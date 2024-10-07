package com.chimericdream.minekea.util;

import com.chimericdream.lib.blocks.ModBlock;
import com.chimericdream.lib.fabric.blocks.FabricModBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public interface MinekeaBlockCategory {
    default List<FabricModBlock> getCategoryBlocks() {
        return new ArrayList<>();
    }

    default void initializeClient() {
        getCategoryBlocks().forEach(block -> {
            if (block.config.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock((Block) block, RenderLayer.getTranslucent());
            }
        });
    }

    default void registerBlocks() {
        getCategoryBlocks().forEach(ModBlock::register);
    }

    default void registerBlockEntities() {
    }

    default void registerEntities() {
    }

    default void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getCategoryBlocks().forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
    }

    default void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        getCategoryBlocks().forEach(block -> block.configureItemTags(registryLookup, getBuilder));
    }

    default void configureRecipes(RecipeExporter exporter) {
        getCategoryBlocks().forEach(block -> block.configureRecipes(exporter));
    }

    default void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        getCategoryBlocks().forEach(block -> block.configureBlockLootTables(registryLookup, generator));
    }

    default void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        getCategoryBlocks().forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
    }

    default void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        getCategoryBlocks().forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
    }

    default void configureItemModels(ItemModelGenerator itemModelGenerator) {
        getCategoryBlocks().forEach(block -> block.configureItemModels(itemModelGenerator));
    }

    default void generateTextures() {
        getCategoryBlocks().forEach(ModBlock::generateTextures);
    }
}
