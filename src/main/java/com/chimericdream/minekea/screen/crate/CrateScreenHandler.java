package com.chimericdream.minekea.screen.crate;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.containers.crates.GenericCrate;
import com.chimericdream.minekea.screen.SimpleInventoryScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class CrateScreenHandler extends SimpleInventoryScreenHandler {
    public static final Identifier SCREEN_ID = Identifier.of(ModInfo.MOD_ID, "screens/container/crate");

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
