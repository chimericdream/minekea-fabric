package com.chimericdream.minekea.block.bookshelves.doors;

import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;

import java.util.List;

public class BookshelfDoors implements MinekeaBlockCategory {
    public static final GenericBookshelfDoor ACACIA_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor BIRCH_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor CRIMSON_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor DARK_OAK_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor JUNGLE_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor OAK_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor SPRUCE_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor WARPED_BOOKSHELF_DOOR;

    static {
        ACACIA_BOOKSHELF_DOOR = new GenericBookshelfDoor("acacia");
        BIRCH_BOOKSHELF_DOOR = new GenericBookshelfDoor("birch");
        CRIMSON_BOOKSHELF_DOOR = new GenericBookshelfDoor("crimson");
        DARK_OAK_BOOKSHELF_DOOR = new GenericBookshelfDoor("dark_oak");
        JUNGLE_BOOKSHELF_DOOR = new GenericBookshelfDoor("jungle");
        OAK_BOOKSHELF_DOOR = new GenericBookshelfDoor("oak");
        SPRUCE_BOOKSHELF_DOOR = new GenericBookshelfDoor("spruce");
        WARPED_BOOKSHELF_DOOR = new GenericBookshelfDoor("warped");
    }

    @Override
    public void registerBlocks() {
        ACACIA_BOOKSHELF_DOOR.register();
        BIRCH_BOOKSHELF_DOOR.register();
        CRIMSON_BOOKSHELF_DOOR.register();
        DARK_OAK_BOOKSHELF_DOOR.register();
        JUNGLE_BOOKSHELF_DOOR.register();
        OAK_BOOKSHELF_DOOR.register();
        SPRUCE_BOOKSHELF_DOOR.register();
        WARPED_BOOKSHELF_DOOR.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }
}
