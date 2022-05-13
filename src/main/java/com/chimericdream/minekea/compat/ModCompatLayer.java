package com.chimericdream.minekea.compat;

import com.chimericdream.minekea.block.bookshelves.GenericStorageBookshelf;
import com.chimericdream.minekea.block.crates.GenericCrate;
import com.chimericdream.minekea.block.displaycases.GenericDisplayCase;
import com.chimericdream.minekea.block.shelves.GenericShelf;

import java.util.List;

public interface ModCompatLayer {
    void initializeClient();

    void register();

    default void setupResources() {
    }

    List<GenericCrate> getCrates();

    List<GenericDisplayCase> getDisplayCases();

    List<GenericShelf> getShelves();

    List<GenericStorageBookshelf> getStorageShelves();
}
