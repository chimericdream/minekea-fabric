package com.chimericdream.minekea;

import com.chimericdream.minekea.block.barrels.Barrels;
import com.chimericdream.minekea.block.bookshelves.Bookshelves;
import com.chimericdream.minekea.block.crates.Crates;
import com.chimericdream.minekea.block.displaycases.DisplayCaseBlockEntityRenderer;
import com.chimericdream.minekea.block.displaycases.DisplayCases;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreen;
import com.chimericdream.minekea.screen.crate.CrateScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class MinekeaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(Bookshelves.STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);
        ScreenRegistry.register(Crates.CRATE_SCREEN_HANDLER, CrateScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getCutout(),
            DisplayCases.ACACIA_DISPLAY_CASE,
            DisplayCases.BIRCH_DISPLAY_CASE,
            DisplayCases.CRIMSON_DISPLAY_CASE,
            DisplayCases.DARK_OAK_DISPLAY_CASE,
            DisplayCases.JUNGLE_DISPLAY_CASE,
            DisplayCases.OAK_DISPLAY_CASE,
            DisplayCases.SPRUCE_DISPLAY_CASE,
            DisplayCases.WARPED_DISPLAY_CASE,
            DisplayCases.STRIPPED_ACACIA_DISPLAY_CASE,
            DisplayCases.STRIPPED_BIRCH_DISPLAY_CASE,
            DisplayCases.STRIPPED_CRIMSON_DISPLAY_CASE,
            DisplayCases.STRIPPED_DARK_OAK_DISPLAY_CASE,
            DisplayCases.STRIPPED_JUNGLE_DISPLAY_CASE,
            DisplayCases.STRIPPED_OAK_DISPLAY_CASE,
            DisplayCases.STRIPPED_SPRUCE_DISPLAY_CASE,
            DisplayCases.STRIPPED_WARPED_DISPLAY_CASE
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getTranslucent(),
            Blocks.BARREL,
            Barrels.ACACIA_BARREL,
            Barrels.BIRCH_BARREL,
            Barrels.CRIMSON_BARREL,
            Barrels.DARK_OAK_BARREL,
            Barrels.JUNGLE_BARREL,
            Barrels.SPRUCE_BARREL,
            Barrels.WARPED_BARREL
        );

        BlockEntityRendererRegistry.INSTANCE.register(DisplayCases.DISPLAY_CASE_BLOCK_ENTITY, DisplayCaseBlockEntityRenderer::new);

        for (ModCompatLayer mod : MinekeaMod.OTHER_MODS) {
            mod.initializeClient();
        }
    }
}
