package com.chimericdream.minekea.resource;

import net.minecraft.util.Identifier;

public class Recipe {
    public static Identifier getRecipeID(Identifier blockID, String suffix) {
        return new Identifier(blockID.getNamespace(), blockID.getPath() + suffix);
    }
}
