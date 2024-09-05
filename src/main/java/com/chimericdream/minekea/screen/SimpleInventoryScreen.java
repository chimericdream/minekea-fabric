//package com.chimericdream.minekea.screen;
//
//import com.chimericdream.minekea.util.ScreenHelpers;
//import com.mojang.blaze3d.systems.RenderSystem;
//import net.minecraft.client.gui.screen.ingame.HandledScreen;
//import net.minecraft.client.render.GameRenderer;
//import net.minecraft.client.util.math.MatrixStack;
//import net.minecraft.entity.player.PlayerInventory;
//import net.minecraft.screen.ScreenHandler;
//import net.minecraft.text.Text;
//import net.minecraft.util.Identifier;
//
//public class SimpleInventoryScreen<Handler extends ScreenHandler> extends HandledScreen<Handler> {
//    private static final Identifier TEXTURE = Identifier.of("minecraft", "textures/gui/container/generic_54.png");
//    private final int numRows;
//
//    public SimpleInventoryScreen(Handler handler, int numRows, PlayerInventory inventory, Text title) {
//        super(handler, inventory, title);
//        this.numRows = numRows;
//        this.passEvents = false;
//        this.backgroundHeight = 114 + this.numRows * ScreenHelpers.ROW_HEIGHT;
//        this.playerInventoryTitleY = this.backgroundHeight - 94;
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
//        this.drawTexture(matrices, i, j, 0, 0, this.backgroundWidth, this.numRows * ScreenHelpers.ROW_HEIGHT + 17);
//        this.drawTexture(matrices, i, j + this.numRows * ScreenHelpers.ROW_HEIGHT + 17, 0, 126, this.backgroundWidth, 96);
//    }
//}
