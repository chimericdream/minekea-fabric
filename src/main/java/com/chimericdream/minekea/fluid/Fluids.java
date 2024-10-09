package com.chimericdream.minekea.fluid;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.containers.HoneyCauldronBlock;
import com.chimericdream.minekea.block.containers.MilkCauldronBlock;
import com.chimericdream.minekea.item.containers.HoneyBucket;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.MapColor;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

public class Fluids implements MinekeaBlockCategory {
    public static final FlowableFluid MILK;
    public static final FlowableFluid FLOWING_MILK;
    public static final FluidBlock MILK_SOURCE_BLOCK;

    public static final FlowableFluid HONEY;
    public static final FlowableFluid FLOWING_HONEY;
    public static final FluidBlock HONEY_SOURCE_BLOCK;

    public static final Block MILK_CAULDRON;
    public static final Block HONEY_CAULDRON;
    public static final Item HONEY_BUCKET;

    public static final Identifier MILK_ID = Identifier.of(ModInfo.MOD_ID, "fluids/milk");
    public static final Identifier FLOWING_MILK_ID = Identifier.of(ModInfo.MOD_ID, "fluids/milk/flowing");
    public static final Identifier MILK_SOURCE_ID = Identifier.of(ModInfo.MOD_ID, "fluids/milk/source");

    public static final Identifier HONEY_ID = Identifier.of(ModInfo.MOD_ID, "fluids/honey");
    public static final Identifier FLOWING_HONEY_ID = Identifier.of(ModInfo.MOD_ID, "fluids/honey/flowing");
    public static final Identifier HONEY_SOURCE_ID = Identifier.of(ModInfo.MOD_ID, "fluids/honey/source");

    static {
        MILK = Registry.register(Registries.FLUID, MILK_ID, new MilkFluid.Still());
        FLOWING_MILK = Registry.register(Registries.FLUID, FLOWING_MILK_ID, new MilkFluid.Flowing());
        MILK_SOURCE_BLOCK = Registry.register(
            Registries.BLOCK,
            MILK_SOURCE_ID,
            new MilkFluid.Source(MILK, AbstractBlock.Settings.copy(Blocks.WATER).mapColor(MapColor.WHITE))
        );

        HONEY = Registry.register(Registries.FLUID, HONEY_ID, new HoneyFluid.Still());
        FLOWING_HONEY = Registry.register(Registries.FLUID, FLOWING_HONEY_ID, new HoneyFluid.Flowing());
        HONEY_SOURCE_BLOCK = Registry.register(
            Registries.BLOCK,
            HONEY_SOURCE_ID,
            new HoneyFluid.Source(HONEY, AbstractBlock.Settings.copy(Blocks.LAVA).mapColor(MapColor.TERRACOTTA_YELLOW))
        );

        MILK_CAULDRON = Registry.register(
            Registries.BLOCK,
            MilkCauldronBlock.BLOCK_ID,
            new MilkCauldronBlock(AbstractBlock.Settings.copy(Blocks.CAULDRON))
        );

        HONEY_BUCKET = Registry.register(
            Registries.ITEM,
            HoneyBucket.ITEM_ID,
            new HoneyBucket()
        );
        HONEY_CAULDRON = Registry.register(
            Registries.BLOCK,
            HoneyCauldronBlock.BLOCK_ID,
            new HoneyCauldronBlock(AbstractBlock.Settings.copy(Blocks.CAULDRON))
        );
    }

    @Override
    public void registerBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
            .register((itemGroup) -> itemGroup.add(HONEY_BUCKET));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(HONEY_BUCKET, "Honey Bucket");
        translationBuilder.add(HONEY_CAULDRON, "Honey Cauldron");
        translationBuilder.add(HONEY_SOURCE_BLOCK, "Honey");
        translationBuilder.add(MILK_CAULDRON, "Milk Cauldron");
        translationBuilder.add(MILK_SOURCE_BLOCK, "Milk");
    }
}
