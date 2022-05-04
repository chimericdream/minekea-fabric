package com.chimericdream.minekea.item;

public class Items {
    public static final WrenchItem WRENCH_ITEM;

    static {
        WRENCH_ITEM = new WrenchItem();
    }

    public void register() {
        WRENCH_ITEM.register();
    }
}
