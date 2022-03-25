package com.chimericdream.shelfstorage.block.bookshelf;

import com.chimericdream.shelfstorage.screen.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.registry.Registry;

public class Bookshelves {
    public static final AbstractBookshelf ACACIA_BOOKSHELF;
    public static final AbstractStorageShelf ACACIA_STORAGE_SHELF;
    public static final AbstractBookshelf BIRCH_BOOKSHELF;
    public static final AbstractStorageShelf BIRCH_STORAGE_SHELF;
    public static final AbstractBookshelf CRIMSON_BOOKSHELF;
    public static final AbstractStorageShelf CRIMSON_STORAGE_SHELF;
    public static final AbstractBookshelf DARK_OAK_BOOKSHELF;
    public static final AbstractStorageShelf DARK_OAK_STORAGE_SHELF;
    public static final AbstractBookshelf JUNGLE_BOOKSHELF;
    public static final AbstractStorageShelf JUNGLE_STORAGE_SHELF;
    public static final AbstractStorageShelf OAK_STORAGE_SHELF;
    public static final AbstractBookshelf SPRUCE_BOOKSHELF;
    public static final AbstractStorageShelf SPRUCE_STORAGE_SHELF;
    public static final AbstractBookshelf WARPED_BOOKSHELF;
    public static final AbstractStorageShelf WARPED_STORAGE_SHELF;

    public static BlockEntityType<AcaciaStorageShelfBlockEntity> ACACIA_STORAGE_SHELF_BLOCK_ENTITY;
    public static ScreenHandlerType<AcaciaStorageShelfScreenHandler> ACACIA_STORAGE_SHELF_SCREEN_HANDLER;
    public static BlockEntityType<BirchStorageShelfBlockEntity> BIRCH_STORAGE_SHELF_BLOCK_ENTITY;
    public static ScreenHandlerType<BirchStorageShelfScreenHandler> BIRCH_STORAGE_SHELF_SCREEN_HANDLER;
    public static BlockEntityType<CrimsonStorageShelfBlockEntity> CRIMSON_STORAGE_SHELF_BLOCK_ENTITY;
    public static ScreenHandlerType<CrimsonStorageShelfScreenHandler> CRIMSON_STORAGE_SHELF_SCREEN_HANDLER;
    public static BlockEntityType<DarkOakStorageShelfBlockEntity> DARK_OAK_STORAGE_SHELF_BLOCK_ENTITY;
    public static ScreenHandlerType<DarkOakStorageShelfScreenHandler> DARK_OAK_STORAGE_SHELF_SCREEN_HANDLER;
    public static BlockEntityType<JungleStorageShelfBlockEntity> JUNGLE_STORAGE_SHELF_BLOCK_ENTITY;
    public static ScreenHandlerType<JungleStorageShelfScreenHandler> JUNGLE_STORAGE_SHELF_SCREEN_HANDLER;
    public static BlockEntityType<OakStorageShelfBlockEntity> OAK_STORAGE_SHELF_BLOCK_ENTITY;
    public static ScreenHandlerType<OakStorageShelfScreenHandler> OAK_STORAGE_SHELF_SCREEN_HANDLER;
    public static BlockEntityType<SpruceStorageShelfBlockEntity> SPRUCE_STORAGE_SHELF_BLOCK_ENTITY;
    public static ScreenHandlerType<SpruceStorageShelfScreenHandler> SPRUCE_STORAGE_SHELF_SCREEN_HANDLER;
    public static BlockEntityType<WarpedStorageShelfBlockEntity> WARPED_STORAGE_SHELF_BLOCK_ENTITY;
    public static ScreenHandlerType<WarpedStorageShelfScreenHandler> WARPED_STORAGE_SHELF_SCREEN_HANDLER;

    static {
        ACACIA_BOOKSHELF = new AcaciaBookshelf();
        ACACIA_STORAGE_SHELF = new AcaciaStorageShelf();
        BIRCH_BOOKSHELF = new BirchBookshelf();
        BIRCH_STORAGE_SHELF = new BirchStorageShelf();
        CRIMSON_BOOKSHELF = new CrimsonBookshelf();
        CRIMSON_STORAGE_SHELF = new CrimsonStorageShelf();
        DARK_OAK_BOOKSHELF = new DarkOakBookshelf();
        DARK_OAK_STORAGE_SHELF = new DarkOakStorageShelf();
        JUNGLE_BOOKSHELF = new JungleBookshelf();
        JUNGLE_STORAGE_SHELF = new JungleStorageShelf();
        OAK_STORAGE_SHELF = new OakStorageShelf();
        SPRUCE_BOOKSHELF = new SpruceBookshelf();
        SPRUCE_STORAGE_SHELF = new SpruceStorageShelf();
        WARPED_BOOKSHELF = new WarpedBookshelf();
        WARPED_STORAGE_SHELF = new WarpedStorageShelf();

        ACACIA_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(AcaciaStorageShelf.BLOCK_ID, AcaciaStorageShelfScreenHandler::new);
        BIRCH_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(BirchStorageShelf.BLOCK_ID, BirchStorageShelfScreenHandler::new);
        CRIMSON_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(CrimsonStorageShelf.BLOCK_ID, CrimsonStorageShelfScreenHandler::new);
        DARK_OAK_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(DarkOakStorageShelf.BLOCK_ID, DarkOakStorageShelfScreenHandler::new);
        OAK_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(OakStorageShelf.BLOCK_ID, OakStorageShelfScreenHandler::new);
        JUNGLE_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(JungleStorageShelf.BLOCK_ID, JungleStorageShelfScreenHandler::new);
        SPRUCE_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(SpruceStorageShelf.BLOCK_ID, SpruceStorageShelfScreenHandler::new);
        WARPED_STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(WarpedStorageShelf.BLOCK_ID, WarpedStorageShelfScreenHandler::new);
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

        ACACIA_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:acacia_storage_shelf_block_entity",
            FabricBlockEntityTypeBuilder.create(AcaciaStorageShelfBlockEntity::new, ACACIA_STORAGE_SHELF).build(null)
        );
        BIRCH_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:birch_storage_shelf_block_entity",
            FabricBlockEntityTypeBuilder.create(BirchStorageShelfBlockEntity::new, BIRCH_STORAGE_SHELF).build(null)
        );
        CRIMSON_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:crimson_storage_shelf_block_entity",
            FabricBlockEntityTypeBuilder.create(CrimsonStorageShelfBlockEntity::new, CRIMSON_STORAGE_SHELF).build(null)
        );
        DARK_OAK_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:dark_oak_storage_shelf_block_entity",
            FabricBlockEntityTypeBuilder.create(DarkOakStorageShelfBlockEntity::new, DARK_OAK_STORAGE_SHELF).build(null)
        );
        JUNGLE_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:jungle_storage_shelf_block_entity",
            FabricBlockEntityTypeBuilder.create(JungleStorageShelfBlockEntity::new, JUNGLE_STORAGE_SHELF).build(null)
        );
        OAK_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:oak_storage_shelf_block_entity",
            FabricBlockEntityTypeBuilder.create(OakStorageShelfBlockEntity::new, OAK_STORAGE_SHELF).build(null)
        );
        SPRUCE_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:spruce_storage_shelf_block_entity",
            FabricBlockEntityTypeBuilder.create(SpruceStorageShelfBlockEntity::new, SPRUCE_STORAGE_SHELF).build(null)
        );
        WARPED_STORAGE_SHELF_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            "shelfstorage:warped_storage_shelf_block_entity",
            FabricBlockEntityTypeBuilder.create(WarpedStorageShelfBlockEntity::new, WARPED_STORAGE_SHELF).build(null)
        );
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
