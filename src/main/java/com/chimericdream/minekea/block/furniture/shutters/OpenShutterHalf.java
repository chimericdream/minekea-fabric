//package com.chimericdream.minekea.block.furniture.shutters;
//
//import com.chimericdream.minekea.block.furniture.shutters.ShutterBlock.ShutterSettings;
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import com.chimericdream.minekea.resource.Model;
//import com.chimericdream.minekea.util.MinekeaBlock;
//import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.ShapeContext;
//import net.minecraft.block.Waterloggable;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.fluid.FluidState;
//import net.minecraft.fluid.Fluids;
//import net.minecraft.item.ItemStack;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.state.StateManager;
//import net.minecraft.state.property.BooleanProperty;
//import net.minecraft.state.property.DirectionProperty;
//import net.minecraft.state.property.EnumProperty;
//import net.minecraft.state.property.Properties;
//import net.minecraft.util.ActionResult;
//import net.minecraft.util.Hand;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.StringIdentifiable;
//import net.minecraft.util.hit.BlockHitResult;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.util.shape.VoxelShape;
//import net.minecraft.world.BlockView;
//import net.minecraft.world.World;
//import net.minecraft.world.WorldAccess;
//import net.minecraft.world.WorldView;
//import net.minecraft.world.event.GameEvent;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.Map;
//
//public class OpenShutterHalf extends Block implements MinekeaBlock, Waterloggable {
//    public static final EnumProperty<ShutterHalf> HALF;
//    public static final DirectionProperty WALL_SIDE;
//    public static final BooleanProperty WATERLOGGED;
//
//    private static final Map<String, VoxelShape> OUTLINE_LEFT;
//    private static final Map<String, VoxelShape> OUTLINE_RIGHT;
//
//    private final ShutterSettings shutterSettings;
//
//    static {
//        HALF = EnumProperty.of("half", ShutterHalf.class);
//        WALL_SIDE = DirectionProperty.of("wall_side", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
//        WATERLOGGED = Properties.WATERLOGGED;
//
//        OUTLINE_LEFT = Map.of(
//            "north", Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 2.0),
//            "south", Block.createCuboidShape(0.0, 0.0, 14.0, 8.0, 16.0, 16.0),
//            "east", Block.createCuboidShape(14.0, 0.0, 8.0, 16.0, 16.0, 16.0),
//            "west", Block.createCuboidShape(0.0, 0.0, 0.0, 2.0, 16.0, 8.0)
//        );
//
//        OUTLINE_RIGHT = Map.of(
//            "north", Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 2.0),
//            "south", Block.createCuboidShape(8.0, 0.0, 14.0, 16.0, 16.0, 16.0),
//            "east", Block.createCuboidShape(14.0, 0.0, 0.0, 16.0, 16.0, 8.0),
//            "west", Block.createCuboidShape(0.0, 0.0, 8.0, 2.0, 16.0, 16.0)
//        );
//    }
//
//    public OpenShutterHalf(ShutterSettings settings) {
//        super(AbstractBlock.Settings.copy(Blocks.BARRIER));
//
//        this.shutterSettings = settings;
//
//        this.setDefaultState(
//            this.stateManager
//                .getDefaultState()
//                .with(HALF, ShutterHalf.LEFT)
//                .with(WALL_SIDE, Direction.NORTH)
//                .with(WATERLOGGED, false)
//        );
//    }
//
//    @Override
//    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
//        return new ItemStack(Shutters.SHUTTERS.get(this.shutterSettings.getMainMaterial()));
//    }
//
//    @Override
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(HALF, WALL_SIDE, WATERLOGGED);
//    }
//
//    @Override
//    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        if (state.get(HALF) == ShutterHalf.LEFT) {
//            return switch (state.get(WALL_SIDE)) {
//                case SOUTH -> OUTLINE_LEFT.get("south");
//                case WEST -> OUTLINE_LEFT.get("west");
//                case EAST -> OUTLINE_LEFT.get("east");
//                default -> OUTLINE_LEFT.get("north");
//            };
//        }
//
//        return switch (state.get(WALL_SIDE)) {
//            case SOUTH -> OUTLINE_RIGHT.get("south");
//            case WEST -> OUTLINE_RIGHT.get("west");
//            case EAST -> OUTLINE_RIGHT.get("east");
//            default -> OUTLINE_RIGHT.get("north");
//        };
//    }
//
//    @Override
//    public FluidState getFluidState(BlockState state) {
//        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
//    }
//
//    @Override
//    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
//        if (state.get(WATERLOGGED)) {
//            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
//        }
//
//        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
//    }
//
//    @Override
//    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
//        BlockPos centerPos;
//        BlockPos oppositePos;
//
//        ShutterHalf half = state.get(HALF);
//        switch (state.get(WALL_SIDE)) {
//            case SOUTH -> {
//                centerPos = half == ShutterHalf.LEFT ? pos.west() : pos.east();
//                oppositePos = half == ShutterHalf.LEFT ? pos.west(2) : pos.east(2);
//            }
//            case EAST -> {
//                centerPos = half == ShutterHalf.LEFT ? pos.south() : pos.north();
//                oppositePos = half == ShutterHalf.LEFT ? pos.south(2) : pos.north(2);
//            }
//            case WEST -> {
//                centerPos = half == ShutterHalf.LEFT ? pos.north() : pos.south();
//                oppositePos = half == ShutterHalf.LEFT ? pos.north(2) : pos.south(2);
//            }
//            default -> {
//                centerPos = half == ShutterHalf.LEFT ? pos.east() : pos.west();
//                oppositePos = half == ShutterHalf.LEFT ? pos.east(2) : pos.west(2);
//            }
//        }
//
//        BlockState centerState = world.getBlockState(centerPos);
//        if (centerState.getProperties().contains(Properties.WATERLOGGED) && centerState.get(WATERLOGGED)) {
//            world.setBlockState(centerPos, Blocks.WATER.getDefaultState());
//        } else {
//            world.setBlockState(centerPos, Blocks.AIR.getDefaultState());
//        }
//
//        BlockState oppositeState = world.getBlockState(oppositePos);
//
//        if (oppositeState.getProperties().contains(Properties.WATERLOGGED) && oppositeState.get(WATERLOGGED)) {
//            world.setBlockState(oppositePos, Blocks.WATER.getDefaultState());
//        } else {
//            world.setBlockState(oppositePos, Blocks.AIR.getDefaultState());
//        }
//
//        if (state.get(WATERLOGGED)) {
//            world.setBlockState(pos, Blocks.WATER.getDefaultState());
//        } else {
//            world.setBlockState(pos, Blocks.AIR.getDefaultState());
//        }
//
//        if (centerState.get(WATERLOGGED)) {
//            world.scheduleFluidTick(centerPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
//        }
//
//        return super.onBreak(world, centerPos, centerState, player);
//    }
//
//    @Override
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        if (this.material == Material.METAL) {
//            return ActionResult.PASS;
//        }
//
//        BlockPos centerPos;
//        BlockPos oppositePos;
//
//        ShutterHalf half = state.get(HALF);
//        switch (state.get(WALL_SIDE)) {
//            case SOUTH -> {
//                centerPos = half == ShutterHalf.LEFT ? pos.west() : pos.east();
//                oppositePos = half == ShutterHalf.LEFT ? pos.west(2) : pos.east(2);
//            }
//            case EAST -> {
//                centerPos = half == ShutterHalf.LEFT ? pos.south() : pos.north();
//                oppositePos = half == ShutterHalf.LEFT ? pos.south(2) : pos.north(2);
//            }
//            case WEST -> {
//                centerPos = half == ShutterHalf.LEFT ? pos.north() : pos.south();
//                oppositePos = half == ShutterHalf.LEFT ? pos.north(2) : pos.south(2);
//            }
//            default -> {
//                centerPos = half == ShutterHalf.LEFT ? pos.east() : pos.west();
//                oppositePos = half == ShutterHalf.LEFT ? pos.east(2) : pos.west(2);
//            }
//        }
//
//        BlockState centerState = world.getBlockState(centerPos);
//        centerState = centerState.cycle(ShutterBlock.OPEN);
//        world.setBlockState(centerPos, centerState, 2);
//
//        BlockState oppositeState = world.getBlockState(oppositePos);
//
//        if (oppositeState.getProperties().contains(Properties.WATERLOGGED) && oppositeState.get(WATERLOGGED)) {
//            world.setBlockState(oppositePos, Blocks.WATER.getDefaultState());
//        } else {
//            world.setBlockState(oppositePos, Blocks.AIR.getDefaultState());
//        }
//
//        if (state.get(WATERLOGGED)) {
//            world.setBlockState(pos, Blocks.WATER.getDefaultState());
//        } else {
//            world.setBlockState(pos, Blocks.AIR.getDefaultState());
//        }
//
//        if (centerState.get(WATERLOGGED)) {
//            world.scheduleFluidTick(centerPos, Fluids.WATER, Fluids.WATER.getTickRate(world));
//        }
//
//        this.playToggleSound(player, world, centerPos, centerState.getMaterial());
//        return ActionResult.success(world.isClient);
//    }
//
//    protected void playToggleSound(@Nullable PlayerEntity player, World world, BlockPos pos, Material material) {
//        int i = material == Material.METAL ? 1036 : 1013;
//        world.syncWorldEvent(player, i, pos, 0);
//        world.emitGameEvent(player, GameEvent.BLOCK_CLOSE, pos);
//    }
//
//    @Override
//    public Identifier getBlockID() {
//        return Identifier.of(shutterSettings.getBlockId() + "_open");
//    }
//
//    @Override
//    public void register() {
//        Registry.register(Registries.BLOCK, getBlockID(), this);
//
//        setupResources();
//    }
//
//    @Override
//    public void setupResources() {
//        MinekeaResourcePack.EN_US.blockRespect(this, String.format(shutterSettings.getNamePattern(), shutterSettings.getIngredientName()));
//
//        Identifier LEFT_MODEL_ID = Model.getBlockModelID(getBlockID() + "_left");
//        Identifier RIGHT_MODEL_ID = Model.getBlockModelID(getBlockID() + "_right");
//
//        Identifier plankTexture = shutterSettings.getBlockTexture("planks");
//        Identifier logTexture = shutterSettings.getBlockTexture("log");
//
//        JTextures textures = new JTextures()
//            .var("frame", logTexture.toString())
//            .var("panel", plankTexture.toString());
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minekea:block/furniture/shutters/left_half").textures(textures),
//            LEFT_MODEL_ID
//        );
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minekea:block/furniture/shutters/right_half").textures(textures),
//            RIGHT_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("half=left,wall_side=north", new JBlockModel(RIGHT_MODEL_ID).y(180))
//                    .put("half=left,wall_side=south", new JBlockModel(RIGHT_MODEL_ID))
//                    .put("half=left,wall_side=east", new JBlockModel(RIGHT_MODEL_ID).y(270))
//                    .put("half=left,wall_side=west", new JBlockModel(RIGHT_MODEL_ID).y(90))
//                    .put("half=right,wall_side=north", new JBlockModel(LEFT_MODEL_ID).y(180))
//                    .put("half=right,wall_side=south", new JBlockModel(LEFT_MODEL_ID))
//                    .put("half=right,wall_side=east", new JBlockModel(LEFT_MODEL_ID).y(270))
//                    .put("half=right,wall_side=west", new JBlockModel(LEFT_MODEL_ID).y(90))
//            ),
//            getBlockID()
//        );
//    }
//
//    public enum ShutterHalf implements StringIdentifiable {
//        LEFT("left"),
//        RIGHT("right");
//
//        private final String name;
//
//        private ShutterHalf(String name) {
//            this.name = name;
//        }
//
//        public String toString() {
//            return this.name;
//        }
//
//        public String asString() {
//            return this.name;
//        }
//    }
//}
