package com.chimericdream.minekea.block.building.dyed;

import com.chimericdream.minekea.registry.ColoredBlocksRegistry;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import com.chimericdream.minekea.util.Tool;
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
import oshi.util.tuples.Pair;
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

    protected static final List<Triplet<Pair<String, String>, Block, Tool>> BLOCKS_TO_DYE = List.of(
        new Triplet<>(new Pair<>("Bricks", "bricks"), Blocks.BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Calcite", "calcite"), Blocks.CALCITE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Cobblestone", "cobblestone"), Blocks.COBBLESTONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Dark Prismarine", "dark_prismarine"), Blocks.DARK_PRISMARINE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Mud Bricks", "mud_bricks"), Blocks.MUD_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Oak Planks", "oak_planks"), Blocks.OAK_PLANKS, Tool.AXE),
        new Triplet<>(new Pair<>("Prismarine", "prismarine"), Blocks.PRISMARINE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Prismarine Bricks", "prismarine_bricks"), Blocks.PRISMARINE_BRICKS, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Smooth Stone", "smooth_stone"), Blocks.SMOOTH_STONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Stone", "stone"), Blocks.STONE, Tool.PICKAXE),
        new Triplet<>(new Pair<>("Stone Bricks", "stone_bricks"), Blocks.STONE_BRICKS, Tool.PICKAXE)
    );

    protected static final List<Quartet<String, Pair<String, String>, Block, Tool>> PILLAR_BLOCKS_TO_DYE = List.of(
        new Quartet<>("Bone Block", new Pair<>("bone_block_top", "bone_block_side"), Blocks.BONE_BLOCK, Tool.PICKAXE)
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
            String materialName = data.getA().getA();
            String textureKey = data.getA().getB();
            Block baseBlock = data.getB();
            Tool miningTool = data.getC();

            DyedBlock whiteBlock = new DyedBlock(DyeColor.WHITE, materialName, textureKey, baseBlock, miningTool);
            DyedBlock lightGrayBlock = new DyedBlock(DyeColor.LIGHT_GRAY, materialName, textureKey, baseBlock, miningTool);
            DyedBlock grayBlock = new DyedBlock(DyeColor.GRAY, materialName, textureKey, baseBlock, miningTool);
            DyedBlock blackBlock = new DyedBlock(DyeColor.BLACK, materialName, textureKey, baseBlock, miningTool);
            DyedBlock brownBlock = new DyedBlock(DyeColor.BROWN, materialName, textureKey, baseBlock, miningTool);
            DyedBlock redBlock = new DyedBlock(DyeColor.RED, materialName, textureKey, baseBlock, miningTool);
            DyedBlock orangeBlock = new DyedBlock(DyeColor.ORANGE, materialName, textureKey, baseBlock, miningTool);
            DyedBlock yellowBlock = new DyedBlock(DyeColor.YELLOW, materialName, textureKey, baseBlock, miningTool);
            DyedBlock limeBlock = new DyedBlock(DyeColor.LIME, materialName, textureKey, baseBlock, miningTool);
            DyedBlock greenBlock = new DyedBlock(DyeColor.GREEN, materialName, textureKey, baseBlock, miningTool);
            DyedBlock cyanBlock = new DyedBlock(DyeColor.CYAN, materialName, textureKey, baseBlock, miningTool);
            DyedBlock lightBlueBlock = new DyedBlock(DyeColor.LIGHT_BLUE, materialName, textureKey, baseBlock, miningTool);
            DyedBlock blueBlock = new DyedBlock(DyeColor.BLUE, materialName, textureKey, baseBlock, miningTool);
            DyedBlock purpleBlock = new DyedBlock(DyeColor.PURPLE, materialName, textureKey, baseBlock, miningTool);
            DyedBlock magentaBlock = new DyedBlock(DyeColor.MAGENTA, materialName, textureKey, baseBlock, miningTool);
            DyedBlock pinkBlock = new DyedBlock(DyeColor.PINK, materialName, textureKey, baseBlock, miningTool);

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
            String endTextureKey = data.getB().getA();
            String sideTextureKey = data.getB().getB();
            Block baseBlock = data.getC();
            Tool miningTool = data.getD();

            DyedPillarBlock whiteBlock = new DyedPillarBlock(DyeColor.WHITE, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock lightGrayBlock = new DyedPillarBlock(DyeColor.LIGHT_GRAY, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock grayBlock = new DyedPillarBlock(DyeColor.GRAY, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock blackBlock = new DyedPillarBlock(DyeColor.BLACK, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock brownBlock = new DyedPillarBlock(DyeColor.BROWN, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock redBlock = new DyedPillarBlock(DyeColor.RED, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock orangeBlock = new DyedPillarBlock(DyeColor.ORANGE, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock yellowBlock = new DyedPillarBlock(DyeColor.YELLOW, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock limeBlock = new DyedPillarBlock(DyeColor.LIME, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock greenBlock = new DyedPillarBlock(DyeColor.GREEN, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock cyanBlock = new DyedPillarBlock(DyeColor.CYAN, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock lightBlueBlock = new DyedPillarBlock(DyeColor.LIGHT_BLUE, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock blueBlock = new DyedPillarBlock(DyeColor.BLUE, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock purpleBlock = new DyedPillarBlock(DyeColor.PURPLE, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock magentaBlock = new DyedPillarBlock(DyeColor.MAGENTA, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);
            DyedPillarBlock pinkBlock = new DyedPillarBlock(DyeColor.PINK, materialName, endTextureKey, sideTextureKey, baseBlock, miningTool);

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

        BLOCKS_TO_DYE.forEach(data -> {
            String textureKey = data.getA().getB();

            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "white"), textureKey, ColoredBlocksRegistry.BlockColor.WHITE);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "light_gray"), textureKey, ColoredBlocksRegistry.BlockColor.LIGHT_GRAY);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "gray"), textureKey, ColoredBlocksRegistry.BlockColor.GRAY);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "black"), textureKey, ColoredBlocksRegistry.BlockColor.BLACK);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "brown"), textureKey, ColoredBlocksRegistry.BlockColor.BROWN);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "red"), textureKey, ColoredBlocksRegistry.BlockColor.RED);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "orange"), textureKey, ColoredBlocksRegistry.BlockColor.ORANGE);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "yellow"), textureKey, ColoredBlocksRegistry.BlockColor.YELLOW);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "lime"), textureKey, ColoredBlocksRegistry.BlockColor.LIME);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "green"), textureKey, ColoredBlocksRegistry.BlockColor.GREEN);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "cyan"), textureKey, ColoredBlocksRegistry.BlockColor.CYAN);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "light_blue"), textureKey, ColoredBlocksRegistry.BlockColor.LIGHT_BLUE);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "blue"), textureKey, ColoredBlocksRegistry.BlockColor.BLUE);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "purple"), textureKey, ColoredBlocksRegistry.BlockColor.PURPLE);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "magenta"), textureKey, ColoredBlocksRegistry.BlockColor.MAGENTA);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "pink"), textureKey, ColoredBlocksRegistry.BlockColor.PINK);
        });

        PILLAR_BLOCKS_TO_DYE.forEach(data -> {
            String textureKey = data.getB().getA();

            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "white"), textureKey, ColoredBlocksRegistry.BlockColor.WHITE);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "light_gray"), textureKey, ColoredBlocksRegistry.BlockColor.LIGHT_GRAY);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "gray"), textureKey, ColoredBlocksRegistry.BlockColor.GRAY);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "black"), textureKey, ColoredBlocksRegistry.BlockColor.BLACK);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "brown"), textureKey, ColoredBlocksRegistry.BlockColor.BROWN);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "red"), textureKey, ColoredBlocksRegistry.BlockColor.RED);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "orange"), textureKey, ColoredBlocksRegistry.BlockColor.ORANGE);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "yellow"), textureKey, ColoredBlocksRegistry.BlockColor.YELLOW);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "lime"), textureKey, ColoredBlocksRegistry.BlockColor.LIME);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "green"), textureKey, ColoredBlocksRegistry.BlockColor.GREEN);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "cyan"), textureKey, ColoredBlocksRegistry.BlockColor.CYAN);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "light_blue"), textureKey, ColoredBlocksRegistry.BlockColor.LIGHT_BLUE);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "blue"), textureKey, ColoredBlocksRegistry.BlockColor.BLUE);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "purple"), textureKey, ColoredBlocksRegistry.BlockColor.PURPLE);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "magenta"), textureKey, ColoredBlocksRegistry.BlockColor.MAGENTA);
            ColoredBlocksRegistry.addBlock((Block) BLOCK_MAP.get(textureKey + "pink"), textureKey, ColoredBlocksRegistry.BlockColor.PINK);
        });
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
