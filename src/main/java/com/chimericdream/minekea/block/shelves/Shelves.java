package com.chimericdream.minekea.block.shelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Shelves implements MinekeaBlockCategory {
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

    public static BlockEntityType<ShelfBlockEntity> SHELF_BLOCK_ENTITY;

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

    @Override
    public void registerBlocks() {
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

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        List<GenericShelf> shelves = new ArrayList<>(List.of(
            ACACIA_SHELF,
            BIRCH_SHELF,
            CRIMSON_SHELF,
            DARK_OAK_SHELF,
            JUNGLE_SHELF,
            OAK_SHELF,
            SPRUCE_SHELF,
            WARPED_SHELF,
            ACACIA_FLOATING_SHELF,
            BIRCH_FLOATING_SHELF,
            CRIMSON_FLOATING_SHELF,
            DARK_OAK_FLOATING_SHELF,
            JUNGLE_FLOATING_SHELF,
            OAK_FLOATING_SHELF,
            SPRUCE_FLOATING_SHELF,
            WARPED_FLOATING_SHELF
        ));

        for (ModCompatLayer mod : otherMods) {
            shelves.addAll(mod.getShelves());
        }

        SHELF_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "shelves/shelf_block_entity"),
            FabricBlockEntityTypeBuilder.create(
                ShelfBlockEntity::new,
                shelves.toArray(new Block[0])
            ).build(null)
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockEntityRendererRegistry.register(SHELF_BLOCK_ENTITY, ShelfBlockEntityRenderer::new);
    }
}
