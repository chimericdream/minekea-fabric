package com.chimericdream.minekea.tag;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class MinecraftBlockTags {
    public static final TagKey<Block> MINEABLE_AXE = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("mineable/axe"));
    public static final TagKey<Block> MINEABLE_HOE = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("mineable/hoe"));
    public static final TagKey<Block> MINEABLE_PICKAXE = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("mineable/pickaxe"));
    public static final TagKey<Block> MINEABLE_SHOVEL = TagKey.of(Registries.BLOCK.getKey(), Identifier.of("mineable/shovel"));
}
