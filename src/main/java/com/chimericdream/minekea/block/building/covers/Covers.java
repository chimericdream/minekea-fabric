package com.chimericdream.minekea.block.building.covers;

import com.chimericdream.minekea.block.building.basalt_bricks.*;
import com.chimericdream.minekea.block.building.end_stone.CobbledEndStoneBlock;
import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBricksBlock;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class Covers implements MinekeaBlockCategory {
    public static final GenericCoverBlock ANDESITE_COVER;
    public static final GenericCoverBlock BASALT_COVER;
    public static final GenericCoverBlock BASALT_BRICK_COVER;
    public static final GenericCoverBlock BLACKSTONE_COVER;
    public static final GenericCoverBlock BONE_COVER;
    public static final GenericCoverBlock BRICK_COVER;
    public static final GenericCoverBlock CALCITE_COVER;
    public static final GenericCoverBlock COBBLED_DEEPSLATE_COVER;
    public static final GenericCoverBlock COBBLED_END_STONE_COVER;
    public static final GenericCoverBlock COBBLESTONE_COVER;
    public static final GenericCoverBlock CRACKED_BASALT_BRICK_COVER;
    public static final GenericCoverBlock CRACKED_DEEPSLATE_BRICK_COVER;
    public static final GenericCoverBlock CRACKED_DEEPSLATE_TILE_COVER;
    public static final GenericCoverBlock CRACKED_STONE_BRICK_COVER;
    public static final GenericCoverBlock CRIMSON_BASALT_BRICK_COVER;
    public static final GenericCoverBlock CRYING_OBSIDIAN_COVER;
    public static final GenericCoverBlock CUT_RED_SANDSTONE_COVER;
    public static final GenericCoverBlock CUT_SANDSTONE_COVER;
    public static final GenericCoverBlock DARK_PRISMARINE_COVER;
    public static final GenericCoverBlock DEEPSLATE_COVER;
    public static final GenericCoverBlock DEEPSLATE_BRICK_COVER;
    public static final GenericCoverBlock DEEPSLATE_TILE_COVER;
    public static final GenericCoverBlock DIORITE_COVER;
    public static final GenericCoverBlock END_STONE_COVER;
    public static final GenericCoverBlock END_STONE_BRICK_COVER;
    public static final GenericCoverBlock GRANITE_COVER;
    public static final GenericCoverBlock MOSSY_BASALT_BRICK_COVER;
    public static final GenericCoverBlock MOSSY_COBBLESTONE_COVER;
    public static final GenericCoverBlock MOSSY_STONE_BRICK_COVER;
    public static final GenericCoverBlock NETHER_BRICK_COVER;
    public static final GenericCoverBlock NETHERRACK_COVER;
    public static final GenericCoverBlock OBSIDIAN_COVER;
    public static final GenericCoverBlock POLISHED_ANDESITE_COVER;
    public static final GenericCoverBlock POLISHED_BLACKSTONE_COVER;
    public static final GenericCoverBlock POLISHED_BLACKSTONE_BRICK_COVER;
    public static final GenericCoverBlock POLISHED_DEEPSLATE_COVER;
    public static final GenericCoverBlock POLISHED_DIORITE_COVER;
    public static final GenericCoverBlock POLISHED_GRANITE_COVER;
    public static final GenericCoverBlock PRISMARINE_COVER;
    public static final GenericCoverBlock PRISMARINE_BRICK_COVER;
    public static final GenericCoverBlock PURPUR_COVER;
    public static final GenericCoverBlock PURPUR_PILLAR_COVER;
    public static final GenericCoverBlock RED_NETHER_BRICK_COVER;
    public static final GenericCoverBlock RED_SANDSTONE_COVER;
    public static final GenericCoverBlock SANDSTONE_COVER;
    public static final GenericCoverBlock SMOOTH_BASALT_COVER;
    public static final GenericCoverBlock SMOOTH_STONE_COVER;
    public static final GenericCoverBlock STONE_COVER;
    public static final GenericCoverBlock STONE_BRICK_COVER;
    public static final GenericCoverBlock TUFF_COVER;
    public static final GenericCoverBlock WARPED_BASALT_BRICK_COVER;
    public static final GenericCoverBlock WARPED_NETHER_BRICK_COVER;

    public static final GenericCoverBlock AMETHYST_COVER;
    public static final GenericCoverBlock POLISHED_BASALT_COVER;
    public static final GenericCoverBlock SMOOTH_RED_SANDSTONE_COVER;
    public static final GenericCoverBlock SMOOTH_SANDSTONE_COVER;

    public static final GenericCoverBlock WHITE_TERRACOTTA_COVER;
    public static final GenericCoverBlock ORANGE_TERRACOTTA_COVER;
    public static final GenericCoverBlock MAGENTA_TERRACOTTA_COVER;
    public static final GenericCoverBlock LIGHT_BLUE_TERRACOTTA_COVER;
    public static final GenericCoverBlock YELLOW_TERRACOTTA_COVER;
    public static final GenericCoverBlock LIME_TERRACOTTA_COVER;
    public static final GenericCoverBlock PINK_TERRACOTTA_COVER;
    public static final GenericCoverBlock GRAY_TERRACOTTA_COVER;
    public static final GenericCoverBlock LIGHT_GRAY_TERRACOTTA_COVER;
    public static final GenericCoverBlock CYAN_TERRACOTTA_COVER;
    public static final GenericCoverBlock PURPLE_TERRACOTTA_COVER;
    public static final GenericCoverBlock BLUE_TERRACOTTA_COVER;
    public static final GenericCoverBlock BROWN_TERRACOTTA_COVER;
    public static final GenericCoverBlock GREEN_TERRACOTTA_COVER;
    public static final GenericCoverBlock RED_TERRACOTTA_COVER;
    public static final GenericCoverBlock BLACK_TERRACOTTA_COVER;
    public static final GenericCoverBlock WHITE_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock ORANGE_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock MAGENTA_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock LIGHT_BLUE_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock YELLOW_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock LIME_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock PINK_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock GRAY_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock LIGHT_GRAY_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock CYAN_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock PURPLE_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock BLUE_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock BROWN_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock GREEN_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock RED_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock BLACK_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock WHITE_CONCRETE_COVER;
    public static final GenericCoverBlock ORANGE_CONCRETE_COVER;
    public static final GenericCoverBlock MAGENTA_CONCRETE_COVER;
    public static final GenericCoverBlock LIGHT_BLUE_CONCRETE_COVER;
    public static final GenericCoverBlock YELLOW_CONCRETE_COVER;
    public static final GenericCoverBlock LIME_CONCRETE_COVER;
    public static final GenericCoverBlock PINK_CONCRETE_COVER;
    public static final GenericCoverBlock GRAY_CONCRETE_COVER;
    public static final GenericCoverBlock LIGHT_GRAY_CONCRETE_COVER;
    public static final GenericCoverBlock CYAN_CONCRETE_COVER;
    public static final GenericCoverBlock PURPLE_CONCRETE_COVER;
    public static final GenericCoverBlock BLUE_CONCRETE_COVER;
    public static final GenericCoverBlock BROWN_CONCRETE_COVER;
    public static final GenericCoverBlock GREEN_CONCRETE_COVER;
    public static final GenericCoverBlock RED_CONCRETE_COVER;
    public static final GenericCoverBlock BLACK_CONCRETE_COVER;
    public static final GenericCoverBlock ACACIA_LOG_COVER;
    public static final GenericCoverBlock BIRCH_LOG_COVER;
    public static final GenericCoverBlock CRIMSON_STEM_COVER;
    public static final GenericCoverBlock DARK_OAK_LOG_COVER;
    public static final GenericCoverBlock JUNGLE_LOG_COVER;
    public static final GenericCoverBlock OAK_LOG_COVER;
    public static final GenericCoverBlock SPRUCE_LOG_COVER;
    public static final GenericCoverBlock WARPED_STEM_COVER;
    public static final GenericCoverBlock ACACIA_PLANK_COVER;
    public static final GenericCoverBlock BIRCH_PLANK_COVER;
    public static final GenericCoverBlock CRIMSON_PLANK_COVER;
    public static final GenericCoverBlock DARK_OAK_PLANK_COVER;
    public static final GenericCoverBlock JUNGLE_PLANK_COVER;
    public static final GenericCoverBlock OAK_PLANK_COVER;
    public static final GenericCoverBlock SPRUCE_PLANK_COVER;
    public static final GenericCoverBlock WARPED_PLANK_COVER;

    static {
        ANDESITE_COVER = new GenericCoverBlock("andesite", Map.of("main", new Identifier("minecraft:andesite")));
        BASALT_BRICK_COVER = new GenericCoverBlock("basalt_brick", Map.of("main", BasaltBricksBlock.BLOCK_ID));
        BLACKSTONE_COVER = new GenericCoverBlock("blackstone", Map.of("main", new Identifier("minecraft:blackstone")));
        BRICK_COVER = new GenericCoverBlock("brick", Map.of("main", new Identifier("minecraft:bricks")));
        CALCITE_COVER = new GenericCoverBlock("calcite", Map.of("main", new Identifier("minecraft:calcite")));
        COBBLED_DEEPSLATE_COVER = new GenericCoverBlock("cobbled_deepslate", Map.of("main", new Identifier("minecraft:cobbled_deepslate")));
        COBBLED_END_STONE_COVER = new GenericCoverBlock("cobbled_end_stone", Map.of("main", CobbledEndStoneBlock.BLOCK_ID));
        COBBLESTONE_COVER = new GenericCoverBlock("cobblestone", Map.of("main", new Identifier("minecraft:cobblestone")));
        CRACKED_BASALT_BRICK_COVER = new GenericCoverBlock("cracked_basalt_brick", Map.of("main", CrackedBasaltBricksBlock.BLOCK_ID));
        CRACKED_DEEPSLATE_BRICK_COVER = new GenericCoverBlock("cracked_deepslate_brick", Map.of("main", new Identifier("minecraft:cracked_deepslate_bricks")));
        CRACKED_DEEPSLATE_TILE_COVER = new GenericCoverBlock("cracked_deepslate_tile", Map.of("main", new Identifier("minecraft:cracked_deepslate_tiles")));
        CRACKED_STONE_BRICK_COVER = new GenericCoverBlock("cracked_stone_brick", Map.of("main", new Identifier("minecraft:cracked_stone_bricks")));
        CRIMSON_BASALT_BRICK_COVER = new GenericCoverBlock("crimson_basalt_brick", Map.of("main", CrimsonBasaltBricksBlock.BLOCK_ID));
        CRYING_OBSIDIAN_COVER = new GenericCoverBlock("crying_obsidian", Map.of("main", new Identifier("minecraft:crying_obsidian")));
        CUT_RED_SANDSTONE_COVER = new GenericCoverBlock("cut_red_sandstone", Map.of("main", new Identifier("minecraft:cut_red_sandstone")));
        CUT_SANDSTONE_COVER = new GenericCoverBlock("cut_sandstone", Map.of("main", new Identifier("minecraft:cut_sandstone")));
        DARK_PRISMARINE_COVER = new GenericCoverBlock("dark_prismarine", Map.of("main", new Identifier("minecraft:dark_prismarine")));
        DEEPSLATE_COVER = new GenericCoverBlock("deepslate", Map.of("main", new Identifier("minecraft:deepslate")));
        DEEPSLATE_BRICK_COVER = new GenericCoverBlock("deepslate_brick", Map.of("main", new Identifier("minecraft:deepslate_bricks")));
        DEEPSLATE_TILE_COVER = new GenericCoverBlock("deepslate_tile", Map.of("main", new Identifier("minecraft:deepslate_tiles")));
        DIORITE_COVER = new GenericCoverBlock("diorite", Map.of("main", new Identifier("minecraft:diorite")));
        END_STONE_COVER = new GenericCoverBlock("end_stone", Map.of("main", new Identifier("minecraft:end_stone")));
        END_STONE_BRICK_COVER = new GenericCoverBlock("end_stone_brick", Map.of("main", new Identifier("minecraft:end_stone_bricks")));
        GRANITE_COVER = new GenericCoverBlock("granite", Map.of("main", new Identifier("minecraft:granite")));
        MOSSY_BASALT_BRICK_COVER = new GenericCoverBlock("mossy_basalt_brick", Map.of("main", MossyBasaltBricksBlock.BLOCK_ID));
        MOSSY_COBBLESTONE_COVER = new GenericCoverBlock("mossy_cobblestone", Map.of("main", new Identifier("minecraft:mossy_cobblestone")));
        MOSSY_STONE_BRICK_COVER = new GenericCoverBlock("mossy_stone_brick", Map.of("main", new Identifier("minecraft:mossy_stone_bricks")));
        NETHER_BRICK_COVER = new GenericCoverBlock("nether_brick", Map.of("main", new Identifier("minecraft:nether_bricks")));
        NETHERRACK_COVER = new GenericCoverBlock("netherrack", Map.of("main", new Identifier("minecraft:netherrack")));
        OBSIDIAN_COVER = new GenericCoverBlock("obsidian", Map.of("main", new Identifier("minecraft:obsidian")));
        POLISHED_ANDESITE_COVER = new GenericCoverBlock("polished_andesite", Map.of("main", new Identifier("minecraft:polished_andesite")));
        POLISHED_BLACKSTONE_COVER = new GenericCoverBlock("polished_blackstone", Map.of("main", new Identifier("minecraft:polished_blackstone")));
        POLISHED_BLACKSTONE_BRICK_COVER = new GenericCoverBlock("polished_blackstone_brick", Map.of("main", new Identifier("minecraft:polished_blackstone_bricks")));
        POLISHED_DEEPSLATE_COVER = new GenericCoverBlock("polished_deepslate", Map.of("main", new Identifier("minecraft:polished_deepslate")));
        POLISHED_DIORITE_COVER = new GenericCoverBlock("polished_diorite", Map.of("main", new Identifier("minecraft:polished_diorite")));
        POLISHED_GRANITE_COVER = new GenericCoverBlock("polished_granite", Map.of("main", new Identifier("minecraft:polished_granite")));
        PRISMARINE_COVER = new GenericCoverBlock("prismarine", Map.of("main", new Identifier("minecraft:prismarine")));
        PRISMARINE_BRICK_COVER = new GenericCoverBlock("prismarine_brick", Map.of("main", new Identifier("minecraft:prismarine_bricks")));
        PURPUR_PILLAR_COVER = new GenericCoverBlock("purpur_pillar", Map.of("main", new Identifier("minecraft:purpur_pillar")));
        RED_NETHER_BRICK_COVER = new GenericCoverBlock("red_nether_brick", Map.of("main", new Identifier("minecraft:red_nether_bricks")));
        RED_SANDSTONE_COVER = new GenericCoverBlock("red_sandstone", Map.of("main", new Identifier("minecraft:red_sandstone")));
        SANDSTONE_COVER = new GenericCoverBlock("sandstone", Map.of("main", new Identifier("minecraft:sandstone")));
        SMOOTH_BASALT_COVER = new GenericCoverBlock("smooth_basalt", Map.of("main", new Identifier("minecraft:smooth_basalt")));
        SMOOTH_STONE_COVER = new GenericCoverBlock("smooth_stone", Map.of("main", new Identifier("minecraft:smooth_stone")));
        STONE_COVER = new GenericCoverBlock("stone", Map.of("main", new Identifier("minecraft:stone")));
        STONE_BRICK_COVER = new GenericCoverBlock("stone_brick", Map.of("main", new Identifier("minecraft:stone_bricks")));
        TUFF_COVER = new GenericCoverBlock("tuff", Map.of("main", new Identifier("minecraft:tuff")));
        WARPED_BASALT_BRICK_COVER = new GenericCoverBlock("warped_basalt_brick", Map.of("main", WarpedBasaltBricksBlock.BLOCK_ID));
        WARPED_NETHER_BRICK_COVER = new GenericCoverBlock("warped_nether_brick", Map.of("main", WarpedNetherBricksBlock.BLOCK_ID));

        AMETHYST_COVER = new GenericCoverBlock(
            "amethyst",
            Map.of(
                "main", new Identifier("minecraft:amethyst_block"),
                "ingredient", new Identifier("minecraft:amethyst_shard")
            )
        );
        BASALT_COVER = new GenericCoverBlock(
            "basalt",
            Map.of(
                "main", new Identifier("minecraft:basalt_side"),
                "end", new Identifier("minecraft:basalt_top"),
                "ingredient", new Identifier("minecraft:basalt")
            )
        );
        BONE_COVER = new GenericCoverBlock(
            "bone",
            Map.of(
                "main", new Identifier("minecraft:bone_block_side"),
                "end", new Identifier("minecraft:bone_block_top"),
                "ingredient", new Identifier("minecraft:bone_block")
            )
        );
        POLISHED_BASALT_COVER = new GenericCoverBlock(
            "polished_basalt",
            Map.of(
                "main", new Identifier("minecraft:polished_basalt_side"),
                "end", new Identifier("minecraft:polished_basalt_top"),
                "ingredient", new Identifier("minecraft:polished_basalt")
            )
        );
        PURPUR_COVER = new GenericCoverBlock(
            "purpur",
            Map.of(
                "main", new Identifier("minecraft:purpur_block")
            )
        );
        SMOOTH_RED_SANDSTONE_COVER = new GenericCoverBlock(
            "smooth_red_sandstone",
            Map.of(
                "main", new Identifier("minecraft:red_sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_red_sandstone")
            )
        );
        SMOOTH_SANDSTONE_COVER = new GenericCoverBlock(
            "smooth_sandstone",
            Map.of(
                "main", new Identifier("minecraft:sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_sandstone")
            )
        );

        WHITE_TERRACOTTA_COVER = new GenericCoverBlock("white_terracotta", Map.of("main", new Identifier("minecraft:white_terracotta")));
        ORANGE_TERRACOTTA_COVER = new GenericCoverBlock("orange_terracotta", Map.of("main", new Identifier("minecraft:orange_terracotta")));
        MAGENTA_TERRACOTTA_COVER = new GenericCoverBlock("magenta_terracotta", Map.of("main", new Identifier("minecraft:magenta_terracotta")));
        LIGHT_BLUE_TERRACOTTA_COVER = new GenericCoverBlock("light_blue_terracotta", Map.of("main", new Identifier("minecraft:light_blue_terracotta")));
        YELLOW_TERRACOTTA_COVER = new GenericCoverBlock("yellow_terracotta", Map.of("main", new Identifier("minecraft:yellow_terracotta")));
        LIME_TERRACOTTA_COVER = new GenericCoverBlock("lime_terracotta", Map.of("main", new Identifier("minecraft:lime_terracotta")));
        PINK_TERRACOTTA_COVER = new GenericCoverBlock("pink_terracotta", Map.of("main", new Identifier("minecraft:pink_terracotta")));
        GRAY_TERRACOTTA_COVER = new GenericCoverBlock("gray_terracotta", Map.of("main", new Identifier("minecraft:gray_terracotta")));
        LIGHT_GRAY_TERRACOTTA_COVER = new GenericCoverBlock("light_gray_terracotta", Map.of("main", new Identifier("minecraft:light_gray_terracotta")));
        CYAN_TERRACOTTA_COVER = new GenericCoverBlock("cyan_terracotta", Map.of("main", new Identifier("minecraft:cyan_terracotta")));
        PURPLE_TERRACOTTA_COVER = new GenericCoverBlock("purple_terracotta", Map.of("main", new Identifier("minecraft:purple_terracotta")));
        BLUE_TERRACOTTA_COVER = new GenericCoverBlock("blue_terracotta", Map.of("main", new Identifier("minecraft:blue_terracotta")));
        BROWN_TERRACOTTA_COVER = new GenericCoverBlock("brown_terracotta", Map.of("main", new Identifier("minecraft:brown_terracotta")));
        GREEN_TERRACOTTA_COVER = new GenericCoverBlock("green_terracotta", Map.of("main", new Identifier("minecraft:green_terracotta")));
        RED_TERRACOTTA_COVER = new GenericCoverBlock("red_terracotta", Map.of("main", new Identifier("minecraft:red_terracotta")));
        BLACK_TERRACOTTA_COVER = new GenericCoverBlock("black_terracotta", Map.of("main", new Identifier("minecraft:black_terracotta")));
        WHITE_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("white_glazed_terracotta", Map.of("main", new Identifier("minecraft:white_glazed_terracotta")));
        ORANGE_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("orange_glazed_terracotta", Map.of("main", new Identifier("minecraft:orange_glazed_terracotta")));
        MAGENTA_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("magenta_glazed_terracotta", Map.of("main", new Identifier("minecraft:magenta_glazed_terracotta")));
        LIGHT_BLUE_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("light_blue_glazed_terracotta", Map.of("main", new Identifier("minecraft:light_blue_glazed_terracotta")));
        YELLOW_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("yellow_glazed_terracotta", Map.of("main", new Identifier("minecraft:yellow_glazed_terracotta")));
        LIME_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("lime_glazed_terracotta", Map.of("main", new Identifier("minecraft:lime_glazed_terracotta")));
        PINK_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("pink_glazed_terracotta", Map.of("main", new Identifier("minecraft:pink_glazed_terracotta")));
        GRAY_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("gray_glazed_terracotta", Map.of("main", new Identifier("minecraft:gray_glazed_terracotta")));
        LIGHT_GRAY_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("light_gray_glazed_terracotta", Map.of("main", new Identifier("minecraft:light_gray_glazed_terracotta")));
        CYAN_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("cyan_glazed_terracotta", Map.of("main", new Identifier("minecraft:cyan_glazed_terracotta")));
        PURPLE_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("purple_glazed_terracotta", Map.of("main", new Identifier("minecraft:purple_glazed_terracotta")));
        BLUE_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("blue_glazed_terracotta", Map.of("main", new Identifier("minecraft:blue_glazed_terracotta")));
        BROWN_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("brown_glazed_terracotta", Map.of("main", new Identifier("minecraft:brown_glazed_terracotta")));
        GREEN_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("green_glazed_terracotta", Map.of("main", new Identifier("minecraft:green_glazed_terracotta")));
        RED_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("red_glazed_terracotta", Map.of("main", new Identifier("minecraft:red_glazed_terracotta")));
        BLACK_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock("black_glazed_terracotta", Map.of("main", new Identifier("minecraft:black_glazed_terracotta")));
        WHITE_CONCRETE_COVER = new GenericCoverBlock("white_concrete", Map.of("main", new Identifier("minecraft:white_concrete")));
        ORANGE_CONCRETE_COVER = new GenericCoverBlock("orange_concrete", Map.of("main", new Identifier("minecraft:orange_concrete")));
        MAGENTA_CONCRETE_COVER = new GenericCoverBlock("magenta_concrete", Map.of("main", new Identifier("minecraft:magenta_concrete")));
        LIGHT_BLUE_CONCRETE_COVER = new GenericCoverBlock("light_blue_concrete", Map.of("main", new Identifier("minecraft:light_blue_concrete")));
        YELLOW_CONCRETE_COVER = new GenericCoverBlock("yellow_concrete", Map.of("main", new Identifier("minecraft:yellow_concrete")));
        LIME_CONCRETE_COVER = new GenericCoverBlock("lime_concrete", Map.of("main", new Identifier("minecraft:lime_concrete")));
        PINK_CONCRETE_COVER = new GenericCoverBlock("pink_concrete", Map.of("main", new Identifier("minecraft:pink_concrete")));
        GRAY_CONCRETE_COVER = new GenericCoverBlock("gray_concrete", Map.of("main", new Identifier("minecraft:gray_concrete")));
        LIGHT_GRAY_CONCRETE_COVER = new GenericCoverBlock("light_gray_concrete", Map.of("main", new Identifier("minecraft:light_gray_concrete")));
        CYAN_CONCRETE_COVER = new GenericCoverBlock("cyan_concrete", Map.of("main", new Identifier("minecraft:cyan_concrete")));
        PURPLE_CONCRETE_COVER = new GenericCoverBlock("purple_concrete", Map.of("main", new Identifier("minecraft:purple_concrete")));
        BLUE_CONCRETE_COVER = new GenericCoverBlock("blue_concrete", Map.of("main", new Identifier("minecraft:blue_concrete")));
        BROWN_CONCRETE_COVER = new GenericCoverBlock("brown_concrete", Map.of("main", new Identifier("minecraft:brown_concrete")));
        GREEN_CONCRETE_COVER = new GenericCoverBlock("green_concrete", Map.of("main", new Identifier("minecraft:green_concrete")));
        RED_CONCRETE_COVER = new GenericCoverBlock("red_concrete", Map.of("main", new Identifier("minecraft:red_concrete")));
        BLACK_CONCRETE_COVER = new GenericCoverBlock("black_concrete", Map.of("main", new Identifier("minecraft:black_concrete")));
        ACACIA_LOG_COVER = new GenericCoverBlock("acacia_log", Map.of("main", new Identifier("minecraft:acacia_log"), "end", new Identifier("minecraft:acacia_log_top")));
        BIRCH_LOG_COVER = new GenericCoverBlock("birch_log", Map.of("main", new Identifier("minecraft:birch_log"), "end", new Identifier("minecraft:birch_log_top")));
        CRIMSON_STEM_COVER = new GenericCoverBlock("crimson_stem", Map.of("main", new Identifier("minecraft:crimson_stem"), "end", new Identifier("minecraft:crimson_stem_top")));
        DARK_OAK_LOG_COVER = new GenericCoverBlock("dark_oak_log", Map.of("main", new Identifier("minecraft:dark_oak_log"), "end", new Identifier("minecraft:dark_oak_log_top")));
        JUNGLE_LOG_COVER = new GenericCoverBlock("jungle_log", Map.of("main", new Identifier("minecraft:jungle_log"), "end", new Identifier("minecraft:jungle_log_top")));
        OAK_LOG_COVER = new GenericCoverBlock("oak_log", Map.of("main", new Identifier("minecraft:oak_log"), "end", new Identifier("minecraft:oak_log_top")));
        SPRUCE_LOG_COVER = new GenericCoverBlock("spruce_log", Map.of("main", new Identifier("minecraft:spruce_log"), "end", new Identifier("minecraft:spruce_log_top")));
        WARPED_STEM_COVER = new GenericCoverBlock("warped_stem", Map.of("main", new Identifier("minecraft:warped_stem"), "end", new Identifier("minecraft:warped_stem_top")));
        ACACIA_PLANK_COVER = new GenericCoverBlock("acacia_plank", Map.of("main", new Identifier("minecraft:acacia_planks")));
        BIRCH_PLANK_COVER = new GenericCoverBlock("birch_plank", Map.of("main", new Identifier("minecraft:birch_planks")));
        CRIMSON_PLANK_COVER = new GenericCoverBlock("crimson_plank", Map.of("main", new Identifier("minecraft:crimson_planks")));
        DARK_OAK_PLANK_COVER = new GenericCoverBlock("dark_oak_plank", Map.of("main", new Identifier("minecraft:dark_oak_planks")));
        JUNGLE_PLANK_COVER = new GenericCoverBlock("jungle_plank", Map.of("main", new Identifier("minecraft:jungle_planks")));
        OAK_PLANK_COVER = new GenericCoverBlock("oak_plank", Map.of("main", new Identifier("minecraft:oak_planks")));
        SPRUCE_PLANK_COVER = new GenericCoverBlock("spruce_plank", Map.of("main", new Identifier("minecraft:spruce_planks")));
        WARPED_PLANK_COVER = new GenericCoverBlock("warped_plank", Map.of("main", new Identifier("minecraft:warped_planks")));
    }

    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        AMETHYST_COVER.register(false);
        ANDESITE_COVER.register(false);
        BASALT_COVER.register(false);
        BASALT_BRICK_COVER.register(false);
        BLACKSTONE_COVER.register(false);
        BONE_COVER.register(false);
        BRICK_COVER.register(false);
        CALCITE_COVER.register(false);
        COBBLED_DEEPSLATE_COVER.register(false);
        COBBLED_END_STONE_COVER.register(false);
        COBBLESTONE_COVER.register(false);
        CRACKED_BASALT_BRICK_COVER.register(false);
        CRACKED_DEEPSLATE_BRICK_COVER.register(false);
        CRACKED_DEEPSLATE_TILE_COVER.register(false);
        CRACKED_STONE_BRICK_COVER.register(false);
        CRIMSON_BASALT_BRICK_COVER.register(false);
        CRYING_OBSIDIAN_COVER.register(false);
        CUT_RED_SANDSTONE_COVER.register(false);
        CUT_SANDSTONE_COVER.register(false);
        DARK_PRISMARINE_COVER.register(false);
        DEEPSLATE_COVER.register(false);
        DEEPSLATE_BRICK_COVER.register(false);
        DEEPSLATE_TILE_COVER.register(false);
        DIORITE_COVER.register(false);
        END_STONE_COVER.register(false);
        END_STONE_BRICK_COVER.register(false);
        GRANITE_COVER.register(false);
        MOSSY_BASALT_BRICK_COVER.register(false);
        MOSSY_COBBLESTONE_COVER.register(false);
        MOSSY_STONE_BRICK_COVER.register(false);
        NETHER_BRICK_COVER.register(false);
        NETHERRACK_COVER.register(false);
        OBSIDIAN_COVER.register(false);
        POLISHED_ANDESITE_COVER.register(false);
        POLISHED_BASALT_COVER.register(false);
        POLISHED_BLACKSTONE_COVER.register(false);
        POLISHED_BLACKSTONE_BRICK_COVER.register(false);
        POLISHED_DEEPSLATE_COVER.register(false);
        POLISHED_DIORITE_COVER.register(false);
        POLISHED_GRANITE_COVER.register(false);
        PRISMARINE_COVER.register(false);
        PRISMARINE_BRICK_COVER.register(false);
        PURPUR_COVER.register(false);
        PURPUR_PILLAR_COVER.register(false);
        RED_NETHER_BRICK_COVER.register(false);
        RED_SANDSTONE_COVER.register(false);
        SANDSTONE_COVER.register(false);
        SMOOTH_BASALT_COVER.register(false);
        SMOOTH_RED_SANDSTONE_COVER.register(false);
        SMOOTH_SANDSTONE_COVER.register(false);
        SMOOTH_STONE_COVER.register(false);
        STONE_COVER.register(false);
        STONE_BRICK_COVER.register(false);
        TUFF_COVER.register(false);
        WARPED_BASALT_BRICK_COVER.register(false);
        WARPED_NETHER_BRICK_COVER.register(false);
        WHITE_TERRACOTTA_COVER.register(false);
        ORANGE_TERRACOTTA_COVER.register(false);
        MAGENTA_TERRACOTTA_COVER.register(false);
        LIGHT_BLUE_TERRACOTTA_COVER.register(false);
        YELLOW_TERRACOTTA_COVER.register(false);
        LIME_TERRACOTTA_COVER.register(false);
        PINK_TERRACOTTA_COVER.register(false);
        GRAY_TERRACOTTA_COVER.register(false);
        LIGHT_GRAY_TERRACOTTA_COVER.register(false);
        CYAN_TERRACOTTA_COVER.register(false);
        PURPLE_TERRACOTTA_COVER.register(false);
        BLUE_TERRACOTTA_COVER.register(false);
        BROWN_TERRACOTTA_COVER.register(false);
        GREEN_TERRACOTTA_COVER.register(false);
        RED_TERRACOTTA_COVER.register(false);
        BLACK_TERRACOTTA_COVER.register(false);
        WHITE_GLAZED_TERRACOTTA_COVER.register(false);
        ORANGE_GLAZED_TERRACOTTA_COVER.register(false);
        MAGENTA_GLAZED_TERRACOTTA_COVER.register(false);
        LIGHT_BLUE_GLAZED_TERRACOTTA_COVER.register(false);
        YELLOW_GLAZED_TERRACOTTA_COVER.register(false);
        LIME_GLAZED_TERRACOTTA_COVER.register(false);
        PINK_GLAZED_TERRACOTTA_COVER.register(false);
        GRAY_GLAZED_TERRACOTTA_COVER.register(false);
        LIGHT_GRAY_GLAZED_TERRACOTTA_COVER.register(false);
        CYAN_GLAZED_TERRACOTTA_COVER.register(false);
        PURPLE_GLAZED_TERRACOTTA_COVER.register(false);
        BLUE_GLAZED_TERRACOTTA_COVER.register(false);
        BROWN_GLAZED_TERRACOTTA_COVER.register(false);
        GREEN_GLAZED_TERRACOTTA_COVER.register(false);
        RED_GLAZED_TERRACOTTA_COVER.register(false);
        BLACK_GLAZED_TERRACOTTA_COVER.register(false);
        WHITE_CONCRETE_COVER.register(false);
        ORANGE_CONCRETE_COVER.register(false);
        MAGENTA_CONCRETE_COVER.register(false);
        LIGHT_BLUE_CONCRETE_COVER.register(false);
        YELLOW_CONCRETE_COVER.register(false);
        LIME_CONCRETE_COVER.register(false);
        PINK_CONCRETE_COVER.register(false);
        GRAY_CONCRETE_COVER.register(false);
        LIGHT_GRAY_CONCRETE_COVER.register(false);
        CYAN_CONCRETE_COVER.register(false);
        PURPLE_CONCRETE_COVER.register(false);
        BLUE_CONCRETE_COVER.register(false);
        BROWN_CONCRETE_COVER.register(false);
        GREEN_CONCRETE_COVER.register(false);
        RED_CONCRETE_COVER.register(false);
        BLACK_CONCRETE_COVER.register(false);
        ACACIA_LOG_COVER.register();
        BIRCH_LOG_COVER.register();
        CRIMSON_STEM_COVER.register(false);
        DARK_OAK_LOG_COVER.register();
        JUNGLE_LOG_COVER.register();
        OAK_LOG_COVER.register();
        SPRUCE_LOG_COVER.register();
        WARPED_STEM_COVER.register(false);
        ACACIA_PLANK_COVER.register();
        BIRCH_PLANK_COVER.register();
        CRIMSON_PLANK_COVER.register(false);
        DARK_OAK_PLANK_COVER.register();
        JUNGLE_PLANK_COVER.register();
        OAK_PLANK_COVER.register();
        SPRUCE_PLANK_COVER.register();
        WARPED_PLANK_COVER.register(false);
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
