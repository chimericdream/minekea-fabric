package com.chimericdream.minekea.block.building.basalt_bricks;

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
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MossyBasaltBrickSlabBlock extends SlabBlock implements MinekeaBlock {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "building/mossy_basalt_brick_slab");

    public MossyBasaltBrickSlabBlock() {
        super(FabricBlockSettings.copyOf(Blocks.BASALT));
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
        Identifier SLAB_MODEL_ID = Model.getBlockModelID(BLOCK_ID);
        Identifier TOP_SLAB_MODEL_ID = new Identifier(ModInfo.MOD_ID, SLAB_MODEL_ID.getPath() + "_top");
        Identifier DOUBLE_MODEL_ID = Model.getItemModelID(MossyBasaltBricksBlock.BLOCK_ID);
        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("###"),
                JKeys.keys().key("#", JIngredient.ingredient().item(MossyBasaltBricksBlock.BLOCK_ID.toString())),
                JResult.stackedResult(BLOCK_ID.toString(), 6)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(
            new Identifier(BLOCK_ID.getNamespace(), "blocks/" + BLOCK_ID.getPath()),
            LootTable.slabLootTable(BLOCK_ID)
        );

        String warpedBricksTexture = Texture.getBlockTextureID(MossyBasaltBricksBlock.BLOCK_ID).toString();

        JTextures textures = new JTextures()
            .var("bottom", warpedBricksTexture)
            .var("top", warpedBricksTexture)
            .var("side", warpedBricksTexture);

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/slab").textures(textures),
            SLAB_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/slab_top").textures(textures),
            TOP_SLAB_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(SLAB_MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("type=bottom", new JBlockModel(SLAB_MODEL_ID))
                    .put("type=double", new JBlockModel(DOUBLE_MODEL_ID))
                    .put("type=top", new JBlockModel(TOP_SLAB_MODEL_ID))
            ),
            BLOCK_ID
        );
    }
}
