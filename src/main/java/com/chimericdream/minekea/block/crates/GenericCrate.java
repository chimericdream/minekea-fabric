package com.chimericdream.minekea.block.crates;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
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
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class GenericCrate extends BlockWithEntity {
    public static final Integer ROW_COUNT = 6;

    public static final EnumProperty<Axis> AXIS;
    public static final DirectionProperty FACING;
    public static final BooleanProperty OPEN;

    private final Identifier BLOCK_ID;
    private final String woodType;
    private final String[] materials;

    static {
        AXIS = Properties.AXIS;
        FACING = Properties.FACING;
        OPEN = Properties.OPEN;
    }

    GenericCrate(String woodType, String[] materials) {
        this(woodType, materials, FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(3.0F, 4.0F));
    }

    GenericCrate(String woodType, String[] materials, Settings settings) {
        super(settings);

        this.materials = materials;
        this.woodType = woodType;
        this.setDefaultState(this.stateManager.getDefaultState().with(AXIS, Direction.Axis.Y).with(FACING, Direction.NORTH).with(OPEN, false));
        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("crates/%s_crate", woodType));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CrateBlockEntity(Crates.CRATE_BLOCK_ENTITY, pos, state);
    }

    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        FuelRegistry.INSTANCE.add(this, 300);
        FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);

        setupResources();
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, Crates.CRATE_BLOCK_ENTITY, CrateBlockEntity::tick);
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState) state.with(FACING, rotation.rotate((Direction) state.get(FACING)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction) state.get(FACING)));
    }

    public static BlockState changeRotation(BlockState state, BlockRotation rotation) {
        switch (rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch ((Axis) state.get(AXIS)) {
                    case X:
                        return (BlockState) state.with(AXIS, Axis.Z);
                    case Z:
                        return (BlockState) state.with(AXIS, Axis.X);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS, FACING, OPEN);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(AXIS, ctx.getSide().getAxis()).with(FACING, ctx.getPlayerLookDirection().getOpposite());
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
            if (blockEntity instanceof CrateBlockEntity) {
                ItemScatterer.spawn(world, pos, (CrateBlockEntity) blockEntity);
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

    protected void setupResources() {
        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("#X#", "XXX", "#X#"),
                JKeys.keys()
                    .key("X", JIngredient.ingredient().item(materials[0]))
                    .key("#", JIngredient.ingredient().item(materials[1])),
                JResult.result(BLOCK_ID.toString())
            )
        );
    }
}
