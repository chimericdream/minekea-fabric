//package com.chimericdream.minekea.block.redstone.buttons;
//
//import com.chimericdream.minekea.block.redstone.buttons.GenericButton.ButtonSettings;
//import com.chimericdream.minekea.compat.ModCompatLayer;
//import com.chimericdream.minekea.settings.BaseBlockSettings;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
//import com.chimericdream.minekea.util.MinekeaBlockCategory;
//
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Buttons implements MinekeaBlockCategory {
//    public static final Map<String, GenericButton> BUTTONS = new LinkedHashMap<>();
//
//    static {
//        for (DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
//            if (blockSettings.hasButton()) {
//                BUTTONS.put(blockSettings.getMainMaterial(), new GenericButton(new ButtonSettings(blockSettings)));
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
//        for (GenericButton block : BUTTONS.values()) {
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
