package net.fabricmc.chimericdream.screen;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class JungleStorageShelfScreen extends AbstractStorageShelfScreen<JungleStorageShelfScreenHandler> {
    public JungleStorageShelfScreen(JungleStorageShelfScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
