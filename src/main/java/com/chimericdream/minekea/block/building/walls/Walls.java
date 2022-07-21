package com.chimericdream.minekea.block.building.walls;

import com.chimericdream.minekea.block.building.dyed.DyedBlock.DyedBlockSettings;
import com.chimericdream.minekea.block.building.walls.GenericWallBlock.WallSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.config.MinekeaConfig;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import com.chimericdream.minekea.util.Colors;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Walls implements MinekeaBlockCategory {
    public static final Map<String, GenericWallBlock> WALLS = new LinkedHashMap<>();

    static {
        MinekeaConfig config = ConfigManager.getConfig();

        for (DefaultSettings settings : BaseBlockSettings.ALL_SETTINGS) {
            if (settings.hasWall()) {
                WALLS.put(settings.getMainMaterial(), new GenericWallBlock(new WallSettings(settings)));
            }

            if (config.enableDyedBlocks && settings.hasDyedBlocks()) {
                for (String color : Colors.getColors()) {
                    WALLS.put(String.format("%s/%s", settings.getMainMaterial(), color), new GenericWallBlock(new WallSettings(new DyedBlockSettings(settings).color(color).asDefaultSettings())));
                }
            }
        }
    }

    @Override
    public void initializeClient() {
        for (GenericWallBlock block : WALLS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }
    }

    @Override
    public void registerBlocks() {
        for (GenericWallBlock block : WALLS.values()) {
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
