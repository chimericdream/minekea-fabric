package com.chimericdream.minekea.util;

import net.minecraft.util.Identifier;

public interface MinekeaBlock {
    Identifier getBlockID();

    void register();

    default void setupResources() {
    }
}
