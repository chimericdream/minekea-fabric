package com.chimericdream.shelfstorage.block.secretdoor;

import net.minecraft.block.DoorBlock;

public abstract class PublicDoorBlock extends DoorBlock {
    public PublicDoorBlock(Settings settings) {
        super(settings);
    }

    abstract public void register();
}
