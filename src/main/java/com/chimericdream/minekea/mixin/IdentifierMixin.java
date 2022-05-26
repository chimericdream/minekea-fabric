package com.chimericdream.minekea.mixin;

import com.chimericdream.minekea.ModInfo;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(Identifier.class)
public class IdentifierMixin {
    @ModifyVariable(method = "<init>([Ljava/lang/String;)V", at = @At(value = "HEAD", ordinal = 1))
    private static String[] updateIdentifiers(String[] id) {
        updateIdsV1V2(id);
        updateIdsV2V3(id);

        return id;
    }

    private static void updateIdsV1V2(String[] id) {
        if (!id[0].equals(ModInfo.MOD_ID)) {
            return;
        }

        if (id[1].matches("^bookshelves/storage/[_a-z]+storage_shelf_block_entity$")) {
            id[1] = "bookshelves/storage/storage_shelf_block_entity";
        } else if (id[1].matches("^crates/[_a-z]+crate_block_entity$")) {
            id[1] = "crates/crate_block_entity";
        } else if (id[1].matches("^displaycases/[_a-z]+case_block_entity$")) {
            id[1] = "displaycases/display_case_block_entity";
        }
    }

    private static void updateIdsV2V3(String[] id) {
        if (!id[0].equals(ModInfo.MOD_ID)) {
            return;
        }

        switch (id[1]) {
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
        }
    }
}
