package com.chimericdream.minekea.block.building.covers;

import com.chimericdream.minekea.block.building.covers.GenericCoverBlock.CoverSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;

import java.util.List;

public class Covers implements MinekeaBlockCategory {
    public static final GenericCoverBlock AMETHYST_COVER;
    public static final GenericCoverBlock ANDESITE_COVER;
    public static final GenericCoverBlock BASALT_BRICK_COVER;
    public static final GenericCoverBlock BASALT_COVER;
    public static final GenericCoverBlock BLACKSTONE_COVER;
    public static final GenericCoverBlock BONE_COVER;
    public static final GenericCoverBlock BRICK_COVER;
    public static final GenericCoverBlock CALCITE_COVER;
    public static final GenericCoverBlock COBBLED_DEEPSLATE_COVER;
    public static final GenericCoverBlock COBBLED_END_STONE_COVER;
    public static final GenericCoverBlock COBBLESTONE_COVER;
    public static final GenericCoverBlock CRACKED_BASALT_BRICK_COVER;
    public static final GenericCoverBlock CRACKED_DEEPSLATE_BRICK_COVER;
    public static final GenericCoverBlock CRACKED_DEEPSLATE_TILE_COVER;
    public static final GenericCoverBlock CRACKED_STONE_BRICK_COVER;
    public static final GenericCoverBlock CRIMSON_BASALT_BRICK_COVER;
    public static final GenericCoverBlock CRYING_OBSIDIAN_COVER;
    public static final GenericCoverBlock CUT_RED_SANDSTONE_COVER;
    public static final GenericCoverBlock CUT_SANDSTONE_COVER;
    public static final GenericCoverBlock DARK_PRISMARINE_COVER;
    public static final GenericCoverBlock DEEPSLATE_BRICK_COVER;
    public static final GenericCoverBlock DEEPSLATE_COVER;
    public static final GenericCoverBlock DEEPSLATE_TILE_COVER;
    public static final GenericCoverBlock DIORITE_COVER;
    public static final GenericCoverBlock END_STONE_BRICK_COVER;
    public static final GenericCoverBlock END_STONE_COVER;
    public static final GenericCoverBlock GRANITE_COVER;
    public static final GenericCoverBlock MOSSY_BASALT_BRICK_COVER;
    public static final GenericCoverBlock MOSSY_COBBLESTONE_COVER;
    public static final GenericCoverBlock MOSSY_STONE_BRICK_COVER;
    public static final GenericCoverBlock NETHERRACK_COVER;
    public static final GenericCoverBlock NETHER_BRICK_COVER;
    public static final GenericCoverBlock OBSIDIAN_COVER;
    public static final GenericCoverBlock POLISHED_ANDESITE_COVER;
    public static final GenericCoverBlock POLISHED_BASALT_COVER;
    public static final GenericCoverBlock POLISHED_BLACKSTONE_BRICK_COVER;
    public static final GenericCoverBlock POLISHED_BLACKSTONE_COVER;
    public static final GenericCoverBlock POLISHED_DEEPSLATE_COVER;
    public static final GenericCoverBlock POLISHED_DIORITE_COVER;
    public static final GenericCoverBlock POLISHED_GRANITE_COVER;
    public static final GenericCoverBlock PRISMARINE_BRICK_COVER;
    public static final GenericCoverBlock PRISMARINE_COVER;
    public static final GenericCoverBlock PURPUR_COVER;
    public static final GenericCoverBlock PURPUR_PILLAR_COVER;
    public static final GenericCoverBlock RED_NETHER_BRICK_COVER;
    public static final GenericCoverBlock RED_SANDSTONE_COVER;
    public static final GenericCoverBlock SANDSTONE_COVER;
    public static final GenericCoverBlock SMOOTH_BASALT_COVER;
    public static final GenericCoverBlock SMOOTH_RED_SANDSTONE_COVER;
    public static final GenericCoverBlock SMOOTH_SANDSTONE_COVER;
    public static final GenericCoverBlock SMOOTH_STONE_COVER;
    public static final GenericCoverBlock STONE_BRICK_COVER;
    public static final GenericCoverBlock STONE_COVER;
    public static final GenericCoverBlock TUFF_COVER;
    public static final GenericCoverBlock WARPED_BASALT_BRICK_COVER;
    public static final GenericCoverBlock WARPED_NETHER_BRICK_COVER;

    public static final GenericCoverBlock WHITE_TERRACOTTA_COVER;
    public static final GenericCoverBlock ORANGE_TERRACOTTA_COVER;
    public static final GenericCoverBlock MAGENTA_TERRACOTTA_COVER;
    public static final GenericCoverBlock LIGHT_BLUE_TERRACOTTA_COVER;
    public static final GenericCoverBlock YELLOW_TERRACOTTA_COVER;
    public static final GenericCoverBlock LIME_TERRACOTTA_COVER;
    public static final GenericCoverBlock PINK_TERRACOTTA_COVER;
    public static final GenericCoverBlock GRAY_TERRACOTTA_COVER;
    public static final GenericCoverBlock LIGHT_GRAY_TERRACOTTA_COVER;
    public static final GenericCoverBlock CYAN_TERRACOTTA_COVER;
    public static final GenericCoverBlock PURPLE_TERRACOTTA_COVER;
    public static final GenericCoverBlock BLUE_TERRACOTTA_COVER;
    public static final GenericCoverBlock BROWN_TERRACOTTA_COVER;
    public static final GenericCoverBlock GREEN_TERRACOTTA_COVER;
    public static final GenericCoverBlock RED_TERRACOTTA_COVER;
    public static final GenericCoverBlock BLACK_TERRACOTTA_COVER;

    public static final GenericCoverBlock WHITE_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock ORANGE_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock MAGENTA_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock LIGHT_BLUE_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock YELLOW_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock LIME_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock PINK_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock GRAY_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock LIGHT_GRAY_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock CYAN_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock PURPLE_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock BLUE_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock BROWN_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock GREEN_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock RED_GLAZED_TERRACOTTA_COVER;
    public static final GenericCoverBlock BLACK_GLAZED_TERRACOTTA_COVER;

    public static final GenericCoverBlock WHITE_CONCRETE_COVER;
    public static final GenericCoverBlock ORANGE_CONCRETE_COVER;
    public static final GenericCoverBlock MAGENTA_CONCRETE_COVER;
    public static final GenericCoverBlock LIGHT_BLUE_CONCRETE_COVER;
    public static final GenericCoverBlock YELLOW_CONCRETE_COVER;
    public static final GenericCoverBlock LIME_CONCRETE_COVER;
    public static final GenericCoverBlock PINK_CONCRETE_COVER;
    public static final GenericCoverBlock GRAY_CONCRETE_COVER;
    public static final GenericCoverBlock LIGHT_GRAY_CONCRETE_COVER;
    public static final GenericCoverBlock CYAN_CONCRETE_COVER;
    public static final GenericCoverBlock PURPLE_CONCRETE_COVER;
    public static final GenericCoverBlock BLUE_CONCRETE_COVER;
    public static final GenericCoverBlock BROWN_CONCRETE_COVER;
    public static final GenericCoverBlock GREEN_CONCRETE_COVER;
    public static final GenericCoverBlock RED_CONCRETE_COVER;
    public static final GenericCoverBlock BLACK_CONCRETE_COVER;

    public static final GenericCoverBlock ACACIA_LOG_COVER;
    public static final GenericCoverBlock ACACIA_PLANK_COVER;
    public static final GenericCoverBlock BIRCH_LOG_COVER;
    public static final GenericCoverBlock BIRCH_PLANK_COVER;
    public static final GenericCoverBlock CRIMSON_PLANK_COVER;
    public static final GenericCoverBlock CRIMSON_STEM_COVER;
    public static final GenericCoverBlock DARK_OAK_LOG_COVER;
    public static final GenericCoverBlock DARK_OAK_PLANK_COVER;
    public static final GenericCoverBlock JUNGLE_LOG_COVER;
    public static final GenericCoverBlock JUNGLE_PLANK_COVER;
    public static final GenericCoverBlock OAK_LOG_COVER;
    public static final GenericCoverBlock OAK_PLANK_COVER;
    public static final GenericCoverBlock SPRUCE_LOG_COVER;
    public static final GenericCoverBlock SPRUCE_PLANK_COVER;
    public static final GenericCoverBlock WARPED_PLANK_COVER;
    public static final GenericCoverBlock WARPED_STEM_COVER;

    static {
        AMETHYST_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.AMETHYST));
        ANDESITE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.ANDESITE));
        BASALT_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BASALT));
        BASALT_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BASALT_BRICK));
        BLACKSTONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BLACKSTONE));
        BONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BONE));
        BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BRICK));
        CALCITE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CALCITE));
        COBBLED_DEEPSLATE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.COBBLED_DEEPSLATE));
        COBBLED_END_STONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.COBBLED_END_STONE));
        COBBLESTONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.COBBLESTONE));
        CRACKED_BASALT_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CRACKED_BASALT_BRICK));
        CRACKED_DEEPSLATE_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CRACKED_DEEPSLATE_BRICK));
        CRACKED_DEEPSLATE_TILE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CRACKED_DEEPSLATE_TILE));
        CRACKED_STONE_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CRACKED_STONE_BRICK));
        CRIMSON_BASALT_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CRIMSON_BASALT_BRICK));
        CRYING_OBSIDIAN_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CRYING_OBSIDIAN));
        CUT_RED_SANDSTONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CUT_RED_SANDSTONE));
        CUT_SANDSTONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CUT_SANDSTONE));
        DARK_PRISMARINE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.DARK_PRISMARINE));
        DEEPSLATE_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.DEEPSLATE_BRICK));
        DEEPSLATE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.DEEPSLATE));
        DEEPSLATE_TILE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.DEEPSLATE_TILE));
        DIORITE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.DIORITE));
        END_STONE_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.END_STONE_BRICK));
        END_STONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.END_STONE));
        GRANITE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.GRANITE));
        MOSSY_BASALT_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.MOSSY_BASALT_BRICK));
        MOSSY_COBBLESTONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.MOSSY_COBBLESTONE));
        MOSSY_STONE_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.MOSSY_STONE_BRICK));
        NETHERRACK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.NETHERRACK));
        NETHER_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.NETHER_BRICK));
        OBSIDIAN_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.OBSIDIAN));
        POLISHED_ANDESITE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.POLISHED_ANDESITE));
        POLISHED_BASALT_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.POLISHED_BASALT));
        POLISHED_BLACKSTONE_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.POLISHED_BLACKSTONE_BRICK));
        POLISHED_BLACKSTONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.POLISHED_BLACKSTONE));
        POLISHED_DEEPSLATE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.POLISHED_DEEPSLATE));
        POLISHED_DIORITE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.POLISHED_DIORITE));
        POLISHED_GRANITE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.POLISHED_GRANITE));
        PRISMARINE_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.PRISMARINE_BRICK));
        PRISMARINE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.PRISMARINE));
        PURPUR_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.PURPUR));
        PURPUR_PILLAR_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.PURPUR_PILLAR));
        RED_NETHER_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.RED_NETHER_BRICK));
        RED_SANDSTONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.RED_SANDSTONE));
        SANDSTONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.SANDSTONE));
        SMOOTH_BASALT_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.SMOOTH_BASALT));
        SMOOTH_RED_SANDSTONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.SMOOTH_RED_SANDSTONE));
        SMOOTH_SANDSTONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.SMOOTH_SANDSTONE));
        SMOOTH_STONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.SMOOTH_STONE));
        STONE_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.STONE_BRICK));
        STONE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.STONE));
        TUFF_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.TUFF));
        WARPED_BASALT_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.WARPED_BASALT_BRICK));
        WARPED_NETHER_BRICK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.WARPED_NETHER_BRICK));

        WHITE_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.WHITE_TERRACOTTA));
        ORANGE_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.ORANGE_TERRACOTTA));
        MAGENTA_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.MAGENTA_TERRACOTTA));
        LIGHT_BLUE_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.LIGHT_BLUE_TERRACOTTA));
        YELLOW_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.YELLOW_TERRACOTTA));
        LIME_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.LIME_TERRACOTTA));
        PINK_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.PINK_TERRACOTTA));
        GRAY_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.GRAY_TERRACOTTA));
        LIGHT_GRAY_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.LIGHT_GRAY_TERRACOTTA));
        CYAN_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CYAN_TERRACOTTA));
        PURPLE_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.PURPLE_TERRACOTTA));
        BLUE_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BLUE_TERRACOTTA));
        BROWN_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BROWN_TERRACOTTA));
        GREEN_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.GREEN_TERRACOTTA));
        RED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.RED_TERRACOTTA));
        BLACK_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BLACK_TERRACOTTA));

        WHITE_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.WHITE_GLAZED_TERRACOTTA));
        ORANGE_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.ORANGE_GLAZED_TERRACOTTA));
        MAGENTA_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.MAGENTA_GLAZED_TERRACOTTA));
        LIGHT_BLUE_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.LIGHT_BLUE_GLAZED_TERRACOTTA));
        YELLOW_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.YELLOW_GLAZED_TERRACOTTA));
        LIME_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.LIME_GLAZED_TERRACOTTA));
        PINK_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.PINK_GLAZED_TERRACOTTA));
        GRAY_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.GRAY_GLAZED_TERRACOTTA));
        LIGHT_GRAY_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.LIGHT_GRAY_GLAZED_TERRACOTTA));
        CYAN_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CYAN_GLAZED_TERRACOTTA));
        PURPLE_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.PURPLE_GLAZED_TERRACOTTA));
        BLUE_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BLUE_GLAZED_TERRACOTTA));
        BROWN_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BROWN_GLAZED_TERRACOTTA));
        GREEN_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.GREEN_GLAZED_TERRACOTTA));
        RED_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.RED_GLAZED_TERRACOTTA));
        BLACK_GLAZED_TERRACOTTA_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BLACK_GLAZED_TERRACOTTA));

        WHITE_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.WHITE_CONCRETE));
        ORANGE_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.ORANGE_CONCRETE));
        MAGENTA_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.MAGENTA_CONCRETE));
        LIGHT_BLUE_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.LIGHT_BLUE_CONCRETE));
        YELLOW_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.YELLOW_CONCRETE));
        LIME_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.LIME_CONCRETE));
        PINK_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.PINK_CONCRETE));
        GRAY_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.GRAY_CONCRETE));
        LIGHT_GRAY_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.LIGHT_GRAY_CONCRETE));
        CYAN_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CYAN_CONCRETE));
        PURPLE_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.PURPLE_CONCRETE));
        BLUE_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BLUE_CONCRETE));
        BROWN_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BROWN_CONCRETE));
        GREEN_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.GREEN_CONCRETE));
        RED_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.RED_CONCRETE));
        BLACK_CONCRETE_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BLACK_CONCRETE));

        ACACIA_LOG_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.ACACIA_LOG));
        ACACIA_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.ACACIA_PLANK));
        BIRCH_LOG_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BIRCH_LOG));
        BIRCH_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BIRCH_PLANK));
        CRIMSON_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CRIMSON_PLANK));
        CRIMSON_STEM_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CRIMSON_STEM));
        DARK_OAK_LOG_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.DARK_OAK_LOG));
        DARK_OAK_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.DARK_OAK_PLANK));
        JUNGLE_LOG_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.JUNGLE_LOG));
        JUNGLE_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.JUNGLE_PLANK));
        OAK_LOG_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.OAK_LOG));
        OAK_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.OAK_PLANK));
        SPRUCE_LOG_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.SPRUCE_LOG));
        SPRUCE_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.SPRUCE_PLANK));
        WARPED_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.WARPED_PLANK));
        WARPED_STEM_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.WARPED_STEM));
    }

    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        AMETHYST_COVER.register(false);
        ANDESITE_COVER.register(false);
        BASALT_BRICK_COVER.register(false);
        BASALT_COVER.register(false);
        BLACKSTONE_COVER.register(false);
        BONE_COVER.register(false);
        BRICK_COVER.register(false);
        CALCITE_COVER.register(false);
        COBBLED_DEEPSLATE_COVER.register(false);
        COBBLED_END_STONE_COVER.register(false);
        COBBLESTONE_COVER.register(false);
        CRACKED_BASALT_BRICK_COVER.register(false);
        CRACKED_DEEPSLATE_BRICK_COVER.register(false);
        CRACKED_DEEPSLATE_TILE_COVER.register(false);
        CRACKED_STONE_BRICK_COVER.register(false);
        CRIMSON_BASALT_BRICK_COVER.register(false);
        CRYING_OBSIDIAN_COVER.register(false);
        CUT_RED_SANDSTONE_COVER.register(false);
        CUT_SANDSTONE_COVER.register(false);
        DARK_PRISMARINE_COVER.register(false);
        DEEPSLATE_BRICK_COVER.register(false);
        DEEPSLATE_COVER.register(false);
        DEEPSLATE_TILE_COVER.register(false);
        DIORITE_COVER.register(false);
        END_STONE_BRICK_COVER.register(false);
        END_STONE_COVER.register(false);
        GRANITE_COVER.register(false);
        MOSSY_BASALT_BRICK_COVER.register(false);
        MOSSY_COBBLESTONE_COVER.register(false);
        MOSSY_STONE_BRICK_COVER.register(false);
        NETHERRACK_COVER.register(false);
        NETHER_BRICK_COVER.register(false);
        OBSIDIAN_COVER.register(false);
        POLISHED_ANDESITE_COVER.register(false);
        POLISHED_BASALT_COVER.register(false);
        POLISHED_BLACKSTONE_BRICK_COVER.register(false);
        POLISHED_BLACKSTONE_COVER.register(false);
        POLISHED_DEEPSLATE_COVER.register(false);
        POLISHED_DIORITE_COVER.register(false);
        POLISHED_GRANITE_COVER.register(false);
        PRISMARINE_BRICK_COVER.register(false);
        PRISMARINE_COVER.register(false);
        PURPUR_COVER.register(false);
        PURPUR_PILLAR_COVER.register(false);
        RED_NETHER_BRICK_COVER.register(false);
        RED_SANDSTONE_COVER.register(false);
        SANDSTONE_COVER.register(false);
        SMOOTH_BASALT_COVER.register(false);
        SMOOTH_RED_SANDSTONE_COVER.register(false);
        SMOOTH_SANDSTONE_COVER.register(false);
        SMOOTH_STONE_COVER.register(false);
        STONE_BRICK_COVER.register(false);
        STONE_COVER.register(false);
        TUFF_COVER.register(false);
        WARPED_BASALT_BRICK_COVER.register(false);
        WARPED_NETHER_BRICK_COVER.register(false);

        WHITE_TERRACOTTA_COVER.register(false);
        ORANGE_TERRACOTTA_COVER.register(false);
        MAGENTA_TERRACOTTA_COVER.register(false);
        LIGHT_BLUE_TERRACOTTA_COVER.register(false);
        YELLOW_TERRACOTTA_COVER.register(false);
        LIME_TERRACOTTA_COVER.register(false);
        PINK_TERRACOTTA_COVER.register(false);
        GRAY_TERRACOTTA_COVER.register(false);
        LIGHT_GRAY_TERRACOTTA_COVER.register(false);
        CYAN_TERRACOTTA_COVER.register(false);
        PURPLE_TERRACOTTA_COVER.register(false);
        BLUE_TERRACOTTA_COVER.register(false);
        BROWN_TERRACOTTA_COVER.register(false);
        GREEN_TERRACOTTA_COVER.register(false);
        RED_TERRACOTTA_COVER.register(false);
        BLACK_TERRACOTTA_COVER.register(false);

        WHITE_GLAZED_TERRACOTTA_COVER.register(false);
        ORANGE_GLAZED_TERRACOTTA_COVER.register(false);
        MAGENTA_GLAZED_TERRACOTTA_COVER.register(false);
        LIGHT_BLUE_GLAZED_TERRACOTTA_COVER.register(false);
        YELLOW_GLAZED_TERRACOTTA_COVER.register(false);
        LIME_GLAZED_TERRACOTTA_COVER.register(false);
        PINK_GLAZED_TERRACOTTA_COVER.register(false);
        GRAY_GLAZED_TERRACOTTA_COVER.register(false);
        LIGHT_GRAY_GLAZED_TERRACOTTA_COVER.register(false);
        CYAN_GLAZED_TERRACOTTA_COVER.register(false);
        PURPLE_GLAZED_TERRACOTTA_COVER.register(false);
        BLUE_GLAZED_TERRACOTTA_COVER.register(false);
        BROWN_GLAZED_TERRACOTTA_COVER.register(false);
        GREEN_GLAZED_TERRACOTTA_COVER.register(false);
        RED_GLAZED_TERRACOTTA_COVER.register(false);
        BLACK_GLAZED_TERRACOTTA_COVER.register(false);

        WHITE_CONCRETE_COVER.register(false);
        ORANGE_CONCRETE_COVER.register(false);
        MAGENTA_CONCRETE_COVER.register(false);
        LIGHT_BLUE_CONCRETE_COVER.register(false);
        YELLOW_CONCRETE_COVER.register(false);
        LIME_CONCRETE_COVER.register(false);
        PINK_CONCRETE_COVER.register(false);
        GRAY_CONCRETE_COVER.register(false);
        LIGHT_GRAY_CONCRETE_COVER.register(false);
        CYAN_CONCRETE_COVER.register(false);
        PURPLE_CONCRETE_COVER.register(false);
        BLUE_CONCRETE_COVER.register(false);
        BROWN_CONCRETE_COVER.register(false);
        GREEN_CONCRETE_COVER.register(false);
        RED_CONCRETE_COVER.register(false);
        BLACK_CONCRETE_COVER.register(false);

        ACACIA_LOG_COVER.register();
        ACACIA_PLANK_COVER.register();
        BIRCH_LOG_COVER.register();
        BIRCH_PLANK_COVER.register();
        CRIMSON_PLANK_COVER.register(false);
        CRIMSON_STEM_COVER.register(false);
        DARK_OAK_LOG_COVER.register();
        DARK_OAK_PLANK_COVER.register();
        JUNGLE_LOG_COVER.register();
        JUNGLE_PLANK_COVER.register();
        OAK_LOG_COVER.register();
        OAK_PLANK_COVER.register();
        SPRUCE_LOG_COVER.register();
        SPRUCE_PLANK_COVER.register();
        WARPED_PLANK_COVER.register(false);
        WARPED_STEM_COVER.register(false);
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
    }
}
