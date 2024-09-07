package com.chimericdream.minekea.block.furniture.displaycases;

import com.chimericdream.minekea.ModInfo;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class StrippedDarkOakDisplayCase extends GenericDisplayCase {
    public static final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "furniture/display_cases/stripped/dark_oak");

    public StrippedDarkOakDisplayCase() {
        super(FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS));
    }

    @Override
    protected Block getPlanksBlock() {
        return Blocks.DARK_OAK_PLANKS;
    }

    @Override
    protected Block getLogBlock() {
        return Blocks.DARK_OAK_LOG;
    }

    @Override
    protected Block getStrippedLogBlock() {
        return Blocks.STRIPPED_DARK_OAK_LOG;
    }

    @Override
    protected Block getLogForRecipe() {
        return Blocks.STRIPPED_DARK_OAK_LOG;
    }

    @Override
    protected String getMaterialName() {
        return "Stripped Dark Oak";
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        FuelRegistry.INSTANCE.add(this, 300);
        FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
    }
}