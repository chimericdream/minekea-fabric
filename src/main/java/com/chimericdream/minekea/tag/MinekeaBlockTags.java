package com.chimericdream.minekea.tag;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class MinekeaBlockTags {
    public static final TagKey<Block> BEAMS = TagKey.of(Registries.BLOCK.getKey(), Identifier.of(ModInfo.MOD_ID, "beams"));
    public static final TagKey<Block> DISPLAY_CASES = TagKey.of(Registries.BLOCK.getKey(), Identifier.of(ModInfo.MOD_ID, "display_cases"));
    public static final TagKey<Block> FRAMED_PLANKS = TagKey.of(Registries.BLOCK.getKey(), Identifier.of(ModInfo.MOD_ID, "framed_planks"));
    public static final TagKey<Block> LANTERNS = TagKey.of(Registries.BLOCK.getKey(), Identifier.of(ModInfo.MOD_ID, "lanterns"));
    public static final TagKey<Block> PILLOWS = TagKey.of(Registries.BLOCK.getKey(), Identifier.of(ModInfo.MOD_ID, "pillows"));
}
