package com.chimericdream.minekea.block.building.compressed;

import com.chimericdream.lib.blocks.BlockConfig;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.data.TextureGenerator;
import com.chimericdream.minekea.resource.ModelUtils;
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
    private final String sideTextureSuffix;
    private final String endTextureSuffix;

    public CompressedColumnBlock(BlockConfig config, int compressionLevel, String sideTextureSuffix, String endTextureSuffix) {
        super(config, compressionLevel);

        this.sideTextureSuffix = sideTextureSuffix;
        this.endTextureSuffix = endTextureSuffix;
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
            generateTexture(instance, config.getMaterial() + endTextureSuffix, BLOCK_ID.withSuffixedPath("_end"));
            generateTexture(instance, config.getMaterial() + sideTextureSuffix, BLOCK_ID.withSuffixedPath("_side"));
        });
    }
}
