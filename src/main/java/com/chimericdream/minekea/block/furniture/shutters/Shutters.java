package com.chimericdream.minekea.block.furniture.shutters;

import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

import static com.chimericdream.minekea.item.ItemGroups.FURNITURE_ITEM_GROUP_KEY;

public class Shutters implements MinekeaBlockCategory {
    public static final Map<String, ShutterBlock> SHUTTERS = new LinkedHashMap<>();
    public static final Map<String, OpenShutterHalf> OPEN_SHUTTER_HALVES = new LinkedHashMap<>();

    static {
        SHUTTERS.put("Acacia", new ShutterBlock(BlockSetType.ACACIA, "Acacia", Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG));
        SHUTTERS.put("Birch", new ShutterBlock(BlockSetType.BIRCH, "Birch", Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG));
        SHUTTERS.put("Cherry", new ShutterBlock(BlockSetType.CHERRY, "Cherry", Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG));
        SHUTTERS.put("Crimson", new ShutterBlock(BlockSetType.CRIMSON, "Crimson", Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM, false));
        SHUTTERS.put("Dark Oak", new ShutterBlock(BlockSetType.DARK_OAK, "Dark Oak", Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG));
        SHUTTERS.put("Jungle", new ShutterBlock(BlockSetType.JUNGLE, "Jungle", Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG));
        SHUTTERS.put("Mangrove", new ShutterBlock(BlockSetType.MANGROVE, "Mangrove", Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG));
        SHUTTERS.put("Oak", new ShutterBlock(BlockSetType.OAK, "Oak", Blocks.OAK_PLANKS, Blocks.OAK_LOG));
        SHUTTERS.put("Spruce", new ShutterBlock(BlockSetType.SPRUCE, "Spruce", Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG));
        SHUTTERS.put("Warped", new ShutterBlock(BlockSetType.WARPED, "Warped", Blocks.WARPED_PLANKS, Blocks.WARPED_STEM, false));

        OPEN_SHUTTER_HALVES.put("Acacia", new OpenShutterHalf(BlockSetType.ACACIA, "Acacia", Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG));
        OPEN_SHUTTER_HALVES.put("Birch", new OpenShutterHalf(BlockSetType.BIRCH, "Birch", Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG));
        OPEN_SHUTTER_HALVES.put("Cherry", new OpenShutterHalf(BlockSetType.CHERRY, "Cherry", Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG));
        OPEN_SHUTTER_HALVES.put("Crimson", new OpenShutterHalf(BlockSetType.CRIMSON, "Crimson", Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM, false));
        OPEN_SHUTTER_HALVES.put("Dark Oak", new OpenShutterHalf(BlockSetType.DARK_OAK, "Dark Oak", Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG));
        OPEN_SHUTTER_HALVES.put("Jungle", new OpenShutterHalf(BlockSetType.JUNGLE, "Jungle", Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG));
        OPEN_SHUTTER_HALVES.put("Mangrove", new OpenShutterHalf(BlockSetType.MANGROVE, "Mangrove", Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG));
        OPEN_SHUTTER_HALVES.put("Oak", new OpenShutterHalf(BlockSetType.OAK, "Oak", Blocks.OAK_PLANKS, Blocks.OAK_LOG));
        OPEN_SHUTTER_HALVES.put("Spruce", new OpenShutterHalf(BlockSetType.SPRUCE, "Spruce", Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG));
        OPEN_SHUTTER_HALVES.put("Warped", new OpenShutterHalf(BlockSetType.WARPED, "Warped", Blocks.WARPED_PLANKS, Blocks.WARPED_STEM, false));
    }

    @Override
    public void registerBlocks() {
        SHUTTERS.forEach((key, shutter) -> shutter.register());
        OPEN_SHUTTER_HALVES.forEach((key, shutter) -> shutter.register());

        ItemGroupEvents.modifyEntriesEvent(FURNITURE_ITEM_GROUP_KEY).register(itemGroup -> SHUTTERS.forEach((key, shutter) -> itemGroup.add(shutter)));
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        SHUTTERS.forEach((key, shutter) -> shutter.configureBlockTags(registryLookup, getBuilder));
        OPEN_SHUTTER_HALVES.forEach((key, shutter) -> shutter.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        SHUTTERS.forEach((key, shutter) -> shutter.configureItemTags(registryLookup, getBuilder));
        OPEN_SHUTTER_HALVES.forEach((key, shutter) -> shutter.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        SHUTTERS.forEach((key, shutter) -> shutter.configureRecipes(exporter));
        OPEN_SHUTTER_HALVES.forEach((key, shutter) -> shutter.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        SHUTTERS.forEach((key, shutter) -> shutter.configureBlockLootTables(registryLookup, generator));
        OPEN_SHUTTER_HALVES.forEach((key, shutter) -> shutter.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        SHUTTERS.forEach((key, shutter) -> shutter.configureTranslations(registryLookup, translationBuilder));
        OPEN_SHUTTER_HALVES.forEach((key, shutter) -> shutter.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        SHUTTERS.forEach((key, shutter) -> shutter.configureBlockStateModels(blockStateModelGenerator));
        OPEN_SHUTTER_HALVES.forEach((key, shutter) -> shutter.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        SHUTTERS.forEach((key, shutter) -> shutter.configureItemModels(itemModelGenerator));
        OPEN_SHUTTER_HALVES.forEach((key, shutter) -> shutter.configureItemModels(itemModelGenerator));
    }
}
