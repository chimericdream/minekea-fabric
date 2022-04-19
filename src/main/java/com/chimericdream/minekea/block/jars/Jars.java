package com.chimericdream.minekea.block.jars;

import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class Jars implements MinekeaBlockCategory {
    public static final GlassJarBlock GLASS_JAR;

    static {
        GLASS_JAR = new GlassJarBlock();
    }

    public void register() {
        GLASS_JAR.register();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), GLASS_JAR);
    }
}
