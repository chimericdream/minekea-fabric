package com.chimericdream.shelfstorage.block.trapdoors;

import net.minecraft.block.TrapdoorBlock;

public abstract class PublicTrapdoorBlock extends TrapdoorBlock {
    public PublicTrapdoorBlock(Settings settings) {
        super(settings);
    }

    abstract public void register();
}
