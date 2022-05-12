package com.chimericdream.minekea.block.beams;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.blockstate.JWhen;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.HashMap;
import java.util.Map;

public class GenericBeamBlock extends Block implements MinekeaBlock {
    private final Identifier BLOCK_ID;
    private final String modId;

    protected final String mainMaterial;
    protected final Map<String, Identifier> materials;

    protected static final VoxelShape CORE_SHAPE = Block.createCuboidShape(5.0, 5.0, 5.0, 11.0, 11.0, 11.0);
    protected static final VoxelShape CONNECTED_NORTH_SHAPE = Block.createCuboidShape(5.0, 5.0, 0.0, 11.0, 11.0, 5.0);
    protected static final VoxelShape CONNECTED_EAST_SHAPE = Block.createCuboidShape(11.0, 5.0, 5.0, 16.0, 11.0, 11.0);
    protected static final VoxelShape CONNECTED_SOUTH_SHAPE = Block.createCuboidShape(5.0, 5.0, 11.0, 11.0, 11.0, 16.0);
    protected static final VoxelShape CONNECTED_WEST_SHAPE = Block.createCuboidShape(0.0, 5.0, 5.0, 5.0, 11.0, 11.0);
    protected static final VoxelShape CONNECTED_UP_SHAPE = Block.createCuboidShape(5.0, 11.0, 5.0, 11.0, 16.0, 11.0);
    protected static final VoxelShape CONNECTED_DOWN_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 5.0, 11.0);

    protected static final Settings DEFAULT_SETTINGS = FabricBlockSettings.copyOf(Blocks.COBBLESTONE_WALL);

    public static final BooleanProperty CONNECTED_NORTH;
    public static final BooleanProperty CONNECTED_EAST;
    public static final BooleanProperty CONNECTED_SOUTH;
    public static final BooleanProperty CONNECTED_WEST;
    public static final BooleanProperty CONNECTED_UP;
    public static final BooleanProperty CONNECTED_DOWN;

    static {
        CONNECTED_NORTH = BooleanProperty.of("connected_north");
        CONNECTED_EAST = BooleanProperty.of("connected_east");
        CONNECTED_SOUTH = BooleanProperty.of("connected_south");
        CONNECTED_WEST = BooleanProperty.of("connected_west");
        CONNECTED_UP = BooleanProperty.of("connected_up");
        CONNECTED_DOWN = BooleanProperty.of("connected_down");
    }

    public GenericBeamBlock(String mainMaterial, Map<String, Identifier> materials) {
        this(mainMaterial, ModInfo.MOD_ID, materials);
    }

    public GenericBeamBlock(String mainMaterial, String modId, Map<String, Identifier> materials) {
        this(
            mainMaterial,
            modId,
            materials,
            DEFAULT_SETTINGS
        );
    }

    public GenericBeamBlock(String mainMaterial, String modId, Map<String, Identifier> materials, Settings settings) {
        this(
            mainMaterial,
            modId,
            materials,
            getDefaultBlockId(modId, mainMaterial),
            settings
        );
    }

    protected GenericBeamBlock(String mainMaterial, String modId, Map<String, Identifier> materials, Identifier blockId) {
        this(
            mainMaterial,
            modId,
            materials,
            blockId,
            DEFAULT_SETTINGS
        );
    }

    protected GenericBeamBlock(String mainMaterial, String modId, Map<String, Identifier> materials, Identifier blockId, Settings settings) {
        super(settings.nonOpaque());

        validateMaterials(materials);

        BLOCK_ID = blockId;

        this.modId = modId;
        this.mainMaterial = mainMaterial;
        this.materials = materials;

        this.setDefaultState(
            this.stateManager
                .getDefaultState()
                .with(CONNECTED_NORTH, false)
                .with(CONNECTED_EAST, false)
                .with(CONNECTED_SOUTH, false)
                .with(CONNECTED_WEST, false)
                .with(CONNECTED_UP, false)
                .with(CONNECTED_DOWN, false)
        );
    }

    protected static Identifier getDefaultBlockId(String modId, String mainMaterial) {
        return new Identifier(ModInfo.MOD_ID, String.format("beams/%s%s_beam", ModInfo.getModPrefix(modId), mainMaterial));
    }

    private boolean canConnect(BlockState state) {
        return state.isOf(this);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockView blockView = ctx.getWorld();
        BlockPos blockPos = ctx.getBlockPos();

        // Neighbors
        BlockPos north = blockPos.north();
        BlockPos east = blockPos.east();
        BlockPos south = blockPos.south();
        BlockPos west = blockPos.west();
        BlockPos up = blockPos.up();
        BlockPos down = blockPos.down();

        // Neighbor blockstates
        BlockState northState = blockView.getBlockState(north);
        BlockState eastState = blockView.getBlockState(east);
        BlockState southState = blockView.getBlockState(south);
        BlockState westState = blockView.getBlockState(west);
        BlockState upState = blockView.getBlockState(up);
        BlockState downState = blockView.getBlockState(down);

        Direction hitSide = ctx.getSide();

        BlockState blockState = this.getDefaultState();

//        BlockState blockState = this.getDefaultState()
//            .with(CONNECTED_NORTH, canConnect(northState))
//            .with(CONNECTED_EAST, canConnect(eastState))
//            .with(CONNECTED_SOUTH, canConnect(southState))
//            .with(CONNECTED_WEST, canConnect(westState))
//            .with(CONNECTED_UP, canConnect(upState))
//            .with(CONNECTED_DOWN, canConnect(downState));

        blockState = switch (hitSide) {
            case NORTH, SOUTH -> blockState.with(CONNECTED_NORTH, true).with(CONNECTED_SOUTH, true);
            case EAST, WEST -> blockState.with(CONNECTED_EAST, true).with(CONNECTED_WEST, true);
            case UP, DOWN -> blockState.with(CONNECTED_UP, true).with(CONNECTED_DOWN, true);
        };

        return blockState;
    }

    public static BooleanProperty getConnectionProperty(Direction direction) {
        return switch (direction) {
            case NORTH -> CONNECTED_NORTH;
            case EAST -> CONNECTED_EAST;
            case SOUTH -> CONNECTED_SOUTH;
            case WEST -> CONNECTED_WEST;
            case UP -> CONNECTED_UP;
            case DOWN -> CONNECTED_DOWN;
        };
    }

//    @Override
//    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
//        return state.with(getConnectionProperty(direction), neighborState.isOf(this));
//    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(
            CONNECTED_NORTH,
            CONNECTED_EAST,
            CONNECTED_SOUTH,
            CONNECTED_WEST,
            CONNECTED_UP,
            CONNECTED_DOWN
        );
    }

    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.NORMAL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        boolean connectedNorth = state.get(CONNECTED_NORTH);
        boolean connectedEast = state.get(CONNECTED_EAST);
        boolean connectedSouth = state.get(CONNECTED_SOUTH);
        boolean connectedWest = state.get(CONNECTED_WEST);
        boolean connectedUp = state.get(CONNECTED_UP);
        boolean connectedDown = state.get(CONNECTED_DOWN);

        VoxelShape outline = CORE_SHAPE;

        if (connectedNorth) {
            outline = VoxelShapes.union(outline, CONNECTED_NORTH_SHAPE);
        }
        if (connectedEast) {
            outline = VoxelShapes.union(outline, CONNECTED_EAST_SHAPE);
        }
        if (connectedSouth) {
            outline = VoxelShapes.union(outline, CONNECTED_SOUTH_SHAPE);
        }
        if (connectedWest) {
            outline = VoxelShapes.union(outline, CONNECTED_WEST_SHAPE);
        }
        if (connectedUp) {
            outline = VoxelShapes.union(outline, CONNECTED_UP_SHAPE);
        }
        if (connectedDown) {
            outline = VoxelShapes.union(outline, CONNECTED_DOWN_SHAPE);
        }

        return outline;
    }

//    @Override
//    public BlockState rotate(BlockState state, BlockRotation rotation) {
//        return (BlockState) state.with(FACING, rotation.rotate((Direction) state.get(FACING)));
//    }
//
//    @Override
//    public BlockState mirror(BlockState state, BlockMirror mirror) {
//        return (BlockState) state.with(FACING, mirror.apply((Direction) state.get(FACING)));
//    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        setupResources();
    }

    @Override
    public void setupResources() {
        Identifier end = materials.getOrDefault("end", materials.get("main"));
        Identifier side = materials.get("main");
        Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

        Identifier BASE_MODEL_ID = Model.getBlockModelID(BLOCK_ID);
        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);

        Map<String, Identifier> MODEL_IDS = new HashMap<>();
        MODEL_IDS.put("core", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_core"));
        MODEL_IDS.put("connected_north", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_connected_north"));
        MODEL_IDS.put("connected_east", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_connected_east"));
        MODEL_IDS.put("connected_south", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_connected_south"));
        MODEL_IDS.put("connected_west", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_connected_west"));
        MODEL_IDS.put("connected_up", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_connected_up"));
        MODEL_IDS.put("connected_down", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_connected_down"));

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("X X", "X X", "X X"),
                JKeys.keys().key("X", JIngredient.ingredient().item(ingredient.toString())),
                JResult.stackedResult(BLOCK_ID.toString(), 6)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        JTextures textures = new JTextures()
            .var("end", Texture.getBlockTextureID(end).toString())
            .var("side", Texture.getBlockTextureID(side).toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":item/beams/generic_beam").textures(textures),
            ITEM_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/beams/beam_core").textures(textures),
            MODEL_IDS.get("core")
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/beams/beam_connected_north").textures(textures),
            MODEL_IDS.get("connected_north")
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/beams/beam_connected_east").textures(textures),
            MODEL_IDS.get("connected_east")
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/beams/beam_connected_south").textures(textures),
            MODEL_IDS.get("connected_south")
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/beams/beam_connected_west").textures(textures),
            MODEL_IDS.get("connected_west")
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/beams/beam_connected_up").textures(textures),
            MODEL_IDS.get("connected_up")
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/beams/beam_connected_down").textures(textures),
            MODEL_IDS.get("connected_down")
        );

//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("facing=down", new JBlockModel(MODEL_ID).x(180))
//                    .put("facing=east", new JBlockModel(MODEL_ID).x(90).y(90))
//                    .put("facing=north", new JBlockModel(MODEL_ID).x(90))
//                    .put("facing=south", new JBlockModel(MODEL_ID).x(90).y(180))
//                    .put("facing=up", new JBlockModel(MODEL_ID))
//                    .put("facing=west", new JBlockModel(MODEL_ID).x(90).y(270))
//            ),
//            BLOCK_ID
//        );

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.multipart(new JBlockModel(MODEL_IDS.get("core"))),
                JState.multipart(new JBlockModel(MODEL_IDS.get("connected_north")).uvlock())
                    .when(new JWhen().add("connected_north", "true")),
                JState.multipart(new JBlockModel(MODEL_IDS.get("connected_east")).uvlock())
                    .when(new JWhen().add("connected_east", "true")),
                JState.multipart(new JBlockModel(MODEL_IDS.get("connected_south")).uvlock())
                    .when(new JWhen().add("connected_south", "true")),
                JState.multipart(new JBlockModel(MODEL_IDS.get("connected_west")).uvlock())
                    .when(new JWhen().add("connected_west", "true")),
                JState.multipart(new JBlockModel(MODEL_IDS.get("connected_up")).uvlock())
                    .when(new JWhen().add("connected_up", "true")),
                JState.multipart(new JBlockModel(MODEL_IDS.get("connected_down")).uvlock())
                    .when(new JWhen().add("connected_down", "true"))
            ),
            BLOCK_ID
        );
    }

    @Override
    public void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"main"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
    }
}
