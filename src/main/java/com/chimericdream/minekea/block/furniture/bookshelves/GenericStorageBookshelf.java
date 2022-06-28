package com.chimericdream.minekea.block.furniture.bookshelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.entities.blocks.StorageBookshelfBlockEntity;
import com.chimericdream.minekea.item.ItemGroups;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.MinekeaTags;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
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
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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

import java.util.Objects;

public class GenericStorageBookshelf extends BlockWithEntity implements MinekeaBlock {
    public static final Integer ROW_COUNT = 1;

    public static final DirectionProperty FACING;
    public static final IntProperty FILL_LEVEL;
    public static final BooleanProperty OPEN;

    static {
        FACING = Properties.FACING;
        FILL_LEVEL = IntProperty.of("fill_level", 0, 4);
        OPEN = Properties.OPEN;
    }

    public GenericStorageBookshelf(StorageBookshelfSettings settings) {
        super(settings);

        setDefaultState(getStateManager().getDefaultState().with(FILL_LEVEL, 0).with(FACING, Direction.NORTH).with(OPEN, false));
    }

    @Override
    public Identifier getBlockID() {
        return ((StorageBookshelfSettings) this.settings).getBlockId();
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
        builder.add(FACING, FILL_LEVEL, OPEN);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, StorageBookshelves.STORAGE_SHELF_BLOCK_ENTITY, StorageBookshelfBlockEntity::tick);
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

    @Override
    public void setupResources() {
        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
        MinekeaTags.BOOKSHELVES.add(getBlockID(), settings.isWooden());
        MinekeaTags.STORAGE_BOOKSHELVES.add(getBlockID(), settings.isWooden());
        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));

        Identifier shelf = settings.getMaterial("bookshelf");

        Identifier BASE_MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        Identifier EMPTY_SHELF_MODEL_ID = new Identifier(BASE_MODEL_ID + "_empty");
        Identifier ONE_HALF_SHELF_MODEL_ID = new Identifier(BASE_MODEL_ID + "_one_half");
        Identifier ONE_QUARTER_SHELF_MODEL_ID = new Identifier(BASE_MODEL_ID + "_one_quarter");
        Identifier THREE_QUARTERS_SHELF_MODEL_ID = new Identifier(BASE_MODEL_ID + "_three_quarters");
        Identifier FULL_SHELF_MODEL_ID = ((StorageBookshelfSettings) settings).getBaseShelfBlockId();

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shapeless(
                JIngredients.ingredients()
                    .add(JIngredient.ingredient().item("minecraft:chest"))
                    .add(JIngredient.ingredient().item(shelf.toString())),
                JResult.result(getBlockID().toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(
            LootTable.blockID(getBlockID()),
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
                                        .name(getBlockID().toString())
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

        String sideTexture = settings.getBlockTexture("side_texture", "planks").toString();

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/furniture/bookshelves/bookshelf")
                .textures(
                    new JTextures()
                        .var("material", sideTexture)
                        .var("shelf", "minekea:block/furniture/bookshelves/empty-shelf")
                ),
            EMPTY_SHELF_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/furniture/bookshelves/bookshelf")
                .textures(
                    new JTextures()
                        .var("material", sideTexture)
                        .var("shelf", "minekea:block/furniture/bookshelves/one-half-shelf")
                ),
            ONE_HALF_SHELF_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/furniture/bookshelves/bookshelf")
                .textures(
                    new JTextures()
                        .var("material", sideTexture)
                        .var("shelf", "minekea:block/furniture/bookshelves/one-quarter-shelf")
                ),
            ONE_QUARTER_SHELF_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/furniture/bookshelves/bookshelf")
                .textures(
                    new JTextures()
                        .var("material", sideTexture)
                        .var("shelf", "minekea:block/furniture/bookshelves/three-quarters-shelf")
                ),
            THREE_QUARTERS_SHELF_MODEL_ID
        );

        /*
         * This will double-register some models, but that's fine. This ensures that we always have the models we need.
         * For example, the BYG mod already provides variant bookshelves, so Minekea doesn't register any of those items
         * for it. However, that means we won't have the `shelf0` model we expect/need.
         */
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/furniture/bookshelves/bookshelf")
                .textures(
                    new JTextures()
                        .var("material", sideTexture)
                        .var("shelf", "minekea:block/furniture/bookshelves/shelf0")
                ),
            FULL_SHELF_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(EMPTY_SHELF_MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("fill_level=0", new JBlockModel(EMPTY_SHELF_MODEL_ID))
                    .put("fill_level=1", new JBlockModel(ONE_QUARTER_SHELF_MODEL_ID))
                    .put("fill_level=2", new JBlockModel(ONE_HALF_SHELF_MODEL_ID))
                    .put("fill_level=3", new JBlockModel(THREE_QUARTERS_SHELF_MODEL_ID))
                    .put("fill_level=4", new JBlockModel(FULL_SHELF_MODEL_ID))
            ),
            getBlockID()
        );
    }

    public static class StorageBookshelfSettings extends MinekeaBlockSettings<StorageBookshelfSettings> {
        public StorageBookshelfSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Storage Bookshelf");
        }

        public Identifier getBaseShelfBlockId() {
            return new Identifier(ModInfo.MOD_ID, String.format("%sfurniture/bookshelves/%s", ModInfo.getModPrefix(modId), mainMaterial));
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sfurniture/bookshelves/storage/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
