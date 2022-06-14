package com.chimericdream.minekea.block.building.beams;

import com.chimericdream.minekea.block.building.beams.GenericBeamBlock.BeamSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Beams implements MinekeaBlockCategory {
    public static final Map<String, GenericBeamBlock> BLOCKS = new HashMap<>();

    static {
        for (MinekeaBlockSettings.DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
            if (blockSettings.hasBeam()) {
                BLOCKS.put(blockSettings.getMainMaterial(), new GenericBeamBlock(new BeamSettings(blockSettings)));
            }
        }
    }

    @Override
    public void initializeClient() {
        for (GenericBeamBlock block : BLOCKS.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            if (settings.isTranslucent()) {
                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
            }
        }
    }

    @Override
    public void registerBlocks() {
        for (GenericBeamBlock block : BLOCKS.values()) {
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
