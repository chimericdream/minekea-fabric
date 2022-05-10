package com.chimericdream.minekea.block.building;

import com.chimericdream.minekea.block.building.basalt_bricks.*;
import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBrickSlabBlock;
import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBrickStairsBlock;
import com.chimericdream.minekea.block.building.warped_nether_bricks.WarpedNetherBricksBlock;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;

import java.util.List;

public class BuildingBlocks implements MinekeaBlockCategory {
    public static final BasaltBricksBlock BASALT_BRICKS_BLOCK;
    public static final ChiseledBasaltBricksBlock CHISELED_BASALT_BRICKS_BLOCK;
    public static final CrackedBasaltBricksBlock CRACKED_BASALT_BRICKS_BLOCK;
    public static final CrimsonBasaltBricksBlock CRIMSON_BASALT_BRICKS_BLOCK;
    public static final MossyBasaltBricksBlock MOSSY_BASALT_BRICKS_BLOCK;
    public static final WarpedBasaltBricksBlock WARPED_BASALT_BRICKS_BLOCK;

    public static final WarpedNetherBrickSlabBlock WARPED_NETHER_BRICK_SLAB_BLOCK;
    public static final WarpedNetherBrickStairsBlock WARPED_NETHER_BRICK_STAIRS_BLOCK;
    public static final WarpedNetherBricksBlock WARPED_NETHER_BRICKS_BLOCK;

    static {
        BASALT_BRICKS_BLOCK = new BasaltBricksBlock();
        CHISELED_BASALT_BRICKS_BLOCK = new ChiseledBasaltBricksBlock();
        CRACKED_BASALT_BRICKS_BLOCK = new CrackedBasaltBricksBlock();
        CRIMSON_BASALT_BRICKS_BLOCK = new CrimsonBasaltBricksBlock();
        MOSSY_BASALT_BRICKS_BLOCK = new MossyBasaltBricksBlock();
        WARPED_BASALT_BRICKS_BLOCK = new WarpedBasaltBricksBlock();

        WARPED_NETHER_BRICK_SLAB_BLOCK = new WarpedNetherBrickSlabBlock();
        WARPED_NETHER_BRICK_STAIRS_BLOCK = new WarpedNetherBrickStairsBlock();
        WARPED_NETHER_BRICKS_BLOCK = new WarpedNetherBricksBlock();
    }

    @Override
    public void registerBlocks() {
        BASALT_BRICKS_BLOCK.register();
        CHISELED_BASALT_BRICKS_BLOCK.register();
        CRACKED_BASALT_BRICKS_BLOCK.register();
        CRIMSON_BASALT_BRICKS_BLOCK.register();
        MOSSY_BASALT_BRICKS_BLOCK.register();
        WARPED_BASALT_BRICKS_BLOCK.register();

        WARPED_NETHER_BRICK_SLAB_BLOCK.register();
        WARPED_NETHER_BRICK_STAIRS_BLOCK.register();
        WARPED_NETHER_BRICKS_BLOCK.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }
}
