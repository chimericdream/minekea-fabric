package com.chimericdream.minekea.block.crates;

import com.chimericdream.minekea.block.crates.entity.WarpedCrateBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WarpedCrate extends GenericCrate {
    WarpedCrate() {
        super("warped", FabricBlockSettings.copyOf(Blocks.WARPED_PLANKS).strength(3.0F, 4.0F));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WarpedCrateBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, Crates.WARPED_CRATE_BLOCK_ENTITY, WarpedCrateBlockEntity::tick);
    }

    @Override
    protected String[] getMaterials() {
        return new String[]{"minecraft:warped_planks", "minecraft:warped_stem"};
    }
}
