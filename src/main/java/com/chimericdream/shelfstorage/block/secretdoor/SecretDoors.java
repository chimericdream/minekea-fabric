package com.chimericdream.shelfstorage.block.secretdoor;

public class SecretDoors {
    public static final PublicDoorBlock ACACIA_BOOKSHELF_DOOR;
    public static final PublicDoorBlock BIRCH_BOOKSHELF_DOOR;
    public static final PublicDoorBlock CRIMSON_BOOKSHELF_DOOR;
    public static final PublicDoorBlock DARK_OAK_BOOKSHELF_DOOR;
    public static final PublicDoorBlock JUNGLE_BOOKSHELF_DOOR;
    public static final PublicDoorBlock OAK_BOOKSHELF_DOOR;
    public static final PublicDoorBlock SPRUCE_BOOKSHELF_DOOR;
    public static final PublicDoorBlock WARPED_BOOKSHELF_DOOR;

    public static final PublicTrapdoorBlock ACACIA_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock BIRCH_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock CRIMSON_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock DARK_OAK_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock JUNGLE_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock OAK_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock SPRUCE_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock WARPED_BOOKSHELF_TRAPDOOR;

    static {
        ACACIA_BOOKSHELF_DOOR = new AcaciaBookshelfDoor();
        BIRCH_BOOKSHELF_DOOR = new BirchBookshelfDoor();
        CRIMSON_BOOKSHELF_DOOR = new CrimsonBookshelfDoor();
        DARK_OAK_BOOKSHELF_DOOR = new DarkOakBookshelfDoor();
        JUNGLE_BOOKSHELF_DOOR = new JungleBookshelfDoor();
        OAK_BOOKSHELF_DOOR = new OakBookshelfDoor();
        SPRUCE_BOOKSHELF_DOOR = new SpruceBookshelfDoor();
        WARPED_BOOKSHELF_DOOR = new WarpedBookshelfDoor();

        ACACIA_BOOKSHELF_TRAPDOOR = new AcaciaBookshelfTrapdoor();
        BIRCH_BOOKSHELF_TRAPDOOR = new BirchBookshelfTrapdoor();
        CRIMSON_BOOKSHELF_TRAPDOOR = new CrimsonBookshelfTrapdoor();
        DARK_OAK_BOOKSHELF_TRAPDOOR = new DarkOakBookshelfTrapdoor();
        JUNGLE_BOOKSHELF_TRAPDOOR = new JungleBookshelfTrapdoor();
        OAK_BOOKSHELF_TRAPDOOR = new OakBookshelfTrapdoor();
        SPRUCE_BOOKSHELF_TRAPDOOR = new SpruceBookshelfTrapdoor();
        WARPED_BOOKSHELF_TRAPDOOR = new WarpedBookshelfTrapdoor();
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

        ACACIA_BOOKSHELF_TRAPDOOR.register();
        BIRCH_BOOKSHELF_TRAPDOOR.register();
        CRIMSON_BOOKSHELF_TRAPDOOR.register();
        DARK_OAK_BOOKSHELF_TRAPDOOR.register();
        JUNGLE_BOOKSHELF_TRAPDOOR.register();
        OAK_BOOKSHELF_TRAPDOOR.register();
        SPRUCE_BOOKSHELF_TRAPDOOR.register();
        WARPED_BOOKSHELF_TRAPDOOR.register();
    }
}
