package net.fabricmc.chimericdream.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class OakStorageShelfScreen extends AbstractStorageShelfScreen<OakStorageShelfScreenHandler> {
    public OakStorageShelfScreen(OakStorageShelfScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
