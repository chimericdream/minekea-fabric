package com.chimericdream.minekea.block.containers;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.containers.barrels.Barrels;
import com.chimericdream.minekea.block.containers.crates.Crates;
import com.chimericdream.minekea.block.containers.jars.GlassJarBlock;
import com.chimericdream.minekea.block.containers.jars.GlassJarBlockEntity;
import com.chimericdream.minekea.block.containers.jars.GlassJarBlockEntityRenderer;
import com.chimericdream.minekea.block.containers.jars.GlassJarItemRenderer;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
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

        BlockEntityRendererRegistry.INSTANCE.register(GLASS_JAR_BLOCK_ENTITY, GlassJarBlockEntityRenderer::new);
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
            new Identifier(ModInfo.MOD_ID, "jars/glass_jar_block_entity"),
            FabricBlockEntityTypeBuilder.create(GlassJarBlockEntity::new, GLASS_JAR).build(null)
        );
    }
}
