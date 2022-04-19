package com.chimericdream.minekea.block.jars;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.recipe.*;
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

public class GlassJarBlock extends Block implements MinekeaBlock {
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
        Identifier MODEL_ID;
        Identifier ITEM_MODEL_ID;

        MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("block/jars/%sglass_jar", ModInfo.getModPrefix(modId)));
        ITEM_MODEL_ID = new Identifier(ModInfo.MOD_ID, String.format("item/jars/%sglass_jar", ModInfo.getModPrefix(modId)));

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

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        JModel model = JModel.model("minekea:block/glass_jar2");

        MinekeaResourcePack.RESOURCE_PACK.addModel(model, MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant(new JBlockModel(MODEL_ID))),
            BLOCK_ID
        );
    }
}
