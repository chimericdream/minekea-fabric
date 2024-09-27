package com.chimericdream.minekea.item.tools;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.tag.CommonItemTags;
import com.chimericdream.minekea.util.MinekeaItem;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Function;

public class WrenchItem extends Item implements MinekeaItem {
    public static final Identifier ITEM_ID = Identifier.of(ModInfo.MOD_ID, "tools/wrench");

    public WrenchItem() {
        super(new Item.Settings().maxCount(1));
    }

    @Override
    public void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
            .register((itemGroup) -> {
                itemGroup.add(this);
            });
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, this, 1)
            .pattern(" # ")
            .pattern(" ##")
            .pattern("#  ")
            .input('#', net.minecraft.item.Items.IRON_INGOT)
            .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
            .offerTo(exporter);
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        getBuilder.apply(CommonItemTags.WRENCHES)
            .setReplace(false)
            .add(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Wrench");
    }

    private boolean tryPlacing(BlockPos pos, BlockState state, World world) {
        if (state.canPlaceAt(world, pos)) {
            world.setBlockState(pos, state);
            world.markDirty(pos);

            return true;
        }

        return false;
    }

    private boolean tryFacing(BlockState state, BlockPos pos, World world) {
        if (state.getOrEmpty(Properties.FACING).isPresent()) {
            if (tryPlacing(pos, state.cycle(Properties.FACING), world)) {
                return true;
            }
        }

        if (state.getOrEmpty(Properties.HORIZONTAL_FACING).isPresent()) {
            if (tryPlacing(pos, state.cycle(Properties.HORIZONTAL_FACING), world)) {
                return true;
            }
        }

        if (state.getOrEmpty(Properties.HOPPER_FACING).isPresent()) {
            if (tryPlacing(pos, state.cycle(Properties.HOPPER_FACING), world)) {
                return true;
            }
        }

        return false;
    }

    private boolean tryAxes(BlockState state, BlockPos pos, World world) {
        if (state.getOrEmpty(Properties.AXIS).isPresent()) {
            if (tryPlacing(pos, state.cycle(Properties.AXIS), world)) {
                return true;
            }
        }

        if (state.getOrEmpty(Properties.HORIZONTAL_AXIS).isPresent()) {
            if (tryPlacing(pos, state.cycle(Properties.HORIZONTAL_AXIS), world)) {
                return true;
            }
        }

        return false;
    }

    private boolean trySlab(BlockState state, BlockPos pos, World world) {
        if (state.getBlock() instanceof SlabBlock) {
            BlockState newState = state;

            if (state.get(Properties.SLAB_TYPE).equals(SlabType.DOUBLE)) {
                return false;
            }

            if (state.get(Properties.SLAB_TYPE).equals(SlabType.BOTTOM)) {
                newState = state.with(Properties.SLAB_TYPE, SlabType.TOP);
            } else if (state.get(Properties.SLAB_TYPE).equals(SlabType.TOP)) {
                newState = state.with(Properties.SLAB_TYPE, SlabType.BOTTOM);
            }

            world.setBlockState(pos, newState);
            world.markDirty(pos);

            return true;
        }

        return false;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);

        if (
            context.getPlayer() == null
                || world.isClient()
                || state.getBlock() instanceof ChestBlock
                || state.getBlock() instanceof BedBlock
        ) {
            return ActionResult.PASS;
        }

        if (tryFacing(state, pos, world) || tryAxes(state, pos, world) || trySlab(state, pos, world)) {
            if (!world.isClient()) {
                world.playSound(null, pos, SoundEvents.ITEM_SPYGLASS_USE, SoundCategory.AMBIENT, 2.0F, 1.5F);
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
}
