package com.chimericdream.shelfstorage.block.bookshelves.storage.entity;

import com.chimericdream.shelfstorage.block.bookshelves.Bookshelves;
import com.chimericdream.shelfstorage.screen.bookshelf.StorageBookshelfScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public class SpruceStorageBookshelfBlockEntity extends GenericStorageBookshelfBlockEntity {
    public SpruceStorageBookshelfBlockEntity(BlockPos pos, BlockState state) {
        super(Bookshelves.SPRUCE_STORAGE_SHELF_BLOCK_ENTITY, pos, state);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new StorageBookshelfScreenHandler(Bookshelves.SPRUCE_STORAGE_SHELF_SCREEN_HANDLER, syncId, playerInventory, this);
    }
}
