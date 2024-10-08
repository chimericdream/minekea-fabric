package com.chimericdream.minekea.block.furniture.trapdoors;

import com.chimericdream.lib.blocks.ModBlock;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
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
        BOOKSHELF_TRAPDOORS.put("acacia", new GenericBookshelfTrapdoor(BlockSetType.ACACIA, new ModBlock.Config().material("acacia").materialName("Acacia").ingredient(Bookshelves.BOOKSHELVES.get("acacia")).ingredient("planks", Blocks.ACACIA_PLANKS)));
        BOOKSHELF_TRAPDOORS.put("bamboo", new GenericBookshelfTrapdoor(BlockSetType.BAMBOO, new ModBlock.Config().material("bamboo").materialName("Bamboo").ingredient(Bookshelves.BOOKSHELVES.get("bamboo")).ingredient("planks", Blocks.BAMBOO_PLANKS)));
        BOOKSHELF_TRAPDOORS.put("birch", new GenericBookshelfTrapdoor(BlockSetType.BIRCH, new ModBlock.Config().material("birch").materialName("Birch").ingredient(Bookshelves.BOOKSHELVES.get("birch")).ingredient("planks", Blocks.BIRCH_PLANKS)));
        BOOKSHELF_TRAPDOORS.put("cherry", new GenericBookshelfTrapdoor(BlockSetType.CHERRY, new ModBlock.Config().material("cherry").materialName("Cherry").ingredient(Bookshelves.BOOKSHELVES.get("cherry")).ingredient("planks", Blocks.CHERRY_PLANKS)));
        BOOKSHELF_TRAPDOORS.put("crimson", new GenericBookshelfTrapdoor(BlockSetType.CRIMSON, new ModBlock.Config().material("crimson").materialName("Crimson").ingredient(Bookshelves.BOOKSHELVES.get("crimson")).ingredient("planks", Blocks.CRIMSON_PLANKS)));
        BOOKSHELF_TRAPDOORS.put("dark_oak", new GenericBookshelfTrapdoor(BlockSetType.DARK_OAK, new ModBlock.Config().material("dark_oak").materialName("Dark Oak").ingredient(Bookshelves.BOOKSHELVES.get("dark_oak")).ingredient("planks", Blocks.DARK_OAK_PLANKS)));
        BOOKSHELF_TRAPDOORS.put("jungle", new GenericBookshelfTrapdoor(BlockSetType.JUNGLE, new ModBlock.Config().material("jungle").materialName("Jungle").ingredient(Bookshelves.BOOKSHELVES.get("jungle")).ingredient("planks", Blocks.JUNGLE_PLANKS)));
        BOOKSHELF_TRAPDOORS.put("mangrove", new GenericBookshelfTrapdoor(BlockSetType.MANGROVE, new ModBlock.Config().material("mangrove").materialName("Mangrove").ingredient(Bookshelves.BOOKSHELVES.get("mangrove")).ingredient("planks", Blocks.MANGROVE_PLANKS)));
        BOOKSHELF_TRAPDOORS.put("oak", new GenericBookshelfTrapdoor(BlockSetType.OAK, new ModBlock.Config().material("oak").materialName("Oak").ingredient(Blocks.BOOKSHELF).ingredient("planks", Blocks.OAK_PLANKS)));
        BOOKSHELF_TRAPDOORS.put("spruce", new GenericBookshelfTrapdoor(BlockSetType.SPRUCE, new ModBlock.Config().material("spruce").materialName("Spruce").ingredient(Bookshelves.BOOKSHELVES.get("spruce")).ingredient("planks", Blocks.SPRUCE_PLANKS)));
        BOOKSHELF_TRAPDOORS.put("warped", new GenericBookshelfTrapdoor(BlockSetType.WARPED, new ModBlock.Config().material("warped").materialName("Warped").ingredient(Bookshelves.BOOKSHELVES.get("warped")).ingredient("planks", Blocks.WARPED_PLANKS)));
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
