//package com.chimericdream.minekea.resource;
//
//import net.minecraft.util.Identifier;
//
//public class Texture {
//    public static Identifier getBlockTextureFileID(Identifier id) {
//        return Identifier.of(id.getNamespace(), "block/" + id.getPath() + ".png");
//    }
//
//    public static Identifier getBlockTextureID(Identifier id) {
//        return Identifier.of(id.getNamespace(), "block/" + id.getPath());
//    }
//
//    public static Identifier getBlockTextureID(String id) {
//        return getBlockTextureID(Identifier.of(id));
//    }
//
//    public static Identifier getItemTextureID(Identifier id) {
//        return Identifier.of(id.getNamespace(), "item/" + id.getPath());
//    }
//
//    public static Identifier getItemTextureID(String id) {
//        return getItemTextureID(Identifier.of(id));
//    }
//
//    public static class Color {
//        public final float r;
//        public final float g;
//        public final float b;
//
//        public Color(int color) {
//            this.r = (float) (color >> 16 & 255) / 255.0F;
//            this.g = (float) (color >> 8 & 255) / 255.0F;
//            this.b = (float) (color & 255) / 255.0F;
//        }
//
//        public Color(float r, float g, float b) {
//            this.r = r;
//            this.g = b;
//            this.b = r;
//        }
//
//        public Color withLight(float lightFactor) {
//            return new Color(r * lightFactor, g * lightFactor, b * lightFactor);
//        }
//    }
//}
