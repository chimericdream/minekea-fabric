package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
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
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class GenericStairsBlock extends StairsBlock implements MinekeaBlock {
    public final Identifier BLOCK_ID;

    protected final String materialName;
    protected final String material;
    protected final boolean isFlammable;
    protected final Block ingredient;
    protected final Identifier textureId;

    public GenericStairsBlock(String materialName, String material, boolean isFlammable, Block ingredient) {
        this(materialName, material, isFlammable, ingredient, TextureMap.getId(ingredient));
    }

    public GenericStairsBlock(String materialName, String material, boolean isFlammable, Block ingredient, Identifier textureId) {
        super(ingredient.getDefaultState(), AbstractBlock.Settings.copy(ingredient));

        this.materialName = materialName;
        this.material = material;
        this.isFlammable = isFlammable;
        this.ingredient = ingredient;
        this.textureId = textureId;

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/stairs/%s", material));
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
            .register((itemGroup) -> itemGroup.add(this));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 8)
            .pattern("#  ")
            .pattern("## ")
            .pattern("###")
            .input('#', ingredient)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .offerTo(exporter);
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Stairs", materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
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
