package net.fabricmc.chimericdream.block.crate;

import net.fabricmc.chimericdream.block.crate.entity.AcaciaCrateBlockEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class OakCrate extends GenericCrate {
    OakCrate() {
        super("oak");
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AcaciaCrateBlockEntity(pos, state);
    }
}
