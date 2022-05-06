package com.chimericdream.minekea.block.storage;

import com.chimericdream.minekea.ModInfo;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;

public class CompressedSugarBlock extends GenericStorageFallingBlock {
    public CompressedSugarBlock(Identifier baseBlock) {
        super(
            FabricBlockSettings.copyOf(Blocks.SAND),
            new Identifier(ModInfo.MOD_ID, "storage/compressed_" + baseBlock.getPath()),
            baseBlock
        );
    }
}
