package com.chimericdream.shelfstorage;

import com.chimericdream.shelfstorage.block.bookshelf.Bookshelves;
import com.chimericdream.shelfstorage.block.crate.Crates;
import com.chimericdream.shelfstorage.screen.*;
import com.chimericdream.shelfstorage.screen.crate.CrateScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class ShelfStorageClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(Bookshelves.ACACIA_STORAGE_SHELF_SCREEN_HANDLER, AcaciaStorageShelfScreen::new);
        ScreenRegistry.register(Bookshelves.BIRCH_STORAGE_SHELF_SCREEN_HANDLER, BirchStorageShelfScreen::new);
        ScreenRegistry.register(Bookshelves.CRIMSON_STORAGE_SHELF_SCREEN_HANDLER, CrimsonStorageShelfScreen::new);
        ScreenRegistry.register(Bookshelves.DARK_OAK_STORAGE_SHELF_SCREEN_HANDLER, DarkOakStorageShelfScreen::new);
        ScreenRegistry.register(Bookshelves.JUNGLE_STORAGE_SHELF_SCREEN_HANDLER, JungleStorageShelfScreen::new);
        ScreenRegistry.register(Bookshelves.OAK_STORAGE_SHELF_SCREEN_HANDLER, OakStorageShelfScreen::new);
        ScreenRegistry.register(Bookshelves.SPRUCE_STORAGE_SHELF_SCREEN_HANDLER, SpruceStorageShelfScreen::new);
        ScreenRegistry.register(Bookshelves.WARPED_STORAGE_SHELF_SCREEN_HANDLER, WarpedStorageShelfScreen::new);

        ScreenRegistry.register(Crates.ACACIA_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.BIRCH_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.CRIMSON_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.DARK_OAK_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.JUNGLE_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.OAK_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.SPRUCE_CRATE_SCREEN_HANDLER, CrateScreen::new);
        ScreenRegistry.register(Crates.WARPED_CRATE_SCREEN_HANDLER, CrateScreen::new);
        // BlockRenderLayerMap.INSTANCE.putBlock(ShelfStorageMod.IRON_SHELF, RenderLayer.getCutout());
    }
}
