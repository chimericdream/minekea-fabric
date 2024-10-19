package com.chimericdream.minekea.util;

import com.chimericdream.minekea.tag.MinekeaBlockTags;
import net.minecraft.block.Block;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

public enum Tool {
    AXE,
    HOE,
    PICKAXE,
    SHEARS,
    SHOVEL,
    NONE;

    public TagKey<Block> getMineableTag() {
        return switch (this) {
            case AXE -> BlockTags.AXE_MINEABLE;
            case HOE -> BlockTags.HOE_MINEABLE;
            case PICKAXE -> BlockTags.PICKAXE_MINEABLE;
            case SHEARS -> MinekeaBlockTags.MINEABLE_SHEARS;
            case SHOVEL -> BlockTags.SHOVEL_MINEABLE;
            default -> null;
        };
    }
}
