package com.chimericdream.minekea.tag;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MinekeaTags {
    public static final TagKey<Block> BOOKSHELVES;
    public static final TagKey<Item> GLASS_JAR_STORABLE;

    static {
        BOOKSHELVES = TagKey.of(Registry.BLOCK_KEY, new Identifier(ModInfo.MOD_ID, "bookshelves"));
        GLASS_JAR_STORABLE = TagKey.of(Registry.ITEM_KEY, new Identifier(ModInfo.MOD_ID, "glass_jar_storable"));
    }

    public void init() {
    }
}
