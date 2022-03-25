package com.chimericdream.shelfstorage.block.bookshelf.storage.entity;

import com.chimericdream.shelfstorage.block.bookshelf.Bookshelves;
import com.chimericdream.shelfstorage.screen.bookshelf.StorageBookshelfScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public class JungleStorageBookshelfBlockEntity extends GenericStorageBookshelfBlockEntity {
    public JungleStorageBookshelfBlockEntity(BlockPos pos, BlockState state) {
        super(Bookshelves.JUNGLE_STORAGE_SHELF_BLOCK_ENTITY, pos, state);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new StorageBookshelfScreenHandler(Bookshelves.JUNGLE_STORAGE_SHELF_SCREEN_HANDLER, syncId, playerInventory, this);
    }
}
