package com.chimericdream.shelfstorage.block.crates.entity;

import com.chimericdream.shelfstorage.block.crates.Crates;
import com.chimericdream.shelfstorage.screen.crate.CrateScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public class SpruceCrateBlockEntity extends GenericCrateBlockEntity {
    public SpruceCrateBlockEntity(BlockPos pos, BlockState state) {
        super(Crates.SPRUCE_CRATE_BLOCK_ENTITY, pos, state);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new CrateScreenHandler(Crates.SPRUCE_CRATE_SCREEN_HANDLER, syncId, playerInventory, this);
    }
}
