package com.chimericdream.minekea.mixin;

import com.chimericdream.minekea.MinekeaMod;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BlockEntity.class)
public class BlockEntityMixin {
    @Redirect(
        method = "createFromNbt",
        at = @At(value = "INVOKE", target = "net/minecraft/util/Identifier.tryParse(Ljava/lang/String;)Lnet/minecraft/util/Identifier;")
    )
    private static Identifier replaceOldIds(String id) {
        String newId = convertOldMinekeaIds(id);

        if (!id.equals(newId)) {
            MinekeaMod.LOGGER.info(String.format("Converting BlockEntity '%s' to '%s'", id, newId));
        }

        return Identifier.tryParse(newId);
    }

    private static String convertOldMinekeaIds(String id) {
//        if (id.matches("^minekea:bookshelves/storage/[_a-z]+storage_shelf_block_entity$")) {
//            return "minekea:bookshelves/storage/storage_shelf_block_entity";
//        }
//
//        if (id.matches("^minekea:crates/[_a-z]+crate_block_entity$")) {
//            return "minekea:crates/crate_block_entity";
//        }
//
//        if (id.matches("^minekea:displaycases/[_a-z]+case_block_entity$")) {
//            return "minekea:displaycases/display_case_block_entity";
//        }

        return id;
    }
}
