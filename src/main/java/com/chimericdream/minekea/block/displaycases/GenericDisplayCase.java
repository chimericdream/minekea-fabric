package com.chimericdream.minekea.block.displaycases;

import com.chimericdream.minekea.block.displaycases.entity.GenericDisplayCaseBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public abstract class GenericDisplayCase extends BlockWithEntity {
    private static final VoxelShape MAIN_SHAPE;
    private static final VoxelShape BASEBOARD_SHAPE;

    static {
        MAIN_SHAPE = Block.createCuboidShape(0.0, 2.0, 0.0, 16.0, 16.0, 16.0);
        BASEBOARD_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    }

    GenericDisplayCase() {
        super(Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    }

    GenericDisplayCase(Settings settings) {
        super(settings);
    }

    abstract public void register();

    @Override
    public ActionResult onUse(BlockState blockState, World world, BlockPos blockPos, PlayerEntity player, Hand hand, BlockHitResult blockHitResult) {
        if (world.isClient) return ActionResult.SUCCESS;

        Inventory blockEntity = (Inventory) world.getBlockEntity(blockPos);

        if (!player.getStackInHand(hand).isEmpty()) {
            // If the player is holding something, put it in the case
            ItemStack toInsert = player.getStackInHand(hand).copy();
            toInsert.setCount(1);

            if (blockEntity.getStack(0).isEmpty()) {
                blockEntity.setStack(0, toInsert);
                blockEntity.markDirty();
                player.getStackInHand(hand).decrement(1);
            } else {
                System.out.println("The case holds " + blockEntity.getStack(0));
            }
        } else {
            // If the player isn't holding anything, get what's in the case
            if (!blockEntity.getStack(0).isEmpty()) {
                player.getInventory().offerOrDrop(blockEntity.getStack(0));
                blockEntity.removeStack(0);
                blockEntity.markDirty();
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof GenericDisplayCaseBlockEntity) {
                ItemScatterer.spawn(world, pos, (GenericDisplayCaseBlockEntity) blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new GenericDisplayCaseBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(MAIN_SHAPE, BASEBOARD_SHAPE);
    }
}
