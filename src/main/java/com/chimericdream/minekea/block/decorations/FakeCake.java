package com.chimericdream.minekea.block.decorations;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FakeCake extends CakeBlock implements MinekeaBlock {
    private final Identifier BLOCK_ID;

    public FakeCake() {
        super(FabricBlockSettings.copyOf(Blocks.CAKE));

        BLOCK_ID = new Identifier(ModInfo.MOD_ID, "decorations/fake_cake");
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(new TranslatableText("block.minekea.decorations.fake_cake.tooltip"));
    }

    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        setupResources();
    }

    public void setupResources() {
        Identifier MODEL_ID = new Identifier(ModInfo.MOD_ID, "block/decorations/fake_cake");
        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, "item/decorations/fake_cake");

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("AAA", "BEB", "CCC"),
                JKeys.keys()
                    .key("A", JIngredient.ingredient().item("minecraft:white_carpet"))
                    .key("B", JIngredient.ingredient().item("minecraft:white_dye"))
                    .key("C", JIngredient.ingredient().item("minecraft:brown_wool"))
                    .key("E", JIngredient.ingredient().item("minecraft:redstone")),
                JResult.result(BLOCK_ID.toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model("minecraft:item/cake"), ITEM_MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model("minecraft:block/cake"), MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant().put("", new JBlockModel("minecraft:block/cake"))),
            BLOCK_ID
        );
    }
}
