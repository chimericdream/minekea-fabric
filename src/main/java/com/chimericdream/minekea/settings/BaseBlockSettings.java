package com.chimericdream.minekea.settings;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.*;
import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import com.chimericdream.minekea.util.Tool;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

import java.util.Map;

public class BaseBlockSettings {
    public static DefaultSettings AMETHYST = new DefaultSettings(Blocks.AMETHYST_BLOCK)
        .material("amethyst")
        .ingredientName("Amethyst")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:amethyst_block")
            )
        );

    public static DefaultSettings ANDESITE = new DefaultSettings(Blocks.ANDESITE)
        .material("andesite")
        .ingredientName("Andesite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:andesite")
            )
        );

    public static DefaultSettings BASALT = new DefaultSettings(Blocks.BASALT)
        .material("basalt")
        .ingredientName("Basalt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:basalt_side"),
                "end", new Identifier("minecraft:basalt_top"),
                "ingredient", new Identifier("minecraft:basalt")
            )
        );

    public static DefaultSettings BASALT_BRICK = new DefaultSettings(BuildingBlocks.BASALT_BRICKS_BLOCK)
        .material("basalt_brick")
        .ingredientName("Basalt Brick")
        .materials(
            Map.of(
                "main", BasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings BLACKSTONE = new DefaultSettings(Blocks.BLACKSTONE)
        .material("blackstone")
        .ingredientName("Blackstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blackstone")
            )
        );

    public static DefaultSettings BONE = new DefaultSettings(Blocks.BONE_BLOCK)
        .material("bone")
        .ingredientName("Bone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:bone_block_side"),
                "end", new Identifier("minecraft:bone_block_top"),
                "ingredient", new Identifier("minecraft:bone_block")
            )
        );

    public static DefaultSettings BRICK = new DefaultSettings(Blocks.BRICKS)
        .material("brick")
        .ingredientName("Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:bricks")
            )
        );

    public static DefaultSettings CALCITE = new DefaultSettings(Blocks.CALCITE)
        .material("calcite")
        .ingredientName("Calcite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:calcite")
            )
        );

    public static DefaultSettings CLAY = new DefaultSettings(Blocks.CLAY)
        .material("clay")
        .tool(Tool.SHOVEL)
        .ingredientName("Clay")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:clay")
            )
        );

    public static DefaultSettings COARSE_DIRT = new DefaultSettings(Blocks.COARSE_DIRT)
        .material("coarse_dirt")
        .tool(Tool.SHOVEL)
        .ingredientName("Coarse Dirt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:coarse_dirt")
            )
        );

    public static DefaultSettings COBBLED_DEEPSLATE = new DefaultSettings(Blocks.COBBLED_DEEPSLATE)
        .material("cobbled_deepslate")
        .ingredientName("Cobbled Deepslate")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cobbled_deepslate")
            )
        );

    public static DefaultSettings COBBLED_END_STONE = new DefaultSettings(BuildingBlocks.COBBLED_END_STONE_BLOCK)
        .material("cobbled_end_stone")
        .ingredientName("Cobbled End Stone")
        .materials(
            Map.of(
                "main", CobbledEndStoneBlock.BLOCK_ID
            )
        );

    public static DefaultSettings COBBLESTONE = new DefaultSettings(Blocks.COBBLESTONE)
        .material("cobblestone")
        .ingredientName("Cobblestone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cobblestone")
            )
        );

    public static DefaultSettings COPPER_BLOCK = new DefaultSettings(Blocks.COPPER_BLOCK)
        .material("copper_block")
        .ingredientName("Copper Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:copper_block")
            )
        );

    public static DefaultSettings CRACKED_BASALT_BRICK = new DefaultSettings(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK)
        .material("cracked_basalt_brick")
        .ingredientName("Cracked Basalt Brick")
        .materials(
            Map.of(
                "main", CrackedBasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings CRACKED_DEEPSLATE_BRICK = new DefaultSettings(Blocks.CRACKED_DEEPSLATE_BRICKS)
        .material("cracked_deepslate_brick")
        .ingredientName("Cracked Deepslate Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cracked_deepslate_bricks")
            )
        );

    public static DefaultSettings CRACKED_DEEPSLATE_TILE = new DefaultSettings(Blocks.CRACKED_DEEPSLATE_TILES)
        .material("cracked_deepslate_tile")
        .ingredientName("Cracked Deepslate Tile")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cracked_deepslate_tiles")
            )
        );

    public static DefaultSettings CRACKED_STONE_BRICK = new DefaultSettings(Blocks.CRACKED_STONE_BRICKS)
        .material("cracked_stone_brick")
        .ingredientName("Cracked Stone Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cracked_stone_bricks")
            )
        );

    public static DefaultSettings CRIMSON_BASALT_BRICK = new DefaultSettings(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK)
        .material("crimson_basalt_brick")
        .ingredientName("Crimson Basalt Brick")
        .materials(
            Map.of(
                "main", CrimsonBasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings CRYING_OBSIDIAN = new DefaultSettings(Blocks.CRYING_OBSIDIAN)
        .material("crying_obsidian")
        .ingredientName("Crying Obsidian")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:crying_obsidian")
            )
        );

    public static DefaultSettings CUT_RED_SANDSTONE = new DefaultSettings(Blocks.CUT_RED_SANDSTONE)
        .material("cut_red_sandstone")
        .ingredientName("Cut Red Sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_red_sandstone")
            )
        );

    public static DefaultSettings CUT_SANDSTONE = new DefaultSettings(Blocks.CUT_SANDSTONE)
        .material("cut_sandstone")
        .ingredientName("Cut Sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_sandstone")
            )
        );

    public static DefaultSettings DARK_PRISMARINE = new DefaultSettings(Blocks.DARK_PRISMARINE)
        .material("dark_prismarine")
        .ingredientName("Dark Prismarine")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dark_prismarine")
            )
        );

    public static DefaultSettings DEEPSLATE_BRICK = new DefaultSettings(Blocks.DEEPSLATE_BRICKS)
        .material("deepslate_brick")
        .ingredientName("Deepslate Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:deepslate_bricks")
            )
        );

    public static DefaultSettings DEEPSLATE = new DefaultSettings(Blocks.DEEPSLATE)
        .material("deepslate")
        .ingredientName("Deepslate")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:deepslate")
            )
        );

    public static DefaultSettings DEEPSLATE_TILE = new DefaultSettings(Blocks.DEEPSLATE_TILES)
        .material("deepslate_tile")
        .ingredientName("Deepslate Tile")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:deepslate_tiles")
            )
        );

    public static DefaultSettings DIAMOND_BLOCK = new DefaultSettings(Blocks.DIAMOND_BLOCK)
        .material("diamond_block")
        .ingredientName("Diamond Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:diamond_block")
            )
        );

    public static DefaultSettings DIORITE = new DefaultSettings(Blocks.DIORITE)
        .material("diorite")
        .ingredientName("Diorite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:diorite")
            )
        );

    public static DefaultSettings DIRT = new DefaultSettings(Blocks.DIRT)
        .material("dirt")
        .tool(Tool.SHOVEL)
        .ingredientName("Dirt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dirt")
            )
        );

    public static DefaultSettings END_STONE_BRICK = new DefaultSettings(Blocks.END_STONE_BRICKS)
        .material("end_stone_brick")
        .ingredientName("End Stone Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:end_stone_bricks")
            )
        );

    public static DefaultSettings END_STONE = new DefaultSettings(Blocks.END_STONE)
        .material("end_stone")
        .ingredientName("End Stone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:end_stone")
            )
        );

    public static DefaultSettings GOLD_BLOCK = new DefaultSettings(Blocks.GOLD_BLOCK)
        .material("gold_block")
        .ingredientName("Gold Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gold_block")
            )
        );

    public static DefaultSettings GRANITE = new DefaultSettings(Blocks.GRANITE)
        .material("granite")
        .ingredientName("Granite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:granite")
            )
        );

    public static DefaultSettings GRAVEL = new DefaultSettings(Blocks.GRAVEL)
        .material("gravel")
        .tool(Tool.SHOVEL)
        .ingredientName("Gravel")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gravel")
            )
        );

    public static DefaultSettings IRON_BLOCK = new DefaultSettings(Blocks.IRON_BLOCK)
        .material("iron_block")
        .ingredientName("Iron Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:iron_block")
            )
        );

    public static DefaultSettings LAPIS_BLOCK = new DefaultSettings(Blocks.LAPIS_BLOCK)
        .material("lapis_block")
        .ingredientName("Lapis Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lapis_block")
            )
        );

    public static DefaultSettings MOSSY_BASALT_BRICK = new DefaultSettings(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK)
        .material("mossy_basalt_brick")
        .ingredientName("Mossy Basalt Brick")
        .materials(
            Map.of(
                "main", MossyBasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings MOSSY_COBBLESTONE = new DefaultSettings(Blocks.MOSSY_COBBLESTONE)
        .material("mossy_cobblestone")
        .ingredientName("Mossy Cobblestone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:mossy_cobblestone")
            )
        );

    public static DefaultSettings MOSSY_STONE_BRICK = new DefaultSettings(Blocks.MOSSY_STONE_BRICKS)
        .material("mossy_stone_brick")
        .ingredientName("Mossy Stone Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:mossy_stone_bricks")
            )
        );

    public static DefaultSettings NETHERRACK = new DefaultSettings(Blocks.NETHERRACK)
        .material("netherrack")
        .ingredientName("Netherrack")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:netherrack")
            )
        );

    public static DefaultSettings NETHER_BRICK = new DefaultSettings(Blocks.NETHER_BRICKS)
        .material("nether_brick")
        .ingredientName("Nether Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:nether_bricks")
            )
        );

    public static DefaultSettings NETHERITE_BLOCK = new DefaultSettings(Blocks.NETHERITE_BLOCK)
        .material("netherite_block")
        .ingredientName("Netherite Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:netherite_block")
            )
        );

    public static DefaultSettings OBSIDIAN = new DefaultSettings(Blocks.OBSIDIAN)
        .material("obsidian")
        .ingredientName("Obsidian")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:obsidian")
            )
        );

    public static DefaultSettings POLISHED_ANDESITE = new DefaultSettings(Blocks.POLISHED_ANDESITE)
        .material("polished_andesite")
        .ingredientName("Polished Andesite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_andesite")
            )
        );

    public static DefaultSettings POLISHED_BASALT = new DefaultSettings(Blocks.POLISHED_BASALT)
        .material("polished_basalt")
        .ingredientName("Polished Basalt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_basalt_side"),
                "end", new Identifier("minecraft:polished_basalt_top"),
                "ingredient", new Identifier("minecraft:polished_basalt")
            )
        );

    public static DefaultSettings POLISHED_BLACKSTONE_BRICK = new DefaultSettings(Blocks.POLISHED_BLACKSTONE_BRICKS)
        .material("polished_blackstone_brick")
        .ingredientName("Polished Blackstone Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_blackstone_bricks")
            )
        );

    public static DefaultSettings POLISHED_BLACKSTONE = new DefaultSettings(Blocks.POLISHED_BLACKSTONE)
        .material("polished_blackstone")
        .ingredientName("Polished Blackstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_blackstone")
            )
        );

    public static DefaultSettings POLISHED_DEEPSLATE = new DefaultSettings(Blocks.POLISHED_DEEPSLATE)
        .material("polished_deepslate")
        .ingredientName("Polished Deepslate")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_deepslate")
            )
        );

    public static DefaultSettings POLISHED_DIORITE = new DefaultSettings(Blocks.POLISHED_DIORITE)
        .material("polished_diorite")
        .ingredientName("Polished Diorite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_diorite")
            )
        );

    public static DefaultSettings POLISHED_GRANITE = new DefaultSettings(Blocks.POLISHED_GRANITE)
        .material("polished_granite")
        .ingredientName("Polished Granite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_granite")
            )
        );

    public static DefaultSettings PRISMARINE_BRICK = new DefaultSettings(Blocks.PRISMARINE_BRICKS)
        .material("prismarine_brick")
        .ingredientName("Prismarine Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:prismarine_bricks")
            )
        );

    public static DefaultSettings PRISMARINE = new DefaultSettings(Blocks.PRISMARINE)
        .material("prismarine")
        .ingredientName("Prismarine")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:prismarine")
            )
        );

    public static DefaultSettings PURPUR = new DefaultSettings(Blocks.PURPUR_BLOCK)
        .material("purpur")
        .ingredientName("Purpur")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purpur_block")
            )
        );

    public static DefaultSettings PURPUR_PILLAR = new DefaultSettings(Blocks.PURPUR_PILLAR)
        .material("purpur_pillar")
        .ingredientName("Purpur Pillar")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purpur_pillar")
            )
        );

    public static DefaultSettings QUARTZ = new DefaultSettings(Blocks.QUARTZ_BLOCK)
        .material("quartz")
        .ingredientName("Quartz")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:quartz_block_top"),
                "ingredient", new Identifier("minecraft:quartz_block")
            )
        );

    public static DefaultSettings QUARTZ_BRICK = new DefaultSettings(Blocks.QUARTZ_BRICKS)
        .material("quartz_brick")
        .ingredientName("Quartz Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:quartz_bricks")
            )
        );

    public static DefaultSettings RED_NETHER_BRICK = new DefaultSettings(Blocks.RED_NETHER_BRICKS)
        .material("red_nether_brick")
        .ingredientName("Red Nether Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_nether_bricks")
            )
        );

    public static DefaultSettings RED_SANDSTONE = new DefaultSettings(Blocks.RED_SANDSTONE)
        .material("red_sandstone")
        .ingredientName("Red Sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_sandstone")
            )
        );

    public static DefaultSettings RED_SAND = new DefaultSettings(Blocks.RED_SAND)
        .material("red_sand")
        .tool(Tool.SHOVEL)
        .ingredientName("Red Sand")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_sand")
            )
        );

    public static DefaultSettings REDSTONE_BLOCK = new DefaultSettings(Blocks.REDSTONE_BLOCK)
        .material("redstone_block")
        .ingredientName("Redstone Block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:redstone_block")
            )
        );

    public static DefaultSettings ROOTED_DIRT = new DefaultSettings(Blocks.ROOTED_DIRT)
        .material("rooted_dirt")
        .tool(Tool.SHOVEL)
        .ingredientName("Rooted Dirt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:rooted_dirt")
            )
        );

    public static DefaultSettings SAND = new DefaultSettings(Blocks.SAND)
        .material("sand")
        .tool(Tool.SHOVEL)
        .ingredientName("Sand")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sand")
            )
        );

    public static DefaultSettings SANDSTONE = new DefaultSettings(Blocks.SANDSTONE)
        .material("sandstone")
        .ingredientName("Sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sandstone")
            )
        );

    public static DefaultSettings SMOOTH_BASALT = new DefaultSettings(Blocks.SMOOTH_BASALT)
        .material("smooth_basalt")
        .ingredientName("Smooth Basalt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:smooth_basalt")
            )
        );

    public static DefaultSettings SMOOTH_QUARTZ = new DefaultSettings(Blocks.SMOOTH_QUARTZ)
        .material("smooth_quartz")
        .ingredientName("Smooth Quartz")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:quartz_block_bottom"),
                "ingredient", new Identifier("minecraft:smooth_quartz")
            )
        );

    public static DefaultSettings SMOOTH_RED_SANDSTONE = new DefaultSettings(Blocks.SMOOTH_RED_SANDSTONE)
        .material("smooth_red_sandstone")
        .ingredientName("Smooth Red Sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_red_sandstone")
            )
        );

    public static DefaultSettings SMOOTH_SANDSTONE = new DefaultSettings(Blocks.SMOOTH_SANDSTONE)
        .material("smooth_sandstone")
        .ingredientName("Smooth Sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_sandstone")
            )
        );

    public static DefaultSettings SMOOTH_STONE = new DefaultSettings(Blocks.SMOOTH_STONE)
        .material("smooth_stone")
        .ingredientName("Smooth Stone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:smooth_stone")
            )
        );

    public static DefaultSettings SOUL_SAND = new DefaultSettings(Blocks.SOUL_SAND)
        .material("soul_sand")
        .tool(Tool.SHOVEL)
        .ingredientName("Soul Sand")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:soul_sand")
            )
        );

    public static DefaultSettings STONE_BRICK = new DefaultSettings(Blocks.STONE_BRICKS)
        .material("stone_brick")
        .ingredientName("Stone Brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:stone_bricks")
            )
        );

    public static DefaultSettings STONE = new DefaultSettings(Blocks.STONE)
        .material("stone")
        .ingredientName("Stone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:stone")
            )
        );

    public static DefaultSettings TUFF = new DefaultSettings(Blocks.TUFF)
        .material("tuff")
        .ingredientName("Tuff")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:tuff")
            )
        );

    public static DefaultSettings WARPED_BASALT_BRICK = new DefaultSettings(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK)
        .material("warped_basalt_brick")
        .ingredientName("Warped Basalt Brick")
        .materials(
            Map.of(
                "main", WarpedBasaltBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings WARPED_NETHER_BRICK = new DefaultSettings(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK)
        .material("warped_nether_brick")
        .ingredientName("Warped Nether Brick")
        .materials(
            Map.of(
                "main", WarpedNetherBricksBlock.BLOCK_ID
            )
        );

    public static DefaultSettings CUT_COPPER = new DefaultSettings(Blocks.CUT_COPPER)
        .material("cut_copper")
        .ingredientName("Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_copper")
            )
        );

    public static DefaultSettings EXPOSED_CUT_COPPER = new DefaultSettings(Blocks.EXPOSED_CUT_COPPER)
        .material("exposed_cut_copper")
        .ingredientName("Exposed Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:exposed_cut_copper")
            )
        );

    public static DefaultSettings WEATHERED_CUT_COPPER = new DefaultSettings(Blocks.WEATHERED_CUT_COPPER)
        .material("weathered_cut_copper")
        .ingredientName("Weathered Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:weathered_cut_copper")
            )
        );

    public static DefaultSettings OXIDIZED_CUT_COPPER = new DefaultSettings(Blocks.OXIDIZED_CUT_COPPER)
        .material("oxidized_cut_copper")
        .ingredientName("Oxidized Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:oxidized_cut_copper")
            )
        );

    public static DefaultSettings WAXED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_CUT_COPPER)
        .material("waxed_cut_copper")
        .ingredientName("Waxed Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_copper"),
                "ingredient", new Identifier("minecraft:waxed_cut_copper")
            )
        );

    public static DefaultSettings WAXED_EXPOSED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_EXPOSED_CUT_COPPER)
        .material("waxed_exposed_cut_copper")
        .ingredientName("Waxed Exposed Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:exposed_cut_copper"),
                "ingredient", new Identifier("minecraft:waxed_exposed_cut_copper")
            )
        );

    public static DefaultSettings WAXED_WEATHERED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_WEATHERED_CUT_COPPER)
        .material("waxed_weathered_cut_copper")
        .ingredientName("Waxed Weathered Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:weathered_cut_copper"),
                "ingredient", new Identifier("minecraft:waxed_weathered_cut_copper")
            )
        );

    public static DefaultSettings WAXED_OXIDIZED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_OXIDIZED_CUT_COPPER)
        .material("waxed_oxidized_cut_copper")
        .ingredientName("Waxed Oxidized Cut Copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:oxidized_cut_copper"),
                "ingredient", new Identifier("minecraft:waxed_oxidized_cut_copper")
            )
        );

    public static DefaultSettings WHITE_TERRACOTTA = new DefaultSettings(Blocks.WHITE_TERRACOTTA)
        .material("white_terracotta")
        .ingredientName("White Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_terracotta")
            )
        );

    public static DefaultSettings ORANGE_TERRACOTTA = new DefaultSettings(Blocks.ORANGE_TERRACOTTA)
        .material("orange_terracotta")
        .ingredientName("Orange Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_terracotta")
            )
        );

    public static DefaultSettings MAGENTA_TERRACOTTA = new DefaultSettings(Blocks.MAGENTA_TERRACOTTA)
        .material("magenta_terracotta")
        .ingredientName("Magenta Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_terracotta")
            )
        );

    public static DefaultSettings LIGHT_BLUE_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_BLUE_TERRACOTTA)
        .material("light_blue_terracotta")
        .ingredientName("Light Blue Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_terracotta")
            )
        );

    public static DefaultSettings YELLOW_TERRACOTTA = new DefaultSettings(Blocks.YELLOW_TERRACOTTA)
        .material("yellow_terracotta")
        .ingredientName("Yellow Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_terracotta")
            )
        );

    public static DefaultSettings LIME_TERRACOTTA = new DefaultSettings(Blocks.LIME_TERRACOTTA)
        .material("lime_terracotta")
        .ingredientName("Lime Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_terracotta")
            )
        );

    public static DefaultSettings PINK_TERRACOTTA = new DefaultSettings(Blocks.PINK_TERRACOTTA)
        .material("pink_terracotta")
        .ingredientName("Pink Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_terracotta")
            )
        );

    public static DefaultSettings GRAY_TERRACOTTA = new DefaultSettings(Blocks.GRAY_TERRACOTTA)
        .material("gray_terracotta")
        .ingredientName("Gray Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_terracotta")
            )
        );

    public static DefaultSettings LIGHT_GRAY_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_GRAY_TERRACOTTA)
        .material("light_gray_terracotta")
        .ingredientName("Light Gray Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_terracotta")
            )
        );

    public static DefaultSettings CYAN_TERRACOTTA = new DefaultSettings(Blocks.CYAN_TERRACOTTA)
        .material("cyan_terracotta")
        .ingredientName("Cyan Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_terracotta")
            )
        );

    public static DefaultSettings PURPLE_TERRACOTTA = new DefaultSettings(Blocks.PURPLE_TERRACOTTA)
        .material("purple_terracotta")
        .ingredientName("Purple Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_terracotta")
            )
        );

    public static DefaultSettings BLUE_TERRACOTTA = new DefaultSettings(Blocks.BLUE_TERRACOTTA)
        .material("blue_terracotta")
        .ingredientName("Blue Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_terracotta")
            )
        );

    public static DefaultSettings BROWN_TERRACOTTA = new DefaultSettings(Blocks.BROWN_TERRACOTTA)
        .material("brown_terracotta")
        .ingredientName("Brown Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_terracotta")
            )
        );

    public static DefaultSettings GREEN_TERRACOTTA = new DefaultSettings(Blocks.GREEN_TERRACOTTA)
        .material("green_terracotta")
        .ingredientName("Green Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_terracotta")
            )
        );

    public static DefaultSettings RED_TERRACOTTA = new DefaultSettings(Blocks.RED_TERRACOTTA)
        .material("red_terracotta")
        .ingredientName("Red Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_terracotta")
            )
        );

    public static DefaultSettings BLACK_TERRACOTTA = new DefaultSettings(Blocks.BLACK_TERRACOTTA)
        .material("black_terracotta")
        .ingredientName("Black Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_terracotta")
            )
        );

    public static DefaultSettings WHITE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.WHITE_GLAZED_TERRACOTTA)
        .material("white_glazed_terracotta")
        .ingredientName("White Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_glazed_terracotta")
            )
        );

    public static DefaultSettings ORANGE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.ORANGE_GLAZED_TERRACOTTA)
        .material("orange_glazed_terracotta")
        .ingredientName("Orange Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_glazed_terracotta")
            )
        );

    public static DefaultSettings MAGENTA_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.MAGENTA_GLAZED_TERRACOTTA)
        .material("magenta_glazed_terracotta")
        .ingredientName("Magenta Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_glazed_terracotta")
            )
        );

    public static DefaultSettings LIGHT_BLUE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)
        .material("light_blue_glazed_terracotta")
        .ingredientName("Light Blue Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_glazed_terracotta")
            )
        );

    public static DefaultSettings YELLOW_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.YELLOW_GLAZED_TERRACOTTA)
        .material("yellow_glazed_terracotta")
        .ingredientName("Yellow Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_glazed_terracotta")
            )
        );

    public static DefaultSettings LIME_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIME_GLAZED_TERRACOTTA)
        .material("lime_glazed_terracotta")
        .ingredientName("Lime Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_glazed_terracotta")
            )
        );

    public static DefaultSettings PINK_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.PINK_GLAZED_TERRACOTTA)
        .material("pink_glazed_terracotta")
        .ingredientName("Pink Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_glazed_terracotta")
            )
        );

    public static DefaultSettings GRAY_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.GRAY_GLAZED_TERRACOTTA)
        .material("gray_glazed_terracotta")
        .ingredientName("Gray Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_glazed_terracotta")
            )
        );

    public static DefaultSettings LIGHT_GRAY_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)
        .material("light_gray_glazed_terracotta")
        .ingredientName("Light Gray Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_glazed_terracotta")
            )
        );

    public static DefaultSettings CYAN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.CYAN_GLAZED_TERRACOTTA)
        .material("cyan_glazed_terracotta")
        .ingredientName("Cyan Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_glazed_terracotta")
            )
        );

    public static DefaultSettings PURPLE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.PURPLE_GLAZED_TERRACOTTA)
        .material("purple_glazed_terracotta")
        .ingredientName("Purple Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_glazed_terracotta")
            )
        );

    public static DefaultSettings BLUE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BLUE_GLAZED_TERRACOTTA)
        .material("blue_glazed_terracotta")
        .ingredientName("Blue Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_glazed_terracotta")
            )
        );

    public static DefaultSettings BROWN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BROWN_GLAZED_TERRACOTTA)
        .material("brown_glazed_terracotta")
        .ingredientName("Brown Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_glazed_terracotta")
            )
        );

    public static DefaultSettings GREEN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.GREEN_GLAZED_TERRACOTTA)
        .material("green_glazed_terracotta")
        .ingredientName("Green Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_glazed_terracotta")
            )
        );

    public static DefaultSettings RED_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.RED_GLAZED_TERRACOTTA)
        .material("red_glazed_terracotta")
        .ingredientName("Red Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_glazed_terracotta")
            )
        );

    public static DefaultSettings BLACK_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BLACK_GLAZED_TERRACOTTA)
        .material("black_glazed_terracotta")
        .ingredientName("Black Glazed Terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_glazed_terracotta")
            )
        );

    public static DefaultSettings WHITE_CONCRETE = new DefaultSettings(Blocks.WHITE_CONCRETE)
        .material("white_concrete")
        .ingredientName("White Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_concrete")
            )
        );

    public static DefaultSettings ORANGE_CONCRETE = new DefaultSettings(Blocks.ORANGE_CONCRETE)
        .material("orange_concrete")
        .ingredientName("Orange Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_concrete")
            )
        );

    public static DefaultSettings MAGENTA_CONCRETE = new DefaultSettings(Blocks.MAGENTA_CONCRETE)
        .material("magenta_concrete")
        .ingredientName("Magenta Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_concrete")
            )
        );

    public static DefaultSettings LIGHT_BLUE_CONCRETE = new DefaultSettings(Blocks.LIGHT_BLUE_CONCRETE)
        .material("light_blue_concrete")
        .ingredientName("Light Blue Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_concrete")
            )
        );

    public static DefaultSettings YELLOW_CONCRETE = new DefaultSettings(Blocks.YELLOW_CONCRETE)
        .material("yellow_concrete")
        .ingredientName("Yellow Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_concrete")
            )
        );

    public static DefaultSettings LIME_CONCRETE = new DefaultSettings(Blocks.LIME_CONCRETE)
        .material("lime_concrete")
        .ingredientName("Lime Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_concrete")
            )
        );

    public static DefaultSettings PINK_CONCRETE = new DefaultSettings(Blocks.PINK_CONCRETE)
        .material("pink_concrete")
        .ingredientName("Pink Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_concrete")
            )
        );

    public static DefaultSettings GRAY_CONCRETE = new DefaultSettings(Blocks.GRAY_CONCRETE)
        .material("gray_concrete")
        .ingredientName("Gray Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_concrete")
            )
        );

    public static DefaultSettings LIGHT_GRAY_CONCRETE = new DefaultSettings(Blocks.LIGHT_GRAY_CONCRETE)
        .material("light_gray_concrete")
        .ingredientName("Light Gray Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_concrete")
            )
        );

    public static DefaultSettings CYAN_CONCRETE = new DefaultSettings(Blocks.CYAN_CONCRETE)
        .material("cyan_concrete")
        .ingredientName("Cyan Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_concrete")
            )
        );

    public static DefaultSettings PURPLE_CONCRETE = new DefaultSettings(Blocks.PURPLE_CONCRETE)
        .material("purple_concrete")
        .ingredientName("Purple Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_concrete")
            )
        );

    public static DefaultSettings BLUE_CONCRETE = new DefaultSettings(Blocks.BLUE_CONCRETE)
        .material("blue_concrete")
        .ingredientName("Blue Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_concrete")
            )
        );

    public static DefaultSettings BROWN_CONCRETE = new DefaultSettings(Blocks.BROWN_CONCRETE)
        .material("brown_concrete")
        .ingredientName("Brown Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_concrete")
            )
        );

    public static DefaultSettings GREEN_CONCRETE = new DefaultSettings(Blocks.GREEN_CONCRETE)
        .material("green_concrete")
        .ingredientName("Green Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_concrete")
            )
        );

    public static DefaultSettings RED_CONCRETE = new DefaultSettings(Blocks.RED_CONCRETE)
        .material("red_concrete")
        .ingredientName("Red Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_concrete")
            )
        );

    public static DefaultSettings BLACK_CONCRETE = new DefaultSettings(Blocks.BLACK_CONCRETE)
        .material("black_concrete")
        .ingredientName("Black Concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_concrete")
            )
        );

    public static DefaultSettings WHITE_STAINED_GLASS = new DefaultSettings(Blocks.WHITE_STAINED_GLASS)
        .material("white_stained_glass")
        .translucent()
        .ingredientName("White Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_stained_glass")
            )
        );

    public static DefaultSettings ORANGE_STAINED_GLASS = new DefaultSettings(Blocks.ORANGE_STAINED_GLASS)
        .material("orange_stained_glass")
        .translucent()
        .ingredientName("Orange Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_stained_glass")
            )
        );

    public static DefaultSettings MAGENTA_STAINED_GLASS = new DefaultSettings(Blocks.MAGENTA_STAINED_GLASS)
        .material("magenta_stained_glass")
        .translucent()
        .ingredientName("Magenta Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_stained_glass")
            )
        );

    public static DefaultSettings LIGHT_BLUE_STAINED_GLASS = new DefaultSettings(Blocks.LIGHT_BLUE_STAINED_GLASS)
        .material("light_blue_stained_glass")
        .translucent()
        .ingredientName("Light Blue Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_stained_glass")
            )
        );

    public static DefaultSettings YELLOW_STAINED_GLASS = new DefaultSettings(Blocks.YELLOW_STAINED_GLASS)
        .material("yellow_stained_glass")
        .translucent()
        .ingredientName("Yellow Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_stained_glass")
            )
        );

    public static DefaultSettings LIME_STAINED_GLASS = new DefaultSettings(Blocks.LIME_STAINED_GLASS)
        .material("lime_stained_glass")
        .translucent()
        .ingredientName("Lime Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_stained_glass")
            )
        );

    public static DefaultSettings PINK_STAINED_GLASS = new DefaultSettings(Blocks.PINK_STAINED_GLASS)
        .material("pink_stained_glass")
        .translucent()
        .ingredientName("Pink Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_stained_glass")
            )
        );

    public static DefaultSettings GRAY_STAINED_GLASS = new DefaultSettings(Blocks.GRAY_STAINED_GLASS)
        .material("gray_stained_glass")
        .translucent()
        .ingredientName("Gray Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_stained_glass")
            )
        );

    public static DefaultSettings LIGHT_GRAY_STAINED_GLASS = new DefaultSettings(Blocks.LIGHT_GRAY_STAINED_GLASS)
        .material("light_gray_stained_glass")
        .translucent()
        .ingredientName("Light Gray Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_stained_glass")
            )
        );

    public static DefaultSettings CYAN_STAINED_GLASS = new DefaultSettings(Blocks.CYAN_STAINED_GLASS)
        .material("cyan_stained_glass")
        .translucent()
        .ingredientName("Cyan Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_stained_glass")
            )
        );

    public static DefaultSettings PURPLE_STAINED_GLASS = new DefaultSettings(Blocks.PURPLE_STAINED_GLASS)
        .material("purple_stained_glass")
        .translucent()
        .ingredientName("Purple Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_stained_glass")
            )
        );

    public static DefaultSettings BLUE_STAINED_GLASS = new DefaultSettings(Blocks.BLUE_STAINED_GLASS)
        .material("blue_stained_glass")
        .translucent()
        .ingredientName("Blue Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_stained_glass")
            )
        );

    public static DefaultSettings BROWN_STAINED_GLASS = new DefaultSettings(Blocks.BROWN_STAINED_GLASS)
        .material("brown_stained_glass")
        .translucent()
        .ingredientName("Brown Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_stained_glass")
            )
        );

    public static DefaultSettings GREEN_STAINED_GLASS = new DefaultSettings(Blocks.GREEN_STAINED_GLASS)
        .material("green_stained_glass")
        .translucent()
        .ingredientName("Green Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_stained_glass")
            )
        );

    public static DefaultSettings RED_STAINED_GLASS = new DefaultSettings(Blocks.RED_STAINED_GLASS)
        .material("red_stained_glass")
        .translucent()
        .ingredientName("Red Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_stained_glass")
            )
        );

    public static DefaultSettings BLACK_STAINED_GLASS = new DefaultSettings(Blocks.BLACK_STAINED_GLASS)
        .material("black_stained_glass")
        .translucent()
        .ingredientName("Black Stained Glass")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_stained_glass")
            )
        );

    public static DefaultSettings ACACIA_LOG = new DefaultSettings(Blocks.ACACIA_PLANKS)
        .material("acacia_log")
        .tool(Tool.AXE)
        .flammable()
        .ingredientName("Acacia Log")
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
        .tool(Tool.AXE)
        .flammable()
        .ingredientName("Acacia")
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
        .tool(Tool.AXE)
        .flammable()
        .ingredientName("Birch Log")
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
        .tool(Tool.AXE)
        .flammable()
        .ingredientName("Birch")
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
        .tool(Tool.AXE)
        .ingredientName("Crimson")
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
        .tool(Tool.AXE)
        .ingredientName("Crimson Stem")
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
        .tool(Tool.AXE)
        .flammable()
        .ingredientName("Dark Oak Log")
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
        .tool(Tool.AXE)
        .flammable()
        .ingredientName("Dark Oak")
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
        .tool(Tool.AXE)
        .flammable()
        .ingredientName("Jungle Log")
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
        .tool(Tool.AXE)
        .flammable()
        .ingredientName("Jungle")
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
        .tool(Tool.AXE)
        .flammable()
        .ingredientName("Oak Log")
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
        .tool(Tool.AXE)
        .flammable()
        .ingredientName("Oak")
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
        .tool(Tool.AXE)
        .flammable()
        .ingredientName("Spruce Log")
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
        .tool(Tool.AXE)
        .flammable()
        .ingredientName("Spruce")
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
        .tool(Tool.AXE)
        .ingredientName("Warped")
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
        .tool(Tool.AXE)
        .ingredientName("Warped Stem")
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
        .ingredientName("Bamboo")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:bamboo"),
                "ingredient", new Identifier("minecraft:bamboo")
            )
        );

    public static DefaultSettings BEETROOT = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("beetroot")
        .ingredientName("Beetroot")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:beetroot"),
                "ingredient", new Identifier("minecraft:beetroot")
            )
        );

    public static DefaultSettings BLAZE_POWDER = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("blaze_powder")
        .ingredientName("Blaze Powder")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blaze_powder"),
                "ingredient", new Identifier("minecraft:blaze_powder")
            )
        );

    public static DefaultSettings CARROT = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("carrot")
        .ingredientName("Carrot")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:carrot"),
                "ingredient", new Identifier("minecraft:carrot")
            )
        );

    public static DefaultSettings CHORUS_FRUIT = new DefaultSettings(Blocks.PURPUR_BLOCK)
        .material("chorus_fruit")
        .ingredientName("Chorus Fruit")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:chorus_fruit"),
                "ingredient", new Identifier("minecraft:chorus_fruit")
            )
        );

    public static DefaultSettings ENDER_PEARL = new DefaultSettings(Blocks.PURPUR_BLOCK)
        .material("ender_pearl")
        .ingredientName("Ender Pearl")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:ender_pearl"),
                "ingredient", new Identifier("minecraft:ender_pearl")
            )
        );

    public static DefaultSettings POTATO = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("potato")
        .ingredientName("Potato")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:potato"),
                "ingredient", new Identifier("minecraft:potato")
            )
        );

    public static DefaultSettings STICK = new DefaultSettings(Blocks.OAK_PLANKS)
        .material("stick")
        .ingredientName("Stick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:stick"),
                "ingredient", new Identifier("minecraft:stick")
            )
        );

    public static DefaultSettings SUGAR = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("sugar")
        .ingredientName("Sugar")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sugar"),
                "ingredient", new Identifier("minecraft:sugar")
            )
        );

    public static DefaultSettings SUGAR_CANE = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("sugar_cane")
        .ingredientName("Sugar Cane")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sugar_cane"),
                "ingredient", new Identifier("minecraft:sugar_cane")
            )
        );

    public static DefaultSettings WHITE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("white_dye")
        .ingredientName("White Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_dye"),
                "ingredient", new Identifier("minecraft:white_dye")
            )
        );

    public static DefaultSettings ORANGE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("orange_dye")
        .ingredientName("Orange Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_dye"),
                "ingredient", new Identifier("minecraft:orange_dye")
            )
        );

    public static DefaultSettings MAGENTA_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("magenta_dye")
        .ingredientName("Magenta Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_dye"),
                "ingredient", new Identifier("minecraft:magenta_dye")
            )
        );

    public static DefaultSettings LIGHT_BLUE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("light_blue_dye")
        .ingredientName("Light Blue Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_dye"),
                "ingredient", new Identifier("minecraft:light_blue_dye")
            )
        );

    public static DefaultSettings YELLOW_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("yellow_dye")
        .ingredientName("Yellow Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_dye"),
                "ingredient", new Identifier("minecraft:yellow_dye")
            )
        );

    public static DefaultSettings LIME_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("lime_dye")
        .ingredientName("Lime Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_dye"),
                "ingredient", new Identifier("minecraft:lime_dye")
            )
        );

    public static DefaultSettings PINK_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("pink_dye")
        .ingredientName("Pink Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_dye"),
                "ingredient", new Identifier("minecraft:pink_dye")
            )
        );

    public static DefaultSettings GRAY_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("gray_dye")
        .ingredientName("Gray Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_dye"),
                "ingredient", new Identifier("minecraft:gray_dye")
            )
        );

    public static DefaultSettings LIGHT_GRAY_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("light_gray_dye")
        .ingredientName("Light Gray Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_dye"),
                "ingredient", new Identifier("minecraft:light_gray_dye")
            )
        );

    public static DefaultSettings CYAN_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("cyan_dye")
        .ingredientName("Cyan Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_dye"),
                "ingredient", new Identifier("minecraft:cyan_dye")
            )
        );

    public static DefaultSettings PURPLE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("purple_dye")
        .ingredientName("Purple Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_dye"),
                "ingredient", new Identifier("minecraft:purple_dye")
            )
        );

    public static DefaultSettings BLUE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("blue_dye")
        .ingredientName("Blue Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_dye"),
                "ingredient", new Identifier("minecraft:blue_dye")
            )
        );

    public static DefaultSettings BROWN_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("brown_dye")
        .ingredientName("Brown Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_dye"),
                "ingredient", new Identifier("minecraft:brown_dye")
            )
        );

    public static DefaultSettings GREEN_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("green_dye")
        .ingredientName("Green Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_dye"),
                "ingredient", new Identifier("minecraft:green_dye")
            )
        );

    public static DefaultSettings RED_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("red_dye")
        .ingredientName("Red Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_dye"),
                "ingredient", new Identifier("minecraft:red_dye")
            )
        );

    public static DefaultSettings BLACK_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("black_dye")
        .ingredientName("Black Dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_dye"),
                "ingredient", new Identifier("minecraft:black_dye")
            )
        );
}
