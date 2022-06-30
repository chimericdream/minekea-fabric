package com.chimericdream.minekea.block.redstone;

import com.chimericdream.minekea.block.redstone.buttons.Buttons;
import com.chimericdream.minekea.block.redstone.pressure_plates.PressurePlates;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.config.MinekeaConfig;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.ArrayList;
import java.util.List;

public class RedstoneBlocks implements MinekeaBlockCategory {
    public static Buttons BUTTONS = null;
    public static PressurePlates PRESSURE_PLATES = null;

    private static final List<MinekeaBlockCategory> BLOCK_GROUPS = new ArrayList<>();

    static {
        MinekeaConfig config = ConfigManager.getConfig();

        if (config.enableButtons) {
            BUTTONS = new Buttons();
            BLOCK_GROUPS.add(BUTTONS);
        }

        if (config.enablePressurePlates) {
            PRESSURE_PLATES = new PressurePlates();
            BLOCK_GROUPS.add(PRESSURE_PLATES);
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.initializeClient();
        }
    }

    @Override
    public void registerBlocks() {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerBlocks();
        }
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerBlockEntities(otherMods);
        }
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerEntities(otherMods);
        }
    }

    @Override
    public void setupResources() {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.setupResources();
        }
    }
}
