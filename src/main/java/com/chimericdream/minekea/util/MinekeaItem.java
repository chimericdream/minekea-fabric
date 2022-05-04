package com.chimericdream.minekea.util;

import net.minecraft.util.Identifier;

public interface MinekeaItem {
    Identifier getItemID();

    void register();

    default void setupResources() {
    }
}
