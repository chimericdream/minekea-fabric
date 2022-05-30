package com.chimericdream.minekea.block.building.covers;

import com.chimericdream.minekea.block.building.covers.GenericCoverBlock.CoverSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import java.util.ArrayList;
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

    public static final GenericCoverBlock WHITE_STAINED_GLASS_COVER;
    public static final GenericCoverBlock ORANGE_STAINED_GLASS_COVER;
    public static final GenericCoverBlock MAGENTA_STAINED_GLASS_COVER;
    public static final GenericCoverBlock LIGHT_BLUE_STAINED_GLASS_COVER;
    public static final GenericCoverBlock YELLOW_STAINED_GLASS_COVER;
    public static final GenericCoverBlock LIME_STAINED_GLASS_COVER;
    public static final GenericCoverBlock PINK_STAINED_GLASS_COVER;
    public static final GenericCoverBlock GRAY_STAINED_GLASS_COVER;
    public static final GenericCoverBlock LIGHT_GRAY_STAINED_GLASS_COVER;
    public static final GenericCoverBlock CYAN_STAINED_GLASS_COVER;
    public static final GenericCoverBlock PURPLE_STAINED_GLASS_COVER;
    public static final GenericCoverBlock BLUE_STAINED_GLASS_COVER;
    public static final GenericCoverBlock BROWN_STAINED_GLASS_COVER;
    public static final GenericCoverBlock GREEN_STAINED_GLASS_COVER;
    public static final GenericCoverBlock RED_STAINED_GLASS_COVER;
    public static final GenericCoverBlock BLACK_STAINED_GLASS_COVER;

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

    public static final List<GenericCoverBlock> COVERS = new ArrayList<>();

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

        WHITE_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.WHITE_STAINED_GLASS));
        ORANGE_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.ORANGE_STAINED_GLASS));
        MAGENTA_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.MAGENTA_STAINED_GLASS));
        LIGHT_BLUE_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.LIGHT_BLUE_STAINED_GLASS));
        YELLOW_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.YELLOW_STAINED_GLASS));
        LIME_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.LIME_STAINED_GLASS));
        PINK_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.PINK_STAINED_GLASS));
        GRAY_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.GRAY_STAINED_GLASS));
        LIGHT_GRAY_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.LIGHT_GRAY_STAINED_GLASS));
        CYAN_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CYAN_STAINED_GLASS));
        PURPLE_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.PURPLE_STAINED_GLASS));
        BLUE_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BLUE_STAINED_GLASS));
        BROWN_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BROWN_STAINED_GLASS));
        GREEN_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.GREEN_STAINED_GLASS));
        RED_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.RED_STAINED_GLASS));
        BLACK_STAINED_GLASS_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BLACK_STAINED_GLASS));

        ACACIA_LOG_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.ACACIA_LOG));
        ACACIA_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.ACACIA));
        BIRCH_LOG_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BIRCH_LOG));
        BIRCH_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.BIRCH));
        CRIMSON_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CRIMSON));
        CRIMSON_STEM_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.CRIMSON_STEM));
        DARK_OAK_LOG_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.DARK_OAK_LOG));
        DARK_OAK_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.DARK_OAK));
        JUNGLE_LOG_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.JUNGLE_LOG));
        JUNGLE_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.JUNGLE));
        OAK_LOG_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.OAK_LOG));
        OAK_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.OAK));
        SPRUCE_LOG_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.SPRUCE_LOG));
        SPRUCE_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.SPRUCE));
        WARPED_PLANK_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.WARPED));
        WARPED_STEM_COVER = new GenericCoverBlock(new CoverSettings(BaseBlockSettings.WARPED_STEM));

        COVERS.addAll(List.of(
            AMETHYST_COVER,
            ANDESITE_COVER,
            BASALT_BRICK_COVER,
            BASALT_COVER,
            BLACKSTONE_COVER,
            BONE_COVER,
            BRICK_COVER,
            CALCITE_COVER,
            COBBLED_DEEPSLATE_COVER,
            COBBLED_END_STONE_COVER,
            COBBLESTONE_COVER,
            CRACKED_BASALT_BRICK_COVER,
            CRACKED_DEEPSLATE_BRICK_COVER,
            CRACKED_DEEPSLATE_TILE_COVER,
            CRACKED_STONE_BRICK_COVER,
            CRIMSON_BASALT_BRICK_COVER,
            CRYING_OBSIDIAN_COVER,
            CUT_RED_SANDSTONE_COVER,
            CUT_SANDSTONE_COVER,
            DARK_PRISMARINE_COVER,
            DEEPSLATE_BRICK_COVER,
            DEEPSLATE_COVER,
            DEEPSLATE_TILE_COVER,
            DIORITE_COVER,
            END_STONE_BRICK_COVER,
            END_STONE_COVER,
            GRANITE_COVER,
            MOSSY_BASALT_BRICK_COVER,
            MOSSY_COBBLESTONE_COVER,
            MOSSY_STONE_BRICK_COVER,
            NETHERRACK_COVER,
            NETHER_BRICK_COVER,
            OBSIDIAN_COVER,
            POLISHED_ANDESITE_COVER,
            POLISHED_BASALT_COVER,
            POLISHED_BLACKSTONE_BRICK_COVER,
            POLISHED_BLACKSTONE_COVER,
            POLISHED_DEEPSLATE_COVER,
            POLISHED_DIORITE_COVER,
            POLISHED_GRANITE_COVER,
            PRISMARINE_BRICK_COVER,
            PRISMARINE_COVER,
            PURPUR_COVER,
            PURPUR_PILLAR_COVER,
            RED_NETHER_BRICK_COVER,
            RED_SANDSTONE_COVER,
            SANDSTONE_COVER,
            SMOOTH_BASALT_COVER,
            SMOOTH_RED_SANDSTONE_COVER,
            SMOOTH_SANDSTONE_COVER,
            SMOOTH_STONE_COVER,
            STONE_BRICK_COVER,
            STONE_COVER,
            TUFF_COVER,
            WARPED_BASALT_BRICK_COVER,
            WARPED_NETHER_BRICK_COVER,

            WHITE_TERRACOTTA_COVER,
            ORANGE_TERRACOTTA_COVER,
            MAGENTA_TERRACOTTA_COVER,
            LIGHT_BLUE_TERRACOTTA_COVER,
            YELLOW_TERRACOTTA_COVER,
            LIME_TERRACOTTA_COVER,
            PINK_TERRACOTTA_COVER,
            GRAY_TERRACOTTA_COVER,
            LIGHT_GRAY_TERRACOTTA_COVER,
            CYAN_TERRACOTTA_COVER,
            PURPLE_TERRACOTTA_COVER,
            BLUE_TERRACOTTA_COVER,
            BROWN_TERRACOTTA_COVER,
            GREEN_TERRACOTTA_COVER,
            RED_TERRACOTTA_COVER,
            BLACK_TERRACOTTA_COVER,

            WHITE_GLAZED_TERRACOTTA_COVER,
            ORANGE_GLAZED_TERRACOTTA_COVER,
            MAGENTA_GLAZED_TERRACOTTA_COVER,
            LIGHT_BLUE_GLAZED_TERRACOTTA_COVER,
            YELLOW_GLAZED_TERRACOTTA_COVER,
            LIME_GLAZED_TERRACOTTA_COVER,
            PINK_GLAZED_TERRACOTTA_COVER,
            GRAY_GLAZED_TERRACOTTA_COVER,
            LIGHT_GRAY_GLAZED_TERRACOTTA_COVER,
            CYAN_GLAZED_TERRACOTTA_COVER,
            PURPLE_GLAZED_TERRACOTTA_COVER,
            BLUE_GLAZED_TERRACOTTA_COVER,
            BROWN_GLAZED_TERRACOTTA_COVER,
            GREEN_GLAZED_TERRACOTTA_COVER,
            RED_GLAZED_TERRACOTTA_COVER,
            BLACK_GLAZED_TERRACOTTA_COVER,

            WHITE_CONCRETE_COVER,
            ORANGE_CONCRETE_COVER,
            MAGENTA_CONCRETE_COVER,
            LIGHT_BLUE_CONCRETE_COVER,
            YELLOW_CONCRETE_COVER,
            LIME_CONCRETE_COVER,
            PINK_CONCRETE_COVER,
            GRAY_CONCRETE_COVER,
            LIGHT_GRAY_CONCRETE_COVER,
            CYAN_CONCRETE_COVER,
            PURPLE_CONCRETE_COVER,
            BLUE_CONCRETE_COVER,
            BROWN_CONCRETE_COVER,
            GREEN_CONCRETE_COVER,
            RED_CONCRETE_COVER,
            BLACK_CONCRETE_COVER,

            WHITE_STAINED_GLASS_COVER,
            ORANGE_STAINED_GLASS_COVER,
            MAGENTA_STAINED_GLASS_COVER,
            LIGHT_BLUE_STAINED_GLASS_COVER,
            YELLOW_STAINED_GLASS_COVER,
            LIME_STAINED_GLASS_COVER,
            PINK_STAINED_GLASS_COVER,
            GRAY_STAINED_GLASS_COVER,
            LIGHT_GRAY_STAINED_GLASS_COVER,
            CYAN_STAINED_GLASS_COVER,
            PURPLE_STAINED_GLASS_COVER,
            BLUE_STAINED_GLASS_COVER,
            BROWN_STAINED_GLASS_COVER,
            GREEN_STAINED_GLASS_COVER,
            RED_STAINED_GLASS_COVER,
            BLACK_STAINED_GLASS_COVER,

            ACACIA_LOG_COVER,
            ACACIA_PLANK_COVER,
            BIRCH_LOG_COVER,
            BIRCH_PLANK_COVER,
            CRIMSON_PLANK_COVER,
            CRIMSON_STEM_COVER,
            DARK_OAK_LOG_COVER,
            DARK_OAK_PLANK_COVER,
            JUNGLE_LOG_COVER,
            JUNGLE_PLANK_COVER,
            OAK_LOG_COVER,
            OAK_PLANK_COVER,
            SPRUCE_LOG_COVER,
            SPRUCE_PLANK_COVER,
            WARPED_PLANK_COVER,
            WARPED_STEM_COVER
        ));
    }

    @Override
    public void initializeClient() {
        for (GenericCoverBlock block : COVERS) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }
    }

    @Override
    public void registerBlocks() {
        for (GenericCoverBlock block : COVERS) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }
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
