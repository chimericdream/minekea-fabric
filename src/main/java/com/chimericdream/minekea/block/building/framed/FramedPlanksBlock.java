package com.chimericdream.minekea.block.building.framed;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.data.property.MinekeaProperties;
import com.chimericdream.minekea.tag.MinekeaBlockTags;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Function;

public class FramedPlanksBlock extends Block implements MinekeaBlock {
    protected static final Model CORE_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/building/framed_planks/core")),
        Optional.empty(),
        MinekeaTextures.BRACE,
        MinekeaTextures.MATERIAL
    );
    protected static final Model A_CONNECTED_MODEL = makeModel("a");
    protected static final Model B_CONNECTED_MODEL = makeModel("b");
    protected static final Model AB_CONNECTED_MODEL = makeModel("ab");

    public static final DirectionProperty FACING;
    public static final BooleanProperty CONNECTED_NORTH;
    public static final BooleanProperty CONNECTED_SOUTH;
    public static final BooleanProperty CONNECTED_EAST;
    public static final BooleanProperty CONNECTED_WEST;

    static {
        FACING = MinekeaProperties.HORIZONTAL_AXIS_FACING;
        CONNECTED_NORTH = BooleanProperty.of("connected_north");
        CONNECTED_SOUTH = BooleanProperty.of("connected_south");
        CONNECTED_EAST = BooleanProperty.of("connected_east");
        CONNECTED_WEST = BooleanProperty.of("connected_west");
    }

    public final Identifier BLOCK_ID;

    protected final String material;
    protected final String materialName;
    protected final Block plankIngredient;
    protected final Block logIngredient;
    protected final boolean isFlammable;

    protected static Model makeModel(String direction) {
        return new Model(
            Optional.of(Identifier.of(ModInfo.MOD_ID, String.format("block/building/framed_planks/%s_connected", direction))),
            Optional.empty(),
            MinekeaTextures.BRACE,
            MinekeaTextures.MATERIAL
        );
    }

    public FramedPlanksBlock(String material, String materialName, Block plankIngredient, Block logIngredient, boolean isFlammable) {
        super(AbstractBlock.Settings.copy(plankIngredient));

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/general/framed_planks/%s", material));

        this.material = material;
        this.materialName = materialName;
        this.plankIngredient = plankIngredient;
        this.logIngredient = logIngredient;
        this.isFlammable = isFlammable;

        this.setDefaultState(
            this.stateManager
                .getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(CONNECTED_NORTH, false)
                .with(CONNECTED_SOUTH, false)
                .with(CONNECTED_EAST, false)
                .with(CONNECTED_WEST, false)
        );
    }

    private boolean shouldConnect(ItemPlacementContext ctx, Direction direction, Direction facing) {
        return shouldConnect(ctx.getWorld(), ctx.getBlockPos(), direction, facing);
    }

    private boolean shouldConnect(BlockView world, BlockPos pos, Direction direction, Direction facing) {
        BlockPos neighborPos = pos.offset(direction);
        BlockState neighborState = world.getBlockState(neighborPos);

        return neighborState.isOf(this) && neighborState.get(FACING).equals(facing);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(
            FACING,
            CONNECTED_NORTH,
            CONNECTED_SOUTH,
            CONNECTED_EAST,
            CONNECTED_WEST
        );
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (ctx.getPlayer() == null) {
            return this.getDefaultState();
        }

        Direction facing = getHorizontalAxisFacing(ctx.getPlayer().getHorizontalFacing());

        if (facing.equals(Direction.NORTH)) {
            return this.getDefaultState()
                .with(FACING, facing)
                .with(CONNECTED_EAST, shouldConnect(ctx, Direction.EAST, facing))
                .with(CONNECTED_WEST, shouldConnect(ctx, Direction.WEST, facing));
        }

        return this.getDefaultState()
            .with(FACING, facing)
            .with(CONNECTED_NORTH, shouldConnect(ctx, Direction.NORTH, facing))
            .with(CONNECTED_SOUTH, shouldConnect(ctx, Direction.SOUTH, facing));
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction.getAxis().isVertical()) {
            return state;
        }

        BooleanProperty prop = getConnectionProperty(direction);

        if (!state.isOf(this)) {
            return state.with(prop, false);
        }

        return state.with(prop, neighborState.isOf(this) && neighborState.get(FACING) == state.get(FACING));
    }

    private Direction getHorizontalAxisFacing(Direction direction) {
        return switch (direction) {
            case EAST, WEST -> Direction.EAST;
            default -> Direction.NORTH;
        };
    }

    @Nullable
    private BooleanProperty getConnectionProperty(Direction direction) {
        return switch (direction) {
            case NORTH -> CONNECTED_NORTH;
            case SOUTH -> CONNECTED_SOUTH;
            case EAST -> CONNECTED_EAST;
            case WEST -> CONNECTED_WEST;
            case UP, DOWN -> null;
        };
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
            .register(itemGroup -> itemGroup.add(this));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.AXE_MINEABLE).setReplace(false).add(this);
        getBuilder.apply(MinekeaBlockTags.FRAMED_PLANKS)
            .setReplace(false)
            .add(this);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 6)
            .input(plankIngredient)
            .input(plankIngredient)
            .input(plankIngredient)
            .input(plankIngredient)
            .input(logIngredient)
            .criterion(FabricRecipeProvider.hasItem(plankIngredient),
                FabricRecipeProvider.conditionsFromItem(plankIngredient))
            .criterion(FabricRecipeProvider.hasItem(logIngredient),
                FabricRecipeProvider.conditionsFromItem(logIngredient))
            .offerTo(exporter);
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("Framed %s Planks", materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.MATERIAL, Registries.BLOCK.getId(plankIngredient).withPrefixedPath("block/"))
            .put(MinekeaTextures.BRACE, Registries.BLOCK.getId(logIngredient).withPrefixedPath("block/"));

        Identifier modelId = blockStateModelGenerator.createSubModel(this, "", CORE_MODEL, unused -> textures);
        Identifier aConnectedModelId = blockStateModelGenerator.createSubModel(this, "_a_connected", A_CONNECTED_MODEL, unused -> textures);
        Identifier bConnectedModelId = blockStateModelGenerator.createSubModel(this, "_b_connected", B_CONNECTED_MODEL, unused -> textures);
        Identifier abConnectedModelId = blockStateModelGenerator.createSubModel(this, "_ab_connected", AB_CONNECTED_MODEL, unused -> textures);

        blockStateModelGenerator.registerParentedItemModel(this, modelId);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(CONNECTED_EAST, false)
                            .set(CONNECTED_WEST, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, modelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(CONNECTED_EAST, true)
                            .set(CONNECTED_WEST, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, aConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(CONNECTED_EAST, false)
                            .set(CONNECTED_WEST, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, bConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.NORTH)
                            .set(CONNECTED_EAST, true)
                            .set(CONNECTED_WEST, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, abConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(CONNECTED_NORTH, false)
                            .set(CONNECTED_SOUTH, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, modelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(CONNECTED_NORTH, true)
                            .set(CONNECTED_SOUTH, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, aConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(CONNECTED_NORTH, false)
                            .set(CONNECTED_SOUTH, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, bConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(FACING, Direction.EAST)
                            .set(CONNECTED_NORTH, true)
                            .set(CONNECTED_SOUTH, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, abConnectedModelId)
                    )
            );
    }
}
