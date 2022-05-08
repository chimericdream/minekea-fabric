package com.chimericdream.minekea.util;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemHelpers {
    public static Identifier getIdentifier(ItemStack stack) {
        if (stack.isEmpty()) {
            return Registry.ITEM.getId(Items.AIR);
        }

        return Registry.ITEM.getId(stack.getItem());
    }
}
