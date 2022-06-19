package com.chimericdream.minekea.block.furniture.pillows;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.item.ItemGroups;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Map;
import java.util.Objects;

public class PillowBlock extends Block implements MinekeaBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 15.0, 15.0);

    public PillowBlock(PillowBlockSettings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.playSound(SoundEvents.BLOCK_WOOL_STEP, 1.0F, 1.0F);
        if (entity.handleFallDamage(fallDistance, 0F, DamageSource.FALL)) {
            entity.playSound(this.soundGroup.getFallSound(), this.soundGroup.getVolume() * 0.5F, this.soundGroup.getPitch() * 0.75F);
        }
    }

    @Override
    public Identifier getBlockID() {
        return ((MinekeaBlockSettings<?>) this.settings).getBlockId();
    }

    @Override
    public void register() {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroups.FURNITURE)));

        setupResources();
    }

    @Override
    public void setupResources() {
        PillowBlockSettings settings = (PillowBlockSettings) this.settings;
        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getColor()));

        Map<String, Identifier> materials = settings.getMaterials();

        Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("XX", "XX"),
                JKeys.keys().key("X", JIngredient.ingredient().item(ingredient.toString())),
                JResult.result(getBlockID().toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            new Identifier(ModInfo.MOD_ID, "furniture/pillows/" + ingredient.getPath() + "_reverse"),
            JRecipe.shapeless(
                JIngredients.ingredients().add(JIngredient.ingredient().item(getBlockID().toString())),
                JResult.stackedResult(ingredient.toString(), 4)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        JTextures textures = new JTextures()
            .var("all", String.format("%s:block/furniture/pillows/%s_opt2", ModInfo.MOD_ID, settings.getColor()));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model("minecraft:block/cube_all").textures(textures), MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant().put("", new JBlockModel(MODEL_ID))),
            getBlockID()
        );
    }

    public static class PillowBlockSettings extends MinekeaBlockSettings<PillowBlockSettings> {
        protected String color = "";

        public PillowBlockSettings(DefaultSettings settings) {
            super(settings);
        }

        public String getColor() {
            return this.color;
        }

        public PillowBlockSettings color(String color) {
            this.color = color;
            return this;
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Pillow");
        }

        @Override
        public Identifier getBlockId() {
            Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("furniture/pillows/" + ingredient.getPath()));
            }

            return blockId;
        }
    }
}
