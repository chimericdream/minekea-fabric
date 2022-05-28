package com.chimericdream.minekea.compat.byg;

import com.chimericdream.minekea.block.building.slabs.GenericBookshelfSlab;
import com.chimericdream.minekea.block.building.slabs.GenericBookshelfSlab.BookshelfSlabSettings;
import net.minecraft.util.Identifier;

public class BygBookshelfSlabs {
    public static final GenericBookshelfSlab ASPEN_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab BAOBAB_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab BLUE_ENCHANTED_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab BULBIS_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab CHERRY_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab CIKA_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab CYPRESS_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab EBONY_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab EMBUR_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab ETHER_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab FIR_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab GREEN_ENCHANTED_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab HOLLY_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab JACARANDA_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab LAMENT_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab MAHOGANY_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab MANGROVE_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab MAPLE_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab NIGHTSHADE_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab PALM_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab PINE_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab RAINBOW_EUCALYPTUS_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab REDWOOD_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab SKYRIS_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab SYTHIAN_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab WILLOW_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab WITCH_HAZEL_BOOKSHELF_SLAB;
    public static final GenericBookshelfSlab ZELKOVA_BOOKSHELF_SLAB;

    static {
        ASPEN_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.ASPEN)
                .addMaterial("bookshelf", new Identifier("byg:aspen_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/aspen_bookshelf"))
        );
        BAOBAB_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.BAOBAB)
                .addMaterial("bookshelf", new Identifier("byg:baobab_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/baobab_bookshelf"))
        );
        BLUE_ENCHANTED_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.BLUE_ENCHANTED)
                .addMaterial("bookshelf", new Identifier("byg:blue_enchanted_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/blue_enchanted_bookshelf"))
        );
        BULBIS_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.BULBIS)
                .addMaterial("bookshelf", new Identifier("byg:bulbis_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/bulbis_bookshelf"))
        );
        CHERRY_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.CHERRY)
                .addMaterial("bookshelf", new Identifier("byg:cherry_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/cherry_bookshelf"))
        );
        CIKA_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.CIKA)
                .addMaterial("bookshelf", new Identifier("byg:cika_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/cika_bookshelf"))
        );
        CYPRESS_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.CYPRESS)
                .addMaterial("bookshelf", new Identifier("byg:cypress_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/cypress_bookshelf"))
        );
        EBONY_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.EBONY)
                .addMaterial("bookshelf", new Identifier("byg:ebony_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/ebony_bookshelf"))
        );
        EMBUR_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.EMBUR)
                .addMaterial("bookshelf", new Identifier("byg:embur_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/embur_bookshelf"))
        );
        ETHER_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.ETHER)
                .addMaterial("bookshelf", new Identifier("byg:ether_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/ether_bookshelf"))
        );
        FIR_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.FIR)
                .addMaterial("bookshelf", new Identifier("byg:fir_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/fir_bookshelf"))
        );
        GREEN_ENCHANTED_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.GREEN_ENCHANTED)
                .addMaterial("bookshelf", new Identifier("byg:green_enchanted_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/green_enchanted_bookshelf"))
        );
        HOLLY_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.HOLLY)
                .addMaterial("bookshelf", new Identifier("byg:holly_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/holly_bookshelf"))
        );
        JACARANDA_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.JACARANDA)
                .addMaterial("bookshelf", new Identifier("byg:jacaranda_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/jacaranda_bookshelf"))
        );
        LAMENT_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.LAMENT)
                .addMaterial("bookshelf", new Identifier("byg:lament_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/lament_bookshelf"))
        );
        MAHOGANY_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.MAHOGANY)
                .addMaterial("bookshelf", new Identifier("byg:mahogany_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/mahogany_bookshelf"))
        );
        MANGROVE_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.MANGROVE)
                .addMaterial("bookshelf", new Identifier("byg:mangrove_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/mangrove_bookshelf"))
        );
        MAPLE_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.MAPLE)
                .addMaterial("bookshelf", new Identifier("byg:maple_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/maple_bookshelf"))
        );
        NIGHTSHADE_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.NIGHTSHADE)
                .addMaterial("bookshelf", new Identifier("byg:nightshade_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/nightshade_bookshelf"))
        );
        PALM_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.PALM)
                .addMaterial("bookshelf", new Identifier("byg:palm_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/palm_bookshelf"))
        );
        PINE_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.PINE)
                .addMaterial("bookshelf", new Identifier("byg:pine_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/pine_bookshelf"))
        );
        RAINBOW_EUCALYPTUS_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.RAINBOW_EUCALYPTUS)
                .addMaterial("bookshelf", new Identifier("byg:rainbow_eucalyptus_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/rainbow_eucalyptus_bookshelf"))
        );
        REDWOOD_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.REDWOOD)
                .addMaterial("bookshelf", new Identifier("byg:redwood_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/redwood_bookshelf"))
        );
        SKYRIS_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.SKYRIS)
                .addMaterial("bookshelf", new Identifier("byg:skyris_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/skyris_bookshelf"))
        );
        SYTHIAN_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.SYTHIAN)
                .addMaterial("bookshelf", new Identifier("byg:sythian_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/sythian_bookshelf"))
        );
        WILLOW_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.WILLOW)
                .addMaterial("bookshelf", new Identifier("byg:willow_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/willow_bookshelf"))
        );
        WITCH_HAZEL_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.WITCH_HAZEL)
                .addMaterial("bookshelf", new Identifier("byg:witch_hazel_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/witch_hazel_bookshelf"))
        );
        ZELKOVA_BOOKSHELF_SLAB = new GenericBookshelfSlab(
            new BookshelfSlabSettings(BygBlockSettings.ZELKOVA)
                .addMaterial("bookshelf", new Identifier("byg:zelkova_bookshelf"))
                .addMaterial("model", new Identifier("byg:block/zelkova_bookshelf"))
        );
    }

    public void register() {
        ASPEN_BOOKSHELF_SLAB.register();
        BAOBAB_BOOKSHELF_SLAB.register();
        BLUE_ENCHANTED_BOOKSHELF_SLAB.register();
        BULBIS_BOOKSHELF_SLAB.register();
        CHERRY_BOOKSHELF_SLAB.register();
        CIKA_BOOKSHELF_SLAB.register();
        CYPRESS_BOOKSHELF_SLAB.register();
        EBONY_BOOKSHELF_SLAB.register();
        EMBUR_BOOKSHELF_SLAB.register();
        ETHER_BOOKSHELF_SLAB.register();
        FIR_BOOKSHELF_SLAB.register();
        GREEN_ENCHANTED_BOOKSHELF_SLAB.register();
        HOLLY_BOOKSHELF_SLAB.register();
        JACARANDA_BOOKSHELF_SLAB.register();
        LAMENT_BOOKSHELF_SLAB.register();
        MAHOGANY_BOOKSHELF_SLAB.register();
        MANGROVE_BOOKSHELF_SLAB.register();
        MAPLE_BOOKSHELF_SLAB.register();
        NIGHTSHADE_BOOKSHELF_SLAB.register();
        PALM_BOOKSHELF_SLAB.register();
        PINE_BOOKSHELF_SLAB.register();
        RAINBOW_EUCALYPTUS_BOOKSHELF_SLAB.register();
        REDWOOD_BOOKSHELF_SLAB.register();
        SKYRIS_BOOKSHELF_SLAB.register();
        SYTHIAN_BOOKSHELF_SLAB.register();
        WILLOW_BOOKSHELF_SLAB.register();
        WITCH_HAZEL_BOOKSHELF_SLAB.register();
        ZELKOVA_BOOKSHELF_SLAB.register();
    }
}
