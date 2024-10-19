package com.chimericdream.minekea.block.building.compressed;

import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.item.MinekeaItemGroups;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import com.chimericdream.minekea.util.Tool;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import oshi.util.tuples.Pair;
import oshi.util.tuples.Quartet;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import static com.chimericdream.minekea.block.building.compressed.GenericCompressedBlock.TOOLTIP_COUNT;
import static com.chimericdream.minekea.block.building.compressed.GenericCompressedBlock.TOOLTIP_LEVEL;

public class CompressedBlocks implements MinekeaBlockCategory {
    public static final Map<String, List<GenericCompressedBlock>> BLOCK_MAP = new LinkedHashMap<>();
    public static final List<GenericCompressedBlock> BLOCKS = new ArrayList<>();

    protected static final List<Quartet<Pair<String, String>, MinekeaBlock, Identifier, Tool>> MINEKEA_BLOCKS_TO_COMPRESS = List.of(
        new Quartet<>(new Pair<>("Basalt Brick", "basalt_brick"), BuildingBlocks.BASALT_BRICKS_BLOCK, BasaltBricksBlock.BLOCK_ID, Tool.PICKAXE),
        new Quartet<>(new Pair<>("Cracked Basalt Bricks", "cracked_basalt_brick"), BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK, CrackedBasaltBricksBlock.BLOCK_ID, Tool.PICKAXE),
        new Quartet<>(new Pair<>("Crimson Basalt Bricks", "crimson_basalt_brick"), BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK, CrimsonBasaltBricksBlock.BLOCK_ID, Tool.PICKAXE),
        new Quartet<>(new Pair<>("Mossy Basalt Brick", "mossy_basalt_brick"), BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK, MossyBasaltBricksBlock.BLOCK_ID, Tool.PICKAXE),
        new Quartet<>(new Pair<>("Warped Basalt Brick", "warped_basalt_brick"), BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK, WarpedBasaltBricksBlock.BLOCK_ID, Tool.PICKAXE),
        new Quartet<>(new Pair<>("Warped Nether Brick", "warped_nether_brick"), BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK, WarpedNetherBricksBlock.BLOCK_ID, Tool.PICKAXE)
    );

    protected static final List<Quartet<Pair<String, String>, Block, Pair<String, String>, Tool>> COLUMN_BLOCKS_TO_COMPRESS = List.of(
        new Quartet<>(new Pair<>("Basalt", "basalt"), Blocks.BASALT, new Pair<>("_side", "_top"), Tool.PICKAXE),
        new Quartet<>(new Pair<>("Blackstone", "blackstone"), Blocks.BLACKSTONE, new Pair<>("", "_top"), Tool.PICKAXE),
        new Quartet<>(new Pair<>("Bone", "bone_block"), Blocks.BONE_BLOCK, new Pair<>("_side", "_top"), Tool.PICKAXE),
        new Quartet<>(new Pair<>("Deepslate", "deepslate"), Blocks.DEEPSLATE, new Pair<>("", "_top"), Tool.PICKAXE),
        new Quartet<>(new Pair<>("Polished Basalt", "polished_basalt"), Blocks.POLISHED_BASALT, new Pair<>("_side", "_top"), Tool.PICKAXE),
        new Quartet<>(new Pair<>("Purpur Pillar", "purpur_pillar"), Blocks.PURPUR_PILLAR, new Pair<>("", "_top"), Tool.PICKAXE),
        new Quartet<>(new Pair<>("Quartz", "quartz_block"), Blocks.QUARTZ_BLOCK, new Pair<>("_side", "_top"), Tool.PICKAXE),
        new Quartet<>(new Pair<>("Acacia Log", "acacia_log"), Blocks.ACACIA_LOG, new Pair<>("", "_top"), Tool.AXE),
        new Quartet<>(new Pair<>("Birch Log", "birch_log"), Blocks.BIRCH_LOG, new Pair<>("", "_top"), Tool.AXE),
        new Quartet<>(new Pair<>("Cherry Log", "cherry_log"), Blocks.CHERRY_LOG, new Pair<>("", "_top"), Tool.AXE),
        new Quartet<>(new Pair<>("Crimson Stem", "crimson_stem"), Blocks.CRIMSON_STEM, new Pair<>("", "_top"), Tool.AXE),
        new Quartet<>(new Pair<>("Dark Oak Log", "dark_oak_log"), Blocks.DARK_OAK_LOG, new Pair<>("", "_top"), Tool.AXE),
        new Quartet<>(new Pair<>("Jungle Log", "jungle_log"), Blocks.JUNGLE_LOG, new Pair<>("", "_top"), Tool.AXE),
        new Quartet<>(new Pair<>("Mangrove Log", "mangrove_log"), Blocks.MANGROVE_LOG, new Pair<>("", "_top"), Tool.AXE),
        new Quartet<>(new Pair<>("Oak Log", "oak_log"), Blocks.OAK_LOG, new Pair<>("", "_top"), Tool.AXE),
        new Quartet<>(new Pair<>("Spruce Log", "spruce_log"), Blocks.SPRUCE_LOG, new Pair<>("", "_top"), Tool.AXE),
        new Quartet<>(new Pair<>("Warped Stem", "warped_stem"), Blocks.WARPED_STEM, new Pair<>("", "_top"), Tool.AXE)
    );

    protected static final List<Triplet<Pair<String, String>, Block, Tool>> BLOCKS_TO_COMPRESS = List.of(
        new Triplet<>(new Pair<>("Amethyst", "amethyst_block"), Blocks.AMETHYST_BLOCK, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Andesite", "andesite"), Blocks.ANDESITE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Bricks", "bricks"), Blocks.BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Calcite", "calcite"), Blocks.CALCITE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Clay", "clay"), Blocks.CLAY, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Coarse Dirt", "coarse_dirt"), Blocks.COARSE_DIRT, Tool.SHOVEL),
        new Triplet<>(new Pair<>("Cobbled Deepslate", "cobbled_deepslate"), Blocks.COBBLED_DEEPSLATE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Cobblestone", "cobblestone"), Blocks.COBBLESTONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Cracked Deepslate Bricks", "cracked_deepslate_bricks"), Blocks.CRACKED_DEEPSLATE_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Cracked Deepslate Tiles", "cracked_deepslate_tiles"), Blocks.CRACKED_DEEPSLATE_TILES, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Cracked Stone Bricks", "cracked_stone_bricks"), Blocks.CRACKED_STONE_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Crying Obsidian", "crying_obsidian"), Blocks.CRYING_OBSIDIAN, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Cut Red Sandstone", "cut_red_sandstone"), Blocks.CUT_RED_SANDSTONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Cut Sandstone", "cut_sandstone"), Blocks.CUT_SANDSTONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Dark Prismarine", "dark_prismarine"), Blocks.DARK_PRISMARINE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Deepslate Bricks", "deepslate_bricks"), Blocks.DEEPSLATE_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Deepslate Tiles", "deepslate_tiles"), Blocks.DEEPSLATE_TILES, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Diorite", "diorite"), Blocks.DIORITE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Dirt", "dirt"), Blocks.DIRT, Tool.SHOVEL),
        new Triplet<>(new Pair<>("End Stone", "end_stone"), Blocks.END_STONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("End Stone Bricks", "end_stone_bricks"), Blocks.END_STONE_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Granite", "granite"), Blocks.GRANITE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Gravel", "gravel"), Blocks.GRAVEL, Tool.SHOVEL),
        new Triplet<>(new Pair<>("Mossy Cobblestone", "mossy_cobblestone"), Blocks.MOSSY_COBBLESTONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Mossy Stone Bricks", "mossy_stone_bricks"), Blocks.MOSSY_STONE_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Mud", "mud"), Blocks.MUD, Tool.SHOVEL),
        new Triplet<>(new Pair<>("Mud Bricks", "mud_bricks"), Blocks.MUD_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Netherrack", "netherrack"), Blocks.NETHERRACK, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Nether Bricks", "nether_bricks"), Blocks.NETHER_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Obsidian", "obsidian"), Blocks.OBSIDIAN, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Packed Mud", "packed_mud"), Blocks.PACKED_MUD, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Polished Andesite", "polished_andesite"), Blocks.POLISHED_ANDESITE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Polished Blackstone", "polished_blackstone"), Blocks.POLISHED_BLACKSTONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Polished Blackstone Bricks", "polished_blackstone_bricks"), Blocks.POLISHED_BLACKSTONE_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Polished Deepslate", "polished_deepslate"), Blocks.POLISHED_DEEPSLATE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Polished Diorite", "polished_diorite"), Blocks.POLISHED_DIORITE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Polished Granite", "polished_granite"), Blocks.POLISHED_GRANITE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Prismarine", "prismarine"), Blocks.PRISMARINE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Prismarine Bricks", "prismarine_bricks"), Blocks.PRISMARINE_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Purpur", "purpur_block"), Blocks.PURPUR_BLOCK, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Quartz Bricks", "quartz_bricks"), Blocks.QUARTZ_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Red Nether Bricks", "red_nether_bricks"), Blocks.RED_NETHER_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Red Sandstone", "red_sandstone"), Blocks.RED_SANDSTONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Red Sand", "red_sand"), Blocks.RED_SAND, Tool.SHOVEL),
        new Triplet<>(new Pair<>("Rooted Dirt", "rooted_dirt"), Blocks.ROOTED_DIRT, Tool.SHOVEL),
        new Triplet<>(new Pair<>("Sand", "sand"), Blocks.SAND, Tool.SHOVEL),
        new Triplet<>(new Pair<>("Sandstone", "sandstone"), Blocks.SANDSTONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Smooth Basalt", "smooth_basalt"), Blocks.SMOOTH_BASALT, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Smooth Quartz", "quartz_block_bottom"), Blocks.SMOOTH_QUARTZ, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Smooth Red Sandstone", "red_sandstone_top"), Blocks.SMOOTH_RED_SANDSTONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Smooth Sandstone", "sandstone_top"), Blocks.SMOOTH_SANDSTONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Smooth Stone", "smooth_stone"), Blocks.SMOOTH_STONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Soul Sand", "soul_sand"), Blocks.SOUL_SAND, Tool.SHOVEL),
        new Triplet<>(new Pair<>("Stone", "stone"), Blocks.STONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Stone Bricks", "stone_bricks"), Blocks.STONE_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Tuff", "tuff"), Blocks.TUFF, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Copper Block", "copper_block"), Blocks.COPPER_BLOCK, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Diamond Block", "diamond_block"), Blocks.DIAMOND_BLOCK, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Gold Block", "gold_block"), Blocks.GOLD_BLOCK, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Iron Block", "iron_block"), Blocks.IRON_BLOCK, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Lapis Block", "lapis_block"), Blocks.LAPIS_BLOCK, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Netherite Block", "netherite_block"), Blocks.NETHERITE_BLOCK, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Redstone Block", "redstone_block"), Blocks.REDSTONE_BLOCK, Tool.PICKAXE),
        new Triplet<>(new Pair<>("White Terracotta", "white_terracotta"), Blocks.WHITE_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Orange Terracotta", "orange_terracotta"), Blocks.ORANGE_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Magenta Terracotta", "magenta_terracotta"), Blocks.MAGENTA_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Light Blue Terracotta", "light_blue_terracotta"), Blocks.LIGHT_BLUE_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Yellow Terracotta", "yellow_terracotta"), Blocks.YELLOW_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Lime Terracotta", "lime_terracotta"), Blocks.LIME_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Pink Terracotta", "pink_terracotta"), Blocks.PINK_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Gray Terracotta", "gray_terracotta"), Blocks.GRAY_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Light Gray Terracotta", "light_gray_terracotta"), Blocks.LIGHT_GRAY_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Cyan Terracotta", "cyan_terracotta"), Blocks.CYAN_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Purple Terracotta", "purple_terracotta"), Blocks.PURPLE_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Blue Terracotta", "blue_terracotta"), Blocks.BLUE_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Brown Terracotta", "brown_terracotta"), Blocks.BROWN_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Green Terracotta", "green_terracotta"), Blocks.GREEN_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Red Terracotta", "red_terracotta"), Blocks.RED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Black Terracotta", "black_terracotta"), Blocks.BLACK_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("White Glazed Terracotta", "white_glazed_terracotta"), Blocks.WHITE_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Orange Glazed Terracotta", "orange_glazed_terracotta"), Blocks.ORANGE_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Magenta Glazed Terracotta", "magenta_glazed_terracotta"), Blocks.MAGENTA_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Light Blue Glazed Terracotta", "light_blue_glazed_terracotta"), Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Yellow Glazed Terracotta", "yellow_glazed_terracotta"), Blocks.YELLOW_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Lime Glazed Terracotta", "lime_glazed_terracotta"), Blocks.LIME_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Pink Glazed Terracotta", "pink_glazed_terracotta"), Blocks.PINK_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Gray Glazed Terracotta", "gray_glazed_terracotta"), Blocks.GRAY_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Light Gray Glazed Terracotta", "light_gray_glazed_terracotta"), Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Cyan Glazed Terracotta", "cyan_glazed_terracotta"), Blocks.CYAN_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Purple Glazed Terracotta", "purple_glazed_terracotta"), Blocks.PURPLE_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Blue Glazed Terracotta", "blue_glazed_terracotta"), Blocks.BLUE_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Brown Glazed Terracotta", "brown_glazed_terracotta"), Blocks.BROWN_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Green Glazed Terracotta", "green_glazed_terracotta"), Blocks.GREEN_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Red Glazed Terracotta", "red_glazed_terracotta"), Blocks.RED_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Black Glazed Terracotta", "black_glazed_terracotta"), Blocks.BLACK_GLAZED_TERRACOTTA, Tool.PICKAXE),
        new Triplet<>(new Pair<>("White Concrete", "white_concrete"), Blocks.WHITE_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Orange Concrete", "orange_concrete"), Blocks.ORANGE_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Magenta Concrete", "magenta_concrete"), Blocks.MAGENTA_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Light Blue Concrete", "light_blue_concrete"), Blocks.LIGHT_BLUE_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Yellow Concrete", "yellow_concrete"), Blocks.YELLOW_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Lime Concrete", "lime_concrete"), Blocks.LIME_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Pink Concrete", "pink_concrete"), Blocks.PINK_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Gray Concrete", "gray_concrete"), Blocks.GRAY_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Light Gray Concrete", "light_gray_concrete"), Blocks.LIGHT_GRAY_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Cyan Concrete", "cyan_concrete"), Blocks.CYAN_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Purple Concrete", "purple_concrete"), Blocks.PURPLE_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Blue Concrete", "blue_concrete"), Blocks.BLUE_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Brown Concrete", "brown_concrete"), Blocks.BROWN_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Green Concrete", "green_concrete"), Blocks.GREEN_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Red Concrete", "red_concrete"), Blocks.RED_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Black Concrete", "black_concrete"), Blocks.BLACK_CONCRETE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Acacia Planks", "acacia_planks"), Blocks.ACACIA_PLANKS, Tool.AXE),
        new Triplet<>(new Pair<>("Birch Planks", "birch_planks"), Blocks.BIRCH_PLANKS, Tool.AXE),
        new Triplet<>(new Pair<>("Cherry Planks", "cherry_planks"), Blocks.CHERRY_PLANKS, Tool.AXE),
        new Triplet<>(new Pair<>("Crimson Planks", "crimson_planks"), Blocks.CRIMSON_PLANKS, Tool.AXE),
        new Triplet<>(new Pair<>("Dark Oak Planks", "dark_oak_planks"), Blocks.DARK_OAK_PLANKS, Tool.AXE),
        new Triplet<>(new Pair<>("Jungle Planks", "jungle_planks"), Blocks.JUNGLE_PLANKS, Tool.AXE),
        new Triplet<>(new Pair<>("Mangrove Planks", "mangrove_planks"), Blocks.MANGROVE_PLANKS, Tool.AXE),
        new Triplet<>(new Pair<>("Oak Planks", "oak_planks"), Blocks.OAK_PLANKS, Tool.AXE),
        new Triplet<>(new Pair<>("Spruce Planks", "spruce_planks"), Blocks.SPRUCE_PLANKS, Tool.AXE),
        new Triplet<>(new Pair<>("Warped Planks", "warped_planks"), Blocks.WARPED_PLANKS, Tool.AXE)
    );

    static {
        MINEKEA_BLOCKS_TO_COMPRESS.forEach(data -> {
            String materialName = data.getA().getA();
            String textureKey = data.getA().getB();
            MinekeaBlock baseBlock = data.getB();
            Identifier baseBlockId = data.getC();
            Tool miningTool = data.getD();

            List<GenericCompressedBlock> compressedBlocks = new ArrayList<>();

            for (int i = 1; i <= 9; i += 1) {
                compressedBlocks.add(new CompressedMinekeaBlock(materialName, textureKey, baseBlock, i, baseBlockId, miningTool));
            }

            BLOCKS.addAll(compressedBlocks);
            BLOCK_MAP.put(materialName, compressedBlocks);
        });

        BLOCKS_TO_COMPRESS.forEach(data -> {
            String materialName = data.getA().getA();
            String textureKey = data.getA().getB();
            Block baseBlock = data.getB();
            Tool miningTool = data.getC();

            List<GenericCompressedBlock> compressedBlocks = new ArrayList<>();

            for (int i = 1; i <= 9; i += 1) {
                compressedBlocks.add(new GenericCompressedBlock(materialName, textureKey, baseBlock, i, miningTool));
            }

            BLOCKS.addAll(compressedBlocks);
            BLOCK_MAP.put(materialName, compressedBlocks);
        });

        COLUMN_BLOCKS_TO_COMPRESS.forEach(data -> {
            String materialName = data.getA().getA();
            String textureKey = data.getA().getB();
            Block baseBlock = data.getB();
            String textureKeySide = data.getC().getA();
            String textureKeyEnd = data.getC().getB();
            Tool tool = data.getD();

            List<GenericCompressedBlock> compressedBlocks = new ArrayList<>();

            for (int i = 1; i <= 9; i += 1) {
                compressedBlocks.add(new CompressedColumnBlock(materialName, textureKey, baseBlock, i, textureKeySide, textureKeyEnd, tool));
            }

            BLOCKS.addAll(compressedBlocks);
            BLOCK_MAP.put(materialName, compressedBlocks);
        });
    }

    @Override
    public void registerBlocks() {
        BLOCKS.forEach(GenericCompressedBlock::register);

        ItemGroupEvents.modifyEntriesEvent(MinekeaItemGroups.COMPRESSED_BLOCK_ITEM_GROUP_KEY)
            .register((itemGroup) -> BLOCKS.forEach(itemGroup::add));
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

        translationBuilder.add(TOOLTIP_LEVEL, "%dx Compressed");
        translationBuilder.add(TOOLTIP_COUNT, "(%s blocks)");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BLOCKS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BLOCKS.forEach(block -> block.configureItemModels(itemModelGenerator));
    }

    @Override
    public void generateTextures() {
        BLOCKS.forEach(GenericCompressedBlock::generateTextures);
    }
}
