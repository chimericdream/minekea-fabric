package com.chimericdream.minekea.block.containers;

import com.chimericdream.minekea.block.containers.barrels.Barrels;
import com.chimericdream.minekea.block.containers.crates.Crates;
import com.chimericdream.minekea.client.render.block.GlassJarBlockEntityRenderer;
import com.chimericdream.minekea.entities.blocks.containers.GlassJarBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
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
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ContainerBlocks implements MinekeaBlockCategory {
    public static Barrels BARRELS;
    public static Crates CRATES;

    public static final GlassJarBlock GLASS_JAR;

    public static BlockEntityType<GlassJarBlockEntity> GLASS_JAR_BLOCK_ENTITY;

    private static final List<MinekeaBlockCategory> BLOCK_GROUPS = new ArrayList<>();

    static {
        BARRELS = new Barrels();
        BLOCK_GROUPS.add(BARRELS);

        CRATES = new Crates();
        BLOCK_GROUPS.add(CRATES);

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
        BLOCK_GROUPS.forEach(MinekeaBlockCategory::registerBlockEntities);

        GLASS_JAR_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            GlassJarBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(GlassJarBlockEntity::new, GLASS_JAR).build(null)
        );
    }

    @Override
    public void registerEntities() {
        BLOCK_GROUPS.forEach(MinekeaBlockCategory::registerEntities);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        BLOCK_GROUPS.forEach(group -> group.configureBlockTags(registryLookup, getBuilder));
        GLASS_JAR.configureBlockTags(registryLookup, getBuilder);
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        BLOCK_GROUPS.forEach(group -> group.configureItemTags(registryLookup, getBuilder));
        GLASS_JAR.configureItemTags(registryLookup, getBuilder);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        BLOCK_GROUPS.forEach(group -> group.configureRecipes(exporter));
        GLASS_JAR.configureRecipes(exporter);
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        BLOCK_GROUPS.forEach(group -> group.configureBlockLootTables(registryLookup, generator));
        GLASS_JAR.configureBlockLootTables(registryLookup, generator);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        BLOCK_GROUPS.forEach(group -> group.configureTranslations(registryLookup, translationBuilder));
        GLASS_JAR.configureTranslations(registryLookup, translationBuilder);
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BLOCK_GROUPS.forEach(group -> group.configureBlockStateModels(blockStateModelGenerator));
        GLASS_JAR.configureBlockStateModels(blockStateModelGenerator);
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BLOCK_GROUPS.forEach(group -> group.configureItemModels(itemModelGenerator));
        GLASS_JAR.configureItemModels(itemModelGenerator);
    }

    @Override
    public void generateTextures() {
        BLOCK_GROUPS.forEach(MinekeaBlockCategory::generateTextures);
        GLASS_JAR.generateTextures();
    }
}
