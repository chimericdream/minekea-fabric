//package com.chimericdream.minekea.block.furniture.tables;
//
//import com.chimericdream.minekea.block.furniture.tables.GenericTable.TableSettings;
//import com.chimericdream.minekea.compat.ModCompatLayer;
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import com.chimericdream.minekea.settings.BaseBlockSettings;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings;
//import com.chimericdream.minekea.util.MinekeaBlockCategory;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Tables implements MinekeaBlockCategory {
//    public static final Map<String, GenericTable> TABLES = new LinkedHashMap<>();
//
//    static {
//        for (MinekeaBlockSettings.DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
//            if (blockSettings.hasTable()) {
//                TABLES.put(blockSettings.getMainMaterial(), new GenericTable(new TableSettings(blockSettings)));
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
//        for (GenericTable block : TABLES.values()) {
//            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
//            block.register(settings.isFlammable());
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
//        MinekeaResourcePack.EN_US.entry(GenericTable.TOOLTIP_KEY, "Simple design, but somehow LACKing...");
//    }
//}
