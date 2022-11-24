package com.chimericdream.minekea.item.tools;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.item.Items;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry.BlockColor;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.screen.item.BlockPainterScreenHandler;
import com.chimericdream.minekea.util.ImplementedInventory;
import com.chimericdream.minekea.util.MinekeaItem;
import com.chimericdream.minekea.util.NbtHelpers;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PainterItem extends Item implements MinekeaItem {
    private final Identifier ITEM_ID;

    public PainterItem() {
        super(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1));

        this.ITEM_ID = new Identifier(ModInfo.MOD_ID, "tools/painter");
    }

    public static BlockColor getColor(ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        String stackColor = nbt.getString("current_color");

        return BlockColor.get(stackColor);
    }

    public static BlockColor getNextColor(ItemStack stack) {
        NbtCompound nbt = stack.getOrCreateNbt();
        String stackColor = nbt.getString("current_color");

        return BlockColor.get(stackColor).getNext();
    }

    public static NbtCompound makeNbt(NbtCompound nbt, BlockColor color) {
        nbt.putString("current_color", color.toString());
        nbt.putInt("CustomModelData", color.getModelNumber());

        return nbt;
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = new ItemStack(this);

        stack.setNbt(makeNbt(new NbtCompound(), BlockColor.WHITE));

        return stack;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        NbtCompound nbt = stack.getOrCreateNbt();
        String stackColor = nbt.getString("current_color");
        BlockColor color = BlockColor.get(stackColor);

        MutableText text = Text.literal(String.format("Current color: %s", color));
        tooltip.add(text);
    }

    @Override
    public Identifier getItemID() {
        return ITEM_ID;
    }

    @Override
    public void register() {
        Registry.register(Registry.ITEM, ITEM_ID, Items.PAINTER_ITEM);
        setupResources();
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.itemRespect(this, "Block Painter");

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            ITEM_ID,
            JRecipe.shaped(
                JPattern.pattern(" NW", " SN", "S  "),
                JKeys.keys()
                    .key("N", JIngredient.ingredient().item(net.minecraft.item.Items.IRON_NUGGET))
                    .key("S", JIngredient.ingredient().item(net.minecraft.item.Items.STICK))
                    .key("W", JIngredient.ingredient().item(net.minecraft.item.Items.WHITE_WOOL)),
                JResult.result(ITEM_ID.toString())
            )
        );
    }

    @Override
    public boolean isItemBarVisible(ItemStack painter) {
        ItemStack dye = getSelectedDye(painter);

        return !dye.isEmpty();
    }

    @Override
    public int getItemBarStep(ItemStack painter) {
        ItemStack dye = getSelectedDye(painter);

        if (dye.isEmpty()) {
            return 0;
        }

        return Math.round(13.0F - (float) (dye.getMaxCount() - dye.getCount()) * 13.0F / (float) dye.getMaxCount());
    }

    @Override
    public int getItemBarColor(ItemStack painter) {
        ItemStack dye = getSelectedDye(painter);

        float f = Math.max(0.0F, (float) dye.getCount() / (float) dye.getMaxCount());
        return MathHelper.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (player.world != null && !player.world.isClient) {
            if (player.isSneaking()) {
                openScreen(player, player.getStackInHand(hand));
            }
        }

        return TypedActionResult.success(player.getStackInHand(hand));
    }

    public static void openScreen(PlayerEntity player, ItemStack painter) {
        if (player.world != null && !player.world.isClient) {
            player.openHandledScreen(new ExtendedScreenHandlerFactory() {
                @Override
                public void writeScreenOpeningData(ServerPlayerEntity serverPlayerEntity, PacketByteBuf packetByteBuf) {
                    packetByteBuf.writeItemStack(painter);
                }

                @Override
                public Text getDisplayName() {
                    return Text.translatable(painter.getItem().getTranslationKey());
                }

                @Override
                public @Nullable ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
                    return new BlockPainterScreenHandler(syncId, inv, painter);
                }
            });
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient() || (context.getPlayer() != null && context.getPlayer().isSneaking())) {
            return super.useOnBlock(context);
        }

        BlockPos pos = context.getBlockPos();
        BlockState state = context.getWorld().getBlockState(pos);

        String colorGroup = ColoredBlocksRegistry.getBlockGroup(state.getBlock());

        if (colorGroup == null) {
            return super.useOnBlock(context);
        }

        ItemStack stack = context.getStack();
        BlockColor color = getColor(stack);

        Block newBlock = ColoredBlocksRegistry.findBlock(colorGroup, color);
        if (newBlock == null || state.isOf(newBlock)) {
            return super.useOnBlock(context);
        }

        PlayerEntity player = context.getPlayer();
        ItemStack dye = getSelectedDye(stack);

        if (dye.isEmpty() && (player == null || !player.isCreative())) {
            return ActionResult.FAIL;
        }

        if (player != null && !player.isCreative()) {
            PainterInventory painter = new PainterInventory(stack);
            painter.consumeDye(color);
        }

        context.getWorld().setBlockState(pos, newBlock.getDefaultState());
        context.getWorld().markDirty(pos);

        return ActionResult.SUCCESS;
    }

    private ItemStack getSelectedDye(ItemStack painter) {
        BlockColor color = getColor(painter);
        DefaultedList<ItemStack> inventory = NbtHelpers.getInventory(painter, PainterInventory.INVENTORY_SIZE);

        return inventory.get(color.getIndex());
    }

    public static class PainterInventory implements ImplementedInventory {
        public static final int INVENTORY_SIZE = 16;

        private final ItemStack painterStack;
        private final DefaultedList<ItemStack> items = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY);

        public PainterInventory(ItemStack stack) {
            painterStack = stack;

            NbtCompound nbt = painterStack.getOrCreateNbt();
            Inventories.readNbt(nbt, items);
        }

        @Override
        public DefaultedList<ItemStack> getItems() {
            return items;
        }

        @Override
        public ItemStack tryInsert(ItemStack stack) {
            return stack;
        }

        @Override
        public ItemStack tryInsert(int slot, ItemStack stack) {
            return ImplementedInventory.super.tryInsert(slot, stack);
        }

        public void consumeDye(BlockColor color) {
            ItemStack dye = this.getStack(color.getIndex()).copy();
            if (dye.isEmpty()) {
                return;
            }

            dye.decrement(1);

            if (dye.isEmpty()) {
                this.setStack(color.getIndex(), ItemStack.EMPTY);
            } else {
                this.setStack(color.getIndex(), dye);
            }

            this.markDirty();
        }

        @Override
        public void markDirty() {
            NbtCompound nbt = painterStack.getOrCreateNbt();

            Inventories.writeNbt(nbt, this.items);
        }
    }
}
