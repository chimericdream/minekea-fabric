package com.chimericdream.minekea.block.displaycases.entity;

import com.chimericdream.minekea.util.ImplementedInventory;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class GenericDisplayCaseBlockEntity extends BlockEntity implements BlockEntityClientSerializable, ImplementedInventory, SidedInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, Blocks.BARRIER.asItem().getDefaultStack());

    public GenericDisplayCaseBlockEntity(BlockPos pos, BlockState state) {
        this(null, pos, state);
    }

    public GenericDisplayCaseBlockEntity(BlockEntityType<? extends GenericDisplayCaseBlockEntity> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    public static NbtCompound getNbt(BlockEntity entity) {
        NbtCompound nbt = new NbtCompound();
        Inventories.writeNbt(nbt, ((GenericDisplayCaseBlockEntity) entity).items);

        return nbt;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }

    @Override
    public NbtCompound writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, items);
        super.writeNbt(nbt);

        return nbt;
    }

    @Override
    public void fromClientTag(NbtCompound tag) {
        readNbt(tag);
    }

    @Override
    public NbtCompound toClientTag(NbtCompound tag) {
        return writeNbt(tag);
    }

    @Override
    public int[] getAvailableSlots(Direction var1) {
        int[] result = new int[getItems().size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction direction) {
        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction direction) {
        return true;
    }
}
