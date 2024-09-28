package com.chimericdream.minekea.screen.crate;

import com.chimericdream.minekea.block.containers.crates.GenericCrate;
import com.chimericdream.minekea.screen.DoubleWideInventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class DoubleCrateScreen extends DoubleWideInventoryScreen<DoubleCrateScreenHandler> {
    public DoubleCrateScreen(DoubleCrateScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, GenericCrate.ROW_COUNT, inventory, title);
    }
}
