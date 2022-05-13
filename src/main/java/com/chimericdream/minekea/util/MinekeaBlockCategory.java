package com.chimericdream.minekea.util;

import com.chimericdream.minekea.compat.ModCompatLayer;

import java.util.List;

public interface MinekeaBlockCategory {
    default void initializeClient() {
    }

    default void setupResources() {
    }

    void registerBlocks();

    void registerBlockEntities(List<ModCompatLayer> otherMods);
}
