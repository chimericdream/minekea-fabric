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
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CrimsonBasaltBrickStairsBlock extends StairsBlock implements MinekeaBlock {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "building/crimson_basalt_brick_stairs");

    public CrimsonBasaltBrickStairsBlock() {
        super(Blocks.NETHER_BRICK_STAIRS.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BASALT));
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
        Identifier MAIN_MODEL_ID = Model.getBlockModelID(BLOCK_ID);
        Identifier INNER_MODEL_ID = new Identifier(ModInfo.MOD_ID, MAIN_MODEL_ID.getPath() + "_inner");
        Identifier OUTER_MODEL_ID = new Identifier(ModInfo.MOD_ID, MAIN_MODEL_ID.getPath() + "_outer");
        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("#  ", "## ", "###"),
                JKeys.keys()
                    .key("#", JIngredient.ingredient().item(CrimsonBasaltBricksBlock.BLOCK_ID.toString())),
                JResult.stackedResult(BLOCK_ID.toString(), 8)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        String warpedBricksTexture = Texture.getBlockTextureID(CrimsonBasaltBricksBlock.BLOCK_ID).toString();

        JTextures textures = new JTextures()
            .var("bottom", warpedBricksTexture)
            .var("top", warpedBricksTexture)
            .var("side", warpedBricksTexture);

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/stairs").textures(textures),
            MAIN_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/inner_stairs").textures(textures),
            INNER_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/outer_stairs").textures(textures),
            OUTER_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MAIN_MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("facing=east,half=bottom,shape=inner_left", new JBlockModel(INNER_MODEL_ID).y(270).uvlock())
                    .put("facing=east,half=bottom,shape=inner_right", new JBlockModel(INNER_MODEL_ID))
                    .put("facing=east,half=bottom,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).y(270).uvlock())
                    .put("facing=east,half=bottom,shape=outer_right", new JBlockModel(OUTER_MODEL_ID))
                    .put("facing=east,half=bottom,shape=straight", new JBlockModel(MAIN_MODEL_ID))
                    .put("facing=east,half=top,shape=inner_left", new JBlockModel(INNER_MODEL_ID).x(180).uvlock())
                    .put("facing=east,half=top,shape=inner_right", new JBlockModel(INNER_MODEL_ID).x(180).y(90).uvlock())
                    .put("facing=east,half=top,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).x(180).uvlock())
                    .put("facing=east,half=top,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).x(180).y(90).uvlock())
                    .put("facing=east,half=top,shape=straight", new JBlockModel(MAIN_MODEL_ID).x(180).uvlock())
                    .put("facing=north,half=bottom,shape=inner_left", new JBlockModel(INNER_MODEL_ID).y(180).uvlock())
                    .put("facing=north,half=bottom,shape=inner_right", new JBlockModel(INNER_MODEL_ID).y(270).uvlock())
                    .put("facing=north,half=bottom,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).y(180).uvlock())
                    .put("facing=north,half=bottom,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).y(270).uvlock())
                    .put("facing=north,half=bottom,shape=straight", new JBlockModel(MAIN_MODEL_ID).y(270).uvlock())
                    .put("facing=north,half=top,shape=inner_left", new JBlockModel(INNER_MODEL_ID).x(180).y(270).uvlock())
                    .put("facing=north,half=top,shape=inner_right", new JBlockModel(INNER_MODEL_ID).x(180).uvlock())
                    .put("facing=north,half=top,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).x(180).y(270).uvlock())
                    .put("facing=north,half=top,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).x(180).uvlock())
                    .put("facing=north,half=top,shape=straight", new JBlockModel(MAIN_MODEL_ID).x(180).y(270).uvlock())
                    .put("facing=south,half=bottom,shape=inner_left", new JBlockModel(INNER_MODEL_ID))
                    .put("facing=south,half=bottom,shape=inner_right", new JBlockModel(INNER_MODEL_ID).y(90).uvlock())
                    .put("facing=south,half=bottom,shape=outer_left", new JBlockModel(OUTER_MODEL_ID))
                    .put("facing=south,half=bottom,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).y(90).uvlock())
                    .put("facing=south,half=bottom,shape=straight", new JBlockModel(MAIN_MODEL_ID).y(90).uvlock())
                    .put("facing=south,half=top,shape=inner_left", new JBlockModel(INNER_MODEL_ID).x(180).y(90).uvlock())
                    .put("facing=south,half=top,shape=inner_right", new JBlockModel(INNER_MODEL_ID).x(180).y(180).uvlock())
                    .put("facing=south,half=top,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).x(180).y(90).uvlock())
                    .put("facing=south,half=top,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).x(180).y(180).uvlock())
                    .put("facing=south,half=top,shape=straight", new JBlockModel(MAIN_MODEL_ID).x(180).y(90).uvlock())
                    .put("facing=west,half=bottom,shape=inner_left", new JBlockModel(INNER_MODEL_ID).y(90).uvlock())
                    .put("facing=west,half=bottom,shape=inner_right", new JBlockModel(INNER_MODEL_ID).y(180).uvlock())
                    .put("facing=west,half=bottom,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).y(90).uvlock())
                    .put("facing=west,half=bottom,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).y(180).uvlock())
                    .put("facing=west,half=bottom,shape=straight", new JBlockModel(MAIN_MODEL_ID).y(180).uvlock())
                    .put("facing=west,half=top,shape=inner_left", new JBlockModel(INNER_MODEL_ID).x(180).y(180).uvlock())
                    .put("facing=west,half=top,shape=inner_right", new JBlockModel(INNER_MODEL_ID).x(180).y(270).uvlock())
                    .put("facing=west,half=top,shape=outer_left", new JBlockModel(OUTER_MODEL_ID).x(180).y(180).uvlock())
                    .put("facing=west,half=top,shape=outer_right", new JBlockModel(OUTER_MODEL_ID).x(180).y(270).uvlock())
                    .put("facing=west,half=top,shape=straight", new JBlockModel(MAIN_MODEL_ID).x(180).y(180).uvlock())
            ),
            BLOCK_ID
        );
    }
}
