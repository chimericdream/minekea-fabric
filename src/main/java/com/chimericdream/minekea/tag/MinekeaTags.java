package com.chimericdream.minekea.tag;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class MinekeaTags {
    public static final TagKey<Block> BOOKSHELVES = TagKey.of(Registries.BLOCK.getKey(), Identifier.of(ModInfo.MOD_ID, "bookshelves"));
    public static final TagKey<Block> DISPLAY_CASES = TagKey.of(Registries.BLOCK.getKey(), Identifier.of(ModInfo.MOD_ID, "display_cases"));
    public static final TagKey<Block> PILLOWS = TagKey.of(Registries.BLOCK.getKey(), Identifier.of(ModInfo.MOD_ID, "pillows"));
    public static final TagKey<Block> MINEABLE_SHEARS = TagKey.of(Registries.BLOCK.getKey(), Identifier.of(ModInfo.MOD_ID, "mineable/shears"));

    public static final TagKey<Item> GLASS_JAR_STORABLE = TagKey.of(Registries.ITEM.getKey(), Identifier.of(ModInfo.MOD_ID, "glass_jar_storable"));
}
