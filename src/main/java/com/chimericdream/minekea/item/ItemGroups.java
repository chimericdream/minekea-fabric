package com.chimericdream.minekea.item;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.building.compressed.CompressedBlocks;
import com.chimericdream.minekea.block.building.covers.Covers;
import com.chimericdream.minekea.block.furniture.seating.Seats;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ItemGroups {
    public static final ItemGroup BEAMS = FabricItemGroupBuilder
        .create(new Identifier(ModInfo.MOD_ID, "blocks.building.beams"))
        .icon(() -> new ItemStack(Beams.BLOCKS.get("amethyst")))
        .build();

    public static final ItemGroup COMPRESSED_BLOCKS = FabricItemGroupBuilder
        .create(new Identifier(ModInfo.MOD_ID, "blocks.building.compressed"))
        .icon(() -> new ItemStack(CompressedBlocks.BLOCK_MAP.get("cobblestone").get(8)))
        .build();

    public static final ItemGroup COVERS = FabricItemGroupBuilder
        .create(new Identifier(ModInfo.MOD_ID, "blocks.building.covers"))
        .icon(() -> new ItemStack(Covers.CRIMSON_STEM_COVER))
        .build();

    public static final ItemGroup FURNITURE = FabricItemGroupBuilder
        .create(new Identifier(ModInfo.MOD_ID, "blocks.furniture"))
        .icon(() -> new ItemStack(Seats.ACACIA_CHAIR))
        .build();

    public void setupResources() {
        MinekeaResourcePack.EN_US.entry("itemGroup.minekea.blocks.building.beams", "Beams");
        MinekeaResourcePack.EN_US.entry("itemGroup.minekea.blocks.building.compressed", "Compressed Blocks");
        MinekeaResourcePack.EN_US.entry("itemGroup.minekea.blocks.building.covers", "Covers");
        MinekeaResourcePack.EN_US.entry("itemGroup.minekea.blocks.furniture", "Furniture");
    }
}
