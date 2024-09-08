package com.chimericdream.minekea.block.furniture.pillows;

import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import static com.chimericdream.minekea.item.ItemGroups.FURNITURE_ITEM_GROUP_KEY;

public class Pillows implements MinekeaBlockCategory {
    public static final PillowBlock WHITE_PILLOW;
    public static final PillowBlock LIGHT_GRAY_PILLOW;
    public static final PillowBlock GRAY_PILLOW;
    public static final PillowBlock BLACK_PILLOW;
    public static final PillowBlock BROWN_PILLOW;
    public static final PillowBlock RED_PILLOW;
    public static final PillowBlock ORANGE_PILLOW;
    public static final PillowBlock YELLOW_PILLOW;
    public static final PillowBlock LIME_PILLOW;
    public static final PillowBlock GREEN_PILLOW;
    public static final PillowBlock CYAN_PILLOW;
    public static final PillowBlock LIGHT_BLUE_PILLOW;
    public static final PillowBlock BLUE_PILLOW;
    public static final PillowBlock PURPLE_PILLOW;
    public static final PillowBlock MAGENTA_PILLOW;
    public static final PillowBlock PINK_PILLOW;

    public static final List<PillowBlock> PILLOWS = new LinkedList<>();

    static {
        WHITE_PILLOW = new PillowBlock("white");
        LIGHT_GRAY_PILLOW = new PillowBlock("light_gray");
        GRAY_PILLOW = new PillowBlock("gray");
        BLACK_PILLOW = new PillowBlock("black");
        BROWN_PILLOW = new PillowBlock("brown");
        RED_PILLOW = new PillowBlock("red");
        ORANGE_PILLOW = new PillowBlock("orange");
        YELLOW_PILLOW = new PillowBlock("yellow");
        LIME_PILLOW = new PillowBlock("lime");
        GREEN_PILLOW = new PillowBlock("green");
        CYAN_PILLOW = new PillowBlock("cyan");
        LIGHT_BLUE_PILLOW = new PillowBlock("light_blue");
        BLUE_PILLOW = new PillowBlock("blue");
        PURPLE_PILLOW = new PillowBlock("purple");
        MAGENTA_PILLOW = new PillowBlock("magenta");
        PINK_PILLOW = new PillowBlock("pink");

        PILLOWS.addAll(List.of(
            WHITE_PILLOW,
            LIGHT_GRAY_PILLOW,
            GRAY_PILLOW,
            BLACK_PILLOW,
            BROWN_PILLOW,
            RED_PILLOW,
            ORANGE_PILLOW,
            YELLOW_PILLOW,
            LIME_PILLOW,
            GREEN_PILLOW,
            CYAN_PILLOW,
            LIGHT_BLUE_PILLOW,
            BLUE_PILLOW,
            PURPLE_PILLOW,
            MAGENTA_PILLOW,
            PINK_PILLOW
        ));
    }

    @Override
    public void registerBlocks() {
        for (PillowBlock block : PILLOWS) {
            block.register();
        }

        Function<FabricItemGroupEntries, Void> registerPillows = (FabricItemGroupEntries itemGroup) -> {
            PILLOWS.forEach(itemGroup::add);

            return null;
        };

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS).register(registerPillows::apply);
        ItemGroupEvents.modifyEntriesEvent(FURNITURE_ITEM_GROUP_KEY).register(registerPillows::apply);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        PILLOWS.forEach(pillow -> pillow.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        PILLOWS.forEach(pillow -> pillow.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        PILLOWS.forEach(pillow -> pillow.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        PILLOWS.forEach(pillow -> pillow.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        PILLOWS.forEach(pillow -> pillow.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        PILLOWS.forEach(pillow -> pillow.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        PILLOWS.forEach(pillow -> pillow.configureItemModels(itemModelGenerator));
    }
}
