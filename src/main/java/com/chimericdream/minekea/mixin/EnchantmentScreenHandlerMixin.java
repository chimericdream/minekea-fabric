package com.chimericdream.minekea.mixin;

import com.chimericdream.minekea.block.bookshelves.Bookshelves;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.screen.EnchantmentScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Arrays;

@Mixin(EnchantmentScreenHandler.class)
public class EnchantmentScreenHandlerMixin {
    @Redirect(
        method = "method_17411",
        at = @At(value = "INVOKE", target = "net/minecraft/block/BlockState.isOf (Lnet/minecraft/block/Block;)Z")
    )
    private boolean isBookshelf(BlockState blockState, Block block) {
        return blockState.getBlock().equals(Blocks.BOOKSHELF)
            || Arrays.stream(Bookshelves.getShelvesForEnchanting()).anyMatch(shelf -> blockState.getBlock().equals(shelf));
    }
}