package com.chimericdream.minekea.item;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class Items {
    public static final PainterItem PAINTER_ITEM;
    public static final WrenchItem WRENCH_ITEM;

    static {
        PAINTER_ITEM = new PainterItem();
        WRENCH_ITEM = new WrenchItem();
    }

    public void register() {
        PAINTER_ITEM.register();
        WRENCH_ITEM.register();
    }

    @Environment(EnvType.CLIENT)
    public void initializeClient() {
    }
}
