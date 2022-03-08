package net.fabricmc.chimericdream.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class SpruceStorageShelfScreen extends AbstractStorageShelfScreen<SpruceStorageShelfScreenHandler> {
    public SpruceStorageShelfScreen(SpruceStorageShelfScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
