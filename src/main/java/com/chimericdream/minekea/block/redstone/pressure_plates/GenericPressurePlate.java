package com.chimericdream.minekea.block.redstone.pressure_plates;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.MinekeaTags;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.JIngredient;
import net.devtech.arrp.json.recipe.JIngredients;
import net.devtech.arrp.json.recipe.JRecipe;
import net.devtech.arrp.json.recipe.JResult;
import net.minecraft.block.AbstractPressurePlateBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.PressurePlateBlock.ActivationRule;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.List;
import java.util.Objects;

import static net.minecraft.block.PressurePlateBlock.ActivationRule.EVERYTHING;

public class GenericPressurePlate extends AbstractPressurePlateBlock implements MinekeaBlock {
    public static final BooleanProperty POWERED;
    private final ActivationRule type;

    static {
        POWERED = Properties.POWERED;
    }

    public GenericPressurePlate(PressurePlateSettings settings) {
        super(settings);

        this.setDefaultState(this.stateManager.getDefaultState().with(POWERED, false));
        this.type = settings.type;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }

    protected void playPressSound(WorldAccess world, BlockPos pos) {
        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;

        // Wool pressure plates are silent
        if (settings.isWool()) {
            return;
        }

        if (this.material != Material.WOOD && this.material != Material.NETHER_WOOD) {
            world.playSound(null, pos, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.6F);
        } else {
            world.playSound(null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON, SoundCategory.BLOCKS, 0.3F, 0.8F);
        }
    }

    protected void playDepressSound(WorldAccess world, BlockPos pos) {
        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;

        // Wool buttons are silent
        if (settings.isWool()) {
            return;
        }

        if (this.material != Material.WOOD && this.material != Material.NETHER_WOOD) {
            world.playSound(null, pos, SoundEvents.BLOCK_STONE_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.5F);
        } else {
            world.playSound(null, pos, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundCategory.BLOCKS, 0.3F, 0.7F);
        }
    }

    protected int getRedstoneOutput(World world, BlockPos pos) {
        Box box = BOX.offset(pos);
        List<?> list;

        switch (this.type) {
            case EVERYTHING:
                list = world.getOtherEntities(null, box);
                break;

            case MOBS:
                list = world.getNonSpectatingEntities(LivingEntity.class, box);
                break;

            default:
                return 0;
        }

        if (!list.isEmpty()) {
            for (Object o : list) {
                Entity entity = (Entity) o;

                if (!entity.canAvoidTraps()) {
                    return 15;
                }
            }
        }

        return 0;
    }

    protected int getRedstoneOutput(BlockState state) {
        return state.get(POWERED) ? 15 : 0;
    }

    protected BlockState setRedstoneOutput(BlockState state, int rsOut) {
        return state.with(POWERED, rsOut > 0);
    }

    @Override
    public Identifier getBlockID() {
        return ((MinekeaBlockSettings<?>) this.settings).getBlockId();
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.REDSTONE)));

        setupResources();
    }

    @Override
    public void setupResources() {
        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
        MinekeaTags.BUTTONS.add(getBlockID(), settings.isWooden());
        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));

        Identifier ingredient = settings.getMaterial("ingredient");
        Identifier texture = settings.getBlockTexture("main");

        Identifier BASE_MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        Identifier PRESSED_MODEL_ID = new Identifier(BASE_MODEL_ID + "_down");

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shapeless(
                JIngredients.ingredients()
                    .add(JIngredient.ingredient().item(ingredient.toString()))
                    .add(JIngredient.ingredient().item(ingredient.toString())),
                JResult.result(getBlockID().toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.getLootTableID(getBlockID()), LootTable.dropSelf(getBlockID()));

        JTextures textures = new JTextures().var("texture", texture.toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/pressure_plate_up").textures(textures),
            BASE_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minecraft:block/pressure_plate_down").textures(textures),
            PRESSED_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(BASE_MODEL_ID.toString()), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("powered=false", new JBlockModel(BASE_MODEL_ID))
                    .put("powered=true", new JBlockModel(PRESSED_MODEL_ID))
            ),
            getBlockID()
        );
    }

    public static class PressurePlateSettings extends MinekeaBlockSettings<PressurePlateSettings> {
        private ActivationRule type = EVERYTHING;

        public PressurePlateSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Pressure Plate");
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sredstone/pressure_plates/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
