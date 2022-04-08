package com.chimericdream.minekea.block.barrels;

public class Barrels {
    public static final GenericBarrel ACACIA_BARREL;
    public static final GenericBarrel BIRCH_BARREL;
    public static final GenericBarrel CRIMSON_BARREL;
    public static final GenericBarrel DARK_OAK_BARREL;
    public static final GenericBarrel JUNGLE_BARREL;
    public static final GenericBarrel SPRUCE_BARREL;
    public static final GenericBarrel WARPED_BARREL;

    static {
        ACACIA_BARREL = new GenericBarrel("acacia");
        BIRCH_BARREL = new GenericBarrel("birch");
        CRIMSON_BARREL = new GenericBarrel("crimson");
        DARK_OAK_BARREL = new GenericBarrel("dark_oak");
        JUNGLE_BARREL = new GenericBarrel("jungle");
        SPRUCE_BARREL = new GenericBarrel("spruce");
        WARPED_BARREL = new GenericBarrel("warped");
    }

    public void register() {
        ACACIA_BARREL.register();
        BIRCH_BARREL.register();
        CRIMSON_BARREL.register();
        DARK_OAK_BARREL.register();
        JUNGLE_BARREL.register();
        SPRUCE_BARREL.register();
        WARPED_BARREL.register();
    }
}
