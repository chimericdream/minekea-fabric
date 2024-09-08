package com.chimericdream.minekea.block.containers;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.fluid.Fluids;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.event.GameEvent;

import static net.minecraft.block.cauldron.CauldronBehavior.createMap;
import static net.minecraft.block.cauldron.CauldronBehavior.emptyCauldron;
import static net.minecraft.block.cauldron.CauldronBehavior.fillCauldron;

public class HoneyCauldronBlock extends LeveledCauldronBlock {
    public static final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "containers/cauldrons/honey");
    public static CauldronBehavior.CauldronBehaviorMap BEHAVIORS = createMap("honey");

    public static final CauldronBehavior FILL_WITH_HONEY;
    public static final CauldronBehavior EMPTY_CAULDRON;
    public static final CauldronBehavior FILL_FROM_BOTTLE;

    static {
        FILL_WITH_HONEY = (state, world, pos, player, hand, stack) -> fillCauldron(
            world,
            pos,
            player,
            hand,
            stack,
            Fluids.HONEY_CAULDRON.getDefaultState().with(LEVEL, 3),
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
        FILL_FROM_BOTTLE = (state, world, pos, player, hand, stack) -> {
            if (!world.isClient) {
                Item item = stack.getItem();
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                player.incrementStat(Stats.USE_CAULDRON);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                world.setBlockState(pos, Fluids.HONEY_CAULDRON.getDefaultState());
                world.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.emitGameEvent((Entity) null, GameEvent.FLUID_PLACE, pos);
            }

            return ItemActionResult.success(world.isClient);
        };

        BEHAVIORS.map().put(Fluids.HONEY_BUCKET, FILL_WITH_HONEY);
        BEHAVIORS.map().put(Items.BUCKET, EMPTY_CAULDRON);
        BEHAVIORS.map().put(Items.GLASS_BOTTLE, (state, world, pos, player, hand, stack) -> {
            if (!world.isClient) {
                Item item = stack.getItem();
                player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, Items.HONEY_BOTTLE.getDefaultStack()));
                player.incrementStat(Stats.USE_CAULDRON);
                player.incrementStat(Stats.USED.getOrCreateStat(item));
                LeveledCauldronBlock.decrementFluidLevel(state, world, pos);
                world.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BOTTLE_FILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
                world.emitGameEvent((Entity) null, GameEvent.FLUID_PICKUP, pos);
            }

            return ItemActionResult.success(world.isClient);
        });
        BEHAVIORS.map().put(Items.HONEY_BOTTLE, (state, world, pos, player, hand, stack) -> {
            if ((Integer) state.get(LeveledCauldronBlock.LEVEL) != 3) {
                if (!world.isClient) {
                    player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
                    player.incrementStat(Stats.USE_CAULDRON);
                    player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
                    world.setBlockState(pos, (BlockState) state.cycle(LeveledCauldronBlock.LEVEL));
                    world.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    world.emitGameEvent((Entity) null, GameEvent.FLUID_PLACE, pos);
                }

                return ItemActionResult.success(world.isClient);
            } else {
                return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }
        });

        CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR.map().put(Fluids.HONEY_BUCKET, FILL_WITH_HONEY);
        CauldronBehavior.EMPTY_CAULDRON_BEHAVIOR.map().put(Items.HONEY_BOTTLE, FILL_FROM_BOTTLE);
    }

    public HoneyCauldronBlock(Settings settings) {
        super(Biome.Precipitation.NONE, BEHAVIORS, settings);
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
}
