package com.chimericdream.minekea.block.furniture.displaycases;

import com.chimericdream.minekea.MinekeaMod;
import com.chimericdream.minekea.entities.blocks.furniture.DisplayCaseBlockEntity;
import com.chimericdream.minekea.util.ImplementedInventory;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

abstract public class GenericDisplayCase extends BlockWithEntity implements MinekeaBlock, Waterloggable {
    public static final IntProperty ROTATION = IntProperty.of("rotation", 0, 8);

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    private static final VoxelShape MAIN_SHAPE;
    private static final VoxelShape BASEBOARD_SHAPE;

    static {
        MAIN_SHAPE = Block.createCuboidShape(0.0, 2.0, 0.0, 16.0, 16.0, 16.0);
        BASEBOARD_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    }

    public GenericDisplayCase() {
        this(new Settings());
    }

    public GenericDisplayCase(Settings settings) {
        super(settings);

        this.setDefaultState(
            this.stateManager.getDefaultState()
                .with(ROTATION, 0)
                .with(WATERLOGGED, false)
        );
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState()
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

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ROTATION, WATERLOGGED);
    }

    private int getRotationFromPlayerFacing(float yaw) {
        float absYaw = yaw + 180;

        int rotation = Math.round(absYaw / 45) + 4;

        return MathHelper.clamp(rotation, 0, 7);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }

        DisplayCaseBlockEntity entity;

        try {
            entity = (DisplayCaseBlockEntity) world.getBlockEntity(pos);
            assert entity != null;
        } catch (Exception e) {
            MinekeaMod.LOGGER.error(String.format("The display case at %s had an invalid block entity.\nBlock Entity: %s", pos, world.getBlockEntity(pos)));

            return ActionResult.FAIL;
        }

        // If the case is empty, there's nothing to get or rotate
        if (entity.isEmpty()) {
            return ActionResult.SUCCESS;
        }

        if (player.isSneaking()) {
            // If the player is sneaking, get what's in the case
            ItemScatterer.spawn(
                world,
                player.getX(),
                player.getY(),
                player.getZ(),
                entity.removeStack(0)
            );

            world.setBlockState(pos, state.with(ROTATION, 0));
            entity.markDirty();
            entity.playRemoveItemSound();
        } else {
            // Otherwise, rotate the item in the case
            int rotation = state.get(ROTATION);
            int newRotation = rotation >= 7 ? 0 : rotation + 1;

            world.setBlockState(pos, state.with(ROTATION, newRotation));
            entity.playRotateItemSound();
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient()) {
            return ItemActionResult.SUCCESS;
        }

        DisplayCaseBlockEntity entity;

        try {
            entity = (DisplayCaseBlockEntity) world.getBlockEntity(pos);
            assert entity != null;
        } catch (Exception e) {
            MinekeaMod.LOGGER.error(String.format("The display case at %s had an invalid block entity.\nBlock Entity: %s", pos, world.getBlockEntity(pos)));

            return ItemActionResult.FAIL;
        }

        if (entity.isEmpty()) {
            // If the player is holding something, put it in the case
            if (!stack.isEmpty()) {
                ItemStack toInsert = stack.copy();
                toInsert.setCount(1);

                entity.setStack(0, toInsert);

                stack.decrement(1);

                world.setBlockState(pos, state.with(ROTATION, getRotationFromPlayerFacing(player.getYaw())));
                entity.markDirty();
                entity.playAddItemSound();
            }
        } else {
            // If the player isn't sneaking, or if they have an item in their hand, rotate the item in the case
            int rotation = state.get(ROTATION);
            int newRotation = rotation >= 7 ? 0 : rotation + 1;

            world.setBlockState(pos, state.with(ROTATION, newRotation));
            entity.playRotateItemSound();
        }

        world.markDirty(pos);

        return ItemActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof DisplayCaseBlockEntity) {
                ItemScatterer.spawn(world, pos, (DisplayCaseBlockEntity) blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DisplayCaseBlockEntity(pos, state);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(MAIN_SHAPE, BASEBOARD_SHAPE);
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        ImplementedInventory displayCase;

        try {
            displayCase = (ImplementedInventory) world.getBlockEntity(pos);
            assert displayCase != null;
        } catch (Exception e) {
            throw new IllegalStateException(String.format("The display case at %s had an invalid block entity.\nBlock Entity: %s", pos, world.getBlockEntity(pos)));
        }

        if (displayCase.isEmpty()) {
            return 0;
        }

        int rotation = state.get(ROTATION);

        return (rotation * 2) + 1;
    }

    @Override
    public void setupResources() {
//        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
//        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
//        MinekeaTags.DISPLAY_CASES.add(getBlockID(), settings.isWooden());
//        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));
//
//        boolean isStripped = ((DisplayCaseSettings) settings).isStripped;
//
//        Identifier planks = settings.getMaterial("planks");
//        Identifier log = settings.getMaterial("log");
//        Identifier stripped_log = settings.getMaterial("stripped_log");
//
//        Identifier logTexture = settings.getBlockTexture("log");
//        Identifier strippedLogTexture = settings.getBlockTexture("stripped_log");
//
//        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
//
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            getBlockID(),
//            JRecipe.shaped(
//                JPattern.pattern(" G ", "X X", "###"),
//                JKeys.keys()
//                    .key("G", JIngredient.ingredient().item("minecraft:glass"))
//                    .key("#", JIngredient.ingredient().item(planks.toString()))
//                    .key("X", JIngredient.ingredient().item(isStripped ? stripped_log.toString() : log.toString())),
//                JResult.stackedResult(getBlockID().toString(), 2)
//            )
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);
//
//        JTextures textures = new JTextures()
//            .var("stripped_material", strippedLogTexture.toString())
//            .var("material", isStripped ? strippedLogTexture.toString() : logTexture.toString())
//            .var("particle", strippedLogTexture.toString());
//
//        JModel model = JModel.model("minekea:block/furniture/display_case").textures(textures);
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(model, MODEL_ID);
//
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(JState.variant(new JBlockModel(MODEL_ID))),
//            getBlockID()
//        );
    }

//    public static class DisplayCaseSettings extends MinekeaBlockSettings<DisplayCaseSettings> {
//        protected boolean isStripped = false;
//
//        public DisplayCaseSettings(DefaultSettings settings) {
//            super((DefaultSettings) settings.nonOpaque());
//        }
//
//        public String getNamePattern() {
//            if (isStripped) {
//                return Objects.requireNonNullElse(namePatternOverride, "Stripped %s Display Case");
//            }
//
//            return Objects.requireNonNullElse(namePatternOverride, "%s Display Case");
//        }
//
//        public boolean isStripped() {
//            return this.isStripped;
//        }
//
//        public DisplayCaseSettings stripped() {
//            this.isStripped = true;
//            return this;
//        }
//
//        public DisplayCaseSettings unstripped() {
//            this.isStripped = false;
//            return this;
//        }
//    }
}
