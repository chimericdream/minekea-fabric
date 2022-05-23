package com.chimericdream.minekea.util;

import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;

public class NbtHelpers {
    public static DefaultedList<ItemStack> getInventory(ItemStack stack, int size) {
        return getInventory(stack.getOrCreateNbt(), size);
    }

    public static DefaultedList<ItemStack> getInventory(NbtCompound nbt, int size) {
        DefaultedList<ItemStack> items = DefaultedList.ofSize(size, ItemStack.EMPTY);
        Inventories.readNbt(nbt, items);

        return items;
    }
}
