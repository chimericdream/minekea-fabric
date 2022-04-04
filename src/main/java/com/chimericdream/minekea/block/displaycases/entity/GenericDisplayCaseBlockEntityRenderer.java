package com.chimericdream.minekea.block.displaycases.entity;

import com.chimericdream.minekea.block.displaycases.GenericDisplayCase;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
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
public class GenericDisplayCaseBlockEntityRenderer<T extends GenericDisplayCaseBlockEntity> implements BlockEntityRenderer<T> {
    private final ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();

    public GenericDisplayCaseBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    private boolean isBlockItem(ItemStack stack) {
        BakedModel model = renderer.getHeldItemModel(stack, null, null, 0);
        return model.hasDepth();
    }

    @Override
    public void render(GenericDisplayCaseBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemStack itemStack = entity.getStack(0);

        BlockState state = entity.getCachedState();

        int rotation = -1;

        if (state.get(GenericDisplayCase.HAS_ITEM)) {
            rotation = state.get(GenericDisplayCase.ROTATION);
        }

        matrices.push();

        boolean isBlock = false;

        Identifier id = Registry.ITEM.getId(itemStack.getItem());
        if (id != Registry.ITEM.getDefaultId() && Registry.BLOCK.containsId(id)) {
            isBlock = true;
        }

        /*
         * @TODO: find a better way to do this
         * This is a hack... apparently you have to render an actual item in order to clear the previous one. At least,
         * that's the only way I could figure out for now.
         */
        if (itemStack.isOf(Blocks.BARRIER.asItem())) {
            matrices.translate(0.5, 0.2, 0.5);
        } else {
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
        }

        ModelTransformation.Mode mode = isBlock ? ModelTransformation.Mode.GROUND : ModelTransformation.Mode.FIXED;

        renderer.renderItem(itemStack, mode, light, overlay, matrices, vertexConsumers, 0);

        matrices.pop();
    }
}
