package com.chimericdream.minekea.mixin;

import com.chimericdream.minekea.tag.CommonBlockTags;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.EnchantingTableBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(EnchantingTableBlock.class)
public class EnchantingTableBlockMixin {
    @Redirect(
        method = "canAccessBookshelf",
        at = @At(value = "INVOKE", target = "Lnet/minecraft/block/BlockState;isOf(Lnet/minecraft/block/Block;)Z")
    )
    private static boolean isBookshelf(BlockState state, Block block) {
        return block == Blocks.BOOKSHELF
            ? state.isIn(CommonBlockTags.BOOKSHELVES)
            : state.isOf(block);
    }
}
