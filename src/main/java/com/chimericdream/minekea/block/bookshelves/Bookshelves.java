package com.chimericdream.minekea.block.bookshelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.compat.ModCompatLayer;
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
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public static final GenericBookshelf NETHER_BRICK_BOOKSHELF;
    public static final GenericBookshelf PURPUR_BOOKSHELF;
    public static final GenericBookshelf QUARTZ_BOOKSHELF;
    public static final GenericBookshelf QUARTZ_BRICK_BOOKSHELF;
    public static final GenericBookshelf RED_NETHER_BRICK_BOOKSHELF;
    public static final GenericBookshelf SMOOTH_QUARTZ_BOOKSHELF;
    public static final GenericBookshelf STONE_BRICK_BOOKSHELF;

    public static final GenericStorageBookshelf ACACIA_STORAGE_SHELF;
    public static final GenericStorageBookshelf BIRCH_STORAGE_SHELF;
    public static final GenericStorageBookshelf CRIMSON_STORAGE_SHELF;
    public static final GenericStorageBookshelf DARK_OAK_STORAGE_SHELF;
    public static final GenericStorageBookshelf JUNGLE_STORAGE_SHELF;
    public static final GenericStorageBookshelf OAK_STORAGE_SHELF;
    public static final GenericStorageBookshelf SPRUCE_STORAGE_SHELF;
    public static final GenericStorageBookshelf WARPED_STORAGE_SHELF;

    public static final GenericStorageBookshelf BONE_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf DARK_PRISMARINE_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf NETHER_BRICK_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf PURPUR_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf QUARTZ_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf QUARTZ_BRICK_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf RED_NETHER_BRICK_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf SMOOTH_QUARTZ_STORAGE_BOOKSHELF;
    public static final GenericStorageBookshelf STONE_BRICK_STORAGE_BOOKSHELF;

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

        BONE_BOOKSHELF = new GenericBookshelf(
            "bone",
            Map.of(
                "planks", new Identifier("minecraft:bone_block"),
                "plank_texture", new Identifier("minecraft:bone_block_side")
            ),
            Blocks.BONE_BLOCK
        );
        DARK_PRISMARINE_BOOKSHELF = new GenericBookshelf(
            "dark_prismarine",
            Map.of("planks", new Identifier("minecraft:dark_prismarine")),
            Blocks.DARK_PRISMARINE
        );
        NETHER_BRICK_BOOKSHELF = new GenericBookshelf(
            "nether_brick",
            Map.of("planks", new Identifier("minecraft:nether_bricks")),
            Blocks.NETHER_BRICKS
        );
        PURPUR_BOOKSHELF = new GenericBookshelf(
            "purpur",
            Map.of("planks", new Identifier("minecraft:purpur_block")),
            Blocks.PURPUR_BLOCK
        );
        QUARTZ_BOOKSHELF = new GenericBookshelf(
            "quartz",
            Map.of(
                "planks", new Identifier("minecraft:quartz_block"),
                "plank_texture", new Identifier("minecraft:quartz_block_side")
            ),
            Blocks.QUARTZ_BLOCK
        );
        QUARTZ_BRICK_BOOKSHELF = new GenericBookshelf(
            "quartz_brick",
            Map.of("planks", new Identifier("minecraft:quartz_bricks")),
            Blocks.QUARTZ_BRICKS
        );
        RED_NETHER_BRICK_BOOKSHELF = new GenericBookshelf(
            "red_nether_brick",
            Map.of("planks", new Identifier("minecraft:red_nether_bricks")),
            Blocks.RED_NETHER_BRICKS
        );
        SMOOTH_QUARTZ_BOOKSHELF = new GenericBookshelf(
            "smooth_quartz",
            Map.of(
                "planks", new Identifier("minecraft:smooth_quartz"),
                "plank_texture", new Identifier("minecraft:quartz_block_bottom")
            ),
            Blocks.SMOOTH_QUARTZ
        );
        STONE_BRICK_BOOKSHELF = new GenericBookshelf(
            "stone_brick",
            Map.of("planks", new Identifier("minecraft:stone_bricks")),
            Blocks.STONE_BRICKS
        );

        ACACIA_STORAGE_SHELF = new GenericStorageBookshelf("acacia");
        BIRCH_STORAGE_SHELF = new GenericStorageBookshelf("birch");
        CRIMSON_STORAGE_SHELF = new GenericStorageBookshelf("crimson");
        DARK_OAK_STORAGE_SHELF = new GenericStorageBookshelf("dark_oak");
        JUNGLE_STORAGE_SHELF = new GenericStorageBookshelf("jungle");
        OAK_STORAGE_SHELF = new GenericStorageBookshelf("oak");
        SPRUCE_STORAGE_SHELF = new GenericStorageBookshelf("spruce");
        WARPED_STORAGE_SHELF = new GenericStorageBookshelf("warped");

        BONE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "bone",
            Map.of(
                "planks", new Identifier("minecraft:bone_block_side"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/bone_bookshelf")
            ),
            Blocks.BONE_BLOCK
        );
        DARK_PRISMARINE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "dark_prismarine",
            Map.of(
                "planks", new Identifier("minecraft:dark_prismarine"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/dark_prismarine_bookshelf")
            ),
            Blocks.DARK_PRISMARINE
        );
        NETHER_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "nether_brick",
            Map.of(
                "planks", new Identifier("minecraft:nether_bricks"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/nether_brick_bookshelf")
            ),
            Blocks.NETHER_BRICKS
        );
        PURPUR_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "purpur",
            Map.of(
                "planks", new Identifier("minecraft:purpur_block"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/purpur_bookshelf")
            ),
            Blocks.PURPUR_BLOCK
        );
        QUARTZ_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "quartz",
            Map.of(
                "planks", new Identifier("minecraft:quartz_block_side"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/quartz_bookshelf")
            ),
            Blocks.QUARTZ_BLOCK
        );
        QUARTZ_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "quartz_brick",
            Map.of(
                "planks", new Identifier("minecraft:quartz_bricks"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/quartz_brick_bookshelf")
            ),
            Blocks.QUARTZ_BRICKS
        );
        RED_NETHER_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "red_nether_brick",
            Map.of(
                "planks", new Identifier("minecraft:red_nether_bricks"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/red_nether_brick_bookshelf")
            ),
            Blocks.RED_NETHER_BRICKS
        );
        SMOOTH_QUARTZ_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "smooth_quartz",
            Map.of(
                "planks", new Identifier("minecraft:quartz_block_bottom"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/smooth_quartz_bookshelf")
            ),
            Blocks.SMOOTH_QUARTZ
        );
        STONE_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "stone_brick",
            Map.of(
                "planks", new Identifier("minecraft:stone_bricks"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/stone_brick_bookshelf")
            ),
            Blocks.STONE_BRICKS
        );

        STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(
            new Identifier(ModInfo.MOD_ID, "screens/storage_shelf"),
            (syncId, inventory) -> new StorageBookshelfScreenHandler(STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory)
        );
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
        NETHER_BRICK_BOOKSHELF.register(false);
        PURPUR_BOOKSHELF.register(false);
        QUARTZ_BOOKSHELF.register(false);
        QUARTZ_BRICK_BOOKSHELF.register(false);
        RED_NETHER_BRICK_BOOKSHELF.register(false);
        SMOOTH_QUARTZ_BOOKSHELF.register(false);
        STONE_BRICK_BOOKSHELF.register(false);

        ACACIA_STORAGE_SHELF.register();
        BIRCH_STORAGE_SHELF.register();
        CRIMSON_STORAGE_SHELF.register(false);
        DARK_OAK_STORAGE_SHELF.register();
        JUNGLE_STORAGE_SHELF.register();
        OAK_STORAGE_SHELF.register();
        SPRUCE_STORAGE_SHELF.register();
        WARPED_STORAGE_SHELF.register(false);

        BONE_STORAGE_BOOKSHELF.register(false);
        DARK_PRISMARINE_STORAGE_BOOKSHELF.register(false);
        NETHER_BRICK_STORAGE_BOOKSHELF.register(false);
        PURPUR_STORAGE_BOOKSHELF.register(false);
        QUARTZ_STORAGE_BOOKSHELF.register(false);
        QUARTZ_BRICK_STORAGE_BOOKSHELF.register(false);
        RED_NETHER_BRICK_STORAGE_BOOKSHELF.register(false);
        SMOOTH_QUARTZ_STORAGE_BOOKSHELF.register(false);
        STONE_BRICK_STORAGE_BOOKSHELF.register(false);

        setupOakBookshelfResources();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
        List<GenericStorageBookshelf> storageShelves = new ArrayList<>(List.of(
            ACACIA_STORAGE_SHELF,
            BIRCH_STORAGE_SHELF,
            CRIMSON_STORAGE_SHELF,
            DARK_OAK_STORAGE_SHELF,
            JUNGLE_STORAGE_SHELF,
            OAK_STORAGE_SHELF,
            SPRUCE_STORAGE_SHELF,
            WARPED_STORAGE_SHELF,
            BONE_STORAGE_BOOKSHELF,
            DARK_PRISMARINE_STORAGE_BOOKSHELF,
            NETHER_BRICK_STORAGE_BOOKSHELF,
            PURPUR_STORAGE_BOOKSHELF,
            QUARTZ_STORAGE_BOOKSHELF,
            QUARTZ_BRICK_STORAGE_BOOKSHELF,
            RED_NETHER_BRICK_STORAGE_BOOKSHELF,
            SMOOTH_QUARTZ_STORAGE_BOOKSHELF,
            STONE_BRICK_STORAGE_BOOKSHELF
        ));

        for (ModCompatLayer mod : otherMods) {
            storageShelves.addAll(mod.getStorageShelves());
        }

        STORAGE_SHELF_BLOCK_ENTITY = Registry.register(
            Registry.BLOCK_ENTITY_TYPE,
            new Identifier(ModInfo.MOD_ID, "bookshelves/storage/storage_shelf_block_entity"),
            FabricBlockEntityTypeBuilder.create(
                StorageBookshelfBlockEntity::new,
                storageShelves.toArray(new Block[0])
            ).build(null)
        );
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
    public void initializeClient() {
        ScreenRegistry.register(STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);
    }
}
