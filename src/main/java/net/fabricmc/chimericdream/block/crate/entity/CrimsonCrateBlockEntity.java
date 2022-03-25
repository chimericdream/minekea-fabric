package net.fabricmc.chimericdream.block.crate.entity;

import net.fabricmc.chimericdream.block.crate.Crates;
import net.fabricmc.chimericdream.screen.crate.CrateScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public class CrimsonCrateBlockEntity extends GenericCrateBlockEntity {
    public CrimsonCrateBlockEntity(BlockPos pos, BlockState state) {
        super(pos, state, "crimson");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        // We provide *this* to the screenHandler as our class Implements Inventory
        // Only the Server has the Inventory at the start, this will be synced to the client in the ScreenHandler
        return new CrateScreenHandler(Crates.ACACIA_CRATE_SCREEN_HANDLER, syncId, playerInventory, this);
    }
}
