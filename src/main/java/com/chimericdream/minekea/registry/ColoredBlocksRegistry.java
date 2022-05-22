package com.chimericdream.minekea.registry;

import net.minecraft.block.Block;
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
        NONE(-1, -1),
        WHITE(0, 2232001),
        ORANGE(1, 2232002),
        MAGENTA(2, 2232003),
        LIGHT_BLUE(3, 2232004),
        YELLOW(4, 2232005),
        LIME(5, 2232006),
        PINK(6, 2232007),
        GRAY(7, 2232008),
        LIGHT_GRAY(8, 2232009),
        CYAN(9, 2232010),
        PURPLE(10, 2232011),
        BLUE(11, 2232012),
        BROWN(12, 2232013),
        GREEN(13, 2232014),
        RED(14, 2232015),
        BLACK(15, 2232016);

        private final int idx;
        private final int modelNumber;

        BlockColor(int idx, int modelNumber) {
            this.idx = idx;
            this.modelNumber = modelNumber;
        }

        public static BlockColor get(String value) {
            for (BlockColor color : values()) {
                if (color.toString().equals(value)) {
                    return color;
                }
            }

            return WHITE;
        }

        public int getModelNumber() {
            return modelNumber;
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
