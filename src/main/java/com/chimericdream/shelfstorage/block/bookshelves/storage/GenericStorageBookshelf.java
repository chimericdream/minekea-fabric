package com.chimericdream.shelfstorage.block.bookshelves.storage;

import com.chimericdream.shelfstorage.block.bookshelves.storage.entity.GenericStorageBookshelfBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class GenericStorageBookshelf extends BlockWithEntity {
    public static final Integer INVENTORY_SIZE = 9;
    public static final IntProperty FILL_LEVEL = IntProperty.of("fill_level", 0, 4);

    GenericStorageBookshelf() {
        super(Settings.copy(Blocks.CHEST));
        setDefaultState(getStateManager().getDefaultState().with(FILL_LEVEL, 0));
    }

    GenericStorageBookshelf(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(FILL_LEVEL, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(FILL_LEVEL);
    }

    abstract public void register();

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

        if (screenHandlerFactory != null) {
            player.openHandledScreen(screenHandlerFactory);
            return ActionResult.CONSUME;
        }

        return ActionResult.FAIL;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof GenericStorageBookshelfBlockEntity) {
                ItemScatterer.spawn(world, pos, (GenericStorageBookshelfBlockEntity) blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    public static int getFillLevel(long slots) {
        if (slots == 0) {
            return 0;
        }

        if (slots == 9) {
            return 4;
        }

        if (slots > 7) {
            return 3;
        }

        if (slots > 3) {
            return 2;
        }

        return 1;
    }
}
