package com.chimericdream.minekea.item;

import com.chimericdream.minekea.block.containers.jars.GlassJarBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.renderer.v1.model.ForwardingBakedModel;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class PainterItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    @Override
    public void render(ItemStack stack, ModelTransformation.Mode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState defaultState = Registry.BLOCK.get(Registry.ITEM.getId(stack.getItem().asItem())).getDefaultState();

        PainterModel model = new PainterModel();
        model.setModel(MinecraftClient.getInstance().getItemRenderer().getModel(stack, null, null, 0));
        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.NONE, false, matrices, vertexConsumers, light, overlay, model);
        matrices.pop();

        GlassJarBlockEntity entity = new GlassJarBlockEntity(BlockPos.ORIGIN, defaultState);

        NbtCompound nbt = stack.getSubNbt("BlockEntityTag");
        if (nbt != null) {
            entity.readNbt(nbt);
        }

        MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity(entity, matrices, vertexConsumers, light, overlay);
    }

    private static class PainterModel extends ForwardingBakedModel {
        public void setModel(BakedModel model) {
            this.wrapped = model;
        }
    }
}
