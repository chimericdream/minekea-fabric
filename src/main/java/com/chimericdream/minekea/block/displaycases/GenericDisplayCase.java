package com.chimericdream.minekea.block.displaycases;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.*;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class GenericDisplayCase extends BlockWithEntity {
    public static final BooleanProperty HAS_ITEM = BooleanProperty.of("has_item");
    public static final IntProperty ROTATION = IntProperty.of("rotation", 0, 8);

    private final Item BARRIER_ITEM = Blocks.BARRIER.asItem();
    private final ItemStack BARRIER = BARRIER_ITEM.getDefaultStack();

    private final Identifier BLOCK_ID;
    private final String woodType;
    private final Identifier[] materials;
    private final boolean isStripped;

    private static final VoxelShape MAIN_SHAPE;
    private static final VoxelShape BASEBOARD_SHAPE;

    static {
        MAIN_SHAPE = Block.createCuboidShape(0.0, 2.0, 0.0, 16.0, 16.0, 16.0);
        BASEBOARD_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 2.0, 15.0);
    }

    public GenericDisplayCase(String woodType, Identifier[] materials) {
        this(woodType, materials, false, Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    }

    public GenericDisplayCase(String woodType, Identifier[] materials, boolean isStripped) {
        this(woodType, materials, isStripped, Settings.copy(Blocks.OAK_PLANKS).nonOpaque());
    }

    GenericDisplayCase(String woodType, Identifier[] materials, boolean isStripped, Settings settings) {
        super(settings);

        setDefaultState(getStateManager().getDefaultState().with(HAS_ITEM, false).with(ROTATION, 0));

        this.isStripped = isStripped;
        this.woodType = woodType;
        this.materials = materials;

        if (isStripped) {
            BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("displaycases/stripped_%s_display_case", woodType));
        } else {
            BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("displaycases/%s_display_case", woodType));
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
        builder.add(HAS_ITEM, ROTATION);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult result) {
        if (world.isClient) return ActionResult.SUCCESS;

        Inventory blockEntity = (Inventory) world.getBlockEntity(pos);

        if (player.isInSneakingPose()) {
            // If the player is sneaking, rotate the item (if any) in the case
            boolean hasItem = state.get(HAS_ITEM);

            if (hasItem) {
                int rotation = state.get(ROTATION);
                int newRotation = rotation == 7 ? 0 : rotation + 1;

                world.setBlockState(pos, state.with(ROTATION, newRotation));
            }
        } else {
            if (!player.getStackInHand(hand).isEmpty()) {
                // If the player is holding something, put it in the case
                ItemStack toInsert = player.getStackInHand(hand).copy();
                toInsert.setCount(1);

                if (blockEntity.getStack(0).isOf(BARRIER_ITEM)) {
                    blockEntity.setStack(0, toInsert);
                    player.getStackInHand(hand).decrement(1);
                    world.setBlockState(pos, state.with(HAS_ITEM, true).with(ROTATION, 0));
                    blockEntity.markDirty();
                } else {
                    // System.out.println("The case holds " + blockEntity.getStack(0));
                }
            } else {
                // If the player isn't holding anything or sneaking, get what's in the case
                if (!blockEntity.getStack(0).isOf(BARRIER_ITEM)) {
                    player.getInventory().offerOrDrop(blockEntity.getStack(0));
                    blockEntity.setStack(0, BARRIER);
                    world.setBlockState(pos, state.with(HAS_ITEM, false).with(ROTATION, 8));
                    blockEntity.markDirty();
                }
            }
        }

        world.markDirty(pos);

        return ActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof DisplayCaseBlockEntity && state.get(HAS_ITEM)) {
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

    protected void setupResources() {
        Identifier MODEL_ID;
        Identifier ITEM_MODEL_ID;

        if (isStripped) {
            MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/displaycases/stripped_%s_display_case", woodType));
            ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/displaycases/stripped_%s_display_case", woodType));
        } else {
            MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/displaycases/%s_display_case", woodType));
            ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/displaycases/%s_display_case", woodType));
        }

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern(" G ", "X X", "###"),
                JKeys.keys()
                    .key("G", JIngredient.ingredient().item("minecraft:glass"))
                    .key("X", JIngredient.ingredient().item(materials[0].toString()))
                    .key("#", JIngredient.ingredient().item(materials[1].toString())),
                JResult.stackedResult(BLOCK_ID.toString(), 2)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        String strippedMat = isStripped
            ? materials[1].getNamespace() + ":block/" + materials[1].getPath()
            : materials[1].getNamespace() + ":block/stripped_" + materials[1].getPath();

        JTextures textures = new JTextures()
            .var("0", strippedMat)
            .var("1", "minecraft:block/item_frame")
            .var("2", "minecraft:block/glass")
            .var("5", materials[1].getNamespace() + ":block/" + materials[1].getPath())
            .var("particle", strippedMat);

        JModel model = JModel.model("minecraft:block/cube")
            .textures(textures)
            .element(
                new JElement()
                    .from(1, 0, 1)
                    .to(15, 2, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(1, 14, 15, 16))
                            .east(new JFace("0").uv(1, 14, 15, 16))
                            .south(new JFace("0").uv(1, 14, 15, 16))
                            .west(new JFace("0").uv(1, 14, 15, 16))
                            .up(new JFace("0").uv(0, 0, 0, 0))
                            .down(new JFace("0").uv(1, 1, 15, 15))
                    ),
                new JElement()
                    .from(2, 12, 2)
                    .to(14, 13, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("1").uv(2, 2, 14, 3))
                            .east(new JFace("1").uv(2, 2, 3, 14).rot90())
                            .south(new JFace("1").uv(2, 13, 14, 14))
                            .west(new JFace("1").uv(13, 2, 14, 14).rot90())
                            .up(new JFace("1").uv(2, 2, 14, 14))
                            .down(new JFace("1").uv(2, 2, 14, 14))
                    ),
                new JElement()
                    .from(0, 12, 0)
                    .to(16, 13, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 16, 1))
                            .east(new JFace("0").uv(0, 0, 2, 1))
                            .south(new JFace("0").uv(0, 0, 16, 1))
                            .west(new JFace("0").uv(0, 0, 2, 1))
                            .up(new JFace("0").uv(0, 0, 16, 2))
                            .down(new JFace("0").uv(0, 0, 16, 2))
                    ),
                new JElement()
                    .from(0, 12, 14)
                    .to(16, 13, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 16, 1))
                            .east(new JFace("0").uv(0, 0, 2, 1))
                            .south(new JFace("0").uv(0, 0, 16, 1))
                            .west(new JFace("0").uv(0, 0, 2, 1))
                            .up(new JFace("0").uv(0, 0, 16, 2))
                            .down(new JFace("0").uv(0, 0, 16, 2))
                    ),
                new JElement()
                    .from(0, 12, 2)
                    .to(2, 13, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1))
                            .east(new JFace("0").uv(0, 0, 12, 1))
                            .south(new JFace("0").uv(0, 0, 2, 1))
                            .west(new JFace("0").uv(0, 0, 12, 1))
                            .up(new JFace("0").uv(0, 0, 2, 12))
                            .down(new JFace("0").uv(0, 0, 2, 12))
                    ),
                new JElement()
                    .from(14, 12, 2)
                    .to(16, 13, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1))
                            .east(new JFace("0").uv(0, 0, 12, 1))
                            .south(new JFace("0").uv(0, 0, 2, 1))
                            .west(new JFace("0").uv(0, 0, 12, 1))
                            .up(new JFace("0").uv(0, 0, 2, 12))
                            .down(new JFace("0").uv(0, 0, 2, 12))
                    ),
                new JElement()
                    .from(0, 13, 0)
                    .to(16, 16, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("2").uv(0, 0, 16, 3))
                            .east(new JFace("2").uv(0, 0, 16, 3))
                            .south(new JFace("2").uv(0, 0, 16, 3))
                            .west(new JFace("2").uv(0, 0, 16, 3))
                            .up(new JFace("2").uv(0, 0, 16, 16))
                    ),
                new JElement()
                    .from(14, 2, 14)
                    .to(16, 12, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 10))
                            .east(new JFace("0").uv(0, 0, 2, 10))
                            .south(new JFace("0").uv(0, 0, 2, 10))
                            .west(new JFace("0").uv(0, 0, 2, 10))
                            .up(new JFace("0").uv(0, 0, 2, 2))
                            .down(new JFace("0").uv(0, 0, 2, 2))
                    ),
                new JElement()
                    .from(0, 2, 0)
                    .to(2, 12, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 10))
                            .east(new JFace("0").uv(0, 0, 2, 10))
                            .south(new JFace("0").uv(0, 0, 2, 10))
                            .west(new JFace("0").uv(0, 0, 2, 10))
                            .up(new JFace("0").uv(0, 0, 2, 2))
                            .down(new JFace("0").uv(0, 0, 2, 2))
                    ),
                new JElement()
                    .from(14, 2, 0)
                    .to(16, 12, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 10))
                            .east(new JFace("0").uv(0, 0, 2, 10))
                            .south(new JFace("0").uv(0, 0, 2, 10))
                            .west(new JFace("0").uv(0, 0, 2, 10))
                            .up(new JFace("0").uv(0, 0, 2, 2))
                            .down(new JFace("0").uv(0, 0, 2, 2))
                    ),
                new JElement()
                    .from(0, 2, 14)
                    .to(2, 12, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 10))
                            .east(new JFace("0").uv(0, 0, 2, 10))
                            .south(new JFace("0").uv(0, 0, 2, 10))
                            .west(new JFace("0").uv(0, 0, 2, 10))
                            .up(new JFace("0").uv(0, 0, 2, 2))
                            .down(new JFace("0").uv(0, 0, 2, 2))
                    ),
                new JElement()
                    .from(0, 2, 2)
                    .to(2, 4, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 2))
                            .east(new JFace("0").uv(0, 0, 12, 2))
                            .south(new JFace("0").uv(0, 0, 2, 2))
                            .west(new JFace("0").uv(0, 0, 12, 2))
                            .up(new JFace("0").uv(0, 0, 2, 12))
                            .down(new JFace("0").uv(0, 0, 2, 12))
                    ),
                new JElement()
                    .from(2, 2, 0)
                    .to(14, 4, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 12, 2))
                            .east(new JFace("0").uv(0, 0, 2, 2))
                            .south(new JFace("0").uv(0, 0, 12, 2))
                            .west(new JFace("0").uv(0, 0, 2, 2))
                            .up(new JFace("0").uv(0, 0, 12, 2))
                            .down(new JFace("0").uv(0, 0, 12, 2))
                    ),
                new JElement()
                    .from(2, 2, 14)
                    .to(14, 4, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 12, 2))
                            .east(new JFace("0").uv(0, 0, 2, 2))
                            .south(new JFace("0").uv(0, 0, 12, 2))
                            .west(new JFace("0").uv(0, 0, 2, 2))
                            .up(new JFace("0").uv(0, 0, 12, 2))
                            .down(new JFace("0").uv(0, 0, 12, 2))
                    ),
                new JElement()
                    .from(14, 2, 2)
                    .to(16, 4, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 2))
                            .east(new JFace("0").uv(0, 0, 12, 2))
                            .south(new JFace("0").uv(0, 0, 2, 2))
                            .west(new JFace("0").uv(0, 0, 12, 2))
                            .up(new JFace("0").uv(0, 0, 2, 12))
                            .down(new JFace("0").uv(0, 0, 2, 12))
                    ),
                new JElement()
                    .from(0, 11, 2)
                    .to(2, 12, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1))
                            .east(new JFace("0").uv(0, 0, 12, 1))
                            .south(new JFace("0").uv(0, 0, 2, 1))
                            .west(new JFace("0").uv(0, 0, 12, 1))
                            .up(new JFace("0").uv(0, 0, 2, 12))
                            .down(new JFace("0").uv(0, 0, 2, 12))
                    ),
                new JElement()
                    .from(2, 11, 0)
                    .to(14, 12, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 12, 1))
                            .east(new JFace("0").uv(0, 0, 2, 1))
                            .south(new JFace("0").uv(0, 0, 12, 1))
                            .west(new JFace("0").uv(0, 0, 2, 1))
                            .up(new JFace("0").uv(0, 0, 12, 2))
                            .down(new JFace("0").uv(0, 0, 12, 2))
                    ),
                new JElement()
                    .from(14, 11, 2)
                    .to(16, 12, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 2, 1))
                            .east(new JFace("0").uv(0, 0, 12, 1))
                            .south(new JFace("0").uv(0, 0, 2, 1))
                            .west(new JFace("0").uv(0, 0, 12, 1))
                            .up(new JFace("0").uv(0, 0, 2, 12))
                            .down(new JFace("0").uv(0, 0, 2, 12))
                    ),
                new JElement()
                    .from(2, 11, 14)
                    .to(14, 12, 16)
                    .faces(
                        new JFaces()
                            .north(new JFace("0").uv(0, 0, 12, 1))
                            .east(new JFace("0").uv(0, 0, 2, 1))
                            .south(new JFace("0").uv(0, 0, 12, 1))
                            .west(new JFace("0").uv(0, 0, 2, 1))
                            .up(new JFace("0").uv(0, 0, 12, 2))
                            .down(new JFace("0").uv(0, 0, 12, 2))
                    ),
                new JElement()
                    .from(2, 4, 1)
                    .to(14, 11, 2)
                    .faces(
                        new JFaces()
                            .north(new JFace("5").uv(0, 0, 12, 7))
                            .east(new JFace("5").uv(0, 0, 1, 7))
                            .south(new JFace("5").uv(0, 0, 12, 7))
                            .west(new JFace("5").uv(0, 0, 1, 7))
                            .up(new JFace("5").uv(0, 0, 12, 1))
                            .down(new JFace("5").uv(0, 0, 12, 1))
                    ),
                new JElement()
                    .from(1, 4, 2)
                    .to(2, 11, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("5").uv(0, 0, 1, 7))
                            .east(new JFace("5").uv(0, 0, 12, 7))
                            .south(new JFace("5").uv(0, 0, 1, 7))
                            .west(new JFace("5").uv(0, 0, 12, 7))
                            .up(new JFace("5").uv(0, 0, 1, 12))
                            .down(new JFace("5").uv(0, 0, 1, 12))
                    ),
                new JElement()
                    .from(2, 4, 14)
                    .to(14, 11, 15)
                    .faces(
                        new JFaces()
                            .north(new JFace("5").uv(0, 0, 12, 7))
                            .east(new JFace("5").uv(0, 0, 1, 7))
                            .south(new JFace("5").uv(0, 0, 12, 7))
                            .west(new JFace("5").uv(0, 0, 1, 7))
                            .up(new JFace("5").uv(0, 0, 12, 1))
                            .down(new JFace("5").uv(0, 0, 12, 1))
                    ),
                new JElement()
                    .from(14, 4, 2)
                    .to(15, 11, 14)
                    .faces(
                        new JFaces()
                            .north(new JFace("5").uv(0, 0, 1, 7))
                            .east(new JFace("5").uv(0, 0, 12, 7))
                            .south(new JFace("5").uv(0, 0, 1, 7))
                            .west(new JFace("5").uv(0, 0, 12, 7))
                            .up(new JFace("5").uv(0, 0, 1, 12))
                            .down(new JFace("5").uv(0, 0, 1, 12))
                    )
            );

        MinekeaResourcePack.RESOURCE_PACK.addModel(model, MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant(new JBlockModel(MODEL_ID))),
            BLOCK_ID
        );
    }
}
