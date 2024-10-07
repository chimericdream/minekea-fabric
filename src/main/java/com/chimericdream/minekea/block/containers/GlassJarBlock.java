package com.chimericdream.minekea.block.containers;

import com.chimericdream.lib.blocks.ModBlock;
import com.chimericdream.lib.fabric.blocks.FabricModBlockWithEntity;
import com.chimericdream.lib.fluids.FluidHelpers;
import com.chimericdream.lib.items.ItemHelpers;
import com.chimericdream.minekea.MinekeaMod;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.general.WaxBlock;
import com.chimericdream.minekea.entities.blocks.containers.GlassJarBlockEntity;
import com.chimericdream.minekea.item.ModItems;
import com.chimericdream.minekea.item.ingredients.WaxItem;
import com.chimericdream.minekea.tag.MinekeaItemTags;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.inventory.Inventories;
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
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
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
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class GlassJarBlock extends FabricModBlockWithEntity implements Waterloggable {
    public static final MapCodec<GlassJarBlock> CODEC = createCodec(GlassJarBlock::new);

    public static final Map<String, String> ALLOWED_ITEMS = new LinkedHashMap<>();

    public static final DirectionProperty FACING;
    public static final BooleanProperty WATERLOGGED;

    public static final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "containers/glass_jar");

    private static final VoxelShape MAIN_SHAPE;
    private static final VoxelShape LID_SHAPE;

    static {
        FACING = Properties.HORIZONTAL_FACING;
        WATERLOGGED = Properties.WATERLOGGED;

        /*
         * This would probably be cleaner looking if did something like
         *
         * ```
         * ALLOWED_ITEMS.putAll(Map.<String, String>ofEntries(...));
         * ```
         *
         * I had it like that, but the item tag generation was totally random, meaning the tag JSON file was different
         * every time I ran datagen. By doing it this way, I ensure the JSON file only updates when the values change.
         */
        ALLOWED_ITEMS.put("minecraft:amethyst_shard", "minecraft:amethyst_block");
        ALLOWED_ITEMS.put("minecraft:apple", "minekea:storage/compressed/apple");
        ALLOWED_ITEMS.put("minecraft:bamboo", "minekea:storage/compressed/bamboo");
        ALLOWED_ITEMS.put("minecraft:beetroot", "minekea:storage/compressed/beetroot");
        ALLOWED_ITEMS.put("minecraft:beetroot_seeds", "minekea:storage/compressed/beetroot_seeds");
        ALLOWED_ITEMS.put("minecraft:blaze_powder", "minekea:storage/compressed/blaze_powder");
        ALLOWED_ITEMS.put("minecraft:blaze_rod", "minekea:storage/compressed/blaze_rod");
        ALLOWED_ITEMS.put("minecraft:breeze_rod", "minekea:storage/compressed/breeze_rod");
        ALLOWED_ITEMS.put("minecraft:carrot", "minekea:storage/compressed/carrot");
        ALLOWED_ITEMS.put("minecraft:charcoal", "minekea:storage/compressed/charcoal");
        ALLOWED_ITEMS.put("minecraft:chorus_fruit", "minekea:storage/compressed/chorus_fruit");
        ALLOWED_ITEMS.put("minecraft:coal", "minecraft:coal_block");
        ALLOWED_ITEMS.put("minecraft:dried_kelp", "minecraft:dried_kelp_block");
        ALLOWED_ITEMS.put("minecraft:egg", "minekea:storage/compressed/set_of_eggs");
        ALLOWED_ITEMS.put("minecraft:ender_pearl", "minekea:storage/compressed/ender_pearl");
        ALLOWED_ITEMS.put("minecraft:flint", "minekea:storage/compressed/flint");
        ALLOWED_ITEMS.put("minecraft:glowstone_dust", "minecraft:glowstone");
        ALLOWED_ITEMS.put("minecraft:golden_apple", "minekea:storage/compressed/golden_apple");
        ALLOWED_ITEMS.put("minecraft:gravel", "minecraft:gravel");
        ALLOWED_ITEMS.put("minecraft:honeycomb", "minecraft:honeycomb_block");
        ALLOWED_ITEMS.put("minecraft:leather", "minekea:storage/compressed/leather");
        ALLOWED_ITEMS.put("minecraft:melon_seeds", "minekea:storage/compressed/melon_seeds");
        ALLOWED_ITEMS.put("minecraft:melon_slice", "minecraft:melon");
        ALLOWED_ITEMS.put("minecraft:nether_star", "minekea:storage/compressed/nether_star");
        ALLOWED_ITEMS.put("minecraft:paper", "minekea:storage/compressed/wallpaper");
        ALLOWED_ITEMS.put("minecraft:phantom_membrane", "minekea:storage/compressed/phantom_membrane");
        ALLOWED_ITEMS.put("minecraft:potato", "minekea:storage/compressed/potato");
        ALLOWED_ITEMS.put("minecraft:pumpkin_seeds", "minekea:storage/compressed/pumpkin_seeds");
        ALLOWED_ITEMS.put("minecraft:red_sand", "minecraft:red_sand");
        ALLOWED_ITEMS.put("minecraft:redstone", "minecraft:redstone_block");
        ALLOWED_ITEMS.put("minecraft:sand", "minecraft:sand");
        ALLOWED_ITEMS.put("minecraft:slime_ball", "minecraft:slime_block");
        ALLOWED_ITEMS.put("minecraft:stick", "minekea:storage/compressed/stick");
        ALLOWED_ITEMS.put("minecraft:sugar", "minekea:storage/compressed/sugar");
        ALLOWED_ITEMS.put("minecraft:sugar_cane", "minekea:storage/compressed/sugar_cane");
        ALLOWED_ITEMS.put("minecraft:totem_of_undying", "minekea:storage/compressed/totem");
        ALLOWED_ITEMS.put("minecraft:wheat", "minecraft:hay_block");
        ALLOWED_ITEMS.put("minecraft:wheat_seeds", "minekea:storage/compressed/wheat_seeds");

        ALLOWED_ITEMS.put("minecraft:white_dye", "minekea:storage/dyes/white_dye");
        ALLOWED_ITEMS.put("minecraft:light_gray_dye", "minekea:storage/dyes/light_gray_dye");
        ALLOWED_ITEMS.put("minecraft:gray_dye", "minekea:storage/dyes/gray_dye");
        ALLOWED_ITEMS.put("minecraft:black_dye", "minekea:storage/dyes/black_dye");
        ALLOWED_ITEMS.put("minecraft:brown_dye", "minekea:storage/dyes/brown_dye");
        ALLOWED_ITEMS.put("minecraft:red_dye", "minekea:storage/dyes/red_dye");
        ALLOWED_ITEMS.put("minecraft:orange_dye", "minekea:storage/dyes/orange_dye");
        ALLOWED_ITEMS.put("minecraft:yellow_dye", "minekea:storage/dyes/yellow_dye");
        ALLOWED_ITEMS.put("minecraft:lime_dye", "minekea:storage/dyes/lime_dye");
        ALLOWED_ITEMS.put("minecraft:green_dye", "minekea:storage/dyes/green_dye");
        ALLOWED_ITEMS.put("minecraft:cyan_dye", "minekea:storage/dyes/cyan_dye");
        ALLOWED_ITEMS.put("minecraft:light_blue_dye", "minekea:storage/dyes/light_blue_dye");
        ALLOWED_ITEMS.put("minecraft:blue_dye", "minekea:storage/dyes/blue_dye");
        ALLOWED_ITEMS.put("minecraft:purple_dye", "minekea:storage/dyes/purple_dye");
        ALLOWED_ITEMS.put("minecraft:magenta_dye", "minekea:storage/dyes/magenta_dye");
        ALLOWED_ITEMS.put("minecraft:pink_dye", "minekea:storage/dyes/pink_dye");

        ALLOWED_ITEMS.put("minecraft:white_concrete_powder", "minecraft:white_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:light_gray_concrete_powder", "minecraft:light_gray_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:gray_concrete_powder", "minecraft:gray_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:black_concrete_powder", "minecraft:black_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:brown_concrete_powder", "minecraft:brown_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:red_concrete_powder", "minecraft:red_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:orange_concrete_powder", "minecraft:orange_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:yellow_concrete_powder", "minecraft:yellow_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:lime_concrete_powder", "minecraft:lime_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:green_concrete_powder", "minecraft:green_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:cyan_concrete_powder", "minecraft:cyan_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:light_blue_concrete_powder", "minecraft:light_blue_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:blue_concrete_powder", "minecraft:blue_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:purple_concrete_powder", "minecraft:purple_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:magenta_concrete_powder", "minecraft:magenta_concrete_powder");
        ALLOWED_ITEMS.put("minecraft:pink_concrete_powder", "minecraft:pink_concrete_powder");

        ALLOWED_ITEMS.put(WaxItem.makeId("plain").toString(), WaxBlock.makeId("plain").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("white").toString(), WaxBlock.makeId("white").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("light_gray").toString(), WaxBlock.makeId("light_gray").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("gray").toString(), WaxBlock.makeId("gray").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("black").toString(), WaxBlock.makeId("black").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("brown").toString(), WaxBlock.makeId("brown").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("red").toString(), WaxBlock.makeId("red").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("orange").toString(), WaxBlock.makeId("orange").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("yellow").toString(), WaxBlock.makeId("yellow").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("lime").toString(), WaxBlock.makeId("lime").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("green").toString(), WaxBlock.makeId("green").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("cyan").toString(), WaxBlock.makeId("cyan").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("light_blue").toString(), WaxBlock.makeId("light_blue").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("blue").toString(), WaxBlock.makeId("blue").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("purple").toString(), WaxBlock.makeId("purple").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("magenta").toString(), WaxBlock.makeId("magenta").toString());
        ALLOWED_ITEMS.put(WaxItem.makeId("pink").toString(), WaxBlock.makeId("pink").toString());

        MAIN_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 9.0, 11.0);
        LID_SHAPE = Block.createCuboidShape(6.0, 9.0, 6.0, 10.0, 10.0, 10.0);
    }

    public GlassJarBlock(AbstractBlock.Settings settings) {
        this();
    }

    public GlassJarBlock() {
        super(new ModBlock.Config().settings(Settings.copy(Blocks.GLASS).nonOpaque()));

        this.setDefaultState(
            this.stateManager
                .getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(WATERLOGGED, false)
        );
    }

    protected MapCodec<GlassJarBlock> getCodec() {
        return CODEC;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, WATERLOGGED);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState()
            .with(FACING, ctx.getPlayer().getHorizontalFacing().getOpposite())
            .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        GlassJarBlockEntity entity;
        try {
            entity = (GlassJarBlockEntity) world.getBlockEntity(pos);
            assert entity != null;
        } catch (Exception e) {
            MinekeaMod.LOGGER.error(String.format("The glass jar at %s had an invalid block entity.\nBlock Entity: %s", pos, world.getBlockEntity(pos)));

            return;
        }

        String mobId = entity.getMobId();
        if (mobId == null) {
            return;
        }

        SoundEvent sound = getMobSound(mobId);
        if (sound != null && random.nextInt(100) == 0) {
            world.playSound((double) pos.getX() + 0.5, (double) pos.getY() + 0.5, (double) pos.getZ() + 0.5, sound, SoundCategory.BLOCKS, 0.5F, random.nextFloat() * 0.4F + 0.8F, false);
        }
    }

    @Nullable
    private SoundEvent getMobSound(String mobId) {
        return switch (mobId) {
            case "minecraft:allay" -> SoundEvents.ENTITY_ALLAY_AMBIENT_WITHOUT_ITEM;
            case "minecraft:bat" -> SoundEvents.ENTITY_BAT_AMBIENT;
            case "minecraft:bee" -> SoundEvents.ENTITY_BEE_POLLINATE;
            case "minecraft:endermite" -> SoundEvents.ENTITY_ENDERMITE_AMBIENT;
            case "minecraft:silverfish" -> SoundEvents.ENTITY_SILVERFISH_AMBIENT;
            case "minecraft:slime" -> SoundEvents.ENTITY_SLIME_SQUISH;
            case "minecraft:vex" -> SoundEvents.ENTITY_VEX_AMBIENT;
            default -> null;
        };
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

        NbtComponent customData = itemStack.getOrDefault(DataComponentTypes.CUSTOM_DATA, NbtComponent.DEFAULT);
        if (!customData.isEmpty()) {
            entity.readNbt(customData.copyNbt(), world.getRegistryManager());
            return;
        }

        NbtComponent entityData = itemStack.getOrDefault(DataComponentTypes.ENTITY_DATA, NbtComponent.DEFAULT);
        if (!entityData.isEmpty()) {
            entity.readMobNbt(entityData.copyNbt(), world.getRegistryManager());
        }
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
                        ModItems.GLASS_JAR_ITEM.getDefaultStack()
                    );

                    itemEntity.setToDefaultPickupDelay();

                    world.spawnEntity(itemEntity);
                } else if (!entity.isEmpty()) {
                    ItemStack itemStack = new ItemStack(ModItems.GLASS_JAR_ITEM);
                    NbtCompound nbt = new NbtCompound();
                    entity.writeNbt(nbt, world.getRegistryManager());

                    if (entity.hasMob()) {
                        itemStack.apply(DataComponentTypes.ENTITY_DATA, NbtComponent.of(nbt.getCompound(GlassJarBlockEntity.MOB_DATA_KEY)), UnaryOperator.identity());
                    } else {
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

        NbtComponent customDataComponent = stack.getComponents().get(DataComponentTypes.CUSTOM_DATA);
        NbtComponent entityDataComponent = stack.getComponents().get(DataComponentTypes.ENTITY_DATA);

        if (customDataComponent != null) {
            NbtCompound nbt = customDataComponent.copyNbt();

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
        } else if (entityDataComponent != null) {
            NbtCompound nbt = entityDataComponent.copyNbt();

            if (!nbt.isEmpty()) {
                EntityType.get(nbt.getString("id")).ifPresent(entityType -> {
                    MutableText text = MutableText.of(Text.of("Captured mob: ").getContent()).formatted(Formatting.GREEN);
                    text.append(entityType.getName().copy());

                    tooltip.add(text);
                });
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

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
            .register((itemGroup) -> itemGroup.add(this));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(MAIN_SHAPE, LID_SHAPE);
    }

    @Override
    public void configureItemTags(RegistryWrapper.WrapperLookup registryLookup, Function<TagKey<Item>, FabricTagProvider<Item>.FabricTagBuilder> getBuilder) {
        FabricTagProvider<Item>.FabricTagBuilder builder = getBuilder.apply(MinekeaItemTags.GLASS_JAR_STORABLE).setReplace(false);

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
            .input('L', ItemTags.PLANKS)
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
