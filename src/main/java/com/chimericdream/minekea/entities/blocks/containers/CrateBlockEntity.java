package com.chimericdream.minekea.entities.blocks.containers;

import com.chimericdream.lib.inventories.ImplementedInventory;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.containers.crates.Crates;
import com.chimericdream.minekea.block.containers.crates.GenericCrate;
import com.chimericdream.minekea.screen.crate.CrateScreenHandler;
import net.minecraft.block.Block;
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
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class CrateBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    public static final Identifier ENTITY_ID = Identifier.of(ModInfo.MOD_ID, "entities/blocks/containers/crate");

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(GenericCrate.ROW_COUNT * 9, ItemStack.EMPTY);
    private final ViewerCountManager stateManager;
    private final boolean isTrapped;

    public CrateBlockEntity(BlockPos pos, BlockState state) {
        this(Crates.CRATE_BLOCK_ENTITY, pos, state, false);
    }

    public CrateBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        this(type, pos, state, false);
    }

    public CrateBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state, boolean isTrapped) {
        super(type, pos, state);

        this.isTrapped = isTrapped;

        this.stateManager = new ViewerCountManager() {
            protected void onContainerOpen(World world, BlockPos pos, BlockState state) {
                CrateBlockEntity.this.playSound(state, SoundEvents.BLOCK_BARREL_OPEN);
                CrateBlockEntity.this.setOpen(state, true);
            }

            protected void onContainerClose(World world, BlockPos pos, BlockState state) {
                CrateBlockEntity.this.playSound(state, SoundEvents.BLOCK_BARREL_CLOSE);
                CrateBlockEntity.this.setOpen(state, false);
            }

            protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
                CrateBlockEntity.this.onViewerCountUpdate(world, pos, state, oldViewerCount, newViewerCount);
            }

            protected boolean isPlayerViewing(PlayerEntity player) {
                if (player.currentScreenHandler instanceof CrateScreenHandler) {
                    Inventory inventory = ((CrateScreenHandler) player.currentScreenHandler).getInventory();

                    return inventory == CrateBlockEntity.this;
                } else {
                    return false;
                }
            }
        };
    }

    public boolean isTrapped() {
        return isTrapped;
    }

    public static int getPlayersLookingInCrateCount(BlockView world, BlockPos pos) {
        BlockState blockState = world.getBlockState(pos);
        if (blockState.hasBlockEntity()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CrateBlockEntity) {
                return ((CrateBlockEntity) blockEntity).stateManager.getViewerCount();
            }
        }

        return 0;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CrateScreenHandler(Crates.CRATE_SCREEN_HANDLER, syncId, playerInventory, this);
    }

    @Override
    public Text getDisplayName() {
        if (this.isTrapped) {
            return Text.translatable(CrateScreenHandler.TRAPPED_SCREEN_ID.toString());
        }

        return Text.translatable(CrateScreenHandler.SCREEN_ID.toString());
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);

        Inventories.readNbt(nbt, items, registryLookup);
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.writeNbt(nbt, items, registryLookup);

        super.writeNbt(nbt, registryLookup);
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

    public static void tick(World world, BlockPos pos, BlockState state, CrateBlockEntity entity) {
        if (!entity.removed) {
            entity.stateManager.updateViewerCount(world, pos, state);
        }
    }

    void setOpen(BlockState state, boolean open) {
        if (this.world == null) {
            return;
        }

        this.world.setBlockState(this.getPos(), state.with(GenericCrate.OPEN, open), 3);
    }

    void playSound(BlockState state, SoundEvent soundEvent) {
        if (this.world == null) {
            return;
        }

        Direction.Axis axis = state.get(GenericCrate.AXIS);

        Vec3i vec3i;
        if (axis.isVertical()) {
            vec3i = Direction.UP.getVector();
        } else if (axis.test(Direction.NORTH)) {
            vec3i = Direction.NORTH.getVector();
        } else {
            vec3i = Direction.EAST.getVector();
        }

        double d = (double) this.pos.getX() + 0.5 + (double) vec3i.getX() / 2.0;
        double e = (double) this.pos.getY() + 0.5 + (double) vec3i.getY() / 2.0;
        double f = (double) this.pos.getZ() + 0.5 + (double) vec3i.getZ() / 2.0;

        this.world.playSound(null, d, e, f, soundEvent, SoundCategory.BLOCKS, 0.5F, this.world.random.nextFloat() * 0.1F + 0.5F);
    }

    protected void onViewerCountUpdate(World world, BlockPos pos, BlockState state, int oldViewerCount, int newViewerCount) {
        Block block = state.getBlock();
        world.addSyncedBlockEvent(pos, block, 1, newViewerCount);

        if (isTrapped && oldViewerCount != newViewerCount) {
            world.updateNeighborsAlways(pos, block);
            world.updateNeighborsAlways(pos.down(), block);
        }
    }
}
