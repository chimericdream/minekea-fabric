package net.fabricmc.chimericdream.screen.crate;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class OakCrateScreen extends AbstractCrateScreen<OakCrateScreenHandler> {
    public OakCrateScreen(OakCrateScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
