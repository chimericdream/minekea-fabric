package com.chimericdream.minekea.block.decorations;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.decorations.jars.GlassJarBlock;
import com.chimericdream.minekea.block.decorations.jars.GlassJarBlockEntity;
import com.chimericdream.minekea.block.decorations.jars.GlassJarBlockEntityRenderer;
import com.chimericdream.minekea.block.decorations.jars.GlassJarItemRenderer;
import com.chimericdream.minekea.compat.ModCompatLayer;
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
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;

public class DecorationBlocks implements MinekeaBlockCategory {
    public static final EndlessRod ENDLESS_ROD;
    public static final FakeCake FAKE_CAKE;
    public static final GlassJarBlock GLASS_JAR;

    public static BlockEntityType<GlassJarBlockEntity> GLASS_JAR_BLOCK_ENTITY;
    public static BlockItem GLASS_JAR_ITEM;

    static {
        ENDLESS_ROD = new EndlessRod();
        FAKE_CAKE = new FakeCake();
        GLASS_JAR = new GlassJarBlock();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), GLASS_JAR);

        BlockEntityRendererRegistry.register(GLASS_JAR_BLOCK_ENTITY, GlassJarBlockEntityRenderer::new);
        BuiltinItemRendererRegistry.INSTANCE.register(GLASS_JAR_ITEM, new GlassJarItemRenderer());
    }

    @Override
    public void registerBlocks() {
        ENDLESS_ROD.register();
        FAKE_CAKE.register();
        GLASS_JAR.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        GLASS_JAR_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "jars/glass_jar_block_entity"),
            FabricBlockEntityTypeBuilder.create(GlassJarBlockEntity::new, GLASS_JAR).build(null)
        );
    }
}
