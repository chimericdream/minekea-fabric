package com.chimericdream.minekea.block.containers;

import com.chimericdream.minekea.block.containers.barrels.Barrels;
import com.chimericdream.minekea.block.containers.crates.Crates;
import com.chimericdream.minekea.client.render.block.GlassJarBlockEntityRenderer;
import com.chimericdream.minekea.client.render.item.GlassJarItemRenderer;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.entities.blocks.containers.GlassJarBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class ContainerBlocks implements MinekeaBlockCategory {
    public static final Barrels BARRELS;
    public static final Crates CRATES;

    public static final GlassJarBlock GLASS_JAR;

    public static BlockEntityType<GlassJarBlockEntity> GLASS_JAR_BLOCK_ENTITY;
    public static BlockItem GLASS_JAR_ITEM;

    static {
        BARRELS = new Barrels();
        CRATES = new Crates();

        GLASS_JAR = new GlassJarBlock();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BARRELS.initializeClient();
        CRATES.initializeClient();

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), GLASS_JAR);

        BlockEntityRendererRegistry.register(GLASS_JAR_BLOCK_ENTITY, GlassJarBlockEntityRenderer::new);
        BuiltinItemRendererRegistry.INSTANCE.register(GLASS_JAR_ITEM, new GlassJarItemRenderer());
    }

    @Override
    public void registerBlocks() {
        BARRELS.registerBlocks();
        CRATES.registerBlocks();

        GLASS_JAR.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        BARRELS.registerBlockEntities(otherMods);
        CRATES.registerBlockEntities(otherMods);

        GLASS_JAR_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            GlassJarBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(GlassJarBlockEntity::new, GLASS_JAR).build(null)
        );
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
        BARRELS.registerEntities(otherMods);
        CRATES.registerEntities(otherMods);
    }

    @Override
    public void setupResources() {
        BARRELS.setupResources();
        CRATES.setupResources();
    }
}
