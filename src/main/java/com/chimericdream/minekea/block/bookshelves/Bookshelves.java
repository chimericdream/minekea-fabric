package com.chimericdream.minekea.block.bookshelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.bookshelves.storage.GenericStorageBookshelf;
import com.chimericdream.minekea.block.bookshelves.storage.StorageBookshelfBlockEntity;
import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreenHandler;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Bookshelves {
    public static final GenericBookshelf ACACIA_BOOKSHELF;
    public static final GenericStorageBookshelf ACACIA_STORAGE_SHELF;
    public static final GenericBookshelf BIRCH_BOOKSHELF;
    public static final GenericStorageBookshelf BIRCH_STORAGE_SHELF;
    public static final GenericBookshelf CRIMSON_BOOKSHELF;
    public static final GenericStorageBookshelf CRIMSON_STORAGE_SHELF;
    public static final GenericBookshelf DARK_OAK_BOOKSHELF;
    public static final GenericStorageBookshelf DARK_OAK_STORAGE_SHELF;
    public static final GenericBookshelf JUNGLE_BOOKSHELF;
    public static final GenericStorageBookshelf JUNGLE_STORAGE_SHELF;
    public static final GenericStorageBookshelf OAK_STORAGE_SHELF;
    public static final GenericBookshelf SPRUCE_BOOKSHELF;
    public static final GenericStorageBookshelf SPRUCE_STORAGE_SHELF;
    public static final GenericBookshelf WARPED_BOOKSHELF;
    public static final GenericStorageBookshelf WARPED_STORAGE_SHELF;

    public static BlockEntityType<StorageBookshelfBlockEntity> STORAGE_SHELF_BLOCK_ENTITY;
    public static ScreenHandlerType<StorageBookshelfScreenHandler> STORAGE_SHELF_SCREEN_HANDLER;

    static {
        ACACIA_BOOKSHELF = new GenericBookshelf("acacia");
        ACACIA_STORAGE_SHELF = new GenericStorageBookshelf("acacia");
        BIRCH_BOOKSHELF = new GenericBookshelf("birch");
        BIRCH_STORAGE_SHELF = new GenericStorageBookshelf("birch");
        CRIMSON_BOOKSHELF = new GenericBookshelf("crimson");
        CRIMSON_STORAGE_SHELF = new GenericStorageBookshelf("crimson");
        DARK_OAK_BOOKSHELF = new GenericBookshelf("dark_oak");
        DARK_OAK_STORAGE_SHELF = new GenericStorageBookshelf("dark_oak");
        JUNGLE_BOOKSHELF = new GenericBookshelf("jungle");
        JUNGLE_STORAGE_SHELF = new GenericStorageBookshelf("jungle");
        OAK_STORAGE_SHELF = new GenericStorageBookshelf("oak");
        SPRUCE_BOOKSHELF = new GenericBookshelf("spruce");
        SPRUCE_STORAGE_SHELF = new GenericStorageBookshelf("spruce");
        WARPED_BOOKSHELF = new GenericBookshelf("warped");
        WARPED_STORAGE_SHELF = new GenericStorageBookshelf("warped");

        STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(
            new Identifier(ModInfo.MOD_ID, "screens/storage_shelf"),
            (syncId, inventory) -> new StorageBookshelfScreenHandler(STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory)
        );
    }

    public void register() {
        ACACIA_BOOKSHELF.register();
        ACACIA_STORAGE_SHELF.register();
        BIRCH_BOOKSHELF.register();
        BIRCH_STORAGE_SHELF.register();
        CRIMSON_BOOKSHELF.register(false);
        CRIMSON_STORAGE_SHELF.register();
        DARK_OAK_BOOKSHELF.register();
        DARK_OAK_STORAGE_SHELF.register();
        JUNGLE_BOOKSHELF.register();
        JUNGLE_STORAGE_SHELF.register();
        OAK_STORAGE_SHELF.register();
        SPRUCE_BOOKSHELF.register();
        SPRUCE_STORAGE_SHELF.register();
        WARPED_BOOKSHELF.register(false);
        WARPED_STORAGE_SHELF.register();

        STORAGE_SHELF_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "bookshelves/storage/storage_shelf_block_entity"),
            FabricBlockEntityTypeBuilder.create(
                StorageBookshelfBlockEntity::new,
                ACACIA_STORAGE_SHELF,
                BIRCH_STORAGE_SHELF,
                CRIMSON_STORAGE_SHELF,
                DARK_OAK_STORAGE_SHELF,
                JUNGLE_STORAGE_SHELF,
                OAK_STORAGE_SHELF,
                SPRUCE_STORAGE_SHELF,
                WARPED_STORAGE_SHELF
            ).build(null)
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
