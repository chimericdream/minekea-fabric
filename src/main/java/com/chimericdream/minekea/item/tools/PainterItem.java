package com.chimericdream.minekea.item.tools;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry.BlockColor;
import com.chimericdream.minekea.screen.item.BlockPainterScreenHandler;
import com.chimericdream.minekea.util.ImplementedInventory;
import com.chimericdream.minekea.util.MinekeaItem;
import com.chimericdream.minekea.util.NbtHelpers;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;

public class PainterItem extends Item implements MinekeaItem {
    public static final Identifier ITEM_ID = Identifier.of(ModInfo.MOD_ID, "tools/painter");

    public PainterItem() {
        super(new Item.Settings().maxCount(1));
    }

    public static BlockColor getColor(ItemStack stack) {
        NbtCompound nbt = NbtHelpers.getOrCreateNbt(stack);
        String stackColor = nbt.getString("current_color");

        return BlockColor.get(stackColor);
    }

    public static BlockColor getNextColor(ItemStack stack) {
        NbtCompound nbt = NbtHelpers.getOrCreateNbt(stack);
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

        NbtHelpers.setCustomDataFromNbt(stack, makeNbt(new NbtCompound(), BlockColor.WHITE));

        return stack;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        super.appendTooltip(stack, context, tooltip, options);

        NbtCompound nbt = NbtHelpers.getOrCreateNbt(stack);
        String stackColor = nbt.getString("current_color");
        BlockColor color = BlockColor.get(stackColor);

        MutableText text = Text.literal(String.format("Current color: %s", color));
        tooltip.add(text);
    }

    @Override
    public void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
            .register((itemGroup) -> {
                itemGroup.add(this);
            });
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, this, 1)
            .pattern(" NW")
            .pattern(" SN")
            .pattern("S  ")
            .input('N', Items.IRON_NUGGET)
            .input('S', Items.STICK)
            .input('W', ItemTags.WOOL)
            .criterion(FabricRecipeProvider.hasItem(Items.IRON_NUGGET),
                FabricRecipeProvider.conditionsFromItem(Items.IRON_NUGGET))
            .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                FabricRecipeProvider.conditionsFromItem(Items.STICK))
            .criterion("has_wool", FabricRecipeProvider.conditionsFromTag(ItemTags.WOOL))
            .offerTo(exporter);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Block Painter");
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
        if (player.getWorld() != null && !player.getWorld().isClient) {
            if (player.isSneaking()) {
                openScreen(player, player.getStackInHand(hand));
            }
        }

        return TypedActionResult.success(player.getStackInHand(hand));
    }

    public static void openScreen(PlayerEntity player, ItemStack painter) {
        if (player.getWorld() != null && !player.getWorld().isClient) {
            player.openHandledScreen(new NamedScreenHandlerFactory() {
                @Override
                public Text getDisplayName() {
                    return Text.translatable(painter.getItem().getTranslationKey());
                }

                @Override
                public ScreenHandler createMenu(int syncId, PlayerInventory inv, PlayerEntity player) {
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
        Item dye = color.getDye();
        ContainerComponent inventory = painter.get(DataComponentTypes.CONTAINER);

        if (dye == null || inventory == null) {
            return ItemStack.EMPTY;
        }

        return inventory.stream()
            .toList().stream()
            .filter(stack -> stack.getItem() == dye)
            .findFirst()
            .orElse(ItemStack.EMPTY);
    }

    public static class PainterInventory implements ImplementedInventory {
        public static final int INVENTORY_SIZE = 16;

        private final ItemStack painterStack;
        private final DefaultedList<ItemStack> items = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY);

        public PainterInventory(ItemStack stack) {
            painterStack = stack;

            ContainerComponent inventory = painterStack.get(DataComponentTypes.CONTAINER);

            if (inventory != null) {
                inventory.copyTo(items);
            }
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
            painterStack.set(DataComponentTypes.CONTAINER, ContainerComponent.fromStacks(items));
        }
    }
}
