package com.chimericdream.minekea.item;

import com.chimericdream.minekea.item.tools.WrenchItem;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import com.chimericdream.minekea.util.MinekeaItem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;

import java.util.List;
import java.util.function.Function;

public class ModItems implements MinekeaBlockCategory {
    //    public static final NuggetBag GOLD_NUGGET_BAG;
//    public static final NuggetBag IRON_NUGGET_BAG;
//
//    public static final HammerItem STONE_HAMMER_ITEM;
//    public static final HammerItem IRON_HAMMER_ITEM;
//    public static final HammerItem GOLD_HAMMER_ITEM;
//    public static final HammerItem DIAMOND_HAMMER_ITEM;
//    public static final HammerItem NETHERITE_HAMMER_ITEM;
//    public static final PainterItem PAINTER_ITEM;
    public static final WrenchItem WRENCH_ITEM;

    public static final List<MinekeaItem> ITEMS;

//    public static ScreenHandlerType<BlockPainterScreenHandler> BLOCK_PAINTER_SCREEN_HANDLER;

    static {
//        GOLD_NUGGET_BAG = new NuggetBag(new NuggetSettings("gold", Identifier.of("minecraft:gold_nugget")));
//        IRON_NUGGET_BAG = new NuggetBag(new NuggetSettings("iron", Identifier.of("minecraft:iron_nugget")));
//
//        STONE_HAMMER_ITEM = new HammerItem(
//            new HammerSettings()
//                .material(ToolMaterials.STONE)
//                .maxSlots(4)
//                .materialName("Stone")
//                .ingredient(JIngredient.ingredient().tag(ItemTags.STONE_TOOL_MATERIALS.id().toString()))
//        );
//        IRON_HAMMER_ITEM = new HammerItem(
//            new HammerSettings()
//                .material(ToolMaterials.IRON)
//                .maxSlots(5)
//                .materialName("Iron")
//                .ingredient(JIngredient.ingredient().item(net.minecraft.item.Items.IRON_INGOT))
//        );
//        GOLD_HAMMER_ITEM = new HammerItem(
//            new HammerSettings()
//                .material(ToolMaterials.GOLD)
//                .maxSlots(6)
//                .materialName("Gold")
//                .ingredient(JIngredient.ingredient().item(net.minecraft.item.Items.GOLD_INGOT))
//        );
//        DIAMOND_HAMMER_ITEM = new HammerItem(
//            new HammerSettings()
//                .material(ToolMaterials.DIAMOND)
//                .maxSlots(7)
//                .materialName("Diamond")
//                .ingredient(JIngredient.ingredient().item(net.minecraft.item.Items.DIAMOND))
//        );
//        NETHERITE_HAMMER_ITEM = new HammerItem(
//            (HammerSettings) new HammerSettings()
//                .material(ToolMaterials.NETHERITE)
//                .maxSlots(8)
//                .materialName("Netherite")
//                .ingredient(JIngredient.ingredient().item(net.minecraft.item.Items.NETHERITE_INGOT))
//                .smithingIngredient(JIngredient.ingredient().item(Identifier.of(ModInfo.MOD_ID, "tools/hammers/diamond").toString()))
//                .fireproof()
//        );
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
            WRENCH_ITEM
        );
    }

    public void register() {
//        GOLD_NUGGET_BAG.register(GOLD_NUGGET_BAG);
//        IRON_NUGGET_BAG.register(IRON_NUGGET_BAG);
//
//        STONE_HAMMER_ITEM.register();
//        IRON_HAMMER_ITEM.register();
//        GOLD_HAMMER_ITEM.register();
//        DIAMOND_HAMMER_ITEM.register();
//        NETHERITE_HAMMER_ITEM.register();
//        PAINTER_ITEM.register();

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
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        ITEMS.forEach(item -> item.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        ITEMS.forEach(item -> item.configureItemModels(itemModelGenerator));
    }

//
//    public void setupResources() {
//        MinekeaResourcePack.EN_US.entry("category.minekea", "Minekea");
//    }
}
