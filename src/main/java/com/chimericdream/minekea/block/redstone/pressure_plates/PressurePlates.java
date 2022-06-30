package com.chimericdream.minekea.block.redstone.pressure_plates;

import com.chimericdream.minekea.block.redstone.pressure_plates.GenericPressurePlate.PressurePlateSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class PressurePlates implements MinekeaBlockCategory {
    public static final Map<String, GenericPressurePlate> PRESSURE_PLATES = new LinkedHashMap<>();

    static {
        for (DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
            if (blockSettings.hasPressurePlate()) {
                PRESSURE_PLATES.put(blockSettings.getMainMaterial(), new GenericPressurePlate(new PressurePlateSettings(blockSettings)));
            }
        }
    }

    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        for (GenericPressurePlate block : PRESSURE_PLATES.values()) {
            block.register();
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
