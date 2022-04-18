package com.chimericdream.minekea.block.displaycases;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3f;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class DisplayCaseBlockEntityRenderer<T extends DisplayCaseBlockEntity> implements BlockEntityRenderer<T> {
    private final ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();

    public DisplayCaseBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    private boolean isBlockItem(ItemStack stack) {
        BakedModel model = renderer.getHeldItemModel(stack, null, null, 0);
        return model.hasDepth();
    }

    @Override
    public void render(DisplayCaseBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState state = entity.getCachedState();

        if (entity.isEmpty()) {
            return;
        }

        ItemStack itemStack = entity.getStack(0);

        int rotation = state.get(GenericDisplayCase.ROTATION);

        matrices.push();

        Identifier id = Registry.ITEM.getId(itemStack.getItem());
        boolean isBlock = isBlockItem(itemStack);

        if (isBlock) {
            Block block = Registry.BLOCK.get(id);
            double maxY = block.getOutlineShape(block.getDefaultState(), null, null, null).getMax(Direction.Axis.Y);

            matrices.translate(0.5, 0.65 + Math.min((0.3 * Math.abs(maxY - 1.0)), 0.125), 0.5);
            matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(rotation * 45));
        } else {
            matrices.translate(0.5, 0.85, 0.5);
            matrices.multiply(Vec3f.POSITIVE_X.getDegreesQuaternion(90));
            matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(rotation * 45));
            matrices.scale(0.5f, 0.5f, 0.5f);
        }

        ModelTransformation.Mode mode = isBlock ? ModelTransformation.Mode.GROUND : ModelTransformation.Mode.FIXED;

        renderer.renderItem(itemStack, mode, light, overlay, matrices, vertexConsumers, 0);

        matrices.pop();
    }
}
