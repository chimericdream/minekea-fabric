package com.chimericdream.minekea.block.furniture.displaycases;

import com.chimericdream.minekea.client.render.block.DisplayCaseBlockEntityRenderer;
import com.chimericdream.minekea.entities.blocks.furniture.DisplayCaseBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlock;
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
        DISPLAY_CASES.add(new GenericDisplayCase("acacia", "Acacia", Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("bamboo", "Bamboo", Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK, true));
        DISPLAY_CASES.add(new GenericDisplayCase("birch", "Birch", Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("cherry", "Cherry", Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("crimson", "Crimson", Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM, false));
        DISPLAY_CASES.add(new GenericDisplayCase("dark_oak", "Dark Oak", Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("jungle", "Jungle", Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("mangrove", "Mangrove", Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("oak", "Oak", Blocks.OAK_PLANKS, Blocks.OAK_LOG, Blocks.STRIPPED_OAK_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("spruce", "Spruce", Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("warped", "Warped", Blocks.WARPED_PLANKS, Blocks.WARPED_STEM, Blocks.STRIPPED_WARPED_STEM, false));

        DISPLAY_CASES.add(new GenericDisplayCase("stripped/acacia", "Stripped Acacia", Blocks.ACACIA_PLANKS, Blocks.STRIPPED_ACACIA_LOG, Blocks.STRIPPED_ACACIA_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("stripped/bamboo", "Stripped Bamboo", Blocks.BAMBOO_PLANKS, Blocks.STRIPPED_BAMBOO_BLOCK, Blocks.STRIPPED_BAMBOO_BLOCK, true));
        DISPLAY_CASES.add(new GenericDisplayCase("stripped/birch", "Stripped Birch", Blocks.BIRCH_PLANKS, Blocks.STRIPPED_BIRCH_LOG, Blocks.STRIPPED_BIRCH_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("stripped/cherry", "Stripped Cherry", Blocks.CHERRY_PLANKS, Blocks.STRIPPED_CHERRY_LOG, Blocks.STRIPPED_CHERRY_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("stripped/crimson", "Stripped Crimson", Blocks.CRIMSON_PLANKS, Blocks.STRIPPED_CRIMSON_STEM, Blocks.STRIPPED_CRIMSON_STEM, false));
        DISPLAY_CASES.add(new GenericDisplayCase("stripped/dark_oak", "Stripped Dark Oak", Blocks.DARK_OAK_PLANKS, Blocks.STRIPPED_DARK_OAK_LOG, Blocks.STRIPPED_DARK_OAK_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("stripped/jungle", "Stripped Jungle", Blocks.JUNGLE_PLANKS, Blocks.STRIPPED_JUNGLE_LOG, Blocks.STRIPPED_JUNGLE_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("stripped/mangrove", "Stripped Mangrove", Blocks.MANGROVE_PLANKS, Blocks.STRIPPED_MANGROVE_LOG, Blocks.STRIPPED_MANGROVE_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("stripped/oak", "Stripped Oak", Blocks.OAK_PLANKS, Blocks.STRIPPED_OAK_LOG, Blocks.STRIPPED_OAK_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("stripped/spruce", "Stripped Spruce", Blocks.SPRUCE_PLANKS, Blocks.STRIPPED_SPRUCE_LOG, Blocks.STRIPPED_SPRUCE_LOG, true));
        DISPLAY_CASES.add(new GenericDisplayCase("stripped/warped", "Stripped Warped", Blocks.WARPED_PLANKS, Blocks.STRIPPED_WARPED_STEM, Blocks.STRIPPED_WARPED_STEM, false));
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        DISPLAY_CASES.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));

        BlockEntityRendererRegistry.register(DISPLAY_CASE_BLOCK_ENTITY, DisplayCaseBlockEntityRenderer::new);
    }

    @Override
    public void registerBlocks() {
        DISPLAY_CASES.forEach(MinekeaBlock::register);
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
