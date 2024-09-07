package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
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

abstract public class GenericStorageBlock extends Block implements MinekeaBlock {
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

    public static final EnumProperty<Direction.Axis> AXIS;
    public static final DirectionProperty FACING;
    public static final BooleanProperty IS_BAGGED;

    public final Item BASE_ITEM;
    public final Identifier BLOCK_ID;
    public final boolean isBaggedItem;

    static {
        AXIS = Properties.AXIS;
        FACING = Properties.FACING;
        IS_BAGGED = BooleanProperty.of("is_bagged");
    }

    public GenericStorageBlock(AbstractBlock.Settings settings, Item baseItem, String baseItemName) {
        this(settings, baseItem, baseItemName, false);
    }

    public GenericStorageBlock(AbstractBlock.Settings settings, Item baseItem, String baseItemName, boolean isBaggedItem) {
        super(settings);

        setDefaultState(
            getStateManager()
                .getDefaultState()
                .with(AXIS, Direction.Axis.Y)
                .with(IS_BAGGED, false)
        );

        BASE_ITEM = baseItem;
        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("storage/compressed/%s", baseItemName));
        this.isBaggedItem = isBaggedItem;
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
                if (!player.isCreative()) {
                    stack.decrement(1);
                    player.setStackInHand(hand, stack);
                }

                world.setBlockState(pos, state.with(IS_BAGGED, true));
                world.markDirty(pos);
            }

            return ItemActionResult.SUCCESS;
        }

        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 1)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .input('#', BASE_ITEM)
            .criterion(FabricRecipeProvider.hasItem(BASE_ITEM),
                FabricRecipeProvider.conditionsFromItem(BASE_ITEM))
            .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, BASE_ITEM, 9)
            .input(this)
            .criterion(FabricRecipeProvider.hasItem(this),
                FabricRecipeProvider.conditionsFromItem(this))
            .offerTo(exporter);
    }

    @Override
    public void configureBlockLootTables(BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

//    @Override
//    public void setupResources() {
//        StorageBlockSettings settings = (StorageBlockSettings) this.settings;
//        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
//        Map<String, Identifier> materials = settings.getMaterials();
//
//        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));
//
//        Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));
//
//        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
//        Identifier HORIZONTAL_MODEL_ID = Identifier.of(MODEL_ID + "_horizontal");
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
//        Identifier BAGGED_MODEL_ID = Identifier.of(MODEL_ID.getNamespace(), MODEL_ID.getPath() + "_bagged");
//
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));
//
//        Identifier blockTexture = Texture.getBlockTextureID(getBlockID());
//
//        JTextures textures = new JTextures();
//
//        if (settings.isColumn()) {
//            if (settings.hasSeparateTop) {
//                textures
//                    .var("down", Identifier.of(blockTexture + "_bottom").toString())
//                    .var("up", Identifier.of(blockTexture + "_top").toString());
//            } else {
//                textures
//                    .var("down", Identifier.of(blockTexture + "_end").toString())
//                    .var("up", Identifier.of(blockTexture + "_end").toString());
//            }
//
//            textures.var("side", Identifier.of(blockTexture + "_side").toString());
//        } else {
//            textures.var("all", blockTexture.toString());
//        }
//
//        JTextures baggedTextures = new JTextures().var("contents", blockTexture.toString());
//
//        if (settings.isColumn()) {
//            MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(ModInfo.MOD_ID + ":block/storage/compressed_column").textures(textures), MODEL_ID);
//            MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(ModInfo.MOD_ID + ":block/storage/compressed_column_horizontal").textures(textures), HORIZONTAL_MODEL_ID);
//        } else {
//            MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model("minecraft:block/cube_all").textures(textures), MODEL_ID);
//        }
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(String.format("%s:block/storage/bagged_block", ModInfo.MOD_ID)).textures(baggedTextures), BAGGED_MODEL_ID);
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);
//
//        if (settings.isColumn()) {
//            if (settings.hasSeparateTop) {
//                MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//                    JState.state(
//                        JState.variant()
//                            .put("facing=north", new JBlockModel(MODEL_ID).x(90))
//                            .put("facing=east", new JBlockModel(MODEL_ID).x(90).y(90))
//                            .put("facing=south", new JBlockModel(MODEL_ID).x(270))
//                            .put("facing=west", new JBlockModel(MODEL_ID).x(90).y(270))
//                            .put("facing=up", new JBlockModel(MODEL_ID))
//                            .put("facing=down", new JBlockModel(MODEL_ID).x(180))
//                    ),
//                    getBlockID()
//                );
//            } else {
//                MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//                    JState.state(
//                        JState.variant()
//                            .put("axis=x", new JBlockModel(HORIZONTAL_MODEL_ID).x(90).y(90))
//                            .put("axis=y", new JBlockModel(MODEL_ID))
//                            .put("axis=z", new JBlockModel(HORIZONTAL_MODEL_ID).x(90))
//                    ),
//                    getBlockID()
//                );
//            }
//        } else {
//            MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//                JState.state(
//                    JState.variant()
//                        .put("is_placed=false", new JBlockModel(MODEL_ID))
//                        .put("is_placed=true", new JBlockModel(BAGGED_MODEL_ID))
//                ),
//                getBlockID()
//            );
//        }
//    }
//
//    public static class StorageBlockSettings extends MinekeaBlockSettings<StorageBlockSettings> {
//        protected boolean isBaggedItem = false;
//        protected boolean hasSeparateTop = false;
//
//        public StorageBlockSettings(DefaultSettings settings) {
//            super((DefaultSettings) settings.nonOpaque());
//        }
//
//        public StorageBlockSettings separateTop() {
//            this.hasSeparateTop = true;
//            return this;
//        }
//
//        public StorageBlockSettings bagged() {
//            this.isBaggedItem = true;
//            return this;
//        }
//
//        public String getNamePattern() {
//            return Objects.requireNonNullElse(namePatternOverride, "Compressed %s");
//        }
//
//        @Override
//        public Identifier getBlockId() {
//            Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));
//
//            if (blockId == null) {
//                blockId = Identifier.of(ModInfo.MOD_ID, String.format("storage/compressed/" + ingredient.getPath()));
//            }
//
//            return blockId;
//        }
//    }
}
