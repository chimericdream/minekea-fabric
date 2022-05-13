package com.chimericdream.minekea.block.beams;

import com.chimericdream.minekea.block.building.basalt_bricks.*;
import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBricksBlock;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class Beams implements MinekeaBlockCategory {
    public static final GenericBeamBlock ANDESITE_BEAM;
    public static final GenericBeamBlock BASALT_BEAM;
    public static final GenericBeamBlock BASALT_BRICK_BEAM;
    public static final GenericBeamBlock BLACKSTONE_BEAM;
    public static final GenericBeamBlock BONE_BEAM;
    public static final GenericBeamBlock BRICK_BEAM;
    public static final GenericBeamBlock CALCITE_BEAM;
    public static final GenericBeamBlock COBBLED_DEEPSLATE_BEAM;
    public static final GenericBeamBlock COBBLESTONE_BEAM;
    public static final GenericBeamBlock CRACKED_BASALT_BRICK_BEAM;
    public static final GenericBeamBlock CRACKED_DEEPSLATE_BRICK_BEAM;
    public static final GenericBeamBlock CRACKED_DEEPSLATE_TILE_BEAM;
    public static final GenericBeamBlock CRACKED_STONE_BRICK_BEAM;
    public static final GenericBeamBlock CRIMSON_BASALT_BRICK_BEAM;
    public static final GenericBeamBlock CRYING_OBSIDIAN_BEAM;
    public static final GenericBeamBlock CUT_RED_SANDSTONE_BEAM;
    public static final GenericBeamBlock CUT_SANDSTONE_BEAM;
    public static final GenericBeamBlock DARK_PRISMARINE_BEAM;
    public static final GenericBeamBlock DEEPSLATE_BEAM;
    public static final GenericBeamBlock DEEPSLATE_BRICK_BEAM;
    public static final GenericBeamBlock DEEPSLATE_TILE_BEAM;
    public static final GenericBeamBlock DIORITE_BEAM;
    public static final GenericBeamBlock END_STONE_BEAM;
    public static final GenericBeamBlock END_STONE_BRICK_BEAM;
    public static final GenericBeamBlock GRANITE_BEAM;
    public static final GenericBeamBlock MOSSY_BASALT_BRICK_BEAM;
    public static final GenericBeamBlock MOSSY_COBBLESTONE_BEAM;
    public static final GenericBeamBlock MOSSY_STONE_BRICK_BEAM;
    public static final GenericBeamBlock NETHER_BRICK_BEAM;
    public static final GenericBeamBlock NETHERRACK_BEAM;
    public static final GenericBeamBlock OBSIDIAN_BEAM;
    public static final GenericBeamBlock POLISHED_ANDESITE_BEAM;
    public static final GenericBeamBlock POLISHED_BLACKSTONE_BEAM;
    public static final GenericBeamBlock POLISHED_BLACKSTONE_BRICK_BEAM;
    public static final GenericBeamBlock POLISHED_DEEPSLATE_BEAM;
    public static final GenericBeamBlock POLISHED_DIORITE_BEAM;
    public static final GenericBeamBlock POLISHED_GRANITE_BEAM;
    public static final GenericBeamBlock PRISMARINE_BEAM;
    public static final GenericBeamBlock PRISMARINE_BRICK_BEAM;
    public static final GenericBeamBlock PURPUR_BEAM;
    public static final GenericBeamBlock PURPUR_PILLAR_BEAM;
    public static final GenericBeamBlock RED_NETHER_BRICK_BEAM;
    public static final GenericBeamBlock RED_SANDSTONE_BEAM;
    public static final GenericBeamBlock SANDSTONE_BEAM;
    public static final GenericBeamBlock SMOOTH_BASALT_BEAM;
    public static final GenericBeamBlock SMOOTH_STONE_BEAM;
    public static final GenericBeamBlock STONE_BEAM;
    public static final GenericBeamBlock STONE_BRICK_BEAM;
    public static final GenericBeamBlock TUFF_BEAM;
    public static final GenericBeamBlock WARPED_BASALT_BRICK_BEAM;
    public static final GenericBeamBlock WARPED_NETHER_BRICK_BEAM;

    public static final GenericBeamBlock AMETHYST_BEAM;
    public static final GenericBeamBlock POLISHED_BASALT_BEAM;
    public static final GenericBeamBlock SMOOTH_RED_SANDSTONE_BEAM;
    public static final GenericBeamBlock SMOOTH_SANDSTONE_BEAM;

    public static final GenericBeamBlock WHITE_TERRACOTTA_BEAM;
    public static final GenericBeamBlock ORANGE_TERRACOTTA_BEAM;
    public static final GenericBeamBlock MAGENTA_TERRACOTTA_BEAM;
    public static final GenericBeamBlock LIGHT_BLUE_TERRACOTTA_BEAM;
    public static final GenericBeamBlock YELLOW_TERRACOTTA_BEAM;
    public static final GenericBeamBlock LIME_TERRACOTTA_BEAM;
    public static final GenericBeamBlock PINK_TERRACOTTA_BEAM;
    public static final GenericBeamBlock GRAY_TERRACOTTA_BEAM;
    public static final GenericBeamBlock LIGHT_GRAY_TERRACOTTA_BEAM;
    public static final GenericBeamBlock CYAN_TERRACOTTA_BEAM;
    public static final GenericBeamBlock PURPLE_TERRACOTTA_BEAM;
    public static final GenericBeamBlock BLUE_TERRACOTTA_BEAM;
    public static final GenericBeamBlock BROWN_TERRACOTTA_BEAM;
    public static final GenericBeamBlock GREEN_TERRACOTTA_BEAM;
    public static final GenericBeamBlock RED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock BLACK_TERRACOTTA_BEAM;
    public static final GenericBeamBlock WHITE_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock ORANGE_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock MAGENTA_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock LIGHT_BLUE_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock YELLOW_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock LIME_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock PINK_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock GRAY_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock LIGHT_GRAY_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock CYAN_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock PURPLE_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock BLUE_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock BROWN_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock GREEN_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock RED_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock BLACK_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock WHITE_CONCRETE_BEAM;
    public static final GenericBeamBlock ORANGE_CONCRETE_BEAM;
    public static final GenericBeamBlock MAGENTA_CONCRETE_BEAM;
    public static final GenericBeamBlock LIGHT_BLUE_CONCRETE_BEAM;
    public static final GenericBeamBlock YELLOW_CONCRETE_BEAM;
    public static final GenericBeamBlock LIME_CONCRETE_BEAM;
    public static final GenericBeamBlock PINK_CONCRETE_BEAM;
    public static final GenericBeamBlock GRAY_CONCRETE_BEAM;
    public static final GenericBeamBlock LIGHT_GRAY_CONCRETE_BEAM;
    public static final GenericBeamBlock CYAN_CONCRETE_BEAM;
    public static final GenericBeamBlock PURPLE_CONCRETE_BEAM;
    public static final GenericBeamBlock BLUE_CONCRETE_BEAM;
    public static final GenericBeamBlock BROWN_CONCRETE_BEAM;
    public static final GenericBeamBlock GREEN_CONCRETE_BEAM;
    public static final GenericBeamBlock RED_CONCRETE_BEAM;
    public static final GenericBeamBlock BLACK_CONCRETE_BEAM;
    public static final GenericBeamBlock ACACIA_LOG_BEAM;
    public static final GenericBeamBlock BIRCH_LOG_BEAM;
    public static final GenericBeamBlock CRIMSON_STEM_BEAM;
    public static final GenericBeamBlock DARK_OAK_LOG_BEAM;
    public static final GenericBeamBlock JUNGLE_LOG_BEAM;
    public static final GenericBeamBlock OAK_LOG_BEAM;
    public static final GenericBeamBlock SPRUCE_LOG_BEAM;
    public static final GenericBeamBlock WARPED_STEM_BEAM;
    public static final GenericBeamBlock ACACIA_PLANK_BEAM;
    public static final GenericBeamBlock BIRCH_PLANK_BEAM;
    public static final GenericBeamBlock CRIMSON_PLANK_BEAM;
    public static final GenericBeamBlock DARK_OAK_PLANK_BEAM;
    public static final GenericBeamBlock JUNGLE_PLANK_BEAM;
    public static final GenericBeamBlock OAK_PLANK_BEAM;
    public static final GenericBeamBlock SPRUCE_PLANK_BEAM;
    public static final GenericBeamBlock WARPED_PLANK_BEAM;

    static {
        ANDESITE_BEAM = new GenericBeamBlock("andesite", Map.of("main", new Identifier("minecraft:andesite")));
        BASALT_BRICK_BEAM = new GenericBeamBlock("basalt_brick", Map.of("main", BasaltBricksBlock.BLOCK_ID));
        BLACKSTONE_BEAM = new GenericBeamBlock("blackstone", Map.of("main", new Identifier("minecraft:blackstone")));
        BRICK_BEAM = new GenericBeamBlock("brick", Map.of("main", new Identifier("minecraft:bricks")));
        CALCITE_BEAM = new GenericBeamBlock("calcite", Map.of("main", new Identifier("minecraft:calcite")));
        COBBLED_DEEPSLATE_BEAM = new GenericBeamBlock("cobbled_deepslate", Map.of("main", new Identifier("minecraft:cobbled_deepslate")));
        COBBLESTONE_BEAM = new GenericBeamBlock("cobblestone", Map.of("main", new Identifier("minecraft:cobblestone")));
        CRACKED_BASALT_BRICK_BEAM = new GenericBeamBlock("cracked_basalt_brick", Map.of("main", CrackedBasaltBricksBlock.BLOCK_ID));
        CRACKED_DEEPSLATE_BRICK_BEAM = new GenericBeamBlock("cracked_deepslate_brick", Map.of("main", new Identifier("minecraft:cracked_deepslate_bricks")));
        CRACKED_DEEPSLATE_TILE_BEAM = new GenericBeamBlock("cracked_deepslate_tile", Map.of("main", new Identifier("minecraft:cracked_deepslate_tiles")));
        CRACKED_STONE_BRICK_BEAM = new GenericBeamBlock("cracked_stone_brick", Map.of("main", new Identifier("minecraft:cracked_stone_bricks")));
        CRIMSON_BASALT_BRICK_BEAM = new GenericBeamBlock("crimson_basalt_brick", Map.of("main", CrimsonBasaltBricksBlock.BLOCK_ID));
        CRYING_OBSIDIAN_BEAM = new GenericBeamBlock("crying_obsidian", Map.of("main", new Identifier("minecraft:crying_obsidian")));
        CUT_RED_SANDSTONE_BEAM = new GenericBeamBlock("cut_red_sandstone", Map.of("main", new Identifier("minecraft:cut_red_sandstone")));
        CUT_SANDSTONE_BEAM = new GenericBeamBlock("cut_sandstone", Map.of("main", new Identifier("minecraft:cut_sandstone")));
        DARK_PRISMARINE_BEAM = new GenericBeamBlock("dark_prismarine", Map.of("main", new Identifier("minecraft:dark_prismarine")));
        DEEPSLATE_BEAM = new GenericBeamBlock("deepslate", Map.of("main", new Identifier("minecraft:deepslate")));
        DEEPSLATE_BRICK_BEAM = new GenericBeamBlock("deepslate_brick", Map.of("main", new Identifier("minecraft:deepslate_bricks")));
        DEEPSLATE_TILE_BEAM = new GenericBeamBlock("deepslate_tile", Map.of("main", new Identifier("minecraft:deepslate_tiles")));
        DIORITE_BEAM = new GenericBeamBlock("diorite", Map.of("main", new Identifier("minecraft:diorite")));
        END_STONE_BEAM = new GenericBeamBlock("end_stone", Map.of("main", new Identifier("minecraft:end_stone")));
        END_STONE_BRICK_BEAM = new GenericBeamBlock("end_stone_brick", Map.of("main", new Identifier("minecraft:end_stone_bricks")));
        GRANITE_BEAM = new GenericBeamBlock("granite", Map.of("main", new Identifier("minecraft:granite")));
        MOSSY_BASALT_BRICK_BEAM = new GenericBeamBlock("mossy_basalt_brick", Map.of("main", MossyBasaltBricksBlock.BLOCK_ID));
        MOSSY_COBBLESTONE_BEAM = new GenericBeamBlock("mossy_cobblestone", Map.of("main", new Identifier("minecraft:mossy_cobblestone")));
        MOSSY_STONE_BRICK_BEAM = new GenericBeamBlock("mossy_stone_brick", Map.of("main", new Identifier("minecraft:mossy_stone_bricks")));
        NETHER_BRICK_BEAM = new GenericBeamBlock("nether_brick", Map.of("main", new Identifier("minecraft:nether_bricks")));
        NETHERRACK_BEAM = new GenericBeamBlock("netherrack", Map.of("main", new Identifier("minecraft:netherrack")));
        OBSIDIAN_BEAM = new GenericBeamBlock("obsidian", Map.of("main", new Identifier("minecraft:obsidian")));
        POLISHED_ANDESITE_BEAM = new GenericBeamBlock("polished_andesite", Map.of("main", new Identifier("minecraft:polished_andesite")));
        POLISHED_BLACKSTONE_BEAM = new GenericBeamBlock("polished_blackstone", Map.of("main", new Identifier("minecraft:polished_blackstone")));
        POLISHED_BLACKSTONE_BRICK_BEAM = new GenericBeamBlock("polished_blackstone_brick", Map.of("main", new Identifier("minecraft:polished_blackstone_bricks")));
        POLISHED_DEEPSLATE_BEAM = new GenericBeamBlock("polished_deepslate", Map.of("main", new Identifier("minecraft:polished_deepslate")));
        POLISHED_DIORITE_BEAM = new GenericBeamBlock("polished_diorite", Map.of("main", new Identifier("minecraft:polished_diorite")));
        POLISHED_GRANITE_BEAM = new GenericBeamBlock("polished_granite", Map.of("main", new Identifier("minecraft:polished_granite")));
        PRISMARINE_BEAM = new GenericBeamBlock("prismarine", Map.of("main", new Identifier("minecraft:prismarine")));
        PRISMARINE_BRICK_BEAM = new GenericBeamBlock("prismarine_brick", Map.of("main", new Identifier("minecraft:prismarine_bricks")));
        PURPUR_PILLAR_BEAM = new GenericBeamBlock("purpur_pillar", Map.of("main", new Identifier("minecraft:purpur_pillar")));
        RED_NETHER_BRICK_BEAM = new GenericBeamBlock("red_nether_brick", Map.of("main", new Identifier("minecraft:red_nether_bricks")));
        RED_SANDSTONE_BEAM = new GenericBeamBlock("red_sandstone", Map.of("main", new Identifier("minecraft:red_sandstone")));
        SANDSTONE_BEAM = new GenericBeamBlock("sandstone", Map.of("main", new Identifier("minecraft:sandstone")));
        SMOOTH_BASALT_BEAM = new GenericBeamBlock("smooth_basalt", Map.of("main", new Identifier("minecraft:smooth_basalt")));
        SMOOTH_STONE_BEAM = new GenericBeamBlock("smooth_stone", Map.of("main", new Identifier("minecraft:smooth_stone")));
        STONE_BEAM = new GenericBeamBlock("stone", Map.of("main", new Identifier("minecraft:stone")));
        STONE_BRICK_BEAM = new GenericBeamBlock("stone_brick", Map.of("main", new Identifier("minecraft:stone_bricks")));
        TUFF_BEAM = new GenericBeamBlock("tuff", Map.of("main", new Identifier("minecraft:tuff")));
        WARPED_BASALT_BRICK_BEAM = new GenericBeamBlock("warped_basalt_brick", Map.of("main", WarpedBasaltBricksBlock.BLOCK_ID));
        WARPED_NETHER_BRICK_BEAM = new GenericBeamBlock("warped_nether_brick", Map.of("main", WarpedNetherBricksBlock.BLOCK_ID));

        AMETHYST_BEAM = new GenericBeamBlock(
            "amethyst",
            Map.of(
                "main", new Identifier("minecraft:amethyst_block"),
                "ingredient", new Identifier("minecraft:amethyst_shard")
            )
        );
        BASALT_BEAM = new GenericBeamBlock(
            "basalt",
            Map.of(
                "main", new Identifier("minecraft:basalt_side"),
                "end", new Identifier("minecraft:basalt_top"),
                "ingredient", new Identifier("minecraft:basalt")
            )
        );
        BONE_BEAM = new GenericBeamBlock(
            "bone",
            Map.of(
                "main", new Identifier("minecraft:bone_block_side"),
                "end", new Identifier("minecraft:bone_block_top"),
                "ingredient", new Identifier("minecraft:bone_block")
            )
        );
        POLISHED_BASALT_BEAM = new GenericBeamBlock(
            "polished_basalt",
            Map.of(
                "main", new Identifier("minecraft:polished_basalt_side"),
                "end", new Identifier("minecraft:polished_basalt_top"),
                "ingredient", new Identifier("minecraft:polished_basalt")
            )
        );
        PURPUR_BEAM = new GenericBeamBlock(
            "purpur",
            Map.of(
                "main", new Identifier("minecraft:purpur_block")
            )
        );
        SMOOTH_RED_SANDSTONE_BEAM = new GenericBeamBlock(
            "smooth_red_sandstone",
            Map.of(
                "main", new Identifier("minecraft:red_sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_red_sandstone")
            )
        );
        SMOOTH_SANDSTONE_BEAM = new GenericBeamBlock(
            "smooth_sandstone",
            Map.of(
                "main", new Identifier("minecraft:sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_sandstone")
            )
        );

        WHITE_TERRACOTTA_BEAM = new GenericBeamBlock("white_terracotta", Map.of("main", new Identifier("minecraft:white_terracotta")));
        ORANGE_TERRACOTTA_BEAM = new GenericBeamBlock("orange_terracotta", Map.of("main", new Identifier("minecraft:orange_terracotta")));
        MAGENTA_TERRACOTTA_BEAM = new GenericBeamBlock("magenta_terracotta", Map.of("main", new Identifier("minecraft:magenta_terracotta")));
        LIGHT_BLUE_TERRACOTTA_BEAM = new GenericBeamBlock("light_blue_terracotta", Map.of("main", new Identifier("minecraft:light_blue_terracotta")));
        YELLOW_TERRACOTTA_BEAM = new GenericBeamBlock("yellow_terracotta", Map.of("main", new Identifier("minecraft:yellow_terracotta")));
        LIME_TERRACOTTA_BEAM = new GenericBeamBlock("lime_terracotta", Map.of("main", new Identifier("minecraft:lime_terracotta")));
        PINK_TERRACOTTA_BEAM = new GenericBeamBlock("pink_terracotta", Map.of("main", new Identifier("minecraft:pink_terracotta")));
        GRAY_TERRACOTTA_BEAM = new GenericBeamBlock("gray_terracotta", Map.of("main", new Identifier("minecraft:gray_terracotta")));
        LIGHT_GRAY_TERRACOTTA_BEAM = new GenericBeamBlock("light_gray_terracotta", Map.of("main", new Identifier("minecraft:light_gray_terracotta")));
        CYAN_TERRACOTTA_BEAM = new GenericBeamBlock("cyan_terracotta", Map.of("main", new Identifier("minecraft:cyan_terracotta")));
        PURPLE_TERRACOTTA_BEAM = new GenericBeamBlock("purple_terracotta", Map.of("main", new Identifier("minecraft:purple_terracotta")));
        BLUE_TERRACOTTA_BEAM = new GenericBeamBlock("blue_terracotta", Map.of("main", new Identifier("minecraft:blue_terracotta")));
        BROWN_TERRACOTTA_BEAM = new GenericBeamBlock("brown_terracotta", Map.of("main", new Identifier("minecraft:brown_terracotta")));
        GREEN_TERRACOTTA_BEAM = new GenericBeamBlock("green_terracotta", Map.of("main", new Identifier("minecraft:green_terracotta")));
        RED_TERRACOTTA_BEAM = new GenericBeamBlock("red_terracotta", Map.of("main", new Identifier("minecraft:red_terracotta")));
        BLACK_TERRACOTTA_BEAM = new GenericBeamBlock("black_terracotta", Map.of("main", new Identifier("minecraft:black_terracotta")));
        WHITE_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("white_glazed_terracotta", Map.of("main", new Identifier("minecraft:white_glazed_terracotta")));
        ORANGE_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("orange_glazed_terracotta", Map.of("main", new Identifier("minecraft:orange_glazed_terracotta")));
        MAGENTA_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("magenta_glazed_terracotta", Map.of("main", new Identifier("minecraft:magenta_glazed_terracotta")));
        LIGHT_BLUE_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("light_blue_glazed_terracotta", Map.of("main", new Identifier("minecraft:light_blue_glazed_terracotta")));
        YELLOW_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("yellow_glazed_terracotta", Map.of("main", new Identifier("minecraft:yellow_glazed_terracotta")));
        LIME_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("lime_glazed_terracotta", Map.of("main", new Identifier("minecraft:lime_glazed_terracotta")));
        PINK_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("pink_glazed_terracotta", Map.of("main", new Identifier("minecraft:pink_glazed_terracotta")));
        GRAY_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("gray_glazed_terracotta", Map.of("main", new Identifier("minecraft:gray_glazed_terracotta")));
        LIGHT_GRAY_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("light_gray_glazed_terracotta", Map.of("main", new Identifier("minecraft:light_gray_glazed_terracotta")));
        CYAN_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("cyan_glazed_terracotta", Map.of("main", new Identifier("minecraft:cyan_glazed_terracotta")));
        PURPLE_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("purple_glazed_terracotta", Map.of("main", new Identifier("minecraft:purple_glazed_terracotta")));
        BLUE_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("blue_glazed_terracotta", Map.of("main", new Identifier("minecraft:blue_glazed_terracotta")));
        BROWN_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("brown_glazed_terracotta", Map.of("main", new Identifier("minecraft:brown_glazed_terracotta")));
        GREEN_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("green_glazed_terracotta", Map.of("main", new Identifier("minecraft:green_glazed_terracotta")));
        RED_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("red_glazed_terracotta", Map.of("main", new Identifier("minecraft:red_glazed_terracotta")));
        BLACK_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock("black_glazed_terracotta", Map.of("main", new Identifier("minecraft:black_glazed_terracotta")));
        WHITE_CONCRETE_BEAM = new GenericBeamBlock("white_concrete", Map.of("main", new Identifier("minecraft:white_concrete")));
        ORANGE_CONCRETE_BEAM = new GenericBeamBlock("orange_concrete", Map.of("main", new Identifier("minecraft:orange_concrete")));
        MAGENTA_CONCRETE_BEAM = new GenericBeamBlock("magenta_concrete", Map.of("main", new Identifier("minecraft:magenta_concrete")));
        LIGHT_BLUE_CONCRETE_BEAM = new GenericBeamBlock("light_blue_concrete", Map.of("main", new Identifier("minecraft:light_blue_concrete")));
        YELLOW_CONCRETE_BEAM = new GenericBeamBlock("yellow_concrete", Map.of("main", new Identifier("minecraft:yellow_concrete")));
        LIME_CONCRETE_BEAM = new GenericBeamBlock("lime_concrete", Map.of("main", new Identifier("minecraft:lime_concrete")));
        PINK_CONCRETE_BEAM = new GenericBeamBlock("pink_concrete", Map.of("main", new Identifier("minecraft:pink_concrete")));
        GRAY_CONCRETE_BEAM = new GenericBeamBlock("gray_concrete", Map.of("main", new Identifier("minecraft:gray_concrete")));
        LIGHT_GRAY_CONCRETE_BEAM = new GenericBeamBlock("light_gray_concrete", Map.of("main", new Identifier("minecraft:light_gray_concrete")));
        CYAN_CONCRETE_BEAM = new GenericBeamBlock("cyan_concrete", Map.of("main", new Identifier("minecraft:cyan_concrete")));
        PURPLE_CONCRETE_BEAM = new GenericBeamBlock("purple_concrete", Map.of("main", new Identifier("minecraft:purple_concrete")));
        BLUE_CONCRETE_BEAM = new GenericBeamBlock("blue_concrete", Map.of("main", new Identifier("minecraft:blue_concrete")));
        BROWN_CONCRETE_BEAM = new GenericBeamBlock("brown_concrete", Map.of("main", new Identifier("minecraft:brown_concrete")));
        GREEN_CONCRETE_BEAM = new GenericBeamBlock("green_concrete", Map.of("main", new Identifier("minecraft:green_concrete")));
        RED_CONCRETE_BEAM = new GenericBeamBlock("red_concrete", Map.of("main", new Identifier("minecraft:red_concrete")));
        BLACK_CONCRETE_BEAM = new GenericBeamBlock("black_concrete", Map.of("main", new Identifier("minecraft:black_concrete")));
        ACACIA_LOG_BEAM = new GenericBeamBlock("acacia_log", Map.of("main", new Identifier("minecraft:acacia_log"), "end", new Identifier("minecraft:acacia_log_top")));
        BIRCH_LOG_BEAM = new GenericBeamBlock("birch_log", Map.of("main", new Identifier("minecraft:birch_log"), "end", new Identifier("minecraft:birch_log_top")));
        CRIMSON_STEM_BEAM = new GenericBeamBlock("crimson_stem", Map.of("main", new Identifier("minecraft:crimson_stem"), "end", new Identifier("minecraft:crimson_stem_top")));
        DARK_OAK_LOG_BEAM = new GenericBeamBlock("dark_oak_log", Map.of("main", new Identifier("minecraft:dark_oak_log"), "end", new Identifier("minecraft:dark_oak_log_top")));
        JUNGLE_LOG_BEAM = new GenericBeamBlock("jungle_log", Map.of("main", new Identifier("minecraft:jungle_log"), "end", new Identifier("minecraft:jungle_log_top")));
        OAK_LOG_BEAM = new GenericBeamBlock("oak_log", Map.of("main", new Identifier("minecraft:oak_log"), "end", new Identifier("minecraft:oak_log_top")));
        SPRUCE_LOG_BEAM = new GenericBeamBlock("spruce_log", Map.of("main", new Identifier("minecraft:spruce_log"), "end", new Identifier("minecraft:spruce_log_top")));
        WARPED_STEM_BEAM = new GenericBeamBlock("warped_stem", Map.of("main", new Identifier("minecraft:warped_stem"), "end", new Identifier("minecraft:warped_stem_top")));
        ACACIA_PLANK_BEAM = new GenericBeamBlock("acacia_plank", Map.of("main", new Identifier("minecraft:acacia_planks")));
        BIRCH_PLANK_BEAM = new GenericBeamBlock("birch_plank", Map.of("main", new Identifier("minecraft:birch_planks")));
        CRIMSON_PLANK_BEAM = new GenericBeamBlock("crimson_plank", Map.of("main", new Identifier("minecraft:crimson_planks")));
        DARK_OAK_PLANK_BEAM = new GenericBeamBlock("dark_oak_plank", Map.of("main", new Identifier("minecraft:dark_oak_planks")));
        JUNGLE_PLANK_BEAM = new GenericBeamBlock("jungle_plank", Map.of("main", new Identifier("minecraft:jungle_planks")));
        OAK_PLANK_BEAM = new GenericBeamBlock("oak_plank", Map.of("main", new Identifier("minecraft:oak_planks")));
        SPRUCE_PLANK_BEAM = new GenericBeamBlock("spruce_plank", Map.of("main", new Identifier("minecraft:spruce_planks")));
        WARPED_PLANK_BEAM = new GenericBeamBlock("warped_plank", Map.of("main", new Identifier("minecraft:warped_planks")));
    }

    @Override
    public void registerBlocks() {
        AMETHYST_BEAM.register(false);
        ANDESITE_BEAM.register(false);
        BASALT_BEAM.register(false);
        BASALT_BRICK_BEAM.register(false);
        BLACKSTONE_BEAM.register(false);
        BONE_BEAM.register(false);
        BRICK_BEAM.register(false);
        CALCITE_BEAM.register(false);
        COBBLED_DEEPSLATE_BEAM.register(false);
        COBBLESTONE_BEAM.register(false);
        CRACKED_BASALT_BRICK_BEAM.register(false);
        CRACKED_DEEPSLATE_BRICK_BEAM.register(false);
        CRACKED_DEEPSLATE_TILE_BEAM.register(false);
        CRACKED_STONE_BRICK_BEAM.register(false);
        CRIMSON_BASALT_BRICK_BEAM.register(false);
        CRYING_OBSIDIAN_BEAM.register(false);
        CUT_RED_SANDSTONE_BEAM.register(false);
        CUT_SANDSTONE_BEAM.register(false);
        DARK_PRISMARINE_BEAM.register(false);
        DEEPSLATE_BEAM.register(false);
        DEEPSLATE_BRICK_BEAM.register(false);
        DEEPSLATE_TILE_BEAM.register(false);
        DIORITE_BEAM.register(false);
        END_STONE_BEAM.register(false);
        END_STONE_BRICK_BEAM.register(false);
        GRANITE_BEAM.register(false);
        MOSSY_BASALT_BRICK_BEAM.register(false);
        MOSSY_COBBLESTONE_BEAM.register(false);
        MOSSY_STONE_BRICK_BEAM.register(false);
        NETHER_BRICK_BEAM.register(false);
        NETHERRACK_BEAM.register(false);
        OBSIDIAN_BEAM.register(false);
        POLISHED_ANDESITE_BEAM.register(false);
        POLISHED_BASALT_BEAM.register(false);
        POLISHED_BLACKSTONE_BEAM.register(false);
        POLISHED_BLACKSTONE_BRICK_BEAM.register(false);
        POLISHED_DEEPSLATE_BEAM.register(false);
        POLISHED_DIORITE_BEAM.register(false);
        POLISHED_GRANITE_BEAM.register(false);
        PRISMARINE_BEAM.register(false);
        PRISMARINE_BRICK_BEAM.register(false);
        PURPUR_BEAM.register(false);
        PURPUR_PILLAR_BEAM.register(false);
        RED_NETHER_BRICK_BEAM.register(false);
        RED_SANDSTONE_BEAM.register(false);
        SANDSTONE_BEAM.register(false);
        SMOOTH_BASALT_BEAM.register(false);
        SMOOTH_RED_SANDSTONE_BEAM.register(false);
        SMOOTH_SANDSTONE_BEAM.register(false);
        SMOOTH_STONE_BEAM.register(false);
        STONE_BEAM.register(false);
        STONE_BRICK_BEAM.register(false);
        TUFF_BEAM.register(false);
        WARPED_BASALT_BRICK_BEAM.register(false);
        WARPED_NETHER_BRICK_BEAM.register(false);
        WHITE_TERRACOTTA_BEAM.register(false);
        ORANGE_TERRACOTTA_BEAM.register(false);
        MAGENTA_TERRACOTTA_BEAM.register(false);
        LIGHT_BLUE_TERRACOTTA_BEAM.register(false);
        YELLOW_TERRACOTTA_BEAM.register(false);
        LIME_TERRACOTTA_BEAM.register(false);
        PINK_TERRACOTTA_BEAM.register(false);
        GRAY_TERRACOTTA_BEAM.register(false);
        LIGHT_GRAY_TERRACOTTA_BEAM.register(false);
        CYAN_TERRACOTTA_BEAM.register(false);
        PURPLE_TERRACOTTA_BEAM.register(false);
        BLUE_TERRACOTTA_BEAM.register(false);
        BROWN_TERRACOTTA_BEAM.register(false);
        GREEN_TERRACOTTA_BEAM.register(false);
        RED_TERRACOTTA_BEAM.register(false);
        BLACK_TERRACOTTA_BEAM.register(false);
        WHITE_GLAZED_TERRACOTTA_BEAM.register(false);
        ORANGE_GLAZED_TERRACOTTA_BEAM.register(false);
        MAGENTA_GLAZED_TERRACOTTA_BEAM.register(false);
        LIGHT_BLUE_GLAZED_TERRACOTTA_BEAM.register(false);
        YELLOW_GLAZED_TERRACOTTA_BEAM.register(false);
        LIME_GLAZED_TERRACOTTA_BEAM.register(false);
        PINK_GLAZED_TERRACOTTA_BEAM.register(false);
        GRAY_GLAZED_TERRACOTTA_BEAM.register(false);
        LIGHT_GRAY_GLAZED_TERRACOTTA_BEAM.register(false);
        CYAN_GLAZED_TERRACOTTA_BEAM.register(false);
        PURPLE_GLAZED_TERRACOTTA_BEAM.register(false);
        BLUE_GLAZED_TERRACOTTA_BEAM.register(false);
        BROWN_GLAZED_TERRACOTTA_BEAM.register(false);
        GREEN_GLAZED_TERRACOTTA_BEAM.register(false);
        RED_GLAZED_TERRACOTTA_BEAM.register(false);
        BLACK_GLAZED_TERRACOTTA_BEAM.register(false);
        WHITE_CONCRETE_BEAM.register(false);
        ORANGE_CONCRETE_BEAM.register(false);
        MAGENTA_CONCRETE_BEAM.register(false);
        LIGHT_BLUE_CONCRETE_BEAM.register(false);
        YELLOW_CONCRETE_BEAM.register(false);
        LIME_CONCRETE_BEAM.register(false);
        PINK_CONCRETE_BEAM.register(false);
        GRAY_CONCRETE_BEAM.register(false);
        LIGHT_GRAY_CONCRETE_BEAM.register(false);
        CYAN_CONCRETE_BEAM.register(false);
        PURPLE_CONCRETE_BEAM.register(false);
        BLUE_CONCRETE_BEAM.register(false);
        BROWN_CONCRETE_BEAM.register(false);
        GREEN_CONCRETE_BEAM.register(false);
        RED_CONCRETE_BEAM.register(false);
        BLACK_CONCRETE_BEAM.register(false);
        ACACIA_LOG_BEAM.register();
        BIRCH_LOG_BEAM.register();
        CRIMSON_STEM_BEAM.register(false);
        DARK_OAK_LOG_BEAM.register();
        JUNGLE_LOG_BEAM.register();
        OAK_LOG_BEAM.register();
        SPRUCE_LOG_BEAM.register();
        WARPED_STEM_BEAM.register(false);
        ACACIA_PLANK_BEAM.register();
        BIRCH_PLANK_BEAM.register();
        CRIMSON_PLANK_BEAM.register(false);
        DARK_OAK_PLANK_BEAM.register();
        JUNGLE_PLANK_BEAM.register();
        OAK_PLANK_BEAM.register();
        SPRUCE_PLANK_BEAM.register();
        WARPED_PLANK_BEAM.register(false);
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }
}
