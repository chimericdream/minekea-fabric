package com.chimericdream.minekea.block.building.stairs;

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
import net.minecraft.block.Block;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.block.enums.StairShape;
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
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class GenericStairsBlock extends StairsBlock implements BlockDataGenerator, FabricBlockDataGenerator, ModConfigurable, RegisterableBlock {
    public final Identifier BLOCK_ID;
    public final BlockConfig config;

    public GenericStairsBlock(BlockConfig config) {
        super(config.getIngredient().getDefaultState(), config.getBaseSettings());

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/stairs/%s", config.getMaterial()));
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

    public void configureRecipes(RecipeExporter exporter) {
        Block ingredient = config.getIngredient();

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 8)
            .pattern("#  ")
            .pattern("## ")
            .pattern("###")
            .input('#', ingredient)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Stairs", config.getMaterialName()));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier textureId = config.getTexture();

        TextureMap textures = new TextureMap()
            .put(TextureKey.BOTTOM, textureId)
            .put(TextureKey.TOP, textureId)
            .put(TextureKey.SIDE, textureId);

        Identifier coreModelId = blockStateModelGenerator.createSubModel(this, "", Models.STAIRS, unused -> textures);
        Identifier innerModelId = blockStateModelGenerator.createSubModel(this, "_inner", Models.INNER_STAIRS, unused -> textures);
        Identifier outerModelId = blockStateModelGenerator.createSubModel(this, "_outer", Models.OUTER_STAIRS, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.INNER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.INNER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.OUTER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.OUTER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.STRAIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.INNER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.INNER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.OUTER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.OUTER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.STRAIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.INNER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.INNER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.OUTER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.OUTER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.STRAIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.INNER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.INNER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.OUTER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.OUTER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.STRAIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.INNER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.INNER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.OUTER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.OUTER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.STRAIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.INNER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.INNER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.OUTER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.OUTER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.STRAIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.INNER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.INNER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.OUTER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.OUTER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(SHAPE, StairShape.STRAIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.INNER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.INNER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, innerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.OUTER_LEFT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.OUTER_RIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, outerModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.TOP)
                            .set(SHAPE, StairShape.STRAIGHT),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
            );
    }
}
