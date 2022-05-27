package com.chimericdream.minekea.entities.blocks;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.bookshelves.Bookshelves;
import com.chimericdream.minekea.block.furniture.bookshelves.GenericStorageBookshelf;
import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreenHandler;
import com.chimericdream.minekea.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ViewerCountManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;

public class StorageBookshelfBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    public static final Identifier ENTITY_ID = new Identifier(ModInfo.MOD_ID, "entities/blocks/storage_bookshelf");

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(GenericStorageBookshelf.ROW_COUNT * 9, ItemStack.EMPTY);
    private final ViewerCountManager stateManager;

    public StorageBookshelfBlockEntity(BlockPos pos, BlockState state) {
        this(Bookshelves.STORAGE_SHELF_BLOCK_ENTITY, pos, state);
    }

    public StorageBookshelfBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);

        this.stateManager = new ViewerCountManager() {
            protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
                StorageBookshelfBlockEntity.this.playSound(state, SoundEvents.ITEM_BOOK_PAGE_TURN);
                StorageBookshelfBlockEntity.this.setOpen(state, true);
            }

            protected void onContainerClose(World world, BlockPos pos, BlockState state) {
                StorageBookshelfBlockEntity.this.playSound(state, SoundEvents.ITEM_BOOK_PUT);
                StorageBookshelfBlockEntity.this.setOpen(state, false);
            }

            protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
            }

            protected boolean isPlayerViewing(PlayerEntity player) {
                if (player.currentScreenHandler instanceof StorageBookshelfScreenHandler) {
                    Inventory inventory = ((StorageBookshelfScreenHandler) player.currentScreenHandler).getInventory();

                    return inventory == StorageBookshelfBlockEntity.this;
                } else {
                    return false;
                }
            }
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new StorageBookshelfScreenHandler(Bookshelves.STORAGE_SHELF_SCREEN_HANDLER, syncId, playerInventory, this);
    }

    public void onOpen(PlayerEntity player) {
        if (!this.removed && !player.isSpectator()) {
            this.stateManager.openContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
        }
    }

    public void onClose(PlayerEntity player) {
        if (!this.removed && !player.isSpectator()) {
            this.stateManager.closeContainer(player, this.getWorld(), this.getPos(), this.getCachedState());
        }
    }

    public static void tick(World world, BlockPos pos, BlockState state, StorageBookshelfBlockEntity entity) {
        if (world.isClient()) {
            return;
        }

        if (!entity.removed) {
            int fillLevel = GenericStorageBookshelf.getFillLevel(entity.getItems().stream().filter(item -> item.getCount() > 0).count());
            if (fillLevel != state.get(GenericStorageBookshelf.FILL_LEVEL)) {
                state = state.with(GenericStorageBookshelf.FILL_LEVEL, fillLevel);
                world.setBlockState(pos, state);
                markDirty(world, pos, state);
            }

            entity.stateManager.updateViewerCount(world, pos, state);
        }
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText("container.minekea.storage_bookshelf");
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);

        Inventories.readNbt(nbt, items);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, items);

        super.writeNbt(nbt);
    }

    void setOpen(BlockState state, boolean open) {
        this.world.setBlockState(this.getPos(), (BlockState) state.with(GenericStorageBookshelf.OPEN, open), 3);
    }

    void playSound(BlockState state, SoundEvent soundEvent) {
        Vec3i vec3i = ((Direction) state.get(GenericStorageBookshelf.FACING)).getVector();

        double d = (double) this.pos.getX() + 0.5 + (double) vec3i.getX() / 2.0;
        double e = (double) this.pos.getY() + 0.5 + (double) vec3i.getY() / 2.0;
        double f = (double) this.pos.getZ() + 0.5 + (double) vec3i.getZ() / 2.0;

        this.world.playSound((PlayerEntity) null, d, e, f, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
    }
}
