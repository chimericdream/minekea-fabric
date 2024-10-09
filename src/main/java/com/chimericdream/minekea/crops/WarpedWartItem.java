package com.chimericdream.minekea.crops;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaItem;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

public class WarpedWartItem extends AliasedBlockItem implements MinekeaItem {
    public static final Identifier ITEM_ID = Identifier.of(ModInfo.MOD_ID, "crops/warped_wart");

    public WarpedWartItem() {
        super(Crops.WARPED_WART_PLANT_BLOCK, new Item.Settings());
    }

    @Override
    public void register() {
        Registry.register(Registries.ITEM, ITEM_ID, this);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(itemGroup -> itemGroup.add(this));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 9)
            .input(Blocks.WARPED_WART_BLOCK)
            .criterion(FabricRecipeProvider.hasItem(Blocks.WARPED_WART_BLOCK),
                FabricRecipeProvider.conditionsFromItem(Blocks.WARPED_WART_BLOCK))
            .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Blocks.WARPED_WART_BLOCK, 1)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .input('#', this)
            .criterion(FabricRecipeProvider.hasItem(this),
                FabricRecipeProvider.conditionsFromItem(this))
            .offerTo(exporter);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Warped Wart");
    }
}
