package com.chimericdream.minekea.screen.crate;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.containers.crates.GenericCrate;
import com.chimericdream.minekea.screen.DoubleWideInventoryScreenHandler;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class DoubleCrateScreenHandler extends DoubleWideInventoryScreenHandler {
    public static final Identifier SCREEN_ID = Identifier.of(ModInfo.MOD_ID, "screens/container/double_crate");
    public static final Identifier TRAPPED_SCREEN_ID = Identifier.of(ModInfo.MOD_ID, "screens/container/double_crate/trapped");

    public DoubleCrateScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(null, syncId, playerInventory, GenericCrate.ROW_COUNT);
    }

    public DoubleCrateScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory) {
        super(type, syncId, playerInventory, GenericCrate.ROW_COUNT);
    }

    public DoubleCrateScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(null, syncId, playerInventory, inventory, GenericCrate.ROW_COUNT);
    }

    public DoubleCrateScreenHandler(ScreenHandlerType<?> type, int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(type, syncId, playerInventory, inventory, GenericCrate.ROW_COUNT);
    }
}
