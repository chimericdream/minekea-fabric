package com.chimericdream.minekea.block.furniture.seating;

import com.chimericdream.minekea.entities.mounts.SeatEntity;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.function.Function;

import static com.chimericdream.minekea.item.MinekeaItemGroups.FURNITURE_ITEM_GROUP_KEY;

public class Seats implements MinekeaBlockCategory {
    public static final List<GenericChair> CHAIRS;
    public static final List<GenericStool> STOOLS;

    public static EntityType<SeatEntity> SEAT_ENTITY;

    static {
        CHAIRS = List.of(
            new GenericChair("Acacia", Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG),
            new GenericChair("Birch", Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG),
            new GenericChair("Cherry", Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG),
            new GenericChair("Crimson", Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM, false),
            new GenericChair("Dark Oak", Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG),
            new GenericChair("Jungle", Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG),
            new GenericChair("Mangrove", Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG),
            new GenericChair("Oak", Blocks.OAK_PLANKS, Blocks.OAK_LOG),
            new GenericChair("Spruce", Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG),
            new GenericChair("Warped", Blocks.WARPED_PLANKS, Blocks.WARPED_STEM, false)
        );

        STOOLS = List.of(
            new GenericStool("Acacia", Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG),
            new GenericStool("Birch", Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG),
            new GenericStool("Cherry", Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG),
            new GenericStool("Crimson", Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM, false),
            new GenericStool("Dark Oak", Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG),
            new GenericStool("Jungle", Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG),
            new GenericStool("Mangrove", Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG),
            new GenericStool("Oak", Blocks.OAK_PLANKS, Blocks.OAK_LOG),
            new GenericStool("Spruce", Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG),
            new GenericStool("Warped", Blocks.WARPED_PLANKS, Blocks.WARPED_STEM, false)
        );
    }

    @Override
    public void initializeClient() {
        EntityRendererRegistry.register(SEAT_ENTITY, SeatEntity.EmptyRenderer::new);
    }

    @Override
    public void registerBlocks() {
        CHAIRS.forEach(GenericChair::register);
        STOOLS.forEach(GenericStool::register);

        SEAT_ENTITY = Registry.register(
            Registries.ENTITY_TYPE,
            SeatEntity.ENTITY_ID,
            FabricEntityTypeBuilder.<SeatEntity>create(SpawnGroup.MISC, SeatEntity::new).build()
        );

        ItemGroupEvents.modifyEntriesEvent(FURNITURE_ITEM_GROUP_KEY).register(itemGroup -> {
            CHAIRS.forEach(itemGroup::add);
            STOOLS.forEach(itemGroup::add);
        });
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        CHAIRS.forEach(chair -> chair.configureBlockTags(registryLookup, getBuilder));
        STOOLS.forEach(stool -> stool.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        CHAIRS.forEach(chair -> chair.configureItemTags(registryLookup, getBuilder));
        STOOLS.forEach(stool -> stool.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        CHAIRS.forEach(chair -> chair.configureRecipes(exporter));
        STOOLS.forEach(stool -> stool.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        CHAIRS.forEach(chair -> chair.configureBlockLootTables(registryLookup, generator));
        STOOLS.forEach(stool -> stool.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        CHAIRS.forEach(chair -> chair.configureTranslations(registryLookup, translationBuilder));
        STOOLS.forEach(stool -> stool.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        CHAIRS.forEach(chair -> chair.configureBlockStateModels(blockStateModelGenerator));
        STOOLS.forEach(stool -> stool.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        CHAIRS.forEach(chair -> chair.configureItemModels(itemModelGenerator));
        STOOLS.forEach(stool -> stool.configureItemModels(itemModelGenerator));
    }
}
