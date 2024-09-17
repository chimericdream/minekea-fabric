package com.chimericdream.minekea.world.poi;

import com.chimericdream.minekea.block.containers.barrels.Barrels;
import com.chimericdream.minekea.mixin.PointOfInterestTypesAccessor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * Shamelessly stolen from Reinforced Barrels by atonkish
 * https://www.curseforge.com/minecraft/mc-mods/reinforced-barrels
 * https://github.com/Aton-Kish/reinforced-barrels/blob/1.21/src/main/java/atonkish/reinfbarrel/world/poi/ModPointOfInterestTypes.java
 *
 * Thank you!!
 */
public class MinekeaPointOfInterestTypes {
    public static void init() {
        Map<BlockState, RegistryEntry<PointOfInterestType>> poiStatesToType = PointOfInterestTypesAccessor
            .getPointOfInterestStatesToType();

        RegistryEntry<PointOfInterestType> fishermanEntry = Registries.POINT_OF_INTEREST_TYPE
            .getEntry(PointOfInterestTypes.FISHERMAN).get();

        PointOfInterestType fishermanPoiType = Registries.POINT_OF_INTEREST_TYPE.get(PointOfInterestTypes.FISHERMAN);

        // NOTE: PointOfInterestType.blockStates is accessible by access widener
        List<BlockState> fishermanBlockStates = new ArrayList<BlockState>(fishermanPoiType.blockStates);

        for (Block block : Barrels.ALL_BARRELS) {
            ImmutableList<BlockState> blockStates = block.getStateManager().getStates();

            for (BlockState blockState : blockStates) {
                poiStatesToType.putIfAbsent(blockState, fishermanEntry);
            }

            fishermanBlockStates.addAll(blockStates);
        }

        // NOTE: PointOfInterestType.blockStates is mutable by access widener
        fishermanPoiType.blockStates = ImmutableSet.copyOf(fishermanBlockStates);
    }
}
