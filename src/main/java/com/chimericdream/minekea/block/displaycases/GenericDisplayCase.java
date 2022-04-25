package com.chimericdream.minekea.block.displaycases;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.util.ImplementedInventory;
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
import net.minecraft.item.ItemGroup;
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

public class GenericDisplayCase extends BlockWithEntity {
    public static final IntProperty ROTATION = IntProperty.of("rotation", 0, 8);

    private final Identifier BLOCK_ID;
    private final String modId;
    private final String woodType;
    private final Map<String, Identifier> materials;
    private final boolean isStripped;

    private static final VoxelShape MAIN_SHAPE;
    private static final VoxelShape BASEBOARD_SHAPE;

    static {
        MAIN_SHAPE = Block.createCuboidShape(0.0, 2.0, 0.0, 16.0, 16.0, 16.0);
        BASEBOARD_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    }

    public GenericDisplayCase(String woodType, Map<String, Identifier> materials) {
        this(woodType, ModInfo.MOD_ID, materials, false);
    }

    public GenericDisplayCase(String woodType, Map<String, Identifier> materials, boolean isStripped) {
        this(woodType, ModInfo.MOD_ID, materials, isStripped);
    }

    public GenericDisplayCase(String woodType, String modId, Map<String, Identifier> materials) {
        this(woodType, modId, materials, false);
    }

    public GenericDisplayCase(String woodType, String modId, Map<String, Identifier> materials, boolean isStripped) {
        super(Settings.copy(Blocks.OAK_PLANKS).nonOpaque());

        setDefaultState(getStateManager().getDefaultState().with(ROTATION, 0));

        validateMaterials(materials);

        this.isStripped = isStripped;
        this.modId = modId;
        this.woodType = woodType;
        this.materials = materials;

        if (isStripped) {
            BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("displaycases/%sstripped_%s_display_case", ModInfo.getModPrefix(modId), woodType));
        } else {
            BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("displaycases/%s%s_display_case", ModInfo.getModPrefix(modId), woodType));
        }
    }

    protected void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"planks", "log"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
    }

    public void register() {
        register(true);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

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
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        DisplayCaseBlockEntity blockEntity;

        try {
            blockEntity = (DisplayCaseBlockEntity) world.getBlockEntity(pos);
            assert blockEntity != null;
        } catch (Exception e) {
            throw new IllegalStateException(String.format("The display case at %s had an invalid block entity.\nBlock Entity: %s", pos, world.getBlockEntity(pos)));
        }

        if (blockEntity.isEmpty()) {
            // If the player is holding something, put it in the case
            if (!player.getStackInHand(hand).isEmpty()) {
                ItemStack toInsert = player.getStackInHand(hand).copy();
                toInsert.setCount(1);

                blockEntity.setStack(0, toInsert);

                player.getStackInHand(hand).decrement(1);

                world.setBlockState(pos, state.with(ROTATION, getRotationFromPlayerFacing(player.getYaw())));
                blockEntity.markDirty();
                blockEntity.playAddItemSound();
            }
        } else if (player.isSneaking() && player.getStackInHand(hand).isEmpty()) {
            // If the player is sneaking and not holding anything, get what's in the case
            ItemScatterer.spawn(
                world,
                player.getX(),
                player.getY(),
                player.getZ(),
                blockEntity.removeStack(0)
            );

            world.setBlockState(pos, state.with(ROTATION, 0));
            blockEntity.markDirty();
            blockEntity.playRemoveItemSound();
        } else {
            // If the player isn't sneaking, or if they have an item in their hand, rotate the item in the case
            int rotation = state.get(ROTATION);
            int newRotation = rotation >= 7 ? 0 : rotation + 1;

            world.setBlockState(pos, state.with(ROTATION, newRotation));
            blockEntity.playRotateItemSound();
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

    protected void setupResources() {
        Identifier MODEL_ID;
        Identifier ITEM_MODEL_ID;

        if (isStripped) {
            MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/displaycases/%sstripped_%s_display_case", ModInfo.getModPrefix(modId), woodType));
            ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/displaycases/%sstripped_%s_display_case", ModInfo.getModPrefix(modId), woodType));
        } else {
            MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/displaycases/%s%s_display_case", ModInfo.getModPrefix(modId), woodType));
            ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/displaycases/%s%s_display_case", ModInfo.getModPrefix(modId), woodType));
        }

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern(" G ", "X X", "###"),
                JKeys.keys()
                    .key("G", JIngredient.ingredient().item("minecraft:glass"))
                    .key("#", JIngredient.ingredient().item(materials.get("planks").toString()))
                    .key("X", JIngredient.ingredient().item(materials.get("log").toString())),
                JResult.stackedResult(BLOCK_ID.toString(), 2)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        String strippedMat = isStripped
            ? materials.get("log").getNamespace() + ":block/" + materials.get("log").getPath()
            : materials.get("log").getNamespace() + ":block/stripped_" + materials.get("log").getPath();

        JTextures textures = new JTextures()
            .var("stripped_material", strippedMat)
            .var("material", materials.get("log").getNamespace() + ":block/" + materials.get("log").getPath())
            .var("particle", strippedMat);

        JModel model = JModel.model("minekea:block/display_case").textures(textures);

        MinekeaResourcePack.RESOURCE_PACK.addModel(model, MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant(new JBlockModel(MODEL_ID))),
            BLOCK_ID
        );
    }
}
