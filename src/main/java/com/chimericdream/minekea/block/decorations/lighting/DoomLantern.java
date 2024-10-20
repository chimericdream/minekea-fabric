package com.chimericdream.minekea.block.decorations.lighting;

import com.chimericdream.lib.blocks.RegisterableBlock;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.fabric.blocks.FabricItemGroupEventHelpers;
import com.chimericdream.lib.registries.RegistryHelpers;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.ModelUtils;
import com.chimericdream.minekea.tag.MinekeaBlockTags;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LanternBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class DoomLantern extends LanternBlock implements FabricBlockDataGenerator, RegisterableBlock {
    public static final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "decorations/lighting/doom_lantern");

    public DoomLantern() {
        super(AbstractBlock.Settings.copy(Blocks.LANTERN).nonOpaque());
    }

    public void register() {
        RegistryHelpers.registerBlockWithItem(this, BLOCK_ID);
        FabricItemGroupEventHelpers.addBlockToItemGroup(this, ItemGroups.FUNCTIONAL);
    }

    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(MinekeaBlockTags.LANTERNS).add(this);
    }

    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, this, 1)
            .pattern("###")
            .pattern("#F#")
            .pattern("#T#")
            .input('#', Items.IRON_NUGGET)
            .input('F', Items.CRIMSON_FUNGUS)
            .input('T', Items.TORCH)
            .criterion(FabricRecipeProvider.hasItem(Items.IRON_NUGGET),
                FabricRecipeProvider.conditionsFromItem(Items.IRON_NUGGET))
            .criterion(FabricRecipeProvider.hasItem(Items.CRIMSON_FUNGUS),
                FabricRecipeProvider.conditionsFromItem(Items.CRIMSON_FUNGUS))
            .criterion(FabricRecipeProvider.hasItem(Items.TORCH),
                FabricRecipeProvider.conditionsFromItem(Items.TORCH))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Doom Lantern");
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        ModelUtils.registerLanternBlock(blockStateModelGenerator, this, BLOCK_ID);
    }

    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        ModelUtils.registerGeneratedItem(itemModelGenerator, this, BLOCK_ID);
    }
}
