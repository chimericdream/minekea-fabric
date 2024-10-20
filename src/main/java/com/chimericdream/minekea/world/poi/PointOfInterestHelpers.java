package com.chimericdream.minekea.world.poi;

import com.chimericdream.minekea.mixin.PointOfInterestTypesAccessor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.poi.PointOfInterestType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Adapted from Reinforced Barrels by atonkish
 * https://www.curseforge.com/minecraft/mc-mods/reinforced-barrels
 * https://github.com/Aton-Kish/reinforced-barrels/blob/1.21/src/main/java/atonkish/reinfbarrel/world/poi/ModPointOfInterestTypes.java
 *
 * Thank you!!
 */
public class PointOfInterestHelpers {
    public static void addBlockStatesToPOI(Block block, RegistryKey<PointOfInterestType> poiKey) {
        addBlockStatesToPOI(ImmutableList.of(block), poiKey);
    }

    public static void addBlockStatesToPOI(List<Block> blocks, RegistryKey<PointOfInterestType> poiKey) {
        Map<BlockState, RegistryEntry<PointOfInterestType>> poiStatesToType = PointOfInterestTypesAccessor
            .getPointOfInterestStatesToType();

        RegistryEntry<PointOfInterestType> poiEntry = Registries.POINT_OF_INTEREST_TYPE.getEntry(poiKey).get();
        PointOfInterestType poiType = Registries.POINT_OF_INTEREST_TYPE.get(poiKey);

        // NOTE: PointOfInterestType.blockStates is accessible by access widener
        List<BlockState> newBlockStates = new ArrayList<BlockState>(poiType.blockStates);

        for (Block block : blocks) {
            ImmutableList<BlockState> blockStates = block.getStateManager().getStates();

            for (BlockState blockState : blockStates) {
                poiStatesToType.putIfAbsent(blockState, poiEntry);
            }

            newBlockStates.addAll(blockStates);
        }

        // NOTE: PointOfInterestType.blockStates is mutable by access widener
        poiType.blockStates = ImmutableSet.copyOf(newBlockStates);
    }
}
