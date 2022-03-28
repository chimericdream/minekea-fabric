package com.chimericdream.minekea.block.doors;

public class Doors {
    public static final PublicDoorBlock ACACIA_BOOKSHELF_DOOR;
    public static final PublicDoorBlock BIRCH_BOOKSHELF_DOOR;
    public static final PublicDoorBlock CRIMSON_BOOKSHELF_DOOR;
    public static final PublicDoorBlock DARK_OAK_BOOKSHELF_DOOR;
    public static final PublicDoorBlock JUNGLE_BOOKSHELF_DOOR;
    public static final PublicDoorBlock OAK_BOOKSHELF_DOOR;
    public static final PublicDoorBlock SPRUCE_BOOKSHELF_DOOR;
    public static final PublicDoorBlock WARPED_BOOKSHELF_DOOR;

    static {
        ACACIA_BOOKSHELF_DOOR = new AcaciaBookshelfDoor();
        BIRCH_BOOKSHELF_DOOR = new BirchBookshelfDoor();
        CRIMSON_BOOKSHELF_DOOR = new CrimsonBookshelfDoor();
        DARK_OAK_BOOKSHELF_DOOR = new DarkOakBookshelfDoor();
        JUNGLE_BOOKSHELF_DOOR = new JungleBookshelfDoor();
        OAK_BOOKSHELF_DOOR = new OakBookshelfDoor();
        SPRUCE_BOOKSHELF_DOOR = new SpruceBookshelfDoor();
        WARPED_BOOKSHELF_DOOR = new WarpedBookshelfDoor();
    }

    public void register() {
        ACACIA_BOOKSHELF_DOOR.register();
        BIRCH_BOOKSHELF_DOOR.register();
        CRIMSON_BOOKSHELF_DOOR.register();
        DARK_OAK_BOOKSHELF_DOOR.register();
        JUNGLE_BOOKSHELF_DOOR.register();
        OAK_BOOKSHELF_DOOR.register();
        SPRUCE_BOOKSHELF_DOOR.register();
        WARPED_BOOKSHELF_DOOR.register();
    }
}
