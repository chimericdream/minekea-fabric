package com.chimericdream.minekea.crops;

import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroups;

public class Crops implements MinekeaBlockCategory {
    public static final WarpedWartPlantBlock WARPED_WART_PLANT_BLOCK;
    public static final WarpedWartItem WARPED_WART_ITEM;

    static {
        WARPED_WART_PLANT_BLOCK = new WarpedWartPlantBlock(AbstractBlock.Settings.copy(Blocks.NETHER_WART));
        WARPED_WART_ITEM = new WarpedWartItem();
    }

    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), WARPED_WART_PLANT_BLOCK);
    }

    @Override
    public void registerBlocks() {
        WARPED_WART_PLANT_BLOCK.register();
        WARPED_WART_ITEM.register();

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
            .register((itemGroup) -> {
                itemGroup.add(WARPED_WART_ITEM);
            });
    }

    @Override
    public void registerBlockEntities() {
    }

    @Override
    public void registerEntities() {
    }

    @Override
    public void setupResources() {
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            Identifier.of(ModInfo.MOD_ID, "items/nether_wart_from_block"),
//            JRecipe.shapeless(
//                JIngredients.ingredients().add(JIngredient.ingredient().item("minecraft:nether_wart_block")),
//                JResult.stackedResult("minecraft:nether_wart", 9)
//            )
//        );
    }
}
