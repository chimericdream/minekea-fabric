package com.chimericdream.minekea.tag;

import com.chimericdream.minekea.ModInfo;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class MinekeaTags {
    public static final Tag<Block> BOOKSHELVES;
    public static final Tag<Block> BOOKSHELVES_WITH_STORAGE;
    public static final Tag<Block> CRATES;

    static {
        BOOKSHELVES = TagFactory.BLOCK.create(new Identifier(ModInfo.MOD_ID, "bookshelves"));
        BOOKSHELVES_WITH_STORAGE = TagFactory.BLOCK.create(new Identifier(ModInfo.MOD_ID, "bookshelves_with_storage"));
        CRATES = TagFactory.BLOCK.create(new Identifier(ModInfo.MOD_ID, "crates"));
    }

    public static void init() {
    }
}
