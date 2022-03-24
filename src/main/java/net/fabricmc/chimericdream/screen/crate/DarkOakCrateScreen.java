package net.fabricmc.chimericdream.screen.crate;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class DarkOakCrateScreen extends AbstractCrateScreen<DarkOakCrateScreenHandler> {
    public DarkOakCrateScreen(DarkOakCrateScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
