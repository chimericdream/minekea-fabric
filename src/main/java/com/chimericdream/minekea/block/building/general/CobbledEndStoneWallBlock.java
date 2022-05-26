package com.chimericdream.minekea.block.building.general;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.blockstate.JWhen;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class CobbledEndStoneWallBlock extends WallBlock implements MinekeaBlock {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "building/cobbled_end_stone_wall");

    public CobbledEndStoneWallBlock() {
        super(FabricBlockSettings.copyOf(Blocks.END_STONE_BRICK_WALL));
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
        Identifier BASE_MODEL_ID = Model.getBlockModelID(BLOCK_ID);
        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);

        Identifier INVENTORY_MODEL_ID = new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_inventory");
        Identifier POST_MODEL_ID = new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_post");
        Identifier SIDE_MODEL_ID = new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_side");
        Identifier SIDE_TALL_MODEL_ID = new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_side_tall");

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("###", "###"),
                JKeys.keys()
                    .key("#", JIngredient.ingredient().item(CobbledEndStoneBlock.BLOCK_ID.toString())),
                JResult.stackedResult(BLOCK_ID.toString(), 6)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        JTextures textures = new JTextures().var("wall", Texture.getBlockTextureID(CobbledEndStoneBlock.BLOCK_ID).toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/wall_inventory").textures(textures),
            INVENTORY_MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/template_wall_post").textures(textures),
            POST_MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/template_wall_side").textures(textures),
            SIDE_MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/template_wall_side_tall").textures(textures),
            SIDE_TALL_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(INVENTORY_MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.multipart(new JBlockModel(POST_MODEL_ID))
                    .when(new JWhen().add("up", "true")),
                JState.multipart(new JBlockModel(SIDE_MODEL_ID).uvlock())
                    .when(new JWhen().add("north", "low")),
                JState.multipart(new JBlockModel(SIDE_MODEL_ID).y(90).uvlock())
                    .when(new JWhen().add("east", "low")),
                JState.multipart(new JBlockModel(SIDE_MODEL_ID).y(180).uvlock())
                    .when(new JWhen().add("south", "low")),
                JState.multipart(new JBlockModel(SIDE_MODEL_ID).y(270).uvlock())
                    .when(new JWhen().add("west", "low")),
                JState.multipart(new JBlockModel(SIDE_TALL_MODEL_ID).uvlock())
                    .when(new JWhen().add("north", "tall")),
                JState.multipart(new JBlockModel(SIDE_TALL_MODEL_ID).y(90).uvlock())
                    .when(new JWhen().add("east", "tall")),
                JState.multipart(new JBlockModel(SIDE_TALL_MODEL_ID).y(180).uvlock())
                    .when(new JWhen().add("south", "tall")),
                JState.multipart(new JBlockModel(SIDE_TALL_MODEL_ID).y(270).uvlock())
                    .when(new JWhen().add("west", "tall"))
            ),
            BLOCK_ID
        );
    }
}
