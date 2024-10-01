package com.chimericdream.minekea.block.building.framed;

import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FramedBlocks implements MinekeaBlockCategory {
    public static final List<MinekeaBlock> FRAMED_PLANKS = new ArrayList<>();

    static {
        FRAMED_PLANKS.add(new FramedPlanksBlock("acacia", "Acacia", Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("acacia_stripped", "Stripped Acacia", Blocks.ACACIA_PLANKS, Blocks.STRIPPED_ACACIA_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("bamboo", "Bamboo", Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_BLOCK, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("bamboo_stripped", "Stripped Bamboo", Blocks.BAMBOO_PLANKS, Blocks.STRIPPED_BAMBOO_BLOCK, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("birch", "Birch", Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("birch_stripped", "Stripped Birch", Blocks.BIRCH_PLANKS, Blocks.STRIPPED_BIRCH_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("cherry", "Cherry", Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("cherry_stripped", "Stripped Cherry", Blocks.CHERRY_PLANKS, Blocks.STRIPPED_CHERRY_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("crimson", "Crimson", Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM, false));
        FRAMED_PLANKS.add(new FramedPlanksBlock("crimson_stripped", "Stripped Crimson", Blocks.CRIMSON_PLANKS, Blocks.STRIPPED_CRIMSON_STEM, false));
        FRAMED_PLANKS.add(new FramedPlanksBlock("dark_oak", "Dark Oak", Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("dark_oak_stripped", "Stripped Dark Oak", Blocks.DARK_OAK_PLANKS, Blocks.STRIPPED_DARK_OAK_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("jungle", "Jungle", Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("jungle_stripped", "Stripped Jungle", Blocks.JUNGLE_PLANKS, Blocks.STRIPPED_JUNGLE_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("mangrove", "Mangrove", Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("mangrove_stripped", "Stripped Mangrove", Blocks.MANGROVE_PLANKS, Blocks.STRIPPED_MANGROVE_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("oak", "Oak", Blocks.OAK_PLANKS, Blocks.OAK_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("oak_stripped", "Stripped Oak", Blocks.OAK_PLANKS, Blocks.STRIPPED_OAK_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("spruce", "Spruce", Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("spruce_stripped", "Stripped Spruce", Blocks.SPRUCE_PLANKS, Blocks.STRIPPED_SPRUCE_LOG, true));
        FRAMED_PLANKS.add(new FramedPlanksBlock("warped", "Warped", Blocks.WARPED_PLANKS, Blocks.WARPED_STEM, false));
        FRAMED_PLANKS.add(new FramedPlanksBlock("warped_stripped", "Stripped Warped", Blocks.WARPED_PLANKS, Blocks.STRIPPED_WARPED_STEM, false));
    }

    @Environment(EnvType.CLIENT)
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        FRAMED_PLANKS.forEach(MinekeaBlock::register);
    }

    @Override
    public void registerBlockEntities() {
    }

    @Override
    public void registerEntities() {
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        FRAMED_PLANKS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        FRAMED_PLANKS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        FRAMED_PLANKS.forEach(block -> block.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        FRAMED_PLANKS.forEach(block -> block.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        FRAMED_PLANKS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        FRAMED_PLANKS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        FRAMED_PLANKS.forEach(block -> block.configureItemModels(itemModelGenerator));
    }

    @Override
    public void generateTextures() {
        FRAMED_PLANKS.forEach(MinekeaBlock::generateTextures);
    }
}
