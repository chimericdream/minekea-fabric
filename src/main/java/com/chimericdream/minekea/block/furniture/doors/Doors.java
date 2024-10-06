package com.chimericdream.minekea.block.furniture.doors;

import com.chimericdream.lib.blocks.ModBlock;
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
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;

public class Doors implements MinekeaBlockCategory {
    public static final Map<String, GenericBookshelfDoor> BOOKSHELF_DOORS = new LinkedHashMap<>();

    static {
        BOOKSHELF_DOORS.put("Acacia", new GenericBookshelfDoor(BlockSetType.ACACIA, new ModBlock.ModBlockConfig().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS)));
        BOOKSHELF_DOORS.put("Bamboo", new GenericBookshelfDoor(BlockSetType.BAMBOO, new ModBlock.ModBlockConfig().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS)));
        BOOKSHELF_DOORS.put("Birch", new GenericBookshelfDoor(BlockSetType.BIRCH, new ModBlock.ModBlockConfig().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS)));
        BOOKSHELF_DOORS.put("Cherry", new GenericBookshelfDoor(BlockSetType.CHERRY, new ModBlock.ModBlockConfig().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS)));
        BOOKSHELF_DOORS.put("Crimson", new GenericBookshelfDoor(BlockSetType.CRIMSON, new ModBlock.ModBlockConfig().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS)));
        BOOKSHELF_DOORS.put("Dark Oak", new GenericBookshelfDoor(BlockSetType.DARK_OAK, new ModBlock.ModBlockConfig().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS)));
        BOOKSHELF_DOORS.put("Jungle", new GenericBookshelfDoor(BlockSetType.JUNGLE, new ModBlock.ModBlockConfig().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS)));
        BOOKSHELF_DOORS.put("Mangrove", new GenericBookshelfDoor(BlockSetType.MANGROVE, new ModBlock.ModBlockConfig().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS)));
        BOOKSHELF_DOORS.put("Oak", new GenericBookshelfDoor(BlockSetType.OAK, new ModBlock.ModBlockConfig().material("oak").materialName("Oak").ingredient(Blocks.OAK_PLANKS)));
        BOOKSHELF_DOORS.put("Spruce", new GenericBookshelfDoor(BlockSetType.SPRUCE, new ModBlock.ModBlockConfig().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS)));
        BOOKSHELF_DOORS.put("Warped", new GenericBookshelfDoor(BlockSetType.WARPED, new ModBlock.ModBlockConfig().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS)));
    }

    @Override
    public void registerBlocks() {
        BOOKSHELF_DOORS.forEach((key, door) -> door.register());

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(itemGroup -> BOOKSHELF_DOORS.forEach((key, door) -> itemGroup.add(door)));
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        BOOKSHELF_DOORS.forEach((key, door) -> door.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        BOOKSHELF_DOORS.forEach((key, door) -> door.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        BOOKSHELF_DOORS.forEach((key, door) -> door.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        BOOKSHELF_DOORS.forEach((key, door) -> door.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        BOOKSHELF_DOORS.forEach((key, door) -> door.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BOOKSHELF_DOORS.forEach((key, door) -> door.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BOOKSHELF_DOORS.forEach((key, door) -> door.configureItemModels(itemModelGenerator));
    }
}
