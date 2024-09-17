package com.chimericdream.minekea.block.building.slabs;

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

public class Slabs implements MinekeaBlockCategory {
    public static final List<GenericVerticalSlabBlock> VERTICAL_SLABS = new ArrayList<>();

    static {
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Acacia", "acacia", false, Blocks.ACACIA_PLANKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Bamboo", "bamboo_planks", false, Blocks.BAMBOO_PLANKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Birch", "birch", false, Blocks.BIRCH_PLANKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Cherry", "cherry", false, Blocks.CHERRY_PLANKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Crimson", "crimson", false, Blocks.CRIMSON_PLANKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Dark Oak", "dark_oak", false, Blocks.DARK_OAK_PLANKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Jungle", "jungle", false, Blocks.JUNGLE_PLANKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Mangrove", "mangrove", false, Blocks.MANGROVE_PLANKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Oak", "oak", false, Blocks.OAK_PLANKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Spruce", "spruce", false, Blocks.SPRUCE_PLANKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Warped", "warped", false, Blocks.WARPED_PLANKS));

        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Andesite", "andesite", false, Blocks.ANDESITE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Bamboo Mosaic", "bamboo_mosaic", false, Blocks.BAMBOO_MOSAIC));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Blackstone", "blackstone", false, Blocks.BLACKSTONE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Brick", "bricks", false, Blocks.BRICKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Cobbled Deepslate", "cobbled_deepslate", false, Blocks.COBBLED_DEEPSLATE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Cobblestone", "cobblestone", false, Blocks.COBBLESTONE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Cut Red Sandstone", "cut_red_sandstone", false, Blocks.CUT_RED_SANDSTONE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Cut Sandstone", "cut_sandstone", false, Blocks.CUT_SANDSTONE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Dark Prismarine", "dark_prismarine", false, Blocks.DARK_PRISMARINE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Deepslate Brick", "deepslate_bricks", false, Blocks.DEEPSLATE_BRICKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Deepslate Tile", "deepslate_tiles", false, Blocks.DEEPSLATE_TILES));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Diorite", "diorite", false, Blocks.DIORITE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("End Stone Brick", "end_stone_bricks", false, Blocks.END_STONE_BRICKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Granite", "granite", false, Blocks.GRANITE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Mossy Cobblestone", "mossy_cobblestone", false, Blocks.MOSSY_COBBLESTONE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Mossy Stone Brick", "mossy_stone_bricks", false, Blocks.MOSSY_STONE_BRICKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Mud Brick", "mud_bricks", false, Blocks.MUD_BRICKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Nether Brick", "nether_bricks", false, Blocks.NETHER_BRICKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Polished Andesite", "polished_andesite", false, Blocks.POLISHED_ANDESITE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Polished Blackstone", "polished_blackstone", false, Blocks.POLISHED_BLACKSTONE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Polished Blackstone Brick", "polished_blackstone_bricks", false, Blocks.POLISHED_BLACKSTONE_BRICKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Polished Deepslate", "polished_deepslate", false, Blocks.POLISHED_DEEPSLATE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Polished Diorite", "polished_diorite", false, Blocks.POLISHED_DIORITE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Polished Granite", "polished_granite", false, Blocks.POLISHED_GRANITE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Polished Tuff", "polished_tuff", false, Blocks.POLISHED_TUFF));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Prismarine", "prismarine", false, Blocks.PRISMARINE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Prismarine Brick", "prismarine_bricks", false, Blocks.PRISMARINE_BRICKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Purpur", "purpur_block", false, Blocks.PURPUR_BLOCK));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Quartz", "quartz_block", false, Blocks.QUARTZ_BLOCK, TextureMap.getId(Blocks.QUARTZ_BLOCK).withSuffixedPath("_top")));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Red Nether Brick", "red_nether_bricks", false, Blocks.RED_NETHER_BRICKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Red Sandstone", "red_sandstone", false, Blocks.RED_SANDSTONE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Sandstone", "sandstone", false, Blocks.SANDSTONE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Smooth Quartz", "smooth_quartz", false, Blocks.SMOOTH_QUARTZ, TextureMap.getId(Blocks.QUARTZ_BLOCK).withSuffixedPath("_bottom")));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Smooth Red Sandstone", "smooth_red_sandstone", false, Blocks.SMOOTH_RED_SANDSTONE, TextureMap.getId(Blocks.RED_SANDSTONE).withSuffixedPath("_top")));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Smooth Sandstone", "smooth_sandstone", false, Blocks.SMOOTH_SANDSTONE, TextureMap.getId(Blocks.SANDSTONE).withSuffixedPath("_top")));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Smooth Stone", "smooth_stone", false, Blocks.SMOOTH_STONE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Stone", "stone", false, Blocks.STONE));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Stone Brick", "stone_bricks", false, Blocks.STONE_BRICKS));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Tuff", "tuff", false, Blocks.TUFF));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Tuff Brick", "tuff_bricks", false, Blocks.TUFF_BRICKS));

        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Cut Copper", "cut_copper", false, Blocks.CUT_COPPER));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Waxed Cut Copper", "waxed_cut_copper", false, Blocks.WAXED_CUT_COPPER, TextureMap.getId(Blocks.CUT_COPPER)));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Exposed Cut Copper", "exposed_cut_copper", false, Blocks.EXPOSED_CUT_COPPER));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Waxed Exposed Cut Copper", "waxed_exposed_cut_copper", false, Blocks.WAXED_EXPOSED_CUT_COPPER, TextureMap.getId(Blocks.EXPOSED_CUT_COPPER)));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Weathered Cut Copper", "weathered_cut_copper", false, Blocks.WEATHERED_CUT_COPPER));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Waxed Weathered Cut Copper", "waxed_weathered_cut_copper", false, Blocks.WAXED_WEATHERED_CUT_COPPER, TextureMap.getId(Blocks.WEATHERED_CUT_COPPER)));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Oxidized Cut Copper", "oxidized_cut_copper", false, Blocks.OXIDIZED_CUT_COPPER));
        VERTICAL_SLABS.add(new GenericVerticalSlabBlock("Waxed Oxidized Cut Copper", "waxed_oxidized_cut_copper", false, Blocks.WAXED_OXIDIZED_CUT_COPPER, TextureMap.getId(Blocks.OXIDIZED_CUT_COPPER)));
    }

    @Override
    public void registerBlocks() {
        VERTICAL_SLABS.forEach(GenericVerticalSlabBlock::register);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        VERTICAL_SLABS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        VERTICAL_SLABS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        VERTICAL_SLABS.forEach(block -> block.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        VERTICAL_SLABS.forEach(block -> block.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        VERTICAL_SLABS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        VERTICAL_SLABS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        VERTICAL_SLABS.forEach(block -> block.configureItemModels(itemModelGenerator));
    }

    @Override
    public void generateTextures() {
        VERTICAL_SLABS.forEach(MinekeaBlock::generateTextures);
    }
}
