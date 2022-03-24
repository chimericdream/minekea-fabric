package net.fabricmc.chimericdream.screen.crate;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class CrimsonCrateScreen extends AbstractCrateScreen<CrimsonCrateScreenHandler> {
    public CrimsonCrateScreen(CrimsonCrateScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
