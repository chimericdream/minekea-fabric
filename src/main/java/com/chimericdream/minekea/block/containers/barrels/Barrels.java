package com.chimericdream.minekea.block.containers.barrels;

import com.chimericdream.minekea.entities.blocks.containers.MinekeaBarrelBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
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

public class Barrels implements MinekeaBlockCategory {
    public static final List<GenericBarrel> BARRELS = new ArrayList<>();
    public static BlockEntityType<MinekeaBarrelBlockEntity> MINEKEA_BARREL_BLOCK_ENTITY;

    static {
        BARRELS.add(new GenericBarrel("Acacia", "acacia_planks", "stripped_acacia_log", Blocks.ACACIA_PLANKS, Blocks.ACACIA_SLAB));
        BARRELS.add(new GenericBarrel("Bamboo", "bamboo_planks", "stripped_bamboo_block", Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_SLAB));
        BARRELS.add(new GenericBarrel("Birch", "birch_planks", "stripped_birch_log", Blocks.BIRCH_PLANKS, Blocks.BIRCH_SLAB));
        BARRELS.add(new GenericBarrel("Cherry", "cherry_planks", "stripped_cherry_log", Blocks.CHERRY_PLANKS, Blocks.CHERRY_SLAB));
        BARRELS.add(new GenericBarrel("Crimson", "crimson_planks", "stripped_crimson_stem", Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_SLAB));
        BARRELS.add(new GenericBarrel("Dark Oak", "dark_oak_planks", "stripped_dark_oak_log", Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_SLAB));
        BARRELS.add(new GenericBarrel("Jungle", "jungle_planks", "stripped_jungle_log", Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_SLAB));
        BARRELS.add(new GenericBarrel("Mangrove", "mangrove_planks", "stripped_mangrove_log", Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_SLAB));
        BARRELS.add(new GenericBarrel("Spruce", "spruce_planks", "stripped_spruce_log", Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_SLAB));
        BARRELS.add(new GenericBarrel("Warped", "warped_planks", "stripped_warped_stem", Blocks.WARPED_PLANKS, Blocks.WARPED_SLAB));
    }

    @Override
    public void registerBlocks() {
        BARRELS.forEach(GenericBarrel::register);
    }

    @Override
    public void registerBlockEntities() {
        MINEKEA_BARREL_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            MinekeaBarrelBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(
                MinekeaBarrelBlockEntity::new,
                BARRELS.toArray(new Block[0])
            ).build(null)
        );
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        BARRELS.forEach(barrel -> barrel.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        BARRELS.forEach(barrel -> barrel.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        BARRELS.forEach(barrel -> barrel.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        BARRELS.forEach(barrel -> barrel.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        BARRELS.forEach(barrel -> barrel.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BARRELS.forEach(barrel -> barrel.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BARRELS.forEach(barrel -> barrel.configureItemModels(itemModelGenerator));
    }

    @Override
    public void generateTextures() {
        BARRELS.forEach(GenericBarrel::generateTextures);

        GenericBarrel.generateTextures("stripped_oak_log", "oak_planks", Registries.BLOCK.getId(Blocks.BARREL));
    }
}
