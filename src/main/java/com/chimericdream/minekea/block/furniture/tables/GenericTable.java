package com.chimericdream.minekea.block.furniture.tables;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaTextures;
import com.chimericdream.minekea.util.TextHelpers;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
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
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.List;
import java.util.Optional;

public class GenericTable extends Block implements MinekeaBlock, Waterloggable {
    public static final String TOOLTIP_KEY = "block.minekea.furniture.tables.tooltip";

    protected static final Model CORE_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/table")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model ALL_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_all_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model NORTH_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_north_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model SOUTH_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_south_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model EAST_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_east_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model WEST_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_west_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model NORTH_EAST_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_north_east_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model SOUTH_EAST_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_south_east_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model NORTH_WEST_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_north_west_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );
    protected static final Model SOUTH_WEST_CONNECTED_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/tables/table_south_west_connected")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );

    public final Identifier BLOCK_ID;

    protected final Block plankIngredient;
    protected final Block logIngredient;
    protected final String materialName;
    protected final boolean isFlammable;

    public static final BooleanProperty NORTH_CONNECTED;
    public static final BooleanProperty SOUTH_CONNECTED;
    public static final BooleanProperty EAST_CONNECTED;
    public static final BooleanProperty WEST_CONNECTED;

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    private static final VoxelShape TABLE_SURFACE_SHAPE;
    private static final VoxelShape[] LEG_SHAPES;

    static {
        TABLE_SURFACE_SHAPE = Block.createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0);
        LEG_SHAPES = new VoxelShape[]{
            Block.createCuboidShape(0.0, 0.0, 0.0, 2.0, 14.0, 2.0), // north-west
            Block.createCuboidShape(14.0, 0.0, 0.0, 16.0, 14.0, 2.0), // north-east
            Block.createCuboidShape(14.0, 0.0, 14.0, 16.0, 14.0, 16.0), // south-east
            Block.createCuboidShape(0.0, 0.0, 14.0, 2.0, 14.0, 16.0) // south-west
        };

        NORTH_CONNECTED = BooleanProperty.of("north_connected");
        SOUTH_CONNECTED = BooleanProperty.of("south_connected");
        EAST_CONNECTED = BooleanProperty.of("east_connected");
        WEST_CONNECTED = BooleanProperty.of("west_connected");
    }

    public GenericTable(String materialName, Block plankIngredient, Block logIngredient) {
        this(materialName, plankIngredient, logIngredient, false);
    }

    public GenericTable(String materialName, Block plankIngredient, Block logIngredient, boolean isFlammable) {
        super(AbstractBlock.Settings.copy(plankIngredient));

        this.setDefaultState(
            this.stateManager
                .getDefaultState()
                .with(NORTH_CONNECTED, false)
                .with(SOUTH_CONNECTED, false)
                .with(EAST_CONNECTED, false)
                .with(WEST_CONNECTED, false)
                .with(WATERLOGGED, false)
        );

        BLOCK_ID = makeBlockId(materialName);

        this.materialName = materialName;
        this.plankIngredient = plankIngredient;
        this.logIngredient = logIngredient;
        this.isFlammable = isFlammable;
    }

    public static Identifier makeBlockId(String materialName) {
        String material = materialName.toLowerCase().replaceAll(" ", "_");

        return Identifier.of(ModInfo.MOD_ID, String.format("furniture/tables/%s", material));
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 3)
            .pattern("XXX")
            .pattern("# #")
            .pattern("# #")
            .input('X', plankIngredient)
            .input('#', logIngredient)
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
        translationBuilder.add(this, String.format("%s Table", materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.LOG, Registries.BLOCK.getId(logIngredient).withPrefixedPath("block/"))
            .put(MinekeaTextures.PLANKS, Registries.BLOCK.getId(plankIngredient).withPrefixedPath("block/"));

        Identifier coreModelId = blockStateModelGenerator.createSubModel(this, "", CORE_MODEL, unused -> textures);
        Identifier allConnectedModelId = blockStateModelGenerator.createSubModel(this, "_all_connected", ALL_CONNECTED_MODEL, unused -> textures);
        Identifier northConnectedModelId = blockStateModelGenerator.createSubModel(this, "_connected_north", NORTH_CONNECTED_MODEL, unused -> textures);
        Identifier southConnectedModelId = blockStateModelGenerator.createSubModel(this, "_connected_south", SOUTH_CONNECTED_MODEL, unused -> textures);
        Identifier eastConnectedModelId = blockStateModelGenerator.createSubModel(this, "_connected_east", EAST_CONNECTED_MODEL, unused -> textures);
        Identifier westConnectedModelId = blockStateModelGenerator.createSubModel(this, "_connected_west", WEST_CONNECTED_MODEL, unused -> textures);
        Identifier northEastConnectedModelId = blockStateModelGenerator.createSubModel(this, "_connected_north_east", NORTH_EAST_CONNECTED_MODEL, unused -> textures);
        Identifier southEastConnectedModelId = blockStateModelGenerator.createSubModel(this, "_connected_south_east", SOUTH_EAST_CONNECTED_MODEL, unused -> textures);
        Identifier northWestConnectedModelId = blockStateModelGenerator.createSubModel(this, "_connected_north_west", NORTH_WEST_CONNECTED_MODEL, unused -> textures);
        Identifier southWestConnectedModelId = blockStateModelGenerator.createSubModel(this, "_connected_south_west", SOUTH_WEST_CONNECTED_MODEL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create()
                            .set(NORTH_CONNECTED, false)
                            .set(SOUTH_CONNECTED, false)
                            .set(EAST_CONNECTED, false)
                            .set(WEST_CONNECTED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                    )
                    .with(
                        When.create()
                            .set(NORTH_CONNECTED, true)
                            .set(SOUTH_CONNECTED, false)
                            .set(EAST_CONNECTED, false)
                            .set(WEST_CONNECTED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, northConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(NORTH_CONNECTED, false)
                            .set(SOUTH_CONNECTED, false)
                            .set(EAST_CONNECTED, true)
                            .set(WEST_CONNECTED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, eastConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(NORTH_CONNECTED, false)
                            .set(SOUTH_CONNECTED, true)
                            .set(EAST_CONNECTED, false)
                            .set(WEST_CONNECTED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, southConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(NORTH_CONNECTED, false)
                            .set(SOUTH_CONNECTED, false)
                            .set(EAST_CONNECTED, false)
                            .set(WEST_CONNECTED, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, westConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(NORTH_CONNECTED, true)
                            .set(SOUTH_CONNECTED, false)
                            .set(EAST_CONNECTED, true)
                            .set(WEST_CONNECTED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, northEastConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(NORTH_CONNECTED, false)
                            .set(SOUTH_CONNECTED, true)
                            .set(EAST_CONNECTED, true)
                            .set(WEST_CONNECTED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, southEastConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(NORTH_CONNECTED, true)
                            .set(SOUTH_CONNECTED, false)
                            .set(EAST_CONNECTED, false)
                            .set(WEST_CONNECTED, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, northWestConnectedModelId)
                    )
                    .with(
                        When.create()
                            .set(NORTH_CONNECTED, false)
                            .set(SOUTH_CONNECTED, true)
                            .set(EAST_CONNECTED, false)
                            .set(WEST_CONNECTED, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, southWestConnectedModelId)
                    )
                    .with(
                        When.anyOf(
                            When.create()
                                .set(NORTH_CONNECTED, false)
                                .set(SOUTH_CONNECTED, false)
                                .set(EAST_CONNECTED, true)
                                .set(WEST_CONNECTED, true),
                            When.create()
                                .set(NORTH_CONNECTED, true)
                                .set(SOUTH_CONNECTED, true)
                                .set(EAST_CONNECTED, false)
                                .set(WEST_CONNECTED, false),
                            When.create()
                                .set(NORTH_CONNECTED, false)
                                .set(SOUTH_CONNECTED, true)
                                .set(EAST_CONNECTED, true)
                                .set(WEST_CONNECTED, true),
                            When.create()
                                .set(NORTH_CONNECTED, true)
                                .set(SOUTH_CONNECTED, false)
                                .set(EAST_CONNECTED, true)
                                .set(WEST_CONNECTED, true),
                            When.create()
                                .set(NORTH_CONNECTED, true)
                                .set(SOUTH_CONNECTED, true)
                                .set(EAST_CONNECTED, true)
                                .set(WEST_CONNECTED, false),
                            When.create()
                                .set(NORTH_CONNECTED, true)
                                .set(SOUTH_CONNECTED, true)
                                .set(EAST_CONNECTED, false)
                                .set(WEST_CONNECTED, true),
                            When.create()
                                .set(NORTH_CONNECTED, true)
                                .set(SOUTH_CONNECTED, true)
                                .set(EAST_CONNECTED, true)
                                .set(WEST_CONNECTED, true)
                        ),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, allConnectedModelId)
                    )
            );
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(TextHelpers.getTooltip(TOOLTIP_KEY));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH_CONNECTED, SOUTH_CONNECTED, EAST_CONNECTED, WEST_CONNECTED, WATERLOGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
            .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return direction.getAxis().isHorizontal()
            ? this.getUpdatedState(state, neighborState, direction)
            : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    private BlockState getUpdatedState(BlockState state, BlockState neighborState, Direction direction) {
        if (direction == Direction.NORTH) {
            if (neighborState.isOf(this)) {
                return state.with(NORTH_CONNECTED, true);
            } else {
                return state.with(NORTH_CONNECTED, false);
            }
        }

        if (direction == Direction.SOUTH) {
            if (neighborState.isOf(this)) {
                return state.with(SOUTH_CONNECTED, true);
            } else {
                return state.with(SOUTH_CONNECTED, false);
            }
        }

        if (direction == Direction.EAST) {
            if (neighborState.isOf(this)) {
                return state.with(EAST_CONNECTED, true);
            } else {
                return state.with(EAST_CONNECTED, false);
            }
        }

        if (direction == Direction.WEST) {
            if (neighborState.isOf(this)) {
                return state.with(WEST_CONNECTED, true);
            } else {
                return state.with(WEST_CONNECTED, false);
            }
        }

        return state;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        boolean north = state.get(NORTH_CONNECTED);
        boolean south = state.get(SOUTH_CONNECTED);
        boolean east = state.get(EAST_CONNECTED);
        boolean west = state.get(WEST_CONNECTED);

        if (!north && !south && !east && !west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES);
        }

        if (north && !south && !east && !west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[2], LEG_SHAPES[3]);
        }

        if (!north && south && !east && !west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[0], LEG_SHAPES[1]);
        }

        if (!north && !south && east && !west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[0], LEG_SHAPES[3]);
        }

        if (!north && !south && !east && west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[1], LEG_SHAPES[2]);
        }

        if (north && !south && east && !west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[3]);
        }

        if (north && !south && !east && west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[2]);
        }

        if (!north && south && east && !west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[0]);
        }

        if (!north && south && !east && west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[1]);
        }

        return VoxelShapes.union(TABLE_SURFACE_SHAPE);
    }
}
