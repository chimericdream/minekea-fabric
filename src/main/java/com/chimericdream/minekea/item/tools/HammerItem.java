package com.chimericdream.minekea.item.tools;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.util.MinekeaItem;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends PickaxeItem implements MinekeaItem {
    public final Identifier ITEM_ID;

    public final ToolMaterial material;
    public final int maxSlots;
    public final String materialName;
    public final Item itemIngredient;
    public final TagKey<Item> itemIngredientTag;

    public HammerItem(ToolMaterial material, int maxSlots, String materialName, Item itemIngredient, TagKey<Item> itemIngredientTag) {
        this(material, maxSlots, materialName, itemIngredient, itemIngredientTag, new Item.Settings());
    }

    public HammerItem(ToolMaterial material, int maxSlots, String materialName, Item itemIngredient, TagKey<Item> itemIngredientTag, Item.Settings settings) {
        super(material, settings.maxCount(1));

        this.material = material;
        this.maxSlots = maxSlots;
        this.materialName = materialName;
        this.itemIngredient = itemIngredient;
        this.itemIngredientTag = itemIngredientTag;

        this.ITEM_ID = makeItemId(materialName);
    }

    public static Identifier makeItemId(String materialName) {
        return Identifier.of(ModInfo.MOD_ID, String.format("tools/hammers/%s", materialName.toLowerCase()));
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, miner, EquipmentSlot.MAINHAND);
        }

        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        super.appendTooltip(stack, context, tooltip, options);

        MutableText text = Text.literal(String.format("Uses up to %d slots", this.maxSlots));
        tooltip.add(text);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext ctx) {
        PlayerEntity player = ctx.getPlayer();
        if (player == null) {
            return ActionResult.FAIL;
        }

        List<Integer> slots = new ArrayList<>();

        PlayerInventory inventory = player.getInventory();

        int hammerSlot = inventory.selectedSlot;
        for (int i = hammerSlot; i < 9 && slots.size() < this.maxSlots; i++) {
            ItemStack item = inventory.getStack(i);
            if (!item.isEmpty() && item.getItem() instanceof BlockItem) {
                slots.add(i);
            }
        }

        ItemStack hammer = inventory.getStack(hammerSlot);
        NbtComponent nbtComponent = hammer.getComponents().get(DataComponentTypes.CUSTOM_DATA);

        Random rand;
        if (nbtComponent == null) {
            rand = Random.create();
        } else {
            rand = Random.create(nbtComponent.copyNbt().getLong("placement_seed"));
        }

        if (slots.isEmpty()) {
            return ActionResult.FAIL;
        }

        int totalBlocks = 0;
        for (int slot : slots) {
            totalBlocks += inventory.getStack(slot).getCount();
        }

        int randomBlock = rand.nextBetween(1, totalBlocks);

        int slotToUse = -1;
        for (int slot : slots) {
            if (randomBlock <= inventory.getStack(slot).getCount()) {
                slotToUse = slot;
                break;
            }

            randomBlock -= inventory.getStack(slot).getCount();
        }

        if (slotToUse == -1) {
            return ActionResult.FAIL;
        }

        ItemStack toPlace = inventory.getStack(slotToUse);
        ItemPlacementContext placementContext = new ItemPlacementContext(
            player,
            ctx.getHand(),
            toPlace,
            new BlockHitResult(ctx.getHitPos(), ctx.getSide(), ctx.getBlockPos(), ctx.hitsInsideBlock())
        );

        if (!placementContext.canPlace()) {
            return ActionResult.FAIL;
        }

        World world = ctx.getWorld();
        if (!world.isClient()) {
            long nextSeed = rand.nextLong();

            NbtCompound nbt = new NbtCompound();
            nbt.putLong("placement_seed", nextSeed);

            NbtComponent hammerNbt = NbtComponent.of(nbt);

            hammer.set(DataComponentTypes.CUSTOM_DATA, hammerNbt);
        }

        ActionResult result = ((BlockItem) toPlace.getItem()).place(placementContext);
        if (result == ActionResult.CONSUME || result == ActionResult.CONSUME_PARTIAL) {
            if (!player.isCreative()) {
                inventory.getMainHandStack().damage(1, player, ctx.getHand() == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void register() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
            .register(itemGroup -> itemGroup.add(this));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        if (this.itemIngredient == null) {
            ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, this, 1)
                .pattern("ISI")
                .pattern(" S ")
                .pattern(" S ")
                .input('I', this.itemIngredientTag)
                .input('S', Items.STICK)
                .criterion("has_item_from_tag",
                    FabricRecipeProvider.conditionsFromTag(this.itemIngredientTag))
                .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                    FabricRecipeProvider.conditionsFromItem(Items.STICK))
                .offerTo(exporter);

            return;
        }

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, this, 1)
            .pattern("ISI")
            .pattern(" S ")
            .pattern(" S ")
            .input('I', this.itemIngredient)
            .input('S', Items.STICK)
            .criterion(FabricRecipeProvider.hasItem(this.itemIngredient),
                FabricRecipeProvider.conditionsFromItem(this.itemIngredient))
            .criterion(FabricRecipeProvider.hasItem(Items.STICK),
                FabricRecipeProvider.conditionsFromItem(Items.STICK))
            .offerTo(exporter);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Hammer", this.materialName));
    }
}
