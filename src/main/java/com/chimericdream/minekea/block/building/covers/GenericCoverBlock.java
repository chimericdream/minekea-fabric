package com.chimericdream.minekea.block.building.covers;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
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
import net.minecraft.block.CarpetBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

import java.util.Map;

public class GenericCoverBlock extends CarpetBlock implements MinekeaBlock {
    public static final DirectionProperty FACING;

    private final Identifier BLOCK_ID;
    private final String modId;

    protected final String mainMaterial;
    protected final Map<String, Identifier> materials;

    protected static final Settings DEFAULT_SETTINGS = FabricBlockSettings.copyOf(Blocks.COBBLESTONE_WALL);

    static {
        FACING = Properties.HORIZONTAL_FACING;
    }

    public GenericCoverBlock(String mainMaterial, Map<String, Identifier> materials) {
        this(mainMaterial, ModInfo.MOD_ID, materials);
    }

    public GenericCoverBlock(String mainMaterial, String modId, Map<String, Identifier> materials) {
        this(
            mainMaterial,
            modId,
            materials,
            DEFAULT_SETTINGS
        );
    }

    public GenericCoverBlock(String mainMaterial, String modId, Map<String, Identifier> materials, Settings settings) {
        this(
            mainMaterial,
            modId,
            materials,
            getDefaultBlockId(modId, mainMaterial),
            settings
        );
    }

    protected GenericCoverBlock(String mainMaterial, String modId, Map<String, Identifier> materials, Identifier blockId) {
        this(
            mainMaterial,
            modId,
            materials,
            blockId,
            DEFAULT_SETTINGS
        );
    }

    protected GenericCoverBlock(String mainMaterial, String modId, Map<String, Identifier> materials, Identifier blockId, Settings settings) {
        super(settings.nonOpaque());

        validateMaterials(materials);

        BLOCK_ID = blockId;

        this.modId = modId;
        this.mainMaterial = mainMaterial;
        this.materials = materials;

        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerFacing().getOpposite());
    }

    protected static Identifier getDefaultBlockId(String modId, String mainMaterial) {
        return new Identifier(ModInfo.MOD_ID, String.format("covers/%s%s_cover", ModInfo.getModPrefix(modId), mainMaterial));
    }

    @Override
    public Identifier getBlockID() {
        return BLOCK_ID;
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, BLOCK_ID, this);
        Registry.register(Registry.ITEM, BLOCK_ID, new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        setupResources();
    }

    @Override
    public void setupResources() {
        Identifier end = materials.getOrDefault("end", materials.get("main"));
        Identifier side = materials.get("main");
        Identifier ingredient = materials.getOrDefault("ingredient", materials.get("main"));

        Identifier MODEL_ID = Model.getBlockModelID(BLOCK_ID);
        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            BLOCK_ID,
            JRecipe.shaped(
                JPattern.pattern("X X", "   ", "X X"),
                JKeys.keys().key("X", JIngredient.ingredient().item(ingredient.toString())),
                JResult.stackedResult(BLOCK_ID.toString(), 16)
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(BLOCK_ID), LootTable.dropSelf(BLOCK_ID));

        JTextures textures = new JTextures()
            .var("end", Texture.getBlockTextureID(end).toString())
            .var("side", Texture.getBlockTextureID(side).toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model(ModInfo.MOD_ID + ":block/building/block_cover").textures(textures),
            MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("facing=north", new JBlockModel(MODEL_ID))
                    .put("facing=east", new JBlockModel(MODEL_ID).y(90))
                    .put("facing=south", new JBlockModel(MODEL_ID).y(180))
                    .put("facing=west", new JBlockModel(MODEL_ID).y(270))
            ),
            BLOCK_ID
        );
    }

    @Override
    public void validateMaterials(Map<String, Identifier> materials) {
        String[] keys = new String[]{"main"};

        for (String key : keys) {
            if (!materials.containsKey(key)) {
                throw new IllegalArgumentException(String.format("The materials must contain a '%s' key", key));
            }
        }
    }
}
