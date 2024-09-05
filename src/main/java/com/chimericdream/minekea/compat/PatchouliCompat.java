//package com.chimericdream.minekea.compat;
//
//import com.chimericdream.minekea.config.ConfigManager;
//import com.chimericdream.minekea.config.MinekeaConfig;
//import vazkii.patchouli.api.PatchouliAPI;
//import vazkii.patchouli.api.PatchouliAPI.IPatchouliAPI;
//
//public class PatchouliCompat {
//    public static void init() {
//        MinekeaConfig config = ConfigManager.getConfig();
//
//        IPatchouliAPI patchouli = PatchouliAPI.get();
//
//        patchouli.setConfigFlag("minekea:enableBeams", config.enableBeams);
//        patchouli.setConfigFlag("minekea:enableButtons", config.enableButtons);
//        patchouli.setConfigFlag("minekea:enableCompressedBlocks", config.enableCompressedBlocks);
//        patchouli.setConfigFlag("minekea:enableCovers", config.enableCovers);
//        patchouli.setConfigFlag("minekea:enableSlabs", config.enableSlabs);
//        patchouli.setConfigFlag("minekea:enableStairs", config.enableStairs);
//        patchouli.setConfigFlag("minekea:enableVerticalStairs", config.enableVerticalStairs);
//        patchouli.setConfigFlag("minekea:enableWalls", config.enableWalls);
//        patchouli.setConfigFlag("minekea:enableBarrels", config.enableBarrels);
//        patchouli.setConfigFlag("minekea:enableCrates", config.enableCrates);
//        patchouli.setConfigFlag("minekea:enableBookshelves", config.enableBookshelves);
//        patchouli.setConfigFlag("minekea:enableStorageBookshelves", config.enableStorageBookshelves);
//        patchouli.setConfigFlag("minekea:enableDisplayCases", config.enableDisplayCases);
//        patchouli.setConfigFlag("minekea:enableDoors", config.enableDoors);
//        patchouli.setConfigFlag("minekea:enablePillows", config.enablePillows);
//        patchouli.setConfigFlag("minekea:enableChairs", config.enableChairs);
//        patchouli.setConfigFlag("minekea:enableStools", config.enableStools);
//        patchouli.setConfigFlag("minekea:enableShelves", config.enableShelves);
//        patchouli.setConfigFlag("minekea:enableShutters", config.enableShutters);
//        patchouli.setConfigFlag("minekea:enableTables", config.enableTables);
//        patchouli.setConfigFlag("minekea:enableTrapdoors", config.enableTrapdoors);
//        patchouli.setConfigFlag("minekea:overrideVanillaBarrelTexture", config.overrideVanillaBarrelTexture);
//        patchouli.setConfigFlag("minekea:overrideVanillaBookshelfTexture", config.overrideVanillaBookshelfTexture);
//        patchouli.setConfigFlag("minekea:enableCobbledEndStone", config.enableCobbledEndStone);
//    }
//}
