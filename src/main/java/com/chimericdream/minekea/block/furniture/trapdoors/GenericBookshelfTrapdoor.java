package com.chimericdream.minekea.block.furniture.trapdoors;

import com.chimericdream.lib.blocks.ModBlock;
import com.chimericdream.lib.fabric.blocks.FabricModTrapdoorBlock;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.enums.BlockHalf;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;
import java.util.function.Function;

public class GenericBookshelfTrapdoor extends FabricModTrapdoorBlock {
    protected static final Model BOTTOM_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/trapdoors/bookshelves/bottom")),
        Optional.empty(),
        MinekeaTextures.MATERIAL,
        MinekeaTextures.SHELF
    );
    protected static final Model TOP_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/trapdoors/bookshelves/top")),
        Optional.empty(),
        MinekeaTextures.MATERIAL,
        MinekeaTextures.SHELF
    );
    protected static final Model OPEN_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/trapdoors/bookshelves/open")),
        Optional.empty(),
        MinekeaTextures.MATERIAL,
        MinekeaTextures.SHELF
    );

    public final Identifier BLOCK_ID;

    public GenericBookshelfTrapdoor(BlockSetType type, ModBlock.Config config) {
        super(type, config);

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("furniture/trapdoors/bookshelves/%s", config.getMaterial()));
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        if (config.isFlammable()) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        Block bookshelf = config.getIngredient();

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 12)
            .pattern("###")
            .pattern("###")
            .input('#', bookshelf)
            .criterion(FabricRecipeProvider.hasItem(bookshelf),
                FabricRecipeProvider.conditionsFromItem(bookshelf))
            .offerTo(exporter);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.AXE_MINEABLE).setReplace(false).add(this);
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Bookshelf Trapdoor", config.getMaterialName()));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Block plankIngredient = config.getIngredient("planks");

        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.MATERIAL, TextureMap.getId(plankIngredient))
            .put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf0"));

        Identifier bottomModelId = blockStateModelGenerator.createSubModel(this, "_bottom", BOTTOM_MODEL, unused -> textures);
        Identifier topModelId = blockStateModelGenerator.createSubModel(this, "_top", TOP_MODEL, unused -> textures);
        Identifier openModelId = blockStateModelGenerator.createSubModel(this, "_open", OPEN_MODEL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.TOP)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.TOP)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.BOTTOM)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, BlockHalf.TOP)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, BlockHalf.TOP)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R0)
                            .put(VariantSettings.MODEL, openModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, BlockHalf.TOP)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, openModelId)
                    ));

        blockStateModelGenerator.registerParentedItemModel(this, bottomModelId);
    }
}
