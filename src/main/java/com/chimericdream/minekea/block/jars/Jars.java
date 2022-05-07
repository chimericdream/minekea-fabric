package com.chimericdream.minekea.block.jars;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

public class Jars implements MinekeaBlockCategory {
    public static final GlassJarBlock GLASS_JAR;

    public static BlockEntityType<GlassJarBlockEntity> GLASS_JAR_BLOCK_ENTITY;

    static {
        GLASS_JAR = new GlassJarBlock();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), GLASS_JAR);

        BlockEntityRendererRegistry.INSTANCE.register(GLASS_JAR_BLOCK_ENTITY, GlassJarBlockEntityRenderer::new);
//        BuiltinItemRendererRegistry.INSTANCE.register(GLASS_JAR.asItem(), new GlassJarItemRenderer());
    }

    @Override
    public void registerBlocks() {
        GLASS_JAR.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        List<GlassJarBlock> jars = new ArrayList<>(List.of(GLASS_JAR));

        GLASS_JAR_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "jars/glass_jar_block_entity"),
            FabricBlockEntityTypeBuilder.create(
                GlassJarBlockEntity::new,
                jars.toArray(new Block[0])
            ).build(null)
        );
    }
}
