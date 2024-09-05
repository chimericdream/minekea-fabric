//package com.chimericdream.minekea.block.building.walls;
//
//import com.chimericdream.minekea.block.building.walls.GenericWallBlock.WallSettings;
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
//public class Walls implements MinekeaBlockCategory {
//    public static final Map<String, GenericWallBlock> WALLS = new LinkedHashMap<>();
//
//    static {
//        for (DefaultSettings settings : BaseBlockSettings.ALL_SETTINGS) {
//            if (settings.hasWall()) {
//                WALLS.put(settings.getMainMaterial(), new GenericWallBlock(new WallSettings(settings)));
//            }
//        }
//    }
//
//    @Override
//    public void initializeClient() {
//        for (GenericWallBlock block : WALLS.values()) {
//            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
//            if (settings.isTranslucent()) {
//                BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent());
//            }
//        }
//    }
//
//    @Override
//    public void registerBlocks() {
//        for (GenericWallBlock block : WALLS.values()) {
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
