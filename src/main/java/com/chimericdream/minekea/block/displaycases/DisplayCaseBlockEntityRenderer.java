package com.chimericdream.minekea.block.displaycases;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.*;
import net.minecraft.util.registry.Registry;

@Environment(EnvType.CLIENT)
public class DisplayCaseBlockEntityRenderer<T extends DisplayCaseBlockEntity> implements BlockEntityRenderer<T> {
    protected final BlockEntityRenderDispatcher dispatcher;
    private final ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();
    private final TextRenderer textRenderer;

    public DisplayCaseBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.dispatcher = ctx.getRenderDispatcher();
        this.textRenderer = ctx.getTextRenderer();
    }

    private boolean isBlockItem(ItemStack stack) {
        BakedModel model = renderer.getModel(stack, null, null, 0);
        return model.hasDepth();
    }

    @Override
    public void render(DisplayCaseBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState state = entity.getCachedState();

        if (entity.isEmpty()) {
            return;
        }

        ItemStack itemStack = entity.getStack(0);

        if (hasLabel(entity, itemStack)) {
            renderLabelIfPresent(entity, itemStack, matrices, vertexConsumers, light);
        }

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

    protected Vec3i getCameraPose(Camera cam) {
        Vec3d cameraPos = cam.getPos();

        return new Vec3i(cameraPos.getX(), cameraPos.getY(), cameraPos.getZ());
    }

    protected double getSquaredDistanceToCamera(DisplayCaseBlockEntity entity) {
        return entity.getPos().getSquaredDistance(getCameraPose(dispatcher.camera));
    }

    protected boolean hasLabel(DisplayCaseBlockEntity entity, ItemStack item) {
        HitResult target = dispatcher.crosshairTarget;
        BlockPos targetedPos = new BlockPos(target.getPos());

        if (MinecraftClient.isHudEnabled() && item.hasCustomName() && entity.getPos().isWithinDistance(targetedPos, 1.5)) {
            double d = entity.getPos().getSquaredDistance(getCameraPose(dispatcher.camera));
            float f = 32.0F;
            return d < (double) (f * f);
        } else {
            return false;
        }
    }

    public TextRenderer getTextRenderer() {
        return this.textRenderer;
    }

    protected void renderLabelIfPresent(DisplayCaseBlockEntity entity, ItemStack item, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        Text text = item.getName();
        double d = getSquaredDistanceToCamera(entity);

        if (!(d > 4096.0)) {
            float f = 1.5F;
            int i = "deadmau5".equals(text.getString()) ? -10 : 0;
            matrices.push();
            matrices.translate(0.5, (double) f, 0.5);
            matrices.multiply(dispatcher.camera.getRotation());
            matrices.scale(-0.025F, -0.025F, 0.025F);
            Matrix4f matrix4f = matrices.peek().getPositionMatrix();
            float g = MinecraftClient.getInstance().options.getTextBackgroundOpacity(0.25F);
            int j = (int) (g * 255.0F) << 24;
            TextRenderer textRenderer = this.getTextRenderer();
            float h = (float) (-textRenderer.getWidth(text) / 2);
            textRenderer.draw(text, h, (float) i, 553648127, false, matrix4f, vertexConsumers, false, j, light);
            textRenderer.draw(text, h, (float) i, -1, false, matrix4f, vertexConsumers, false, 0, light);

            matrices.pop();
        }
    }
}
