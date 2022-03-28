package com.chimericdream.minekea.screen.crate;

import com.chimericdream.minekea.block.crates.GenericCrate;
import com.chimericdream.minekea.screen.SimpleInventoryScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandlerType;

public class CrateScreenHandler extends SimpleInventoryScreenHandler {
    public CrateScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(null, syncId, playerInventory, GenericCrate.ROW_COUNT);
    }

    public CrateScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory) {
        super(type, syncId, playerInventory, GenericCrate.ROW_COUNT);
    }

    public CrateScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(type, syncId, playerInventory, inventory, GenericCrate.ROW_COUNT);
    }
}
