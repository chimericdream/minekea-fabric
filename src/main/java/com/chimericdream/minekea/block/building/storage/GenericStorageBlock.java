package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.blocks.BlockDataGenerator;
import com.chimericdream.lib.blocks.RegisterableBlock;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.util.ModConfigurable;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaTextures;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Optional;
import java.util.function.Supplier;

abstract public class GenericStorageBlock extends Block implements BlockDataGenerator, FabricBlockDataGenerator, ModConfigurable, RegisterableBlock {
    protected static final Model COMPRESSED_BLOCK_MODEL = Models.CUBE_ALL;
    protected static final Model COMPRESSED_COLUMN_BLOCK_MODEL = new Model(
        Optional.of(Identifier.of("minekea:block/storage/compressed_column")),
        Optional.empty(),
        TextureKey.BOTTOM,
        TextureKey.SIDE,
        TextureKey.TOP
    );
    protected static final Model COMPRESSED_COLUMN_BLOCK_HORIZONTAL_MODEL = new Model(
        Optional.of(Identifier.of("minekea:block/storage/compressed_column_horizontal")),
        Optional.empty(),
        TextureKey.BOTTOM,
        TextureKey.SIDE,
        TextureKey.TOP
    );
    protected static final Model BAGGED_BLOCK_MODEL = new Model(
        Optional.of(Identifier.of("minekea:block/storage/bagged_block")),
        Optional.empty(),
        MinekeaTextures.CONTENTS
    );

    public static final EnumProperty<Direction.Axis> AXIS;
    public static final DirectionProperty FACING;
    public static final BooleanProperty IS_BAGGED;

    public final Identifier BLOCK_ID;
    public final BlockConfig config;
    public final boolean isBaggedItem;

    static {
        AXIS = Properties.AXIS;
        FACING = Properties.FACING;
        IS_BAGGED = BooleanProperty.of("is_bagged");
    }

    public GenericStorageBlock(BlockConfig config) {
        this(config, false);
    }

    public GenericStorageBlock(BlockConfig config, boolean isBaggedItem) {
        super(config.getBaseSettings());

        setDefaultState(
            getStateManager()
                .getDefaultState()
                .with(AXIS, Direction.Axis.Y)
                .with(IS_BAGGED, false)
        );

        this.BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("storage/compressed/%s", config.getMaterial()));
        this.config = config;
        this.isBaggedItem = isBaggedItem;
    }

    public BlockConfig getConfig() {
        return this.config;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        if (state.get(IS_BAGGED)) {
            return VoxelShapes.union(
                Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 9.0, 16.0),
                Block.createCuboidShape(1.0, 9.0, 1.0, 15.0, 10.0, 15.0),
                Block.createCuboidShape(0.0, 10.0, 0.0, 16.0, 13.0, 16.0),
                Block.createCuboidShape(1.0, 13.0, 1.0, 15.0, 16.0, 15.0)
            );
        }

        return VoxelShapes.fullCube();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS, FACING, IS_BAGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = this.getDefaultState()
            .with(AXIS, ctx.getSide().getAxis())
            .with(FACING, ctx.getPlayerLookDirection().getOpposite());

        if (this.isBaggedItem) {
            return state.with(IS_BAGGED, true);
        }

        return state.with(IS_BAGGED, false);
    }

    @Override
    public ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(IS_BAGGED) && stack.isOf(Items.SHEARS)) {
            if (world.isClient()) {
                world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0f, 1.0f);
            } else {
                world.setBlockState(pos, state.with(IS_BAGGED, false));
                world.markDirty(pos);
            }

            return ItemActionResult.SUCCESS;
        }

        if (!state.get(IS_BAGGED) && this.isBaggedItem && stack.isOf(Items.LEATHER)) {
            if (world.isClient()) {
                world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_BUNDLE_INSERT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            } else {
                world.setBlockState(pos, state.with(IS_BAGGED, true));
                world.markDirty(pos);
            }

            return ItemActionResult.SUCCESS;
        }

        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    public void configureRecipes(RecipeExporter exporter) {
        Item baseItem = config.getItem();

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 1)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .input('#', baseItem)
            .criterion(FabricRecipeProvider.hasItem(baseItem),
                FabricRecipeProvider.conditionsFromItem(baseItem))
            .offerTo(exporter);

        // This means that things like totems won't be uncraftable; modpacks which have some method to override
        // the max stack size can re-add these recipes in a datapack
        if (baseItem.getMaxCount() >= 9) {
            ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, baseItem, 9)
                .input(this)
                .criterion(FabricRecipeProvider.hasItem(this),
                    FabricRecipeProvider.conditionsFromItem(this))
                .offerTo(exporter, Registries.ITEM.getId(baseItem).withSuffixedPath("_from_compressed"));
        }
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    public void configureBaggedBlockModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(MinekeaTextures.CONTENTS, Identifier.of(ModInfo.MOD_ID, String.format("block/%s", BLOCK_ID.getPath())))
            .put(TextureKey.ALL, Identifier.of(ModInfo.MOD_ID, String.format("block/%s", BLOCK_ID.getPath())));

        this.configureBaggedBlockModels(blockStateModelGenerator, textures);
    }

    public void configureBaggedBlockModels(BlockStateModelGenerator blockStateModelGenerator, TextureMap textures) {
        Identifier baggedModelId = blockStateModelGenerator.createSubModel(this, "_bagged", BAGGED_BLOCK_MODEL, unused -> textures);
        Identifier baseModelId = blockStateModelGenerator.createSubModel(this, "", Models.CUBE_ALL, unused -> textures);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create().set(IS_BAGGED, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baggedModelId)
                    )
                    .with(
                        When.create().set(IS_BAGGED, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, baseModelId)
                    )
            );

        blockStateModelGenerator.excludeFromSimpleItemModelGeneration(this);
    }

    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        if (this.isBaggedItem) {
            Block self = this;

            itemModelGenerator.writer.accept(ModelIds.getItemModelId(this.asItem()), new Supplier<JsonElement>() {
                @Override
                public JsonElement get() {
                    JsonArray overrides = new JsonArray();

                    JsonObject override = new JsonObject();
                    JsonObject predicate = new JsonObject();
                    predicate.addProperty("custom_model_data", 9001);
                    override.add("predicate", predicate);
                    override.addProperty("model", ModelIds.getBlockModelId(self).withSuffixedPath("_bagged").toString());

                    overrides.add(override);

                    JsonObject modelJson = new JsonObject();
                    modelJson.addProperty("parent", ModelIds.getBlockModelId(self).toString());
                    modelJson.add("overrides", overrides);

                    return modelJson;
                }
            });
        }
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(this);
    }
}
