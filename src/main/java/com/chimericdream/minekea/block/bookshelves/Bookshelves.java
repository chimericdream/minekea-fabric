package com.chimericdream.minekea.block.bookshelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.bookshelves.storage.*;
import com.chimericdream.minekea.block.bookshelves.storage.entity.*;
import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreenHandler;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Bookshelves {
    public static final AbstractBookshelf ACACIA_BOOKSHELF;
    public static final GenericStorageBookshelf ACACIA_STORAGE_SHELF;
    public static final AbstractBookshelf BIRCH_BOOKSHELF;
    public static final GenericStorageBookshelf BIRCH_STORAGE_SHELF;
    public static final AbstractBookshelf CRIMSON_BOOKSHELF;
    public static final GenericStorageBookshelf CRIMSON_STORAGE_SHELF;
    public static final AbstractBookshelf DARK_OAK_BOOKSHELF;
    public static final GenericStorageBookshelf DARK_OAK_STORAGE_SHELF;
    public static final AbstractBookshelf JUNGLE_BOOKSHELF;
    public static final GenericStorageBookshelf JUNGLE_STORAGE_SHELF;
    public static final GenericStorageBookshelf OAK_STORAGE_SHELF;
    public static final AbstractBookshelf SPRUCE_BOOKSHELF;
    public static final GenericStorageBookshelf SPRUCE_STORAGE_SHELF;
    public static final AbstractBookshelf WARPED_BOOKSHELF;
    public static final GenericStorageBookshelf WARPED_STORAGE_SHELF;

    public static BlockEntityType<AcaciaStorageBookshelfBlockEntity> ACACIA_STORAGE_SHELF_BLOCK_ENTITY;
    public static BlockEntityType<BirchStorageBookshelfBlockEntity> BIRCH_STORAGE_SHELF_BLOCK_ENTITY;
    public static BlockEntityType<CrimsonStorageBookshelfBlockEntity> CRIMSON_STORAGE_SHELF_BLOCK_ENTITY;
    public static BlockEntityType<DarkOakStorageBookshelfBlockEntity> DARK_OAK_STORAGE_SHELF_BLOCK_ENTITY;
    public static BlockEntityType<JungleStorageBookshelfBlockEntity> JUNGLE_STORAGE_SHELF_BLOCK_ENTITY;
    public static BlockEntityType<OakStorageBookshelfBlockEntity> OAK_STORAGE_SHELF_BLOCK_ENTITY;
    public static BlockEntityType<SpruceStorageBookshelfBlockEntity> SPRUCE_STORAGE_SHELF_BLOCK_ENTITY;
    public static BlockEntityType<WarpedStorageBookshelfBlockEntity> WARPED_STORAGE_SHELF_BLOCK_ENTITY;

    public static ScreenHandlerType<StorageBookshelfScreenHandler> ACACIA_STORAGE_SHELF_SCREEN_HANDLER;
    public static ScreenHandlerType<StorageBookshelfScreenHandler> BIRCH_STORAGE_SHELF_SCREEN_HANDLER;
    public static ScreenHandlerType<StorageBookshelfScreenHandler> CRIMSON_STORAGE_SHELF_SCREEN_HANDLER;
    public static ScreenHandlerType<StorageBookshelfScreenHandler> DARK_OAK_STORAGE_SHELF_SCREEN_HANDLER;
    public static ScreenHandlerType<StorageBookshelfScreenHandler> JUNGLE_STORAGE_SHELF_SCREEN_HANDLER;
    public static ScreenHandlerType<StorageBookshelfScreenHandler> OAK_STORAGE_SHELF_SCREEN_HANDLER;
    public static ScreenHandlerType<StorageBookshelfScreenHandler> SPRUCE_STORAGE_SHELF_SCREEN_HANDLER;
    public static ScreenHandlerType<StorageBookshelfScreenHandler> WARPED_STORAGE_SHELF_SCREEN_HANDLER;

    static {
        ACACIA_BOOKSHELF = new AcaciaBookshelf();
        ACACIA_STORAGE_SHELF = new AcaciaStorageBookshelf();
        BIRCH_BOOKSHELF = new BirchBookshelf();
        BIRCH_STORAGE_SHELF = new BirchStorageBookshelf();
        CRIMSON_BOOKSHELF = new CrimsonBookshelf();
        CRIMSON_STORAGE_SHELF = new CrimsonStorageBookshelf();
        DARK_OAK_BOOKSHELF = new DarkOakBookshelf();
        DARK_OAK_STORAGE_SHELF = new DarkOakStorageBookshelf();
        JUNGLE_BOOKSHELF = new JungleBookshelf();
        JUNGLE_STORAGE_SHELF = new JungleStorageBookshelf();
        OAK_STORAGE_SHELF = new OakStorageBookshelf();
        SPRUCE_BOOKSHELF = new SpruceBookshelf();
        SPRUCE_STORAGE_SHELF = new SpruceStorageBookshelf();
        WARPED_BOOKSHELF = new WarpedBookshelf();
        WARPED_STORAGE_SHELF = new WarpedStorageBookshelf();

        ACACIA_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(AcaciaStorageBookshelf.BLOCK_ID, (syncId, inventory) -> new StorageBookshelfScreenHandler(ACACIA_STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory));
        BIRCH_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(BirchStorageBookshelf.BLOCK_ID, (syncId, inventory) -> new StorageBookshelfScreenHandler(BIRCH_STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory));
        CRIMSON_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(CrimsonStorageBookshelf.BLOCK_ID, (syncId, inventory) -> new StorageBookshelfScreenHandler(CRIMSON_STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory));
        DARK_OAK_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(DarkOakStorageBookshelf.BLOCK_ID, (syncId, inventory) -> new StorageBookshelfScreenHandler(DARK_OAK_STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory));
        OAK_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(OakStorageBookshelf.BLOCK_ID, (syncId, inventory) -> new StorageBookshelfScreenHandler(OAK_STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory));
        JUNGLE_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(JungleStorageBookshelf.BLOCK_ID, (syncId, inventory) -> new StorageBookshelfScreenHandler(JUNGLE_STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory));
        SPRUCE_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(SpruceStorageBookshelf.BLOCK_ID, (syncId, inventory) -> new StorageBookshelfScreenHandler(SPRUCE_STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory));
        WARPED_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(WarpedStorageBookshelf.BLOCK_ID, (syncId, inventory) -> new StorageBookshelfScreenHandler(WARPED_STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory));
    }

    public void register() {
        ACACIA_BOOKSHELF.register();
        ACACIA_STORAGE_SHELF.register();
        BIRCH_BOOKSHELF.register();
        BIRCH_STORAGE_SHELF.register();
        CRIMSON_BOOKSHELF.register();
        CRIMSON_STORAGE_SHELF.register();
        DARK_OAK_BOOKSHELF.register();
        DARK_OAK_STORAGE_SHELF.register();
        JUNGLE_BOOKSHELF.register();
        JUNGLE_STORAGE_SHELF.register();
        OAK_STORAGE_SHELF.register();
        SPRUCE_BOOKSHELF.register();
        SPRUCE_STORAGE_SHELF.register();
        WARPED_BOOKSHELF.register();
        WARPED_STORAGE_SHELF.register();

        ACACIA_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ModInfo.MOD_ID, "bookshelves/storage/acacia_storage_shelf_block_entity"), FabricBlockEntityTypeBuilder.create(AcaciaStorageBookshelfBlockEntity::new, ACACIA_STORAGE_SHELF).build(null));
        BIRCH_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ModInfo.MOD_ID, "bookshelves/storage/birch_storage_shelf_block_entity"), FabricBlockEntityTypeBuilder.create(BirchStorageBookshelfBlockEntity::new, BIRCH_STORAGE_SHELF).build(null));
        CRIMSON_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ModInfo.MOD_ID, "bookshelves/storage/crimson_storage_shelf_block_entity"), FabricBlockEntityTypeBuilder.create(CrimsonStorageBookshelfBlockEntity::new, CRIMSON_STORAGE_SHELF).build(null));
        DARK_OAK_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ModInfo.MOD_ID, "bookshelves/storage/dark_oak_storage_shelf_block_entity"), FabricBlockEntityTypeBuilder.create(DarkOakStorageBookshelfBlockEntity::new, DARK_OAK_STORAGE_SHELF).build(null));
        JUNGLE_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ModInfo.MOD_ID, "bookshelves/storage/jungle_storage_shelf_block_entity"), FabricBlockEntityTypeBuilder.create(JungleStorageBookshelfBlockEntity::new, JUNGLE_STORAGE_SHELF).build(null));
        OAK_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ModInfo.MOD_ID, "bookshelves/storage/oak_storage_shelf_block_entity"), FabricBlockEntityTypeBuilder.create(OakStorageBookshelfBlockEntity::new, OAK_STORAGE_SHELF).build(null));
        SPRUCE_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ModInfo.MOD_ID, "bookshelves/storage/spruce_storage_shelf_block_entity"), FabricBlockEntityTypeBuilder.create(SpruceStorageBookshelfBlockEntity::new, SPRUCE_STORAGE_SHELF).build(null));
        WARPED_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ModInfo.MOD_ID, "bookshelves/storage/warped_storage_shelf_block_entity"), FabricBlockEntityTypeBuilder.create(WarpedStorageBookshelfBlockEntity::new, WARPED_STORAGE_SHELF).build(null));
    }

    public static Block[] getShelvesForEnchanting() {
        return new Block[]{
            ACACIA_BOOKSHELF,
            ACACIA_STORAGE_SHELF,
            BIRCH_BOOKSHELF,
            BIRCH_STORAGE_SHELF,
            CRIMSON_BOOKSHELF,
            CRIMSON_STORAGE_SHELF,
            DARK_OAK_BOOKSHELF,
            DARK_OAK_STORAGE_SHELF,
            JUNGLE_BOOKSHELF,
            JUNGLE_STORAGE_SHELF,
            OAK_STORAGE_SHELF,
            SPRUCE_BOOKSHELF,
            SPRUCE_STORAGE_SHELF,
            WARPED_BOOKSHELF,
            WARPED_STORAGE_SHELF,
        };
    }
}
