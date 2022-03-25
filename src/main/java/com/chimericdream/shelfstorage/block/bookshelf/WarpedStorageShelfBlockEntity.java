package com.chimericdream.shelfstorage.block.bookshelf;

import com.chimericdream.shelfstorage.screen.WarpedStorageShelfScreenHandler;
import com.chimericdream.shelfstorage.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static com.chimericdream.shelfstorage.block.bookshelf.AbstractStorageShelf.FILL_LEVEL;

public class WarpedStorageShelfBlockEntity extends BlockEntity implements NamedScreenHandlerFactory, ImplementedInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(9, ItemStack.EMPTY);

    public WarpedStorageShelfBlockEntity(BlockPos pos, BlockState state) {
        super(Bookshelves.WARPED_STORAGE_SHELF_BLOCK_ENTITY, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new WarpedStorageShelfScreenHandler(syncId, playerInventory, this);
    }

    public static void tick(World world, BlockPos pos, BlockState state, WarpedStorageShelfBlockEntity entity) {
        if (world.isClient()) {
            return;
        }

        int fillLevel = AbstractStorageShelf.getFillLevel(entity.getItems().stream().filter(item -> item.getCount() > 0).count());
        if (fillLevel != state.get(FILL_LEVEL)) {
            state = state.with(FILL_LEVEL, fillLevel);
            world.setBlockState(pos, state);
            markDirty(world, pos, state);
        }
    }

    @Override
    public Text getDisplayName() {
        return new TranslatableText(getCachedState().getBlock().getTranslationKey());
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
}
