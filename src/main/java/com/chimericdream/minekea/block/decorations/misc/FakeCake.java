package com.chimericdream.minekea.block.decorations.misc;

import com.chimericdream.lib.blocks.BlockDataGenerator;
import com.chimericdream.lib.blocks.RegisterableBlock;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.lib.resource.ModelUtils;
import com.chimericdream.lib.text.TextHelpers;
import com.chimericdream.minekea.ModInfo;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CakeBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.VariantsBlockStateSupplier;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.List;

public class FakeCake extends CakeBlock implements BlockDataGenerator, FabricBlockDataGenerator, RegisterableBlock {
    public final static String TOOLTIP_KEY = "block.minekea.decorations.misc.fake_cake.tooltip";
    public final static Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "decorations/misc/fake_cake");

    public FakeCake() {
        super(AbstractBlock.Settings.copy(Blocks.CAKE));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        tooltip.add(TextHelpers.getTooltip(TOOLTIP_KEY));
    }

    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
            .register(itemGroup -> itemGroup.add(this.asItem()));
    }

    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, this, 3)
            .pattern("AAA")
            .pattern("BEB")
            .pattern("CCC")
            .input('A', Items.WHITE_CARPET)
            .input('B', Items.WHITE_DYE)
            .input('C', Items.BROWN_WOOL)
            .input('E', Items.REDSTONE)
            .criterion(FabricRecipeProvider.hasItem(Items.WHITE_CARPET),
                FabricRecipeProvider.conditionsFromItem(Items.WHITE_CARPET))
            .criterion(FabricRecipeProvider.hasItem(Items.WHITE_DYE),
                FabricRecipeProvider.conditionsFromItem(Items.WHITE_DYE))
            .criterion(FabricRecipeProvider.hasItem(Items.BROWN_WOOL),
                FabricRecipeProvider.conditionsFromItem(Items.BROWN_WOOL))
            .criterion(FabricRecipeProvider.hasItem(Items.REDSTONE),
                FabricRecipeProvider.conditionsFromItem(Items.REDSTONE))
            .offerTo(exporter);
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Cake");
        translationBuilder.add(TOOLTIP_KEY, "This cake is a lie!");
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Identifier identifier = ModelIds.getBlockModelId(Blocks.CAKE);
        blockStateModelGenerator.blockStateCollector
            .accept(
                VariantsBlockStateSupplier.create(
                    this,
                    BlockStateVariant.create().put(VariantSettings.MODEL, identifier)
                )
            );
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        ModelUtils.registerGeneratedItem(itemModelGenerator, this, Registries.BLOCK.getId(Blocks.CAKE));
    }
}
