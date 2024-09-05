//package com.chimericdream.minekea.block.furniture.bookshelves;
//
//import com.chimericdream.minekea.block.furniture.bookshelves.GenericStorageBookshelf.StorageBookshelfSettings;
//import com.chimericdream.minekea.entities.blocks.StorageBookshelfBlockEntity;
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreen;
//import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreenHandler;
//import com.chimericdream.minekea.settings.BaseBlockSettings;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings;
//import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
//import com.chimericdream.minekea.util.MinekeaBlockCategory;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
//import net.minecraft.block.Block;
//import net.minecraft.block.entity.BlockEntityType;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.screen.ScreenHandlerType;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class StorageBookshelves implements MinekeaBlockCategory {
//    public static final Map<String, GenericStorageBookshelf> STORAGE_BOOKSHELVES = new LinkedHashMap<>();
//
//    public static BlockEntityType<StorageBookshelfBlockEntity> STORAGE_SHELF_BLOCK_ENTITY;
//    public static ScreenHandlerType<StorageBookshelfScreenHandler> STORAGE_SHELF_SCREEN_HANDLER;
//
//    static {
//        for (DefaultSettings settings : BaseBlockSettings.ALL_SETTINGS) {
//            if (settings.hasStorageBookshelf()) {
//                STORAGE_BOOKSHELVES.put(settings.getMainMaterial(), new GenericStorageBookshelf(new StorageBookshelfSettings(settings).addMaterial("bookshelf", settings.getBookshelfId())));
//            }
//        }
//
//        STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(
//            StorageBookshelfScreenHandler.SCREEN_ID,
//            (syncId, inventory) -> new StorageBookshelfScreenHandler(STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory)
//        );
//    }
//
//    @Environment(EnvType.CLIENT)
//    @Override
//    public void initializeClient() {
//        ScreenRegistry.register(STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);
//    }
//
//    @Override
//    public void registerBlocks() {
//        for (GenericStorageBookshelf block : STORAGE_BOOKSHELVES.values()) {
//            MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) block.settings;
//            block.register(settings.isFlammable());
//        }
//    }
//
//    @Override
//    public void registerBlockEntities() {
//        List<GenericStorageBookshelf> storageShelves = new ArrayList<>(STORAGE_BOOKSHELVES.values());
//
//        STORAGE_SHELF_BLOCK_ENTITY = Registry.register(
//            Registries.BLOCK_ENTITY_TYPE,
//            StorageBookshelfBlockEntity.ENTITY_ID,
//            FabricBlockEntityTypeBuilder.create(
//                StorageBookshelfBlockEntity::new,
//                storageShelves.toArray(new Block[0])
//            ).build(null)
//        );
//    }
//
//    @Override
//    public void registerEntities() {
//    }
//
//    @Override
//    public void setupResources() {
//        MinekeaResourcePack.EN_US.entry(StorageBookshelfScreenHandler.SCREEN_ID.toString(), "Storage Bookshelf");
//    }
//}
