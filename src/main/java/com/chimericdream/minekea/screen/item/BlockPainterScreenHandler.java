package com.chimericdream.minekea.screen.item;

import com.chimericdream.minekea.item.ModItems;
import com.chimericdream.minekea.item.tools.PainterItem;
import com.chimericdream.minekea.util.ScreenHelpers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class BlockPainterScreenHandler extends ScreenHandler {
    private final PainterItem.PainterInventory painter;
    private final int ROW_COUNT = 2;

    public BlockPainterScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new ItemStack(ModItems.PAINTER_ITEM));
    }

    public BlockPainterScreenHandler(int syncId, PlayerInventory playerInventory, ItemStack stack) {
        super(ModItems.BLOCK_PAINTER_SCREEN_HANDLER, syncId);

        painter = new PainterItem.PainterInventory(stack);

        int i = -18, j, k;
        for (j = 0; j < ROW_COUNT; ++j) {
            for (k = 0; k < 8; ++k) {
                this.addSlot(new PainterSlot(
                    painter,
                    k + j * 8,
                    17 + k * ScreenHelpers.ROW_HEIGHT,
                    ScreenHelpers.ROW_HEIGHT + j * ScreenHelpers.ROW_HEIGHT
                ));
            }
        }

        for (j = 0; j < 3; ++j) {
            for (k = 0; k < 9; ++k) {
                this.addSlot(new Slot(
                    playerInventory,
                    k + j * 9 + 9,
                    8 + k * ScreenHelpers.ROW_HEIGHT,
                    ScreenHelpers.getPlayerInventoryOffset(ROW_COUNT) + j * ScreenHelpers.ROW_HEIGHT + i
                ));
            }
        }

        for (j = 0; j < 9; ++j) {
            this.addSlot(new Slot(
                playerInventory,
                j,
                8 + j * ScreenHelpers.ROW_HEIGHT,
                ScreenHelpers.getPlayerHotbarOffset(ROW_COUNT) + i
            ));
        }
    }

    public Inventory getInventory() {
        return painter;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.painter.canPlayerUse(player);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;

        Slot slot = this.slots.get(invSlot);

        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.painter.size()) {
                if (!this.insertItem(originalStack, this.painter.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.painter.size(), false)) {
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

    private class PainterSlot extends Slot {
        public PainterSlot(Inventory inventory, int index, int x, int y) {
            super(inventory, index, x, y);
        }

        @Override
        public boolean canInsert(ItemStack stack) {
            return doesItemMatchSlot(stack);
        }

        private boolean doesItemMatchSlot(ItemStack item) {
            return switch (this.getIndex()) {
                case 0 -> item.isOf(Items.WHITE_DYE);
                case 1 -> item.isOf(Items.LIGHT_GRAY_DYE);
                case 2 -> item.isOf(Items.GRAY_DYE);
                case 3 -> item.isOf(Items.BLACK_DYE);
                case 4 -> item.isOf(Items.BROWN_DYE);
                case 5 -> item.isOf(Items.RED_DYE);
                case 6 -> item.isOf(Items.ORANGE_DYE);
                case 7 -> item.isOf(Items.YELLOW_DYE);
                case 8 -> item.isOf(Items.LIME_DYE);
                case 9 -> item.isOf(Items.GREEN_DYE);
                case 10 -> item.isOf(Items.CYAN_DYE);
                case 11 -> item.isOf(Items.LIGHT_BLUE_DYE);
                case 12 -> item.isOf(Items.BLUE_DYE);
                case 13 -> item.isOf(Items.PURPLE_DYE);
                case 14 -> item.isOf(Items.MAGENTA_DYE);
                case 15 -> item.isOf(Items.PINK_DYE);
                default -> false;
            };
        }
    }
}
