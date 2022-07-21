package com.chimericdream.minekea.settings;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.*;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import com.chimericdream.minekea.util.Tool;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class BaseBlockSettings {
    public static DefaultSettings AMETHYST = new DefaultSettings(Blocks.AMETHYST_BLOCK)
        .material("amethyst")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:amethyst_block")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings ANDESITE = new DefaultSettings(Blocks.ANDESITE)
        .material("andesite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:andesite")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs();

    public static DefaultSettings BASALT = new DefaultSettings(Blocks.BASALT)
        .material("basalt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:basalt_side"),
                "end", new Identifier("minecraft:basalt_top"),
                "ingredient", new Identifier("minecraft:basalt")
            )
        )
        .column()
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings BASALT_BRICK = new DefaultSettings(BuildingBlocks.BASALT_BRICKS_BLOCK)
        .material("basalt_brick")
        .ingredientName("Basalt Bricks")
        .materials(
            Map.of(
                "main", BasaltBricksBlock.BLOCK_ID
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings BLACKSTONE = new DefaultSettings(Blocks.BLACKSTONE)
        .material("blackstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blackstone")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs();

    public static DefaultSettings BONE = new DefaultSettings(Blocks.BONE_BLOCK)
        .material("bone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:bone_block_side"),
                "end", new Identifier("minecraft:bone_block_top"),
                "ingredient", new Identifier("minecraft:bone_block")
            )
        )
        .column()
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withBookshelf()
        .withStorageBookshelf()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall()
        .withDyedBlocks();

    public static DefaultSettings BRICK = new DefaultSettings(Blocks.BRICKS)
        .material("brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:bricks")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withDyedBlocks();

    public static DefaultSettings CALCITE = new DefaultSettings(Blocks.CALCITE)
        .material("calcite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:calcite")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall()
        .withDyedBlocks();

    public static DefaultSettings CLAY = new DefaultSettings(Blocks.CLAY)
        .material("clay")
        .tool(Tool.SHOVEL)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:clay")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings COARSE_DIRT = new DefaultSettings(Blocks.COARSE_DIRT)
        .material("coarse_dirt")
        .tool(Tool.SHOVEL)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:coarse_dirt")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings COBBLED_DEEPSLATE = new DefaultSettings(Blocks.COBBLED_DEEPSLATE)
        .material("cobbled_deepslate")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cobbled_deepslate")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs();

    public static DefaultSettings COBBLED_END_STONE = new DefaultSettings(Blocks.END_STONE)
        .material("cobbled_end_stone")
        .enabled(() -> ConfigManager.getConfig().enableCobbledEndStone)
        .materials(
            Map.of(
                "main", CobbledEndStoneBlock.BLOCK_ID
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings COBBLESTONE = new DefaultSettings(Blocks.COBBLESTONE)
        .material("cobblestone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cobblestone")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withDyedBlocks();

    public static DefaultSettings CRACKED_BASALT_BRICK = new DefaultSettings(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK)
        .material("cracked_basalt_brick")
        .ingredientName("Cracked Basalt Bricks")
        .materials(
            Map.of(
                "main", CrackedBasaltBricksBlock.BLOCK_ID
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings CRACKED_DEEPSLATE_BRICK = new DefaultSettings(Blocks.CRACKED_DEEPSLATE_BRICKS)
        .material("cracked_deepslate_brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cracked_deepslate_bricks")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings CRACKED_DEEPSLATE_TILE = new DefaultSettings(Blocks.CRACKED_DEEPSLATE_TILES)
        .material("cracked_deepslate_tile")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cracked_deepslate_tiles")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings CRACKED_STONE_BRICK = new DefaultSettings(Blocks.CRACKED_STONE_BRICKS)
        .material("cracked_stone_brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cracked_stone_bricks")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings CRIMSON_BASALT_BRICK = new DefaultSettings(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK)
        .material("crimson_basalt_brick")
        .ingredientName("Crimson Basalt Bricks")
        .materials(
            Map.of(
                "main", CrimsonBasaltBricksBlock.BLOCK_ID
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings CRYING_OBSIDIAN = new DefaultSettings(Blocks.CRYING_OBSIDIAN)
        .material("crying_obsidian")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:crying_obsidian")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings CUT_RED_SANDSTONE = new DefaultSettings(Blocks.CUT_RED_SANDSTONE)
        .material("cut_red_sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_red_sandstone")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings CUT_SANDSTONE = new DefaultSettings(Blocks.CUT_SANDSTONE)
        .material("cut_sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_sandstone")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings DARK_PRISMARINE = new DefaultSettings(Blocks.DARK_PRISMARINE)
        .material("dark_prismarine")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dark_prismarine")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withWall()
        .withBookshelf()
        .withStorageBookshelf()
        .withDyedBlocks();

    public static DefaultSettings DEEPSLATE = new DefaultSettings(Blocks.DEEPSLATE)
        .material("deepslate")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:deepslate")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings DEEPSLATE_BRICK = new DefaultSettings(Blocks.DEEPSLATE_BRICKS)
        .material("deepslate_brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:deepslate_bricks")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings DEEPSLATE_TILE = new DefaultSettings(Blocks.DEEPSLATE_TILES)
        .material("deepslate_tile")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:deepslate_tiles")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs();

    public static DefaultSettings DIORITE = new DefaultSettings(Blocks.DIORITE)
        .material("diorite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:diorite")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs();

    public static DefaultSettings DIRT = new DefaultSettings(Blocks.DIRT)
        .material("dirt")
        .tool(Tool.SHOVEL)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dirt")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withStairs()
        .withVerticalStairs()
        .withSlab();

    public static DefaultSettings END_STONE = new DefaultSettings(Blocks.END_STONE)
        .material("end_stone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:end_stone")
            )
        )
        .texture(
            "end",
            ConfigManager.getConfig().enableCobbledEndStone
                ? new Identifier("minekea:block/building/general/end_stone")
                : new Identifier("minekea:block/building/general/cobbled_end_stone")
        )
        .texture(
            "main",
            ConfigManager.getConfig().enableCobbledEndStone
                ? new Identifier("minekea:block/building/general/end_stone")
                : new Identifier("minekea:block/building/general/cobbled_end_stone")
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings END_STONE_BRICK = new DefaultSettings(Blocks.END_STONE_BRICKS)
        .material("end_stone_brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:end_stone_bricks")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings GRANITE = new DefaultSettings(Blocks.GRANITE)
        .material("granite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:granite")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs();

    public static DefaultSettings GRAVEL = new DefaultSettings(Blocks.GRAVEL)
        .material("gravel")
        .tool(Tool.SHOVEL)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gravel")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings MOSSY_BASALT_BRICK = new DefaultSettings(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK)
        .material("mossy_basalt_brick")
        .ingredientName("Mossy Basalt Bricks")
        .materials(
            Map.of(
                "main", MossyBasaltBricksBlock.BLOCK_ID
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings MOSSY_COBBLESTONE = new DefaultSettings(Blocks.MOSSY_COBBLESTONE)
        .material("mossy_cobblestone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:mossy_cobblestone")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs();

    public static DefaultSettings MOSSY_STONE_BRICK = new DefaultSettings(Blocks.MOSSY_STONE_BRICKS)
        .material("mossy_stone_brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:mossy_stone_bricks")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs();

    public static DefaultSettings MUD = new DefaultSettings(Blocks.MUD)
        .material("mud")
        .tool(Tool.SHOVEL)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:mud")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings MUD_BRICK = new DefaultSettings(Blocks.MUD_BRICKS)
        .material("mud_brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:mud_bricks")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withDyedBlocks();

    public static DefaultSettings NETHERRACK = new DefaultSettings(Blocks.NETHERRACK)
        .material("netherrack")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:netherrack")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings NETHER_BRICK = new DefaultSettings(Blocks.NETHER_BRICKS)
        .material("nether_brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:nether_bricks")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings NETHER_WART = new DefaultSettings(Blocks.NETHER_WART_BLOCK)
        .material("nether_wart")
        .tool(Tool.HOE)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:nether_wart_block")
            )
        )
        .withCover();

    public static DefaultSettings OBSIDIAN = new DefaultSettings(Blocks.OBSIDIAN)
        .material("obsidian")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:obsidian")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings PACKED_MUD = new DefaultSettings(Blocks.PACKED_MUD)
        .material("packed_mud")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:packed_mud")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withStairs()
        .withVerticalStairs()
        .withSlab();

    public static DefaultSettings POLISHED_ANDESITE = new DefaultSettings(Blocks.POLISHED_ANDESITE)
        .material("polished_andesite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_andesite")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withWall()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings POLISHED_BASALT = new DefaultSettings(Blocks.POLISHED_BASALT)
        .material("polished_basalt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_basalt_side"),
                "end", new Identifier("minecraft:polished_basalt_top"),
                "ingredient", new Identifier("minecraft:polished_basalt")
            )
        )
        .column()
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings POLISHED_BLACKSTONE = new DefaultSettings(Blocks.POLISHED_BLACKSTONE)
        .material("polished_blackstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_blackstone")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings POLISHED_BLACKSTONE_BRICK = new DefaultSettings(Blocks.POLISHED_BLACKSTONE_BRICKS)
        .material("polished_blackstone_brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_blackstone_bricks")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings POLISHED_DEEPSLATE = new DefaultSettings(Blocks.POLISHED_DEEPSLATE)
        .material("polished_deepslate")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_deepslate")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings POLISHED_DIORITE = new DefaultSettings(Blocks.POLISHED_DIORITE)
        .material("polished_diorite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_diorite")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withWall()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings POLISHED_GRANITE = new DefaultSettings(Blocks.POLISHED_GRANITE)
        .material("polished_granite")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:polished_granite")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withWall()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings PRISMARINE = new DefaultSettings(Blocks.PRISMARINE)
        .material("prismarine")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:prismarine")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withBookshelf()
        .withStorageBookshelf()
        .withDyedBlocks();

    public static DefaultSettings PRISMARINE_BRICK = new DefaultSettings(Blocks.PRISMARINE_BRICKS)
        .material("prismarine_brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:prismarine_bricks")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withWall()
        .withBookshelf()
        .withStorageBookshelf()
        .withDyedBlocks();

    public static DefaultSettings PURPUR = new DefaultSettings(Blocks.PURPUR_BLOCK)
        .material("purpur")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purpur_block")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withWall()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings PURPUR_PILLAR = new DefaultSettings(Blocks.PURPUR_PILLAR)
        .material("purpur_pillar")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purpur_pillar")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings QUARTZ = new DefaultSettings(Blocks.QUARTZ_BLOCK)
        .material("quartz")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:quartz_block_top"),
                "ingredient", new Identifier("minecraft:quartz_block")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs();

    public static DefaultSettings QUARTZ_BRICK = new DefaultSettings(Blocks.QUARTZ_BRICKS)
        .material("quartz_brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:quartz_bricks")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings RED_NETHER_BRICK = new DefaultSettings(Blocks.RED_NETHER_BRICKS)
        .material("red_nether_brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_nether_bricks")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings RED_SANDSTONE = new DefaultSettings(Blocks.RED_SANDSTONE)
        .material("red_sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_sandstone")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs();

    public static DefaultSettings RED_SAND = new DefaultSettings(Blocks.RED_SAND)
        .material("red_sand")
        .tool(Tool.SHOVEL)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_sand")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings ROOTED_DIRT = new DefaultSettings(Blocks.ROOTED_DIRT)
        .material("rooted_dirt")
        .tool(Tool.SHOVEL)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:rooted_dirt")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings SAND = new DefaultSettings(Blocks.SAND)
        .material("sand")
        .tool(Tool.SHOVEL)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sand")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings SANDSTONE = new DefaultSettings(Blocks.SANDSTONE)
        .material("sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sandstone")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs();

    public static DefaultSettings SMOOTH_BASALT = new DefaultSettings(Blocks.SMOOTH_BASALT)
        .material("smooth_basalt")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:smooth_basalt")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings SMOOTH_QUARTZ = new DefaultSettings(Blocks.SMOOTH_QUARTZ)
        .material("smooth_quartz")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:quartz_block_bottom"),
                "ingredient", new Identifier("minecraft:smooth_quartz")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings SMOOTH_RED_SANDSTONE = new DefaultSettings(Blocks.SMOOTH_RED_SANDSTONE)
        .material("smooth_red_sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_red_sandstone")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings SMOOTH_SANDSTONE = new DefaultSettings(Blocks.SMOOTH_SANDSTONE)
        .material("smooth_sandstone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sandstone_top"),
                "ingredient", new Identifier("minecraft:smooth_sandstone")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings SMOOTH_STONE = new DefaultSettings(Blocks.SMOOTH_STONE)
        .material("smooth_stone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:smooth_stone")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withStairs()
        .withVerticalStairs()
        .withWall()
        .withBookshelf()
        .withStorageBookshelf()
        .withDyedBlocks();

    public static DefaultSettings SOUL_SAND = new DefaultSettings(Blocks.SOUL_SAND)
        .material("soul_sand")
        .tool(Tool.SHOVEL)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:soul_sand")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings STONE = new DefaultSettings(Blocks.STONE)
        .material("stone")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:stone")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withWall()
        .withDyedBlocks();

    public static DefaultSettings STONE_BRICK = new DefaultSettings(Blocks.STONE_BRICKS)
        .material("stone_brick")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:stone_bricks")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withVerticalStairs()
        .withBookshelf()
        .withStorageBookshelf()
        .withDyedBlocks();

    public static DefaultSettings TUFF = new DefaultSettings(Blocks.TUFF)
        .material("tuff")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:tuff")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings WARPED_BASALT_BRICK = new DefaultSettings(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK)
        .material("warped_basalt_brick")
        .ingredientName("Warped Basalt Bricks")
        .materials(
            Map.of(
                "main", WarpedBasaltBricksBlock.BLOCK_ID
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings WARPED_NETHER_BRICK = new DefaultSettings(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK)
        .material("warped_nether_brick")
        .ingredientName("Warped Nether Bricks")
        .materials(
            Map.of(
                "main", WarpedNetherBricksBlock.BLOCK_ID
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall()
        .withBookshelf()
        .withStorageBookshelf();

    public static DefaultSettings WARPED_WART = new DefaultSettings(Blocks.WARPED_WART_BLOCK)
        .material("warped_wart")
        .tool(Tool.HOE)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:warped_wart_block")
            )
        );

    /******************************************************************************************************************/

    public static DefaultSettings COPPER_BLOCK = new DefaultSettings(Blocks.COPPER_BLOCK)
        .material("copper_block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:copper_block")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab();

    public static DefaultSettings DIAMOND_BLOCK = new DefaultSettings(Blocks.DIAMOND_BLOCK)
        .material("diamond_block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:diamond_block")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab();

    public static DefaultSettings GOLD_BLOCK = new DefaultSettings(Blocks.GOLD_BLOCK)
        .material("gold_block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gold_block")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab();

    public static DefaultSettings IRON_BLOCK = new DefaultSettings(Blocks.IRON_BLOCK)
        .material("iron_block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:iron_block")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab();

    public static DefaultSettings LAPIS_BLOCK = new DefaultSettings(Blocks.LAPIS_BLOCK)
        .material("lapis_block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lapis_block")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab();

    public static DefaultSettings NETHERITE_BLOCK = new DefaultSettings(Blocks.NETHERITE_BLOCK)
        .material("netherite_block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:netherite_block")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab();

    public static DefaultSettings REDSTONE_BLOCK = new DefaultSettings(Blocks.REDSTONE_BLOCK)
        .material("redstone_block")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:redstone_block")
            )
        )
        .withCompressedBlock()
        .withCover()
        .withSlab();

    /******************************************************************************************************************/

    public static DefaultSettings CUT_COPPER = new DefaultSettings(Blocks.CUT_COPPER)
        .material("cut_copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_copper")
            )
        )
        .withVerticalStairs();

    public static DefaultSettings EXPOSED_CUT_COPPER = new DefaultSettings(Blocks.EXPOSED_CUT_COPPER)
        .material("exposed_cut_copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:exposed_cut_copper")
            )
        )
        .withVerticalStairs();

    public static DefaultSettings WEATHERED_CUT_COPPER = new DefaultSettings(Blocks.WEATHERED_CUT_COPPER)
        .material("weathered_cut_copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:weathered_cut_copper")
            )
        )
        .withVerticalStairs();

    public static DefaultSettings OXIDIZED_CUT_COPPER = new DefaultSettings(Blocks.OXIDIZED_CUT_COPPER)
        .material("oxidized_cut_copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:oxidized_cut_copper")
            )
        )
        .withVerticalStairs();

    public static DefaultSettings WAXED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_CUT_COPPER)
        .material("waxed_cut_copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cut_copper"),
                "ingredient", new Identifier("minecraft:waxed_cut_copper")
            )
        )
        .withVerticalStairs();

    public static DefaultSettings WAXED_EXPOSED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_EXPOSED_CUT_COPPER)
        .material("waxed_exposed_cut_copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:exposed_cut_copper"),
                "ingredient", new Identifier("minecraft:waxed_exposed_cut_copper")
            )
        )
        .withVerticalStairs();

    public static DefaultSettings WAXED_WEATHERED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_WEATHERED_CUT_COPPER)
        .material("waxed_weathered_cut_copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:weathered_cut_copper"),
                "ingredient", new Identifier("minecraft:waxed_weathered_cut_copper")
            )
        )
        .withVerticalStairs();

    public static DefaultSettings WAXED_OXIDIZED_CUT_COPPER = new DefaultSettings(Blocks.WAXED_OXIDIZED_CUT_COPPER)
        .material("waxed_oxidized_cut_copper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:oxidized_cut_copper"),
                "ingredient", new Identifier("minecraft:waxed_oxidized_cut_copper")
            )
        )
        .withVerticalStairs();

    /******************************************************************************************************************/

    public static DefaultSettings WHITE_WOOL = new DefaultSettings(Blocks.WHITE_WOOL)
        .material("white_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:white_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings ORANGE_WOOL = new DefaultSettings(Blocks.ORANGE_WOOL)
        .material("orange_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:orange_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings MAGENTA_WOOL = new DefaultSettings(Blocks.MAGENTA_WOOL)
        .material("magenta_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:magenta_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings LIGHT_BLUE_WOOL = new DefaultSettings(Blocks.LIGHT_BLUE_WOOL)
        .material("light_blue_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:light_blue_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings YELLOW_WOOL = new DefaultSettings(Blocks.YELLOW_WOOL)
        .material("yellow_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:yellow_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings LIME_WOOL = new DefaultSettings(Blocks.LIME_WOOL)
        .material("lime_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:lime_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings PINK_WOOL = new DefaultSettings(Blocks.PINK_WOOL)
        .material("pink_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:pink_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings GRAY_WOOL = new DefaultSettings(Blocks.GRAY_WOOL)
        .material("gray_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:gray_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings LIGHT_GRAY_WOOL = new DefaultSettings(Blocks.LIGHT_GRAY_WOOL)
        .material("light_gray_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:light_gray_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings CYAN_WOOL = new DefaultSettings(Blocks.CYAN_WOOL)
        .material("cyan_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:cyan_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings PURPLE_WOOL = new DefaultSettings(Blocks.PURPLE_WOOL)
        .material("purple_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:purple_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings BLUE_WOOL = new DefaultSettings(Blocks.BLUE_WOOL)
        .material("blue_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:blue_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings BROWN_WOOL = new DefaultSettings(Blocks.BROWN_WOOL)
        .material("brown_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:brown_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings GREEN_WOOL = new DefaultSettings(Blocks.GREEN_WOOL)
        .material("green_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:green_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings RED_WOOL = new DefaultSettings(Blocks.RED_WOOL)
        .material("red_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:red_wool")))
        .withButton()
        .withPressurePlate();

    public static DefaultSettings BLACK_WOOL = new DefaultSettings(Blocks.BLACK_WOOL)
        .material("black_wool")
        .wool()
        .tool(Tool.SHEARS)
        .materials(Map.of("main", new Identifier("minecraft:black_wool")))
        .withButton()
        .withPressurePlate();

    /******************************************************************************************************************/

    public static DefaultSettings WHITE_TERRACOTTA = new DefaultSettings(Blocks.WHITE_TERRACOTTA)
        .material("white_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings ORANGE_TERRACOTTA = new DefaultSettings(Blocks.ORANGE_TERRACOTTA)
        .material("orange_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings MAGENTA_TERRACOTTA = new DefaultSettings(Blocks.MAGENTA_TERRACOTTA)
        .material("magenta_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings LIGHT_BLUE_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_BLUE_TERRACOTTA)
        .material("light_blue_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings YELLOW_TERRACOTTA = new DefaultSettings(Blocks.YELLOW_TERRACOTTA)
        .material("yellow_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings LIME_TERRACOTTA = new DefaultSettings(Blocks.LIME_TERRACOTTA)
        .material("lime_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings PINK_TERRACOTTA = new DefaultSettings(Blocks.PINK_TERRACOTTA)
        .material("pink_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings GRAY_TERRACOTTA = new DefaultSettings(Blocks.GRAY_TERRACOTTA)
        .material("gray_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings LIGHT_GRAY_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_GRAY_TERRACOTTA)
        .material("light_gray_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings CYAN_TERRACOTTA = new DefaultSettings(Blocks.CYAN_TERRACOTTA)
        .material("cyan_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings PURPLE_TERRACOTTA = new DefaultSettings(Blocks.PURPLE_TERRACOTTA)
        .material("purple_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings BLUE_TERRACOTTA = new DefaultSettings(Blocks.BLUE_TERRACOTTA)
        .material("blue_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings BROWN_TERRACOTTA = new DefaultSettings(Blocks.BROWN_TERRACOTTA)
        .material("brown_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings GREEN_TERRACOTTA = new DefaultSettings(Blocks.GREEN_TERRACOTTA)
        .material("green_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings RED_TERRACOTTA = new DefaultSettings(Blocks.RED_TERRACOTTA)
        .material("red_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings BLACK_TERRACOTTA = new DefaultSettings(Blocks.BLACK_TERRACOTTA)
        .material("black_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    /******************************************************************************************************************/

    public static DefaultSettings WHITE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.WHITE_GLAZED_TERRACOTTA)
        .material("white_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings ORANGE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.ORANGE_GLAZED_TERRACOTTA)
        .material("orange_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings MAGENTA_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.MAGENTA_GLAZED_TERRACOTTA)
        .material("magenta_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings LIGHT_BLUE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA)
        .material("light_blue_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings YELLOW_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.YELLOW_GLAZED_TERRACOTTA)
        .material("yellow_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings LIME_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIME_GLAZED_TERRACOTTA)
        .material("lime_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings PINK_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.PINK_GLAZED_TERRACOTTA)
        .material("pink_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings GRAY_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.GRAY_GLAZED_TERRACOTTA)
        .material("gray_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings LIGHT_GRAY_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA)
        .material("light_gray_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings CYAN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.CYAN_GLAZED_TERRACOTTA)
        .material("cyan_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings PURPLE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.PURPLE_GLAZED_TERRACOTTA)
        .material("purple_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings BLUE_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BLUE_GLAZED_TERRACOTTA)
        .material("blue_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings BROWN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BROWN_GLAZED_TERRACOTTA)
        .material("brown_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings GREEN_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.GREEN_GLAZED_TERRACOTTA)
        .material("green_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings RED_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.RED_GLAZED_TERRACOTTA)
        .material("red_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings BLACK_GLAZED_TERRACOTTA = new DefaultSettings(Blocks.BLACK_GLAZED_TERRACOTTA)
        .material("black_glazed_terracotta")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_glazed_terracotta")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    /******************************************************************************************************************/

    public static DefaultSettings WHITE_CONCRETE = new DefaultSettings(Blocks.WHITE_CONCRETE)
        .material("white_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings ORANGE_CONCRETE = new DefaultSettings(Blocks.ORANGE_CONCRETE)
        .material("orange_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings MAGENTA_CONCRETE = new DefaultSettings(Blocks.MAGENTA_CONCRETE)
        .material("magenta_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings LIGHT_BLUE_CONCRETE = new DefaultSettings(Blocks.LIGHT_BLUE_CONCRETE)
        .material("light_blue_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings YELLOW_CONCRETE = new DefaultSettings(Blocks.YELLOW_CONCRETE)
        .material("yellow_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings LIME_CONCRETE = new DefaultSettings(Blocks.LIME_CONCRETE)
        .material("lime_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings PINK_CONCRETE = new DefaultSettings(Blocks.PINK_CONCRETE)
        .material("pink_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings GRAY_CONCRETE = new DefaultSettings(Blocks.GRAY_CONCRETE)
        .material("gray_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings LIGHT_GRAY_CONCRETE = new DefaultSettings(Blocks.LIGHT_GRAY_CONCRETE)
        .material("light_gray_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings CYAN_CONCRETE = new DefaultSettings(Blocks.CYAN_CONCRETE)
        .material("cyan_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings PURPLE_CONCRETE = new DefaultSettings(Blocks.PURPLE_CONCRETE)
        .material("purple_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings BLUE_CONCRETE = new DefaultSettings(Blocks.BLUE_CONCRETE)
        .material("blue_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings BROWN_CONCRETE = new DefaultSettings(Blocks.BROWN_CONCRETE)
        .material("brown_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings GREEN_CONCRETE = new DefaultSettings(Blocks.GREEN_CONCRETE)
        .material("green_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings RED_CONCRETE = new DefaultSettings(Blocks.RED_CONCRETE)
        .material("red_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    public static DefaultSettings BLACK_CONCRETE = new DefaultSettings(Blocks.BLACK_CONCRETE)
        .material("black_concrete")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_concrete")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs()
        .withWall();

    /******************************************************************************************************************/

    public static DefaultSettings WHITE_STAINED_GLASS = new DefaultSettings(Blocks.WHITE_STAINED_GLASS)
        .material("white_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings ORANGE_STAINED_GLASS = new DefaultSettings(Blocks.ORANGE_STAINED_GLASS)
        .material("orange_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings MAGENTA_STAINED_GLASS = new DefaultSettings(Blocks.MAGENTA_STAINED_GLASS)
        .material("magenta_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings LIGHT_BLUE_STAINED_GLASS = new DefaultSettings(Blocks.LIGHT_BLUE_STAINED_GLASS)
        .material("light_blue_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings YELLOW_STAINED_GLASS = new DefaultSettings(Blocks.YELLOW_STAINED_GLASS)
        .material("yellow_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings LIME_STAINED_GLASS = new DefaultSettings(Blocks.LIME_STAINED_GLASS)
        .material("lime_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings PINK_STAINED_GLASS = new DefaultSettings(Blocks.PINK_STAINED_GLASS)
        .material("pink_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings GRAY_STAINED_GLASS = new DefaultSettings(Blocks.GRAY_STAINED_GLASS)
        .material("gray_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings LIGHT_GRAY_STAINED_GLASS = new DefaultSettings(Blocks.LIGHT_GRAY_STAINED_GLASS)
        .material("light_gray_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings CYAN_STAINED_GLASS = new DefaultSettings(Blocks.CYAN_STAINED_GLASS)
        .material("cyan_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings PURPLE_STAINED_GLASS = new DefaultSettings(Blocks.PURPLE_STAINED_GLASS)
        .material("purple_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings BLUE_STAINED_GLASS = new DefaultSettings(Blocks.BLUE_STAINED_GLASS)
        .material("blue_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings BROWN_STAINED_GLASS = new DefaultSettings(Blocks.BROWN_STAINED_GLASS)
        .material("brown_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings GREEN_STAINED_GLASS = new DefaultSettings(Blocks.GREEN_STAINED_GLASS)
        .material("green_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings RED_STAINED_GLASS = new DefaultSettings(Blocks.RED_STAINED_GLASS)
        .material("red_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings BLACK_STAINED_GLASS = new DefaultSettings(Blocks.BLACK_STAINED_GLASS)
        .material("black_stained_glass")
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_stained_glass")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    /******************************************************************************************************************/

    public static DefaultSettings ACACIA = new DefaultSettings(Blocks.ACACIA_PLANKS)
        .material("acacia")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:acacia_planks"),
                "log", new Identifier("minecraft:acacia_log"),
                "stripped_log", new Identifier("minecraft:stripped_acacia_log"),
                "planks", new Identifier("minecraft:acacia_planks"),
                "slab", new Identifier("minecraft:acacia_slab")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalStairs()
        .withVerticalBookshelfStairs()
        .withBookshelf()
        .withStorageBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withBookshelfDoor()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withShutters()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings ACACIA_LEAVES = new DefaultSettings(Blocks.ACACIA_LEAVES)
        .material("acacia_leaves")
        .tool(Tool.SHEARS)
        .flammable()
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:acacia_leaves")
            )
        );

    public static DefaultSettings ACACIA_LOG = new DefaultSettings(Blocks.ACACIA_PLANKS)
        .material("acacia_log")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:acacia_log"),
                "end", new Identifier("minecraft:acacia_log_top"),
                "log", new Identifier("minecraft:acacia_log"),
                "stripped_log", new Identifier("minecraft:stripped_acacia_log"),
                "planks", new Identifier("minecraft:acacia_planks")
            )
        )
        .column()
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings AZALEA_LEAVES = new DefaultSettings(Blocks.AZALEA_LEAVES)
        .material("azalea_leaves")
        .tool(Tool.SHEARS)
        .flammable()
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:azalea_leaves")
            )
        );

    public static DefaultSettings BIRCH = new DefaultSettings(Blocks.BIRCH_PLANKS)
        .material("birch")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:birch_planks"),
                "log", new Identifier("minecraft:birch_log"),
                "stripped_log", new Identifier("minecraft:stripped_birch_log"),
                "planks", new Identifier("minecraft:birch_planks"),
                "slab", new Identifier("minecraft:birch_slab")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalStairs()
        .withVerticalBookshelfStairs()
        .withBookshelf()
        .withStorageBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withBookshelfDoor()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withShutters()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings BIRCH_LEAVES = new DefaultSettings(Blocks.BIRCH_LEAVES)
        .material("birch_leaves")
        .tool(Tool.SHEARS)
        .flammable()
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:birch_leaves")
            )
        );

    public static DefaultSettings BIRCH_LOG = new DefaultSettings(Blocks.BIRCH_PLANKS)
        .material("birch_log")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:birch_log"),
                "end", new Identifier("minecraft:birch_log_top"),
                "log", new Identifier("minecraft:birch_log"),
                "stripped_log", new Identifier("minecraft:stripped_birch_log"),
                "planks", new Identifier("minecraft:birch_planks")
            )
        )
        .column()
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings CRIMSON = new DefaultSettings(Blocks.CRIMSON_PLANKS)
        .material("crimson")
        .wooden()
        .tool(Tool.AXE)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:crimson_planks"),
                "log", new Identifier("minecraft:crimson_stem"),
                "stripped_log", new Identifier("minecraft:stripped_crimson_stem"),
                "planks", new Identifier("minecraft:crimson_planks"),
                "slab", new Identifier("minecraft:crimson_slab")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalStairs()
        .withVerticalBookshelfStairs()
        .withBookshelf()
        .withStorageBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withBookshelfDoor()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withShutters()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings CRIMSON_STEM = new DefaultSettings(Blocks.CRIMSON_PLANKS)
        .material("crimson_stem")
        .wooden()
        .tool(Tool.AXE)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:crimson_stem"),
                "end", new Identifier("minecraft:crimson_stem_top"),
                "log", new Identifier("minecraft:crimson_stem"),
                "stripped_log", new Identifier("minecraft:stripped_crimson_stem"),
                "planks", new Identifier("minecraft:crimson_planks")
            )
        )
        .column()
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings DARK_OAK = new DefaultSettings(Blocks.DARK_OAK_PLANKS)
        .material("dark_oak")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dark_oak_planks"),
                "log", new Identifier("minecraft:dark_oak_log"),
                "stripped_log", new Identifier("minecraft:stripped_dark_oak_log"),
                "planks", new Identifier("minecraft:dark_oak_planks"),
                "slab", new Identifier("minecraft:dark_oak_slab")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalStairs()
        .withVerticalBookshelfStairs()
        .withBookshelf()
        .withStorageBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withBookshelfDoor()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withShutters()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings DARK_OAK_LEAVES = new DefaultSettings(Blocks.DARK_OAK_LEAVES)
        .material("dark_oak_leaves")
        .tool(Tool.SHEARS)
        .flammable()
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dark_oak_leaves")
            )
        );

    public static DefaultSettings DARK_OAK_LOG = new DefaultSettings(Blocks.DARK_OAK_PLANKS)
        .material("dark_oak_log")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:dark_oak_log"),
                "end", new Identifier("minecraft:dark_oak_log_top"),
                "log", new Identifier("minecraft:dark_oak_log"),
                "stripped_log", new Identifier("minecraft:stripped_dark_oak_log"),
                "planks", new Identifier("minecraft:dark_oak_planks")
            )
        )
        .column()
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings FLOWERING_AZALEA_LEAVES = new DefaultSettings(Blocks.FLOWERING_AZALEA_LEAVES)
        .material("flowering_azalea_leaves")
        .tool(Tool.SHEARS)
        .flammable()
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:flowering_azalea_leaves")
            )
        );

    public static DefaultSettings JUNGLE = new DefaultSettings(Blocks.JUNGLE_PLANKS)
        .material("jungle")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:jungle_planks"),
                "log", new Identifier("minecraft:jungle_log"),
                "stripped_log", new Identifier("minecraft:stripped_jungle_log"),
                "planks", new Identifier("minecraft:jungle_planks"),
                "slab", new Identifier("minecraft:jungle_slab")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalStairs()
        .withVerticalBookshelfStairs()
        .withBookshelf()
        .withStorageBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withBookshelfDoor()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withShutters()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings JUNGLE_LEAVES = new DefaultSettings(Blocks.JUNGLE_LEAVES)
        .material("jungle_leaves")
        .tool(Tool.SHEARS)
        .flammable()
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:jungle_leaves")
            )
        );

    public static DefaultSettings JUNGLE_LOG = new DefaultSettings(Blocks.JUNGLE_PLANKS)
        .material("jungle_log")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:jungle_log"),
                "end", new Identifier("minecraft:jungle_log_top"),
                "log", new Identifier("minecraft:jungle_log"),
                "stripped_log", new Identifier("minecraft:stripped_jungle_log"),
                "planks", new Identifier("minecraft:jungle_planks")
            )
        )
        .column()
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings MANGROVE = new DefaultSettings(Blocks.MANGROVE_PLANKS)
        .material("mangrove")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:mangrove_planks"),
                "log", new Identifier("minecraft:mangrove_log"),
                "stripped_log", new Identifier("minecraft:stripped_mangrove_log"),
                "planks", new Identifier("minecraft:mangrove_planks"),
                "slab", new Identifier("minecraft:mangrove_slab")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalStairs()
        .withVerticalBookshelfStairs()
        .withBookshelf()
        .withStorageBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withBookshelfDoor()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withShutters()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings MANGROVE_LEAVES = new DefaultSettings(Blocks.MANGROVE_LEAVES)
        .material("mangrove_leaves")
        .tool(Tool.SHEARS)
        .flammable()
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:mangrove_leaves")
            )
        );

    public static DefaultSettings MANGROVE_LOG = new DefaultSettings(Blocks.MANGROVE_PLANKS)
        .material("mangrove_log")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:mangrove_log"),
                "end", new Identifier("minecraft:mangrove_log_top"),
                "log", new Identifier("minecraft:mangrove_log"),
                "stripped_log", new Identifier("minecraft:stripped_mangrove_log"),
                "planks", new Identifier("minecraft:mangrove_planks")
            )
        )
        .column()
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings OAK = new DefaultSettings(Blocks.OAK_PLANKS)
        .material("oak")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:oak_planks"),
                "log", new Identifier("minecraft:oak_log"),
                "stripped_log", new Identifier("minecraft:stripped_oak_log"),
                "planks", new Identifier("minecraft:oak_planks"),
                "slab", new Identifier("minecraft:oak_slab")
            )
        )
        .bookshelfId("minecraft:bookshelf")
        .bookshelfModel("minecraft:block/bookshelf")
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalStairs()
        .withVerticalBookshelfStairs()
        .withStorageBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withBookshelfDoor()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withShutters()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings OAK_LEAVES = new DefaultSettings(Blocks.OAK_LEAVES)
        .material("oak_leaves")
        .tool(Tool.SHEARS)
        .flammable()
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:oak_leaves")
            )
        );

    public static DefaultSettings OAK_LOG = new DefaultSettings(Blocks.OAK_PLANKS)
        .material("oak_log")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:oak_log"),
                "end", new Identifier("minecraft:oak_log_top"),
                "log", new Identifier("minecraft:oak_log"),
                "stripped_log", new Identifier("minecraft:stripped_oak_log"),
                "planks", new Identifier("minecraft:oak_planks")
            )
        )
        .column()
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings SPRUCE = new DefaultSettings(Blocks.SPRUCE_PLANKS)
        .material("spruce")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:spruce_planks"),
                "log", new Identifier("minecraft:spruce_log"),
                "stripped_log", new Identifier("minecraft:stripped_spruce_log"),
                "planks", new Identifier("minecraft:spruce_planks"),
                "slab", new Identifier("minecraft:spruce_slab")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalStairs()
        .withVerticalBookshelfStairs()
        .withBookshelf()
        .withStorageBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withBookshelfDoor()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withShutters()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings SPRUCE_LEAVES = new DefaultSettings(Blocks.SPRUCE_LEAVES)
        .material("spruce_leaves")
        .tool(Tool.SHEARS)
        .flammable()
        .translucent()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:spruce_leaves")
            )
        );

    public static DefaultSettings SPRUCE_LOG = new DefaultSettings(Blocks.SPRUCE_PLANKS)
        .material("spruce_log")
        .wooden()
        .tool(Tool.AXE)
        .flammable()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:spruce_log"),
                "end", new Identifier("minecraft:spruce_log_top"),
                "log", new Identifier("minecraft:spruce_log"),
                "stripped_log", new Identifier("minecraft:stripped_spruce_log"),
                "planks", new Identifier("minecraft:spruce_planks")
            )
        )
        .column()
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    public static DefaultSettings WARPED = new DefaultSettings(Blocks.WARPED_PLANKS)
        .material("warped")
        .wooden()
        .tool(Tool.AXE)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:warped_planks"),
                "log", new Identifier("minecraft:warped_stem"),
                "stripped_log", new Identifier("minecraft:stripped_warped_stem"),
                "planks", new Identifier("minecraft:warped_planks"),
                "slab", new Identifier("minecraft:warped_slab")
            )
        )
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withBookshelfSlab()
        .withBookshelfStairs()
        .withVerticalStairs()
        .withVerticalBookshelfStairs()
        .withBookshelf()
        .withStorageBookshelf()
        .withDisplayCase()
        .withStrippedDisplayCase()
        .withBookshelfDoor()
        .withChair()
        .withStool()
        .withShelf()
        .withFloatingShelf()
        .withShutters()
        .withTable()
        .withBookshelfTrapdoor();

    public static DefaultSettings WARPED_STEM = new DefaultSettings(Blocks.WARPED_PLANKS)
        .material("warped_stem")
        .wooden()
        .tool(Tool.AXE)
        .materials(
            Map.of(
                "main", new Identifier("minecraft:warped_stem"),
                "end", new Identifier("minecraft:warped_stem_top"),
                "log", new Identifier("minecraft:warped_stem"),
                "stripped_log", new Identifier("minecraft:stripped_warped_stem"),
                "planks", new Identifier("minecraft:warped_planks")
            )
        )
        .column()
        .withBeam()
        .withCompressedBlock()
        .withCover()
        .withSlab()
        .withStairs()
        .withVerticalStairs();

    /******************************************************************************************************************/

    public static DefaultSettings APPLE = new DefaultSettings(Blocks.MELON)
        .material("apple")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:apple"),
                "ingredient", new Identifier("minecraft:apple")
            )
        )
        .column();

    public static DefaultSettings BAMBOO = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("bamboo")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:bamboo"),
                "ingredient", new Identifier("minecraft:bamboo")
            )
        )
        .column();

    public static DefaultSettings BEETROOT = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("beetroot")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:beetroot"),
                "ingredient", new Identifier("minecraft:beetroot")
            )
        );

    public static DefaultSettings BEETROOT_SEEDS = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("beetroot_seeds")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:beetroot_seeds"),
                "ingredient", new Identifier("minecraft:beetroot_seeds")
            )
        );

    public static DefaultSettings BLAZE_POWDER = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("blaze_powder")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blaze_powder"),
                "ingredient", new Identifier("minecraft:blaze_powder")
            )
        );

    public static DefaultSettings BLAZE_ROD = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("blaze_rod")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blaze_rod"),
                "ingredient", new Identifier("minecraft:blaze_rod")
            )
        );

    public static DefaultSettings CARROT = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("carrot")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:carrot"),
                "ingredient", new Identifier("minecraft:carrot")
            )
        );

    public static DefaultSettings CHARCOAL = new DefaultSettings(Blocks.COAL_BLOCK)
        .material("charcoal")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:charcoal"),
                "ingredient", new Identifier("minecraft:charcoal")
            )
        );

    public static DefaultSettings CHORUS_FRUIT = new DefaultSettings(Blocks.PURPUR_BLOCK)
        .material("chorus_fruit")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:chorus_fruit"),
                "ingredient", new Identifier("minecraft:chorus_fruit")
            )
        );

    public static DefaultSettings ENDER_PEARL = new DefaultSettings(Blocks.PURPUR_BLOCK)
        .material("ender_pearl")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:ender_pearl"),
                "ingredient", new Identifier("minecraft:ender_pearl")
            )
        );

    public static DefaultSettings FLINT = new DefaultSettings(Blocks.COBBLESTONE)
        .material("flint")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:flint"),
                "ingredient", new Identifier("minecraft:flint")
            )
        );

    public static DefaultSettings GOLDEN_APPLE = new DefaultSettings(Blocks.MELON)
        .material("golden_apple")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:golden_apple"),
                "ingredient", new Identifier("minecraft:golden_apple")
            )
        )
        .column();

    public static DefaultSettings LEATHER = new DefaultSettings(Blocks.WHITE_WOOL)
        .material("leather")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:leather"),
                "ingredient", new Identifier("minecraft:leather")
            )
        );

    public static DefaultSettings MELON_SEEDS = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("melon_seeds")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:melon_seeds"),
                "ingredient", new Identifier("minecraft:melon_seeds")
            )
        );

    public static DefaultSettings NETHER_STAR = new DefaultSettings(Blocks.DIAMOND_BLOCK)
        .material("nether_star")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:nether_star"),
                "ingredient", new Identifier("minecraft:nether_star")
            )
        );

    public static DefaultSettings PAPER = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("paper")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:paper"),
                "ingredient", new Identifier("minecraft:paper")
            )
        );

    public static DefaultSettings PHANTOM_MEMBRANE = new DefaultSettings(Blocks.NETHER_WART_BLOCK)
        .material("phantom_membrane")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:phantom_membrane"),
                "ingredient", new Identifier("minecraft:phantom_membrane")
            )
        );

    public static DefaultSettings POTATO = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("potato")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:potato"),
                "ingredient", new Identifier("minecraft:potato")
            )
        );

    public static DefaultSettings PUMPKIN_SEEDS = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("pumpkin_seeds")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pumpkin_seeds"),
                "ingredient", new Identifier("minecraft:pumpkin_seeds")
            )
        );

    public static DefaultSettings STICK = new DefaultSettings(Blocks.OAK_PLANKS)
        .material("stick")
        .wooden()
        .materials(
            Map.of(
                "main", new Identifier("minecraft:stick"),
                "ingredient", new Identifier("minecraft:stick")
            )
        );

    public static DefaultSettings SUGAR = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("sugar")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sugar"),
                "ingredient", new Identifier("minecraft:sugar")
            )
        );

    public static DefaultSettings SUGAR_CANE = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("sugar_cane")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:sugar_cane"),
                "ingredient", new Identifier("minecraft:sugar_cane")
            )
        );

    public static DefaultSettings TOTEM = new DefaultSettings(Blocks.GOLD_BLOCK)
        .material("totem_of_undying")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:totem_of_undying"),
                "ingredient", new Identifier("minecraft:totem_of_undying")
            )
        )
        .column();

    public static DefaultSettings WHEAT_SEEDS = new DefaultSettings(Blocks.HAY_BLOCK)
        .material("wheat_seeds")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:wheat_seeds"),
                "ingredient", new Identifier("minecraft:wheat_seeds")
            )
        );

    /******************************************************************************************************************/

    public static DefaultSettings WHITE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("white_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:white_dye"),
                "ingredient", new Identifier("minecraft:white_dye")
            )
        );

    public static DefaultSettings ORANGE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("orange_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:orange_dye"),
                "ingredient", new Identifier("minecraft:orange_dye")
            )
        );

    public static DefaultSettings MAGENTA_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("magenta_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:magenta_dye"),
                "ingredient", new Identifier("minecraft:magenta_dye")
            )
        );

    public static DefaultSettings LIGHT_BLUE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("light_blue_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_blue_dye"),
                "ingredient", new Identifier("minecraft:light_blue_dye")
            )
        );

    public static DefaultSettings YELLOW_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("yellow_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:yellow_dye"),
                "ingredient", new Identifier("minecraft:yellow_dye")
            )
        );

    public static DefaultSettings LIME_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("lime_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:lime_dye"),
                "ingredient", new Identifier("minecraft:lime_dye")
            )
        );

    public static DefaultSettings PINK_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("pink_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:pink_dye"),
                "ingredient", new Identifier("minecraft:pink_dye")
            )
        );

    public static DefaultSettings GRAY_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("gray_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:gray_dye"),
                "ingredient", new Identifier("minecraft:gray_dye")
            )
        );

    public static DefaultSettings LIGHT_GRAY_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("light_gray_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:light_gray_dye"),
                "ingredient", new Identifier("minecraft:light_gray_dye")
            )
        );

    public static DefaultSettings CYAN_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("cyan_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:cyan_dye"),
                "ingredient", new Identifier("minecraft:cyan_dye")
            )
        );

    public static DefaultSettings PURPLE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("purple_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:purple_dye"),
                "ingredient", new Identifier("minecraft:purple_dye")
            )
        );

    public static DefaultSettings BLUE_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("blue_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:blue_dye"),
                "ingredient", new Identifier("minecraft:blue_dye")
            )
        );

    public static DefaultSettings BROWN_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("brown_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:brown_dye"),
                "ingredient", new Identifier("minecraft:brown_dye")
            )
        );

    public static DefaultSettings GREEN_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("green_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:green_dye"),
                "ingredient", new Identifier("minecraft:green_dye")
            )
        );

    public static DefaultSettings RED_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("red_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:red_dye"),
                "ingredient", new Identifier("minecraft:red_dye")
            )
        );

    public static DefaultSettings BLACK_DYE = new DefaultSettings(Blocks.HONEY_BLOCK)
        .material("black_dye")
        .materials(
            Map.of(
                "main", new Identifier("minecraft:black_dye"),
                "ingredient", new Identifier("minecraft:black_dye")
            )
        );

    /******************************************************************************************************************/

    public static final List<DefaultSettings> ALL_SETTINGS = List.of(
        AMETHYST,
        ANDESITE,
        BASALT,
        BASALT_BRICK,
        BLACKSTONE,
        BONE,
        BRICK,
        CALCITE,
        CLAY,
        COARSE_DIRT,
        COBBLED_DEEPSLATE,
        COBBLED_END_STONE,
        COBBLESTONE,
        CRACKED_BASALT_BRICK,
        CRACKED_DEEPSLATE_BRICK,
        CRACKED_DEEPSLATE_TILE,
        CRACKED_STONE_BRICK,
        CRIMSON_BASALT_BRICK,
        CRYING_OBSIDIAN,
        CUT_RED_SANDSTONE,
        CUT_SANDSTONE,
        DARK_PRISMARINE,
        DEEPSLATE,
        DEEPSLATE_BRICK,
        DEEPSLATE_TILE,
        DIORITE,
        DIRT,
        END_STONE,
        END_STONE_BRICK,
        GRANITE,
        GRAVEL,
        MOSSY_BASALT_BRICK,
        MOSSY_COBBLESTONE,
        MOSSY_STONE_BRICK,
        MUD,
        MUD_BRICK,
        NETHERRACK,
        NETHER_BRICK,
        NETHER_WART,
        OBSIDIAN,
        PACKED_MUD,
        POLISHED_ANDESITE,
        POLISHED_BASALT,
        POLISHED_BLACKSTONE,
        POLISHED_BLACKSTONE_BRICK,
        POLISHED_DEEPSLATE,
        POLISHED_DIORITE,
        POLISHED_GRANITE,
        PRISMARINE,
        PRISMARINE_BRICK,
        PURPUR,
        PURPUR_PILLAR,
        QUARTZ,
        QUARTZ_BRICK,
        RED_NETHER_BRICK,
        RED_SANDSTONE,
        RED_SAND,
        ROOTED_DIRT,
        SAND,
        SANDSTONE,
        SMOOTH_BASALT,
        SMOOTH_QUARTZ,
        SMOOTH_RED_SANDSTONE,
        SMOOTH_SANDSTONE,
        SMOOTH_STONE,
        SOUL_SAND,
        STONE,
        STONE_BRICK,
        TUFF,
        WARPED_BASALT_BRICK,
        WARPED_NETHER_BRICK,
        WARPED_WART,

        COPPER_BLOCK,
        DIAMOND_BLOCK,
        GOLD_BLOCK,
        IRON_BLOCK,
        LAPIS_BLOCK,
        NETHERITE_BLOCK,
        REDSTONE_BLOCK,

        CUT_COPPER,
        EXPOSED_CUT_COPPER,
        WEATHERED_CUT_COPPER,
        OXIDIZED_CUT_COPPER,
        WAXED_CUT_COPPER,
        WAXED_EXPOSED_CUT_COPPER,
        WAXED_WEATHERED_CUT_COPPER,
        WAXED_OXIDIZED_CUT_COPPER,

        WHITE_WOOL,
        ORANGE_WOOL,
        MAGENTA_WOOL,
        LIGHT_BLUE_WOOL,
        YELLOW_WOOL,
        LIME_WOOL,
        PINK_WOOL,
        GRAY_WOOL,
        LIGHT_GRAY_WOOL,
        CYAN_WOOL,
        PURPLE_WOOL,
        BLUE_WOOL,
        BROWN_WOOL,
        GREEN_WOOL,
        RED_WOOL,
        BLACK_WOOL,

        WHITE_TERRACOTTA,
        ORANGE_TERRACOTTA,
        MAGENTA_TERRACOTTA,
        LIGHT_BLUE_TERRACOTTA,
        YELLOW_TERRACOTTA,
        LIME_TERRACOTTA,
        PINK_TERRACOTTA,
        GRAY_TERRACOTTA,
        LIGHT_GRAY_TERRACOTTA,
        CYAN_TERRACOTTA,
        PURPLE_TERRACOTTA,
        BLUE_TERRACOTTA,
        BROWN_TERRACOTTA,
        GREEN_TERRACOTTA,
        RED_TERRACOTTA,
        BLACK_TERRACOTTA,

        WHITE_GLAZED_TERRACOTTA,
        ORANGE_GLAZED_TERRACOTTA,
        MAGENTA_GLAZED_TERRACOTTA,
        LIGHT_BLUE_GLAZED_TERRACOTTA,
        YELLOW_GLAZED_TERRACOTTA,
        LIME_GLAZED_TERRACOTTA,
        PINK_GLAZED_TERRACOTTA,
        GRAY_GLAZED_TERRACOTTA,
        LIGHT_GRAY_GLAZED_TERRACOTTA,
        CYAN_GLAZED_TERRACOTTA,
        PURPLE_GLAZED_TERRACOTTA,
        BLUE_GLAZED_TERRACOTTA,
        BROWN_GLAZED_TERRACOTTA,
        GREEN_GLAZED_TERRACOTTA,
        RED_GLAZED_TERRACOTTA,
        BLACK_GLAZED_TERRACOTTA,

        WHITE_CONCRETE,
        ORANGE_CONCRETE,
        MAGENTA_CONCRETE,
        LIGHT_BLUE_CONCRETE,
        YELLOW_CONCRETE,
        LIME_CONCRETE,
        PINK_CONCRETE,
        GRAY_CONCRETE,
        LIGHT_GRAY_CONCRETE,
        CYAN_CONCRETE,
        PURPLE_CONCRETE,
        BLUE_CONCRETE,
        BROWN_CONCRETE,
        GREEN_CONCRETE,
        RED_CONCRETE,
        BLACK_CONCRETE,

        WHITE_STAINED_GLASS,
        ORANGE_STAINED_GLASS,
        MAGENTA_STAINED_GLASS,
        LIGHT_BLUE_STAINED_GLASS,
        YELLOW_STAINED_GLASS,
        LIME_STAINED_GLASS,
        PINK_STAINED_GLASS,
        GRAY_STAINED_GLASS,
        LIGHT_GRAY_STAINED_GLASS,
        CYAN_STAINED_GLASS,
        PURPLE_STAINED_GLASS,
        BLUE_STAINED_GLASS,
        BROWN_STAINED_GLASS,
        GREEN_STAINED_GLASS,
        RED_STAINED_GLASS,
        BLACK_STAINED_GLASS,

        ACACIA,
        ACACIA_LEAVES,
        ACACIA_LOG,
        AZALEA_LEAVES,
        BIRCH,
        BIRCH_LEAVES,
        BIRCH_LOG,
        CRIMSON,
        CRIMSON_STEM,
        DARK_OAK,
        DARK_OAK_LEAVES,
        DARK_OAK_LOG,
        FLOWERING_AZALEA_LEAVES,
        JUNGLE,
        JUNGLE_LEAVES,
        JUNGLE_LOG,
        MANGROVE,
        MANGROVE_LEAVES,
        MANGROVE_LOG,
        OAK,
        OAK_LEAVES,
        OAK_LOG,
        SPRUCE,
        SPRUCE_LEAVES,
        SPRUCE_LOG,
        WARPED,
        WARPED_STEM,

        BAMBOO,
        BEETROOT,
        BLAZE_POWDER,
        CARROT,
        CHORUS_FRUIT,
        ENDER_PEARL,
        POTATO,
        STICK,
        SUGAR,
        SUGAR_CANE,
        WHITE_DYE,
        ORANGE_DYE,
        MAGENTA_DYE,
        LIGHT_BLUE_DYE,
        YELLOW_DYE,
        LIME_DYE,
        PINK_DYE,
        GRAY_DYE,
        LIGHT_GRAY_DYE,
        CYAN_DYE,
        PURPLE_DYE,
        BLUE_DYE,
        BROWN_DYE,
        GREEN_DYE,
        RED_DYE,
        BLACK_DYE
    );
}
