package com.chimericdream.minekea.block.building.general;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.chimericdream.minekea.block.building.BuildingBlocks.BASALT_BRICKS_BLOCK;

public class CrimsonBasaltBricksBlock extends Block implements MinekeaBlock {
    public static final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "building/general/crimson_basalt_bricks");

    public CrimsonBasaltBricksBlock() {
        super(AbstractBlock.Settings.copy(Blocks.SMOOTH_BASALT));
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(BlockTags.PICKAXE_MINEABLE)
            .setReplace(false)
            .add(this);
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 1)
            .input(BASALT_BRICKS_BLOCK)
            .input(Blocks.WEEPING_VINES)
            .criterion(FabricRecipeProvider.hasItem(BASALT_BRICKS_BLOCK),
                FabricRecipeProvider.conditionsFromItem(BASALT_BRICKS_BLOCK))
            .criterion(FabricRecipeProvider.hasItem(Blocks.WEEPING_VINES),
                FabricRecipeProvider.conditionsFromItem(Blocks.WEEPING_VINES))
            .offerTo(exporter);

        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICKS_BLOCK, this, 1);

    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Crimson Basalt Bricks");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(this);
    }
}
