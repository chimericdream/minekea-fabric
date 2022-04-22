package com.chimericdream.minekea.block.decorations;

import com.chimericdream.minekea.util.MinekeaBlockCategory;

public class DecorationBlocks implements MinekeaBlockCategory {
    public static final FakeCake FAKE_CAKE;

    static {
        FAKE_CAKE = new FakeCake();
    }

    public void register() {
        FAKE_CAKE.register();
    }
}
