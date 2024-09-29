package com.chimericdream.minekea.block.furniture.armoires;

import com.chimericdream.minekea.client.render.block.ArmoireBlockEntityRenderer;
import com.chimericdream.minekea.entities.blocks.furniture.ArmoireBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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

import java.util.List;
import java.util.function.Function;

public class Armoires implements MinekeaBlockCategory {
    public static final List<MinekeaBlock> ARMOIRES;

    public static BlockEntityType<ArmoireBlockEntity> ARMOIRE_BLOCK_ENTITY;

    static {
        ARMOIRES = List.of(
            new GenericArmoireBlock("Acacia", "acacia", Blocks.ACACIA_PLANKS, Blocks.STRIPPED_ACACIA_LOG, Blocks.ACACIA_SLAB, true),
            new GenericArmoireBlock("Bamboo", "bamboo", Blocks.BAMBOO_PLANKS, Blocks.STRIPPED_BAMBOO_BLOCK, Blocks.BAMBOO_SLAB, true),
            new GenericArmoireBlock("Birch", "birch", Blocks.BIRCH_PLANKS, Blocks.STRIPPED_BIRCH_LOG, Blocks.BIRCH_SLAB, true),
            new GenericArmoireBlock("Cherry", "cherry", Blocks.CHERRY_PLANKS, Blocks.STRIPPED_CHERRY_LOG, Blocks.CHERRY_SLAB, true),
            new GenericArmoireBlock("Crimson", "crimson", Blocks.CRIMSON_PLANKS, Blocks.STRIPPED_CRIMSON_STEM, Blocks.CRIMSON_SLAB, false),
            new GenericArmoireBlock("Dark Oak", "dark_oak", Blocks.DARK_OAK_PLANKS, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.DARK_OAK_SLAB, true),
            new GenericArmoireBlock("Jungle", "jungle", Blocks.JUNGLE_PLANKS, Blocks.STRIPPED_JUNGLE_LOG, Blocks.JUNGLE_SLAB, true),
            new GenericArmoireBlock("Mangrove", "mangrove", Blocks.MANGROVE_PLANKS, Blocks.STRIPPED_MANGROVE_LOG, Blocks.MANGROVE_SLAB, true),
            new GenericArmoireBlock("Oak", "oak", Blocks.OAK_PLANKS, Blocks.STRIPPED_OAK_LOG, Blocks.OAK_SLAB, true),
            new GenericArmoireBlock("Spruce", "spruce", Blocks.SPRUCE_PLANKS, Blocks.STRIPPED_SPRUCE_LOG, Blocks.SPRUCE_SLAB, true),
            new GenericArmoireBlock("Warped", "warped", Blocks.WARPED_PLANKS, Blocks.STRIPPED_WARPED_STEM, Blocks.WARPED_SLAB, false)
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        ARMOIRES.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock((Block) block, RenderLayer.getCutout()));

        BlockEntityRendererRegistry.INSTANCE.register(ARMOIRE_BLOCK_ENTITY, ArmoireBlockEntityRenderer::new);
    }

    @Override
    public void registerBlocks() {
        ARMOIRES.forEach(MinekeaBlock::register);
    }

    @Override
    public void registerBlockEntities() {
        ARMOIRE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            ArmoireBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(
                ArmoireBlockEntity::new,
                ARMOIRES.toArray(new Block[0])
            ).build(null)
        );
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        ARMOIRES.forEach(armoire -> armoire.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        ARMOIRES.forEach(armoire -> armoire.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ARMOIRES.forEach(armoire -> armoire.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        ARMOIRES.forEach(armoire -> armoire.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        ARMOIRES.forEach(armoire -> armoire.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        ARMOIRES.forEach(armoire -> armoire.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        ARMOIRES.forEach(armoire -> armoire.configureItemModels(itemModelGenerator));
    }
}
