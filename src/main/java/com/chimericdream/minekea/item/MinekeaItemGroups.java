package com.chimericdream.minekea.item;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.building.compressed.CompressedBlocks;
import com.chimericdream.minekea.block.building.covers.Covers;
import com.chimericdream.minekea.block.building.dyed.DyedBlocks;
import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MinekeaItemGroups {
    public static ItemGroup BEAMS;
    public static RegistryKey<ItemGroup> BEAM_ITEM_GROUP_KEY = RegistryKey.of(
        Registries.ITEM_GROUP.getKey(),
        Identifier.of(ModInfo.MOD_ID, "item_group.minekea.blocks.building.beams")
    );

    public static ItemGroup COMPRESSED_BLOCKS;
    public static RegistryKey<ItemGroup> COMPRESSED_BLOCK_ITEM_GROUP_KEY = RegistryKey.of(
        Registries.ITEM_GROUP.getKey(),
        Identifier.of(ModInfo.MOD_ID, "item_group.minekea.blocks.building.compressed")
    );

    public static ItemGroup DYED_BLOCKS;
    public static RegistryKey<ItemGroup> DYED_BLOCK_ITEM_GROUP_KEY = RegistryKey.of(
        Registries.ITEM_GROUP.getKey(),
        Identifier.of(ModInfo.MOD_ID, "item_group.minekea.blocks.building.dyed")
    );

    public static ItemGroup COVERS;
    public static RegistryKey<ItemGroup> COVERS_ITEM_GROUP_KEY = RegistryKey.of(
        Registries.ITEM_GROUP.getKey(),
        Identifier.of(ModInfo.MOD_ID, "item_group.minekea.blocks.building.covers")
    );

    public static ItemGroup FURNITURE;
    public static final RegistryKey<ItemGroup> FURNITURE_ITEM_GROUP_KEY = RegistryKey.of(
        Registries.ITEM_GROUP.getKey(),
        Identifier.of(ModInfo.MOD_ID, "item_group.minekea.blocks.furniture")
    );

    static {
        BEAMS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Beams.BLOCKS.getFirst()))
            .displayName(Text.translatable("item_group.minekea.blocks.building.beams"))
            .build();

        COMPRESSED_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CompressedBlocks.BLOCKS.getFirst()))
            .displayName(Text.translatable("item_group.minekea.blocks.building.compressed"))
            .build();

        DYED_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(DyedBlocks.BLOCKS.getFirst()))
            .displayName(Text.translatable("item_group.minekea.blocks.building.dyed"))
            .build();

        COVERS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Covers.BLOCKS.getFirst()))
            .displayName(Text.translatable("item_group.minekea.blocks.building.covers"))
            .build();

        FURNITURE = FabricItemGroup.builder()
            .icon(() -> new ItemStack(DisplayCases.BLOCKS.getFirst()))
            .displayName(Text.translatable("item_group.minekea.blocks.furniture"))
            .build();
    }

    public void register() {
        Registry.register(Registries.ITEM_GROUP, BEAM_ITEM_GROUP_KEY, BEAMS);
        Registry.register(Registries.ITEM_GROUP, COMPRESSED_BLOCK_ITEM_GROUP_KEY, COMPRESSED_BLOCKS);
        Registry.register(Registries.ITEM_GROUP, COVERS_ITEM_GROUP_KEY, COVERS);
        Registry.register(Registries.ITEM_GROUP, DYED_BLOCK_ITEM_GROUP_KEY, DYED_BLOCKS);
        Registry.register(Registries.ITEM_GROUP, FURNITURE_ITEM_GROUP_KEY, FURNITURE);
    }
}
