package com.chimericdream.minekea.client.render.block;

import com.chimericdream.minekea.block.furniture.armoires.GenericArmoireBlock;
import com.chimericdream.minekea.entities.blocks.furniture.ArmoireBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;

import java.util.List;

public class ArmoireBlockEntityRenderer<T extends ArmoireBlockEntity> implements BlockEntityRenderer<T> {
    private final ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();

    public ArmoireBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(ArmoireBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        List<ItemStack> items = entity.getItems();

        World world = entity.getWorld();

        if (world == null || world.getBlockEntity(entity.getPos()) != entity) {
            return;
        }

        Quaternion rotation;
        Vec3f axis = new Vec3f(0, 1, 0);
        switch (world.getBlockState(entity.getPos()).get(GenericArmoireBlock.FACING)) {
            case NORTH -> rotation = new Quaternion(axis, 270, true);
            case EAST -> rotation = new Quaternion(axis, 180, true);
            case SOUTH -> rotation = new Quaternion(axis, 90, true);
            case WEST -> rotation = new Quaternion(axis, 0, true);
            default -> throw new IllegalStateException("Armoires cannot face ".concat(
                world.getBlockState(entity.getPos()).get(GenericArmoireBlock.FACING).toString()).concat("."));
        }

        ItemStack stack;

        for (int i = 0; i < items.size(); i += 1) {
            stack = items.get(i);
            double xPos = 0.5 + (i * 0.25);

            if (i == 0 && !stack.isEmpty()) {
                renderStack(matrices, vertexConsumers, light, overlay, stack, rotation, xPos);
            }
        }
    }

    private void renderStack(
        MatrixStack matrices,
        VertexConsumerProvider vertexConsumers,
        int light,
        int overlay,
        ItemStack stack,
        Quaternion rotation,
        double x
    ) {
        matrices.push();

        matrices.translate(0.5, 1.7, 0.75);

        matrices.multiply(rotation);

        matrices.scale(0.25f, 0.25f, 0.25f);

        matrices.multiply(new Quaternion(new Vec3f(0, 1, 0), 180, true));

        renderer.renderItem(stack, ModelTransformation.Mode.GROUND, light, overlay, matrices, vertexConsumers, 0);

        matrices.pop();
    }
}
