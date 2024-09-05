//package com.chimericdream.minekea.screen.item;
//
//import com.chimericdream.minekea.ModInfo;
//import com.mojang.blaze3d.systems.RenderSystem;
//import net.minecraft.client.gui.screen.ingame.HandledScreen;
//import net.minecraft.client.render.GameRenderer;
//import net.minecraft.client.util.math.MatrixStack;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.text.Text;
//import net.minecraft.util.Identifier;
//
//public class BlockPainterScreen extends HandledScreen<BlockPainterScreenHandler> {
//    private static final Identifier TEXTURE = Identifier.of(ModInfo.MOD_ID, "textures/gui/painter/block_painter.png");
//    private final int NUM_ROWS = 2;
//
//    public BlockPainterScreen(BlockPainterScreenHandler handler, PlayerInventory inventory, Text title) {
//        super(handler, inventory, title);
//        ++this.backgroundHeight;
//        this.playerInventoryTitleY = this.backgroundHeight - 111;
//    }
//
//    @Override
//    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
//        this.renderBackground(matrices);
//        super.render(matrices, mouseX, mouseY, delta);
//        this.drawMouseoverTooltip(matrices, mouseX, mouseY);
//    }
//
//    @Override
//    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
//        RenderSystem.setShader(GameRenderer::getPositionTexShader);
//        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
//        RenderSystem.setShaderTexture(0, TEXTURE);
//        int i = (this.width - this.backgroundWidth) / 2;
//        int j = (this.height - this.backgroundHeight) / 2;
//        this.drawTexture(matrices, i, j, 0, 0, this.backgroundWidth, this.backgroundHeight);
//    }
//}
