package com.chimericdream.minekea.item.containers;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.EndermiteEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.SilverfishEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.entity.mob.VexEntity;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class GlassJarItem extends BlockItem {
    public GlassJarItem(Block block, Settings settings) {
        super(block, settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity player, LivingEntity entity, Hand hand) {
        if (player.getWorld().isClient()) {
            return ActionResult.PASS;
        }

        if (entity instanceof MobEntity mob && canCaptureMob(mob) && !hasStoredMob(stack)) {
            mob.stopRiding();
            mob.removeAllPassengers();
            if (mob.hasCustomName()) {
                stack.set(DataComponentTypes.CUSTOM_NAME, mob.getCustomName());
                NbtCompound hasCustomName = new NbtCompound();
                hasCustomName.putBoolean("has_custom_name", true);
                stack.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(hasCustomName));
            } else {
                stack.set(DataComponentTypes.CUSTOM_NAME, getDefaultName(mob));
            }

            NbtCompound nbt = new NbtCompound();
            if (!saveMob(mob, nbt)) {
                return ActionResult.FAIL;
            }

            mob.discard();

            ItemStack newStack = new ItemStack(this);
            newStack.setCount(1);
            newStack.set(DataComponentTypes.ENTITY_DATA, NbtComponent.of(nbt));

            player.giveItemStack(newStack);
            if (!player.isCreative()) {
                stack.decrement(1);
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ItemStack stack = context.getStack();

        if (context.getPlayer() != null && context.getPlayer().isSneaking() && hasStoredMob(stack)) {
            World world = context.getWorld();
            if (world.isClient()) {
                return ActionResult.SUCCESS;
            }

            BlockPos blockPos = context.getBlockPos();
            Direction direction = context.getSide();
            BlockState blockState = world.getBlockState(blockPos);

            BlockPos releasePos;
            if (blockState.getCollisionShape(world, blockPos).isEmpty()) {
                releasePos = blockPos;
            } else {
                releasePos = blockPos.offset(direction);
            }

            this.releaseMob(context.getPlayer(), world, stack, blockPos, releasePos);

            return ActionResult.CONSUME;
        }

        return this.place(new ItemPlacementContext(context));
    }

    public void releaseMob(@Nullable PlayerEntity player, World world, ItemStack itemStack, BlockPos blockPos, BlockPos releasePos) {
        NbtCompound nbt = itemStack.getOrDefault(DataComponentTypes.ENTITY_DATA, NbtComponent.DEFAULT).copyNbt();

        if (releaseMobAt(nbt, world, releasePos, itemStack)) {
            world.emitGameEvent(player, GameEvent.ENTITY_PLACE, blockPos);

            itemStack.decrement(1);

            if (player != null) {
                ItemStack newStack = new ItemStack(this);
                newStack.setCount(1);
                player.giveItemStack(newStack);
            }
        }
    }

    private boolean releaseMobAt(NbtCompound nbt, World world, BlockPos pos, ItemStack stack) {
        if (!world.isClient() && !nbt.isEmpty()) {
            nbt.remove("UUID");

            return EntityType.getEntityFromNbt(nbt, world).map((entity) -> {
                moveEntityTo(entity, world, pos);
                entity.setVelocity(Vec3d.ZERO);

                world.spawnEntity(entity);

                if (hasCustomName(stack) && entity instanceof LivingEntity) {
                    entity.setCustomName(stack.get(DataComponentTypes.CUSTOM_NAME));
                }

                return entity;
            }).isPresent();
        }

        return false;
    }

    private Text getDefaultName(MobEntity mob) {
        return Text.of(String.format("%s in a jar", mob.getType().getName()));
    }

    private boolean hasCustomName(ItemStack stack) {
        NbtCompound nbt = stack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT).copyNbt();

        return nbt.getBoolean("has_custom_name");
    }

    private boolean saveMob(MobEntity entity, NbtCompound nbt) {
        return entity.saveNbt(nbt);
    }

    public boolean canCaptureMob(MobEntity entity) {
        if (!entity.isAlive()) {
            return false;
        }

        if (entity instanceof SlimeEntity) {
            return ((SlimeEntity) entity).isSmall();
        }

        return entity instanceof VexEntity || entity instanceof AllayEntity || entity instanceof SilverfishEntity || entity instanceof EndermiteEntity || entity instanceof BatEntity;
    }

    public boolean hasStoredMob(ItemStack stack) {
        return !stack.getOrDefault(DataComponentTypes.ENTITY_DATA, NbtComponent.DEFAULT).isEmpty();
    }

    private void moveEntityTo(Entity entity, World world, BlockPos pos) {
        entity.setPos((double) pos.getX() + 0.5D, pos.getY() + 1, (double) pos.getZ() + 0.5D);

        entity.updatePositionAndAngles(
            (double) pos.getX() + 0.5D,
            (double) pos.getY() + getYOffset(world, pos, entity.getBoundingBox()),
            (double) pos.getZ() + 0.5D,
            MathHelper.wrapDegrees(world.random.nextFloat() * 360.0F),
            0.0F
        );

        if (entity instanceof MobEntity mob) {
            mob.setHeadYaw(mob.getYaw());
            mob.setBodyYaw(mob.getYaw());
            mob.playAmbientSound();
        }
    }

    private double getYOffset(WorldAccess world, BlockPos pos, Box box) {
        Box box2 = new Box(pos);
        Iterable<VoxelShape> iterable = world.getCollisions(null, box2);

        return 1.0D + VoxelShapes.calculateMaxOffset(Direction.Axis.Y, box, iterable, -1.0D);
    }
}
