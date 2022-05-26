package com.chimericdream.minekea.block.bookshelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.bookshelves.doors.BookshelfDoors;
import com.chimericdream.minekea.block.bookshelves.slabs.BookshelfSlabs;
import com.chimericdream.minekea.block.bookshelves.stairs.BookshelfStairs;
import com.chimericdream.minekea.block.bookshelves.trapdoors.BookshelfTrapdoors;
import com.chimericdream.minekea.block.building.BuildingBlocks;
import com.chimericdream.minekea.block.building.general.WarpedNetherBricksBlock;
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

    public static final BookshelfDoors BOOKSHELF_DOORS;
    public static final BookshelfSlabs BOOKSHELF_SLABS;
    public static final BookshelfStairs BOOKSHELF_STAIRS;
    public static final BookshelfTrapdoors BOOKSHELF_TRAPDOORS;

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
        DEEPSLATE_BRICK_BOOKSHELF = new GenericBookshelf(
            "deepslate_brick",
            Map.of("planks", new Identifier("minecraft:deepslate_bricks")),
            Blocks.DEEPSLATE_BRICKS
        );
        END_STONE_BRICK_BOOKSHELF = new GenericBookshelf(
            "end_stone_brick",
            Map.of("planks", new Identifier("minecraft:end_stone_bricks")),
            Blocks.END_STONE_BRICKS
        );
        NETHER_BRICK_BOOKSHELF = new GenericBookshelf(
            "nether_brick",
            Map.of("planks", new Identifier("minecraft:nether_bricks")),
            Blocks.NETHER_BRICKS
        );
        POLISHED_ANDESITE_BOOKSHELF = new GenericBookshelf(
            "polished_andesite",
            Map.of("planks", new Identifier("minecraft:polished_andesite")),
            Blocks.POLISHED_ANDESITE
        );
        POLISHED_BASALT_BOOKSHELF = new GenericBookshelf(
            "polished_basalt",
            Map.of(
                "planks", new Identifier("minecraft:polished_basalt"),
                "plank_texture", new Identifier("minecraft:polished_basalt_side")
            ),
            Blocks.POLISHED_BASALT
        );
        POLISHED_BLACKSTONE_BOOKSHELF = new GenericBookshelf(
            "polished_blackstone",
            Map.of("planks", new Identifier("minecraft:polished_blackstone")),
            Blocks.POLISHED_BLACKSTONE
        );
        POLISHED_BLACKSTONE_BRICK_BOOKSHELF = new GenericBookshelf(
            "polished_blackstone_brick",
            Map.of("planks", new Identifier("minecraft:polished_blackstone_bricks")),
            Blocks.POLISHED_BLACKSTONE_BRICKS
        );
        POLISHED_DEEPSLATE_BOOKSHELF = new GenericBookshelf(
            "polished_deepslate",
            Map.of("planks", new Identifier("minecraft:polished_deepslate")),
            Blocks.POLISHED_DEEPSLATE
        );
        POLISHED_DIORITE_BOOKSHELF = new GenericBookshelf(
            "polished_diorite",
            Map.of("planks", new Identifier("minecraft:polished_diorite")),
            Blocks.POLISHED_DIORITE
        );
        POLISHED_GRANITE_BOOKSHELF = new GenericBookshelf(
            "polished_granite",
            Map.of("planks", new Identifier("minecraft:polished_granite")),
            Blocks.POLISHED_GRANITE
        );
        PRISMARINE_BOOKSHELF = new GenericBookshelf(
            "prismarine",
            Map.of("planks", new Identifier("minecraft:prismarine")),
            Blocks.PRISMARINE
        );
        PRISMARINE_BRICK_BOOKSHELF = new GenericBookshelf(
            "prismarine_brick",
            Map.of("planks", new Identifier("minecraft:prismarine_bricks")),
            Blocks.PRISMARINE_BRICKS
        );
        PURPUR_BOOKSHELF = new GenericBookshelf(
            "purpur",
            Map.of("planks", new Identifier("minecraft:purpur_block")),
            Blocks.PURPUR_BLOCK
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
        SMOOTH_STONE_BOOKSHELF = new GenericBookshelf(
            "smooth_stone",
            Map.of("planks", new Identifier("minecraft:smooth_stone")),
            Blocks.SMOOTH_STONE
        );
        STONE_BRICK_BOOKSHELF = new GenericBookshelf(
            "stone_brick",
            Map.of("planks", new Identifier("minecraft:stone_bricks")),
            Blocks.STONE_BRICKS
        );
        WARPED_NETHER_BRICK_BOOKSHELF = new GenericBookshelf(
            "warped_nether_brick",
            Map.of("planks", WarpedNetherBricksBlock.BLOCK_ID),
            BuildingBlocks.WARPED_NETHER_BRICKS_BLOCK
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
        DEEPSLATE_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "deepslate_brick",
            Map.of(
                "planks", new Identifier("minecraft:deepslate_bricks"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/deepslate_brick_bookshelf")
            ),
            Blocks.DEEPSLATE_BRICKS
        );
        END_STONE_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "end_stone_brick",
            Map.of(
                "planks", new Identifier("minecraft:end_stone_bricks"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/end_stone_brick_bookshelf")
            ),
            Blocks.END_STONE_BRICKS
        );
        NETHER_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "nether_brick",
            Map.of(
                "planks", new Identifier("minecraft:nether_bricks"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/nether_brick_bookshelf")
            ),
            Blocks.NETHER_BRICKS
        );
        POLISHED_ANDESITE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "polished_andesite",
            Map.of(
                "planks", new Identifier("minecraft:polished_andesite"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/polished_andesite_bookshelf")
            ),
            Blocks.POLISHED_ANDESITE
        );
        POLISHED_BASALT_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "polished_basalt",
            Map.of(
                "planks", new Identifier("minecraft:polished_basalt_side"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/polished_basalt_bookshelf")
            ),
            Blocks.POLISHED_BASALT
        );
        POLISHED_BLACKSTONE_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "polished_blackstone",
            Map.of(
                "planks", new Identifier("minecraft:polished_blackstone"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/polished_blackstone_bookshelf")
            ),
            Blocks.POLISHED_BLACKSTONE_BRICKS
        );
        POLISHED_BLACKSTONE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "polished_blackstone_brick",
            Map.of(
                "planks", new Identifier("minecraft:polished_blackstone_bricks"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/polished_blackstone_brick_bookshelf")
            ),
            Blocks.POLISHED_BLACKSTONE
        );
        POLISHED_DEEPSLATE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "polished_deepslate",
            Map.of(
                "planks", new Identifier("minecraft:polished_deepslate"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/polished_deepslate_bookshelf")
            ),
            Blocks.POLISHED_DEEPSLATE
        );
        POLISHED_DIORITE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "polished_diorite",
            Map.of(
                "planks", new Identifier("minecraft:polished_diorite"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/polished_diorite_bookshelf")
            ),
            Blocks.POLISHED_DIORITE
        );
        POLISHED_GRANITE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "polished_granite",
            Map.of(
                "planks", new Identifier("minecraft:polished_granite"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/polished_granite_bookshelf")
            ),
            Blocks.POLISHED_GRANITE
        );
        PRISMARINE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "prismarine",
            Map.of(
                "planks", new Identifier("minecraft:prismarine"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/prismarine_bookshelf")
            ),
            Blocks.PRISMARINE
        );
        PRISMARINE_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "prismarine_brick",
            Map.of(
                "planks", new Identifier("minecraft:prismarine_bricks"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/prismarine_brick_bookshelf")
            ),
            Blocks.PRISMARINE_BRICKS
        );
        PURPUR_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "purpur",
            Map.of(
                "planks", new Identifier("minecraft:purpur_block"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/purpur_bookshelf")
            ),
            Blocks.PURPUR_BLOCK
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
        SMOOTH_STONE_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "smooth_stone",
            Map.of(
                "planks", new Identifier("minecraft:smooth_stone"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/smooth_stone_bookshelf")
            ),
            Blocks.SMOOTH_STONE
        );
        STONE_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "stone_brick",
            Map.of(
                "planks", new Identifier("minecraft:stone_bricks"),
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/stone_brick_bookshelf")
            ),
            Blocks.STONE_BRICKS
        );
        WARPED_NETHER_BRICK_STORAGE_BOOKSHELF = new GenericStorageBookshelf(
            "warped_nether_brick",
            Map.of(
                "planks", WarpedNetherBricksBlock.BLOCK_ID,
                "bookshelf", new Identifier(ModInfo.MOD_ID, "bookshelves/warped_nether_brick_bookshelf")
            ),
            Blocks.RED_NETHER_BRICKS
        );

        STORAGE_SHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(
            new Identifier(ModInfo.MOD_ID, "screens/storage_shelf"),
            (syncId, inventory) -> new StorageBookshelfScreenHandler(STORAGE_SHELF_SCREEN_HANDLER, syncId, inventory)
        );

        BOOKSHELF_DOORS = new BookshelfDoors();
        BOOKSHELF_SLABS = new BookshelfSlabs();
        BOOKSHELF_STAIRS = new BookshelfStairs();
        BOOKSHELF_TRAPDOORS = new BookshelfTrapdoors();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        ScreenRegistry.register(STORAGE_SHELF_SCREEN_HANDLER, StorageBookshelfScreen::new);

        BOOKSHELF_DOORS.initializeClient();
        BOOKSHELF_SLABS.initializeClient();
        BOOKSHELF_STAIRS.initializeClient();
        BOOKSHELF_TRAPDOORS.initializeClient();
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

        BOOKSHELF_DOORS.registerBlocks();
        BOOKSHELF_SLABS.registerBlocks();
        BOOKSHELF_STAIRS.registerBlocks();
        BOOKSHELF_TRAPDOORS.registerBlocks();
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
            new Identifier(ModInfo.MOD_ID, "bookshelves/storage/storage_shelf_block_entity"),
            FabricBlockEntityTypeBuilder.create(
                StorageBookshelfBlockEntity::new,
                storageShelves.toArray(new Block[0])
            ).build(null)
        );

        BOOKSHELF_DOORS.registerBlockEntities(otherMods);
        BOOKSHELF_SLABS.registerBlockEntities(otherMods);
        BOOKSHELF_STAIRS.registerBlockEntities(otherMods);
        BOOKSHELF_TRAPDOORS.registerBlockEntities(otherMods);
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
        BOOKSHELF_DOORS.registerEntities(otherMods);
        BOOKSHELF_SLABS.registerEntities(otherMods);
        BOOKSHELF_STAIRS.registerEntities(otherMods);
        BOOKSHELF_TRAPDOORS.registerEntities(otherMods);
    }

    @Override
    public void setupResources() {
        BOOKSHELF_DOORS.setupResources();
        BOOKSHELF_SLABS.setupResources();
        BOOKSHELF_STAIRS.setupResources();
        BOOKSHELF_TRAPDOORS.setupResources();

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
}
