package com.chimericdream.minekea.block.building.covers;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.item.MinekeaItemGroups;
import com.chimericdream.minekea.resource.ModelUtils;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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
import net.minecraft.world.WorldAccess;

import java.util.Optional;

public class GenericCoverBlock extends CarpetBlock implements MinekeaBlock, Waterloggable {
    // yowza
    public static final Model COVER_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/building/cover")),
        Optional.empty(),
        TextureKey.END,
        TextureKey.SIDE
    );

    public static final DirectionProperty FACING;
    public static final BooleanProperty WATERLOGGED;

    static {
        FACING = Properties.HORIZONTAL_FACING;
        WATERLOGGED = Properties.WATERLOGGED;
    }

    public final Identifier BLOCK_ID;

    protected final String materialName;
    protected final String material;
    protected final boolean isFlammable;
    protected final Block settingsSource;
    protected final Block ingredient;
    protected final Identifier endTextureId;
    protected final Identifier sideTextureId;

    public GenericCoverBlock(String materialName, String material, boolean isFlammable, Block ingredient) {
        this(materialName, material, isFlammable, ingredient, ingredient, TextureMap.getId(ingredient), TextureMap.getId(ingredient));
    }

    public GenericCoverBlock(String materialName, String material, boolean isFlammable, Block ingredient, Block settingsSource) {
        this(materialName, material, isFlammable, ingredient, settingsSource, TextureMap.getId(ingredient), TextureMap.getId(ingredient));
    }

    public GenericCoverBlock(String materialName, String material, boolean isFlammable, Block ingredient, Identifier textureId) {
        this(materialName, material, isFlammable, ingredient, ingredient, textureId, textureId);
    }

    public GenericCoverBlock(String materialName, String material, boolean isFlammable, Block ingredient, Block settingsSource, Identifier textureId) {
        this(materialName, material, isFlammable, ingredient, settingsSource, textureId, textureId);
    }

    public GenericCoverBlock(String materialName, String material, boolean isFlammable, Block ingredient, Identifier endTextureId, Identifier sideTextureId) {
        this(materialName, material, isFlammable, ingredient, ingredient, endTextureId, sideTextureId);
    }

    public GenericCoverBlock(String materialName, String material, boolean isFlammable, Block ingredient, Block settingsSource, Identifier endTextureId, Identifier sideTextureId) {
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
        this.settingsSource = settingsSource;
        this.endTextureId = endTextureId;
        this.sideTextureId = sideTextureId;

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/covers/%s", material));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayer().getHorizontalFacing().getOpposite())
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
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        ItemGroupEvents.modifyEntriesEvent(MinekeaItemGroups.COVERS_ITEM_GROUP_KEY)
            .register((itemGroup) -> itemGroup.add(this));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 16)
            .pattern("# #")
            .pattern("   ")
            .pattern("# #")
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
        translationBuilder.add(this, String.format("%s Cover", materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.END, endTextureId)
            .put(TextureKey.SIDE, sideTextureId);

        Identifier subModelId = blockStateModelGenerator.createSubModel(this, "", COVER_MODEL, unused -> textures);

        ModelUtils.registerBlockWithHorizontalFacing(blockStateModelGenerator, FACING, this, subModelId);
    }
}
