package com.chimericdream.shelfstorage.block.crates;

import com.chimericdream.shelfstorage.block.crates.entity.JungleCrateBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class JungleCrate extends GenericCrate {
    JungleCrate() {
        super("jungle", FabricBlockSettings.copyOf(Blocks.JUNGLE_PLANKS).strength(3.0F, 4.0F));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new JungleCrateBlockEntity(pos, state);
    }
}
