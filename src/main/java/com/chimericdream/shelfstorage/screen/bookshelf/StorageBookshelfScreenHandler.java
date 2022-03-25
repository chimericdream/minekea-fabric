package com.chimericdream.shelfstorage.screen.bookshelf;

import com.chimericdream.shelfstorage.block.bookshelves.storage.GenericStorageBookshelf;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public class StorageBookshelfScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public StorageBookshelfScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(null, syncId, playerInventory, new SimpleInventory(GenericStorageBookshelf.INVENTORY_SIZE));
    }

    public StorageBookshelfScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory) {
        this(type, syncId, playerInventory, new SimpleInventory(GenericStorageBookshelf.INVENTORY_SIZE));
    }

    public StorageBookshelfScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(type, syncId);
        checkSize(inventory, GenericStorageBookshelf.INVENTORY_SIZE);

        this.inventory = inventory;

        inventory.onOpen(playerInventory.player);

        int i = -18, j, k;
        for (k = 0; k < 9; ++k) {
            this.addSlot(new Slot(inventory, k, 8 + k * 18, 18));
        }

        for (j = 0; j < 3; ++j) {
            for (k = 0; k < 9; ++k) {
                this.addSlot(new Slot(playerInventory, k + j * 9 + 9, 8 + k * 18, 67 + j * 18 + i));
            }
        }

        for (j = 0; j < 9; ++j) {
            this.addSlot(new Slot(playerInventory, j, 8 + j * 18, 125 + i));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;

        Slot slot = this.slots.get(invSlot);

        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }
}
