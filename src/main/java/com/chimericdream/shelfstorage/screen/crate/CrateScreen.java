package com.chimericdream.shelfstorage.screen.crate;

import com.chimericdream.shelfstorage.screen.SimpleInventoryScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;

public class CrateScreen extends SimpleInventoryScreen<CrateScreenHandler> {
    public CrateScreen(CrateScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, 6, inventory, title);
    }
}
