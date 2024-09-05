//package com.chimericdream.minekea.mixin;
//
//import com.chimericdream.minekea.fluid.Fluids;
//import net.minecraft.advancement.criterion.Criteria;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.FluidFillable;
//import net.minecraft.block.Material;
//import net.minecraft.entity.player.PlayerEntity;
//import net.minecraft.item.*;
//import net.minecraft.particle.ParticleTypes;
//import net.minecraft.server.network.ServerPlayerEntity;
//import net.minecraft.sound.SoundCategory;
//import net.minecraft.sound.SoundEvents;
//import net.minecraft.util.Hand;
//import net.minecraft.util.TypedActionResult;
//import net.minecraft.util.hit.BlockHitResult;
//import net.minecraft.util.hit.HitResult;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.world.RaycastContext;
//import net.minecraft.world.World;
//import net.minecraft.world.WorldAccess;
//import net.minecraft.world.event.GameEvent;
//import org.spongepowered.asm.mixin.Mixin;
//
//import javax.annotation.Nullable;
//
//import static net.minecraft.item.BucketItem.getEmptiedStack;
//
//@Mixin(MilkBucketItem.class)
//public class MilkBucketItemMixin extends Item implements FluidModificationItem {
//    public MilkBucketItemMixin(Settings settings) {
//        super(settings);
//    }
//
//    @Override
//    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
//        ItemStack stack = player.getStackInHand(hand);
//        BlockHitResult hit = raycast(world, player, RaycastContext.FluidHandling.NONE);
//
//        if (hit.getType() == HitResult.Type.MISS || player.isSneaking()) {
//            return ItemUsage.consumeHeldItem(world, player, hand);
//        } else if (hit.getType() != HitResult.Type.BLOCK) {
//            return TypedActionResult.pass(stack);
//        } else {
//            BlockPos blockPos = hit.getBlockPos();
//            Direction direction = hit.getSide();
//            BlockPos offset = blockPos.offset(direction);
//
//            if (world.canPlayerModifyAt(player, blockPos) && player.canPlaceOn(offset, direction, stack)) {
//                if (this.placeFluid(player, world, offset, hit)) {
//                    this.onEmptied(player, world, stack, offset);
//
//                    if (player instanceof ServerPlayerEntity) {
//                        Criteria.PLACED_BLOCK.trigger((ServerPlayerEntity) player, offset, stack);
//                    }
//
//                    return TypedActionResult.success(getEmptiedStack(stack, player), world.isClient());
//                } else {
//                    return TypedActionResult.fail(stack);
//                }
//            } else {
//                return TypedActionResult.fail(stack);
//            }
//        }
//    }
//
//    public boolean placeFluid(@Nullable PlayerEntity player, World world, BlockPos pos, @Nullable BlockHitResult hit) {
//        BlockState state = world.getBlockState(pos);
//        Block block = state.getBlock();
//        Material material = state.getMaterial();
//
//        boolean canBucketPlace = state.canBucketPlace(com.chimericdream.minekea.fluid.Fluids.MILK);
//        boolean preventBucketPlace = state.isAir()
//            || canBucketPlace
//            || block instanceof FluidFillable && ((FluidFillable) block).canFillWithFluid(world, pos, state, com.chimericdream.minekea.fluid.Fluids.MILK);
//
//        if (!preventBucketPlace) {
//            return hit != null && this.placeFluid(player, world, hit.getBlockPos().offset(hit.getSide()), (BlockHitResult) null);
//        } else if (world.getDimension().ultrawarm()) {
//            int i = pos.getX();
//            int j = pos.getY();
//            int k = pos.getZ();
//
//            world.playSound(player, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (world.random.nextFloat() - world.random.nextFloat()) * 0.8F);
//
//            for (int l = 0; l < 8; ++l) {
//                world.addParticle(ParticleTypes.LARGE_SMOKE, (double) i + Math.random(), (double) j + Math.random(), (double) k + Math.random(), 0.0, 0.0, 0.0);
//            }
//
//            return true;
//        } else if (block instanceof FluidFillable) {
//            ((FluidFillable) block).tryFillWithFluid(world, pos, state, Fluids.MILK.getStill(false));
//
//            this.playEmptyingSound(player, world, pos);
//
//            return true;
//        } else {
//            if (!world.isClient && canBucketPlace && !material.isLiquid()) {
//                world.breakBlock(pos, true);
//            }
//
//            if (!world.setBlockState(pos, Fluids.MILK.getDefaultState().getBlockState(), 11) && !state.getFluidState().isStill()) {
//                return false;
//            } else {
//                this.playEmptyingSound(player, world, pos);
//
//                return true;
//            }
//        }
//    }
//
//    protected void playEmptyingSound(@Nullable PlayerEntity player, WorldAccess world, BlockPos pos) {
//        world.playSound(player, pos, SoundEvents.ITEM_BUCKET_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
//        world.emitGameEvent(player, GameEvent.FLUID_PLACE, pos);
//    }
//}
