package com.chimericdream.minekea.item.tools;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.util.MinekeaItem;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtLong;
import net.minecraft.tag.ItemTags;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class HammerItem extends PickaxeItem implements MinekeaItem {
    private final HammerSettings settings;

    public HammerItem(HammerSettings settings) {
        super(
            settings.material,
            (int) settings.material.getAttackDamage(),
            settings.material.getMiningSpeedMultiplier(),
            settings
        );

        this.settings = settings;
    }

    public Identifier getItemID() {
        return new Identifier(ModInfo.MOD_ID, String.format("tools/hammers/%s", settings.materialName.toLowerCase()));
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, miner, (e) -> {
                e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            });
        }

        return true;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);

        MutableText text = Text.literal(String.format("Uses up to %d slots", settings.maxSlots));
        tooltip.add(text);
    }

    @Override
    public void register() {
        Registry.register(Registry.ITEM, getItemID(), this);
        setupResources();
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
        for (int i = hammerSlot; i < 9 && slots.size() <= settings.maxSlots; i++) {
            ItemStack item = inventory.getStack(i);
            if (!item.isEmpty() && item.getItem() instanceof BlockItem) {
                slots.add(i);
            }
        }

        ItemStack hammer = inventory.getStack(hammerSlot);
        long currentSeed = hammer.getOrCreateNbt().getLong("placement_seed");

        Random rand = Random.create(currentSeed);

        if (slots.size() == 0) {
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
            hammer.setSubNbt("placement_seed", NbtLong.of(nextSeed));
        }

        ActionResult result = ((BlockItem) toPlace.getItem()).place(placementContext);
        if (result == ActionResult.CONSUME || result == ActionResult.CONSUME_PARTIAL) {
            if (!player.isCreative()) {
                inventory.getMainHandStack().damage(1, player, p -> p.sendToolBreakStatus(ctx.getHand()));
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.itemRespect(this, String.format("%s Hammer", settings.materialName));

        if (settings.smithingIngredient != null) {
            MinekeaResourcePack.RESOURCE_PACK.addRecipe(
                getItemID(),
                JRecipe.smithing(
                    settings.smithingIngredient,
                    settings.ingredient,
                    JResult.result(getItemID().toString())
                )
            );
        } else {
            MinekeaResourcePack.RESOURCE_PACK.addRecipe(
                getItemID(),
                JRecipe.shaped(
                    JPattern.pattern("ISI", " S ", " S "),
                    JKeys.keys()
                        .key("I", settings.ingredient)
                        .key("S", JIngredient.ingredient().item(Items.STICK)),
                    JResult.result(getItemID().toString())
                )
            );
        }
    }

    public static class HammerSettings extends FabricItemSettings {
        protected int maxSlots = 4;
        protected ToolMaterial material = ToolMaterials.STONE;
        protected String materialName = "Stone";
        protected JIngredient ingredient = JIngredient.ingredient().tag(ItemTags.STONE_TOOL_MATERIALS.id().toString());
        protected JIngredient smithingIngredient = null;

        public HammerSettings() {
            super();

            this.group(ItemGroup.TOOLS);
        }

        public HammerSettings maxSlots(int maxSlots) {
            this.maxSlots = maxSlots;
            return this;
        }

        public HammerSettings material(ToolMaterial material) {
            this.material = material;
            return this;
        }

        public HammerSettings materialName(String materialName) {
            this.materialName = materialName;
            return this;
        }

        public HammerSettings ingredient(JIngredient ingredient) {
            this.ingredient = ingredient;
            return this;
        }

        public HammerSettings smithingIngredient(JIngredient ingredient) {
            this.smithingIngredient = ingredient;
            return this;
        }
    }
}
