package com.chimericdream.minekea.block.decorations;

import com.chimericdream.minekea.block.decorations.lighting.DoomLantern;
import com.chimericdream.minekea.block.decorations.lighting.EndLantern;
import com.chimericdream.minekea.block.decorations.lighting.EndlessRod;
import com.chimericdream.minekea.block.decorations.misc.FakeCake;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import java.util.List;

public class DecorationBlocks implements MinekeaBlockCategory {
    public static final DoomLantern DOOM_LANTERN;
    public static final EndLantern END_LANTERN;
    public static final EndlessRod ENDLESS_ROD;
    public static final FakeCake FAKE_CAKE;

    static {
        DOOM_LANTERN = new DoomLantern();
        END_LANTERN = new EndLantern();
        ENDLESS_ROD = new EndlessRod();
        FAKE_CAKE = new FakeCake();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), DOOM_LANTERN, END_LANTERN);
    }

    @Override
    public void registerBlocks() {
        DOOM_LANTERN.register();
        END_LANTERN.register();
        ENDLESS_ROD.register();
        FAKE_CAKE.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
    }
}
