package com.chimericdream.minekea.settings;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.basalt_bricks.*;
import com.chimericdream.minekea.block.building.end_stone.CobbledEndStoneBlock;
import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBricksBlock;
import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

import java.util.Map;

public class BaseBlockSettings {
    public static DefaultSettings AMETHYST = new DefaultSettings(Blocks.AMETHYST_BLOCK)
        .material("amethyst")
        .translation("amethyst")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:amethyst_block"),
                "ingredient", new Identifier("minecraft:amethyst_shard")
            )
        );

    public static DefaultSettings ANDESITE = new DefaultSettings(Blocks.ANDESITE)
        .material("andesite")
        .translation("andesite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:andesite")
            )
        );

    public static DefaultSettings BASALT = new DefaultSettings(Blocks.BASALT)
        .material("basalt")
        .translation("basalt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:basalt_side"),
                "end", new Identifier("minecraft:basalt_top"),
                "ingredient", new Identifier("minecraft:basalt")
            )
        );

    public static DefaultSettings BASALT_BRICK = new DefaultSettings(BuildingBlocks.BASALT_BRICKS_BLOCK)
        .material("basalt_brick")
        .translation("basalt brick")
        .materials(
            Map.of(
                "main", BasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings BLACKSTONE = new DefaultSettings(Blocks.BLACKSTONE)
        .material("blackstone")
        .translation("blackstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blackstone")
            )
        );

    public static DefaultSettings BONE = new DefaultSettings(Blocks.BONE_BLOCK)
        .material("bone")
        .translation("bone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:bone_block_side"),
                "end", new Identifier("minecraft:bone_block_top"),
                "ingredient", new Identifier("minecraft:bone_block")
            )
        );

    public static DefaultSettings BRICK = new DefaultSettings(Blocks.BRICKS)
        .material("brick")
        .translation("brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:bricks")
            )
        );

    public static DefaultSettings CALCITE = new DefaultSettings(Blocks.CALCITE)
        .material("calcite")
        .translation("calcite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:calcite")
            )
        );

    public static DefaultSettings COBBLED_DEEPSLATE = new DefaultSettings(Blocks.COBBLED_DEEPSLATE)
        .material("cobbled_deepslate")
        .translation("cobbled deepslate")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cobbled_deepslate")
            )
        );

    public static DefaultSettings COBBLED_END_STONE = new DefaultSettings(BuildingBlocks.COBBLED_END_STONE_BLOCK)
        .material("cobbled_end_stone")
        .translation("cobbled end stone")
        .materials(
            Map.of(
                "main", CobbledEndStoneBlock.BLOCK_ID
            )
        );

    public static DefaultSettings COBBLESTONE = new DefaultSettings(Blocks.COBBLESTONE)
        .material("cobblestone")
        .translation("cobblestone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cobblestone")
            )
        );

    public static DefaultSettings CRACKED_BASALT_BRICK = new DefaultSettings(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK)
        .material("cracked_basalt_brick")
        .translation("cracked basalt brick")
        .materials(
            Map.of(
                "main", CrackedBasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings CRACKED_DEEPSLATE_BRICK = new DefaultSettings(Blocks.CRACKED_DEEPSLATE_BRICKS)
        .material("cracked_deepslate_brick")
        .translation("cracked deepslate brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cracked_deepslate_bricks")
            )
        );

    public static DefaultSettings CRACKED_DEEPSLATE_TILE = new DefaultSettings(Blocks.CRACKED_DEEPSLATE_TILES)
        .material("cracked_deepslate_tile")
        .translation("cracked deepslate tile")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cracked_deepslate_tiles")
            )
        );

    public static DefaultSettings CRACKED_STONE_BRICK = new DefaultSettings(Blocks.CRACKED_STONE_BRICKS)
        .material("cracked_stone_brick")
        .translation("cracked stone brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cracked_stone_bricks")
            )
        );

    public static DefaultSettings CRIMSON_BASALT_BRICK = new DefaultSettings(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK)
        .material("crimson_basalt_brick")
        .translation("crimson basalt brick")
        .materials(
            Map.of(
                "main", CrimsonBasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings CRYING_OBSIDIAN = new DefaultSettings(Blocks.CRYING_OBSIDIAN)
        .material("crying_obsidian")
        .translation("crying obsidian")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:crying_obsidian")
            )
        );

    public static DefaultSettings CUT_RED_SANDSTONE = new DefaultSettings(Blocks.CUT_RED_SANDSTONE)
        .material("cut_red_sandstone")
        .translation("cut red sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_red_sandstone")
            )
        );

    public static DefaultSettings CUT_SANDSTONE = new DefaultSettings(Blocks.CUT_SANDSTONE)
        .material("cut_sandstone")
        .translation("cut sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_sandstone")
            )
        );

    public static DefaultSettings DARK_PRISMARINE = new DefaultSettings(Blocks.DARK_PRISMARINE)
        .material("dark_prismarine")
        .translation("dark prismarine")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dark_prismarine")
            )
        );

    public static DefaultSettings DEEPSLATE_BRICK = new DefaultSettings(Blocks.DEEPSLATE_BRICKS)
        .material("deepslate_brick")
        .translation("deepslate brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:deepslate_bricks")
            )
        );

    public static DefaultSettings DEEPSLATE = new DefaultSettings(Blocks.DEEPSLATE)
        .material("deepslate")
        .translation("deepslate")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:deepslate")
            )
        );

    public static DefaultSettings DEEPSLATE_TILE = new DefaultSettings(Blocks.DEEPSLATE_TILES)
        .material("deepslate_tile")
        .translation("deepslate tile")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:deepslate_tiles")
            )
        );

    public static DefaultSettings DIORITE = new DefaultSettings(Blocks.DIORITE)
        .material("diorite")
        .translation("diorite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:diorite")
            )
        );

    public static DefaultSettings END_STONE_BRICK = new DefaultSettings(Blocks.END_STONE_BRICKS)
        .material("end_stone_brick")
        .translation("end stone brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:end_stone_bricks")
            )
        );

    public static DefaultSettings END_STONE = new DefaultSettings(Blocks.END_STONE)
        .material("end_stone")
        .translation("end stone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:end_stone")
            )
        );

    public static DefaultSettings GRANITE = new DefaultSettings(Blocks.GRANITE)
        .material("granite")
        .translation("granite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:granite")
            )
        );

    public static DefaultSettings MOSSY_BASALT_BRICK = new DefaultSettings(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK)
        .material("mossy_basalt_brick")
        .translation("mossy basalt brick")
        .materials(
            Map.of(
                "main", MossyBasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings MOSSY_COBBLESTONE = new DefaultSettings(Blocks.MOSSY_COBBLESTONE)
        .material("mossy_cobblestone")
        .translation("mossy cobblestone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:mossy_cobblestone")
            )
        );

    public static DefaultSettings MOSSY_STONE_BRICK = new DefaultSettings(Blocks.MOSSY_STONE_BRICKS)
        .material("mossy_stone_brick")
        .translation("mossy stone brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:mossy_stone_bricks")
            )
        );

    public static DefaultSettings NETHERRACK = new DefaultSettings(Blocks.NETHERRACK)
        .material("netherrack")
        .translation("netherrack")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:netherrack")
            )
        );

    public static DefaultSettings NETHER_BRICK = new DefaultSettings(Blocks.NETHER_BRICKS)
        .material("nether_brick")
        .translation("nether brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:nether_bricks")
            )
        );

    public static DefaultSettings OBSIDIAN = new DefaultSettings(Blocks.OBSIDIAN)
        .material("obsidian")
        .translation("obsidian")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:obsidian")
            )
        );

    public static DefaultSettings POLISHED_ANDESITE = new DefaultSettings(Blocks.POLISHED_ANDESITE)
        .material("polished_andesite")
        .translation("polished andesite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_andesite")
            )
        );

    public static DefaultSettings POLISHED_BASALT = new DefaultSettings(Blocks.POLISHED_BASALT)
        .material("polished_basalt")
        .translation("polished basalt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_basalt_side"),
                "end", new Identifier("minecraft:polished_basalt_top"),
                "ingredient", new Identifier("minecraft:polished_basalt")
            )
        );

    public static DefaultSettings POLISHED_BLACKSTONE_BRICK = new DefaultSettings(Blocks.POLISHED_BLACKSTONE_BRICKS)
        .material("polished_blackstone_brick")
        .translation("polished blackstone brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_blackstone_bricks")
            )
        );

    public static DefaultSettings POLISHED_BLACKSTONE = new DefaultSettings(Blocks.POLISHED_BLACKSTONE)
        .material("polished_blackstone")
        .translation("polished blackstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_blackstone")
            )
        );

    public static DefaultSettings POLISHED_DEEPSLATE = new DefaultSettings(Blocks.POLISHED_DEEPSLATE)
        .material("polished_deepslate")
        .translation("polished deepslate")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_deepslate")
            )
        );

    public static DefaultSettings POLISHED_DIORITE = new DefaultSettings(Blocks.POLISHED_DIORITE)
        .material("polished_diorite")
        .translation("polished diorite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_diorite")
            )
        );

    public static DefaultSettings POLISHED_GRANITE = new DefaultSettings(Blocks.POLISHED_GRANITE)
        .material("polished_granite")
        .translation("polished granite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_granite")
            )
        );

    public static DefaultSettings PRISMARINE_BRICK = new DefaultSettings(Blocks.PRISMARINE_BRICKS)
        .material("prismarine_brick")
        .translation("prismarine brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:prismarine_bricks")
            )
        );

    public static DefaultSettings PRISMARINE = new DefaultSettings(Blocks.PRISMARINE)
        .material("prismarine")
        .translation("prismarine")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:prismarine")
            )
        );

    public static DefaultSettings PURPUR = new DefaultSettings(Blocks.PURPUR_BLOCK)
        .material("purpur")
        .translation("purpur")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purpur_block")
            )
        );

    public static DefaultSettings PURPUR_PILLAR = new DefaultSettings(Blocks.PURPUR_PILLAR)
        .material("purpur_pillar")
        .translation("purpur pillar")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purpur_pillar")
            )
        );

    public static DefaultSettings RED_NETHER_BRICK = new DefaultSettings(Blocks.RED_NETHER_BRICKS)
        .material("red_nether_brick")
        .translation("red nether brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_nether_bricks")
            )
        );

    public static DefaultSettings RED_SANDSTONE = new DefaultSettings(Blocks.RED_SANDSTONE)
        .material("red_sandstone")
        .translation("red sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_sandstone")
            )
        );

    public static DefaultSettings SANDSTONE = new DefaultSettings(Blocks.SANDSTONE)
        .material("sandstone")
        .translation("sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sandstone")
            )
        );

    public static DefaultSettings SMOOTH_BASALT = new DefaultSettings(Blocks.SMOOTH_BASALT)
        .material("smooth_basalt")
        .translation("smooth basalt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:smooth_basalt")
            )
        );

    public static DefaultSettings SMOOTH_RED_SANDSTONE = new DefaultSettings(Blocks.SMOOTH_RED_SANDSTONE)
        .material("smooth_red_sandstone")
        .translation("smooth red sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_red_sandstone")
            )
        );

    public static DefaultSettings SMOOTH_SANDSTONE = new DefaultSettings(Blocks.SMOOTH_SANDSTONE)
        .material("smooth_sandstone")
        .translation("smooth sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_sandstone")
            )
        );

    public static DefaultSettings SMOOTH_STONE = new DefaultSettings(Blocks.SMOOTH_STONE)
        .material("smooth_stone")
        .translation("smooth stone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:smooth_stone")
            )
        );

    public static DefaultSettings STONE_BRICK = new DefaultSettings(Blocks.STONE_BRICKS)
        .material("stone_brick")
        .translation("stone brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:stone_bricks")
            )
        );

    public static DefaultSettings STONE = new DefaultSettings(Blocks.STONE)
        .material("stone")
        .translation("stone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:stone")
            )
        );

    public static DefaultSettings TUFF = new DefaultSettings(Blocks.TUFF)
        .material("tuff")
        .translation("tuff")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:tuff")
            )
        );

    public static DefaultSettings WARPED_BASALT_BRICK = new DefaultSettings(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK)
        .material("warped_basalt_brick")
        .translation("warped basalt brick")
        .materials(
            Map.of(
                "main", WarpedBasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings WARPED_NETHER_BRICK = new DefaultSettings(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK)
        .material("warped_nether_brick")
        .translation("warped nether brick")
        .materials(
            Map.of(
                "main", WarpedNetherBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings WHITE_TERRACOTTA = new DefaultSettings(Blocks.WHITE_TERRACOTTA)
        .material("white_terracotta")
        .translation("white terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_terracotta")
            )
        );

    public static DefaultSettings ORANGE_TERRACOTTA = new DefaultSettings(Blocks.ORANGE_TERRACOTTA)
        .material("orange_terracotta")
        .translation("orange terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_terracotta")
            )
        );

    public static DefaultSettings MAGENTA_TERRACOTTA = new DefaultSettings(Blocks.MAGENTA_TERRACOTTA)
        .material("magenta_terracotta")
        .translation("magenta terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_terracotta")
            )
        );

    public static DefaultSettings LIGHT_BLUE_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_BLUE_TERRACOTTA)
        .material("light_blue_terracotta")
        .translation("light blue terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_terracotta")
            )
        );

    public static DefaultSettings YELLOW_TERRACOTTA = new DefaultSettings(Blocks.YELLOW_TERRACOTTA)
        .material("yellow_terracotta")
        .translation("yellow terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_terracotta")
            )
        );

    public static DefaultSettings LIME_TERRACOTTA = new DefaultSettings(Blocks.LIME_TERRACOTTA)
        .material("lime_terracotta")
        .translation("lime terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_terracotta")
            )
        );

    public static DefaultSettings PINK_TERRACOTTA = new DefaultSettings(Blocks.PINK_TERRACOTTA)
        .material("pink_terracotta")
        .translation("pink terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_terracotta")
            )
        );

    public static DefaultSettings GRAY_TERRACOTTA = new DefaultSettings(Blocks.GRAY_TERRACOTTA)
        .material("gray_terracotta")
        .translation("gray terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_terracotta")
            )
        );

    public static DefaultSettings LIGHT_GRAY_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_GRAY_TERRACOTTA)
        .material("light_gray_terracotta")
        .translation("light gray terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_terracotta")
            )
        );

    public static DefaultSettings CYAN_TERRACOTTA = new DefaultSettings(Blocks.CYAN_TERRACOTTA)
        .material("cyan_terracotta")
        .translation("cyan terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_terracotta")
            )
        );

    public static DefaultSettings PURPLE_TERRACOTTA = new DefaultSettings(Blocks.PURPLE_TERRACOTTA)
        .material("purple_terracotta")
        .translation("purple terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_terracotta")
            )
        );

    public static DefaultSettings BLUE_TERRACOTTA = new DefaultSettings(Blocks.BLUE_TERRACOTTA)
        .material("blue_terracotta")
        .translation("blue terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_terracotta")
            )
        );

    public static DefaultSettings BROWN_TERRACOTTA = new DefaultSettings(Blocks.BROWN_TERRACOTTA)
        .material("brown_terracotta")
        .translation("brown terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_terracotta")
            )
        );

    public static DefaultSettings GREEN_TERRACOTTA = new DefaultSettings(Blocks.GREEN_TERRACOTTA)
        .material("green_terracotta")
        .translation("green terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_terracotta")
            )
        );

    public static DefaultSettings RED_TERRACOTTA = new DefaultSettings(Blocks.RED_TERRACOTTA)
        .material("red_terracotta")
        .translation("red terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_terracotta")
            )
        );

    public static DefaultSettings BLACK_TERRACOTTA = new DefaultSettings(Blocks.BLACK_TERRACOTTA)
        .material("black_terracotta")
        .translation("black terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_terracotta")
            )
        );

    public static DefaultSettings WHITE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.WHITE_GLAZED_TERRACOTTA)
        .material("white_glazed_terracotta")
        .translation("white glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_glazed_terracotta")
            )
        );

    public static DefaultSettings ORANGE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.ORANGE_GLAZED_TERRACOTTA)
        .material("orange_glazed_terracotta")
        .translation("orange glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_glazed_terracotta")
            )
        );

    public static DefaultSettings MAGENTA_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.MAGENTA_GLAZED_TERRACOTTA)
        .material("magenta_glazed_terracotta")
        .translation("magenta glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_glazed_terracotta")
            )
        );

    public static DefaultSettings LIGHT_BLUE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)
        .material("light_blue_glazed_terracotta")
        .translation("light blue glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_glazed_terracotta")
            )
        );

    public static DefaultSettings YELLOW_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.YELLOW_GLAZED_TERRACOTTA)
        .material("yellow_glazed_terracotta")
        .translation("yellow glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_glazed_terracotta")
            )
        );

    public static DefaultSettings LIME_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIME_GLAZED_TERRACOTTA)
        .material("lime_glazed_terracotta")
        .translation("lime glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_glazed_terracotta")
            )
        );

    public static DefaultSettings PINK_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.PINK_GLAZED_TERRACOTTA)
        .material("pink_glazed_terracotta")
        .translation("pink glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_glazed_terracotta")
            )
        );

    public static DefaultSettings GRAY_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.GRAY_GLAZED_TERRACOTTA)
        .material("gray_glazed_terracotta")
        .translation("gray glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_glazed_terracotta")
            )
        );

    public static DefaultSettings LIGHT_GRAY_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)
        .material("light_gray_glazed_terracotta")
        .translation("light gray glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_glazed_terracotta")
            )
        );

    public static DefaultSettings CYAN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.CYAN_GLAZED_TERRACOTTA)
        .material("cyan_glazed_terracotta")
        .translation("cyan glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_glazed_terracotta")
            )
        );

    public static DefaultSettings PURPLE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.PURPLE_GLAZED_TERRACOTTA)
        .material("purple_glazed_terracotta")
        .translation("purple glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_glazed_terracotta")
            )
        );

    public static DefaultSettings BLUE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BLUE_GLAZED_TERRACOTTA)
        .material("blue_glazed_terracotta")
        .translation("blue glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_glazed_terracotta")
            )
        );

    public static DefaultSettings BROWN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BROWN_GLAZED_TERRACOTTA)
        .material("brown_glazed_terracotta")
        .translation("brown glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_glazed_terracotta")
            )
        );

    public static DefaultSettings GREEN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.GREEN_GLAZED_TERRACOTTA)
        .material("green_glazed_terracotta")
        .translation("green glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_glazed_terracotta")
            )
        );

    public static DefaultSettings RED_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.RED_GLAZED_TERRACOTTA)
        .material("red_glazed_terracotta")
        .translation("red glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_glazed_terracotta")
            )
        );

    public static DefaultSettings BLACK_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BLACK_GLAZED_TERRACOTTA)
        .material("black_glazed_terracotta")
        .translation("black glazed terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_glazed_terracotta")
            )
        );

    public static DefaultSettings WHITE_CONCRETE = new DefaultSettings(Blocks.WHITE_CONCRETE)
        .material("white_concrete")
        .translation("white concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_concrete")
            )
        );

    public static DefaultSettings ORANGE_CONCRETE = new DefaultSettings(Blocks.ORANGE_CONCRETE)
        .material("orange_concrete")
        .translation("orange concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_concrete")
            )
        );

    public static DefaultSettings MAGENTA_CONCRETE = new DefaultSettings(Blocks.MAGENTA_CONCRETE)
        .material("magenta_concrete")
        .translation("magenta concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_concrete")
            )
        );

    public static DefaultSettings LIGHT_BLUE_CONCRETE = new DefaultSettings(Blocks.LIGHT_BLUE_CONCRETE)
        .material("light_blue_concrete")
        .translation("light blue concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_concrete")
            )
        );

    public static DefaultSettings YELLOW_CONCRETE = new DefaultSettings(Blocks.YELLOW_CONCRETE)
        .material("yellow_concrete")
        .translation("yellow concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_concrete")
            )
        );

    public static DefaultSettings LIME_CONCRETE = new DefaultSettings(Blocks.LIME_CONCRETE)
        .material("lime_concrete")
        .translation("lime concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_concrete")
            )
        );

    public static DefaultSettings PINK_CONCRETE = new DefaultSettings(Blocks.PINK_CONCRETE)
        .material("pink_concrete")
        .translation("pink concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_concrete")
            )
        );

    public static DefaultSettings GRAY_CONCRETE = new DefaultSettings(Blocks.GRAY_CONCRETE)
        .material("gray_concrete")
        .translation("gray concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_concrete")
            )
        );

    public static DefaultSettings LIGHT_GRAY_CONCRETE = new DefaultSettings(Blocks.LIGHT_GRAY_CONCRETE)
        .material("light_gray_concrete")
        .translation("light gray concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_concrete")
            )
        );

    public static DefaultSettings CYAN_CONCRETE = new DefaultSettings(Blocks.CYAN_CONCRETE)
        .material("cyan_concrete")
        .translation("cyan concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_concrete")
            )
        );

    public static DefaultSettings PURPLE_CONCRETE = new DefaultSettings(Blocks.PURPLE_CONCRETE)
        .material("purple_concrete")
        .translation("purple concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_concrete")
            )
        );

    public static DefaultSettings BLUE_CONCRETE = new DefaultSettings(Blocks.BLUE_CONCRETE)
        .material("blue_concrete")
        .translation("blue concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_concrete")
            )
        );

    public static DefaultSettings BROWN_CONCRETE = new DefaultSettings(Blocks.BROWN_CONCRETE)
        .material("brown_concrete")
        .translation("brown concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_concrete")
            )
        );

    public static DefaultSettings GREEN_CONCRETE = new DefaultSettings(Blocks.GREEN_CONCRETE)
        .material("green_concrete")
        .translation("green concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_concrete")
            )
        );

    public static DefaultSettings RED_CONCRETE = new DefaultSettings(Blocks.RED_CONCRETE)
        .material("red_concrete")
        .translation("red concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_concrete")
            )
        );

    public static DefaultSettings BLACK_CONCRETE = new DefaultSettings(Blocks.BLACK_CONCRETE)
        .material("black_concrete")
        .translation("black concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_concrete")
            )
        );

    public static DefaultSettings ACACIA_LOG = new DefaultSettings(Blocks.ACACIA_PLANKS)
        .material("acacia_log")
        .translation("acacia log")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:acacia_log"),
                "end", new Identifier("minecraft:acacia_log_top")
            )
        );

    public static DefaultSettings ACACIA_PLANK = new DefaultSettings(Blocks.ACACIA_PLANKS)
        .material("acacia_plank")
        .translation("acacia plank")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:acacia_planks")
            )
        );

    public static DefaultSettings BIRCH_LOG = new DefaultSettings(Blocks.BIRCH_PLANKS)
        .material("birch_log")
        .translation("birch log")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:birch_log"),
                "end", new Identifier("minecraft:birch_log_top")
            )
        );

    public static DefaultSettings BIRCH_PLANK = new DefaultSettings(Blocks.BIRCH_PLANKS)
        .material("birch_plank")
        .translation("birch plank")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:birch_planks")
            )
        );

    public static DefaultSettings CRIMSON_PLANK = new DefaultSettings(Blocks.CRIMSON_PLANKS)
        .material("crimson_plank")
        .translation("crimson plank")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:crimson_planks")
            )
        );

    public static DefaultSettings CRIMSON_STEM = new DefaultSettings(Blocks.CRIMSON_PLANKS)
        .material("crimson_stem")
        .translation("crimson stem")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:crimson_stem"),
                "end", new Identifier("minecraft:crimson_stem_top")
            )
        );

    public static DefaultSettings DARK_OAK_LOG = new DefaultSettings(Blocks.DARK_OAK_PLANKS)
        .material("dark_oak_log")
        .translation("dark oak log")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dark_oak_log"),
                "end", new Identifier("minecraft:dark_oak_log_top")
            )
        );

    public static DefaultSettings DARK_OAK_PLANK = new DefaultSettings(Blocks.DARK_OAK_PLANKS)
        .material("dark_oak_plank")
        .translation("dark oak plank")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dark_oak_planks")
            )
        );

    public static DefaultSettings JUNGLE_LOG = new DefaultSettings(Blocks.JUNGLE_PLANKS)
        .material("jungle_log")
        .translation("jungle log")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:jungle_log"),
                "end", new Identifier("minecraft:jungle_log_top")
            )
        );

    public static DefaultSettings JUNGLE_PLANK = new DefaultSettings(Blocks.JUNGLE_PLANKS)
        .material("jungle_plank")
        .translation("jungle plank")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:jungle_planks")
            )
        );

    public static DefaultSettings OAK_LOG = new DefaultSettings(Blocks.OAK_PLANKS)
        .material("oak_log")
        .translation("oak log")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:oak_log"),
                "end", new Identifier("minecraft:oak_log_top")
            )
        );

    public static DefaultSettings OAK_PLANK = new DefaultSettings(Blocks.OAK_PLANKS)
        .material("oak_plank")
        .translation("oak plank")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:oak_planks")
            )
        );

    public static DefaultSettings SPRUCE_LOG = new DefaultSettings(Blocks.SPRUCE_PLANKS)
        .material("spruce_log")
        .translation("spruce log")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:spruce_log"),
                "end", new Identifier("minecraft:spruce_log_top")
            )
        );

    public static DefaultSettings SPRUCE_PLANK = new DefaultSettings(Blocks.SPRUCE_PLANKS)
        .material("spruce_plank")
        .translation("spruce plank")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:spruce_planks")
            )
        );

    public static DefaultSettings WARPED_PLANK = new DefaultSettings(Blocks.WARPED_PLANKS)
        .material("warped_plank")
        .translation("warped plank")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:warped_planks")
            )
        );

    public static DefaultSettings WARPED_STEM = new DefaultSettings(Blocks.WARPED_PLANKS)
        .material("warped_stem")
        .translation("warped stem")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:warped_stem"),
                "end", new Identifier("minecraft:warped_stem_top")
            )
        );
}
