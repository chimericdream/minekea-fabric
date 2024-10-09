package com.chimericdream.minekea.entities.blocks.furniture;

import com.chimericdream.lib.inventories.ImplementedInventory;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.displaycases.DisplayCases;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static com.chimericdream.minekea.block.furniture.displaycases.GenericDisplayCase.ROTATION;

public class DisplayCaseBlockEntity extends BlockEntity implements ImplementedInventory, SidedInventory {
    public static final Identifier ENTITY_ID = Identifier.of(ModInfo.MOD_ID, "entities/blocks/furniture/display_case");

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public DisplayCaseBlockEntity(BlockPos pos, BlockState state) {
        this(DisplayCases.DISPLAY_CASE_BLOCK_ENTITY, pos, state);
    }

    public DisplayCaseBlockEntity(BlockEntityType<? extends DisplayCaseBlockEntity> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public int getRotation() {
        return this.getCachedState().get(ROTATION);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        items.clear();
        super.readNbt(nbt, registryLookup);
        Inventories.readNbt(nbt, items, registryLookup);
        if (items.get(0).isOf(Blocks.BARRIER.asItem())) {
            items.set(0, ItemStack.EMPTY);
        }
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.writeNbt(nbt, items, registryLookup);
        super.writeNbt(nbt, registryLookup);
    }

    @Override
    public void markDirty() {
        if (this.world == null) {
            return;
        }

        markDirtyInWorld(this.world, this.pos, this.getCachedState());
    }

    protected void markDirtyInWorld(World world, BlockPos pos, BlockState state) {
        world.markDirty(pos);

        if (!world.isClient()) {
            ((ServerWorld) world).getChunkManager().markForUpdate(pos); // Mark changes to be synced to the client.
        }
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

    @Override
    public int[] getAvailableSlots(Direction var1) {
        return new int[]{};
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction direction) {
        return false;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction direction) {
        return false;
    }

    public void playRemoveItemSound() {
        playSound(SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM);
    }

    public void playRotateItemSound() {
        playSound(SoundEvents.ENTITY_ITEM_FRAME_ROTATE_ITEM);
    }

    public void playAddItemSound() {
        playSound(SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM);
    }

    public void playSound(SoundEvent soundEvent) {
        if (this.world == null) {
            return;
        }

        this.world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), soundEvent, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }
}
