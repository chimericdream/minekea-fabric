package com.chimericdream.minekea.client.render.color;

import net.minecraft.client.color.block.BlockColorProvider;

public class BlockColorProviders {
    public static BlockColorProvider WHITE = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.WHITE);
    public static BlockColorProvider ORANGE = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.ORANGE);
    public static BlockColorProvider MAGENTA = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.MAGENTA);
    public static BlockColorProvider LIGHT_BLUE = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.LIGHT_BLUE);
    public static BlockColorProvider YELLOW = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.YELLOW);
    public static BlockColorProvider LIME = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.LIME);
    public static BlockColorProvider PINK = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.PINK);
    public static BlockColorProvider GRAY = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.GRAY);
    public static BlockColorProvider LIGHT_GRAY = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.LIGHT_GRAY);
    public static BlockColorProvider CYAN = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.CYAN);
    public static BlockColorProvider PURPLE = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.PURPLE);
    public static BlockColorProvider BLUE = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.BLUE);
    public static BlockColorProvider BROWN = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.BROWN);
    public static BlockColorProvider GREEN = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.GREEN);
    public static BlockColorProvider RED = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.RED);
    public static BlockColorProvider BLACK = (state, view, pos, tintIndex) -> Colors.getTint(tintIndex, Colors.BLACK);
}
