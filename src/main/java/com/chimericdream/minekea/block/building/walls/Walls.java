package com.chimericdream.minekea.block.building.walls;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
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
    public static final List<GenericWallBlock> WALLS = new ArrayList<>();

    static {
        WALLS.add(new GenericWallBlock(new BlockConfig().material("basalt_bricks").materialName("Basalt Brick").ingredient(BuildingBlocks.BASALT_BRICKS_BLOCK).texture(BasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
        WALLS.add(new GenericWallBlock(new BlockConfig().material("cracked_basalt_bricks").materialName("Cracked Basalt Brick").ingredient(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK).texture(CrackedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
        WALLS.add(new GenericWallBlock(new BlockConfig().material("crimson_basalt_bricks").materialName("Crimson Basalt Brick").ingredient(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK).texture(CrimsonBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
        WALLS.add(new GenericWallBlock(new BlockConfig().material("mossy_basalt_bricks").materialName("Mossy Basalt Brick").ingredient(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK).texture(MossyBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
        WALLS.add(new GenericWallBlock(new BlockConfig().material("warped_basalt_bricks").materialName("Warped Basalt Brick").ingredient(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK).texture(WarpedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
        WALLS.add(new GenericWallBlock(new BlockConfig().material("warped_nether_bricks").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK).texture(WarpedNetherBricksBlock.BLOCK_ID.withPrefixedPath("block/"))));
    }

    @Override
    public void registerBlocks() {
        WALLS.forEach(GenericWallBlock::register);
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
        WALLS.forEach(GenericWallBlock::generateTextures);
    }
}
