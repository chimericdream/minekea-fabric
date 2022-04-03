package com.chimericdream.minekea.block.displaycases.entity;

import com.chimericdream.minekea.block.displaycases.DisplayCases;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class OakDisplayCaseBlockEntity extends GenericDisplayCaseBlockEntity {
    public OakDisplayCaseBlockEntity(BlockPos pos, BlockState state) {
        super(DisplayCases.OAK_DISPLAY_CASE_BLOCK_ENTITY, pos, state);
    }
}
