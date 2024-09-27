package com.chimericdream.minekea.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CommonItemTags {
    public static final TagKey<Item> WRENCHES = TagKey.of(Registries.ITEM.getKey(), Identifier.of("c", "tools/wrenches"));
}
