package com.chimericdream.minekea.block.furniture.armoires;

import com.chimericdream.minekea.block.furniture.armoires.GenericArmoireBlock.ArmoireSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;

import java.util.List;

public class Armoires implements MinekeaBlockCategory {
    public static final GenericArmoireBlock ACACIA_ARMOIRE;
    public static final GenericArmoireBlock BIRCH_ARMOIRE;
    public static final GenericArmoireBlock CRIMSON_ARMOIRE;
    public static final GenericArmoireBlock DARK_OAK_ARMOIRE;
    public static final GenericArmoireBlock JUNGLE_ARMOIRE;
    public static final GenericArmoireBlock OAK_ARMOIRE;
    public static final GenericArmoireBlock SPRUCE_ARMOIRE;
    public static final GenericArmoireBlock WARPED_ARMOIRE;

    static {
        ACACIA_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.ACACIA));
        BIRCH_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.BIRCH));
        CRIMSON_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.CRIMSON));
        DARK_OAK_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.DARK_OAK));
        JUNGLE_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.JUNGLE));
        OAK_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.OAK));
        SPRUCE_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.SPRUCE));
        WARPED_ARMOIRE = new GenericArmoireBlock(new ArmoireSettings(BaseBlockSettings.WARPED));
    }

    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        ACACIA_ARMOIRE.register();
        BIRCH_ARMOIRE.register();
        CRIMSON_ARMOIRE.register();
        DARK_OAK_ARMOIRE.register();
        JUNGLE_ARMOIRE.register();
        OAK_ARMOIRE.register();
        SPRUCE_ARMOIRE.register();
        WARPED_ARMOIRE.register();
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
