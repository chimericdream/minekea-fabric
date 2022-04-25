package com.chimericdream.minekea.block.shelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.util.ImplementedInventory;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Map;

public class GenericShelf extends BlockWithEntity implements MinekeaBlock {
    public static final DirectionProperty WALL_SIDE;

    protected final Identifier BLOCK_ID;
    protected final String modId;
    protected final String woodType;
    protected final Map<String, Identifier> materials;

    static {
        WALL_SIDE = DirectionProperty.of("wall_side", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
    }

    protected GenericShelf(String woodType, String modId, Map<String, Identifier> materials, Identifier blockId) {
        super(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque());

        validateMaterials(materials);

        BLOCK_ID = blockId;

        this.modId = modId;
        this.woodType = woodType;
        this.materials = materials;

        this.setDefaultState(this.stateManager.getDefaultState().with(WALL_SIDE, Direction.NORTH));
    }

    public GenericShelf(String woodType, Map<String, Identifier> materials) {
        this(woodType, ModInfo.MOD_ID, materials);
    }

    public GenericShelf(String woodType, String modId, Map<String, Identifier> materials) {
        super(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque());

        validateMaterials(materials);

        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("shelves/%s%s_supported_shelf", ModInfo.getModPrefix(modId), woodType));

        this.modId = modId;
        this.woodType = woodType;
        this.materials = materials;

        this.setDefaultState(this.stateManager.getDefaultState().with(WALL_SIDE, Direction.NORTH));
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState) state.with(WALL_SIDE, rotation.rotate((Direction) state.get(WALL_SIDE)));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation((Direction) state.get(WALL_SIDE)));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WALL_SIDE);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction lookDirection = ctx.getPlayerLookDirection();

        if (lookDirection == Direction.DOWN || lookDirection == Direction.UP) {
            return (BlockState) this.getDefaultState().with(WALL_SIDE, Direction.NORTH);
        }

        return (BlockState) this.getDefaultState().with(WALL_SIDE, lookDirection.getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction wall = state.get(WALL_SIDE);

        switch (wall) {
            case EAST:
                return VoxelShapes.union(Block.createCuboidShape(0.0, 7.0, 0.0, 7.0, 9.0, 16.0),
                    Block.createCuboidShape(0.0, 4.0, 0.0, 2.0, 7.0, 1.0),
                    Block.createCuboidShape(2.0, 5.0, 15.0, 4.0, 7.0, 16.0),
                    Block.createCuboidShape(2.0, 5.0, 0.0, 4.0, 7.0, 1.0),
                    Block.createCuboidShape(4.0, 6.0, 0.0, 6.0, 7.0, 1.0),
                    Block.createCuboidShape(4.0, 6.0, 15.0, 6.0, 7.0, 16.0),
                    Block.createCuboidShape(0.0, 4.0, 15.0, 2.0, 7.0, 16.0)
                );

            case SOUTH:
                return VoxelShapes.union(Block.createCuboidShape(0.0, 7.0, 0.0, 16.0, 9.0, 7.0),
                    Block.createCuboidShape(15.0, 4.0, 0.0, 16.0, 7.0, 2.0),
                    Block.createCuboidShape(0.0, 5.0, 2.0, 1.0, 7.0, 4.0),
                    Block.createCuboidShape(15.0, 5.0, 2.0, 16.0, 7.0, 4.0),
                    Block.createCuboidShape(15.0, 6.0, 4.0, 16.0, 7.0, 6.0),
                    Block.createCuboidShape(0.0, 6.0, 4.0, 1.0, 7.0, 6.0),
                    Block.createCuboidShape(0.0, 4.0, 0.0, 1.0, 7.0, 2.0)
                );

            case WEST:
                return VoxelShapes.union(
                    Block.createCuboidShape(9.0, 7.0, 0.0, 16.0, 9.0, 16.0),
                    Block.createCuboidShape(14.0, 4.0, 15.0, 16.0, 7.0, 16.0),
                    Block.createCuboidShape(12.0, 5.0, 0.0, 14.0, 7.0, 1.0),
                    Block.createCuboidShape(12.0, 5.0, 15.0, 14.0, 7.0, 16.0),
                    Block.createCuboidShape(10.0, 6.0, 15.0, 12.0, 7.0, 16.0),
                    Block.createCuboidShape(10.0, 6.0, 0.0, 12.0, 7.0, 1.0),
                    Block.createCuboidShape(14.0, 4.0, 0.0, 16.0, 7.0, 1.0)
                );

            case NORTH:
            default:
                return VoxelShapes.union(
                    Block.createCuboidShape(0.0, 7.0, 9.0, 16.0, 9.0, 16.0),
                    Block.createCuboidShape(0.0, 4.0, 14.0, 1.0, 7.0, 16.0),
                    Block.createCuboidShape(15.0, 5.0, 12.0, 16.0, 7.0, 14.0),
                    Block.createCuboidShape(0.0, 5.0, 12.0, 1.0, 7.0, 14.0),
                    Block.createCuboidShape(0.0, 6.0, 10.0, 1.0, 7.0, 12.0),
                    Block.createCuboidShape(15.0, 6.0, 10.0, 16.0, 7.0, 12.0),
                    Block.createCuboidShape(15.0, 4.0, 14.0, 16.0, 7.0, 16.0)
                );
        }
    }

    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    public void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"slab", "log"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ShelfBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    private int getTargetSlot(BlockState state, BlockHitResult hit) {
        Direction facing = state.get(WALL_SIDE);
        Vec3d localCoords = hit.getPos().subtract(Vec3d.of(hit.getBlockPos()));

        switch (facing) {
            case NORTH -> {
                double x = localCoords.getX();
                if (x > 0.75) return 0;
                if (x > 0.50) return 1;
                if (x > 0.25) return 2;

                return 3;
            }
            case EAST -> {
                double z = localCoords.getZ();
                if (z > 0.75) return 0;
                if (z > 0.50) return 1;
                if (z > 0.25) return 2;

                return 3;
            }
            case SOUTH -> {
                double x = localCoords.getX();
                if (x > 0.75) return 3;
                if (x > 0.50) return 2;
                if (x > 0.25) return 1;

                return 0;
            }
            case WEST -> {
                double z = localCoords.getZ();
                if (z > 0.75) return 3;
                if (z > 0.50) return 2;
                if (z > 0.25) return 1;

                return 0;
            }
        }

        return -1;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ImplementedInventory entity = (ImplementedInventory) world.getBlockEntity(pos);

        // Theoretically, this shouldn't be possible
        if (entity == null) {
            return ActionResult.FAIL;
        }

        int slot = getTargetSlot(state, hit);
        if (slot == -1) {
            throw new IllegalStateException("It should not be possible to target a slot outside of the block");
        }

        if (!player.getMainHandStack().isEmpty()) {
            // Try to insert the item in the player's hand into the targeted slot on the shelf
            player.setStackInHand(hand, entity.tryInsert(slot, player.getMainHandStack()));
        } else if (player.isSneaking() && player.getMainHandStack().isEmpty()) {
            if (!entity.getStack(slot).isEmpty()) {
                ItemScatterer.spawn(
                    world,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    entity.removeStack(slot)
                );
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ShelfBlockEntity) {
                ItemScatterer.spawn(world, pos, (ShelfBlockEntity) blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        FuelRegistry.INSTANCE.add(this, 300);
        FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);

        setupResources();
    }

    public void setupResources() {
        Identifier log = materials.get("log");
        Identifier planks = materials.get("planks");
        Identifier slab = materials.get("slab");

        Identifier MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/shelves/%s%s_supported_shelf", ModInfo.getModPrefix(modId), woodType));
        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/shelves/%s%s_supported_shelf", ModInfo.getModPrefix(modId), woodType));

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("XXX", "# #", "X X"),
                JKeys.keys()
                    .key("X", JIngredient.ingredient().item(slab.toString()))
                    .key("#", JIngredient.ingredient().item("minecraft:iron_nugget")),
                JResult.stackedResult(BLOCK_ID.toString(), 3)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel
                .model(ModInfo.MOD_ID + ":block/supported_shelf")
                .textures(
                    new JTextures()
                        .var("planks", Texture.getBlockTextureID(planks).toString())
                        .var("log", Texture.getBlockTextureID(log).toString())
                ),
            MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("wall_side=north", new JBlockModel(MODEL_ID))
                    .put("wall_side=east", new JBlockModel(MODEL_ID).y(90))
                    .put("wall_side=south", new JBlockModel(MODEL_ID).y(180))
                    .put("wall_side=west", new JBlockModel(MODEL_ID).y(270))
            ),
            BLOCK_ID
        );
    }
}
