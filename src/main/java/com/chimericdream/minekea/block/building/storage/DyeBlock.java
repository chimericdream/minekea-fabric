package com.chimericdream.minekea.block.building.storage;

import com.chimericdream.minekea.ModInfo;
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
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Map;

public class DyeBlock extends Block implements MinekeaBlock {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 15.0, 15.0);

    public DyeBlock(DyeBlockSettings settings) {
        super(settings.jumpVelocityMultiplier(0.5F));
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        entity.playSound(SoundEvents.BLOCK_HONEY_BLOCK_SLIDE, 1.0F, 1.0F);
        if (entity.handleFallDamage(fallDistance, 0.2F, DamageSource.FALL)) {
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
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));

        setupResources();
    }

    @Override
    public void setupResources() {
        DyeBlockSettings settings = (DyeBlockSettings) this.settings;
        Map<String, Identifier> materials = settings.getMaterials();

        Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

        MinekeaResourcePack.EN_US.blockRespect(this, String.format("Compressed %s", Registry.ITEM.get(ingredient).getName().getString()));

        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("XXX", "XXX", "XXX"),
                JKeys.keys().key("X", JIngredient.ingredient().item(ingredient.toString())),
                JResult.result(getBlockID().toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            new Identifier(ModInfo.MOD_ID, "storage/" + ingredient.getPath() + "_from_compressed"),
            JRecipe.shapeless(
                JIngredients.ingredients().add(JIngredient.ingredient().item(getBlockID().toString())),
                JResult.stackedResult(ingredient.toString(), 9)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        JTextures textures = new JTextures()
            .var("bottom", String.format("%s:block/storage/dyes/%s/bottom", ModInfo.MOD_ID, settings.getColor()))
            .var("side", String.format("%s:block/storage/dyes/%s/side", ModInfo.MOD_ID, settings.getColor()))
            .var("top", String.format("%s:block/storage/dyes/%s/top", ModInfo.MOD_ID, settings.getColor()));

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(String.format("%s:block/storage/dye_block", ModInfo.MOD_ID)).textures(textures), MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant().put("", new JBlockModel(MODEL_ID))),
            getBlockID()
        );
    }

    public static class DyeBlockSettings extends MinekeaBlockSettings<DyeBlockSettings> {
        protected String color = "";

        public DyeBlockSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public String getColor() {
            return this.color;
        }

        public DyeBlockSettings color(String color) {
            this.color = color;
            return this;
        }

        @Override
        public Identifier getBlockId() {
            Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("storage/dyes/" + ingredient.getPath()));
            }

            return blockId;
        }
    }
}
