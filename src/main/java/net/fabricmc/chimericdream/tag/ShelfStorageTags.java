package net.fabricmc.chimericdream.tag;

import net.fabricmc.chimericdream.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ShelfStorageTags {
    public static final TagKey<Block> BOOKSHELVES = TagKey.of(Registry.BLOCK_KEY, new Identifier(ModInfo.MOD_ID, "bookshelves"));

    public static void init() {

    }
}
