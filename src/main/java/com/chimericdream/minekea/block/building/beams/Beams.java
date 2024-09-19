package com.chimericdream.minekea.block.building.beams;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.function.Function;

public class Beams implements MinekeaBlockCategory {
    public static final List<GenericBeamBlock> BLOCKS;

    static {
        BLOCKS = List.of(
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK), new GenericBeamBlock.BeamConfig(Blocks.AMETHYST_BLOCK, "amethyst", "Amethyst", false, false, Registries.BLOCK.getId(Blocks.AMETHYST_BLOCK).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.ANDESITE), new GenericBeamBlock.BeamConfig(Blocks.ANDESITE, "andesite", "Andesite", false, false, Registries.BLOCK.getId(Blocks.ANDESITE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BASALT), new GenericBeamBlock.BeamConfig(Blocks.BASALT, "basalt", "Basalt", false, false, Registries.BLOCK.getId(Blocks.BASALT).withPrefixedPath("block/").withSuffixedPath("_side"), Registries.BLOCK.getId(Blocks.BASALT).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(BuildingBlocks.BASALT_BRICKS_BLOCK), new GenericBeamBlock.BeamConfig(BuildingBlocks.BASALT_BRICKS_BLOCK, "basalt_brick", "Basalt Brick", false, false, BasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BLACKSTONE), new GenericBeamBlock.BeamConfig(Blocks.BLACKSTONE, "blackstone", "Blackstone", false, false, Registries.BLOCK.getId(Blocks.BLACKSTONE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BONE_BLOCK), new GenericBeamBlock.BeamConfig(Blocks.BONE_BLOCK, "bone", "Bone", false, false, Registries.BLOCK.getId(Blocks.BONE_BLOCK).withPrefixedPath("block/").withSuffixedPath("_side"), Registries.BLOCK.getId(Blocks.BONE_BLOCK).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BRICKS), new GenericBeamBlock.BeamConfig(Blocks.BRICKS, "brick", "Brick", false, false, Registries.BLOCK.getId(Blocks.BRICKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CALCITE), new GenericBeamBlock.BeamConfig(Blocks.CALCITE, "calcite", "Calcite", false, false, Registries.BLOCK.getId(Blocks.CALCITE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.COBBLED_DEEPSLATE), new GenericBeamBlock.BeamConfig(Blocks.COBBLED_DEEPSLATE, "cobbled_deepslate", "Cobbled Deepslate", false, false, Registries.BLOCK.getId(Blocks.COBBLED_DEEPSLATE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.COBBLESTONE), new GenericBeamBlock.BeamConfig(Blocks.COBBLESTONE, "cobblestone", "Cobblestone", false, false, Registries.BLOCK.getId(Blocks.COBBLESTONE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK), new GenericBeamBlock.BeamConfig(BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK, "cracked_basalt_brick", "Cracked Basalt Brick", false, false, CrackedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CRACKED_DEEPSLATE_BRICKS), new GenericBeamBlock.BeamConfig(Blocks.CRACKED_DEEPSLATE_BRICKS, "cracked_deepslate_brick", "Cracked Deepslate Brick", false, false, Registries.BLOCK.getId(Blocks.CRACKED_DEEPSLATE_BRICKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CRACKED_DEEPSLATE_TILES), new GenericBeamBlock.BeamConfig(Blocks.CRACKED_DEEPSLATE_TILES, "cracked_deepslate_tile", "Cracked Deepslate Tile", false, false, Registries.BLOCK.getId(Blocks.CRACKED_DEEPSLATE_TILES).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CRACKED_STONE_BRICKS), new GenericBeamBlock.BeamConfig(Blocks.CRACKED_STONE_BRICKS, "cracked_stone_brick", "Cracked Stone Brick", false, false, Registries.BLOCK.getId(Blocks.CRACKED_STONE_BRICKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK), new GenericBeamBlock.BeamConfig(BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK, "crimson_basalt_brick", "Crimson Basalt Brick", false, false, CrimsonBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CRYING_OBSIDIAN), new GenericBeamBlock.BeamConfig(Blocks.CRYING_OBSIDIAN, "crying_obsidian", "Crying Obsidian", false, false, Registries.BLOCK.getId(Blocks.CRYING_OBSIDIAN).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CUT_RED_SANDSTONE), new GenericBeamBlock.BeamConfig(Blocks.CUT_RED_SANDSTONE, "cut_red_sandstone", "Cut Red Sandstone", false, false, Registries.BLOCK.getId(Blocks.CUT_RED_SANDSTONE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CUT_SANDSTONE), new GenericBeamBlock.BeamConfig(Blocks.CUT_SANDSTONE, "cut_sandstone", "Cut Sandstone", false, false, Registries.BLOCK.getId(Blocks.CUT_SANDSTONE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.DARK_PRISMARINE), new GenericBeamBlock.BeamConfig(Blocks.DARK_PRISMARINE, "dark_prismarine", "Dark Prismarine", false, false, Registries.BLOCK.getId(Blocks.DARK_PRISMARINE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE), new GenericBeamBlock.BeamConfig(Blocks.DEEPSLATE, "deepslate", "Deepslate", false, false, Registries.BLOCK.getId(Blocks.DEEPSLATE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_BRICKS), new GenericBeamBlock.BeamConfig(Blocks.DEEPSLATE_BRICKS, "deepslate_brick", "Deepslate Brick", false, false, Registries.BLOCK.getId(Blocks.DEEPSLATE_BRICKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.DEEPSLATE_TILES), new GenericBeamBlock.BeamConfig(Blocks.DEEPSLATE_TILES, "deepslate_tile", "Deepslate Tile", false, false, Registries.BLOCK.getId(Blocks.DEEPSLATE_TILES).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.DIORITE), new GenericBeamBlock.BeamConfig(Blocks.DIORITE, "diorite", "Diorite", false, false, Registries.BLOCK.getId(Blocks.DIORITE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.END_STONE), new GenericBeamBlock.BeamConfig(Blocks.END_STONE, "end_stone", "End Stone", false, false, Registries.BLOCK.getId(Blocks.END_STONE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.END_STONE_BRICKS), new GenericBeamBlock.BeamConfig(Blocks.END_STONE_BRICKS, "end_stone_brick", "End Stone Brick", false, false, Registries.BLOCK.getId(Blocks.END_STONE_BRICKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.GRANITE), new GenericBeamBlock.BeamConfig(Blocks.GRANITE, "granite", "Granite", false, false, Registries.BLOCK.getId(Blocks.GRANITE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK), new GenericBeamBlock.BeamConfig(BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK, "mossy_basalt_brick", "Mossy Basalt Brick", false, false, MossyBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.MOSSY_COBBLESTONE), new GenericBeamBlock.BeamConfig(Blocks.MOSSY_COBBLESTONE, "mossy_cobblestone", "Mossy Cobblestone", false, false, Registries.BLOCK.getId(Blocks.MOSSY_COBBLESTONE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.MOSSY_STONE_BRICKS), new GenericBeamBlock.BeamConfig(Blocks.MOSSY_STONE_BRICKS, "mossy_stone_brick", "Mossy Stone Brick", false, false, Registries.BLOCK.getId(Blocks.MOSSY_STONE_BRICKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.MUD_BRICKS), new GenericBeamBlock.BeamConfig(Blocks.MUD_BRICKS, "mud_brick", "Mud Brick", false, false, Registries.BLOCK.getId(Blocks.MUD_BRICKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.NETHERRACK), new GenericBeamBlock.BeamConfig(Blocks.NETHERRACK, "netherrack", "Netherrack", false, false, Registries.BLOCK.getId(Blocks.NETHERRACK).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.NETHER_BRICKS), new GenericBeamBlock.BeamConfig(Blocks.NETHER_BRICKS, "nether_brick", "Nether Brick", false, false, Registries.BLOCK.getId(Blocks.NETHER_BRICKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.OBSIDIAN), new GenericBeamBlock.BeamConfig(Blocks.OBSIDIAN, "obsidian", "Obsidian", false, false, Registries.BLOCK.getId(Blocks.OBSIDIAN).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.PACKED_MUD), new GenericBeamBlock.BeamConfig(Blocks.PACKED_MUD, "packed_mud", "Packed Mud", false, false, Registries.BLOCK.getId(Blocks.PACKED_MUD).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_ANDESITE), new GenericBeamBlock.BeamConfig(Blocks.POLISHED_ANDESITE, "polished_andesite", "Polished Andesite", false, false, Registries.BLOCK.getId(Blocks.POLISHED_ANDESITE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BASALT), new GenericBeamBlock.BeamConfig(Blocks.POLISHED_BASALT, "polished_basalt", "Polished Basalt", false, false, Registries.BLOCK.getId(Blocks.POLISHED_BASALT).withPrefixedPath("block/").withSuffixedPath("_side"), Registries.BLOCK.getId(Blocks.POLISHED_BASALT).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE), new GenericBeamBlock.BeamConfig(Blocks.POLISHED_BLACKSTONE, "polished_blackstone", "Polished Blackstone", false, false, Registries.BLOCK.getId(Blocks.POLISHED_BLACKSTONE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_BLACKSTONE_BRICKS), new GenericBeamBlock.BeamConfig(Blocks.POLISHED_BLACKSTONE_BRICKS, "polished_blackstone_brick", "Polished Blackstone Brick", false, false, Registries.BLOCK.getId(Blocks.POLISHED_BLACKSTONE_BRICKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_DEEPSLATE), new GenericBeamBlock.BeamConfig(Blocks.POLISHED_DEEPSLATE, "polished_deepslate", "Polished Deepslate", false, false, Registries.BLOCK.getId(Blocks.POLISHED_DEEPSLATE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_DIORITE), new GenericBeamBlock.BeamConfig(Blocks.POLISHED_DIORITE, "polished_diorite", "Polished Diorite", false, false, Registries.BLOCK.getId(Blocks.POLISHED_DIORITE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.POLISHED_GRANITE), new GenericBeamBlock.BeamConfig(Blocks.POLISHED_GRANITE, "polished_granite", "Polished Granite", false, false, Registries.BLOCK.getId(Blocks.POLISHED_GRANITE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.PRISMARINE), new GenericBeamBlock.BeamConfig(Blocks.PRISMARINE, "prismarine", "Prismarine", false, false, Registries.BLOCK.getId(Blocks.PRISMARINE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.PRISMARINE_BRICKS), new GenericBeamBlock.BeamConfig(Blocks.PRISMARINE_BRICKS, "prismarine_brick", "Prismarine Brick", false, false, Registries.BLOCK.getId(Blocks.PRISMARINE_BRICKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.PURPUR_BLOCK), new GenericBeamBlock.BeamConfig(Blocks.PURPUR_BLOCK, "purpur", "Purpur", false, false, Registries.BLOCK.getId(Blocks.PURPUR_BLOCK).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.PURPUR_PILLAR), new GenericBeamBlock.BeamConfig(Blocks.PURPUR_PILLAR, "purpur_pillar", "Purpur Pillar", false, false, Registries.BLOCK.getId(Blocks.PURPUR_PILLAR).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BLOCK), new GenericBeamBlock.BeamConfig(Blocks.QUARTZ_BLOCK, "quartz", "Quartz", false, false, Registries.BLOCK.getId(Blocks.QUARTZ_BLOCK).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.QUARTZ_BRICKS), new GenericBeamBlock.BeamConfig(Blocks.QUARTZ_BRICKS, "quartz_brick", "Quartz Brick", false, false, Registries.BLOCK.getId(Blocks.QUARTZ_BRICKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.RED_NETHER_BRICKS), new GenericBeamBlock.BeamConfig(Blocks.RED_NETHER_BRICKS, "red_nether_brick", "Red Nether Brick", false, false, Registries.BLOCK.getId(Blocks.RED_NETHER_BRICKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.RED_SANDSTONE), new GenericBeamBlock.BeamConfig(Blocks.RED_SANDSTONE, "red_sandstone", "Red Sandstone", false, false, Registries.BLOCK.getId(Blocks.RED_SANDSTONE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.SANDSTONE), new GenericBeamBlock.BeamConfig(Blocks.SANDSTONE, "sandstone", "Sandstone", false, false, Registries.BLOCK.getId(Blocks.SANDSTONE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_BASALT), new GenericBeamBlock.BeamConfig(Blocks.SMOOTH_BASALT, "smooth_basalt", "Smooth Basalt", false, false, Registries.BLOCK.getId(Blocks.SMOOTH_BASALT).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_QUARTZ), new GenericBeamBlock.BeamConfig(Blocks.SMOOTH_QUARTZ, "smooth_quartz", "Smooth Quartz", false, false, Registries.BLOCK.getId(Blocks.QUARTZ_BLOCK).withPrefixedPath("block/").withSuffixedPath("_bottom"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_RED_SANDSTONE), new GenericBeamBlock.BeamConfig(Blocks.SMOOTH_RED_SANDSTONE, "smooth_red_sandstone", "Smooth Red Sandstone", false, false, Registries.BLOCK.getId(Blocks.RED_SANDSTONE).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_SANDSTONE), new GenericBeamBlock.BeamConfig(Blocks.SMOOTH_SANDSTONE, "smooth_sandstone", "Smooth Sandstone", false, false, Registries.BLOCK.getId(Blocks.SANDSTONE).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.SMOOTH_STONE), new GenericBeamBlock.BeamConfig(Blocks.SMOOTH_STONE, "smooth_stone", "Smooth Stone", false, false, Registries.BLOCK.getId(Blocks.SMOOTH_STONE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.STONE), new GenericBeamBlock.BeamConfig(Blocks.STONE, "stone", "Stone", false, false, Registries.BLOCK.getId(Blocks.STONE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.STONE_BRICKS), new GenericBeamBlock.BeamConfig(Blocks.STONE_BRICKS, "stone_brick", "Stone Brick", false, false, Registries.BLOCK.getId(Blocks.STONE_BRICKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.TUFF), new GenericBeamBlock.BeamConfig(Blocks.TUFF, "tuff", "Tuff", false, false, Registries.BLOCK.getId(Blocks.TUFF).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK), new GenericBeamBlock.BeamConfig(BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK, "warped_basalt_brick", "Warped Basalt Brick", false, false, WarpedBasaltBricksBlock.BLOCK_ID.withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK), new GenericBeamBlock.BeamConfig(BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK, "warped_nether_brick", "Warped Nether Brick", false, false, WarpedNetherBricksBlock.BLOCK_ID.withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.COPPER_BLOCK), new GenericBeamBlock.BeamConfig(Blocks.COPPER_BLOCK, "copper_block", "Copper Block", false, false, Registries.BLOCK.getId(Blocks.COPPER_BLOCK).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.DIAMOND_BLOCK), new GenericBeamBlock.BeamConfig(Blocks.DIAMOND_BLOCK, "diamond_block", "Diamond Block", false, false, Registries.BLOCK.getId(Blocks.DIAMOND_BLOCK).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.GOLD_BLOCK), new GenericBeamBlock.BeamConfig(Blocks.GOLD_BLOCK, "gold_block", "Gold Block", false, false, Registries.BLOCK.getId(Blocks.GOLD_BLOCK).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.IRON_BLOCK), new GenericBeamBlock.BeamConfig(Blocks.IRON_BLOCK, "iron_block", "Iron Block", false, false, Registries.BLOCK.getId(Blocks.IRON_BLOCK).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.LAPIS_BLOCK), new GenericBeamBlock.BeamConfig(Blocks.LAPIS_BLOCK, "lapis_block", "Lapis Block", false, false, Registries.BLOCK.getId(Blocks.LAPIS_BLOCK).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.NETHERITE_BLOCK), new GenericBeamBlock.BeamConfig(Blocks.NETHERITE_BLOCK, "netherite_block", "Netherite Block", false, false, Registries.BLOCK.getId(Blocks.NETHERITE_BLOCK).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.REDSTONE_BLOCK), new GenericBeamBlock.BeamConfig(Blocks.REDSTONE_BLOCK, "redstone_block", "Redstone Block", false, false, Registries.BLOCK.getId(Blocks.REDSTONE_BLOCK).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CUT_COPPER), new GenericBeamBlock.BeamConfig(Blocks.CUT_COPPER, "cut_copper", "Cut Copper", false, false, Registries.BLOCK.getId(Blocks.CUT_COPPER).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.EXPOSED_CUT_COPPER), new GenericBeamBlock.BeamConfig(Blocks.EXPOSED_CUT_COPPER, "exposed_cut_copper", "Exposed Cut Copper", false, false, Registries.BLOCK.getId(Blocks.EXPOSED_CUT_COPPER).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.WEATHERED_CUT_COPPER), new GenericBeamBlock.BeamConfig(Blocks.WEATHERED_CUT_COPPER, "weathered_cut_copper", "Weathered Cut Copper", false, false, Registries.BLOCK.getId(Blocks.WEATHERED_CUT_COPPER).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.OXIDIZED_CUT_COPPER), new GenericBeamBlock.BeamConfig(Blocks.OXIDIZED_CUT_COPPER, "oxidized_cut_copper", "Oxidized Cut Copper", false, false, Registries.BLOCK.getId(Blocks.OXIDIZED_CUT_COPPER).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.WHITE_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.WHITE_TERRACOTTA, "white_terracotta", "White Terracotta", false, false, Registries.BLOCK.getId(Blocks.WHITE_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.ORANGE_TERRACOTTA, "orange_terracotta", "Orange Terracotta", false, false, Registries.BLOCK.getId(Blocks.ORANGE_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.MAGENTA_TERRACOTTA, "magenta_terracotta", "Magenta Terracotta", false, false, Registries.BLOCK.getId(Blocks.MAGENTA_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.LIGHT_BLUE_TERRACOTTA, "light_blue_terracotta", "Light Blue Terracotta", false, false, Registries.BLOCK.getId(Blocks.LIGHT_BLUE_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.YELLOW_TERRACOTTA, "yellow_terracotta", "Yellow Terracotta", false, false, Registries.BLOCK.getId(Blocks.YELLOW_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.LIME_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.LIME_TERRACOTTA, "lime_terracotta", "Lime Terracotta", false, false, Registries.BLOCK.getId(Blocks.LIME_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.PINK_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.PINK_TERRACOTTA, "pink_terracotta", "Pink Terracotta", false, false, Registries.BLOCK.getId(Blocks.PINK_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.GRAY_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.GRAY_TERRACOTTA, "gray_terracotta", "Gray Terracotta", false, false, Registries.BLOCK.getId(Blocks.GRAY_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.LIGHT_GRAY_TERRACOTTA, "light_gray_terracotta", "Light Gray Terracotta", false, false, Registries.BLOCK.getId(Blocks.LIGHT_GRAY_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CYAN_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.CYAN_TERRACOTTA, "cyan_terracotta", "Cyan Terracotta", false, false, Registries.BLOCK.getId(Blocks.CYAN_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.PURPLE_TERRACOTTA, "purple_terracotta", "Purple Terracotta", false, false, Registries.BLOCK.getId(Blocks.PURPLE_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BLUE_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.BLUE_TERRACOTTA, "blue_terracotta", "Blue Terracotta", false, false, Registries.BLOCK.getId(Blocks.BLUE_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BROWN_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.BROWN_TERRACOTTA, "brown_terracotta", "Brown Terracotta", false, false, Registries.BLOCK.getId(Blocks.BROWN_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.GREEN_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.GREEN_TERRACOTTA, "green_terracotta", "Green Terracotta", false, false, Registries.BLOCK.getId(Blocks.GREEN_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.RED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.RED_TERRACOTTA, "red_terracotta", "Red Terracotta", false, false, Registries.BLOCK.getId(Blocks.RED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BLACK_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.BLACK_TERRACOTTA, "black_terracotta", "Black Terracotta", false, false, Registries.BLOCK.getId(Blocks.BLACK_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.WHITE_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.WHITE_GLAZED_TERRACOTTA, "white_glazed_terracotta", "White Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.WHITE_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.ORANGE_GLAZED_TERRACOTTA, "orange_glazed_terracotta", "Orange Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.ORANGE_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.MAGENTA_GLAZED_TERRACOTTA, "magenta_glazed_terracotta", "Magenta Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.MAGENTA_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, "light_blue_glazed_terracotta", "Light Blue Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.YELLOW_GLAZED_TERRACOTTA, "yellow_glazed_terracotta", "Yellow Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.YELLOW_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.LIME_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.LIME_GLAZED_TERRACOTTA, "lime_glazed_terracotta", "Lime Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.LIME_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.PINK_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.PINK_GLAZED_TERRACOTTA, "pink_glazed_terracotta", "Pink Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.PINK_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.GRAY_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.GRAY_GLAZED_TERRACOTTA, "gray_glazed_terracotta", "Gray Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.GRAY_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, "light_gray_glazed_terracotta", "Light Gray Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CYAN_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.CYAN_GLAZED_TERRACOTTA, "cyan_glazed_terracotta", "Cyan Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.CYAN_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.PURPLE_GLAZED_TERRACOTTA, "purple_glazed_terracotta", "Purple Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.PURPLE_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BLUE_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.BLUE_GLAZED_TERRACOTTA, "blue_glazed_terracotta", "Blue Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.BLUE_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BROWN_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.BROWN_GLAZED_TERRACOTTA, "brown_glazed_terracotta", "Brown Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.BROWN_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.GREEN_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.GREEN_GLAZED_TERRACOTTA, "green_glazed_terracotta", "Green Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.GREEN_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.RED_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.RED_GLAZED_TERRACOTTA, "red_glazed_terracotta", "Red Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.RED_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BLACK_GLAZED_TERRACOTTA), new GenericBeamBlock.BeamConfig(Blocks.BLACK_GLAZED_TERRACOTTA, "black_glazed_terracotta", "Black Glazed Terracotta", false, false, Registries.BLOCK.getId(Blocks.BLACK_GLAZED_TERRACOTTA).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.WHITE_CONCRETE, "white_concrete", "White Concrete", false, false, Registries.BLOCK.getId(Blocks.WHITE_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.ORANGE_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.ORANGE_CONCRETE, "orange_concrete", "Orange Concrete", false, false, Registries.BLOCK.getId(Blocks.ORANGE_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.MAGENTA_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.MAGENTA_CONCRETE, "magenta_concrete", "Magenta Concrete", false, false, Registries.BLOCK.getId(Blocks.MAGENTA_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_BLUE_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.LIGHT_BLUE_CONCRETE, "light_blue_concrete", "Light Blue Concrete", false, false, Registries.BLOCK.getId(Blocks.LIGHT_BLUE_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.YELLOW_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.YELLOW_CONCRETE, "yellow_concrete", "Yellow Concrete", false, false, Registries.BLOCK.getId(Blocks.YELLOW_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.LIME_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.LIME_CONCRETE, "lime_concrete", "Lime Concrete", false, false, Registries.BLOCK.getId(Blocks.LIME_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.PINK_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.PINK_CONCRETE, "pink_concrete", "Pink Concrete", false, false, Registries.BLOCK.getId(Blocks.PINK_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.GRAY_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.GRAY_CONCRETE, "gray_concrete", "Gray Concrete", false, false, Registries.BLOCK.getId(Blocks.GRAY_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.LIGHT_GRAY_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.LIGHT_GRAY_CONCRETE, "light_gray_concrete", "Light Gray Concrete", false, false, Registries.BLOCK.getId(Blocks.LIGHT_GRAY_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CYAN_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.CYAN_CONCRETE, "cyan_concrete", "Cyan Concrete", false, false, Registries.BLOCK.getId(Blocks.CYAN_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.PURPLE_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.PURPLE_CONCRETE, "purple_concrete", "Purple Concrete", false, false, Registries.BLOCK.getId(Blocks.PURPLE_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BLUE_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.BLUE_CONCRETE, "blue_concrete", "Blue Concrete", false, false, Registries.BLOCK.getId(Blocks.BLUE_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BROWN_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.BROWN_CONCRETE, "brown_concrete", "Brown Concrete", false, false, Registries.BLOCK.getId(Blocks.BROWN_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.GREEN_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.GREEN_CONCRETE, "green_concrete", "Green Concrete", false, false, Registries.BLOCK.getId(Blocks.GREEN_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.RED_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.RED_CONCRETE, "red_concrete", "Red Concrete", false, false, Registries.BLOCK.getId(Blocks.RED_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BLACK_CONCRETE), new GenericBeamBlock.BeamConfig(Blocks.BLACK_CONCRETE, "black_concrete", "Black Concrete", false, false, Registries.BLOCK.getId(Blocks.BLACK_CONCRETE).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.ACACIA_PLANKS, "acacia", "Acacia", true, false, Registries.BLOCK.getId(Blocks.ACACIA_PLANKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.ACACIA_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.ACACIA_LOG, "acacia_log", "Acacia Log", true, false, Registries.BLOCK.getId(Blocks.ACACIA_LOG).withPrefixedPath("block/"), Registries.BLOCK.getId(Blocks.ACACIA_LOG).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.BIRCH_PLANKS, "birch", "Birch", true, false, Registries.BLOCK.getId(Blocks.BIRCH_PLANKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.BIRCH_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.BIRCH_LOG, "birch_log", "Birch Log", true, false, Registries.BLOCK.getId(Blocks.BIRCH_LOG).withPrefixedPath("block/"), Registries.BLOCK.getId(Blocks.BIRCH_LOG).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.CHERRY_PLANKS, "cherry", "Cherry", false, false, Registries.BLOCK.getId(Blocks.CHERRY_PLANKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CHERRY_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.CHERRY_LOG, "cherry_log", "Cherry Log", false, false, Registries.BLOCK.getId(Blocks.CHERRY_LOG).withPrefixedPath("block/"), Registries.BLOCK.getId(Blocks.CHERRY_LOG).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.CRIMSON_PLANKS, "crimson", "Crimson", false, false, Registries.BLOCK.getId(Blocks.CRIMSON_PLANKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.CRIMSON_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.CRIMSON_STEM, "crimson_stem", "Crimson Stem", false, false, Registries.BLOCK.getId(Blocks.CRIMSON_STEM).withPrefixedPath("block/"), Registries.BLOCK.getId(Blocks.CRIMSON_STEM).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.DARK_OAK_PLANKS, "dark_oak", "Dark Oak", true, false, Registries.BLOCK.getId(Blocks.DARK_OAK_PLANKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.DARK_OAK_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.DARK_OAK_LOG, "dark_oak_log", "Dark Oak Log", true, false, Registries.BLOCK.getId(Blocks.DARK_OAK_LOG).withPrefixedPath("block/"), Registries.BLOCK.getId(Blocks.DARK_OAK_LOG).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.JUNGLE_PLANKS, "jungle", "Jungle", true, false, Registries.BLOCK.getId(Blocks.JUNGLE_PLANKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.JUNGLE_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.JUNGLE_LOG, "jungle_log", "Jungle Log", true, false, Registries.BLOCK.getId(Blocks.JUNGLE_LOG).withPrefixedPath("block/"), Registries.BLOCK.getId(Blocks.JUNGLE_LOG).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.MANGROVE_PLANKS, "mangrove", "Mangrove", true, false, Registries.BLOCK.getId(Blocks.MANGROVE_PLANKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.MANGROVE_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.MANGROVE_LOG, "mangrove_log", "Mangrove Log", true, false, Registries.BLOCK.getId(Blocks.MANGROVE_LOG).withPrefixedPath("block/"), Registries.BLOCK.getId(Blocks.MANGROVE_LOG).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.OAK_PLANKS, "oak", "Oak", true, false, Registries.BLOCK.getId(Blocks.OAK_PLANKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.OAK_LOG, "oak_log", "Oak Log", true, false, Registries.BLOCK.getId(Blocks.OAK_LOG).withPrefixedPath("block/"), Registries.BLOCK.getId(Blocks.OAK_LOG).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.SPRUCE_PLANKS, "spruce", "Spruce", true, false, Registries.BLOCK.getId(Blocks.SPRUCE_PLANKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.SPRUCE_LOG, "spruce_log", "Spruce Log", true, false, Registries.BLOCK.getId(Blocks.SPRUCE_LOG).withPrefixedPath("block/"), Registries.BLOCK.getId(Blocks.SPRUCE_LOG).withPrefixedPath("block/").withSuffixedPath("_top"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.WARPED_PLANKS, "warped", "Warped", false, false, Registries.BLOCK.getId(Blocks.WARPED_PLANKS).withPrefixedPath("block/"))),
            new GenericBeamBlock(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS), new GenericBeamBlock.BeamConfig(Blocks.WARPED_STEM, "warped_stem", "Warped Stem", false, false, Registries.BLOCK.getId(Blocks.WARPED_STEM).withPrefixedPath("block/"), Registries.BLOCK.getId(Blocks.WARPED_STEM).withPrefixedPath("block/").withSuffixedPath("_top")))
        );
    }

    @Override
    public void initializeClient() {
        BLOCKS.forEach(block -> {
            if (block.config.isTranslucent) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        });
    }

    @Override
    public void registerBlocks() {
        BLOCKS.forEach(GenericBeamBlock::register);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        BLOCKS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        BLOCKS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        BLOCKS.forEach(block -> block.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        BLOCKS.forEach(block -> block.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        BLOCKS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BLOCKS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BLOCKS.forEach(block -> block.configureItemModels(itemModelGenerator));
    }
}
