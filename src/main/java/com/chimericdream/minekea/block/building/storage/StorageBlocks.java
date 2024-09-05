//package com.chimericdream.minekea.block.building.storage;
//
//import com.chimericdream.minekea.block.building.storage.DyeBlock.DyeBlockSettings;
//import com.chimericdream.minekea.block.building.storage.GenericStorageBlock.StorageBlockSettings;
//import com.chimericdream.minekea.settings.BaseBlockSettings;
//import com.chimericdream.minekea.util.MinekeaBlockCategory;
//import com.chimericdream.minekea.util.Tool;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
//import net.minecraft.client.render.RenderLayer;
//import net.minecraft.sound.BlockSoundGroup;
//
//public class StorageBlocks implements MinekeaBlockCategory {
//    public static final DyeBlock WHITE_DYE_BLOCK;
//    public static final DyeBlock ORANGE_DYE_BLOCK;
//    public static final DyeBlock MAGENTA_DYE_BLOCK;
//    public static final DyeBlock LIGHT_BLUE_DYE_BLOCK;
//    public static final DyeBlock YELLOW_DYE_BLOCK;
//    public static final DyeBlock LIME_DYE_BLOCK;
//    public static final DyeBlock PINK_DYE_BLOCK;
//    public static final DyeBlock GRAY_DYE_BLOCK;
//    public static final DyeBlock LIGHT_GRAY_DYE_BLOCK;
//    public static final DyeBlock CYAN_DYE_BLOCK;
//    public static final DyeBlock PURPLE_DYE_BLOCK;
//    public static final DyeBlock BLUE_DYE_BLOCK;
//    public static final DyeBlock BROWN_DYE_BLOCK;
//    public static final DyeBlock GREEN_DYE_BLOCK;
//    public static final DyeBlock RED_DYE_BLOCK;
//    public static final DyeBlock BLACK_DYE_BLOCK;
//
//    public static final GenericStorageBlock APPLE_BLOCK;
//    public static final GenericStorageBlock BAMBOO_BLOCK;
//    public static final GenericStorageBlock BEETROOT_BLOCK;
//    public static final GenericStorageBlock BEETROOT_SEEDS_BLOCK;
//    public static final GenericStorageBlock BLAZE_POWDER_BLOCK;
//    public static final GenericStorageBlock BLAZE_ROD_BLOCK;
//    public static final GenericStorageBlock CARROT_BLOCK;
//    public static final GenericStorageBlock CHARCOAL_BLOCK;
//    public static final GenericStorageBlock CHORUS_FRUIT_BLOCK;
//    public static final GenericStorageBlock ENDER_PEARL_BLOCK;
//    public static final GenericStorageBlock FLINT_BLOCK;
//    public static final GenericStorageBlock GOLD_NUGGET_SACK;
//    public static final GenericStorageBlock GOLDEN_APPLE_BLOCK;
//    public static final GenericStorageBlock IRON_NUGGET_SACK;
//    public static final GenericStorageBlock LEATHER_BLOCK;
//    public static final GenericStorageBlock MELON_SEEDS_BLOCK;
//    public static final GenericStorageBlock NETHER_STAR_BLOCK;
//    public static final GenericStorageBlock PHANTOM_MEMBRANE_BLOCK;
//    public static final GenericStorageBlock POTATO_BLOCK;
//    public static final GenericStorageBlock PUMPKIN_SEEDS_BLOCK;
//    public static final SetOfEggsBlock SET_OF_EGGS_BLOCK;
//    public static final GenericStorageBlock STICK_BLOCK;
//    public static final GenericStorageBlock SUGAR_BLOCK;
//    public static final GenericStorageBlock SUGAR_CANE_BLOCK;
//    public static final GenericStorageBlock TOTEM_BLOCK;
//    public static final GenericStorageBlock WALLPAPER_BLOCK;
//    public static final GenericStorageBlock WHEAT_SEEDS_BLOCK;
//
//    static {
//        WHITE_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.WHITE_DYE).color("white"));
//        ORANGE_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.ORANGE_DYE).color("orange"));
//        MAGENTA_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.MAGENTA_DYE).color("magenta"));
//        LIGHT_BLUE_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.LIGHT_BLUE_DYE).color("light_blue"));
//        YELLOW_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.YELLOW_DYE).color("yellow"));
//        LIME_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.LIME_DYE).color("lime"));
//        PINK_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.PINK_DYE).color("pink"));
//        GRAY_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.GRAY_DYE).color("gray"));
//        LIGHT_GRAY_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.LIGHT_GRAY_DYE).color("light_gray"));
//        CYAN_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.CYAN_DYE).color("cyan"));
//        PURPLE_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.PURPLE_DYE).color("purple"));
//        BLUE_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.BLUE_DYE).color("blue"));
//        BROWN_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.BROWN_DYE).color("brown"));
//        GREEN_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.GREEN_DYE).color("green"));
//        RED_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.RED_DYE).color("red"));
//        BLACK_DYE_BLOCK = new DyeBlock(new DyeBlockSettings(BaseBlockSettings.BLACK_DYE).color("black"));
//
//        APPLE_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.APPLE).tool(Tool.HOE).separateTop().sounds(BlockSoundGroup.WOOD));
//        BAMBOO_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.BAMBOO).namePattern("Bundle of %s").tool(Tool.AXE).sounds(BlockSoundGroup.BAMBOO));
//        BEETROOT_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.BEETROOT).tool(Tool.HOE).bagged().sounds(BlockSoundGroup.CROP));
//        BEETROOT_SEEDS_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.BEETROOT_SEEDS).tool(Tool.HOE).bagged().sounds(BlockSoundGroup.CROP));
//        BLAZE_POWDER_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.BLAZE_POWDER).tool(Tool.SHOVEL).sounds(BlockSoundGroup.NETHER_STEM));
//        BLAZE_ROD_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.BLAZE_ROD).tool(Tool.AXE).sounds(BlockSoundGroup.NETHER_STEM));
//        CARROT_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.CARROT).tool(Tool.HOE).bagged().sounds(BlockSoundGroup.CROP));
//        CHARCOAL_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.CHARCOAL).tool(Tool.SHOVEL).sounds(BlockSoundGroup.TUFF));
//        CHORUS_FRUIT_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.CHORUS_FRUIT).tool(Tool.AXE).bagged().sounds(BlockSoundGroup.WOOD));
//        ENDER_PEARL_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.ENDER_PEARL).sounds(BlockSoundGroup.SHROOMLIGHT));
//        FLINT_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.FLINT).sounds(BlockSoundGroup.STONE));
//        GOLD_NUGGET_SACK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.GOLD_BLOCK).material("gold").ingredientName("Gold Nugget").namePattern("%s Sack").bagged().addMaterial("ingredient", "minekea:currency/gold_nugget_bag").sounds(BlockSoundGroup.METAL));
//        GOLDEN_APPLE_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.GOLDEN_APPLE).tool(Tool.HOE).separateTop().sounds(BlockSoundGroup.WOOD));
//        IRON_NUGGET_SACK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.IRON_BLOCK).material("iron").ingredientName("Iron Nugget").namePattern("%s Sack").bagged().addMaterial("ingredient", "minekea:currency/iron_nugget_bag").sounds(BlockSoundGroup.METAL));
//        LEATHER_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.LEATHER).tool(Tool.SHEARS).sounds(BlockSoundGroup.WOOL));
//        MELON_SEEDS_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.MELON_SEEDS).tool(Tool.HOE).bagged().sounds(BlockSoundGroup.CROP));
//        NETHER_STAR_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.NETHER_STAR).sounds(BlockSoundGroup.METAL));
//        PHANTOM_MEMBRANE_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.PHANTOM_MEMBRANE).tool(Tool.HOE).sounds(BlockSoundGroup.NETHER_WART));
//        POTATO_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.POTATO).tool(Tool.HOE).bagged().sounds(BlockSoundGroup.CROP));
//        PUMPKIN_SEEDS_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.PUMPKIN_SEEDS).tool(Tool.HOE).bagged().sounds(BlockSoundGroup.CROP));
//        SET_OF_EGGS_BLOCK = new SetOfEggsBlock();
//        STICK_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.STICK).namePattern("Bundle of %s").tool(Tool.AXE).ingredientName("Sticks").sounds(BlockSoundGroup.WOOD));
//        SUGAR_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.SUGAR).tool(Tool.SHOVEL).bagged().sounds(BlockSoundGroup.SAND));
//        SUGAR_CANE_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.SUGAR_CANE).tool(Tool.AXE).namePattern("Bundle of %s").sounds(BlockSoundGroup.GRASS));
//        TOTEM_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.TOTEM).sounds(BlockSoundGroup.METAL));
//        WALLPAPER_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.PAPER).tool(Tool.SHEARS).namePattern("Wallpaper").sounds(BlockSoundGroup.LADDER));
//        WHEAT_SEEDS_BLOCK = new GenericStorageBlock((StorageBlockSettings) new StorageBlockSettings(BaseBlockSettings.WHEAT_SEEDS).tool(Tool.HOE).bagged().sounds(BlockSoundGroup.CROP));
//    }
//
//    @Environment(EnvType.CLIENT)
//    @Override
//    public void initializeClient() {
//        BlockRenderLayerMap.INSTANCE.putBlocks(
//            RenderLayer.getCutout(),
//            SET_OF_EGGS_BLOCK
//        );
//
//        BlockRenderLayerMap.INSTANCE.putBlocks(
//            RenderLayer.getTranslucent(),
//            WHITE_DYE_BLOCK,
//            ORANGE_DYE_BLOCK,
//            MAGENTA_DYE_BLOCK,
//            LIGHT_BLUE_DYE_BLOCK,
//            YELLOW_DYE_BLOCK,
//            LIME_DYE_BLOCK,
//            PINK_DYE_BLOCK,
//            GRAY_DYE_BLOCK,
//            LIGHT_GRAY_DYE_BLOCK,
//            CYAN_DYE_BLOCK,
//            PURPLE_DYE_BLOCK,
//            BLUE_DYE_BLOCK,
//            BROWN_DYE_BLOCK,
//            GREEN_DYE_BLOCK,
//            RED_DYE_BLOCK,
//            BLACK_DYE_BLOCK,
//            SUGAR_CANE_BLOCK
//        );
//    }
//
//    @Override
//    public void registerBlocks() {
//        WHITE_DYE_BLOCK.register();
//        ORANGE_DYE_BLOCK.register();
//        MAGENTA_DYE_BLOCK.register();
//        LIGHT_BLUE_DYE_BLOCK.register();
//        YELLOW_DYE_BLOCK.register();
//        LIME_DYE_BLOCK.register();
//        PINK_DYE_BLOCK.register();
//        GRAY_DYE_BLOCK.register();
//        LIGHT_GRAY_DYE_BLOCK.register();
//        CYAN_DYE_BLOCK.register();
//        PURPLE_DYE_BLOCK.register();
//        BLUE_DYE_BLOCK.register();
//        BROWN_DYE_BLOCK.register();
//        GREEN_DYE_BLOCK.register();
//        RED_DYE_BLOCK.register();
//        BLACK_DYE_BLOCK.register();
//
//        APPLE_BLOCK.register();
//        BAMBOO_BLOCK.register();
//        BEETROOT_BLOCK.register();
//        BEETROOT_SEEDS_BLOCK.register();
//        BLAZE_POWDER_BLOCK.register();
//        BLAZE_ROD_BLOCK.register();
//        CARROT_BLOCK.register();
//        CHARCOAL_BLOCK.register();
//        CHORUS_FRUIT_BLOCK.register();
//        ENDER_PEARL_BLOCK.register();
//        FLINT_BLOCK.register();
//        GOLD_NUGGET_SACK.register();
//        GOLDEN_APPLE_BLOCK.register();
//        IRON_NUGGET_SACK.register();
//        LEATHER_BLOCK.register();
//        MELON_SEEDS_BLOCK.register();
//        NETHER_STAR_BLOCK.register();
//        PHANTOM_MEMBRANE_BLOCK.register();
//        POTATO_BLOCK.register();
//        PUMPKIN_SEEDS_BLOCK.register();
//        SET_OF_EGGS_BLOCK.register();
//        STICK_BLOCK.register();
//        SUGAR_BLOCK.register();
//        SUGAR_CANE_BLOCK.register();
//        TOTEM_BLOCK.register();
//        WALLPAPER_BLOCK.register();
//        WHEAT_SEEDS_BLOCK.register();
//    }
//
//    @Override
//    public void registerBlockEntities() {
//    }
//
//    @Override
//    public void registerEntities() {
//    }
//
//    @Override
//    public void setupResources() {
//    }
//}
