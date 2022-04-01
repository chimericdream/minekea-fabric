package com.chimericdream.minekea;

import com.chimericdream.minekea.block.bookshelves.Bookshelves;
import com.chimericdream.minekea.block.crates.Crates;
import com.chimericdream.minekea.block.displaycases.DisplayCases;
import com.chimericdream.minekea.block.displaycases.entity.GenericDisplayCaseBlockEntityRenderer;
import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreen;
import com.chimericdream.minekea.screen.crate.CrateScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.minecraft.client.render.RenderLayer;

import static com.chimericdream.minekea.block.displaycases.DisplayCases.ACACIA_DISPLAY_CASE_BLOCK_ENTITY;

@Environment(EnvType.CLIENT)
public class MinekeaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(Bookshelves.ACACIA_STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);
        ScreenRegistry.register(Bookshelves.BIRCH_STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);
        ScreenRegistry.register(Bookshelves.CRIMSON_STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);
        ScreenRegistry.register(Bookshelves.DARK_OAK_STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);
        ScreenRegistry.register(Bookshelves.JUNGLE_STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);
        ScreenRegistry.register(Bookshelves.OAK_STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);
        ScreenRegistry.register(Bookshelves.SPRUCE_STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);
        ScreenRegistry.register(Bookshelves.WARPED_STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);

        ScreenRegistry.register(Crates.ACACIA_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.BIRCH_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.CRIMSON_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.DARK_OAK_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.JUNGLE_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.OAK_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.SPRUCE_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.WARPED_CRATE_SCREEN_HANDLER, CrateScreen::new);

        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.ACACIA_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.STRIPPED_ACACIA_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.BIRCH_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.STRIPPED_BIRCH_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.CRIMSON_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.STRIPPED_CRIMSON_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.DARK_OAK_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.STRIPPED_DARK_OAK_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.JUNGLE_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.STRIPPED_JUNGLE_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.OAK_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.STRIPPED_OAK_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.SPRUCE_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.STRIPPED_SPRUCE_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.WARPED_DISPLAY_CASE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(DisplayCases.STRIPPED_WARPED_DISPLAY_CASE, RenderLayer.getCutout());

        BlockEntityRendererRegistry.INSTANCE.register(ACACIA_DISPLAY_CASE_BLOCK_ENTITY, GenericDisplayCaseBlockEntityRenderer::new);
    }
}
