package net.fabricmc.chimericdream.block.bookshelf;

import net.fabricmc.chimericdream.ModInfo;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class WarpedBookshelf extends AbstractBookshelf {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "warped_bookshelf");

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));
    }
}
