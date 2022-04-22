package com.chimericdream.minekea.block.decorations;

public class DecorationBlocks {
    public static final FakeCake FAKE_CAKE;

    static {
        FAKE_CAKE = new FakeCake();
    }

    public void register() {
        FAKE_CAKE.register();
    }
}
