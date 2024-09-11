package com.chimericdream.minekea.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class MinecraftItemTags {
    public static final TagKey<Item> ACACIA_LOGS = TagKey.of(Registries.ITEM.getKey(), Identifier.of("acacia_logs"));
    public static final TagKey<Item> BIRCH_LOGS = TagKey.of(Registries.ITEM.getKey(), Identifier.of("birch_logs"));
    public static final TagKey<Item> CHERRY_LOGS = TagKey.of(Registries.ITEM.getKey(), Identifier.of("cherry_logs"));
    public static final TagKey<Item> CRIMSON_STEMS = TagKey.of(Registries.ITEM.getKey(), Identifier.of("crimson_stems"));
    public static final TagKey<Item> DARK_OAK_LOGS = TagKey.of(Registries.ITEM.getKey(), Identifier.of("dark_oak_logs"));
    public static final TagKey<Item> JUNGLE_LOGS = TagKey.of(Registries.ITEM.getKey(), Identifier.of("jungle_logs"));
    public static final TagKey<Item> MANGROVE_LOGS = TagKey.of(Registries.ITEM.getKey(), Identifier.of("mangrove_logs"));
    public static final TagKey<Item> OAK_LOGS = TagKey.of(Registries.ITEM.getKey(), Identifier.of("oak_logs"));
    public static final TagKey<Item> SPRUCE_LOGS = TagKey.of(Registries.ITEM.getKey(), Identifier.of("spruce_logs"));
    public static final TagKey<Item> WARPED_STEMS = TagKey.of(Registries.ITEM.getKey(), Identifier.of("warped_stems"));

    public static final TagKey<Item> PLANKS = TagKey.of(Registries.ITEM.getKey(), Identifier.of("planks"));
}
