package com.chimericdream.minekea.block.jars;

import com.chimericdream.minekea.block.storage.StorageBlocks;
import com.chimericdream.minekea.util.ItemHelpers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandler;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class GlassJarBlockEntityRenderer implements BlockEntityRenderer<GlassJarBlockEntity> {
    private static final float yLightFactor = 0.5f;
    private static final float zLightFactor = 0.8f;
    private static final float xLightFactor = 0.6f;

    // Prevents z-fighting when the textures would otherwise be touching
    private static final float NUDGE = 0.0001f;
    // Ensures that textures start at the appropriate distance from the block's edge
    private static final float EDGE_OFFSET = 5f / 16f;
    private static final float HORIZONTAL_OFFSET = NUDGE + EDGE_OFFSET;
    // Ensures that the total height of the contents doesn't go above the top
    private static final float VERTICAL_MULTIPLIER = 9f / 16f;

    protected final BlockEntityRenderDispatcher dispatcher;
    private final ItemRenderer renderer = MinecraftClient.getInstance().getItemRenderer();
    private final TextRenderer textRenderer;

    public GlassJarBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
        this.dispatcher = ctx.getRenderDispatcher();
        this.textRenderer = ctx.getTextRenderer();
    }

    @Override
    public void render(GlassJarBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if (entity.hasFluid()) {
            renderFluid(entity, tickDelta, matrices, vertexConsumers, light, overlay);
        } else if (entity.hasItem()) {
            renderItem(entity, tickDelta, matrices, vertexConsumers, light, overlay);
        }

    }

    private void renderFluidTexture(
        Sprite texture,
        MatrixStack matrices,
        VertexConsumerProvider vertexConsumers,
        float fY,
        double fillLevel,
        int color,
        int light
    ) {
        VertexConsumer translucentBuffer = vertexConsumers.getBuffer(RenderLayer.getTranslucent());
        MatrixStack.Entry worldMatrix = matrices.peek();

        float colorR = (float) (color >> 16 & 255) / 255.0F;
        float colorG = (float) (color >> 8 & 255) / 255.0F;
        float colorB = (float) (color & 255) / 255.0F;
        float xColorR = colorR * xLightFactor;
        float xColorG = colorG * xLightFactor;
        float xColorB = colorB * xLightFactor;
        float yColorR = colorR * yLightFactor;
        float yColorG = colorG * yLightFactor;
        float yColorB = colorB * yLightFactor;
        float zColorR = colorR * zLightFactor;
        float zColorG = colorG * zLightFactor;
        float zColorB = colorB * zLightFactor;

        matrices.push();

        // east (x+)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(texture.getMinU(), texture.getMinV())
            .light(light)
            .normal(1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(texture.getMaxU(), texture.getMinV())
            .light(light)
            .normal(1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(texture.getMaxU(), texture.getFrameV(fillLevel))
            .light(light)
            .normal(1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(texture.getMinU(), texture.getFrameV(fillLevel))
            .light(light)
            .normal(1f, 0f, 0f)
            .next();

        // west (x-)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(texture.getMinU(), texture.getMinV())
            .light(light)
            .normal(-1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(texture.getMaxU(), texture.getMinV())
            .light(light)
            .normal(-1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(texture.getMaxU(), texture.getFrameV(fillLevel))
            .light(light)
            .normal(-1f, 0f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
            .color(xColorR, xColorG, xColorB, 1f)
            .texture(texture.getMinU(), texture.getFrameV(fillLevel))
            .light(light)
            .normal(-1f, 0f, 0f)
            .next();

        // south (z+)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(texture.getMinU(), texture.getMinV())
            .light(light)
            .normal(0f, 0f, 1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 1f - HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(texture.getMaxU(), texture.getMinV())
            .light(light)
            .normal(0f, 0f, 1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(texture.getMaxU(), texture.getFrameV(fillLevel))
            .light(light)
            .normal(0f, 0f, 1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 1f - HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(texture.getMinU(), texture.getFrameV(fillLevel))
            .light(light)
            .normal(0f, 0f, 1f)
            .next();

        // north (z-)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(texture.getMinU(), texture.getMinV())
            .light(light)
            .normal(0f, 0f, -1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f, 0f + HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(texture.getMaxU(), texture.getMinV())
            .light(light)
            .normal(0f, 0f, -1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(texture.getMaxU(), texture.getFrameV(fillLevel))
            .light(light)
            .normal(0f, 0f, -1f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY, 0f + HORIZONTAL_OFFSET)
            .color(zColorR, zColorG, zColorB, 1f)
            .texture(texture.getMinU(), texture.getFrameV(fillLevel))
            .light(light)
            .normal(0f, 0f, -1f)
            .next();

        // up (y+)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY - NUDGE, 1f - HORIZONTAL_OFFSET)
            .color(colorR, colorG, colorB, 1f)
            .texture(texture.getMinU(), texture.getMinV())
            .light(light)
            .normal(0f, 1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY - NUDGE, 1f - HORIZONTAL_OFFSET)
            .color(colorR, colorG, colorB, 1f)
            .texture(texture.getMaxU(), texture.getMinV())
            .light(light)
            .normal(0f, 1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, fY - NUDGE, 0f + HORIZONTAL_OFFSET)
            .color(colorR, colorG, colorB, 1f)
            .texture(texture.getMaxU(), texture.getMaxV())
            .light(light)
            .normal(0f, 1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, fY - NUDGE, 0f + HORIZONTAL_OFFSET)
            .color(colorR, colorG, colorB, 1f)
            .texture(texture.getMinU(), texture.getMaxV())
            .light(light)
            .normal(0f, 1f, 0f)
            .next();

        // down (y-)
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f + NUDGE, 0f + HORIZONTAL_OFFSET)
            .color(yColorR, yColorG, yColorB, 1f)
            .texture(texture.getMinU(), texture.getMinV())
            .light(light)
            .normal(0f, -1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f + NUDGE, 0f + HORIZONTAL_OFFSET)
            .color(yColorR, yColorG, yColorB, 1f)
            .texture(texture.getMaxU(), texture.getMinV())
            .light(light)
            .normal(0f, -1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 1f - HORIZONTAL_OFFSET, 0f + NUDGE, 1f - HORIZONTAL_OFFSET)
            .color(yColorR, yColorG, yColorB, 1f)
            .texture(texture.getMaxU(), texture.getMaxV())
            .light(light)
            .normal(0f, -1f, 0f)
            .next();
        translucentBuffer
            .vertex(worldMatrix.getPositionMatrix(), 0f + HORIZONTAL_OFFSET, 0f + NUDGE, 1f - HORIZONTAL_OFFSET)
            .color(yColorR, yColorG, yColorB, 1f)
            .texture(texture.getMinU(), texture.getMaxV())
            .light(light)
            .normal(0f, -1f, 0f)
            .next();

        matrices.pop();
    }

    private void renderFluid(GlassJarBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();

        if (world == null) {
            return;
        }

        Fluid storedFluid = entity.getStoredFluid();
        if (storedFluid.matchesType(Fluids.EMPTY)) {
            return;
        }

        FluidRenderHandler renderHandler = FluidRenderHandlerRegistry.INSTANCE.get(storedFluid);

        int color = renderHandler.getFluidColor(entity.getWorld(), entity.getPos(), storedFluid.getDefaultState());

        Sprite fluidTexture = getFluidTexture(storedFluid);

        double fillLevel = entity.getStoredBuckets();

        float fY = (((float) fillLevel / GlassJarBlockEntity.MAX_BUCKETS) * VERTICAL_MULTIPLIER) - NUDGE;

        renderFluidTexture(fluidTexture, matrices, vertexConsumers, fY, fillLevel, color, light);
    }

    private void renderItem(GlassJarBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();
        BlockPos pos = entity.getPos();

        if (world == null) {
            return;
        }

        ItemStack storedStack = entity.getStack(0);
        if (storedStack.isEmpty()) {
            return;
        }

        ItemStack stack = getStackToRender(storedStack);

        if (stack.isItemEqual(Items.AIR.getDefaultStack())) {
//            Sprite fluidTexture = getFluidTexture(Jars.JAR_POWDER_FLUID);
//            int color = getFluidColor(stack);
//
//            renderFluidTexture(fluidTexture, matrices, vertexConsumers, fY, fillLevel, color, light);

            return;
        }

        int fillLevel = entity.getStoredStacks() + 1;
        float fY = (float) fillLevel / (GlassJarBlockEntity.MAX_ITEM_STACKS + 1);

        matrices.push();

        matrices.translate(0.5, (fY * 0.25) + NUDGE, 0.5);
        matrices.scale(0.749f, fY, 0.749f);

        int lightAbove = WorldRenderer.getLightmapCoordinates(world, pos.up());
        renderer.renderItem(stack, ModelTransformation.Mode.FIXED, lightAbove, OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, 0);

        matrices.pop();
    }

    private ItemStack getStackToRender(ItemStack stack) {
        Identifier stackId = ItemHelpers.getIdentifier(stack);

        switch (stackId.toString()) {
            case "minecraft:slime_ball":
                return Items.SLIME_BLOCK.getDefaultStack();

            case "minecraft:wheat":
                return Items.HAY_BLOCK.getDefaultStack();

            case "minecraft:redstone":
                return Items.REDSTONE_BLOCK.getDefaultStack();

            case "minecraft:glowstone_dust":
                return Items.GLOWSTONE.getDefaultStack();

            case "minecraft:honey_bottle":
                return Items.HONEY_BLOCK.getDefaultStack();

            case "minecraft:honeycomb":
                return Items.HONEYCOMB_BLOCK.getDefaultStack();

            case "minecraft:sugar":
                return new ItemStack(StorageBlocks.SUGAR_BLOCK.asItem());

            case "minecraft:white_dye":
                return new ItemStack(StorageBlocks.WHITE_DYE_BLOCK.asItem());

            case "minecraft:orange_dye":
                return new ItemStack(StorageBlocks.ORANGE_DYE_BLOCK.asItem());

            case "minecraft:magenta_dye":
                return new ItemStack(StorageBlocks.MAGENTA_DYE_BLOCK.asItem());

            case "minecraft:light_blue_dye":
                return new ItemStack(StorageBlocks.LIGHT_BLUE_DYE_BLOCK.asItem());

            case "minecraft:yellow_dye":
                return new ItemStack(StorageBlocks.YELLOW_DYE_BLOCK.asItem());

            case "minecraft:lime_dye":
                return new ItemStack(StorageBlocks.LIME_DYE_BLOCK.asItem());

            case "minecraft:pink_dye":
                return new ItemStack(StorageBlocks.PINK_DYE_BLOCK.asItem());

            case "minecraft:gray_dye":
                return new ItemStack(StorageBlocks.GRAY_DYE_BLOCK.asItem());

            case "minecraft:light_gray_dye":
                return new ItemStack(StorageBlocks.LIGHT_GRAY_DYE_BLOCK.asItem());

            case "minecraft:cyan_dye":
                return new ItemStack(StorageBlocks.CYAN_DYE_BLOCK.asItem());

            case "minecraft:purple_dye":
                return new ItemStack(StorageBlocks.PURPLE_DYE_BLOCK.asItem());

            case "minecraft:blue_dye":
                return new ItemStack(StorageBlocks.BLUE_DYE_BLOCK.asItem());

            case "minecraft:brown_dye":
                return new ItemStack(StorageBlocks.BROWN_DYE_BLOCK.asItem());

            case "minecraft:green_dye":
                return new ItemStack(StorageBlocks.GREEN_DYE_BLOCK.asItem());

            case "minecraft:red_dye":
                return new ItemStack(StorageBlocks.RED_DYE_BLOCK.asItem());

            case "minecraft:black_dye":
                return new ItemStack(StorageBlocks.BLACK_DYE_BLOCK.asItem());

            case "minecraft:blaze_powder":
                return new ItemStack(StorageBlocks.BLAZE_POWDER_BLOCK.asItem());

            case "minecraft:ender_pearl":
                return new ItemStack(StorageBlocks.ENDER_PEARL_BLOCK.asItem());

            case "minecraft:potato":
                return new ItemStack(StorageBlocks.POTATO_BLOCK.asItem());

            case "minecraft:carrot":
                return new ItemStack(StorageBlocks.CARROT_BLOCK.asItem());

            case "minecraft:beetroot":
                return new ItemStack(StorageBlocks.BEETROOT_BLOCK.asItem());

            case "minecraft:chorus_fruit":
                return new ItemStack(StorageBlocks.CHORUS_FRUIT_BLOCK.asItem());

            case "minecraft:amethyst_shard":
                return new ItemStack(Blocks.AMETHYST_BLOCK.asItem());

            default:
                return stack;
        }
    }

    private Sprite getFluidTexture(Fluid fluid) {
        FluidRenderHandler renderHandler = FluidRenderHandlerRegistry.INSTANCE.get(fluid);
        Sprite[] sprites = renderHandler.getFluidSprites(null, null, fluid.getDefaultState());

        return sprites[0];
    }
}
