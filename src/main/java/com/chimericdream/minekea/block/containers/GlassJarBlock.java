package com.chimericdream.minekea.block.containers;

import com.chimericdream.minekea.MinekeaMod;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.entities.blocks.containers.GlassJarBlockEntity;
import com.chimericdream.minekea.tag.MinecraftItemTags;
import com.chimericdream.minekea.tag.MinekeaTags;
import com.chimericdream.minekea.util.FluidHelpers;
import com.chimericdream.minekea.util.ItemHelpers;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;

import static java.util.Map.entry;

public class GlassJarBlock extends Block implements MinekeaBlock, BlockEntityProvider, Waterloggable {
    public static final Map<String, String> ALLOWED_ITEMS = new HashMap<>();

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    private final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "containers/glass_jar");

    private static final VoxelShape MAIN_SHAPE;
    private static final VoxelShape LID_SHAPE;

    static {
        ALLOWED_ITEMS.putAll(Map.<String, String>ofEntries(
            entry("minecraft:amethyst_shard", "minecraft:amethyst_block"),
            entry("minecraft:apple", "minekea:storage/compressed/apple"),
            entry("minecraft:bamboo", "minekea:storage/compressed/bamboo"),
            entry("minecraft:beetroot", "minekea:storage/compressed/beetroot"),
            entry("minecraft:beetroot_seeds", "minekea:storage/compressed/beetroot_seeds"),
            entry("minecraft:black_concrete_powder", "minecraft:black_concrete_powder"),
            entry("minecraft:black_dye", "minekea:storage/dyes/black_dye"),
            entry("minecraft:blaze_powder", "minekea:storage/compressed/blaze_powder"),
            entry("minecraft:blaze_rod", "minekea:storage/compressed/blaze_rod"),
            entry("minecraft:breeze_rod", "minekea:storage/compressed/breeze_rod"),
            entry("minecraft:blue_concrete_powder", "minecraft:blue_concrete_powder"),
            entry("minecraft:blue_dye", "minekea:storage/dyes/blue_dye"),
            entry("minecraft:brown_concrete_powder", "minecraft:brown_concrete_powder"),
            entry("minecraft:brown_dye", "minekea:storage/dyes/brown_dye"),
            entry("minecraft:carrot", "minekea:storage/compressed/carrot"),
            entry("minecraft:charcoal", "minekea:storage/compressed/charcoal"),
            entry("minecraft:chorus_fruit", "minekea:storage/compressed/chorus_fruit"),
            entry("minecraft:coal", "minecraft:coal_block"),
            entry("minecraft:cyan_concrete_powder", "minecraft:cyan_concrete_powder"),
            entry("minecraft:cyan_dye", "minekea:storage/dyes/cyan_dye"),
            entry("minecraft:dried_kelp", "minecraft:dried_kelp_block"),
            entry("minecraft:egg", "minekea:storage/compressed/set_of_eggs"),
            entry("minecraft:ender_pearl", "minekea:storage/compressed/ender_pearl"),
            entry("minecraft:flint", "minekea:storage/compressed/flint"),
            entry("minecraft:glowstone_dust", "minecraft:glowstone"),
            entry("minecraft:golden_apple", "minekea:storage/compressed/golden_apple"),
            entry("minecraft:gravel", "minecraft:gravel"),
            entry("minecraft:gray_concrete_powder", "minecraft:gray_concrete_powder"),
            entry("minecraft:gray_dye", "minekea:storage/dyes/gray_dye"),
            entry("minecraft:green_concrete_powder", "minecraft:green_concrete_powder"),
            entry("minecraft:green_dye", "minekea:storage/dyes/green_dye"),
            entry("minecraft:honeycomb", "minecraft:honeycomb_block"),
            entry("minecraft:leather", "minekea:storage/compressed/leather"),
            entry("minecraft:light_blue_concrete_powder", "minecraft:light_blue_concrete_powder"),
            entry("minecraft:light_blue_dye", "minekea:storage/dyes/light_blue_dye"),
            entry("minecraft:light_gray_concrete_powder", "minecraft:light_gray_concrete_powder"),
            entry("minecraft:light_gray_dye", "minekea:storage/dyes/light_gray_dye"),
            entry("minecraft:lime_concrete_powder", "minecraft:lime_concrete_powder"),
            entry("minecraft:lime_dye", "minekea:storage/dyes/lime_dye"),
            entry("minecraft:magenta_concrete_powder", "minecraft:magenta_concrete_powder"),
            entry("minecraft:magenta_dye", "minekea:storage/dyes/magenta_dye"),
            entry("minecraft:melon_seeds", "minekea:storage/compressed/melon_seeds"),
            entry("minecraft:melon_slice", "minecraft:melon"),
            entry("minecraft:nether_star", "minekea:storage/compressed/nether_star"),
            entry("minecraft:orange_concrete_powder", "minecraft:orange_concrete_powder"),
            entry("minecraft:orange_dye", "minekea:storage/dyes/orange_dye"),
            entry("minecraft:paper", "minekea:storage/compressed/wallpaper"),
            entry("minecraft:phantom_membrane", "minekea:storage/compressed/phantom_membrane"),
            entry("minecraft:pink_concrete_powder", "minecraft:pink_concrete_powder"),
            entry("minecraft:pink_dye", "minekea:storage/dyes/pink_dye"),
            entry("minecraft:potato", "minekea:storage/compressed/potato"),
            entry("minecraft:pumpkin_seeds", "minekea:storage/compressed/pumpkin_seeds"),
            entry("minecraft:purple_concrete_powder", "minecraft:purple_concrete_powder"),
            entry("minecraft:purple_dye", "minekea:storage/dyes/purple_dye"),
            entry("minecraft:red_concrete_powder", "minecraft:red_concrete_powder"),
            entry("minecraft:red_dye", "minekea:storage/dyes/red_dye"),
            entry("minecraft:red_sand", "minecraft:red_sand"),
            entry("minecraft:redstone", "minecraft:redstone_block"),
            entry("minecraft:sand", "minecraft:sand"),
            entry("minecraft:slime_ball", "minecraft:slime_block"),
            entry("minecraft:stick", "minekea:storage/compressed/stick"),
            entry("minecraft:sugar", "minekea:storage/compressed/sugar"),
            entry("minecraft:sugar_cane", "minekea:storage/compressed/sugar_cane"),
            entry("minecraft:totem_of_undying", "minekea:storage/compressed/totem"),
            entry("minecraft:wheat", "minecraft:hay_block"),
            entry("minecraft:wheat_seeds", "minekea:storage/compressed/wheat_seeds"),
            entry("minecraft:white_concrete_powder", "minecraft:white_concrete_powder"),
            entry("minecraft:white_dye", "minekea:storage/dyes/white_dye"),
            entry("minecraft:yellow_concrete_powder", "minecraft:yellow_concrete_powder"),
            entry("minecraft:yellow_dye", "minekea:storage/dyes/yellow_dye")
        ));

        MAIN_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 9.0, 11.0);
        LID_SHAPE = Block.createCuboidShape(6.0, 9.0, 6.0, 10.0, 10.0, 10.0);
    }

    public GlassJarBlock() {
        super(Settings.copy(Blocks.GLASS).nonOpaque());

        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
            .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new GlassJarBlockEntity(ContainerBlocks.GLASS_JAR_BLOCK_ENTITY, pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        GlassJarBlockEntity entity;

        try {
            entity = (GlassJarBlockEntity) world.getBlockEntity(pos);
            assert entity != null;
        } catch (Exception e) {
            MinekeaMod.LOGGER.error(String.format("The glass jar at %s had an invalid block entity.\nBlock Entity: %s", pos, world.getBlockEntity(pos)));

            return ActionResult.FAIL;
        }

        ItemStack stack = player.getMainHandStack();

        if (isFilledBucket(stack)) {
            Identifier stackId = Registries.ITEM.getId(stack.getItem());
            Fluid bucketFluid = getFluidType(stackId);

            if (!bucketFluid.matchesType(Fluids.EMPTY) && entity.tryInsert(bucketFluid)) {
                replaceHeldItemOrDont(world, player, stack, Items.BUCKET.getDefaultStack());
                if (world.isClient()) {
                    entity.playEmptyBucketSound(bucketFluid);
                }
                entity.markDirty();
            }
        } else if (isFilledBottle(stack)) {
            if (
                stack.isOf(Items.HONEY_BOTTLE)
                    && entity.tryInsert(com.chimericdream.minekea.fluid.Fluids.HONEY, GlassJarBlockEntity.BOTTLE_SIZE)
            ) {
                replaceHeldItemOrDont(world, player, stack, Items.GLASS_BOTTLE.getDefaultStack());
                if (world.isClient()) {
                    entity.playEmptyBottleSound();
                }
                entity.markDirty();
            } else if (
                stack.isOf(Items.POTION)
                    && stack.getComponents().get(DataComponentTypes.POTION_CONTENTS) != null
                    && stack.getComponents().get(DataComponentTypes.POTION_CONTENTS).matches(Potions.WATER)
                    && entity.tryInsert(Fluids.WATER, GlassJarBlockEntity.BOTTLE_SIZE)
            ) {
                replaceHeldItemOrDont(world, player, stack, Items.GLASS_BOTTLE.getDefaultStack());
                if (world.isClient()) {
                    entity.playEmptyBottleSound();
                }
                entity.markDirty();
            }
        } else if (
            stack.isOf(Items.GLASS_BOTTLE)
                && entity.hasFluid()
                && (entity.getStoredFluid() == Fluids.WATER || entity.getStoredFluid() == com.chimericdream.minekea.fluid.Fluids.HONEY)
        ) {
            ItemStack bottle = entity.getBottle();

            if (bottle != null && !bottle.isOf(Items.GLASS_BOTTLE)) {
                replaceHeldItemOrDont(world, player, stack, bottle);
                if (world.isClient()) {
                    entity.playFillBottleSound();
                }
            }
        } else if (isEmptyBucket(stack) && entity.hasFluid()) {
            Fluid fluid = entity.getBucket();

            if (!fluid.matchesType(Fluids.EMPTY)) {
                if (fluid.matchesType(Fluids.WATER)) {
                    replaceHeldItemOrDont(world, player, stack, Items.WATER_BUCKET.getDefaultStack());
                } else if (fluid.matchesType(Fluids.LAVA)) {
                    replaceHeldItemOrDont(world, player, stack, Items.LAVA_BUCKET.getDefaultStack());
                } else if (fluid.matchesType(com.chimericdream.minekea.fluid.Fluids.MILK)) {
                    replaceHeldItemOrDont(world, player, stack, Items.MILK_BUCKET.getDefaultStack());
                } else if (fluid.matchesType(com.chimericdream.minekea.fluid.Fluids.HONEY)) {
                    replaceHeldItemOrDont(world, player, stack, com.chimericdream.minekea.fluid.Fluids.HONEY_BUCKET.getDefaultStack());
                }

                if (world.isClient()) {
                    entity.playFillBucketSound(fluid);
                }
                entity.markDirty();
            }
        } else if (!stack.isEmpty() && entity.canAcceptItem(stack)) {
            ItemStack originalStack = stack.copy();

            // Try to insert the item in the player's hand into the jar
            ItemStack remainingStack = entity.tryInsert(stack);

            if (remainingStack.isEmpty() || originalStack.getCount() > remainingStack.getCount()) {
                player.setStackInHand(Hand.MAIN_HAND, remainingStack);
                if (world.isClient()) {
                    entity.playAddItemSound();
                }
                entity.markDirty();
            }
        } else if (player.isSneaking() && stack.isEmpty()) {
            if (entity.hasItem()) {
                ItemScatterer.spawn(
                    world,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    entity.removeStack()
                );
                if (world.isClient()) {
                    entity.playRemoveItemSound();
                }
                entity.markDirty();
            }
        }

        world.markDirty(pos);

        return ActionResult.SUCCESS;
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        if (world.isClient()) {
            return;
        }

        GlassJarBlockEntity entity;

        try {
            entity = (GlassJarBlockEntity) world.getBlockEntity(pos);
            assert entity != null;
        } catch (Exception e) {
            MinekeaMod.LOGGER.error(String.format("The glass jar at %s had an invalid block entity.\nBlock Entity: %s", pos, world.getBlockEntity(pos)));
            return;
        }

        if (itemStack.get(DataComponentTypes.CUSTOM_DATA) == null) {
            return;
        }

        entity.readNbt(itemStack.get(DataComponentTypes.CUSTOM_DATA).copyNbt(), world.getRegistryManager());
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        BlockEntity blockEntity = world.getBlockEntity(pos);

        if (blockEntity instanceof GlassJarBlockEntity entity) {
            if (!world.isClient) {
                if (entity.isEmpty() && !player.isCreative()) {
                    ItemEntity itemEntity = new ItemEntity(
                        world,
                        (double) pos.getX() + 0.5D,
                        (double) pos.getY() + 0.5D,
                        (double) pos.getZ() + 0.5D,
                        ContainerBlocks.GLASS_JAR_ITEM.getDefaultStack()
                    );

                    itemEntity.setToDefaultPickupDelay();

                    world.spawnEntity(itemEntity);
                } else if (!entity.isEmpty()) {
                    ItemStack itemStack = new ItemStack(ContainerBlocks.GLASS_JAR_ITEM);
                    NbtCompound nbt = new NbtCompound();
                    entity.writeNbt(nbt, world.getRegistryManager());

                    if (!nbt.isEmpty()) {
                        itemStack.apply(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt), UnaryOperator.identity());
                    }

                    ItemEntity itemEntity = new ItemEntity(
                        world,
                        (double) pos.getX() + 0.5D,
                        (double) pos.getY() + 0.5D,
                        (double) pos.getZ() + 0.5D,
                        itemStack
                    );

                    itemEntity.setToDefaultPickupDelay();

                    world.spawnEntity(itemEntity);
                }
            }
        }

        return state;
    }

    private void replaceHeldItemOrDont(World world, PlayerEntity player, ItemStack heldItem, ItemStack item) {
        ItemStack remaining = heldItem.copy();
        remaining.decrement(1);

        if (remaining.getCount() == 0) {
            player.setStackInHand(Hand.MAIN_HAND, item);
        } else {
            player.setStackInHand(Hand.MAIN_HAND, remaining);
            ItemScatterer.spawn(
                world,
                player.getX(),
                player.getY(),
                player.getZ(),
                item
            );
        }
    }

    @Override
    public void appendTooltip(ItemStack stack, Item.TooltipContext context, List<Text> tooltip, TooltipType options) {
        super.appendTooltip(stack, context, tooltip, options);

        NbtComponent nbtComponent = stack.getComponents().get(DataComponentTypes.CUSTOM_DATA);

        if (nbtComponent != null) {
            NbtCompound nbt = nbtComponent.copyNbt();

            String storedFluid = nbt.getString(GlassJarBlockEntity.FLUID_KEY);
            if (!storedFluid.isEmpty() && !storedFluid.equals("NONE")) {
                Fluid fluid = Registries.FLUID.get(Identifier.of(storedFluid));

                if (fluid != Fluids.EMPTY) {
                    MutableText text = FluidHelpers.getFluidName(fluid).copy().formatted(Formatting.GREEN);

                    double fluidAmount = nbt.getDouble(GlassJarBlockEntity.FLUID_AMT_KEY);

                    String format = Math.round(fluidAmount) == fluidAmount ? " (%.0f buckets)" : " (%.1f buckets)";
                    text.append(
                        fluidAmount != 1.0
                            ? String.format(format, fluidAmount)
                            : " (1 bucket)"
                    );

                    tooltip.add(text);
                }
            } else {
                DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);
                Inventories.readNbt(nbt, items, context.getRegistryLookup());

                ItemStack storedItem = items.get(0);
                if (!storedItem.isEmpty()) {
                    int fullStacks = nbt.getInt(GlassJarBlockEntity.ITEM_AMT_KEY);
                    int total = storedItem.getCount() + (fullStacks * storedItem.getMaxCount());

                    MutableText text = storedItem.getName().copy().formatted(Formatting.GREEN);
                    text.append(String.format(" (%d)", total));

                    tooltip.add(text);
                }
            }
        }
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity entity = world.getBlockEntity(pos);

            if (entity instanceof GlassJarBlockEntity) {
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    private Fluid getFluidType(Identifier heldItemId) {
        Optional<Fluid> foundFluid = Registries.FLUID.stream()
            .filter(fluid -> {
                Item bucket = fluid.getBucketItem();
                return Registries.ITEM.getId(bucket).compareTo(heldItemId) == 0;
            })
            .findFirst();

        return foundFluid.orElse(Fluids.EMPTY);
    }

    private boolean isEmptyBucket(ItemStack item) {
        if (item.isEmpty()) {
            return false;
        }

        return item.isOf(Items.BUCKET);
    }

    private boolean isFilledBottle(ItemStack item) {
        if (item.isEmpty()) {
            return false;
        }

        if (
            item.isOf(Items.POTION)
                && item.getComponents().get(DataComponentTypes.POTION_CONTENTS) != null
                && item.getComponents().get(DataComponentTypes.POTION_CONTENTS).matches(Potions.WATER)
        ) {
            return true;
        }

        return item.isOf(Items.HONEY_BOTTLE);
    }

    private boolean isFilledBucket(ItemStack item) {
        if (item.isEmpty()) {
            return false;
        }

        if (!(item.getItem() instanceof BucketItem) && !(item.getItem() instanceof MilkBucketItem)) {
            return false;
        }

        Identifier itemId = Registries.ITEM.getId(item.getItem());

        return itemId.compareTo(Registries.ITEM.getId(Items.BUCKET.asItem())) != 0;
    }

    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        ContainerBlocks.GLASS_JAR_ITEM = Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().maxCount(8)));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
            .register((itemGroup) -> itemGroup.add(this));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(MAIN_SHAPE, LID_SHAPE);
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        FabricTagProvider<Item>.FabricTagBuilder builder = getBuilder.apply(MinekeaTags.GLASS_JAR_STORABLE).setReplace(false);

        for (String id : ALLOWED_ITEMS.keySet()) {
            builder.add(Identifier.of(id));
        }
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, this, 3)
            .pattern(" L ")
            .pattern("G G")
            .pattern("GGG")
            .input('L', MinecraftItemTags.PLANKS)
            .input('G', Items.GLASS_PANE)
            .criterion(FabricRecipeProvider.hasItem(Items.GLASS_PANE),
                FabricRecipeProvider.conditionsFromItem(Items.GLASS_PANE))
            .offerTo(exporter);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Glass Jar");
    }

    public static ItemStack getStackToRender(ItemStack stack) {
        Identifier stackId = ItemHelpers.getIdentifier(stack);

        if (!ALLOWED_ITEMS.containsKey(stackId.toString())) {
            return stack;
        }

        return Registries.ITEM.get(Identifier.of(ALLOWED_ITEMS.get(stackId.toString()))).getDefaultStack();
    }
}
