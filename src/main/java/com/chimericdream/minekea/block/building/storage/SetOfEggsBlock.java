package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
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

public class SetOfEggsBlock extends Block implements MinekeaBlock {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "storage/set_of_eggs");

    public SetOfEggsBlock() {
        super(FabricBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(
            Block.createCuboidShape(0.0, 1.0, 0.0, 16.0, 2.0, 16.0),
            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0),
            Block.createCuboidShape(0.0, 9.0, 0.0, 16.0, 10.0, 16.0)
        );
    }

    @Override
    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        setupResources();
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.blockRespect(this, "Set of Eggs");

        Identifier MODEL_ID = Model.getBlockModelID(BLOCK_ID);

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("###", "###", "###"),
                JKeys.keys().key("#", JIngredient.ingredient().item("minecraft:egg")),
                JResult.result(BLOCK_ID.toString())
            )
        );
        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            new Identifier(BLOCK_ID.getNamespace(), BLOCK_ID.getPath() + "_reverse"),
            JRecipe.stonecutting(
                JIngredient.ingredient().item(BLOCK_ID.toString()),
                JResult.stackedResult("minecraft:egg", 9)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant().put("", new JBlockModel(MODEL_ID))),
            BLOCK_ID
        );
    }
}
