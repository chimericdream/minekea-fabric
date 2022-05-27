package com.chimericdream.minekea.block.bookshelves.stairs;

import com.chimericdream.minekea.block.bookshelves.Bookshelves;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class BookshelfStairs implements MinekeaBlockCategory {
    public static final GenericBookshelfStairs ACACIA_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs BIRCH_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs CRIMSON_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs DARK_OAK_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs JUNGLE_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs OAK_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs SPRUCE_BOOKSHELF_STAIRS;
    public static final GenericBookshelfStairs WARPED_BOOKSHELF_STAIRS;

    public static final GenericVerticalBookshelfStairs ACACIA_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs BIRCH_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs CRIMSON_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs DARK_OAK_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs JUNGLE_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs OAK_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs SPRUCE_VERTICAL_BOOKSHELF_STAIRS;
    public static final GenericVerticalBookshelfStairs WARPED_VERTICAL_BOOKSHELF_STAIRS;

    static {
        ACACIA_BOOKSHELF_STAIRS = new GenericBookshelfStairs("acacia",
            Map.of(
                "bookshelf", Bookshelves.ACACIA_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:acacia_planks")
            )
        );
        BIRCH_BOOKSHELF_STAIRS = new GenericBookshelfStairs("birch",
            Map.of(
                "bookshelf", Bookshelves.BIRCH_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:birch_planks")
            )
        );
        CRIMSON_BOOKSHELF_STAIRS = new GenericBookshelfStairs("crimson",
            Map.of(
                "bookshelf", Bookshelves.CRIMSON_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:crimson_planks")
            )
        );
        DARK_OAK_BOOKSHELF_STAIRS = new GenericBookshelfStairs("dark_oak",
            Map.of(
                "bookshelf", Bookshelves.DARK_OAK_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:dark_oak_planks")
            )
        );
        JUNGLE_BOOKSHELF_STAIRS = new GenericBookshelfStairs("jungle",
            Map.of(
                "bookshelf", Bookshelves.JUNGLE_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:jungle_planks")
            )
        );
        OAK_BOOKSHELF_STAIRS = new GenericBookshelfStairs("oak",
            Map.of(
                "bookshelf", new Identifier("minecraft:bookshelf"),
                "planks", new Identifier("minecraft:oak_planks")
            )
        );
        SPRUCE_BOOKSHELF_STAIRS = new GenericBookshelfStairs("spruce",
            Map.of(
                "bookshelf", Bookshelves.SPRUCE_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:spruce_planks")
            )
        );
        WARPED_BOOKSHELF_STAIRS = new GenericBookshelfStairs("warped",
            Map.of(
                "bookshelf", Bookshelves.WARPED_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:warped_planks")
            )
        );

        ACACIA_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs("acacia",
            Map.of(
                "bookshelf", Bookshelves.ACACIA_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:acacia_planks")
            )
        );
        BIRCH_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs("birch",
            Map.of(
                "bookshelf", Bookshelves.BIRCH_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:birch_planks")
            )
        );
        CRIMSON_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs("crimson",
            Map.of(
                "bookshelf", Bookshelves.CRIMSON_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:crimson_planks")
            )
        );
        DARK_OAK_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs("dark_oak",
            Map.of(
                "bookshelf", Bookshelves.DARK_OAK_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:dark_oak_planks")
            )
        );
        JUNGLE_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs("jungle",
            Map.of(
                "bookshelf", Bookshelves.JUNGLE_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:jungle_planks")
            )
        );
        OAK_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs("oak",
            Map.of(
                "bookshelf", new Identifier("minecraft:bookshelf"),
                "planks", new Identifier("minecraft:oak_planks")
            )
        );
        SPRUCE_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs("spruce",
            Map.of(
                "bookshelf", Bookshelves.SPRUCE_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:spruce_planks")
            )
        );
        WARPED_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs("warped",
            Map.of(
                "bookshelf", Bookshelves.WARPED_BOOKSHELF.getBlockID(),
                "planks", new Identifier("minecraft:warped_planks")
            )
        );
    }

    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        ACACIA_BOOKSHELF_STAIRS.register();
        BIRCH_BOOKSHELF_STAIRS.register();
        CRIMSON_BOOKSHELF_STAIRS.register();
        DARK_OAK_BOOKSHELF_STAIRS.register();
        JUNGLE_BOOKSHELF_STAIRS.register();
        OAK_BOOKSHELF_STAIRS.register();
        SPRUCE_BOOKSHELF_STAIRS.register();
        WARPED_BOOKSHELF_STAIRS.register();

        ACACIA_VERTICAL_BOOKSHELF_STAIRS.register();
        BIRCH_VERTICAL_BOOKSHELF_STAIRS.register();
        CRIMSON_VERTICAL_BOOKSHELF_STAIRS.register();
        DARK_OAK_VERTICAL_BOOKSHELF_STAIRS.register();
        JUNGLE_VERTICAL_BOOKSHELF_STAIRS.register();
        OAK_VERTICAL_BOOKSHELF_STAIRS.register();
        SPRUCE_VERTICAL_BOOKSHELF_STAIRS.register();
        WARPED_VERTICAL_BOOKSHELF_STAIRS.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
    }
}
