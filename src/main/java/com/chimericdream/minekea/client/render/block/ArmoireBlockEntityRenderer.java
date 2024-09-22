package com.chimericdream.minekea.client.render.block;

import com.chimericdream.minekea.block.furniture.armoires.GenericArmoireBlock;
import com.chimericdream.minekea.entities.blocks.furniture.ArmoireBlockEntity;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import org.joml.Quaternionf;

import java.util.List;

public class ArmoireBlockEntityRenderer<T extends ArmoireBlockEntity> implements BlockEntityRenderer<T> {
    private final ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

    public ArmoireBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public void render(ArmoireBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        List<ItemStack> items = entity.getItems();

        World world = entity.getWorld();

        if (world == null || world.getBlockEntity(entity.getPos()) != entity) {
            return;
        }

        Quaternionf rotation;
        switch (world.getBlockState(entity.getPos()).get(GenericArmoireBlock.FACING)) {
            case NORTH -> rotation = RotationAxis.POSITIVE_Y.rotationDegrees(0);
            case EAST -> rotation = RotationAxis.POSITIVE_Y.rotationDegrees(90);
            case SOUTH -> rotation = RotationAxis.POSITIVE_Y.rotationDegrees(180);
            case WEST -> rotation = RotationAxis.POSITIVE_Y.rotationDegrees(270);
            default -> throw new IllegalStateException("Armoires cannot face ".concat(
                world.getBlockState(entity.getPos()).get(GenericArmoireBlock.FACING).toString()).concat("."));
        }

        ItemStack stack;

        for (int i = 0; i < items.size(); i += 1) {
            // Don't render chestplates or leggings; those are handled elsewhere
            if (i % 4 < 2) {
                continue;
            }

            stack = items.get(i);

            boolean isHelmet = i % 4 == 2;
            int armorStand = Math.floorDiv(i, 4);
            double bootOffset = (isHelmet ? 0 : 1) * 0.1875;

            double xOffset = switch (entity.getCachedState().get(GenericArmoireBlock.FACING)) {
                case NORTH -> 0.171875 + (0.21875 * armorStand);
                case SOUTH -> 0.828125 - (0.21875 * armorStand);
                case EAST -> 0.59375 - bootOffset;
                case WEST -> 0.40625 + bootOffset;
                default -> 0.0;
            };

            double yOffset = isHelmet ? 0.5 : 0.078125;

            double zOffset = switch (entity.getCachedState().get(GenericArmoireBlock.FACING)) {
                case NORTH -> 0.40625 + bootOffset;
                case SOUTH -> 0.59375 - bootOffset;
                case EAST -> 0.171875 + (0.21875 * armorStand);
                case WEST -> 0.828125 - (0.21875 * armorStand);
                default -> 0.0;
            };

            if (!stack.isEmpty()) {
                renderStack(matrices, vertexConsumers, light, overlay, stack, rotation, xOffset, yOffset, zOffset);
            }
        }
    }

    private void renderStack(
        MatrixStack matrices,
        VertexConsumerProvider vertexConsumers,
        int light,
        int overlay,
        ItemStack stack,
        Quaternionf rotation,
        double xOffset,
        double yOffset,
        double zOffset
    ) {
        matrices.push();

        matrices.translate(xOffset, yOffset, zOffset);

        matrices.multiply(rotation);

        matrices.scale(0.5f, 0.5f, 0.5f);

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));

        itemRenderer.renderItem(stack, ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, null, 0);

        matrices.pop();
    }
}
