package com.chimericdream.minekea.block.tables;

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
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import java.util.Map;

public class GenericTable extends Block implements MinekeaBlock {
    private final Identifier BLOCK_ID;
    private final String modId;
    private final String woodType;
    private final Map<String, Identifier> materials;

    private static final VoxelShape TABLE_SURFACE_SHAPE;
    private static final VoxelShape[] LEG_SHAPES;

    static {
        TABLE_SURFACE_SHAPE = Block.createCuboidShape(0.0, 14.0, 0.0, 16.0, 16.0, 16.0);
        LEG_SHAPES = new VoxelShape[]{
            Block.createCuboidShape(0.0, 0.0, 0.0, 2.0, 14.0, 2.0),
            Block.createCuboidShape(14.0, 0.0, 0.0, 16.0, 14.0, 2.0),
            Block.createCuboidShape(14.0, 0.0, 14.0, 16.0, 14.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 14.0, 2.0, 14.0, 16.0)
        };
    }

    public GenericTable(String woodType, Map<String, Identifier> materials) {
        this(woodType, ModInfo.MOD_ID, materials);
    }

    public GenericTable(String woodType, String modId, Map<String, Identifier> materials) {
        super(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(3.0F, 4.0F));

        validateMaterials(materials);

        this.modId = modId;
        this.materials = materials;
        this.woodType = woodType;

        BLOCK_ID = new Identifier(ModInfo.MOD_ID, String.format("tables/%s%s_table", ModInfo.getModPrefix(modId), woodType));
    }

    @Override
    public void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"planks", "log"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
    }

    @Override
    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(TABLE_SURFACE_SHAPE, LEG_SHAPES);
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        FuelRegistry.INSTANCE.add(this, 300);
        FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);

        setupResources();
    }

    @Override
    public void setupResources() {
        Identifier MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/tables/%s%s_table", ModInfo.getModPrefix(modId), woodType));
        Identifier ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/tables/%s%s_table", ModInfo.getModPrefix(modId), woodType));

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("XXX", "# #", "# #"),
                JKeys.keys()
                    .key("X", JIngredient.ingredient().item(materials.get("planks").toString()))
                    .key("#", JIngredient.ingredient().item(materials.get("log").toString())),
                JResult.stackedResult(BLOCK_ID.toString(), 3)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        JTextures textures = new JTextures()
            .var("log", Texture.getBlockTextureID(materials.get("log")).toString())
            .var("planks", Texture.getBlockTextureID(materials.get("planks")).toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model("minekea:block/table").textures(textures), MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant().put("", new JBlockModel(MODEL_ID))),
            BLOCK_ID
        );
    }
}
