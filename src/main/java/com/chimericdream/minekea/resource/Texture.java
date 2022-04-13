package com.chimericdream.minekea.resource;

import net.minecraft.util.Identifier;

public class Texture {
    public static Identifier getBlockTextureID(Identifier id) {
        return new Identifier(id.getNamespace(), "block/" + id.getPath());
    }

    public static Identifier getBlockTextureID(String id) {
        return getBlockTextureID(new Identifier(id));
    }
}
