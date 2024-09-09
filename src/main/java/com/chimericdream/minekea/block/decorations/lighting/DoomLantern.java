package com.chimericdream.minekea.block.decorations.lighting;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.ModelUtils;
import com.chimericdream.minekea.tag.MinekeaTags;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LanternBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class DoomLantern extends LanternBlock implements MinekeaBlock {
    private final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "decorations/lighting/doom_lantern");

    public DoomLantern() {
        super(AbstractBlock.Settings.copy(Blocks.LANTERN).nonOpaque());
    }

    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
            .register(itemGroup -> itemGroup.add(this.asItem()));
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(MinekeaTags.LANTERNS).add(this);
    }

    @Override
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

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Doom Lantern");
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        ModelUtils.registerLanternBlock(blockStateModelGenerator, this, BLOCK_ID);
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        ModelUtils.registerGeneratedItem(itemModelGenerator, this, BLOCK_ID);
    }
}
