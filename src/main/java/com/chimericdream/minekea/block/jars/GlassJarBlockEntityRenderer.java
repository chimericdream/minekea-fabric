package com.chimericdream.minekea.block.jars;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;

public class GlassJarBlockEntityRenderer<T extends GlassJarBlockEntity> implements BlockEntityRenderer<T> {
    public GlassJarBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (entity.hasFluid()) {
            renderFluid(entity, tickDelta, matrices, vertexConsumers, light, overlay);
        } else if (entity.hasItem()) {
            renderTexture(entity, tickDelta, matrices, vertexConsumers, light, overlay);
        }

//        Minecraft.getInstance.getProfiler.push("RenderTank")
//        if (te.hasContent) {
//            matrix.push()
//            val tank = te.tank
//            if (tank.box != null) {
//                if (tank.fluid.fluid != null) {
//                    val texture = RenderTank.textureName(te)
//                    //        val texture = Minecraft.getInstance.getSpriteAtlas(PlayerContainer.BLOCK_ATLAS_TEXTURE).apply(resource)
//                    val color = RenderTank.color(te)
//
//                    val b = buffer.getBuffer {
//                        if (Minecraft.useShaderTransparency()) RenderType.cutout()
//                        else RenderType.translucent()
//                    }
//                    val value = Box.LightValue(light).overrideBlock(te.tank.fluid.fluidVolume.getFluidKey.luminosity)
//                    tank.box.render(b, matrix, texture, color >> 24 & 0xFF, color >> 16 & 0xFF, color >> 8 & 0xFF, color >> 0 & 0xFF)(value)
//                } else {
//          import alexiil.mc.lib.attributes.fluid.render.FluidRenderFace
//                    val faces = new java.util.ArrayList[FluidRenderFace]
//                    val x0 = tank.box.startX - tank.box.offX
//                    val y0 = tank.box.startY
//                    val z0 = tank.box.startZ - tank.box.offZ
//                    val x1 = tank.box.endX + tank.box.offX
//                    val y1 = tank.box.endY
//                    val z1 = tank.box.endZ + tank.box.offZ
//                    FluidRenderFace.appendCuboid(x0, y0, z0, x1, y1, z1, 1.0D, java.util.EnumSet.allOf(classOf[Direction]), faces)
//                    faces.forEach(_.light = light)
//                    tank.fluid.fluidVolume.render(faces, buffer, matrix)
//                }
//            }
//            matrix.pop()
//        }
//        Minecraft.getInstance.getProfiler.pop()
    }

    private void renderFluid(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {

    }

    private void renderTexture(T entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemStack stack = entity.getStack(0);

    }
}
