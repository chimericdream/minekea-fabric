package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

import java.util.List;

public class StorageBlocks implements MinekeaBlockCategory {
    public static final GenericStorageBlock WHITE_DYE_BLOCK;
    public static final GenericStorageBlock ORANGE_DYE_BLOCK;
    public static final GenericStorageBlock MAGENTA_DYE_BLOCK;
    public static final GenericStorageBlock LIGHT_BLUE_DYE_BLOCK;
    public static final GenericStorageBlock YELLOW_DYE_BLOCK;
    public static final GenericStorageBlock LIME_DYE_BLOCK;
    public static final GenericStorageBlock PINK_DYE_BLOCK;
    public static final GenericStorageBlock GRAY_DYE_BLOCK;
    public static final GenericStorageBlock LIGHT_GRAY_DYE_BLOCK;
    public static final GenericStorageBlock CYAN_DYE_BLOCK;
    public static final GenericStorageBlock PURPLE_DYE_BLOCK;
    public static final GenericStorageBlock BLUE_DYE_BLOCK;
    public static final GenericStorageBlock BROWN_DYE_BLOCK;
    public static final GenericStorageBlock GREEN_DYE_BLOCK;
    public static final GenericStorageBlock RED_DYE_BLOCK;
    public static final GenericStorageBlock BLACK_DYE_BLOCK;

    public static final GenericStorageFallingBlock SUGAR_BLOCK;
    public static final GenericStorageBlock BLAZE_POWDER_BLOCK;
    public static final GenericStorageBlock POTATO_BLOCK;
    public static final GenericStorageBlock ENDER_PEARL_BLOCK;
    public static final GenericStorageBlock CARROT_BLOCK;
    public static final GenericStorageBlock BEETROOT_BLOCK;
    public static final GenericStorageBlock CHORUS_FRUIT_BLOCK;

    static {
        WHITE_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:white_dye"), "white");
        ORANGE_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:orange_dye"), "orange");
        MAGENTA_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:magenta_dye"), "magenta");
        LIGHT_BLUE_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:light_blue_dye"), "light_blue");
        YELLOW_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:yellow_dye"), "yellow");
        LIME_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:lime_dye"), "lime");
        PINK_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:pink_dye"), "pink");
        GRAY_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:gray_dye"), "gray");
        LIGHT_GRAY_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:light_gray_dye"), "light_gray");
        CYAN_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:cyan_dye"), "cyan");
        PURPLE_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:purple_dye"), "purple");
        BLUE_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:blue_dye"), "blue");
        BROWN_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:brown_dye"), "brown");
        GREEN_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:green_dye"), "green");
        RED_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:red_dye"), "red");
        BLACK_DYE_BLOCK = new CompressedDyeBlock(new Identifier("minecraft:black_dye"), "black");

        SUGAR_BLOCK = new CompressedSugarBlock(new Identifier("minecraft:sugar"));
        BLAZE_POWDER_BLOCK = new GenericStorageBlock(new Identifier("minecraft:blaze_powder"));
        POTATO_BLOCK = new GenericStorageBlock(new Identifier("minecraft:potato"), true);
        ENDER_PEARL_BLOCK = new GenericStorageBlock(new Identifier("minecraft:ender_pearl"));
        CARROT_BLOCK = new GenericStorageBlock(new Identifier("minecraft:carrot"), true);
        BEETROOT_BLOCK = new GenericStorageBlock(new Identifier("minecraft:beetroot"), true);
        CHORUS_FRUIT_BLOCK = new GenericStorageBlock(new Identifier("minecraft:chorus_fruit"), true);
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getTranslucent(),
            WHITE_DYE_BLOCK,
            ORANGE_DYE_BLOCK,
            MAGENTA_DYE_BLOCK,
            LIGHT_BLUE_DYE_BLOCK,
            YELLOW_DYE_BLOCK,
            LIME_DYE_BLOCK,
            PINK_DYE_BLOCK,
            GRAY_DYE_BLOCK,
            LIGHT_GRAY_DYE_BLOCK,
            CYAN_DYE_BLOCK,
            PURPLE_DYE_BLOCK,
            BLUE_DYE_BLOCK,
            BROWN_DYE_BLOCK,
            GREEN_DYE_BLOCK,
            RED_DYE_BLOCK,
            BLACK_DYE_BLOCK,
            POTATO_BLOCK,
            CARROT_BLOCK,
            BEETROOT_BLOCK,
            CHORUS_FRUIT_BLOCK
        );
    }

    @Override
    public void registerBlocks() {
        SUGAR_BLOCK.register();
        WHITE_DYE_BLOCK.register();
        ORANGE_DYE_BLOCK.register();
        MAGENTA_DYE_BLOCK.register();
        LIGHT_BLUE_DYE_BLOCK.register();
        YELLOW_DYE_BLOCK.register();
        LIME_DYE_BLOCK.register();
        PINK_DYE_BLOCK.register();
        GRAY_DYE_BLOCK.register();
        LIGHT_GRAY_DYE_BLOCK.register();
        CYAN_DYE_BLOCK.register();
        PURPLE_DYE_BLOCK.register();
        BLUE_DYE_BLOCK.register();
        BROWN_DYE_BLOCK.register();
        GREEN_DYE_BLOCK.register();
        RED_DYE_BLOCK.register();
        BLACK_DYE_BLOCK.register();
        BLAZE_POWDER_BLOCK.register();
        POTATO_BLOCK.register();
        ENDER_PEARL_BLOCK.register();
        CARROT_BLOCK.register();
        BEETROOT_BLOCK.register();
        CHORUS_FRUIT_BLOCK.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
    }
}
