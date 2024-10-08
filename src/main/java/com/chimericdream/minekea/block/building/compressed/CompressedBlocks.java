package com.chimericdream.minekea.block.building.compressed;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.BasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrackedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.CrimsonBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.MossyBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedBasaltBricksBlock;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
import com.chimericdream.minekea.item.MinekeaItemGroups;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
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
import oshi.util.tuples.Quartet;
import oshi.util.tuples.Quintet;
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

    protected static final List<Triplet<String, String, Block>> BLOCKS_TO_COMPRESS = new ArrayList<>();
    protected static final List<Quintet<String, String, Block, String, String>> COLUMN_BLOCKS_TO_COMPRESS = new ArrayList<>();
    protected static final List<Quartet<String, String, Block, Identifier>> MINEKEA_BLOCKS_TO_COMPRESS = new ArrayList<>();

    static {
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Amethyst", "amethyst_block", Blocks.AMETHYST_BLOCK));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Andesite", "andesite", Blocks.ANDESITE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Bricks", "bricks", Blocks.BRICKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Calcite", "calcite", Blocks.CALCITE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Clay", "clay", Blocks.CLAY));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Coarse Dirt", "coarse_dirt", Blocks.COARSE_DIRT));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Cobbled Deepslate", "cobbled_deepslate", Blocks.COBBLED_DEEPSLATE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Cobblestone", "cobblestone", Blocks.COBBLESTONE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Cracked Deepslate Bricks", "cracked_deepslate_bricks", Blocks.CRACKED_DEEPSLATE_BRICKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Cracked Deepslate Tiles", "cracked_deepslate_tiles", Blocks.CRACKED_DEEPSLATE_TILES));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Cracked Stone Bricks", "cracked_stone_bricks", Blocks.CRACKED_STONE_BRICKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Crying Obsidian", "crying_obsidian", Blocks.CRYING_OBSIDIAN));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Cut Red Sandstone", "cut_red_sandstone", Blocks.CUT_RED_SANDSTONE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Cut Sandstone", "cut_sandstone", Blocks.CUT_SANDSTONE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Dark Prismarine", "dark_prismarine", Blocks.DARK_PRISMARINE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Deepslate Bricks", "deepslate_bricks", Blocks.DEEPSLATE_BRICKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Deepslate Tiles", "deepslate_tiles", Blocks.DEEPSLATE_TILES));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Diorite", "diorite", Blocks.DIORITE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Dirt", "dirt", Blocks.DIRT));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("End Stone", "end_stone", Blocks.END_STONE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("End Stone Bricks", "end_stone_bricks", Blocks.END_STONE_BRICKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Granite", "granite", Blocks.GRANITE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Gravel", "gravel", Blocks.GRAVEL));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Mossy Cobblestone", "mossy_cobblestone", Blocks.MOSSY_COBBLESTONE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Mossy Stone Bricks", "mossy_stone_bricks", Blocks.MOSSY_STONE_BRICKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Mud", "mud", Blocks.MUD));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Mud Bricks", "mud_bricks", Blocks.MUD_BRICKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Netherrack", "netherrack", Blocks.NETHERRACK));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Nether Bricks", "nether_bricks", Blocks.NETHER_BRICKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Obsidian", "obsidian", Blocks.OBSIDIAN));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Packed Mud", "packed_mud", Blocks.PACKED_MUD));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Polished Andesite", "polished_andesite", Blocks.POLISHED_ANDESITE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Polished Blackstone", "polished_blackstone", Blocks.POLISHED_BLACKSTONE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Polished Blackstone Bricks", "polished_blackstone_bricks", Blocks.POLISHED_BLACKSTONE_BRICKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Polished Deepslate", "polished_deepslate", Blocks.POLISHED_DEEPSLATE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Polished Diorite", "polished_diorite", Blocks.POLISHED_DIORITE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Polished Granite", "polished_granite", Blocks.POLISHED_GRANITE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Prismarine", "prismarine", Blocks.PRISMARINE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Prismarine Bricks", "prismarine_bricks", Blocks.PRISMARINE_BRICKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Purpur", "purpur_block", Blocks.PURPUR_BLOCK));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Quartz Bricks", "quartz_bricks", Blocks.QUARTZ_BRICKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Red Nether Bricks", "red_nether_bricks", Blocks.RED_NETHER_BRICKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Red Sandstone", "red_sandstone", Blocks.RED_SANDSTONE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Red Sand", "red_sand", Blocks.RED_SAND));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Rooted Dirt", "rooted_dirt", Blocks.ROOTED_DIRT));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Sand", "sand", Blocks.SAND));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Sandstone", "sandstone", Blocks.SANDSTONE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Smooth Basalt", "smooth_basalt", Blocks.SMOOTH_BASALT));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Smooth Quartz", "quartz_block_bottom", Blocks.SMOOTH_QUARTZ));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Smooth Red Sandstone", "red_sandstone_top", Blocks.SMOOTH_RED_SANDSTONE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Smooth Sandstone", "sandstone_top", Blocks.SMOOTH_SANDSTONE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Smooth Stone", "smooth_stone", Blocks.SMOOTH_STONE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Soul Sand", "soul_sand", Blocks.SOUL_SAND));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Stone", "stone", Blocks.STONE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Stone Bricks", "stone_bricks", Blocks.STONE_BRICKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Tuff", "tuff", Blocks.TUFF));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Copper Block", "copper_block", Blocks.COPPER_BLOCK));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Diamond Block", "diamond_block", Blocks.DIAMOND_BLOCK));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Gold Block", "gold_block", Blocks.GOLD_BLOCK));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Iron Block", "iron_block", Blocks.IRON_BLOCK));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Lapis Block", "lapis_block", Blocks.LAPIS_BLOCK));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Netherite Block", "netherite_block", Blocks.NETHERITE_BLOCK));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Redstone Block", "redstone_block", Blocks.REDSTONE_BLOCK));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("White Terracotta", "white_terracotta", Blocks.WHITE_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Orange Terracotta", "orange_terracotta", Blocks.ORANGE_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Magenta Terracotta", "magenta_terracotta", Blocks.MAGENTA_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Light Blue Terracotta", "light_blue_terracotta", Blocks.LIGHT_BLUE_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Yellow Terracotta", "yellow_terracotta", Blocks.YELLOW_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Lime Terracotta", "lime_terracotta", Blocks.LIME_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Pink Terracotta", "pink_terracotta", Blocks.PINK_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Gray Terracotta", "gray_terracotta", Blocks.GRAY_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Light Gray Terracotta", "light_gray_terracotta", Blocks.LIGHT_GRAY_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Cyan Terracotta", "cyan_terracotta", Blocks.CYAN_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Purple Terracotta", "purple_terracotta", Blocks.PURPLE_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Blue Terracotta", "blue_terracotta", Blocks.BLUE_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Brown Terracotta", "brown_terracotta", Blocks.BROWN_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Green Terracotta", "green_terracotta", Blocks.GREEN_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Red Terracotta", "red_terracotta", Blocks.RED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Black Terracotta", "black_terracotta", Blocks.BLACK_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("White Glazed Terracotta", "white_glazed_terracotta", Blocks.WHITE_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Orange Glazed Terracotta", "orange_glazed_terracotta", Blocks.ORANGE_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Magenta Glazed Terracotta", "magenta_glazed_terracotta", Blocks.MAGENTA_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Light Blue Glazed Terracotta", "light_blue_glazed_terracotta", Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Yellow Glazed Terracotta", "yellow_glazed_terracotta", Blocks.YELLOW_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Lime Glazed Terracotta", "lime_glazed_terracotta", Blocks.LIME_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Pink Glazed Terracotta", "pink_glazed_terracotta", Blocks.PINK_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Gray Glazed Terracotta", "gray_glazed_terracotta", Blocks.GRAY_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Light Gray Glazed Terracotta", "light_gray_glazed_terracotta", Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Cyan Glazed Terracotta", "cyan_glazed_terracotta", Blocks.CYAN_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Purple Glazed Terracotta", "purple_glazed_terracotta", Blocks.PURPLE_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Blue Glazed Terracotta", "blue_glazed_terracotta", Blocks.BLUE_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Brown Glazed Terracotta", "brown_glazed_terracotta", Blocks.BROWN_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Green Glazed Terracotta", "green_glazed_terracotta", Blocks.GREEN_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Red Glazed Terracotta", "red_glazed_terracotta", Blocks.RED_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Black Glazed Terracotta", "black_glazed_terracotta", Blocks.BLACK_GLAZED_TERRACOTTA));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("White Concrete", "white_concrete", Blocks.WHITE_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Orange Concrete", "orange_concrete", Blocks.ORANGE_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Magenta Concrete", "magenta_concrete", Blocks.MAGENTA_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Light Blue Concrete", "light_blue_concrete", Blocks.LIGHT_BLUE_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Yellow Concrete", "yellow_concrete", Blocks.YELLOW_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Lime Concrete", "lime_concrete", Blocks.LIME_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Pink Concrete", "pink_concrete", Blocks.PINK_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Gray Concrete", "gray_concrete", Blocks.GRAY_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Light Gray Concrete", "light_gray_concrete", Blocks.LIGHT_GRAY_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Cyan Concrete", "cyan_concrete", Blocks.CYAN_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Purple Concrete", "purple_concrete", Blocks.PURPLE_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Blue Concrete", "blue_concrete", Blocks.BLUE_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Brown Concrete", "brown_concrete", Blocks.BROWN_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Green Concrete", "green_concrete", Blocks.GREEN_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Red Concrete", "red_concrete", Blocks.RED_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Black Concrete", "black_concrete", Blocks.BLACK_CONCRETE));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Acacia Planks", "acacia_planks", Blocks.ACACIA_PLANKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Birch Planks", "birch_planks", Blocks.BIRCH_PLANKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Cherry Planks", "cherry_planks", Blocks.CHERRY_PLANKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Crimson Planks", "crimson_planks", Blocks.CRIMSON_PLANKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Dark Oak Planks", "dark_oak_planks", Blocks.DARK_OAK_PLANKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Jungle Planks", "jungle_planks", Blocks.JUNGLE_PLANKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Mangrove Planks", "mangrove_planks", Blocks.MANGROVE_PLANKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Oak Planks", "oak_planks", Blocks.OAK_PLANKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Spruce Planks", "spruce_planks", Blocks.SPRUCE_PLANKS));
        BLOCKS_TO_COMPRESS.add(new Triplet<>("Warped Planks", "warped_planks", Blocks.WARPED_PLANKS));

        BLOCKS_TO_COMPRESS.forEach(data -> {
            String materialName = data.getA();
            String material = data.getB();
            Block ingredient = data.getC();

            List<GenericCompressedBlock> compressedBlocks = new ArrayList<>();

            for (int i = 1; i <= 9; i += 1) {
                compressedBlocks.add(new GenericCompressedBlock(new BlockConfig().material(material).materialName(materialName).ingredient(ingredient), i));
            }

            BLOCKS.addAll(compressedBlocks);
            BLOCK_MAP.put(materialName, compressedBlocks);
        });

        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Basalt", "basalt", Blocks.BASALT, "_side", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Blackstone", "blackstone", Blocks.BLACKSTONE, "", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Bone", "bone_block", Blocks.BONE_BLOCK, "_side", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Deepslate", "deepslate", Blocks.DEEPSLATE, "", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Polished Basalt", "polished_basalt", Blocks.POLISHED_BASALT, "_side", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Purpur Pillar", "purpur_pillar", Blocks.PURPUR_PILLAR, "", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Quartz", "quartz_block", Blocks.QUARTZ_BLOCK, "_side", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Acacia Log", "acacia_log", Blocks.ACACIA_LOG, "", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Birch Log", "birch_log", Blocks.BIRCH_LOG, "", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Cherry Log", "cherry_log", Blocks.CHERRY_LOG, "", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Crimson Stem", "crimson_stem", Blocks.CRIMSON_STEM, "", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Dark Oak Log", "dark_oak_log", Blocks.DARK_OAK_LOG, "", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Jungle Log", "jungle_log", Blocks.JUNGLE_LOG, "", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Mangrove Log", "mangrove_log", Blocks.MANGROVE_LOG, "", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Oak Log", "oak_log", Blocks.OAK_LOG, "", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Spruce Log", "spruce_log", Blocks.SPRUCE_LOG, "", "_top"));
        COLUMN_BLOCKS_TO_COMPRESS.add(new Quintet<>("Warped Stem", "warped_stem", Blocks.WARPED_STEM, "", "_top"));

        COLUMN_BLOCKS_TO_COMPRESS.forEach(data -> {
            String materialName = data.getA();
            String material = data.getB();
            Block ingredient = data.getC();
            String sideTextureSuffix = data.getD();
            String endTextureSuffix = data.getE();

            List<GenericCompressedBlock> compressedBlocks = new ArrayList<>();

            for (int i = 1; i <= 9; i += 1) {
                compressedBlocks.add(new CompressedColumnBlock(new BlockConfig().material(material).materialName(materialName).ingredient(ingredient), i, sideTextureSuffix, endTextureSuffix));
            }

            BLOCKS.addAll(compressedBlocks);
            BLOCK_MAP.put(materialName, compressedBlocks);
        });

        MINEKEA_BLOCKS_TO_COMPRESS.add(new Quartet<>("Basalt Brick", "basalt_brick", BuildingBlocks.BASALT_BRICKS_BLOCK, BasaltBricksBlock.BLOCK_ID));
        MINEKEA_BLOCKS_TO_COMPRESS.add(new Quartet<>("Cracked Basalt Bricks", "cracked_basalt_brick", BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK, CrackedBasaltBricksBlock.BLOCK_ID));
        MINEKEA_BLOCKS_TO_COMPRESS.add(new Quartet<>("Crimson Basalt Bricks", "crimson_basalt_brick", BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK, CrimsonBasaltBricksBlock.BLOCK_ID));
        MINEKEA_BLOCKS_TO_COMPRESS.add(new Quartet<>("Mossy Basalt Brick", "mossy_basalt_brick", BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK, MossyBasaltBricksBlock.BLOCK_ID));
        MINEKEA_BLOCKS_TO_COMPRESS.add(new Quartet<>("Warped Basalt Brick", "warped_basalt_brick", BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK, WarpedBasaltBricksBlock.BLOCK_ID));
        MINEKEA_BLOCKS_TO_COMPRESS.add(new Quartet<>("Warped Nether Brick", "warped_nether_brick", BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK, WarpedNetherBricksBlock.BLOCK_ID));

        MINEKEA_BLOCKS_TO_COMPRESS.forEach(data -> {
            String materialName = data.getA();
            String material = data.getB();
            Block ingredient = data.getC();
            Identifier baseBlockId = data.getD();

            List<GenericCompressedBlock> compressedBlocks = new ArrayList<>();

            for (int i = 1; i <= 9; i += 1) {
                compressedBlocks.add(new CompressedMinekeaBlock(new BlockConfig().material(material).materialName(materialName).ingredient(ingredient), i, baseBlockId));
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
