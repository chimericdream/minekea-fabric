package net.fabricmc.chimericdream.screen.crate;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class WarpedCrateScreen extends AbstractCrateScreen<WarpedCrateScreenHandler> {
    public WarpedCrateScreen(WarpedCrateScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
