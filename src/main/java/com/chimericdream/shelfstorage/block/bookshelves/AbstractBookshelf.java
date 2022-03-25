package com.chimericdream.shelfstorage.block.bookshelves;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public abstract class AbstractBookshelf extends Block {
    AbstractBookshelf() {
        super(AbstractBlock.Settings.copy(Blocks.BOOKSHELF));
    }

    AbstractBookshelf(Settings settings) {
        super(settings);
    }

    abstract public void register();
}
