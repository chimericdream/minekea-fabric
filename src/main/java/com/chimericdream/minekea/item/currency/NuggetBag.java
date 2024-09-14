package com.chimericdream.minekea.item.currency;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaItem;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

public class NuggetBag extends Item implements MinekeaItem {
    public final Identifier ITEM_ID;

    protected final String material;
    protected final Item ingredient;

    public NuggetBag(String material, Item ingredient) {
        super(new Item.Settings());

        ITEM_ID = makeItemId(material);

        this.material = material;
        this.ingredient = ingredient;
    }

    public static Identifier makeItemId(String material) {
        return Identifier.of(ModInfo.MOD_ID, String.format("currency/%s_nugget_bag", material.toLowerCase()));
    }

    @Override
    public void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
            .register(itemGroup -> itemGroup.add(this));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, this, 1)
            .pattern("##")
            .pattern("##")
            .input('#', ingredient)
            .criterion(FabricRecipeProvider.hasItem(ingredient),
                FabricRecipeProvider.conditionsFromItem(ingredient))
            .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ingredient, 4)
            .input(this)
            .criterion(FabricRecipeProvider.hasItem(this),
                FabricRecipeProvider.conditionsFromItem(this))
            .offerTo(exporter, Registries.ITEM.getId(ingredient).withSuffixedPath("_from_bag"));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Nugget Bag", material));
    }
}
