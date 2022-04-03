package com.chimericdream.minekea.block.displaycases.entity;

import com.chimericdream.minekea.block.displaycases.DisplayCases;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class JungleDisplayCaseBlockEntity extends GenericDisplayCaseBlockEntity {
    public JungleDisplayCaseBlockEntity(BlockPos pos, BlockState state) {
        super(DisplayCases.JUNGLE_DISPLAY_CASE_BLOCK_ENTITY, pos, state);
    }
}
