package com.chimericdream.minekea.resource;

import net.minecraft.util.Identifier;

public class Texture {
    public static Identifier getBlockTextureID(Identifier id) {
        return new Identifier(id.getNamespace(), "block/" + id.getPath());
    }

    public static Identifier getBlockTextureID(String id) {
        return getBlockTextureID(new Identifier(id));
    }

    public static class Color {
        public final float r;
        public final float g;
        public final float b;

        public Color(int color) {
            this.r = (float) (color >> 16 & 255) / 255.0F;
            this.g = (float) (color >> 8 & 255) / 255.0F;
            this.b = (float) (color & 255) / 255.0F;
        }

        public Color(float r, float g, float b) {
            this.r = r;
            this.g = b;
            this.b = r;
        }

        public Color withLight(float lightFactor) {
            return new Color(r * lightFactor, g * lightFactor, b * lightFactor);
        }
    }
}
