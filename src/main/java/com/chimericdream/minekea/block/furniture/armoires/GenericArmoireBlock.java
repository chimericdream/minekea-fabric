package com.chimericdream.minekea.block.furniture.armoires;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Map;

public class GenericArmoireBlock extends Block implements MinekeaBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF;
    public static final DirectionProperty FACING;

    protected static final VoxelShape NORTH_TOP_SHAPE;
    protected static final VoxelShape NORTH_BOTTOM_SHAPE;

    protected static final VoxelShape SOUTH_TOP_SHAPE;
    protected static final VoxelShape SOUTH_BOTTOM_SHAPE;

    protected static final VoxelShape EAST_TOP_SHAPE;
    protected static final VoxelShape EAST_BOTTOM_SHAPE;

    protected static final VoxelShape WEST_TOP_SHAPE;
    protected static final VoxelShape WEST_BOTTOM_SHAPE;

    static {
        FACING = HorizontalFacingBlock.FACING;
        HALF = Properties.DOUBLE_BLOCK_HALF;

        NORTH_TOP_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 0.0, 1.0, 16.0, 10.0),   // left
            Block.createCuboidShape(15.0, 0.0, 0.0, 16.0, 16.0, 10.0), // right
            Block.createCuboidShape(1.0, 0.0, 0.0, 15.0, 16.0, 1.0),   // back
            Block.createCuboidShape(1.0, 15.0, 1.0, 15.0, 16.0, 10.0), // top
            Block.createCuboidShape(1.0, 12.0, 5.0, 15.0, 13.0, 6.0)  // pole
        );
        NORTH_BOTTOM_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 1.0, 10.0),   // bottom
            Block.createCuboidShape(1.0, 4.0, 1.0, 15.0, 5.0, 9.0),    // shelf
            Block.createCuboidShape(15.0, 1.0, 0.0, 16.0, 16.0, 10.0), // right
            Block.createCuboidShape(0.0, 1.0, 0.0, 1.0, 16.0, 10.0),   // left
            Block.createCuboidShape(1.0, 1.0, 0.0, 15.0, 16.0, 1.0)    // back
        );

        SOUTH_TOP_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 6.0, 1.0, 16.0, 16.0),   // left
            Block.createCuboidShape(15.0, 0.0, 6.0, 16.0, 16.0, 16.0), // right
            Block.createCuboidShape(1.0, 0.0, 15.0, 15.0, 16.0, 16.0), // back
            Block.createCuboidShape(1.0, 15.0, 6.0, 15.0, 16.0, 15.0), // top
            Block.createCuboidShape(1.0, 12.0, 10.0, 15.0, 13.0, 11.0) // pole
        );
        SOUTH_BOTTOM_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 6.0, 16.0, 1.0, 16.0),   // bottom
            Block.createCuboidShape(1.0, 4.0, 7.0, 15.0, 5.0, 15.0),   // shelf
            Block.createCuboidShape(15.0, 1.0, 6.0, 16.0, 16.0, 16.0), // right
            Block.createCuboidShape(0.0, 1.0, 6.0, 1.0, 16.0, 16.0),   // left
            Block.createCuboidShape(1.0, 1.0, 15.0, 15.0, 16.0, 16.0)  // back
        );

        EAST_TOP_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(6.0, 0.0, 0.0, 16.0, 16.0, 1.0),   // left
            Block.createCuboidShape(6.0, 0.0, 15.0, 16.0, 16.0, 16.0), // right
            Block.createCuboidShape(15.0, 0.0, 1.0, 16.0, 16.0, 15.0), // back
            Block.createCuboidShape(6.0, 15.0, 1.0, 15.0, 16.0, 15.0), // top
            Block.createCuboidShape(10.0, 12.0, 1.0, 11.0, 13.0, 15.0) // pole
        );
        EAST_BOTTOM_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(6.0, 0.0, 0.0, 16.0, 1.0, 16.0),   // bottom
            Block.createCuboidShape(7.0, 4.0, 1.0, 15.0, 5.0, 15.0),   // shelf
            Block.createCuboidShape(6.0, 1.0, 15.0, 16.0, 16.0, 16.0), // right
            Block.createCuboidShape(6.0, 1.0, 0.0, 16.0, 16.0, 1.0),   // left
            Block.createCuboidShape(15.0, 1.0, 1.0, 16.0, 16.0, 15.0)  // back
        );

        WEST_TOP_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 15.0, 10.0, 16.0, 16.0), // left
            Block.createCuboidShape(0.0, 0.0, 0.0, 10.0, 16.0, 1.0),   // right
            Block.createCuboidShape(0.0, 0.0, 1.0, 1.0, 16.0, 15.0),   // back
            Block.createCuboidShape(1.0, 15.0, 1.0, 10.0, 16.0, 15.0), // top
            Block.createCuboidShape(5.0, 12.0, 1.0, 6.0, 13.0, 15.0)   // pole
        );
        WEST_BOTTOM_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.0, 0.0, 0.0, 10.0, 1.0, 16.0),   // bottom
            Block.createCuboidShape(1.0, 4.0, 1.0, 9.0, 5.0, 15.0),    // shelf
            Block.createCuboidShape(0.0, 1.0, 0.0, 10.0, 16.0, 1.0),   // right
            Block.createCuboidShape(0.0, 1.0, 15.0, 10.0, 16.0, 16.0), // left
            Block.createCuboidShape(0.0, 1.0, 1.0, 1.0, 16.0, 15.0)    // back
        );
    }

    public GenericArmoireBlock(ArmoireSettings settings) {
        super(settings);

        this.setDefaultState(
            this.stateManager
                .getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(HALF, DoubleBlockHalf.LOWER)
        );
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF);
    }

    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && player.isCreative()) {
            DoubleBlockHalf half = (DoubleBlockHalf) state.get(HALF);

            if (half == DoubleBlockHalf.UPPER) {
                BlockPos blockPos = pos.down();
                BlockState blockState = world.getBlockState(blockPos);

                if (blockState.isOf(state.getBlock()) && blockState.get(HALF) == DoubleBlockHalf.LOWER) {
                    BlockState blockState2 = blockState.contains(Properties.WATERLOGGED) && (Boolean) blockState.get(Properties.WATERLOGGED) ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState();
                    world.setBlockState(blockPos, blockState2, 35);
                    world.syncWorldEvent(player, 2001, blockPos, Block.getRawIdFromState(blockState));
                }
            }
        }

        super.onBreak(world, pos, state, player);
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        world.setBlockState(pos.up(), (BlockState) state.with(HALF, DoubleBlockHalf.UPPER), 3);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction lookDirection = ctx.getPlayerLookDirection();

        if (lookDirection == Direction.DOWN || lookDirection == Direction.UP) {
            return (BlockState) this.getDefaultState().with(FACING, Direction.NORTH);
        }

        return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerLookDirection());
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf) state.get(HALF);

        if (direction.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
            return neighborState.isOf(this) && neighborState.get(HALF) != doubleBlockHalf ? state.with(FACING, neighborState.get(FACING)) : Blocks.AIR.getDefaultState();
        } else {
            return doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canPlaceAt(world, pos)
                ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        return state.get(HALF) == DoubleBlockHalf.LOWER ? blockState.isSideSolidFullSquare(world, blockPos, Direction.UP) : blockState.isOf(this);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        DoubleBlockHalf half = state.get(HALF);

        return switch (direction) {
            case EAST -> half == DoubleBlockHalf.LOWER ? EAST_BOTTOM_SHAPE : EAST_TOP_SHAPE;
            case SOUTH -> half == DoubleBlockHalf.LOWER ? SOUTH_BOTTOM_SHAPE : SOUTH_TOP_SHAPE;
            case WEST -> half == DoubleBlockHalf.LOWER ? WEST_BOTTOM_SHAPE : WEST_TOP_SHAPE;
            default -> half == DoubleBlockHalf.LOWER ? NORTH_BOTTOM_SHAPE : NORTH_TOP_SHAPE;
        };
    }

    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.IGNORE;
    }

    @Override
    public Identifier getBlockID() {
        return ((MinekeaBlockSettings<?>) this.settings).getBlockId();
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        setupResources();
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.blockRespect(this, String.format("%s Armor-oire", ((MinekeaBlockSettings<?>) this.settings).getDefaultTranslation()));

        ArmoireSettings settings = (ArmoireSettings) this.settings;

        Map<String, Identifier> materials = settings.getMaterials();

        Identifier planks = materials.getOrDefault("planks", materials.get("main"));
        Identifier slab = materials.getOrDefault("slab", materials.get("main"));
        Identifier main = materials.getOrDefault("stripped_log", materials.get("main"));

        Identifier MAIN_MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier BOTTOM_MODEL_ID = new Identifier(MAIN_MODEL_ID + "_bottom");
        Identifier TOP_MODEL_ID = new Identifier(MAIN_MODEL_ID + "_top");

        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("BSB", "BCB", "###"),
                JKeys.keys()
                    .key("S", JIngredient.ingredient().item("minecraft:armor_stand"))
                    .key("C", JIngredient.ingredient().item("minecraft:chest"))
                    .key("B", JIngredient.ingredient().item(slab.toString()))
                    .key("#", JIngredient.ingredient().item(planks.toString())),
                JResult.result(getBlockID().toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.getLootTableID(getBlockID()), LootTable.doubleBlockLootTable(getBlockID()));

        JTextures textures = new JTextures().var("main", Texture.getBlockTextureID(main).toString());
        JModel bottomModel = JModel.model("minekea:block/furniture/armoires/bottom").textures(textures);
        JModel topModel = JModel.model("minekea:block/furniture/armoires/top").textures(textures);

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:item/furniture/armoire")
                .textures(new JTextures().var("main", String.format("minekea:item/furniture/armoires/%s", settings.getMainMaterial()))),
            ITEM_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(bottomModel, BOTTOM_MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(topModel, TOP_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("facing=north,half=lower", new JBlockModel(BOTTOM_MODEL_ID).y(180))
                    .put("facing=north,half=upper", new JBlockModel(TOP_MODEL_ID).y(180))
                    .put("facing=south,half=lower", new JBlockModel(BOTTOM_MODEL_ID))
                    .put("facing=south,half=upper", new JBlockModel(TOP_MODEL_ID))
                    .put("facing=east,half=lower", new JBlockModel(BOTTOM_MODEL_ID).y(270))
                    .put("facing=east,half=upper", new JBlockModel(TOP_MODEL_ID).y(270))
                    .put("facing=west,half=lower", new JBlockModel(BOTTOM_MODEL_ID).y(90))
                    .put("facing=west,half=upper", new JBlockModel(TOP_MODEL_ID).y(90))
            ),
            getBlockID()
        );
    }

    public static class ArmoireSettings extends MinekeaBlockSettings<ArmoireSettings> {
        public ArmoireSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sfurniture/armoires/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
