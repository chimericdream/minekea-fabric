package com.chimericdream.minekea.resource;

import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.MultipartBlockStateSupplier;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.When;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public class ModelUtils {
    public static void registerBlockWithFacing(
        BlockStateModelGenerator blockStateModelGenerator,
        DirectionProperty facing,
        Block block,
        Identifier subModelId
    ) {
        blockStateModelGenerator.blockStateCollector
            .accept(
                MultipartBlockStateSupplier.create(block)
                    .with(
                        When.create().set(facing, Direction.NORTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(facing, Direction.EAST),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R90)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(facing, Direction.SOUTH),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(facing, Direction.WEST),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R90)
                            .put(VariantSettings.Y, VariantSettings.Rotation.R270)
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(facing, Direction.UP),
                        BlockStateVariant.create()
                            .put(VariantSettings.MODEL, subModelId)
                    )
                    .with(
                        When.create().set(facing, Direction.DOWN),
                        BlockStateVariant.create()
                            .put(VariantSettings.X, VariantSettings.Rotation.R180)
                            .put(VariantSettings.MODEL, subModelId)
                    )
            );
    }
}
