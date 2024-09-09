//package com.chimericdream.minekea.block.decorations.misc;
//
//import com.chimericdream.minekea.ModInfo;
//import com.chimericdream.minekea.resource.LootTable;
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import com.chimericdream.minekea.resource.Model;
//import com.chimericdream.minekea.util.MinekeaBlock;
//import com.chimericdream.minekea.util.TextHelpers;
//import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.CakeBlock;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.tooltip.TooltipType;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.text.Text;
//import net.minecraft.util.ActionResult;
//import net.minecraft.util.Hand;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.hit.BlockHitResult;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//
//import java.util.List;
//
//public class FakeCake extends CakeBlock implements MinekeaBlock {
//    public final static String TOOLTIP_KEY = "block.minekea.decorations.misc.fake_cake.tooltip";
//    private final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "decorations/misc/fake_cake");
//
//    public FakeCake() {
//        super(AbstractBlock.Settings.copy(Blocks.CAKE));
//    }
//
//    @Override
//    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
//        return ActionResult.SUCCESS;
//    }
//
//    @Override
//    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
//        tooltip.add(TextHelpers.getTooltip(TOOLTIP_KEY));
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
//        MinekeaResourcePack.EN_US.entry(TOOLTIP_KEY, "This cake is a lie!");
//        MinekeaResourcePack.EN_US.blockRespect(this, "Cake");
//
//        Identifier MODEL_ID = Model.getBlockModelID(BLOCK_ID);
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);
//
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            BLOCK_ID,
//            JRecipe.shaped(
//                JPattern.pattern("AAA", "BEB", "CCC"),
//                JKeys.keys()
//                    .key("A", JIngredient.ingredient().item("minecraft:white_carpet"))
//                    .key("B", JIngredient.ingredient().item("minecraft:white_dye"))
//                    .key("C", JIngredient.ingredient().item("minecraft:brown_wool"))
//                    .key("E", JIngredient.ingredient().item("minecraft:redstone")),
//                JResult.stackedResult(BLOCK_ID.toString(), 3)
//            )
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model("minecraft:item/cake"), ITEM_MODEL_ID);
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model("minecraft:block/cake"), MODEL_ID);
//
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(JState.variant().put("", new JBlockModel("minecraft:block/cake"))),
//            BLOCK_ID
//        );
//    }
//}
