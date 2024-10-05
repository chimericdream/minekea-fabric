package com.chimericdream.minekea.screen.crate;

import com.chimericdream.lib.screen.DoubleWideInventoryScreen;
import com.chimericdream.minekea.block.containers.crates.GenericCrate;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class DoubleCrateScreen extends DoubleWideInventoryScreen<DoubleCrateScreenHandler> {
    public DoubleCrateScreen(DoubleCrateScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, GenericCrate.ROW_COUNT, inventory, title);
    }
}
