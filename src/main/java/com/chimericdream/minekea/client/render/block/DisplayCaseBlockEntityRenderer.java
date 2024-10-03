package com.chimericdream.minekea.client.render.block;

import com.chimericdream.minekea.block.containers.ContainerBlocks;
import com.chimericdream.minekea.block.furniture.displaycases.GenericDisplayCase;
import com.chimericdream.minekea.entities.blocks.furniture.DisplayCaseBlockEntity;
import com.chimericdream.minekea.tag.MinekeaItemTags;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix4f;

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

    private boolean isBaggedItem(ItemStack stack) {
        return stack.isIn(MinekeaItemTags.BAGGED_ITEMS);
    }

    private boolean isJarItem(ItemStack stack) {
        return stack.isOf(ContainerBlocks.GLASS_JAR.asItem());
    }

    private boolean isHeadItem(Identifier id) {
        return
            id.compareTo(Registries.ITEM.getId(Items.PLAYER_HEAD)) == 0
                || id.compareTo(Registries.ITEM.getId(Items.ZOMBIE_HEAD)) == 0
                || id.compareTo(Registries.ITEM.getId(Items.SKELETON_SKULL)) == 0
                || id.compareTo(Registries.ITEM.getId(Items.CREEPER_HEAD)) == 0
                || id.compareTo(Registries.ITEM.getId(Items.WITHER_SKELETON_SKULL)) == 0;
    }

    @Override
    public void render(DisplayCaseBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockState state = entity.getCachedState();

        if (entity.isEmpty()) {
            return;
        }

        ItemStack stack = entity.getStack(0);

        if (hasLabel(entity, stack)) {
            renderLabelIfPresent(entity, stack.getName(), matrices, vertexConsumers, light, tickDelta);
        }

        int rotation = state.get(GenericDisplayCase.ROTATION);

        matrices.push();

        Identifier id = Registries.ITEM.getId(stack.getItem());
        boolean isBlock = isBlockItem(stack);

        if (isBlock) {
            Block block = Registries.BLOCK.get(id);
            double maxY = block.getOutlineShape(block.getDefaultState(), entity.getWorld(), entity.getPos(), null).getMax(Direction.Axis.Y);

            matrices.translate(0.5, 0.65 + Math.min((0.3 * Math.abs(maxY - 1.0)), 0.125), 0.5);

            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation * 45));
        } else {
            matrices.translate(0.5, 0.85, 0.5);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
            matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(rotation * 45));
            matrices.scale(0.5f, 0.5f, 0.5f);
        }

        // Rotate heads and jars so they face up instead of being half inside the case
        if (isHeadItem(id) || isJarItem(stack)) {
            matrices.multiply(RotationAxis.NEGATIVE_X.rotationDegrees(90));
        }

        // Jars need to move up a tiny bit more
        if (isJarItem(stack)) {
            matrices.translate(0, 0, 0.09375);
        }

        ModelTransformationMode mode = isBlock ? ModelTransformationMode.GROUND : ModelTransformationMode.FIXED;

        if (isBaggedItem(stack)) {
            stack.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(9001));
        }

        renderer.renderItem(stack, mode, light, overlay, matrices, vertexConsumers, null, 0);

        matrices.pop();
    }

    protected double getSquaredDistanceToCamera(DisplayCaseBlockEntity entity) {
        return entity.getPos().getSquaredDistance(dispatcher.camera.getPos());
    }

    protected boolean hasLabel(DisplayCaseBlockEntity entity, ItemStack item) {
        HitResult target = dispatcher.crosshairTarget;
        BlockPos targetedPos = BlockPos.ofFloored(target.getPos());

        if (entity.isEmpty()) {
            return false;
        }

        if (MinecraftClient.isHudEnabled() && item.contains(DataComponentTypes.CUSTOM_NAME) && entity.getPos().isWithinDistance(targetedPos, 1.5)) {
            double d = entity.getPos().getSquaredDistance(dispatcher.camera.getPos());
            float f = 32.0F;
            return d < (double) (f * f);
        } else {
            return false;
        }
    }

    public TextRenderer getTextRenderer() {
        return this.textRenderer;
    }

    protected void renderLabelIfPresent(DisplayCaseBlockEntity entity, Text text, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, float tickDelta) {
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
            textRenderer.draw(text, g, (float) i, 553648127, false, matrix4f, vertexConsumers, TextRenderer.TextLayerType.NORMAL, j, light);
            textRenderer.draw(text, g, (float) i, -1, false, matrix4f, vertexConsumers, TextRenderer.TextLayerType.NORMAL, 0, light);

            matrices.pop();
        }
    }
}
