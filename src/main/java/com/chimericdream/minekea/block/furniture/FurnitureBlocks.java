package com.chimericdream.minekea.block.furniture;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.block.furniture.bookshelves.StorageBookshelves;
import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
import com.chimericdream.minekea.block.furniture.doors.Doors;
import com.chimericdream.minekea.block.furniture.pillows.Pillows;
import com.chimericdream.minekea.block.furniture.seating.Seats;
import com.chimericdream.minekea.block.furniture.shelves.Shelves;
import com.chimericdream.minekea.block.furniture.shutters.Shutters;
import com.chimericdream.minekea.block.furniture.tables.Tables;
import com.chimericdream.minekea.block.furniture.trapdoors.Trapdoors;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.config.MinekeaConfig;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class FurnitureBlocks implements MinekeaBlockCategory {
    public static Bookshelves BOOKSHELVES = null;
    public static DisplayCases DISPLAY_CASES = null;
    public static Doors DOORS = null;
    public static Pillows PILLOWS = null;
    public static Seats SEATS = null;
    public static Shelves SHELVES = null;
    public static StorageBookshelves STORAGE_BOOKSHELVES = null;
    public static Shutters SHUTTERS = null;
    public static Tables TABLES = null;
    public static Trapdoors TRAPDOORS = null;

    private static final List<MinekeaBlockCategory> BLOCK_GROUPS = new ArrayList<>();

    static {
        MinekeaConfig config = ConfigManager.getConfig();

        if (config.enableBookshelves) {
            BOOKSHELVES = new Bookshelves();
            BLOCK_GROUPS.add(BOOKSHELVES);
        }

        if (config.enableDisplayCases) {
            DISPLAY_CASES = new DisplayCases();
            BLOCK_GROUPS.add(DISPLAY_CASES);
        }

        if (config.enableDoors) {
            DOORS = new Doors();
            BLOCK_GROUPS.add(DOORS);
        }

        if (config.enablePillows) {
            PILLOWS = new Pillows();
            BLOCK_GROUPS.add(PILLOWS);
        }

        if (config.enableChairs || config.enableStools) {
            SEATS = new Seats();
            BLOCK_GROUPS.add(SEATS);
        }

        if (config.enableShelves) {
            SHELVES = new Shelves();
            BLOCK_GROUPS.add(SHELVES);
        }

        if (config.enableStorageBookshelves) {
            STORAGE_BOOKSHELVES = new StorageBookshelves();
            BLOCK_GROUPS.add(STORAGE_BOOKSHELVES);
        }

        if (config.enableShutters) {
            SHUTTERS = new Shutters();
            BLOCK_GROUPS.add(SHUTTERS);
        }

        if (config.enableTables) {
            TABLES = new Tables();
            BLOCK_GROUPS.add(TABLES);
        }

        if (config.enableTrapdoors) {
            TRAPDOORS = new Trapdoors();
            BLOCK_GROUPS.add(TRAPDOORS);
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
        MinekeaConfig config = ConfigManager.getConfig();

        MinekeaResourcePack.EN_US.entry("block.minecraft.bookshelf", "Oak Bookshelf");

        if (config.overrideVanillaBookshelfTexture) {
            for (int i = 0; i <= 6; i++) {
                MinekeaResourcePack.RESOURCE_PACK.addModel(
                    JModel.model("minekea:block/furniture/bookshelves/bookshelf")
                        .textures(
                            new JTextures()
                                .var("material", "minecraft:block/oak_planks")
                                .var("shelf", String.format("minekea:block/furniture/bookshelves/shelf%d", i))
                        ),
                    new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/oak/shelf%d", i))
                );
            }

            MinekeaResourcePack.RESOURCE_PACK.addBlockState(
                JState.state(
                    JState.variant()
                        .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, "block/bookshelves/oak/shelf0")))
                        .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, "block/bookshelves/oak/shelf1")))
                        .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, "block/bookshelves/oak/shelf2")))
                        .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, "block/bookshelves/oak/shelf3")))
                        .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, "block/bookshelves/oak/shelf4")))
                        .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, "block/bookshelves/oak/shelf5")))
                        .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, "block/bookshelves/oak/shelf6")))
                ),
                new Identifier("minecraft:bookshelf")
            );
        }

        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.setupResources();
        }
    }
}
