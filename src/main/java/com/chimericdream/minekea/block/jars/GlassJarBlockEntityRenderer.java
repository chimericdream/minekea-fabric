package com.chimericdream.minekea.block.jars;

import com.chimericdream.minekea.resource.Texture;
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
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class GlassJarBlockEntityRenderer implements BlockEntityRenderer<GlassJarBlockEntity> {
    private static final float yLightFactor = 0.5f;
    private static final float zLightFactor = 0.8f;
    private static final float xLightFactor = 0.6f;

    // Prevents z-fighting when the textures would otherwise be touching
    private static final float EPSILON = 0.00005f;
    // Ensures that textures start at the appropriate distance from the block's edge
    private static final float UPSILON = 5f / 16f;
    private static final float HORIZONTAL_OFFSET = EPSILON + UPSILON;
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
            renderTexture(entity, tickDelta, matrices, vertexConsumers, light, overlay);
        }

    }

    private void renderFluid(GlassJarBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        Fluid storedFluid = entity.getStoredFluid();
        if (storedFluid.matchesType(Fluids.EMPTY)) {
            return;
        }

        World world = entity.getWorld();

        if (world == null) {
            return;
        }

        MatrixStack.Entry worldMatrix = matrices.peek();

        matrices.push();

        FluidRenderHandler renderHandler = FluidRenderHandlerRegistry.INSTANCE.get(storedFluid);

        int color = renderHandler.getFluidColor(entity.getWorld(), entity.getPos(), storedFluid.getDefaultState());

        Sprite[] sprites = renderHandler.getFluidSprites(entity.getWorld(), entity.getPos(), storedFluid.getDefaultState());
        Sprite fluidTexture = sprites[0];

        VertexConsumer translucentBuffer = vertexConsumers.getBuffer(RenderLayer.getTranslucent());

        Texture.Color fluidColor = new Texture.Color(color);
        Texture.Color xColor = fluidColor.withLight(xLightFactor);
        Texture.Color yColor = fluidColor.withLight(yLightFactor);
        Texture.Color zColor = fluidColor.withLight(zLightFactor);

        int fillLevel = entity.getStoredBuckets();

        float fY = (((float) fillLevel / GlassJarBlockEntity.MAX_BUCKETS) * VERTICAL_MULTIPLIER) - EPSILON;

        // east (x+)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
            .color(xColor.r, xColor.g, xColor.b, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMinV())
            .light(light)
            .normal(1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
            .color(xColor.r, xColor.g, xColor.b, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMinV())
            .light(light)
            .normal(1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
            .color(xColor.r, xColor.g, xColor.b, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
            .color(xColor.r, xColor.g, xColor.b, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(1f, 0f, 0f)
            .next();

        // west (x-)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
            .color(xColor.r, xColor.g, xColor.b, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMinV())
            .light(light)
            .normal(-1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
            .color(xColor.r, xColor.g, xColor.b, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMinV())
            .light(light)
            .normal(-1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
            .color(xColor.r, xColor.g, xColor.b, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(-1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
            .color(xColor.r, xColor.g, xColor.b, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(-1f, 0f, 0f)
            .next();

        // south (z+)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
            .color(zColor.r, zColor.g, zColor.b, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, 0f, 1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
            .color(zColor.r, zColor.g, zColor.b, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, 0f, 1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
            .color(zColor.r, zColor.g, zColor.b, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(0f, 0f, 1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
            .color(zColor.r, zColor.g, zColor.b, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(0f, 0f, 1f)
            .next();

        // north (z-)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
            .color(zColor.r, zColor.g, zColor.b, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, 0f, -1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
            .color(zColor.r, zColor.g, zColor.b, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, 0f, -1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
            .color(zColor.r, zColor.g, zColor.b, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(0f, 0f, -1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
            .color(zColor.r, zColor.g, zColor.b, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getFrameV(fillLevel))
            .light(light)
            .normal(0f, 0f, -1f)
            .next();

        // up (y+)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY - EPSILON, 1f - HORIZONTAL_OFFSET)
            .color(fluidColor.r, fluidColor.g, fluidColor.b, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, 1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY - EPSILON, 1f - HORIZONTAL_OFFSET)
            .color(fluidColor.r, fluidColor.g, fluidColor.b, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, 1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY - EPSILON, 0f + HORIZONTAL_OFFSET)
            .color(fluidColor.r, fluidColor.g, fluidColor.b, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMaxV())
            .light(light)
            .normal(0f, 1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY - EPSILON, 0f + HORIZONTAL_OFFSET)
            .color(fluidColor.r, fluidColor.g, fluidColor.b, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMaxV())
            .light(light)
            .normal(0f, 1f, 0f)
            .next();

        // down (y-)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f + EPSILON, 0f + HORIZONTAL_OFFSET)
            .color(yColor.r, yColor.g, yColor.b, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, -1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f + EPSILON, 0f + HORIZONTAL_OFFSET)
            .color(yColor.r, yColor.g, yColor.b, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMinV())
            .light(light)
            .normal(0f, -1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f + EPSILON, 1f - HORIZONTAL_OFFSET)
            .color(yColor.r, yColor.g, yColor.b, 1f)
            .texture(fluidTexture.getMaxU(), fluidTexture.getMaxV())
            .light(light)
            .normal(0f, -1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f + EPSILON, 1f - HORIZONTAL_OFFSET)
            .color(yColor.r, yColor.g, yColor.b, 1f)
            .texture(fluidTexture.getMinU(), fluidTexture.getMaxV())
            .light(light)
            .normal(0f, -1f, 0f)
            .next();

        matrices.pop();
    }

    private void renderTexture(GlassJarBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemStack stack = entity.getStack(0);
    }
}
