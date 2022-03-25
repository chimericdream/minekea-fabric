package com.chimericdream.shelfstorage.block.bookshelf.storage;

import com.chimericdream.shelfstorage.ModInfo;
import com.chimericdream.shelfstorage.block.bookshelf.Bookshelves;
import com.chimericdream.shelfstorage.block.bookshelf.storage.entity.AcaciaStorageBookshelfBlockEntity;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class AcaciaStorageBookshelf extends GenericStorageBookshelf implements BlockEntityProvider {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "acacia_storage_shelf");

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        FuelRegistry.INSTANCE.add(this, 300);
        FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, Bookshelves.ACACIA_STORAGE_SHELF_BLOCK_ENTITY, AcaciaStorageBookshelfBlockEntity::tick);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AcaciaStorageBookshelfBlockEntity(pos, state);
    }
}
