package com.chimericdream.minekea.settings;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.*;
import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

import java.util.Map;

public class BaseBlockSettings {
    public static DefaultSettings AMETHYST = new DefaultSettings(Blocks.AMETHYST_BLOCK)
        .material("amethyst")
        .translation("Amethyst")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:amethyst_block")
            )
        );

    public static DefaultSettings ANDESITE = new DefaultSettings(Blocks.ANDESITE)
        .material("andesite")
        .translation("Andesite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:andesite")
            )
        );

    public static DefaultSettings BASALT = new DefaultSettings(Blocks.BASALT)
        .material("basalt")
        .translation("Basalt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:basalt_side"),
                "end", new Identifier("minecraft:basalt_top"),
                "ingredient", new Identifier("minecraft:basalt")
            )
        );

    public static DefaultSettings BASALT_BRICK = new DefaultSettings(BuildingBlocks.BASALT_BRICKS_BLOCK)
        .material("basalt_brick")
        .translation("Basalt Brick")
        .materials(
            Map.of(
                "main", BasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings BLACKSTONE = new DefaultSettings(Blocks.BLACKSTONE)
        .material("blackstone")
        .translation("Blackstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blackstone")
            )
        );

    public static DefaultSettings BONE = new DefaultSettings(Blocks.BONE_BLOCK)
        .material("bone")
        .translation("Bone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:bone_block_side"),
                "end", new Identifier("minecraft:bone_block_top"),
                "ingredient", new Identifier("minecraft:bone_block")
            )
        );

    public static DefaultSettings BRICK = new DefaultSettings(Blocks.BRICKS)
        .material("brick")
        .translation("Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:bricks")
            )
        );

    public static DefaultSettings CALCITE = new DefaultSettings(Blocks.CALCITE)
        .material("calcite")
        .translation("Calcite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:calcite")
            )
        );

    public static DefaultSettings CLAY = new DefaultSettings(Blocks.CLAY)
        .material("clay")
        .translation("Clay")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:clay")
            )
        );

    public static DefaultSettings COARSE_DIRT = new DefaultSettings(Blocks.COARSE_DIRT)
        .material("coarse_dirt")
        .translation("Coarse Dirt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:coarse_dirt")
            )
        );

    public static DefaultSettings COBBLED_DEEPSLATE = new DefaultSettings(Blocks.COBBLED_DEEPSLATE)
        .material("cobbled_deepslate")
        .translation("Cobbled Deepslate")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cobbled_deepslate")
            )
        );

    public static DefaultSettings COBBLED_END_STONE = new DefaultSettings(BuildingBlocks.COBBLED_END_STONE_BLOCK)
        .material("cobbled_end_stone")
        .translation("Cobbled End Stone")
        .materials(
            Map.of(
                "main", CobbledEndStoneBlock.BLOCK_ID
            )
        );

    public static DefaultSettings COBBLESTONE = new DefaultSettings(Blocks.COBBLESTONE)
        .material("cobblestone")
        .translation("Cobblestone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cobblestone")
            )
        );

    public static DefaultSettings COPPER_BLOCK = new DefaultSettings(Blocks.COPPER_BLOCK)
        .material("copper_block")
        .translation("Copper Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:copper_block")
            )
        );

    public static DefaultSettings CRACKED_BASALT_BRICK = new DefaultSettings(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK)
        .material("cracked_basalt_brick")
        .translation("Cracked Basalt Brick")
        .materials(
            Map.of(
                "main", CrackedBasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings CRACKED_DEEPSLATE_BRICK = new DefaultSettings(Blocks.CRACKED_DEEPSLATE_BRICKS)
        .material("cracked_deepslate_brick")
        .translation("Cracked Deepslate Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cracked_deepslate_bricks")
            )
        );

    public static DefaultSettings CRACKED_DEEPSLATE_TILE = new DefaultSettings(Blocks.CRACKED_DEEPSLATE_TILES)
        .material("cracked_deepslate_tile")
        .translation("Cracked Deepslate Tile")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cracked_deepslate_tiles")
            )
        );

    public static DefaultSettings CRACKED_STONE_BRICK = new DefaultSettings(Blocks.CRACKED_STONE_BRICKS)
        .material("cracked_stone_brick")
        .translation("Cracked Stone Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cracked_stone_bricks")
            )
        );

    public static DefaultSettings CRIMSON_BASALT_BRICK = new DefaultSettings(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK)
        .material("crimson_basalt_brick")
        .translation("Crimson Basalt Brick")
        .materials(
            Map.of(
                "main", CrimsonBasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings CRYING_OBSIDIAN = new DefaultSettings(Blocks.CRYING_OBSIDIAN)
        .material("crying_obsidian")
        .translation("Crying Obsidian")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:crying_obsidian")
            )
        );

    public static DefaultSettings CUT_RED_SANDSTONE = new DefaultSettings(Blocks.CUT_RED_SANDSTONE)
        .material("cut_red_sandstone")
        .translation("Cut Red Sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_red_sandstone")
            )
        );

    public static DefaultSettings CUT_SANDSTONE = new DefaultSettings(Blocks.CUT_SANDSTONE)
        .material("cut_sandstone")
        .translation("Cut Sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_sandstone")
            )
        );

    public static DefaultSettings DARK_PRISMARINE = new DefaultSettings(Blocks.DARK_PRISMARINE)
        .material("dark_prismarine")
        .translation("Dark Prismarine")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dark_prismarine")
            )
        );

    public static DefaultSettings DEEPSLATE_BRICK = new DefaultSettings(Blocks.DEEPSLATE_BRICKS)
        .material("deepslate_brick")
        .translation("Deepslate Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:deepslate_bricks")
            )
        );

    public static DefaultSettings DEEPSLATE = new DefaultSettings(Blocks.DEEPSLATE)
        .material("deepslate")
        .translation("Deepslate")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:deepslate")
            )
        );

    public static DefaultSettings DEEPSLATE_TILE = new DefaultSettings(Blocks.DEEPSLATE_TILES)
        .material("deepslate_tile")
        .translation("Deepslate Tile")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:deepslate_tiles")
            )
        );

    public static DefaultSettings DIAMOND_BLOCK = new DefaultSettings(Blocks.DIAMOND_BLOCK)
        .material("diamond_block")
        .translation("Diamond Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:diamond_block")
            )
        );

    public static DefaultSettings DIORITE = new DefaultSettings(Blocks.DIORITE)
        .material("diorite")
        .translation("Diorite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:diorite")
            )
        );

    public static DefaultSettings DIRT = new DefaultSettings(Blocks.DIRT)
        .material("dirt")
        .translation("Dirt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dirt")
            )
        );

    public static DefaultSettings END_STONE_BRICK = new DefaultSettings(Blocks.END_STONE_BRICKS)
        .material("end_stone_brick")
        .translation("End Stone Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:end_stone_bricks")
            )
        );

    public static DefaultSettings END_STONE = new DefaultSettings(Blocks.END_STONE)
        .material("end_stone")
        .translation("End Stone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:end_stone")
            )
        );

    public static DefaultSettings GOLD_BLOCK = new DefaultSettings(Blocks.GOLD_BLOCK)
        .material("gold_block")
        .translation("Gold Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gold_block")
            )
        );

    public static DefaultSettings GRANITE = new DefaultSettings(Blocks.GRANITE)
        .material("granite")
        .translation("Granite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:granite")
            )
        );

    public static DefaultSettings GRAVEL = new DefaultSettings(Blocks.GRAVEL)
        .material("gravel")
        .translation("Gravel")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gravel")
            )
        );

    public static DefaultSettings IRON_BLOCK = new DefaultSettings(Blocks.IRON_BLOCK)
        .material("iron_block")
        .translation("Iron Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:iron_block")
            )
        );

    public static DefaultSettings LAPIS_BLOCK = new DefaultSettings(Blocks.LAPIS_BLOCK)
        .material("lapis_block")
        .translation("Lapis Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lapis_block")
            )
        );

    public static DefaultSettings MOSSY_BASALT_BRICK = new DefaultSettings(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK)
        .material("mossy_basalt_brick")
        .translation("Mossy Basalt Brick")
        .materials(
            Map.of(
                "main", MossyBasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings MOSSY_COBBLESTONE = new DefaultSettings(Blocks.MOSSY_COBBLESTONE)
        .material("mossy_cobblestone")
        .translation("Mossy Cobblestone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:mossy_cobblestone")
            )
        );

    public static DefaultSettings MOSSY_STONE_BRICK = new DefaultSettings(Blocks.MOSSY_STONE_BRICKS)
        .material("mossy_stone_brick")
        .translation("Mossy Stone Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:mossy_stone_bricks")
            )
        );

    public static DefaultSettings NETHERRACK = new DefaultSettings(Blocks.NETHERRACK)
        .material("netherrack")
        .translation("Netherrack")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:netherrack")
            )
        );

    public static DefaultSettings NETHER_BRICK = new DefaultSettings(Blocks.NETHER_BRICKS)
        .material("nether_brick")
        .translation("Nether Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:nether_bricks")
            )
        );

    public static DefaultSettings NETHERITE_BLOCK = new DefaultSettings(Blocks.NETHERITE_BLOCK)
        .material("netherite_block")
        .translation("Netherite Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:netherite_block")
            )
        );

    public static DefaultSettings OBSIDIAN = new DefaultSettings(Blocks.OBSIDIAN)
        .material("obsidian")
        .translation("Obsidian")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:obsidian")
            )
        );

    public static DefaultSettings POLISHED_ANDESITE = new DefaultSettings(Blocks.POLISHED_ANDESITE)
        .material("polished_andesite")
        .translation("Polished Andesite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_andesite")
            )
        );

    public static DefaultSettings POLISHED_BASALT = new DefaultSettings(Blocks.POLISHED_BASALT)
        .material("polished_basalt")
        .translation("Polished Basalt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_basalt_side"),
                "end", new Identifier("minecraft:polished_basalt_top"),
                "ingredient", new Identifier("minecraft:polished_basalt")
            )
        );

    public static DefaultSettings POLISHED_BLACKSTONE_BRICK = new DefaultSettings(Blocks.POLISHED_BLACKSTONE_BRICKS)
        .material("polished_blackstone_brick")
        .translation("Polished Blackstone Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_blackstone_bricks")
            )
        );

    public static DefaultSettings POLISHED_BLACKSTONE = new DefaultSettings(Blocks.POLISHED_BLACKSTONE)
        .material("polished_blackstone")
        .translation("Polished Blackstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_blackstone")
            )
        );

    public static DefaultSettings POLISHED_DEEPSLATE = new DefaultSettings(Blocks.POLISHED_DEEPSLATE)
        .material("polished_deepslate")
        .translation("Polished Deepslate")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_deepslate")
            )
        );

    public static DefaultSettings POLISHED_DIORITE = new DefaultSettings(Blocks.POLISHED_DIORITE)
        .material("polished_diorite")
        .translation("Polished Diorite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_diorite")
            )
        );

    public static DefaultSettings POLISHED_GRANITE = new DefaultSettings(Blocks.POLISHED_GRANITE)
        .material("polished_granite")
        .translation("Polished Granite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_granite")
            )
        );

    public static DefaultSettings PRISMARINE_BRICK = new DefaultSettings(Blocks.PRISMARINE_BRICKS)
        .material("prismarine_brick")
        .translation("Prismarine Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:prismarine_bricks")
            )
        );

    public static DefaultSettings PRISMARINE = new DefaultSettings(Blocks.PRISMARINE)
        .material("prismarine")
        .translation("Prismarine")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:prismarine")
            )
        );

    public static DefaultSettings PURPUR = new DefaultSettings(Blocks.PURPUR_BLOCK)
        .material("purpur")
        .translation("Purpur")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purpur_block")
            )
        );

    public static DefaultSettings PURPUR_PILLAR = new DefaultSettings(Blocks.PURPUR_PILLAR)
        .material("purpur_pillar")
        .translation("Purpur Pillar")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purpur_pillar")
            )
        );

    public static DefaultSettings QUARTZ = new DefaultSettings(Blocks.QUARTZ_BLOCK)
        .material("quartz")
        .translation("Quartz")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:quartz_block_top"),
                "ingredient", new Identifier("minecraft:quartz_block")
            )
        );

    public static DefaultSettings QUARTZ_BRICK = new DefaultSettings(Blocks.QUARTZ_BRICKS)
        .material("quartz_brick")
        .translation("Quartz Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:quartz_bricks")
            )
        );

    public static DefaultSettings RED_NETHER_BRICK = new DefaultSettings(Blocks.RED_NETHER_BRICKS)
        .material("red_nether_brick")
        .translation("Red Nether Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_nether_bricks")
            )
        );

    public static DefaultSettings RED_SANDSTONE = new DefaultSettings(Blocks.RED_SANDSTONE)
        .material("red_sandstone")
        .translation("Red Sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_sandstone")
            )
        );

    public static DefaultSettings RED_SAND = new DefaultSettings(Blocks.RED_SAND)
        .material("red_sand")
        .translation("Red Sand")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_sand")
            )
        );

    public static DefaultSettings REDSTONE_BLOCK = new DefaultSettings(Blocks.REDSTONE_BLOCK)
        .material("redstone_block")
        .translation("Redstone Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:redstone_block")
            )
        );

    public static DefaultSettings ROOTED_DIRT = new DefaultSettings(Blocks.ROOTED_DIRT)
        .material("rooted_dirt")
        .translation("Rooted Dirt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:rooted_dirt")
            )
        );

    public static DefaultSettings SAND = new DefaultSettings(Blocks.SAND)
        .material("sand")
        .translation("Sand")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sand")
            )
        );

    public static DefaultSettings SANDSTONE = new DefaultSettings(Blocks.SANDSTONE)
        .material("sandstone")
        .translation("Sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sandstone")
            )
        );

    public static DefaultSettings SMOOTH_BASALT = new DefaultSettings(Blocks.SMOOTH_BASALT)
        .material("smooth_basalt")
        .translation("Smooth Basalt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:smooth_basalt")
            )
        );

    public static DefaultSettings SMOOTH_QUARTZ = new DefaultSettings(Blocks.SMOOTH_QUARTZ)
        .material("smooth_quartz")
        .translation("Smooth Quartz")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:quartz_block_bottom"),
                "ingredient", new Identifier("minecraft:smooth_quartz")
            )
        );

    public static DefaultSettings SMOOTH_RED_SANDSTONE = new DefaultSettings(Blocks.SMOOTH_RED_SANDSTONE)
        .material("smooth_red_sandstone")
        .translation("Smooth Red Sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_red_sandstone")
            )
        );

    public static DefaultSettings SMOOTH_SANDSTONE = new DefaultSettings(Blocks.SMOOTH_SANDSTONE)
        .material("smooth_sandstone")
        .translation("Smooth Sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_sandstone")
            )
        );

    public static DefaultSettings SMOOTH_STONE = new DefaultSettings(Blocks.SMOOTH_STONE)
        .material("smooth_stone")
        .translation("Smooth Stone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:smooth_stone")
            )
        );

    public static DefaultSettings SOUL_SAND = new DefaultSettings(Blocks.SOUL_SAND)
        .material("soul_sand")
        .translation("Soul Sand")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:soul_sand")
            )
        );

    public static DefaultSettings STONE_BRICK = new DefaultSettings(Blocks.STONE_BRICKS)
        .material("stone_brick")
        .translation("Stone Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:stone_bricks")
            )
        );

    public static DefaultSettings STONE = new DefaultSettings(Blocks.STONE)
        .material("stone")
        .translation("Stone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:stone")
            )
        );

    public static DefaultSettings TUFF = new DefaultSettings(Blocks.TUFF)
        .material("tuff")
        .translation("Tuff")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:tuff")
            )
        );

    public static DefaultSettings WARPED_BASALT_BRICK = new DefaultSettings(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK)
        .material("warped_basalt_brick")
        .translation("Warped Basalt Brick")
        .materials(
            Map.of(
                "main", WarpedBasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings WARPED_NETHER_BRICK = new DefaultSettings(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK)
        .material("warped_nether_brick")
        .translation("Warped Nether Brick")
        .materials(
            Map.of(
                "main", WarpedNetherBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings CUT_COPPER = new DefaultSettings(Blocks.CUT_COPPER)
        .material("cut_copper")
        .translation("Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_copper")
            )
        );

    public static DefaultSettings EXPOSED_CUT_COPPER = new DefaultSettings(Blocks.EXPOSED_CUT_COPPER)
        .material("exposed_cut_copper")
        .translation("Exposed Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:exposed_cut_copper")
            )
        );

    public static DefaultSettings WEATHERED_CUT_COPPER = new DefaultSettings(Blocks.WEATHERED_CUT_COPPER)
        .material("weathered_cut_copper")
        .translation("Weathered Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:weathered_cut_copper")
            )
        );

    public static DefaultSettings OXIDIZED_CUT_COPPER = new DefaultSettings(Blocks.OXIDIZED_CUT_COPPER)
        .material("oxidized_cut_copper")
        .translation("Oxidized Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:oxidized_cut_copper")
            )
        );

    public static DefaultSettings WAXED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_CUT_COPPER)
        .material("waxed_cut_copper")
        .translation("Waxed Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_copper"),
                "ingredient", new Identifier("minecraft:waxed_cut_copper")
            )
        );

    public static DefaultSettings WAXED_EXPOSED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_EXPOSED_CUT_COPPER)
        .material("waxed_exposed_cut_copper")
        .translation("Waxed Exposed Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:exposed_cut_copper"),
                "ingredient", new Identifier("minecraft:waxed_exposed_cut_copper")
            )
        );

    public static DefaultSettings WAXED_WEATHERED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_WEATHERED_CUT_COPPER)
        .material("waxed_weathered_cut_copper")
        .translation("Waxed Weathered Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:weathered_cut_copper"),
                "ingredient", new Identifier("minecraft:waxed_weathered_cut_copper")
            )
        );

    public static DefaultSettings WAXED_OXIDIZED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_OXIDIZED_CUT_COPPER)
        .material("waxed_oxidized_cut_copper")
        .translation("Waxed Oxidized Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:oxidized_cut_copper"),
                "ingredient", new Identifier("minecraft:waxed_oxidized_cut_copper")
            )
        );

    public static DefaultSettings WHITE_TERRACOTTA = new DefaultSettings(Blocks.WHITE_TERRACOTTA)
        .material("white_terracotta")
        .translation("White Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_terracotta")
            )
        );

    public static DefaultSettings ORANGE_TERRACOTTA = new DefaultSettings(Blocks.ORANGE_TERRACOTTA)
        .material("orange_terracotta")
        .translation("Orange Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_terracotta")
            )
        );

    public static DefaultSettings MAGENTA_TERRACOTTA = new DefaultSettings(Blocks.MAGENTA_TERRACOTTA)
        .material("magenta_terracotta")
        .translation("Magenta Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_terracotta")
            )
        );

    public static DefaultSettings LIGHT_BLUE_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_BLUE_TERRACOTTA)
        .material("light_blue_terracotta")
        .translation("Light Blue Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_terracotta")
            )
        );

    public static DefaultSettings YELLOW_TERRACOTTA = new DefaultSettings(Blocks.YELLOW_TERRACOTTA)
        .material("yellow_terracotta")
        .translation("Yellow Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_terracotta")
            )
        );

    public static DefaultSettings LIME_TERRACOTTA = new DefaultSettings(Blocks.LIME_TERRACOTTA)
        .material("lime_terracotta")
        .translation("Lime Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_terracotta")
            )
        );

    public static DefaultSettings PINK_TERRACOTTA = new DefaultSettings(Blocks.PINK_TERRACOTTA)
        .material("pink_terracotta")
        .translation("Pink Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_terracotta")
            )
        );

    public static DefaultSettings GRAY_TERRACOTTA = new DefaultSettings(Blocks.GRAY_TERRACOTTA)
        .material("gray_terracotta")
        .translation("Gray Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_terracotta")
            )
        );

    public static DefaultSettings LIGHT_GRAY_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_GRAY_TERRACOTTA)
        .material("light_gray_terracotta")
        .translation("Light Gray Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_terracotta")
            )
        );

    public static DefaultSettings CYAN_TERRACOTTA = new DefaultSettings(Blocks.CYAN_TERRACOTTA)
        .material("cyan_terracotta")
        .translation("Cyan Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_terracotta")
            )
        );

    public static DefaultSettings PURPLE_TERRACOTTA = new DefaultSettings(Blocks.PURPLE_TERRACOTTA)
        .material("purple_terracotta")
        .translation("Purple Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_terracotta")
            )
        );

    public static DefaultSettings BLUE_TERRACOTTA = new DefaultSettings(Blocks.BLUE_TERRACOTTA)
        .material("blue_terracotta")
        .translation("Blue Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_terracotta")
            )
        );

    public static DefaultSettings BROWN_TERRACOTTA = new DefaultSettings(Blocks.BROWN_TERRACOTTA)
        .material("brown_terracotta")
        .translation("Brown Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_terracotta")
            )
        );

    public static DefaultSettings GREEN_TERRACOTTA = new DefaultSettings(Blocks.GREEN_TERRACOTTA)
        .material("green_terracotta")
        .translation("Green Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_terracotta")
            )
        );

    public static DefaultSettings RED_TERRACOTTA = new DefaultSettings(Blocks.RED_TERRACOTTA)
        .material("red_terracotta")
        .translation("Red Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_terracotta")
            )
        );

    public static DefaultSettings BLACK_TERRACOTTA = new DefaultSettings(Blocks.BLACK_TERRACOTTA)
        .material("black_terracotta")
        .translation("Black Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_terracotta")
            )
        );

    public static DefaultSettings WHITE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.WHITE_GLAZED_TERRACOTTA)
        .material("white_glazed_terracotta")
        .translation("White Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_glazed_terracotta")
            )
        );

    public static DefaultSettings ORANGE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.ORANGE_GLAZED_TERRACOTTA)
        .material("orange_glazed_terracotta")
        .translation("Orange Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_glazed_terracotta")
            )
        );

    public static DefaultSettings MAGENTA_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.MAGENTA_GLAZED_TERRACOTTA)
        .material("magenta_glazed_terracotta")
        .translation("Magenta Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_glazed_terracotta")
            )
        );

    public static DefaultSettings LIGHT_BLUE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)
        .material("light_blue_glazed_terracotta")
        .translation("Light Blue Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_glazed_terracotta")
            )
        );

    public static DefaultSettings YELLOW_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.YELLOW_GLAZED_TERRACOTTA)
        .material("yellow_glazed_terracotta")
        .translation("Yellow Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_glazed_terracotta")
            )
        );

    public static DefaultSettings LIME_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIME_GLAZED_TERRACOTTA)
        .material("lime_glazed_terracotta")
        .translation("Lime Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_glazed_terracotta")
            )
        );

    public static DefaultSettings PINK_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.PINK_GLAZED_TERRACOTTA)
        .material("pink_glazed_terracotta")
        .translation("Pink Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_glazed_terracotta")
            )
        );

    public static DefaultSettings GRAY_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.GRAY_GLAZED_TERRACOTTA)
        .material("gray_glazed_terracotta")
        .translation("Gray Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_glazed_terracotta")
            )
        );

    public static DefaultSettings LIGHT_GRAY_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)
        .material("light_gray_glazed_terracotta")
        .translation("Light Gray Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_glazed_terracotta")
            )
        );

    public static DefaultSettings CYAN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.CYAN_GLAZED_TERRACOTTA)
        .material("cyan_glazed_terracotta")
        .translation("Cyan Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_glazed_terracotta")
            )
        );

    public static DefaultSettings PURPLE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.PURPLE_GLAZED_TERRACOTTA)
        .material("purple_glazed_terracotta")
        .translation("Purple Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_glazed_terracotta")
            )
        );

    public static DefaultSettings BLUE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BLUE_GLAZED_TERRACOTTA)
        .material("blue_glazed_terracotta")
        .translation("Blue Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_glazed_terracotta")
            )
        );

    public static DefaultSettings BROWN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BROWN_GLAZED_TERRACOTTA)
        .material("brown_glazed_terracotta")
        .translation("Brown Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_glazed_terracotta")
            )
        );

    public static DefaultSettings GREEN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.GREEN_GLAZED_TERRACOTTA)
        .material("green_glazed_terracotta")
        .translation("Green Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_glazed_terracotta")
            )
        );

    public static DefaultSettings RED_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.RED_GLAZED_TERRACOTTA)
        .material("red_glazed_terracotta")
        .translation("Red Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_glazed_terracotta")
            )
        );

    public static DefaultSettings BLACK_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BLACK_GLAZED_TERRACOTTA)
        .material("black_glazed_terracotta")
        .translation("Black Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_glazed_terracotta")
            )
        );

    public static DefaultSettings WHITE_CONCRETE = new DefaultSettings(Blocks.WHITE_CONCRETE)
        .material("white_concrete")
        .translation("White Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_concrete")
            )
        );

    public static DefaultSettings ORANGE_CONCRETE = new DefaultSettings(Blocks.ORANGE_CONCRETE)
        .material("orange_concrete")
        .translation("Orange Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_concrete")
            )
        );

    public static DefaultSettings MAGENTA_CONCRETE = new DefaultSettings(Blocks.MAGENTA_CONCRETE)
        .material("magenta_concrete")
        .translation("Magenta Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_concrete")
            )
        );

    public static DefaultSettings LIGHT_BLUE_CONCRETE = new DefaultSettings(Blocks.LIGHT_BLUE_CONCRETE)
        .material("light_blue_concrete")
        .translation("Light Blue Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_concrete")
            )
        );

    public static DefaultSettings YELLOW_CONCRETE = new DefaultSettings(Blocks.YELLOW_CONCRETE)
        .material("yellow_concrete")
        .translation("Yellow Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_concrete")
            )
        );

    public static DefaultSettings LIME_CONCRETE = new DefaultSettings(Blocks.LIME_CONCRETE)
        .material("lime_concrete")
        .translation("Lime Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_concrete")
            )
        );

    public static DefaultSettings PINK_CONCRETE = new DefaultSettings(Blocks.PINK_CONCRETE)
        .material("pink_concrete")
        .translation("Pink Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_concrete")
            )
        );

    public static DefaultSettings GRAY_CONCRETE = new DefaultSettings(Blocks.GRAY_CONCRETE)
        .material("gray_concrete")
        .translation("Gray Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_concrete")
            )
        );

    public static DefaultSettings LIGHT_GRAY_CONCRETE = new DefaultSettings(Blocks.LIGHT_GRAY_CONCRETE)
        .material("light_gray_concrete")
        .translation("Light Gray Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_concrete")
            )
        );

    public static DefaultSettings CYAN_CONCRETE = new DefaultSettings(Blocks.CYAN_CONCRETE)
        .material("cyan_concrete")
        .translation("Cyan Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_concrete")
            )
        );

    public static DefaultSettings PURPLE_CONCRETE = new DefaultSettings(Blocks.PURPLE_CONCRETE)
        .material("purple_concrete")
        .translation("Purple Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_concrete")
            )
        );

    public static DefaultSettings BLUE_CONCRETE = new DefaultSettings(Blocks.BLUE_CONCRETE)
        .material("blue_concrete")
        .translation("Blue Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_concrete")
            )
        );

    public static DefaultSettings BROWN_CONCRETE = new DefaultSettings(Blocks.BROWN_CONCRETE)
        .material("brown_concrete")
        .translation("Brown Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_concrete")
            )
        );

    public static DefaultSettings GREEN_CONCRETE = new DefaultSettings(Blocks.GREEN_CONCRETE)
        .material("green_concrete")
        .translation("Green Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_concrete")
            )
        );

    public static DefaultSettings RED_CONCRETE = new DefaultSettings(Blocks.RED_CONCRETE)
        .material("red_concrete")
        .translation("Red Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_concrete")
            )
        );

    public static DefaultSettings BLACK_CONCRETE = new DefaultSettings(Blocks.BLACK_CONCRETE)
        .material("black_concrete")
        .translation("Black Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_concrete")
            )
        );

    public static DefaultSettings WHITE_STAINED_GLASS = new DefaultSettings(Blocks.WHITE_STAINED_GLASS)
        .material("white_stained_glass")
        .translucent()
        .translation("White Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_stained_glass")
            )
        );

    public static DefaultSettings ORANGE_STAINED_GLASS = new DefaultSettings(Blocks.ORANGE_STAINED_GLASS)
        .material("orange_stained_glass")
        .translucent()
        .translation("Orange Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_stained_glass")
            )
        );

    public static DefaultSettings MAGENTA_STAINED_GLASS = new DefaultSettings(Blocks.MAGENTA_STAINED_GLASS)
        .material("magenta_stained_glass")
        .translucent()
        .translation("Magenta Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_stained_glass")
            )
        );

    public static DefaultSettings LIGHT_BLUE_STAINED_GLASS = new DefaultSettings(Blocks.LIGHT_BLUE_STAINED_GLASS)
        .material("light_blue_stained_glass")
        .translucent()
        .translation("Light Blue Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_stained_glass")
            )
        );

    public static DefaultSettings YELLOW_STAINED_GLASS = new DefaultSettings(Blocks.YELLOW_STAINED_GLASS)
        .material("yellow_stained_glass")
        .translucent()
        .translation("Yellow Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_stained_glass")
            )
        );

    public static DefaultSettings LIME_STAINED_GLASS = new DefaultSettings(Blocks.LIME_STAINED_GLASS)
        .material("lime_stained_glass")
        .translucent()
        .translation("Lime Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_stained_glass")
            )
        );

    public static DefaultSettings PINK_STAINED_GLASS = new DefaultSettings(Blocks.PINK_STAINED_GLASS)
        .material("pink_stained_glass")
        .translucent()
        .translation("Pink Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_stained_glass")
            )
        );

    public static DefaultSettings GRAY_STAINED_GLASS = new DefaultSettings(Blocks.GRAY_STAINED_GLASS)
        .material("gray_stained_glass")
        .translucent()
        .translation("Gray Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_stained_glass")
            )
        );

    public static DefaultSettings LIGHT_GRAY_STAINED_GLASS = new DefaultSettings(Blocks.LIGHT_GRAY_STAINED_GLASS)
        .material("light_gray_stained_glass")
        .translucent()
        .translation("Light Gray Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_stained_glass")
            )
        );

    public static DefaultSettings CYAN_STAINED_GLASS = new DefaultSettings(Blocks.CYAN_STAINED_GLASS)
        .material("cyan_stained_glass")
        .translucent()
        .translation("Cyan Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_stained_glass")
            )
        );

    public static DefaultSettings PURPLE_STAINED_GLASS = new DefaultSettings(Blocks.PURPLE_STAINED_GLASS)
        .material("purple_stained_glass")
        .translucent()
        .translation("Purple Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_stained_glass")
            )
        );

    public static DefaultSettings BLUE_STAINED_GLASS = new DefaultSettings(Blocks.BLUE_STAINED_GLASS)
        .material("blue_stained_glass")
        .translucent()
        .translation("Blue Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_stained_glass")
            )
        );

    public static DefaultSettings BROWN_STAINED_GLASS = new DefaultSettings(Blocks.BROWN_STAINED_GLASS)
        .material("brown_stained_glass")
        .translucent()
        .translation("Brown Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_stained_glass")
            )
        );

    public static DefaultSettings GREEN_STAINED_GLASS = new DefaultSettings(Blocks.GREEN_STAINED_GLASS)
        .material("green_stained_glass")
        .translucent()
        .translation("Green Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_stained_glass")
            )
        );

    public static DefaultSettings RED_STAINED_GLASS = new DefaultSettings(Blocks.RED_STAINED_GLASS)
        .material("red_stained_glass")
        .translucent()
        .translation("Red Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_stained_glass")
            )
        );

    public static DefaultSettings BLACK_STAINED_GLASS = new DefaultSettings(Blocks.BLACK_STAINED_GLASS)
        .material("black_stained_glass")
        .translucent()
        .translation("Black Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_stained_glass")
            )
        );

    public static DefaultSettings ACACIA_LOG = new DefaultSettings(Blocks.ACACIA_PLANKS)
        .material("acacia_log")
        .flammable()
        .translation("Acacia Log")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:acacia_log"),
                "end", new Identifier("minecraft:acacia_log_top"),
                "log", new Identifier("minecraft:acacia_log"),
                "stripped_log", new Identifier("minecraft:stripped_acacia_log"),
                "planks", new Identifier("minecraft:acacia_planks")
            )
        );

    public static DefaultSettings ACACIA = new DefaultSettings(Blocks.ACACIA_PLANKS)
        .material("acacia")
        .flammable()
        .translation("Acacia")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:acacia_planks"),
                "log", new Identifier("minecraft:acacia_log"),
                "stripped_log", new Identifier("minecraft:stripped_acacia_log"),
                "planks", new Identifier("minecraft:acacia_planks"),
                "slab", new Identifier("minecraft:acacia_slab")
            )
        );

    public static DefaultSettings BIRCH_LOG = new DefaultSettings(Blocks.BIRCH_PLANKS)
        .material("birch_log")
        .flammable()
        .translation("Birch Log")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:birch_log"),
                "end", new Identifier("minecraft:birch_log_top"),
                "log", new Identifier("minecraft:birch_log"),
                "stripped_log", new Identifier("minecraft:stripped_birch_log"),
                "planks", new Identifier("minecraft:birch_planks")
            )
        );

    public static DefaultSettings BIRCH = new DefaultSettings(Blocks.BIRCH_PLANKS)
        .material("birch")
        .flammable()
        .translation("Birch")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:birch_planks"),
                "log", new Identifier("minecraft:birch_log"),
                "stripped_log", new Identifier("minecraft:stripped_birch_log"),
                "planks", new Identifier("minecraft:birch_planks"),
                "slab", new Identifier("minecraft:birch_slab")
            )
        );

    public static DefaultSettings CRIMSON = new DefaultSettings(Blocks.CRIMSON_PLANKS)
        .material("crimson")
        .translation("Crimson")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:crimson_planks"),
                "log", new Identifier("minecraft:crimson_stem"),
                "stripped_log", new Identifier("minecraft:stripped_crimson_stem"),
                "planks", new Identifier("minecraft:crimson_planks"),
                "slab", new Identifier("minecraft:crimson_slab")
            )
        );

    public static DefaultSettings CRIMSON_STEM = new DefaultSettings(Blocks.CRIMSON_PLANKS)
        .material("crimson_stem")
        .translation("Crimson Stem")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:crimson_stem"),
                "end", new Identifier("minecraft:crimson_stem_top"),
                "log", new Identifier("minecraft:crimson_stem"),
                "stripped_log", new Identifier("minecraft:stripped_crimson_stem"),
                "planks", new Identifier("minecraft:crimson_planks")
            )
        );

    public static DefaultSettings DARK_OAK_LOG = new DefaultSettings(Blocks.DARK_OAK_PLANKS)
        .material("dark_oak_log")
        .flammable()
        .translation("Dark Oak Log")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dark_oak_log"),
                "end", new Identifier("minecraft:dark_oak_log_top"),
                "log", new Identifier("minecraft:dark_oak_log"),
                "stripped_log", new Identifier("minecraft:stripped_dark_oak_log"),
                "planks", new Identifier("minecraft:dark_oak_planks")
            )
        );

    public static DefaultSettings DARK_OAK = new DefaultSettings(Blocks.DARK_OAK_PLANKS)
        .material("dark_oak")
        .flammable()
        .translation("Dark Oak")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dark_oak_planks"),
                "log", new Identifier("minecraft:dark_oak_log"),
                "stripped_log", new Identifier("minecraft:stripped_dark_oak_log"),
                "planks", new Identifier("minecraft:dark_oak_planks"),
                "slab", new Identifier("minecraft:dark_oak_slab")
            )
        );

    public static DefaultSettings JUNGLE_LOG = new DefaultSettings(Blocks.JUNGLE_PLANKS)
        .material("jungle_log")
        .flammable()
        .translation("Jungle Log")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:jungle_log"),
                "end", new Identifier("minecraft:jungle_log_top"),
                "log", new Identifier("minecraft:jungle_log"),
                "stripped_log", new Identifier("minecraft:stripped_jungle_log"),
                "planks", new Identifier("minecraft:jungle_planks")
            )
        );

    public static DefaultSettings JUNGLE = new DefaultSettings(Blocks.JUNGLE_PLANKS)
        .material("jungle")
        .flammable()
        .translation("Jungle")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:jungle_planks"),
                "log", new Identifier("minecraft:jungle_log"),
                "stripped_log", new Identifier("minecraft:stripped_jungle_log"),
                "planks", new Identifier("minecraft:jungle_planks"),
                "slab", new Identifier("minecraft:jungle_slab")
            )
        );

    public static DefaultSettings OAK_LOG = new DefaultSettings(Blocks.OAK_PLANKS)
        .material("oak_log")
        .flammable()
        .translation("Oak Log")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:oak_log"),
                "end", new Identifier("minecraft:oak_log_top"),
                "log", new Identifier("minecraft:oak_log"),
                "stripped_log", new Identifier("minecraft:stripped_oak_log"),
                "planks", new Identifier("minecraft:oak_planks")
            )
        );

    public static DefaultSettings OAK = new DefaultSettings(Blocks.OAK_PLANKS)
        .material("oak")
        .flammable()
        .translation("Oak")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:oak_planks"),
                "log", new Identifier("minecraft:oak_log"),
                "stripped_log", new Identifier("minecraft:stripped_oak_log"),
                "planks", new Identifier("minecraft:oak_planks"),
                "slab", new Identifier("minecraft:oak_slab")
            )
        );

    public static DefaultSettings SPRUCE_LOG = new DefaultSettings(Blocks.SPRUCE_PLANKS)
        .material("spruce_log")
        .flammable()
        .translation("Spruce Log")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:spruce_log"),
                "end", new Identifier("minecraft:spruce_log_top"),
                "log", new Identifier("minecraft:spruce_log"),
                "stripped_log", new Identifier("minecraft:stripped_spruce_log"),
                "planks", new Identifier("minecraft:spruce_planks")
            )
        );

    public static DefaultSettings SPRUCE = new DefaultSettings(Blocks.SPRUCE_PLANKS)
        .material("spruce")
        .flammable()
        .translation("Spruce")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:spruce_planks"),
                "log", new Identifier("minecraft:spruce_log"),
                "stripped_log", new Identifier("minecraft:stripped_spruce_log"),
                "planks", new Identifier("minecraft:spruce_planks"),
                "slab", new Identifier("minecraft:spruce_slab")
            )
        );

    public static DefaultSettings WARPED = new DefaultSettings(Blocks.WARPED_PLANKS)
        .material("warped")
        .translation("Warped")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:warped_planks"),
                "log", new Identifier("minecraft:warped_stem"),
                "stripped_log", new Identifier("minecraft:stripped_warped_stem"),
                "planks", new Identifier("minecraft:warped_planks"),
                "slab", new Identifier("minecraft:warped_slab")
            )
        );

    public static DefaultSettings WARPED_STEM = new DefaultSettings(Blocks.WARPED_PLANKS)
        .material("warped_stem")
        .translation("Warped Stem")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:warped_stem"),
                "end", new Identifier("minecraft:warped_stem_top"),
                "log", new Identifier("minecraft:warped_stem"),
                "stripped_log", new Identifier("minecraft:stripped_warped_stem"),
                "planks", new Identifier("minecraft:warped_planks")
            )
        );

    public static DefaultSettings BAMBOO = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("bamboo")
        .translation("Bamboo")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:bamboo"),
                "ingredient", new Identifier("minecraft:bamboo")
            )
        );

    public static DefaultSettings BEETROOT = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("beetroot")
        .translation("Beetroot")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:beetroot"),
                "ingredient", new Identifier("minecraft:beetroot")
            )
        );

    public static DefaultSettings BLAZE_POWDER = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("blaze_powder")
        .translation("Blaze Powder")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blaze_powder"),
                "ingredient", new Identifier("minecraft:blaze_powder")
            )
        );

    public static DefaultSettings CARROT = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("carrot")
        .translation("Carrot")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:carrot"),
                "ingredient", new Identifier("minecraft:carrot")
            )
        );

    public static DefaultSettings CHORUS_FRUIT = new DefaultSettings(Blocks.PURPUR_BLOCK)
        .material("chorus_fruit")
        .translation("Chorus Fruit")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:chorus_fruit"),
                "ingredient", new Identifier("minecraft:chorus_fruit")
            )
        );

    public static DefaultSettings ENDER_PEARL = new DefaultSettings(Blocks.PURPUR_BLOCK)
        .material("ender_pearl")
        .translation("Ender Pearl")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:ender_pearl"),
                "ingredient", new Identifier("minecraft:ender_pearl")
            )
        );

    public static DefaultSettings POTATO = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("potato")
        .translation("Potato")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:potato"),
                "ingredient", new Identifier("minecraft:potato")
            )
        );

    public static DefaultSettings STICK = new DefaultSettings(Blocks.OAK_PLANKS)
        .material("stick")
        .translation("Stick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:stick"),
                "ingredient", new Identifier("minecraft:stick")
            )
        );

    public static DefaultSettings SUGAR = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("sugar")
        .translation("Sugar")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sugar"),
                "ingredient", new Identifier("minecraft:sugar")
            )
        );

    public static DefaultSettings SUGAR_CANE = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("sugar_cane")
        .translation("Sugar Cane")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sugar_cane"),
                "ingredient", new Identifier("minecraft:sugar_cane")
            )
        );

    public static DefaultSettings WHITE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("white_dye")
        .translation("White Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_dye"),
                "ingredient", new Identifier("minecraft:white_dye")
            )
        );

    public static DefaultSettings ORANGE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("orange_dye")
        .translation("Orange Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_dye"),
                "ingredient", new Identifier("minecraft:orange_dye")
            )
        );

    public static DefaultSettings MAGENTA_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("magenta_dye")
        .translation("Magenta Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_dye"),
                "ingredient", new Identifier("minecraft:magenta_dye")
            )
        );

    public static DefaultSettings LIGHT_BLUE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("light_blue_dye")
        .translation("Light Blue Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_dye"),
                "ingredient", new Identifier("minecraft:light_blue_dye")
            )
        );

    public static DefaultSettings YELLOW_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("yellow_dye")
        .translation("Yellow Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_dye"),
                "ingredient", new Identifier("minecraft:yellow_dye")
            )
        );

    public static DefaultSettings LIME_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("lime_dye")
        .translation("Lime Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_dye"),
                "ingredient", new Identifier("minecraft:lime_dye")
            )
        );

    public static DefaultSettings PINK_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("pink_dye")
        .translation("Pink Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_dye"),
                "ingredient", new Identifier("minecraft:pink_dye")
            )
        );

    public static DefaultSettings GRAY_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("gray_dye")
        .translation("Gray Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_dye"),
                "ingredient", new Identifier("minecraft:gray_dye")
            )
        );

    public static DefaultSettings LIGHT_GRAY_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("light_gray_dye")
        .translation("Light Gray Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_dye"),
                "ingredient", new Identifier("minecraft:light_gray_dye")
            )
        );

    public static DefaultSettings CYAN_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("cyan_dye")
        .translation("Cyan Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_dye"),
                "ingredient", new Identifier("minecraft:cyan_dye")
            )
        );

    public static DefaultSettings PURPLE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("purple_dye")
        .translation("Purple Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_dye"),
                "ingredient", new Identifier("minecraft:purple_dye")
            )
        );

    public static DefaultSettings BLUE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("blue_dye")
        .translation("Blue Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_dye"),
                "ingredient", new Identifier("minecraft:blue_dye")
            )
        );

    public static DefaultSettings BROWN_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("brown_dye")
        .translation("Brown Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_dye"),
                "ingredient", new Identifier("minecraft:brown_dye")
            )
        );

    public static DefaultSettings GREEN_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("green_dye")
        .translation("Green Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_dye"),
                "ingredient", new Identifier("minecraft:green_dye")
            )
        );

    public static DefaultSettings RED_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("red_dye")
        .translation("Red Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_dye"),
                "ingredient", new Identifier("minecraft:red_dye")
            )
        );

    public static DefaultSettings BLACK_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("black_dye")
        .translation("Black Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_dye"),
                "ingredient", new Identifier("minecraft:black_dye")
            )
        );
}
