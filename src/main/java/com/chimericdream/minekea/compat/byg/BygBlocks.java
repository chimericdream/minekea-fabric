package com.chimericdream.minekea.compat.byg;

import com.chimericdream.minekea.compat.ModCompatLayer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class BygBlocks implements ModCompatLayer {
    public static final BygBarrels BARRELS;
    public static final BygCrates CRATES;
    public static final BygDisplayCases DISPLAY_CASES;
    public static final BygDoors DOORS;
    public static final BygStorageBookshelves STORAGE_BOOKSHELVES;
    public static final BygTrapdoors TRAPDOORS;

    static {
        BARRELS = new BygBarrels();
        CRATES = new BygCrates();
        DISPLAY_CASES = new BygDisplayCases();
        DOORS = new BygDoors();
        STORAGE_BOOKSHELVES = new BygStorageBookshelves();
        TRAPDOORS = new BygTrapdoors();
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
            BygDisplayCases.STRIPPED_WILLOW_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_WITCH_HAZEL_DISPLAY_CASE,
            BygDisplayCases.STRIPPED_ZELKOVA_DISPLAY_CASE
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
    }
}
