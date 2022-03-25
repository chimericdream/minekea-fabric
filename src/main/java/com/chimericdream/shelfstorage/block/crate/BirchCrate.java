package com.chimericdream.shelfstorage.block.crate;

import com.chimericdream.shelfstorage.block.crate.entity.BirchCrateBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class BirchCrate extends GenericCrate {
    BirchCrate() {
        super("birch", FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS).strength(3.0F, 4.0F));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BirchCrateBlockEntity(pos, state);
    }
}
