package com.chimericdream.minekea.item;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.beams.Beams;
import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroups {
    public static ItemGroup BEAMS;
    public static RegistryKey<ItemGroup> BEAM_ITEM_GROUP_KEY = RegistryKey.of(
        Registries.ITEM_GROUP.getKey(),
        Identifier.of(ModInfo.MOD_ID, "item_group.minekea.blocks.building.beams")
    );
    //    public static ItemGroup COMPRESSED_BLOCKS = null;
//    public static ItemGroup COVERS = null;
    public static ItemGroup FURNITURE;
    public static final RegistryKey<ItemGroup> FURNITURE_ITEM_GROUP_KEY = RegistryKey.of(
        Registries.ITEM_GROUP.getKey(),
        Identifier.of(ModInfo.MOD_ID, "item_group.minekea.blocks.furniture")
    );

    static {
//        MinekeaConfig config = ConfigManager.getConfig();
//
//        if (config.enableBeams) {
        BEAMS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(Beams.BLOCKS.get(0)))
            .displayName(Text.translatable("item_group.minekea.blocks.building.beams"))
            .build();
//            BEAMS = FabricItemGroupBuilder
//                .create(Identifier.of(ModInfo.MOD_ID, "blocks.building.beams"))
//                .icon(() -> new ItemStack(Beams.BLOCKS.get("amethyst")))
//                .build();
//        }
//
//        if (config.enableCompressedBlocks) {
//            COMPRESSED_BLOCKS = FabricItemGroupBuilder
//                .create(Identifier.of(ModInfo.MOD_ID, "blocks.building.compressed"))
//                .icon(() -> new ItemStack(CompressedBlocks.BLOCK_MAP.get("cobblestone").get(8)))
//                .build();
//        }
//
//        if (config.enableCovers) {
//            COVERS = FabricItemGroupBuilder
//                .create(Identifier.of(ModInfo.MOD_ID, "blocks.building.covers"))
//                .icon(() -> new ItemStack(Covers.BLOCKS.get("crimson_stem")))
//                .build();
//        }

//        if (isFurnitureEnabled()) {
        FURNITURE = FabricItemGroup.builder()
            .icon(ItemGroups::getFurnitureIcon)
            .displayName(Text.translatable("item_group.minekea.blocks.furniture"))
            .build();
//        }
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
        return new ItemStack(DisplayCases.ACACIA_DISPLAY_CASE);
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
        Registry.register(Registries.ITEM_GROUP, FURNITURE_ITEM_GROUP_KEY, FURNITURE);
    }
}
