package com.chimericdream.minekea.item.ingredients;

import com.chimericdream.lib.colors.ColorHelpers;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaItem;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

public class WaxItem extends Item implements MinekeaItem {
    public final Identifier ITEM_ID;

    protected final String color;
    protected final Item ingredient;

    public WaxItem(String color, Item ingredient) {
        super(new Item.Settings());

        ITEM_ID = makeId(color);

        this.color = color;
        this.ingredient = ingredient;
    }

    public static Identifier makeId(String color) {
        return Identifier.of(ModInfo.MOD_ID, String.format("ingredients/wax/%s", color));
    }

    @Override
    public void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
            .register(itemGroup -> itemGroup.add(this));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        CookingRecipeJsonBuilder.createSmelting(
                Ingredient.ofItems(ingredient),
                RecipeCategory.MISC,
                this,
                0.1f,
                200
            )
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .offerTo(exporter);

        if (color.equals("plain")) {
            CookingRecipeJsonBuilder.createSmelting(
                    Ingredient.ofItems(Items.HONEYCOMB),
                    RecipeCategory.MISC,
                    this,
                    0.1f,
                    200
                )
                .criterion(FabricRecipeProvider.hasItem(Items.HONEYCOMB),
                    FabricRecipeProvider.conditionsFromItem(Items.HONEYCOMB))
                .offerTo(exporter, ITEM_ID.withSuffixedPath("_from_honeycomb"));
        }
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        if (color.equals("plain")) {
            translationBuilder.add(this, "Wax");

            return;
        }

        translationBuilder.add(this, String.format("%s Wax", ColorHelpers.getName(color)));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(this, Models.GENERATED);
    }
}
