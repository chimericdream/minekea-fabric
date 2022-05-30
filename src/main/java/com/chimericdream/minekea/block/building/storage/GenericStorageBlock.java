package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class GenericStorageBlock extends Block implements MinekeaBlock {
    // @TODO: change this to `is_bagged` instead of `is_placed`
    public static final BooleanProperty IS_BAGGED = BooleanProperty.of("is_placed");

    public final Identifier BLOCK_ID;
    public final Identifier baseBlock;
    public final boolean isBaggedItem;

    public GenericStorageBlock(FabricBlockSettings settings, Identifier blockID, Identifier baseBlock) {
        this(settings, blockID, baseBlock, false);
    }

    public GenericStorageBlock(Identifier baseBlock) {
        this(baseBlock, false);
    }

    public GenericStorageBlock(Identifier baseBlock, boolean isBaggedItem) {
        this(
            FabricBlockSettings.of(Material.AGGREGATE).strength(1.0f),
            new Identifier(ModInfo.MOD_ID, "storage/compressed/" + baseBlock.getPath()),
            baseBlock,
            isBaggedItem
        );
    }

    public GenericStorageBlock(FabricBlockSettings settings, Identifier blockID, Identifier baseBlock, boolean isBaggedItem) {
        super(settings);

        this.BLOCK_ID = blockID;
        this.baseBlock = baseBlock;
        this.isBaggedItem = isBaggedItem;

        setDefaultState(getStateManager().getDefaultState().with(IS_BAGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(IS_BAGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        if (isBaggedItem) {
            return (BlockState) this.getDefaultState().with(IS_BAGGED, true);
        }

        return (BlockState) this.getDefaultState().with(IS_BAGGED, false);
    }

    @Override
    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        setupResources();
    }

    @Override
    public void setupResources() {
        Identifier MODEL_ID = Model.getBlockModelID(BLOCK_ID);
        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);
        Identifier BAGGED_MODEL_ID = new Identifier(MODEL_ID.getNamespace(), MODEL_ID.getPath() + "_bagged");

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("XXX", "XXX", "XXX"),
                JKeys.keys().key("X", JIngredient.ingredient().item(baseBlock.toString())),
                JResult.result(BLOCK_ID.toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            new Identifier(ModInfo.MOD_ID, "storage/" + baseBlock.getPath() + "_from_compressed"),
            JRecipe.shapeless(
                JIngredients.ingredients().add(JIngredient.ingredient().item(BLOCK_ID.toString())),
                JResult.stackedResult(baseBlock.toString(), 9)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        JTextures textures = new JTextures().var("all", Texture.getBlockTextureID(BLOCK_ID).toString());
        JTextures placedTextures = new JTextures().var("contents", Texture.getBlockTextureID(BLOCK_ID).toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model("minecraft:block/cube_all").textures(textures), MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(String.format("%s:block/storage/bagged_block", ModInfo.MOD_ID)).textures(placedTextures), BAGGED_MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("is_placed=false", new JBlockModel(MODEL_ID))
                    .put("is_placed=true", new JBlockModel(BAGGED_MODEL_ID))
            ),
            BLOCK_ID
        );
    }
}
