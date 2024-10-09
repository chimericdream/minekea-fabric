package com.chimericdream.minekea.block.decorations;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.block.decorations.candles.GenericVotiveCandle;
import com.chimericdream.minekea.block.decorations.lighting.AncientLantern;
import com.chimericdream.minekea.block.decorations.lighting.DoomLantern;
import com.chimericdream.minekea.block.decorations.lighting.EndLantern;
import com.chimericdream.minekea.block.decorations.lighting.EndlessRod;
import com.chimericdream.minekea.block.decorations.misc.FakeCake;
import com.chimericdream.minekea.util.MinekeaBlockCategory;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.render.RenderLayer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DecorationBlocks implements MinekeaBlockCategory {
    public static final AncientLantern ANCIENT_LANTERN;
    public static final DoomLantern DOOM_LANTERN;
    public static final EndLantern END_LANTERN;
    public static final EndlessRod ENDLESS_ROD;
    public static final FakeCake FAKE_CAKE;

    public static final List<Block> BLOCKS = new ArrayList<>();

    public static final Map<String, GenericVotiveCandle> VOTIVE_CANDLES = new LinkedHashMap<>();

    static {
        ANCIENT_LANTERN = new AncientLantern();
        DOOM_LANTERN = new DoomLantern();
        END_LANTERN = new EndLantern();
        ENDLESS_ROD = new EndlessRod();
        FAKE_CAKE = new FakeCake();

        BLOCKS.add(ANCIENT_LANTERN);
        BLOCKS.add(DOOM_LANTERN);
        BLOCKS.add(END_LANTERN);
        BLOCKS.add(ENDLESS_ROD);
        BLOCKS.add(FAKE_CAKE);

        VOTIVE_CANDLES.put("plain", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.CANDLE), "plain"));
        VOTIVE_CANDLES.put("white", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.WHITE_CANDLE), "white"));
        VOTIVE_CANDLES.put("light_gray", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.LIGHT_GRAY_CANDLE), "light_gray"));
        VOTIVE_CANDLES.put("gray", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.GRAY_CANDLE), "gray"));
        VOTIVE_CANDLES.put("black", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.BLACK_CANDLE), "black"));
        VOTIVE_CANDLES.put("brown", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.BROWN_CANDLE), "brown"));
        VOTIVE_CANDLES.put("red", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.RED_CANDLE), "red"));
        VOTIVE_CANDLES.put("orange", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.ORANGE_CANDLE), "orange"));
        VOTIVE_CANDLES.put("yellow", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.YELLOW_CANDLE), "yellow"));
        VOTIVE_CANDLES.put("lime", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.LIME_CANDLE), "lime"));
        VOTIVE_CANDLES.put("green", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.GREEN_CANDLE), "green"));
        VOTIVE_CANDLES.put("cyan", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.CYAN_CANDLE), "cyan"));
        VOTIVE_CANDLES.put("light_blue", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.LIGHT_BLUE_CANDLE), "light_blue"));
        VOTIVE_CANDLES.put("blue", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.BLUE_CANDLE), "blue"));
        VOTIVE_CANDLES.put("purple", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.PURPLE_CANDLE), "purple"));
        VOTIVE_CANDLES.put("magenta", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.MAGENTA_CANDLE), "magenta"));
        VOTIVE_CANDLES.put("pink", new GenericVotiveCandle(new BlockConfig().ingredient(Blocks.PINK_CANDLE), "pink"));

        BLOCKS.addAll(VOTIVE_CANDLES.values());
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void initializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), ANCIENT_LANTERN, DOOM_LANTERN, END_LANTERN);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), VOTIVE_CANDLES.values().toArray(new Block[0]));
    }

    public List<Block> getCategoryBlocks() {
        return BLOCKS;
    }
}
