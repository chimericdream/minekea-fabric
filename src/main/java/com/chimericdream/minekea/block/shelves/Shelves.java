package com.chimericdream.minekea.block.shelves;

import net.minecraft.util.Identifier;

import java.util.Map;

public class Shelves {
    public static final GenericFloatingShelf ACACIA_FLOATING_SHELF;
    public static final GenericFloatingShelf BIRCH_FLOATING_SHELF;
    public static final GenericFloatingShelf CRIMSON_FLOATING_SHELF;
    public static final GenericFloatingShelf DARK_OAK_FLOATING_SHELF;
    public static final GenericFloatingShelf JUNGLE_FLOATING_SHELF;
    public static final GenericFloatingShelf OAK_FLOATING_SHELF;
    public static final GenericFloatingShelf SPRUCE_FLOATING_SHELF;
    public static final GenericFloatingShelf WARPED_FLOATING_SHELF;

    static {
        ACACIA_FLOATING_SHELF = new GenericFloatingShelf("acacia", Map.of("planks", new Identifier("minecraft:acacia_planks")));
        BIRCH_FLOATING_SHELF = new GenericFloatingShelf("birch", Map.of("planks", new Identifier("minecraft:birch_planks")));
        CRIMSON_FLOATING_SHELF = new GenericFloatingShelf("crimson", Map.of("planks", new Identifier("minecraft:crimson_planks")));
        DARK_OAK_FLOATING_SHELF = new GenericFloatingShelf("dark_oak", Map.of("planks", new Identifier("minecraft:dark_oak_planks")));
        JUNGLE_FLOATING_SHELF = new GenericFloatingShelf("jungle", Map.of("planks", new Identifier("minecraft:jungle_planks")));
        OAK_FLOATING_SHELF = new GenericFloatingShelf("oak", Map.of("planks", new Identifier("minecraft:oak_planks")));
        SPRUCE_FLOATING_SHELF = new GenericFloatingShelf("spruce", Map.of("planks", new Identifier("minecraft:spruce_planks")));
        WARPED_FLOATING_SHELF = new GenericFloatingShelf("warped", Map.of("planks", new Identifier("minecraft:warped_planks")));
    }

    public void register() {
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
