package com.chimericdream.shelfstorage.mixin;

import com.chimericdream.shelfstorage.block.bookshelves.Bookshelves;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EnchantingTableBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Arrays;

@Mixin(EnchantingTableBlock.class)
public class EnchantingTableBlockMixin {
    @Redirect(
        method = "canAccessBookshelf",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z")
    )
    private static boolean isBookshelf(BlockState blockState, Block block) {
        return blockState.getBlock().equals(Blocks.BOOKSHELF)
            || Arrays.stream(Bookshelves.getShelvesForEnchanting()).anyMatch(shelf -> blockState.getBlock().equals(shelf));
    }
}
