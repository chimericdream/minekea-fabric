package com.chimericdream.shelfstorage.block.crate;

import com.chimericdream.shelfstorage.block.crate.entity.AcaciaCrateBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class AcaciaCrate extends GenericCrate {
    AcaciaCrate() {
        super("acacia", FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS).strength(3.0F, 4.0F));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AcaciaCrateBlockEntity(pos, state);
    }
}
