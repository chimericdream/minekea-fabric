package com.chimericdream.minekea.screen.item;

import com.chimericdream.minekea.item.PainterItem;
import com.chimericdream.minekea.util.ScreenHelpers;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class BlockPainterScreenHandler extends ScreenHandler {
    private final PainterItem.PainterInventory painter;
    private final int ROW_COUNT = 2;

    public BlockPainterScreenHandler(int syncId, PlayerInventory playerInventory, PacketByteBuf packetByteBuf) {
        this(syncId, playerInventory, packetByteBuf.readItemStack());
    }

    public BlockPainterScreenHandler(int syncId, PlayerInventory playerInventory, ItemStack stack) {
        super(com.chimericdream.minekea.item.Items.BLOCK_PAINTER_SCREEN_HANDLER, syncId);

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
    public ItemStack transferSlot(PlayerEntity player, int invSlot) {
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
                case 0 -> item.isItemEqual(Items.WHITE_DYE.getDefaultStack());
                case 1 -> item.isItemEqual(Items.ORANGE_DYE.getDefaultStack());
                case 2 -> item.isItemEqual(Items.MAGENTA_DYE.getDefaultStack());
                case 3 -> item.isItemEqual(Items.LIGHT_BLUE_DYE.getDefaultStack());
                case 4 -> item.isItemEqual(Items.YELLOW_DYE.getDefaultStack());
                case 5 -> item.isItemEqual(Items.LIME_DYE.getDefaultStack());
                case 6 -> item.isItemEqual(Items.PINK_DYE.getDefaultStack());
                case 7 -> item.isItemEqual(Items.GRAY_DYE.getDefaultStack());
                case 8 -> item.isItemEqual(Items.LIGHT_GRAY_DYE.getDefaultStack());
                case 9 -> item.isItemEqual(Items.CYAN_DYE.getDefaultStack());
                case 10 -> item.isItemEqual(Items.PURPLE_DYE.getDefaultStack());
                case 11 -> item.isItemEqual(Items.BLUE_DYE.getDefaultStack());
                case 12 -> item.isItemEqual(Items.BROWN_DYE.getDefaultStack());
                case 13 -> item.isItemEqual(Items.GREEN_DYE.getDefaultStack());
                case 14 -> item.isItemEqual(Items.RED_DYE.getDefaultStack());
                case 15 -> item.isItemEqual(Items.BLACK_DYE.getDefaultStack());
                default -> false;
            };
        }
    }
}
