package com.chimericdream.shelfstorage.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class DarkOakStorageShelfScreen extends AbstractStorageShelfScreen<DarkOakStorageShelfScreenHandler> {
    public DarkOakStorageShelfScreen(DarkOakStorageShelfScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
