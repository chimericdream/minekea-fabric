package com.chimericdream.minekea.block.building.walls;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.blocks.BlockDataGenerator;
import com.chimericdream.lib.blocks.RegisterableBlock;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.fabric.blocks.FabricItemGroupEventHelpers;
import com.chimericdream.lib.fabric.registries.FabricRegistryHelpers;
import com.chimericdream.lib.registries.RegistryHelpers;
import com.chimericdream.lib.util.ModConfigurable;
import com.chimericdream.minekea.ModInfo;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;
import net.minecraft.block.enums.WallShape;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemGroups;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class GenericWallBlock extends WallBlock implements BlockDataGenerator, FabricBlockDataGenerator, ModConfigurable, RegisterableBlock {
    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    public GenericWallBlock(BlockConfig config) {
        super(AbstractBlock.Settings.copy(config.getIngredient()));

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/walls/%s", config.getMaterial()));
        this.config = config;
    }

    public BlockConfig getConfig() {
        return config;
    }

    public void register() {
        RegistryHelpers.registerBlockWithItem(this, BLOCK_ID);
        FabricItemGroupEventHelpers.addBlockToItemGroup(this, ItemGroups.BUILDING_BLOCKS);

        if (config.isFlammable()) {
            FabricRegistryHelpers.registerFlammableBlock(this);
        }
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.WALLS)
            .setReplace(false)
            .add(this);
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block ingredient = config.getIngredient();

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 6)
            .pattern("###")
            .pattern("###")
            .input('#', ingredient)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Wall", config.getMaterialName()));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.WALL, config.getTexture());

        Identifier inventoryModelId = blockStateModelGenerator.createSubModel(this, "", Models.WALL_INVENTORY, unused -> textures);
        Identifier postModelId = blockStateModelGenerator.createSubModel(this, "", Models.TEMPLATE_WALL_POST, unused -> textures);
        Identifier sideModelId = blockStateModelGenerator.createSubModel(this, "", Models.TEMPLATE_WALL_SIDE, unused -> textures);
        Identifier sideTallModelId = blockStateModelGenerator.createSubModel(this, "", Models.TEMPLATE_WALL_SIDE_TALL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create().set(UP, true),
                        BlockStateVariant.create().put(VariantSettings.MODEL, postModelId)
                    )
                    .with(
                        When.create().set(NORTH_SHAPE, WallShape.LOW),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideModelId)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(EAST_SHAPE, WallShape.LOW),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(SOUTH_SHAPE, WallShape.LOW),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(WEST_SHAPE, WallShape.LOW),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(NORTH_SHAPE, WallShape.TALL),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideTallModelId)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(EAST_SHAPE, WallShape.TALL),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideTallModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(SOUTH_SHAPE, WallShape.TALL),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideTallModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(WEST_SHAPE, WallShape.TALL),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, sideTallModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
            );

        blockStateModelGenerator.registerParentedItemModel(this, inventoryModelId);
    }
}
