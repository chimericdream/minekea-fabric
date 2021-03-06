package com.chimericdream.minekea.util;

import net.minecraft.util.Identifier;

import java.util.List;

public class Colors {
    public static int[] WHITE = {0xf9fffe, 0xe4e4e4};
    public static int[] ORANGE = {0xf9801d, 0xea7e35};
    public static int[] MAGENTA = {0xc74ebd, 0xbe49c9};
    public static int[] LIGHT_BLUE = {0x3ab3da, 0x6387d2};
    public static int[] YELLOW = {0xfed83d, 0xc2b51c};
    public static int[] LIME = {0x80c71f, 0x39ba2e};
    public static int[] PINK = {0xf38baa, 0xd98199};
    public static int[] GRAY = {0x474f52, 0x414141};
    public static int[] LIGHT_GRAY = {0x9d9d97, 0xa0a7a7};
    public static int[] CYAN = {0x169c9c, 0x267191};
    public static int[] PURPLE = {0x8932b8, 0x7e34bf};
    public static int[] BLUE = {0x3c44aa, 0x253193};
    public static int[] BROWN = {0x835432, 0x56331c};
    public static int[] GREEN = {0x5e7c16, 0x364b18};
    public static int[] RED = {0xb02e26, 0x9e2b27};
    public static int[] BLACK = {0x1d1d21, 0x181414};

    public static String[] getColors() {
        return List.of(
            "white",
            "orange",
            "magenta",
            "light_blue",
            "yellow",
            "lime",
            "pink",
            "gray",
            "light_gray",
            "cyan",
            "purple",
            "blue",
            "brown",
            "green",
            "red",
            "black"
        ).toArray(new String[0]);
    }

    public static int getTint(int tintIndex, int[] variants) {
        if (tintIndex >= variants.length) {
            return variants[0];
        }

        return variants[tintIndex];
    }

    public static String getName(String key) {
        return switch (key) {
            case "white" -> "White";
            case "orange" -> "Orange";
            case "magenta" -> "Magenta";
            case "light_blue" -> "Light Blue";
            case "yellow" -> "Yellow";
            case "lime" -> "Lime";
            case "pink" -> "Pink";
            case "gray" -> "Gray";
            case "light_gray" -> "Light Gray";
            case "cyan" -> "Cyan";
            case "purple" -> "Purple";
            case "blue" -> "Blue";
            case "brown" -> "Brown";
            case "green" -> "Green";
            case "red" -> "Red";
            case "black" -> "Black";
            default -> "";
        };
    }

    public static Identifier getDye(String key) {
        return switch (key) {
            case "white" -> new Identifier("minecraft:white_dye");
            case "orange" -> new Identifier("minecraft:orange_dye");
            case "magenta" -> new Identifier("minecraft:magenta_dye");
            case "light_blue" -> new Identifier("minecraft:light_blue_dye");
            case "yellow" -> new Identifier("minecraft:yellow_dye");
            case "lime" -> new Identifier("minecraft:lime_dye");
            case "pink" -> new Identifier("minecraft:pink_dye");
            case "gray" -> new Identifier("minecraft:gray_dye");
            case "light_gray" -> new Identifier("minecraft:light_gray_dye");
            case "cyan" -> new Identifier("minecraft:cyan_dye");
            case "purple" -> new Identifier("minecraft:purple_dye");
            case "blue" -> new Identifier("minecraft:blue_dye");
            case "brown" -> new Identifier("minecraft:brown_dye");
            case "green" -> new Identifier("minecraft:green_dye");
            case "red" -> new Identifier("minecraft:red_dye");
            case "black" -> new Identifier("minecraft:black_dye");
            default -> new Identifier("");
        };
    }
}
