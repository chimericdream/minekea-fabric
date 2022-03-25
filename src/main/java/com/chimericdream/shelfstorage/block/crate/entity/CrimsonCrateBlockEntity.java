package com.chimericdream.shelfstorage.block.crate.entity;

import com.chimericdream.shelfstorage.block.crate.Crates;
import com.chimericdream.shelfstorage.screen.crate.CrateScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public class CrimsonCrateBlockEntity extends GenericCrateBlockEntity {
    public CrimsonCrateBlockEntity(BlockPos pos, BlockState state) {
        super(Crates.CRIMSON_CRATE_BLOCK_ENTITY, pos, state);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CrateScreenHandler(Crates.CRIMSON_CRATE_SCREEN_HANDLER, syncId, playerInventory, this);
    }
}
