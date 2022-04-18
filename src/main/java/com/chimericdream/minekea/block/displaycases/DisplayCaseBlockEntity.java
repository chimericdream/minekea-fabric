package com.chimericdream.minekea.block.displaycases;

import com.chimericdream.minekea.util.ImplementedInventory;
import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class DisplayCaseBlockEntity extends BlockEntity implements BlockEntityClientSerializable, ImplementedInventory, SidedInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public DisplayCaseBlockEntity(BlockPos pos, BlockState state) {
        this(DisplayCases.DISPLAY_CASE_BLOCK_ENTITY, pos, state);
    }

    public DisplayCaseBlockEntity(BlockEntityType<? extends DisplayCaseBlockEntity> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
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
        return new int[]{};
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction direction) {
        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction direction) {
        return false;
    }

    public void playRemoveItemSound() {
        playSound(SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM);
    }

    public void playRotateItemSound() {
        playSound(SoundEvents.ENTITY_ITEM_FRAME_ROTATE_ITEM);
    }

    public void playAddItemSound() {
        playSound(SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM);
    }

    public void playSound(SoundEvent soundEvent) {
        this.world.playSound((PlayerEntity) null, pos.getX(), pos.getY(), pos.getZ(), soundEvent, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }
}
