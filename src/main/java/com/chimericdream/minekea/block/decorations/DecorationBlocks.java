package com.chimericdream.minekea.block.decorations;

import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;

import java.util.List;

public class DecorationBlocks implements MinekeaBlockCategory {
    public static final FakeCake FAKE_CAKE;

    static {
        FAKE_CAKE = new FakeCake();
    }

    @Override
    public void registerBlocks() {
        FAKE_CAKE.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }
}
