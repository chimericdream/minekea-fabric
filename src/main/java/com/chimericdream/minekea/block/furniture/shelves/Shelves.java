package com.chimericdream.minekea.block.furniture.shelves;

import com.chimericdream.minekea.block.furniture.shelves.GenericFloatingShelf.FloatingShelfSettings;
import com.chimericdream.minekea.block.furniture.shelves.GenericShelf.SupportedShelfSettings;
import com.chimericdream.minekea.client.render.block.ShelfBlockEntityRenderer;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.entities.blocks.furniture.ShelfBlockEntity;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Shelves implements MinekeaBlockCategory {
    public static final Map<String, GenericShelf> SHELVES = new LinkedHashMap<>();
    public static final Map<String, GenericFloatingShelf> FLOATING_SHELVES = new LinkedHashMap<>();

    public static BlockEntityType<ShelfBlockEntity> SHELF_BLOCK_ENTITY;

    static {
        for (MinekeaBlockSettings.DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
            if (blockSettings.hasShelf()) {
                SHELVES.put(blockSettings.getMainMaterial(), new GenericShelf(new SupportedShelfSettings(blockSettings)));
            }

            if (blockSettings.hasFloatingShelf()) {
                FLOATING_SHELVES.put(blockSettings.getMainMaterial(), new GenericFloatingShelf(new FloatingShelfSettings(blockSettings)));
            }
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockEntityRendererRegistry.register(SHELF_BLOCK_ENTITY, ShelfBlockEntityRenderer::new);
    }

    @Override
    public void registerBlocks() {
        for (GenericShelf block : SHELVES.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }

        for (GenericFloatingShelf block : FLOATING_SHELVES.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        List<GenericShelf> shelves = new ArrayList<>();

        shelves.addAll(SHELVES.values());
        shelves.addAll(FLOATING_SHELVES.values());

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
