package com.chimericdream.minekea.client.render.block;

import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.block.furniture.shelves.GenericShelf;
import com.chimericdream.minekea.entities.blocks.furniture.ShelfBlockEntity;
import com.chimericdream.minekea.tag.MinekeaItemTags;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import org.joml.Quaternionf;

import java.util.List;

/*
 * Much of the code in this file was adapted from similar code in the SimpleShelves mod by Pinaz993. They have my
 * gratitude for doing such a good job documenting their code! (also for making it open source!!)
 * Links:
 * https://github.com/Pinaz993/SimpleShelves/blob/master/src/main/java/net/pinaz993/simpleshelves/client/ShelfEntityRenderer.java
 * https://www.curseforge.com/minecraft/mc-mods/simple-shelves
 */

public class ShelfBlockEntityRenderer<T extends ShelfBlockEntity> implements BlockEntityRenderer<T> {
    private final ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();

    public ShelfBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    private boolean isBlockItem(ItemStack stack) {
        BakedModel model = renderer.getModel(stack, null, null, 0);
        return model.hasDepth();
    }

    private boolean isBaggedItem(ItemStack stack) {
        return stack.isIn(MinekeaItemTags.BAGGED_ITEMS);
    }

    private boolean isJarItem(ItemStack stack) {
        return stack.isOf(ContainerBlocks.GLASS_JAR.asItem());
    }

    @Override
    public void render(ShelfBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        List<ItemStack> items = entity.getItems();

        World world = entity.getWorld();

        if (world == null || world.getBlockEntity(entity.getPos()) != entity) {
            return;
        }

        Quaternionf rotation;
        RotationAxis axis = RotationAxis.POSITIVE_Y;
        switch (world.getBlockState(entity.getPos()).get(GenericShelf.WALL_SIDE)) {
            case NORTH -> rotation = axis.rotationDegrees(180);
            case EAST -> rotation = axis.rotationDegrees(90);
            case SOUTH -> rotation = axis.rotationDegrees(0);
            case WEST -> rotation = axis.rotationDegrees(270);
            default -> throw new IllegalStateException("Shelves cannot face ".concat(
                world.getBlockState(entity.getPos()).get(GenericShelf.WALL_SIDE).toString()).concat("."));
        }

        ItemStack stack;

        for (int i = 0; i < items.size(); i += 1) {
            stack = items.get(i);
            double xPos = 0.125 + (i * 0.25);

            if (!stack.isEmpty()) {
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
        Quaternionf rotation,
        double x
    ) {
        matrices.push();

        matrices.translate(0.5, 0.5, 0.5);

        matrices.multiply(rotation);
        matrices.translate(-0.5, -0.5, -0.5);

        if (isJarItem(stack)) {
            matrices.translate(x, 0.785, 0.25);
            matrices.scale(0.9f, 0.9f, 0.9f);
        } else if (isBlockItem(stack)) {
            matrices.translate(x, 0.65, 0.25);
            matrices.scale(0.375f, 0.375f, 0.375f);
        } else {
            matrices.translate(x, 0.7, 0.25);
            matrices.scale(0.25f, 0.25f, 0.25f);
        }

        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));

        if (isBaggedItem(stack)) {
            stack.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(9001));
        }

        renderer.renderItem(stack, ModelTransformationMode.FIXED, light, overlay, matrices, vertexConsumers, null, 0);

        matrices.pop();
    }
}
