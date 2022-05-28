package com.chimericdream.minekea.block.furniture;

import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
import com.chimericdream.minekea.block.furniture.doors.Doors;
import com.chimericdream.minekea.block.furniture.seating.Seats;
import com.chimericdream.minekea.block.furniture.shelves.Shelves;
import com.chimericdream.minekea.block.furniture.tables.Tables;
import com.chimericdream.minekea.block.furniture.trapdoors.Trapdoors;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.List;

public class FurnitureBlocks implements MinekeaBlockCategory {
    public static final DisplayCases DISPLAY_CASES;
    public static final Doors DOORS;
    public static final Seats SEATS;
    public static final Shelves SHELVES;
    public static final Tables TABLES;
    public static final Trapdoors TRAPDOORS;

    static {
        DISPLAY_CASES = new DisplayCases();
        DOORS = new Doors();
        SEATS = new Seats();
        SHELVES = new Shelves();
        TABLES = new Tables();
        TRAPDOORS = new Trapdoors();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        DISPLAY_CASES.initializeClient();
        DOORS.initializeClient();
        SEATS.initializeClient();
        SHELVES.initializeClient();
        TABLES.initializeClient();
        TRAPDOORS.initializeClient();
    }

    @Override
    public void registerBlocks() {
        DISPLAY_CASES.registerBlocks();
        DOORS.registerBlocks();
        SEATS.registerBlocks();
        SHELVES.registerBlocks();
        TABLES.registerBlocks();
        TRAPDOORS.registerBlocks();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        DISPLAY_CASES.registerBlockEntities(otherMods);
        DOORS.registerBlockEntities(otherMods);
        SEATS.registerBlockEntities(otherMods);
        SHELVES.registerBlockEntities(otherMods);
        TABLES.registerBlockEntities(otherMods);
        TRAPDOORS.registerBlockEntities(otherMods);
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
        DISPLAY_CASES.registerEntities(otherMods);
        DOORS.registerEntities(otherMods);
        SEATS.registerEntities(otherMods);
        SHELVES.registerEntities(otherMods);
        TABLES.registerEntities(otherMods);
        TRAPDOORS.registerEntities(otherMods);
    }

    @Override
    public void setupResources() {
        DISPLAY_CASES.setupResources();
        DOORS.setupResources();
        SEATS.setupResources();
        SHELVES.setupResources();
        TABLES.setupResources();
        TRAPDOORS.setupResources();
    }
}
