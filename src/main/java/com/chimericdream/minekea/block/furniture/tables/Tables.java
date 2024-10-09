package com.chimericdream.minekea.block.furniture.tables;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;

import java.util.ArrayList;
import java.util.List;

public class Tables implements MinekeaBlockCategory {
    public static final List<Block> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.add(new GenericTable(new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)));
        BLOCKS.add(new GenericTable(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)));

        BLOCKS.add(new GenericTable(new BlockConfig().material("stripped_acacia").materialName("Stripped Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("stripped_bamboo").materialName("Stripped Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("stripped_birch").materialName("Stripped Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("stripped_cherry").materialName("Stripped Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("stripped_crimson").materialName("Stripped Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)));
        BLOCKS.add(new GenericTable(new BlockConfig().material("stripped_dark_oak").materialName("Stripped Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("stripped_jungle").materialName("Stripped Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("stripped_mangrove").materialName("Stripped Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("stripped_oak").materialName("Stripped Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("stripped_spruce").materialName("Stripped Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()));
        BLOCKS.add(new GenericTable(new BlockConfig().material("stripped_warped").materialName("Stripped Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)));
    }

    public List<Block> getCategoryBlocks() {
        return BLOCKS;
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        MinekeaBlockCategory.super.configureTranslations(registryLookup, translationBuilder);

        translationBuilder.add(GenericTable.TOOLTIP_KEY, "Simple design, but somehow LACKing...");
    }
}
