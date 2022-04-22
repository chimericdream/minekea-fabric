package com.chimericdream.minekea.block.bookshelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreen;
import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreenHandler;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Bookshelves implements MinekeaBlockCategory {
    public static final GenericBookshelf ACACIA_BOOKSHELF;
    public static final GenericBookshelf BIRCH_BOOKSHELF;
    public static final GenericBookshelf CRIMSON_BOOKSHELF;
    public static final GenericBookshelf DARK_OAK_BOOKSHELF;
    public static final GenericBookshelf JUNGLE_BOOKSHELF;
    public static final GenericBookshelf SPRUCE_BOOKSHELF;
    public static final GenericBookshelf WARPED_BOOKSHELF;

    public static final GenericStorageBookshelf ACACIA_STORAGE_SHELF;
    public static final GenericStorageBookshelf BIRCH_STORAGE_SHELF;
    public static final GenericStorageBookshelf CRIMSON_STORAGE_SHELF;
    public static final GenericStorageBookshelf DARK_OAK_STORAGE_SHELF;
    public static final GenericStorageBookshelf JUNGLE_STORAGE_SHELF;
    public static final GenericStorageBookshelf OAK_STORAGE_SHELF;
    public static final GenericStorageBookshelf SPRUCE_STORAGE_SHELF;
    public static final GenericStorageBookshelf WARPED_STORAGE_SHELF;

    public static BlockEntityType<StorageBookshelfBlockEntity> STORAGE_SHELF_BLOCK_ENTITY;
    public static ScreenHandlerType<StorageBookshelfScreenHandler> STORAGE_SHELF_SCREEN_HANDLER;

    static {
        ACACIA_BOOKSHELF = new GenericBookshelf("acacia");
        BIRCH_BOOKSHELF = new GenericBookshelf("birch");
        CRIMSON_BOOKSHELF = new GenericBookshelf("crimson");
        DARK_OAK_BOOKSHELF = new GenericBookshelf("dark_oak");
        JUNGLE_BOOKSHELF = new GenericBookshelf("jungle");
        SPRUCE_BOOKSHELF = new GenericBookshelf("spruce");
        WARPED_BOOKSHELF = new GenericBookshelf("warped");

        ACACIA_STORAGE_SHELF = new GenericStorageBookshelf("acacia");
        BIRCH_STORAGE_SHELF = new GenericStorageBookshelf("birch");
        CRIMSON_STORAGE_SHELF = new GenericStorageBookshelf("crimson");
        DARK_OAK_STORAGE_SHELF = new GenericStorageBookshelf("dark_oak");
        JUNGLE_STORAGE_SHELF = new GenericStorageBookshelf("jungle");
        OAK_STORAGE_SHELF = new GenericStorageBookshelf("oak");
        SPRUCE_STORAGE_SHELF = new GenericStorageBookshelf("spruce");
        WARPED_STORAGE_SHELF = new GenericStorageBookshelf("warped");

        STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(
            new Identifier(ModInfo.MOD_ID, "screens/storage_shelf"),
            (syncId, inventory) -> new StorageBookshelfScreenHandler(STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory)
        );
    }

    public void register() {
        ACACIA_BOOKSHELF.register();
        BIRCH_BOOKSHELF.register();
        CRIMSON_BOOKSHELF.register(false);
        DARK_OAK_BOOKSHELF.register();
        JUNGLE_BOOKSHELF.register();
        SPRUCE_BOOKSHELF.register();
        WARPED_BOOKSHELF.register(false);

        ACACIA_STORAGE_SHELF.register();
        BIRCH_STORAGE_SHELF.register();
        CRIMSON_STORAGE_SHELF.register(false);
        DARK_OAK_STORAGE_SHELF.register();
        JUNGLE_STORAGE_SHELF.register();
        OAK_STORAGE_SHELF.register();
        SPRUCE_STORAGE_SHELF.register();
        WARPED_STORAGE_SHELF.register(false);

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

        setupOakBookshelfResources();
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

    protected void setupOakBookshelfResources() {
        for (int i = 0; i <= 6; i++) {
            MinekeaResourcePack.RESOURCE_PACK.addModel(
                JModel.model("minekea:block/bookshelf_variant")
                    .textures(
                        new JTextures()
                            .var("material", "minecraft:block/oak_planks")
                            .var("shelf", String.format("minekea:block/bookshelves/shelf%d", i))
                    ),
                new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/oak/shelf%d", i))
            );
        }

        // This is bugged in ARRP
        // See: https://github.com/Devan-Kerman/ARRP/issues/62
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf0", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf1", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf2", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf3", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf4", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf5", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf6", woodType))))
//            ),
//            BLOCK_ID
//        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);
    }
}
