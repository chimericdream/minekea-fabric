//package com.chimericdream.minekea.block.decorations.lighting;
//
//import com.chimericdream.minekea.ModInfo;
//import com.chimericdream.minekea.resource.LootTable;
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import com.chimericdream.minekea.resource.MinekeaTags;
//import com.chimericdream.minekea.util.MinekeaBlock;
//import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.EndRodBlock;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.util.Identifier;
//
//public class EndlessRod extends EndRodBlock implements MinekeaBlock {
//    private final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "decorations/lighting/endless_rod");
//
//    public EndlessRod() {
//        super(AbstractBlock.Settings.copy(Blocks.END_ROD));
//    }
//
//    public Identifier getBlockID() {
//        return BLOCK_ID;
//    }
//
//    public void register() {
//        Registry.register(Registries.BLOCK, BLOCK_ID, this);
//        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));
//
//        setupResources();
//    }
//
//    public void setupResources() {
//        MinekeaResourcePack.EN_US.blockRespect(this, "End(less) Rod");
//        MinekeaTags.LANTERNS.add(getBlockID());
//
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            BLOCK_ID,
//            JRecipe.shapeless(
//                JIngredients.ingredients().add(JIngredient.ingredient().item("minecraft:end_rod")),
//                JResult.result(BLOCK_ID.toString())
//            )
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            Identifier.of(ModInfo.MOD_ID, "decorations/end_rod_from_endless_rod"),
//            JRecipe.shapeless(
//                JIngredients.ingredients().add(JIngredient.ingredient().item(BLOCK_ID.toString())),
//                JResult.result("minecraft:end_rod")
//            )
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));
//    }
//}
