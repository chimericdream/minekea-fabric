package com.chimericdream.minekea.block.bookshelves.storage;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.bookshelves.Bookshelves;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class GenericStorageBookshelf extends BlockWithEntity {
    public static final Integer ROW_COUNT = 1;

    public static final DirectionProperty FACING;
    public static final IntProperty FILL_LEVEL;
    public static final BooleanProperty OPEN;

    private final Identifier BLOCK_ID;
    private final String woodType;

    static {
        FACING = Properties.FACING;
        FILL_LEVEL = IntProperty.of("fill_level", 0, 4);
        OPEN = Properties.OPEN;
    }

    public GenericStorageBookshelf(String woodType) {
        super(Settings.copy(Blocks.CHEST));

        setDefaultState(getStateManager().getDefaultState().with(FILL_LEVEL, 0).with(FACING, Direction.NORTH).with(OPEN, false));

        this.woodType = woodType;
        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("bookshelves/storage/%s_storage_shelf", woodType));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, FILL_LEVEL, OPEN);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    public void register() {
        this.register(true);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, Bookshelves.STORAGE_SHELF_BLOCK_ENTITY, StorageBookshelfBlockEntity::tick);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StorageBookshelfBlockEntity(pos, state);
    }

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
            if (blockEntity instanceof StorageBookshelfBlockEntity) {
                ItemScatterer.spawn(world, pos, (StorageBookshelfBlockEntity) blockEntity);
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
