package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class Bookshelves implements MinekeaBlockCategory {
    public static final Map<String, GenericBookshelf> BOOKSHELVES = new LinkedHashMap<>();

    static {
        BOOKSHELVES.put("Acacia", new GenericBookshelf("Acacia", "acacia", true, Blocks.ACACIA_PLANKS));
        BOOKSHELVES.put("Birch", new GenericBookshelf("Birch", "birch", true, Blocks.BIRCH_PLANKS));
        BOOKSHELVES.put("Cherry", new GenericBookshelf("Cherry", "cherry", true, Blocks.CHERRY_PLANKS));
        BOOKSHELVES.put("Crimson", new GenericBookshelf("Crimson", "crimson", false, Blocks.CRIMSON_PLANKS));
        BOOKSHELVES.put("Dark Oak", new GenericBookshelf("Dark Oak", "dark_oak", true, Blocks.DARK_OAK_PLANKS));
        BOOKSHELVES.put("Jungle", new GenericBookshelf("Jungle", "jungle", true, Blocks.JUNGLE_PLANKS));
        BOOKSHELVES.put("Mangrove", new GenericBookshelf("Mangrove", "mangrove", true, Blocks.MANGROVE_PLANKS));
        BOOKSHELVES.put("Spruce", new GenericBookshelf("Spruce", "spruce", true, Blocks.SPRUCE_PLANKS));
        BOOKSHELVES.put("Warped", new GenericBookshelf("Warped", "warped", false, Blocks.WARPED_PLANKS));

        BOOKSHELVES.put("Bone", new GenericBookshelf("Bone", "bone", false, Blocks.BONE_BLOCK, Registries.BLOCK.getId(Blocks.BONE_BLOCK).withPrefixedPath("block/").withSuffixedPath("_side")));
        BOOKSHELVES.put("Dark Prismarine", new GenericBookshelf("Dark Prismarine", "dark_prismarine", false, Blocks.DARK_PRISMARINE));
        BOOKSHELVES.put("Deepslate Brick", new GenericBookshelf("Deepslate Brick", "deepslate_brick", false, Blocks.DEEPSLATE_BRICKS));
        BOOKSHELVES.put("End Stone Brick", new GenericBookshelf("End Stone Brick", "end_stone_brick", false, Blocks.END_STONE_BRICKS));
        BOOKSHELVES.put("Nether Brick", new GenericBookshelf("Nether Brick", "nether_brick", false, Blocks.NETHER_BRICKS));
        BOOKSHELVES.put("Polished Andesite", new GenericBookshelf("Polished Andesite", "polished_andesite", false, Blocks.POLISHED_ANDESITE));
        BOOKSHELVES.put("Polished Basalt", new GenericBookshelf("Polished Basalt", "polished_basalt", false, Blocks.POLISHED_BASALT, Registries.BLOCK.getId(Blocks.POLISHED_BASALT).withPrefixedPath("block/").withSuffixedPath("_top")));
        BOOKSHELVES.put("Polished Blackstone", new GenericBookshelf("Polished Blackstone", "polished_blackstone", false, Blocks.POLISHED_BLACKSTONE));
        BOOKSHELVES.put("Polished Blackstone Brick", new GenericBookshelf("Polished Blackstone Brick", "polished_blackstone_brick", false, Blocks.POLISHED_BLACKSTONE_BRICKS));
        BOOKSHELVES.put("Polished Deepslate", new GenericBookshelf("Polished Deepslate", "polished_deepslate", false, Blocks.POLISHED_DEEPSLATE));
        BOOKSHELVES.put("Polished Diorite", new GenericBookshelf("Polished Diorite", "polished_diorite", false, Blocks.POLISHED_DIORITE));
        BOOKSHELVES.put("Polished Granite", new GenericBookshelf("Polished Granite", "polished_granite", false, Blocks.POLISHED_GRANITE));
        BOOKSHELVES.put("Polished Tuff", new GenericBookshelf("Polished Tuff", "polished_tuff", false, Blocks.POLISHED_TUFF));
        BOOKSHELVES.put("Prismarine", new GenericBookshelf("Prismarine", "prismarine", false, Blocks.PRISMARINE));
        BOOKSHELVES.put("Prismarine Brick", new GenericBookshelf("Prismarine Brick", "prismarine_brick", false, Blocks.PRISMARINE_BRICKS));
        BOOKSHELVES.put("Purpur", new GenericBookshelf("Purpur", "purpur", false, Blocks.PURPUR_BLOCK));
        BOOKSHELVES.put("Quartz Brick", new GenericBookshelf("Quartz Brick", "quartz_brick", false, Blocks.QUARTZ_BRICKS));
        BOOKSHELVES.put("Red Nether Brick", new GenericBookshelf("Red Nether Brick", "red_nether_brick", false, Blocks.RED_NETHER_BRICKS));
        BOOKSHELVES.put("Smooth Quartz", new GenericBookshelf("Smooth Quartz", "smooth_quartz", false, Blocks.SMOOTH_QUARTZ, Registries.BLOCK.getId(Blocks.QUARTZ_BLOCK).withPrefixedPath("block/").withSuffixedPath("_bottom")));
        BOOKSHELVES.put("Smooth Stone", new GenericBookshelf("Smooth Stone", "smooth_stone", false, Blocks.SMOOTH_STONE));
        BOOKSHELVES.put("Stone Brick", new GenericBookshelf("Stone Brick", "stone_brick", false, Blocks.STONE_BRICKS));
        BOOKSHELVES.put("Tuff Brick", new GenericBookshelf("Tuff Brick", "tuff_brick", false, Blocks.TUFF_BRICKS));
        BOOKSHELVES.put("Warped Nether Brick", new GenericBookshelf("Warped Nether Brick", "warped_nether_brick", false, BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK, WarpedNetherBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        BOOKSHELVES.forEach((key, bookshelf) -> bookshelf.register());

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(itemGroup -> BOOKSHELVES.forEach((key, bookshelf) -> itemGroup.add(bookshelf)));
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
