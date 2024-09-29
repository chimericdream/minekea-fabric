package com.chimericdream.minekea.block.decorations;

import com.chimericdream.minekea.block.decorations.candles.GenericVotiveCandle;
import com.chimericdream.minekea.block.decorations.lighting.AncientLantern;
import com.chimericdream.minekea.block.decorations.lighting.DoomLantern;
import com.chimericdream.minekea.block.decorations.lighting.EndLantern;
import com.chimericdream.minekea.block.decorations.lighting.EndlessRod;
import com.chimericdream.minekea.block.decorations.misc.FakeCake;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class DecorationBlocks implements MinekeaBlockCategory {
    public static final AncientLantern ANCIENT_LANTERN;
    public static final DoomLantern DOOM_LANTERN;
    public static final EndLantern END_LANTERN;
    public static final EndlessRod ENDLESS_ROD;
    public static final FakeCake FAKE_CAKE;

    public static final List<MinekeaBlock> BLOCKS = new ArrayList<>();

    public static final Map<String, MinekeaBlock> VOTIVE_CANDLES = new LinkedHashMap<>();

    static {
        ANCIENT_LANTERN = new AncientLantern();
        DOOM_LANTERN = new DoomLantern();
        END_LANTERN = new EndLantern();
        ENDLESS_ROD = new EndlessRod();
        FAKE_CAKE = new FakeCake();

        BLOCKS.add(ANCIENT_LANTERN);
        BLOCKS.add(DOOM_LANTERN);
        BLOCKS.add(END_LANTERN);
        BLOCKS.add(ENDLESS_ROD);
        BLOCKS.add(FAKE_CAKE);

        VOTIVE_CANDLES.put("plain", new GenericVotiveCandle("plain", Blocks.CANDLE));
        VOTIVE_CANDLES.put("white", new GenericVotiveCandle("white", Blocks.WHITE_CANDLE));
        VOTIVE_CANDLES.put("light_gray", new GenericVotiveCandle("light_gray", Blocks.LIGHT_GRAY_CANDLE));
        VOTIVE_CANDLES.put("gray", new GenericVotiveCandle("gray", Blocks.GRAY_CANDLE));
        VOTIVE_CANDLES.put("black", new GenericVotiveCandle("black", Blocks.BLACK_CANDLE));
        VOTIVE_CANDLES.put("brown", new GenericVotiveCandle("brown", Blocks.BROWN_CANDLE));
        VOTIVE_CANDLES.put("red", new GenericVotiveCandle("red", Blocks.RED_CANDLE));
        VOTIVE_CANDLES.put("orange", new GenericVotiveCandle("orange", Blocks.ORANGE_CANDLE));
        VOTIVE_CANDLES.put("yellow", new GenericVotiveCandle("yellow", Blocks.YELLOW_CANDLE));
        VOTIVE_CANDLES.put("lime", new GenericVotiveCandle("lime", Blocks.LIME_CANDLE));
        VOTIVE_CANDLES.put("green", new GenericVotiveCandle("green", Blocks.GREEN_CANDLE));
        VOTIVE_CANDLES.put("cyan", new GenericVotiveCandle("cyan", Blocks.CYAN_CANDLE));
        VOTIVE_CANDLES.put("light_blue", new GenericVotiveCandle("light_blue", Blocks.LIGHT_BLUE_CANDLE));
        VOTIVE_CANDLES.put("blue", new GenericVotiveCandle("blue", Blocks.BLUE_CANDLE));
        VOTIVE_CANDLES.put("purple", new GenericVotiveCandle("purple", Blocks.PURPLE_CANDLE));
        VOTIVE_CANDLES.put("magenta", new GenericVotiveCandle("magenta", Blocks.MAGENTA_CANDLE));
        VOTIVE_CANDLES.put("pink", new GenericVotiveCandle("pink", Blocks.PINK_CANDLE));

        BLOCKS.addAll(VOTIVE_CANDLES.values());
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ANCIENT_LANTERN, DOOM_LANTERN, END_LANTERN);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), VOTIVE_CANDLES.values().toArray(new Block[0]));
    }

    @Override
    public void registerBlocks() {
        BLOCKS.forEach(MinekeaBlock::register);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        BLOCKS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        BLOCKS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        BLOCKS.forEach(block -> block.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        BLOCKS.forEach(block -> block.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        BLOCKS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BLOCKS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BLOCKS.forEach(block -> block.configureItemModels(itemModelGenerator));
    }
}
