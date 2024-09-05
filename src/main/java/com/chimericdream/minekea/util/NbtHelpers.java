//package com.chimericdream.minekea.util;
//
//import net.minecraft.inventory.Inventories;
//import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NbtCompound;
//import net.minecraft.registry.RegistryWrapper;
//import net.minecraft.util.collection.DefaultedList;
//
//public class NbtHelpers {
//    public static DefaultedList<ItemStack> getInventory(ItemStack stack, int size, RegistryWrapper.WrapperLookup registries) {
//        return getInventory(stack.getOrCreateNbt(), size, registries);
//    }
//
//    public static DefaultedList<ItemStack> getInventory(NbtCompound nbt, int size, RegistryWrapper.WrapperLookup registries) {
//        DefaultedList<ItemStack> items = DefaultedList.ofSize(size, ItemStack.EMPTY);
//        Inventories.readNbt(nbt, items, registries);
//
//        return items;
//    }
//}
