package com.chimericdream.minekea.block.building.covers;

import com.chimericdream.minekea.block.building.covers.GenericCoverBlock.CoverSettings;
import com.chimericdream.minekea.block.building.dyed.DyedBlock.DyedBlockSettings;
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

public class Covers implements MinekeaBlockCategory {
    public static final Map<String, GenericCoverBlock> BLOCKS = new LinkedHashMap<>();

    static {
        MinekeaConfig config = ConfigManager.getConfig();

        for (DefaultSettings settings : BaseBlockSettings.ALL_SETTINGS) {
            if (settings.hasCover()) {
                BLOCKS.put(settings.getMainMaterial(), new GenericCoverBlock(new CoverSettings(settings)));
            }

            if (config.enableDyedBlocks && settings.hasDyedBlocks()) {
                for (String color : Colors.getColors()) {
                    BLOCKS.put(String.format("%s/%s", settings.getMainMaterial(), color), new GenericCoverBlock(new CoverSettings(new DyedBlockSettings(settings).color(color).asDefaultSettings())));
                }
            }
        }
    }

    @Override
    public void initializeClient() {
        for (GenericCoverBlock block : BLOCKS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }
    }

    @Override
    public void registerBlocks() {
        for (GenericCoverBlock block : BLOCKS.values()) {
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
