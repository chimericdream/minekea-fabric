package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

import java.util.Map;

public class GenericStorageBlock extends Block implements MinekeaBlock {
    public static final EnumProperty<Direction.Axis> AXIS;
    public static final BooleanProperty IS_BAGGED;

    static {
        AXIS = Properties.AXIS;
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS, IS_BAGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        StorageBlockSettings settings = (StorageBlockSettings) this.settings;

        BlockState state = this.getDefaultState().with(AXIS, ctx.getSide().getAxis());

        if (settings.isBaggedItem) {
            return state.with(IS_BAGGED, true);
        }

        return state.with(IS_BAGGED, false);
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
        Map<String, Identifier> materials = settings.getMaterials();

        Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

        MinekeaResourcePack.EN_US.blockRespect(this, String.format("Compressed %s", Registry.ITEM.get(ingredient).getName().getString()));

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

        JTextures textures = new JTextures()
            .var("all", blockTexture.toString())
            .var("end", new Identifier(blockTexture + "_end").toString())
            .var("side", new Identifier(blockTexture + "_side").toString());

        JTextures baggedTextures = new JTextures().var("contents", blockTexture.toString());

        if (settings.isColumnBlock) {
            MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model("minecraft:block/cube_column").textures(textures), MODEL_ID);
            MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model("minecraft:block/cube_column_horizontal").textures(textures), HORIZONTAL_MODEL_ID);
        } else {
            MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model("minecraft:block/cube_all").textures(textures), MODEL_ID);
        }

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(String.format("%s:block/storage/bagged_block", ModInfo.MOD_ID)).textures(baggedTextures), BAGGED_MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        if (settings.isColumnBlock) {
            MinekeaResourcePack.RESOURCE_PACK.addBlockState(
                JState.state(
                    JState.variant()
                        .put("axis=x", new JBlockModel(HORIZONTAL_MODEL_ID).x(90).y(90))
                        .put("axis=y", new JBlockModel(MODEL_ID))
                        .put("axis=z", new JBlockModel(HORIZONTAL_MODEL_ID).x(90))
                ),
                getBlockID()
            );
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

        public StorageBlockSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public StorageBlockSettings bagged() {
            this.isBaggedItem = true;
            return this;
        }

        public StorageBlockSettings column() {
            this.isColumnBlock = true;
            return this;
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
