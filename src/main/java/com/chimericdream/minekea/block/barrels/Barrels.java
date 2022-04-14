package com.chimericdream.minekea.block.barrels;

import net.minecraft.util.Identifier;

import java.util.Map;

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
            Map.of(
                "planks", new Identifier("minecraft:acacia_planks"),
                "slab", new Identifier("minecraft:acacia_slab"),
                "log", new Identifier("minecraft:stripped_acacia_log")
            )
        );
        BIRCH_BARREL = new GenericBarrel(
            "birch",
            Map.of(
                "planks", new Identifier("minecraft:birch_planks"),
                "slab", new Identifier("minecraft:birch_slab"),
                "log", new Identifier("minecraft:stripped_birch_log")
            )
        );
        CRIMSON_BARREL = new GenericBarrel(
            "crimson",
            Map.of(
                "planks", new Identifier("minecraft:crimson_planks"),
                "slab", new Identifier("minecraft:crimson_slab"),
                "log", new Identifier("minecraft:stripped_crimson_stem")
            )
        );
        DARK_OAK_BARREL = new GenericBarrel(
            "dark_oak",
            Map.of(
                "planks", new Identifier("minecraft:dark_oak_planks"),
                "slab", new Identifier("minecraft:dark_oak_slab"),
                "log", new Identifier("minecraft:stripped_dark_oak_log")
            )
        );
        JUNGLE_BARREL = new GenericBarrel(
            "jungle",
            Map.of(
                "planks", new Identifier("minecraft:jungle_planks"),
                "slab", new Identifier("minecraft:jungle_slab"),
                "log", new Identifier("minecraft:stripped_jungle_log")
            )
        );
        SPRUCE_BARREL = new GenericBarrel(
            "spruce",
            Map.of(
                "planks", new Identifier("minecraft:spruce_planks"),
                "slab", new Identifier("minecraft:spruce_slab"),
                "log", new Identifier("minecraft:stripped_spruce_log")
            )
        );
        WARPED_BARREL = new GenericBarrel(
            "warped",
            Map.of(
                "planks", new Identifier("minecraft:warped_planks"),
                "slab", new Identifier("minecraft:warped_slab"),
                "log", new Identifier("minecraft:stripped_warped_stem")
            )
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
