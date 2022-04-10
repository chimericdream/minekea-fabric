package com.chimericdream.minekea.block.crates;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import net.devtech.arrp.json.models.*;
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
    private final Identifier[] materials;

    static {
        AXIS = Properties.AXIS;
        FACING = Properties.FACING;
        OPEN = Properties.OPEN;
    }

    GenericCrate(String woodType, Identifier[] materials) {
        this(woodType, materials, FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(3.0F, 4.0F));
    }

    GenericCrate(String woodType, Identifier[] materials, Settings settings) {
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
        Identifier MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/crates/%s_crate", woodType));
        Identifier HORIZONTAL_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/crates/%s_crate_horizontal", woodType));
        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/crates/%s_crate", woodType));

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("#X#", "XXX", "#X#"),
                JKeys.keys()
                    .key("X", JIngredient.ingredient().item(materials[0].toString()))
                    .key("#", JIngredient.ingredient().item(materials[1].toString())),
                JResult.result(BLOCK_ID.toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        JTextures textures = new JTextures()
            .var("0", materials[1].getNamespace() + ":block/stripped_" + materials[1].getPath())
            .var("1", materials[0].getNamespace() + ":block/" + materials[0].getPath())
            .var("particle", materials[1].getNamespace() + ":block/stripped_" + materials[1].getPath());

        JModel mainModel = JModel.model("minecraft:block/cube_column")
            .textures(textures)
            .element(
                new JElement()
                    .from(1, 1, 1)
                    .to(15, 15, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("1").uv(2, 2, 14, 14).cullface(Direction.NORTH))
                            .east(new JFace("1").uv(2, 2, 14, 14).cullface(Direction.EAST))
                            .south(new JFace("1").uv(2, 2, 14, 14).cullface(Direction.SOUTH))
                            .west(new JFace("1").uv(2, 2, 14, 14).cullface(Direction.WEST))
                            .up(new JFace("1").uv(2, 2, 14, 14).cullface(Direction.UP))
                            .down(new JFace("1").uv(2, 2, 14, 14).cullface(Direction.DOWN))
                    ),
                new JElement()
                    .from(0, 14, 15)
                    .to(16, 16, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 16, 2))
                            .east(new JFace("0").uv(0, 0, 1, 2))
                            .south(new JFace("0").uv(0, 0, 16, 2))
                            .west(new JFace("0").uv(0, 0, 1, 2))
                            .up(new JFace("0").uv(0, 0, 16, 1))
                            .down(new JFace("0").uv(0, 0, 16, 1))
                    ),
                new JElement()
                    .from(0, 14, 1)
                    .to(1, 16, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 2))
                            .east(new JFace("0").uv(0, 0, 14, 2))
                            .south(new JFace("0").uv(0, 0, 1, 2))
                            .west(new JFace("0").uv(0, 0, 14, 2))
                            .up(new JFace("0").uv(0, 0, 14, 1).rot90())
                            .down(new JFace("0").uv(0, 0, 14, 1).rot270())
                    ),
                new JElement()
                    .from(15, 14, 1)
                    .to(16, 16, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 2))
                            .east(new JFace("0").uv(0, 0, 14, 2))
                            .south(new JFace("0").uv(0, 0, 1, 2))
                            .west(new JFace("0").uv(0, 0, 14, 2))
                            .up(new JFace("0").uv(0, 0, 14, 1).rot90())
                            .down(new JFace("0").uv(0, 0, 14, 1).rot270())
                    ),
                new JElement()
                    .from(0, 14, 0)
                    .to(16, 16, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 16, 2))
                            .east(new JFace("0").uv(0, 0, 1, 2))
                            .south(new JFace("0").uv(0, 0, 16, 2))
                            .west(new JFace("0").uv(0, 0, 1, 2))
                            .up(new JFace("0").uv(0, 0, 16, 1))
                            .down(new JFace("0").uv(0, 0, 16, 1))
                    ),
                new JElement()
                    .from(1, 15, 1)
                    .to(15, 16, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 14, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 14, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 14, 1))
                            .down(new JFace("0").uv(0, 0, 14, 1))
                    ),
                new JElement()
                    .from(1, 15, 14)
                    .to(15, 16, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 14, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 14, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 14, 1))
                            .down(new JFace("0").uv(0, 0, 14, 1))
                    ),
                new JElement()
                    .from(1, 15, 2)
                    .to(2, 16, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 12, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 12, 1))
                            .up(new JFace("0").uv(0, 0, 1, 12))
                            .down(new JFace("0").uv(0, 0, 1, 12))
                    ),
                new JElement()
                    .from(14, 15, 2)
                    .to(15, 16, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 12, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 12, 1))
                            .up(new JFace("0").uv(0, 0, 1, 12))
                            .down(new JFace("0").uv(0, 0, 1, 12))
                    ),
                new JElement()
                    .from(15, 0, 1)
                    .to(16, 2, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 2))
                            .east(new JFace("0").uv(0, 0, 14, 2))
                            .south(new JFace("0").uv(0, 0, 1, 2))
                            .west(new JFace("0").uv(0, 0, 14, 2))
                            .up(new JFace("0").uv(0, 0, 14, 1).rot90())
                            .down(new JFace("0").uv(0, 0, 14, 1).rot270())
                    ),
                new JElement()
                    .from(0, 0, 1)
                    .to(1, 2, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 2))
                            .east(new JFace("0").uv(0, 0, 14, 2))
                            .south(new JFace("0").uv(0, 0, 1, 2))
                            .west(new JFace("0").uv(0, 0, 14, 2))
                            .up(new JFace("0").uv(0, 0, 14, 1).rot90())
                            .down(new JFace("0").uv(0, 0, 14, 1).rot270())
                    ),
                new JElement()
                    .from(0, 0, 0)
                    .to(16, 2, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 16, 2))
                            .east(new JFace("0").uv(0, 0, 1, 2))
                            .south(new JFace("0").uv(0, 0, 16, 2))
                            .west(new JFace("0").uv(0, 0, 1, 2))
                            .up(new JFace("0").uv(0, 0, 16, 1))
                            .down(new JFace("0").uv(0, 0, 16, 1))
                    ),
                new JElement()
                    .from(0, 0, 15)
                    .to(16, 2, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 16, 2))
                            .east(new JFace("0").uv(0, 0, 1, 2))
                            .south(new JFace("0").uv(0, 0, 16, 2))
                            .west(new JFace("0").uv(0, 0, 1, 2))
                            .up(new JFace("0").uv(0, 0, 16, 1))
                            .down(new JFace("0").uv(0, 0, 16, 1))
                    ),
                new JElement()
                    .from(14, 0, 2)
                    .to(15, 1, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 12, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 12, 1))
                            .up(new JFace("0").uv(0, 0, 1, 12))
                            .down(new JFace("0").uv(0, 0, 1, 12))
                    ),
                new JElement()
                    .from(1, 0, 2)
                    .to(2, 1, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 12, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 12, 1))
                            .up(new JFace("0").uv(0, 0, 1, 12))
                            .down(new JFace("0").uv(0, 0, 1, 12))
                    ),
                new JElement()
                    .from(1, 0, 1)
                    .to(15, 1, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 14, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 14, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 14, 1))
                            .down(new JFace("0").uv(0, 0, 14, 1))
                    ),
                new JElement()
                    .from(1, 0, 14)
                    .to(15, 1, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 14, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 14, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 14, 1))
                            .down(new JFace("0").uv(0, 0, 14, 1))
                    ),
                new JElement()
                    .from(0, 2, 0)
                    .to(1, 14, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12))
                            .east(new JFace("0").uv(0, 0, 2, 12))
                            .south(new JFace("0").uv(0, 0, 1, 12))
                            .west(new JFace("0").uv(0, 0, 2, 12))
                            .up(new JFace("0").uv(0, 0, 1, 2))
                            .down(new JFace("0").uv(0, 0, 1, 2))
                    ),
                new JElement()
                    .from(1, 2, 0)
                    .to(2, 14, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12))
                            .east(new JFace("0").uv(0, 0, 1, 12))
                            .south(new JFace("0").uv(0, 0, 1, 12))
                            .west(new JFace("0").uv(0, 0, 1, 12))
                            .up(new JFace("0").uv(0, 0, 1, 1))
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(0, 2, 14)
                    .to(1, 14, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12))
                            .east(new JFace("0").uv(0, 0, 2, 12))
                            .south(new JFace("0").uv(0, 0, 1, 12))
                            .west(new JFace("0").uv(0, 0, 2, 12))
                            .up(new JFace("0").uv(0, 0, 1, 2))
                            .down(new JFace("0").uv(0, 0, 1, 2))
                    ),
                new JElement()
                    .from(15, 2, 14)
                    .to(16, 14, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12))
                            .east(new JFace("0").uv(0, 0, 2, 12))
                            .south(new JFace("0").uv(0, 0, 1, 12))
                            .west(new JFace("0").uv(0, 0, 2, 12))
                            .up(new JFace("0").uv(0, 0, 1, 2))
                            .down(new JFace("0").uv(0, 0, 1, 2))
                    ),
                new JElement()
                    .from(15, 2, 0)
                    .to(16, 14, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12))
                            .east(new JFace("0").uv(0, 0, 2, 12))
                            .south(new JFace("0").uv(0, 0, 1, 12))
                            .west(new JFace("0").uv(0, 0, 2, 12))
                            .up(new JFace("0").uv(0, 0, 1, 2))
                            .down(new JFace("0").uv(0, 0, 1, 2))
                    ),
                new JElement()
                    .from(14, 2, 0)
                    .to(15, 14, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12))
                            .east(new JFace("0").uv(0, 0, 1, 12))
                            .south(new JFace("0").uv(0, 0, 1, 12))
                            .west(new JFace("0").uv(0, 0, 1, 12))
                            .up(new JFace("0").uv(0, 0, 1, 1))
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(14, 2, 15)
                    .to(15, 14, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12))
                            .east(new JFace("0").uv(0, 0, 1, 12))
                            .south(new JFace("0").uv(0, 0, 1, 12))
                            .west(new JFace("0").uv(0, 0, 1, 12))
                            .up(new JFace("0").uv(0, 0, 1, 1))
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(1, 2, 15)
                    .to(2, 14, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12))
                            .east(new JFace("0").uv(0, 0, 1, 12))
                            .south(new JFace("0").uv(0, 0, 1, 12))
                            .west(new JFace("0").uv(0, 0, 1, 12))
                            .up(new JFace("0").uv(0, 0, 1, 1))
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(12, 2, 0)
                    .to(14, 3, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 2, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 2, 1))
                            .down(new JFace("0").uv(0, 0, 2, 1))
                    ),
                new JElement()
                    .from(2, 13, 0)
                    .to(4, 14, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 2, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 2, 1))
                            .down(new JFace("0").uv(0, 0, 2, 1))
                    ),
                new JElement()
                    .from(11, 3, 0)
                    .to(14, 4, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 3, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1))
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(10, 4, 0)
                    .to(13, 5, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 3, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1))
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(9, 5, 0)
                    .to(12, 6, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 3, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1))
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(8, 6, 0)
                    .to(11, 7, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 3, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1))
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(7, 7, 0)
                    .to(10, 8, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 3, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1))
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(6, 8, 0)
                    .to(9, 9, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 3, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1))
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(5, 9, 0)
                    .to(8, 10, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 3, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1))
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(4, 10, 0)
                    .to(7, 11, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 3, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1))
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(3, 11, 0)
                    .to(6, 12, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 3, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1))
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(2, 12, 0)
                    .to(5, 13, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 3, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1))
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(3, 11, 0)
                    .to(6, 12, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1))
                            .south(new JFace("0").uv(0, 0, 3, 1))
                            .west(new JFace("0").uv(0, 0, 1, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1))
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(13, 12, 15)
                    .to(14, 14, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(2, 2, 15)
                    .to(3, 4, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(12, 11, 15)
                    .to(13, 14, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(11, 10, 15)
                    .to(12, 13, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(10, 9, 15)
                    .to(11, 12, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(9, 8, 15)
                    .to(10, 11, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(8, 7, 15)
                    .to(9, 10, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(7, 6, 15)
                    .to(8, 9, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(6, 5, 15)
                    .to(7, 8, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(5, 4, 15)
                    .to(6, 7, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(4, 3, 15)
                    .to(5, 6, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(3, 2, 15)
                    .to(4, 5, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(4, 3, 15)
                    .to(5, 6, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(15, 2, 2)
                    .to(16, 3, 4)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 2, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 2, 1))
                            .up(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 2, 1).rot90())
                    ),
                new JElement()
                    .from(15, 13, 12)
                    .to(16, 14, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 2, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 2, 1))
                            .up(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 2, 1).rot90())
                    ),
                new JElement()
                    .from(15, 3, 2)
                    .to(16, 4, 5)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 3, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot90())
                    ),
                new JElement()
                    .from(15, 4, 3)
                    .to(16, 5, 6)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 3, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot90())
                    ),
                new JElement()
                    .from(15, 5, 4)
                    .to(16, 6, 7)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 3, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot90())
                    ),
                new JElement()
                    .from(15, 6, 5)
                    .to(16, 7, 8)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 3, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot90())
                    ),
                new JElement()
                    .from(15, 7, 6)
                    .to(16, 8, 9)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 3, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot90())
                    ),
                new JElement()
                    .from(15, 8, 7)
                    .to(16, 9, 10)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 3, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot90())
                    ),
                new JElement()
                    .from(15, 9, 8)
                    .to(16, 10, 11)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 3, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot90())
                    ),
                new JElement()
                    .from(15, 10, 9)
                    .to(16, 11, 12)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 3, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot90())
                    ),
                new JElement()
                    .from(15, 11, 10)
                    .to(16, 12, 13)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 3, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot90())
                    ),
                new JElement()
                    .from(15, 12, 11)
                    .to(16, 13, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 3, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot90())
                    ),
                new JElement()
                    .from(15, 11, 10)
                    .to(16, 12, 13)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1))
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1))
                            .west(new JFace("0").uv(0, 0, 3, 1))
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot90())
                    ),
                new JElement()
                    .from(0, 12, 2)
                    .to(1, 14, 3)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .east(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 2, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(0, 2, 13)
                    .to(1, 4, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .east(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 2, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(0, 11, 3)
                    .to(1, 14, 4)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(0, 10, 4)
                    .to(1, 13, 5)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(0, 9, 5)
                    .to(1, 12, 6)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(0, 8, 6)
                    .to(1, 11, 7)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(0, 7, 7)
                    .to(1, 10, 8)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(0, 6, 8)
                    .to(1, 9, 9)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(0, 5, 9)
                    .to(1, 8, 10)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(0, 4, 10)
                    .to(1, 7, 11)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(0, 3, 11)
                    .to(1, 6, 12)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    ),
                new JElement()
                    .from(0, 2, 12)
                    .to(1, 5, 13)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 1, 1))
                    )

            );

        JModel horizontalModel = JModel.model("minecraft:block/cube_column")
            .textures(textures)
            .element(
                new JElement()
                    .from(1, 1, 1)
                    .to(15, 15, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("1").uv(2, 2, 14, 14).rot90().cullface(Direction.NORTH))
                            .east(new JFace("1").uv(2, 2, 14, 14).rot270().cullface(Direction.EAST))
                            .south(new JFace("1").uv(2, 2, 14, 14).rot270().cullface(Direction.SOUTH))
                            .west(new JFace("1").uv(2, 2, 14, 14).rot270().cullface(Direction.WEST))
                            .up(new JFace("1").uv(2, 2, 14, 14).rot270().cullface(Direction.UP))
                            .down(new JFace("1").uv(2, 2, 14, 14).rot270().cullface(Direction.DOWN))

                    ),
                new JElement()
                    .from(0, 0, 15)
                    .to(2, 16, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 16, 2).rot90())
                            .east(new JFace("0").uv(0, 0, 16, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 16, 2).rot270())
                            .west(new JFace("0").uv(0, 0, 16, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 2).rot270())
                    ),
                new JElement()
                    .from(0, 0, 1)
                    .to(2, 1, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 2).rot90())
                            .east(new JFace("0").uv(0, 0, 14, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .west(new JFace("0").uv(0, 0, 14, 1))
                            .up(new JFace("0").uv(0, 0, 14, 2).rot270())
                            .down(new JFace("0").uv(0, 0, 14, 2).rot270())
                    ),
                new JElement()
                    .from(0, 15, 1)
                    .to(2, 16, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 2).rot90())
                            .east(new JFace("0").uv(0, 0, 14, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .west(new JFace("0").uv(0, 0, 14, 1))
                            .up(new JFace("0").uv(0, 0, 14, 2).rot270())
                            .down(new JFace("0").uv(0, 0, 14, 2).rot270())
                    ),
                new JElement()
                    .from(0, 0, 0)
                    .to(2, 16, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 16, 2).rot90())
                            .east(new JFace("0").uv(0, 0, 16, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 16, 2).rot270())
                            .west(new JFace("0").uv(0, 0, 16, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 2).rot270())
                    ),
                new JElement()
                    .from(0, 1, 1)
                    .to(1, 15, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 14, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 14, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 14, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 14, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(0, 1, 14)
                    .to(1, 15, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 14, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 14, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 14, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 14, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(0, 1, 2)
                    .to(1, 2, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .up(new JFace("0").uv(0, 0, 12, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 12, 1).rot270())
                    ),
                new JElement()
                    .from(0, 14, 2)
                    .to(1, 15, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .up(new JFace("0").uv(0, 0, 12, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 12, 1).rot270())
                    ),
                new JElement()
                    .from(14, 15, 1)
                    .to(16, 16, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 2).rot90())
                            .east(new JFace("0").uv(0, 0, 14, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .west(new JFace("0").uv(0, 0, 14, 1))
                            .up(new JFace("0").uv(0, 0, 14, 2).rot270())
                            .down(new JFace("0").uv(0, 0, 14, 2).rot270())
                    ),
                new JElement()
                    .from(14, 0, 1)
                    .to(16, 1, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 2).rot90())
                            .east(new JFace("0").uv(0, 0, 14, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .west(new JFace("0").uv(0, 0, 14, 1))
                            .up(new JFace("0").uv(0, 0, 14, 2).rot270())
                            .down(new JFace("0").uv(0, 0, 14, 2).rot270())
                    ),
                new JElement()
                    .from(14, 0, 0)
                    .to(16, 16, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 16, 2).rot90())
                            .east(new JFace("0").uv(0, 0, 16, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 16, 2).rot270())
                            .west(new JFace("0").uv(0, 0, 16, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 2).rot270())
                    ),
                new JElement()
                    .from(14, 0, 15)
                    .to(16, 16, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 16, 2).rot90())
                            .east(new JFace("0").uv(0, 0, 16, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 16, 2).rot270())
                            .west(new JFace("0").uv(0, 0, 16, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 2).rot270())
                    ),
                new JElement()
                    .from(15, 14, 2)
                    .to(16, 15, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .up(new JFace("0").uv(0, 0, 12, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 12, 1).rot270())
                    ),
                new JElement()
                    .from(15, 1, 2)
                    .to(16, 2, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .up(new JFace("0").uv(0, 0, 12, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 12, 1).rot270())
                    ),
                new JElement()
                    .from(15, 1, 1)
                    .to(16, 15, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 14, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 14, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 14, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 14, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(15, 1, 14)
                    .to(16, 15, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 14, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 14, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 14, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 14, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(2, 0, 0)
                    .to(14, 1, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12).rot90())
                            .east(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .south(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .west(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .up(new JFace("0").uv(0, 0, 2, 12).rot270())
                            .down(new JFace("0").uv(0, 0, 2, 12).rot270())
                    ),
                new JElement()
                    .from(2, 1, 0)
                    .to(14, 2, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12).rot90())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 12).rot270())
                    ),
                new JElement()
                    .from(2, 0, 14)
                    .to(14, 1, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12).rot90())
                            .east(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .south(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .west(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .up(new JFace("0").uv(0, 0, 2, 12).rot270())
                            .down(new JFace("0").uv(0, 0, 2, 12).rot270())
                    ),
                new JElement()
                    .from(2, 15, 14)
                    .to(14, 16, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12).rot90())
                            .east(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .south(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .west(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .up(new JFace("0").uv(0, 0, 2, 12).rot270())
                            .down(new JFace("0").uv(0, 0, 2, 12).rot270())
                    ),
                new JElement()
                    .from(2, 15, 0)
                    .to(14, 16, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12).rot90())
                            .east(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .south(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .west(new JFace("0").uv(0, 0, 1, 2).rot270())
                            .up(new JFace("0").uv(0, 0, 2, 12).rot270())
                            .down(new JFace("0").uv(0, 0, 2, 12).rot270())
                    ),
                new JElement()
                    .from(2, 14, 0)
                    .to(14, 15, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12).rot90())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 12).rot270())
                    ),
                new JElement()
                    .from(2, 14, 15)
                    .to(14, 15, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12).rot90())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 12).rot270())
                    ),
                new JElement()
                    .from(2, 1, 15)
                    .to(14, 2, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 12).rot90())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 12).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 12).rot270())
                    ),
                new JElement()
                    .from(13, 12, 0)
                    .to(14, 14, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(2, 2, 0)
                    .to(3, 4, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(12, 11, 0)
                    .to(13, 14, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(11, 10, 0)
                    .to(12, 13, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(10, 9, 0)
                    .to(11, 12, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(9, 8, 0)
                    .to(10, 11, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(8, 7, 0)
                    .to(9, 10, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(7, 6, 0)
                    .to(8, 9, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(6, 5, 0)
                    .to(7, 8, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(5, 4, 0)
                    .to(6, 7, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(4, 3, 0)
                    .to(5, 6, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(3, 2, 0)
                    .to(4, 5, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(4, 3, 0)
                    .to(5, 6, 1)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .up(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 1, 1).rot270())
                    ),
                new JElement()
                    .from(2, 13, 15)
                    .to(4, 14, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1).rot180())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 2, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 2, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 2, 1).rot180())
                    ),
                new JElement()
                    .from(12, 2, 15)
                    .to(14, 3, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1).rot180())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 2, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 2, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 2, 1).rot180())
                    ),
                new JElement()
                    .from(2, 12, 15)
                    .to(5, 13, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot180())
                    ),
                new JElement()
                    .from(3, 11, 15)
                    .to(6, 12, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot180())
                    ),
                new JElement()
                    .from(4, 10, 15)
                    .to(7, 11, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot180())
                    ),
                new JElement()
                    .from(5, 9, 15)
                    .to(8, 10, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot180())
                    ),
                new JElement()
                    .from(6, 8, 15)
                    .to(9, 9, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot180())
                    ),
                new JElement()
                    .from(7, 7, 15)
                    .to(10, 8, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot180())
                    ),
                new JElement()
                    .from(8, 6, 15)
                    .to(11, 7, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot180())
                    ),
                new JElement()
                    .from(9, 5, 15)
                    .to(12, 6, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot180())
                    ),
                new JElement()
                    .from(10, 4, 15)
                    .to(13, 5, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot180())
                    ),
                new JElement()
                    .from(11, 3, 15)
                    .to(14, 4, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot180())
                    ),
                new JElement()
                    .from(10, 4, 15)
                    .to(13, 5, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .east(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot180())
                    ),
                new JElement()
                    .from(13, 15, 2)
                    .to(14, 16, 4)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 2, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 2, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 2, 1).rot270())
                    ),
                new JElement()
                    .from(2, 15, 12)
                    .to(3, 16, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 2, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 2, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 2, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 2, 1).rot270())
                    ),
                new JElement()
                    .from(12, 15, 2)
                    .to(13, 16, 5)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot270())
                    ),
                new JElement()
                    .from(11, 15, 3)
                    .to(12, 16, 6)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot270())
                    ),
                new JElement()
                    .from(10, 15, 4)
                    .to(11, 16, 7)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot270())
                    ),
                new JElement()
                    .from(9, 15, 5)
                    .to(10, 16, 8)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot270())
                    ),
                new JElement()
                    .from(8, 15, 6)
                    .to(9, 16, 9)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot270())
                    ),
                new JElement()
                    .from(7, 15, 7)
                    .to(8, 16, 10)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot270())
                    ),
                new JElement()
                    .from(6, 15, 8)
                    .to(7, 16, 11)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot270())
                    ),
                new JElement()
                    .from(5, 15, 9)
                    .to(6, 16, 12)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot270())
                    ),
                new JElement()
                    .from(4, 15, 10)
                    .to(5, 16, 13)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot270())
                    ),
                new JElement()
                    .from(3, 15, 11)
                    .to(4, 16, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot270())
                    ),
                new JElement()
                    .from(4, 15, 10)
                    .to(5, 16, 13)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .east(new JFace("0").uv(0, 0, 3, 1))
                            .south(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .west(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot270())
                            .down(new JFace("0").uv(0, 0, 3, 1).rot270())
                    ),
                new JElement()
                    .from(2, 0, 2)
                    .to(4, 1, 3)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 2, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 2, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 2, 1))
                    ),
                new JElement()
                    .from(12, 0, 13)
                    .to(14, 1, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 2, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 2, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 2, 1))
                    ),
                new JElement()
                    .from(2, 0, 3)
                    .to(5, 1, 4)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(3, 0, 4)
                    .to(6, 1, 5)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(4, 0, 5)
                    .to(7, 1, 6)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(5, 0, 6)
                    .to(8, 1, 7)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(6, 0, 7)
                    .to(9, 1, 8)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(7, 0, 8)
                    .to(10, 1, 9)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(8, 0, 9)
                    .to(11, 1, 10)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(9, 0, 10)
                    .to(12, 1, 11)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(10, 0, 11)
                    .to(13, 1, 12)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    ),
                new JElement()
                    .from(11, 0, 12)
                    .to(14, 1, 13)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 3, 1))
                            .east(new JFace("0").uv(0, 0, 1, 1).rot270())
                            .south(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .west(new JFace("0").uv(0, 0, 1, 1).rot90())
                            .up(new JFace("0").uv(0, 0, 3, 1).rot180())
                            .down(new JFace("0").uv(0, 0, 3, 1))
                    )
            );

        MinekeaResourcePack.RESOURCE_PACK.addModel(mainModel, MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(horizontalModel, HORIZONTAL_MODEL_ID);
    }
}
