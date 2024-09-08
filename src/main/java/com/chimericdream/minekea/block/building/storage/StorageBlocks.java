package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.function.Function;

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

    public static final List<DyeBlock> DYE_BLOCKS;

    public static final GenericStorageBlock APPLE_STORAGE_BLOCK;
    public static final GenericStorageBlock BEETROOT_BLOCK;
    public static final GenericStorageBlock BEETROOT_SEEDS_BLOCK;
    public static final GenericStorageBlock BLAZE_POWDER_BLOCK;
    public static final GenericStorageBlock BLAZE_ROD_BLOCK;
    public static final GenericStorageBlock CARROT_BLOCK;
    public static final GenericStorageBlock CHARCOAL_BLOCK;
    public static final GenericStorageBlock CHORUS_FRUIT_BLOCK;
    public static final GenericStorageBlock ENDER_PEARL_BLOCK;
    public static final GenericStorageBlock FLINT_BLOCK;
    public static final GenericStorageBlock GOLD_NUGGET_SACK;
    public static final GenericStorageBlock GOLDEN_APPLE_BLOCK;
    public static final GenericStorageBlock IRON_NUGGET_SACK;
    public static final GenericStorageBlock LEATHER_BLOCK;
    public static final GenericStorageBlock MELON_SEEDS_BLOCK;
    public static final GenericStorageBlock NETHER_STAR_BLOCK;
    public static final GenericStorageBlock PHANTOM_MEMBRANE_BLOCK;
    public static final GenericStorageBlock POTATO_BLOCK;
    public static final GenericStorageBlock PUMPKIN_SEEDS_BLOCK;
    //    public static final SetOfEggsBlock SET_OF_EGGS_BLOCK;
    public static final GenericStorageBlock STICK_BLOCK;
    public static final GenericStorageBlock SUGAR_BLOCK;
    public static final GenericStorageBlock SUGAR_CANE_BLOCK;
    public static final GenericStorageBlock TOTEM_BLOCK;
    public static final GenericStorageBlock WALLPAPER_BLOCK;
    public static final GenericStorageBlock WHEAT_SEEDS_BLOCK;

    public static final List<GenericStorageBlock> STORAGE_BLOCKS;
    public static final List<GenericStorageBlock> BAGGED_BLOCKS;

    static {
        WHITE_DYE_BLOCK = new DyeBlock("white");
        ORANGE_DYE_BLOCK = new DyeBlock("orange");
        MAGENTA_DYE_BLOCK = new DyeBlock("magenta");
        LIGHT_BLUE_DYE_BLOCK = new DyeBlock("light_blue");
        YELLOW_DYE_BLOCK = new DyeBlock("yellow");
        LIME_DYE_BLOCK = new DyeBlock("lime");
        PINK_DYE_BLOCK = new DyeBlock("pink");
        GRAY_DYE_BLOCK = new DyeBlock("gray");
        LIGHT_GRAY_DYE_BLOCK = new DyeBlock("light_gray");
        CYAN_DYE_BLOCK = new DyeBlock("cyan");
        PURPLE_DYE_BLOCK = new DyeBlock("purple");
        BLUE_DYE_BLOCK = new DyeBlock("blue");
        BROWN_DYE_BLOCK = new DyeBlock("brown");
        GREEN_DYE_BLOCK = new DyeBlock("green");
        RED_DYE_BLOCK = new DyeBlock("red");
        BLACK_DYE_BLOCK = new DyeBlock("black");

        DYE_BLOCKS = List.of(
            WHITE_DYE_BLOCK,
            LIGHT_GRAY_DYE_BLOCK,
            GRAY_DYE_BLOCK,
            BLACK_DYE_BLOCK,
            BROWN_DYE_BLOCK,
            RED_DYE_BLOCK,
            ORANGE_DYE_BLOCK,
            YELLOW_DYE_BLOCK,
            LIME_DYE_BLOCK,
            GREEN_DYE_BLOCK,
            CYAN_DYE_BLOCK,
            LIGHT_BLUE_DYE_BLOCK,
            BLUE_DYE_BLOCK,
            PURPLE_DYE_BLOCK,
            MAGENTA_DYE_BLOCK,
            PINK_DYE_BLOCK
        );

        APPLE_STORAGE_BLOCK = new AppleStorageBlock();
        BEETROOT_BLOCK = new BeetrootStorageBlock();
        BEETROOT_SEEDS_BLOCK = new BeetrootSeedsStorageBlock();
        BLAZE_POWDER_BLOCK = new BlazePowderStorageBlock();
        BLAZE_ROD_BLOCK = new BlazeRodStorageBlock();
        CARROT_BLOCK = new CarrotStorageBlock();
        CHARCOAL_BLOCK = new CharcoalStorageBlock();
        CHORUS_FRUIT_BLOCK = new ChorusFruitStorageBlock();
        ENDER_PEARL_BLOCK = new EnderPearlStorageBlock();
        FLINT_BLOCK = new FlintStorageBlock();
        GOLD_NUGGET_SACK = new GoldNuggetSack();
        GOLDEN_APPLE_BLOCK = new GoldenAppleStorageBlock();
        IRON_NUGGET_SACK = new IronNuggetSack();
        LEATHER_BLOCK = new LeatherStorageBlock();
        MELON_SEEDS_BLOCK = new MelonSeedsStorageBlock();
        NETHER_STAR_BLOCK = new NetherStarStorageBlock();
        PHANTOM_MEMBRANE_BLOCK = new PhantomMembraneStorageBlock();
        POTATO_BLOCK = new PotatoStorageBlock();
        PUMPKIN_SEEDS_BLOCK = new PumpkinSeedsStorageBlock();
//        SET_OF_EGGS_BLOCK = new SetOfEggsBlock();
        STICK_BLOCK = new StickStorageBlock();
        SUGAR_BLOCK = new SugarStorageBlock();
        SUGAR_CANE_BLOCK = new SugarCaneStorageBlock();
        TOTEM_BLOCK = new TotemStorageBlock();
        WALLPAPER_BLOCK = new WallpaperStorageBlock();
        WHEAT_SEEDS_BLOCK = new WheatSeedsStorageBlock();

        STORAGE_BLOCKS = List.of(
            APPLE_STORAGE_BLOCK,
            BEETROOT_BLOCK,
            BEETROOT_SEEDS_BLOCK,
            BLAZE_POWDER_BLOCK,
            BLAZE_ROD_BLOCK,
            CARROT_BLOCK,
            CHARCOAL_BLOCK,
            CHORUS_FRUIT_BLOCK,
            ENDER_PEARL_BLOCK,
            FLINT_BLOCK,
            GOLD_NUGGET_SACK,
            GOLDEN_APPLE_BLOCK,
            IRON_NUGGET_SACK,
            LEATHER_BLOCK,
            MELON_SEEDS_BLOCK,
            NETHER_STAR_BLOCK,
            PHANTOM_MEMBRANE_BLOCK,
            POTATO_BLOCK,
            PUMPKIN_SEEDS_BLOCK,
            STICK_BLOCK,
            SUGAR_BLOCK,
            SUGAR_CANE_BLOCK,
            TOTEM_BLOCK,
            WALLPAPER_BLOCK,
            WHEAT_SEEDS_BLOCK
        );

        BAGGED_BLOCKS = List.of(
            BEETROOT_BLOCK,
            BEETROOT_SEEDS_BLOCK,
            CARROT_BLOCK,
            CHORUS_FRUIT_BLOCK,
            GOLD_NUGGET_SACK,
            IRON_NUGGET_SACK,
            MELON_SEEDS_BLOCK,
            PHANTOM_MEMBRANE_BLOCK,
            POTATO_BLOCK,
            PUMPKIN_SEEDS_BLOCK,
            SUGAR_BLOCK,
            WHEAT_SEEDS_BLOCK
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        DYE_BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getTranslucent()));
        BAGGED_BLOCKS.forEach(block -> BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout()));

//        BlockRenderLayerMap.INSTANCE.putBlock(SET_OF_EGGS_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(SUGAR_CANE_BLOCK, RenderLayer.getTranslucent());
    }

    @Override
    public void registerBlocks() {
        DYE_BLOCKS.forEach(DyeBlock::register);
        STORAGE_BLOCKS.forEach(GenericStorageBlock::register);
//        SET_OF_EGGS_BLOCK.register();

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS)
            .register((itemGroup) -> {
                DYE_BLOCKS.forEach(itemGroup::add);
            });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
            .register((itemGroup) -> {
                STORAGE_BLOCKS.forEach(itemGroup::add);
            });
    }

    @Override
    public void registerBlockEntities() {
    }

    @Override
    public void registerEntities() {
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        DYE_BLOCKS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
        STORAGE_BLOCKS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
//        SET_OF_EGGS_BLOCK.configureBlockTags(registryLookup, getBuilder);
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        DYE_BLOCKS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
        STORAGE_BLOCKS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
//        SET_OF_EGGS_BLOCK.configureItemTags(registryLookup, getBuilder);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        DYE_BLOCKS.forEach(block -> block.configureRecipes(exporter));
        STORAGE_BLOCKS.forEach(block -> block.configureRecipes(exporter));
//        SET_OF_EGGS_BLOCK.configureRecipes(exporter);
    }

    @Override
    public void configureBlockLootTables(BlockLootTableGenerator generator) {
        DYE_BLOCKS.forEach(block -> block.configureBlockLootTables(generator));
        STORAGE_BLOCKS.forEach(block -> block.configureBlockLootTables(generator));
//        SET_OF_EGGS_BLOCK.configureBlockLootTables(generator);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        DYE_BLOCKS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
        STORAGE_BLOCKS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
//        SET_OF_EGGS_BLOCK.configureTranslations(registryLookup, translationBuilder);
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        DYE_BLOCKS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
        STORAGE_BLOCKS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
//        SET_OF_EGGS_BLOCK.configureBlockStateModels(blockStateModelGenerator);
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        DYE_BLOCKS.forEach(block -> block.configureItemModels(itemModelGenerator));
        STORAGE_BLOCKS.forEach(block -> block.configureItemModels(itemModelGenerator));
//        SET_OF_EGGS_BLOCK.configureItemModels(itemModelGenerator);
    }
}
