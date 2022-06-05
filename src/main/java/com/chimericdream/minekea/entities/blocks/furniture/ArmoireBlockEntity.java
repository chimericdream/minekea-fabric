package com.chimericdream.minekea.entities.blocks.furniture;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.armoires.Armoires;
import com.chimericdream.minekea.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ArmoireBlockEntity extends BlockEntity implements ImplementedInventory, SidedInventory {
    public static final Identifier ENTITY_ID = new Identifier(ModInfo.MOD_ID, "entities/blocks/furniture/armoire");

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(16, ItemStack.EMPTY);

    public ArmoireBlockEntity(BlockPos pos, BlockState state) {
        this(Armoires.ARMOIRE_BLOCK_ENTITY, pos, state);
    }

    public ArmoireBlockEntity(BlockEntityType<? extends ArmoireBlockEntity> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public boolean hasItem(int slot) {
        return !items.get(slot).isEmpty();
    }

    public boolean canAccept(int slot, ItemStack item) {
        if (hasItem(slot) || !(item.getItem() instanceof ArmorItem armorItem)) {
            return false;
        }

        int slotType = slot % 4; // 0, 1, 2, 3 -> chestplate, leggings, helmet, boots

        return switch (slotType) {
            case 0 -> armorItem.getSlotType() == EquipmentSlot.CHEST;
            case 1 -> armorItem.getSlotType() == EquipmentSlot.LEGS;
            case 2 -> armorItem.getSlotType() == EquipmentSlot.HEAD;
            case 3 -> armorItem.getSlotType() == EquipmentSlot.FEET;
            default -> false;
        };
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    public NbtCompound getNbt() {
        NbtCompound nbt = new NbtCompound();

        this.writeNbt(nbt);

        return nbt;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        items.clear();
        Inventories.readNbt(nbt, items);
        markDirty();
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        Inventories.writeNbt(nbt, items);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    @Override
    public int[] getAvailableSlots(Direction var1) {
        int[] result = new int[getItems().size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction direction) {
        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction direction) {
        return true;
    }

    @Override
    public ItemStack tryInsert(int slot, ItemStack stack) {
        if (!canAccept(slot, stack)) {
            return stack;
        }

        ItemStack ret = stack.copy();
        ItemStack toInsert = stack.copy();
        toInsert.setCount(1);

        setStack(slot, toInsert);

        ret.decrement(1);

        if (!ItemStack.areEqual(ret, stack)) {
            this.playAddItemSound(slot);
        }

        return ret;
    }

    @Override
    public void markDirty() {
        if (this.world != null) {
            markDirtyInWorld(this.world, this.pos, this.getCachedState());
        }
    }

    protected void markDirtyInWorld(World world, BlockPos pos, BlockState state) {
        world.markDirty(pos);

        if (!world.isClient()) {
            ((ServerWorld) world).getChunkManager().markForUpdate(pos); // Mark changes to be synced to the client.
        }
    }

    public void playAddItemSound(int slot) {
        switch (slot) {
            case 0, 1 -> playSound(SoundEvents.ITEM_ARMOR_EQUIP_GENERIC);
            default -> playSound(SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM);
        }
    }

    public void playSound(SoundEvent soundEvent) {
        this.world.playSound((PlayerEntity) null, pos.getX(), pos.getY(), pos.getZ(), soundEvent, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }
}
