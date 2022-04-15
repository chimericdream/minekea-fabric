package com.chimericdream.minekea.block.slabs;

import com.chimericdream.minekea.block.bookshelves.Bookshelves;
import net.minecraft.util.Identifier;

import java.util.Map;

public class BookshelfSlabs {
    public static final GenericBookshelfSlab ACACIA_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab BIRCH_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab CRIMSON_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab DARK_OAK_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab JUNGLE_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab OAK_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab SPRUCE_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab WARPED_BOOKSHELF_SLAB;

    static {
        ACACIA_BOOKSHELF_SLAB = new GenericBookshelfSlab("acacia",
            Map.of(
                "bookshelf", Bookshelves.ACACIA_BOOKSHELF.BLOCK_ID,
                "planks", new Identifier("minecraft:acacia_planks")
            )
        );
        BIRCH_BOOKSHELF_SLAB = new GenericBookshelfSlab("birch",
            Map.of(
                "bookshelf", Bookshelves.BIRCH_BOOKSHELF.BLOCK_ID,
                "planks", new Identifier("minecraft:birch_planks")
            )
        );
        CRIMSON_BOOKSHELF_SLAB = new GenericBookshelfSlab("crimson",
            Map.of(
                "bookshelf", Bookshelves.CRIMSON_BOOKSHELF.BLOCK_ID,
                "planks", new Identifier("minecraft:crimson_planks")
            )
        );
        DARK_OAK_BOOKSHELF_SLAB = new GenericBookshelfSlab("dark_oak",
            Map.of(
                "bookshelf", Bookshelves.DARK_OAK_BOOKSHELF.BLOCK_ID,
                "planks", new Identifier("minecraft:dark_oak_planks")
            )
        );
        JUNGLE_BOOKSHELF_SLAB = new GenericBookshelfSlab("jungle",
            Map.of(
                "bookshelf", Bookshelves.JUNGLE_BOOKSHELF.BLOCK_ID,
                "planks", new Identifier("minecraft:jungle_planks")
            )
        );
        OAK_BOOKSHELF_SLAB = new GenericBookshelfSlab("oak",
            Map.of(
                "bookshelf", new Identifier("minecraft:bookshelf"),
                "model", new Identifier("minecraft:block/bookshelf"),
                "planks", new Identifier("minecraft:oak_planks")
            )
        );
        SPRUCE_BOOKSHELF_SLAB = new GenericBookshelfSlab("spruce",
            Map.of(
                "bookshelf", Bookshelves.SPRUCE_BOOKSHELF.BLOCK_ID,
                "planks", new Identifier("minecraft:spruce_planks")
            )
        );
        WARPED_BOOKSHELF_SLAB = new GenericBookshelfSlab("warped",
            Map.of(
                "bookshelf", Bookshelves.WARPED_BOOKSHELF.BLOCK_ID,
                "planks", new Identifier("minecraft:warped_planks")
            )
        );
    }

    public void register() {
        ACACIA_BOOKSHELF_SLAB.register();
        BIRCH_BOOKSHELF_SLAB.register();
        CRIMSON_BOOKSHELF_SLAB.register();
        DARK_OAK_BOOKSHELF_SLAB.register();
        JUNGLE_BOOKSHELF_SLAB.register();
        OAK_BOOKSHELF_SLAB.register();
        SPRUCE_BOOKSHELF_SLAB.register();
        WARPED_BOOKSHELF_SLAB.register();
    }
}
