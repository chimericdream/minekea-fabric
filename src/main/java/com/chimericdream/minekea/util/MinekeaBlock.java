package com.chimericdream.minekea.util;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Function;

public interface MinekeaBlock {
    void register();

    default boolean isTranslucent() {
        return false;
    }

    default boolean isFlammable() {
        return false;
    }

    default void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
    }

    default void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
    }

    default void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
    }

    default void configureRecipes(RecipeExporter exporter) {
    }

    default void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
    }

    default void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    default void configureItemModels(ItemModelGenerator itemModelGenerator) {
    }

    default void generateTextures() {
    }
}
