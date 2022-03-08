package net.fabricmc.chimericdream.block.bookshelf;

import net.fabricmc.chimericdream.ModInfo;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class JungleBookshelf extends AbstractBookshelf {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "jungle_bookshelf");

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        FuelRegistry.INSTANCE.add(this, 300);
        FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
    }
}
