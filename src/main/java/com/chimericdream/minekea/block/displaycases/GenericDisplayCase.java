package com.chimericdream.minekea.block.displaycases;

import com.chimericdream.minekea.block.displaycases.entity.GenericDisplayCaseBlockEntity;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public abstract class GenericDisplayCase extends BlockWithEntity {
    public static final BooleanProperty HAS_ITEM = BooleanProperty.of("has_item");
    public static final IntProperty ROTATION = IntProperty.of("rotation", 0, 8);

    private final Item BARRIER_ITEM = Blocks.BARRIER.asItem();
    private final ItemStack BARRIER = BARRIER_ITEM.getDefaultStack();

    private static final VoxelShape MAIN_SHAPE;
    private static final VoxelShape BASEBOARD_SHAPE;

    static {
        MAIN_SHAPE = Block.createCuboidShape(0.0, 2.0, 0.0, 16.0, 16.0, 16.0);
        BASEBOARD_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    }

    GenericDisplayCase() {
        this(Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    }

    GenericDisplayCase(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(HAS_ITEM, false).with(ROTATION, 0));
    }

    abstract public void register();

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HAS_ITEM, ROTATION);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        if (world.isClient) return ActionResult.SUCCESS;

        Inventory blockEntity = (Inventory) world.getBlockEntity(pos);

        if (player.isInSneakingPose()) {
            // If the player is sneaking, rotate the item (if any) in the case
            boolean hasItem = state.get(HAS_ITEM);

            if (hasItem) {
                int rotation = state.get(ROTATION);
                int newRotation = rotation == 7 ? 0 : rotation + 1;

                world.setBlockState(pos, state.with(ROTATION, newRotation));
            }
        } else {
            if (!player.getStackInHand(hand).isEmpty()) {
                // If the player is holding something, put it in the case
                ItemStack toInsert = player.getStackInHand(hand).copy();
                toInsert.setCount(1);

                if (blockEntity.getStack(0).isOf(BARRIER_ITEM)) {
                    blockEntity.setStack(0, toInsert);
                    player.getStackInHand(hand).decrement(1);
                    world.setBlockState(pos, state.with(HAS_ITEM, true).with(ROTATION, 0));
                    blockEntity.markDirty();
                } else {
                    // System.out.println("The case holds " + blockEntity.getStack(0));
                }
            } else {
                // If the player isn't holding anything or sneaking, get what's in the case
                if (!blockEntity.getStack(0).isOf(BARRIER_ITEM)) {
                    player.getInventory().offerOrDrop(blockEntity.getStack(0));
                    blockEntity.setStack(0, BARRIER);
                    world.setBlockState(pos, state.with(HAS_ITEM, false).with(ROTATION, 8));
                    blockEntity.markDirty();
                }
            }
        }

        world.markDirty(pos);

        return ActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof GenericDisplayCaseBlockEntity && state.get(HAS_ITEM)) {
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

    protected void setupResources(Identifier id, String[] materials) {
        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            id,
            JRecipe.shaped(
                JPattern.pattern(" G ", "X X", "###"),
                JKeys.keys()
                    .key("G", JIngredient.ingredient().item("minecraft:glass"))
                    .key("X", JIngredient.ingredient().item(materials[0]))
                    .key("#", JIngredient.ingredient().item(materials[1])),
                JResult.stackedResult(id.toString(), 2)
            )
        );
    }
}
