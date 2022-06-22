package com.chimericdream.minekea.fluid;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.containers.HoneyCauldronBlock;
import com.chimericdream.minekea.block.containers.MilkCauldronBlock;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.item.containers.HoneyBucket;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.MapColor;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.List;

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

    public static final Identifier MILK_ID = new Identifier(ModInfo.MOD_ID, "fluids/milk");
    public static final Identifier FLOWING_MILK_ID = new Identifier(ModInfo.MOD_ID, "fluids/milk/flowing");
    public static final Identifier MILK_SOURCE_ID = new Identifier(ModInfo.MOD_ID, "fluids/milk/source");

    public static final Identifier HONEY_ID = new Identifier(ModInfo.MOD_ID, "fluids/honey");
    public static final Identifier FLOWING_HONEY_ID = new Identifier(ModInfo.MOD_ID, "fluids/honey/flowing");
    public static final Identifier HONEY_SOURCE_ID = new Identifier(ModInfo.MOD_ID, "fluids/honey/source");

    static {
        MILK = Registry.register(Registry.FLUID, MILK_ID, new MilkFluid.Still());
        FLOWING_MILK = Registry.register(Registry.FLUID, FLOWING_MILK_ID, new MilkFluid.Flowing());
        MILK_SOURCE_BLOCK = Registry.register(
            Registry.BLOCK,
            MILK_SOURCE_ID,
            new MilkFluid.Source(MILK, FabricBlockSettings.copyOf(Blocks.WATER).mapColor(MapColor.WHITE))
        );

        HONEY = Registry.register(Registry.FLUID, HONEY_ID, new HoneyFluid.Still());
        FLOWING_HONEY = Registry.register(Registry.FLUID, FLOWING_HONEY_ID, new HoneyFluid.Flowing());
        HONEY_SOURCE_BLOCK = Registry.register(
            Registry.BLOCK,
            HONEY_SOURCE_ID,
            new HoneyFluid.Source(HONEY, FabricBlockSettings.copyOf(Blocks.LAVA).mapColor(MapColor.TERRACOTTA_YELLOW))
        );

        MILK_CAULDRON = Registry.register(
            Registry.BLOCK,
            new Identifier(ModInfo.MOD_ID, "milk_cauldron"),
            new MilkCauldronBlock(FabricBlockSettings.copyOf(Blocks.CAULDRON))
        );

        HONEY_BUCKET = Registry.register(
            Registry.ITEM,
            HoneyBucket.ITEM_ID,
            new HoneyBucket()
        );
        HONEY_CAULDRON = Registry.register(
            Registry.BLOCK,
            new Identifier(ModInfo.MOD_ID, "honey_cauldron"),
            new HoneyCauldronBlock(FabricBlockSettings.copyOf(Blocks.CAULDRON))
        );
    }

    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.itemRespect(HONEY_BUCKET, "Honey Bucket");
        MinekeaResourcePack.EN_US.blockRespect(HONEY_CAULDRON, "Honey Cauldron");
        MinekeaResourcePack.EN_US.blockRespect(MILK_CAULDRON, "Milk Cauldron");
        MinekeaResourcePack.EN_US.fluid(MILK, "Milk");
        MinekeaResourcePack.EN_US.fluid(HONEY, "Honey");
        MinekeaResourcePack.EN_US.blockRespect(MILK_SOURCE_BLOCK, "Milk");
        MinekeaResourcePack.EN_US.blockRespect(HONEY_SOURCE_BLOCK, "Honey");
    }
}
