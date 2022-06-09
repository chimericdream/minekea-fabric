package com.chimericdream.minekea.block.furniture.doors;

import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
import com.chimericdream.minekea.block.furniture.doors.GenericBookshelfDoor.BookshelfDoorSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class Doors implements MinekeaBlockCategory {
    public static final GenericBookshelfDoor ACACIA_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor BIRCH_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor CRIMSON_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor DARK_OAK_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor JUNGLE_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor MANGROVE_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor OAK_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor SPRUCE_BOOKSHELF_DOOR;
    public static final GenericBookshelfDoor WARPED_BOOKSHELF_DOOR;

    static {
        ACACIA_BOOKSHELF_DOOR = new GenericBookshelfDoor(new BookshelfDoorSettings(BaseBlockSettings.ACACIA).addMaterial("bookshelf", Bookshelves.ACACIA_BOOKSHELF.getBlockID()));
        BIRCH_BOOKSHELF_DOOR = new GenericBookshelfDoor(new BookshelfDoorSettings(BaseBlockSettings.BIRCH).addMaterial("bookshelf", Bookshelves.BIRCH_BOOKSHELF.getBlockID()));
        CRIMSON_BOOKSHELF_DOOR = new GenericBookshelfDoor(new BookshelfDoorSettings(BaseBlockSettings.CRIMSON).addMaterial("bookshelf", Bookshelves.CRIMSON_BOOKSHELF.getBlockID()));
        DARK_OAK_BOOKSHELF_DOOR = new GenericBookshelfDoor(new BookshelfDoorSettings(BaseBlockSettings.DARK_OAK).addMaterial("bookshelf", Bookshelves.DARK_OAK_BOOKSHELF.getBlockID()));
        JUNGLE_BOOKSHELF_DOOR = new GenericBookshelfDoor(new BookshelfDoorSettings(BaseBlockSettings.JUNGLE).addMaterial("bookshelf", Bookshelves.JUNGLE_BOOKSHELF.getBlockID()));
        MANGROVE_BOOKSHELF_DOOR = new GenericBookshelfDoor(new BookshelfDoorSettings(BaseBlockSettings.MANGROVE).addMaterial("bookshelf", Bookshelves.MANGROVE_BOOKSHELF.getBlockID()));
        OAK_BOOKSHELF_DOOR = new GenericBookshelfDoor(new BookshelfDoorSettings(BaseBlockSettings.OAK).addMaterial("bookshelf", new Identifier("minecraft:bookshelf")));
        SPRUCE_BOOKSHELF_DOOR = new GenericBookshelfDoor(new BookshelfDoorSettings(BaseBlockSettings.SPRUCE).addMaterial("bookshelf", Bookshelves.SPRUCE_BOOKSHELF.getBlockID()));
        WARPED_BOOKSHELF_DOOR = new GenericBookshelfDoor(new BookshelfDoorSettings(BaseBlockSettings.WARPED).addMaterial("bookshelf", Bookshelves.WARPED_BOOKSHELF.getBlockID()));
    }

    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        ACACIA_BOOKSHELF_DOOR.register();
        BIRCH_BOOKSHELF_DOOR.register();
        CRIMSON_BOOKSHELF_DOOR.register();
        DARK_OAK_BOOKSHELF_DOOR.register();
        JUNGLE_BOOKSHELF_DOOR.register();
        MANGROVE_BOOKSHELF_DOOR.register();
        OAK_BOOKSHELF_DOOR.register();
        SPRUCE_BOOKSHELF_DOOR.register();
        WARPED_BOOKSHELF_DOOR.register();
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
