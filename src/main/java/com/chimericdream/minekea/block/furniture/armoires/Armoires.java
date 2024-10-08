package com.chimericdream.minekea.block.furniture.armoires;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.client.render.block.ArmoireBlockEntityRenderer;
import com.chimericdream.minekea.entities.blocks.furniture.ArmoireBlockEntity;
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

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Armoires implements MinekeaBlockCategory {
    public static final List<GenericArmoireBlock> ARMOIRES = new ArrayList<>();

    public static BlockEntityType<ArmoireBlockEntity> ARMOIRE_BLOCK_ENTITY;

    static {
        ARMOIRES.add(new GenericArmoireBlock(new BlockConfig().materialName("Acacia").material("acacia").ingredient("planks", Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).ingredient("slab", Blocks.ACACIA_SLAB).flammable()));
        ARMOIRES.add(new GenericArmoireBlock(new BlockConfig().materialName("Bamboo").material("bamboo").ingredient("planks", Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).ingredient("slab", Blocks.BAMBOO_SLAB).flammable()));
        ARMOIRES.add(new GenericArmoireBlock(new BlockConfig().materialName("Birch").material("birch").ingredient("planks", Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).ingredient("slab", Blocks.BIRCH_SLAB).flammable()));
        ARMOIRES.add(new GenericArmoireBlock(new BlockConfig().materialName("Cherry").material("cherry").ingredient("planks", Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).ingredient("slab", Blocks.CHERRY_SLAB).flammable()));
        ARMOIRES.add(new GenericArmoireBlock(new BlockConfig().materialName("Crimson").material("crimson").ingredient("planks", Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM).ingredient("slab", Blocks.CRIMSON_SLAB)));
        ARMOIRES.add(new GenericArmoireBlock(new BlockConfig().materialName("Dark Oak").material("dark_oak").ingredient("planks", Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).ingredient("slab", Blocks.DARK_OAK_SLAB).flammable()));
        ARMOIRES.add(new GenericArmoireBlock(new BlockConfig().materialName("Jungle").material("jungle").ingredient("planks", Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).ingredient("slab", Blocks.JUNGLE_SLAB).flammable()));
        ARMOIRES.add(new GenericArmoireBlock(new BlockConfig().materialName("Mangrove").material("mangrove").ingredient("planks", Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).ingredient("slab", Blocks.MANGROVE_SLAB).flammable()));
        ARMOIRES.add(new GenericArmoireBlock(new BlockConfig().materialName("Oak").material("oak").ingredient("planks", Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).ingredient("slab", Blocks.OAK_SLAB).flammable()));
        ARMOIRES.add(new GenericArmoireBlock(new BlockConfig().materialName("Spruce").material("spruce").ingredient("planks", Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).ingredient("slab", Blocks.SPRUCE_SLAB).flammable()));
        ARMOIRES.add(new GenericArmoireBlock(new BlockConfig().materialName("Warped").material("warped").ingredient("planks", Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM).ingredient("slab", Blocks.WARPED_SLAB)));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        ARMOIRES.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock((Block) block, RenderLayer.getCutout()));

        BlockEntityRendererRegistry.INSTANCE.register(ARMOIRE_BLOCK_ENTITY, ArmoireBlockEntityRenderer::new);
    }

    @Override
    public void registerBlocks() {
        ARMOIRES.forEach(GenericArmoireBlock::register);
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
