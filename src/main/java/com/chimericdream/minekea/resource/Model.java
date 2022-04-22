package com.chimericdream.minekea.resource;

import net.minecraft.util.Identifier;

public class Model {
    public static Identifier getBlockModelID(String blockID) {
        return getBlockModelID(new Identifier(blockID));
    }

    public static Identifier getBlockModelID(Identifier blockID) {
        return new Identifier(blockID.getNamespace(), "block/" + blockID.getPath());
    }

    public static Identifier getItemModelID(String blockID) {
        return getItemModelID(new Identifier(blockID));
    }

    public static Identifier getItemModelID(Identifier blockID) {
        return new Identifier(blockID.getNamespace(), "item/" + blockID.getPath());
    }
}
