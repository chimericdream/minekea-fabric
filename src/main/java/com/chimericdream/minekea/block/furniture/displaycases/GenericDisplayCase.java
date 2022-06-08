package com.chimericdream.minekea.block.furniture.displaycases;

import com.chimericdream.minekea.MinekeaMod;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.entities.blocks.furniture.DisplayCaseBlockEntity;
import com.chimericdream.minekea.item.ItemGroups;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.ImplementedInventory;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Map;

public class GenericDisplayCase extends BlockWithEntity implements MinekeaBlock {
    public static final IntProperty ROTATION = IntProperty.of("rotation", 0, 8);

    private static final VoxelShape MAIN_SHAPE;
    private static final VoxelShape BASEBOARD_SHAPE;

    static {
        MAIN_SHAPE = Block.createCuboidShape(0.0, 2.0, 0.0, 16.0, 16.0, 16.0);
        BASEBOARD_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    }

    public GenericDisplayCase(DisplayCaseSettings settings) {
        super(settings);

        setDefaultState(getStateManager().getDefaultState().with(ROTATION, 0));
    }

    @Override
    public Identifier getBlockID() {
        return ((DisplayCaseSettings) this.settings).getBlockId();
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroups.FURNITURE)));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        setupResources();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ROTATION);
    }

    private int getRotationFromPlayerFacing(float yaw) {
        float absYaw = yaw + 180;

        int rotation = Math.round(absYaw / 45) + 4;

        return MathHelper.clamp(rotation, 0, 7);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }

        DisplayCaseBlockEntity entity;

        try {
            entity = (DisplayCaseBlockEntity) world.getBlockEntity(pos);
            assert entity != null;
        } catch (Exception e) {
            MinekeaMod.LOGGER.error(String.format("The display case at %s had an invalid block entity.\nBlock Entity: %s", pos, world.getBlockEntity(pos)));

            return ActionResult.FAIL;
        }

        if (entity.isEmpty()) {
            // If the player is holding something, put it in the case
            if (!player.getMainHandStack().isEmpty()) {
                ItemStack toInsert = player.getMainHandStack().copy();
                toInsert.setCount(1);

                entity.setStack(0, toInsert);

                player.getMainHandStack().decrement(1);

                world.setBlockState(pos, state.with(ROTATION, getRotationFromPlayerFacing(player.getYaw())));
                entity.markDirty();
                entity.playAddItemSound();
            }
        } else if (player.isSneaking() && player.getMainHandStack().isEmpty()) {
            // If the player is sneaking and not holding anything, get what's in the case
            ItemScatterer.spawn(
                world,
                player.getX(),
                player.getY(),
                player.getZ(),
                entity.removeStack(0)
            );

            world.setBlockState(pos, state.with(ROTATION, 0));
            entity.markDirty();
            entity.playRemoveItemSound();
        } else {
            // If the player isn't sneaking, or if they have an item in their hand, rotate the item in the case
            int rotation = state.get(ROTATION);
            int newRotation = rotation >= 7 ? 0 : rotation + 1;

            world.setBlockState(pos, state.with(ROTATION, newRotation));
            entity.playRotateItemSound();
        }

        world.markDirty(pos);

        return ActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof DisplayCaseBlockEntity) {
                ItemScatterer.spawn(world, pos, (DisplayCaseBlockEntity) blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DisplayCaseBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(MAIN_SHAPE, BASEBOARD_SHAPE);
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        ImplementedInventory displayCase;

        try {
            displayCase = (ImplementedInventory) world.getBlockEntity(pos);
            assert displayCase != null;
        } catch (Exception e) {
            throw new IllegalStateException(String.format("The display case at %s had an invalid block entity.\nBlock Entity: %s", pos, world.getBlockEntity(pos)));
        }

        if (displayCase.isEmpty()) {
            return 0;
        }

        int rotation = state.get(ROTATION);

        return (rotation * 2) + 1;
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.blockRespect(this, String.format("%s Display Case", ((MinekeaBlockSettings<?>) this.settings).getDefaultTranslation()));

        Map<String, Identifier> materials = ((DisplayCaseSettings) this.settings).getMaterials();
        boolean isStripped = ((DisplayCaseSettings) this.settings).isStripped;

        Identifier planks = materials.getOrDefault("planks", materials.get("main"));
        Identifier log = materials.getOrDefault("log", materials.get("main"));
        Identifier stripped_log = materials.getOrDefault("stripped_log", materials.get("main"));

        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern(" G ", "X X", "###"),
                JKeys.keys()
                    .key("G", JIngredient.ingredient().item("minecraft:glass"))
                    .key("#", JIngredient.ingredient().item(planks.toString()))
                    .key("X", JIngredient.ingredient().item(isStripped ? stripped_log.toString() : log.toString())),
                JResult.stackedResult(getBlockID().toString(), 2)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        JTextures textures = new JTextures()
            .var("stripped_material", Texture.getBlockTextureID(stripped_log).toString())
            .var("material", isStripped ? Texture.getBlockTextureID(stripped_log).toString() : Texture.getBlockTextureID(log).toString())
            .var("particle", Texture.getBlockTextureID(stripped_log).toString());

        JModel model = JModel.model("minekea:block/furniture/display_case").textures(textures);

        MinekeaResourcePack.RESOURCE_PACK.addModel(model, MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant(new JBlockModel(MODEL_ID))),
            getBlockID()
        );
    }

    public static class DisplayCaseSettings extends MinekeaBlockSettings<DisplayCaseSettings> {
        protected boolean isStripped = false;

        public DisplayCaseSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public boolean isStripped() {
            return this.isStripped;
        }

        public DisplayCaseSettings stripped() {
            this.isStripped = true;
            return this;
        }

        public DisplayCaseSettings unstripped() {
            this.isStripped = false;
            return this;
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                if (isStripped) {
                    blockId = new Identifier(ModInfo.MOD_ID, String.format("%sfurniture/display_cases/stripped/%s", ModInfo.getModPrefix(modId), mainMaterial));
                } else {
                    blockId = new Identifier(ModInfo.MOD_ID, String.format("%sfurniture/display_cases/%s", ModInfo.getModPrefix(modId), mainMaterial));
                }
            }

            return blockId;
        }
    }
}
