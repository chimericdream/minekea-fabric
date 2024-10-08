package com.chimericdream.minekea.block.furniture.shutters;

import com.chimericdream.lib.blocks.BlockConfig;
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

import static com.chimericdream.minekea.item.MinekeaItemGroups.FURNITURE_ITEM_GROUP_KEY;

public class Shutters implements MinekeaBlockCategory {
    public static final Map<String, ShutterBlock> SHUTTERS = new LinkedHashMap<>();
    public static final Map<String, OpenShutterHalf> OPEN_SHUTTER_HALVES = new LinkedHashMap<>();

    static {
        SHUTTERS.put("acacia", new ShutterBlock(BlockSetType.ACACIA, new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()));
        SHUTTERS.put("bamboo", new ShutterBlock(BlockSetType.BAMBOO, new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()));
        SHUTTERS.put("birch", new ShutterBlock(BlockSetType.BIRCH, new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()));
        SHUTTERS.put("cherry", new ShutterBlock(BlockSetType.CHERRY, new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()));
        SHUTTERS.put("crimson", new ShutterBlock(BlockSetType.CRIMSON, new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)));
        SHUTTERS.put("dark_oak", new ShutterBlock(BlockSetType.DARK_OAK, new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()));
        SHUTTERS.put("jungle", new ShutterBlock(BlockSetType.JUNGLE, new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()));
        SHUTTERS.put("mangrove", new ShutterBlock(BlockSetType.MANGROVE, new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()));
        SHUTTERS.put("oak", new ShutterBlock(BlockSetType.OAK, new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()));
        SHUTTERS.put("spruce", new ShutterBlock(BlockSetType.SPRUCE, new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()));
        SHUTTERS.put("warped", new ShutterBlock(BlockSetType.WARPED, new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)));

        SHUTTERS.put("stripped_acacia", new ShutterBlock(BlockSetType.ACACIA, new BlockConfig().material("stripped_acacia").materialName("Stripped Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()));
        SHUTTERS.put("stripped_bamboo", new ShutterBlock(BlockSetType.BAMBOO, new BlockConfig().material("stripped_bamboo").materialName("Stripped Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()));
        SHUTTERS.put("stripped_birch", new ShutterBlock(BlockSetType.BIRCH, new BlockConfig().material("stripped_birch").materialName("Stripped Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()));
        SHUTTERS.put("stripped_cherry", new ShutterBlock(BlockSetType.CHERRY, new BlockConfig().material("stripped_cherry").materialName("Stripped Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()));
        SHUTTERS.put("stripped_crimson", new ShutterBlock(BlockSetType.CRIMSON, new BlockConfig().material("stripped_crimson").materialName("Stripped Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)));
        SHUTTERS.put("stripped_dark_oak", new ShutterBlock(BlockSetType.DARK_OAK, new BlockConfig().material("stripped_dark_oak").materialName("Stripped Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()));
        SHUTTERS.put("stripped_jungle", new ShutterBlock(BlockSetType.JUNGLE, new BlockConfig().material("stripped_jungle").materialName("Stripped Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()));
        SHUTTERS.put("stripped_mangrove", new ShutterBlock(BlockSetType.MANGROVE, new BlockConfig().material("stripped_mangrove").materialName("Stripped Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()));
        SHUTTERS.put("stripped_oak", new ShutterBlock(BlockSetType.OAK, new BlockConfig().material("stripped_oak").materialName("Stripped Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()));
        SHUTTERS.put("stripped_spruce", new ShutterBlock(BlockSetType.SPRUCE, new BlockConfig().material("stripped_spruce").materialName("Stripped Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()));
        SHUTTERS.put("stripped_warped", new ShutterBlock(BlockSetType.WARPED, new BlockConfig().material("stripped_warped").materialName("Stripped Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)));

        OPEN_SHUTTER_HALVES.put("acacia", new OpenShutterHalf(BlockSetType.ACACIA, new BlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("bamboo", new OpenShutterHalf(BlockSetType.BAMBOO, new BlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()));
        OPEN_SHUTTER_HALVES.put("birch", new OpenShutterHalf(BlockSetType.BIRCH, new BlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("cherry", new OpenShutterHalf(BlockSetType.CHERRY, new BlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("crimson", new OpenShutterHalf(BlockSetType.CRIMSON, new BlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)));
        OPEN_SHUTTER_HALVES.put("dark_oak", new OpenShutterHalf(BlockSetType.DARK_OAK, new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("jungle", new OpenShutterHalf(BlockSetType.JUNGLE, new BlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("mangrove", new OpenShutterHalf(BlockSetType.MANGROVE, new BlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("oak", new OpenShutterHalf(BlockSetType.OAK, new BlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("spruce", new OpenShutterHalf(BlockSetType.SPRUCE, new BlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("warped", new OpenShutterHalf(BlockSetType.WARPED, new BlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM)));

        OPEN_SHUTTER_HALVES.put("stripped_acacia", new OpenShutterHalf(BlockSetType.ACACIA, new BlockConfig().material("stripped_acacia").materialName("Stripped Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_bamboo", new OpenShutterHalf(BlockSetType.BAMBOO, new BlockConfig().material("stripped_bamboo").materialName("Stripped Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_birch", new OpenShutterHalf(BlockSetType.BIRCH, new BlockConfig().material("stripped_birch").materialName("Stripped Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_cherry", new OpenShutterHalf(BlockSetType.CHERRY, new BlockConfig().material("stripped_cherry").materialName("Stripped Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_crimson", new OpenShutterHalf(BlockSetType.CRIMSON, new BlockConfig().material("stripped_crimson").materialName("Stripped Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)));
        OPEN_SHUTTER_HALVES.put("stripped_dark_oak", new OpenShutterHalf(BlockSetType.DARK_OAK, new BlockConfig().material("stripped_dark_oak").materialName("Stripped Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_jungle", new OpenShutterHalf(BlockSetType.JUNGLE, new BlockConfig().material("stripped_jungle").materialName("Stripped Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_mangrove", new OpenShutterHalf(BlockSetType.MANGROVE, new BlockConfig().material("stripped_mangrove").materialName("Stripped Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_oak", new OpenShutterHalf(BlockSetType.OAK, new BlockConfig().material("stripped_oak").materialName("Stripped Oak").ingredient(Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_spruce", new OpenShutterHalf(BlockSetType.SPRUCE, new BlockConfig().material("stripped_spruce").materialName("Stripped Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()));
        OPEN_SHUTTER_HALVES.put("stripped_warped", new OpenShutterHalf(BlockSetType.WARPED, new BlockConfig().material("stripped_warped").materialName("Stripped Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)));
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
