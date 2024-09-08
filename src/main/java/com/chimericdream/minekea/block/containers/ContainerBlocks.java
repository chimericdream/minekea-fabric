package com.chimericdream.minekea.block.containers;

import com.chimericdream.minekea.client.render.block.GlassJarBlockEntityRenderer;
import com.chimericdream.minekea.client.render.item.GlassJarItemRenderer;
import com.chimericdream.minekea.entities.blocks.containers.GlassJarBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ContainerBlocks implements MinekeaBlockCategory {
//    public static Barrels BARRELS = null;
//    public static Crates CRATES = null;

    public static final GlassJarBlock GLASS_JAR;

    public static BlockEntityType<GlassJarBlockEntity> GLASS_JAR_BLOCK_ENTITY;
    public static BlockItem GLASS_JAR_ITEM;

    private static final List<MinekeaBlockCategory> BLOCK_GROUPS = new ArrayList<>();

    static {
//        MinekeaConfig config = ConfigManager.getConfig();
//
//        if (config.enableBarrels) {
//            BARRELS = new Barrels();
//            BLOCK_GROUPS.add(BARRELS);
//        }
//
//        if (config.enableCrates) {
//            CRATES = new Crates();
//            BLOCK_GROUPS.add(CRATES);
//        }

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
    public void registerBlockEntities() {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerBlockEntities();
        }

        GLASS_JAR_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            GlassJarBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(GlassJarBlockEntity::new, GLASS_JAR).build(null)
        );
    }

    @Override
    public void registerEntities() {
        for (MinekeaBlockCategory group : BLOCK_GROUPS) {
            group.registerEntities();
        }
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        GLASS_JAR.configureBlockTags(registryLookup, getBuilder);
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        GLASS_JAR.configureItemTags(registryLookup, getBuilder);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        GLASS_JAR.configureRecipes(exporter);
    }

    @Override
    public void configureBlockLootTables(BlockLootTableGenerator generator) {
        GLASS_JAR.configureBlockLootTables(generator);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        GLASS_JAR.configureTranslations(registryLookup, translationBuilder);
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        GLASS_JAR.configureBlockStateModels(blockStateModelGenerator);
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        GLASS_JAR.configureItemModels(itemModelGenerator);
    }
}
