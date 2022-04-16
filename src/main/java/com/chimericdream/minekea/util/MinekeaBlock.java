package com.chimericdream.minekea.util;

import net.minecraft.util.Identifier;

import java.util.Map;

public interface MinekeaBlock {
    Identifier getBlockID();

    void register();

    default void setupResources() {
    }

    default void validateMaterials(Map<String, Identifier> materials) {
    }
}
