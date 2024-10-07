package com.chimericdream.minekea.block.containers.barrels;

import com.chimericdream.lib.blocks.ModBlock;
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
        BARRELS.add(new GenericBarrel(new ModBlock.Config().material("acacia").materialName("Acacia").ingredient(Blocks.ACACIA_PLANKS).ingredient("slab", Blocks.ACACIA_SLAB), "acacia_planks", "stripped_acacia_log"));
        BARRELS.add(new GenericBarrel(new ModBlock.Config().material("bamboo").materialName("Bamboo").ingredient(Blocks.BAMBOO_PLANKS).ingredient("slab", Blocks.BAMBOO_SLAB), "bamboo_planks", "stripped_bamboo_block"));
        BARRELS.add(new GenericBarrel(new ModBlock.Config().material("birch").materialName("Birch").ingredient(Blocks.BIRCH_PLANKS).ingredient("slab", Blocks.BIRCH_SLAB), "birch_planks", "stripped_birch_log"));
        BARRELS.add(new GenericBarrel(new ModBlock.Config().material("cherry").materialName("Cherry").ingredient(Blocks.CHERRY_PLANKS).ingredient("slab", Blocks.CHERRY_SLAB), "cherry_planks", "stripped_cherry_log"));
        BARRELS.add(new GenericBarrel(new ModBlock.Config().material("crimson").materialName("Crimson").ingredient(Blocks.CRIMSON_PLANKS).ingredient("slab", Blocks.CRIMSON_SLAB), "crimson_planks", "stripped_crimson_stem"));
        BARRELS.add(new GenericBarrel(new ModBlock.Config().material("dark_oak").materialName("Dark Oak").ingredient(Blocks.DARK_OAK_PLANKS).ingredient("slab", Blocks.DARK_OAK_SLAB), "dark_oak_planks", "stripped_dark_oak_log"));
        BARRELS.add(new GenericBarrel(new ModBlock.Config().material("jungle").materialName("Jungle").ingredient(Blocks.JUNGLE_PLANKS).ingredient("slab", Blocks.JUNGLE_SLAB), "jungle_planks", "stripped_jungle_log"));
        BARRELS.add(new GenericBarrel(new ModBlock.Config().material("mangrove").materialName("Mangrove").ingredient(Blocks.MANGROVE_PLANKS).ingredient("slab", Blocks.MANGROVE_SLAB), "mangrove_planks", "stripped_mangrove_log"));
        BARRELS.add(new GenericBarrel(new ModBlock.Config().material("spruce").materialName("Spruce").ingredient(Blocks.SPRUCE_PLANKS).ingredient("slab", Blocks.SPRUCE_SLAB), "spruce_planks", "stripped_spruce_log"));
        BARRELS.add(new GenericBarrel(new ModBlock.Config().material("warped").materialName("Warped").ingredient(Blocks.WARPED_PLANKS).ingredient("slab", Blocks.WARPED_SLAB), "warped_planks", "stripped_warped_stem"));
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
