package com.chimericdream.minekea.block.bookshelves.trapdoors;

import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;

import java.util.List;

public class BookshelfTrapdoors implements MinekeaBlockCategory {
    public static final GenericBookshelfTrapdoor ACACIA_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor BIRCH_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor CRIMSON_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor DARK_OAK_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor JUNGLE_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor OAK_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor SPRUCE_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor WARPED_BOOKSHELF_TRAPDOOR;

    static {
        ACACIA_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor("acacia");
        BIRCH_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor("birch");
        CRIMSON_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor("crimson");
        DARK_OAK_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor("dark_oak");
        JUNGLE_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor("jungle");
        OAK_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor("oak");
        SPRUCE_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor("spruce");
        WARPED_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor("warped");
    }

    @Override
    public void registerBlocks() {
        ACACIA_BOOKSHELF_TRAPDOOR.register();
        BIRCH_BOOKSHELF_TRAPDOOR.register();
        CRIMSON_BOOKSHELF_TRAPDOOR.register();
        DARK_OAK_BOOKSHELF_TRAPDOOR.register();
        JUNGLE_BOOKSHELF_TRAPDOOR.register();
        OAK_BOOKSHELF_TRAPDOOR.register();
        SPRUCE_BOOKSHELF_TRAPDOOR.register();
        WARPED_BOOKSHELF_TRAPDOOR.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }
}
