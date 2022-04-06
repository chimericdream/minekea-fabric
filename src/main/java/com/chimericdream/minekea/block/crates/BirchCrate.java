package com.chimericdream.minekea.block.crates;

import com.chimericdream.minekea.block.crates.entity.BirchCrateBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BirchCrate extends GenericCrate {
    BirchCrate() {
        super("birch", FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS).strength(3.0F, 4.0F));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BirchCrateBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, Crates.BIRCH_CRATE_BLOCK_ENTITY, BirchCrateBlockEntity::tick);
    }

    @Override
    protected String[] getMaterials() {
        return new String[]{"minecraft:birch_planks", "minecraft:birch_log"};
    }
}
