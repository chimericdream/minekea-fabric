package com.chimericdream.minekea.block.furniture.doors;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.ItemModelGenerator;
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
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import java.util.Optional;

public class GenericBookshelfDoor extends DoorBlock implements MinekeaBlock {
    protected static final Model ITEM_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "item/furniture/doors/bookshelf")),
        Optional.empty(),
        MinekeaTextures.MATERIAL,
        MinekeaTextures.SHELF
    );
    protected static final Model BOTTOM_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/doors/bookshelves/bottom")),
        Optional.empty(),
        MinekeaTextures.MATERIAL,
        MinekeaTextures.SHELF
    );
    protected static final Model BOTTOM_HINGE_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/doors/bookshelves/bottom_rh")),
        Optional.empty(),
        MinekeaTextures.MATERIAL,
        MinekeaTextures.SHELF
    );
    protected static final Model TOP_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/doors/bookshelves/top")),
        Optional.empty(),
        MinekeaTextures.MATERIAL,
        MinekeaTextures.SHELF
    );
    protected static final Model TOP_HINGE_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/doors/bookshelves/top_rh")),
        Optional.empty(),
        MinekeaTextures.MATERIAL,
        MinekeaTextures.SHELF
    );

    public final Identifier BLOCK_ID;

    protected final Block plankIngredient;
    protected final String materialName;
    protected final boolean isFlammable;

    public GenericBookshelfDoor(BlockSetType type, String materialName, Block plankIngredient) {
        this(type, materialName, plankIngredient, true);
    }

    public GenericBookshelfDoor(BlockSetType type, String materialName, Block plankIngredient, boolean isFlammable) {
        super(type, AbstractBlock.Settings.create());

        BLOCK_ID = makeBlockId(materialName);

        this.materialName = materialName;
        this.plankIngredient = plankIngredient;
        this.isFlammable = isFlammable;
    }

    public static Identifier makeBlockId(String materialName) {
        String material = materialName.toLowerCase().replaceAll(" ", "_");

        return Identifier.of(ModInfo.MOD_ID, String.format("furniture/doors/bookshelves/%s", material));
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }
    }

    private Block getBookshelf() {
        if (materialName == "Oak") {
            return Blocks.BOOKSHELF;
        }

        return Bookshelves.BOOKSHELVES.get(materialName);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        Block bookshelf = getBookshelf();

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 3)
            .pattern("##")
            .pattern("##")
            .pattern("##")
            .input('#', bookshelf)
            .criterion(FabricRecipeProvider.hasItem(bookshelf),
                FabricRecipeProvider.conditionsFromItem(bookshelf))
            .offerTo(exporter);
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.doorDrops(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Bookshelf Door", materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.MATERIAL, TextureMap.getId(plankIngredient))
            .put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf0"));

        Identifier bottomModelId = blockStateModelGenerator.createSubModel(this, "_bottom", BOTTOM_MODEL, unused -> textures);
        Identifier bottomHingeModelId = blockStateModelGenerator.createSubModel(this, "_bottom_rh", BOTTOM_HINGE_MODEL, unused -> textures);
        Identifier topModelId = blockStateModelGenerator.createSubModel(this, "_top", TOP_MODEL, unused -> textures);
        Identifier topHingeModelId = blockStateModelGenerator.createSubModel(this, "_top_rh", TOP_HINGE_MODEL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, bottomModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, DoubleBlockHalf.LOWER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, bottomHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, topModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.SOUTH)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.LEFT)
                            .set(OPEN, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.WEST)
                            .set(HALF, DoubleBlockHalf.UPPER)
                            .set(HINGE, DoorHinge.RIGHT)
                            .set(OPEN, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, topHingeModelId)
                    )
            );
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.MATERIAL, TextureMap.getId(plankIngredient))
            .put(MinekeaTextures.SHELF, Identifier.of(ModInfo.MOD_ID, "block/furniture/bookshelves/shelf0"));

        ITEM_MODEL.upload(
            BLOCK_ID.withPrefixedPath("item/"),
            textures,
            itemModelGenerator.writer
        );
    }
}
