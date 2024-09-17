package com.chimericdream.minekea.block.building.slabs;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.Optional;

public class GenericVerticalSlabBlock extends Block implements MinekeaBlock, Waterloggable {
    public static final Model VERTICAL_SLAB_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/building/slabs/vertical")),
        Optional.empty(),
        TextureKey.ALL
    );

    public static final DirectionProperty FACING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public static final VoxelShape NORTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 8.0);
    public static final VoxelShape SOUTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 8.0, 16.0, 16.0, 16.0);
    public static final VoxelShape EAST_SHAPE = Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 16.0);
    public static final VoxelShape WEST_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 16.0);

    public final Identifier BLOCK_ID;

    protected final String materialName;
    protected final String material;
    protected final boolean isFlammable;
    protected final Block ingredient;
    protected final Identifier textureId;

    static {
        FACING = Properties.HORIZONTAL_FACING;
    }

    public GenericVerticalSlabBlock(String materialName, String material, boolean isFlammable, Block ingredient) {
        this(materialName, material, isFlammable, ingredient, TextureMap.getId(ingredient));
    }

    public GenericVerticalSlabBlock(String materialName, String material, boolean isFlammable, Block ingredient, Identifier textureId) {
        super(AbstractBlock.Settings.copy(ingredient));

        this.setDefaultState(
            this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(WATERLOGGED, false)
        );

        this.materialName = materialName;
        this.material = material;
        this.isFlammable = isFlammable;
        this.ingredient = ingredient;
        this.textureId = textureId;

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/slabs/vertical/%s", material));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState()
            .with(FACING, ctx.getPlayer() == null ? Direction.NORTH : ctx.getPlayer().getHorizontalFacing())
            .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);

        return switch (facing) {
            case EAST -> GenericVerticalSlabBlock.EAST_SHAPE;
            case SOUTH -> GenericVerticalSlabBlock.SOUTH_SHAPE;
            case WEST -> GenericVerticalSlabBlock.WEST_SHAPE;
            default -> GenericVerticalSlabBlock.NORTH_SHAPE;
        };
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
            .register((itemGroup) -> itemGroup.add(this));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 6)
            .pattern("#")
            .pattern("#")
            .pattern("#")
            .input('#', ingredient)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .offerTo(exporter);
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Vertical Slab", materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.ALL, textureId);

        Identifier coreModelId = blockStateModelGenerator.createSubModel(this, "", VERTICAL_SLAB_MODEL, unused -> textures);
        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create().set(FACING, Direction.NORTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(FACING, Direction.EAST),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(FACING, Direction.SOUTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(FACING, Direction.WEST),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.UVLOCK, true)
                    )
            );
    }

//    @Override
//    public void setupResources() {
//        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
//        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
//        MinekeaTags.SLABS.add(getBlockID(), settings.isWooden());
//        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));
//
//        Identifier ingredient = settings.getMaterial("ingredient");
//        Identifier endTexture = settings.getBlockTexture("end");
//        Identifier sideTexture = settings.getBlockTexture("main");
//
//        Identifier SLAB_MODEL_ID = Model.getBlockModelID(getBlockID());
//        Identifier TOP_SLAB_MODEL_ID = new Identifier(ModInfo.MOD_ID, SLAB_MODEL_ID.getPath() + "_top");
//        Identifier DOUBLE_MODEL_ID = Model.getItemModelID(ingredient);
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
//
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.getLootTableID(getBlockID()), LootTable.slabLootTable(getBlockID()));
//
//        JTextures textures = new JTextures()
//            .var("bottom", endTexture.toString())
//            .var("top", endTexture.toString())
//            .var("side", sideTexture.toString());
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minecraft:block/slab").textures(textures),
//            SLAB_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(
//            JModel.model("minecraft:block/slab_top").textures(textures),
//            TOP_SLAB_MODEL_ID
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(SLAB_MODEL_ID), ITEM_MODEL_ID);
//
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("type=bottom", new JBlockModel(SLAB_MODEL_ID))
//                    .put("type=double", new JBlockModel(DOUBLE_MODEL_ID))
//                    .put("type=top", new JBlockModel(TOP_SLAB_MODEL_ID))
//            ),
//            getBlockID()
//        );
//    }
//
//    public static class SlabSettings extends MinekeaBlockSettings<SlabSettings> {
//        public SlabSettings(DefaultSettings settings) {
//            super((DefaultSettings) settings.nonOpaque());
//        }
//
//        public String getNamePattern() {
//            return Objects.requireNonNullElse(namePatternOverride, "%s Slab");
//        }
//
//        @Override
//        public Identifier getBlockId() {
//            if (blockId == null) {
//                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sbuilding/slabs/%s", ModInfo.getModPrefix(modId), mainMaterial));
//            }
//
//            return blockId;
//        }
//    }
}
