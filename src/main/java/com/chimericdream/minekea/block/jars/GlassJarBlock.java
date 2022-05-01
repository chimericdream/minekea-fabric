package com.chimericdream.minekea.block.jars;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class GlassJarBlock extends Block implements MinekeaBlock, BlockEntityProvider {
    private final Identifier BLOCK_ID;
    private final String modId;
    private static final VoxelShape MAIN_SHAPE;
    private static final VoxelShape LID_SHAPE;

    static {
        MAIN_SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 9.0, 11.0);
        LID_SHAPE = Block.createCuboidShape(6.0, 9.0, 6.0, 10.0, 10.0, 10.0);
    }

    public GlassJarBlock() {
        this(ModInfo.MOD_ID);
    }

    public GlassJarBlock(String modId) {
        super(Settings.copy(Blocks.GLASS).nonOpaque());

        validateMaterials(null);

        this.modId = modId;

        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("jars/%sglass_jar", ModInfo.getModPrefix(modId)));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new GlassJarBlockEntity(Jars.GLASS_JAR_BLOCK_ENTITY, pos, state);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        GlassJarBlockEntity entity = (GlassJarBlockEntity) world.getBlockEntity(pos);

        // Theoretically, this shouldn't be possible
        if (entity == null) {
            return ActionResult.FAIL;
        }

        ItemStack heldItem = player.getMainHandStack();

        if (isFilledBucket(heldItem)) {
            RegistryEntry.Reference<Item> entry = heldItem.getItem().getRegistryEntry();
            Fluid bucketFluid = getFluidType(entry);

            if (!bucketFluid.matchesType(Fluids.EMPTY) && entity.tryInsert(bucketFluid)) {
                player.setStackInHand(Hand.MAIN_HAND, Items.BUCKET.getDefaultStack());
                entity.playEmptyBucketSound(bucketFluid);
                entity.markDirty();
            }
        } else if (isEmptyBucket(heldItem) && entity.hasFluid()) {
            Fluid fluid = entity.getBucket();

            if (!fluid.matchesType(Fluids.EMPTY)) {
                if (fluid.matchesType(Fluids.WATER)) {
                    player.setStackInHand(Hand.MAIN_HAND, Items.WATER_BUCKET.getDefaultStack());
                } else if (fluid.matchesType(Fluids.LAVA)) {
                    player.setStackInHand(Hand.MAIN_HAND, Items.LAVA_BUCKET.getDefaultStack());
                } else if (fluid.matchesType(com.chimericdream.minekea.fluid.Fluids.MILK)) {
                    player.setStackInHand(Hand.MAIN_HAND, Items.MILK_BUCKET.getDefaultStack());
                }

                entity.playFillBucketSound(fluid);
                entity.markDirty();
            }
        } else if (!heldItem.isEmpty() && entity.canAcceptItem(heldItem)) {
            ItemStack originalStack = heldItem.copy();

            // Try to insert the item in the player's hand into the jar
            ItemStack remainingStack = entity.tryInsert(heldItem);

            if (remainingStack.isEmpty() || originalStack.getCount() > remainingStack.getCount()) {
                player.setStackInHand(hand, remainingStack);
                entity.playAddItemSound();
                entity.markDirty();
            }
        } else if (player.isSneaking() && heldItem.isEmpty()) {
            if (entity.hasItem()) {
                ItemScatterer.spawn(
                    world,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    entity.removeStack()
                );
                entity.playRemoveItemSound();
                entity.markDirty();
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity entity = world.getBlockEntity(pos);

            if (entity instanceof GlassJarBlockEntity) {
                ItemScatterer.spawn(world, pos, ((GlassJarBlockEntity) entity).getItemsOnBreak());
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    /*
     * @TODO: it'd be nice if this could be done in a more generalized way
     */
    private Fluid getFluidType(RegistryEntry.Reference<Item> entry) {
        if (entry.value().toString().equals("water_bucket")) {
            return Fluids.WATER;
        }

        if (entry.value().toString().equals("lava_bucket")) {
            return Fluids.LAVA;
        }

        if (entry.value().toString().equals("milk_bucket")) {
            return com.chimericdream.minekea.fluid.Fluids.MILK;
        }

        return Fluids.EMPTY;
    }

    private boolean isEmptyBucket(ItemStack item) {
        if (item.isEmpty()) {
            return false;
        }

        return item.isItemEqual(Items.BUCKET.getDefaultStack());
    }

    private boolean isFilledBucket(ItemStack item) {
        if (item.isEmpty()) {
            return false;
        }

        if (!(item.getItem() instanceof BucketItem) && !(item.getItem() instanceof MilkBucketItem)) {
            return false;
        }

        String registryEntry = item.getItem().getRegistryEntry().value().toString();

        return !registryEntry.equals("bucket");
    }

    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        setupResources();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(MAIN_SHAPE, LID_SHAPE);
    }

    public void setupResources() {
        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern(" L ", "G G", "GGG"),
                JKeys.keys()
                    .key("G", JIngredient.ingredient().item("minecraft:glass_pane"))
                    .key("L", JIngredient.ingredient().item("minecraft:acacia_planks")),
                JResult.stackedResult(BLOCK_ID.toString(), 3)
            )
        );

        Identifier MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/jars/%sglass_jar", ModInfo.getModPrefix(modId)));
        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/jars/%sglass_jar", ModInfo.getModPrefix(modId)));

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(new Identifier(ModInfo.MOD_ID, "block/glass_jar")), MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(new Identifier(ModInfo.MOD_ID, "item/glass_jar")), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant(new JBlockModel(MODEL_ID))),
            BLOCK_ID
        );
    }
}
