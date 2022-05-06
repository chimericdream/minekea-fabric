package com.chimericdream.minekea.block.storage;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

public class CompressedDyeBlock extends GenericStorageBlock {
    private final String color;

    public CompressedDyeBlock(Identifier baseBlock, String color) {
        super(
            FabricBlockSettings.copyOf(Blocks.HONEY_BLOCK),
            new Identifier(ModInfo.MOD_ID, "storage/dyes/compressed_" + baseBlock.getPath()),
            baseBlock
        );
        this.color = color;
    }

    @Override
    public void setupResources() {
        Identifier MODEL_ID = Model.getBlockModelID(BLOCK_ID);
        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);

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

        JTextures textures = new JTextures()
            .var("bottom", String.format("%s:block/storage/dyes/%s/bottom", ModInfo.MOD_ID, color))
            .var("side", String.format("%s:block/storage/dyes/%s/side", ModInfo.MOD_ID, color))
            .var("top", String.format("%s:block/storage/dyes/%s/top", ModInfo.MOD_ID, color));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(String.format("%s:block/storage/compressed_dye_block", ModInfo.MOD_ID)).textures(textures), MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant().put("", new JBlockModel(MODEL_ID))),
            BLOCK_ID
        );
    }
}
