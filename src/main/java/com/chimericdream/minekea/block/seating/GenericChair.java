package com.chimericdream.minekea.block.seating;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Texture;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class GenericChair extends Block {
    public static final DirectionProperty FACING;

    private final String modId;
    private final String woodType;
    private final Identifier BLOCK_ID;
    private final Map<String, Identifier> materials;

    private static final VoxelShape SEAT_SHAPE;
    private static final VoxelShape[] LEG_SHAPES;
    private static final Map<String, VoxelShape> SEAT_BACKS;

    static {
        FACING = DirectionProperty.of("facing", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);

        SEAT_SHAPE = Block.createCuboidShape(2.0, 8.0, 2.0, 14.0, 10.0, 14.0);
        LEG_SHAPES = new VoxelShape[]{
            Block.createCuboidShape(2.0, 0.0, 2.0, 4.0, 8.0, 4.0), // north-west
            Block.createCuboidShape(12.0, 0.0, 2.0, 14.0, 8.0, 4.0), // north-east
            Block.createCuboidShape(12.0, 0.0, 12.0, 14.0, 8.0, 14.0), // south-east
            Block.createCuboidShape(2.0, 0.0, 12.0, 4.0, 8.0, 14.0) // south-west
        };
        SEAT_BACKS = Map.of(
            "north", Block.createCuboidShape(2.0, 10.0, 2.0, 14.0, 22.0, 4.0),
            "south", Block.createCuboidShape(2.0, 10.0, 12.0, 14.0, 22.0, 14.0),
            "east", Block.createCuboidShape(12.0, 10.0, 2.0, 14.0, 22.0, 14.0),
            "west", Block.createCuboidShape(2.0, 10.0, 2.0, 4.0, 22.0, 14.0)
        );
    }

    public GenericChair(String woodType, Map<String, Identifier> materials) {
        this(woodType, ModInfo.MOD_ID, materials);
    }

    public GenericChair(String woodType, String modId, Map<String, Identifier> materials) {
        super(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).sounds(BlockSoundGroup.WOOD));

        validateMaterials(materials);

        this.modId = modId;
        this.woodType = woodType;
        this.materials = materials;

        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("chairs/%s%s_chair", ModInfo.getModPrefix(modId), woodType));

        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction lookDirection = ctx.getPlayerLookDirection();

        if (lookDirection == Direction.DOWN || lookDirection == Direction.UP) {
            return (BlockState) this.getDefaultState().with(FACING, Direction.NORTH);
        }

        return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerLookDirection());
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return super.getCollisionShape(state, world, pos, context);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }

        List<SeatEntity> seats = world.getEntitiesByClass(SeatEntity.class, new Box(pos), (Object) -> true);

        if (seats.size() == 0 && player.getStackInHand(hand).isEmpty()) {
            SeatEntity seat = Seats.SEAT_ENTITY.create(world);
            Vec3d seatPos = new Vec3d(hit.getBlockPos().getX() + 0.5d, hit.getBlockPos().getY() + 1.15d, hit.getBlockPos().getZ() + 0.5d);

            seat.updatePosition(seatPos.getX(), seatPos.getY(), seatPos.getZ());
            world.spawnEntity(seat);
            player.startRiding(seat);

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);

        if (facing == Direction.SOUTH) {
            return VoxelShapes.union(VoxelShapes.union(SEAT_SHAPE, LEG_SHAPES), SEAT_BACKS.get("north"));
        }

        if (facing == Direction.EAST) {
            return VoxelShapes.union(VoxelShapes.union(SEAT_SHAPE, LEG_SHAPES), SEAT_BACKS.get("west"));
        }

        if (facing == Direction.WEST) {
            return VoxelShapes.union(VoxelShapes.union(SEAT_SHAPE, LEG_SHAPES), SEAT_BACKS.get("east"));
        }

        return VoxelShapes.union(VoxelShapes.union(SEAT_SHAPE, LEG_SHAPES), SEAT_BACKS.get("south"));
    }

    protected void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"planks", "log"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        setupResources();
    }

    protected void setupResources() {
        String PLANK_MATERIAL = materials.get("planks").toString();
        String LOG_MATERIAL = materials.get("log").toString();

        Identifier MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/chairs/%s%s_chair", ModInfo.getModPrefix(modId), woodType));
        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/chairs/%s%s_chair", ModInfo.getModPrefix(modId), woodType));

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("P  ", "PP ", "LL "),
                JKeys.keys()
                    .key("P", JIngredient.ingredient().item(PLANK_MATERIAL))
                    .key("L", JIngredient.ingredient().item(LOG_MATERIAL)),
                JResult.result(BLOCK_ID.toString())
            )
        );
        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        JTextures textures = new JTextures()
            .var("log", Texture.getBlockTextureID(LOG_MATERIAL).toString())
            .var("planks", Texture.getBlockTextureID(PLANK_MATERIAL).toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/chair_variant").textures(textures),
            MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:item/chair_item").textures(textures),
            ITEM_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("facing=north", new JBlockModel(MODEL_ID).y(90))
                    .put("facing=south", new JBlockModel(MODEL_ID).y(270))
                    .put("facing=east", new JBlockModel(MODEL_ID).y(180))
                    .put("facing=west", new JBlockModel(MODEL_ID))
            ),
            BLOCK_ID
        );
    }
}
