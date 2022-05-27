package com.chimericdream.minekea.block.bookshelves.stairs;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.building.stairs.GenericVerticalStairsBlock;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.Map;

public class GenericVerticalBookshelfStairs extends Block implements MinekeaBlock {
    public static final DirectionProperty FACING;

    private final String modId;
    private final String woodType;
    private final Identifier BLOCK_ID;
    private final Map<String, Identifier> materials;

    static {
        FACING = Properties.HORIZONTAL_FACING;
    }

    public GenericVerticalBookshelfStairs(String woodType, Map<String, Identifier> materials) {
        this(woodType, ModInfo.MOD_ID, materials);
    }

    public GenericVerticalBookshelfStairs(String woodType, String modId, Map<String, Identifier> materials) {
        super(FabricBlockSettings.copyOf(Blocks.OAK_STAIRS).sounds(BlockSoundGroup.WOOD));

        validateMaterials(materials);

        this.modId = modId;
        this.woodType = woodType;
        this.materials = materials;

        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("building/stairs/%s%s_vertical_bookshelf_stairs", ModInfo.getModPrefix(modId), woodType));

        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);

        switch (facing) {
            case EAST:
                return GenericVerticalStairsBlock.EAST_SHAPE;

            case SOUTH:
                return GenericVerticalStairsBlock.SOUTH_SHAPE;

            case WEST:
                return GenericVerticalStairsBlock.WEST_SHAPE;

            case NORTH:
            default:
                return GenericVerticalStairsBlock.NORTH_SHAPE;
        }
    }

    @Override
    public void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"bookshelf", "planks"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        setupResources();
    }

    @Override
    public void setupResources() {
        Identifier shelf = materials.get("bookshelf");
        Identifier planks = materials.get("planks");

        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);

        Identifier MAIN_MODEL_ID = Model.getBlockModelID(BLOCK_ID);

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("###", " ##", "  #"),
                JKeys.keys().key("#", JIngredient.ingredient().item(shelf.toString())),
                JResult.stackedResult(BLOCK_ID.toString(), 8)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        JTextures textures = new JTextures()
            .var("planks", Texture.getBlockTextureID(planks).toString())
            .var("shelf", ModInfo.MOD_ID + ":block/furniture/bookshelves/shelf0");

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/bookshelves/vertical_bookshelf_stairs").textures(textures),
            MAIN_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MAIN_MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("facing=north", new JBlockModel(MAIN_MODEL_ID).uvlock())
                    .put("facing=east", new JBlockModel(MAIN_MODEL_ID).y(90).uvlock())
                    .put("facing=south", new JBlockModel(MAIN_MODEL_ID).y(180).uvlock())
                    .put("facing=west", new JBlockModel(MAIN_MODEL_ID).y(270).uvlock())
            ),
            BLOCK_ID
        );
    }
}
