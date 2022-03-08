package net.fabricmc.chimericdream.block.bookshelf;

import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;

public abstract class AbstractStorageShelf extends BlockWithEntity {
    AbstractStorageShelf() {
        super(Settings.copy(Blocks.CHEST));
    }

    AbstractStorageShelf(Settings settings) {
        super(settings);
    }

    abstract public void register();
}
