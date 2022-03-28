package com.chimericdream.minekea.block.barrels;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class AcaciaBarrel extends GenericBarrel {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "barrels/acacia_barrel");

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));
    }
}
