//package com.chimericdream.minekea.item;
//
//import com.chimericdream.minekea.ModInfo;
//import com.chimericdream.minekea.block.building.beams.Beams;
//import com.chimericdream.minekea.block.building.compressed.CompressedBlocks;
//import com.chimericdream.minekea.block.building.covers.Covers;
//import com.chimericdream.minekea.block.furniture.bookshelves.Bookshelves;
//import com.chimericdream.minekea.block.furniture.bookshelves.StorageBookshelves;
//import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
//import com.chimericdream.minekea.block.furniture.doors.Doors;
//import com.chimericdream.minekea.block.furniture.pillows.Pillows;
//import com.chimericdream.minekea.block.furniture.seating.Seats;
//import com.chimericdream.minekea.block.furniture.shelves.Shelves;
//import com.chimericdream.minekea.block.furniture.tables.Tables;
//import com.chimericdream.minekea.block.furniture.trapdoors.Trapdoors;
//import com.chimericdream.minekea.config.ConfigManager;
//import com.chimericdream.minekea.config.MinekeaConfig;
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.Identifier;
//
//public class ItemGroups {
//    public static ItemGroup BEAMS = null;
//    public static ItemGroup COMPRESSED_BLOCKS = null;
//    public static ItemGroup COVERS = null;
//    public static ItemGroup FURNITURE = null;
//
//    static {
//        MinekeaConfig config = ConfigManager.getConfig();
//
//        if (config.enableBeams) {
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
//
//        if (isFurnitureEnabled()) {
//            FURNITURE = FabricItemGroupBuilder
//                .create(Identifier.of(ModInfo.MOD_ID, "blocks.furniture"))
//                .icon(ItemGroups::getFurnitureIcon)
//                .build();
//        }
//    }
//
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
//
//    protected static ItemStack getFurnitureIcon() {
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
//            return new ItemStack(DisplayCases.DISPLAY_CASES.get("acacia"));
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
//    }
//
//    public void setupResources() {
//        MinekeaResourcePack.EN_US.entry("itemGroup.minekea.blocks.building.beams", "Beams");
//        MinekeaResourcePack.EN_US.entry("itemGroup.minekea.blocks.building.compressed", "Compressed Blocks");
//        MinekeaResourcePack.EN_US.entry("itemGroup.minekea.blocks.building.covers", "Covers");
//        MinekeaResourcePack.EN_US.entry("itemGroup.minekea.blocks.furniture", "Furniture");
//    }
//}
