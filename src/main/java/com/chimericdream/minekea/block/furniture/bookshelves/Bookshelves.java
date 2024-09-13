package com.chimericdream.minekea.block.furniture.bookshelves;

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
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class Bookshelves implements MinekeaBlockCategory {
    public static final Map<String, GenericBookshelf> BOOKSHELVES = new LinkedHashMap<>();

    static {
        BOOKSHELVES.put("Acacia", new GenericBookshelf("Acacia", Blocks.ACACIA_PLANKS));
        BOOKSHELVES.put("Birch", new GenericBookshelf("Birch", Blocks.BIRCH_PLANKS));
        BOOKSHELVES.put("Cherry", new GenericBookshelf("Cherry", Blocks.CHERRY_PLANKS));
        BOOKSHELVES.put("Crimson", new GenericBookshelf("Crimson", Blocks.CRIMSON_PLANKS, false));
        BOOKSHELVES.put("Dark Oak", new GenericBookshelf("Dark Oak", Blocks.DARK_OAK_PLANKS));
        BOOKSHELVES.put("Jungle", new GenericBookshelf("Jungle", Blocks.JUNGLE_PLANKS));
        BOOKSHELVES.put("Mangrove", new GenericBookshelf("Mangrove", Blocks.MANGROVE_PLANKS));
        BOOKSHELVES.put("Spruce", new GenericBookshelf("Spruce", Blocks.SPRUCE_PLANKS));
        BOOKSHELVES.put("Warped", new GenericBookshelf("Warped", Blocks.WARPED_PLANKS, false));
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
