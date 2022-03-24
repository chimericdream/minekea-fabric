package net.fabricmc.chimericdream.screen.crate;

import net.fabricmc.chimericdream.block.crate.AbstractCrate;
import net.fabricmc.chimericdream.block.crate.Crates;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;

public class AcaciaCrateScreenHandler extends AbstractCrateScreenHandler {
    // This constructor gets called on the client when the server wants it to open the screenHandler,
    // The client will call the other constructor with an empty Inventory and the screenHandler will automatically
    // sync this empty inventory with the inventory on the server.
    public AcaciaCrateScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(AbstractCrate.INVENTORY_SIZE));
    }

    // This constructor gets called from the BlockEntity on the server without calling the other constructor first, the server knows the inventory of the container
    // and can therefore directly provide it as an argument. This inventory will then be synced to the client.
    public AcaciaCrateScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(Crates.ACACIA_CRATE_SCREEN_HANDLER, syncId);
        this.init(playerInventory, inventory);
    }
}
