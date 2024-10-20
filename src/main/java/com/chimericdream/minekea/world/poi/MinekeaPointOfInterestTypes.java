package com.chimericdream.minekea.world.poi;

import com.chimericdream.minekea.block.containers.barrels.Barrels;
import net.minecraft.world.poi.PointOfInterestTypes;

public class MinekeaPointOfInterestTypes {
    public static void init() {
        PointOfInterestHelpers.addBlockStatesToPOI(Barrels.BARRELS, PointOfInterestTypes.FISHERMAN);
    }
}
