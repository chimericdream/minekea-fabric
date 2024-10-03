package com.chimericdream.minekea.client.render.item;

import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.entities.blocks.containers.GlassJarBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.renderer.v1.model.ForwardingBakedModel;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class GlassJarItemRenderer implements BuiltinItemRendererRegistry.DynamicItemRenderer {
    @Override
    public void render(ItemStack stack, ModelTransformationMode mode, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState defaultState = ContainerBlocks.GLASS_JAR.getDefaultState();

        JarModel model = new JarModel();
        model.setModel(MinecraftClient.getInstance().getBlockRenderManager().getModel(defaultState));
        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformationMode.NONE, false, matrices, vertexConsumers, light, overlay, model);
        matrices.pop();

        GlassJarBlockEntity entity = new GlassJarBlockEntity(BlockPos.ORIGIN, defaultState);

        NbtComponent customData = stack.getComponents().get(DataComponentTypes.CUSTOM_DATA);
        if (customData != null && MinecraftClient.getInstance().world != null) {
            NbtCompound data = customData.copyNbt();
            if (!data.isEmpty()) {
                entity.readNbt(data, MinecraftClient.getInstance().world.getRegistryManager());
            }
        }

        NbtComponent entityData = stack.getComponents().get(DataComponentTypes.ENTITY_DATA);
        if (entityData != null && MinecraftClient.getInstance().world != null) {
            NbtCompound mobData = entityData.copyNbt();
            if (!mobData.isEmpty()) {
                entity.readMobNbt(mobData, MinecraftClient.getInstance().world.getRegistryManager());
            }
        }

        MinecraftClient.getInstance().getBlockEntityRenderDispatcher().renderEntity(entity, matrices, vertexConsumers, light, overlay);
    }

    private static class JarModel extends ForwardingBakedModel {
        public void setModel(BakedModel model) {
            this.wrapped = model;
        }
    }
}
