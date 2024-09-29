package com.chimericdream.minekea.item;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.building.compressed.CompressedBlocks;
import com.chimericdream.minekea.block.building.covers.Covers;
import com.chimericdream.minekea.block.building.dyed.DyedBlocks;
import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
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
            .icon(() -> new ItemStack(Beams.BLOCKS.get(0)))
            .displayName(Text.translatable("item_group.minekea.blocks.building.beams"))
            .build();

        COMPRESSED_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(CompressedBlocks.BLOCKS.get(0)))
            .displayName(Text.translatable("item_group.minekea.blocks.building.compressed"))
            .build();

        DYED_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack((Block) DyedBlocks.BLOCKS.get(0)))
            .displayName(Text.translatable("item_group.minekea.blocks.building.dyed"))
            .build();

        COVERS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Covers.BLOCKS.get(0)))
            .displayName(Text.translatable("item_group.minekea.blocks.building.covers"))
            .build();

        FURNITURE = FabricItemGroup.builder()
            .icon(MinekeaItemGroups::getFurnitureIcon)
            .displayName(Text.translatable("item_group.minekea.blocks.furniture"))
            .build();
    }

//    protected static boolean isFurnitureEnabled() {
//        MinekeaConfig config = ConfigManager.getConfig();
//
//        return config.enableBookshelves
//            || config.enableStorageBookshelves
//            || config.enableDisplayCases
//            || config.enableDoors
//            || config.enablePillows
//            || config.enableChairs
//            || config.enableStools
//            || config.enableShelves
//            || config.enableTables
//            || config.enableTrapdoors;
//    }

    protected static ItemStack getFurnitureIcon() {
//        MinekeaConfig config = ConfigManager.getConfig();
//
//        if (config.enableChairs) {
//            return new ItemStack(Seats.CHAIRS.get("acacia"));
//        }
//
//        if (config.enableStools) {
//            return new ItemStack(Seats.STOOLS.get("acacia"));
//        }
//
//        if (config.enableTables) {
//            return new ItemStack(Tables.TABLES.get("acacia"));
//        }
//
//        if (config.enableShelves) {
//            return new ItemStack(Shelves.SHELVES.get("acacia"));
//        }
//
//        if (config.enableDisplayCases) {
        return new ItemStack(DisplayCases.DISPLAY_CASES.getFirst());
//        }
//
//        if (config.enableBookshelves) {
//            return new ItemStack(Bookshelves.BOOKSHELVES.get("acacia"));
//        }
//
//        if (config.enableStorageBookshelves) {
//            return new ItemStack(StorageBookshelves.STORAGE_BOOKSHELVES.get("acacia"));
//        }
//
//        if (config.enablePillows) {
//            return new ItemStack(Pillows.GREEN_PILLOW);
//        }
//
//        if (config.enableDoors) {
//            return new ItemStack(Doors.BOOKSHELF_DOORS.get("acacia"));
//        }
//
//        if (config.enableTrapdoors) {
//            return new ItemStack(Trapdoors.BOOKSHELF_TRAPDOORS.get("acacia"));
//        }
//
//        return new ItemStack(net.minecraft.item.Items.COBBLESTONE);
    }

    public void register() {
        Registry.register(Registries.ITEM_GROUP, BEAM_ITEM_GROUP_KEY, BEAMS);
        Registry.register(Registries.ITEM_GROUP, COMPRESSED_BLOCK_ITEM_GROUP_KEY, COMPRESSED_BLOCKS);
        Registry.register(Registries.ITEM_GROUP, COVERS_ITEM_GROUP_KEY, COVERS);
        Registry.register(Registries.ITEM_GROUP, DYED_BLOCK_ITEM_GROUP_KEY, DYED_BLOCKS);
        Registry.register(Registries.ITEM_GROUP, FURNITURE_ITEM_GROUP_KEY, FURNITURE);
    }
}
