package com.chimericdream.minekea.block.barrels;

import net.minecraft.util.Identifier;

public class Barrels {
    public static final GenericBarrel ACACIA_BARREL;
    public static final GenericBarrel BIRCH_BARREL;
    public static final GenericBarrel CRIMSON_BARREL;
    public static final GenericBarrel DARK_OAK_BARREL;
    public static final GenericBarrel JUNGLE_BARREL;
    public static final GenericBarrel SPRUCE_BARREL;
    public static final GenericBarrel WARPED_BARREL;

    static {
        ACACIA_BARREL = new GenericBarrel(
            "acacia",
            new Identifier[]{
                new Identifier("minecraft:acacia_planks"),
                new Identifier("minecraft:acacia_slab"),
                new Identifier("minecraft:stripped_acacia_log")
            }
        );
        BIRCH_BARREL = new GenericBarrel(
            "birch",
            new Identifier[]{
                new Identifier("minecraft:birch_planks"),
                new Identifier("minecraft:birch_slab"),
                new Identifier("minecraft:stripped_birch_log")
            }
        );
        CRIMSON_BARREL = new GenericBarrel(
            "crimson",
            new Identifier[]{
                new Identifier("minecraft:crimson_planks"),
                new Identifier("minecraft:crimson_slab"),
                new Identifier("minecraft:stripped_crimson_stem")
            }
        );
        DARK_OAK_BARREL = new GenericBarrel(
            "dark_oak",
            new Identifier[]{
                new Identifier("minecraft:dark_oak_planks"),
                new Identifier("minecraft:dark_oak_slab"),
                new Identifier("minecraft:stripped_dark_oak_log")
            }
        );
        JUNGLE_BARREL = new GenericBarrel(
            "jungle",
            new Identifier[]{
                new Identifier("minecraft:jungle_planks"),
                new Identifier("minecraft:jungle_slab"),
                new Identifier("minecraft:stripped_jungle_log")
            }
        );
        SPRUCE_BARREL = new GenericBarrel(
            "spruce",
            new Identifier[]{
                new Identifier("minecraft:spruce_planks"),
                new Identifier("minecraft:spruce_slab"),
                new Identifier("minecraft:stripped_spruce_log")
            }
        );
        WARPED_BARREL = new GenericBarrel(
            "warped",
            new Identifier[]{
                new Identifier("minecraft:warped_planks"),
                new Identifier("minecraft:warped_slab"),
                new Identifier("minecraft:stripped_warped_stem")
            }
        );
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
