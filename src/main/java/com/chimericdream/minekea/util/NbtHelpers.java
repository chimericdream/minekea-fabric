package com.chimericdream.minekea.util;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;

public class NbtHelpers {
    public static void setCustomDataFromNbt(ItemStack itemStack, NbtCompound nbt) {
        itemStack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
    }

    public static NbtCompound getOrCreateNbt(ItemStack stack) {
        NbtComponent component = stack.get(DataComponentTypes.CUSTOM_DATA);
        NbtCompound nbt = component != null ? component.copyNbt() : new NbtCompound();

        return nbt;
    }

    public static DefaultedList<ItemStack> getInventory(ItemStack stack, int size, RegistryWrapper.WrapperLookup registries) {
        return getInventory(getOrCreateNbt(stack), size, registries);
    }

    public static DefaultedList<ItemStack> getInventory(NbtCompound nbt, int size, RegistryWrapper.WrapperLookup registries) {
        DefaultedList<ItemStack> items = DefaultedList.ofSize(size, ItemStack.EMPTY);
        Inventories.readNbt(nbt, items, registries);

        return items;
    }
}
