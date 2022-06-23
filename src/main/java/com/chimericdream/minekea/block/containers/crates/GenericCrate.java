package com.chimericdream.minekea.block.containers.crates;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.entities.blocks.containers.CrateBlockEntity;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
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

import java.util.Map;
import java.util.Objects;

public class GenericCrate extends BlockWithEntity implements MinekeaBlock {
    public static final Integer ROW_COUNT = 6;

    public static final EnumProperty<Axis> AXIS;
    public static final DirectionProperty FACING;
    public static final BooleanProperty OPEN;

    static {
        AXIS = Properties.AXIS;
        FACING = Properties.FACING;
        OPEN = Properties.OPEN;
    }

    public GenericCrate(CrateSettings settings) {
        super(settings);

        this.setDefaultState(this.stateManager.getDefaultState().with(AXIS, Direction.Axis.Y).with(FACING, Direction.NORTH).with(OPEN, false));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CrateBlockEntity(Crates.CRATE_BLOCK_ENTITY, pos, state);
    }

    @Override
    public Identifier getBlockID() {
        return ((CrateSettings) this.settings).getBlockId();
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
        return switch (rotation) {
            case COUNTERCLOCKWISE_90, CLOCKWISE_90 -> switch ((Axis) state.get(AXIS)) {
                case X -> (BlockState) state.with(AXIS, Axis.Z);
                case Z -> (BlockState) state.with(AXIS, Axis.X);
                default -> state;
            };
            default -> state;
        };
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

    public void setupResources() {
        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
        MinekeaResourcePack.addToolTag(settings.getTool(), getBlockID());
        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));

        Map<String, Identifier> materials = ((CrateSettings) this.settings).getMaterials();

        Identifier log = materials.getOrDefault("log", materials.get("main"));
        Identifier planks = materials.getOrDefault("planks", materials.get("main"));
        Identifier stripped_log = materials.getOrDefault("stripped_log", materials.get("main"));

        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier HORIZONTAL_MODEL_ID = new Identifier(MODEL_ID + "_horizontal");
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("#X#", "XXX", "#X#"),
                JKeys.keys()
                    .key("X", JIngredient.ingredient().item(planks.toString()))
                    .key("#", JIngredient.ingredient().item(log.toString())),
                JResult.result(getBlockID().toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        JTextures textures = new JTextures()
            .var("brace", Model.getBlockModelID(stripped_log).toString())
            .var("planks", Model.getBlockModelID(planks).toString());

        JModel mainModel = JModel.model("minekea:block/containers/crate").textures(textures);
        JModel horizontalModel = JModel.model("minekea:block/containers/crate_horizontal").textures(textures);

        MinekeaResourcePack.RESOURCE_PACK.addModel(mainModel, MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(horizontalModel, HORIZONTAL_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("axis=x", new JBlockModel(HORIZONTAL_MODEL_ID).x(90).y(90))
                    .put("axis=y", new JBlockModel(MODEL_ID))
                    .put("axis=z", new JBlockModel(HORIZONTAL_MODEL_ID).x(90))
            ),
            getBlockID()
        );
    }

    public static class CrateSettings extends MinekeaBlockSettings<CrateSettings> {
        public CrateSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Crate");
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%scontainers/crates/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
