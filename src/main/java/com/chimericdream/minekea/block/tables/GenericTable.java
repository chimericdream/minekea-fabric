package com.chimericdream.minekea.block.tables;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
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
import net.minecraft.world.WorldAccess;

import java.util.Map;

public class GenericTable extends Block implements MinekeaBlock {
    public static final BooleanProperty NORTH_CONNECTED;
    public static final BooleanProperty SOUTH_CONNECTED;
    public static final BooleanProperty EAST_CONNECTED;
    public static final BooleanProperty WEST_CONNECTED;

    private final Identifier BLOCK_ID;
    private final String modId;
    private final String woodType;
    private final Map<String, Identifier> materials;

    private static final VoxelShape TABLE_SURFACE_SHAPE;
    private static final VoxelShape[] LEG_SHAPES;

    static {
        TABLE_SURFACE_SHAPE = Block.createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0);
        LEG_SHAPES = new VoxelShape[]{
            Block.createCuboidShape(0.0, 0.0, 0.0, 2.0, 14.0, 2.0), // north-west
            Block.createCuboidShape(14.0, 0.0, 0.0, 16.0, 14.0, 2.0), // north-east
            Block.createCuboidShape(14.0, 0.0, 14.0, 16.0, 14.0, 16.0), // south-east
            Block.createCuboidShape(0.0, 0.0, 14.0, 2.0, 14.0, 16.0) // south-west
        };

        NORTH_CONNECTED = BooleanProperty.of("north_connected");
        SOUTH_CONNECTED = BooleanProperty.of("south_connected");
        EAST_CONNECTED = BooleanProperty.of("east_connected");
        WEST_CONNECTED = BooleanProperty.of("west_connected");
    }

    public GenericTable(String woodType, Map<String, Identifier> materials) {
        this(woodType, ModInfo.MOD_ID, materials);
    }

    public GenericTable(String woodType, String modId, Map<String, Identifier> materials) {
        super(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(3.0F, 4.0F));

        validateMaterials(materials);

        this.modId = modId;
        this.materials = materials;
        this.woodType = woodType;

        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("tables/%s%s_table", ModInfo.getModPrefix(modId), woodType));

        this.setDefaultState(
            this.stateManager
                .getDefaultState()
                .with(NORTH_CONNECTED, false)
                .with(SOUTH_CONNECTED, false)
                .with(EAST_CONNECTED, false)
                .with(WEST_CONNECTED, false)
        );
    }

    @Override
    public void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"planks", "log"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NORTH_CONNECTED, SOUTH_CONNECTED, EAST_CONNECTED, WEST_CONNECTED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState();
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        return direction.getAxis().isHorizontal()
            ? this.getUpdatedState(state, neighborState, direction)
            : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    private BlockState getUpdatedState(BlockState state, BlockState neighborState, Direction direction) {
        if (direction == Direction.NORTH) {
            if (neighborState.isOf(this)) {
                return state.with(NORTH_CONNECTED, true);
            } else {
                return state.with(NORTH_CONNECTED, false);
            }
        }

        if (direction == Direction.SOUTH) {
            if (neighborState.isOf(this)) {
                return state.with(SOUTH_CONNECTED, true);
            } else {
                return state.with(SOUTH_CONNECTED, false);
            }
        }

        if (direction == Direction.EAST) {
            if (neighborState.isOf(this)) {
                return state.with(EAST_CONNECTED, true);
            } else {
                return state.with(EAST_CONNECTED, false);
            }
        }

        if (direction == Direction.WEST) {
            if (neighborState.isOf(this)) {
                return state.with(WEST_CONNECTED, true);
            } else {
                return state.with(WEST_CONNECTED, false);
            }
        }

        return state;
    }

    @Override
    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        boolean north = state.get(NORTH_CONNECTED);
        boolean south = state.get(SOUTH_CONNECTED);
        boolean east = state.get(EAST_CONNECTED);
        boolean west = state.get(WEST_CONNECTED);

        if (!north && !south && !east && !west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES);
        }

        if (north && !south && !east && !west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[2], LEG_SHAPES[3]);
        }

        if (!north && south && !east && !west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[0], LEG_SHAPES[1]);
        }

        if (!north && !south && east && !west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[0], LEG_SHAPES[3]);
        }

        if (!north && !south && !east && west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[1], LEG_SHAPES[2]);
        }

        if (north && !south && east && !west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[3]);
        }

        if (north && !south && !east && west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[2]);
        }

        if (!north && south && east && !west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[0]);
        }

        if (!north && south && !east && west) {
            return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES[1]);
        }

        return VoxelShapes.union(TABLE_SURFACE_SHAPE);
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        FuelRegistry.INSTANCE.add(this, 300);
        FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);

        setupResources();
    }

    @Override
    public void setupResources() {
        Identifier MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/tables/%s%s_table", ModInfo.getModPrefix(modId), woodType));
        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/tables/%s%s_table", ModInfo.getModPrefix(modId), woodType));

        Identifier NORTH_CONN = new Identifier(ModInfo.MOD_ID, "block/tables/table_north_connected");
        Identifier SOUTH_CONN = new Identifier(ModInfo.MOD_ID, "block/tables/table_south_connected");
        Identifier EAST_CONN = new Identifier(ModInfo.MOD_ID, "block/tables/table_east_connected");
        Identifier WEST_CONN = new Identifier(ModInfo.MOD_ID, "block/tables/table_west_connected");

        Identifier NORTH_EAST_CONN = new Identifier(ModInfo.MOD_ID, "block/tables/table_north_east_connected");
        Identifier SOUTH_EAST_CONN = new Identifier(ModInfo.MOD_ID, "block/tables/table_south_east_connected");

        Identifier NORTH_WEST_CONN = new Identifier(ModInfo.MOD_ID, "block/tables/table_north_west_connected");
        Identifier SOUTH_WEST_CONN = new Identifier(ModInfo.MOD_ID, "block/tables/table_south_west_connected");

        Identifier ALL_CONN = new Identifier(ModInfo.MOD_ID, "block/tables/table_all_connected");

        Map<String, Identifier> OTHER_MODEL_IDS = Map.of(
            "north", new Identifier(ModInfo.MOD_ID, String.format("block/tables/%s%s_table_north", ModInfo.getModPrefix(modId), woodType)),
            "east", new Identifier(ModInfo.MOD_ID, String.format("block/tables/%s%s_table_east", ModInfo.getModPrefix(modId), woodType)),
            "south", new Identifier(ModInfo.MOD_ID, String.format("block/tables/%s%s_table_south", ModInfo.getModPrefix(modId), woodType)),
            "west", new Identifier(ModInfo.MOD_ID, String.format("block/tables/%s%s_table_west", ModInfo.getModPrefix(modId), woodType)),
            "north_east", new Identifier(ModInfo.MOD_ID, String.format("block/tables/%s%s_table_north_east", ModInfo.getModPrefix(modId), woodType)),
            "south_east", new Identifier(ModInfo.MOD_ID, String.format("block/tables/%s%s_table_south_east", ModInfo.getModPrefix(modId), woodType)),
            "north_west", new Identifier(ModInfo.MOD_ID, String.format("block/tables/%s%s_table_north_west", ModInfo.getModPrefix(modId), woodType)),
            "south_west", new Identifier(ModInfo.MOD_ID, String.format("block/tables/%s%s_table_south_west", ModInfo.getModPrefix(modId), woodType)),
            "all", new Identifier(ModInfo.MOD_ID, String.format("block/tables/%s%s_table_all", ModInfo.getModPrefix(modId), woodType))
        );

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("XXX", "# #", "# #"),
                JKeys.keys()
                    .key("X", JIngredient.ingredient().item(materials.get("planks").toString()))
                    .key("#", JIngredient.ingredient().item(materials.get("log").toString())),
                JResult.stackedResult(BLOCK_ID.toString(), 3)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        JTextures textures = new JTextures()
            .var("log", Texture.getBlockTextureID(materials.get("log")).toString())
            .var("planks", Texture.getBlockTextureID(materials.get("planks")).toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model("minekea:block/table").textures(textures), MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(NORTH_CONN).textures(textures), OTHER_MODEL_IDS.get("north"));
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(EAST_CONN).textures(textures), OTHER_MODEL_IDS.get("east"));
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(SOUTH_CONN).textures(textures), OTHER_MODEL_IDS.get("south"));
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(WEST_CONN).textures(textures), OTHER_MODEL_IDS.get("west"));
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(NORTH_EAST_CONN).textures(textures), OTHER_MODEL_IDS.get("north_east"));
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(SOUTH_EAST_CONN).textures(textures), OTHER_MODEL_IDS.get("south_east"));
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(NORTH_WEST_CONN).textures(textures), OTHER_MODEL_IDS.get("north_west"));
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(SOUTH_WEST_CONN).textures(textures), OTHER_MODEL_IDS.get("south_west"));
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(ALL_CONN).textures(textures), OTHER_MODEL_IDS.get("all"));

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("east_connected=false,north_connected=false,south_connected=false,west_connected=false", new JBlockModel(MODEL_ID))

                    .put("east_connected=false,north_connected=true,south_connected=false,west_connected=false", new JBlockModel(OTHER_MODEL_IDS.get("north")))
                    .put("east_connected=true,north_connected=false,south_connected=false,west_connected=false", new JBlockModel(OTHER_MODEL_IDS.get("east")))
                    .put("east_connected=false,north_connected=false,south_connected=true,west_connected=false", new JBlockModel(OTHER_MODEL_IDS.get("south")))
                    .put("east_connected=false,north_connected=false,south_connected=false,west_connected=true", new JBlockModel(OTHER_MODEL_IDS.get("west")))

                    .put("east_connected=true,north_connected=true,south_connected=false,west_connected=false", new JBlockModel(OTHER_MODEL_IDS.get("north_east")))
                    .put("east_connected=true,north_connected=false,south_connected=true,west_connected=false", new JBlockModel(OTHER_MODEL_IDS.get("south_east")))

                    .put("east_connected=false,north_connected=true,south_connected=false,west_connected=true", new JBlockModel(OTHER_MODEL_IDS.get("north_west")))
                    .put("east_connected=false,north_connected=false,south_connected=true,west_connected=true", new JBlockModel(OTHER_MODEL_IDS.get("south_west")))

                    .put("east_connected=true,north_connected=false,south_connected=false,west_connected=true", new JBlockModel(OTHER_MODEL_IDS.get("all")))
                    .put("east_connected=false,north_connected=true,south_connected=true,west_connected=false", new JBlockModel(OTHER_MODEL_IDS.get("all")))
                    .put("east_connected=true,north_connected=false,south_connected=true,west_connected=true", new JBlockModel(OTHER_MODEL_IDS.get("all")))
                    .put("east_connected=true,north_connected=true,south_connected=false,west_connected=true", new JBlockModel(OTHER_MODEL_IDS.get("all")))
                    .put("east_connected=true,north_connected=true,south_connected=true,west_connected=false", new JBlockModel(OTHER_MODEL_IDS.get("all")))
                    .put("east_connected=false,north_connected=true,south_connected=true,west_connected=true", new JBlockModel(OTHER_MODEL_IDS.get("all")))
                    .put("east_connected=true,north_connected=true,south_connected=true,west_connected=true", new JBlockModel(OTHER_MODEL_IDS.get("all")))

            ),
            BLOCK_ID
        );
    }
}
