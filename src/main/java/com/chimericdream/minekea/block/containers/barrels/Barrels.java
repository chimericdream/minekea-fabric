package com.chimericdream.minekea.block.containers.barrels;

import com.chimericdream.minekea.block.containers.barrels.GenericBarrel.BarrelSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;

import java.util.List;

public class Barrels implements MinekeaBlockCategory {
    public static final GenericBarrel ACACIA_BARREL;
    public static final GenericBarrel BIRCH_BARREL;
    public static final GenericBarrel CRIMSON_BARREL;
    public static final GenericBarrel DARK_OAK_BARREL;
    public static final GenericBarrel JUNGLE_BARREL;
    public static final GenericBarrel SPRUCE_BARREL;
    public static final GenericBarrel WARPED_BARREL;

    static {
        ACACIA_BARREL = new GenericBarrel(new BarrelSettings(BaseBlockSettings.ACACIA));
        BIRCH_BARREL = new GenericBarrel(new BarrelSettings(BaseBlockSettings.BIRCH));
        CRIMSON_BARREL = new GenericBarrel(new BarrelSettings(BaseBlockSettings.CRIMSON));
        DARK_OAK_BARREL = new GenericBarrel(new BarrelSettings(BaseBlockSettings.DARK_OAK));
        JUNGLE_BARREL = new GenericBarrel(new BarrelSettings(BaseBlockSettings.JUNGLE));
        SPRUCE_BARREL = new GenericBarrel(new BarrelSettings(BaseBlockSettings.SPRUCE));
        WARPED_BARREL = new GenericBarrel(new BarrelSettings(BaseBlockSettings.WARPED));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getTranslucent(),
            Blocks.BARREL,
            ACACIA_BARREL,
            BIRCH_BARREL,
            CRIMSON_BARREL,
            DARK_OAK_BARREL,
            JUNGLE_BARREL,
            SPRUCE_BARREL,
            WARPED_BARREL
        );
    }

    @Override
    public void registerBlocks() {
        ACACIA_BARREL.register();
        BIRCH_BARREL.register();
        CRIMSON_BARREL.register();
        DARK_OAK_BARREL.register();
        JUNGLE_BARREL.register();
        SPRUCE_BARREL.register();
        WARPED_BARREL.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.entry("block.minecraft.barrel", "Oak Barrel");
    }
}
