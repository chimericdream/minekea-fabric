//package com.chimericdream.minekea.block.building.beams;
//
//import com.chimericdream.minekea.block.building.beams.GenericBeamBlock.BeamSettings;
//import com.chimericdream.minekea.config.ConfigManager;
//import com.chimericdream.minekea.config.MinekeaConfig;
//import com.chimericdream.minekea.settings.BaseBlockSettings;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
//import com.chimericdream.minekea.util.MinekeaBlockCategory;
//import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
//import net.minecraft.client.render.RenderLayer;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class Beams implements MinekeaBlockCategory {
//    public static final Map<String, GenericBeamBlock> BLOCKS = new LinkedHashMap<>();
//
//    static {
//        MinekeaConfig config = ConfigManager.getConfig();
//
//        for (DefaultSettings settings : BaseBlockSettings.ALL_SETTINGS) {
//            if (settings.hasBeam()) {
//                BLOCKS.put(settings.getMainMaterial(), new GenericBeamBlock(new BeamSettings(settings)));
//            }
//        }
//    }
//
//    @Override
//    public void initializeClient() {
//        for (GenericBeamBlock block : BLOCKS.values()) {
//            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
//            if (settings.isTranslucent()) {
//                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
//            }
//        }
//    }
//
//    @Override
//    public void registerBlocks() {
//        for (GenericBeamBlock block : BLOCKS.values()) {
//            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
//            block.register(settings.isFlammable());
//        }
//    }
//
//    @Override
//    public void registerBlockEntities() {
//    }
//
//    @Override
//    public void registerEntities() {
//    }
//
//    @Override
//    public void setupResources() {
//    }
//}
