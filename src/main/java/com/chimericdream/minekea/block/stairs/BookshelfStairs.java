package com.chimericdream.minekea.block.stairs;

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

    static {
        ACACIA_BOOKSHELF_STAIRS = new GenericBookshelfStairs("acacia",
            Map.of(
                "bookshelf", Bookshelves.ACACIA_BOOKSHELF.BLOCK_ID,
                "planks", new Identifier("minecraft:acacia_planks")
            )
        );
        BIRCH_BOOKSHELF_STAIRS = new GenericBookshelfStairs("birch",
            Map.of(
                "bookshelf", Bookshelves.BIRCH_BOOKSHELF.BLOCK_ID,
                "planks", new Identifier("minecraft:birch_planks")
            )
        );
        CRIMSON_BOOKSHELF_STAIRS = new GenericBookshelfStairs("crimson",
            Map.of(
                "bookshelf", Bookshelves.CRIMSON_BOOKSHELF.BLOCK_ID,
                "planks", new Identifier("minecraft:crimson_planks")
            )
        );
        DARK_OAK_BOOKSHELF_STAIRS = new GenericBookshelfStairs("dark_oak",
            Map.of(
                "bookshelf", Bookshelves.DARK_OAK_BOOKSHELF.BLOCK_ID,
                "planks", new Identifier("minecraft:dark_oak_planks")
            )
        );
        JUNGLE_BOOKSHELF_STAIRS = new GenericBookshelfStairs("jungle",
            Map.of(
                "bookshelf", Bookshelves.JUNGLE_BOOKSHELF.BLOCK_ID,
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
                "bookshelf", Bookshelves.SPRUCE_BOOKSHELF.BLOCK_ID,
                "planks", new Identifier("minecraft:spruce_planks")
            )
        );
        WARPED_BOOKSHELF_STAIRS = new GenericBookshelfStairs("warped",
            Map.of(
                "bookshelf", Bookshelves.WARPED_BOOKSHELF.BLOCK_ID,
                "planks", new Identifier("minecraft:warped_planks")
            )
        );
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
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }
}
