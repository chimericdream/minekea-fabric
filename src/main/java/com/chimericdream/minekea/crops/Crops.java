package com.chimericdream.minekea.crops;

import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.function.Function;

public class Crops implements MinekeaBlockCategory {
    public static final WarpedWartPlantBlock WARPED_WART_PLANT_BLOCK;
    public static final WarpedWartItem WARPED_WART_ITEM;

    static {
        WARPED_WART_PLANT_BLOCK = new WarpedWartPlantBlock(AbstractBlock.Settings.copy(Blocks.NETHER_WART));
        WARPED_WART_ITEM = new WarpedWartItem();
    }

    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), WARPED_WART_PLANT_BLOCK);
    }

    @Override
    public void registerBlocks() {
        WARPED_WART_PLANT_BLOCK.register();
        WARPED_WART_ITEM.register();

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
            .register((itemGroup) -> {
                itemGroup.add(WARPED_WART_ITEM);
            });
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        WARPED_WART_PLANT_BLOCK.configureBlockTags(registryLookup, getBuilder);
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        WARPED_WART_PLANT_BLOCK.configureItemTags(registryLookup, getBuilder);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        WARPED_WART_PLANT_BLOCK.configureRecipes(exporter);
    }

    @Override
    public void configureBlockLootTables(BlockLootTableGenerator generator) {
        WARPED_WART_PLANT_BLOCK.configureBlockLootTables(generator);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        WARPED_WART_PLANT_BLOCK.configureTranslations(registryLookup, translationBuilder);
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        WARPED_WART_PLANT_BLOCK.configureBlockStateModels(blockStateModelGenerator);
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        WARPED_WART_PLANT_BLOCK.configureItemModels(itemModelGenerator);
    }
}
