package com.chimericdream.minekea.screen.crate;

import com.chimericdream.lib.screen.SimpleInventoryScreen;
import com.chimericdream.minekea.block.containers.crates.GenericCrate;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class CrateScreen extends SimpleInventoryScreen<CrateScreenHandler> {
    public CrateScreen(CrateScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, GenericCrate.ROW_COUNT, inventory, title);
    }
}
