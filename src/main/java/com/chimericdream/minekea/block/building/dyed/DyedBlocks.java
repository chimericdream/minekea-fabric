package com.chimericdream.minekea.block.building.dyed;

import com.chimericdream.minekea.block.building.dyed.DyedBlock.DyedBlockSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DyedBlocks implements MinekeaBlockCategory {
    public static final Map<String, DyedBlock> BLOCKS = new LinkedHashMap<>();
    public static final List<DefaultSettings> BLOCK_TYPES = new ArrayList<>();

    static {
        for (DefaultSettings settings : BaseBlockSettings.ALL_SETTINGS) {
            if (settings.hasDyedBlocks()) {
                BLOCK_TYPES.add(settings);

                BLOCKS.put(settings.getMainMaterial() + "white", new DyedBlock(new DyedBlockSettings(settings).color("white")));
                BLOCKS.put(settings.getMainMaterial() + "orange", new DyedBlock(new DyedBlockSettings(settings).color("orange")));
                BLOCKS.put(settings.getMainMaterial() + "magenta", new DyedBlock(new DyedBlockSettings(settings).color("magenta")));
                BLOCKS.put(settings.getMainMaterial() + "light_blue", new DyedBlock(new DyedBlockSettings(settings).color("light_blue")));
                BLOCKS.put(settings.getMainMaterial() + "yellow", new DyedBlock(new DyedBlockSettings(settings).color("yellow")));
                BLOCKS.put(settings.getMainMaterial() + "lime", new DyedBlock(new DyedBlockSettings(settings).color("lime")));
                BLOCKS.put(settings.getMainMaterial() + "pink", new DyedBlock(new DyedBlockSettings(settings).color("pink")));
                BLOCKS.put(settings.getMainMaterial() + "gray", new DyedBlock(new DyedBlockSettings(settings).color("gray")));
                BLOCKS.put(settings.getMainMaterial() + "light_gray", new DyedBlock(new DyedBlockSettings(settings).color("light_gray")));
                BLOCKS.put(settings.getMainMaterial() + "cyan", new DyedBlock(new DyedBlockSettings(settings).color("cyan")));
                BLOCKS.put(settings.getMainMaterial() + "purple", new DyedBlock(new DyedBlockSettings(settings).color("purple")));
                BLOCKS.put(settings.getMainMaterial() + "blue", new DyedBlock(new DyedBlockSettings(settings).color("blue")));
                BLOCKS.put(settings.getMainMaterial() + "brown", new DyedBlock(new DyedBlockSettings(settings).color("brown")));
                BLOCKS.put(settings.getMainMaterial() + "green", new DyedBlock(new DyedBlockSettings(settings).color("green")));
                BLOCKS.put(settings.getMainMaterial() + "red", new DyedBlock(new DyedBlockSettings(settings).color("red")));
                BLOCKS.put(settings.getMainMaterial() + "black", new DyedBlock(new DyedBlockSettings(settings).color("black")));
            }
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        for (DyedBlock block : BLOCKS.values()) {
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
