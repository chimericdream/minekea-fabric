package com.chimericdream.minekea.block.building.walls;

import com.chimericdream.minekea.block.building.walls.GenericWallBlock.WallSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import java.util.ArrayList;
import java.util.List;

public class Walls implements MinekeaBlockCategory {
    public static final GenericWallBlock AMETHYST_WALL;
    public static final GenericWallBlock BASALT_WALL;
    public static final GenericWallBlock BASALT_BRICK_WALL;
    public static final GenericWallBlock BONE_WALL;
    public static final GenericWallBlock CALCITE_WALL;
    public static final GenericWallBlock COBBLED_END_STONE_WALL;
    public static final GenericWallBlock CRACKED_BASALT_BRICK_WALL;
    public static final GenericWallBlock CRACKED_DEEPSLATE_BRICK_WALL;
    public static final GenericWallBlock CRACKED_DEEPSLATE_TILE_WALL;
    public static final GenericWallBlock CRACKED_STONE_BRICK_WALL;
    public static final GenericWallBlock CRIMSON_BASALT_BRICK_WALL;
    public static final GenericWallBlock CRYING_OBSIDIAN_WALL;
    public static final GenericWallBlock CUT_RED_SANDSTONE_WALL;
    public static final GenericWallBlock CUT_SANDSTONE_WALL;
    public static final GenericWallBlock DARK_PRISMARINE_WALL;
    public static final GenericWallBlock DEEPSLATE_WALL;
    public static final GenericWallBlock END_STONE_WALL;
    public static final GenericWallBlock MOSSY_BASALT_BRICK_WALL;
    public static final GenericWallBlock NETHERRACK_WALL;
    public static final GenericWallBlock OBSIDIAN_WALL;
    public static final GenericWallBlock POLISHED_ANDESITE_WALL;
    public static final GenericWallBlock POLISHED_BASALT_WALL;
    public static final GenericWallBlock POLISHED_DIORITE_WALL;
    public static final GenericWallBlock POLISHED_GRANITE_WALL;
    public static final GenericWallBlock PRISMARINE_BRICK_WALL;
    public static final GenericWallBlock PURPUR_WALL;
    public static final GenericWallBlock PURPUR_PILLAR_WALL;
    public static final GenericWallBlock SMOOTH_BASALT_WALL;
    public static final GenericWallBlock SMOOTH_RED_SANDSTONE_WALL;
    public static final GenericWallBlock SMOOTH_SANDSTONE_WALL;
    public static final GenericWallBlock SMOOTH_STONE_WALL;
    public static final GenericWallBlock STONE_WALL;
    public static final GenericWallBlock TUFF_WALL;
    public static final GenericWallBlock WARPED_BASALT_BRICK_WALL;
    public static final GenericWallBlock WARPED_NETHER_BRICK_WALL;

    public static final GenericWallBlock WHITE_TERRACOTTA_WALL;
    public static final GenericWallBlock ORANGE_TERRACOTTA_WALL;
    public static final GenericWallBlock MAGENTA_TERRACOTTA_WALL;
    public static final GenericWallBlock LIGHT_BLUE_TERRACOTTA_WALL;
    public static final GenericWallBlock YELLOW_TERRACOTTA_WALL;
    public static final GenericWallBlock LIME_TERRACOTTA_WALL;
    public static final GenericWallBlock PINK_TERRACOTTA_WALL;
    public static final GenericWallBlock GRAY_TERRACOTTA_WALL;
    public static final GenericWallBlock LIGHT_GRAY_TERRACOTTA_WALL;
    public static final GenericWallBlock CYAN_TERRACOTTA_WALL;
    public static final GenericWallBlock PURPLE_TERRACOTTA_WALL;
    public static final GenericWallBlock BLUE_TERRACOTTA_WALL;
    public static final GenericWallBlock BROWN_TERRACOTTA_WALL;
    public static final GenericWallBlock GREEN_TERRACOTTA_WALL;
    public static final GenericWallBlock RED_TERRACOTTA_WALL;
    public static final GenericWallBlock BLACK_TERRACOTTA_WALL;

    public static final GenericWallBlock WHITE_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock ORANGE_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock MAGENTA_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock LIGHT_BLUE_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock YELLOW_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock LIME_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock PINK_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock GRAY_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock LIGHT_GRAY_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock CYAN_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock PURPLE_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock BLUE_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock BROWN_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock GREEN_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock RED_GLAZED_TERRACOTTA_WALL;
    public static final GenericWallBlock BLACK_GLAZED_TERRACOTTA_WALL;

    public static final GenericWallBlock WHITE_CONCRETE_WALL;
    public static final GenericWallBlock ORANGE_CONCRETE_WALL;
    public static final GenericWallBlock MAGENTA_CONCRETE_WALL;
    public static final GenericWallBlock LIGHT_BLUE_CONCRETE_WALL;
    public static final GenericWallBlock YELLOW_CONCRETE_WALL;
    public static final GenericWallBlock LIME_CONCRETE_WALL;
    public static final GenericWallBlock PINK_CONCRETE_WALL;
    public static final GenericWallBlock GRAY_CONCRETE_WALL;
    public static final GenericWallBlock LIGHT_GRAY_CONCRETE_WALL;
    public static final GenericWallBlock CYAN_CONCRETE_WALL;
    public static final GenericWallBlock PURPLE_CONCRETE_WALL;
    public static final GenericWallBlock BLUE_CONCRETE_WALL;
    public static final GenericWallBlock BROWN_CONCRETE_WALL;
    public static final GenericWallBlock GREEN_CONCRETE_WALL;
    public static final GenericWallBlock RED_CONCRETE_WALL;
    public static final GenericWallBlock BLACK_CONCRETE_WALL;

    public static final List<GenericWallBlock> WALLS = new ArrayList<>();

    static {
        AMETHYST_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.AMETHYST));
        BASALT_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.BASALT));
        BASALT_BRICK_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.BASALT_BRICK));
        BONE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.BONE));
        CALCITE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.CALCITE));
        COBBLED_END_STONE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.COBBLED_END_STONE));
        CRACKED_BASALT_BRICK_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.CRACKED_BASALT_BRICK));
        CRACKED_DEEPSLATE_BRICK_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.CRACKED_DEEPSLATE_BRICK));
        CRACKED_DEEPSLATE_TILE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.CRACKED_DEEPSLATE_TILE));
        CRACKED_STONE_BRICK_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.CRACKED_STONE_BRICK));
        CRIMSON_BASALT_BRICK_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.CRIMSON_BASALT_BRICK));
        CRYING_OBSIDIAN_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.CRYING_OBSIDIAN));
        CUT_RED_SANDSTONE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.CUT_RED_SANDSTONE));
        CUT_SANDSTONE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.CUT_SANDSTONE));
        DARK_PRISMARINE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.DARK_PRISMARINE));
        DEEPSLATE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.DEEPSLATE));
        END_STONE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.END_STONE));
        MOSSY_BASALT_BRICK_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.MOSSY_BASALT_BRICK));
        NETHERRACK_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.NETHERRACK));
        OBSIDIAN_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.OBSIDIAN));
        POLISHED_ANDESITE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.POLISHED_ANDESITE));
        POLISHED_BASALT_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.POLISHED_BASALT));
        POLISHED_DIORITE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.POLISHED_DIORITE));
        POLISHED_GRANITE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.POLISHED_GRANITE));
        PRISMARINE_BRICK_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.PRISMARINE_BRICK));
        PURPUR_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.PURPUR));
        PURPUR_PILLAR_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.PURPUR_PILLAR));
        SMOOTH_BASALT_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.SMOOTH_BASALT));
        SMOOTH_RED_SANDSTONE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.SMOOTH_RED_SANDSTONE));
        SMOOTH_SANDSTONE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.SMOOTH_SANDSTONE));
        SMOOTH_STONE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.SMOOTH_STONE));
        STONE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.STONE));
        TUFF_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.TUFF));
        WARPED_BASALT_BRICK_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.WARPED_BASALT_BRICK));
        WARPED_NETHER_BRICK_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.WARPED_NETHER_BRICK));

        WHITE_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.WHITE_TERRACOTTA));
        ORANGE_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.ORANGE_TERRACOTTA));
        MAGENTA_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.MAGENTA_TERRACOTTA));
        LIGHT_BLUE_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.LIGHT_BLUE_TERRACOTTA));
        YELLOW_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.YELLOW_TERRACOTTA));
        LIME_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.LIME_TERRACOTTA));
        PINK_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.PINK_TERRACOTTA));
        GRAY_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.GRAY_TERRACOTTA));
        LIGHT_GRAY_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.LIGHT_GRAY_TERRACOTTA));
        CYAN_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.CYAN_TERRACOTTA));
        PURPLE_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.PURPLE_TERRACOTTA));
        BLUE_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.BLUE_TERRACOTTA));
        BROWN_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.BROWN_TERRACOTTA));
        GREEN_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.GREEN_TERRACOTTA));
        RED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.RED_TERRACOTTA));
        BLACK_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.BLACK_TERRACOTTA));

        WHITE_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.WHITE_GLAZED_TERRACOTTA));
        ORANGE_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.ORANGE_GLAZED_TERRACOTTA));
        MAGENTA_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.MAGENTA_GLAZED_TERRACOTTA));
        LIGHT_BLUE_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.LIGHT_BLUE_GLAZED_TERRACOTTA));
        YELLOW_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.YELLOW_GLAZED_TERRACOTTA));
        LIME_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.LIME_GLAZED_TERRACOTTA));
        PINK_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.PINK_GLAZED_TERRACOTTA));
        GRAY_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.GRAY_GLAZED_TERRACOTTA));
        LIGHT_GRAY_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.LIGHT_GRAY_GLAZED_TERRACOTTA));
        CYAN_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.CYAN_GLAZED_TERRACOTTA));
        PURPLE_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.PURPLE_GLAZED_TERRACOTTA));
        BLUE_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.BLUE_GLAZED_TERRACOTTA));
        BROWN_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.BROWN_GLAZED_TERRACOTTA));
        GREEN_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.GREEN_GLAZED_TERRACOTTA));
        RED_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.RED_GLAZED_TERRACOTTA));
        BLACK_GLAZED_TERRACOTTA_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.BLACK_GLAZED_TERRACOTTA));

        WHITE_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.WHITE_CONCRETE));
        ORANGE_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.ORANGE_CONCRETE));
        MAGENTA_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.MAGENTA_CONCRETE));
        LIGHT_BLUE_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.LIGHT_BLUE_CONCRETE));
        YELLOW_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.YELLOW_CONCRETE));
        LIME_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.LIME_CONCRETE));
        PINK_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.PINK_CONCRETE));
        GRAY_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.GRAY_CONCRETE));
        LIGHT_GRAY_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.LIGHT_GRAY_CONCRETE));
        CYAN_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.CYAN_CONCRETE));
        PURPLE_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.PURPLE_CONCRETE));
        BLUE_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.BLUE_CONCRETE));
        BROWN_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.BROWN_CONCRETE));
        GREEN_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.GREEN_CONCRETE));
        RED_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.RED_CONCRETE));
        BLACK_CONCRETE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.BLACK_CONCRETE));

        WALLS.addAll(List.of(
            AMETHYST_WALL,
            BASALT_WALL,
            BASALT_BRICK_WALL,
            BONE_WALL,
            CALCITE_WALL,
            COBBLED_END_STONE_WALL,
            CRACKED_BASALT_BRICK_WALL,
            CRACKED_DEEPSLATE_BRICK_WALL,
            CRACKED_DEEPSLATE_TILE_WALL,
            CRACKED_STONE_BRICK_WALL,
            CRIMSON_BASALT_BRICK_WALL,
            CRYING_OBSIDIAN_WALL,
            CUT_RED_SANDSTONE_WALL,
            CUT_SANDSTONE_WALL,
            DARK_PRISMARINE_WALL,
            DEEPSLATE_WALL,
            END_STONE_WALL,
            MOSSY_BASALT_BRICK_WALL,
            NETHERRACK_WALL,
            OBSIDIAN_WALL,
            POLISHED_ANDESITE_WALL,
            POLISHED_BASALT_WALL,
            POLISHED_DIORITE_WALL,
            POLISHED_GRANITE_WALL,
            PRISMARINE_BRICK_WALL,
            PURPUR_WALL,
            PURPUR_PILLAR_WALL,
            SMOOTH_BASALT_WALL,
            SMOOTH_RED_SANDSTONE_WALL,
            SMOOTH_SANDSTONE_WALL,
            SMOOTH_STONE_WALL,
            STONE_WALL,
            TUFF_WALL,
            WARPED_BASALT_BRICK_WALL,
            WARPED_NETHER_BRICK_WALL,

            WHITE_TERRACOTTA_WALL,
            ORANGE_TERRACOTTA_WALL,
            MAGENTA_TERRACOTTA_WALL,
            LIGHT_BLUE_TERRACOTTA_WALL,
            YELLOW_TERRACOTTA_WALL,
            LIME_TERRACOTTA_WALL,
            PINK_TERRACOTTA_WALL,
            GRAY_TERRACOTTA_WALL,
            LIGHT_GRAY_TERRACOTTA_WALL,
            CYAN_TERRACOTTA_WALL,
            PURPLE_TERRACOTTA_WALL,
            BLUE_TERRACOTTA_WALL,
            BROWN_TERRACOTTA_WALL,
            GREEN_TERRACOTTA_WALL,
            RED_TERRACOTTA_WALL,
            BLACK_TERRACOTTA_WALL,

            WHITE_GLAZED_TERRACOTTA_WALL,
            ORANGE_GLAZED_TERRACOTTA_WALL,
            MAGENTA_GLAZED_TERRACOTTA_WALL,
            LIGHT_BLUE_GLAZED_TERRACOTTA_WALL,
            YELLOW_GLAZED_TERRACOTTA_WALL,
            LIME_GLAZED_TERRACOTTA_WALL,
            PINK_GLAZED_TERRACOTTA_WALL,
            GRAY_GLAZED_TERRACOTTA_WALL,
            LIGHT_GRAY_GLAZED_TERRACOTTA_WALL,
            CYAN_GLAZED_TERRACOTTA_WALL,
            PURPLE_GLAZED_TERRACOTTA_WALL,
            BLUE_GLAZED_TERRACOTTA_WALL,
            BROWN_GLAZED_TERRACOTTA_WALL,
            GREEN_GLAZED_TERRACOTTA_WALL,
            RED_GLAZED_TERRACOTTA_WALL,
            BLACK_GLAZED_TERRACOTTA_WALL,

            WHITE_CONCRETE_WALL,
            ORANGE_CONCRETE_WALL,
            MAGENTA_CONCRETE_WALL,
            LIGHT_BLUE_CONCRETE_WALL,
            YELLOW_CONCRETE_WALL,
            LIME_CONCRETE_WALL,
            PINK_CONCRETE_WALL,
            GRAY_CONCRETE_WALL,
            LIGHT_GRAY_CONCRETE_WALL,
            CYAN_CONCRETE_WALL,
            PURPLE_CONCRETE_WALL,
            BLUE_CONCRETE_WALL,
            BROWN_CONCRETE_WALL,
            GREEN_CONCRETE_WALL,
            RED_CONCRETE_WALL,
            BLACK_CONCRETE_WALL
        ));
    }

    @Override
    public void initializeClient() {
        for (GenericWallBlock block : WALLS) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }
    }

    @Override
    public void registerBlocks() {
        for (GenericWallBlock block : WALLS) {
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
