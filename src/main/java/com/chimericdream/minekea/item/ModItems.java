package com.chimericdream.minekea.item;

import com.chimericdream.minekea.item.tools.HammerItem;
import com.chimericdream.minekea.item.tools.WrenchItem;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import com.chimericdream.minekea.util.MinekeaItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterials;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.function.Function;

public class ModItems implements MinekeaBlockCategory {
    //    public static final NuggetBag GOLD_NUGGET_BAG;
//    public static final NuggetBag IRON_NUGGET_BAG;
//
    public static final HammerItem STONE_HAMMER_ITEM;
    public static final HammerItem IRON_HAMMER_ITEM;
    public static final HammerItem GOLD_HAMMER_ITEM;
    public static final HammerItem DIAMOND_HAMMER_ITEM;
    public static final HammerItem NETHERITE_HAMMER_ITEM;
    //    public static final PainterItem PAINTER_ITEM;
    public static final WrenchItem WRENCH_ITEM;

    public static final List<MinekeaItem> ITEMS;

//    public static ScreenHandlerType<BlockPainterScreenHandler> BLOCK_PAINTER_SCREEN_HANDLER;

    static {
//        GOLD_NUGGET_BAG = new NuggetBag(new NuggetSettings("gold", Identifier.of("minecraft:gold_nugget")));
//        IRON_NUGGET_BAG = new NuggetBag(new NuggetSettings("iron", Identifier.of("minecraft:iron_nugget")));
//
        STONE_HAMMER_ITEM = Registry.register(
            Registries.ITEM,
            HammerItem.makeItemId("stone"),
            new HammerItem(
                ToolMaterials.STONE,
                4,
                "Stone",
                null,
                ItemTags.STONE_TOOL_MATERIALS
            )
        );
        IRON_HAMMER_ITEM = Registry.register(
            Registries.ITEM,
            HammerItem.makeItemId("iron"),
            new HammerItem(
                ToolMaterials.IRON,
                5,
                "Iron",
                Items.IRON_INGOT,
                null
            )
        );
        GOLD_HAMMER_ITEM = Registry.register(
            Registries.ITEM,
            HammerItem.makeItemId("gold"),
            new HammerItem(
                ToolMaterials.GOLD,
                6,
                "Gold",
                Items.GOLD_INGOT,
                null
            )
        );
        DIAMOND_HAMMER_ITEM = Registry.register(
            Registries.ITEM,
            HammerItem.makeItemId("diamond"),
            new HammerItem(
                ToolMaterials.DIAMOND,
                7,
                "Diamond",
                Items.DIAMOND,
                null
            )
        );
        NETHERITE_HAMMER_ITEM = Registry.register(
            Registries.ITEM,
            HammerItem.makeItemId("netherite"),
            new HammerItem(
                ToolMaterials.NETHERITE,
                8,
                "Netherite",
                Items.NETHERITE_INGOT,
                null,
                new Item.Settings().fireproof()
            )
        );
//        PAINTER_ITEM = new PainterItem();
        WRENCH_ITEM = Registry.register(
            Registries.ITEM,
            WrenchItem.ITEM_ID,
            new WrenchItem()
        );

//        BLOCK_PAINTER_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(
//            Identifier.of(ModInfo.MOD_ID, "screens/items/block_painter"),
//            BlockPainterScreenHandler::new
//        );

        ITEMS = List.of(
            STONE_HAMMER_ITEM,
            IRON_HAMMER_ITEM,
            GOLD_HAMMER_ITEM,
            DIAMOND_HAMMER_ITEM,
            NETHERITE_HAMMER_ITEM,
            WRENCH_ITEM
        );
    }

    public void register() {
//        GOLD_NUGGET_BAG.register(GOLD_NUGGET_BAG);
//        IRON_NUGGET_BAG.register(IRON_NUGGET_BAG);

        ITEMS.forEach(MinekeaItem::register);
    }

    @Environment(EnvType.CLIENT)
    public void initializeClient() {
//        ScreenRegistry.register(BLOCK_PAINTER_SCREEN_HANDLER, BlockPainterScreen::new);
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        ITEMS.forEach(item -> item.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ITEMS.forEach(item -> item.configureRecipes(exporter));

        SmithingTransformRecipeJsonBuilder.create(
                Ingredient.ofItems(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.ofItems(DIAMOND_HAMMER_ITEM),
                Ingredient.ofItems(Items.NETHERITE_INGOT),
                RecipeCategory.TOOLS,
                NETHERITE_HAMMER_ITEM
            )
            .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE))
            .criterion(FabricRecipeProvider.hasItem(DIAMOND_HAMMER_ITEM),
                FabricRecipeProvider.conditionsFromItem(DIAMOND_HAMMER_ITEM))
            .criterion(FabricRecipeProvider.hasItem(Items.NETHERITE_INGOT),
                FabricRecipeProvider.conditionsFromItem(Items.NETHERITE_INGOT))
            .offerTo(exporter, NETHERITE_HAMMER_ITEM.ITEM_ID.withSuffixedPath("_upgrade_from_diamond"));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        ITEMS.forEach(item -> item.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        ITEMS.forEach(item -> item.configureItemModels(itemModelGenerator));
    }
}
