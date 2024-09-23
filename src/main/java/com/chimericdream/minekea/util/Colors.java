package com.chimericdream.minekea.util;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.DyeColor;

import java.util.List;

public class Colors {
    public static int[] WHITE = {0xf9fffe, 0xe4e4e4};
    public static int[] LIGHT_GRAY = {0x9d9d97, 0xa0a7a7};
    public static int[] GRAY = {0x474f52, 0x414141};
    public static int[] BLACK = {0x1d1d21, 0x181414};
    public static int[] BROWN = {0x835432, 0x56331c};
    public static int[] RED = {0xb02e26, 0x9e2b27};
    public static int[] ORANGE = {0xf9801d, 0xea7e35};
    public static int[] YELLOW = {0xfed83d, 0xc2b51c};
    public static int[] LIME = {0x80c71f, 0x39ba2e};
    public static int[] GREEN = {0x5e7c16, 0x364b18};
    public static int[] CYAN = {0x169c9c, 0x267191};
    public static int[] LIGHT_BLUE = {0x3ab3da, 0x6387d2};
    public static int[] BLUE = {0x3c44aa, 0x253193};
    public static int[] PURPLE = {0x8932b8, 0x7e34bf};
    public static int[] MAGENTA = {0xc74ebd, 0xbe49c9};
    public static int[] PINK = {0xf38baa, 0xd98199};

    public static String[] getColors() {
        return List.of(
            "white",
            "light_gray",
            "gray",
            "black",
            "brown",
            "red",
            "orange",
            "yellow",
            "lime",
            "green",
            "cyan",
            "light_blue",
            "blue",
            "purple",
            "magenta",
            "pink"
        ).toArray(new String[0]);
    }

    public static int getTint(int tintIndex, int[] variants) {
        if (tintIndex >= variants.length) {
            return variants[0];
        }

        return variants[tintIndex];
    }

    public static String getName(DyeColor color) {
        return getName(color.asString());
    }

    public static String getName(String color) {
        return switch (color) {
            case "white" -> "White";
            case "light_gray" -> "Light Gray";
            case "gray" -> "Gray";
            case "black" -> "Black";
            case "brown" -> "Brown";
            case "red" -> "Red";
            case "orange" -> "Orange";
            case "yellow" -> "Yellow";
            case "lime" -> "Lime";
            case "green" -> "Green";
            case "cyan" -> "Cyan";
            case "light_blue" -> "Light Blue";
            case "blue" -> "Blue";
            case "purple" -> "Purple";
            case "magenta" -> "Magenta";
            case "pink" -> "Pink";
            default -> throw new RuntimeException(String.format("Invalid color %s", color));
        };
    }

    public static Item getDye(DyeColor color) {
        return getDye(color.asString());
    }

    public static Item getDye(String color) {
        return switch (color) {
            case "white" -> Items.WHITE_DYE;
            case "light_gray" -> Items.LIGHT_GRAY_DYE;
            case "gray" -> Items.GRAY_DYE;
            case "black" -> Items.BLACK_DYE;
            case "brown" -> Items.BROWN_DYE;
            case "red" -> Items.RED_DYE;
            case "orange" -> Items.ORANGE_DYE;
            case "yellow" -> Items.YELLOW_DYE;
            case "lime" -> Items.LIME_DYE;
            case "green" -> Items.GREEN_DYE;
            case "cyan" -> Items.CYAN_DYE;
            case "light_blue" -> Items.LIGHT_BLUE_DYE;
            case "blue" -> Items.BLUE_DYE;
            case "purple" -> Items.PURPLE_DYE;
            case "magenta" -> Items.MAGENTA_DYE;
            case "pink" -> Items.PINK_DYE;
            default -> throw new RuntimeException(String.format("Invalid color %s", color));
        };
    }

    public static Block getWool(String color) {
        return switch (color) {
            case "white" -> Blocks.WHITE_WOOL;
            case "light_gray" -> Blocks.LIGHT_GRAY_WOOL;
            case "gray" -> Blocks.GRAY_WOOL;
            case "black" -> Blocks.BLACK_WOOL;
            case "brown" -> Blocks.BROWN_WOOL;
            case "red" -> Blocks.RED_WOOL;
            case "orange" -> Blocks.ORANGE_WOOL;
            case "yellow" -> Blocks.YELLOW_WOOL;
            case "lime" -> Blocks.LIME_WOOL;
            case "green" -> Blocks.GREEN_WOOL;
            case "cyan" -> Blocks.CYAN_WOOL;
            case "light_blue" -> Blocks.LIGHT_BLUE_WOOL;
            case "blue" -> Blocks.BLUE_WOOL;
            case "purple" -> Blocks.PURPLE_WOOL;
            case "magenta" -> Blocks.MAGENTA_WOOL;
            case "pink" -> Blocks.PINK_WOOL;
            default -> throw new RuntimeException(String.format("Invalid color %s", color));
        };
    }
}
