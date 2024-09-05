//package com.chimericdream.minekea.block.furniture.trapdoors;
//
//import com.chimericdream.minekea.block.furniture.trapdoors.GenericBookshelfTrapdoor.BookshelfTrapdoorSettings;
//import com.chimericdream.minekea.compat.ModCompatLayer;
//import com.chimericdream.minekea.settings.BaseBlockSettings;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings;
//import com.chimericdream.minekea.util.MinekeaBlockCategory;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Trapdoors implements MinekeaBlockCategory {
//    public static final Map<String, GenericBookshelfTrapdoor> BOOKSHELF_TRAPDOORS = new LinkedHashMap<>();
//
//    static {
//        for (MinekeaBlockSettings.DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
//            if (blockSettings.hasBookshelfTrapdoor()) {
//                BOOKSHELF_TRAPDOORS.put(blockSettings.getMainMaterial(), new GenericBookshelfTrapdoor(new BookshelfTrapdoorSettings(blockSettings).addMaterial("bookshelf", blockSettings.getBookshelfId())));
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
//        for (GenericBookshelfTrapdoor block : BOOKSHELF_TRAPDOORS.values()) {
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
//    }
//}
