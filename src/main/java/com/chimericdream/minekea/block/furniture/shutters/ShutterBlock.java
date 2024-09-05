//package com.chimericdream.minekea.block.furniture.shutters;
//
//import com.chimericdream.minekea.ModInfo;
//import com.chimericdream.minekea.item.ItemGroups;
//import com.chimericdream.minekea.resource.LootTable;
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import com.chimericdream.minekea.resource.MinekeaTags;
//import com.chimericdream.minekea.resource.Model;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings;
//import com.chimericdream.minekea.util.MinekeaBlock;
//import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
//import net.fabricmc.fabric.api.registry.FuelRegistry;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.ShapeContext;
//import net.minecraft.block.Waterloggable;
//import net.minecraft.entity.ai.pathing.NavigationType;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.fluid.FluidState;
//import net.minecraft.fluid.Fluids;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemPlacementContext;
//import net.minecraft.state.StateManager;
//import net.minecraft.state.property.BooleanProperty;
//import net.minecraft.state.property.DirectionProperty;
//import net.minecraft.state.property.Properties;
//import net.minecraft.util.ActionResult;
//import net.minecraft.util.Hand;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.hit.BlockHitResult;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.util.shape.VoxelShape;
//import net.minecraft.util.shape.VoxelShapes;
//import net.minecraft.world.BlockView;
//import net.minecraft.world.World;
//import net.minecraft.world.WorldAccess;
//import net.minecraft.world.event.GameEvent;
//import org.jetbrains.annotations.Nullable;
//
//import java.util.Map;
//import java.util.Objects;
//
//public class ShutterBlock extends Block implements MinekeaBlock, Waterloggable {
//    public static final BooleanProperty OPEN;
//    public static final BooleanProperty POWERED;
//    public static final DirectionProperty WALL_SIDE;
//    public static final BooleanProperty WATERLOGGED;
//
//    private static final Map<String, VoxelShape> OUTLINE_CLOSED;
//    private static final Map<String, VoxelShape> HITBOX_OPEN;
//
//    static {
//        OPEN = Properties.OPEN;
//        POWERED = Properties.POWERED;
//        WALL_SIDE = DirectionProperty.of("wall_side", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
//        WATERLOGGED = Properties.WATERLOGGED;
//
//        OUTLINE_CLOSED = Map.of(
//            "north", Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 2.0),
//            "south", Block.createCuboidShape(0.0, 0.0, 14.0, 16.0, 16.0, 16.0),
//            "east", Block.createCuboidShape(14.0, 0.0, 0.0, 16.0, 16.0, 16.0),
//            "west", Block.createCuboidShape(0.0, 0.0, 0.0, 2.0, 16.0, 16.0)
//        );
//        HITBOX_OPEN = Map.of(
//            "north", VoxelShapes.union(
//                Block.createCuboidShape(16.0, 0.0, 0.0, 24.0, 16.0, 2.0),
//                Block.createCuboidShape(-8.0, 0.0, 0.0, 0.0, 16.0, 2.0)
//            ),
//            "south", VoxelShapes.union(
//                Block.createCuboidShape(16.0, 0.0, 14.0, 24.0, 16.0, 16.0),
//                Block.createCuboidShape(-8.0, 0.0, 14.0, 0.0, 16.0, 16.0)
//            ),
//            "east", VoxelShapes.union(
//                Block.createCuboidShape(14.0, 0.0, -8.0, 16.0, 16.0, 0.0),
//                Block.createCuboidShape(14.0, 0.0, 16.0, 16.0, 16.0, 24.0)
//            ),
//            "west", VoxelShapes.union(
//                Block.createCuboidShape(0.0, 0.0, -8.0, 2.0, 16.0, 0.0),
//                Block.createCuboidShape(0.0, 0.0, 16.0, 2.0, 16.0, 24.0)
//            )
//        );
//    }
//
//    public ShutterBlock(ShutterSettings settings) {
//        super(settings);
//
//        this.setDefaultState(
//            this.stateManager.getDefaultState()
//                .with(OPEN, false)
//                .with(POWERED, false)
//                .with(WALL_SIDE, Direction.NORTH)
//                .with(WATERLOGGED, false)
//        );
//    }
//
//    @Override
//    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
//        if (state.get(OPEN)) {
//            removeOpenHalves(state, world, pos);
//        }
//
//        return super.onBreak(world, pos, state, player);
//    }
//
//    @Override
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(OPEN, POWERED, WALL_SIDE, WATERLOGGED);
//    }
//
//    @Override
//    public boolean canPathfindThrough(BlockState state, NavigationType type) {
//        return switch (type) {
//            case LAND, AIR -> state.get(OPEN);
//            case WATER -> state.get(WATERLOGGED);
//        };
//    }
//
//    private static boolean hasSpaceToOpen(BlockState state, BlockView world, BlockPos pos) {
//        BlockPos pos1 = pos.east();
//        BlockPos pos2 = pos.west();
//
//        Direction wallSide = state.get(WALL_SIDE);
//        if (wallSide == Direction.EAST || wallSide == Direction.WEST) {
//            pos1 = pos.north();
//            pos2 = pos.south();
//        }
//
//        BlockState pos1State = world.getBlockState(pos1);
//        BlockState pos2State = world.getBlockState(pos2);
//
//        return (pos1State.isOf(Blocks.AIR) || pos1State.isOf(Blocks.WATER))
//            && (pos2State.isOf(Blocks.AIR) || pos2State.isOf(Blocks.WATER));
//    }
//
//    private void placeOpenHalves(BlockState state, World world, BlockPos pos) {
//        BlockPos left;
//        BlockPos right;
//
//        switch (state.get(WALL_SIDE)) {
//            case NORTH -> {
//                left = pos.west();
//                right = pos.east();
//            }
//            case EAST -> {
//                left = pos.north();
//                right = pos.south();
//            }
//            case SOUTH -> {
//                left = pos.east();
//                right = pos.west();
//            }
//            default -> {
//                left = pos.south();
//                right = pos.north();
//            }
//        }
//
//        BlockState leftState = world.getBlockState(left);
//        BlockState rightState = world.getBlockState(right);
//
//        String mainMaterial = ((MinekeaBlockSettings<?>) this.settings).getMainMaterial();
//
//        BlockState newLeftState = Shutters.OPEN_SHUTTER_HALVES
//            .get(mainMaterial)
//            .getDefaultState()
//            .with(OpenShutterHalf.HALF, OpenShutterHalf.ShutterHalf.LEFT)
//            .with(OpenShutterHalf.WALL_SIDE, state.get(WALL_SIDE));
//
//        BlockState newRightState = Shutters.OPEN_SHUTTER_HALVES
//            .get(mainMaterial)
//            .getDefaultState()
//            .with(OpenShutterHalf.HALF, OpenShutterHalf.ShutterHalf.RIGHT)
//            .with(OpenShutterHalf.WALL_SIDE, state.get(WALL_SIDE));
//
//        if (leftState.isOf(Blocks.WATER)) {
//            world.setBlockState(
//                left,
//                newLeftState.with(OpenShutterHalf.WATERLOGGED, true)
//            );
//        } else {
//            world.setBlockState(left, newLeftState);
//        }
//
//        if (rightState.isOf(Blocks.WATER)) {
//            world.setBlockState(right, newRightState.with(OpenShutterHalf.WATERLOGGED, true));
//        } else {
//            world.setBlockState(right, newRightState);
//        }
//    }
//
//    private void removeOpenHalves(BlockState state, World world, BlockPos pos) {
//        BlockPos pos1 = pos.east();
//        BlockPos pos2 = pos.west();
//
//        Direction wallSide = state.get(WALL_SIDE);
//        if (wallSide == Direction.EAST || wallSide == Direction.WEST) {
//            pos1 = pos.north();
//            pos2 = pos.south();
//        }
//
//        BlockState pos1State = world.getBlockState(pos1);
//        BlockState pos2State = world.getBlockState(pos2);
//
//        if (pos1State.getProperties().contains(Properties.WATERLOGGED) && pos1State.get(WATERLOGGED)) {
//            world.setBlockState(pos1, Blocks.WATER.getDefaultState());
//        } else {
//            world.setBlockState(pos1, Blocks.AIR.getDefaultState());
//        }
//
//        if (pos2State.getProperties().contains(Properties.WATERLOGGED) && pos2State.get(WATERLOGGED)) {
//            world.setBlockState(pos2, Blocks.WATER.getDefaultState());
//        } else {
//            world.setBlockState(pos2, Blocks.AIR.getDefaultState());
//        }
//    }
//
//    @Override
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        if (this.material == Material.METAL) {
//            return ActionResult.PASS;
//        }
//
//        boolean isOpen = state.get(OPEN);
//
//        if (!isOpen && !hasSpaceToOpen(state, world, pos)) {
//            return ActionResult.FAIL;
//        }
//
//        if (isOpen) {
//            removeOpenHalves(state, world, pos);
//        } else {
//            placeOpenHalves(state, world, pos);
//        }
//
//        state = state.cycle(OPEN);
//        world.setBlockState(pos, state, 2);
//        if (state.get(WATERLOGGED)) {
//            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
//        }
//
//        this.playToggleSound(player, world, pos, state.get(OPEN));
//        return ActionResult.success(world.isClient);
//    }
//
//    protected void playToggleSound(@Nullable PlayerEntity player, World world, BlockPos pos, boolean open) {
//        int i;
//        if (open) {
//            i = this.material == Material.METAL ? 1037 : 1007;
//            world.syncWorldEvent(player, i, pos, 0);
//        } else {
//            i = this.material == Material.METAL ? 1036 : 1013;
//            world.syncWorldEvent(player, i, pos, 0);
//        }
//
//        world.emitGameEvent(player, open ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
//    }
//
//    @Override
//    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
//        if (!world.isClient) {
//            boolean isReceivingPower = world.isReceivingRedstonePower(pos);
//            boolean isPowered = state.get(POWERED);
//            boolean isOpen = state.get(OPEN);
//
//            if (isReceivingPower != isPowered) {
//                if (isOpen != isReceivingPower) {
//                    if (isOpen) {
//                        removeOpenHalves(state, world, pos);
//                    } else {
//                        placeOpenHalves(state, world, pos);
//                    }
//
//                    state = state.with(OPEN, isReceivingPower);
//                    this.playToggleSound(null, world, pos, isReceivingPower);
//                }
//
//                world.setBlockState(pos, state.with(POWERED, isReceivingPower), 2);
//                if (state.get(WATERLOGGED)) {
//                    world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
//                }
//            }
//        }
//    }
//
//    @Override
//    public BlockState getPlacementState(ItemPlacementContext ctx) {
//        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
//
//        BlockState blockState = this.getDefaultState().with(WALL_SIDE, ctx.getPlayerFacing());
//
//        if (ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos())) {
//            blockState = blockState.with(OPEN, true).with(POWERED, true);
//        }
//
//        return blockState.with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
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
//            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
//        }
//
//        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
//    }
//
//    @Override
//    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        if (state.get(OPEN)) {
//            return VoxelShapes.empty();
//        }
//
//        return switch (state.get(WALL_SIDE)) {
//            case SOUTH -> OUTLINE_CLOSED.get("south");
//            case WEST -> OUTLINE_CLOSED.get("west");
//            case EAST -> OUTLINE_CLOSED.get("east");
//            default -> OUTLINE_CLOSED.get("north");
//        };
//    }
//
//    @Override
//    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        if (state.get(OPEN)) {
//            return switch (state.get(WALL_SIDE)) {
//                case SOUTH -> HITBOX_OPEN.get("south");
//                case WEST -> HITBOX_OPEN.get("west");
//                case EAST -> HITBOX_OPEN.get("east");
//                default -> HITBOX_OPEN.get("north");
//            };
//        }
//
//        return switch (state.get(WALL_SIDE)) {
//            case SOUTH -> OUTLINE_CLOSED.get("south");
//            case WEST -> OUTLINE_CLOSED.get("west");
//            case EAST -> OUTLINE_CLOSED.get("east");
//            default -> OUTLINE_CLOSED.get("north");
//        };
//    }
//
//    @Override
//    public Identifier getBlockID() {
//        return ((MinekeaBlockSettings<?>) this.settings).getBlockId();
//    }
//
//    @Override
//    public void register() {
//        register(false);
//    }
//
//    public void register(boolean isFlammable) {
//        Registry.register(Registry.BLOCK, getBlockID(), this);
//        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroups.FURNITURE)));
//
//        if (isFlammable) {
//            FuelRegistry.INSTANCE.add(this, 300);
//            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
//        }
//
//        setupResources();
//    }
//
//    @Override
//    public void setupResources() {
//        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
//        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
//        MinekeaTags.SHUTTERS.add(getBlockID(), settings.isWooden());
//        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));
//
//        Identifier PLANK_MATERIAL = settings.getMaterial("planks");
//        Identifier LOG_MATERIAL = settings.getMaterial("log");
//
//        Identifier plankTexture = settings.getBlockTexture("planks");
//        Identifier logTexture = settings.getBlockTexture("log");
//
//        Identifier CLOSED_MODEL_ID = Model.getBlockModelID(getBlockID());
//        Identifier OPEN_MODEL_ID = Identifier.of(CLOSED_MODEL_ID + "_open");
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
//
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            getBlockID(),
//            JRecipe.shaped(
//                JPattern.pattern("LPL", "LPL", "LPL"),
//                JKeys.keys()
//                    .key("P", JIngredient.ingredient().item(PLANK_MATERIAL.toString()))
//                    .key("L", JIngredient.ingredient().item(LOG_MATERIAL.toString())),
//                JResult.stackedResult(getBlockID().toString(), 6)
//            )
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));
//
//        JTextures textures = new JTextures()
//            .var("frame", logTexture.toString())
//            .var("panel", plankTexture.toString());
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minekea:block/furniture/shutters/closed").textures(textures),
//            CLOSED_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minekea:block/furniture/shutters/open").textures(textures),
//            OPEN_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model(CLOSED_MODEL_ID).textures(textures),
//            ITEM_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("wall_side=north,open=false", new JBlockModel(CLOSED_MODEL_ID).y(180))
//                    .put("wall_side=south,open=false", new JBlockModel(CLOSED_MODEL_ID))
//                    .put("wall_side=east,open=false", new JBlockModel(CLOSED_MODEL_ID).y(270))
//                    .put("wall_side=west,open=false", new JBlockModel(CLOSED_MODEL_ID).y(90))
//                    .put("open=true", new JBlockModel(OPEN_MODEL_ID))
//            ),
//            getBlockID()
//        );
//    }
//
//    public static class ShutterSettings extends MinekeaBlockSettings<ShutterSettings> {
//        protected ShutterSettings(DefaultSettings settings) {
//            super(settings);
//        }
//
//        @Override
//        public Identifier getBlockId() {
//            if (blockId == null) {
//                blockId = Identifier.of(ModInfo.MOD_ID, String.format("%sfurniture/shutters/%s", ModInfo.getModPrefix(modId), mainMaterial));
//            }
//
//            return blockId;
//        }
//
//        @Override
//        public String getNamePattern() {
//            return Objects.requireNonNullElse(namePatternOverride, "%s Shutters");
//        }
//    }
//}
