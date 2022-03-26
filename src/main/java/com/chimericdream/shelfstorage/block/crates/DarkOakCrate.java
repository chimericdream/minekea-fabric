package com.chimericdream.shelfstorage.block.crates;

import com.chimericdream.shelfstorage.block.crates.entity.DarkOakCrateBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class DarkOakCrate extends GenericCrate {
    DarkOakCrate() {
        super("dark_oak", FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS).strength(3.0F, 4.0F));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DarkOakCrateBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, Crates.DARK_OAK_CRATE_BLOCK_ENTITY, DarkOakCrateBlockEntity::tick);
    }
}
