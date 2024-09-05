//package com.chimericdream.minekea.block.furniture.bookshelves;
//
//import com.chimericdream.minekea.block.furniture.bookshelves.GenericBookshelf.BookshelfSettings;
//import com.chimericdream.minekea.settings.BaseBlockSettings;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
//import com.chimericdream.minekea.util.MinekeaBlockCategory;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class Bookshelves implements MinekeaBlockCategory {
//    public static final Map<String, GenericBookshelf> BOOKSHELVES = new LinkedHashMap<>();
//
//    static {
//        for (DefaultSettings settings : BaseBlockSettings.ALL_SETTINGS) {
//            if (settings.hasBookshelf()) {
//                BOOKSHELVES.put(settings.getMainMaterial(), new GenericBookshelf(new BookshelfSettings(settings)));
//            }
//        }
//    }
//
//    @Environment(EnvType.CLIENT)
//    @Override
//    public void initializeClient() {
//    }
//
//    @Override
//    public void registerBlocks() {
//        for (GenericBookshelf block : BOOKSHELVES.values()) {
//            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
//            block.register(settings.isFlammable());
//        }
//    }
//
//    @Override
//    public void setupResources() {
//    }
//}
