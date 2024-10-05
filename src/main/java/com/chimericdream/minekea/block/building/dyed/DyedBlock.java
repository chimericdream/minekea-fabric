package com.chimericdream.minekea.block.building.dyed;

import com.chimericdream.lib.colors.ColorHelpers;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.item.MinekeaItemGroups;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class DyedBlock extends Block implements MinekeaBlock {
    public static final EnumProperty<Direction.Axis> AXIS;

    static {
        AXIS = Properties.AXIS;
    }

    public final Identifier BLOCK_ID;
    protected final Identifier PARENT_BLOCK_ID;

    protected final String materialName;
    protected final String textureKey;
    protected final DyeColor color;
    protected final Block baseBlock;

    public DyedBlock(DyeColor color, String materialName, String textureKey, Block baseBlock) {
        this(AbstractBlock.Settings.copy(baseBlock), color, materialName, textureKey, baseBlock);
    }

    public DyedBlock(
        AbstractBlock.Settings settings,
        DyeColor color,
        String materialName,
        String textureKey,
        Block baseBlock
    ) {
        super(settings.mapColor(color));

        this.color = color;
        this.materialName = materialName;
        this.textureKey = textureKey;
        this.baseBlock = baseBlock;

        BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/dyed/%s/%s", Registries.BLOCK.getId(baseBlock).getPath(), color));

        PARENT_BLOCK_ID = Registries.BLOCK.getId(baseBlock);

        this.setDefaultState(this.stateManager.getDefaultState().with(AXIS, Direction.Axis.Y));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AXIS);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(AXIS, ctx.getSide().getAxis());
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        PotionContentsComponent potionContentsComponent = (PotionContentsComponent) stack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
        BlockState blockState = world.getBlockState(pos);
        if (hit.getSide() != Direction.DOWN && potionContentsComponent.matches(Potions.WATER)) {
            world.playSound((PlayerEntity) null, pos, SoundEvents.ENTITY_GENERIC_SPLASH, SoundCategory.BLOCKS, 1.0F, 1.0F);
            player.setStackInHand(hand, ItemUsage.exchangeStack(stack, player, new ItemStack(Items.GLASS_BOTTLE)));
            player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));

            if (!world.isClient) {
                ServerWorld serverWorld = (ServerWorld) world;

                for (int i = 0; i < 5; ++i) {
                    serverWorld.spawnParticles(ParticleTypes.SPLASH, (double) pos.getX() + world.random.nextDouble(), (double) (pos.getY() + 1), (double) pos.getZ() + world.random.nextDouble(), 1, 0.0, 0.0, 0.0, 1.0);
                }
            }

            world.playSound((PlayerEntity) null, pos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.emitGameEvent((Entity) null, GameEvent.FLUID_PLACE, pos);
            world.setBlockState(pos, this.baseBlock.getDefaultState());
            return ItemActionResult.success(world.isClient);
        } else {
            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
    }

    @Override
    public void register() {
        Registry.register(Registries.BLOCK, BLOCK_ID, this);
        Registry.register(Registries.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings()));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COLORED_BLOCKS)
            .register((itemGroup) -> itemGroup.add(this));

        ItemGroupEvents.modifyEntriesEvent(MinekeaItemGroups.DYED_BLOCK_ITEM_GROUP_KEY)
            .register((itemGroup) -> itemGroup.add(this));
    }

    @Override
    public void configureRecipes(RecipeExporter exporter) {
        Block parentBlock = Registries.BLOCK.get(PARENT_BLOCK_ID);
        Item dye = ColorHelpers.getDye(color);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, this, 8)
            .pattern("###")
            .pattern("#D#")
            .pattern("###")
            .input('#', parentBlock)
            .input('D', dye)
            .criterion(FabricRecipeProvider.hasItem(parentBlock),
                FabricRecipeProvider.conditionsFromItem(parentBlock))
            .criterion(FabricRecipeProvider.hasItem(dye),
                FabricRecipeProvider.conditionsFromItem(dye))
            .offerTo(exporter);
    }

    @Override
    public void configureBlockLootTables(RegistryWrapper.WrapperLookup registryLookup, BlockLootTableGenerator generator) {
        generator.addDrop(this);
    }

    @Override
    public void configureTranslations(RegistryWrapper.WrapperLookup registryLookup, FabricLanguageProvider.TranslationBuilder translationBuilder) {
        translationBuilder.add(this, String.format("%s Dyed %s", ColorHelpers.getName(color), materialName));
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(this);
    }
}
