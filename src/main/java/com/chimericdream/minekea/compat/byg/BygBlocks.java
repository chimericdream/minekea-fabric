package com.chimericdream.minekea.compat.byg;

import com.chimericdream.minekea.block.bookshelves.GenericStorageBookshelf;
import com.chimericdream.minekea.block.crates.GenericCrate;
import com.chimericdream.minekea.block.displaycases.GenericDisplayCase;
import com.chimericdream.minekea.block.shelves.GenericShelf;
import com.chimericdream.minekea.compat.ModCompatLayer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

import java.util.List;

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
    }

    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getCutout(),
            BygDisplayCases.ASPEN_DISPLAY_CASE,
            BygDisplayCases.BAOBAB_DISPLAY_CASE,
            BygDisplayCases.BLUE_ENCHANTED_DISPLAY_CASE,
            BygDisplayCases.BULBIS_DISPLAY_CASE,
            BygDisplayCases.CHERRY_DISPLAY_CASE,
            BygDisplayCases.CIKA_DISPLAY_CASE,
            BygDisplayCases.CYPRESS_DISPLAY_CASE,
            BygDisplayCases.EBONY_DISPLAY_CASE,
            BygDisplayCases.EMBUR_DISPLAY_CASE,
            BygDisplayCases.ETHER_DISPLAY_CASE,
            BygDisplayCases.FIR_DISPLAY_CASE,
            BygDisplayCases.GREEN_ENCHANTED_DISPLAY_CASE,
            BygDisplayCases.HOLLY_DISPLAY_CASE,
            BygDisplayCases.JACARANDA_DISPLAY_CASE,
            BygDisplayCases.LAMENT_DISPLAY_CASE,
            BygDisplayCases.MAHOGANY_DISPLAY_CASE,
            BygDisplayCases.MANGROVE_DISPLAY_CASE,
            BygDisplayCases.MAPLE_DISPLAY_CASE,
            BygDisplayCases.NIGHTSHADE_DISPLAY_CASE,
            BygDisplayCases.PALM_DISPLAY_CASE,
            BygDisplayCases.PINE_DISPLAY_CASE,
            BygDisplayCases.RAINBOW_EUCALYPTUS_DISPLAY_CASE,
            BygDisplayCases.REDWOOD_DISPLAY_CASE,
            BygDisplayCases.SKYRIS_DISPLAY_CASE,
            BygDisplayCases.SYTHIAN_DISPLAY_CASE,
            BygDisplayCases.WILLOW_DISPLAY_CASE,
            BygDisplayCases.WITCH_HAZEL_DISPLAY_CASE,
            BygDisplayCases.ZELKOVA_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_ASPEN_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_BAOBAB_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_BLUE_ENCHANTED_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_BULBIS_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_CHERRY_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_CIKA_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_CYPRESS_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_EBONY_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_EMBUR_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_ETHER_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_FIR_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_GREEN_ENCHANTED_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_HOLLY_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_JACARANDA_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_LAMENT_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_MAHOGANY_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_MANGROVE_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_MAPLE_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_NIGHTSHADE_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_PALM_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_PINE_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_RAINBOW_EUCALYPTUS_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_REDWOOD_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_SKYRIS_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_SYTHIAN_DISPLAY_CASE,
            STRIPPED_WILLOW_DISPLAY_CASE,
            STRIPPED_WITCH_HAZEL_DISPLAY_CASE,
            STRIPPED_ZELKOVA_DISPLAY_CASE
        );

        BlockRenderLayerMap.INSTANCE.putBlocks(
            RenderLayer.getTranslucent(),
            BygBarrels.ASPEN_BARREL,
            BygBarrels.BAOBAB_BARREL,
            BygBarrels.BLUE_ENCHANTED_BARREL,
            BygBarrels.BULBIS_BARREL,
            BygBarrels.CHERRY_BARREL,
            BygBarrels.CIKA_BARREL,
            BygBarrels.CYPRESS_BARREL,
            BygBarrels.EBONY_BARREL,
            BygBarrels.EMBUR_BARREL,
            BygBarrels.ETHER_BARREL,
            BygBarrels.FIR_BARREL,
            BygBarrels.GREEN_ENCHANTED_BARREL,
            BygBarrels.HOLLY_BARREL,
            BygBarrels.JACARANDA_BARREL,
            BygBarrels.LAMENT_BARREL,
            BygBarrels.MAHOGANY_BARREL,
            BygBarrels.MANGROVE_BARREL,
            BygBarrels.MAPLE_BARREL,
            BygBarrels.NIGHTSHADE_BARREL,
            BygBarrels.PALM_BARREL,
            BygBarrels.PINE_BARREL,
            BygBarrels.RAINBOW_EUCALYPTUS_BARREL,
            BygBarrels.REDWOOD_BARREL,
            BygBarrels.SKYRIS_BARREL,
            BygBarrels.SYTHIAN_BARREL,
            BygBarrels.WILLOW_BARREL,
            BygBarrels.WITCH_HAZEL_BARREL,
            BygBarrels.ZELKOVA_BARREL
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
            HOLLY_SHELF,
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
            ASPEN_STORAGE_SHELF,
            BAOBAB_STORAGE_SHELF,
            BLUE_ENCHANTED_STORAGE_SHELF,
            BULBIS_STORAGE_SHELF,
            CHERRY_STORAGE_SHELF,
            CIKA_STORAGE_SHELF,
            CYPRESS_STORAGE_SHELF,
            EBONY_STORAGE_SHELF,
            EMBUR_STORAGE_SHELF,
            ETHER_STORAGE_SHELF,
            FIR_STORAGE_SHELF,
            GREEN_ENCHANTED_STORAGE_SHELF,
            HOLLY_STORAGE_SHELF,
            JACARANDA_STORAGE_SHELF,
            LAMENT_STORAGE_SHELF,
            MAHOGANY_STORAGE_SHELF,
            MANGROVE_STORAGE_SHELF,
            MAPLE_STORAGE_SHELF,
            NIGHTSHADE_STORAGE_SHELF,
            PALM_STORAGE_SHELF,
            PINE_STORAGE_SHELF,
            RAINBOW_EUCALYPTUS_STORAGE_SHELF,
            REDWOOD_STORAGE_SHELF,
            SKYRIS_STORAGE_SHELF,
            SYTHIAN_STORAGE_SHELF,
            WILLOW_STORAGE_SHELF,
            WITCH_HAZEL_STORAGE_SHELF,
            ZELKOVA_STORAGE_SHELF
        );
    }
}
