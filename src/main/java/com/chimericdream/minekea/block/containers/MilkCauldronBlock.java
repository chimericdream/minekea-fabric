package com.chimericdream.minekea.block.containers;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.fluid.Fluids;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import static net.minecraft.block.cauldron.CauldronBehavior.createMap;
import static net.minecraft.block.cauldron.CauldronBehavior.emptyCauldron;
import static net.minecraft.block.cauldron.CauldronBehavior.fillCauldron;

public class MilkCauldronBlock extends AbstractCauldronBlock {
    public static final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "containers/cauldrons/milk");
    public static CauldronBehavior.CauldronBehaviorMap BEHAVIORS = createMap("milk");
    public static final MapCodec<MilkCauldronBlock> CODEC = createCodec(MilkCauldronBlock::new);

    public static final CauldronBehavior FILL_WITH_MILK;
    public static final CauldronBehavior EMPTY_CAULDRON;

    static {
        FILL_WITH_MILK = (state, world, pos, player, hand, stack) -> fillCauldron(
            world,
            pos,
            player,
            hand,
            stack,
            Fluids.MILK_CAULDRON.getDefaultState(),
            SoundEvents.ITEM_BUCKET_EMPTY
        );
        EMPTY_CAULDRON = (state, world, pos, player, hand, stack) -> emptyCauldron(
            state,
            world,
            pos,
            player,
            hand,
            stack,
            new ItemStack(Items.MILK_BUCKET),
            statex -> true,
            SoundEvents.ITEM_BUCKET_FILL
        );

        BEHAVIORS.map().put(Items.MILK_BUCKET, FILL_WITH_MILK);
        BEHAVIORS.map().put(Items.BUCKET, EMPTY_CAULDRON);

        CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR.map().put(Items.MILK_BUCKET, FILL_WITH_MILK);
    }

    public MilkCauldronBlock(AbstractBlock.Settings settings) {
        super(settings, BEHAVIORS);
    }

    @Override
    protected MapCodec<MilkCauldronBlock> getCodec() {
        return CODEC;
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
                ((LivingEntity) entity).clearStatusEffects();
            }
        }
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return 3;
    }
}
