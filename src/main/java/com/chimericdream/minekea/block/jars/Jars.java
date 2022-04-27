package com.chimericdream.minekea.block.jars;

import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import java.util.List;

public class Jars implements MinekeaBlockCategory {
    public static final GlassJarBlock GLASS_JAR;

    static {
        GLASS_JAR = new GlassJarBlock();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), GLASS_JAR);
    }

    @Override
    public void registerBlocks() {
        GLASS_JAR.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }
}
