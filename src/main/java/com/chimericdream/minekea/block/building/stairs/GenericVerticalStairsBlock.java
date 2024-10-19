package com.chimericdream.minekea.block.building.stairs;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.Tool;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
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
import net.minecraft.registry.tag.TagKey;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;

import java.util.Optional;
import java.util.function.Function;

public class GenericVerticalStairsBlock extends Block implements MinekeaBlock, Waterloggable {
    public static final Model VERTICAL_STAIRS_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/building/stairs/vertical")),
        Optional.empty(),
        TextureKey.ALL
    );

    public static final DirectionProperty FACING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    public static final VoxelShape NORTH_SHAPE = VoxelShapes.union(
        Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 16.0),
        Block.createCuboidShape(8.0, 0.0, 8.0, 16.0, 16.0, 16.0)
    );
    public static final VoxelShape EAST_SHAPE = VoxelShapes.union(
        Block.createCuboidShape(0.0, 0.0, 0.0, 8.0, 16.0, 16.0),
        Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 8.0)
    );
    public static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(
        Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 8.0),
        Block.createCuboidShape(8.0, 0.0, 8.0, 16.0, 16.0, 16.0)
    );
    public static final VoxelShape WEST_SHAPE = VoxelShapes.union(
        Block.createCuboidShape(0.0, 0.0, 8.0, 16.0, 16.0, 16.0),
        Block.createCuboidShape(8.0, 0.0, 0.0, 16.0, 16.0, 8.0)
    );

    static {
        FACING = Properties.HORIZONTAL_FACING;
    }

    public final Identifier BLOCK_ID;

    protected final String materialName;
    protected final String material;
    protected final boolean isFlammable;
    protected final Block ingredient;
    protected final Identifier textureId;
    protected final Tool miningTool;

    public GenericVerticalStairsBlock(String materialName, String material, boolean isFlammable, Block ingredient) {
        this(materialName, material, isFlammable, ingredient, TextureMap.getId(ingredient));
    }

    public GenericVerticalStairsBlock(String materialName, String material, boolean isFlammable, Block ingredient, Tool miningTool) {
        this(materialName, material, isFlammable, ingredient, TextureMap.getId(ingredient), miningTool);
    }

    public GenericVerticalStairsBlock(String materialName, String material, boolean isFlammable, Block ingredient, Identifier textureId) {
        this(materialName, material, isFlammable, ingredient, textureId, Tool.PICKAXE);
    }

    public GenericVerticalStairsBlock(String materialName, String material, boolean isFlammable, Block ingredient, Identifier textureId, Tool miningTool) {
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
        this.miningTool = miningTool;

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/stairs/vertical/%s", material));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState()
            .with(FACING, ctx.getPlayer() == null ? Direction.NORTH : ctx.getPlayer().getHorizontalFacing().getOpposite())
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
            case EAST -> GenericVerticalStairsBlock.EAST_SHAPE;
            case SOUTH -> GenericVerticalStairsBlock.SOUTH_SHAPE;
            case WEST -> GenericVerticalStairsBlock.WEST_SHAPE;
            default -> GenericVerticalStairsBlock.NORTH_SHAPE;
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
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(this.miningTool.getMineableTag())
            .setReplace(false)
            .add(this);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 8)
            .pattern("###")
            .pattern(" ##")
            .pattern("  #")
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
        translationBuilder.add(this, String.format("%s Vertical Stairs", materialName));
    }

    public static void doBlockStateModels(
        BlockStateModelGenerator blockStateModelGenerator,
        Block block,
        Identifier textureId
    ) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.ALL, textureId);

        Identifier coreModelId = blockStateModelGenerator.createSubModel(block, "", VERTICAL_STAIRS_MODEL, unused -> textures);
        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(block)
                    .with(
                        When.create().set(FACING, Direction.NORTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(FACING, Direction.EAST),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(FACING, Direction.SOUTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R180)
                            .put(VariantSettings.UVLOCK, true)
                    )
                    .with(
                        When.create().set(FACING, Direction.WEST),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, coreModelId)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.UVLOCK, true)
                    )
            );
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        doBlockStateModels(blockStateModelGenerator, this, textureId);
    }
}
