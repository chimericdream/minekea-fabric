package com.chimericdream.minekea.block.building.dyed;

import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.DyeColor;
import oshi.util.tuples.Quartet;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class DyedBlocks implements MinekeaBlockCategory {
    public static final Map<String, MinekeaBlock> BLOCK_MAP = new LinkedHashMap<>();
    public static final List<MinekeaBlock> BLOCKS = new ArrayList<>();

    protected static final List<Triplet<String, String, Block>> BLOCKS_TO_DYE = List.of(
        new Triplet<>("Bricks", "bricks", Blocks.BRICKS),
        new Triplet<>("Calcite", "calcite", Blocks.CALCITE),
        new Triplet<>("Cobblestone", "cobblestone", Blocks.COBBLESTONE),
        new Triplet<>("Dark Prismarine", "dark_prismarine", Blocks.DARK_PRISMARINE),
        new Triplet<>("Mud Bricks", "mud_bricks", Blocks.MUD_BRICKS),
        new Triplet<>("Oak Planks", "oak_planks", Blocks.OAK_PLANKS),
        new Triplet<>("Prismarine", "prismarine", Blocks.PRISMARINE),
        new Triplet<>("Prismarine Bricks", "prismarine_bricks", Blocks.PRISMARINE_BRICKS),
        new Triplet<>("Smooth Stone", "smooth_stone", Blocks.SMOOTH_STONE),
        new Triplet<>("Stone", "stone", Blocks.STONE),
        new Triplet<>("Stone Bricks", "stone_bricks", Blocks.STONE_BRICKS)
    );

    protected static final List<Quartet<String, String, String, Block>> PILLAR_BLOCKS_TO_DYE = List.of(
        new Quartet<>("Bone Block", "bone_block_top", "bone_block_side", Blocks.BONE_BLOCK)
    );

    protected static final List<MinekeaBlock> WHITE_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> LIGHT_GRAY_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> GRAY_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> BLACK_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> BROWN_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> RED_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> ORANGE_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> YELLOW_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> LIME_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> GREEN_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> CYAN_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> LIGHT_BLUE_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> BLUE_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> PURPLE_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> MAGENTA_BLOCKS = new ArrayList<>();
    protected static final List<MinekeaBlock> PINK_BLOCKS = new ArrayList<>();

    static {
        BLOCKS_TO_DYE.forEach(data -> {
            String materialName = data.getA();
            String textureKey = data.getB();
            Block baseBlock = data.getC();

            DyedBlock whiteBlock = new DyedBlock(DyeColor.WHITE, materialName, textureKey, baseBlock);
            DyedBlock lightGrayBlock = new DyedBlock(DyeColor.LIGHT_GRAY, materialName, textureKey, baseBlock);
            DyedBlock grayBlock = new DyedBlock(DyeColor.GRAY, materialName, textureKey, baseBlock);
            DyedBlock blackBlock = new DyedBlock(DyeColor.BLACK, materialName, textureKey, baseBlock);
            DyedBlock brownBlock = new DyedBlock(DyeColor.BROWN, materialName, textureKey, baseBlock);
            DyedBlock redBlock = new DyedBlock(DyeColor.RED, materialName, textureKey, baseBlock);
            DyedBlock orangeBlock = new DyedBlock(DyeColor.ORANGE, materialName, textureKey, baseBlock);
            DyedBlock yellowBlock = new DyedBlock(DyeColor.YELLOW, materialName, textureKey, baseBlock);
            DyedBlock limeBlock = new DyedBlock(DyeColor.LIME, materialName, textureKey, baseBlock);
            DyedBlock greenBlock = new DyedBlock(DyeColor.GREEN, materialName, textureKey, baseBlock);
            DyedBlock cyanBlock = new DyedBlock(DyeColor.CYAN, materialName, textureKey, baseBlock);
            DyedBlock lightBlueBlock = new DyedBlock(DyeColor.LIGHT_BLUE, materialName, textureKey, baseBlock);
            DyedBlock blueBlock = new DyedBlock(DyeColor.BLUE, materialName, textureKey, baseBlock);
            DyedBlock purpleBlock = new DyedBlock(DyeColor.PURPLE, materialName, textureKey, baseBlock);
            DyedBlock magentaBlock = new DyedBlock(DyeColor.MAGENTA, materialName, textureKey, baseBlock);
            DyedBlock pinkBlock = new DyedBlock(DyeColor.PINK, materialName, textureKey, baseBlock);

            BLOCK_MAP.put(textureKey + "white", whiteBlock);
            BLOCK_MAP.put(textureKey + "light_gray", lightGrayBlock);
            BLOCK_MAP.put(textureKey + "gray", grayBlock);
            BLOCK_MAP.put(textureKey + "black", blackBlock);
            BLOCK_MAP.put(textureKey + "brown", brownBlock);
            BLOCK_MAP.put(textureKey + "red", redBlock);
            BLOCK_MAP.put(textureKey + "orange", orangeBlock);
            BLOCK_MAP.put(textureKey + "yellow", yellowBlock);
            BLOCK_MAP.put(textureKey + "lime", limeBlock);
            BLOCK_MAP.put(textureKey + "green", greenBlock);
            BLOCK_MAP.put(textureKey + "cyan", cyanBlock);
            BLOCK_MAP.put(textureKey + "light_blue", lightBlueBlock);
            BLOCK_MAP.put(textureKey + "blue", blueBlock);
            BLOCK_MAP.put(textureKey + "purple", purpleBlock);
            BLOCK_MAP.put(textureKey + "magenta", magentaBlock);
            BLOCK_MAP.put(textureKey + "pink", pinkBlock);

            WHITE_BLOCKS.add(whiteBlock);
            LIGHT_GRAY_BLOCKS.add(lightGrayBlock);
            GRAY_BLOCKS.add(grayBlock);
            BLACK_BLOCKS.add(blackBlock);
            BROWN_BLOCKS.add(brownBlock);
            RED_BLOCKS.add(redBlock);
            ORANGE_BLOCKS.add(orangeBlock);
            YELLOW_BLOCKS.add(yellowBlock);
            LIME_BLOCKS.add(limeBlock);
            GREEN_BLOCKS.add(greenBlock);
            CYAN_BLOCKS.add(cyanBlock);
            LIGHT_BLUE_BLOCKS.add(lightBlueBlock);
            BLUE_BLOCKS.add(blueBlock);
            PURPLE_BLOCKS.add(purpleBlock);
            MAGENTA_BLOCKS.add(magentaBlock);
            PINK_BLOCKS.add(pinkBlock);
        });

        PILLAR_BLOCKS_TO_DYE.forEach(data -> {
            String materialName = data.getA();
            String endTextureKey = data.getB();
            String sideTextureKey = data.getC();
            Block baseBlock = data.getD();

            DyedPillarBlock whiteBlock = new DyedPillarBlock(DyeColor.WHITE, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock lightGrayBlock = new DyedPillarBlock(DyeColor.LIGHT_GRAY, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock grayBlock = new DyedPillarBlock(DyeColor.GRAY, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock blackBlock = new DyedPillarBlock(DyeColor.BLACK, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock brownBlock = new DyedPillarBlock(DyeColor.BROWN, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock redBlock = new DyedPillarBlock(DyeColor.RED, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock orangeBlock = new DyedPillarBlock(DyeColor.ORANGE, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock yellowBlock = new DyedPillarBlock(DyeColor.YELLOW, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock limeBlock = new DyedPillarBlock(DyeColor.LIME, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock greenBlock = new DyedPillarBlock(DyeColor.GREEN, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock cyanBlock = new DyedPillarBlock(DyeColor.CYAN, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock lightBlueBlock = new DyedPillarBlock(DyeColor.LIGHT_BLUE, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock blueBlock = new DyedPillarBlock(DyeColor.BLUE, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock purpleBlock = new DyedPillarBlock(DyeColor.PURPLE, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock magentaBlock = new DyedPillarBlock(DyeColor.MAGENTA, materialName, endTextureKey, sideTextureKey, baseBlock);
            DyedPillarBlock pinkBlock = new DyedPillarBlock(DyeColor.PINK, materialName, endTextureKey, sideTextureKey, baseBlock);

            BLOCK_MAP.put(endTextureKey + "white", whiteBlock);
            BLOCK_MAP.put(endTextureKey + "light_gray", lightGrayBlock);
            BLOCK_MAP.put(endTextureKey + "gray", grayBlock);
            BLOCK_MAP.put(endTextureKey + "black", blackBlock);
            BLOCK_MAP.put(endTextureKey + "brown", brownBlock);
            BLOCK_MAP.put(endTextureKey + "red", redBlock);
            BLOCK_MAP.put(endTextureKey + "orange", orangeBlock);
            BLOCK_MAP.put(endTextureKey + "yellow", yellowBlock);
            BLOCK_MAP.put(endTextureKey + "lime", limeBlock);
            BLOCK_MAP.put(endTextureKey + "green", greenBlock);
            BLOCK_MAP.put(endTextureKey + "cyan", cyanBlock);
            BLOCK_MAP.put(endTextureKey + "light_blue", lightBlueBlock);
            BLOCK_MAP.put(endTextureKey + "blue", blueBlock);
            BLOCK_MAP.put(endTextureKey + "purple", purpleBlock);
            BLOCK_MAP.put(endTextureKey + "magenta", magentaBlock);
            BLOCK_MAP.put(endTextureKey + "pink", pinkBlock);

            WHITE_BLOCKS.add(whiteBlock);
            LIGHT_GRAY_BLOCKS.add(lightGrayBlock);
            GRAY_BLOCKS.add(grayBlock);
            BLACK_BLOCKS.add(blackBlock);
            BROWN_BLOCKS.add(brownBlock);
            RED_BLOCKS.add(redBlock);
            ORANGE_BLOCKS.add(orangeBlock);
            YELLOW_BLOCKS.add(yellowBlock);
            LIME_BLOCKS.add(limeBlock);
            GREEN_BLOCKS.add(greenBlock);
            CYAN_BLOCKS.add(cyanBlock);
            LIGHT_BLUE_BLOCKS.add(lightBlueBlock);
            BLUE_BLOCKS.add(blueBlock);
            PURPLE_BLOCKS.add(purpleBlock);
            MAGENTA_BLOCKS.add(magentaBlock);
            PINK_BLOCKS.add(pinkBlock);
        });

        BLOCK_MAP.forEach((unused, block) -> BLOCKS.add(block));
    }

    @Override
    public void registerBlocks() {
        BLOCK_MAP.values().forEach(MinekeaBlock::register);
    }

    @Override
    public void configureBlockTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Block>, FabricTagProvider<Block>.FabricTagBuilder> getBuilder) {
        BLOCKS.forEach(block -> block.configureBlockTags(registryLookup, getBuilder));
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        BLOCKS.forEach(block -> block.configureItemTags(registryLookup, getBuilder));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        BLOCKS.forEach(block -> block.configureRecipes(exporter));
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        BLOCKS.forEach(block -> block.configureBlockLootTables(registryLookup, generator));
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        BLOCKS.forEach(block -> block.configureTranslations(registryLookup, translationBuilder));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BLOCKS.forEach(block -> block.configureBlockStateModels(blockStateModelGenerator));
    }

    @Override
    public void configureItemModels(ItemModelGenerator itemModelGenerator) {
        BLOCKS.forEach(block -> block.configureItemModels(itemModelGenerator));
    }

    @Override
    public void generateTextures() {
        BLOCKS.forEach(MinekeaBlock::generateTextures);
    }
}
