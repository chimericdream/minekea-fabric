//package com.chimericdream.minekea.client.render.block;
//
//import com.chimericdream.minekea.block.containers.GlassJarBlock;
//import com.chimericdream.minekea.entities.blocks.containers.GlassJarBlockEntity;
//import net.fabricmc.api.EnvType;
//import net.fabricmc.api.Environment;
//import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
//import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
//import net.minecraft.client.MinecraftClient;
//import net.minecraft.client.render.OverlayTexture;
//import net.minecraft.client.render.RenderLayer;
//import net.minecraft.client.render.VertexConsumer;
//import net.minecraft.client.render.VertexConsumerProvider;
//import net.minecraft.client.render.WorldRenderer;
//import net.minecraft.client.render.block.entity.BlockEntityRenderer;
//import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
//import net.minecraft.client.render.item.ItemRenderer;
//import net.minecraft.client.render.model.json.ModelTransformation;
//import net.minecraft.client.texture.Sprite;
//import net.minecraft.client.util.math.MatrixStack;
//import net.minecraft.fluid.Fluid;
//import net.minecraft.fluid.Fluids;
//import net.minecraft.item.ItemStack;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.world.World;
//
//@Environment(EnvType.CLIENT)
//public class GlassJarBlockEntityRenderer implements BlockEntityRenderer<GlassJarBlockEntity> {
//    private static final float yLightFactor = 0.5f;
//    private static final float zLightFactor = 0.8f;
//    private static final float xLightFactor = 0.6f;
//
//    // Prevents z-fighting when the textures would otherwise be touching
//    private static final float NUDGE = 0.0001f;
//    // Ensures that textures start at the appropriate distance from the block's edge
//    private static final float EDGE_OFFSET = 5f / 16f;
//    private static final float HORIZONTAL_OFFSET = NUDGE + EDGE_OFFSET;
//    // Ensures that the total height of the contents doesn't go above the top
//    private static final float VERTICAL_MULTIPLIER = 9f / 16f;
//
//    private final ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();
//
//    public GlassJarBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
//    }
//
//    @Override
//    public void render(GlassJarBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
//        if (entity.hasFluid()) {
//            renderFluid(entity, matrices, vertexConsumers, light);
//        } else if (entity.hasItem()) {
//            renderItem(entity, matrices, vertexConsumers);
//        }
//
//    }
//
//    private void renderFluidTexture(
//        Sprite texture,
//        MatrixStack matrices,
//        VertexConsumerProvider vertexConsumers,
//        float fY,
//        double fillLevel,
//        int color,
//        int light
//    ) {
//        VertexConsumer translucentBuffer = vertexConsumers.getBuffer(RenderLayer.getTranslucent());
//        MatrixStack.Entry worldMatrix = matrices.peek();
//
//        float colorR = (float) (color >> 16 & 255) / 255.0F;
//        float colorG = (float) (color >> 8 & 255) / 255.0F;
//        float colorB = (float) (color & 255) / 255.0F;
//        float xColorR = colorR * xLightFactor;
//        float xColorG = colorG * xLightFactor;
//        float xColorB = colorB * xLightFactor;
//        float yColorR = colorR * yLightFactor;
//        float yColorG = colorG * yLightFactor;
//        float yColorB = colorB * yLightFactor;
//        float zColorR = colorR * zLightFactor;
//        float zColorG = colorG * zLightFactor;
//        float zColorB = colorB * zLightFactor;
//
//        matrices.push();
//
//        // east (x+)
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
//            .color(xColorR, xColorG, xColorB, 1f)
//            .texture(texture.getMinU(), texture.getMinV())
//            .light(light)
//            .normal(1f, 0f, 0f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
//            .color(xColorR, xColorG, xColorB, 1f)
//            .texture(texture.getMaxU(), texture.getMinV())
//            .light(light)
//            .normal(1f, 0f, 0f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
//            .color(xColorR, xColorG, xColorB, 1f)
//            .texture(texture.getMaxU(), texture.getFrameV(fillLevel))
//            .light(light)
//            .normal(1f, 0f, 0f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
//            .color(xColorR, xColorG, xColorB, 1f)
//            .texture(texture.getMinU(), texture.getFrameV(fillLevel))
//            .light(light)
//            .normal(1f, 0f, 0f)
//            .next();
//
//        // west (x-)
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
//            .color(xColorR, xColorG, xColorB, 1f)
//            .texture(texture.getMinU(), texture.getMinV())
//            .light(light)
//            .normal(-1f, 0f, 0f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
//            .color(xColorR, xColorG, xColorB, 1f)
//            .texture(texture.getMaxU(), texture.getMinV())
//            .light(light)
//            .normal(-1f, 0f, 0f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
//            .color(xColorR, xColorG, xColorB, 1f)
//            .texture(texture.getMaxU(), texture.getFrameV(fillLevel))
//            .light(light)
//            .normal(-1f, 0f, 0f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
//            .color(xColorR, xColorG, xColorB, 1f)
//            .texture(texture.getMinU(), texture.getFrameV(fillLevel))
//            .light(light)
//            .normal(-1f, 0f, 0f)
//            .next();
//
//        // south (z+)
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
//            .color(zColorR, zColorG, zColorB, 1f)
//            .texture(texture.getMinU(), texture.getMinV())
//            .light(light)
//            .normal(0f, 0f, 1f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
//            .color(zColorR, zColorG, zColorB, 1f)
//            .texture(texture.getMaxU(), texture.getMinV())
//            .light(light)
//            .normal(0f, 0f, 1f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
//            .color(zColorR, zColorG, zColorB, 1f)
//            .texture(texture.getMaxU(), texture.getFrameV(fillLevel))
//            .light(light)
//            .normal(0f, 0f, 1f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
//            .color(zColorR, zColorG, zColorB, 1f)
//            .texture(texture.getMinU(), texture.getFrameV(fillLevel))
//            .light(light)
//            .normal(0f, 0f, 1f)
//            .next();
//
//        // north (z-)
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
//            .color(zColorR, zColorG, zColorB, 1f)
//            .texture(texture.getMinU(), texture.getMinV())
//            .light(light)
//            .normal(0f, 0f, -1f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
//            .color(zColorR, zColorG, zColorB, 1f)
//            .texture(texture.getMaxU(), texture.getMinV())
//            .light(light)
//            .normal(0f, 0f, -1f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
//            .color(zColorR, zColorG, zColorB, 1f)
//            .texture(texture.getMaxU(), texture.getFrameV(fillLevel))
//            .light(light)
//            .normal(0f, 0f, -1f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
//            .color(zColorR, zColorG, zColorB, 1f)
//            .texture(texture.getMinU(), texture.getFrameV(fillLevel))
//            .light(light)
//            .normal(0f, 0f, -1f)
//            .next();
//
//        // up (y+)
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY - NUDGE, 1f - HORIZONTAL_OFFSET)
//            .color(colorR, colorG, colorB, 1f)
//            .texture(texture.getMinU(), texture.getMinV())
//            .light(light)
//            .normal(0f, 1f, 0f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY - NUDGE, 1f - HORIZONTAL_OFFSET)
//            .color(colorR, colorG, colorB, 1f)
//            .texture(texture.getMaxU(), texture.getMinV())
//            .light(light)
//            .normal(0f, 1f, 0f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY - NUDGE, 0f + HORIZONTAL_OFFSET)
//            .color(colorR, colorG, colorB, 1f)
//            .texture(texture.getMaxU(), texture.getMaxV())
//            .light(light)
//            .normal(0f, 1f, 0f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY - NUDGE, 0f + HORIZONTAL_OFFSET)
//            .color(colorR, colorG, colorB, 1f)
//            .texture(texture.getMinU(), texture.getMaxV())
//            .light(light)
//            .normal(0f, 1f, 0f)
//            .next();
//
//        // down (y-)
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f + NUDGE, 0f + HORIZONTAL_OFFSET)
//            .color(yColorR, yColorG, yColorB, 1f)
//            .texture(texture.getMinU(), texture.getMinV())
//            .light(light)
//            .normal(0f, -1f, 0f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f + NUDGE, 0f + HORIZONTAL_OFFSET)
//            .color(yColorR, yColorG, yColorB, 1f)
//            .texture(texture.getMaxU(), texture.getMinV())
//            .light(light)
//            .normal(0f, -1f, 0f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f + NUDGE, 1f - HORIZONTAL_OFFSET)
//            .color(yColorR, yColorG, yColorB, 1f)
//            .texture(texture.getMaxU(), texture.getMaxV())
//            .light(light)
//            .normal(0f, -1f, 0f)
//            .next();
//        translucentBuffer
//            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f + NUDGE, 1f - HORIZONTAL_OFFSET)
//            .color(yColorR, yColorG, yColorB, 1f)
//            .texture(texture.getMinU(), texture.getMaxV())
//            .light(light)
//            .normal(0f, -1f, 0f)
//            .next();
//
//        matrices.pop();
//    }
//
//    private void renderFluid(GlassJarBlockEntity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
//        World world = entity.getWorld();
//
//        Fluid storedFluid = entity.getStoredFluid();
//        if (storedFluid.matchesType(Fluids.EMPTY)) {
//            return;
//        }
//
//        FluidRenderHandler renderHandler = FluidRenderHandlerRegistry.INSTANCE.get(storedFluid);
//
//        int color = renderHandler.getFluidColor(world, entity.getPos(), storedFluid.getDefaultState());
//
//        Sprite fluidTexture = getFluidTexture(storedFluid);
//
//        double fillLevel = entity.getStoredBuckets();
//
//        float fY = (((float) fillLevel / GlassJarBlockEntity.MAX_BUCKETS) * VERTICAL_MULTIPLIER) - NUDGE;
//
//        renderFluidTexture(fluidTexture, matrices, vertexConsumers, fY, fillLevel, color, light);
//    }
//
//    private void renderItem(GlassJarBlockEntity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers) {
//        World world = entity.getWorld();
//        BlockPos pos = entity.getPos();
//
//        ItemStack storedStack = entity.getStack(0);
//        if (storedStack.isEmpty()) {
//            return;
//        }
//
//        ItemStack stack = GlassJarBlock.getStackToRender(storedStack);
//
//        if (stack.isEmpty()) {
//            return;
//        }
//
//        int fillLevel = entity.getStoredStacks() + 1;
//        float fY = (float) fillLevel / (GlassJarBlockEntity.MAX_ITEM_STACKS + 1);
//
//        matrices.push();
//
//        matrices.translate(0.5, (fY * 0.25) + NUDGE, 0.5);
//        matrices.scale(0.749f, fY, 0.749f);
//
//        int lightAbove = world == null ? 15728880 : WorldRenderer.getLightmapCoordinates(world, pos.up());
//        renderer.renderItem(stack, ModelTransformation.Mode.FIXED, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);
//
//        matrices.pop();
//    }
//
//    private Sprite getFluidTexture(Fluid fluid) {
//        FluidRenderHandler renderHandler = FluidRenderHandlerRegistry.INSTANCE.get(fluid);
//        Sprite[] sprites = renderHandler.getFluidSprites(null, null, fluid.getDefaultState());
//
//        return sprites[0];
//    }
//}
