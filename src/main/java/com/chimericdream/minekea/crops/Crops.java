package com.chimericdream.minekea.crops;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.devtech.arrp.json.recipe.JIngredient;
import net.devtech.arrp.json.recipe.JIngredients;
import net.devtech.arrp.json.recipe.JRecipe;
import net.devtech.arrp.json.recipe.JResult;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

import java.util.List;

public class Crops implements MinekeaBlockCategory {
    public static final WarpedWartBlock WARPED_WART_BLOCK;
    public static final WarpedWartItem WARPED_WART_ITEM;

    static {
        WARPED_WART_BLOCK = new WarpedWartBlock();
        WARPED_WART_ITEM = new WarpedWartItem();
    }

    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), WARPED_WART_BLOCK);
    }

    @Override
    public void registerBlocks() {
        WARPED_WART_BLOCK.register();
        WARPED_WART_ITEM.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            new Identifier(ModInfo.MOD_ID, "items/nether_wart_from_block"),
            JRecipe.shapeless(
                JIngredients.ingredients().add(JIngredient.ingredient().item("minecraft:nether_wart_block")),
                JResult.stackedResult("minecraft:nether_wart", 9)
            )
        );
    }
}
