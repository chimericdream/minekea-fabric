package com.chimericdream.minekea.block.furniture.seating;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.entities.mounts.SeatEntity;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaTextures;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

public class GenericChair extends Block implements MinekeaBlock, Waterloggable {
    protected static final Model CHAIR_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/furniture/seating/chair")),
        Optional.empty(),
        MinekeaTextures.LOG,
        MinekeaTextures.PLANKS
    );

    public static final DirectionProperty FACING;

    public final Identifier BLOCK_ID;

    protected final Block plankIngredient;
    protected final Block logIngredient;
    protected final String materialName;
    protected final boolean isFlammable;

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    private static final VoxelShape SEAT_SHAPE;
    private static final VoxelShape[] LEG_SHAPES;
    private static final Map<String, VoxelShape> SEAT_BACKS;

    static {
        FACING = DirectionProperty.of("facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);

        SEAT_SHAPE = Block.createCuboidShape(2.0, 8.0, 2.0, 14.0, 10.0, 14.0);
        LEG_SHAPES = new VoxelShape[]{
            Block.createCuboidShape(2.0, 0.0, 2.0, 4.0, 8.0, 4.0), // north-west
            Block.createCuboidShape(12.0, 0.0, 2.0, 14.0, 8.0, 4.0), // north-east
            Block.createCuboidShape(12.0, 0.0, 12.0, 14.0, 8.0, 14.0), // south-east
            Block.createCuboidShape(2.0, 0.0, 12.0, 4.0, 8.0, 14.0) // south-west
        };
        SEAT_BACKS = Map.of(
            "north", Block.createCuboidShape(2.0, 10.0, 2.0, 14.0, 22.0, 4.0),
            "south", Block.createCuboidShape(2.0, 10.0, 12.0, 14.0, 22.0, 14.0),
            "east", Block.createCuboidShape(12.0, 10.0, 2.0, 14.0, 22.0, 14.0),
            "west", Block.createCuboidShape(2.0, 10.0, 2.0, 4.0, 22.0, 14.0)
        );
    }

    public GenericChair(String materialName, Block plankIngredient, Block logIngredient) {
        this(materialName, plankIngredient, logIngredient, false);
    }

    public GenericChair(String materialName, Block plankIngredient, Block logIngredient, boolean isFlammable) {
        super(AbstractBlock.Settings.copy(plankIngredient));

        this.setDefaultState(
            this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
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

        return Identifier.of(ModInfo.MOD_ID, String.format("furniture/seating/chairs/%s", material));
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

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction dir = Direction.NORTH;
        if (ctx.getPlayer() != null) {
            dir = ctx.getPlayer().getHorizontalFacing();
        }

        return this.getDefaultState()
            .with(FACING, dir)
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

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return super.getCollisionShape(state, world, pos, context);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }

        List<SeatEntity> seats = world.getEntitiesByClass(SeatEntity.class, new Box(pos), (Object) -> true);

        if (seats.isEmpty() && player.isSneaking()) {
            world.setBlockState(pos, state.with(FACING, state.get(FACING).rotateYClockwise()));

            return ActionResult.SUCCESS;
        } else if (seats.isEmpty()) {
            SeatEntity seat = Seats.SEAT_ENTITY.create(world);
            Vec3d seatPos = new Vec3d(hit.getBlockPos().getX() + 0.5d, hit.getBlockPos().getY() + 1.65d, hit.getBlockPos().getZ() + 0.5d);

            seat.updatePosition(seatPos.getX(), seatPos.getY(), seatPos.getZ());
            world.spawnEntity(seat);
            player.startRiding(seat);

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);

        if (facing == Direction.SOUTH) {
            return VoxelShapes.union(VoxelShapes.union(SEAT_SHAPE, LEG_SHAPES), SEAT_BACKS.get("north"));
        }

        if (facing == Direction.EAST) {
            return VoxelShapes.union(VoxelShapes.union(SEAT_SHAPE, LEG_SHAPES), SEAT_BACKS.get("west"));
        }

        if (facing == Direction.WEST) {
            return VoxelShapes.union(VoxelShapes.union(SEAT_SHAPE, LEG_SHAPES), SEAT_BACKS.get("east"));
        }

        return VoxelShapes.union(VoxelShapes.union(SEAT_SHAPE, LEG_SHAPES), SEAT_BACKS.get("south"));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 2)
            .pattern("P ")
            .pattern("PP")
            .pattern("LL")
            .input('P', plankIngredient)
            .input('L', logIngredient)
            .criterion(FabricRecipeProvider.hasItem(plankIngredient),
                FabricRecipeProvider.conditionsFromItem(plankIngredient))
            .criterion(FabricRecipeProvider.hasItem(logIngredient),
                FabricRecipeProvider.conditionsFromItem(logIngredient))
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
        translationBuilder.add(this, String.format("%s Chair", materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.LOG, Registries.BLOCK.getId(logIngredient).withPrefixedPath("block/"))
            .put(MinekeaTextures.PLANKS, Registries.BLOCK.getId(plankIngredient).withPrefixedPath("block/"));

        Identifier modelId = blockStateModelGenerator.createSubModel(this, "", CHAIR_MODEL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create().set(FACING, Direction.NORTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, modelId)
                    )
                    .with(
                        When.create().set(FACING, Direction.EAST),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, modelId)
                    )
                    .with(
                        When.create().set(FACING, Direction.SOUTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, modelId)
                    )
                    .with(
                        When.create().set(FACING, Direction.WEST),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, modelId)
                    )
            );
    }
}
