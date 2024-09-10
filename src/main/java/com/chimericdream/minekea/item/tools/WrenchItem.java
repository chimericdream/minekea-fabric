package com.chimericdream.minekea.item.tools;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.beams.GenericBeamBlock;
import com.chimericdream.minekea.util.MinekeaItem;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class WrenchItem extends Item implements MinekeaItem {
    public static final Identifier ITEM_ID = Identifier.of(ModInfo.MOD_ID, "tools/wrench");

    public WrenchItem() {
        super(new Item.Settings().maxCount(1));
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
            .pattern(" # ")
            .pattern(" ##")
            .pattern("#  ")
            .input('#', net.minecraft.item.Items.IRON_INGOT)
            .criterion(FabricRecipeProvider.hasItem(Items.IRON_INGOT),
                FabricRecipeProvider.conditionsFromItem(Items.IRON_INGOT))
            .offerTo(exporter);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Wrench");
    }

    private boolean tryPlacing(BlockPos pos, BlockState state, World world) {
        if (state.canPlaceAt(world, pos)) {
            world.setBlockState(pos, state);
            world.markDirty(pos);

            return true;
        }

        return false;
    }

    private boolean tryFacing(BlockState state, BlockPos pos, World world) {
        if (state.getOrEmpty(Properties.FACING).isPresent()) {
            if (tryPlacing(pos, state.cycle(Properties.FACING), world)) {
                return true;
            }
        }

        if (state.getOrEmpty(Properties.HORIZONTAL_FACING).isPresent()) {
            if (tryPlacing(pos, state.cycle(Properties.HORIZONTAL_FACING), world)) {
                return true;
            }
        }

        if (state.getOrEmpty(Properties.HOPPER_FACING).isPresent()) {
            if (tryPlacing(pos, state.cycle(Properties.HOPPER_FACING), world)) {
                return true;
            }
        }

        return false;
    }

    private boolean tryAxes(BlockState state, BlockPos pos, World world) {
        if (state.getOrEmpty(Properties.AXIS).isPresent()) {
            if (tryPlacing(pos, state.cycle(Properties.AXIS), world)) {
                return true;
            }
        }

        if (state.getOrEmpty(Properties.HORIZONTAL_AXIS).isPresent()) {
            if (tryPlacing(pos, state.cycle(Properties.HORIZONTAL_AXIS), world)) {
                return true;
            }
        }

        return false;
    }

    private boolean trySlab(BlockState state, BlockPos pos, World world) {
        if (state.getBlock() instanceof SlabBlock) {
            BlockState newState = state;

            if (state.get(Properties.SLAB_TYPE).equals(SlabType.DOUBLE)) {
                return false;
            }

            if (state.get(Properties.SLAB_TYPE).equals(SlabType.BOTTOM)) {
                newState = state.with(Properties.SLAB_TYPE, SlabType.TOP);
            } else if (state.get(Properties.SLAB_TYPE).equals(SlabType.TOP)) {
                newState = state.with(Properties.SLAB_TYPE, SlabType.BOTTOM);
            }

            world.setBlockState(pos, newState);
            world.markDirty(pos);

            return true;
        }

        return false;
    }

    private double getPartialCoord(Direction hitSide, double coord) {
        double offset = 0.00001;

        if (hitSide == Direction.EAST || hitSide == Direction.SOUTH || hitSide == Direction.UP) {
            offset = -1 * offset;
        }

        int floor = MathHelper.floor(coord + offset);

        return coord - (double) floor;
    }

    // @TODO: Add "override" versions of the CONNECTED_* properties to allow for more granular control of the beam connections
    private boolean tryBeam(BlockState state, ItemUsageContext context, BlockPos pos, World world) {
        if (state.getBlock() instanceof GenericBeamBlock) {
            Direction hitSide = context.getSide();
            Vec3d hitPos = context.getHitPos();
            BooleanProperty connection = GenericBeamBlock.getConnectionProperty(hitSide);

            double x = getPartialCoord(hitSide, hitPos.x);
            double y = getPartialCoord(hitSide, hitPos.y);
            double z = getPartialCoord(hitSide, hitPos.z);

            double UPPER_ARM_START = 0.687500;
            double LOWER_ARM_END = 0.312500;

            if (x > UPPER_ARM_START) {
                connection = GenericBeamBlock.CONNECTED_EAST;
            } else if (y > UPPER_ARM_START) {
                connection = GenericBeamBlock.CONNECTED_UP;
            } else if (z > UPPER_ARM_START) {
                connection = GenericBeamBlock.CONNECTED_SOUTH;
            } else if (x < LOWER_ARM_END) {
                connection = GenericBeamBlock.CONNECTED_WEST;
            } else if (y < LOWER_ARM_END) {
                connection = GenericBeamBlock.CONNECTED_DOWN;
            } else if (z < LOWER_ARM_END) {
                connection = GenericBeamBlock.CONNECTED_NORTH;
            }

            world.setBlockState(pos, state.with(connection, !state.get(connection)));
            world.markDirty(pos);

            return true;
        }

        return false;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();
        BlockState state = world.getBlockState(pos);

        if (
            context.getPlayer() == null
                || world.isClient()
                || state.getBlock() instanceof ChestBlock
                || state.getBlock() instanceof BedBlock
        ) {
            return ActionResult.PASS;
        }

        if (
            tryFacing(state, pos, world)
                || tryAxes(state, pos, world)
                || trySlab(state, pos, world)
                || tryBeam(state, context, pos, world)
        ) {
            if (!world.isClient()) {
                world.playSound(null, pos, SoundEvents.ITEM_SPYGLASS_USE, SoundCategory.AMBIENT, 2.0F, 1.5F);
            }

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }
}
