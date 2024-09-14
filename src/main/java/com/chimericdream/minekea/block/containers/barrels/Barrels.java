package com.chimericdream.minekea.block.containers.barrels;

import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.function.Function;

public class Barrels implements MinekeaBlockCategory {
    public static final List<GenericBarrel> ALL_BARRELS;

    public static final GenericBarrel ACACIA_BARREL;
    public static final GenericBarrel BIRCH_BARREL;
    public static final GenericBarrel CHERRY_BARREL;
    public static final GenericBarrel CRIMSON_BARREL;
    public static final GenericBarrel DARK_OAK_BARREL;
    public static final GenericBarrel JUNGLE_BARREL;
    public static final GenericBarrel MANGROVE_BARREL;
    public static final GenericBarrel SPRUCE_BARREL;
    public static final GenericBarrel WARPED_BARREL;

    static {
        ACACIA_BARREL = new GenericBarrel("Acacia", "acacia_planks", "stripped_acacia_log", Blocks.ACACIA_PLANKS, Blocks.ACACIA_SLAB);
        BIRCH_BARREL = new GenericBarrel("Birch", "birch_planks", "stripped_birch_log", Blocks.BIRCH_PLANKS, Blocks.BIRCH_SLAB);
        CHERRY_BARREL = new GenericBarrel("Cherry", "cherry_planks", "stripped_cherry_log", Blocks.CHERRY_PLANKS, Blocks.CHERRY_SLAB);
        CRIMSON_BARREL = new GenericBarrel("Crimson", "crimson_planks", "stripped_crimson_stem", Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_SLAB);
        DARK_OAK_BARREL = new GenericBarrel("Dark Oak", "dark_oak_planks", "stripped_dark_oak_log", Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_SLAB);
        JUNGLE_BARREL = new GenericBarrel("Jungle", "jungle_planks", "stripped_jungle_log", Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_SLAB);
        MANGROVE_BARREL = new GenericBarrel("Mangrove", "mangrove_planks", "stripped_mangrove_log", Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_SLAB);
        SPRUCE_BARREL = new GenericBarrel("Spruce", "spruce_planks", "stripped_spruce_log", Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_SLAB);
        WARPED_BARREL = new GenericBarrel("Warped", "warped_planks", "stripped_warped_stem", Blocks.WARPED_PLANKS, Blocks.WARPED_SLAB);

        ALL_BARRELS = List.of(
            ACACIA_BARREL,
            BIRCH_BARREL,
            CHERRY_BARREL,
            CRIMSON_BARREL,
            DARK_OAK_BARREL,
            JUNGLE_BARREL,
            MANGROVE_BARREL,
            SPRUCE_BARREL,
            WARPED_BARREL
        );
    }

    @Override
    public void registerBlocks() {
        ALL_BARRELS.forEach(GenericBarrel::register);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        ALL_BARRELS.forEach(barrel -> barrel.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        ALL_BARRELS.forEach(barrel -> barrel.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ALL_BARRELS.forEach(barrel -> barrel.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        ALL_BARRELS.forEach(barrel -> barrel.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        ALL_BARRELS.forEach(barrel -> barrel.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        ALL_BARRELS.forEach(barrel -> barrel.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        ALL_BARRELS.forEach(barrel -> barrel.configureItemModels(itemModelGenerator));
    }

    @Override
    public void generateTextures() {
        ALL_BARRELS.forEach(GenericBarrel::generateTextures);

        GenericBarrel.generateTextures("stripped_oak_log", "oak_planks", Registries.BLOCK.getId(Blocks.BARREL));
    }
}
