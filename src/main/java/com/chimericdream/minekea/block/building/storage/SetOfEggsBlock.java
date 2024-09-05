//package com.chimericdream.minekea.block.building.storage;
//
//import com.chimericdream.minekea.ModInfo;
//import com.chimericdream.minekea.resource.LootTable;
//import com.chimericdream.minekea.resource.MinekeaResourcePack;
//import com.chimericdream.minekea.resource.Model;
//import com.chimericdream.minekea.sound.MinekeaSoundGroup;
//import com.chimericdream.minekea.util.MinekeaBlock;
//import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
//import net.minecraft.block.Block;
//import net.minecraft.block.BlockState;
//import net.minecraft.block.Blocks;
//import net.minecraft.block.ShapeContext;
//import net.minecraft.block.Waterloggable;
//import net.minecraft.fluid.FluidState;
//import net.minecraft.fluid.Fluids;
//import net.minecraft.item.BlockItem;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemGroup;
//import net.minecraft.item.ItemPlacementContext;
//import net.minecraft.registry.Registries;
//import net.minecraft.registry.Registry;
//import net.minecraft.state.StateManager;
//import net.minecraft.state.property.BooleanProperty;
//import net.minecraft.state.property.Properties;
//import net.minecraft.util.Identifier;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.Direction;
//import net.minecraft.util.shape.VoxelShape;
//import net.minecraft.util.shape.VoxelShapes;
//import net.minecraft.world.BlockView;
//import net.minecraft.world.WorldAccess;
//
//public class SetOfEggsBlock extends Block implements MinekeaBlock, Waterloggable {
//    public static final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "storage/set_of_eggs");
//
//    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
//
//    public SetOfEggsBlock() {
//        super(FabricBlockSettings.copyOf(Blocks.NETHER_WART_BLOCK).sounds(MinekeaSoundGroup.SET_OF_EGGS_SOUND_GROUP));
//
//        this.setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false));
//    }
//
//    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(WATERLOGGED);
//    }
//
//    public BlockState getPlacementState(ItemPlacementContext ctx) {
//        return (BlockState) this.getDefaultState()
//            .with(WATERLOGGED, ctx.getWorld().getFluidState(ctx.getBlockPos()).getFluid() == Fluids.WATER);
//    }
//
//    @Override
//    public FluidState getFluidState(BlockState state) {
//        return state.get(WATERLOGGED) ? Fluids.WATER.getStill(false) : super.getFluidState(state);
//    }
//
//    @Override
//    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
//        if (state.get(WATERLOGGED)) {
//            world.createAndScheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
//        }
//
//        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
//    }
//
//    @Override
//    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
//        return VoxelShapes.union(
//            Block.createCuboidShape(0.0, 1.0, 0.0, 16.0, 2.0, 16.0),
//            Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0),
//            Block.createCuboidShape(0.0, 9.0, 0.0, 16.0, 10.0, 16.0)
//        );
//    }
//
//    @Override
//    public Identifier getBlockID() {
//        return BLOCK_ID;
//    }
//
//    @Override
//    public void register() {
//        Registry.register(Registries.BLOCK, BLOCK_ID, this);
//        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
//
//        setupResources();
//    }
//
//    @Override
//    public void setupResources() {
//        MinekeaResourcePack.EN_US.blockRespect(this, "Set of Eggs");
//
//        Identifier MODEL_ID = Model.getBlockModelID(BLOCK_ID);
//
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            BLOCK_ID,
//            JRecipe.shaped(
//                JPattern.pattern("###", "###", "###"),
//                JKeys.keys().key("#", JIngredient.ingredient().item("minecraft:egg")),
//                JResult.result(BLOCK_ID.toString())
//            )
//        );
//        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
//            Identifier.of(BLOCK_ID.getNamespace(), BLOCK_ID.getPath() + "_reverse"),
//            JRecipe.stonecutting(
//                JIngredient.ingredient().item(BLOCK_ID.toString()),
//                JResult.stackedResult("minecraft:egg", 9)
//            )
//        );
//
//        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));
//
//        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//            JState.state(JState.variant().put("", new JBlockModel(MODEL_ID))),
//            BLOCK_ID
//        );
//    }
//}
