package com.chimericdream.shelfstorage.block.crates;

import com.chimericdream.shelfstorage.block.crates.entity.CrimsonCrateBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class CrimsonCrate extends GenericCrate {
    CrimsonCrate() {
        super("crimson", FabricBlockSettings.copyOf(Blocks.CRIMSON_PLANKS).strength(3.0F, 4.0F));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CrimsonCrateBlockEntity(pos, state);
    }
}
