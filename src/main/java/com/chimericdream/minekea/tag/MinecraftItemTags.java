package com.chimericdream.minekea.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class MinecraftItemTags {
    public static final TagKey<Item> PLANKS = TagKey.of(Registries.ITEM.getKey(), Identifier.of("planks"));
}
