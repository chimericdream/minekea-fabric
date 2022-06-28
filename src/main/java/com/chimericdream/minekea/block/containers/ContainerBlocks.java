package com.chimericdream.minekea.block.containers;

import com.chimericdream.minekea.block.containers.barrels.Barrels;
import com.chimericdream.minekea.block.containers.crates.Crates;
import com.chimericdream.minekea.client.render.block.GlassJarBlockEntityRenderer;
import com.chimericdream.minekea.client.render.item.GlassJarItemRenderer;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.config.ConfigManager;
import com.chimericdream.minekea.config.MinekeaConfig;
import com.chimericdream.minekea.entities.blocks.containers.GlassJarBlockEntity;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class ContainerBlocks implements MinekeaBlockCategory {
    public static Barrels BARRELS = null;
    public static Crates CRATES = null;

    public static final GlassJarBlock GLASS_JAR;

    public static BlockEntityType<GlassJarBlockEntity> GLASS_JAR_BLOCK_ENTITY;
    public static BlockItem GLASS_JAR_ITEM;

    private static final List<MinekeaBlockCategory> BLOCK_GROUPS = new ArrayList<>();

    static {
        MinekeaConfig config = ConfigManager.getConfig();

        if (config.enableBarrels) {
            BARRELS = new Barrels();
            BLOCK_GROUPS.add(BARRELS);
        }

        if (config.enableCrates) {
            CRATES = new Crates();
            BLOCK_GROUPS.add(CRATES);
        }

        GLASS_JAR = new GlassJarBlock();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.initializeClient();
        }

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), GLASS_JAR);

        BlockEntityRendererRegistry.register(GLASS_JAR_BLOCK_ENTITY, GlassJarBlockEntityRenderer::new);
        BuiltinItemRendererRegistry.INSTANCE.register(GLASS_JAR_ITEM, new GlassJarItemRenderer());
    }

    @Override
    public void registerBlocks() {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerBlocks();
        }

        GLASS_JAR.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerBlockEntities(otherMods);
        }

        GLASS_JAR_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            GlassJarBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(GlassJarBlockEntity::new, GLASS_JAR).build(null)
        );
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerEntities(otherMods);
        }
    }

    @Override
    public void setupResources() {
        MinekeaConfig config = ConfigManager.getConfig();

        if (config.overrideVanillaBarrelTexture) {
            MinekeaResourcePack.RESOURCE_PACK.addModel(
                JModel.model("minekea:block/containers/barrel")
                    .textures(
                        new JTextures()
                            .var("face", "minecraft:block/stripped_oak_log")
                            .var("sides", "minecraft:block/oak_planks")
                    ),
                new Identifier("minecraft:block/barrel")
            );

            MinekeaResourcePack.RESOURCE_PACK.addModel(
                JModel.model("minekea:block/containers/barrel_open")
                    .textures(
                        new JTextures()
                            .var("face", "minecraft:block/stripped_oak_log")
                            .var("sides", "minecraft:block/oak_planks")
                    ),
                new Identifier("minecraft:block/barrel_open")
            );
        }

        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.setupResources();
        }
    }
}
