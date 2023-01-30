package com.chimericdream.minekea.mixin;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.IdentifierUpdateHelper;

import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.LinkedHashMap;
import java.util.Map;

@Mixin(Identifier.class)
public class IdentifierMixin {
    @ModifyVariable(method = "<init>([Ljava/lang/String;)V", at = @At(value = "HEAD", ordinal = 1))
    private static String[] updateIdentifiers(String[] id) {
        updateIdsV1V2(id);
        updateIdsV2V3(id);

        convertPannotiasParcelsIds(id);

        return id;
    }

    // Changes made in 2.2.0
    private static void updateIdsV1V2(String[] id) {
        if (!id[0].equals(ModInfo.MOD_ID)) {
            return;
        }

        IdentifierUpdateHelper.updateIdsV1V2(id);
    }

    // Changes made in 2.8.0
    private static void updateIdsV2V3(String[] id) {
        if (!id[0].equals(ModInfo.MOD_ID)) {
            return;
        }

        switch (id[1]) {
            case "building/basalt_bricks" -> id[1] = "building/general/basalt_bricks";
            case "building/cracked_basalt_bricks" -> id[1] = "building/general/cracked_basalt_bricks";
            case "building/chiseled_basalt_bricks" -> id[1] = "building/general/chiseled_basalt_bricks";
            case "building/warped_basalt_bricks" -> id[1] = "building/general/warped_basalt_bricks";
            case "building/mossy_basalt_bricks" -> id[1] = "building/general/mossy_basalt_bricks";
            case "building/crimson_basalt_bricks" -> id[1] = "building/general/crimson_basalt_bricks";
            case "building/cobbled_end_stone" -> id[1] = "building/general/cobbled_end_stone";
            case "building/warped_nether_bricks" -> id[1] = "building/general/warped_nether_bricks";

            case "building/basalt_brick_slab" -> id[1] = "slabs/basalt_brick_slab";
            case "building/cobbled_end_stone_slab" -> id[1] = "slabs/cobbled_end_stone_slab";
            case "building/cracked_basalt_brick_slab" -> id[1] = "slabs/cracked_basalt_brick_slab";
            case "building/crimson_basalt_brick_slab" -> id[1] = "slabs/crimson_basalt_brick_slab";
            case "building/end_stone_slab" -> id[1] = "slabs/end_stone_slab";
            case "building/mossy_basalt_brick_slab" -> id[1] = "slabs/mossy_basalt_brick_slab";
            case "building/warped_basalt_brick_slab" -> id[1] = "slabs/warped_basalt_brick_slab";
            case "building/warped_nether_brick_slab" -> id[1] = "slabs/warped_nether_brick_slab";

            case "building/basalt_brick_stairs" -> id[1] = "stairs/basalt_brick_stairs";
            case "building/cobbled_end_stone_stairs" -> id[1] = "stairs/cobbled_end_stone_stairs";
            case "building/cracked_basalt_brick_stairs" -> id[1] = "stairs/cracked_basalt_brick_stairs";
            case "building/crimson_basalt_brick_stairs" -> id[1] = "stairs/crimson_basalt_brick_stairs";
            case "building/end_stone_stairs" -> id[1] = "stairs/end_stone_stairs";
            case "building/mossy_basalt_brick_stairs" -> id[1] = "stairs/mossy_basalt_brick_stairs";
            case "building/warped_basalt_brick_stairs" -> id[1] = "stairs/warped_basalt_brick_stairs";
            case "building/warped_nether_brick_stairs" -> id[1] = "stairs/warped_nether_brick_stairs";

            case "fluids/flowing_honey" -> id[1] = "fluids/honey/flowing";
            case "fluids/flowing_milk" -> id[1] = "fluids/milk/flowing";
            case "fluids/honey_source" -> id[1] = "fluids/honey/source";
            case "fluids/milk_source" -> id[1] = "fluids/milk/source";

            case "decorations/fake_cake" -> id[1] = "decorations/misc/fake_cake";
            case "decorations/doom_lantern" -> id[1] = "decorations/lighting/doom_lantern";
            case "decorations/end_lantern" -> id[1] = "decorations/lighting/end_lantern";
            case "decorations/endless_rod" -> id[1] = "decorations/lighting/endless_rod";

            case "jars/glass_jar" -> id[1] = "containers/glass_jar";

            case "bookshelves/storage/storage_shelf_block_entity" -> id[1] = "entities/blocks/storage_bookshelf";
            case "crates/crate_block_entity" -> id[1] = "entities/blocks/containers/crate";
            case "displaycases/display_case_block_entity" -> id[1] = "entities/blocks/furniture/display_case";
            case "jars/glass_jar_block_entity" -> id[1] = "entities/blocks/containers/glass_jar";
            case "seats/seat_entity" -> id[1] = "entities/mounts/seat";
            case "shelves/shelf_block_entity" -> id[1] = "entities/blocks/furniture/shelf";

            case "building/cobbled_end_stone_wall" -> id[1] = "building/walls/cobbled_end_stone";

            case "crops/warped_wart_block" -> id[1] = "crops/warped_wart/block";

            case "wrench" -> id[1] = "tools/wrench";
            case "honey_bucket" -> id[1] = "containers/honey_bucket";
            case "milk_cauldron" -> id[1] = "containers/cauldrons/milk";
            case "honey_cauldron" -> id[1] = "containers/cauldrons/honey";
        }

        IdentifierUpdateHelper.updateIdsV2V3(id);
    }

    // Blocks moved over in 2.8.0
    private static void convertPannotiasParcelsIds(String[] id) {
        if (!id[0].equals("pannotiasparcels")) {
            return;
        }

        Map<String, String> replacements = new LinkedHashMap<>();

        replacements.put("^compressed_([a-zA-Z_-]+)_([0-9])x$", "building/compressed/$1/$2x");
        replacements.put("^bamboo_bundle$", "storage/compressed/bamboo");
        replacements.put("^cane_bundle$", "storage/compressed/sugar_cane");
        replacements.put("^stick_bundle$", "storage/compressed/stick");

        replacements.forEach((String match, String replace) -> {
            if (id[1].matches(match)) {
                id[0] = ModInfo.MOD_ID;
                id[1] = id[1].replaceAll(match, replace);
            }
        });
    }
}
