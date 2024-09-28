package com.chimericdream.minekea.block.containers.crates;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.entities.blocks.containers.CrateBlockEntity;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaTextures;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
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
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class GenericCrate extends BlockWithEntity implements MinekeaBlock {
    protected static final Model CRATE_MODEL = new Model(
        Optional.of(Identifier.of("minekea:block/containers/crate")),
        Optional.empty(),
        MinekeaTextures.BRACE,
        MinekeaTextures.MATERIAL
    );
    protected static final Model HALF_DOUBLE_CRATE_MODEL = new Model(
        Optional.of(Identifier.of("minekea:block/containers/double_crate_half")),
        Optional.empty(),
        MinekeaTextures.BRACE,
        MinekeaTextures.MATERIAL
    );

    public static final MapCodec<GenericCrate> CODEC = createCodec(GenericCrate::new);

    public static final Integer ROW_COUNT = 6;

    public static final EnumProperty<Axis> AXIS;
    public static final BooleanProperty OPEN;

    public static final BooleanProperty CONNECTED_NORTH;
    public static final BooleanProperty CONNECTED_SOUTH;
    public static final BooleanProperty CONNECTED_EAST;
    public static final BooleanProperty CONNECTED_WEST;

    protected final Identifier BLOCK_ID;
    protected final String material;
    protected final String materialName;
    protected final Block ingredient1;
    protected final TagKey<Item> ingredient2;
    protected final Block braceMaterial;
    protected final boolean isFlammable;

    static {
        AXIS = Properties.AXIS;
        OPEN = Properties.OPEN;

        CONNECTED_NORTH = BooleanProperty.of("connected_north");
        CONNECTED_SOUTH = BooleanProperty.of("connected_south");
        CONNECTED_EAST = BooleanProperty.of("connected_east");
        CONNECTED_WEST = BooleanProperty.of("connected_west");
    }

    public GenericCrate(AbstractBlock.Settings settings) {
        this("Oak", "oak", Blocks.OAK_PLANKS, ItemTags.OAK_LOGS, Blocks.STRIPPED_OAK_LOG, true);
    }

    public GenericCrate(String material, String materialName, Block ingredient1, TagKey<Item> ingredient2, Block braceMaterial, boolean isFlammable) {
        super(AbstractBlock.Settings.copy(Blocks.BARREL));

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("containers/crates/%s", material));

        this.material = material;
        this.materialName = materialName;
        this.ingredient1 = ingredient1;
        this.ingredient2 = ingredient2;
        this.braceMaterial = braceMaterial;
        this.isFlammable = isFlammable;

        this.setDefaultState(
            this.stateManager
                .getDefaultState()
                .with(AXIS, Axis.Y)
                .with(CONNECTED_NORTH, false)
                .with(CONNECTED_SOUTH, false)
                .with(CONNECTED_EAST, false)
                .with(CONNECTED_WEST, false)
                .with(OPEN, false)
        );
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

    public static BlockState changeRotation(BlockState state, BlockRotation rotation) {
        if (isConnectedCrate(state)) {
            return state;
        }

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
        builder.add(AXIS, OPEN, CONNECTED_NORTH, CONNECTED_SOUTH, CONNECTED_EAST, CONNECTED_WEST);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState placementState = this.getDefaultState().with(AXIS, ctx.getSide().getAxis());

        // if the player is sneaking, and they are targeting another block of this type, and that block is not already connected elsewhere
        if (ctx.getPlayer() != null && ctx.getPlayer().isSneaking() && ctx.getSide().getAxis().isHorizontal()) {
            Direction side = ctx.getSide().getOpposite();
            BlockState neighbor = getAvailableNeighboringCrate(ctx, side);
            BooleanProperty prop = getConnectionProperty(side);

            if (neighbor != null) {
                return this.getDefaultState().with(AXIS, Axis.Y).with(prop, true);
            }
        }

        // if the player is sneaking, or if this crate is not being placed vertically, skip checking for double crate stuff
        if (ctx.shouldCancelInteraction() || ctx.getSide().getAxis().isHorizontal()) {
            return placementState;
        }

        BlockState neighbor;

        neighbor = getAvailableNeighboringCrate(ctx, Direction.NORTH);
        if (neighbor != null) {
            return placementState.with(CONNECTED_NORTH, true);
        }

        neighbor = getAvailableNeighboringCrate(ctx, Direction.EAST);
        if (neighbor != null) {
            return placementState.with(CONNECTED_EAST, true);
        }

        neighbor = getAvailableNeighboringCrate(ctx, Direction.SOUTH);
        if (neighbor != null) {
            return placementState.with(CONNECTED_SOUTH, true);
        }

        neighbor = getAvailableNeighboringCrate(ctx, Direction.WEST);
        if (neighbor != null) {
            return placementState.with(CONNECTED_WEST, true);
        }

        return placementState;
    }

    @Nullable
    private BooleanProperty getConnectionProperty(Direction dir) {
        return switch (dir) {
            case DOWN, UP -> null;
            case NORTH -> CONNECTED_NORTH;
            case SOUTH -> CONNECTED_SOUTH;
            case EAST -> CONNECTED_EAST;
            case WEST -> CONNECTED_WEST;
        };
    }

    @Nullable
    private BooleanProperty getReverseConnectionProperty(Direction dir) {
        return switch (dir) {
            case DOWN, UP -> null;
            case NORTH -> CONNECTED_SOUTH;
            case SOUTH -> CONNECTED_NORTH;
            case EAST -> CONNECTED_WEST;
            case WEST -> CONNECTED_EAST;
        };
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (direction.getAxis().isVertical()) {
            return state;
        }

        if (!neighborState.isOf(this)) {
            return state.with(getConnectionProperty(direction), false);
        }

        BooleanProperty prop = getReverseConnectionProperty(direction);
        if (neighborState.get(prop)) {
            return state.with(getConnectionProperty(direction), true);
        }

        return state;
    }

    private static boolean isConnectedCrate(BlockState crate) {
        return crate.get(CONNECTED_NORTH) || crate.get(CONNECTED_SOUTH) || crate.get(CONNECTED_EAST) || crate.get(CONNECTED_WEST);
    }

    @Nullable
    private BlockState getAvailableNeighboringCrate(ItemPlacementContext ctx, Direction dir) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos().offset(dir));

        if (!blockState.isOf(this) || isConnectedCrate(blockState) || blockState.get(AXIS).isHorizontal()) {
            return null;
        }

        return blockState;
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

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, this, 1)
            .pattern("#X#")
            .pattern("XXX")
            .pattern("#X#")
            .input('X', ingredient1)
            .input('#', ingredient2)
            .criterion(FabricRecipeProvider.hasItem(ingredient1),
                FabricRecipeProvider.conditionsFromItem(ingredient1))
            .criterion("has_log",
                FabricRecipeProvider.conditionsFromTag(ingredient2))
            .offerTo(exporter);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Crate", materialName));
    }


    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.BRACE, Registries.BLOCK.getId(braceMaterial).withPrefixedPath("block/"))
            .put(MinekeaTextures.MATERIAL, Registries.BLOCK.getId(ingredient1).withPrefixedPath("block/"));

        Identifier subModelId = blockStateModelGenerator.createSubModel(this, "", CRATE_MODEL, unused -> textures);
        Identifier halfModelId = blockStateModelGenerator.createSubModel(this, "_double_half", HALF_DOUBLE_CRATE_MODEL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create()
                            .set(AXIS, Direction.Axis.X),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create()
                            .set(AXIS, Direction.Axis.Z),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create()
                            .set(CONNECTED_NORTH, false)
                            .set(CONNECTED_SOUTH, false)
                            .set(CONNECTED_EAST, false)
                            .set(CONNECTED_WEST, false)
                            .set(AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create()
                            .set(CONNECTED_NORTH, false)
                            .set(CONNECTED_SOUTH, false)
                            .set(CONNECTED_EAST, false)
                            .set(CONNECTED_WEST, true)
                            .set(AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, halfModelId)
                    )
                    .with(
                        When.create()
                            .set(CONNECTED_NORTH, true)
                            .set(CONNECTED_SOUTH, false)
                            .set(CONNECTED_EAST, false)
                            .set(CONNECTED_WEST, false)
                            .set(AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, halfModelId)
                    )
                    .with(
                        When.create()
                            .set(CONNECTED_NORTH, false)
                            .set(CONNECTED_SOUTH, false)
                            .set(CONNECTED_EAST, true)
                            .set(CONNECTED_WEST, false)
                            .set(AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, halfModelId)
                    )
                    .with(
                        When.create()
                            .set(CONNECTED_NORTH, false)
                            .set(CONNECTED_SOUTH, true)
                            .set(CONNECTED_EAST, false)
                            .set(CONNECTED_WEST, false)
                            .set(AXIS, Direction.Axis.Y),
                        BlockStateVariant.create()
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, halfModelId)
                    )
            );
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
