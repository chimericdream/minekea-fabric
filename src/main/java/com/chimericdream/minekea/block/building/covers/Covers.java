package com.chimericdream.minekea.block.building.covers;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Covers implements MinekeaBlockCategory {
    public static final List<GenericCoverBlock> BLOCKS = new ArrayList<>();

    static {
        BLOCKS.add(new GenericCoverBlock("Amethyst", "amethyst", false, Blocks.AMETHYST_BLOCK));
        BLOCKS.add(new GenericCoverBlock("Andesite", "andesite", false, Blocks.ANDESITE));
        BLOCKS.add(new GenericCoverBlock("Basalt", "basalt", false, Blocks.BASALT, Registries.BLOCK.getId(Blocks.BASALT).withPrefixedPath("block/").withSuffixedPath("_top"), Registries.BLOCK.getId(Blocks.BASALT).withPrefixedPath("block/").withSuffixedPath("_side")));
        BLOCKS.add(new GenericCoverBlock("Basalt Brick", "basalt_brick", false, BuildingBlocks.BASALT_BRICKS_BLOCK, BasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Blackstone", "blackstone", false, Blocks.BLACKSTONE));
        BLOCKS.add(new GenericCoverBlock("Bone", "bone", false, Blocks.BONE_BLOCK, Registries.BLOCK.getId(Blocks.BONE_BLOCK).withPrefixedPath("block/").withSuffixedPath("_top"), Registries.BLOCK.getId(Blocks.BONE_BLOCK).withPrefixedPath("block/").withSuffixedPath("_side")));
        BLOCKS.add(new GenericCoverBlock("Brick", "brick", false, Blocks.BRICKS));
        BLOCKS.add(new GenericCoverBlock("Calcite", "calcite", false, Blocks.CALCITE));
        BLOCKS.add(new GenericCoverBlock("Cobbled Deepslate", "cobbled_deepslate", false, Blocks.COBBLED_DEEPSLATE));
        BLOCKS.add(new GenericCoverBlock("Cobblestone", "cobblestone", false, Blocks.COBBLESTONE));
        BLOCKS.add(new GenericCoverBlock("Cracked Basalt Brick", "cracked_basalt_brick", false, BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK, CrackedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Cracked Deepslate Brick", "cracked_deepslate_brick", false, Blocks.CRACKED_DEEPSLATE_BRICKS));
        BLOCKS.add(new GenericCoverBlock("Cracked Deepslate Tile", "cracked_deepslate_tile", false, Blocks.CRACKED_DEEPSLATE_TILES));
        BLOCKS.add(new GenericCoverBlock("Cracked Stone Brick", "cracked_stone_brick", false, Blocks.CRACKED_STONE_BRICKS));
        BLOCKS.add(new GenericCoverBlock("Crimson Basalt Brick", "crimson_basalt_brick", false, BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK, CrimsonBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Crying Obsidian", "crying_obsidian", false, Blocks.CRYING_OBSIDIAN));
        BLOCKS.add(new GenericCoverBlock("Cut Red Sandstone", "cut_red_sandstone", false, Blocks.CUT_RED_SANDSTONE));
        BLOCKS.add(new GenericCoverBlock("Cut Sandstone", "cut_sandstone", false, Blocks.CUT_SANDSTONE));
        BLOCKS.add(new GenericCoverBlock("Dark Prismarine", "dark_prismarine", false, Blocks.DARK_PRISMARINE));
        BLOCKS.add(new GenericCoverBlock("Deepslate", "deepslate", false, Blocks.DEEPSLATE));
        BLOCKS.add(new GenericCoverBlock("Deepslate Brick", "deepslate_brick", false, Blocks.DEEPSLATE_BRICKS));
        BLOCKS.add(new GenericCoverBlock("Deepslate Tile", "deepslate_tile", false, Blocks.DEEPSLATE_TILES));
        BLOCKS.add(new GenericCoverBlock("Diorite", "diorite", false, Blocks.DIORITE));
        BLOCKS.add(new GenericCoverBlock("End Stone", "end_stone", false, Blocks.END_STONE));
        BLOCKS.add(new GenericCoverBlock("End Stone Brick", "end_stone_brick", false, Blocks.END_STONE_BRICKS));
        BLOCKS.add(new GenericCoverBlock("Granite", "granite", false, Blocks.GRANITE));
        BLOCKS.add(new GenericCoverBlock("Mossy Basalt Brick", "mossy_basalt_brick", false, BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK, MossyBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Mossy Cobblestone", "mossy_cobblestone", false, Blocks.MOSSY_COBBLESTONE));
        BLOCKS.add(new GenericCoverBlock("Mossy Stone Brick", "mossy_stone_brick", false, Blocks.MOSSY_STONE_BRICKS));
        BLOCKS.add(new GenericCoverBlock("Mud Brick", "mud_brick", false, Blocks.MUD_BRICKS));
        BLOCKS.add(new GenericCoverBlock("Netherrack", "netherrack", false, Blocks.NETHERRACK));
        BLOCKS.add(new GenericCoverBlock("Nether Brick", "nether_brick", false, Blocks.NETHER_BRICKS));
        BLOCKS.add(new GenericCoverBlock("Obsidian", "obsidian", false, Blocks.OBSIDIAN));
        BLOCKS.add(new GenericCoverBlock("Packed Mud", "packed_mud", false, Blocks.PACKED_MUD));
        BLOCKS.add(new GenericCoverBlock("Polished Andesite", "polished_andesite", false, Blocks.POLISHED_ANDESITE));
        BLOCKS.add(new GenericCoverBlock("Polished Basalt", "polished_basalt", false, Blocks.POLISHED_BASALT, Registries.BLOCK.getId(Blocks.POLISHED_BASALT).withPrefixedPath("block/").withSuffixedPath("_top"), Registries.BLOCK.getId(Blocks.POLISHED_BASALT).withPrefixedPath("block/").withSuffixedPath("_side")));
        BLOCKS.add(new GenericCoverBlock("Polished Blackstone", "polished_blackstone", false, Blocks.POLISHED_BLACKSTONE));
        BLOCKS.add(new GenericCoverBlock("Polished Blackstone Brick", "polished_blackstone_brick", false, Blocks.POLISHED_BLACKSTONE_BRICKS));
        BLOCKS.add(new GenericCoverBlock("Polished Deepslate", "polished_deepslate", false, Blocks.POLISHED_DEEPSLATE));
        BLOCKS.add(new GenericCoverBlock("Polished Diorite", "polished_diorite", false, Blocks.POLISHED_DIORITE));
        BLOCKS.add(new GenericCoverBlock("Polished Granite", "polished_granite", false, Blocks.POLISHED_GRANITE));
        BLOCKS.add(new GenericCoverBlock("Prismarine", "prismarine", false, Blocks.PRISMARINE));
        BLOCKS.add(new GenericCoverBlock("Prismarine Brick", "prismarine_brick", false, Blocks.PRISMARINE_BRICKS));
        BLOCKS.add(new GenericCoverBlock("Purpur", "purpur", false, Blocks.PURPUR_BLOCK));
        BLOCKS.add(new GenericCoverBlock("Purpur Pillar", "purpur_pillar", false, Blocks.PURPUR_PILLAR));
        BLOCKS.add(new GenericCoverBlock("Quartz", "quartz", false, Blocks.QUARTZ_BLOCK, Registries.BLOCK.getId(Blocks.QUARTZ_BLOCK).withPrefixedPath("block/").withSuffixedPath("_top")));
        BLOCKS.add(new GenericCoverBlock("Quartz Brick", "quartz_brick", false, Blocks.QUARTZ_BRICKS));
        BLOCKS.add(new GenericCoverBlock("Red Nether Brick", "red_nether_brick", false, Blocks.RED_NETHER_BRICKS));
        BLOCKS.add(new GenericCoverBlock("Red Sandstone", "red_sandstone", false, Blocks.RED_SANDSTONE));
        BLOCKS.add(new GenericCoverBlock("Sandstone", "sandstone", false, Blocks.SANDSTONE));
        BLOCKS.add(new GenericCoverBlock("Smooth Basalt", "smooth_basalt", false, Blocks.SMOOTH_BASALT));
        BLOCKS.add(new GenericCoverBlock("Smooth Quartz", "smooth_quartz", false, Blocks.SMOOTH_QUARTZ, Registries.BLOCK.getId(Blocks.QUARTZ_BLOCK).withPrefixedPath("block/").withSuffixedPath("_bottom")));
        BLOCKS.add(new GenericCoverBlock("Smooth Red Sandstone", "smooth_red_sandstone", false, Blocks.SMOOTH_RED_SANDSTONE, Registries.BLOCK.getId(Blocks.RED_SANDSTONE).withPrefixedPath("block/").withSuffixedPath("_top")));
        BLOCKS.add(new GenericCoverBlock("Smooth Sandstone", "smooth_sandstone", false, Blocks.SMOOTH_SANDSTONE, Registries.BLOCK.getId(Blocks.SANDSTONE).withPrefixedPath("block/").withSuffixedPath("_top")));
        BLOCKS.add(new GenericCoverBlock("Smooth Stone", "smooth_stone", false, Blocks.SMOOTH_STONE));
        BLOCKS.add(new GenericCoverBlock("Stone", "stone", false, Blocks.STONE));
        BLOCKS.add(new GenericCoverBlock("Stone Brick", "stone_brick", false, Blocks.STONE_BRICKS));
        BLOCKS.add(new GenericCoverBlock("Tuff", "tuff", false, Blocks.TUFF));
        BLOCKS.add(new GenericCoverBlock("Warped Basalt Brick", "warped_basalt_brick", false, BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK, WarpedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Warped Nether Brick", "warped_nether_brick", false, BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK, WarpedNetherBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Copper Block", "copper_block", false, Blocks.COPPER_BLOCK));
        BLOCKS.add(new GenericCoverBlock("Diamond Block", "diamond_block", false, Blocks.DIAMOND_BLOCK));
        BLOCKS.add(new GenericCoverBlock("Gold Block", "gold_block", false, Blocks.GOLD_BLOCK));
        BLOCKS.add(new GenericCoverBlock("Iron Block", "iron_block", false, Blocks.IRON_BLOCK));
        BLOCKS.add(new GenericCoverBlock("Lapis Block", "lapis_block", false, Blocks.LAPIS_BLOCK));
        BLOCKS.add(new GenericCoverBlock("Netherite Block", "netherite_block", false, Blocks.NETHERITE_BLOCK));
        BLOCKS.add(new GenericCoverBlock("Redstone Block", "redstone_block", false, Blocks.REDSTONE_BLOCK));
        BLOCKS.add(new GenericCoverBlock("Cut Copper", "cut_copper", false, Blocks.CUT_COPPER));
        BLOCKS.add(new GenericCoverBlock("Exposed Cut Copper", "exposed_cut_copper", false, Blocks.EXPOSED_CUT_COPPER));
        BLOCKS.add(new GenericCoverBlock("Weathered Cut Copper", "weathered_cut_copper", false, Blocks.WEATHERED_CUT_COPPER));
        BLOCKS.add(new GenericCoverBlock("Oxidized Cut Copper", "oxidized_cut_copper", false, Blocks.OXIDIZED_CUT_COPPER));

        BLOCKS.add(new GenericCoverBlock("White Terracotta", "white_terracotta", false, Blocks.WHITE_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Light Gray Terracotta", "light_gray_terracotta", false, Blocks.LIGHT_GRAY_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Gray Terracotta", "gray_terracotta", false, Blocks.GRAY_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Black Terracotta", "black_terracotta", false, Blocks.BLACK_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Brown Terracotta", "brown_terracotta", false, Blocks.BROWN_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Red Terracotta", "red_terracotta", false, Blocks.RED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Orange Terracotta", "orange_terracotta", false, Blocks.ORANGE_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Yellow Terracotta", "yellow_terracotta", false, Blocks.YELLOW_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Lime Terracotta", "lime_terracotta", false, Blocks.LIME_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Green Terracotta", "green_terracotta", false, Blocks.GREEN_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Cyan Terracotta", "cyan_terracotta", false, Blocks.CYAN_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Light Blue Terracotta", "light_blue_terracotta", false, Blocks.LIGHT_BLUE_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Blue Terracotta", "blue_terracotta", false, Blocks.BLUE_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Purple Terracotta", "purple_terracotta", false, Blocks.PURPLE_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Magenta Terracotta", "magenta_terracotta", false, Blocks.MAGENTA_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Pink Terracotta", "pink_terracotta", false, Blocks.PINK_TERRACOTTA));

        BLOCKS.add(new GenericCoverBlock("White Glazed Terracotta", "white_glazed_terracotta", false, Blocks.WHITE_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Light Gray Glazed Terracotta", "light_gray_glazed_terracotta", false, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Gray Glazed Terracotta", "gray_glazed_terracotta", false, Blocks.GRAY_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Black Glazed Terracotta", "black_glazed_terracotta", false, Blocks.BLACK_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Brown Glazed Terracotta", "brown_glazed_terracotta", false, Blocks.BROWN_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Red Glazed Terracotta", "red_glazed_terracotta", false, Blocks.RED_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Orange Glazed Terracotta", "orange_glazed_terracotta", false, Blocks.ORANGE_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Yellow Glazed Terracotta", "yellow_glazed_terracotta", false, Blocks.YELLOW_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Lime Glazed Terracotta", "lime_glazed_terracotta", false, Blocks.LIME_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Green Glazed Terracotta", "green_glazed_terracotta", false, Blocks.GREEN_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Cyan Glazed Terracotta", "cyan_glazed_terracotta", false, Blocks.CYAN_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Light Blue Glazed Terracotta", "light_blue_glazed_terracotta", false, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Blue Glazed Terracotta", "blue_glazed_terracotta", false, Blocks.BLUE_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Purple Glazed Terracotta", "purple_glazed_terracotta", false, Blocks.PURPLE_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Magenta Glazed Terracotta", "magenta_glazed_terracotta", false, Blocks.MAGENTA_GLAZED_TERRACOTTA));
        BLOCKS.add(new GenericCoverBlock("Pink Glazed Terracotta", "pink_glazed_terracotta", false, Blocks.PINK_GLAZED_TERRACOTTA));

        BLOCKS.add(new GenericCoverBlock("White Concrete", "white_concrete", false, Blocks.WHITE_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Light Gray Concrete", "light_gray_concrete", false, Blocks.LIGHT_GRAY_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Gray Concrete", "gray_concrete", false, Blocks.GRAY_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Black Concrete", "black_concrete", false, Blocks.BLACK_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Brown Concrete", "brown_concrete", false, Blocks.BROWN_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Red Concrete", "red_concrete", false, Blocks.RED_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Orange Concrete", "orange_concrete", false, Blocks.ORANGE_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Yellow Concrete", "yellow_concrete", false, Blocks.YELLOW_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Lime Concrete", "lime_concrete", false, Blocks.LIME_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Green Concrete", "green_concrete", false, Blocks.GREEN_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Cyan Concrete", "cyan_concrete", false, Blocks.CYAN_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Light Blue Concrete", "light_blue_concrete", false, Blocks.LIGHT_BLUE_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Blue Concrete", "blue_concrete", false, Blocks.BLUE_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Purple Concrete", "purple_concrete", false, Blocks.PURPLE_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Magenta Concrete", "magenta_concrete", false, Blocks.MAGENTA_CONCRETE));
        BLOCKS.add(new GenericCoverBlock("Pink Concrete", "pink_concrete", false, Blocks.PINK_CONCRETE));

        BLOCKS.add(new GenericCoverBlock("Acacia", "acacia", true, Blocks.ACACIA_PLANKS));
        BLOCKS.add(new GenericCoverBlock("Birch", "birch", true, Blocks.BIRCH_PLANKS));
        BLOCKS.add(new GenericCoverBlock("Cherry", "cherry", false, Blocks.CHERRY_PLANKS));
        BLOCKS.add(new GenericCoverBlock("Crimson", "crimson", false, Blocks.CRIMSON_PLANKS));
        BLOCKS.add(new GenericCoverBlock("Dark Oak", "dark_oak", true, Blocks.DARK_OAK_PLANKS));
        BLOCKS.add(new GenericCoverBlock("Jungle", "jungle", true, Blocks.JUNGLE_PLANKS));
        BLOCKS.add(new GenericCoverBlock("Mangrove", "mangrove", true, Blocks.MANGROVE_PLANKS));
        BLOCKS.add(new GenericCoverBlock("Oak", "oak", true, Blocks.OAK_PLANKS));
        BLOCKS.add(new GenericCoverBlock("Spruce", "spruce", true, Blocks.SPRUCE_PLANKS));
        BLOCKS.add(new GenericCoverBlock("Warped", "warped", false, Blocks.WARPED_PLANKS));

        BLOCKS.add(new GenericCoverBlock("Acacia Log", "acacia_log", true, Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG, Registries.BLOCK.getId(Blocks.ACACIA_LOG).withPrefixedPath("block/").withSuffixedPath("_top"), Registries.BLOCK.getId(Blocks.ACACIA_LOG).withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Birch Log", "birch_log", true, Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG, Registries.BLOCK.getId(Blocks.BIRCH_LOG).withPrefixedPath("block/").withSuffixedPath("_top"), Registries.BLOCK.getId(Blocks.BIRCH_LOG).withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Cherry Log", "cherry_log", false, Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG, Registries.BLOCK.getId(Blocks.CHERRY_LOG).withPrefixedPath("block/").withSuffixedPath("_top"), Registries.BLOCK.getId(Blocks.CHERRY_LOG).withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Crimson Stem", "crimson_stem", false, Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM, Registries.BLOCK.getId(Blocks.CRIMSON_STEM).withPrefixedPath("block/").withSuffixedPath("_top"), Registries.BLOCK.getId(Blocks.CRIMSON_STEM).withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Dark Oak Log", "dark_oak_log", true, Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG, Registries.BLOCK.getId(Blocks.DARK_OAK_LOG).withPrefixedPath("block/").withSuffixedPath("_top"), Registries.BLOCK.getId(Blocks.DARK_OAK_LOG).withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Jungle Log", "jungle_log", true, Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG, Registries.BLOCK.getId(Blocks.JUNGLE_LOG).withPrefixedPath("block/").withSuffixedPath("_top"), Registries.BLOCK.getId(Blocks.JUNGLE_LOG).withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Mangrove Log", "mangrove_log", true, Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG, Registries.BLOCK.getId(Blocks.MANGROVE_LOG).withPrefixedPath("block/").withSuffixedPath("_top"), Registries.BLOCK.getId(Blocks.MANGROVE_LOG).withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Oak Log", "oak_log", true, Blocks.OAK_PLANKS, Blocks.OAK_LOG, Registries.BLOCK.getId(Blocks.OAK_LOG).withPrefixedPath("block/").withSuffixedPath("_top"), Registries.BLOCK.getId(Blocks.OAK_LOG).withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Spruce Log", "spruce_log", true, Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG, Registries.BLOCK.getId(Blocks.SPRUCE_LOG).withPrefixedPath("block/").withSuffixedPath("_top"), Registries.BLOCK.getId(Blocks.SPRUCE_LOG).withPrefixedPath("block/")));
        BLOCKS.add(new GenericCoverBlock("Warped Stem", "warped_stem", false, Blocks.WARPED_PLANKS, Blocks.WARPED_STEM, Registries.BLOCK.getId(Blocks.WARPED_STEM).withPrefixedPath("block/").withSuffixedPath("_top"), Registries.BLOCK.getId(Blocks.WARPED_STEM).withPrefixedPath("block/")));
    }

    @Override
    public void registerBlocks() {
        BLOCKS.forEach(MinekeaBlock::register);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        BLOCKS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        BLOCKS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        BLOCKS.forEach(block -> block.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        BLOCKS.forEach(block -> block.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        BLOCKS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BLOCKS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BLOCKS.forEach(block -> block.configureItemModels(itemModelGenerator));
    }

    @Override
    public void generateTextures() {
        BLOCKS.forEach(MinekeaBlock::generateTextures);
    }
}
