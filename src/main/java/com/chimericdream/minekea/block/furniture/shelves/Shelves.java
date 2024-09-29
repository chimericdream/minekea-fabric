package com.chimericdream.minekea.block.furniture.shelves;

import com.chimericdream.minekea.client.render.block.ShelfBlockEntityRenderer;
import com.chimericdream.minekea.entities.blocks.furniture.ShelfBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
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

import static com.chimericdream.minekea.item.MinekeaItemGroups.FURNITURE_ITEM_GROUP_KEY;

public class Shelves implements MinekeaBlockCategory {
    public static final List<GenericShelf> SHELVES;
    public static final List<GenericFloatingShelf> FLOATING_SHELVES;

    public static BlockEntityType<ShelfBlockEntity> SHELF_BLOCK_ENTITY;

    static {
        SHELVES = List.of(
            new GenericShelf("Acacia", Blocks.ACACIA_SLAB, Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG, true),
            new GenericShelf("Bamboo", Blocks.BAMBOO_SLAB, Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_BLOCK, true),
            new GenericShelf("Birch", Blocks.BIRCH_SLAB, Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG, true),
            new GenericShelf("Cherry", Blocks.CHERRY_SLAB, Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG, true),
            new GenericShelf("Crimson", Blocks.CRIMSON_SLAB, Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM, false),
            new GenericShelf("Dark Oak", Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG, true),
            new GenericShelf("Jungle", Blocks.JUNGLE_SLAB, Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG, true),
            new GenericShelf("Mangrove", Blocks.MANGROVE_SLAB, Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG, true),
            new GenericShelf("Oak", Blocks.OAK_SLAB, Blocks.OAK_PLANKS, Blocks.OAK_LOG, true),
            new GenericShelf("Spruce", Blocks.SPRUCE_SLAB, Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG, true),
            new GenericShelf("Warped", Blocks.WARPED_SLAB, Blocks.WARPED_PLANKS, Blocks.WARPED_STEM, false)
        );
        FLOATING_SHELVES = List.of(
            new GenericFloatingShelf("Acacia", Blocks.ACACIA_SLAB, Blocks.ACACIA_PLANKS, Blocks.ACACIA_LOG, true),
            new GenericFloatingShelf("Bamboo", Blocks.BAMBOO_SLAB, Blocks.BAMBOO_PLANKS, Blocks.BAMBOO_BLOCK, true),
            new GenericFloatingShelf("Birch", Blocks.BIRCH_SLAB, Blocks.BIRCH_PLANKS, Blocks.BIRCH_LOG, true),
            new GenericFloatingShelf("Cherry", Blocks.CHERRY_SLAB, Blocks.CHERRY_PLANKS, Blocks.CHERRY_LOG, true),
            new GenericFloatingShelf("Crimson", Blocks.CRIMSON_SLAB, Blocks.CRIMSON_PLANKS, Blocks.CRIMSON_STEM, false),
            new GenericFloatingShelf("Dark Oak", Blocks.DARK_OAK_SLAB, Blocks.DARK_OAK_PLANKS, Blocks.DARK_OAK_LOG, true),
            new GenericFloatingShelf("Jungle", Blocks.JUNGLE_SLAB, Blocks.JUNGLE_PLANKS, Blocks.JUNGLE_LOG, true),
            new GenericFloatingShelf("Mangrove", Blocks.MANGROVE_SLAB, Blocks.MANGROVE_PLANKS, Blocks.MANGROVE_LOG, true),
            new GenericFloatingShelf("Oak", Blocks.OAK_SLAB, Blocks.OAK_PLANKS, Blocks.OAK_LOG, true),
            new GenericFloatingShelf("Spruce", Blocks.SPRUCE_SLAB, Blocks.SPRUCE_PLANKS, Blocks.SPRUCE_LOG, true),
            new GenericFloatingShelf("Warped", Blocks.WARPED_SLAB, Blocks.WARPED_PLANKS, Blocks.WARPED_STEM, false)
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockEntityRendererRegistry.register(SHELF_BLOCK_ENTITY, ShelfBlockEntityRenderer::new);
    }

    @Override
    public void registerBlocks() {
        SHELVES.forEach(GenericShelf::register);
        FLOATING_SHELVES.forEach(GenericFloatingShelf::register);

        ItemGroupEvents.modifyEntriesEvent(FURNITURE_ITEM_GROUP_KEY).register(itemGroup -> {
            SHELVES.forEach(itemGroup::add);
            FLOATING_SHELVES.forEach(itemGroup::add);
        });
    }

    @Override
    public void registerBlockEntities() {
        List<GenericShelf> shelves = new ArrayList<>();

        shelves.addAll(SHELVES);
        shelves.addAll(FLOATING_SHELVES);

        SHELF_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            ShelfBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(
                ShelfBlockEntity::new,
                shelves.toArray(new Block[0])
            ).build(null)
        );
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        SHELVES.forEach(displayCase -> displayCase.configureBlockTags(registryLookup, getBuilder));
        FLOATING_SHELVES.forEach(displayCase -> displayCase.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        SHELVES.forEach(displayCase -> displayCase.configureItemTags(registryLookup, getBuilder));
        FLOATING_SHELVES.forEach(displayCase -> displayCase.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        SHELVES.forEach(displayCase -> displayCase.configureRecipes(exporter));
        FLOATING_SHELVES.forEach(displayCase -> displayCase.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        SHELVES.forEach(displayCase -> displayCase.configureBlockLootTables(registryLookup, generator));
        FLOATING_SHELVES.forEach(displayCase -> displayCase.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        SHELVES.forEach(displayCase -> displayCase.configureTranslations(registryLookup, translationBuilder));
        FLOATING_SHELVES.forEach(displayCase -> displayCase.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        SHELVES.forEach(displayCase -> displayCase.configureBlockStateModels(blockStateModelGenerator));
        FLOATING_SHELVES.forEach(displayCase -> displayCase.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        SHELVES.forEach(displayCase -> displayCase.configureItemModels(itemModelGenerator));
        FLOATING_SHELVES.forEach(displayCase -> displayCase.configureItemModels(itemModelGenerator));
    }
}
