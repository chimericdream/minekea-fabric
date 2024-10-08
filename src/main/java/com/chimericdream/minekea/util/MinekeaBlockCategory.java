package com.chimericdream.minekea.util;

import com.chimericdream.lib.blocks.BlockDataGenerator;
import com.chimericdream.lib.blocks.RegisterableBlock;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.util.ModConfigurable;
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
    default List<Block> getCategoryBlocks() {
        return new ArrayList<>();
    }

    default void initializeClient() {
        getCategoryBlocks().forEach(block -> {
            if (((ModConfigurable) block).getConfig().isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        });
    }

    default void registerBlocks() {
        getCategoryBlocks().forEach(block -> ((RegisterableBlock) block).register());
    }

    default void registerBlockEntities() {
    }

    default void registerEntities() {
    }

    default void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getCategoryBlocks().forEach(block -> ((FabricBlockDataGenerator) block).configureBlockTags(registryLookup, getBuilder));
    }

    default void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        getCategoryBlocks().forEach(block -> ((FabricBlockDataGenerator) block).configureItemTags(registryLookup, getBuilder));
    }

    default void configureRecipes(RecipeExporter exporter) {
        getCategoryBlocks().forEach(block -> ((BlockDataGenerator) block).configureRecipes(exporter));
    }

    default void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        getCategoryBlocks().forEach(block -> ((BlockDataGenerator) block).configureBlockLootTables(registryLookup, generator));
    }

    default void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        getCategoryBlocks().forEach(block -> ((FabricBlockDataGenerator) block).configureTranslations(registryLookup, translationBuilder));
    }

    default void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        getCategoryBlocks().forEach(block -> ((BlockDataGenerator) block).configureBlockStateModels(blockStateModelGenerator));
    }

    default void configureItemModels(ItemModelGenerator itemModelGenerator) {
        getCategoryBlocks().forEach(block -> ((BlockDataGenerator) block).configureItemModels(itemModelGenerator));
    }

    default void generateTextures() {
        getCategoryBlocks().forEach(block -> ((BlockDataGenerator) block).generateTextures());
    }
}
