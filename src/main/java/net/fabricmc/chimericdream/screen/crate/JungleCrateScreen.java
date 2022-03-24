package net.fabricmc.chimericdream.screen.crate;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class JungleCrateScreen extends AbstractCrateScreen<JungleCrateScreenHandler> {
    public JungleCrateScreen(JungleCrateScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }
}
