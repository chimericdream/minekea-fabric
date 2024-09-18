package com.chimericdream.minekea.block.building.stairs;

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
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Stairs implements MinekeaBlockCategory {
    public static final List<MinekeaBlock> STAIRS = new ArrayList<>();
    public static final List<MinekeaBlock> VERTICAL_STAIRS = new ArrayList<>();

    static {
        STAIRS.add(new GenericStairsBlock("Basalt Brick", "basalt_bricks", false, BuildingBlocks.BASALT_BRICKS_BLOCK, BasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        STAIRS.add(new GenericStairsBlock("Cracked Basalt Brick", "cracked_basalt_bricks", false, BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK, CrackedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        STAIRS.add(new GenericStairsBlock("Crimson Basalt Brick", "crimson_basalt_bricks", false, BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK, CrimsonBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        STAIRS.add(new GenericStairsBlock("Mossy Basalt Brick", "mossy_basalt_bricks", false, BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK, MossyBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        STAIRS.add(new GenericStairsBlock("Warped Basalt Brick", "warped_basalt_bricks", false, BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK, WarpedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        STAIRS.add(new GenericStairsBlock("Warped Nether Brick", "warped_nether_bricks", false, BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK, WarpedNetherBricksBlock.BLOCK_ID.withPrefixedPath("block/")));

        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Acacia", "acacia_planks", true, Blocks.ACACIA_PLANKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Birch", "birch_planks", true, Blocks.BIRCH_PLANKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Cherry", "cherry_planks", true, Blocks.CHERRY_PLANKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Crimson", "crimson_planks", false, Blocks.CRIMSON_PLANKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Dark Oak", "dark_oak_planks", true, Blocks.DARK_OAK_PLANKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Jungle", "jungle_planks", true, Blocks.JUNGLE_PLANKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Mangrove", "mangrove_planks", true, Blocks.MANGROVE_PLANKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Oak", "oak_planks", true, Blocks.OAK_PLANKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Spruce", "spruce_planks", true, Blocks.SPRUCE_PLANKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Warped", "warped_planks", false, Blocks.WARPED_PLANKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Andesite", "andesite", false, Blocks.ANDESITE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Bamboo Mosaic", "bamboo_mosaic", false, Blocks.BAMBOO_MOSAIC));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Blackstone", "blackstone", false, Blocks.BLACKSTONE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Brick", "bricks", false, Blocks.BRICKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Cobbled Deepslate", "cobbled_deepslate", false, Blocks.COBBLED_DEEPSLATE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Cobblestone", "cobblestone", false, Blocks.COBBLESTONE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Dark Prismarine", "dark_prismarine", false, Blocks.DARK_PRISMARINE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Deepslate Brick", "deepslate_bricks", false, Blocks.DEEPSLATE_BRICKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Deepslate Tile", "deepslate_tiles", false, Blocks.DEEPSLATE_TILES));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Diorite", "diorite", false, Blocks.DIORITE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("End Stone Brick", "end_stone_bricks", false, Blocks.END_STONE_BRICKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Granite", "granite", false, Blocks.GRANITE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Mossy Cobblestone", "mossy_cobblestone", false, Blocks.MOSSY_COBBLESTONE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Mossy Stone Brick", "mossy_stone_bricks", false, Blocks.MOSSY_STONE_BRICKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Mud Brick", "mud_bricks", false, Blocks.MUD_BRICKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Nether Brick", "nether_bricks", false, Blocks.NETHER_BRICKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Polished Andesite", "polished_andesite", false, Blocks.POLISHED_ANDESITE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Polished Blackstone Brick", "polished_blackstone_bricks", false, Blocks.POLISHED_BLACKSTONE_BRICKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Polished Blackstone", "polished_blackstone", false, Blocks.POLISHED_BLACKSTONE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Polished Deepslate", "polished_deepslate", false, Blocks.POLISHED_DEEPSLATE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Polished Diorite", "polished_diorite", false, Blocks.POLISHED_DIORITE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Polished Granite", "polished_granite", false, Blocks.POLISHED_GRANITE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Polished Tuff", "polished_tuff", false, Blocks.POLISHED_TUFF));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Prismarine Brick", "prismarine_bricks", false, Blocks.PRISMARINE_BRICKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Prismarine", "prismarine", false, Blocks.PRISMARINE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Purpur", "purpur_block", false, Blocks.PURPUR_BLOCK));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Quartz", "quartz_block", false, Blocks.QUARTZ_BLOCK, TextureMap.getId(Blocks.QUARTZ_BLOCK).withSuffixedPath("_top")));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Red Nether Brick", "red_nether_bricks", false, Blocks.RED_NETHER_BRICKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Red Sandstone", "red_sandstone", false, Blocks.RED_SANDSTONE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Sandstone", "sandstone", false, Blocks.SANDSTONE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Smooth Quartz", "quartz_block_bottom", false, Blocks.SMOOTH_QUARTZ, TextureMap.getId(Blocks.QUARTZ_BLOCK).withSuffixedPath("_bottom")));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Smooth Red Sandstone", "red_sandstone_top", false, Blocks.SMOOTH_RED_SANDSTONE, TextureMap.getId(Blocks.RED_SANDSTONE).withSuffixedPath("_top")));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Smooth Sandstone", "sandstone_top", false, Blocks.SMOOTH_SANDSTONE, TextureMap.getId(Blocks.SANDSTONE).withSuffixedPath("_top")));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Stone Brick", "stone_bricks", false, Blocks.STONE_BRICKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Stone", "stone", false, Blocks.STONE));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Tuff Brick", "tuff_bricks", false, Blocks.TUFF_BRICKS));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Tuff", "tuff", false, Blocks.TUFF));

        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Cut Copper", "cut_copper", false, Blocks.CUT_COPPER));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Waxed Cut Copper", "waxed_cut_copper", false, Blocks.WAXED_CUT_COPPER, TextureMap.getId(Blocks.CUT_COPPER)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Exposed Cut Copper", "exposed_cut_copper", false, Blocks.EXPOSED_CUT_COPPER));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Waxed Exposed Cut Copper", "waxed_exposed_cut_copper", false, Blocks.WAXED_EXPOSED_CUT_COPPER, TextureMap.getId(Blocks.EXPOSED_CUT_COPPER)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Weathered Cut Copper", "weathered_cut_copper", false, Blocks.WEATHERED_CUT_COPPER));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Waxed Weathered Cut Copper", "waxed_weathered_cut_copper", false, Blocks.WAXED_WEATHERED_CUT_COPPER, TextureMap.getId(Blocks.WEATHERED_CUT_COPPER)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Oxidized Cut Copper", "oxidized_cut_copper", false, Blocks.OXIDIZED_CUT_COPPER));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Waxed Oxidized Cut Copper", "waxed_oxidized_cut_copper", false, Blocks.WAXED_OXIDIZED_CUT_COPPER, TextureMap.getId(Blocks.OXIDIZED_CUT_COPPER)));

        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Basalt Brick", "basalt_bricks", false, BuildingBlocks.BASALT_BRICKS_BLOCK, BasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Cracked Basalt Brick", "cracked_basalt_bricks", false, BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK, CrackedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Crimson Basalt Brick", "crimson_basalt_bricks", false, BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK, CrimsonBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Mossy Basalt Brick", "mossy_basalt_bricks", false, BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK, MossyBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Warped Basalt Brick", "warped_basalt_bricks", false, BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK, WarpedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock("Warped Nether Brick", "warped_nether_bricks", false, BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK, WarpedNetherBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
    }

    @Override
    public void registerBlocks() {
        STAIRS.forEach(MinekeaBlock::register);
        VERTICAL_STAIRS.forEach(MinekeaBlock::register);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        STAIRS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
        VERTICAL_STAIRS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        STAIRS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
        VERTICAL_STAIRS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        STAIRS.forEach(block -> block.configureRecipes(exporter));
        VERTICAL_STAIRS.forEach(block -> block.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        STAIRS.forEach(block -> block.configureBlockLootTables(registryLookup, generator));
        VERTICAL_STAIRS.forEach(block -> block.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        STAIRS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
        VERTICAL_STAIRS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        STAIRS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
        VERTICAL_STAIRS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        STAIRS.forEach(block -> block.configureItemModels(itemModelGenerator));
        VERTICAL_STAIRS.forEach(block -> block.configureItemModels(itemModelGenerator));
    }

    @Override
    public void generateTextures() {
        STAIRS.forEach(MinekeaBlock::generateTextures);
        VERTICAL_STAIRS.forEach(MinekeaBlock::generateTextures);
    }
}
