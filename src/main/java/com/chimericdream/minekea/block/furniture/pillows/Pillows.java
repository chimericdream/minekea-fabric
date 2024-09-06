package com.chimericdream.minekea.block.furniture.pillows;

import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import java.util.LinkedList;
import java.util.List;

import static com.chimericdream.minekea.item.ItemGroups.FURNITURE_ITEM_GROUP_KEY;

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
        WHITE_PILLOW = new PillowBlock("white");
        ORANGE_PILLOW = new PillowBlock("orange");
        MAGENTA_PILLOW = new PillowBlock("magenta");
        LIGHT_BLUE_PILLOW = new PillowBlock("light_blue");
        YELLOW_PILLOW = new PillowBlock("yellow");
        LIME_PILLOW = new PillowBlock("lime");
        PINK_PILLOW = new PillowBlock("pink");
        GRAY_PILLOW = new PillowBlock("gray");
        LIGHT_GRAY_PILLOW = new PillowBlock("light_gray");
        CYAN_PILLOW = new PillowBlock("cyan");
        PURPLE_PILLOW = new PillowBlock("purple");
        BLUE_PILLOW = new PillowBlock("blue");
        BROWN_PILLOW = new PillowBlock("brown");
        GREEN_PILLOW = new PillowBlock("green");
        RED_PILLOW = new PillowBlock("red");
        BLACK_PILLOW = new PillowBlock("black");

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

        ItemGroupEvents.modifyEntriesEvent(FURNITURE_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(WHITE_PILLOW);
            itemGroup.add(ORANGE_PILLOW);
            itemGroup.add(MAGENTA_PILLOW);
            itemGroup.add(LIGHT_BLUE_PILLOW);
            itemGroup.add(YELLOW_PILLOW);
            itemGroup.add(LIME_PILLOW);
            itemGroup.add(PINK_PILLOW);
            itemGroup.add(GRAY_PILLOW);
            itemGroup.add(LIGHT_GRAY_PILLOW);
            itemGroup.add(CYAN_PILLOW);
            itemGroup.add(PURPLE_PILLOW);
            itemGroup.add(BLUE_PILLOW);
            itemGroup.add(BROWN_PILLOW);
            itemGroup.add(GREEN_PILLOW);
            itemGroup.add(RED_PILLOW);
            itemGroup.add(BLACK_PILLOW);
        });
    }

    @Override
    public void registerBlockEntities() {
    }

    @Override
    public void registerEntities() {
    }

    @Override
    public void setupResources() {
//        MinekeaResourcePack.EN_US.entry(PillowBlock.TRANSLATION_KEY, "Pillow");
    }
}
