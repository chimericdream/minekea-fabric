package com.chimericdream.minekea.util;

import net.minecraft.text.MutableText;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;

public class TextHelpers {
    public static MutableText getTooltip(String tooltipId) {
        return formatTooltip(new TranslatableText(tooltipId));
    }

    public static MutableText formatTooltip(TranslatableText tooltipText) {
        return tooltipText.formatted(Formatting.AQUA).formatted(Formatting.ITALIC);
    }
}