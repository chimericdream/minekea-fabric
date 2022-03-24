package net.fabricmc.chimericdream.screen.crate;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class BirchCrateScreen extends AbstractCrateScreen<BirchCrateScreenHandler> {
    public BirchCrateScreen(BirchCrateScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
