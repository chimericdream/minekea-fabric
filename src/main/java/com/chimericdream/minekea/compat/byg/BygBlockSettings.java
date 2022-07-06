package com.chimericdream.minekea.compat.byg;

import com.chimericdream.minekea.settings.MinekeaBlockSettings.DefaultSettings;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

import java.util.Map;

public class BygBlockSettings {
    public static DefaultSettings ASPEN = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("aspen")
        .ingredientName("Aspen")
        .materials(
            Map.of(
                "main", new Identifier("byg:aspen_planks"),
                "slab", new Identifier("byg:aspen_slab"),
                "log", new Identifier("byg:aspen_log")
            )
        )
        .texture("planks", new Identifier("byg:block/aspen/planks"))
        .texture("main", new Identifier("byg:block/aspen/planks"))
        .texture("stripped_log", new Identifier("byg:block/aspen/stripped_log"))
        .texture("log", new Identifier("byg:block/aspen/log"));

    public static DefaultSettings BAOBAB = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("baobab")
        .ingredientName("Baobab")
        .materials(
            Map.of(
                "main", new Identifier("byg:baobab_planks"),
                "slab", new Identifier("byg:baobab_slab"),
                "log", new Identifier("byg:baobab_log")
            )
        )
        .texture("planks", new Identifier("byg:block/baobab/planks"))
        .texture("main", new Identifier("byg:block/baobab/planks"))
        .texture("stripped_log", new Identifier("byg:block/baobab/stripped_log"))
        .texture("log", new Identifier("byg:block/baobab/log"));

    public static DefaultSettings BLUE_ENCHANTED = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("blue_enchanted")
        .ingredientName("Blue Enchanted")
        .materials(
            Map.of(
                "main", new Identifier("byg:blue_enchanted_planks"),
                "slab", new Identifier("byg:blue_enchanted_slab"),
                "log", new Identifier("byg:blue_enchanted_log")
            )
        )
        .texture("planks", new Identifier("byg:block/blue_enchanted/planks"))
        .texture("main", new Identifier("byg:block/blue_enchanted/planks"))
        .texture("stripped_log", new Identifier("byg:block/blue_enchanted/stripped_log"))
        .texture("log", new Identifier("byg:block/blue_enchanted/log"));

    public static DefaultSettings BULBIS = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("bulbis")
        .ingredientName("Bulbis")
        .materials(
            Map.of(
                "main", new Identifier("byg:bulbis_planks"),
                "slab", new Identifier("byg:bulbis_slab"),
                "log", new Identifier("byg:bulbis_stem")
            )
        )
        .texture("planks", new Identifier("byg:block/bulbis/planks"))
        .texture("main", new Identifier("byg:block/bulbis/planks"))
        .texture("stripped_log", new Identifier("byg:block/bulbis/stripped_log"))
        .texture("log", new Identifier("byg:block/bulbis/log"));

    public static DefaultSettings CHERRY = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("cherry")
        .ingredientName("Cherry")
        .materials(
            Map.of(
                "main", new Identifier("byg:cherry_planks"),
                "slab", new Identifier("byg:cherry_slab"),
                "log", new Identifier("byg:cherry_log")
            )
        )
        .texture("planks", new Identifier("byg:block/cherry/planks"))
        .texture("main", new Identifier("byg:block/cherry/planks"))
        .texture("stripped_log", new Identifier("byg:block/cherry/stripped_log"))
        .texture("log", new Identifier("byg:block/cherry/log"));

    public static DefaultSettings CIKA = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("cika")
        .ingredientName("Cika")
        .materials(
            Map.of(
                "main", new Identifier("byg:cika_planks"),
                "slab", new Identifier("byg:cika_slab"),
                "log", new Identifier("byg:cika_log")
            )
        )
        .texture("planks", new Identifier("byg:block/cika/planks"))
        .texture("main", new Identifier("byg:block/cika/planks"))
        .texture("stripped_log", new Identifier("byg:block/cika/stripped_log"))
        .texture("log", new Identifier("byg:block/cika/log"));

    public static DefaultSettings CYPRESS = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("cypress")
        .ingredientName("Cypress")
        .materials(
            Map.of(
                "main", new Identifier("byg:cypress_planks"),
                "slab", new Identifier("byg:cypress_slab"),
                "log", new Identifier("byg:cypress_log")
            )
        )
        .texture("planks", new Identifier("byg:block/cypress/planks"))
        .texture("main", new Identifier("byg:block/cypress/planks"))
        .texture("stripped_log", new Identifier("byg:block/cypress/stripped_log"))
        .texture("log", new Identifier("byg:block/cypress/log"));

    public static DefaultSettings EBONY = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("ebony")
        .ingredientName("Ebony")
        .materials(
            Map.of(
                "main", new Identifier("byg:ebony_planks"),
                "slab", new Identifier("byg:ebony_slab"),
                "log", new Identifier("byg:ebony_log")
            )
        )
        .texture("planks", new Identifier("byg:block/ebony/planks"))
        .texture("main", new Identifier("byg:block/ebony/planks"))
        .texture("stripped_log", new Identifier("byg:block/ebony/stripped_log"))
        .texture("log", new Identifier("byg:block/ebony/log"));

    public static DefaultSettings EMBUR = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("embur")
        .ingredientName("Embur")
        .materials(
            Map.of(
                "main", new Identifier("byg:embur_planks"),
                "slab", new Identifier("byg:embur_slab"),
                "log", new Identifier("byg:embur_pedu")
            )
        )
        .texture("planks", new Identifier("byg:block/embur/planks"))
        .texture("main", new Identifier("byg:block/embur/planks"))
        .texture("stripped_log", new Identifier("byg:block/embur/stripped_log"))
        .texture("log", new Identifier("byg:block/embur/log"));

    public static DefaultSettings ETHER = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("ether")
        .ingredientName("Ether")
        .materials(
            Map.of(
                "main", new Identifier("byg:ether_planks"),
                "slab", new Identifier("byg:ether_slab"),
                "log", new Identifier("byg:ether_log")
            )
        )
        .texture("planks", new Identifier("byg:block/ether/planks"))
        .texture("main", new Identifier("byg:block/ether/planks"))
        .texture("stripped_log", new Identifier("byg:block/ether/stripped_log"))
        .texture("log", new Identifier("byg:block/ether/log"));

    public static DefaultSettings FIR = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("fir")
        .ingredientName("Fir")
        .materials(
            Map.of(
                "main", new Identifier("byg:fir_planks"),
                "slab", new Identifier("byg:fir_slab"),
                "log", new Identifier("byg:fir_log")
            )
        )
        .texture("planks", new Identifier("byg:block/fir/planks"))
        .texture("main", new Identifier("byg:block/fir/planks"))
        .texture("stripped_log", new Identifier("byg:block/fir/stripped_log"))
        .texture("log", new Identifier("byg:block/fir/log"));

    public static DefaultSettings GREEN_ENCHANTED = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("green_enchanted")
        .ingredientName("Green Enchanted")
        .materials(
            Map.of(
                "main", new Identifier("byg:green_enchanted_planks"),
                "slab", new Identifier("byg:green_enchanted_slab"),
                "log", new Identifier("byg:green_enchanted_log")
            )
        )
        .texture("planks", new Identifier("byg:block/green_enchanted/planks"))
        .texture("main", new Identifier("byg:block/green_enchanted/planks"))
        .texture("stripped_log", new Identifier("byg:block/green_enchanted/stripped_log"))
        .texture("log", new Identifier("byg:block/green_enchanted/log"));

    public static DefaultSettings HOLLY = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("holly")
        .ingredientName("Holly")
        .materials(
            Map.of(
                "main", new Identifier("byg:holly_planks"),
                "slab", new Identifier("byg:holly_slab"),
                "log", new Identifier("byg:holly_log")
            )
        )
        .texture("planks", new Identifier("byg:block/holly/planks"))
        .texture("main", new Identifier("byg:block/holly/planks"))
        .texture("stripped_log", new Identifier("byg:block/holly/stripped_log"))
        .texture("log", new Identifier("byg:block/holly/log"));

    public static DefaultSettings IMPARIUS = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("imparius")
        .ingredientName("Imparius")
        .materials(
            Map.of(
                "main", new Identifier("byg:imparius_planks"),
                "slab", new Identifier("byg:imparius_slab"),
                "log", new Identifier("byg:imparius_stem")
            )
        )
        .texture("planks", new Identifier("byg:block/imparius/planks"))
        .texture("main", new Identifier("byg:block/imparius/planks"))
        .texture("stripped_log", new Identifier("byg:block/fungal_imparius_block"))
        .texture("log", new Identifier("byg:block/fungal_imparius_stem"));

    public static DefaultSettings JACARANDA = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("jacaranda")
        .ingredientName("Jacaranda")
        .materials(
            Map.of(
                "main", new Identifier("byg:jacaranda_planks"),
                "slab", new Identifier("byg:jacaranda_slab"),
                "log", new Identifier("byg:jacaranda_log")
            )
        )
        .texture("planks", new Identifier("byg:block/jacaranda/planks"))
        .texture("main", new Identifier("byg:block/jacaranda/planks"))
        .texture("stripped_log", new Identifier("byg:block/jacaranda/stripped_log"))
        .texture("log", new Identifier("byg:block/jacaranda/log"));

    public static DefaultSettings LAMENT = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("lament")
        .ingredientName("Lament")
        .materials(
            Map.of(
                "main", new Identifier("byg:lament_planks"),
                "slab", new Identifier("byg:lament_slab"),
                "log", new Identifier("byg:lament_log")
            )
        )
        .texture("planks", new Identifier("byg:block/lament/planks"))
        .texture("main", new Identifier("byg:block/lament/planks"))
        .texture("stripped_log", new Identifier("byg:block/lament/stripped_log"))
        .texture("log", new Identifier("byg:block/lament/log"));

    public static DefaultSettings MAHOGANY = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("mahogany")
        .ingredientName("Mahogany")
        .materials(
            Map.of(
                "main", new Identifier("byg:mahogany_planks"),
                "slab", new Identifier("byg:mahogany_slab"),
                "log", new Identifier("byg:mahogany_log")
            )
        )
        .texture("planks", new Identifier("byg:block/mahogany/planks"))
        .texture("main", new Identifier("byg:block/mahogany/planks"))
        .texture("stripped_log", new Identifier("byg:block/mahogany/stripped_log"))
        .texture("log", new Identifier("byg:block/mahogany/log"));

    public static DefaultSettings MAPLE = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("maple")
        .ingredientName("Maple")
        .materials(
            Map.of(
                "main", new Identifier("byg:maple_planks"),
                "slab", new Identifier("byg:maple_slab"),
                "log", new Identifier("byg:maple_log")
            )
        )
        .texture("planks", new Identifier("byg:block/maple/planks"))
        .texture("main", new Identifier("byg:block/maple/planks"))
        .texture("stripped_log", new Identifier("byg:block/maple/stripped_log"))
        .texture("log", new Identifier("byg:block/maple/log"));

    public static DefaultSettings NIGHTSHADE = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("nightshade")
        .ingredientName("Nightshade")
        .materials(
            Map.of(
                "main", new Identifier("byg:nightshade_planks"),
                "slab", new Identifier("byg:nightshade_slab"),
                "log", new Identifier("byg:nightshade_log")
            )
        )
        .texture("planks", new Identifier("byg:block/nightshade/planks"))
        .texture("main", new Identifier("byg:block/nightshade/planks"))
        .texture("stripped_log", new Identifier("byg:block/nightshade/stripped_log"))
        .texture("log", new Identifier("byg:block/nightshade/log"));

    public static DefaultSettings PALM = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("palm")
        .ingredientName("Palm")
        .materials(
            Map.of(
                "main", new Identifier("byg:palm_planks"),
                "slab", new Identifier("byg:palm_slab"),
                "log", new Identifier("byg:palm_log")
            )
        )
        .texture("planks", new Identifier("byg:block/palm/planks"))
        .texture("main", new Identifier("byg:block/palm/planks"))
        .texture("stripped_log", new Identifier("byg:block/palm/stripped_log"))
        .texture("log", new Identifier("byg:block/palm/log"));

    public static DefaultSettings PINE = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("pine")
        .ingredientName("Pine")
        .materials(
            Map.of(
                "main", new Identifier("byg:pine_planks"),
                "slab", new Identifier("byg:pine_slab"),
                "log", new Identifier("byg:pine_log")
            )
        )
        .texture("planks", new Identifier("byg:block/pine/planks"))
        .texture("main", new Identifier("byg:block/pine/planks"))
        .texture("stripped_log", new Identifier("byg:block/pine/stripped_log"))
        .texture("log", new Identifier("byg:block/pine/log"));

    public static DefaultSettings RAINBOW_EUCALYPTUS = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("rainbow_eucalyptus")
        .ingredientName("Rainbow Eucalyptus")
        .materials(
            Map.of(
                "main", new Identifier("byg:rainbow_eucalyptus_planks"),
                "slab", new Identifier("byg:rainbow_eucalyptus_slab"),
                "log", new Identifier("byg:rainbow_eucalyptus_log")
            )
        )
        .texture("planks", new Identifier("byg:block/rainbow_eucalyptus/planks"))
        .texture("main", new Identifier("byg:block/rainbow_eucalyptus/planks"))
        .texture("stripped_log", new Identifier("byg:block/rainbow_eucalyptus/stripped_log"))
        .texture("log", new Identifier("byg:block/rainbow_eucalyptus/log"));

    public static DefaultSettings REDWOOD = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("redwood")
        .ingredientName("Redwood")
        .materials(
            Map.of(
                "main", new Identifier("byg:redwood_planks"),
                "slab", new Identifier("byg:redwood_slab"),
                "log", new Identifier("byg:redwood_log")
            )
        )
        .texture("planks", new Identifier("byg:block/redwood/planks"))
        .texture("main", new Identifier("byg:block/redwood/planks"))
        .texture("stripped_log", new Identifier("byg:block/redwood/stripped_log"))
        .texture("log", new Identifier("byg:block/redwood/log"));

    public static DefaultSettings SKYRIS = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("skyris")
        .ingredientName("Skyris")
        .materials(
            Map.of(
                "main", new Identifier("byg:skyris_planks"),
                "slab", new Identifier("byg:skyris_slab"),
                "log", new Identifier("byg:skyris_log")
            )
        )
        .texture("planks", new Identifier("byg:block/skyris/planks"))
        .texture("main", new Identifier("byg:block/skyris/planks"))
        .texture("stripped_log", new Identifier("byg:block/skyris/stripped_log"))
        .texture("log", new Identifier("byg:block/skyris/log"));

    public static DefaultSettings SYTHIAN = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("sythian")
        .ingredientName("Sythian")
        .materials(
            Map.of(
                "main", new Identifier("byg:sythian_planks"),
                "slab", new Identifier("byg:sythian_slab"),
                "Log", new Identifier("byg:sythian_stem")
            )
        )
        .texture("planks", new Identifier("byg:block/sythian/planks"))
        .texture("main", new Identifier("byg:block/sythian/planks"))
        .texture("stripped_log", new Identifier("byg:block/sythian/stripped_log"))
        .texture("log", new Identifier("byg:block/sythian/log"));

    public static DefaultSettings WHITE_MANGROVE = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .material("white_mangrove")
        .ingredientName("White Mangrove")
        .materials(
            Map.of(
                "main", new Identifier("byg:white_mangrove_planks"),
                "slab", new Identifier("byg:white_mangrove_slab"),
                "log", new Identifier("byg:white_mangrove_log")
            )
        )
        .texture("planks", new Identifier("byg:block/white_mangrove/planks"))
        .texture("main", new Identifier("byg:block/white_mangrove/planks"))
        .texture("stripped_log", new Identifier("byg:block/white_mangrove/stripped_log"))
        .texture("log", new Identifier("byg:block/white_mangrove/log"));

    public static DefaultSettings WILLOW = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("willow")
        .ingredientName("Willow")
        .materials(
            Map.of(
                "main", new Identifier("byg:willow_planks"),
                "slab", new Identifier("byg:willow_slab"),
                "log", new Identifier("byg:willow_log")
            )
        )
        .texture("planks", new Identifier("byg:block/willow/planks"))
        .texture("main", new Identifier("byg:block/willow/planks"))
        .texture("stripped_log", new Identifier("byg:block/willow/stripped_log"))
        .texture("log", new Identifier("byg:block/willow/log"));

    public static DefaultSettings WITCH_HAZEL = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("witch_hazel")
        .ingredientName("Witch Hazel")
        .materials(
            Map.of(
                "main", new Identifier("byg:witch_hazel_planks"),
                "slab", new Identifier("byg:witch_hazel_slab"),
                "log", new Identifier("byg:witch_hazel_log")
            )
        )
        .texture("planks", new Identifier("byg:block/witch_hazel/planks"))
        .texture("main", new Identifier("byg:block/witch_hazel/planks"))
        .texture("stripped_log", new Identifier("byg:block/witch_hazel/stripped_log"))
        .texture("log", new Identifier("byg:block/witch_hazel/log"));

    public static DefaultSettings ZELKOVA = new DefaultSettings(Blocks.OAK_PLANKS)
        .modId("byg")
        .wooden()
        .material("zelkova")
        .ingredientName("Zelkova")
        .materials(
            Map.of(
                "main", new Identifier("byg:zelkova_planks"),
                "slab", new Identifier("byg:zelkova_slab"),
                "log", new Identifier("byg:zelkova_log")
            )
        )
        .texture("planks", new Identifier("byg:block/zelkova/planks"))
        .texture("main", new Identifier("byg:block/zelkova/planks"))
        .texture("stripped_log", new Identifier("byg:block/zelkova/stripped_log"))
        .texture("log", new Identifier("byg:block/zelkova/log"));
}
