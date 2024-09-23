package com.chimericdream.minekea.tag;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class MinekeaItemTags {
    public static final TagKey<Item> BAGGED_ITEMS = TagKey.of(Registries.ITEM.getKey(), Identifier.of(ModInfo.MOD_ID, "bagged_items"));
    public static final TagKey<Item> GLASS_JAR_STORABLE = TagKey.of(Registries.ITEM.getKey(), Identifier.of(ModInfo.MOD_ID, "glass_jar_storable"));
    public static final TagKey<Item> VOTIVE_CANDLES = TagKey.of(Registries.ITEM.getKey(), Identifier.of(ModInfo.MOD_ID, "votive_candles"));
}
