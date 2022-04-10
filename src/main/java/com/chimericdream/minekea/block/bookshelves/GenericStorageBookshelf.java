package com.chimericdream.minekea.block.bookshelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import net.devtech.arrp.json.loot.JCondition;
import net.devtech.arrp.json.loot.JEntry;
import net.devtech.arrp.json.loot.JFunction;
import net.devtech.arrp.json.loot.JLootTable;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.JIngredient;
import net.devtech.arrp.json.recipe.JIngredients;
import net.devtech.arrp.json.recipe.JRecipe;
import net.devtech.arrp.json.recipe.JResult;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;

public class GenericStorageBookshelf extends BlockWithEntity {
    public static final Integer ROW_COUNT = 1;

    public static final DirectionProperty FACING;
    public static final IntProperty FILL_LEVEL;
    public static final BooleanProperty OPEN;

    private final Identifier BLOCK_ID;
    private final String woodType;

    static {
        FACING = Properties.FACING;
        FILL_LEVEL = IntProperty.of("fill_level", 0, 4);
        OPEN = Properties.OPEN;
    }

    public GenericStorageBookshelf(String woodType) {
        super(Settings.copy(Blocks.CHEST));

        setDefaultState(getStateManager().getDefaultState().with(FILL_LEVEL, 0).with(FACING, Direction.NORTH).with(OPEN, false));

        this.woodType = woodType;
        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("bookshelves/storage/%s_storage_shelf", woodType));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, FILL_LEVEL, OPEN);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    public void register() {
        this.register(true);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        setupResources();
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, Bookshelves.STORAGE_SHELF_BLOCK_ENTITY, StorageBookshelfBlockEntity::tick);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new StorageBookshelfBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        }

        NamedScreenHandlerFactory screenHandlerFactory = state.createScreenHandlerFactory(world, pos);

        if (screenHandlerFactory != null) {
            player.openHandledScreen(screenHandlerFactory);
            return ActionResult.CONSUME;
        }

        return ActionResult.FAIL;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof StorageBookshelfBlockEntity) {
                ItemScatterer.spawn(world, pos, (StorageBookshelfBlockEntity) blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ScreenHandler.calculateComparatorOutput(world.getBlockEntity(pos));
    }

    public static int getFillLevel(long slots) {
        if (slots == 0) {
            return 0;
        }

        if (slots == 9) {
            return 4;
        }

        if (slots > 7) {
            return 3;
        }

        if (slots > 3) {
            return 2;
        }

        return 1;
    }

    protected void setupResources() {
        String BOOKSHELF;

        if (this.woodType.equals("oak")) {
            BOOKSHELF = "minecraft:bookshelf";
        } else {
            BOOKSHELF = String.format("minekea:bookshelves/%s_bookshelf", woodType);
        }

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shapeless(
                JIngredients.ingredients()
                    .add(JIngredient.ingredient().item("minecraft:chest"))
                    .add(JIngredient.ingredient().item(BOOKSHELF)),
                JResult.result(BLOCK_ID.toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(
            LootTable.blockID(BLOCK_ID),
            JLootTable.loot("minecraft:block")
                .pool(
                    JLootTable.pool()
                        .rolls(1)
                        .entry(
                            new JEntry()
                                .type("minecraft:alternatives")
                                .child(
                                    new JEntry()
                                        .type("minecraft:item")
                                        .name(BLOCK_ID.toString())
                                        .condition(
                                            new JCondition()
                                                .condition("minecraft:match_tool")
                                                .parameter("predicate", LootTable.silkTouchPredicate())
                                        )
                                )
                                .child(
                                    new JEntry()
                                        .type("minecraft:item")
                                        .name("minecraft:book")
                                        .function(
                                            new JFunction("minecraft:set_count")
                                                .parameter("count", 3)
                                                .parameter("add", false)
                                        )
                                        .function(new JFunction("minecraft:explosion_decay"))
                                )
                        )
                        .condition(new JCondition().condition("minecraft:survives_explosion"))
                )
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/cube_column")
                .textures(
                    new JTextures()
                        .var("end", String.format("minecraft:block/%s_planks", woodType))
                        .var("side", String.format("minekea:block/bookshelves/%s/empty_shelf", woodType))
                ),
            new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/empty_shelf", woodType))
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/cube_column")
                .textures(
                    new JTextures()
                        .var("end", String.format("minecraft:block/%s_planks", woodType))
                        .var("side", String.format("minekea:block/bookshelves/%s/one_half_shelf", woodType))
                ),
            new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/one_half_shelf", woodType))
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/cube_column")
                .textures(
                    new JTextures()
                        .var("end", String.format("minecraft:block/%s_planks", woodType))
                        .var("side", String.format("minekea:block/bookshelves/%s/one_quarter_shelf", woodType))
                ),
            new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/one_quarter_shelf", woodType))
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/cube_column")
                .textures(
                    new JTextures()
                        .var("end", String.format("minecraft:block/%s_planks", woodType))
                        .var("side", String.format("minekea:block/bookshelves/%s/three_quarters_shelf", woodType))
                ),
            new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/three_quarters_shelf", woodType))
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(String.format("minekea:block/bookshelves/%s/empty_shelf", woodType)),
            new Identifier(ModInfo.MOD_ID, String.format("item/bookshelves/storage/%s_storage_shelf", woodType))
        );

        // This is bugged in ARRP
        // See: https://github.com/Devan-Kerman/ARRP/issues/62
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(
//                JState.variant()
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf0", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf1", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf2", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf3", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf4", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf5", woodType))))
//                    .put("", new JBlockModel(new Identifier(ModInfo.MOD_ID, String.format("block/bookshelves/%s/shelf6", woodType))))
//            ),
//            BLOCK_ID
//        );
    }
}
