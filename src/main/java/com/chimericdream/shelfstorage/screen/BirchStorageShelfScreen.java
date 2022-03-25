package com.chimericdream.shelfstorage.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class BirchStorageShelfScreen extends AbstractStorageShelfScreen<BirchStorageShelfScreenHandler> {
    public BirchStorageShelfScreen(BirchStorageShelfScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
