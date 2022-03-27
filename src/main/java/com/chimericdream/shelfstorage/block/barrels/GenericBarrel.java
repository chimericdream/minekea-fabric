package com.chimericdream.shelfstorage.block.barrels;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BarrelBlock;
import net.minecraft.block.Blocks;
import net.minecraft.sound.BlockSoundGroup;

public abstract class GenericBarrel extends BarrelBlock {
    public GenericBarrel() {
        super(FabricBlockSettings.copyOf(Blocks.BARREL).sounds(BlockSoundGroup.WOOD));
    }

    abstract public void register();
}
