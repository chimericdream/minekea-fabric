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
    public static final GenericWallBlock COBBLED_END_STONE_WALL;

    public static final List<GenericWallBlock> WALLS = new ArrayList<>();

    static {
        COBBLED_END_STONE_WALL = new GenericWallBlock(new WallSettings(BaseBlockSettings.COBBLED_END_STONE));

        WALLS.addAll(List.of(
            COBBLED_END_STONE_WALL
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
