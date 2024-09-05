//package com.chimericdream.minekea.item;
//
//import com.chimericdream.minekea.ModInfo;
//import com.chimericdream.minekea.item.currency.NuggetBag;
//import com.chimericdream.minekea.item.currency.NuggetBag.NuggetSettings;
//import com.chimericdream.minekea.item.tools.HammerItem;
//import com.chimericdream.minekea.item.tools.HammerItem.HammerSettings;
//import com.chimericdream.minekea.item.tools.PainterItem;
//import com.chimericdream.minekea.item.tools.WrenchItem;
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import com.chimericdream.minekea.screen.item.BlockPainterScreen;
//import com.chimericdream.minekea.screen.item.BlockPainterScreenHandler;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.minecraft.item.ToolMaterials;
//import net.minecraft.registry.tag.ItemTags;
//import net.minecraft.screen.ScreenHandlerType;
//import net.minecraft.util.Identifier;
//
//public class Items {
//    public static final NuggetBag GOLD_NUGGET_BAG;
//    public static final NuggetBag IRON_NUGGET_BAG;
//
//    public static final HammerItem STONE_HAMMER_ITEM;
//    public static final HammerItem IRON_HAMMER_ITEM;
//    public static final HammerItem GOLD_HAMMER_ITEM;
//    public static final HammerItem DIAMOND_HAMMER_ITEM;
//    public static final HammerItem NETHERITE_HAMMER_ITEM;
//    public static final PainterItem PAINTER_ITEM;
//    public static final WrenchItem WRENCH_ITEM;
//
//    public static ScreenHandlerType<BlockPainterScreenHandler> BLOCK_PAINTER_SCREEN_HANDLER;
//
//    static {
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
//        WRENCH_ITEM = new WrenchItem();
//
//        BLOCK_PAINTER_SCREEN_HANDLER = ScreenHandlerRegistry.registerExtended(
//            Identifier.of(ModInfo.MOD_ID, "screens/items/block_painter"),
//            BlockPainterScreenHandler::new
//        );
//    }
//
//    public void register() {
//        GOLD_NUGGET_BAG.register(GOLD_NUGGET_BAG);
//        IRON_NUGGET_BAG.register(IRON_NUGGET_BAG);
//
//        STONE_HAMMER_ITEM.register();
//        IRON_HAMMER_ITEM.register();
//        GOLD_HAMMER_ITEM.register();
//        DIAMOND_HAMMER_ITEM.register();
//        NETHERITE_HAMMER_ITEM.register();
//        PAINTER_ITEM.register();
//        WRENCH_ITEM.register();
//    }
//
//    @Environment(EnvType.CLIENT)
//    public void initializeClient() {
//        ScreenRegistry.register(BLOCK_PAINTER_SCREEN_HANDLER, BlockPainterScreen::new);
//    }
//
//    public void setupResources() {
//        MinekeaResourcePack.EN_US.entry("category.minekea", "Minekea");
//    }
//}
