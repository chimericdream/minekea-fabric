package com.chimericdream.minekea.block.building.compressed;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.data.TextureGenerator;
import com.chimericdream.minekea.util.MinekeaBlock;
import com.chimericdream.minekea.util.Tool;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Optional;

public class CompressedMinekeaBlock extends GenericCompressedBlock {
    private final Identifier baseBlockId;

    public CompressedMinekeaBlock(String materialName, String textureKey, MinekeaBlock baseBlock, int compressionLevel, Identifier baseBlockId) {
        this(Settings.copy((Block) baseBlock), materialName, textureKey, baseBlock, compressionLevel, baseBlockId);
    }

    public CompressedMinekeaBlock(String materialName, String textureKey, MinekeaBlock baseBlock, int compressionLevel, Identifier baseBlockId, Tool miningTool) {
        this(Settings.copy((Block) baseBlock), materialName, textureKey, baseBlock, compressionLevel, baseBlockId, miningTool);
    }

    public CompressedMinekeaBlock(
        Settings settings,
        String materialName,
        String textureKey,
        MinekeaBlock baseBlock,
        int compressionLevel,
        Identifier baseBlockId
    ) {
        this(settings, materialName, textureKey, baseBlock, compressionLevel, baseBlockId, Tool.PICKAXE);
    }

    public CompressedMinekeaBlock(
        Settings settings,
        String materialName,
        String textureKey,
        MinekeaBlock baseBlock,
        int compressionLevel,
        Identifier baseBlockId,
        Tool miningTool
    ) {
        super(settings, materialName, textureKey, (Block) baseBlock, compressionLevel, miningTool);

        this.baseBlockId = baseBlockId;

        if (compressionLevel > 1) {
            PARENT_BLOCK_ID = Identifier.of(ModInfo.MOD_ID, String.format("building/compressed/%s/%dx", textureKey, compressionLevel - 1));
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
