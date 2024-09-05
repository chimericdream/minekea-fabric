//package com.chimericdream.minekea.util;
//
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.inventory.Inventories;
//import net.minecraft.inventory.Inventory;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.collection.DefaultedList;
//
///**
// * A simple {@code Inventory} implementation with only default methods + an item list getter.
// * <p>
// * Originally by Juuz
// */
//public interface ImplementedInventory extends Inventory {
//
//    /**
//     * Retrieves the item list of this inventory.
//     * Must return the same instance every time it's called.
//     */
//    DefaultedList<ItemStack> getItems();
//
//    /**
//     * Creates an inventory from the item list.
//     */
//    static ImplementedInventory of(DefaultedList<ItemStack> items) {
//        return () -> items;
//    }
//
//    /**
//     * Creates a new inventory with the specified size.
//     */
//    static ImplementedInventory ofSize(int size) {
//        return of(DefaultedList.ofSize(size, ItemStack.EMPTY));
//    }
//
//    /**
//     * Returns the inventory size.
//     */
//    @Override
//    default int size() {
//        return getItems().size();
//    }
//
//    default boolean hasContents() {
//        return !isEmpty();
//    }
//
//    /**
//     * Checks if the inventory is empty.
//     *
//     * @return true if this inventory has only empty stacks, false otherwise.
//     */
//    @Override
//    default boolean isEmpty() {
//        for (int i = 0; i < size(); i++) {
//            ItemStack stack = getStack(i);
//            if (!stack.isEmpty()) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    /**
//     * Retrieves the item in the slot.
//     */
//    @Override
//    default ItemStack getStack(int slot) {
//        return getItems().get(slot);
//    }
//
//    /**
//     * Removes items from an inventory slot.
//     *
//     * @param slot  The slot to remove from.
//     * @param count How many items to remove. If there are less items in the slot than what are requested,
//     *              takes all items in that slot.
//     */
//    @Override
//    default ItemStack removeStack(int slot, int count) {
//        ItemStack result = Inventories.splitStack(getItems(), slot, count);
//
//        if (!result.isEmpty()) {
//            markDirty();
//        }
//
//        return result;
//    }
//
//    /**
//     * Removes all items from an inventory slot.
//     *
//     * @param slot The slot to remove from.
//     */
//    @Override
//    default ItemStack removeStack(int slot) {
//        ItemStack items = Inventories.removeStack(getItems(), slot);
//        markDirty();
//
//        return items;
//    }
//
//    default ItemStack removeStack() {
//        return removeStack(0);
//    }
//
//    default boolean isMatchingPartialStack(ItemStack incomingStack, ItemStack existingStack) {
//        if (!existingStack.isStackable()) {
//            return false;
//        }
//
//        if (!ItemStack.areEqual(incomingStack, existingStack)) {
//            return false;
//        }
//
//        return existingStack.getCount() < existingStack.getMaxCount();
//    }
//
//    default ItemStack tryInsert(ItemStack stack) {
//        return tryInsert(0, stack);
//    }
//
//    default ItemStack tryInsert(int slot, ItemStack stack) {
//        ItemStack oldStack = getStack(slot);
//
//        if (oldStack.isEmpty()) {
//            getItems().set(slot, stack);
//
//            markDirty();
//
//            return ItemStack.EMPTY;
//        }
//
//        if (isMatchingPartialStack(stack, oldStack)) {
//            int stackDiff = oldStack.getMaxCount() - oldStack.getCount();
//
//            // The new stack will completely fit into the slot
//            if (stack.getCount() <= stackDiff) {
//                oldStack.setCount(oldStack.getCount() + stack.getCount());
//
//                markDirty();
//
//                return ItemStack.EMPTY;
//            }
//
//            stack.setCount(stack.getCount() - stackDiff);
//            oldStack.setCount(oldStack.getMaxCount());
//        }
//
//        return stack;
//    }
//
//    /**
//     * Replaces the current stack in an inventory slot with the provided stack.
//     *
//     * @param slot  The inventory slot of which to replace the itemstack.
//     * @param stack The replacing itemstack. If the stack is too big for
//     *              this inventory ({@link Inventory#getMaxCountPerStack()}),
//     *              it gets resized to this inventory's maximum amount.
//     */
//    @Override
//    default void setStack(int slot, ItemStack stack) {
//        getItems().set(slot, stack);
//
//        if (stack.getCount() > getMaxCountPerStack()) {
//            stack.setCount(getMaxCountPerStack());
//        }
//
//        markDirty();
//    }
//
//    /**
//     * Clears the inventory.
//     */
//    @Override
//    default void clear() {
//        getItems().clear();
//    }
//
//    /**
//     * Marks the state as dirty.
//     * Must be called after changes in the inventory, so that the game can properly save
//     * the inventory contents and notify neighboring blocks of inventory changes.
//     */
//    @Override
//    default void markDirty() {
//        // Override if you want behavior.
//    }
//
//    /**
//     * @return true if the player can use the inventory, false otherwise.
//     */
//    @Override
//    default boolean canPlayerUse(PlayerEntity player) {
//        return true;
//    }
//}
