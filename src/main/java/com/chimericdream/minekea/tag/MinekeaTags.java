package com.chimericdream.minekea.tag;

import com.chimericdream.minekea.ModInfo;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class MinekeaTags {
    public static final Tag<Block> BOOKSHELVES;
    public static final Tag<Item> GLASS_JAR_STORABLE;

    static {
        BOOKSHELVES = TagFactory.BLOCK.create(new Identifier(ModInfo.MOD_ID, "bookshelves"));
        GLASS_JAR_STORABLE = TagFactory.ITEM.create(new Identifier(ModInfo.MOD_ID, "glass_jar_storable"));
    }

    public void init() {
    }
}
