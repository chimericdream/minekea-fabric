package com.chimericdream.minekea.block.decorations;

import com.chimericdream.lib.blocks.ModBlock;
import com.chimericdream.lib.blocks.ModBlockDataGenerator;
import com.chimericdream.lib.fabric.blocks.FabricModBlockDataGenerator;
import com.chimericdream.lib.util.Registerable;
import com.chimericdream.minekea.block.decorations.candles.GenericVotiveCandle;
import com.chimericdream.minekea.block.decorations.lighting.AncientLantern;
import com.chimericdream.minekea.block.decorations.lighting.DoomLantern;
import com.chimericdream.minekea.block.decorations.lighting.EndLantern;
import com.chimericdream.minekea.block.decorations.lighting.EndlessRod;
import com.chimericdream.minekea.block.decorations.misc.FakeCake;
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

    public static final List<Registerable> BLOCKS = new ArrayList<>();

    public static final Map<String, GenericVotiveCandle> VOTIVE_CANDLES = new LinkedHashMap<>();

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

        VOTIVE_CANDLES.put("plain", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.CANDLE), "plain"));
        VOTIVE_CANDLES.put("white", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.WHITE_CANDLE), "white"));
        VOTIVE_CANDLES.put("light_gray", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.LIGHT_GRAY_CANDLE), "light_gray"));
        VOTIVE_CANDLES.put("gray", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.GRAY_CANDLE), "gray"));
        VOTIVE_CANDLES.put("black", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.BLACK_CANDLE), "black"));
        VOTIVE_CANDLES.put("brown", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.BROWN_CANDLE), "brown"));
        VOTIVE_CANDLES.put("red", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.RED_CANDLE), "red"));
        VOTIVE_CANDLES.put("orange", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.ORANGE_CANDLE), "orange"));
        VOTIVE_CANDLES.put("yellow", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.YELLOW_CANDLE), "yellow"));
        VOTIVE_CANDLES.put("lime", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.LIME_CANDLE), "lime"));
        VOTIVE_CANDLES.put("green", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.GREEN_CANDLE), "green"));
        VOTIVE_CANDLES.put("cyan", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.CYAN_CANDLE), "cyan"));
        VOTIVE_CANDLES.put("light_blue", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.LIGHT_BLUE_CANDLE), "light_blue"));
        VOTIVE_CANDLES.put("blue", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.BLUE_CANDLE), "blue"));
        VOTIVE_CANDLES.put("purple", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.PURPLE_CANDLE), "purple"));
        VOTIVE_CANDLES.put("magenta", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.MAGENTA_CANDLE), "magenta"));
        VOTIVE_CANDLES.put("pink", new GenericVotiveCandle(new ModBlock.Config().ingredient(Blocks.PINK_CANDLE), "pink"));

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
        BLOCKS.forEach(Registerable::register);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        BLOCKS.forEach(block -> ((FabricModBlockDataGenerator) block).configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        BLOCKS.forEach(block -> ((FabricModBlockDataGenerator) block).configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        BLOCKS.forEach(block -> ((ModBlockDataGenerator) block).configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        BLOCKS.forEach(block -> ((ModBlockDataGenerator) block).configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        BLOCKS.forEach(block -> ((FabricModBlockDataGenerator) block).configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BLOCKS.forEach(block -> ((ModBlockDataGenerator) block).configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BLOCKS.forEach(block -> ((ModBlockDataGenerator) block).configureItemModels(itemModelGenerator));
    }
}
