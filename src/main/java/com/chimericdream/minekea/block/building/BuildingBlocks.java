package com.chimericdream.minekea.block.building;

import com.chimericdream.minekea.block.building.basalt_bricks.*;
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

    static {
        BASALT_BRICKS_BLOCK = new BasaltBricksBlock();
        CHISELED_BASALT_BRICKS_BLOCK = new ChiseledBasaltBricksBlock();
        CRACKED_BASALT_BRICKS_BLOCK = new CrackedBasaltBricksBlock();
        CRIMSON_BASALT_BRICKS_BLOCK = new CrimsonBasaltBricksBlock();
        MOSSY_BASALT_BRICKS_BLOCK = new MossyBasaltBricksBlock();
        WARPED_BASALT_BRICKS_BLOCK = new WarpedBasaltBricksBlock();
    }

    @Override
    public void registerBlocks() {
        BASALT_BRICKS_BLOCK.register();
        CHISELED_BASALT_BRICKS_BLOCK.register();
        CRACKED_BASALT_BRICKS_BLOCK.register();
        CRIMSON_BASALT_BRICKS_BLOCK.register();
        MOSSY_BASALT_BRICKS_BLOCK.register();
        WARPED_BASALT_BRICKS_BLOCK.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }
}
