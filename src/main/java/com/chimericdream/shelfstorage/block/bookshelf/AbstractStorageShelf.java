package com.chimericdream.shelfstorage.block.bookshelf;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;

public abstract class AbstractStorageShelf extends BlockWithEntity {
    public static final IntProperty FILL_LEVEL = IntProperty.of("fill_level", 0, 4);

    AbstractStorageShelf() {
        super(Settings.copy(Blocks.CHEST));
        setDefaultState(getStateManager().getDefaultState().with(FILL_LEVEL, 0));
    }

    AbstractStorageShelf(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(FILL_LEVEL, 0));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> stateManager) {
        stateManager.add(FILL_LEVEL);
    }

    abstract public void register();

    public static int getFillLevel(long slots) {
        if (slots == 0) {
            return 0;
        }

        if (slots == 9) {
            return 4;
        }

        if (slots > 7) {
            return 3;
        }

        if (slots > 3) {
            return 2;
        }

        return 1;
    }
}
