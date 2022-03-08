package net.fabricmc.chimericdream.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class AcaciaStorageShelfScreen extends AbstractStorageShelfScreen<AcaciaStorageShelfScreenHandler> {
    public AcaciaStorageShelfScreen(AcaciaStorageShelfScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
