package com.chimericdream.shelfstorage.screen.crate;

import com.chimericdream.shelfstorage.block.crates.GenericCrate;
import com.chimericdream.shelfstorage.screen.SimpleInventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class CrateScreen extends SimpleInventoryScreen<CrateScreenHandler> {
    public CrateScreen(CrateScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, GenericCrate.ROW_COUNT, inventory, title);
    }
}
