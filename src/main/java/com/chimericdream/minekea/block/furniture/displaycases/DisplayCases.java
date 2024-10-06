package com.chimericdream.minekea.block.furniture.displaycases;

import com.chimericdream.lib.blocks.ModBlock;
import com.chimericdream.minekea.client.render.block.DisplayCaseBlockEntityRenderer;
import com.chimericdream.minekea.entities.blocks.furniture.DisplayCaseBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
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

public class DisplayCases implements MinekeaBlockCategory {
    public static final List<GenericDisplayCase> DISPLAY_CASES = new ArrayList<>();

    public static BlockEntityType<DisplayCaseBlockEntity> DISPLAY_CASE_BLOCK_ENTITY;

    static {
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("acacia").materialName("Acacia").ingredient("planks", Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).ingredient("stripped_log", Blocks.STRIPPED_ACACIA_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("bamboo").materialName("Bamboo").ingredient("planks", Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).ingredient("stripped_log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("birch").materialName("Birch").ingredient("planks", Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).ingredient("stripped_log", Blocks.STRIPPED_BIRCH_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("cherry").materialName("Cherry").ingredient("planks", Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).ingredient("stripped_log", Blocks.STRIPPED_CHERRY_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("crimson").materialName("Crimson").ingredient("planks", Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM).ingredient("stripped_log", Blocks.STRIPPED_CRIMSON_STEM)));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("dark_oak").materialName("Dark Oak").ingredient("planks", Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).ingredient("stripped_log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("jungle").materialName("Jungle").ingredient("planks", Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).ingredient("stripped_log", Blocks.STRIPPED_JUNGLE_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("mangrove").materialName("Mangrove").ingredient("planks", Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).ingredient("stripped_log", Blocks.STRIPPED_MANGROVE_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("oak").materialName("Oak").ingredient("planks", Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).ingredient("stripped_log", Blocks.STRIPPED_OAK_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("spruce").materialName("Spruce").ingredient("planks", Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).ingredient("stripped_log", Blocks.STRIPPED_SPRUCE_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("warped").materialName("Warped").ingredient("planks", Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM).ingredient("stripped_log", Blocks.STRIPPED_WARPED_STEM)));

        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("stripped/acacia").materialName("Stripped Acacia").ingredient("planks", Blocks.ACACIA_PLANKS).ingredient("log", Blocks.STRIPPED_ACACIA_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("stripped/bamboo").materialName("Stripped Bamboo").ingredient("planks", Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.STRIPPED_BAMBOO_BLOCK).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("stripped/birch").materialName("Stripped Birch").ingredient("planks", Blocks.BIRCH_PLANKS).ingredient("log", Blocks.STRIPPED_BIRCH_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("stripped/cherry").materialName("Stripped Cherry").ingredient("planks", Blocks.CHERRY_PLANKS).ingredient("log", Blocks.STRIPPED_CHERRY_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("stripped/crimson").materialName("Stripped Crimson").ingredient("planks", Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.STRIPPED_CRIMSON_STEM)));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("stripped/dark_oak").materialName("Stripped Dark Oak").ingredient("planks", Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.STRIPPED_DARK_OAK_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("stripped/jungle").materialName("Stripped Jungle").ingredient("planks", Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.STRIPPED_JUNGLE_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("stripped/mangrove").materialName("Stripped Mangrove").ingredient("planks", Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.STRIPPED_MANGROVE_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("stripped/oak").materialName("Stripped Oak").ingredient("planks", Blocks.OAK_PLANKS).ingredient("log", Blocks.STRIPPED_OAK_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("stripped/spruce").materialName("Stripped Spruce").ingredient("planks", Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.STRIPPED_SPRUCE_LOG).flammable()));
        DISPLAY_CASES.add(new GenericDisplayCase(new ModBlock.ModBlockConfig().material("stripped/warped").materialName("Stripped Warped").ingredient("planks", Blocks.WARPED_PLANKS).ingredient("log", Blocks.STRIPPED_WARPED_STEM)));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        DISPLAY_CASES.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));

        BlockEntityRendererRegistry.register(DISPLAY_CASE_BLOCK_ENTITY, DisplayCaseBlockEntityRenderer::new);
    }

    @Override
    public void registerBlocks() {
        DISPLAY_CASES.forEach(GenericDisplayCase::register);
    }

    @Override
    public void registerBlockEntities() {
        DISPLAY_CASE_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            DisplayCaseBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(
                DisplayCaseBlockEntity::new,
                DISPLAY_CASES.toArray(new Block[0])
            ).build(null)
        );
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        DISPLAY_CASES.forEach(displayCase -> displayCase.configureItemModels(itemModelGenerator));
    }
}
