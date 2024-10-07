package com.chimericdream.minekea.block.building.compressed;

import com.chimericdream.lib.blocks.ModBlock;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.data.TextureGenerator;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class CompressedMinekeaBlock extends GenericCompressedBlock {
    private final Identifier baseBlockId;

    public CompressedMinekeaBlock(
        ModBlock.Config config,
        int compressionLevel,
        Identifier baseBlockId
    ) {
        super(config, compressionLevel);

        this.baseBlockId = baseBlockId;

        if (compressionLevel > 1) {
            PARENT_BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/compressed/%s/%dx", config.getMaterial(), compressionLevel - 1));
        } else {
            PARENT_BLOCK_ID = baseBlockId;
        }
    }

    @Override
    public void generateTextures() {
        TextureGenerator.getInstance().generate(Registries.BLOCK.getKey(), instance -> {
            final Optional<BufferedImage> source = instance.getMinekeaImage(baseBlockId.withPrefixedPath("block/").getPath());

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

                instance.generate(BLOCK_ID, combined);
            }
        });
    }
}
