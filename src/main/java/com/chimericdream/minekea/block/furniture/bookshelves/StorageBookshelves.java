package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.minekea.block.furniture.bookshelves.GenericStorageBookshelf.StorageBookshelfSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.entities.blocks.StorageBookshelfBlockEntity;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreen;
import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreenHandler;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StorageBookshelves implements MinekeaBlockCategory {
    public static final Map<String, GenericStorageBookshelf> STORAGE_BOOKSHELVES = new LinkedHashMap<>();

    public static BlockEntityType<StorageBookshelfBlockEntity> STORAGE_SHELF_BLOCK_ENTITY;
    public static ScreenHandlerType<StorageBookshelfScreenHandler> STORAGE_SHELF_SCREEN_HANDLER;

    static {
        for (MinekeaBlockSettings.DefaultSettings blockSettings : BaseBlockSettings.ALL_SETTINGS) {
            if (blockSettings.hasStorageBookshelf()) {
                STORAGE_BOOKSHELVES.put(blockSettings.getMainMaterial(), new GenericStorageBookshelf(new StorageBookshelfSettings(blockSettings).addMaterial("bookshelf", blockSettings.getBookshelfId())));
            }
        }

        STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(
            StorageBookshelfScreenHandler.SCREEN_ID,
            (syncId, inventory) -> new StorageBookshelfScreenHandler(STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory)
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        ScreenRegistry.register(STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);
    }

    @Override
    public void registerBlocks() {
        for (GenericStorageBookshelf block : STORAGE_BOOKSHELVES.values()) {
            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
            block.register(settings.isFlammable());
        }
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        List<GenericStorageBookshelf> storageShelves = new ArrayList<>(STORAGE_BOOKSHELVES.values());

        for (ModCompatLayer mod : otherMods) {
            storageShelves.addAll(mod.getStorageShelves());
        }

        STORAGE_SHELF_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            StorageBookshelfBlockEntity.ENTITY_ID,
            FabricBlockEntityTypeBuilder.create(
                StorageBookshelfBlockEntity::new,
                storageShelves.toArray(new Block[0])
            ).build(null)
        );
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.entry(StorageBookshelfScreenHandler.SCREEN_ID.toString(), "Storage Bookshelf");
    }
}
