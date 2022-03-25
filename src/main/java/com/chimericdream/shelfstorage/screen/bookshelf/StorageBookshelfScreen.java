package com.chimericdream.shelfstorage.screen.bookshelf;

import com.chimericdream.shelfstorage.screen.SimpleInventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class StorageBookshelfScreen extends SimpleInventoryScreen<StorageBookshelfScreenHandler> {
    public StorageBookshelfScreen(StorageBookshelfScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, 1, inventory, title);
    }
}
