package com.chimericdream.minekea.crops;

import com.chimericdream.lib.blocks.BlockDataGenerator;
import com.chimericdream.lib.blocks.RegisterableBlock;
import com.chimericdream.lib.fabric.blocks.FabricBlockDataGenerator;
import com.chimericdream.minekea.ModInfo;
import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.PlantBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

import static com.chimericdream.minekea.crops.Crops.WARPED_WART_ITEM;

public class WarpedWartPlantBlock extends PlantBlock implements BlockDataGenerator, FabricBlockDataGenerator, RegisterableBlock {
    public static final MapCodec<WarpedWartPlantBlock> CODEC = createCodec(_unused -> new WarpedWartPlantBlock());

    public static final Identifier BLOCK_ID = Identifier.of(ModInfo.MOD_ID, "crops/warped_wart/block");
    public static final IntProperty AGE;
    private static final VoxelShape[] AGE_TO_SHAPE;

    public WarpedWartPlantBlock() {
        super(AbstractBlock.Settings.copy(Blocks.NETHER_WART).mapColor(MapColor.BRIGHT_TEAL));

        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    public MapCodec<WarpedWartPlantBlock> getCodec() {
        return CODEC;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return AGE_TO_SHAPE[state.get(AGE)];
    }

    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(Blocks.SOUL_SAND);
    }

    public boolean hasRandomTicks(BlockState state) {
        return state.get(AGE) < 3;
    }

    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        int i = state.get(AGE);
        if (i < 3 && random.nextInt(10) == 0) {
            state = state.with(AGE, i + 1);
            world.setBlockState(pos, state, 2);
        }
    }

    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
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

    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
    }

    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        RegistryWrapper.Impl<Enchantment> impl = registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);

        generator.addDrop(
            this,
            block -> LootTable.builder()
                .pool(
                    generator.applyExplosionDecay(
                        block,
                        LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(1.0F))
                            .with(
                                ItemEntry.builder(WARPED_WART_ITEM)
                                    .apply(
                                        SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 4.0F))
                                            .conditionally(
                                                BlockStatePropertyLootCondition
                                                    .builder(block)
                                                    .properties(StatePredicate.Builder.create().exactMatch(WarpedWartPlantBlock.AGE, 3))
                                            )
                                    )
                                    .apply(
                                        ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))
                                            .conditionally(
                                                BlockStatePropertyLootCondition
                                                    .builder(block)
                                                    .properties(StatePredicate.Builder.create().exactMatch(WarpedWartPlantBlock.AGE, 3))
                                            )
                                    )
                            )
                    )
                )
        );
    }

    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, "Warped Wart");
    }

    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(this, Properties.AGE_3, 0, 1, 1, 2);
    }
}
