package com.chimericdream.minekea.fluid;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.compat.ModCompatLayer;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.block.MapColor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockRenderView;

import java.util.List;
import java.util.function.Function;

public class Fluids implements MinekeaBlockCategory {
    public static final FlowableFluid MILK;
    public static final FlowableFluid FLOWING_MILK;
    public static final FluidBlock MILK_SOURCE_BLOCK;

    public static final FlowableFluid HONEY;
    public static final FlowableFluid FLOWING_HONEY;
    public static final FluidBlock HONEY_SOURCE_BLOCK;

    public static final Block MILK_CAULDRON;
    public static final Block HONEY_CAULDRON;
    public static final Item HONEY_BUCKET;

    public static final Identifier MILK_ID = new Identifier(ModInfo.MOD_ID, "fluids/milk");
    public static final Identifier FLOWING_MILK_ID = new Identifier(ModInfo.MOD_ID, "fluids/flowing_milk");
    public static final Identifier MILK_SOURCE_ID = new Identifier(ModInfo.MOD_ID, "fluids/milk_source");

    public static final Identifier HONEY_ID = new Identifier(ModInfo.MOD_ID, "fluids/honey");
    public static final Identifier FLOWING_HONEY_ID = new Identifier(ModInfo.MOD_ID, "fluids/flowing_honey");
    public static final Identifier HONEY_SOURCE_ID = new Identifier(ModInfo.MOD_ID, "fluids/honey_source");

    static {
        MILK = Registry.register(Registry.FLUID, MILK_ID, new MilkFluid.Still());
        FLOWING_MILK = Registry.register(Registry.FLUID, FLOWING_MILK_ID, new MilkFluid.Flowing());
        MILK_SOURCE_BLOCK = Registry.register(
            Registry.BLOCK,
            MILK_SOURCE_ID,
            new MilkFluid.Source(MILK, FabricBlockSettings.copyOf(Blocks.WATER).mapColor(MapColor.WHITE))
        );

        HONEY = Registry.register(Registry.FLUID, HONEY_ID, new HoneyFluid.Still());
        FLOWING_HONEY = Registry.register(Registry.FLUID, FLOWING_HONEY_ID, new HoneyFluid.Flowing());
        HONEY_SOURCE_BLOCK = Registry.register(
            Registry.BLOCK,
            HONEY_SOURCE_ID,
            new HoneyFluid.Source(HONEY, FabricBlockSettings.copyOf(Blocks.LAVA).mapColor(MapColor.TERRACOTTA_YELLOW))
        );

        MILK_CAULDRON = Registry.register(
            Registry.BLOCK,
            new Identifier(ModInfo.MOD_ID, "milk_cauldron"),
            new MilkCauldronBlock(FabricBlockSettings.copyOf(Blocks.CAULDRON))
        );

        HONEY_BUCKET = Registry.register(
            Registry.ITEM,
            HoneyBucketItem.ITEM_ID,
            new HoneyBucketItem()
        );
        HONEY_CAULDRON = Registry.register(
            Registry.BLOCK,
            new Identifier(ModInfo.MOD_ID, "honey_cauldron"),
            new HoneyCauldronBlock(FabricBlockSettings.copyOf(Blocks.CAULDRON))
        );
    }

    @Override
    public void initializeClient() {
        setupMilkHandlers();
        setupHoneyHandlers();
    }

    @Override
    public void registerBlocks() {
    }

    @Override
    public void registerBlockEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void registerEntities(List<ModCompatLayer> otherMods) {
    }

    @Override
    public void setupResources() {
    }

    private void setupMilkHandlers() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(Texture.getBlockTextureID(MILK_ID));
            registry.register(Texture.getBlockTextureID(FLOWING_MILK_ID));
        });

        Identifier listenerId = new Identifier(MILK_ID.getNamespace(), MILK_ID.getPath() + "_reload_listener");

        Sprite[] sprites = {null, null};

        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
            @Override
            public Identifier getFabricId() {
                return listenerId;
            }

            @Override
            public void reload(ResourceManager resourceManager) {
                Function<Identifier, Sprite> atlas = MinecraftClient.getInstance().getSpriteAtlas(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE);

                sprites[0] = atlas.apply(Texture.getBlockTextureID(MILK_ID));
                sprites[1] = atlas.apply(Texture.getBlockTextureID(FLOWING_MILK_ID));
            }
        });

        FluidRenderHandler renderHandler = new FluidRenderHandler() {
            @Override
            public Sprite[] getFluidSprites(BlockRenderView view, BlockPos pos, FluidState state) {
                return sprites;
            }

            @Override
            public int getFluidColor(BlockRenderView view, BlockPos pos, FluidState state) {
                return 0xFFFFFF;
            }
        };

        FluidRenderHandlerRegistry.INSTANCE.register(MILK, renderHandler);
        FluidRenderHandlerRegistry.INSTANCE.register(FLOWING_MILK, renderHandler);
    }

    private void setupHoneyHandlers() {
        ClientSpriteRegistryCallback.event(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE).register((atlasTexture, registry) -> {
            registry.register(Texture.getBlockTextureID(HONEY_ID));
            registry.register(Texture.getBlockTextureID(FLOWING_HONEY_ID));
        });

        Identifier listenerId = new Identifier(HONEY_ID.getNamespace(), HONEY_ID.getPath() + "_reload_listener");

        Sprite[] sprites = {null, null};

        ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
            @Override
            public Identifier getFabricId() {
                return listenerId;
            }

            @Override
            public void reload(ResourceManager resourceManager) {
                Function<Identifier, Sprite> atlas = MinecraftClient.getInstance().getSpriteAtlas(PlayerScreenHandler.BLOCK_ATLAS_TEXTURE);

                sprites[0] = atlas.apply(Texture.getBlockTextureID(HONEY_ID));
                sprites[1] = atlas.apply(Texture.getBlockTextureID(FLOWING_HONEY_ID));
            }
        });

        FluidRenderHandler renderHandler = new FluidRenderHandler() {
            @Override
            public Sprite[] getFluidSprites(BlockRenderView view, BlockPos pos, FluidState state) {
                return sprites;
            }

            @Override
            public int getFluidColor(BlockRenderView view, BlockPos pos, FluidState state) {
                return 0xFFFFFF;
            }
        };

        FluidRenderHandlerRegistry.INSTANCE.register(HONEY, renderHandler);
        FluidRenderHandlerRegistry.INSTANCE.register(FLOWING_HONEY, renderHandler);
    }
}
