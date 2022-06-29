package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.*;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Objects;

public class GenericStorageBlock extends Block implements MinekeaBlock {
    public static final EnumProperty<Direction.Axis> AXIS;
    public static final DirectionProperty FACING;
    public static final BooleanProperty IS_BAGGED;

    static {
        AXIS = Properties.AXIS;
        FACING = Properties.FACING;
        // @TODO: change this to `is_bagged` instead of `is_placed`
        IS_BAGGED = BooleanProperty.of("is_placed");
    }

    public GenericStorageBlock(StorageBlockSettings settings) {
        super(settings);

        setDefaultState(
            getStateManager()
                .getDefaultState()
                .with(AXIS, Direction.Axis.Y)
                .with(IS_BAGGED, false)
        );
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
        StorageBlockSettings settings = (StorageBlockSettings) this.settings;

        BlockState state = this.getDefaultState()
            .with(AXIS, ctx.getSide().getAxis())
            .with(FACING, ctx.getPlayerLookDirection().getOpposite());

        if (settings.isBaggedItem) {
            return state.with(IS_BAGGED, true);
        }

        return state.with(IS_BAGGED, false);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        StorageBlockSettings settings = (StorageBlockSettings) this.settings;
        ItemStack heldItem = player.getStackInHand(hand);

        if (state.get(IS_BAGGED) && heldItem.isItemEqual(Items.SHEARS.getDefaultStack())) {
            if (world.isClient()) {
                world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ENTITY_SHEEP_SHEAR, SoundCategory.BLOCKS, 1.0f, 1.0f);
            } else {
                world.setBlockState(pos, state.with(IS_BAGGED, false));
                world.markDirty(pos);
            }

            return ActionResult.SUCCESS;
        }

        if (!state.get(IS_BAGGED) && settings.isBaggedItem && heldItem.isItemEqual(Items.LEATHER.getDefaultStack())) {
            if (world.isClient()) {
                world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_BUNDLE_INSERT, SoundCategory.BLOCKS, 1.0f, 1.0f);
            } else {
                if (!player.isCreative()) {
                    heldItem.decrement(1);
                    player.setStackInHand(hand, heldItem);
                }

                world.setBlockState(pos, state.with(IS_BAGGED, true));
                world.markDirty(pos);
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public Identifier getBlockID() {
        return ((MinekeaBlockSettings<?>) this.settings).getBlockId();
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        setupResources();
    }

    @Override
    public void setupResources() {
        StorageBlockSettings settings = (StorageBlockSettings) this.settings;
        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
        Map<String, Identifier> materials = settings.getMaterials();

        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));

        Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier HORIZONTAL_MODEL_ID = new Identifier(MODEL_ID + "_horizontal");
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());
        Identifier BAGGED_MODEL_ID = new Identifier(MODEL_ID.getNamespace(), MODEL_ID.getPath() + "_bagged");

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("XXX", "XXX", "XXX"),
                JKeys.keys().key("X", JIngredient.ingredient().item(ingredient.toString())),
                JResult.result(getBlockID().toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            new Identifier(ModInfo.MOD_ID, "storage/" + ingredient.getPath() + "_from_compressed"),
            JRecipe.shapeless(
                JIngredients.ingredients().add(JIngredient.ingredient().item(getBlockID().toString())),
                JResult.stackedResult(ingredient.toString(), 9)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        Identifier blockTexture = Texture.getBlockTextureID(getBlockID());

        JTextures textures = new JTextures();

        if (settings.isColumnBlock) {
            if (settings.hasSeparateTop) {
                textures
                    .var("down", new Identifier(blockTexture + "_bottom").toString())
                    .var("up", new Identifier(blockTexture + "_top").toString());
            } else {
                textures
                    .var("down", new Identifier(blockTexture + "_end").toString())
                    .var("up", new Identifier(blockTexture + "_end").toString());
            }

            textures.var("side", new Identifier(blockTexture + "_side").toString());
        } else {
            textures.var("all", blockTexture.toString());
        }

        JTextures baggedTextures = new JTextures().var("contents", blockTexture.toString());

        if (settings.isColumnBlock) {
            MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(ModInfo.MOD_ID + ":block/storage/compressed_column").textures(textures), MODEL_ID);
            MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(ModInfo.MOD_ID + ":block/storage/compressed_column_horizontal").textures(textures), HORIZONTAL_MODEL_ID);
        } else {
            MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model("minecraft:block/cube_all").textures(textures), MODEL_ID);
        }

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(String.format("%s:block/storage/bagged_block", ModInfo.MOD_ID)).textures(baggedTextures), BAGGED_MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        if (settings.isColumnBlock) {
            if (settings.hasSeparateTop) {
                MinekeaResourcePack.RESOURCE_PACK.addBlockState(
                    JState.state(
                        JState.variant()
                            .put("facing=north", new JBlockModel(MODEL_ID).x(90))
                            .put("facing=east", new JBlockModel(MODEL_ID).x(90).y(90))
                            .put("facing=south", new JBlockModel(MODEL_ID).x(270))
                            .put("facing=west", new JBlockModel(MODEL_ID).x(90).y(270))
                            .put("facing=up", new JBlockModel(MODEL_ID))
                            .put("facing=down", new JBlockModel(MODEL_ID).x(180))
                    ),
                    getBlockID()
                );
            } else {
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
        } else {
            MinekeaResourcePack.RESOURCE_PACK.addBlockState(
                JState.state(
                    JState.variant()
                        .put("is_placed=false", new JBlockModel(MODEL_ID))
                        .put("is_placed=true", new JBlockModel(BAGGED_MODEL_ID))
                ),
                getBlockID()
            );
        }
    }

    public static class StorageBlockSettings extends MinekeaBlockSettings<StorageBlockSettings> {
        protected boolean isBaggedItem = false;
        protected boolean isColumnBlock = false;
        protected boolean hasSeparateTop = false;

        public StorageBlockSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public StorageBlockSettings separateTop() {
            this.hasSeparateTop = true;
            return this;
        }

        public StorageBlockSettings bagged() {
            this.isBaggedItem = true;
            return this;
        }

        public StorageBlockSettings column() {
            this.isColumnBlock = true;
            return this;
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "Compressed %s");
        }

        @Override
        public Identifier getBlockId() {
            Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("storage/compressed/" + ingredient.getPath()));
            }

            return blockId;
        }
    }
}
