package com.chimericdream.minekea.util;

import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class TextHelpers {
    public static MutableText getTooltip(String tooltipId) {
        return formatTooltip(Text.translatable(tooltipId));
    }

    public static MutableText formatTooltip(MutableText tooltipText) {
        return tooltipText.formatted(Formatting.AQUA).formatted(Formatting.ITALIC);
    }
}
