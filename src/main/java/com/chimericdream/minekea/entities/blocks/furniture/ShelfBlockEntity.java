package com.chimericdream.minekea.entities.blocks.furniture;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.shelves.Shelves;
import com.chimericdream.minekea.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
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

public class ShelfBlockEntity extends BlockEntity implements ImplementedInventory, SidedInventory {
    public static final Identifier ENTITY_ID = new Identifier(ModInfo.MOD_ID, "entities/blocks/furniture/shelf");

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(4, ItemStack.EMPTY);

    public ShelfBlockEntity(BlockPos pos, BlockState state) {
        this(Shelves.SHELF_BLOCK_ENTITY, pos, state);
    }

    public ShelfBlockEntity(BlockEntityType<? extends ShelfBlockEntity> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
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
        ItemStack ret = ImplementedInventory.super.tryInsert(slot, stack);

        if (!ItemStack.areEqual(ret, stack)) {
            this.playAddItemSound();
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

    public void playAddItemSound() {
        playSound(SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM);
    }

    public void playSound(SoundEvent soundEvent) {
        this.world.playSound((PlayerEntity) null, pos.getX(), pos.getY(), pos.getZ(), soundEvent, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }
}
