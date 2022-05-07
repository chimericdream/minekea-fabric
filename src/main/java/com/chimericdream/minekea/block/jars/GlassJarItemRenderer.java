package com.chimericdream.minekea.block.jars;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.renderer.v1.model.ForwardingBakedModel;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class GlassJarItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    private final BlockRenderManager blockRenderer = MinecraftClient.getInstance().getBlockRenderManager();
    private final ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();

    @Override
    public void render(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        NbtCompound nbt = stack.getSubNbt("BlockEntityTag");

        BlockState defaultState = Registry.BLOCK.get(Registry.ITEM.getId(stack.getItem().asItem())).getDefaultState();

        JarModel model = new JarModel();
        model.setModel(blockRenderer.getModel(defaultState));

        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        renderer.renderItem(stack, ModelTransformation.Mode.NONE, false, matrices, vertexConsumers, light, overlay, model);
        matrices.pop();
    }

    private class JarModel extends ForwardingBakedModel {
        public void setModel(BakedModel model) {
            this.wrapped = model;
        }
    }
}
