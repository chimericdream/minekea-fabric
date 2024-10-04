package com.chimericdream.minekea.entities.blocks.containers;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.tag.MinekeaItemTags;
import com.chimericdream.minekea.util.ImplementedInventory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GlassJarBlockEntity extends BlockEntity implements ImplementedInventory {
    public static final Identifier ENTITY_ID = Identifier.of(ModInfo.MOD_ID, "entities/blocks/containers/glass_jar");
    public static final int MAX_BUCKETS = 8;
    public static final double BOTTLE_SIZE = 0.33;

    // Since the `items` stores a single stack, the actual total is one higher than this
    public static final int MAX_ITEM_STACKS = 7;

    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);
    private int fullItemStacks = 0;

    private Fluid storedFluid = Fluids.EMPTY;
    private double fluidAmountInBuckets = 0.0;

    private NbtCompound storedMobData = new NbtCompound();

    public static final String ITEM_AMT_KEY = "FullItemStacks";
    public static final String FLUID_KEY = "StoredFluid";
    public static final String FLUID_AMT_KEY = "StoredFluidAmount";
    public static final String MOB_DATA_KEY = "StoredMobData";

    public GlassJarBlockEntity(BlockPos pos, BlockState state) {
        this(ContainerBlocks.GLASS_JAR_BLOCK_ENTITY, pos, state);
    }

    public GlassJarBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public NbtCompound getStoredMobData() {
        return storedMobData;
    }

    public Fluid getStoredFluid() {
        return storedFluid;
    }

    public int getStoredStacks() {
        return fullItemStacks;
    }

    public double getStoredBuckets() {
        return fluidAmountInBuckets;
    }

    public boolean canAcceptFluid(Fluid fluid) {
        return canAcceptFluid(fluid, 1.0);
    }

    public boolean canAcceptFluid(Fluid fluid, double amount) {
        if (this.isEmpty()) {
            return true;
        }

        // We can't store multiple things at the same time
        if (this.hasItem() || this.hasMob()) {
            return false;
        }

        if (storedFluid.matchesType(Fluids.EMPTY)) {
            return true;
        }

        // If this is the same fluid we're already storing, AND the jar isn't full yet
        return fluid.matchesType(storedFluid) && (fluidAmountInBuckets + amount) <= MAX_BUCKETS;
    }

    public boolean tryInsert(Fluid fluid) {
        return tryInsert(fluid, 1.0);
    }

    public boolean tryInsert(Fluid fluid, double amount) {
        if (!canAcceptFluid(fluid, amount)) {
            return false;
        }

        storedFluid = fluid;
        fluidAmountInBuckets += amount;

        if (fluidAmountInBuckets > (MAX_BUCKETS - BOTTLE_SIZE)) {
            fluidAmountInBuckets = MAX_BUCKETS;
        }

        return true;
    }

    @Nullable
    public ItemStack getBottle() {
        if (!this.hasFluid()) {
            return null;
        }

        if (!this.hasFluid()) {
            return Items.GLASS_BOTTLE.getDefaultStack();
        }

        ItemStack retStack = null;

        if (this.getStoredFluid() == Fluids.WATER) {
            fluidAmountInBuckets -= BOTTLE_SIZE;
            retStack = Items.POTION.getDefaultStack();
        }

        if (this.getStoredFluid() == com.chimericdream.minekea.fluid.Fluids.HONEY) {
            fluidAmountInBuckets -= BOTTLE_SIZE;
            retStack = Items.HONEY_BOTTLE.getDefaultStack();
        }

        if (fluidAmountInBuckets < BOTTLE_SIZE) {
            storedFluid = Fluids.EMPTY;
            fluidAmountInBuckets = 0;
        }

        return retStack;
    }

    public Fluid getBucket() {
        if (!this.hasFluid() || fluidAmountInBuckets < 1) {
            return Fluids.EMPTY;
        }

        Fluid fluid = storedFluid;
        fluidAmountInBuckets -= 1;

        if (fluidAmountInBuckets <= 0) {
            storedFluid = Fluids.EMPTY;
        }

        return fluid;
    }

    public boolean canAcceptItem(ItemStack item) {
        // We can't store multiple things at the same time
        if (this.hasFluid() || this.hasMob()) {
            return false;
        }

        if (!item.isIn(MinekeaItemTags.GLASS_JAR_STORABLE)) {
            return false;
        }

        if (this.isEmpty()) {
            return true;
        }

        ItemStack storedItem = items.get(0);

        // If this is the same item we're already storing, AND the jar isn't full yet
        return item.isOf(storedItem.getItem()) && (fullItemStacks < MAX_ITEM_STACKS || storedItem.getCount() < storedItem.getMaxCount());
    }

    @Override
    public ItemStack tryInsert(ItemStack stack) {
        if (this.hasFluid() || this.hasMob()) {
            return stack;
        }

        ItemStack storedItem = this.items.get(0);

        // The jar was empty. Now it won't be
        if (storedItem.isEmpty()) {
            this.items.set(0, stack);

            return ItemStack.EMPTY;
        }

        // We're full. No dice
        if (this.fullItemStacks == MAX_ITEM_STACKS && storedItem.getCount() == storedItem.getMaxCount()) {
            return stack;
        }

        // You can't insert different things
        if (!stack.isOf(storedItem.getItem())) {
            return stack;
        }

        int itemCount = stack.getCount();
        int storedItemCount = storedItem.getCount();

        // The stack coming in fits completely in the main inventory slot
        if (itemCount + storedItemCount <= storedItem.getMaxCount()) {
            storedItem.setCount(itemCount + storedItemCount);

            this.items.set(0, storedItem);
            return ItemStack.EMPTY;
        }

        int remainder = (itemCount + storedItemCount) - storedItem.getMaxCount();

        // The stack coming in will fill up the main slot, plus a little overflow, but that's ok because we have room.
        if (this.fullItemStacks < MAX_ITEM_STACKS) {
            this.fullItemStacks += 1;

            storedItem.setCount(remainder);
            this.items.set(0, storedItem);

            return ItemStack.EMPTY;
        }

        // At this point, we have MAX_ITEM_STACKS already stored, but a little space left in the "real" inventory slot
        storedItem.setCount(storedItem.getMaxCount());
        this.items.set(0, storedItem);

        stack.setCount(remainder);

        return stack;
    }

    @Override
    public ItemStack removeStack() {
        if (!this.hasItem()) {
            return ItemStack.EMPTY;
        }

        ItemStack stack = this.items.get(0).copy();

        if (fullItemStacks > 1 || (fullItemStacks == 1 && stack.isStackable())) {
            stack.setCount(stack.getMaxCount());
            fullItemStacks -= 1;

            return stack;
        }

        this.items.set(0, ItemStack.EMPTY);
        fullItemStacks = 0;

        return stack;
    }

    public DefaultedList<ItemStack> getItemsOnBreak() {
        DefaultedList<ItemStack> stacks = DefaultedList.of();

        int i = 0;

        while (i < fullItemStacks) {
            ItemStack stack = this.items.get(0).copy();
            stack.setCount(stack.getMaxCount());

            stacks.add(stack);
            i++;
        }

        stacks.add(this.items.get(0));

        return stacks;
    }

    @Nullable
    public String getMobId() {
        if (this.hasMob()) {
            return storedMobData.getString("id");
        }

        return null;
    }

    public boolean hasMob() {
        return !storedMobData.isEmpty();
    }

    public boolean hasFluid() {
        return !storedFluid.matchesType(Fluids.EMPTY);
    }

    public boolean hasItem() {
        if (!storedFluid.matchesType(Fluids.EMPTY)) {
            return false;
        }

        ItemStack storedItem = items.get(0);

        return !storedItem.isEmpty();
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        items.clear();

        super.readNbt(nbt, registryLookup);

        boolean hasFluid = readFluidNbt(nbt);
        boolean hasMob = readMobNbt(nbt);

        if (!hasFluid && !hasMob) {
            Inventories.readNbt(nbt, items, registryLookup);
            fullItemStacks = nbt.getInt(ITEM_AMT_KEY);
        }

        markDirty();
    }

    private boolean readFluidNbt(NbtCompound nbt) {
        String fluidKey = nbt.getString(FLUID_KEY);

        if (fluidKey.equals("NONE")) {
            storedFluid = Fluids.EMPTY;
            fluidAmountInBuckets = 0.0;

            return false;
        }

        storedFluid = Registries.FLUID.get(Identifier.of(fluidKey));
        fluidAmountInBuckets = nbt.getDouble(FLUID_AMT_KEY);

        return true;
    }

    private boolean readMobNbt(NbtCompound nbt) {
        storedMobData = nbt.getCompound(MOB_DATA_KEY);

        return !storedMobData.isEmpty();
    }

    public void readMobNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        storedMobData = nbt;
    }

    @Override
    public void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.writeNbt(nbt, items, registryLookup);
        nbt.putInt(ITEM_AMT_KEY, fullItemStacks);

        writeFluidNbt(nbt, registryLookup);
        writeMobNbt(nbt, registryLookup);

        super.writeNbt(nbt, registryLookup);
    }

    private void writeFluidNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        if (storedFluid.matchesType(Fluids.EMPTY)) {
            nbt.putString(FLUID_KEY, "NONE");
            nbt.putDouble(FLUID_AMT_KEY, 0.0);
        } else {
            nbt.putString(FLUID_KEY, Registries.FLUID.getId(storedFluid).toString());
            nbt.putDouble(FLUID_AMT_KEY, fluidAmountInBuckets);
        }
    }

    public void writeMobNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        nbt.put(MOB_DATA_KEY, storedMobData);
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
    public boolean isEmpty() {
        if (hasFluid() || hasMob()) {
            return false;
        }

        return ImplementedInventory.super.isEmpty();
    }

    public void playEmptyBottleSound() {
        playSound(SoundEvents.ITEM_BOTTLE_EMPTY);
    }

    public void playFillBottleSound() {
        playSound(SoundEvents.ITEM_BOTTLE_FILL);
    }

    public void playEmptyBucketSound(Fluid fluid) {
        if (fluid == Fluids.LAVA || fluid == com.chimericdream.minekea.fluid.Fluids.HONEY) {
            playSound(SoundEvents.ITEM_BUCKET_EMPTY_LAVA);
        } else {
            playSound(SoundEvents.ITEM_BUCKET_EMPTY);
        }
    }

    public void playFillBucketSound(Fluid fluid) {
        if (fluid == Fluids.LAVA || fluid == com.chimericdream.minekea.fluid.Fluids.HONEY) {
            playSound(SoundEvents.ITEM_BUCKET_FILL_LAVA);
        } else {
            playSound(SoundEvents.ITEM_BUCKET_FILL);
        }
    }

    public void playAddItemSound() {
        playSound(SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM);
    }

    public void playRemoveItemSound() {
        playSound(SoundEvents.ENTITY_ITEM_FRAME_REMOVE_ITEM);
    }

    public void playSound(SoundEvent soundEvent) {
        this.world.playSound((PlayerEntity) null, pos.getX(), pos.getY(), pos.getZ(), soundEvent, SoundCategory.BLOCKS, 1.0f, 1.0f);
    }
}
