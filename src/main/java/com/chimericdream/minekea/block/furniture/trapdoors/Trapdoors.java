package com.chimericdream.minekea.block.furniture.trapdoors;

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

public class Trapdoors implements MinekeaBlockCategory {
    public static final Map<String, GenericBookshelfTrapdoor> BOOKSHELF_TRAPDOORS = new LinkedHashMap<>();

    static {
        BOOKSHELF_TRAPDOORS.put("Acacia", new GenericBookshelfTrapdoor(BlockSetType.ACACIA, "Acacia", Blocks.ACACIA_PLANKS));
        BOOKSHELF_TRAPDOORS.put("Birch", new GenericBookshelfTrapdoor(BlockSetType.BIRCH, "Birch", Blocks.BIRCH_PLANKS));
        BOOKSHELF_TRAPDOORS.put("Cherry", new GenericBookshelfTrapdoor(BlockSetType.CHERRY, "Cherry", Blocks.CHERRY_PLANKS));
        BOOKSHELF_TRAPDOORS.put("Crimson", new GenericBookshelfTrapdoor(BlockSetType.CRIMSON, "Crimson", Blocks.CRIMSON_PLANKS));
        BOOKSHELF_TRAPDOORS.put("Dark Oak", new GenericBookshelfTrapdoor(BlockSetType.DARK_OAK, "Dark Oak", Blocks.DARK_OAK_PLANKS));
        BOOKSHELF_TRAPDOORS.put("Jungle", new GenericBookshelfTrapdoor(BlockSetType.JUNGLE, "Jungle", Blocks.JUNGLE_PLANKS));
        BOOKSHELF_TRAPDOORS.put("Mangrove", new GenericBookshelfTrapdoor(BlockSetType.MANGROVE, "Mangrove", Blocks.MANGROVE_PLANKS));
        BOOKSHELF_TRAPDOORS.put("Oak", new GenericBookshelfTrapdoor(BlockSetType.OAK, "Oak", Blocks.OAK_PLANKS));
        BOOKSHELF_TRAPDOORS.put("Spruce", new GenericBookshelfTrapdoor(BlockSetType.SPRUCE, "Spruce", Blocks.SPRUCE_PLANKS));
        BOOKSHELF_TRAPDOORS.put("Warped", new GenericBookshelfTrapdoor(BlockSetType.WARPED, "Warped", Blocks.WARPED_PLANKS));
    }

    @Override
    public void registerBlocks() {
        BOOKSHELF_TRAPDOORS.forEach((key, door) -> door.register());

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(itemGroup -> BOOKSHELF_TRAPDOORS.forEach((key, door) -> itemGroup.add(door)));
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        BOOKSHELF_TRAPDOORS.forEach((key, door) -> door.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        BOOKSHELF_TRAPDOORS.forEach((key, door) -> door.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        BOOKSHELF_TRAPDOORS.forEach((key, door) -> door.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        BOOKSHELF_TRAPDOORS.forEach((key, door) -> door.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        BOOKSHELF_TRAPDOORS.forEach((key, door) -> door.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BOOKSHELF_TRAPDOORS.forEach((key, door) -> door.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BOOKSHELF_TRAPDOORS.forEach((key, door) -> door.configureItemModels(itemModelGenerator));
    }
}
