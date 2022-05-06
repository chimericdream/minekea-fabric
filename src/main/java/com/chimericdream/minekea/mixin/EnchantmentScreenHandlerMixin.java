package com.chimericdream.minekea.mixin;

import com.chimericdream.minekea.tag.CommonBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.screen.EnchantmentScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantmentScreenHandler.class)
public class EnchantmentScreenHandlerMixin {
    @Redirect(
        method = "method_17411",
        at = @At(value = "INVOKE", target = "net/minecraft/block/BlockState.isOf (Lnet/minecraft/block/Block;)Z")
    )
    private boolean isBookshelf(BlockState state, Block block) {
        return block == Blocks.BOOKSHELF
            ? state.isIn(CommonBlockTags.BOOKSHELVES)
            : state.isOf(block);
    }
}