package com.chimericdream.minekea.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.poi.PointOfInterestType;
import net.minecraft.world.poi.PointOfInterestTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

/*
 * Shamelessly stolen from Reinforced Barrels by atonkish
 * https://www.curseforge.com/minecraft/mc-mods/reinforced-barrels
 * https://github.com/Aton-Kish/reinforced-barrels/blob/1.21/src/main/java/atonkish/reinfbarrel/mixin/PointOfInterestTypesAccessor.java
 *
 * Thank you!!
 */
@Mixin(PointOfInterestTypes.class)
public interface PointOfInterestTypesAccessor {
    @Accessor("POI_STATES_TO_TYPE")
    static Map<BlockState, RegistryEntry<PointOfInterestType>> getPointOfInterestStatesToType() {
        throw new UnsupportedOperationException();
    }
}
