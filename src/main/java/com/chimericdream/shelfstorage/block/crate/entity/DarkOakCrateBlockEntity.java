package com.chimericdream.shelfstorage.block.crate.entity;

import com.chimericdream.shelfstorage.block.crate.Crates;
import com.chimericdream.shelfstorage.screen.crate.CrateScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public class DarkOakCrateBlockEntity extends GenericCrateBlockEntity {
    public DarkOakCrateBlockEntity(BlockPos pos, BlockState state) {
        super(Crates.DARK_OAK_CRATE_BLOCK_ENTITY, pos, state);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        // We provide *this* to the screenHandler as our class Implements Inventory
        // Only the Server has the Inventory at the start, this will be synced to the client in the ScreenHandler
        return new CrateScreenHandler(Crates.DARK_OAK_CRATE_SCREEN_HANDLER, syncId, playerInventory, this);
    }
}