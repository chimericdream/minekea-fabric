package com.chimericdream.minekea.screen.bookshelf;

import com.chimericdream.minekea.block.furniture.bookshelves.GenericStorageBookshelf;
import com.chimericdream.minekea.screen.SimpleInventoryScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandlerType;

public class StorageBookshelfScreenHandler extends SimpleInventoryScreenHandler {
    public StorageBookshelfScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(null, syncId, playerInventory, GenericStorageBookshelf.ROW_COUNT);
    }

    public StorageBookshelfScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory) {
        super(type, syncId, playerInventory, GenericStorageBookshelf.ROW_COUNT);
    }

    public StorageBookshelfScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(type, syncId, playerInventory, inventory, GenericStorageBookshelf.ROW_COUNT);
    }
}
