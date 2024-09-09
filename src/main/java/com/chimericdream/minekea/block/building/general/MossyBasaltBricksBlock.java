package com.chimericdream.minekea.block.building.general;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.tag.MinecraftBlockTags;
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
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.chimericdream.minekea.block.building.BuildingBlocks.BASALT_BRICKS_BLOCK;

public class MossyBasaltBricksBlock extends Block implements MinekeaBlock {
    public static final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "building/general/mossy_basalt_bricks");

    public MossyBasaltBricksBlock() {
        super(AbstractBlock.Settings.copy(Blocks.SMOOTH_BASALT));
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(MinecraftBlockTags.MINEABLE_PICKAXE)
            .setReplace(false)
            .add(this);
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 1)
            .input(BASALT_BRICKS_BLOCK)
            .input(Blocks.VINE)
            .criterion(FabricRecipeProvider.hasItem(BASALT_BRICKS_BLOCK),
                FabricRecipeProvider.conditionsFromItem(BASALT_BRICKS_BLOCK))
            .criterion(FabricRecipeProvider.hasItem(Blocks.VINE),
                FabricRecipeProvider.conditionsFromItem(Blocks.VINE))
            .offerTo(exporter);

        RecipeProvider.offerStonecuttingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, BASALT_BRICKS_BLOCK, this, 1);
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Mossy Basalt Bricks");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(this);
    }
}
