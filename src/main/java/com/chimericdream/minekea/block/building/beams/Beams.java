package com.chimericdream.minekea.block.building.beams;

import com.chimericdream.minekea.block.building.beams.GenericBeamBlock.BeamSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import java.util.ArrayList;
import java.util.List;

public class Beams implements MinekeaBlockCategory {
    public static final GenericBeamBlock AMETHYST_BEAM;
    public static final GenericBeamBlock ANDESITE_BEAM;
    public static final GenericBeamBlock BASALT_BEAM;
    public static final GenericBeamBlock BASALT_BRICK_BEAM;
    public static final GenericBeamBlock BLACKSTONE_BEAM;
    public static final GenericBeamBlock BONE_BEAM;
    public static final GenericBeamBlock BRICK_BEAM;
    public static final GenericBeamBlock CALCITE_BEAM;
    public static final GenericBeamBlock COBBLED_DEEPSLATE_BEAM;
    public static final GenericBeamBlock COBBLED_END_STONE_BEAM;
    public static final GenericBeamBlock COBBLESTONE_BEAM;
    public static final GenericBeamBlock CRACKED_BASALT_BRICK_BEAM;
    public static final GenericBeamBlock CRACKED_DEEPSLATE_BRICK_BEAM;
    public static final GenericBeamBlock CRACKED_DEEPSLATE_TILE_BEAM;
    public static final GenericBeamBlock CRACKED_STONE_BRICK_BEAM;
    public static final GenericBeamBlock CRIMSON_BASALT_BRICK_BEAM;
    public static final GenericBeamBlock CRYING_OBSIDIAN_BEAM;
    public static final GenericBeamBlock CUT_RED_SANDSTONE_BEAM;
    public static final GenericBeamBlock CUT_SANDSTONE_BEAM;
    public static final GenericBeamBlock DARK_PRISMARINE_BEAM;
    public static final GenericBeamBlock DEEPSLATE_BEAM;
    public static final GenericBeamBlock DEEPSLATE_BRICK_BEAM;
    public static final GenericBeamBlock DEEPSLATE_TILE_BEAM;
    public static final GenericBeamBlock DIORITE_BEAM;
    public static final GenericBeamBlock END_STONE_BEAM;
    public static final GenericBeamBlock END_STONE_BRICK_BEAM;
    public static final GenericBeamBlock GRANITE_BEAM;
    public static final GenericBeamBlock MOSSY_BASALT_BRICK_BEAM;
    public static final GenericBeamBlock MOSSY_COBBLESTONE_BEAM;
    public static final GenericBeamBlock MOSSY_STONE_BRICK_BEAM;
    public static final GenericBeamBlock MUD_BRICK_BEAM;
    public static final GenericBeamBlock NETHERRACK_BEAM;
    public static final GenericBeamBlock NETHER_BRICK_BEAM;
    public static final GenericBeamBlock OBSIDIAN_BEAM;
    public static final GenericBeamBlock PACKED_MUD_BEAM;
    public static final GenericBeamBlock POLISHED_ANDESITE_BEAM;
    public static final GenericBeamBlock POLISHED_BASALT_BEAM;
    public static final GenericBeamBlock POLISHED_BLACKSTONE_BEAM;
    public static final GenericBeamBlock POLISHED_BLACKSTONE_BRICK_BEAM;
    public static final GenericBeamBlock POLISHED_DEEPSLATE_BEAM;
    public static final GenericBeamBlock POLISHED_DIORITE_BEAM;
    public static final GenericBeamBlock POLISHED_GRANITE_BEAM;
    public static final GenericBeamBlock PRISMARINE_BEAM;
    public static final GenericBeamBlock PRISMARINE_BRICK_BEAM;
    public static final GenericBeamBlock PURPUR_BEAM;
    public static final GenericBeamBlock PURPUR_PILLAR_BEAM;
    public static final GenericBeamBlock RED_NETHER_BRICK_BEAM;
    public static final GenericBeamBlock RED_SANDSTONE_BEAM;
    public static final GenericBeamBlock SANDSTONE_BEAM;
    public static final GenericBeamBlock SMOOTH_BASALT_BEAM;
    public static final GenericBeamBlock SMOOTH_RED_SANDSTONE_BEAM;
    public static final GenericBeamBlock SMOOTH_SANDSTONE_BEAM;
    public static final GenericBeamBlock SMOOTH_STONE_BEAM;
    public static final GenericBeamBlock STONE_BEAM;
    public static final GenericBeamBlock STONE_BRICK_BEAM;
    public static final GenericBeamBlock TUFF_BEAM;
    public static final GenericBeamBlock WARPED_BASALT_BRICK_BEAM;
    public static final GenericBeamBlock WARPED_NETHER_BRICK_BEAM;

    public static final GenericBeamBlock WHITE_TERRACOTTA_BEAM;
    public static final GenericBeamBlock ORANGE_TERRACOTTA_BEAM;
    public static final GenericBeamBlock MAGENTA_TERRACOTTA_BEAM;
    public static final GenericBeamBlock LIGHT_BLUE_TERRACOTTA_BEAM;
    public static final GenericBeamBlock YELLOW_TERRACOTTA_BEAM;
    public static final GenericBeamBlock LIME_TERRACOTTA_BEAM;
    public static final GenericBeamBlock PINK_TERRACOTTA_BEAM;
    public static final GenericBeamBlock GRAY_TERRACOTTA_BEAM;
    public static final GenericBeamBlock LIGHT_GRAY_TERRACOTTA_BEAM;
    public static final GenericBeamBlock CYAN_TERRACOTTA_BEAM;
    public static final GenericBeamBlock PURPLE_TERRACOTTA_BEAM;
    public static final GenericBeamBlock BLUE_TERRACOTTA_BEAM;
    public static final GenericBeamBlock BROWN_TERRACOTTA_BEAM;
    public static final GenericBeamBlock GREEN_TERRACOTTA_BEAM;
    public static final GenericBeamBlock RED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock BLACK_TERRACOTTA_BEAM;

    public static final GenericBeamBlock WHITE_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock ORANGE_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock MAGENTA_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock LIGHT_BLUE_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock YELLOW_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock LIME_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock PINK_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock GRAY_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock LIGHT_GRAY_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock CYAN_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock PURPLE_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock BLUE_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock BROWN_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock GREEN_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock RED_GLAZED_TERRACOTTA_BEAM;
    public static final GenericBeamBlock BLACK_GLAZED_TERRACOTTA_BEAM;

    public static final GenericBeamBlock WHITE_CONCRETE_BEAM;
    public static final GenericBeamBlock ORANGE_CONCRETE_BEAM;
    public static final GenericBeamBlock MAGENTA_CONCRETE_BEAM;
    public static final GenericBeamBlock LIGHT_BLUE_CONCRETE_BEAM;
    public static final GenericBeamBlock YELLOW_CONCRETE_BEAM;
    public static final GenericBeamBlock LIME_CONCRETE_BEAM;
    public static final GenericBeamBlock PINK_CONCRETE_BEAM;
    public static final GenericBeamBlock GRAY_CONCRETE_BEAM;
    public static final GenericBeamBlock LIGHT_GRAY_CONCRETE_BEAM;
    public static final GenericBeamBlock CYAN_CONCRETE_BEAM;
    public static final GenericBeamBlock PURPLE_CONCRETE_BEAM;
    public static final GenericBeamBlock BLUE_CONCRETE_BEAM;
    public static final GenericBeamBlock BROWN_CONCRETE_BEAM;
    public static final GenericBeamBlock GREEN_CONCRETE_BEAM;
    public static final GenericBeamBlock RED_CONCRETE_BEAM;
    public static final GenericBeamBlock BLACK_CONCRETE_BEAM;

    public static final GenericBeamBlock WHITE_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock ORANGE_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock MAGENTA_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock LIGHT_BLUE_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock YELLOW_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock LIME_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock PINK_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock GRAY_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock LIGHT_GRAY_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock CYAN_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock PURPLE_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock BLUE_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock BROWN_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock GREEN_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock RED_STAINED_GLASS_BEAM;
    public static final GenericBeamBlock BLACK_STAINED_GLASS_BEAM;

    public static final GenericBeamBlock ACACIA_LOG_BEAM;
    public static final GenericBeamBlock ACACIA_PLANK_BEAM;
    public static final GenericBeamBlock BIRCH_LOG_BEAM;
    public static final GenericBeamBlock BIRCH_PLANK_BEAM;
    public static final GenericBeamBlock CRIMSON_PLANK_BEAM;
    public static final GenericBeamBlock CRIMSON_STEM_BEAM;
    public static final GenericBeamBlock DARK_OAK_LOG_BEAM;
    public static final GenericBeamBlock DARK_OAK_PLANK_BEAM;
    public static final GenericBeamBlock JUNGLE_LOG_BEAM;
    public static final GenericBeamBlock JUNGLE_PLANK_BEAM;
    public static final GenericBeamBlock MANGROVE_LOG_BEAM;
    public static final GenericBeamBlock MANGROVE_PLANK_BEAM;
    public static final GenericBeamBlock OAK_LOG_BEAM;
    public static final GenericBeamBlock OAK_PLANK_BEAM;
    public static final GenericBeamBlock SPRUCE_LOG_BEAM;
    public static final GenericBeamBlock SPRUCE_PLANK_BEAM;
    public static final GenericBeamBlock WARPED_PLANK_BEAM;
    public static final GenericBeamBlock WARPED_STEM_BEAM;

    public static final List<GenericBeamBlock> BEAMS = new ArrayList<>();

    static {
        AMETHYST_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.AMETHYST));
        ANDESITE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.ANDESITE));
        BASALT_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BASALT));
        BASALT_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BASALT_BRICK));
        BLACKSTONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BLACKSTONE));
        BONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BONE));
        BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BRICK));
        CALCITE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CALCITE));
        COBBLED_DEEPSLATE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.COBBLED_DEEPSLATE));
        COBBLED_END_STONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.COBBLED_END_STONE));
        COBBLESTONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.COBBLESTONE));
        CRACKED_BASALT_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CRACKED_BASALT_BRICK));
        CRACKED_DEEPSLATE_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CRACKED_DEEPSLATE_BRICK));
        CRACKED_DEEPSLATE_TILE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CRACKED_DEEPSLATE_TILE));
        CRACKED_STONE_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CRACKED_STONE_BRICK));
        CRIMSON_BASALT_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CRIMSON_BASALT_BRICK));
        CRYING_OBSIDIAN_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CRYING_OBSIDIAN));
        CUT_RED_SANDSTONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CUT_RED_SANDSTONE));
        CUT_SANDSTONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CUT_SANDSTONE));
        DARK_PRISMARINE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.DARK_PRISMARINE));
        DEEPSLATE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.DEEPSLATE));
        DEEPSLATE_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.DEEPSLATE_BRICK));
        DEEPSLATE_TILE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.DEEPSLATE_TILE));
        DIORITE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.DIORITE));
        END_STONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.END_STONE));
        END_STONE_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.END_STONE_BRICK));
        GRANITE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.GRANITE));
        MOSSY_BASALT_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.MOSSY_BASALT_BRICK));
        MOSSY_COBBLESTONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.MOSSY_COBBLESTONE));
        MOSSY_STONE_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.MOSSY_STONE_BRICK));
        MUD_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.MUD_BRICK));
        NETHERRACK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.NETHERRACK));
        NETHER_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.NETHER_BRICK));
        OBSIDIAN_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.OBSIDIAN));
        PACKED_MUD_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.PACKED_MUD));
        POLISHED_ANDESITE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.POLISHED_ANDESITE));
        POLISHED_BASALT_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.POLISHED_BASALT));
        POLISHED_BLACKSTONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.POLISHED_BLACKSTONE));
        POLISHED_BLACKSTONE_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.POLISHED_BLACKSTONE_BRICK));
        POLISHED_DEEPSLATE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.POLISHED_DEEPSLATE));
        POLISHED_DIORITE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.POLISHED_DIORITE));
        POLISHED_GRANITE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.POLISHED_GRANITE));
        PRISMARINE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.PRISMARINE));
        PRISMARINE_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.PRISMARINE_BRICK));
        PURPUR_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.PURPUR));
        PURPUR_PILLAR_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.PURPUR_PILLAR));
        RED_NETHER_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.RED_NETHER_BRICK));
        RED_SANDSTONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.RED_SANDSTONE));
        SANDSTONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.SANDSTONE));
        SMOOTH_BASALT_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.SMOOTH_BASALT));
        SMOOTH_RED_SANDSTONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.SMOOTH_RED_SANDSTONE));
        SMOOTH_SANDSTONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.SMOOTH_SANDSTONE));
        SMOOTH_STONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.SMOOTH_STONE));
        STONE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.STONE));
        STONE_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.STONE_BRICK));
        TUFF_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.TUFF));
        WARPED_BASALT_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.WARPED_BASALT_BRICK));
        WARPED_NETHER_BRICK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.WARPED_NETHER_BRICK));

        WHITE_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.WHITE_TERRACOTTA));
        ORANGE_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.ORANGE_TERRACOTTA));
        MAGENTA_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.MAGENTA_TERRACOTTA));
        LIGHT_BLUE_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.LIGHT_BLUE_TERRACOTTA));
        YELLOW_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.YELLOW_TERRACOTTA));
        LIME_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.LIME_TERRACOTTA));
        PINK_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.PINK_TERRACOTTA));
        GRAY_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.GRAY_TERRACOTTA));
        LIGHT_GRAY_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.LIGHT_GRAY_TERRACOTTA));
        CYAN_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CYAN_TERRACOTTA));
        PURPLE_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.PURPLE_TERRACOTTA));
        BLUE_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BLUE_TERRACOTTA));
        BROWN_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BROWN_TERRACOTTA));
        GREEN_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.GREEN_TERRACOTTA));
        RED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.RED_TERRACOTTA));
        BLACK_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BLACK_TERRACOTTA));

        WHITE_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.WHITE_GLAZED_TERRACOTTA));
        ORANGE_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.ORANGE_GLAZED_TERRACOTTA));
        MAGENTA_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.MAGENTA_GLAZED_TERRACOTTA));
        LIGHT_BLUE_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.LIGHT_BLUE_GLAZED_TERRACOTTA));
        YELLOW_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.YELLOW_GLAZED_TERRACOTTA));
        LIME_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.LIME_GLAZED_TERRACOTTA));
        PINK_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.PINK_GLAZED_TERRACOTTA));
        GRAY_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.GRAY_GLAZED_TERRACOTTA));
        LIGHT_GRAY_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.LIGHT_GRAY_GLAZED_TERRACOTTA));
        CYAN_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CYAN_GLAZED_TERRACOTTA));
        PURPLE_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.PURPLE_GLAZED_TERRACOTTA));
        BLUE_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BLUE_GLAZED_TERRACOTTA));
        BROWN_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BROWN_GLAZED_TERRACOTTA));
        GREEN_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.GREEN_GLAZED_TERRACOTTA));
        RED_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.RED_GLAZED_TERRACOTTA));
        BLACK_GLAZED_TERRACOTTA_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BLACK_GLAZED_TERRACOTTA));

        WHITE_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.WHITE_CONCRETE));
        ORANGE_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.ORANGE_CONCRETE));
        MAGENTA_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.MAGENTA_CONCRETE));
        LIGHT_BLUE_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.LIGHT_BLUE_CONCRETE));
        YELLOW_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.YELLOW_CONCRETE));
        LIME_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.LIME_CONCRETE));
        PINK_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.PINK_CONCRETE));
        GRAY_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.GRAY_CONCRETE));
        LIGHT_GRAY_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.LIGHT_GRAY_CONCRETE));
        CYAN_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CYAN_CONCRETE));
        PURPLE_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.PURPLE_CONCRETE));
        BLUE_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BLUE_CONCRETE));
        BROWN_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BROWN_CONCRETE));
        GREEN_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.GREEN_CONCRETE));
        RED_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.RED_CONCRETE));
        BLACK_CONCRETE_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BLACK_CONCRETE));

        WHITE_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.WHITE_STAINED_GLASS));
        ORANGE_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.ORANGE_STAINED_GLASS));
        MAGENTA_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.MAGENTA_STAINED_GLASS));
        LIGHT_BLUE_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.LIGHT_BLUE_STAINED_GLASS));
        YELLOW_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.YELLOW_STAINED_GLASS));
        LIME_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.LIME_STAINED_GLASS));
        PINK_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.PINK_STAINED_GLASS));
        GRAY_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.GRAY_STAINED_GLASS));
        LIGHT_GRAY_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.LIGHT_GRAY_STAINED_GLASS));
        CYAN_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CYAN_STAINED_GLASS));
        PURPLE_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.PURPLE_STAINED_GLASS));
        BLUE_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BLUE_STAINED_GLASS));
        BROWN_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BROWN_STAINED_GLASS));
        GREEN_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.GREEN_STAINED_GLASS));
        RED_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.RED_STAINED_GLASS));
        BLACK_STAINED_GLASS_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BLACK_STAINED_GLASS));

        ACACIA_LOG_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.ACACIA_LOG));
        ACACIA_PLANK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.ACACIA));
        BIRCH_LOG_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BIRCH_LOG));
        BIRCH_PLANK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.BIRCH));
        CRIMSON_PLANK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CRIMSON));
        CRIMSON_STEM_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.CRIMSON_STEM));
        DARK_OAK_LOG_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.DARK_OAK_LOG));
        DARK_OAK_PLANK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.DARK_OAK));
        JUNGLE_LOG_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.JUNGLE_LOG));
        JUNGLE_PLANK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.JUNGLE));
        MANGROVE_LOG_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.MANGROVE_LOG));
        MANGROVE_PLANK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.MANGROVE));
        OAK_LOG_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.OAK_LOG));
        OAK_PLANK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.OAK));
        SPRUCE_LOG_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.SPRUCE_LOG));
        SPRUCE_PLANK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.SPRUCE));
        WARPED_PLANK_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.WARPED));
        WARPED_STEM_BEAM = new GenericBeamBlock(new BeamSettings(BaseBlockSettings.WARPED_STEM));

        BEAMS.addAll(List.of(
            AMETHYST_BEAM,
            ANDESITE_BEAM,
            BASALT_BEAM,
            BASALT_BRICK_BEAM,
            BLACKSTONE_BEAM,
            BONE_BEAM,
            BRICK_BEAM,
            CALCITE_BEAM,
            COBBLED_DEEPSLATE_BEAM,
            COBBLED_END_STONE_BEAM,
            COBBLESTONE_BEAM,
            CRACKED_BASALT_BRICK_BEAM,
            CRACKED_DEEPSLATE_BRICK_BEAM,
            CRACKED_DEEPSLATE_TILE_BEAM,
            CRACKED_STONE_BRICK_BEAM,
            CRIMSON_BASALT_BRICK_BEAM,
            CRYING_OBSIDIAN_BEAM,
            CUT_RED_SANDSTONE_BEAM,
            CUT_SANDSTONE_BEAM,
            DARK_PRISMARINE_BEAM,
            DEEPSLATE_BEAM,
            DEEPSLATE_BRICK_BEAM,
            DEEPSLATE_TILE_BEAM,
            DIORITE_BEAM,
            END_STONE_BEAM,
            END_STONE_BRICK_BEAM,
            GRANITE_BEAM,
            MOSSY_BASALT_BRICK_BEAM,
            MOSSY_COBBLESTONE_BEAM,
            MOSSY_STONE_BRICK_BEAM,
            MUD_BRICK_BEAM,
            NETHERRACK_BEAM,
            NETHER_BRICK_BEAM,
            OBSIDIAN_BEAM,
            PACKED_MUD_BEAM,
            POLISHED_ANDESITE_BEAM,
            POLISHED_BASALT_BEAM,
            POLISHED_BLACKSTONE_BEAM,
            POLISHED_BLACKSTONE_BRICK_BEAM,
            POLISHED_DEEPSLATE_BEAM,
            POLISHED_DIORITE_BEAM,
            POLISHED_GRANITE_BEAM,
            PRISMARINE_BEAM,
            PRISMARINE_BRICK_BEAM,
            PURPUR_BEAM,
            PURPUR_PILLAR_BEAM,
            RED_NETHER_BRICK_BEAM,
            RED_SANDSTONE_BEAM,
            SANDSTONE_BEAM,
            SMOOTH_BASALT_BEAM,
            SMOOTH_RED_SANDSTONE_BEAM,
            SMOOTH_SANDSTONE_BEAM,
            SMOOTH_STONE_BEAM,
            STONE_BEAM,
            STONE_BRICK_BEAM,
            TUFF_BEAM,
            WARPED_BASALT_BRICK_BEAM,
            WARPED_NETHER_BRICK_BEAM,

            WHITE_TERRACOTTA_BEAM,
            ORANGE_TERRACOTTA_BEAM,
            MAGENTA_TERRACOTTA_BEAM,
            LIGHT_BLUE_TERRACOTTA_BEAM,
            YELLOW_TERRACOTTA_BEAM,
            LIME_TERRACOTTA_BEAM,
            PINK_TERRACOTTA_BEAM,
            GRAY_TERRACOTTA_BEAM,
            LIGHT_GRAY_TERRACOTTA_BEAM,
            CYAN_TERRACOTTA_BEAM,
            PURPLE_TERRACOTTA_BEAM,
            BLUE_TERRACOTTA_BEAM,
            BROWN_TERRACOTTA_BEAM,
            GREEN_TERRACOTTA_BEAM,
            RED_TERRACOTTA_BEAM,
            BLACK_TERRACOTTA_BEAM,

            WHITE_GLAZED_TERRACOTTA_BEAM,
            ORANGE_GLAZED_TERRACOTTA_BEAM,
            MAGENTA_GLAZED_TERRACOTTA_BEAM,
            LIGHT_BLUE_GLAZED_TERRACOTTA_BEAM,
            YELLOW_GLAZED_TERRACOTTA_BEAM,
            LIME_GLAZED_TERRACOTTA_BEAM,
            PINK_GLAZED_TERRACOTTA_BEAM,
            GRAY_GLAZED_TERRACOTTA_BEAM,
            LIGHT_GRAY_GLAZED_TERRACOTTA_BEAM,
            CYAN_GLAZED_TERRACOTTA_BEAM,
            PURPLE_GLAZED_TERRACOTTA_BEAM,
            BLUE_GLAZED_TERRACOTTA_BEAM,
            BROWN_GLAZED_TERRACOTTA_BEAM,
            GREEN_GLAZED_TERRACOTTA_BEAM,
            RED_GLAZED_TERRACOTTA_BEAM,
            BLACK_GLAZED_TERRACOTTA_BEAM,

            WHITE_CONCRETE_BEAM,
            ORANGE_CONCRETE_BEAM,
            MAGENTA_CONCRETE_BEAM,
            LIGHT_BLUE_CONCRETE_BEAM,
            YELLOW_CONCRETE_BEAM,
            LIME_CONCRETE_BEAM,
            PINK_CONCRETE_BEAM,
            GRAY_CONCRETE_BEAM,
            LIGHT_GRAY_CONCRETE_BEAM,
            CYAN_CONCRETE_BEAM,
            PURPLE_CONCRETE_BEAM,
            BLUE_CONCRETE_BEAM,
            BROWN_CONCRETE_BEAM,
            GREEN_CONCRETE_BEAM,
            RED_CONCRETE_BEAM,
            BLACK_CONCRETE_BEAM,

            WHITE_STAINED_GLASS_BEAM,
            ORANGE_STAINED_GLASS_BEAM,
            MAGENTA_STAINED_GLASS_BEAM,
            LIGHT_BLUE_STAINED_GLASS_BEAM,
            YELLOW_STAINED_GLASS_BEAM,
            LIME_STAINED_GLASS_BEAM,
            PINK_STAINED_GLASS_BEAM,
            GRAY_STAINED_GLASS_BEAM,
            LIGHT_GRAY_STAINED_GLASS_BEAM,
            CYAN_STAINED_GLASS_BEAM,
            PURPLE_STAINED_GLASS_BEAM,
            BLUE_STAINED_GLASS_BEAM,
            BROWN_STAINED_GLASS_BEAM,
            GREEN_STAINED_GLASS_BEAM,
            RED_STAINED_GLASS_BEAM,
            BLACK_STAINED_GLASS_BEAM,

            ACACIA_LOG_BEAM,
            ACACIA_PLANK_BEAM,
            BIRCH_LOG_BEAM,
            BIRCH_PLANK_BEAM,
            CRIMSON_PLANK_BEAM,
            CRIMSON_STEM_BEAM,
            DARK_OAK_LOG_BEAM,
            DARK_OAK_PLANK_BEAM,
            JUNGLE_LOG_BEAM,
            JUNGLE_PLANK_BEAM,
            MANGROVE_LOG_BEAM,
            MANGROVE_PLANK_BEAM,
            OAK_LOG_BEAM,
            OAK_PLANK_BEAM,
            SPRUCE_LOG_BEAM,
            SPRUCE_PLANK_BEAM,
            WARPED_PLANK_BEAM,
            WARPED_STEM_BEAM
        ));
    }

    @Override
    public void initializeClient() {
        for (GenericBeamBlock block : BEAMS) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }
    }

    @Override
    public void registerBlocks() {
        for (GenericBeamBlock block : BEAMS) {
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
