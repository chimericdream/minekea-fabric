package com.chimericdream.minekea.block.furniture;

import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import java.util.ArrayList;
import java.util.List;

public class FurnitureBlocks implements MinekeaBlockCategory {
    //    public static Bookshelves BOOKSHELVES;
    public static DisplayCases DISPLAY_CASES;
//    public static Doors DOORS;
//    public static Pillows PILLOWS;
//    public static Seats SEATS;
//    public static Shelves SHELVES;
//    public static StorageBookshelves STORAGE_BOOKSHELVES;
//    public static Shutters SHUTTERS;
//    public static Tables TABLES;
//    public static Trapdoors TRAPDOORS;

    private static final List<MinekeaBlockCategory> BLOCK_GROUPS = new ArrayList<>();

    static {
//        MinekeaConfig config = ConfigManager.getConfig();

//        if (config.enableBookshelves) {
//            BOOKSHELVES = new Bookshelves();
//            BLOCK_GROUPS.add(BOOKSHELVES);
//        }

//        if (config.enableDisplayCases) {
        DISPLAY_CASES = new DisplayCases();
        BLOCK_GROUPS.add(DISPLAY_CASES);
//        }

//        if (config.enableDoors) {
//            DOORS = new Doors();
//            BLOCK_GROUPS.add(DOORS);
//        }
//
//        if (config.enablePillows) {
//            PILLOWS = new Pillows();
//            BLOCK_GROUPS.add(PILLOWS);
//        }
//
//        if (config.enableChairs || config.enableStools) {
//            SEATS = new Seats();
//            BLOCK_GROUPS.add(SEATS);
//        }
//
//        if (config.enableShelves) {
//            SHELVES = new Shelves();
//            BLOCK_GROUPS.add(SHELVES);
//        }
//
//        if (config.enableStorageBookshelves) {
//            STORAGE_BOOKSHELVES = new StorageBookshelves();
//            BLOCK_GROUPS.add(STORAGE_BOOKSHELVES);
//        }
//
//        if (config.enableShutters) {
//            SHUTTERS = new Shutters();
//            BLOCK_GROUPS.add(SHUTTERS);
//        }
//
//        if (config.enableTables) {
//            TABLES = new Tables();
//            BLOCK_GROUPS.add(TABLES);
//        }
//
//        if (config.enableTrapdoors) {
//            TRAPDOORS = new Trapdoors();
//            BLOCK_GROUPS.add(TRAPDOORS);
//        }
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
    public void registerBlockEntities() {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerBlockEntities();
        }
    }

    @Override
    public void registerEntities() {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerEntities();
        }
    }

    @Override
    public void setupResources() {
//        MinekeaConfig config = ConfigManager.getConfig();
//
//        MinekeaResourcePack.EN_US.entry("block.minecraft.bookshelf", "Oak Bookshelf");
//
//        if (config.overrideVanillaBookshelfTexture) {
//            for (int i = 0; i <= 6; i++) {
//                MinekeaResourcePack.RESOURCE_PACK.addModel(
//                    JModel.model("minekea:block/furniture/bookshelves/bookshelf")
//                        .textures(
//                            new JTextures()
//                                .var("material", "minecraft:block/oak_planks")
//                                .var("shelf", String.format("minekea:block/furniture/bookshelves/shelf%d", i))
//                        ),
//                    Identifier.of(ModInfo.MOD_ID, String.format("block/bookshelves/oak/shelf%d", i))
//                );
//            }
//
//            MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//                JState.state(
//                    JState.variant()
//                        .put("", new JBlockModel(Identifier.of(ModInfo.MOD_ID, "block/bookshelves/oak/shelf0")))
//                        .put("", new JBlockModel(Identifier.of(ModInfo.MOD_ID, "block/bookshelves/oak/shelf1")))
//                        .put("", new JBlockModel(Identifier.of(ModInfo.MOD_ID, "block/bookshelves/oak/shelf2")))
//                        .put("", new JBlockModel(Identifier.of(ModInfo.MOD_ID, "block/bookshelves/oak/shelf3")))
//                        .put("", new JBlockModel(Identifier.of(ModInfo.MOD_ID, "block/bookshelves/oak/shelf4")))
//                        .put("", new JBlockModel(Identifier.of(ModInfo.MOD_ID, "block/bookshelves/oak/shelf5")))
//                        .put("", new JBlockModel(Identifier.of(ModInfo.MOD_ID, "block/bookshelves/oak/shelf6")))
//                ),
//                Identifier.of("minecraft:bookshelf")
//            );
//        }
//
//        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
//            group.setupResources();
//        }
    }
}
