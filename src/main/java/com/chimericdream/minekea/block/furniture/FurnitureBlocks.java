package com.chimericdream.minekea.block.furniture;

import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
import com.chimericdream.minekea.block.furniture.pillows.Pillows;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FurnitureBlocks implements MinekeaBlockCategory {
    //    public static Bookshelves BOOKSHELVES;
    public static DisplayCases DISPLAY_CASES;
    //    public static Doors DOORS;
    public static Pillows PILLOWS;
//    public static Seats SEATS;
//    public static Shelves SHELVES;
//    public static Shutters SHUTTERS;
//    public static Tables TABLES;
//    public static Trapdoors TRAPDOORS;

    private static final List<MinekeaBlockCategory> BLOCK_GROUPS = new ArrayList<>();

    static {
//        MinekeaConfig config = ConfigManager.getConfig();

//        if (config.enableBookshelves) {
//            BOOKSHELVES = new Bookshelves();
//            BLOCK_GROUPS.add(BOOKSHELVES);
//        }

//        if (config.enableDisplayCases) {
        DISPLAY_CASES = new DisplayCases();
        BLOCK_GROUPS.add(DISPLAY_CASES);
//        }

//        if (config.enableDoors) {
//            DOORS = new Doors();
//            BLOCK_GROUPS.add(DOORS);
//        }
//
//        if (config.enablePillows) {
        PILLOWS = new Pillows();
        BLOCK_GROUPS.add(PILLOWS);
//        }
//
//        if (config.enableChairs || config.enableStools) {
//            SEATS = new Seats();
//            BLOCK_GROUPS.add(SEATS);
//        }
//
//        if (config.enableShelves) {
//            SHELVES = new Shelves();
//            BLOCK_GROUPS.add(SHELVES);
//        }
//
//        if (config.enableShutters) {
//            SHUTTERS = new Shutters();
//            BLOCK_GROUPS.add(SHUTTERS);
//        }
//
//        if (config.enableTables) {
//            TABLES = new Tables();
//            BLOCK_GROUPS.add(TABLES);
//        }
//
//        if (config.enableTrapdoors) {
//            TRAPDOORS = new Trapdoors();
//            BLOCK_GROUPS.add(TRAPDOORS);
//        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BLOCK_GROUPS.forEach(MinekeaBlockCategory::initializeClient);
    }

    @Override
    public void registerBlocks() {
        BLOCK_GROUPS.forEach(MinekeaBlockCategory::registerBlocks);
    }

    @Override
    public void registerBlockEntities() {
        BLOCK_GROUPS.forEach(MinekeaBlockCategory::registerBlockEntities);
    }

    @Override
    public void registerEntities() {
        BLOCK_GROUPS.forEach(MinekeaBlockCategory::registerEntities);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        BLOCK_GROUPS.forEach(group -> group.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        BLOCK_GROUPS.forEach(group -> group.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        BLOCK_GROUPS.forEach(group -> group.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(BlockLootTableGenerator generator) {
        BLOCK_GROUPS.forEach(group -> group.configureBlockLootTables(generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        BLOCK_GROUPS.forEach(group -> group.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BLOCK_GROUPS.forEach(group -> group.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BLOCK_GROUPS.forEach(group -> group.configureItemModels(itemModelGenerator));
    }
}
