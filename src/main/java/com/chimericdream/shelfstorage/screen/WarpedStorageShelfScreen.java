package com.chimericdream.shelfstorage.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class WarpedStorageShelfScreen extends AbstractStorageShelfScreen<WarpedStorageShelfScreenHandler> {
    public WarpedStorageShelfScreen(WarpedStorageShelfScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
