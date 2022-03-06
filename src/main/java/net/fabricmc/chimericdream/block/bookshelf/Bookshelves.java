package net.fabricmc.chimericdream.block.bookshelf;

import net.minecraft.block.Block;

public class Bookshelves {
    public static final AbstractBookshelf ACACIA_BOOKSHELF = new AcaciaBookshelf();
    public static final AbstractBookshelf BIRCH_BOOKSHELF = new BirchBookshelf();
    public static final AbstractBookshelf CRIMSON_BOOKSHELF = new CrimsonBookshelf();
    public static final AbstractBookshelf DARK_OAK_BOOKSHELF = new DarkOakBookshelf();
    public static final AbstractBookshelf JUNGLE_BOOKSHELF = new JungleBookshelf();
    public static final AbstractBookshelf SPRUCE_BOOKSHELF = new SpruceBookshelf();
    public static final AbstractBookshelf WARPED_BOOKSHELF = new WarpedBookshelf();

    public void register() {
        ACACIA_BOOKSHELF.register();
        BIRCH_BOOKSHELF.register();
        CRIMSON_BOOKSHELF.register();
        DARK_OAK_BOOKSHELF.register();
        JUNGLE_BOOKSHELF.register();
        SPRUCE_BOOKSHELF.register();
        WARPED_BOOKSHELF.register();
    }

    public static Block[] getShelvesForEnchanting() {
        return new Block[]{
            ACACIA_BOOKSHELF,
            BIRCH_BOOKSHELF,
            CRIMSON_BOOKSHELF,
            DARK_OAK_BOOKSHELF,
            JUNGLE_BOOKSHELF,
            SPRUCE_BOOKSHELF,
            WARPED_BOOKSHELF,
        };
    }
}
