package com.chimericdream.minekea.client.render.color;

import net.minecraft.client.color.item.ItemColorProvider;

public class ItemColorProviders {
    public static ItemColorProvider WHITE = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.WHITE);
    public static ItemColorProvider ORANGE = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.ORANGE);
    public static ItemColorProvider MAGENTA = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.MAGENTA);
    public static ItemColorProvider LIGHT_BLUE = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.LIGHT_BLUE);
    public static ItemColorProvider YELLOW = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.YELLOW);
    public static ItemColorProvider LIME = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.LIME);
    public static ItemColorProvider PINK = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.PINK);
    public static ItemColorProvider GRAY = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.GRAY);
    public static ItemColorProvider LIGHT_GRAY = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.LIGHT_GRAY);
    public static ItemColorProvider CYAN = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.CYAN);
    public static ItemColorProvider PURPLE = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.PURPLE);
    public static ItemColorProvider BLUE = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.BLUE);
    public static ItemColorProvider BROWN = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.BROWN);
    public static ItemColorProvider GREEN = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.GREEN);
    public static ItemColorProvider RED = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.RED);
    public static ItemColorProvider BLACK = (stack, tintIndex) -> Colors.getTint(tintIndex, Colors.BLACK);
}
