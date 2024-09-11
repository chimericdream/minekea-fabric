package com.chimericdream.minekea.registry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ColoredBlocksRegistry {
    public static final List<ColoredBlock> REGISTRY = new ArrayList<>();

    public static void addBlock(Block block, String group, BlockColor color) {
        REGISTRY.add(new ColoredBlock(block, group, color));
    }

    public static @Nullable String getBlockGroup(Block block) {
        ColoredBlock match = REGISTRY.stream()
            .filter((ColoredBlock cb) -> cb.block.asItem() == block.asItem())
            .findFirst()
            .orElse(null);

        if (match == null) {
            return null;
        }

        return match.group;
    }

    public static @Nullable Block findBlock(String group, BlockColor color) {
        ColoredBlock match = REGISTRY.stream()
            .filter((ColoredBlock cb) -> cb.group.equals(group) && cb.color == color)
            .findFirst()
            .orElse(null);

        if (match == null) {
            return null;
        }

        return match.block;
    }

    public static class ColoredBlock {
        private final Block block;
        private final String group;
        private final BlockColor color;

        ColoredBlock(Block block, String group, BlockColor color) {
            this.block = block;
            this.group = group;
            this.color = color;
        }
    }

    public enum BlockColor {
        NONE(-1, -1, null),
        WHITE(0, 2232000, Items.WHITE_DYE),
        LIGHT_GRAY(1, 2232001, Items.LIGHT_GRAY_DYE),
        GRAY(2, 2232002, Items.GRAY_DYE),
        BLACK(3, 2232003, Items.BLACK_DYE),
        BROWN(4, 2232004, Items.BROWN_DYE),
        RED(5, 2232005, Items.RED_DYE),
        ORANGE(6, 2232006, Items.ORANGE_DYE),
        YELLOW(7, 2232007, Items.YELLOW_DYE),
        LIME(8, 2232008, Items.LIME_DYE),
        GREEN(9, 2232009, Items.GREEN_DYE),
        CYAN(10, 2232010, Items.CYAN_DYE),
        LIGHT_BLUE(11, 2232011, Items.LIGHT_BLUE_DYE),
        BLUE(12, 2232012, Items.BLUE_DYE),
        PURPLE(13, 2232013, Items.PURPLE_DYE),
        MAGENTA(14, 2232014, Items.MAGENTA_DYE),
        PINK(15, 2232015, Items.PINK_DYE);

        private final int idx;
        private final int modelNumber;
        private final Item dye;

        BlockColor(int idx, int modelNumber, Item dye) {
            this.idx = idx;
            this.modelNumber = modelNumber;
            this.dye = dye;
        }

        public static BlockColor get(String value) {
            for (BlockColor color : values()) {
                if (color.toString().equals(value)) {
                    return color;
                }
            }

            return WHITE;
        }

        public int getIndex() {
            return idx;
        }

        public int getModelNumber() {
            return modelNumber;
        }

        public Item getDye() {
            return dye;
        }

        public BlockColor getNext() {
            int nextIdx = (idx + 1) % 16;

            for (BlockColor color : values()) {
                if (color.idx == nextIdx) {
                    return color;
                }
            }

            return WHITE;
        }
    }
}
