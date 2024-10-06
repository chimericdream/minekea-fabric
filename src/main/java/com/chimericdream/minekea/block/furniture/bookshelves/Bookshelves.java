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
        BOOKSHELVES.put("Acacia", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Acacia").material("acacia").flammable().ingredient(Blocks.ACACIA_PLANKS)));
        BOOKSHELVES.put("Bamboo", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Bamboo").material("bamboo").flammable().ingredient(Blocks.BAMBOO_PLANKS)));
        BOOKSHELVES.put("Birch", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Birch").material("birch").flammable().ingredient(Blocks.BIRCH_PLANKS)));
        BOOKSHELVES.put("Cherry", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Cherry").material("cherry").flammable().ingredient(Blocks.CHERRY_PLANKS)));
        BOOKSHELVES.put("Crimson", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Crimson").material("crimson").ingredient(Blocks.CRIMSON_PLANKS)));
        BOOKSHELVES.put("Dark Oak", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Dark Oak").material("dark_oak").flammable().ingredient(Blocks.DARK_OAK_PLANKS)));
        BOOKSHELVES.put("Jungle", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Jungle").material("jungle").flammable().ingredient(Blocks.JUNGLE_PLANKS)));
        BOOKSHELVES.put("Mangrove", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Mangrove").material("mangrove").flammable().ingredient(Blocks.MANGROVE_PLANKS)));
        BOOKSHELVES.put("Spruce", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Spruce").material("spruce").flammable().ingredient(Blocks.SPRUCE_PLANKS)));
        BOOKSHELVES.put("Warped", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Warped").material("warped").ingredient(Blocks.WARPED_PLANKS)));

        BOOKSHELVES.put("Bone", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Bone").material("bone").ingredient(Blocks.BONE_BLOCK).texture("default", Registries.BLOCK.getId(Blocks.BONE_BLOCK).withPrefixedPath("block/").withSuffixedPath("_side"))));
        BOOKSHELVES.put("Dark Prismarine", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Dark Prismarine").material("dark_prismarine").ingredient(Blocks.DARK_PRISMARINE)));
        BOOKSHELVES.put("Deepslate Brick", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Deepslate Brick").material("deepslate_brick").ingredient(Blocks.DEEPSLATE_BRICKS)));
        BOOKSHELVES.put("End Stone Brick", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("End Stone Brick").material("end_stone_brick").ingredient(Blocks.END_STONE_BRICKS)));
        BOOKSHELVES.put("Nether Brick", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Nether Brick").material("nether_brick").ingredient(Blocks.NETHER_BRICKS)));
        BOOKSHELVES.put("Polished Andesite", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Polished Andesite").material("polished_andesite").ingredient(Blocks.POLISHED_ANDESITE)));
        BOOKSHELVES.put("Polished Basalt", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Polished Basalt").material("polished_basalt").ingredient(Blocks.POLISHED_BASALT).texture("default", Registries.BLOCK.getId(Blocks.POLISHED_BASALT).withPrefixedPath("block/").withSuffixedPath("_top"))));
        BOOKSHELVES.put("Polished Blackstone", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Polished Blackstone").material("polished_blackstone").ingredient(Blocks.POLISHED_BLACKSTONE)));
        BOOKSHELVES.put("Polished Blackstone Brick", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Polished Blackstone Brick").material("polished_blackstone_brick").ingredient(Blocks.POLISHED_BLACKSTONE_BRICKS)));
        BOOKSHELVES.put("Polished Deepslate", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Polished Deepslate").material("polished_deepslate").ingredient(Blocks.POLISHED_DEEPSLATE)));
        BOOKSHELVES.put("Polished Diorite", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Polished Diorite").material("polished_diorite").ingredient(Blocks.POLISHED_DIORITE)));
        BOOKSHELVES.put("Polished Granite", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Polished Granite").material("polished_granite").ingredient(Blocks.POLISHED_GRANITE)));
        BOOKSHELVES.put("Polished Tuff", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Polished Tuff").material("polished_tuff").ingredient(Blocks.POLISHED_TUFF)));
        BOOKSHELVES.put("Prismarine", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Prismarine").material("prismarine").ingredient(Blocks.PRISMARINE)));
        BOOKSHELVES.put("Prismarine Brick", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Prismarine Brick").material("prismarine_brick").ingredient(Blocks.PRISMARINE_BRICKS)));
        BOOKSHELVES.put("Purpur", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Purpur").material("purpur").ingredient(Blocks.PURPUR_BLOCK)));
        BOOKSHELVES.put("Quartz Brick", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Quartz Brick").material("quartz_brick").ingredient(Blocks.QUARTZ_BRICKS)));
        BOOKSHELVES.put("Red Nether Brick", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Red Nether Brick").material("red_nether_brick").ingredient(Blocks.RED_NETHER_BRICKS)));
        BOOKSHELVES.put("Smooth Quartz", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Smooth Quartz").material("smooth_quartz").ingredient(Blocks.SMOOTH_QUARTZ).texture("default", Registries.BLOCK.getId(Blocks.QUARTZ_BLOCK).withPrefixedPath("block/").withSuffixedPath("_bottom"))));
        BOOKSHELVES.put("Smooth Stone", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Smooth Stone").material("smooth_stone").ingredient(Blocks.SMOOTH_STONE)));
        BOOKSHELVES.put("Stone Brick", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Stone Brick").material("stone_brick").ingredient(Blocks.STONE_BRICKS)));
        BOOKSHELVES.put("Tuff Brick", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Tuff Brick").material("tuff_brick").ingredient(Blocks.TUFF_BRICKS)));
        BOOKSHELVES.put("Warped Nether Brick", new GenericBookshelf(new ModBlock.ModBlockConfig().materialName("Warped Nether Brick").material("warped_nether_brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK).texture("default", WarpedNetherBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
    }

//    @Override
//    public List<MinekeaBlock> getCategoryBlocks() {
//        return BOOKSHELVES;
//    }

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
