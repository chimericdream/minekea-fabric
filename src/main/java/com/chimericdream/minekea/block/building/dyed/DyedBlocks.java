package com.chimericdream.minekea.block.building.dyed;

import com.chimericdream.minekea.block.building.dyed.DyedBlock.DyedBlockSettings;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.settings.BaseBlockSettings;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DyedBlocks implements MinekeaBlockCategory {
    public static final Map<String, DyedBlock> BLOCKS = new LinkedHashMap<>();

    static {
        for (MinekeaBlockSettings.DefaultSettings settings : BaseBlockSettings.ALL_SETTINGS) {
            if (settings.hasDyedBlock()) {
                BLOCKS.put(settings.getMainMaterial() + "white", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("white")
                        .colorName("White")
                        .dye(new Identifier("minecraft:white_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "orange", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("orange")
                        .colorName("Orange")
                        .dye(new Identifier("minecraft:orange_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "magenta", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("magenta")
                        .colorName("Magenta")
                        .dye(new Identifier("minecraft:magenta_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "light_blue", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("light_blue")
                        .colorName("Light Blue")
                        .dye(new Identifier("minecraft:light_blue_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "yellow", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("yellow")
                        .colorName("Yellow")
                        .dye(new Identifier("minecraft:yellow_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "lime", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("lime")
                        .colorName("Lime")
                        .dye(new Identifier("minecraft:lime_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "pink", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("pink")
                        .colorName("Pink")
                        .dye(new Identifier("minecraft:pink_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "gray", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("gray")
                        .colorName("Gray")
                        .dye(new Identifier("minecraft:gray_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "light_gray", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("light_gray")
                        .colorName("Light Gray")
                        .dye(new Identifier("minecraft:light_gray_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "cyan", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("cyan")
                        .colorName("Cyan")
                        .dye(new Identifier("minecraft:cyan_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "purple", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("purple")
                        .colorName("Purple")
                        .dye(new Identifier("minecraft:purple_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "blue", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("blue")
                        .colorName("Blue")
                        .dye(new Identifier("minecraft:blue_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "brown", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("brown")
                        .colorName("Brown")
                        .dye(new Identifier("minecraft:brown_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "green", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("green")
                        .colorName("Green")
                        .dye(new Identifier("minecraft:green_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "red", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("red")
                        .colorName("Red")
                        .dye(new Identifier("minecraft:red_dye"))
                ));
                BLOCKS.put(settings.getMainMaterial() + "black", new DyedBlock(
                    new DyedBlockSettings(settings)
                        .color("black")
                        .colorName("Black")
                        .dye(new Identifier("minecraft:black_dye"))
                ));
            }
        }
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
    }

    @Override
    public void registerBlocks() {
        for (DyedBlock block : BLOCKS.values()) {
            block.register();
        }
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
}
