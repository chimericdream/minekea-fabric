package com.chimericdream.minekea.block.bookshelves.stairs;

import com.chimericdream.minekea.block.bookshelves.Bookshelves;
import com.chimericdream.minekea.block.building.stairs.GenericBookshelfStairs;
import com.chimericdream.minekea.block.building.stairs.GenericBookshelfStairs.BookshelfStairsSettings;
import com.chimericdream.minekea.block.building.stairs.GenericVerticalBookshelfStairs;
import com.chimericdream.minekea.block.building.stairs.GenericVerticalBookshelfStairs.VerticalBookshelfStairsSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.util.Identifier;

import java.util.List;

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
        ACACIA_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.ACACIA).addMaterial("bookshelf", Bookshelves.ACACIA_BOOKSHELF.getBlockID()));
        BIRCH_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.BIRCH).addMaterial("bookshelf", Bookshelves.BIRCH_BOOKSHELF.getBlockID()));
        CRIMSON_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.CRIMSON).addMaterial("bookshelf", Bookshelves.CRIMSON_BOOKSHELF.getBlockID()));
        DARK_OAK_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.DARK_OAK).addMaterial("bookshelf", Bookshelves.DARK_OAK_BOOKSHELF.getBlockID()));
        JUNGLE_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.JUNGLE).addMaterial("bookshelf", Bookshelves.JUNGLE_BOOKSHELF.getBlockID()));
        OAK_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.OAK).addMaterial("bookshelf", new Identifier("minecraft:bookshelf")).addMaterial("model", new Identifier("minecraft:block/bookshelf")));
        SPRUCE_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.SPRUCE).addMaterial("bookshelf", Bookshelves.SPRUCE_BOOKSHELF.getBlockID()));
        WARPED_BOOKSHELF_STAIRS = new GenericBookshelfStairs(new BookshelfStairsSettings(BaseBlockSettings.WARPED).addMaterial("bookshelf", Bookshelves.WARPED_BOOKSHELF.getBlockID()));

        ACACIA_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.ACACIA).addMaterial("bookshelf", Bookshelves.ACACIA_BOOKSHELF.getBlockID()));
        BIRCH_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.BIRCH).addMaterial("bookshelf", Bookshelves.BIRCH_BOOKSHELF.getBlockID()));
        CRIMSON_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.CRIMSON).addMaterial("bookshelf", Bookshelves.CRIMSON_BOOKSHELF.getBlockID()));
        DARK_OAK_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.DARK_OAK).addMaterial("bookshelf", Bookshelves.DARK_OAK_BOOKSHELF.getBlockID()));
        JUNGLE_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.JUNGLE).addMaterial("bookshelf", Bookshelves.JUNGLE_BOOKSHELF.getBlockID()));
        OAK_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.OAK).addMaterial("bookshelf", new Identifier("minecraft:bookshelf")).addMaterial("model", new Identifier("minecraft:block/bookshelf")));
        SPRUCE_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.SPRUCE).addMaterial("bookshelf", Bookshelves.SPRUCE_BOOKSHELF.getBlockID()));
        WARPED_VERTICAL_BOOKSHELF_STAIRS = new GenericVerticalBookshelfStairs(new VerticalBookshelfStairsSettings(BaseBlockSettings.WARPED).addMaterial("bookshelf", Bookshelves.WARPED_BOOKSHELF.getBlockID()));
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
