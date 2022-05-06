package com.chimericdream.minekea.tag;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class CommonBlockTags {
    public static final Tag<Block> BOOKSHELVES = TagFactory.BLOCK.create(new Identifier("c", "bookshelves"));

    public void init() {
    }
}
