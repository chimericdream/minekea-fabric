package com.chimericdream.minekea.block.containers.crates;

import com.chimericdream.minekea.entities.blocks.containers.CrateBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaTextures;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.data.client.Model;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.world.World;

import java.util.Optional;

public class GenericCrate extends BlockWithEntity implements MinekeaBlock {
    protected static final Model CRATE_MODEL = new Model(
        Optional.of(Identifier.of("minekea:block/containers/crate")),
        Optional.empty(),
        MinekeaTextures.BRACE,
        MinekeaTextures.MATERIAL
    );

    public static final MapCodec<GenericCrate> CODEC = createCodec(GenericCrate::new);

    public static final Integer ROW_COUNT = 6;

    public static final EnumProperty<Axis> AXIS;
    public static final DirectionProperty FACING;
    public static final BooleanProperty OPEN;

    public Identifier BLOCK_ID = null;

    static {
        AXIS = Properties.AXIS;
        FACING = Properties.FACING;
        OPEN = Properties.OPEN;
    }

    protected GenericCrate(Settings settings) {
        super(settings);

        this.setDefaultState(this.stateManager.getDefaultState().with(AXIS, Direction.Axis.Y).with(FACING, Direction.NORTH).with(OPEN, false));
    }

    @Override
    protected MapCodec<GenericCrate> getCodec() {
        return CODEC;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CrateBlockEntity(Crates.CRATE_BLOCK_ENTITY, pos, state);
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
            .register(itemGroup -> itemGroup.add(this.asItem()));
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, Crates.CRATE_BLOCK_ENTITY, CrateBlockEntity::tick);
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
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
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

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    protected void registerRecipe(RecipeExporter exporter, Item planks, TagKey<Item> log) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, this, 1)
            .pattern("#X#")
            .pattern("XXX")
            .pattern("#X#")
            .input('X', planks)
            .input('#', log)
            .criterion(FabricRecipeProvider.hasItem(planks),
                FabricRecipeProvider.conditionsFromItem(planks))
            .offerTo(exporter);
    }

    protected void registerRecipe(RecipeExporter exporter, Item planks, Item log) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, this, 1)
            .pattern("#X#")
            .pattern("XXX")
            .pattern("#X#")
            .input('X', planks)
            .input('#', log)
            .criterion(FabricRecipeProvider.hasItem(planks),
                FabricRecipeProvider.conditionsFromItem(planks))
            .criterion(FabricRecipeProvider.hasItem(log),
                FabricRecipeProvider.conditionsFromItem(log))
            .offerTo(exporter);
    }

//    public void setupResources() {
//        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
//        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
//        MinekeaTags.CRATES.add(getBlockID(), settings.isWooden());
//
//        Identifier log = settings.getMaterial("log");
//        Identifier planks = settings.getMaterial("planks");
//
//        Identifier plankTexture = settings.getBlockTexture("planks");
//        Identifier strippedLogTexture = settings.getBlockTexture("stripped_log");
//
//        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
//        Identifier HORIZONTAL_MODEL_ID = Identifier.of(MODEL_ID + "_horizontal");
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);
//
//        JTextures textures = new JTextures()
//            .var("brace", strippedLogTexture.toString())
//            .var("planks", plankTexture.toString());
//
//        JModel mainModel = JModel.model("minekea:block/containers/crate").textures(textures);
//        JModel horizontalModel = JModel.model("minekea:block/containers/crate_horizontal").textures(textures);
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(mainModel, MODEL_ID);
//        MinekeaResourcePack.RESOURCE_PACK.addModel(horizontalModel, HORIZONTAL_MODEL_ID);
//
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("axis=x", new JBlockModel(HORIZONTAL_MODEL_ID).x(90).y(90))
//                    .put("axis=y", new JBlockModel(MODEL_ID))
//                    .put("axis=z", new JBlockModel(HORIZONTAL_MODEL_ID).x(90))
//            ),
//            getBlockID()
//        );
//    }
//
//    public static class CrateSettings extends MinekeaBlockSettings<CrateSettings> {
//        public CrateSettings(DefaultSettings settings) {
//            super((DefaultSettings) settings.nonOpaque());
//        }
//
//        public String getNamePattern() {
//            return Objects.requireNonNullElse(namePatternOverride, "%s Crate");
//        }
//
//        @Override
//        public Identifier getBlockId() {
//            if (blockId == null) {
//                blockId = Identifier.of(ModInfo.MOD_ID, String.format("%scontainers/crates/%s", ModInfo.getModPrefix(modId), mainMaterial));
//            }
//
//            return blockId;
//        }
//    }
}
