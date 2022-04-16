package com.chimericdream.minekea.block.shelves;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.Map;

public class GenericShelf extends Block implements MinekeaBlock {
    public static final DirectionProperty WALL_SIDE;

    private final Identifier BLOCK_ID;
    private final String modId;
    private final String woodType;
    private final Map<String, Identifier> materials;

    static {
        WALL_SIDE = DirectionProperty.of("wall_side", Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
    }

    public GenericShelf(String woodType, Map<String, Identifier> materials) {
        this(woodType, ModInfo.MOD_ID, materials);
    }

    public GenericShelf(String woodType, String modId, Map<String, Identifier> materials) {
        super(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).nonOpaque());

        validateMaterials(materials);

        BLOCK_ID = new Identifier(modId, String.format("shelves/%s%s_supported_shelf", ModInfo.getModPrefix(modId), woodType));

        this.modId = modId;
        this.woodType = woodType;
        this.materials = materials;

        this.setDefaultState(this.stateManager.getDefaultState().with(WALL_SIDE, Direction.NORTH));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(WALL_SIDE);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(WALL_SIDE, ctx.getPlayerLookDirection().getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction wall = state.get(WALL_SIDE);

        switch (wall) {
            case EAST:
                return VoxelShapes.union(Block.createCuboidShape(0.0, 7.0, 0.0, 7.0, 9.0, 16.0),
                    Block.createCuboidShape(0.0, 4.0, 0.0, 2.0, 7.0, 1.0),
                    Block.createCuboidShape(2.0, 5.0, 15.0, 4.0, 7.0, 16.0),
                    Block.createCuboidShape(2.0, 5.0, 0.0, 4.0, 7.0, 1.0),
                    Block.createCuboidShape(4.0, 6.0, 0.0, 6.0, 7.0, 1.0),
                    Block.createCuboidShape(4.0, 6.0, 15.0, 6.0, 7.0, 16.0),
                    Block.createCuboidShape(0.0, 4.0, 15.0, 2.0, 7.0, 16.0)
                );

            case SOUTH:
                return VoxelShapes.union(Block.createCuboidShape(0.0, 7.0, 0.0, 16.0, 9.0, 7.0),
                    Block.createCuboidShape(15.0, 4.0, 0.0, 16.0, 7.0, 2.0),
                    Block.createCuboidShape(0.0, 5.0, 2.0, 1.0, 7.0, 4.0),
                    Block.createCuboidShape(15.0, 5.0, 2.0, 16.0, 7.0, 4.0),
                    Block.createCuboidShape(15.0, 6.0, 4.0, 16.0, 7.0, 6.0),
                    Block.createCuboidShape(0.0, 6.0, 4.0, 1.0, 7.0, 6.0),
                    Block.createCuboidShape(0.0, 4.0, 0.0, 1.0, 7.0, 2.0)
                );

            case WEST:
                return VoxelShapes.union(
                    Block.createCuboidShape(9.0, 7.0, 0.0, 16.0, 9.0, 16.0),
                    Block.createCuboidShape(14.0, 4.0, 15.0, 16.0, 7.0, 16.0),
                    Block.createCuboidShape(12.0, 5.0, 0.0, 14.0, 7.0, 1.0),
                    Block.createCuboidShape(12.0, 5.0, 15.0, 14.0, 7.0, 16.0),
                    Block.createCuboidShape(10.0, 6.0, 15.0, 12.0, 7.0, 16.0),
                    Block.createCuboidShape(10.0, 6.0, 0.0, 12.0, 7.0, 1.0),
                    Block.createCuboidShape(14.0, 4.0, 0.0, 16.0, 7.0, 1.0)
                );

            case NORTH:
            default:
                return VoxelShapes.union(
                    Block.createCuboidShape(0.0, 7.0, 9.0, 16.0, 9.0, 16.0),
                    Block.createCuboidShape(0.0, 4.0, 14.0, 1.0, 7.0, 16.0),
                    Block.createCuboidShape(15.0, 5.0, 12.0, 16.0, 7.0, 14.0),
                    Block.createCuboidShape(0.0, 5.0, 12.0, 1.0, 7.0, 14.0),
                    Block.createCuboidShape(0.0, 6.0, 10.0, 1.0, 7.0, 12.0),
                    Block.createCuboidShape(15.0, 6.0, 10.0, 16.0, 7.0, 12.0),
                    Block.createCuboidShape(15.0, 4.0, 14.0, 16.0, 7.0, 16.0)
                );
        }
    }

    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    public void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"slab", "log"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
    }

    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        FuelRegistry.INSTANCE.add(this, 300);
        FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);

        setupResources();
    }

    public void setupResources() {
        Identifier log = materials.get("log");
        Identifier planks = materials.get("planks");
        Identifier slab = materials.get("slab");

        Identifier MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/shelves/%s%s_supported_shelf", ModInfo.getModPrefix(modId), woodType));
        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/shelves/%s%s_supported_shelf", ModInfo.getModPrefix(modId), woodType));

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("XXX", "# #", "X X"),
                JKeys.keys()
                    .key("X", JIngredient.ingredient().item(slab.toString()))
                    .key("#", JIngredient.ingredient().item("minecraft:iron_nugget")),
                JResult.stackedResult(BLOCK_ID.toString(), 3)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel
                .model(ModInfo.MOD_ID + ":block/supported_shelf")
                .textures(
                    new JTextures()
                        .var("planks", Texture.getBlockTextureID(planks).toString())
                        .var("log", Texture.getBlockTextureID(log).toString())
                ),
            MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("wall_side=north", new JBlockModel(MODEL_ID))
                    .put("wall_side=east", new JBlockModel(MODEL_ID).y(90))
                    .put("wall_side=south", new JBlockModel(MODEL_ID).y(180))
                    .put("wall_side=west", new JBlockModel(MODEL_ID).y(270))
            ),
            BLOCK_ID
        );
    }
}
