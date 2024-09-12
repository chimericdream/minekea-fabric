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

import java.util.List;
import java.util.function.Function;

public class Bookshelves implements MinekeaBlockCategory {
    public static final List<GenericBookshelf> BOOKSHELVES;

    static {
        BOOKSHELVES = List.of(
            new GenericBookshelf("Acacia", Blocks.ACACIA_PLANKS),
            new GenericBookshelf("Birch", Blocks.BIRCH_PLANKS),
            new GenericBookshelf("Cherry", Blocks.CHERRY_PLANKS),
            new GenericBookshelf("Crimson", Blocks.CRIMSON_PLANKS, false),
            new GenericBookshelf("Dark Oak", Blocks.DARK_OAK_PLANKS),
            new GenericBookshelf("Jungle", Blocks.JUNGLE_PLANKS),
            new GenericBookshelf("Mangrove", Blocks.MANGROVE_PLANKS),
            new GenericBookshelf("Spruce", Blocks.SPRUCE_PLANKS),
            new GenericBookshelf("Warped", Blocks.WARPED_PLANKS, false)
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        BOOKSHELVES.forEach(GenericBookshelf::register);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(itemGroup -> BOOKSHELVES.forEach(itemGroup::add));
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        BOOKSHELVES.forEach(bookshelf -> bookshelf.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        BOOKSHELVES.forEach(bookshelf -> bookshelf.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        BOOKSHELVES.forEach(bookshelf -> bookshelf.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        BOOKSHELVES.forEach(bookshelf -> bookshelf.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        BOOKSHELVES.forEach(bookshelf -> bookshelf.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BOOKSHELVES.forEach(bookshelf -> bookshelf.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BOOKSHELVES.forEach(bookshelf -> bookshelf.configureItemModels(itemModelGenerator));
    }
}
