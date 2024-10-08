package com.chimericdream.minekea.block.furniture.shelves;

import com.chimericdream.lib.blocks.BlockConfig;
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
            new GenericShelf(new BlockConfig().material("acacia").materialName("Acacia").ingredient("slab", Blocks.ACACIA_SLAB).ingredient("planks", Blocks.ACACIA_PLANKS).ingredient("log", Blocks.ACACIA_LOG).flammable()),
            new GenericShelf(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient("slab", Blocks.BAMBOO_SLAB).ingredient("planks", Blocks.BAMBOO_PLANKS).ingredient("log", Blocks.BAMBOO_BLOCK).flammable()),
            new GenericShelf(new BlockConfig().material("birch").materialName("Birch").ingredient("slab", Blocks.BIRCH_SLAB).ingredient("planks", Blocks.BIRCH_PLANKS).ingredient("log", Blocks.BIRCH_LOG).flammable()),
            new GenericShelf(new BlockConfig().material("cherry").materialName("Cherry").ingredient("slab", Blocks.CHERRY_SLAB).ingredient("planks", Blocks.CHERRY_PLANKS).ingredient("log", Blocks.CHERRY_LOG).flammable()),
            new GenericShelf(new BlockConfig().material("crimson").materialName("Crimson").ingredient("slab", Blocks.CRIMSON_SLAB).ingredient("planks", Blocks.CRIMSON_PLANKS).ingredient("log", Blocks.CRIMSON_STEM)),
            new GenericShelf(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient("slab", Blocks.DARK_OAK_SLAB).ingredient("planks", Blocks.DARK_OAK_PLANKS).ingredient("log", Blocks.DARK_OAK_LOG).flammable()),
            new GenericShelf(new BlockConfig().material("jungle").materialName("Jungle").ingredient("slab", Blocks.JUNGLE_SLAB).ingredient("planks", Blocks.JUNGLE_PLANKS).ingredient("log", Blocks.JUNGLE_LOG).flammable()),
            new GenericShelf(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient("slab", Blocks.MANGROVE_SLAB).ingredient("planks", Blocks.MANGROVE_PLANKS).ingredient("log", Blocks.MANGROVE_LOG).flammable()),
            new GenericShelf(new BlockConfig().material("oak").materialName("Oak").ingredient("slab", Blocks.OAK_SLAB).ingredient("planks", Blocks.OAK_PLANKS).ingredient("log", Blocks.OAK_LOG).flammable()),
            new GenericShelf(new BlockConfig().material("spruce").materialName("Spruce").ingredient("slab", Blocks.SPRUCE_SLAB).ingredient("planks", Blocks.SPRUCE_PLANKS).ingredient("log", Blocks.SPRUCE_LOG).flammable()),
            new GenericShelf(new BlockConfig().material("warped").materialName("Warped").ingredient("slab", Blocks.WARPED_SLAB).ingredient("planks", Blocks.WARPED_PLANKS).ingredient("log", Blocks.WARPED_STEM))
        );
        FLOATING_SHELVES = List.of(
            new GenericFloatingShelf(new BlockConfig().material("acacia").materialName("Acacia").ingredient("slab", Blocks.ACACIA_SLAB).ingredient("planks", Blocks.ACACIA_PLANKS).flammable()),
            new GenericFloatingShelf(new BlockConfig().material("bamboo").materialName("Bamboo").ingredient("slab", Blocks.BAMBOO_SLAB).ingredient("planks", Blocks.BAMBOO_PLANKS).flammable()),
            new GenericFloatingShelf(new BlockConfig().material("birch").materialName("Birch").ingredient("slab", Blocks.BIRCH_SLAB).ingredient("planks", Blocks.BIRCH_PLANKS).flammable()),
            new GenericFloatingShelf(new BlockConfig().material("cherry").materialName("Cherry").ingredient("slab", Blocks.CHERRY_SLAB).ingredient("planks", Blocks.CHERRY_PLANKS).flammable()),
            new GenericFloatingShelf(new BlockConfig().material("crimson").materialName("Crimson").ingredient("slab", Blocks.CRIMSON_SLAB).ingredient("planks", Blocks.CRIMSON_PLANKS)),
            new GenericFloatingShelf(new BlockConfig().material("dark_oak").materialName("Dark Oak").ingredient("slab", Blocks.DARK_OAK_SLAB).ingredient("planks", Blocks.DARK_OAK_PLANKS).flammable()),
            new GenericFloatingShelf(new BlockConfig().material("jungle").materialName("Jungle").ingredient("slab", Blocks.JUNGLE_SLAB).ingredient("planks", Blocks.JUNGLE_PLANKS).flammable()),
            new GenericFloatingShelf(new BlockConfig().material("mangrove").materialName("Mangrove").ingredient("slab", Blocks.MANGROVE_SLAB).ingredient("planks", Blocks.MANGROVE_PLANKS).flammable()),
            new GenericFloatingShelf(new BlockConfig().material("oak").materialName("Oak").ingredient("slab", Blocks.OAK_SLAB).ingredient("planks", Blocks.OAK_PLANKS).flammable()),
            new GenericFloatingShelf(new BlockConfig().material("spruce").materialName("Spruce").ingredient("slab", Blocks.SPRUCE_SLAB).ingredient("planks", Blocks.SPRUCE_PLANKS).flammable()),
            new GenericFloatingShelf(new BlockConfig().material("warped").materialName("Warped").ingredient("slab", Blocks.WARPED_SLAB).ingredient("planks", Blocks.WARPED_PLANKS))
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
