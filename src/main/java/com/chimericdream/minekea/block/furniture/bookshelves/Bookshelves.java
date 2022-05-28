package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.bookshelves.GenericBookshelf.BookshelfSettings;
import com.chimericdream.minekea.block.furniture.bookshelves.GenericStorageBookshelf.StorageBookshelfSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.entities.blocks.StorageBookshelfBlockEntity;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreen;
import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreenHandler;
import com.chimericdream.minekea.settings.BaseBlockSettings;
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

import java.util.ArrayList;
import java.util.List;

public class Bookshelves implements MinekeaBlockCategory {
    public static final GenericBookshelf ACACIA_BOOKSHELF;
    public static final GenericBookshelf BIRCH_BOOKSHELF;
    public static final GenericBookshelf CRIMSON_BOOKSHELF;
    public static final GenericBookshelf DARK_OAK_BOOKSHELF;
    public static final GenericBookshelf JUNGLE_BOOKSHELF;
    public static final GenericBookshelf SPRUCE_BOOKSHELF;
    public static final GenericBookshelf WARPED_BOOKSHELF;

    public static final GenericBookshelf BONE_BOOKSHELF;
    public static final GenericBookshelf DARK_PRISMARINE_BOOKSHELF;
    public static final GenericBookshelf DEEPSLATE_BRICK_BOOKSHELF;
    public static final GenericBookshelf END_STONE_BRICK_BOOKSHELF;
    public static final GenericBookshelf NETHER_BRICK_BOOKSHELF;
    public static final GenericBookshelf POLISHED_ANDESITE_BOOKSHELF;
    public static final GenericBookshelf POLISHED_BASALT_BOOKSHELF;
    public static final GenericBookshelf POLISHED_BLACKSTONE_BOOKSHELF;
    public static final GenericBookshelf POLISHED_BLACKSTONE_BRICK_BOOKSHELF;
    public static final GenericBookshelf POLISHED_DEEPSLATE_BOOKSHELF;
    public static final GenericBookshelf POLISHED_DIORITE_BOOKSHELF;
    public static final GenericBookshelf POLISHED_GRANITE_BOOKSHELF;
    public static final GenericBookshelf PRISMARINE_BOOKSHELF;
    public static final GenericBookshelf PRISMARINE_BRICK_BOOKSHELF;
    public static final GenericBookshelf PURPUR_BOOKSHELF;
    public static final GenericBookshelf QUARTZ_BRICK_BOOKSHELF;
    public static final GenericBookshelf RED_NETHER_BRICK_BOOKSHELF;
    public static final GenericBookshelf SMOOTH_QUARTZ_BOOKSHELF;
    public static final GenericBookshelf SMOOTH_STONE_BOOKSHELF;
    public static final GenericBookshelf STONE_BRICK_BOOKSHELF;
    public static final GenericBookshelf WARPED_NETHER_BRICK_BOOKSHELF;

    public static final GenericStorageBookshelf ACACIA_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf BIRCH_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf CRIMSON_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf DARK_OAK_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf JUNGLE_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf OAK_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf SPRUCE_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf WARPED_STORAGE_BOOKSHELF;

    public static final GenericStorageBookshelf BONE_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf DARK_PRISMARINE_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf DEEPSLATE_BRICK_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf END_STONE_BRICK_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf NETHER_BRICK_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf POLISHED_ANDESITE_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf POLISHED_BASALT_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf POLISHED_BLACKSTONE_BRICK_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf POLISHED_BLACKSTONE_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf POLISHED_DEEPSLATE_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf POLISHED_DIORITE_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf POLISHED_GRANITE_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf PRISMARINE_BRICK_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf PRISMARINE_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf PURPUR_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf QUARTZ_BRICK_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf RED_NETHER_BRICK_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf SMOOTH_QUARTZ_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf SMOOTH_STONE_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf STONE_BRICK_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf WARPED_NETHER_BRICK_STORAGE_BOOKSHELF;

    public static BlockEntityType<StorageBookshelfBlockEntity> STORAGE_SHELF_BLOCK_ENTITY;
    public static ScreenHandlerType<StorageBookshelfScreenHandler> STORAGE_SHELF_SCREEN_HANDLER;

    static {
        ACACIA_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.ACACIA));
        BIRCH_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.BIRCH));
        CRIMSON_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.CRIMSON));
        DARK_OAK_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.DARK_OAK));
        JUNGLE_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.JUNGLE));
        SPRUCE_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.SPRUCE));
        WARPED_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.WARPED));

        BONE_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.BONE).addMaterial("side_texture", "minecraft:bone_block_side"));
        DARK_PRISMARINE_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.DARK_PRISMARINE));
        DEEPSLATE_BRICK_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.DEEPSLATE_BRICK));
        END_STONE_BRICK_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.END_STONE_BRICK));
        NETHER_BRICK_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.NETHER_BRICK));
        POLISHED_ANDESITE_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.POLISHED_ANDESITE));
        POLISHED_BASALT_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.POLISHED_BASALT).addMaterial("side_texture", "minecraft:polished_basalt_side"));
        POLISHED_BLACKSTONE_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.POLISHED_BLACKSTONE));
        POLISHED_BLACKSTONE_BRICK_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.POLISHED_BLACKSTONE_BRICK));
        POLISHED_DEEPSLATE_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.POLISHED_DEEPSLATE));
        POLISHED_DIORITE_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.POLISHED_DIORITE));
        POLISHED_GRANITE_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.POLISHED_GRANITE));
        PRISMARINE_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.PRISMARINE));
        PRISMARINE_BRICK_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.PRISMARINE_BRICK));
        PURPUR_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.PURPUR));
        QUARTZ_BRICK_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.QUARTZ_BRICK));
        RED_NETHER_BRICK_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.RED_NETHER_BRICK));
        SMOOTH_QUARTZ_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.SMOOTH_QUARTZ).addMaterial("side_texture", "minecraft:quartz_block_bottom"));
        SMOOTH_STONE_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.SMOOTH_STONE));
        STONE_BRICK_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.STONE_BRICK));
        WARPED_NETHER_BRICK_BOOKSHELF = new GenericBookshelf(new BookshelfSettings(BaseBlockSettings.WARPED_NETHER_BRICK));

        ACACIA_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.ACACIA).addMaterial("bookshelf", ACACIA_BOOKSHELF.getBlockID()));
        BIRCH_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.BIRCH).addMaterial("bookshelf", BIRCH_BOOKSHELF.getBlockID()));
        CRIMSON_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.CRIMSON).addMaterial("bookshelf", CRIMSON_BOOKSHELF.getBlockID()));
        DARK_OAK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.DARK_OAK).addMaterial("bookshelf", DARK_OAK_BOOKSHELF.getBlockID()));
        JUNGLE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.JUNGLE).addMaterial("bookshelf", JUNGLE_BOOKSHELF.getBlockID()));
        OAK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.OAK).addMaterial("bookshelf", new Identifier("minecraft:bookshelf")));
        SPRUCE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.SPRUCE).addMaterial("bookshelf", SPRUCE_BOOKSHELF.getBlockID()));
        WARPED_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.WARPED).addMaterial("bookshelf", WARPED_BOOKSHELF.getBlockID()));

        BONE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.BONE).addMaterial("bookshelf", BONE_BOOKSHELF.getBlockID()).addMaterial("side_texture", "minecraft:bone_block_side"));
        DARK_PRISMARINE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.DARK_PRISMARINE).addMaterial("bookshelf", DARK_PRISMARINE_BOOKSHELF.getBlockID()));
        DEEPSLATE_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.DEEPSLATE_BRICK).addMaterial("bookshelf", DEEPSLATE_BRICK_BOOKSHELF.getBlockID()));
        END_STONE_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.END_STONE_BRICK).addMaterial("bookshelf", END_STONE_BRICK_BOOKSHELF.getBlockID()));
        NETHER_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.NETHER_BRICK).addMaterial("bookshelf", NETHER_BRICK_BOOKSHELF.getBlockID()));
        POLISHED_ANDESITE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.POLISHED_ANDESITE).addMaterial("bookshelf", POLISHED_ANDESITE_BOOKSHELF.getBlockID()));
        POLISHED_BASALT_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.POLISHED_BASALT).addMaterial("bookshelf", POLISHED_BASALT_BOOKSHELF.getBlockID()).addMaterial("side_texture", "minecraft:polished_basalt_side"));
        POLISHED_BLACKSTONE_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.POLISHED_BLACKSTONE_BRICK).addMaterial("bookshelf", POLISHED_BLACKSTONE_BRICK_BOOKSHELF.getBlockID()));
        POLISHED_BLACKSTONE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.POLISHED_BLACKSTONE).addMaterial("bookshelf", POLISHED_BLACKSTONE_BOOKSHELF.getBlockID()));
        POLISHED_DEEPSLATE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.POLISHED_DEEPSLATE).addMaterial("bookshelf", POLISHED_DEEPSLATE_BOOKSHELF.getBlockID()));
        POLISHED_DIORITE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.POLISHED_DIORITE).addMaterial("bookshelf", POLISHED_DIORITE_BOOKSHELF.getBlockID()));
        POLISHED_GRANITE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.POLISHED_GRANITE).addMaterial("bookshelf", POLISHED_GRANITE_BOOKSHELF.getBlockID()));
        PRISMARINE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.PRISMARINE).addMaterial("bookshelf", PRISMARINE_BOOKSHELF.getBlockID()));
        PRISMARINE_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.PRISMARINE_BRICK).addMaterial("bookshelf", PRISMARINE_BRICK_BOOKSHELF.getBlockID()));
        PURPUR_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.PURPUR).addMaterial("bookshelf", PURPUR_BOOKSHELF.getBlockID()));
        QUARTZ_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.QUARTZ_BRICK).addMaterial("bookshelf", QUARTZ_BRICK_BOOKSHELF.getBlockID()));
        RED_NETHER_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.RED_NETHER_BRICK).addMaterial("bookshelf", RED_NETHER_BRICK_BOOKSHELF.getBlockID()));
        SMOOTH_QUARTZ_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.SMOOTH_QUARTZ).addMaterial("bookshelf", SMOOTH_QUARTZ_BOOKSHELF.getBlockID()).addMaterial("side_texture", "minecraft:quartz_block_bottom"));
        SMOOTH_STONE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.SMOOTH_STONE).addMaterial("bookshelf", SMOOTH_STONE_BOOKSHELF.getBlockID()));
        STONE_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.STONE_BRICK).addMaterial("bookshelf", STONE_BRICK_BOOKSHELF.getBlockID()));
        WARPED_NETHER_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(new StorageBookshelfSettings(BaseBlockSettings.WARPED_NETHER_BRICK).addMaterial("bookshelf", WARPED_NETHER_BRICK_BOOKSHELF.getBlockID()));

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
        ACACIA_BOOKSHELF.register();
        BIRCH_BOOKSHELF.register();
        CRIMSON_BOOKSHELF.register(false);
        DARK_OAK_BOOKSHELF.register();
        JUNGLE_BOOKSHELF.register();
        SPRUCE_BOOKSHELF.register();
        WARPED_BOOKSHELF.register(false);

        BONE_BOOKSHELF.register(false);
        DARK_PRISMARINE_BOOKSHELF.register(false);
        DEEPSLATE_BRICK_BOOKSHELF.register();
        END_STONE_BRICK_BOOKSHELF.register();
        NETHER_BRICK_BOOKSHELF.register(false);
        POLISHED_ANDESITE_BOOKSHELF.register();
        POLISHED_BASALT_BOOKSHELF.register();
        POLISHED_BLACKSTONE_BOOKSHELF.register();
        POLISHED_BLACKSTONE_BRICK_BOOKSHELF.register();
        POLISHED_DEEPSLATE_BOOKSHELF.register();
        POLISHED_DIORITE_BOOKSHELF.register();
        POLISHED_GRANITE_BOOKSHELF.register();
        PRISMARINE_BOOKSHELF.register();
        PRISMARINE_BRICK_BOOKSHELF.register();
        PURPUR_BOOKSHELF.register(false);
        QUARTZ_BRICK_BOOKSHELF.register(false);
        RED_NETHER_BRICK_BOOKSHELF.register(false);
        SMOOTH_QUARTZ_BOOKSHELF.register(false);
        SMOOTH_STONE_BOOKSHELF.register();
        STONE_BRICK_BOOKSHELF.register(false);
        WARPED_NETHER_BRICK_BOOKSHELF.register(false);

        ACACIA_STORAGE_BOOKSHELF.register();
        BIRCH_STORAGE_BOOKSHELF.register();
        CRIMSON_STORAGE_BOOKSHELF.register(false);
        DARK_OAK_STORAGE_BOOKSHELF.register();
        JUNGLE_STORAGE_BOOKSHELF.register();
        OAK_STORAGE_BOOKSHELF.register();
        SPRUCE_STORAGE_BOOKSHELF.register();
        WARPED_STORAGE_BOOKSHELF.register(false);

        BONE_STORAGE_BOOKSHELF.register(false);
        DARK_PRISMARINE_STORAGE_BOOKSHELF.register(false);
        DEEPSLATE_BRICK_STORAGE_BOOKSHELF.register();
        END_STONE_BRICK_STORAGE_BOOKSHELF.register();
        NETHER_BRICK_STORAGE_BOOKSHELF.register(false);
        POLISHED_ANDESITE_STORAGE_BOOKSHELF.register();
        POLISHED_BASALT_STORAGE_BOOKSHELF.register();
        POLISHED_BLACKSTONE_BRICK_STORAGE_BOOKSHELF.register();
        POLISHED_BLACKSTONE_STORAGE_BOOKSHELF.register();
        POLISHED_DEEPSLATE_STORAGE_BOOKSHELF.register();
        POLISHED_DIORITE_STORAGE_BOOKSHELF.register();
        POLISHED_GRANITE_STORAGE_BOOKSHELF.register();
        PRISMARINE_STORAGE_BOOKSHELF.register();
        PRISMARINE_BRICK_STORAGE_BOOKSHELF.register();
        PURPUR_STORAGE_BOOKSHELF.register(false);
        QUARTZ_BRICK_STORAGE_BOOKSHELF.register(false);
        RED_NETHER_BRICK_STORAGE_BOOKSHELF.register(false);
        SMOOTH_QUARTZ_STORAGE_BOOKSHELF.register(false);
        SMOOTH_STONE_STORAGE_BOOKSHELF.register();
        STONE_BRICK_STORAGE_BOOKSHELF.register(false);
        WARPED_NETHER_BRICK_STORAGE_BOOKSHELF.register(false);
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        List<GenericStorageBookshelf> storageShelves = new ArrayList<>(List.of(
            ACACIA_STORAGE_BOOKSHELF,
            BIRCH_STORAGE_BOOKSHELF,
            CRIMSON_STORAGE_BOOKSHELF,
            DARK_OAK_STORAGE_BOOKSHELF,
            JUNGLE_STORAGE_BOOKSHELF,
            OAK_STORAGE_BOOKSHELF,
            SPRUCE_STORAGE_BOOKSHELF,
            WARPED_STORAGE_BOOKSHELF,
            BONE_STORAGE_BOOKSHELF,
            DARK_PRISMARINE_STORAGE_BOOKSHELF,
            DEEPSLATE_BRICK_STORAGE_BOOKSHELF,
            END_STONE_BRICK_STORAGE_BOOKSHELF,
            NETHER_BRICK_STORAGE_BOOKSHELF,
            POLISHED_ANDESITE_STORAGE_BOOKSHELF,
            POLISHED_BASALT_STORAGE_BOOKSHELF,
            POLISHED_BLACKSTONE_BRICK_STORAGE_BOOKSHELF,
            POLISHED_BLACKSTONE_STORAGE_BOOKSHELF,
            POLISHED_DEEPSLATE_STORAGE_BOOKSHELF,
            POLISHED_DIORITE_STORAGE_BOOKSHELF,
            POLISHED_GRANITE_STORAGE_BOOKSHELF,
            PRISMARINE_STORAGE_BOOKSHELF,
            PRISMARINE_BRICK_STORAGE_BOOKSHELF,
            PURPUR_STORAGE_BOOKSHELF,
            QUARTZ_BRICK_STORAGE_BOOKSHELF,
            RED_NETHER_BRICK_STORAGE_BOOKSHELF,
            SMOOTH_QUARTZ_STORAGE_BOOKSHELF,
            SMOOTH_STONE_STORAGE_BOOKSHELF,
            STONE_BRICK_STORAGE_BOOKSHELF,
            WARPED_NETHER_BRICK_STORAGE_BOOKSHELF
        ));

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
        for (int i = 0; i <= 6; i++) {
            MinekeaResourcePack.RESOURCE_PACK.addModel(
                JModel.model("minekea:block/furniture/bookshelves/bookshelf")
                    .textures(
                        new JTextures()
                            .var("material", "minecraft:block/oak_planks")
                            .var("shelf", String.format("minekea:block/furniture/bookshelves/shelf%d", i))
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
}
