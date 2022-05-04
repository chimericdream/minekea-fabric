package com.chimericdream.minekea.util;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ItemHelpers {
    public static Identifier getIdentifier(ItemStack stack) {
        if (stack.isEmpty()) {
            return Items.AIR.getRegistryEntry().registryKey().getValue();
        }

        return stack.getItem().getRegistryEntry().registryKey().getValue();
    }
}
