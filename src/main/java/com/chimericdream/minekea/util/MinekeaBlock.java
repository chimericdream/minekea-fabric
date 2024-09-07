package com.chimericdream.minekea.util;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.registry.RegistryWrapper;

public interface MinekeaBlock {
    void register();

    default void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup) {
    }

    default void configureItemTags(RegistryWrapper.WrapperLookup registryLookup) {
    }

    default void configureRecipes(RecipeExporter exporter) {
    }

    default void configureLootTables(RegistryWrapper.WrapperLookup registryLookup) {
    }

    default void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
    }

    default void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    }

    default void configureItemModels(ItemModelGenerator itemModelGenerator) {
    }
}
