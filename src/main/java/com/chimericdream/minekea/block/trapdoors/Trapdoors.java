package com.chimericdream.minekea.block.trapdoors;

public class Trapdoors {
    public static final PublicTrapdoorBlock ACACIA_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock BIRCH_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock CRIMSON_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock DARK_OAK_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock JUNGLE_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock OAK_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock SPRUCE_BOOKSHELF_TRAPDOOR;
    public static final PublicTrapdoorBlock WARPED_BOOKSHELF_TRAPDOOR;

    static {
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
