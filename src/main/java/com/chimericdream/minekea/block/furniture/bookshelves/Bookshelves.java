package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.lib.blocks.ModBlock;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
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

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class Bookshelves implements MinekeaBlockCategory {
    public static final Map<String, GenericBookshelf> BOOKSHELVES = new LinkedHashMap<>();

    static {
        BOOKSHELVES.put("acacia", new GenericBookshelf(new ModBlock.Config().material("acacia").materialName("Acacia").flammable().ingredient(Blocks.ACACIA_PLANKS)));
        BOOKSHELVES.put("bamboo", new GenericBookshelf(new ModBlock.Config().material("bamboo").materialName("Bamboo").flammable().ingredient(Blocks.BAMBOO_PLANKS)));
        BOOKSHELVES.put("birch", new GenericBookshelf(new ModBlock.Config().material("birch").materialName("Birch").flammable().ingredient(Blocks.BIRCH_PLANKS)));
        BOOKSHELVES.put("cherry", new GenericBookshelf(new ModBlock.Config().material("cherry").materialName("Cherry").flammable().ingredient(Blocks.CHERRY_PLANKS)));
        BOOKSHELVES.put("crimson", new GenericBookshelf(new ModBlock.Config().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS)));
        BOOKSHELVES.put("dark_oak", new GenericBookshelf(new ModBlock.Config().material("dark_oak").materialName("Dark Oak").flammable().ingredient(Blocks.DARK_OAK_PLANKS)));
        BOOKSHELVES.put("jungle", new GenericBookshelf(new ModBlock.Config().material("jungle").materialName("Jungle").flammable().ingredient(Blocks.JUNGLE_PLANKS)));
        BOOKSHELVES.put("mangrove", new GenericBookshelf(new ModBlock.Config().material("mangrove").materialName("Mangrove").flammable().ingredient(Blocks.MANGROVE_PLANKS)));
        BOOKSHELVES.put("spruce", new GenericBookshelf(new ModBlock.Config().material("spruce").materialName("Spruce").flammable().ingredient(Blocks.SPRUCE_PLANKS)));
        BOOKSHELVES.put("warped", new GenericBookshelf(new ModBlock.Config().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS)));

        BOOKSHELVES.put("bone", new GenericBookshelf(new ModBlock.Config().material("bone").materialName("Bone").ingredient(Blocks.BONE_BLOCK).texture("default", Registries.BLOCK.getId(Blocks.BONE_BLOCK).withPrefixedPath("block/").withSuffixedPath("_side"))));
        BOOKSHELVES.put("dark_prismarine", new GenericBookshelf(new ModBlock.Config().material("dark_prismarine").materialName("Dark Prismarine").ingredient(Blocks.DARK_PRISMARINE)));
        BOOKSHELVES.put("deepslate_brick", new GenericBookshelf(new ModBlock.Config().material("deepslate_brick").materialName("Deepslate Brick").ingredient(Blocks.DEEPSLATE_BRICKS)));
        BOOKSHELVES.put("end_stone_brick", new GenericBookshelf(new ModBlock.Config().material("end_stone_brick").materialName("End Stone Brick").ingredient(Blocks.END_STONE_BRICKS)));
        BOOKSHELVES.put("nether_brick", new GenericBookshelf(new ModBlock.Config().material("nether_brick").materialName("Nether Brick").ingredient(Blocks.NETHER_BRICKS)));
        BOOKSHELVES.put("polished_andesite", new GenericBookshelf(new ModBlock.Config().material("polished_andesite").materialName("Polished Andesite").ingredient(Blocks.POLISHED_ANDESITE)));
        BOOKSHELVES.put("polished_basalt", new GenericBookshelf(new ModBlock.Config().material("polished_basalt").materialName("Polished Basalt").ingredient(Blocks.POLISHED_BASALT).texture("default", Registries.BLOCK.getId(Blocks.POLISHED_BASALT).withPrefixedPath("block/").withSuffixedPath("_top"))));
        BOOKSHELVES.put("polished_blackstone", new GenericBookshelf(new ModBlock.Config().material("polished_blackstone").materialName("Polished Blackstone").ingredient(Blocks.POLISHED_BLACKSTONE)));
        BOOKSHELVES.put("polished_blackstone_brick", new GenericBookshelf(new ModBlock.Config().material("polished_blackstone_brick").materialName("Polished Blackstone Brick").ingredient(Blocks.POLISHED_BLACKSTONE_BRICKS)));
        BOOKSHELVES.put("polished_deepslate", new GenericBookshelf(new ModBlock.Config().material("polished_deepslate").materialName("Polished Deepslate").ingredient(Blocks.POLISHED_DEEPSLATE)));
        BOOKSHELVES.put("polished_diorite", new GenericBookshelf(new ModBlock.Config().material("polished_diorite").materialName("Polished Diorite").ingredient(Blocks.POLISHED_DIORITE)));
        BOOKSHELVES.put("polished_granite", new GenericBookshelf(new ModBlock.Config().material("polished_granite").materialName("Polished Granite").ingredient(Blocks.POLISHED_GRANITE)));
        BOOKSHELVES.put("polished_tuff", new GenericBookshelf(new ModBlock.Config().material("polished_tuff").materialName("Polished Tuff").ingredient(Blocks.POLISHED_TUFF)));
        BOOKSHELVES.put("prismarine", new GenericBookshelf(new ModBlock.Config().material("prismarine").materialName("Prismarine").ingredient(Blocks.PRISMARINE)));
        BOOKSHELVES.put("prismarine_brick", new GenericBookshelf(new ModBlock.Config().material("prismarine_brick").materialName("Prismarine Brick").ingredient(Blocks.PRISMARINE_BRICKS)));
        BOOKSHELVES.put("purpur", new GenericBookshelf(new ModBlock.Config().material("purpur").materialName("Purpur").ingredient(Blocks.PURPUR_BLOCK)));
        BOOKSHELVES.put("quartz_brick", new GenericBookshelf(new ModBlock.Config().material("quartz_brick").materialName("Quartz Brick").ingredient(Blocks.QUARTZ_BRICKS)));
        BOOKSHELVES.put("red_nether_brick", new GenericBookshelf(new ModBlock.Config().material("red_nether_brick").materialName("Red Nether Brick").ingredient(Blocks.RED_NETHER_BRICKS)));
        BOOKSHELVES.put("smooth_quartz", new GenericBookshelf(new ModBlock.Config().material("smooth_quartz").materialName("Smooth Quartz").ingredient(Blocks.SMOOTH_QUARTZ).texture("default", Registries.BLOCK.getId(Blocks.QUARTZ_BLOCK).withPrefixedPath("block/").withSuffixedPath("_bottom"))));
        BOOKSHELVES.put("smooth_stone", new GenericBookshelf(new ModBlock.Config().material("smooth_stone").materialName("Smooth Stone").ingredient(Blocks.SMOOTH_STONE)));
        BOOKSHELVES.put("stone_brick", new GenericBookshelf(new ModBlock.Config().material("stone_brick").materialName("Stone Brick").ingredient(Blocks.STONE_BRICKS)));
        BOOKSHELVES.put("tuff_brick", new GenericBookshelf(new ModBlock.Config().material("tuff_brick").materialName("Tuff Brick").ingredient(Blocks.TUFF_BRICKS)));
        BOOKSHELVES.put("warped_nether_brick", new GenericBookshelf(new ModBlock.Config().material("warped_nether_brick").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK).texture("default", WarpedNetherBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
    }

    @Override
    public void registerBlocks() {
        BOOKSHELVES.forEach((key, bookshelf) -> bookshelf.register());
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        BOOKSHELVES.forEach((key, bookshelf) -> bookshelf.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        BOOKSHELVES.forEach((key, bookshelf) -> bookshelf.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        BOOKSHELVES.forEach((key, bookshelf) -> bookshelf.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        BOOKSHELVES.forEach((key, bookshelf) -> bookshelf.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        BOOKSHELVES.forEach((key, bookshelf) -> bookshelf.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BOOKSHELVES.forEach((key, bookshelf) -> bookshelf.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BOOKSHELVES.forEach((key, bookshelf) -> bookshelf.configureItemModels(itemModelGenerator));
    }
}
