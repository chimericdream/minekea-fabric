package com.chimericdream.minekea.data.property;

import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.math.Direction;

public class MinekeaProperties {
    public static final DirectionProperty HORIZONTAL_AXIS_FACING;

    static {
        HORIZONTAL_AXIS_FACING = DirectionProperty.of("facing", Direction.NORTH, Direction.EAST);
    }
}
