package com.chimericdream.minekea.block.furniture.pillows;

import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class Pillows implements MinekeaBlockCategory {
    public static final PillowBlock WHITE_PILLOW;
    public static final PillowBlock LIGHT_GRAY_PILLOW;
    public static final PillowBlock GRAY_PILLOW;
    public static final PillowBlock BLACK_PILLOW;
    public static final PillowBlock BROWN_PILLOW;
    public static final PillowBlock RED_PILLOW;
    public static final PillowBlock ORANGE_PILLOW;
    public static final PillowBlock YELLOW_PILLOW;
    public static final PillowBlock LIME_PILLOW;
    public static final PillowBlock GREEN_PILLOW;
    public static final PillowBlock CYAN_PILLOW;
    public static final PillowBlock LIGHT_BLUE_PILLOW;
    public static final PillowBlock BLUE_PILLOW;
    public static final PillowBlock PURPLE_PILLOW;
    public static final PillowBlock MAGENTA_PILLOW;
    public static final PillowBlock PINK_PILLOW;

    public static final List<Block> BLOCKS = new ArrayList<>();

    static {
        WHITE_PILLOW = new PillowBlock("white");
        LIGHT_GRAY_PILLOW = new PillowBlock("light_gray");
        GRAY_PILLOW = new PillowBlock("gray");
        BLACK_PILLOW = new PillowBlock("black");
        BROWN_PILLOW = new PillowBlock("brown");
        RED_PILLOW = new PillowBlock("red");
        ORANGE_PILLOW = new PillowBlock("orange");
        YELLOW_PILLOW = new PillowBlock("yellow");
        LIME_PILLOW = new PillowBlock("lime");
        GREEN_PILLOW = new PillowBlock("green");
        CYAN_PILLOW = new PillowBlock("cyan");
        LIGHT_BLUE_PILLOW = new PillowBlock("light_blue");
        BLUE_PILLOW = new PillowBlock("blue");
        PURPLE_PILLOW = new PillowBlock("purple");
        MAGENTA_PILLOW = new PillowBlock("magenta");
        PINK_PILLOW = new PillowBlock("pink");

        BLOCKS.addAll(List.of(
            WHITE_PILLOW,
            LIGHT_GRAY_PILLOW,
            GRAY_PILLOW,
            BLACK_PILLOW,
            BROWN_PILLOW,
            RED_PILLOW,
            ORANGE_PILLOW,
            YELLOW_PILLOW,
            LIME_PILLOW,
            GREEN_PILLOW,
            CYAN_PILLOW,
            LIGHT_BLUE_PILLOW,
            BLUE_PILLOW,
            PURPLE_PILLOW,
            MAGENTA_PILLOW,
            PINK_PILLOW
        ));
    }

    public List<Block> getCategoryBlocks() {
        return BLOCKS;
    }
}
