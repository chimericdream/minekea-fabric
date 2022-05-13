package com.chimericdream.minekea.crops;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.minecraft.block.*;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

import java.util.Random;

public class WarpedWartBlock extends PlantBlock implements MinekeaBlock {
    public static final Identifier BLOCK_ID = new Identifier(ModInfo.MOD_ID, "crops/warped_wart_block");
    public static final IntProperty AGE;
    private static final VoxelShape[] AGE_TO_SHAPE;

    protected WarpedWartBlock() {
        super(Settings.of(Material.PLANT, MapColor.BRIGHT_TEAL).noCollision().ticksRandomly().sounds(BlockSoundGroup.NETHER_WART));

        this.setDefaultState((BlockState) ((BlockState) this.stateManager.getDefaultState()).with(AGE, 0));
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[(Integer) state.get(AGE)];
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.SOUL_SAND);
    }

    public boolean hasRandomTicks(BlockState state) {
        return (Integer) state.get(AGE) < 3;
    }

    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = (Integer) state.get(AGE);
        if (i < 3 && random.nextInt(10) == 0) {
            state = (BlockState) state.with(AGE, i + 1);
            world.setBlockState(pos, state, 2);
        }

    }

    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return new ItemStack(Crops.WARPED_WART_ITEM);
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    static {
        AGE = Properties.AGE_3;
        AGE_TO_SHAPE = new VoxelShape[]{
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 5.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 8.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 11.0, 16.0),
            Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 14.0, 16.0)
        };
    }

    @Override
    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        setupResources();
    }

    @Override
    public void setupResources() {
        Identifier BASE_MODEL_ID = Model.getBlockModelID(BLOCK_ID);
        Identifier STAGE0_MODEL_ID = new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_stage0");
        Identifier STAGE1_MODEL_ID = new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_stage1");
        Identifier STAGE2_MODEL_ID = new Identifier(BASE_MODEL_ID.getNamespace(), BASE_MODEL_ID.getPath() + "_stage2");

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/crop")
                .textures(new JTextures().var("crop", "minekea:block/crops/warped_wart_stage0")),
            STAGE0_MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/crop")
                .textures(new JTextures().var("crop", "minekea:block/crops/warped_wart_stage1")),
            STAGE1_MODEL_ID
        );
        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/crop")
                .textures(new JTextures().var("crop", "minekea:block/crops/warped_wart_stage2")),
            STAGE2_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("age=0", new JBlockModel(STAGE0_MODEL_ID))
                    .put("age=1", new JBlockModel(STAGE1_MODEL_ID))
                    .put("age=2", new JBlockModel(STAGE1_MODEL_ID))
                    .put("age=3", new JBlockModel(STAGE2_MODEL_ID))
            ),
            BLOCK_ID
        );
    }
}
