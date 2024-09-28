package com.chimericdream.minekea.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class DoubleWideInventoryScreen<Handler extends ScreenHandler> extends HandledScreen<Handler> {
    private static final Identifier BG = Identifier.ofVanilla("textures/gui/demo_background.png");
    private static final int BG_CORNER = 4;
    private static final int BG_X = 0;
    private static final int BG_Y = 0;
    private static final int BG_W = 248;
    private static final int BG_H = 166;

    private static final Identifier CONTAINER = Identifier.ofVanilla("textures/gui/container/generic_54.png");
    private static final int CINV_X = 7;
    private static final int CINV_Y = 17;
    private static final int CINV_COLS = 9;
    private static final int CINV_ROWS = 6;
    private static final int PINV_X = 7;
    private static final int PINV_Y = 139;
    private static final int PINV_W = 162;
    private static final int PINV_H = 76;

    private static final int SLOT_SIZE = 18;
    private static final int TEXT_LH = 11;
    private static final int PT = 17;
    private static final int PB = 7;
    private static final int PL = 7;
    private static final int PR = 7;
    private static final int CINV_MB = 14;
    private static final int PINV_MB = 4;

    private final int numCols;
    private final int numRows;

    public DoubleWideInventoryScreen(Handler handler, int numRows, PlayerInventory inventory, Text title) {
        this(handler, 18, numRows, inventory, title);
    }

    public DoubleWideInventoryScreen(Handler handler, int numCols, int numRows, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        this.numCols = numCols;
        this.numRows = numRows;

        this.backgroundWidth = PL + (this.numCols * SLOT_SIZE) + PR;
        this.backgroundHeight = PT + (this.numRows * SLOT_SIZE) + CINV_MB + (3 * SLOT_SIZE) + PINV_MB + (1 * SLOT_SIZE) + PB;
        this.titleX = PL + 1;
        this.titleY = PT - TEXT_LH;
        this.playerInventoryTitleX = PL + ((this.numCols - CINV_COLS) * (SLOT_SIZE / 2)) + 1;
        this.playerInventoryTitleY = this.backgroundHeight - (TEXT_LH + (3 * SLOT_SIZE) + PINV_MB + (1 * SLOT_SIZE) + PB);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context, mouseX, mouseY, delta);
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        this.drawBackgroundTexture(context);
        this.drawSlotTexture(context);
    }

    private void drawBackgroundTexture(DrawContext context) {
        int hnum = (this.backgroundWidth - (BG_CORNER * 2)) / (BG_W - (BG_CORNER * 2));
        int hrem = (this.backgroundWidth - (BG_CORNER * 2)) % (BG_W - (BG_CORNER * 2));

        int vnum = (this.backgroundHeight - (BG_CORNER * 2)) / (BG_H - (BG_CORNER * 2));
        int vrem = (this.backgroundHeight - (BG_CORNER * 2)) % (BG_H - (BG_CORNER * 2));

        //
        // corner
        //

        // left-top
        context.drawTexture(
            BG,
            this.x,
            this.y,
            BG_X,
            BG_Y,
            BG_CORNER,
            BG_CORNER
        );

        // right-top
        context.drawTexture(
            BG,
            this.x + this.backgroundWidth - BG_CORNER,
            this.y,
            BG_W - BG_CORNER,
            BG_Y,
            BG_CORNER,
            BG_CORNER
        );

        // right-top
        context.drawTexture(
            BG,
            this.x,
            this.y + this.backgroundHeight - BG_CORNER,
            BG_X,
            BG_H - BG_CORNER,
            BG_CORNER,
            BG_CORNER
        );

        // right-bottom
        context.drawTexture(
            BG,
            this.x + this.backgroundWidth - BG_CORNER,
            this.y + this.backgroundHeight - BG_CORNER,
            BG_W - BG_CORNER,
            BG_H - BG_CORNER,
            BG_CORNER,
            BG_CORNER
        );

        //
        // edge
        //

        for (int hcnt = 0; hcnt < hnum; ++hcnt) {
            // top
            context.drawTexture(
                BG,
                this.x + BG_CORNER + hcnt * (BG_W - BG_CORNER * 2),
                this.y,
                BG_CORNER,
                BG_Y,
                BG_W - BG_CORNER * 2,
                BG_CORNER
            );

            // bottom
            context.drawTexture(
                BG,
                this.x + BG_CORNER + hcnt * (BG_W - BG_CORNER * 2),
                this.y + this.backgroundHeight - BG_CORNER,
                BG_CORNER,
                BG_H - BG_CORNER,
                BG_W - BG_CORNER * 2,
                BG_CORNER
            );
        }

        for (int vcnt = 0; vcnt < vnum; ++vcnt) {
            // left
            context.drawTexture(
                BG,
                this.x,
                this.y + BG_CORNER + vcnt * (BG_H - BG_CORNER * 2),
                BG_X,
                BG_CORNER,
                BG_CORNER,
                BG_H - BG_CORNER * 2
            );

            // right
            context.drawTexture(
                BG,
                this.x + this.backgroundWidth - BG_CORNER,
                this.y + BG_CORNER + vcnt * (BG_H - BG_CORNER * 2),
                BG_W - BG_CORNER,
                BG_CORNER,
                BG_CORNER,
                BG_H - BG_CORNER * 2
            );
        }

        // top
        context.drawTexture(
            BG,
            this.x + BG_CORNER + hnum * (BG_W - BG_CORNER * 2),
            this.y,
            BG_CORNER,
            BG_Y,
            hrem,
            BG_CORNER
        );

        // bottom
        context.drawTexture(
            BG,
            this.x + BG_CORNER + hnum * (BG_W - BG_CORNER * 2),
            this.y + this.backgroundHeight - BG_CORNER,
            BG_CORNER,
            BG_H - BG_CORNER,
            hrem,
            BG_CORNER
        );

        // left
        context.drawTexture(
            BG,
            this.x,
            this.y + BG_CORNER + vnum * (BG_H - BG_CORNER * 2),
            BG_X,
            BG_CORNER,
            BG_CORNER,
            vrem
        );

        // right
        context.drawTexture(
            BG,
            this.x + this.backgroundWidth - BG_CORNER,
            this.y + BG_CORNER + vnum * (BG_H - BG_CORNER * 2),
            BG_W - BG_CORNER,
            BG_CORNER,
            BG_CORNER,
            vrem
        );

        //
        // area
        //

        for (int vcnt = 0; vcnt < vnum; ++vcnt) {
            for (int hcnt = 0; hcnt < hnum; ++hcnt) {
                context.drawTexture(
                    BG,
                    this.x + BG_CORNER + hcnt * (BG_W - BG_CORNER * 2),
                    this.y + BG_CORNER + vcnt * (BG_H - BG_CORNER * 2),
                    BG_CORNER,
                    BG_CORNER,
                    BG_W - BG_CORNER * 2,
                    BG_H - BG_CORNER * 2
                );
            }

            context.drawTexture(
                BG,
                this.x + BG_CORNER + hnum * (BG_W - BG_CORNER * 2),
                this.y + BG_CORNER + vcnt * (BG_H - BG_CORNER * 2),
                BG_CORNER,
                BG_CORNER,
                hrem,
                BG_H - BG_CORNER * 2
            );
        }

        for (int hcnt = 0; hcnt < hnum; ++hcnt) {
            context.drawTexture(
                BG,
                this.x + BG_CORNER + hcnt * (BG_W - BG_CORNER * 2),
                this.y + BG_CORNER + vnum * (BG_H - BG_CORNER * 2),
                BG_CORNER,
                BG_CORNER,
                BG_W - BG_CORNER * 2,
                vrem
            );
        }

        context.drawTexture(
            BG,
            this.x + BG_CORNER + hnum * (BG_W - BG_CORNER * 2),
            this.y + BG_CORNER + vnum * (BG_H - BG_CORNER * 2),
            BG_CORNER,
            BG_CORNER,
            hrem,
            vrem
        );
    }

    private void drawSlotTexture(DrawContext context) {
        //
        // container inventory
        //

        int hnum = this.numCols / CINV_COLS;
        int hrem = (this.numCols % CINV_COLS) * SLOT_SIZE;

        int vnum = this.numRows / CINV_ROWS;
        int vrem = (this.numRows % CINV_ROWS) * SLOT_SIZE;

        for (int vcnt = 0; vcnt < vnum; ++vcnt) {
            for (int hcnt = 0; hcnt < hnum; ++hcnt) {
                context.drawTexture(
                    CONTAINER,
                    this.x + CINV_X + hcnt * CINV_COLS * SLOT_SIZE,
                    this.y + CINV_Y + vcnt * CINV_ROWS * SLOT_SIZE,
                    CINV_X,
                    CINV_Y,
                    CINV_COLS * SLOT_SIZE,
                    CINV_ROWS * SLOT_SIZE
                );
            }

            context.drawTexture(
                CONTAINER,
                this.x + CINV_X + hnum * CINV_COLS * SLOT_SIZE,
                this.y + CINV_Y + vcnt * CINV_ROWS * SLOT_SIZE,
                CINV_X,
                CINV_Y,
                hrem,
                CINV_ROWS * SLOT_SIZE
            );
        }

        for (int hcnt = 0; hcnt < hnum; ++hcnt) {
            context.drawTexture(
                CONTAINER,
                this.x + CINV_X + hcnt * CINV_COLS * SLOT_SIZE,
                this.y + CINV_Y + vnum * CINV_ROWS * SLOT_SIZE,
                CINV_X,
                CINV_Y,
                CINV_COLS * SLOT_SIZE,
                vrem
            );
        }

        context.drawTexture(
            CONTAINER,
            this.x + CINV_X + hnum * CINV_COLS * SLOT_SIZE,
            this.y + CINV_Y + vnum * CINV_ROWS * SLOT_SIZE,
            CINV_X,
            CINV_Y,
            hrem,
            vrem
        );

        //
        // player inventory
        //

        context.drawTexture(
            CONTAINER,
            this.x + CINV_X + (this.numCols - CINV_COLS) * (SLOT_SIZE / 2),
            this.y + CINV_Y + this.numRows * SLOT_SIZE + CINV_MB,
            PINV_X,
            PINV_Y,
            PINV_W,
            PINV_H
        );
    }
}
