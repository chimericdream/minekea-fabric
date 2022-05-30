package com.chimericdream.minekea.compat.byg;

import com.chimericdream.minekea.block.containers.crates.GenericCrate;
import com.chimericdream.minekea.block.furniture.bookshelves.GenericStorageBookshelf;
import com.chimericdream.minekea.block.furniture.displaycases.GenericDisplayCase;
import com.chimericdream.minekea.block.furniture.shelves.GenericShelf;
import com.chimericdream.minekea.compat.ModCompatLayer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import java.util.List;

import static com.chimericdream.minekea.compat.byg.BygBarrels.*;
import static com.chimericdream.minekea.compat.byg.BygCrates.*;
import static com.chimericdream.minekea.compat.byg.BygDisplayCases.*;
import static com.chimericdream.minekea.compat.byg.BygShelves.*;
import static com.chimericdream.minekea.compat.byg.BygStorageBookshelves.*;

public class BygBlocks implements ModCompatLayer {
    public static final BygBarrels BARRELS;
    public static final BygCrates CRATES;
    public static final BygDisplayCases DISPLAY_CASES;
    public static final BygDoors DOORS;
    public static final BygStorageBookshelves STORAGE_BOOKSHELVES;
    public static final BygTrapdoors TRAPDOORS;
    public static final BygBookshelfSlabs BOOKSHELF_SLABS;
    public static final BygBookshelfStairs BOOKSHELF_STAIRS;
    public static final BygShelves SHELVES;
    public static final BygTables TABLES;
    public static final BygSeats SEATS;

    static {
        BARRELS = new BygBarrels();
        CRATES = new BygCrates();
        DISPLAY_CASES = new BygDisplayCases();
        DOORS = new BygDoors();
        STORAGE_BOOKSHELVES = new BygStorageBookshelves();
        TRAPDOORS = new BygTrapdoors();
        BOOKSHELF_SLABS = new BygBookshelfSlabs();
        BOOKSHELF_STAIRS = new BygBookshelfStairs();
        SHELVES = new BygShelves();
        TABLES = new BygTables();
        SEATS = new BygSeats();
    }

    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getCutout(),
            ASPEN_DISPLAY_CASE,
            BAOBAB_DISPLAY_CASE,
            BLUE_ENCHANTED_DISPLAY_CASE,
            BULBIS_DISPLAY_CASE,
            CHERRY_DISPLAY_CASE,
            CIKA_DISPLAY_CASE,
            CYPRESS_DISPLAY_CASE,
            EBONY_DISPLAY_CASE,
            EMBUR_DISPLAY_CASE,
            ETHER_DISPLAY_CASE,
            FIR_DISPLAY_CASE,
            GREEN_ENCHANTED_DISPLAY_CASE,
            HOLLY_DISPLAY_CASE,
            IMPARIUS_DISPLAY_CASE,
            JACARANDA_DISPLAY_CASE,
            LAMENT_DISPLAY_CASE,
            MAHOGANY_DISPLAY_CASE,
            MANGROVE_DISPLAY_CASE,
            MAPLE_DISPLAY_CASE,
            NIGHTSHADE_DISPLAY_CASE,
            PALM_DISPLAY_CASE,
            PINE_DISPLAY_CASE,
            RAINBOW_EUCALYPTUS_DISPLAY_CASE,
            REDWOOD_DISPLAY_CASE,
            SKYRIS_DISPLAY_CASE,
            SYTHIAN_DISPLAY_CASE,
            WILLOW_DISPLAY_CASE,
            WITCH_HAZEL_DISPLAY_CASE,
            ZELKOVA_DISPLAY_CASE,
            STRIPPED_ASPEN_DISPLAY_CASE,
            STRIPPED_BAOBAB_DISPLAY_CASE,
            STRIPPED_BLUE_ENCHANTED_DISPLAY_CASE,
            STRIPPED_BULBIS_DISPLAY_CASE,
            STRIPPED_CHERRY_DISPLAY_CASE,
            STRIPPED_CIKA_DISPLAY_CASE,
            STRIPPED_CYPRESS_DISPLAY_CASE,
            STRIPPED_EBONY_DISPLAY_CASE,
            STRIPPED_EMBUR_DISPLAY_CASE,
            STRIPPED_ETHER_DISPLAY_CASE,
            STRIPPED_FIR_DISPLAY_CASE,
            STRIPPED_GREEN_ENCHANTED_DISPLAY_CASE,
            STRIPPED_HOLLY_DISPLAY_CASE,
            STRIPPED_IMPARIUS_DISPLAY_CASE,
            STRIPPED_JACARANDA_DISPLAY_CASE,
            STRIPPED_LAMENT_DISPLAY_CASE,
            STRIPPED_MAHOGANY_DISPLAY_CASE,
            STRIPPED_MANGROVE_DISPLAY_CASE,
            STRIPPED_MAPLE_DISPLAY_CASE,
            STRIPPED_NIGHTSHADE_DISPLAY_CASE,
            STRIPPED_PALM_DISPLAY_CASE,
            STRIPPED_PINE_DISPLAY_CASE,
            STRIPPED_RAINBOW_EUCALYPTUS_DISPLAY_CASE,
            STRIPPED_REDWOOD_DISPLAY_CASE,
            STRIPPED_SKYRIS_DISPLAY_CASE,
            STRIPPED_SYTHIAN_DISPLAY_CASE,
            STRIPPED_WILLOW_DISPLAY_CASE,
            STRIPPED_WITCH_HAZEL_DISPLAY_CASE,
            STRIPPED_ZELKOVA_DISPLAY_CASE
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getTranslucent(),
            ASPEN_BARREL,
            BAOBAB_BARREL,
            BLUE_ENCHANTED_BARREL,
            BULBIS_BARREL,
            CHERRY_BARREL,
            CIKA_BARREL,
            CYPRESS_BARREL,
            EBONY_BARREL,
            EMBUR_BARREL,
            ETHER_BARREL,
            FIR_BARREL,
            GREEN_ENCHANTED_BARREL,
            HOLLY_BARREL,
            IMPARIUS_BARREL,
            JACARANDA_BARREL,
            LAMENT_BARREL,
            MAHOGANY_BARREL,
            MANGROVE_BARREL,
            MAPLE_BARREL,
            NIGHTSHADE_BARREL,
            PALM_BARREL,
            PINE_BARREL,
            RAINBOW_EUCALYPTUS_BARREL,
            REDWOOD_BARREL,
            SKYRIS_BARREL,
            SYTHIAN_BARREL,
            WILLOW_BARREL,
            WITCH_HAZEL_BARREL,
            ZELKOVA_BARREL
        );
    }

    public void register() {
        BARRELS.register();
        CRATES.register();
        DISPLAY_CASES.register();
        DOORS.register();
        STORAGE_BOOKSHELVES.register();
        TRAPDOORS.register();
        BOOKSHELF_SLABS.register();
        BOOKSHELF_STAIRS.register();
        SHELVES.register();
        TABLES.register();
        SEATS.register();
    }

    @Override
    public List<GenericCrate> getCrates() {
        return List.of(
            ASPEN_CRATE,
            BAOBAB_CRATE,
            BLUE_ENCHANTED_CRATE,
            BULBIS_CRATE,
            CHERRY_CRATE,
            CIKA_CRATE,
            CYPRESS_CRATE,
            EBONY_CRATE,
            EMBUR_CRATE,
            ETHER_CRATE,
            FIR_CRATE,
            GREEN_ENCHANTED_CRATE,
            HOLLY_CRATE,
            IMPARIUS_CRATE,
            JACARANDA_CRATE,
            LAMENT_CRATE,
            MAHOGANY_CRATE,
            MANGROVE_CRATE,
            MAPLE_CRATE,
            NIGHTSHADE_CRATE,
            PALM_CRATE,
            PINE_CRATE,
            RAINBOW_EUCALYPTUS_CRATE,
            REDWOOD_CRATE,
            SKYRIS_CRATE,
            SYTHIAN_CRATE,
            WILLOW_CRATE,
            WITCH_HAZEL_CRATE,
            ZELKOVA_CRATE
        );
    }

    @Override
    public List<GenericDisplayCase> getDisplayCases() {
        return List.of(
            ASPEN_DISPLAY_CASE,
            BAOBAB_DISPLAY_CASE,
            BLUE_ENCHANTED_DISPLAY_CASE,
            BULBIS_DISPLAY_CASE,
            CHERRY_DISPLAY_CASE,
            CIKA_DISPLAY_CASE,
            CYPRESS_DISPLAY_CASE,
            EBONY_DISPLAY_CASE,
            EMBUR_DISPLAY_CASE,
            ETHER_DISPLAY_CASE,
            FIR_DISPLAY_CASE,
            GREEN_ENCHANTED_DISPLAY_CASE,
            HOLLY_DISPLAY_CASE,
            IMPARIUS_DISPLAY_CASE,
            JACARANDA_DISPLAY_CASE,
            LAMENT_DISPLAY_CASE,
            MAHOGANY_DISPLAY_CASE,
            MANGROVE_DISPLAY_CASE,
            MAPLE_DISPLAY_CASE,
            NIGHTSHADE_DISPLAY_CASE,
            PALM_DISPLAY_CASE,
            PINE_DISPLAY_CASE,
            RAINBOW_EUCALYPTUS_DISPLAY_CASE,
            REDWOOD_DISPLAY_CASE,
            SKYRIS_DISPLAY_CASE,
            SYTHIAN_DISPLAY_CASE,
            WILLOW_DISPLAY_CASE,
            WITCH_HAZEL_DISPLAY_CASE,
            ZELKOVA_DISPLAY_CASE,
            STRIPPED_ASPEN_DISPLAY_CASE,
            STRIPPED_BAOBAB_DISPLAY_CASE,
            STRIPPED_BLUE_ENCHANTED_DISPLAY_CASE,
            STRIPPED_BULBIS_DISPLAY_CASE,
            STRIPPED_CHERRY_DISPLAY_CASE,
            STRIPPED_CIKA_DISPLAY_CASE,
            STRIPPED_CYPRESS_DISPLAY_CASE,
            STRIPPED_EBONY_DISPLAY_CASE,
            STRIPPED_EMBUR_DISPLAY_CASE,
            STRIPPED_ETHER_DISPLAY_CASE,
            STRIPPED_FIR_DISPLAY_CASE,
            STRIPPED_GREEN_ENCHANTED_DISPLAY_CASE,
            STRIPPED_HOLLY_DISPLAY_CASE,
            STRIPPED_IMPARIUS_DISPLAY_CASE,
            STRIPPED_JACARANDA_DISPLAY_CASE,
            STRIPPED_LAMENT_DISPLAY_CASE,
            STRIPPED_MAHOGANY_DISPLAY_CASE,
            STRIPPED_MANGROVE_DISPLAY_CASE,
            STRIPPED_MAPLE_DISPLAY_CASE,
            STRIPPED_NIGHTSHADE_DISPLAY_CASE,
            STRIPPED_PALM_DISPLAY_CASE,
            STRIPPED_PINE_DISPLAY_CASE,
            STRIPPED_RAINBOW_EUCALYPTUS_DISPLAY_CASE,
            STRIPPED_REDWOOD_DISPLAY_CASE,
            STRIPPED_SKYRIS_DISPLAY_CASE,
            STRIPPED_SYTHIAN_DISPLAY_CASE,
            STRIPPED_WILLOW_DISPLAY_CASE,
            STRIPPED_WITCH_HAZEL_DISPLAY_CASE,
            STRIPPED_ZELKOVA_DISPLAY_CASE
        );
    }

    @Override
    public List<GenericShelf> getShelves() {
        return List.of(
            ASPEN_SHELF,
            BAOBAB_SHELF,
            BLUE_ENCHANTED_SHELF,
            BULBIS_SHELF,
            CHERRY_SHELF,
            CIKA_SHELF,
            CYPRESS_SHELF,
            EBONY_SHELF,
            EMBUR_SHELF,
            ETHER_SHELF,
            FIR_SHELF,
            GREEN_ENCHANTED_SHELF,
            IMPARIUS_SHELF,
            JACARANDA_SHELF,
            LAMENT_SHELF,
            MAHOGANY_SHELF,
            MANGROVE_SHELF,
            MAPLE_SHELF,
            NIGHTSHADE_SHELF,
            PALM_SHELF,
            PINE_SHELF,
            RAINBOW_EUCALYPTUS_SHELF,
            REDWOOD_SHELF,
            SKYRIS_SHELF,
            SYTHIAN_SHELF,
            WILLOW_SHELF,
            WITCH_HAZEL_SHELF,
            ZELKOVA_SHELF,
            ASPEN_FLOATING_SHELF,
            BAOBAB_FLOATING_SHELF,
            BLUE_ENCHANTED_FLOATING_SHELF,
            BULBIS_FLOATING_SHELF,
            CHERRY_FLOATING_SHELF,
            CIKA_FLOATING_SHELF,
            CYPRESS_FLOATING_SHELF,
            EBONY_FLOATING_SHELF,
            EMBUR_FLOATING_SHELF,
            ETHER_FLOATING_SHELF,
            FIR_FLOATING_SHELF,
            GREEN_ENCHANTED_FLOATING_SHELF,
            HOLLY_FLOATING_SHELF,
            IMPARIUS_FLOATING_SHELF,
            JACARANDA_FLOATING_SHELF,
            LAMENT_FLOATING_SHELF,
            MAHOGANY_FLOATING_SHELF,
            MANGROVE_FLOATING_SHELF,
            MAPLE_FLOATING_SHELF,
            NIGHTSHADE_FLOATING_SHELF,
            PALM_FLOATING_SHELF,
            PINE_FLOATING_SHELF,
            RAINBOW_EUCALYPTUS_FLOATING_SHELF,
            REDWOOD_FLOATING_SHELF,
            SKYRIS_FLOATING_SHELF,
            SYTHIAN_FLOATING_SHELF,
            WILLOW_FLOATING_SHELF,
            WITCH_HAZEL_FLOATING_SHELF,
            ZELKOVA_FLOATING_SHELF
        );
    }

    @Override
    public List<GenericStorageBookshelf> getStorageShelves() {
        return List.of(
            ASPEN_STORAGE_BOOKSHELF,
            BAOBAB_STORAGE_BOOKSHELF,
            BLUE_ENCHANTED_STORAGE_BOOKSHELF,
            BULBIS_STORAGE_BOOKSHELF,
            CHERRY_STORAGE_BOOKSHELF,
            CIKA_STORAGE_BOOKSHELF,
            CYPRESS_STORAGE_BOOKSHELF,
            EBONY_STORAGE_BOOKSHELF,
            EMBUR_STORAGE_BOOKSHELF,
            ETHER_STORAGE_BOOKSHELF,
            FIR_STORAGE_BOOKSHELF,
            GREEN_ENCHANTED_STORAGE_BOOKSHELF,
            HOLLY_STORAGE_BOOKSHELF,
            IMPARIUS_STORAGE_BOOKSHELF,
            JACARANDA_STORAGE_BOOKSHELF,
            LAMENT_STORAGE_BOOKSHELF,
            MAHOGANY_STORAGE_BOOKSHELF,
            MANGROVE_STORAGE_BOOKSHELF,
            MAPLE_STORAGE_BOOKSHELF,
            NIGHTSHADE_STORAGE_BOOKSHELF,
            PALM_STORAGE_BOOKSHELF,
            PINE_STORAGE_BOOKSHELF,
            RAINBOW_EUCALYPTUS_STORAGE_BOOKSHELF,
            REDWOOD_STORAGE_BOOKSHELF,
            SKYRIS_STORAGE_BOOKSHELF,
            SYTHIAN_STORAGE_BOOKSHELF,
            WILLOW_STORAGE_BOOKSHELF,
            WITCH_HAZEL_STORAGE_BOOKSHELF,
            ZELKOVA_STORAGE_BOOKSHELF
        );
    }
}
