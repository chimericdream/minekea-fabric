package com.chimericdream.minekea.block.building.beams;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.blockstate.JWhen;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
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
    protected static final VoxelShape CORE_SHAPE = Block.createCuboidShape(5.0, 5.0, 5.0, 11.0, 11.0, 11.0);
    protected static final VoxelShape CONNECTED_NORTH_SHAPE = Block.createCuboidShape(5.0, 5.0, 0.0, 11.0, 11.0, 5.0);
    protected static final VoxelShape CONNECTED_EAST_SHAPE = Block.createCuboidShape(11.0, 5.0, 5.0, 16.0, 11.0, 11.0);
    protected static final VoxelShape CONNECTED_SOUTH_SHAPE = Block.createCuboidShape(5.0, 5.0, 11.0, 11.0, 11.0, 16.0);
    protected static final VoxelShape CONNECTED_WEST_SHAPE = Block.createCuboidShape(0.0, 5.0, 5.0, 5.0, 11.0, 11.0);
    protected static final VoxelShape CONNECTED_UP_SHAPE = Block.createCuboidShape(5.0, 11.0, 5.0, 11.0, 16.0, 11.0);
    protected static final VoxelShape CONNECTED_DOWN_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 5.0, 11.0);

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

    public GenericBeamBlock(BeamSettings settings) {
        super(settings);

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

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction hitSide = ctx.getSide();
        BlockState blockState = this.getDefaultState();

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

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public Identifier getBlockID() {
        return ((BeamSettings) this.settings).getBlockId();
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
        MinekeaResourcePack.EN_US.blockRespect(this, String.format("%s Beam", ((MinekeaBlockSettings<?>) this.settings).getDefaultTranslation()));

        Map<String, Identifier> materials = ((BeamSettings) this.settings).getMaterials();

        Identifier end = materials.getOrDefault("end", materials.get("main"));
        Identifier side = materials.get("main");
        Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

        Identifier BASE_MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        Map<String, Identifier> MODEL_IDS = new HashMap<>();
        MODEL_IDS.put("core", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_core"));
        MODEL_IDS.put("connected_north", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_connected_north"));
        MODEL_IDS.put("connected_east", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_connected_east"));
        MODEL_IDS.put("connected_south", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_connected_south"));
        MODEL_IDS.put("connected_west", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_connected_west"));
        MODEL_IDS.put("connected_up", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_connected_up"));
        MODEL_IDS.put("connected_down", new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_connected_down"));

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("X X", "X X", "X X"),
                JKeys.keys().key("X", JIngredient.ingredient().item(ingredient.toString())),
                JResult.stackedResult(getBlockID().toString(), 6)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        JTextures textures = new JTextures()
            .var("end", Texture.getBlockTextureID(end).toString())
            .var("side", Texture.getBlockTextureID(side).toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":item/building/beam").textures(textures),
            ITEM_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/building/beams/core").textures(textures),
            MODEL_IDS.get("core")
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/building/beams/connected_north").textures(textures),
            MODEL_IDS.get("connected_north")
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/building/beams/connected_east").textures(textures),
            MODEL_IDS.get("connected_east")
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/building/beams/connected_south").textures(textures),
            MODEL_IDS.get("connected_south")
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/building/beams/connected_west").textures(textures),
            MODEL_IDS.get("connected_west")
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/building/beams/connected_up").textures(textures),
            MODEL_IDS.get("connected_up")
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/building/beams/connected_down").textures(textures),
            MODEL_IDS.get("connected_down")
        );

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
            getBlockID()
        );
    }

    public static class BeamSettings extends MinekeaBlockSettings<BeamSettings> {
        public BeamSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sbuilding/beams/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
