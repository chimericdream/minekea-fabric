package com.chimericdream.minekea.block.bookshelves.storage.entity;

import com.chimericdream.minekea.block.bookshelves.Bookshelves;
import com.chimericdream.minekea.screen.bookshelf.StorageBookshelfScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.math.BlockPos;

public class DarkOakStorageBookshelfBlockEntity extends GenericStorageBookshelfBlockEntity {
    public DarkOakStorageBookshelfBlockEntity(BlockPos pos, BlockState state) {
        super(Bookshelves.DARK_OAK_STORAGE_SHELF_BLOCK_ENTITY, pos, state);
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new StorageBookshelfScreenHandler(Bookshelves.DARK_OAK_STORAGE_SHELF_SCREEN_HANDLER, syncId, playerInventory, this);
    }
}
