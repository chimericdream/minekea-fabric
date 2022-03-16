package net.fabricmc.chimericdream.tag;

import net.fabricmc.chimericdream.ModInfo;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.block.Block;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

public class ShelfStorageTags {
    public static final Tag<Block> BOOKSHELVES = TagFactory.BLOCK.create(new Identifier(ModInfo.MOD_ID, "bookshelves"));

    public static void init() {}
}
