package com.chimericdream.minekea.block.furniture.displaycases;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class StrippedWarpedDisplayCase extends GenericDisplayCase {
    public static final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "furniture/display_cases/stripped/warped");

    public StrippedWarpedDisplayCase() {
        super(AbstractBlock.Settings.copy(Blocks.WARPED_PLANKS));
    }

    @Override
    protected Block getPlanksBlock() {
        return Blocks.WARPED_PLANKS;
    }

    @Override
    protected Block getLogBlock() {
        return Blocks.WARPED_STEM;
    }

    @Override
    protected Block getStrippedLogBlock() {
        return Blocks.STRIPPED_WARPED_STEM;
    }

    @Override
    protected Block getLogForRecipe() {
        return Blocks.STRIPPED_WARPED_STEM;
    }

    @Override
    protected String getMaterialName() {
        return "Stripped Warped";
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));
    }
}
