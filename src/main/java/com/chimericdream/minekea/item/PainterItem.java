package com.chimericdream.minekea.item;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry.BlockColor;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.util.MinekeaItem;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
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

    public static NbtCompound makeNbt(BlockColor color) {
        NbtCompound nbt = new NbtCompound();
        nbt.putString("current_color", color.toString());
        nbt.putInt("CustomModelData", color.getModelNumber());

        return nbt;
    }

    @Override
    public ItemStack getDefaultStack() {
        ItemStack stack = new ItemStack(this);

        stack.setNbt(makeNbt(BlockColor.WHITE));

        return stack;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        NbtCompound nbt = stack.getOrCreateNbt();
        String stackColor = nbt.getString("current_color");
        BlockColor color = BlockColor.get(stackColor);

        MutableText text = new LiteralText(String.format("Current color: %s", color));
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
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (context.getWorld().isClient()) {
            return super.useOnBlock(context);
        }

        BlockPos pos = context.getBlockPos();
        BlockState state = context.getWorld().getBlockState(pos);

        String colorGroup = ColoredBlocksRegistry.getBlockGroup(state.getBlock());

        if (colorGroup == null) {
            return super.useOnBlock(context);
        }

        ItemStack painter = context.getStack();
        BlockColor color = getColor(painter);
        Block newBlock = ColoredBlocksRegistry.findBlock(colorGroup, color);

        if (newBlock == null) {
            return super.useOnBlock(context);
        }

        context.getWorld().setBlockState(pos, newBlock.getDefaultState());
        context.getWorld().markDirty(pos);

        return ActionResult.SUCCESS;
    }
}
