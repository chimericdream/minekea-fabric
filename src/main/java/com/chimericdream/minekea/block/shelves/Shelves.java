package com.chimericdream.minekea.block.shelves;

import net.minecraft.util.Identifier;

import java.util.Map;

public class Shelves {
    public static final GenericShelf ACACIA_SHELF;
    public static final GenericShelf BIRCH_SHELF;
    public static final GenericShelf CRIMSON_SHELF;
    public static final GenericShelf DARK_OAK_SHELF;
    public static final GenericShelf JUNGLE_SHELF;
    public static final GenericShelf OAK_SHELF;
    public static final GenericShelf SPRUCE_SHELF;
    public static final GenericShelf WARPED_SHELF;

    public static final GenericFloatingShelf ACACIA_FLOATING_SHELF;
    public static final GenericFloatingShelf BIRCH_FLOATING_SHELF;
    public static final GenericFloatingShelf CRIMSON_FLOATING_SHELF;
    public static final GenericFloatingShelf DARK_OAK_FLOATING_SHELF;
    public static final GenericFloatingShelf JUNGLE_FLOATING_SHELF;
    public static final GenericFloatingShelf OAK_FLOATING_SHELF;
    public static final GenericFloatingShelf SPRUCE_FLOATING_SHELF;
    public static final GenericFloatingShelf WARPED_FLOATING_SHELF;

    static {
        ACACIA_SHELF = new GenericShelf("acacia", Map.of("slab", new Identifier("minecraft:acacia_slab"), "planks", new Identifier("minecraft:acacia_planks"), "log", new Identifier("minecraft:stripped_acacia_log")));
        BIRCH_SHELF = new GenericShelf("birch", Map.of("slab", new Identifier("minecraft:birch_slab"), "planks", new Identifier("minecraft:birch_planks"), "log", new Identifier("minecraft:stripped_birch_log")));
        CRIMSON_SHELF = new GenericShelf("crimson", Map.of("slab", new Identifier("minecraft:crimson_slab"), "planks", new Identifier("minecraft:crimson_planks"), "log", new Identifier("minecraft:stripped_crimson_stem")));
        DARK_OAK_SHELF = new GenericShelf("dark_oak", Map.of("slab", new Identifier("minecraft:dark_oak_slab"), "planks", new Identifier("minecraft:dark_oak_planks"), "log", new Identifier("minecraft:stripped_dark_oak_log")));
        JUNGLE_SHELF = new GenericShelf("jungle", Map.of("slab", new Identifier("minecraft:jungle_slab"), "planks", new Identifier("minecraft:jungle_planks"), "log", new Identifier("minecraft:stripped_jungle_log")));
        OAK_SHELF = new GenericShelf("oak", Map.of("slab", new Identifier("minecraft:oak_slab"), "planks", new Identifier("minecraft:oak_planks"), "log", new Identifier("minecraft:stripped_oak_log")));
        SPRUCE_SHELF = new GenericShelf("spruce", Map.of("slab", new Identifier("minecraft:spruce_slab"), "planks", new Identifier("minecraft:spruce_planks"), "log", new Identifier("minecraft:stripped_spruce_log")));
        WARPED_SHELF = new GenericShelf("warped", Map.of("slab", new Identifier("minecraft:warped_slab"), "planks", new Identifier("minecraft:warped_planks"), "log", new Identifier("minecraft:stripped_warped_stem")));

        ACACIA_FLOATING_SHELF = new GenericFloatingShelf("acacia", Map.of("slab", new Identifier("minecraft:acacia_slab"), "planks", new Identifier("minecraft:acacia_planks")));
        BIRCH_FLOATING_SHELF = new GenericFloatingShelf("birch", Map.of("slab", new Identifier("minecraft:birch_slab"), "planks", new Identifier("minecraft:birch_planks")));
        CRIMSON_FLOATING_SHELF = new GenericFloatingShelf("crimson", Map.of("slab", new Identifier("minecraft:crimson_slab"), "planks", new Identifier("minecraft:crimson_planks")));
        DARK_OAK_FLOATING_SHELF = new GenericFloatingShelf("dark_oak", Map.of("slab", new Identifier("minecraft:dark_oak_slab"), "planks", new Identifier("minecraft:dark_oak_planks")));
        JUNGLE_FLOATING_SHELF = new GenericFloatingShelf("jungle", Map.of("slab", new Identifier("minecraft:jungle_slab"), "planks", new Identifier("minecraft:jungle_planks")));
        OAK_FLOATING_SHELF = new GenericFloatingShelf("oak", Map.of("slab", new Identifier("minecraft:oak_slab"), "planks", new Identifier("minecraft:oak_planks")));
        SPRUCE_FLOATING_SHELF = new GenericFloatingShelf("spruce", Map.of("slab", new Identifier("minecraft:spruce_slab"), "planks", new Identifier("minecraft:spruce_planks")));
        WARPED_FLOATING_SHELF = new GenericFloatingShelf("warped", Map.of("slab", new Identifier("minecraft:warped_slab"), "planks", new Identifier("minecraft:warped_planks")));
    }

    public void register() {
        ACACIA_SHELF.register();
        BIRCH_SHELF.register();
        CRIMSON_SHELF.register();
        DARK_OAK_SHELF.register();
        JUNGLE_SHELF.register();
        OAK_SHELF.register();
        SPRUCE_SHELF.register();
        WARPED_SHELF.register();

        ACACIA_FLOATING_SHELF.register();
        BIRCH_FLOATING_SHELF.register();
        CRIMSON_FLOATING_SHELF.register();
        DARK_OAK_FLOATING_SHELF.register();
        JUNGLE_FLOATING_SHELF.register();
        OAK_FLOATING_SHELF.register();
        SPRUCE_FLOATING_SHELF.register();
        WARPED_FLOATING_SHELF.register();
    }
}
