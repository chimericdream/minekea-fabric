package com.chimericdream.minekea.resource;

import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class TextureUtils {
    public static Identifier block(Block block) {
        return TextureUtils.block(Registries.BLOCK.getId(block));
    }

    public static Identifier block(Block block, String suffix) {
        return TextureUtils.block(Registries.BLOCK.getId(block), suffix);
    }

    public static Identifier block(Identifier id) {
        return id.withPrefixedPath("block/");
    }

    public static Identifier block(Identifier id, String suffix) {
        return id.withPrefixedPath("block/").withSuffixedPath(suffix);
    }
}
