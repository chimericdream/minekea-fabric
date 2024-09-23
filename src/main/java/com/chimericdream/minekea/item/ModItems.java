package com.chimericdream.minekea.item;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.item.ingredients.WaxItem;
import com.chimericdream.minekea.item.tools.HammerItem;
import com.chimericdream.minekea.item.tools.PainterItem;
import com.chimericdream.minekea.item.tools.WrenchItem;
import com.chimericdream.minekea.screen.item.BlockPainterScreen;
import com.chimericdream.minekea.screen.item.BlockPainterScreenHandler;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import com.chimericdream.minekea.util.MinekeaItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
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
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class ModItems implements MinekeaBlockCategory {
    public static final HammerItem STONE_HAMMER_ITEM;
    public static final HammerItem IRON_HAMMER_ITEM;
    public static final HammerItem GOLD_HAMMER_ITEM;
    public static final HammerItem DIAMOND_HAMMER_ITEM;
    public static final HammerItem NETHERITE_HAMMER_ITEM;
    public static final PainterItem PAINTER_ITEM;
    public static final WrenchItem WRENCH_ITEM;

    public static final Map<String, MinekeaItem> WAX_ITEMS = new LinkedHashMap<>();
    public static final List<MinekeaItem> ITEMS = new ArrayList<>();

    public static ScreenHandlerType<BlockPainterScreenHandler> BLOCK_PAINTER_SCREEN_HANDLER;

    static {
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
        PAINTER_ITEM = Registry.register(
            Registries.ITEM,
            PainterItem.ITEM_ID,
            new PainterItem()
        );
        WRENCH_ITEM = Registry.register(
            Registries.ITEM,
            WrenchItem.ITEM_ID,
            new WrenchItem()
        );

        WAX_ITEMS.put("plain", Registry.register(Registries.ITEM, WaxItem.makeId("plain"), new WaxItem("plain", Items.CANDLE)));
        WAX_ITEMS.put("white", Registry.register(Registries.ITEM, WaxItem.makeId("white"), new WaxItem("white", Items.WHITE_CANDLE)));
        WAX_ITEMS.put("light_gray", Registry.register(Registries.ITEM, WaxItem.makeId("light_gray"), new WaxItem("light_gray", Items.LIGHT_GRAY_CANDLE)));
        WAX_ITEMS.put("gray", Registry.register(Registries.ITEM, WaxItem.makeId("gray"), new WaxItem("gray", Items.GRAY_CANDLE)));
        WAX_ITEMS.put("black", Registry.register(Registries.ITEM, WaxItem.makeId("black"), new WaxItem("black", Items.BLACK_CANDLE)));
        WAX_ITEMS.put("brown", Registry.register(Registries.ITEM, WaxItem.makeId("brown"), new WaxItem("brown", Items.BROWN_CANDLE)));
        WAX_ITEMS.put("red", Registry.register(Registries.ITEM, WaxItem.makeId("red"), new WaxItem("red", Items.RED_CANDLE)));
        WAX_ITEMS.put("orange", Registry.register(Registries.ITEM, WaxItem.makeId("orange"), new WaxItem("orange", Items.ORANGE_CANDLE)));
        WAX_ITEMS.put("yellow", Registry.register(Registries.ITEM, WaxItem.makeId("yellow"), new WaxItem("yellow", Items.YELLOW_CANDLE)));
        WAX_ITEMS.put("lime", Registry.register(Registries.ITEM, WaxItem.makeId("lime"), new WaxItem("lime", Items.LIME_CANDLE)));
        WAX_ITEMS.put("green", Registry.register(Registries.ITEM, WaxItem.makeId("green"), new WaxItem("green", Items.GREEN_CANDLE)));
        WAX_ITEMS.put("cyan", Registry.register(Registries.ITEM, WaxItem.makeId("cyan"), new WaxItem("cyan", Items.CYAN_CANDLE)));
        WAX_ITEMS.put("light_blue", Registry.register(Registries.ITEM, WaxItem.makeId("light_blue"), new WaxItem("light_blue", Items.LIGHT_BLUE_CANDLE)));
        WAX_ITEMS.put("blue", Registry.register(Registries.ITEM, WaxItem.makeId("blue"), new WaxItem("blue", Items.BLUE_CANDLE)));
        WAX_ITEMS.put("purple", Registry.register(Registries.ITEM, WaxItem.makeId("purple"), new WaxItem("purple", Items.PURPLE_CANDLE)));
        WAX_ITEMS.put("magenta", Registry.register(Registries.ITEM, WaxItem.makeId("magenta"), new WaxItem("magenta", Items.MAGENTA_CANDLE)));
        WAX_ITEMS.put("pink", Registry.register(Registries.ITEM, WaxItem.makeId("pink"), new WaxItem("pink", Items.PINK_CANDLE)));

        BLOCK_PAINTER_SCREEN_HANDLER = Registry.register(
            Registries.SCREEN_HANDLER,
            Identifier.of(ModInfo.MOD_ID, "screens/items/block_painter"),
            new ScreenHandlerType<>(BlockPainterScreenHandler::new, FeatureSet.empty())
        );

        ITEMS.addAll(List.of(
            STONE_HAMMER_ITEM,
            IRON_HAMMER_ITEM,
            GOLD_HAMMER_ITEM,
            DIAMOND_HAMMER_ITEM,
            NETHERITE_HAMMER_ITEM,
            PAINTER_ITEM,
            WRENCH_ITEM
        ));

        ITEMS.addAll(WAX_ITEMS.values());
    }

    public void register() {
        ITEMS.forEach(MinekeaItem::register);
    }

    @Environment(EnvType.CLIENT)
    public void initializeClient() {
        HandledScreens.register(BLOCK_PAINTER_SCREEN_HANDLER, BlockPainterScreen::new);
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
