package com.chimericdream.minekea.client.render.block;

import com.chimericdream.minekea.entities.blocks.furniture.ArmoireBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Quaternion;

public class ArmoireBlockEntityRenderer<T extends ArmoireBlockEntity> implements BlockEntityRenderer<T> {
    private final ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();

    public ArmoireBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(ArmoireBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
//        List<ItemStack> items = entity.getItems();
//
//        World world = entity.getWorld();
//
//        if (world == null || world.getBlockEntity(entity.getPos()) != entity) {
//            return;
//        }
//
//        Quaternion rotation;
//        Vec3f axis = new Vec3f(0, 1, 0);
//        switch (world.getBlockState(entity.getPos()).get(GenericShelf.WALL_SIDE)) {
//            case NORTH -> rotation = new Quaternion(axis, 180, true);
//            case EAST -> rotation = new Quaternion(axis, 90, true);
//            case SOUTH -> rotation = new Quaternion(axis, 0, true);
//            case WEST -> rotation = new Quaternion(axis, 270, true);
//            default -> throw new IllegalStateException("Shelves cannot face ".concat(
//                world.getBlockState(entity.getPos()).get(GenericShelf.WALL_SIDE).toString()).concat("."));
//        }
//
//        ItemStack stack;
//
//        for (int i = 0; i < items.size(); i += 1) {
//            stack = items.get(i);
//            double xPos = 0.125 + (i * 0.25);
//
//            if (!stack.isEmpty()) {
//                renderStack(matrices, vertexConsumers, light, overlay, stack, rotation, xPos);
//            }
//        }
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
//        matrices.push();
//
//        matrices.translate(0.5, 0.5, 0.5);
//
//        matrices.multiply(rotation);
//        matrices.translate(-0.5, -0.5, -0.5);
//
//        if (isJarItem(stack)) {
//            matrices.translate(x, 0.785, 0.25);
//            matrices.scale(0.9f, 0.9f, 0.9f);
//        } else if (isBlockItem(stack)) {
//            matrices.translate(x, 0.65, 0.25);
//            matrices.scale(0.375f, 0.375f, 0.375f);
//        } else {
//            matrices.translate(x, 0.7, 0.25);
//            matrices.scale(0.25f, 0.25f, 0.25f);
//        }
//
//        matrices.multiply(new Quaternion(new Vec3f(0, 1, 0), 180, true));
//
//        renderer.renderItem(stack, ModelTransformation.Mode.FIXED, light, overlay, matrices, vertexConsumers, 0);
//
//        matrices.pop();
    }
}
