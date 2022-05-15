package com.chimericdream.minekea.block.furniture;

import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
import com.chimericdream.minekea.block.furniture.seating.Seats;
import com.chimericdream.minekea.block.furniture.shelves.Shelves;
import com.chimericdream.minekea.block.furniture.tables.Tables;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.List;

public class FurnitureBlocks implements MinekeaBlockCategory {
    public static final DisplayCases DISPLAY_CASES;
    public static final Seats SEATS;
    public static final Shelves SHELVES;
    public static final Tables TABLES;

    static {
        DISPLAY_CASES = new DisplayCases();
        SEATS = new Seats();
        SHELVES = new Shelves();
        TABLES = new Tables();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        DISPLAY_CASES.initializeClient();
        SEATS.initializeClient();
        SHELVES.initializeClient();
        TABLES.initializeClient();
    }

    @Override
    public void registerBlocks() {
        DISPLAY_CASES.registerBlocks();
        SEATS.registerBlocks();
        SHELVES.registerBlocks();
        TABLES.registerBlocks();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        DISPLAY_CASES.registerBlockEntities(otherMods);
        SEATS.registerBlockEntities(otherMods);
        SHELVES.registerBlockEntities(otherMods);
        TABLES.registerBlockEntities(otherMods);
    }
}
