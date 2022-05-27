package com.chimericdream.minekea.mixin;

import com.chimericdream.minekea.ModInfo;
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

        return id;
    }

    // Changes made in 2.2.0
    private static void updateIdsV1V2(String[] id) {
        if (!id[0].equals(ModInfo.MOD_ID)) {
            return;
        }

        if (id[1].matches("^bookshelves/storage/[_a-z]+storage_shelf_block_entity$")) {
            id[1] = "bookshelves/storage/storage_shelf_block_entity";
        }

        if (id[1].matches("^crates/[_a-z]+crate_block_entity$")) {
            id[1] = "crates/crate_block_entity";
        }

        if (id[1].matches("^displaycases/[_a-z]+case_block_entity$")) {
            id[1] = "displaycases/display_case_block_entity";
        }
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
        }

        Map<String, String> replacements = new LinkedHashMap<>();

        replacements.put("^beams/([^/]+/)?([./_a-z]+)_beam$", "$1building/beams/$2");
        replacements.put("^slabs/([^/]+/)?([./_a-z]+)_slab$", "$1building/slabs/$2");
        replacements.put("^stairs/([^/]+/)?([./_a-z]+)_stairs$", "$1building/stairs/$2");
        replacements.put("^covers/([^/]+/)?([./_a-z]+)_cover$", "$1building/covers/$2");
        replacements.put("^building/stairs/([^/]+/)?([./_a-z]+)_vertical_stairs$", "$1building/stairs/vertical/$2");
        replacements.put("^storage/compressed_([./_a-z]+)$", "storage/compressed/$1");
        replacements.put("^storage/dyes/compressed_([./_a-z]+)$", "storage/dyes/$1");
        replacements.put("^crates/([^/]+/)?([./_a-z]+)_crate$", "$1containers/crates/$2");
        replacements.put("^barrels/([^/]+/)?([./_a-z]+)_barrel$", "$1containers/barrels/$2");
        replacements.put("^displaycases/([^/]+/)?stripped_([./_a-z]+)_display_case$", "$1furniture/display_cases/stripped/$2");
        replacements.put("^displaycases/([^/]+/)?([./_a-z]+)_display_case$", "$1furniture/display_cases/$2");
        replacements.put("^seating/stools/([^/]+/)?([./_a-z]+)_stool", "$1furniture/seating/stools/$2");
        replacements.put("^seating/chairs/([^/]+/)?([./_a-z]+)_chair", "$1furniture/seating/chairs/$2");
        replacements.put("^tables/([^/]+/)?([./_a-z]+)_table", "$1furniture/tables/$2");
        replacements.put("^shelves/([^/]+/)?([./_a-z]+)_supported_shelf$", "$1furniture/shelves/supported/$2");
        replacements.put("^shelves/([^/]+/)?([./_a-z]+)_floating_shelf$", "$1furniture/shelves/floating/$2");

        replacements.forEach((String match, String replace) -> {
            if (id[1].matches(match)) {
                id[1] = id[1].replaceAll(match, replace);
            }
        });
    }
}
