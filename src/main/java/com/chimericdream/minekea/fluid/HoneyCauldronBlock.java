package com.chimericdream.minekea.fluid;

import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

import static net.minecraft.block.cauldron.CauldronBehavior.*;

public class HoneyCauldronBlock extends AbstractCauldronBlock {
    public static Map<Item, CauldronBehavior> BEHAVIORS = createMap();

    public static final CauldronBehavior FILL_WITH_HONEY;
    public static final CauldronBehavior EMPTY_CAULDRON;

    static {
        FILL_WITH_HONEY = (state, world, pos, player, hand, stack) -> fillCauldron(
            world,
            pos,
            player,
            hand,
            stack,
            Fluids.HONEY_CAULDRON.getDefaultState(),
            SoundEvents.ITEM_BUCKET_EMPTY_LAVA
        );
        EMPTY_CAULDRON = (state, world, pos, player, hand, stack) -> emptyCauldron(
            state,
            world,
            pos,
            player,
            hand,
            stack,
            new ItemStack(Fluids.HONEY_BUCKET),
            statex -> true,
            SoundEvents.ITEM_BUCKET_FILL_LAVA
        );

        BEHAVIORS.put(Fluids.HONEY_BUCKET, FILL_WITH_HONEY);
        BEHAVIORS.put(Items.BUCKET, EMPTY_CAULDRON);

        CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR.put(Fluids.HONEY_BUCKET, FILL_WITH_HONEY);
    }

    public HoneyCauldronBlock(Settings settings) {
        super(settings, BEHAVIORS);
    }

    protected double getFluidHeight(BlockState state) {
        return 0.9375;
    }

    public boolean isFull(BlockState state) {
        return true;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (!world.isClient && isEntityTouchingFluid(state, pos, entity) && entity.canModifyAt(world, pos)) {
            if (entity.isOnFire()) {
                entity.extinguish();
            }

            if (entity instanceof LivingEntity) {
                ((LivingEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 15));
            }
        }
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return 3;
    }
}
