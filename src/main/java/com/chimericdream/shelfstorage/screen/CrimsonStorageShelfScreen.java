package com.chimericdream.shelfstorage.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class CrimsonStorageShelfScreen extends AbstractStorageShelfScreen<CrimsonStorageShelfScreenHandler> {
    public CrimsonStorageShelfScreen(CrimsonStorageShelfScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
