package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.minekea.block.furniture.bookshelves.GenericBookshelf.BookshelfSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Bookshelves implements MinekeaBlockCategory {
    public static final Map<String, GenericBookshelf> BOOKSHELVES = new LinkedHashMap<>();

    static {
        for (MinekeaBlockSettings.DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
            if (blockSettings.hasBookshelf()) {
                BOOKSHELVES.put(blockSettings.getMainMaterial(), new GenericBookshelf(new BookshelfSettings(blockSettings)));
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
