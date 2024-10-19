package com.chimericdream.minekea.block.building.compressed;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.data.TextureGenerator;
import com.chimericdream.minekea.resource.ModelUtils;
import com.chimericdream.minekea.util.Tool;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TextureMap;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class CompressedColumnBlock extends GenericCompressedBlock {
    protected final String textureKeySide;
    protected final String textureKeyEnd;

    public CompressedColumnBlock(String materialName, String textureKey, Block baseBlock, int compressionLevel, String textureKeySide, String textureKeyEnd) {
        this(Settings.copy(baseBlock), materialName, textureKey, baseBlock, compressionLevel, textureKeySide, textureKeyEnd);
    }

    public CompressedColumnBlock(String materialName, String textureKey, Block baseBlock, int compressionLevel, String textureKeySide, String textureKeyEnd, Tool miningTool) {
        this(Settings.copy(baseBlock), materialName, textureKey, baseBlock, compressionLevel, textureKeySide, textureKeyEnd, miningTool);
    }

    public CompressedColumnBlock(
        Settings settings,
        String materialName,
        String textureKey,
        Block baseBlock,
        int compressionLevel,
        String textureKeySide,
        String textureKeyEnd
    ) {
        this(settings, materialName, textureKey, baseBlock, compressionLevel, textureKeySide, textureKeyEnd, Tool.PICKAXE);
    }

    public CompressedColumnBlock(
        Settings settings,
        String materialName,
        String textureKey,
        Block baseBlock,
        int compressionLevel,
        String textureKeySide,
        String textureKeyEnd,
        Tool miningTool
    ) {
        super(settings, materialName, textureKey, baseBlock, compressionLevel, miningTool);

        this.textureKeySide = textureKeySide;
        this.textureKeyEnd = textureKeyEnd;
    }

    @Override
    public void configureBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        TextureMap textures = new TextureMap()
            .put(TextureKey.END, Identifier.of(ModInfo.MOD_ID, String.format("block/%s_end", BLOCK_ID.getPath())))
            .put(TextureKey.SIDE, Identifier.of(ModInfo.MOD_ID, String.format("block/%s_side", BLOCK_ID.getPath())));

        Identifier subModelId = blockStateModelGenerator.createSubModel(this, "", Models.CUBE_COLUMN, unused -> textures);

        ModelUtils.registerBlockWithAxis(blockStateModelGenerator, AXIS, this, subModelId);
    }

    private void generateTexture(TextureGenerator.Instance<Block> instance, String key, Identifier blockId) {
        final Optional<BufferedImage> source = instance.getImage(key);

        if (source.isPresent()) {
            BufferedImage sourceImage = source.get();
            BufferedImage overlayImage = instance.getMinekeaImage(String.format("block/building/compressed/level-%d", compressionLevel)).orElse(null);

            int w = sourceImage.getWidth();
            int h = sourceImage.getHeight();

            BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

            Graphics g = combined.getGraphics();
            g.drawImage(sourceImage, 0, 0, null);
            g.drawImage(overlayImage, 0, 0, w, h, null);

            g.dispose();

            instance.generate(blockId, combined);
        }
    }

    @Override
    public void generateTextures() {
        TextureGenerator.getInstance().generate(Registries.BLOCK.getKey(), instance -> {
            generateTexture(instance, textureKey + textureKeyEnd, BLOCK_ID.withSuffixedPath("_end"));
            generateTexture(instance, textureKey + textureKeySide, BLOCK_ID.withSuffixedPath("_side"));
        });
    }

//    @Override
//    public void setupResources() {
//        CompressedBlockSettings settings = (CompressedBlockSettings) this.settings;
//
//        MinekeaTags.addToolTag(settings.getTool(), getBlockID());
//
//        Identifier endTexture = settings.getBlockTexture("end");
//        Identifier sideTexture = settings.getBlockTexture("main");
//
//        Identifier MODEL_ID = Model.getBlockModelID(BLOCK_ID);
//        Identifier ITEM_MODEL_ID = Model.getItemModelID(BLOCK_ID);
//
//        JTextures textures = new JTextures()
//            .var("side", sideTexture.toString())
//            .var("end", endTexture.toString())
//            .var("overlay", String.format(ModInfo.MOD_ID + ":block/building/compressed/level-%d", settings.getCompressionLevel()));
//
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(ModInfo.MOD_ID + ":block/building/compressed_block").textures(textures), MODEL_ID);
//        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);
//
//        if (settings.isColumn()) {
//            MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//                JState.state(
//                    JState.variant()
//                        .put("axis=x", new JBlockModel(MODEL_ID).x(90).y(90))
//                        .put("axis=y", new JBlockModel(MODEL_ID))
//                        .put("axis=z", new JBlockModel(MODEL_ID).x(90))
//                ),
//                BLOCK_ID
//            );
//        } else {
//            MinekeaResourcePack.RESOURCE_PACK.addBlockState(
//                JState.state(JState.variant(new JBlockModel(MODEL_ID))),
//                BLOCK_ID
//            );
//        }
//    }
}
