package com.chimericdream.minekea.block.building.dyed;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.DyeColor;
import oshi.util.tuples.Triplet;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DyedBlocks implements MinekeaBlockCategory {
    public static final Map<String, Block> BLOCK_MAP = new LinkedHashMap<>();
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Map<String, Block> PILLAR_BLOCK_MAP = new LinkedHashMap<>();

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

    protected static final List<Triplet<String, String, Block>> PILLAR_BLOCKS_TO_DYE = List.of(
        new Triplet<>("Bone Block", "bone_block", Blocks.BONE_BLOCK)
    );

    protected static final List<Block> WHITE_BLOCKS = new ArrayList<>();
    protected static final List<Block> LIGHT_GRAY_BLOCKS = new ArrayList<>();
    protected static final List<Block> GRAY_BLOCKS = new ArrayList<>();
    protected static final List<Block> BLACK_BLOCKS = new ArrayList<>();
    protected static final List<Block> BROWN_BLOCKS = new ArrayList<>();
    protected static final List<Block> RED_BLOCKS = new ArrayList<>();
    protected static final List<Block> ORANGE_BLOCKS = new ArrayList<>();
    protected static final List<Block> YELLOW_BLOCKS = new ArrayList<>();
    protected static final List<Block> LIME_BLOCKS = new ArrayList<>();
    protected static final List<Block> GREEN_BLOCKS = new ArrayList<>();
    protected static final List<Block> CYAN_BLOCKS = new ArrayList<>();
    protected static final List<Block> LIGHT_BLUE_BLOCKS = new ArrayList<>();
    protected static final List<Block> BLUE_BLOCKS = new ArrayList<>();
    protected static final List<Block> PURPLE_BLOCKS = new ArrayList<>();
    protected static final List<Block> MAGENTA_BLOCKS = new ArrayList<>();
    protected static final List<Block> PINK_BLOCKS = new ArrayList<>();

    static {
        BLOCKS_TO_DYE.forEach(data -> {
            String materialName = data.getA();
            String material = data.getB();
            Block baseBlock = data.getC();

            BlockConfig config = new BlockConfig()
                .material(material)
                .materialName(materialName)
                .ingredient(baseBlock);

            DyedBlock whiteBlock = new DyedBlock(config, DyeColor.WHITE);
            DyedBlock lightGrayBlock = new DyedBlock(config, DyeColor.LIGHT_GRAY);
            DyedBlock grayBlock = new DyedBlock(config, DyeColor.GRAY);
            DyedBlock blackBlock = new DyedBlock(config, DyeColor.BLACK);
            DyedBlock brownBlock = new DyedBlock(config, DyeColor.BROWN);
            DyedBlock redBlock = new DyedBlock(config, DyeColor.RED);
            DyedBlock orangeBlock = new DyedBlock(config, DyeColor.ORANGE);
            DyedBlock yellowBlock = new DyedBlock(config, DyeColor.YELLOW);
            DyedBlock limeBlock = new DyedBlock(config, DyeColor.LIME);
            DyedBlock greenBlock = new DyedBlock(config, DyeColor.GREEN);
            DyedBlock cyanBlock = new DyedBlock(config, DyeColor.CYAN);
            DyedBlock lightBlueBlock = new DyedBlock(config, DyeColor.LIGHT_BLUE);
            DyedBlock blueBlock = new DyedBlock(config, DyeColor.BLUE);
            DyedBlock purpleBlock = new DyedBlock(config, DyeColor.PURPLE);
            DyedBlock magentaBlock = new DyedBlock(config, DyeColor.MAGENTA);
            DyedBlock pinkBlock = new DyedBlock(config, DyeColor.PINK);

            BLOCK_MAP.put(material + "white", whiteBlock);
            BLOCK_MAP.put(material + "light_gray", lightGrayBlock);
            BLOCK_MAP.put(material + "gray", grayBlock);
            BLOCK_MAP.put(material + "black", blackBlock);
            BLOCK_MAP.put(material + "brown", brownBlock);
            BLOCK_MAP.put(material + "red", redBlock);
            BLOCK_MAP.put(material + "orange", orangeBlock);
            BLOCK_MAP.put(material + "yellow", yellowBlock);
            BLOCK_MAP.put(material + "lime", limeBlock);
            BLOCK_MAP.put(material + "green", greenBlock);
            BLOCK_MAP.put(material + "cyan", cyanBlock);
            BLOCK_MAP.put(material + "light_blue", lightBlueBlock);
            BLOCK_MAP.put(material + "blue", blueBlock);
            BLOCK_MAP.put(material + "purple", purpleBlock);
            BLOCK_MAP.put(material + "magenta", magentaBlock);
            BLOCK_MAP.put(material + "pink", pinkBlock);

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
            String material = data.getB();
            Block ingredient = data.getC();

            BlockConfig config = new BlockConfig()
                .materialName(materialName)
                .material(material)
                .ingredient(ingredient);

            DyedPillarBlock whiteBlock = new DyedPillarBlock(config, DyeColor.WHITE);
            DyedPillarBlock lightGrayBlock = new DyedPillarBlock(config, DyeColor.LIGHT_GRAY);
            DyedPillarBlock grayBlock = new DyedPillarBlock(config, DyeColor.GRAY);
            DyedPillarBlock blackBlock = new DyedPillarBlock(config, DyeColor.BLACK);
            DyedPillarBlock brownBlock = new DyedPillarBlock(config, DyeColor.BROWN);
            DyedPillarBlock redBlock = new DyedPillarBlock(config, DyeColor.RED);
            DyedPillarBlock orangeBlock = new DyedPillarBlock(config, DyeColor.ORANGE);
            DyedPillarBlock yellowBlock = new DyedPillarBlock(config, DyeColor.YELLOW);
            DyedPillarBlock limeBlock = new DyedPillarBlock(config, DyeColor.LIME);
            DyedPillarBlock greenBlock = new DyedPillarBlock(config, DyeColor.GREEN);
            DyedPillarBlock cyanBlock = new DyedPillarBlock(config, DyeColor.CYAN);
            DyedPillarBlock lightBlueBlock = new DyedPillarBlock(config, DyeColor.LIGHT_BLUE);
            DyedPillarBlock blueBlock = new DyedPillarBlock(config, DyeColor.BLUE);
            DyedPillarBlock purpleBlock = new DyedPillarBlock(config, DyeColor.PURPLE);
            DyedPillarBlock magentaBlock = new DyedPillarBlock(config, DyeColor.MAGENTA);
            DyedPillarBlock pinkBlock = new DyedPillarBlock(config, DyeColor.PINK);

            PILLAR_BLOCK_MAP.put(material + "white", whiteBlock);
            PILLAR_BLOCK_MAP.put(material + "light_gray", lightGrayBlock);
            PILLAR_BLOCK_MAP.put(material + "gray", grayBlock);
            PILLAR_BLOCK_MAP.put(material + "black", blackBlock);
            PILLAR_BLOCK_MAP.put(material + "brown", brownBlock);
            PILLAR_BLOCK_MAP.put(material + "red", redBlock);
            PILLAR_BLOCK_MAP.put(material + "orange", orangeBlock);
            PILLAR_BLOCK_MAP.put(material + "yellow", yellowBlock);
            PILLAR_BLOCK_MAP.put(material + "lime", limeBlock);
            PILLAR_BLOCK_MAP.put(material + "green", greenBlock);
            PILLAR_BLOCK_MAP.put(material + "cyan", cyanBlock);
            PILLAR_BLOCK_MAP.put(material + "light_blue", lightBlueBlock);
            PILLAR_BLOCK_MAP.put(material + "blue", blueBlock);
            PILLAR_BLOCK_MAP.put(material + "purple", purpleBlock);
            PILLAR_BLOCK_MAP.put(material + "magenta", magentaBlock);
            PILLAR_BLOCK_MAP.put(material + "pink", pinkBlock);

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
        PILLAR_BLOCK_MAP.forEach((unused, block) -> BLOCKS.add(block));
    }

    public List<Block> getCategoryBlocks() {
        return BLOCKS;
    }

    @Override
    public void registerBlocks() {
        MinekeaBlockCategory.super.registerBlocks();

        BLOCKS_TO_DYE.forEach(data -> {
            String textureKey = data.getB();

            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "white"), textureKey, ColoredBlocksRegistry.BlockColor.WHITE);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "light_gray"), textureKey, ColoredBlocksRegistry.BlockColor.LIGHT_GRAY);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "gray"), textureKey, ColoredBlocksRegistry.BlockColor.GRAY);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "black"), textureKey, ColoredBlocksRegistry.BlockColor.BLACK);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "brown"), textureKey, ColoredBlocksRegistry.BlockColor.BROWN);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "red"), textureKey, ColoredBlocksRegistry.BlockColor.RED);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "orange"), textureKey, ColoredBlocksRegistry.BlockColor.ORANGE);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "yellow"), textureKey, ColoredBlocksRegistry.BlockColor.YELLOW);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "lime"), textureKey, ColoredBlocksRegistry.BlockColor.LIME);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "green"), textureKey, ColoredBlocksRegistry.BlockColor.GREEN);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "cyan"), textureKey, ColoredBlocksRegistry.BlockColor.CYAN);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "light_blue"), textureKey, ColoredBlocksRegistry.BlockColor.LIGHT_BLUE);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "blue"), textureKey, ColoredBlocksRegistry.BlockColor.BLUE);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "purple"), textureKey, ColoredBlocksRegistry.BlockColor.PURPLE);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "magenta"), textureKey, ColoredBlocksRegistry.BlockColor.MAGENTA);
            ColoredBlocksRegistry.addBlock(BLOCK_MAP.get(textureKey + "pink"), textureKey, ColoredBlocksRegistry.BlockColor.PINK);
        });

        PILLAR_BLOCKS_TO_DYE.forEach(data -> {
            String textureKey = data.getB();

            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "white"), textureKey, ColoredBlocksRegistry.BlockColor.WHITE);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "light_gray"), textureKey, ColoredBlocksRegistry.BlockColor.LIGHT_GRAY);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "gray"), textureKey, ColoredBlocksRegistry.BlockColor.GRAY);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "black"), textureKey, ColoredBlocksRegistry.BlockColor.BLACK);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "brown"), textureKey, ColoredBlocksRegistry.BlockColor.BROWN);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "red"), textureKey, ColoredBlocksRegistry.BlockColor.RED);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "orange"), textureKey, ColoredBlocksRegistry.BlockColor.ORANGE);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "yellow"), textureKey, ColoredBlocksRegistry.BlockColor.YELLOW);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "lime"), textureKey, ColoredBlocksRegistry.BlockColor.LIME);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "green"), textureKey, ColoredBlocksRegistry.BlockColor.GREEN);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "cyan"), textureKey, ColoredBlocksRegistry.BlockColor.CYAN);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "light_blue"), textureKey, ColoredBlocksRegistry.BlockColor.LIGHT_BLUE);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "blue"), textureKey, ColoredBlocksRegistry.BlockColor.BLUE);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "purple"), textureKey, ColoredBlocksRegistry.BlockColor.PURPLE);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "magenta"), textureKey, ColoredBlocksRegistry.BlockColor.MAGENTA);
            ColoredBlocksRegistry.addBlock(PILLAR_BLOCK_MAP.get(textureKey + "pink"), textureKey, ColoredBlocksRegistry.BlockColor.PINK);
        });
    }
}
