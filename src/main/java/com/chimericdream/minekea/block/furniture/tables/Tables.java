package com.chimericdream.minekea.block.furniture.tables;

import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.function.Function;

import static com.chimericdream.minekea.item.MinekeaItemGroups.FURNITURE_ITEM_GROUP_KEY;

public class Tables implements MinekeaBlockCategory {
    public static final List<GenericTable> TABLES;

    static {
        TABLES = List.of(
            new GenericTable("Acacia", Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG),
            new GenericTable("Bamboo", Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_BLOCK),
            new GenericTable("Birch", Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG),
            new GenericTable("Cherry", Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG),
            new GenericTable("Crimson", Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM),
            new GenericTable("Dark Oak", Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG),
            new GenericTable("Jungle", Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG),
            new GenericTable("Mangrove", Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG),
            new GenericTable("Oak", Blocks.OAK_PLANKS, Blocks.OAK_LOG),
            new GenericTable("Spruce", Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG),
            new GenericTable("Warped", Blocks.WARPED_PLANKS, Blocks.WARPED_STEM),

            new GenericTable("Stripped Acacia", Blocks.ACACIA_PLANKS, Blocks.STRIPPED_ACACIA_LOG),
            new GenericTable("Stripped Bamboo", Blocks.BAMBOO_PLANKS, Blocks.STRIPPED_BAMBOO_BLOCK),
            new GenericTable("Stripped Birch", Blocks.BIRCH_PLANKS, Blocks.STRIPPED_BIRCH_LOG),
            new GenericTable("Stripped Cherry", Blocks.CHERRY_PLANKS, Blocks.STRIPPED_CHERRY_LOG),
            new GenericTable("Stripped Crimson", Blocks.CRIMSON_PLANKS, Blocks.STRIPPED_CRIMSON_STEM),
            new GenericTable("Stripped Dark Oak", Blocks.DARK_OAK_PLANKS, Blocks.STRIPPED_DARK_OAK_LOG),
            new GenericTable("Stripped Jungle", Blocks.JUNGLE_PLANKS, Blocks.STRIPPED_JUNGLE_LOG),
            new GenericTable("Stripped Mangrove", Blocks.MANGROVE_PLANKS, Blocks.STRIPPED_MANGROVE_LOG),
            new GenericTable("Stripped Oak", Blocks.OAK_PLANKS, Blocks.STRIPPED_OAK_LOG),
            new GenericTable("Stripped Spruce", Blocks.SPRUCE_PLANKS, Blocks.STRIPPED_SPRUCE_LOG),
            new GenericTable("Stripped Warped", Blocks.WARPED_PLANKS, Blocks.STRIPPED_WARPED_STEM)
        );
    }

    @Override
    public void registerBlocks() {
        TABLES.forEach(GenericTable::register);

        ItemGroupEvents.modifyEntriesEvent(FURNITURE_ITEM_GROUP_KEY).register(itemGroup -> {
            TABLES.forEach(itemGroup::add);
        });
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        TABLES.forEach(table -> table.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        TABLES.forEach(table -> table.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        TABLES.forEach(table -> table.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        TABLES.forEach(table -> table.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        TABLES.forEach(table -> table.configureTranslations(registryLookup, translationBuilder));
        translationBuilder.add(GenericTable.TOOLTIP_KEY, "Simple design, but somehow LACKing...");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TABLES.forEach(table -> table.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        TABLES.forEach(table -> table.configureItemModels(itemModelGenerator));
    }
}
