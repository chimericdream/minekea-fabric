package com.chimericdream.minekea.block.furniture.trapdoors;

import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.block.furniture.trapdoors.GenericBookshelfTrapdoor.BookshelfTrapdoorSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class Trapdoors implements MinekeaBlockCategory {
    public static final GenericBookshelfTrapdoor ACACIA_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor BIRCH_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor CRIMSON_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor DARK_OAK_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor JUNGLE_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor MANGROVE_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor OAK_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor SPRUCE_BOOKSHELF_TRAPDOOR;
    public static final GenericBookshelfTrapdoor WARPED_BOOKSHELF_TRAPDOOR;

    static {
        ACACIA_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor(new BookshelfTrapdoorSettings(BaseBlockSettings.ACACIA).addMaterial("bookshelf", Bookshelves.ACACIA_BOOKSHELF.getBlockID()));
        BIRCH_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor(new BookshelfTrapdoorSettings(BaseBlockSettings.BIRCH).addMaterial("bookshelf", Bookshelves.BIRCH_BOOKSHELF.getBlockID()));
        CRIMSON_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor(new BookshelfTrapdoorSettings(BaseBlockSettings.CRIMSON).addMaterial("bookshelf", Bookshelves.CRIMSON_BOOKSHELF.getBlockID()));
        DARK_OAK_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor(new BookshelfTrapdoorSettings(BaseBlockSettings.DARK_OAK).addMaterial("bookshelf", Bookshelves.DARK_OAK_BOOKSHELF.getBlockID()));
        JUNGLE_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor(new BookshelfTrapdoorSettings(BaseBlockSettings.JUNGLE).addMaterial("bookshelf", Bookshelves.JUNGLE_BOOKSHELF.getBlockID()));
        MANGROVE_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor(new BookshelfTrapdoorSettings(BaseBlockSettings.MANGROVE).addMaterial("bookshelf", Bookshelves.MANGROVE_BOOKSHELF.getBlockID()));
        OAK_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor(new BookshelfTrapdoorSettings(BaseBlockSettings.OAK).addMaterial("bookshelf", new Identifier("minecraft:bookshelf")));
        SPRUCE_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor(new BookshelfTrapdoorSettings(BaseBlockSettings.SPRUCE).addMaterial("bookshelf", Bookshelves.SPRUCE_BOOKSHELF.getBlockID()));
        WARPED_BOOKSHELF_TRAPDOOR = new GenericBookshelfTrapdoor(new BookshelfTrapdoorSettings(BaseBlockSettings.WARPED).addMaterial("bookshelf", Bookshelves.WARPED_BOOKSHELF.getBlockID()));
    }

    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        ACACIA_BOOKSHELF_TRAPDOOR.register();
        BIRCH_BOOKSHELF_TRAPDOOR.register();
        CRIMSON_BOOKSHELF_TRAPDOOR.register();
        DARK_OAK_BOOKSHELF_TRAPDOOR.register();
        JUNGLE_BOOKSHELF_TRAPDOOR.register();
        MANGROVE_BOOKSHELF_TRAPDOOR.register();
        OAK_BOOKSHELF_TRAPDOOR.register();
        SPRUCE_BOOKSHELF_TRAPDOOR.register();
        WARPED_BOOKSHELF_TRAPDOOR.register();
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
