package com.chimericdream.minekea.block.building.warped_nether_bricks;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.crops.WarpedWartItem;
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
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WarpedNetherBricksBlock extends Block implements MinekeaBlock {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "building/warped_nether_bricks");

    public WarpedNetherBricksBlock() {
        super(FabricBlockSettings.copyOf(Blocks.RED_NETHER_BRICKS));
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

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("AB", "BA"),
                JKeys.keys()
                    .key("A", JIngredient.ingredient().item(WarpedWartItem.ITEM_ID.toString()))
                    .key("B", JIngredient.ingredient().item("minecraft:nether_brick")),
                JResult.result(BLOCK_ID.toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/cube_all")
                .textures(new JTextures().var("all", Texture.getBlockTextureID(BLOCK_ID).toString())),
            MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant().put("", new JBlockModel(MODEL_ID))),
            BLOCK_ID
        );
    }
}
