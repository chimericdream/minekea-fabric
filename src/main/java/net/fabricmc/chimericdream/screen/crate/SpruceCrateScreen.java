package net.fabricmc.chimericdream.screen.crate;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class SpruceCrateScreen extends AbstractCrateScreen<SpruceCrateScreenHandler> {
    public SpruceCrateScreen(SpruceCrateScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
