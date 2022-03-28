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
        ACACIA_BARREL = new AcaciaBarrel();
        BIRCH_BARREL = new BirchBarrel();
        CRIMSON_BARREL = new CrimsonBarrel();
        DARK_OAK_BARREL = new DarkOakBarrel();
        JUNGLE_BARREL = new JungleBarrel();
        SPRUCE_BARREL = new SpruceBarrel();
        WARPED_BARREL = new WarpedBarrel();
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
