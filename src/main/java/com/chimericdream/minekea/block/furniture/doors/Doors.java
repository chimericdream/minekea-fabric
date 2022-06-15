package com.chimericdream.minekea.block.furniture.doors;

import com.chimericdream.minekea.block.furniture.doors.GenericBookshelfDoor.BookshelfDoorSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Doors implements MinekeaBlockCategory {
    public static final Map<String, GenericBookshelfDoor> BOOKSHELF_DOORS = new LinkedHashMap<>();

    static {
        for (MinekeaBlockSettings.DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
            if (blockSettings.hasBookshelfDoor()) {
                BOOKSHELF_DOORS.put(blockSettings.getMainMaterial(), new GenericBookshelfDoor(new BookshelfDoorSettings(blockSettings).addMaterial("bookshelf", blockSettings.getBookshelfId())));
            }
        }
    }

    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        for (GenericBookshelfDoor block : BOOKSHELF_DOORS.values()) {
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
