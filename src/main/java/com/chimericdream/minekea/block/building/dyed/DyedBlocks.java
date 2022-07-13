package com.chimericdream.minekea.block.building.dyed;

import com.chimericdream.minekea.block.building.dyed.DyedDarkPrismarineBlock.DyedDarkPrismarineSettings;
import com.chimericdream.minekea.block.building.dyed.DyedPrismarineBlock.DyedPrismarineSettings;
import com.chimericdream.minekea.block.building.dyed.DyedPrismarineBricksBlock.DyedPrismarineBricksSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;

import java.util.List;

public class DyedBlocks implements MinekeaBlockCategory {
    public static final DyedDarkPrismarineBlock WHITE_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock ORANGE_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock MAGENTA_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock LIGHT_BLUE_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock YELLOW_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock LIME_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock PINK_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock GRAY_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock LIGHT_GRAY_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock CYAN_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock PURPLE_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock BLUE_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock BROWN_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock GREEN_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock RED_DARK_PRISMARINE_BLOCK;
    public static final DyedDarkPrismarineBlock BLACK_DARK_PRISMARINE_BLOCK;

    public static final DyedPrismarineBlock WHITE_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock ORANGE_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock MAGENTA_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock LIGHT_BLUE_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock YELLOW_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock LIME_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock PINK_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock GRAY_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock LIGHT_GRAY_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock CYAN_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock PURPLE_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock BLUE_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock BROWN_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock GREEN_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock RED_PRISMARINE_BLOCK;
    public static final DyedPrismarineBlock BLACK_PRISMARINE_BLOCK;

    public static final DyedPrismarineBricksBlock WHITE_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock ORANGE_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock MAGENTA_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock LIGHT_BLUE_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock YELLOW_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock LIME_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock PINK_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock GRAY_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock LIGHT_GRAY_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock CYAN_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock PURPLE_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock BLUE_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock BROWN_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock GREEN_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock RED_PRISMARINE_BRICKS_BLOCK;
    public static final DyedPrismarineBricksBlock BLACK_PRISMARINE_BRICKS_BLOCK;

    static {
        WHITE_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("white")
                .colorName("White")
                .dye(new Identifier("minecraft:white_dye"))
        );
        ORANGE_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("orange")
                .colorName("Orange")
                .dye(new Identifier("minecraft:orange_dye"))
        );
        MAGENTA_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("magenta")
                .colorName("Magenta")
                .dye(new Identifier("minecraft:magenta_dye"))
        );
        LIGHT_BLUE_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("light_blue")
                .colorName("Light Blue")
                .dye(new Identifier("minecraft:light_blue_dye"))
        );
        YELLOW_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("yellow")
                .colorName("Yellow")
                .dye(new Identifier("minecraft:yellow_dye"))
        );
        LIME_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("lime")
                .colorName("Lime")
                .dye(new Identifier("minecraft:lime_dye"))
        );
        PINK_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("pink")
                .colorName("Pink")
                .dye(new Identifier("minecraft:pink_dye"))
        );
        GRAY_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("gray")
                .colorName("Gray")
                .dye(new Identifier("minecraft:gray_dye"))
        );
        LIGHT_GRAY_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("light_gray")
                .colorName("Light Gray")
                .dye(new Identifier("minecraft:light_gray_dye"))
        );
        CYAN_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("cyan")
                .colorName("Cyan")
                .dye(new Identifier("minecraft:cyan_dye"))
        );
        PURPLE_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("purple")
                .colorName("Purple")
                .dye(new Identifier("minecraft:purple_dye"))
        );
        BLUE_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("blue")
                .colorName("Blue")
                .dye(new Identifier("minecraft:blue_dye"))
        );
        BROWN_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("brown")
                .colorName("Brown")
                .dye(new Identifier("minecraft:brown_dye"))
        );
        GREEN_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("green")
                .colorName("Green")
                .dye(new Identifier("minecraft:green_dye"))
        );
        RED_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("red")
                .colorName("Red")
                .dye(new Identifier("minecraft:red_dye"))
        );
        BLACK_DARK_PRISMARINE_BLOCK = new DyedDarkPrismarineBlock(
            new DyedDarkPrismarineSettings(BaseBlockSettings.DARK_PRISMARINE)
                .color("black")
                .colorName("Black")
                .dye(new Identifier("minecraft:black_dye"))
        );

        WHITE_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("white")
                .colorName("White")
                .dye(new Identifier("minecraft:white_dye"))
        );
        ORANGE_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("orange")
                .colorName("Orange")
                .dye(new Identifier("minecraft:orange_dye"))
        );
        MAGENTA_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("magenta")
                .colorName("Magenta")
                .dye(new Identifier("minecraft:magenta_dye"))
        );
        LIGHT_BLUE_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("light_blue")
                .colorName("Light Blue")
                .dye(new Identifier("minecraft:light_blue_dye"))
        );
        YELLOW_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("yellow")
                .colorName("Yellow")
                .dye(new Identifier("minecraft:yellow_dye"))
        );
        LIME_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("lime")
                .colorName("Lime")
                .dye(new Identifier("minecraft:lime_dye"))
        );
        PINK_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("pink")
                .colorName("Pink")
                .dye(new Identifier("minecraft:pink_dye"))
        );
        GRAY_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("gray")
                .colorName("Gray")
                .dye(new Identifier("minecraft:gray_dye"))
        );
        LIGHT_GRAY_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("light_gray")
                .colorName("Light Gray")
                .dye(new Identifier("minecraft:light_gray_dye"))
        );
        CYAN_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("cyan")
                .colorName("Cyan")
                .dye(new Identifier("minecraft:cyan_dye"))
        );
        PURPLE_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("purple")
                .colorName("Purple")
                .dye(new Identifier("minecraft:purple_dye"))
        );
        BLUE_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("blue")
                .colorName("Blue")
                .dye(new Identifier("minecraft:blue_dye"))
        );
        BROWN_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("brown")
                .colorName("Brown")
                .dye(new Identifier("minecraft:brown_dye"))
        );
        GREEN_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("green")
                .colorName("Green")
                .dye(new Identifier("minecraft:green_dye"))
        );
        RED_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("red")
                .colorName("Red")
                .dye(new Identifier("minecraft:red_dye"))
        );
        BLACK_PRISMARINE_BLOCK = new DyedPrismarineBlock(
            new DyedPrismarineSettings(BaseBlockSettings.PRISMARINE)
                .color("black")
                .colorName("Black")
                .dye(new Identifier("minecraft:black_dye"))
        );

        WHITE_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("white")
                .colorName("White")
                .dye(new Identifier("minecraft:white_dye"))
        );
        ORANGE_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("orange")
                .colorName("Orange")
                .dye(new Identifier("minecraft:orange_dye"))
        );
        MAGENTA_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("magenta")
                .colorName("Magenta")
                .dye(new Identifier("minecraft:magenta_dye"))
        );
        LIGHT_BLUE_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("light_blue")
                .colorName("Light Blue")
                .dye(new Identifier("minecraft:light_blue_dye"))
        );
        YELLOW_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("yellow")
                .colorName("Yellow")
                .dye(new Identifier("minecraft:yellow_dye"))
        );
        LIME_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("lime")
                .colorName("Lime")
                .dye(new Identifier("minecraft:lime_dye"))
        );
        PINK_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("pink")
                .colorName("Pink")
                .dye(new Identifier("minecraft:pink_dye"))
        );
        GRAY_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("gray")
                .colorName("Gray")
                .dye(new Identifier("minecraft:gray_dye"))
        );
        LIGHT_GRAY_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("light_gray")
                .colorName("Light Gray")
                .dye(new Identifier("minecraft:light_gray_dye"))
        );
        CYAN_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("cyan")
                .colorName("Cyan")
                .dye(new Identifier("minecraft:cyan_dye"))
        );
        PURPLE_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("purple")
                .colorName("Purple")
                .dye(new Identifier("minecraft:purple_dye"))
        );
        BLUE_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("blue")
                .colorName("Blue")
                .dye(new Identifier("minecraft:blue_dye"))
        );
        BROWN_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("brown")
                .colorName("Brown")
                .dye(new Identifier("minecraft:brown_dye"))
        );
        GREEN_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("green")
                .colorName("Green")
                .dye(new Identifier("minecraft:green_dye"))
        );
        RED_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("red")
                .colorName("Red")
                .dye(new Identifier("minecraft:red_dye"))
        );
        BLACK_PRISMARINE_BRICKS_BLOCK = new DyedPrismarineBricksBlock(
            new DyedPrismarineBricksSettings(BaseBlockSettings.PRISMARINE_BRICK)
                .color("black")
                .colorName("Black")
                .dye(new Identifier("minecraft:black_dye"))
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        WHITE_DARK_PRISMARINE_BLOCK.register();
        ORANGE_DARK_PRISMARINE_BLOCK.register();
        MAGENTA_DARK_PRISMARINE_BLOCK.register();
        LIGHT_BLUE_DARK_PRISMARINE_BLOCK.register();
        YELLOW_DARK_PRISMARINE_BLOCK.register();
        LIME_DARK_PRISMARINE_BLOCK.register();
        PINK_DARK_PRISMARINE_BLOCK.register();
        GRAY_DARK_PRISMARINE_BLOCK.register();
        LIGHT_GRAY_DARK_PRISMARINE_BLOCK.register();
        CYAN_DARK_PRISMARINE_BLOCK.register();
        PURPLE_DARK_PRISMARINE_BLOCK.register();
        BLUE_DARK_PRISMARINE_BLOCK.register();
        BROWN_DARK_PRISMARINE_BLOCK.register();
        GREEN_DARK_PRISMARINE_BLOCK.register();
        RED_DARK_PRISMARINE_BLOCK.register();
        BLACK_DARK_PRISMARINE_BLOCK.register();

        WHITE_PRISMARINE_BLOCK.register();
        ORANGE_PRISMARINE_BLOCK.register();
        MAGENTA_PRISMARINE_BLOCK.register();
        LIGHT_BLUE_PRISMARINE_BLOCK.register();
        YELLOW_PRISMARINE_BLOCK.register();
        LIME_PRISMARINE_BLOCK.register();
        PINK_PRISMARINE_BLOCK.register();
        GRAY_PRISMARINE_BLOCK.register();
        LIGHT_GRAY_PRISMARINE_BLOCK.register();
        CYAN_PRISMARINE_BLOCK.register();
        PURPLE_PRISMARINE_BLOCK.register();
        BLUE_PRISMARINE_BLOCK.register();
        BROWN_PRISMARINE_BLOCK.register();
        GREEN_PRISMARINE_BLOCK.register();
        RED_PRISMARINE_BLOCK.register();
        BLACK_PRISMARINE_BLOCK.register();

        WHITE_PRISMARINE_BRICKS_BLOCK.register();
        ORANGE_PRISMARINE_BRICKS_BLOCK.register();
        MAGENTA_PRISMARINE_BRICKS_BLOCK.register();
        LIGHT_BLUE_PRISMARINE_BRICKS_BLOCK.register();
        YELLOW_PRISMARINE_BRICKS_BLOCK.register();
        LIME_PRISMARINE_BRICKS_BLOCK.register();
        PINK_PRISMARINE_BRICKS_BLOCK.register();
        GRAY_PRISMARINE_BRICKS_BLOCK.register();
        LIGHT_GRAY_PRISMARINE_BRICKS_BLOCK.register();
        CYAN_PRISMARINE_BRICKS_BLOCK.register();
        PURPLE_PRISMARINE_BRICKS_BLOCK.register();
        BLUE_PRISMARINE_BRICKS_BLOCK.register();
        BROWN_PRISMARINE_BRICKS_BLOCK.register();
        GREEN_PRISMARINE_BRICKS_BLOCK.register();
        RED_PRISMARINE_BRICKS_BLOCK.register();
        BLACK_PRISMARINE_BRICKS_BLOCK.register();
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
    }

    public static abstract class DyedBlockSettings extends MinekeaBlockSettings<DyedBlockSettings> {
        protected String color = "";
        protected String colorName = "";
        protected Identifier dye = null;

        public DyedBlockSettings(DefaultSettings settings) {
            super(settings);
        }

        public String getColor() {
            return this.color;
        }

        public DyedBlockSettings color(String color) {
            this.color = color;
            return this;
        }

        public String getColorName() {
            return this.colorName;
        }

        public DyedBlockSettings colorName(String colorName) {
            this.colorName = colorName;
            return this;
        }

        public Identifier getDye() {
            return this.dye;
        }

        public DyedBlockSettings dye(Identifier dye) {
            this.dye = dye;
            return this;
        }
    }
}
