package com.chimericdream.minekea.block.decorations.candles;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.lib.blocks.BlockDataGenerator;
import com.chimericdream.lib.blocks.RegisterableBlock;
import com.chimericdream.lib.colors.ColorHelpers;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.fabric.blocks.FabricItemGroupEventHelpers;
import com.chimericdream.lib.registries.RegistryHelpers;
import com.chimericdream.lib.util.ModConfigurable;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.tag.MinekeaItemTags;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CandleBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.function.Function;

public class GenericVotiveCandle extends CandleBlock implements BlockDataGenerator, FabricBlockDataGenerator, ModConfigurable, RegisterableBlock {
    protected static final Model VOTIVE_ITEM_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/candles/template_votive_item")),
        Optional.empty(),
        TextureKey.CANDLE,
        TextureKey.SIDE
    );
    protected static final Model ONE_VOTIVE_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/candles/template_votive_candle")),
        Optional.empty(),
        TextureKey.CANDLE,
        TextureKey.SIDE
    );
    protected static final Model ONE_VOTIVE_LIT_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/candles/template_votive_candle")),
        Optional.empty(),
        TextureKey.CANDLE,
        TextureKey.SIDE
    );
    protected static final Model TWO_VOTIVES_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/candles/template_two_votive_candles")),
        Optional.empty(),
        TextureKey.CANDLE,
        TextureKey.SIDE
    );
    protected static final Model TWO_VOTIVES_LIT_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/candles/template_two_votive_candles")),
        Optional.empty(),
        TextureKey.CANDLE,
        TextureKey.SIDE
    );
    protected static final Model THREE_VOTIVES_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/candles/template_three_votive_candles")),
        Optional.empty(),
        TextureKey.CANDLE,
        TextureKey.SIDE
    );
    protected static final Model THREE_VOTIVES_LIT_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/candles/template_three_votive_candles")),
        Optional.empty(),
        TextureKey.CANDLE,
        TextureKey.SIDE
    );
    protected static final Model FOUR_VOTIVES_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/candles/template_four_votive_candles")),
        Optional.empty(),
        TextureKey.CANDLE,
        TextureKey.SIDE
    );
    protected static final Model FOUR_VOTIVES_LIT_MODEL = new Model(
        Optional.of(Identifier.of(ModInfo.MOD_ID, "block/candles/template_four_votive_candles")),
        Optional.empty(),
        TextureKey.CANDLE,
        TextureKey.SIDE
    );

    public final Identifier BLOCK_ID;
    public final BlockConfig config;
    public final String color;

    public GenericVotiveCandle(BlockConfig config, String color) {
        super(config.getBaseSettings());

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("decorations/candles/%s_votive_candle", color));
        this.config = config;
        this.color = color;
    }

    public BlockConfig getConfig() {
        return config;
    }

    public void register() {
        RegistryHelpers.registerBlockWithItem(this, BLOCK_ID);
        FabricItemGroupEventHelpers.addBlockToItemGroup(this, ItemGroups.FUNCTIONAL);
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.CANDLES).add(this);
    }

    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(MinekeaItemTags.VOTIVE_CANDLES).add(this.asItem());
    }

    public void configureRecipes(RecipeExporter exporter) {
        Block ingredient = config.getIngredient();

        ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, this, 4)
            .input(ingredient, 4)
            .input(Items.GLASS)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .criterion(FabricRecipeProvider.hasItem(Items.GLASS),
                FabricRecipeProvider.conditionsFromItem(Items.GLASS))
            .offerTo(exporter);

        Item dye;
        if (color.equals("plain")) {
            dye = Items.ICE;
        } else {
            dye = ColorHelpers.getDye(color);
        }

        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, this, 8)
            .pattern("###")
            .pattern("#D#")
            .pattern("###")
            .input('#', Ingredient.fromTag(MinekeaItemTags.VOTIVE_CANDLES))
            .input('D', dye)
            .criterion("has_any_votive",
                FabricRecipeProvider.conditionsFromTag(MinekeaItemTags.VOTIVE_CANDLES))
            .criterion(FabricRecipeProvider.hasItem(dye),
                FabricRecipeProvider.conditionsFromItem(dye))
            .offerTo(exporter, BLOCK_ID.withSuffixedPath("_universal_dyeing"));
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this, generator.candleDrops(this));
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        if (color.equals("plain")) {
            translationBuilder.add(this, "Votive Candle");

            return;
        }

        translationBuilder.add(this, String.format("%s Votive Candle", ColorHelpers.getName(color)));
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Block ingredient = config.getIngredient();

        TextureMap textures = new TextureMap()
            .put(TextureKey.CANDLE, TextureMap.getId(ingredient))
            .put(TextureKey.SIDE, TextureMap.getId(Blocks.GLASS));
        TextureMap litTextures = new TextureMap()
            .put(TextureKey.CANDLE, TextureMap.getId(ingredient).withSuffixedPath("_lit"))
            .put(TextureKey.SIDE, TextureMap.getId(Blocks.GLASS));

        Identifier candleItemModelId = blockStateModelGenerator.createSubModel(this, "", VOTIVE_ITEM_MODEL, unused -> textures);
        Identifier oneCandleModelId = blockStateModelGenerator.createSubModel(this, "_one", ONE_VOTIVE_MODEL, unused -> textures);
        Identifier oneCandleLitModelId = blockStateModelGenerator.createSubModel(this, "_one_lit", ONE_VOTIVE_LIT_MODEL, unused -> litTextures);
        Identifier twoCandlesModelId = blockStateModelGenerator.createSubModel(this, "_two", TWO_VOTIVES_MODEL, unused -> textures);
        Identifier twoCandlesLitModelId = blockStateModelGenerator.createSubModel(this, "_two_lit", TWO_VOTIVES_LIT_MODEL, unused -> litTextures);
        Identifier threeCandlesModelId = blockStateModelGenerator.createSubModel(this, "_three", THREE_VOTIVES_MODEL, unused -> textures);
        Identifier threeCandlesLitModelId = blockStateModelGenerator.createSubModel(this, "_three_lit", THREE_VOTIVES_LIT_MODEL, unused -> litTextures);
        Identifier fourCandlesModelId = blockStateModelGenerator.createSubModel(this, "_four", FOUR_VOTIVES_MODEL, unused -> textures);
        Identifier fourCandlesLitModelId = blockStateModelGenerator.createSubModel(this, "_four_lit", FOUR_VOTIVES_LIT_MODEL, unused -> litTextures);

        blockStateModelGenerator.registerParentedItemModel(this, candleItemModelId);

        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(this)
                    .with(
                        When.create()
                            .set(CANDLES, 1)
                            .set(LIT, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, oneCandleModelId)
                    )
                    .with(
                        When.create()
                            .set(CANDLES, 1)
                            .set(LIT, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, oneCandleLitModelId)
                    )
                    .with(
                        When.create()
                            .set(CANDLES, 2)
                            .set(LIT, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, twoCandlesModelId)
                    )
                    .with(
                        When.create()
                            .set(CANDLES, 2)
                            .set(LIT, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, twoCandlesLitModelId)
                    )
                    .with(
                        When.create()
                            .set(CANDLES, 3)
                            .set(LIT, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, threeCandlesModelId)
                    )
                    .with(
                        When.create()
                            .set(CANDLES, 3)
                            .set(LIT, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, threeCandlesLitModelId)
                    )
                    .with(
                        When.create()
                            .set(CANDLES, 4)
                            .set(LIT, false),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, fourCandlesModelId)
                    )
                    .with(
                        When.create()
                            .set(CANDLES, 4)
                            .set(LIT, true),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, fourCandlesLitModelId)
                    )
            );
    }
}
