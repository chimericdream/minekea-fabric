//package com.chimericdream.minekea.block.furniture.shutters;
//
//import com.chimericdream.minekea.block.furniture.shutters.ShutterBlock.ShutterSettings;
//import com.chimericdream.minekea.compat.ModCompatLayer;
//import com.chimericdream.minekea.settings.BaseBlockSettings;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings;
//import com.chimericdream.minekea.util.MinekeaBlockCategory;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Shutters implements MinekeaBlockCategory {
//    public static final Map<String, ShutterBlock> SHUTTERS = new LinkedHashMap<>();
//    public static final Map<String, OpenShutterHalf> OPEN_SHUTTER_HALVES = new LinkedHashMap<>();
//
//    static {
//        for (MinekeaBlockSettings.DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
//            if (blockSettings.hasShutters()) {
//                SHUTTERS.put(blockSettings.getMainMaterial(), new ShutterBlock(new ShutterSettings(blockSettings)));
//                OPEN_SHUTTER_HALVES.put(blockSettings.getMainMaterial(), new OpenShutterHalf(new ShutterSettings(blockSettings)));
//            }
//        }
//    }
//
//    @Override
//    public void initializeClient() {
//    }
//
//    @Override
//    public void registerBlocks() {
//        for (ShutterBlock block : SHUTTERS.values()) {
//            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
//            block.register(settings.isFlammable());
//        }
//
//        for (OpenShutterHalf block : OPEN_SHUTTER_HALVES.values()) {
//            block.register();
//        }
//    }
//
//    @Override
//    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
//    }
//
//    @Override
//    public void registerEntities(List<ModCompatLayer> otherMods) {
//    }
//
//    @Override
//    public void setupResources() {
//    }
//}
