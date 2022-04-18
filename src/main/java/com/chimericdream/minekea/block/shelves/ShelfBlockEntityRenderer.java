package com.chimericdream.minekea.block.shelves;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Quaternion;
import net.minecraft.util.math.Vec3f;
import net.minecraft.world.World;

import java.util.List;

public class ShelfBlockEntityRenderer<T extends ShelfBlockEntity> implements BlockEntityRenderer<T> {
    private final ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();

    public ShelfBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    private boolean isBlockItem(ItemStack stack) {
        BakedModel model = renderer.getModel(stack, null, null, 0);
        return model.hasDepth();
    }

    @Override
    public void render(ShelfBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        List<ItemStack> items = entity.getItems();

        World world = entity.getWorld();

        if (world == null || world.getBlockEntity(entity.getPos()) != entity) {
            return;
        }

        Quaternion rotationQuaternion; // This defines the rotation we use to make sure the items end up in the right places.
        Vec3f axis = new Vec3f(0, 1, 0); // Let's define this once, so we don't waste time and memory.
        switch (world.getBlockState(entity.getPos()).get(GenericShelf.WALL_SIDE)) { // Which direction?
            case NORTH -> rotationQuaternion = new Quaternion(axis, 180, true);
            case EAST -> rotationQuaternion = new Quaternion(axis, 90, true);
            case SOUTH -> rotationQuaternion = new Quaternion(axis, 0, true);
            case WEST -> rotationQuaternion = new Quaternion(axis, 270, true);
            default ->
                throw new IllegalStateException("Shelves cannot face ".concat( // Let's be verbose about what went wrong.
                    world.getBlockState(entity.getPos()).get(GenericShelf.WALL_SIDE).toString()).concat("."));
        }

        ItemStack stack;

        for (int i = 0; i < items.size(); i += 1) {
            stack = items.get(i);
            double xPos = 0.125 + (i * 0.25);

            if (!stack.isEmpty()) {
                renderStack(matrices, vertexConsumers, light, overlay, stack, rotationQuaternion, xPos);
            }
        }
    }

    private void renderStack(
        MatrixStack matrices,
        VertexConsumerProvider vertexConsumers,
        int light,
        int overlay,
        ItemStack stack,
        Quaternion rotationQuaternion,
        double x
    ) {
        matrices.push(); // Obligatory, for OpenGL calls of any kind. I have only vague ideas of why.

        matrices.translate(0.5, 0.5, 0.5); // Move to the middle of the block before rotating.

        // Rotate to make the stack matches with the direction the shelf is facing.
        matrices.multiply(rotationQuaternion);
        matrices.translate(-0.5, -0.5, -0.5); // Move back to 0,0,0.
        matrices.translate(x, 0.65, 0.25); // Translate to the position this quadrant occupies.

        // If this is a block that renders as a block:
        if (isBlockItem(stack)) {
            matrices.scale(0.375f, 0.375f, 0.375f); // Scale to 37.5%.
        } else {
            matrices.scale(0.1875f, 0.1875f, 0.1875f); // Otherwise scale to 18.75%
        }

        // Rotate 180 degrees to make block or item face properly outward.
        matrices.multiply(new Quaternion(new Vec3f(0, 1, 0), 180, true));

        // Actually render the item.
        renderer.renderItem(stack, ModelTransformation.Mode.FIXED, light, overlay, matrices, vertexConsumers, 0);

        matrices.pop(); // We're done with this matrix entry (whatever that entails).
    }
}
