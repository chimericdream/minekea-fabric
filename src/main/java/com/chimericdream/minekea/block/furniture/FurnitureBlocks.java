package com.chimericdream.minekea.block.furniture;

import com.chimericdream.minekea.block.furniture.armoires.Armoires;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
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

import java.util.ArrayList;
import java.util.List;

public class FurnitureBlocks implements MinekeaBlockCategory {
    public static final Armoires ARMOIRES;
    public static final Bookshelves BOOKSHELVES;
    public static final DisplayCases DISPLAY_CASES;
    public static final Doors DOORS;
    public static final Seats SEATS;
    public static final Shelves SHELVES;
    public static final Tables TABLES;
    public static final Trapdoors TRAPDOORS;

    protected static final List<MinekeaBlockCategory> SUB_CATEGORIES = new ArrayList<>();

    static {
        ARMOIRES = new Armoires();
        BOOKSHELVES = new Bookshelves();
        DISPLAY_CASES = new DisplayCases();
        DOORS = new Doors();
        SEATS = new Seats();
        SHELVES = new Shelves();
        TABLES = new Tables();
        TRAPDOORS = new Trapdoors();

        SUB_CATEGORIES.addAll(List.of(
            ARMOIRES,
            BOOKSHELVES,
            DISPLAY_CASES,
            DOORS,
            SEATS,
            SHELVES,
            TABLES,
            TRAPDOORS
        ));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        for (MinekeaBlockCategory cat : SUB_CATEGORIES) {
            cat.initializeClient();
        }
    }

    @Override
    public void registerBlocks() {
        for (MinekeaBlockCategory cat : SUB_CATEGORIES) {
            cat.registerBlocks();
        }
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        for (MinekeaBlockCategory cat : SUB_CATEGORIES) {
            cat.registerBlockEntities(otherMods);
        }
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
        for (MinekeaBlockCategory cat : SUB_CATEGORIES) {
            cat.registerEntities(otherMods);
        }
    }

    @Override
    public void setupResources() {
        for (MinekeaBlockCategory cat : SUB_CATEGORIES) {
            cat.setupResources();
        }
    }
}
