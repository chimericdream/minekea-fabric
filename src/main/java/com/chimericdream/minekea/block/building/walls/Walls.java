package com.chimericdream.minekea.block.building.walls;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
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

public class Walls implements MinekeaBlockCategory {
    public static final List<MinekeaBlock> WALLS = new ArrayList<>();

    static {
        WALLS.add(new GenericWallBlock("Basalt Brick", "basalt_bricks", false, BuildingBlocks.BASALT_BRICKS_BLOCK, BasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        WALLS.add(new GenericWallBlock("Cracked Basalt Brick", "cracked_basalt_bricks", false, BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK, CrackedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        WALLS.add(new GenericWallBlock("Crimson Basalt Brick", "crimson_basalt_bricks", false, BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK, CrimsonBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        WALLS.add(new GenericWallBlock("Mossy Basalt Brick", "mossy_basalt_bricks", false, BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK, MossyBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        WALLS.add(new GenericWallBlock("Warped Basalt Brick", "warped_basalt_bricks", false, BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK, WarpedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
        WALLS.add(new GenericWallBlock("Warped Nether Brick", "warped_nether_bricks", false, BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK, WarpedNetherBricksBlock.BLOCK_ID.withPrefixedPath("block/")));
    }

    @Override
    public void registerBlocks() {
        WALLS.forEach(MinekeaBlock::register);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        WALLS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        WALLS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        WALLS.forEach(block -> block.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        WALLS.forEach(block -> block.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        WALLS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        WALLS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        WALLS.forEach(block -> block.configureItemModels(itemModelGenerator));
    }

    @Override
    public void generateTextures() {
        WALLS.forEach(MinekeaBlock::generateTextures);
    }
}
