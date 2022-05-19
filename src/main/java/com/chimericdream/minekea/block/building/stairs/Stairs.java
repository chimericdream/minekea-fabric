package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.minekea.block.building.basalt_bricks.*;
import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBricksBlock;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class Stairs implements MinekeaBlockCategory {
    public static final GenericVerticalStairsBlock CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock EXPOSED_CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WEATHERED_CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock OXIDIZED_CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WAXED_CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WAXED_EXPOSED_CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WAXED_WEATHERED_CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WAXED_OXIDIZED_CUT_COPPER_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock PURPUR_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock OAK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock COBBLESTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock STONE_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock NETHER_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock SANDSTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock SPRUCE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock BIRCH_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock JUNGLE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock CRIMSON_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WARPED_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock QUARTZ_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock ACACIA_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock DARK_OAK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock PRISMARINE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock PRISMARINE_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock DARK_PRISMARINE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock RED_SANDSTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock POLISHED_GRANITE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock SMOOTH_RED_SANDSTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock MOSSY_STONE_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock POLISHED_DIORITE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock MOSSY_COBBLESTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock END_STONE_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock STONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock SMOOTH_SANDSTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock SMOOTH_QUARTZ_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock GRANITE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock ANDESITE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock RED_NETHER_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock POLISHED_ANDESITE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock DIORITE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock COBBLED_DEEPSLATE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock POLISHED_DEEPSLATE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock DEEPSLATE_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock DEEPSLATE_TILE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock BLACKSTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock POLISHED_BLACKSTONE_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock POLISHED_BLACKSTONE_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock BASALT_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock CRACKED_BASALT_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock CRIMSON_BASALT_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock MOSSY_BASALT_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WARPED_BASALT_BRICK_VERTICAL_STAIRS;
    public static final GenericVerticalStairsBlock WARPED_NETHER_BRICK_VERTICAL_STAIRS;

    static {
        CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock("cut_copper", Map.of("main", new Identifier("minecraft:cut_copper")));
        EXPOSED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock("exposed_cut_copper", Map.of("main", new Identifier("minecraft:exposed_cut_copper")));
        WEATHERED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock("weathered_cut_copper", Map.of("main", new Identifier("minecraft:weathered_cut_copper")));
        OXIDIZED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock("oxidized_cut_copper", Map.of("main", new Identifier("minecraft:oxidized_cut_copper")));
        WAXED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock("waxed_cut_copper", Map.of("main", new Identifier("minecraft:cut_copper"), "ingredient", new Identifier("minecraft:waxed_cut_copper")));
        WAXED_EXPOSED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock("waxed_exposed_cut_copper", Map.of("main", new Identifier("minecraft:exposed_cut_copper"), "ingredient", new Identifier("minecraft:waxed_exposed_cut_copper")));
        WAXED_WEATHERED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock("waxed_weathered_cut_copper", Map.of("main", new Identifier("minecraft:weathered_cut_copper"), "ingredient", new Identifier("minecraft:waxed_weathered_cut_copper")));
        WAXED_OXIDIZED_CUT_COPPER_VERTICAL_STAIRS = new GenericVerticalStairsBlock("waxed_oxidized_cut_copper", Map.of("main", new Identifier("minecraft:oxidized_cut_copper"), "ingredient", new Identifier("minecraft:waxed_oxidized_cut_copper")));
        PURPUR_VERTICAL_STAIRS = new GenericVerticalStairsBlock("purpur", Map.of("main", new Identifier("minecraft:purpur_block")));
        OAK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("oak", Map.of("main", new Identifier("minecraft:oak_planks")));
        COBBLESTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("cobblestone", Map.of("main", new Identifier("minecraft:cobblestone")));
        BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("brick", Map.of("main", new Identifier("minecraft:bricks")));
        STONE_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("stone_brick", Map.of("main", new Identifier("minecraft:stone_bricks")));
        NETHER_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("nether_brick", Map.of("main", new Identifier("minecraft:nether_bricks")));
        SANDSTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("sandstone", Map.of("main", new Identifier("minecraft:sandstone")));
        SPRUCE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("spruce", Map.of("main", new Identifier("minecraft:spruce_planks")));
        BIRCH_VERTICAL_STAIRS = new GenericVerticalStairsBlock("birch", Map.of("main", new Identifier("minecraft:birch_planks")));
        JUNGLE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("jungle", Map.of("main", new Identifier("minecraft:jungle_planks")));
        CRIMSON_VERTICAL_STAIRS = new GenericVerticalStairsBlock("crimson", Map.of("main", new Identifier("minecraft:crimson_planks")));
        WARPED_VERTICAL_STAIRS = new GenericVerticalStairsBlock("warped", Map.of("main", new Identifier("minecraft:warped_planks")));
        QUARTZ_VERTICAL_STAIRS = new GenericVerticalStairsBlock("quartz", Map.of("main", new Identifier("minecraft:quartz_block_top"), "ingredient", new Identifier("minecraft:quartz_block")));
        ACACIA_VERTICAL_STAIRS = new GenericVerticalStairsBlock("acacia", Map.of("main", new Identifier("minecraft:acacia_planks")));
        DARK_OAK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("dark_oak", Map.of("main", new Identifier("minecraft:dark_oak_planks")));
        PRISMARINE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("prismarine", Map.of("main", new Identifier("minecraft:prismarine")));
        PRISMARINE_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("prismarine_brick", Map.of("main", new Identifier("minecraft:prismarine_bricks")));
        DARK_PRISMARINE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("dark_prismarine", Map.of("main", new Identifier("minecraft:dark_prismarine")));
        RED_SANDSTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("red_sandstone", Map.of("main", new Identifier("minecraft:red_sandstone")));
        POLISHED_GRANITE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("polished_granite", Map.of("main", new Identifier("minecraft:polished_granite")));
        SMOOTH_RED_SANDSTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("smooth_red_sandstone", Map.of("main", new Identifier("minecraft:red_sandstone_top"), "ingredient", new Identifier("minecraft:smooth_red_sandstone")));
        MOSSY_STONE_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("mossy_stone_brick", Map.of("main", new Identifier("minecraft:mossy_stone_bricks")));
        POLISHED_DIORITE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("polished_diorite", Map.of("main", new Identifier("minecraft:polished_diorite")));
        MOSSY_COBBLESTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("mossy_cobblestone", Map.of("main", new Identifier("minecraft:mossy_cobblestone")));
        END_STONE_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("end_stone_brick", Map.of("main", new Identifier("minecraft:end_stone_bricks")));
        STONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("stone", Map.of("main", new Identifier("minecraft:stone")));
        SMOOTH_SANDSTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("smooth_sandstone", Map.of("main", new Identifier("minecraft:sandstone_top"), "ingredient", new Identifier("minecraft:smooth_sandstone")));
        SMOOTH_QUARTZ_VERTICAL_STAIRS = new GenericVerticalStairsBlock("smooth_quartz", Map.of("main", new Identifier("minecraft:quartz_block_bottom"), "ingredient", new Identifier("minecraft:smooth_quartz")));
        GRANITE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("granite", Map.of("main", new Identifier("minecraft:granite")));
        ANDESITE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("andesite", Map.of("main", new Identifier("minecraft:andesite")));
        RED_NETHER_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("red_nether_brick", Map.of("main", new Identifier("minecraft:red_nether_bricks")));
        POLISHED_ANDESITE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("polished_andesite", Map.of("main", new Identifier("minecraft:polished_andesite")));
        DIORITE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("diorite", Map.of("main", new Identifier("minecraft:diorite")));
        COBBLED_DEEPSLATE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("cobbled_deepslate", Map.of("main", new Identifier("minecraft:cobbled_deepslate")));
        POLISHED_DEEPSLATE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("polished_deepslate", Map.of("main", new Identifier("minecraft:polished_deepslate")));
        DEEPSLATE_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("deepslate_brick", Map.of("main", new Identifier("minecraft:deepslate_bricks")));
        DEEPSLATE_TILE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("deepslate_tile", Map.of("main", new Identifier("minecraft:deepslate_tiles")));
        BLACKSTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("blackstone", Map.of("main", new Identifier("minecraft:blackstone")));
        POLISHED_BLACKSTONE_VERTICAL_STAIRS = new GenericVerticalStairsBlock("polished_blackstone", Map.of("main", new Identifier("minecraft:polished_blackstone")));
        POLISHED_BLACKSTONE_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("polished_blackstone_brick", Map.of("main", new Identifier("minecraft:polished_blackstone_bricks")));
        BASALT_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("basalt_brick", Map.of("main", BasaltBricksBlock.BLOCK_ID));
        CRACKED_BASALT_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("cracked_basalt_brick", Map.of("main", CrackedBasaltBricksBlock.BLOCK_ID));
        CRIMSON_BASALT_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("crimson_basalt_brick", Map.of("main", CrimsonBasaltBricksBlock.BLOCK_ID));
        MOSSY_BASALT_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("mossy_basalt_brick", Map.of("main", MossyBasaltBricksBlock.BLOCK_ID));
        WARPED_BASALT_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("warped_basalt_brick", Map.of("main", WarpedBasaltBricksBlock.BLOCK_ID));
        WARPED_NETHER_BRICK_VERTICAL_STAIRS = new GenericVerticalStairsBlock("warped_nether_brick", Map.of("main", WarpedNetherBricksBlock.BLOCK_ID));
    }

    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        CUT_COPPER_VERTICAL_STAIRS.register();
        EXPOSED_CUT_COPPER_VERTICAL_STAIRS.register();
        WEATHERED_CUT_COPPER_VERTICAL_STAIRS.register();
        OXIDIZED_CUT_COPPER_VERTICAL_STAIRS.register();
        WAXED_CUT_COPPER_VERTICAL_STAIRS.register();
        WAXED_EXPOSED_CUT_COPPER_VERTICAL_STAIRS.register();
        WAXED_WEATHERED_CUT_COPPER_VERTICAL_STAIRS.register();
        WAXED_OXIDIZED_CUT_COPPER_VERTICAL_STAIRS.register();
        PURPUR_VERTICAL_STAIRS.register();
        OAK_VERTICAL_STAIRS.register();
        COBBLESTONE_VERTICAL_STAIRS.register();
        BRICK_VERTICAL_STAIRS.register();
        STONE_BRICK_VERTICAL_STAIRS.register();
        NETHER_BRICK_VERTICAL_STAIRS.register();
        SANDSTONE_VERTICAL_STAIRS.register();
        SPRUCE_VERTICAL_STAIRS.register();
        BIRCH_VERTICAL_STAIRS.register();
        JUNGLE_VERTICAL_STAIRS.register();
        CRIMSON_VERTICAL_STAIRS.register();
        WARPED_VERTICAL_STAIRS.register();
        QUARTZ_VERTICAL_STAIRS.register();
        ACACIA_VERTICAL_STAIRS.register();
        DARK_OAK_VERTICAL_STAIRS.register();
        PRISMARINE_VERTICAL_STAIRS.register();
        PRISMARINE_BRICK_VERTICAL_STAIRS.register();
        DARK_PRISMARINE_VERTICAL_STAIRS.register();
        RED_SANDSTONE_VERTICAL_STAIRS.register();
        POLISHED_GRANITE_VERTICAL_STAIRS.register();
        SMOOTH_RED_SANDSTONE_VERTICAL_STAIRS.register();
        MOSSY_STONE_BRICK_VERTICAL_STAIRS.register();
        POLISHED_DIORITE_VERTICAL_STAIRS.register();
        MOSSY_COBBLESTONE_VERTICAL_STAIRS.register();
        END_STONE_BRICK_VERTICAL_STAIRS.register();
        STONE_VERTICAL_STAIRS.register();
        SMOOTH_SANDSTONE_VERTICAL_STAIRS.register();
        SMOOTH_QUARTZ_VERTICAL_STAIRS.register();
        GRANITE_VERTICAL_STAIRS.register();
        ANDESITE_VERTICAL_STAIRS.register();
        RED_NETHER_BRICK_VERTICAL_STAIRS.register();
        POLISHED_ANDESITE_VERTICAL_STAIRS.register();
        DIORITE_VERTICAL_STAIRS.register();
        COBBLED_DEEPSLATE_VERTICAL_STAIRS.register();
        POLISHED_DEEPSLATE_VERTICAL_STAIRS.register();
        DEEPSLATE_BRICK_VERTICAL_STAIRS.register();
        DEEPSLATE_TILE_VERTICAL_STAIRS.register();
        BLACKSTONE_VERTICAL_STAIRS.register();
        POLISHED_BLACKSTONE_VERTICAL_STAIRS.register();
        POLISHED_BLACKSTONE_BRICK_VERTICAL_STAIRS.register();
        BASALT_BRICK_VERTICAL_STAIRS.register();
        CRACKED_BASALT_BRICK_VERTICAL_STAIRS.register();
        CRIMSON_BASALT_BRICK_VERTICAL_STAIRS.register();
        MOSSY_BASALT_BRICK_VERTICAL_STAIRS.register();
        WARPED_BASALT_BRICK_VERTICAL_STAIRS.register();
        WARPED_NETHER_BRICK_VERTICAL_STAIRS.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
    }
}