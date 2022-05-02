package com.chimericdream.minekea.block.jars;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class GlassJarBlockEntityRenderer implements BlockEntityRenderer<GlassJarBlockEntity> {
    private static final float yLightFactor = 0.5f;
    private static final float zLightFactor = 0.8f;
    private static final float xLightFactor = 0.6f;

    // Prevents z-fighting when the textures would otherwise be touching
    private static final float OFFSET = 0.00005f;
    // Ensures that textures start at the appropriate distance from the block's edge
    private static final float UPSILON = 5f / 16f;
    private static final float HORIZONTAL_OFFSET = OFFSET + UPSILON;
    // Ensures that the total height of the contents doesn't go above the top
    private static final float VERTICAL_MULTIPLIER = 9f / 16f;

    protected final BlockEntityRenderDispatcher dispatcher;
    private final ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();
    private final TextRenderer textRenderer;

    public GlassJarBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.dispatcher = ctx.getRenderDispatcher();
        this.textRenderer = ctx.getTextRenderer();
    }

    @Override
    public void render(GlassJarBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (entity.hasFluid()) {
            renderFluid(entity, tickDelta, matrices, vertexConsumers, light, overlay);
        } else if (entity.hasItem()) {
            renderItem(entity, tickDelta, matrices, vertexConsumers, light, overlay);
        }

    }

    private void renderFluid(GlassJarBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();

        if (world == null) {
            return;
        }

        Fluid storedFluid = entity.getStoredFluid();
        if (storedFluid.matchesType(Fluids.EMPTY)) {
            return;
        }

        FluidRenderHandler renderHandler = FluidRenderHandlerRegistry.INSTANCE.get(storedFluid);

        int color = renderHandler.getFluidColor(entity.getWorld(), entity.getPos(), storedFluid.getDefaultState());

        Sprite[] sprites = renderHandler.getFluidSprites(entity.getWorld(), entity.getPos(), storedFluid.getDefaultState());
        Sprite fluidTexture = sprites[0];

        int fillLevel = entity.getStoredBuckets();

        float fY = (((float) fillLevel / GlassJarBlockEntity.MAX_BUCKETS) * VERTICAL_MULTIPLIER) - OFFSET;

        VertexConsumer translucentBuffer = vertexConsumers.getBuffer(RenderLayer.getTranslucent());
        MatrixStack.Entry worldMatrix = matrices.peek();

        float colorR = (float) (color >> 16 & 255) / 255.0F;
        float colorG = (float) (color >> 8 & 255) / 255.0F;
        float colorB = (float) (color & 255) / 255.0F;
        float xColorR = colorR * xLightFactor;
        float xColorG = colorG * xLightFactor;
        float xColorB = colorB * xLightFactor;
        float yColorR = colorR * yLightFactor;
        float yColorG = colorG * yLightFactor;
        float yColorB = colorB * yLightFactor;
        float zColorR = colorR * zLightFactor;
        float zColorG = colorG * zLightFactor;
        float zColorB = colorB * zLightFactor;

        matrices.push();

        // east (x+)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMinV())
            .light(light)
            .normal(1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMinV())
            .light(light)
            .normal(1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(1f, 0f, 0f)
            .next();

        // west (x-)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMinV())
            .light(light)
            .normal(-1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMinV())
            .light(light)
            .normal(-1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(-1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(-1f, 0f, 0f)
            .next();

        // south (z+)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, 0f, 1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, 0f, 1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(0f, 0f, 1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(0f, 0f, 1f)
            .next();

        // north (z-)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, 0f, -1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, 0f, -1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(0f, 0f, -1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(0f, 0f, -1f)
            .next();

        // up (y+)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY - OFFSET, 1f - HORIZONTAL_OFFSET)
            .color(colorR, colorG, colorB, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, 1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY - OFFSET, 1f - HORIZONTAL_OFFSET)
            .color(colorR, colorG, colorB, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, 1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY - OFFSET, 0f + HORIZONTAL_OFFSET)
            .color(colorR, colorG, colorB, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMaxV())
            .light(light)
            .normal(0f, 1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY - OFFSET, 0f + HORIZONTAL_OFFSET)
            .color(colorR, colorG, colorB, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMaxV())
            .light(light)
            .normal(0f, 1f, 0f)
            .next();

        // down (y-)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f + OFFSET, 0f + HORIZONTAL_OFFSET)
            .color(yColorR, yColorG, yColorB, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, -1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f + OFFSET, 0f + HORIZONTAL_OFFSET)
            .color(yColorR, yColorG, yColorB, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, -1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f + OFFSET, 1f - HORIZONTAL_OFFSET)
            .color(yColorR, yColorG, yColorB, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMaxV())
            .light(light)
            .normal(0f, -1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f + OFFSET, 1f - HORIZONTAL_OFFSET)
            .color(yColorR, yColorG, yColorB, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMaxV())
            .light(light)
            .normal(0f, -1f, 0f)
            .next();

        matrices.pop();
    }

    private void renderItem(GlassJarBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
//        World world = entity.getWorld();
//        BlockPos pos = entity.getPos();
//
//        if (world == null) {
//            return;
//        }
//
//        ItemStack stack = entity.getStack(0);
//        if (stack.isEmpty()) {
//            return;
//        }
//
//        matrices.push();
//
//        matrices.translate(0.5, OFFSET, 0.5);
//
//        int lightAbove = WorldRenderer.getLightmapCoordinates(world, pos.up());
//        renderer.renderItem(stack, ModelTransformation.Mode.FIXED, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
//
//        matrices.pop();
//
//        Identifier stackId = stack.getItem().getRegistryEntry().registryKey().getValue();
//        BakedModelManager bakedModelManager = MinecraftClient.getInstance().getBakedModelManager();
//        BakedModel model = BakedModelManagerHelper.getModel(bakedModelManager, stackId);
//
//        Sprite texture = MinecraftClient.getInstance().getSpriteAtlas(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE).apply(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE);
//
//        ItemColorProvider provider = ColorProviderRegistryImpl.ITEM.get(stack.getItem());
//        int color = provider.getColor(stack, 0);
//
//        int fillLevel = entity.getStoredStacks() + 1;
//
//        float fY = (((float) fillLevel / (GlassJarBlockEntity.MAX_ITEM_STACKS + 1)) * VERTICAL_MULTIPLIER) - OFFSET;
//
//        this.renderTexture(matrices, vertexConsumers, texture, color, light, fillLevel, fY);
    }
}
