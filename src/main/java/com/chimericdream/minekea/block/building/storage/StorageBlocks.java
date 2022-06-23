package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.minekea.block.building.storage.DyeBlock.DyeBlockSettings;
import com.chimericdream.minekea.block.building.storage.GenericStorageBlock.StorageBlockSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import com.chimericdream.minekea.util.Tool;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.sound.BlockSoundGroup;

import java.util.List;

public class StorageBlocks implements MinekeaBlockCategory {
    public static final DyeBlock WHITE_DYE_BLOCK;
    public static final DyeBlock ORANGE_DYE_BLOCK;
    public static final DyeBlock MAGENTA_DYE_BLOCK;
    public static final DyeBlock LIGHT_BLUE_DYE_BLOCK;
    public static final DyeBlock YELLOW_DYE_BLOCK;
    public static final DyeBlock LIME_DYE_BLOCK;
    public static final DyeBlock PINK_DYE_BLOCK;
    public static final DyeBlock GRAY_DYE_BLOCK;
    public static final DyeBlock LIGHT_GRAY_DYE_BLOCK;
    public static final DyeBlock CYAN_DYE_BLOCK;
    public static final DyeBlock PURPLE_DYE_BLOCK;
    public static final DyeBlock BLUE_DYE_BLOCK;
    public static final DyeBlock BROWN_DYE_BLOCK;
    public static final DyeBlock GREEN_DYE_BLOCK;
    public static final DyeBlock RED_DYE_BLOCK;
    public static final DyeBlock BLACK_DYE_BLOCK;

    public static final GenericStorageBlock BAMBOO_BLOCK;
    public static final GenericStorageBlock BEETROOT_BLOCK;
    public static final GenericStorageBlock BLAZE_POWDER_BLOCK;
    public static final GenericStorageBlock CARROT_BLOCK;
    public static final GenericStorageBlock CHORUS_FRUIT_BLOCK;
    public static final GenericStorageBlock ENDER_PEARL_BLOCK;
    public static final GenericStorageBlock POTATO_BLOCK;
    public static final GenericStorageBlock STICK_BLOCK;
    public static final GenericStorageBlock SUGAR_BLOCK;
    public static final GenericStorageBlock SUGAR_CANE_BLOCK;

    static {
        WHITE_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.WHITE_DYE).color("white"));
        ORANGE_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.ORANGE_DYE).color("orange"));
        MAGENTA_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.MAGENTA_DYE).color("magenta"));
        LIGHT_BLUE_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.LIGHT_BLUE_DYE).color("light_blue"));
        YELLOW_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.YELLOW_DYE).color("yellow"));
        LIME_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.LIME_DYE).color("lime"));
        PINK_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.PINK_DYE).color("pink"));
        GRAY_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.GRAY_DYE).color("gray"));
        LIGHT_GRAY_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.LIGHT_GRAY_DYE).color("light_gray"));
        CYAN_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.CYAN_DYE).color("cyan"));
        PURPLE_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.PURPLE_DYE).color("purple"));
        BLUE_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.BLUE_DYE).color("blue"));
        BROWN_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.BROWN_DYE).color("brown"));
        GREEN_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.GREEN_DYE).color("green"));
        RED_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.RED_DYE).color("red"));
        BLACK_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.BLACK_DYE).color("black"));

        BAMBOO_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.BAMBOO).namePattern("Bundle of %s").tool(Tool.AXE).column().sounds(BlockSoundGroup.BAMBOO));
        BEETROOT_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.BEETROOT).tool(Tool.HOE).bagged().sounds(BlockSoundGroup.CROP));
        BLAZE_POWDER_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.BLAZE_POWDER).tool(Tool.SHOVEL).sounds(BlockSoundGroup.NETHER_STEM));
        CARROT_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.CARROT).tool(Tool.HOE).bagged().sounds(BlockSoundGroup.CROP));
        CHORUS_FRUIT_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.CHORUS_FRUIT).tool(Tool.AXE).bagged().sounds(BlockSoundGroup.WOOD));
        ENDER_PEARL_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.ENDER_PEARL).sounds(BlockSoundGroup.SHROOMLIGHT));
        POTATO_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.POTATO).tool(Tool.HOE).bagged().sounds(BlockSoundGroup.CROP));
        STICK_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.STICK).tool(Tool.AXE).column().namePattern("Bundle of %s").ingredientName("Sticks").sounds(BlockSoundGroup.WOOD));
        SUGAR_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.SUGAR).tool(Tool.SHOVEL).sounds(BlockSoundGroup.SAND));
        SUGAR_CANE_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.SUGAR_CANE).tool(Tool.AXE).namePattern("Bundle of %s").column().sounds(BlockSoundGroup.GRASS));
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

        BAMBOO_BLOCK.register();
        BEETROOT_BLOCK.register();
        BLAZE_POWDER_BLOCK.register();
        CARROT_BLOCK.register();
        CHORUS_FRUIT_BLOCK.register();
        ENDER_PEARL_BLOCK.register();
        POTATO_BLOCK.register();
        STICK_BLOCK.register();
        SUGAR_BLOCK.register();
        SUGAR_CANE_BLOCK.register();
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
