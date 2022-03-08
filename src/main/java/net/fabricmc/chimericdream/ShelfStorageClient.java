package net.fabricmc.chimericdream;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.chimericdream.block.bookshelf.Bookshelves;
import net.fabricmc.chimericdream.screen.*;
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
    }
}
