package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.lib.blocks.ModBlock;
import com.chimericdream.lib.resource.TextureUtils;
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
import net.minecraft.block.Blocks;
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

public class Stairs implements MinekeaBlockCategory {
    public static final List<GenericStairsBlock> STAIRS = new ArrayList<>();
    public static final List<GenericVerticalStairsBlock> VERTICAL_STAIRS = new ArrayList<>();

    static {
        STAIRS.add(new GenericStairsBlock(new ModBlock.Config().material("basalt_bricks").materialName("Basalt Brick").ingredient(BuildingBlocks.BASALT_BRICKS_BLOCK).texture(TextureUtils.block(BasaltBricksBlock.BLOCK_ID))));
        STAIRS.add(new GenericStairsBlock(new ModBlock.Config().material("cracked_basalt_bricks").materialName("Cracked Basalt Brick").ingredient(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(CrackedBasaltBricksBlock.BLOCK_ID))));
        STAIRS.add(new GenericStairsBlock(new ModBlock.Config().material("crimson_basalt_bricks").materialName("Crimson Basalt Brick").ingredient(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(CrimsonBasaltBricksBlock.BLOCK_ID))));
        STAIRS.add(new GenericStairsBlock(new ModBlock.Config().material("mossy_basalt_bricks").materialName("Mossy Basalt Brick").ingredient(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(MossyBasaltBricksBlock.BLOCK_ID))));
        STAIRS.add(new GenericStairsBlock(new ModBlock.Config().material("warped_basalt_bricks").materialName("Warped Basalt Brick").ingredient(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(WarpedBasaltBricksBlock.BLOCK_ID))));
        STAIRS.add(new GenericStairsBlock(new ModBlock.Config().material("warped_nether_bricks").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK).texture(TextureUtils.block(WarpedNetherBricksBlock.BLOCK_ID))));

        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("acacia_planks").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).flammable()));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("birch_planks").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).flammable()));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("cherry_planks").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).flammable()));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("crimson_planks").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("dark_oak_planks").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).flammable()));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("jungle_planks").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).flammable()));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("mangrove_planks").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).flammable()));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("oak_planks").materialName("Oak").ingredient(Blocks.OAK_PLANKS).flammable()));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("spruce_planks").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).flammable()));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("warped_planks").materialName("Warped").ingredient(Blocks.WARPED_PLANKS)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("andesite").materialName("Andesite").ingredient(Blocks.ANDESITE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("bamboo_mosaic").materialName("Bamboo Mosaic").ingredient(Blocks.BAMBOO_MOSAIC)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("blackstone").materialName("Blackstone").ingredient(Blocks.BLACKSTONE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("bricks").materialName("Brick").ingredient(Blocks.BRICKS)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("cobbled_deepslate").materialName("Cobbled Deepslate").ingredient(Blocks.COBBLED_DEEPSLATE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("cobblestone").materialName("Cobblestone").ingredient(Blocks.COBBLESTONE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("dark_prismarine").materialName("Dark Prismarine").ingredient(Blocks.DARK_PRISMARINE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("deepslate_bricks").materialName("Deepslate Brick").ingredient(Blocks.DEEPSLATE_BRICKS)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("deepslate_tiles").materialName("Deepslate Tile").ingredient(Blocks.DEEPSLATE_TILES)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("diorite").materialName("Diorite").ingredient(Blocks.DIORITE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("end_stone_bricks").materialName("End Stone Brick").ingredient(Blocks.END_STONE_BRICKS)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("granite").materialName("Granite").ingredient(Blocks.GRANITE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("mossy_cobblestone").materialName("Mossy Cobblestone").ingredient(Blocks.MOSSY_COBBLESTONE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("mossy_stone_bricks").materialName("Mossy Stone Brick").ingredient(Blocks.MOSSY_STONE_BRICKS)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("mud_bricks").materialName("Mud Brick").ingredient(Blocks.MUD_BRICKS)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("nether_bricks").materialName("Nether Brick").ingredient(Blocks.NETHER_BRICKS)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("polished_andesite").materialName("Polished Andesite").ingredient(Blocks.POLISHED_ANDESITE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("polished_blackstone_bricks").materialName("Polished Blackstone Brick").ingredient(Blocks.POLISHED_BLACKSTONE_BRICKS)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("polished_blackstone").materialName("Polished Blackstone").ingredient(Blocks.POLISHED_BLACKSTONE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("polished_deepslate").materialName("Polished Deepslate").ingredient(Blocks.POLISHED_DEEPSLATE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("polished_diorite").materialName("Polished Diorite").ingredient(Blocks.POLISHED_DIORITE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("polished_granite").materialName("Polished Granite").ingredient(Blocks.POLISHED_GRANITE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("polished_tuff").materialName("Polished Tuff").ingredient(Blocks.POLISHED_TUFF)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("prismarine_bricks").materialName("Prismarine Brick").ingredient(Blocks.PRISMARINE_BRICKS)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("prismarine").materialName("Prismarine").ingredient(Blocks.PRISMARINE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("purpur_block").materialName("Purpur").ingredient(Blocks.PURPUR_BLOCK)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("quartz_block").materialName("Quartz").ingredient(Blocks.QUARTZ_BLOCK).texture(TextureUtils.block(Blocks.QUARTZ_BLOCK, "_top"))));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("red_nether_bricks").materialName("Red Nether Brick").ingredient(Blocks.RED_NETHER_BRICKS)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("red_sandstone").materialName("Red Sandstone").ingredient(Blocks.RED_SANDSTONE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("sandstone").materialName("Sandstone").ingredient(Blocks.SANDSTONE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("quartz_block_bottom").materialName("Smooth Quartz").ingredient(Blocks.SMOOTH_QUARTZ).texture(TextureUtils.block(Blocks.QUARTZ_BLOCK, "_bottom"))));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("red_sandstone_top").materialName("Smooth Red Sandstone").ingredient(Blocks.SMOOTH_RED_SANDSTONE).texture(TextureUtils.block(Blocks.RED_SANDSTONE, "_top"))));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("sandstone_top").materialName("Smooth Sandstone").ingredient(Blocks.SMOOTH_SANDSTONE).texture(TextureUtils.block(Blocks.SANDSTONE, "_top"))));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("stone_bricks").materialName("Stone Brick").ingredient(Blocks.STONE_BRICKS)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("stone").materialName("Stone").ingredient(Blocks.STONE)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("tuff_bricks").materialName("Tuff Brick").ingredient(Blocks.TUFF_BRICKS)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("tuff").materialName("Tuff").ingredient(Blocks.TUFF)));

        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("cut_copper").materialName("Cut Copper").ingredient(Blocks.CUT_COPPER)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("waxed_cut_copper").materialName("Waxed Cut Copper").ingredient(Blocks.WAXED_CUT_COPPER).texture(TextureUtils.block(Blocks.CUT_COPPER))));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("exposed_cut_copper").materialName("Exposed Cut Copper").ingredient(Blocks.EXPOSED_CUT_COPPER)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("waxed_exposed_cut_copper").materialName("Waxed Exposed Cut Copper").ingredient(Blocks.WAXED_EXPOSED_CUT_COPPER).texture(TextureUtils.block(Blocks.EXPOSED_CUT_COPPER))));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("weathered_cut_copper").materialName("Weathered Cut Copper").ingredient(Blocks.WEATHERED_CUT_COPPER)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("waxed_weathered_cut_copper").materialName("Waxed Weathered Cut Copper").ingredient(Blocks.WAXED_WEATHERED_CUT_COPPER).texture(TextureUtils.block(Blocks.WEATHERED_CUT_COPPER))));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("oxidized_cut_copper").materialName("Oxidized Cut Copper").ingredient(Blocks.OXIDIZED_CUT_COPPER)));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("waxed_oxidized_cut_copper").materialName("Waxed Oxidized Cut Copper").ingredient(Blocks.WAXED_OXIDIZED_CUT_COPPER).texture(TextureUtils.block(Blocks.OXIDIZED_CUT_COPPER))));

        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("basalt_bricks").materialName("Basalt Brick").ingredient(BuildingBlocks.BASALT_BRICKS_BLOCK).texture(TextureUtils.block(BasaltBricksBlock.BLOCK_ID))));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("cracked_basalt_bricks").materialName("Cracked Basalt Brick").ingredient(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(CrackedBasaltBricksBlock.BLOCK_ID))));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("crimson_basalt_bricks").materialName("Crimson Basalt Brick").ingredient(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(CrimsonBasaltBricksBlock.BLOCK_ID))));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("mossy_basalt_bricks").materialName("Mossy Basalt Brick").ingredient(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(MossyBasaltBricksBlock.BLOCK_ID))));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("warped_basalt_bricks").materialName("Warped Basalt Brick").ingredient(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK).texture(TextureUtils.block(WarpedBasaltBricksBlock.BLOCK_ID))));
        VERTICAL_STAIRS.add(new GenericVerticalStairsBlock(new ModBlock.Config().material("warped_nether_bricks").materialName("Warped Nether Brick").ingredient(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK).texture(TextureUtils.block(WarpedNetherBricksBlock.BLOCK_ID))));
    }

    @Override
    public void registerBlocks() {
        STAIRS.forEach(GenericStairsBlock::register);
        VERTICAL_STAIRS.forEach(GenericVerticalStairsBlock::register);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        STAIRS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
        VERTICAL_STAIRS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        STAIRS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
        VERTICAL_STAIRS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        STAIRS.forEach(block -> block.configureRecipes(exporter));
        VERTICAL_STAIRS.forEach(block -> block.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        STAIRS.forEach(block -> block.configureBlockLootTables(registryLookup, generator));
        VERTICAL_STAIRS.forEach(block -> block.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        STAIRS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
        VERTICAL_STAIRS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        STAIRS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
        VERTICAL_STAIRS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        STAIRS.forEach(block -> block.configureItemModels(itemModelGenerator));
        VERTICAL_STAIRS.forEach(block -> block.configureItemModels(itemModelGenerator));
    }

    @Override
    public void generateTextures() {
        STAIRS.forEach(GenericStairsBlock::generateTextures);
        VERTICAL_STAIRS.forEach(GenericVerticalStairsBlock::generateTextures);
    }
}
