package com.chimericdream.minekea.util;

public interface MinekeaBlockCategory {
    default void onInitializeClient() {
    }

    void register();
}
