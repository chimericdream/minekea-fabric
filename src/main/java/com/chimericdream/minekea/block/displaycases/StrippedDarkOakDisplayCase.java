package com.chimericdream.minekea.block.displaycases;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.displaycases.entity.StrippedDarkOakDisplayCaseBlockEntity;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

public class StrippedDarkOakDisplayCase extends GenericDisplayCase {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "displaycases/stripped_dark_oak_display_case");

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StrippedDarkOakDisplayCaseBlockEntity(pos, state);
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        FuelRegistry.INSTANCE.add(this, 300);
        FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
    }
}
