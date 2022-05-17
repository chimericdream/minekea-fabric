package com.chimericdream.minekea.block.furniture.tables;

import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class Tables implements MinekeaBlockCategory {
    public static final GenericTable ACACIA_TABLE;
    public static final GenericTable BIRCH_TABLE;
    public static final GenericTable CRIMSON_TABLE;
    public static final GenericTable DARK_OAK_TABLE;
    public static final GenericTable JUNGLE_TABLE;
    public static final GenericTable OAK_TABLE;
    public static final GenericTable SPRUCE_TABLE;
    public static final GenericTable WARPED_TABLE;

    static {
        ACACIA_TABLE = new GenericTable(
            "acacia",
            Map.of("planks", new Identifier("minecraft:acacia_planks"), "log", new Identifier("minecraft:acacia_log"))
        );
        BIRCH_TABLE = new GenericTable(
            "birch",
            Map.of("planks", new Identifier("minecraft:birch_planks"), "log", new Identifier("minecraft:birch_log"))
        );
        CRIMSON_TABLE = new GenericTable(
            "crimson",
            Map.of("planks", new Identifier("minecraft:crimson_planks"), "log", new Identifier("minecraft:crimson_stem"))
        );
        DARK_OAK_TABLE = new GenericTable(
            "dark_oak",
            Map.of("planks", new Identifier("minecraft:dark_oak_planks"), "log", new Identifier("minecraft:dark_oak_log"))
        );
        JUNGLE_TABLE = new GenericTable(
            "jungle",
            Map.of("planks", new Identifier("minecraft:jungle_planks"), "log", new Identifier("minecraft:jungle_log"))
        );
        OAK_TABLE = new GenericTable(
            "oak",
            Map.of("planks", new Identifier("minecraft:oak_planks"), "log", new Identifier("minecraft:oak_log"))
        );
        SPRUCE_TABLE = new GenericTable(
            "spruce",
            Map.of("planks", new Identifier("minecraft:spruce_planks"), "log", new Identifier("minecraft:spruce_log"))
        );
        WARPED_TABLE = new GenericTable(
            "warped",
            Map.of("planks", new Identifier("minecraft:warped_planks"), "log", new Identifier("minecraft:warped_stem"))
        );
    }

    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        ACACIA_TABLE.register();
        BIRCH_TABLE.register();
        CRIMSON_TABLE.register();
        DARK_OAK_TABLE.register();
        JUNGLE_TABLE.register();
        OAK_TABLE.register();
        SPRUCE_TABLE.register();
        WARPED_TABLE.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
    }
}
