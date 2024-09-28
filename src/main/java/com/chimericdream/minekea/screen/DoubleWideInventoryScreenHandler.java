package com.chimericdream.minekea.screen;

import com.chimericdream.minekea.util.ScreenHelpers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public class DoubleWideInventoryScreenHandler extends ScreenHandler {
    private final Inventory inventory;

    public DoubleWideInventoryScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, int rowCount) {
        this(type, syncId, playerInventory, new SimpleInventory(ScreenHelpers.getDoubleWideInventorySize(rowCount)), rowCount);
    }

    public DoubleWideInventoryScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, Inventory inventory, int rowCount) {
        super(type, syncId);

        checkSize(inventory, ScreenHelpers.getDoubleWideInventorySize(rowCount));

        this.inventory = inventory;

        inventory.onOpen(playerInventory.player);

        int i = (rowCount - 4) * 18, j, k;
        for (j = 0; j < rowCount; ++j) {
            for (k = 0; k < 18; ++k) {
                this.addSlot(new Slot(
                    inventory,
                    k + j * 18,
                    8 + k * ScreenHelpers.ROW_HEIGHT,
                    ScreenHelpers.ROW_HEIGHT + j * ScreenHelpers.ROW_HEIGHT
                ));
            }
        }

        for (j = 0; j < 3; ++j) {
            for (k = 0; k < 9; ++k) {
                this.addSlot(new Slot(
                    playerInventory,
                    k + j * 9 + 9,
                    89 + k * ScreenHelpers.ROW_HEIGHT,
                    104 + j * ScreenHelpers.ROW_HEIGHT + i
                ));
            }
        }

        for (j = 0; j < 9; ++j) {
            this.addSlot(new Slot(
                playerInventory,
                j,
                89 + j * ScreenHelpers.ROW_HEIGHT,
                162 + i
            ));
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
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
