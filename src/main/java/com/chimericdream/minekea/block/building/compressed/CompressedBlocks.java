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

    protected static final List<Quartet<String, String, MinekeaBlock, Identifier>> MINEKEA_BLOCKS_TO_COMPRESS = List.of(
        new Quartet<>("Basalt Brick", "basalt_brick", BuildingBlocks.BASALT_BRICKS_BLOCK, BasaltBricksBlock.BLOCK_ID),
        new Quartet<>("Cracked Basalt Bricks", "cracked_basalt_brick", BuildingBlocks.CRACKED_BASALT_BRICKS_BLOCK, CrackedBasaltBricksBlock.BLOCK_ID),
        new Quartet<>("Crimson Basalt Bricks", "crimson_basalt_brick", BuildingBlocks.CRIMSON_BASALT_BRICKS_BLOCK, CrimsonBasaltBricksBlock.BLOCK_ID),
        new Quartet<>("Mossy Basalt Brick", "mossy_basalt_brick", BuildingBlocks.MOSSY_BASALT_BRICKS_BLOCK, MossyBasaltBricksBlock.BLOCK_ID),
        new Quartet<>("Warped Basalt Brick", "warped_basalt_brick", BuildingBlocks.WARPED_BASALT_BRICKS_BLOCK, WarpedBasaltBricksBlock.BLOCK_ID),
        new Quartet<>("Warped Nether Brick", "warped_nether_brick", BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK, WarpedNetherBricksBlock.BLOCK_ID)
    );

    protected static final List<Quintet<String, String, Block, String, String>> COLUMN_BLOCKS_TO_COMPRESS = List.of(
        new Quintet<>("Basalt", "basalt", Blocks.BASALT, "_side", "_top"),
        new Quintet<>("Blackstone", "blackstone", Blocks.BLACKSTONE, "", "_top"),
        new Quintet<>("Bone", "bone_block", Blocks.BONE_BLOCK, "_side", "_top"),
        new Quintet<>("Deepslate", "deepslate", Blocks.DEEPSLATE, "", "_top"),
        new Quintet<>("Polished Basalt", "polished_basalt", Blocks.POLISHED_BASALT, "_side", "_top"),
        new Quintet<>("Purpur Pillar", "purpur_pillar", Blocks.PURPUR_PILLAR, "", "_top"),
        new Quintet<>("Quartz", "quartz_block", Blocks.QUARTZ_BLOCK, "_side", "_top"),
        new Quintet<>("Acacia Log", "acacia_log", Blocks.ACACIA_LOG, "", "_top"),
        new Quintet<>("Birch Log", "birch_log", Blocks.BIRCH_LOG, "", "_top"),
        new Quintet<>("Cherry Log", "cherry_log", Blocks.CHERRY_LOG, "", "_top"),
        new Quintet<>("Crimson Stem", "crimson_stem", Blocks.CRIMSON_STEM, "", "_top"),
        new Quintet<>("Dark Oak Log", "dark_oak_log", Blocks.DARK_OAK_LOG, "", "_top"),
        new Quintet<>("Jungle Log", "jungle_log", Blocks.JUNGLE_LOG, "", "_top"),
        new Quintet<>("Mangrove Log", "mangrove_log", Blocks.MANGROVE_LOG, "", "_top"),
        new Quintet<>("Oak Log", "oak_log", Blocks.OAK_LOG, "", "_top"),
        new Quintet<>("Spruce Log", "spruce_log", Blocks.SPRUCE_LOG, "", "_top"),
        new Quintet<>("Warped Stem", "warped_stem", Blocks.WARPED_STEM, "", "_top")
    );

    protected static final List<Triplet<String, String, Block>> BLOCKS_TO_COMPRESS = List.of(
        new Triplet<>("Amethyst", "amethyst_block", Blocks.AMETHYST_BLOCK),
        new Triplet<>("Andesite", "andesite", Blocks.ANDESITE),
        new Triplet<>("Bricks", "bricks", Blocks.BRICKS),
        new Triplet<>("Calcite", "calcite", Blocks.CALCITE),
        new Triplet<>("Clay", "clay", Blocks.CLAY),
        new Triplet<>("Coarse Dirt", "coarse_dirt", Blocks.COARSE_DIRT),
        new Triplet<>("Cobbled Deepslate", "cobbled_deepslate", Blocks.COBBLED_DEEPSLATE),
        new Triplet<>("Cobblestone", "cobblestone", Blocks.COBBLESTONE),
        new Triplet<>("Cracked Deepslate Bricks", "cracked_deepslate_bricks", Blocks.CRACKED_DEEPSLATE_BRICKS),
        new Triplet<>("Cracked Deepslate Tiles", "cracked_deepslate_tiles", Blocks.CRACKED_DEEPSLATE_TILES),
        new Triplet<>("Cracked Stone Bricks", "cracked_stone_bricks", Blocks.CRACKED_STONE_BRICKS),
        new Triplet<>("Crying Obsidian", "crying_obsidian", Blocks.CRYING_OBSIDIAN),
        new Triplet<>("Cut Red Sandstone", "cut_red_sandstone", Blocks.CUT_RED_SANDSTONE),
        new Triplet<>("Cut Sandstone", "cut_sandstone", Blocks.CUT_SANDSTONE),
        new Triplet<>("Dark Prismarine", "dark_prismarine", Blocks.DARK_PRISMARINE),
        new Triplet<>("Deepslate Bricks", "deepslate_bricks", Blocks.DEEPSLATE_BRICKS),
        new Triplet<>("Deepslate Tiles", "deepslate_tiles", Blocks.DEEPSLATE_TILES),
        new Triplet<>("Diorite", "diorite", Blocks.DIORITE),
        new Triplet<>("Dirt", "dirt", Blocks.DIRT),
        new Triplet<>("End Stone", "end_stone", Blocks.END_STONE),
        new Triplet<>("End Stone Bricks", "end_stone_bricks", Blocks.END_STONE_BRICKS),
        new Triplet<>("Granite", "granite", Blocks.GRANITE),
        new Triplet<>("Gravel", "gravel", Blocks.GRAVEL),
        new Triplet<>("Mossy Cobblestone", "mossy_cobblestone", Blocks.MOSSY_COBBLESTONE),
        new Triplet<>("Mossy Stone Bricks", "mossy_stone_bricks", Blocks.MOSSY_STONE_BRICKS),
        new Triplet<>("Mud", "mud", Blocks.MUD),
        new Triplet<>("Mud Bricks", "mud_bricks", Blocks.MUD_BRICKS),
        new Triplet<>("Netherrack", "netherrack", Blocks.NETHERRACK),
        new Triplet<>("Nether Bricks", "nether_bricks", Blocks.NETHER_BRICKS),
        new Triplet<>("Obsidian", "obsidian", Blocks.OBSIDIAN),
        new Triplet<>("Packed Mud", "packed_mud", Blocks.PACKED_MUD),
        new Triplet<>("Polished Andesite", "polished_andesite", Blocks.POLISHED_ANDESITE),
        new Triplet<>("Polished Blackstone", "polished_blackstone", Blocks.POLISHED_BLACKSTONE),
        new Triplet<>("Polished Blackstone Bricks", "polished_blackstone_bricks", Blocks.POLISHED_BLACKSTONE_BRICKS),
        new Triplet<>("Polished Deepslate", "polished_deepslate", Blocks.POLISHED_DEEPSLATE),
        new Triplet<>("Polished Diorite", "polished_diorite", Blocks.POLISHED_DIORITE),
        new Triplet<>("Polished Granite", "polished_granite", Blocks.POLISHED_GRANITE),
        new Triplet<>("Prismarine", "prismarine", Blocks.PRISMARINE),
        new Triplet<>("Prismarine Bricks", "prismarine_bricks", Blocks.PRISMARINE_BRICKS),
        new Triplet<>("Purpur", "purpur_block", Blocks.PURPUR_BLOCK),
        new Triplet<>("Quartz Bricks", "quartz_bricks", Blocks.QUARTZ_BRICKS),
        new Triplet<>("Red Nether Bricks", "red_nether_bricks", Blocks.RED_NETHER_BRICKS),
        new Triplet<>("Red Sandstone", "red_sandstone", Blocks.RED_SANDSTONE),
        new Triplet<>("Red Sand", "red_sand", Blocks.RED_SAND),
        new Triplet<>("Rooted Dirt", "rooted_dirt", Blocks.ROOTED_DIRT),
        new Triplet<>("Sand", "sand", Blocks.SAND),
        new Triplet<>("Sandstone", "sandstone", Blocks.SANDSTONE),
        new Triplet<>("Smooth Basalt", "smooth_basalt", Blocks.SMOOTH_BASALT),
        new Triplet<>("Smooth Quartz", "quartz_block_bottom", Blocks.SMOOTH_QUARTZ),
        new Triplet<>("Smooth Red Sandstone", "red_sandstone_top", Blocks.SMOOTH_RED_SANDSTONE),
        new Triplet<>("Smooth Sandstone", "sandstone_top", Blocks.SMOOTH_SANDSTONE),
        new Triplet<>("Smooth Stone", "smooth_stone", Blocks.SMOOTH_STONE),
        new Triplet<>("Soul Sand", "soul_sand", Blocks.SOUL_SAND),
        new Triplet<>("Stone", "stone", Blocks.STONE),
        new Triplet<>("Stone Bricks", "stone_bricks", Blocks.STONE_BRICKS),
        new Triplet<>("Tuff", "tuff", Blocks.TUFF),
        new Triplet<>("Copper Block", "copper_block", Blocks.COPPER_BLOCK),
        new Triplet<>("Diamond Block", "diamond_block", Blocks.DIAMOND_BLOCK),
        new Triplet<>("Gold Block", "gold_block", Blocks.GOLD_BLOCK),
        new Triplet<>("Iron Block", "iron_block", Blocks.IRON_BLOCK),
        new Triplet<>("Lapis Block", "lapis_block", Blocks.LAPIS_BLOCK),
        new Triplet<>("Netherite Block", "netherite_block", Blocks.NETHERITE_BLOCK),
        new Triplet<>("Redstone Block", "redstone_block", Blocks.REDSTONE_BLOCK),
        new Triplet<>("White Terracotta", "white_terracotta", Blocks.WHITE_TERRACOTTA),
        new Triplet<>("Orange Terracotta", "orange_terracotta", Blocks.ORANGE_TERRACOTTA),
        new Triplet<>("Magenta Terracotta", "magenta_terracotta", Blocks.MAGENTA_TERRACOTTA),
        new Triplet<>("Light Blue Terracotta", "light_blue_terracotta", Blocks.LIGHT_BLUE_TERRACOTTA),
        new Triplet<>("Yellow Terracotta", "yellow_terracotta", Blocks.YELLOW_TERRACOTTA),
        new Triplet<>("Lime Terracotta", "lime_terracotta", Blocks.LIME_TERRACOTTA),
        new Triplet<>("Pink Terracotta", "pink_terracotta", Blocks.PINK_TERRACOTTA),
        new Triplet<>("Gray Terracotta", "gray_terracotta", Blocks.GRAY_TERRACOTTA),
        new Triplet<>("Light Gray Terracotta", "light_gray_terracotta", Blocks.LIGHT_GRAY_TERRACOTTA),
        new Triplet<>("Cyan Terracotta", "cyan_terracotta", Blocks.CYAN_TERRACOTTA),
        new Triplet<>("Purple Terracotta", "purple_terracotta", Blocks.PURPLE_TERRACOTTA),
        new Triplet<>("Blue Terracotta", "blue_terracotta", Blocks.BLUE_TERRACOTTA),
        new Triplet<>("Brown Terracotta", "brown_terracotta", Blocks.BROWN_TERRACOTTA),
        new Triplet<>("Green Terracotta", "green_terracotta", Blocks.GREEN_TERRACOTTA),
        new Triplet<>("Red Terracotta", "red_terracotta", Blocks.RED_TERRACOTTA),
        new Triplet<>("Black Terracotta", "black_terracotta", Blocks.BLACK_TERRACOTTA),
        new Triplet<>("White Glazed Terracotta", "white_glazed_terracotta", Blocks.WHITE_GLAZED_TERRACOTTA),
        new Triplet<>("Orange Glazed Terracotta", "orange_glazed_terracotta", Blocks.ORANGE_GLAZED_TERRACOTTA),
        new Triplet<>("Magenta Glazed Terracotta", "magenta_glazed_terracotta", Blocks.MAGENTA_GLAZED_TERRACOTTA),
        new Triplet<>("Light Blue Glazed Terracotta", "light_blue_glazed_terracotta", Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA),
        new Triplet<>("Yellow Glazed Terracotta", "yellow_glazed_terracotta", Blocks.YELLOW_GLAZED_TERRACOTTA),
        new Triplet<>("Lime Glazed Terracotta", "lime_glazed_terracotta", Blocks.LIME_GLAZED_TERRACOTTA),
        new Triplet<>("Pink Glazed Terracotta", "pink_glazed_terracotta", Blocks.PINK_GLAZED_TERRACOTTA),
        new Triplet<>("Gray Glazed Terracotta", "gray_glazed_terracotta", Blocks.GRAY_GLAZED_TERRACOTTA),
        new Triplet<>("Light Gray Glazed Terracotta", "light_gray_glazed_terracotta", Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA),
        new Triplet<>("Cyan Glazed Terracotta", "cyan_glazed_terracotta", Blocks.CYAN_GLAZED_TERRACOTTA),
        new Triplet<>("Purple Glazed Terracotta", "purple_glazed_terracotta", Blocks.PURPLE_GLAZED_TERRACOTTA),
        new Triplet<>("Blue Glazed Terracotta", "blue_glazed_terracotta", Blocks.BLUE_GLAZED_TERRACOTTA),
        new Triplet<>("Brown Glazed Terracotta", "brown_glazed_terracotta", Blocks.BROWN_GLAZED_TERRACOTTA),
        new Triplet<>("Green Glazed Terracotta", "green_glazed_terracotta", Blocks.GREEN_GLAZED_TERRACOTTA),
        new Triplet<>("Red Glazed Terracotta", "red_glazed_terracotta", Blocks.RED_GLAZED_TERRACOTTA),
        new Triplet<>("Black Glazed Terracotta", "black_glazed_terracotta", Blocks.BLACK_GLAZED_TERRACOTTA),
        new Triplet<>("White Concrete", "white_concrete", Blocks.WHITE_CONCRETE),
        new Triplet<>("Orange Concrete", "orange_concrete", Blocks.ORANGE_CONCRETE),
        new Triplet<>("Magenta Concrete", "magenta_concrete", Blocks.MAGENTA_CONCRETE),
        new Triplet<>("Light Blue Concrete", "light_blue_concrete", Blocks.LIGHT_BLUE_CONCRETE),
        new Triplet<>("Yellow Concrete", "yellow_concrete", Blocks.YELLOW_CONCRETE),
        new Triplet<>("Lime Concrete", "lime_concrete", Blocks.LIME_CONCRETE),
        new Triplet<>("Pink Concrete", "pink_concrete", Blocks.PINK_CONCRETE),
        new Triplet<>("Gray Concrete", "gray_concrete", Blocks.GRAY_CONCRETE),
        new Triplet<>("Light Gray Concrete", "light_gray_concrete", Blocks.LIGHT_GRAY_CONCRETE),
        new Triplet<>("Cyan Concrete", "cyan_concrete", Blocks.CYAN_CONCRETE),
        new Triplet<>("Purple Concrete", "purple_concrete", Blocks.PURPLE_CONCRETE),
        new Triplet<>("Blue Concrete", "blue_concrete", Blocks.BLUE_CONCRETE),
        new Triplet<>("Brown Concrete", "brown_concrete", Blocks.BROWN_CONCRETE),
        new Triplet<>("Green Concrete", "green_concrete", Blocks.GREEN_CONCRETE),
        new Triplet<>("Red Concrete", "red_concrete", Blocks.RED_CONCRETE),
        new Triplet<>("Black Concrete", "black_concrete", Blocks.BLACK_CONCRETE),
        new Triplet<>("Acacia Planks", "acacia_planks", Blocks.ACACIA_PLANKS),
        new Triplet<>("Birch Planks", "birch_planks", Blocks.BIRCH_PLANKS),
        new Triplet<>("Cherry Planks", "cherry_planks", Blocks.CHERRY_PLANKS),
        new Triplet<>("Crimson Planks", "crimson_planks", Blocks.CRIMSON_PLANKS),
        new Triplet<>("Dark Oak Planks", "dark_oak_planks", Blocks.DARK_OAK_PLANKS),
        new Triplet<>("Jungle Planks", "jungle_planks", Blocks.JUNGLE_PLANKS),
        new Triplet<>("Mangrove Planks", "mangrove_planks", Blocks.MANGROVE_PLANKS),
        new Triplet<>("Oak Planks", "oak_planks", Blocks.OAK_PLANKS),
        new Triplet<>("Spruce Planks", "spruce_planks", Blocks.SPRUCE_PLANKS),
        new Triplet<>("Warped Planks", "warped_planks", Blocks.WARPED_PLANKS)
    );

    static {
        MINEKEA_BLOCKS_TO_COMPRESS.forEach(data -> {
            String materialName = data.getA();
            String textureKey = data.getB();
            MinekeaBlock baseBlock = data.getC();
            Identifier baseBlockId = data.getD();

            List<GenericCompressedBlock> compressedBlocks = new ArrayList<>();

            for (int i = 1; i <= 9; i += 1) {
                compressedBlocks.add(new CompressedMinekeaBlock(materialName, textureKey, baseBlock, i, baseBlockId));
            }

            BLOCKS.addAll(compressedBlocks);
            BLOCK_MAP.put(materialName, compressedBlocks);
        });

        BLOCKS_TO_COMPRESS.forEach(data -> {
            String materialName = data.getA();
            String textureKey = data.getB();
            Block baseBlock = data.getC();

            List<GenericCompressedBlock> compressedBlocks = new ArrayList<>();

            for (int i = 1; i <= 9; i += 1) {
                compressedBlocks.add(new GenericCompressedBlock(materialName, textureKey, baseBlock, i));
            }

            BLOCKS.addAll(compressedBlocks);
            BLOCK_MAP.put(materialName, compressedBlocks);
        });

        COLUMN_BLOCKS_TO_COMPRESS.forEach(data -> {
            String materialName = data.getA();
            String textureKey = data.getB();
            Block baseBlock = data.getC();
            String textureKeySide = data.getD();
            String textureKeyEnd = data.getE();

            List<GenericCompressedBlock> compressedBlocks = new ArrayList<>();

            for (int i = 1; i <= 9; i += 1) {
                compressedBlocks.add(new CompressedColumnBlock(materialName, textureKey, baseBlock, i, textureKeySide, textureKeyEnd));
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
