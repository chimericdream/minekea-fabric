package com.chimericdream.minekea.block.building.compressed;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.util.Tool;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Quartet;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.chimericdream.minekea.block.building.compressed.GenericCompressedBlock.TOOLTIP_COUNT;
import static com.chimericdream.minekea.block.building.compressed.GenericCompressedBlock.TOOLTIP_LEVEL;

public class CompressedBlocks implements MinekeaBlockCategory {
    public static final Map<String, List<Block>> BLOCK_MAP = new LinkedHashMap<>();
    public static final List<Block> BLOCKS = new ArrayList<>();

    protected static final List<Triplet<Pair<String, String>, Block, Tool>> BLOCKS_TO_COMPRESS = new ArrayList<>();
    protected static final List<Quartet<Pair<String, String>, Block, Pair<String, String>, Tool>> COLUMN_BLOCKS_TO_COMPRESS = new ArrayList<>();
    protected static final List<Quartet<Pair<String, String>, Block, Identifier, Tool>> MINEKEA_BLOCKS_TO_COMPRESS = new ArrayList<>();

    static {
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Amethyst", "amethyst_block"), Blocks.AMETHYST_BLOCK, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Andesite", "andesite"), Blocks.ANDESITE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Bricks", "bricks"), Blocks.BRICKS, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Calcite", "calcite"), Blocks.CALCITE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Clay", "clay"), Blocks.CLAY, Tool.SHOVEL));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Coarse Dirt", "coarse_dirt"), Blocks.COARSE_DIRT, Tool.SHOVEL));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Cobbled Deepslate", "cobbled_deepslate"), Blocks.COBBLED_DEEPSLATE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Cobblestone", "cobblestone"), Blocks.COBBLESTONE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Cracked Deepslate Bricks", "cracked_deepslate_bricks"), Blocks.CRACKED_DEEPSLATE_BRICKS, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Cracked Deepslate Tiles", "cracked_deepslate_tiles"), Blocks.CRACKED_DEEPSLATE_TILES, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Cracked Stone Bricks", "cracked_stone_bricks"), Blocks.CRACKED_STONE_BRICKS, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Crying Obsidian", "crying_obsidian"), Blocks.CRYING_OBSIDIAN, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Cut Red Sandstone", "cut_red_sandstone"), Blocks.CUT_RED_SANDSTONE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Cut Sandstone", "cut_sandstone"), Blocks.CUT_SANDSTONE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Dark Prismarine", "dark_prismarine"), Blocks.DARK_PRISMARINE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Deepslate Bricks", "deepslate_bricks"), Blocks.DEEPSLATE_BRICKS, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Deepslate Tiles", "deepslate_tiles"), Blocks.DEEPSLATE_TILES, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Diorite", "diorite"), Blocks.DIORITE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Dirt", "dirt"), Blocks.DIRT, Tool.SHOVEL));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("End Stone", "end_stone"), Blocks.END_STONE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("End Stone Bricks", "end_stone_bricks"), Blocks.END_STONE_BRICKS, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Granite", "granite"), Blocks.GRANITE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Gravel", "gravel"), Blocks.GRAVEL, Tool.SHOVEL));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Mossy Cobblestone", "mossy_cobblestone"), Blocks.MOSSY_COBBLESTONE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Mossy Stone Bricks", "mossy_stone_bricks"), Blocks.MOSSY_STONE_BRICKS, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Mud", "mud"), Blocks.MUD, Tool.SHOVEL));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Mud Bricks", "mud_bricks"), Blocks.MUD_BRICKS, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Netherrack", "netherrack"), Blocks.NETHERRACK, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Nether Bricks", "nether_bricks"), Blocks.NETHER_BRICKS, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Obsidian", "obsidian"), Blocks.OBSIDIAN, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Packed Mud", "packed_mud"), Blocks.PACKED_MUD, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Polished Andesite", "polished_andesite"), Blocks.POLISHED_ANDESITE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Polished Blackstone", "polished_blackstone"), Blocks.POLISHED_BLACKSTONE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Polished Blackstone Bricks", "polished_blackstone_bricks"), Blocks.POLISHED_BLACKSTONE_BRICKS, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Polished Deepslate", "polished_deepslate"), Blocks.POLISHED_DEEPSLATE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Polished Diorite", "polished_diorite"), Blocks.POLISHED_DIORITE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Polished Granite", "polished_granite"), Blocks.POLISHED_GRANITE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Prismarine", "prismarine"), Blocks.PRISMARINE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Prismarine Bricks", "prismarine_bricks"), Blocks.PRISMARINE_BRICKS, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Purpur", "purpur_block"), Blocks.PURPUR_BLOCK, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Quartz Bricks", "quartz_bricks"), Blocks.QUARTZ_BRICKS, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Red Nether Bricks", "red_nether_bricks"), Blocks.RED_NETHER_BRICKS, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Red Sandstone", "red_sandstone"), Blocks.RED_SANDSTONE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Red Sand", "red_sand"), Blocks.RED_SAND, Tool.SHOVEL));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Rooted Dirt", "rooted_dirt"), Blocks.ROOTED_DIRT, Tool.SHOVEL));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Sand", "sand"), Blocks.SAND, Tool.SHOVEL));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Sandstone", "sandstone"), Blocks.SANDSTONE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Smooth Basalt", "smooth_basalt"), Blocks.SMOOTH_BASALT, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Smooth Quartz", "quartz_block_bottom"), Blocks.SMOOTH_QUARTZ, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Smooth Red Sandstone", "red_sandstone_top"), Blocks.SMOOTH_RED_SANDSTONE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Smooth Sandstone", "sandstone_top"), Blocks.SMOOTH_SANDSTONE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Smooth Stone", "smooth_stone"), Blocks.SMOOTH_STONE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Soul Sand", "soul_sand"), Blocks.SOUL_SAND, Tool.SHOVEL));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Stone", "stone"), Blocks.STONE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Stone Bricks", "stone_bricks"), Blocks.STONE_BRICKS, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Tuff", "tuff"), Blocks.TUFF, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Copper Block", "copper_block"), Blocks.COPPER_BLOCK, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Diamond Block", "diamond_block"), Blocks.DIAMOND_BLOCK, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Gold Block", "gold_block"), Blocks.GOLD_BLOCK, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Iron Block", "iron_block"), Blocks.IRON_BLOCK, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Lapis Block", "lapis_block"), Blocks.LAPIS_BLOCK, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Netherite Block", "netherite_block"), Blocks.NETHERITE_BLOCK, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Redstone Block", "redstone_block"), Blocks.REDSTONE_BLOCK, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("White Terracotta", "white_terracotta"), Blocks.WHITE_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Orange Terracotta", "orange_terracotta"), Blocks.ORANGE_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Magenta Terracotta", "magenta_terracotta"), Blocks.MAGENTA_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Light Blue Terracotta", "light_blue_terracotta"), Blocks.LIGHT_BLUE_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Yellow Terracotta", "yellow_terracotta"), Blocks.YELLOW_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Lime Terracotta", "lime_terracotta"), Blocks.LIME_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Pink Terracotta", "pink_terracotta"), Blocks.PINK_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Gray Terracotta", "gray_terracotta"), Blocks.GRAY_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Light Gray Terracotta", "light_gray_terracotta"), Blocks.LIGHT_GRAY_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Cyan Terracotta", "cyan_terracotta"), Blocks.CYAN_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Purple Terracotta", "purple_terracotta"), Blocks.PURPLE_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Blue Terracotta", "blue_terracotta"), Blocks.BLUE_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Brown Terracotta", "brown_terracotta"), Blocks.BROWN_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Green Terracotta", "green_terracotta"), Blocks.GREEN_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Red Terracotta", "red_terracotta"), Blocks.RED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Black Terracotta", "black_terracotta"), Blocks.BLACK_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("White Glazed Terracotta", "white_glazed_terracotta"), Blocks.WHITE_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Orange Glazed Terracotta", "orange_glazed_terracotta"), Blocks.ORANGE_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Magenta Glazed Terracotta", "magenta_glazed_terracotta"), Blocks.MAGENTA_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Light Blue Glazed Terracotta", "light_blue_glazed_terracotta"), Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Yellow Glazed Terracotta", "yellow_glazed_terracotta"), Blocks.YELLOW_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Lime Glazed Terracotta", "lime_glazed_terracotta"), Blocks.LIME_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Pink Glazed Terracotta", "pink_glazed_terracotta"), Blocks.PINK_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Gray Glazed Terracotta", "gray_glazed_terracotta"), Blocks.GRAY_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Light Gray Glazed Terracotta", "light_gray_glazed_terracotta"), Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Cyan Glazed Terracotta", "cyan_glazed_terracotta"), Blocks.CYAN_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Purple Glazed Terracotta", "purple_glazed_terracotta"), Blocks.PURPLE_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Blue Glazed Terracotta", "blue_glazed_terracotta"), Blocks.BLUE_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Brown Glazed Terracotta", "brown_glazed_terracotta"), Blocks.BROWN_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Green Glazed Terracotta", "green_glazed_terracotta"), Blocks.GREEN_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Red Glazed Terracotta", "red_glazed_terracotta"), Blocks.RED_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Black Glazed Terracotta", "black_glazed_terracotta"), Blocks.BLACK_GLAZED_TERRACOTTA, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("White Concrete", "white_concrete"), Blocks.WHITE_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Orange Concrete", "orange_concrete"), Blocks.ORANGE_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Magenta Concrete", "magenta_concrete"), Blocks.MAGENTA_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Light Blue Concrete", "light_blue_concrete"), Blocks.LIGHT_BLUE_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Yellow Concrete", "yellow_concrete"), Blocks.YELLOW_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Lime Concrete", "lime_concrete"), Blocks.LIME_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Pink Concrete", "pink_concrete"), Blocks.PINK_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Gray Concrete", "gray_concrete"), Blocks.GRAY_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Light Gray Concrete", "light_gray_concrete"), Blocks.LIGHT_GRAY_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Cyan Concrete", "cyan_concrete"), Blocks.CYAN_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Purple Concrete", "purple_concrete"), Blocks.PURPLE_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Blue Concrete", "blue_concrete"), Blocks.BLUE_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Brown Concrete", "brown_concrete"), Blocks.BROWN_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Green Concrete", "green_concrete"), Blocks.GREEN_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Red Concrete", "red_concrete"), Blocks.RED_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Black Concrete", "black_concrete"), Blocks.BLACK_CONCRETE, null));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Acacia Planks", "acacia_planks"), Blocks.ACACIA_PLANKS, Tool.AXE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Birch Planks", "birch_planks"), Blocks.BIRCH_PLANKS, Tool.AXE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Cherry Planks", "cherry_planks"), Blocks.CHERRY_PLANKS, Tool.AXE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Crimson Planks", "crimson_planks"), Blocks.CRIMSON_PLANKS, Tool.AXE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Dark Oak Planks", "dark_oak_planks"), Blocks.DARK_OAK_PLANKS, Tool.AXE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Jungle Planks", "jungle_planks"), Blocks.JUNGLE_PLANKS, Tool.AXE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Mangrove Planks", "mangrove_planks"), Blocks.MANGROVE_PLANKS, Tool.AXE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Oak Planks", "oak_planks"), Blocks.OAK_PLANKS, Tool.AXE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Spruce Planks", "spruce_planks"), Blocks.SPRUCE_PLANKS, Tool.AXE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>(new Pair<>("Warped Planks", "warped_planks"), Blocks.WARPED_PLANKS, Tool.AXE));

        BLOCKS_TO_COMPRESS.forEach(data -> {
            String materialName = data.getA().getA();
            String material = data.getA().getB();
            Block ingredient = data.getB();
            Tool tool = data.getC();

            List<Block> compressedBlocks = new ArrayList<>();

            for (int i = 1; i <= 9; i += 1) {
                compressedBlocks.add(
                    new GenericCompressedBlock(
                        new BlockConfig()
                            .material(material)
                            .materialName(materialName)
                            .ingredient(ingredient)
                            .tool(tool),
                        i
                    )
                );
            }

            BLOCKS.addAll(compressedBlocks);
            BLOCK_MAP.put(materialName, compressedBlocks);
        });

        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Basalt", "basalt"), Blocks.BASALT, new Pair<>("_side", "_top"), null));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Blackstone", "blackstone"), Blocks.BLACKSTONE, new Pair<>("", "_top"), null));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Bone", "bone_block"), Blocks.BONE_BLOCK, new Pair<>("_side", "_top"), null));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Deepslate", "deepslate"), Blocks.DEEPSLATE, new Pair<>("", "_top"), null));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Polished Basalt", "polished_basalt"), Blocks.POLISHED_BASALT, new Pair<>("_side", "_top"), null));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Purpur Pillar", "purpur_pillar"), Blocks.PURPUR_PILLAR, new Pair<>("", "_top"), null));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Quartz", "quartz_block"), Blocks.QUARTZ_BLOCK, new Pair<>("_side", "_top"), null));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Acacia Log", "acacia_log"), Blocks.ACACIA_LOG, new Pair<>("", "_top"), Tool.AXE));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Birch Log", "birch_log"), Blocks.BIRCH_LOG, new Pair<>("", "_top"), Tool.AXE));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Cherry Log", "cherry_log"), Blocks.CHERRY_LOG, new Pair<>("", "_top"), Tool.AXE));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Crimson Stem", "crimson_stem"), Blocks.CRIMSON_STEM, new Pair<>("", "_top"), Tool.AXE));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Dark Oak Log", "dark_oak_log"), Blocks.DARK_OAK_LOG, new Pair<>("", "_top"), Tool.AXE));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Jungle Log", "jungle_log"), Blocks.JUNGLE_LOG, new Pair<>("", "_top"), Tool.AXE));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Mangrove Log", "mangrove_log"), Blocks.MANGROVE_LOG, new Pair<>("", "_top"), Tool.AXE));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Oak Log", "oak_log"), Blocks.OAK_LOG, new Pair<>("", "_top"), Tool.AXE));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Spruce Log", "spruce_log"), Blocks.SPRUCE_LOG, new Pair<>("", "_top"), Tool.AXE));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Warped Stem", "warped_stem"), Blocks.WARPED_STEM, new Pair<>("", "_top"), Tool.AXE));

        COLUMN_BLOCKS_TO_COMPRESS.forEach(data -> {
            String materialName = data.getA().getA();
            String material = data.getA().getB();
            Block ingredient = data.getB();
            String sideTextureSuffix = data.getC().getA();
            String endTextureSuffix = data.getC().getB();
            Tool tool = data.getD();

            List<Block> compressedBlocks = new ArrayList<>();

            for (int i = 1; i <= 9; i += 1) {
                compressedBlocks.add(
                    new CompressedColumnBlock(
                        new BlockConfig()
                            .material(material)
                            .materialName(materialName)
                            .ingredient(ingredient)
                            .tool(tool),
                        i,
                        sideTextureSuffix,
                        endTextureSuffix
                    )
                );
            }

            BLOCKS.addAll(compressedBlocks);
            BLOCK_MAP.put(materialName, compressedBlocks);
        });

        MINEKEA_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Basalt Brick", "basalt_brick"), BuildingBlocks.BASALT_BRICKS_BLOCK, BasaltBricksBlock.BLOCK_ID, null));
        MINEKEA_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Cracked Basalt Bricks", "cracked_basalt_brick"), BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK, CrackedBasaltBricksBlock.BLOCK_ID, null));
        MINEKEA_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Crimson Basalt Bricks", "crimson_basalt_brick"), BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK, CrimsonBasaltBricksBlock.BLOCK_ID, null));
        MINEKEA_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Mossy Basalt Brick", "mossy_basalt_brick"), BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK, MossyBasaltBricksBlock.BLOCK_ID, null));
        MINEKEA_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Warped Basalt Brick", "warped_basalt_brick"), BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK, WarpedBasaltBricksBlock.BLOCK_ID, null));
        MINEKEA_BLOCKS_TO_COMPRESS.add(new Quartet<>(new Pair<>("Warped Nether Brick", "warped_nether_brick"), BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK, WarpedNetherBricksBlock.BLOCK_ID, null));

        MINEKEA_BLOCKS_TO_COMPRESS.forEach(data -> {
            String materialName = data.getA().getA();
            String material = data.getA().getB();
            Block ingredient = data.getB();
            Identifier baseBlockId = data.getC();
            Tool tool = data.getD();

            List<Block> compressedBlocks = new ArrayList<>();

            for (int i = 1; i <= 9; i += 1) {
                compressedBlocks.add(
                    new CompressedMinekeaBlock(
                        new BlockConfig()
                            .material(material)
                            .materialName(materialName)
                            .ingredient(ingredient)
                            .tool(tool),
                        i,
                        baseBlockId
                    )
                );
            }

            BLOCKS.addAll(compressedBlocks);
            BLOCK_MAP.put(materialName, compressedBlocks);
        });
    }

    public List<Block> getCategoryBlocks() {
        return BLOCKS;
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        MinekeaBlockCategory.super.configureTranslations(registryLookup, translationBuilder);

        translationBuilder.add(TOOLTIP_LEVEL, "%dx Compressed");
        translationBuilder.add(TOOLTIP_COUNT, "(%s blocks)");
    }
}
