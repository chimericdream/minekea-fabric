package com.chimericdream.minekea.client;

import com.chimericdream.minekea.resource.Texture;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.event.client.ClientSpriteRegistryCallback;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.Sprite;
import net.minecraft.fluid.FluidState;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

import java.util.function.Function;

import static com.chimericdream.minekea.fluid.Fluids.*;

public class FluidClientHandlers {
    public static void setupHandlers() {
        setupMilkHandlers();
        setupHoneyHandlers();
    }

    private static void setupMilkHandlers() {
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

    private static void setupHoneyHandlers() {
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
