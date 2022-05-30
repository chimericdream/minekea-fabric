package com.chimericdream.minekea.block.decorations.lighting;

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
import net.minecraft.block.LanternBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DoomLantern extends LanternBlock implements MinekeaBlock {
    private final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "decorations/lighting/doom_lantern");

    public DoomLantern() {
        super(FabricBlockSettings.copyOf(Blocks.LANTERN));
    }

    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        setupResources();
    }

    public void setupResources() {
        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("###", "#F#", "#T#"),
                JKeys.keys()
                    .key("#", JIngredient.ingredient().item(Items.IRON_NUGGET))
                    .key("F", JIngredient.ingredient().item(Items.CRIMSON_FUNGUS))
                    .key("T", JIngredient.ingredient().item(Items.TORCH)),
                JResult.result(BLOCK_ID.toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        Identifier MODEL_ID = Model.getBlockModelID(BLOCK_ID);
        Identifier HANGING_MODEL_ID = new Identifier(MODEL_ID.getNamespace(), MODEL_ID.getPath() + "_hanging");
        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);

        // Models
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/template_lantern")
                .textures(new JTextures().var("lantern", Texture.getBlockTextureID(BLOCK_ID).toString())),
            MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/template_hanging_lantern")
                .textures(new JTextures().var("lantern", Texture.getBlockTextureID(BLOCK_ID).toString())),
            HANGING_MODEL_ID
        );

        // Item model
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:item/generated")
                .textures(new JTextures().layer0(Texture.getItemTextureID(BLOCK_ID).toString())),
            ITEM_MODEL_ID
        );

        // Blockstate
        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("hanging=false", new JBlockModel(MODEL_ID))
                    .put("hanging=true", new JBlockModel(HANGING_MODEL_ID))
            ),
            BLOCK_ID
        );
    }
}
