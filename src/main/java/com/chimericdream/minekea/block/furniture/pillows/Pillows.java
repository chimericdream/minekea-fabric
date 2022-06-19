package com.chimericdream.minekea.block.furniture.pillows;

import com.chimericdream.minekea.block.furniture.pillows.PillowBlock.PillowBlockSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;

import java.util.LinkedList;
import java.util.List;

public class Pillows implements MinekeaBlockCategory {
    public static final PillowBlock WHITE_PILLOW;
    public static final PillowBlock ORANGE_PILLOW;
    public static final PillowBlock MAGENTA_PILLOW;
    public static final PillowBlock LIGHT_BLUE_PILLOW;
    public static final PillowBlock YELLOW_PILLOW;
    public static final PillowBlock LIME_PILLOW;
    public static final PillowBlock PINK_PILLOW;
    public static final PillowBlock GRAY_PILLOW;
    public static final PillowBlock LIGHT_GRAY_PILLOW;
    public static final PillowBlock CYAN_PILLOW;
    public static final PillowBlock PURPLE_PILLOW;
    public static final PillowBlock BLUE_PILLOW;
    public static final PillowBlock BROWN_PILLOW;
    public static final PillowBlock GREEN_PILLOW;
    public static final PillowBlock RED_PILLOW;
    public static final PillowBlock BLACK_PILLOW;

    public static final List<PillowBlock> PILLOWS = new LinkedList<>();

    static {
        WHITE_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.WHITE_WOOL).color("white"));
        ORANGE_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.ORANGE_WOOL).color("orange"));
        MAGENTA_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.MAGENTA_WOOL).color("magenta"));
        LIGHT_BLUE_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.LIGHT_BLUE_WOOL).color("light_blue"));
        YELLOW_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.YELLOW_WOOL).color("yellow"));
        LIME_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.LIME_WOOL).color("lime"));
        PINK_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.PINK_WOOL).color("pink"));
        GRAY_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.GRAY_WOOL).color("gray"));
        LIGHT_GRAY_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.LIGHT_GRAY_WOOL).color("light_gray"));
        CYAN_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.CYAN_WOOL).color("cyan"));
        PURPLE_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.PURPLE_WOOL).color("purple"));
        BLUE_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.BLUE_WOOL).color("blue"));
        BROWN_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.BROWN_WOOL).color("brown"));
        GREEN_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.GREEN_WOOL).color("green"));
        RED_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.RED_WOOL).color("red"));
        BLACK_PILLOW = new PillowBlock(new PillowBlockSettings(BaseBlockSettings.BLACK_WOOL).color("black"));

        PILLOWS.addAll(List.of(
            WHITE_PILLOW,
            ORANGE_PILLOW,
            MAGENTA_PILLOW,
            LIGHT_BLUE_PILLOW,
            YELLOW_PILLOW,
            LIME_PILLOW,
            PINK_PILLOW,
            GRAY_PILLOW,
            LIGHT_GRAY_PILLOW,
            CYAN_PILLOW,
            PURPLE_PILLOW,
            BLUE_PILLOW,
            BROWN_PILLOW,
            GREEN_PILLOW,
            RED_PILLOW,
            BLACK_PILLOW
        ));
    }

    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        for (PillowBlock block : PILLOWS) {
            block.register();
        }
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
