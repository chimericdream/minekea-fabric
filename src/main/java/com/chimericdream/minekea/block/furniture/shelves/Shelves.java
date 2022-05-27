package com.chimericdream.minekea.block.furniture.shelves;

import com.chimericdream.minekea.block.furniture.shelves.GenericFloatingShelf.FloatingShelfSettings;
import com.chimericdream.minekea.block.furniture.shelves.GenericShelf.SupportedShelfSettings;
import com.chimericdream.minekea.client.render.block.ShelfBlockEntityRenderer;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.entities.blocks.furniture.ShelfBlockEntity;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

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
        ACACIA_SHELF = new GenericShelf(new SupportedShelfSettings(BaseBlockSettings.ACACIA));
        BIRCH_SHELF = new GenericShelf(new SupportedShelfSettings(BaseBlockSettings.BIRCH));
        CRIMSON_SHELF = new GenericShelf(new SupportedShelfSettings(BaseBlockSettings.CRIMSON));
        DARK_OAK_SHELF = new GenericShelf(new SupportedShelfSettings(BaseBlockSettings.DARK_OAK));
        JUNGLE_SHELF = new GenericShelf(new SupportedShelfSettings(BaseBlockSettings.JUNGLE));
        OAK_SHELF = new GenericShelf(new SupportedShelfSettings(BaseBlockSettings.OAK));
        SPRUCE_SHELF = new GenericShelf(new SupportedShelfSettings(BaseBlockSettings.SPRUCE));
        WARPED_SHELF = new GenericShelf(new SupportedShelfSettings(BaseBlockSettings.WARPED));

        ACACIA_FLOATING_SHELF = new GenericFloatingShelf(new FloatingShelfSettings(BaseBlockSettings.ACACIA));
        BIRCH_FLOATING_SHELF = new GenericFloatingShelf(new FloatingShelfSettings(BaseBlockSettings.BIRCH));
        CRIMSON_FLOATING_SHELF = new GenericFloatingShelf(new FloatingShelfSettings(BaseBlockSettings.CRIMSON));
        DARK_OAK_FLOATING_SHELF = new GenericFloatingShelf(new FloatingShelfSettings(BaseBlockSettings.DARK_OAK));
        JUNGLE_FLOATING_SHELF = new GenericFloatingShelf(new FloatingShelfSettings(BaseBlockSettings.JUNGLE));
        OAK_FLOATING_SHELF = new GenericFloatingShelf(new FloatingShelfSettings(BaseBlockSettings.OAK));
        SPRUCE_FLOATING_SHELF = new GenericFloatingShelf(new FloatingShelfSettings(BaseBlockSettings.SPRUCE));
        WARPED_FLOATING_SHELF = new GenericFloatingShelf(new FloatingShelfSettings(BaseBlockSettings.WARPED));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockEntityRendererRegistry.INSTANCE.register(SHELF_BLOCK_ENTITY, ShelfBlockEntityRenderer::new);
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
            ShelfBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(
                ShelfBlockEntity::new,
                shelves.toArray(new Block[0])
            ).build(null)
        );
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
    }
}
