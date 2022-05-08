package com.chimericdream.minekea.block.building;

import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;

import java.util.List;

public class BuildingBlocks implements MinekeaBlockCategory {
    public static final BasaltBricksBlock SMOOTH_BASALT_BRICKS_BLOCK;

    static {
        SMOOTH_BASALT_BRICKS_BLOCK = new BasaltBricksBlock();
    }

    @Override
    public void registerBlocks() {
        SMOOTH_BASALT_BRICKS_BLOCK.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }
}
