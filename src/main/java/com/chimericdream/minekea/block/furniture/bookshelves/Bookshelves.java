package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.minekea.block.building.dyed.DyedBlock.DyedBlockSettings;
import com.chimericdream.minekea.block.furniture.bookshelves.GenericBookshelf.BookshelfSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.config.MinekeaConfig;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import com.chimericdream.minekea.util.Colors;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Bookshelves implements MinekeaBlockCategory {
    public static final Map<String, GenericBookshelf> BOOKSHELVES = new LinkedHashMap<>();

    static {
        MinekeaConfig config = ConfigManager.getConfig();

        for (DefaultSettings settings : BaseBlockSettings.ALL_SETTINGS) {
            if (settings.hasBookshelf()) {
                BOOKSHELVES.put(settings.getMainMaterial(), new GenericBookshelf(new BookshelfSettings(settings)));
            }

            if (config.enableDyedBlocks && settings.hasDyedBlocks()) {
                for (String color : Colors.getColors()) {
                    BOOKSHELVES.put(String.format("%s/%s", settings.getMainMaterial(), color), new GenericBookshelf(new BookshelfSettings(new DyedBlockSettings(settings).color(color).asDefaultSettings())));
                }
            }
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        for (GenericBookshelf block : BOOKSHELVES.values()) {
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
