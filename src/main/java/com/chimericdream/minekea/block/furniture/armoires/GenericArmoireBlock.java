package com.chimericdream.minekea.block.furniture.armoires;

import com.chimericdream.minekea.MinekeaMod;
import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.entities.blocks.furniture.ArmoireBlockEntity;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.resource.Texture;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import java.util.Map;

public class GenericArmoireBlock extends BlockWithEntity implements MinekeaBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF;
    public static final DirectionProperty FACING;

    protected static final VoxelShape NORTH_TOP_SHAPE;
    protected static final VoxelShape NORTH_BOTTOM_SHAPE;

    protected static final VoxelShape SOUTH_TOP_SHAPE;
    protected static final VoxelShape SOUTH_BOTTOM_SHAPE;

    protected static final VoxelShape EAST_TOP_SHAPE;
    protected static final VoxelShape EAST_BOTTOM_SHAPE;

    protected static final VoxelShape WEST_TOP_SHAPE;
    protected static final VoxelShape WEST_BOTTOM_SHAPE;

    static {
        FACING = HorizontalFacingBlock.FACING;
        HALF = Properties.DOUBLE_BLOCK_HALF;

        NORTH_TOP_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(15.00, 0.00, 0.00, 16.00, 16.00, 12.00),   // left
            Block.createCuboidShape(0.00, 0.00, 0.00, 1.00, 16.00, 12.00),     // right
            Block.createCuboidShape(1.00, 15.00, 1.00, 15.00, 16.00, 12.00),   // back
            Block.createCuboidShape(1.00, 0.00, 0.00, 15.00, 16.00, 1.00),     // top
            Block.createCuboidShape(1.00, 12.00, 6.00, 15.00, 13.00, 7.00),    // pole
            Block.createCuboidShape(12.75, 8.40, 5.60, 13.75, 12.00, 7.40),    // Armor stand 1, head
            Block.createCuboidShape(12.50, 5.70, 2.00, 14.00, 8.40, 11.00),    // Armor stand 1, shoulders
            Block.createCuboidShape(12.75, 1.20, 4.10, 13.75, 5.70, 5.60),     // Armor stand 1, left arm
            Block.createCuboidShape(12.75, 1.20, 7.40, 13.75, 5.70, 8.90),     // Armor stand 1, right arm
            Block.createCuboidShape(12.75, -0.60, 3.53, 13.75, 1.20, 9.48),    // Armor stand 1, waist
            Block.createCuboidShape(12.75, -6.90, 4.10, 13.75, -0.60, 5.60),   // Armor stand 1, left leg
            Block.createCuboidShape(12.75, -6.90, 7.40, 13.75, -0.60, 8.90),   // Armor stand 1, right leg
            Block.createCuboidShape(9.25, 8.40, 5.60, 10.25, 12.00, 7.40),     // Armor stand 2, head
            Block.createCuboidShape(9.00, 5.70, 2.00, 10.50, 8.40, 11.00),     // Armor stand 2, shoulders
            Block.createCuboidShape(9.25, 1.20, 4.10, 10.25, 5.70, 5.60),      // Armor stand 2, left arm
            Block.createCuboidShape(9.25, 1.20, 7.40, 10.25, 5.70, 8.90),      // Armor stand 2, right arm
            Block.createCuboidShape(9.25, -0.60, 3.53, 10.25, 1.20, 9.48),     // Armor stand 2, waist
            Block.createCuboidShape(9.25, -6.90, 4.10, 10.25, -0.60, 5.60),    // Armor stand 2, left leg
            Block.createCuboidShape(9.25, -6.90, 7.40, 10.25, -0.60, 8.90),    // Armor stand 2, right leg
            Block.createCuboidShape(5.75, 8.40, 5.60, 6.75, 12.00, 7.40),      // Armor stand 3, head
            Block.createCuboidShape(5.50, 5.70, 2.00, 7.00, 8.40, 11.00),      // Armor stand 3, shoulders
            Block.createCuboidShape(5.75, 1.20, 4.10, 6.75, 5.70, 5.60),       // Armor stand 3, left arm
            Block.createCuboidShape(5.75, 1.20, 7.40, 6.75, 5.70, 8.90),       // Armor stand 3, right arm
            Block.createCuboidShape(5.75, -0.60, 3.53, 6.75, 1.20, 9.48),      // Armor stand 3, waist
            Block.createCuboidShape(5.75, -6.90, 4.10, 6.75, -0.60, 5.60),     // Armor stand 3, left leg
            Block.createCuboidShape(5.75, -6.90, 7.40, 6.75, -0.60, 8.90),     // Armor stand 3, right leg
            Block.createCuboidShape(2.25, 8.40, 5.60, 3.25, 12.00, 7.40),      // Armor stand 4, head
            Block.createCuboidShape(2.00, 5.70, 2.00, 3.50, 8.40, 11.00),      // Armor stand 4, shoulders
            Block.createCuboidShape(2.25, 1.20, 4.10, 3.25, 5.70, 5.60),       // Armor stand 4, left arm
            Block.createCuboidShape(2.25, 1.20, 7.40, 3.25, 5.70, 8.90),       // Armor stand 4, right arm
            Block.createCuboidShape(2.25, -0.60, 3.53, 3.25, 1.20, 9.48),      // Armor stand 4, waist
            Block.createCuboidShape(2.25, -6.90, 4.10, 3.25, -0.60, 5.60),     // Armor stand 4, left leg
            Block.createCuboidShape(2.25, -6.90, 7.40, 3.25, -0.60, 8.90)      // Armor stand 4, right leg
        );
        NORTH_BOTTOM_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.00, 0.00, 0.00, 16.00, 1.00, 12.00),     // bottom
            Block.createCuboidShape(15.00, 1.00, 0.00, 16.00, 16.00, 12.00),   // shelf
            Block.createCuboidShape(0.00, 1.00, 0.00, 1.00, 16.00, 12.00),     // right
            Block.createCuboidShape(1.00, 1.00, 0.00, 15.00, 16.00, 1.00),     // left
            Block.createCuboidShape(1.00, 4.50, 1.00, 15.00, 5.50, 11.00)      // back
        );

        SOUTH_TOP_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.00, 0.00, 4.00, 1.00, 16.00, 16.00),     // left
            Block.createCuboidShape(15.00, 0.00, 4.00, 16.00, 16.00, 16.00),   // right
            Block.createCuboidShape(1.00, 15.00, 4.00, 15.00, 16.00, 15.00),   // back
            Block.createCuboidShape(1.00, 0.00, 15.00, 15.00, 16.00, 16.00),   // top
            Block.createCuboidShape(1.00, 12.00, 9.00, 15.00, 13.00, 10.00),   // pole
            Block.createCuboidShape(2.25, 8.40, 8.60, 3.25, 12.00, 10.40),     // Armor stand 1, head
            Block.createCuboidShape(2.00, 5.70, 5.00, 3.50, 8.40, 14.00),      // Armor stand 1, shoulders
            Block.createCuboidShape(2.25, 1.20, 10.40, 3.25, 5.70, 11.90),     // Armor stand 1, left arm
            Block.createCuboidShape(2.25, 1.20, 7.10, 3.25, 5.70, 8.60),       // Armor stand 1, right arm
            Block.createCuboidShape(2.25, -0.60, 6.53, 3.25, 1.20, 12.48),     // Armor stand 1, waist
            Block.createCuboidShape(2.25, -6.90, 10.40, 3.25, -0.60, 11.90),   // Armor stand 1, left leg
            Block.createCuboidShape(2.25, -6.90, 7.10, 3.25, -0.60, 8.60),     // Armor stand 1, right leg
            Block.createCuboidShape(5.75, 8.40, 8.60, 6.75, 12.00, 10.40),     // Armor stand 2, head
            Block.createCuboidShape(5.50, 5.70, 5.00, 7.00, 8.40, 14.00),      // Armor stand 2, shoulders
            Block.createCuboidShape(5.75, 1.20, 10.40, 6.75, 5.70, 11.90),     // Armor stand 2, left arm
            Block.createCuboidShape(5.75, 1.20, 7.10, 6.75, 5.70, 8.60),       // Armor stand 2, right arm
            Block.createCuboidShape(5.75, -0.60, 6.53, 6.75, 1.20, 12.48),     // Armor stand 2, waist
            Block.createCuboidShape(5.75, -6.90, 10.40, 6.75, -0.60, 11.90),   // Armor stand 2, left leg
            Block.createCuboidShape(5.75, -6.90, 7.10, 6.75, -0.60, 8.60),     // Armor stand 2, right leg
            Block.createCuboidShape(9.25, 8.40, 8.60, 10.25, 12.00, 10.40),    // Armor stand 3, head
            Block.createCuboidShape(9.00, 5.70, 5.00, 10.50, 8.40, 14.00),     // Armor stand 3, shoulders
            Block.createCuboidShape(9.25, 1.20, 10.40, 10.25, 5.70, 11.90),    // Armor stand 3, left arm
            Block.createCuboidShape(9.25, 1.20, 7.10, 10.25, 5.70, 8.60),      // Armor stand 3, right arm
            Block.createCuboidShape(9.25, -0.60, 6.53, 10.25, 1.20, 12.48),    // Armor stand 3, waist
            Block.createCuboidShape(9.25, -6.90, 10.40, 10.25, -0.60, 11.90),  // Armor stand 3, left leg
            Block.createCuboidShape(9.25, -6.90, 7.10, 10.25, -0.60, 8.60),    // Armor stand 3, right leg
            Block.createCuboidShape(12.75, 8.40, 8.60, 13.75, 12.00, 10.40),   // Armor stand 4, head
            Block.createCuboidShape(12.50, 5.70, 5.00, 14.00, 8.40, 14.00),    // Armor stand 4, shoulders
            Block.createCuboidShape(12.75, 1.20, 10.40, 13.75, 5.70, 11.90),   // Armor stand 4, left arm
            Block.createCuboidShape(12.75, 1.20, 7.10, 13.75, 5.70, 8.60),     // Armor stand 4, right arm
            Block.createCuboidShape(12.75, -0.60, 6.53, 13.75, 1.20, 12.48),   // Armor stand 4, waist
            Block.createCuboidShape(12.75, -6.90, 10.40, 13.75, -0.60, 11.90), // Armor stand 4, left leg
            Block.createCuboidShape(12.75, -6.90, 7.10, 13.75, -0.60, 8.60)    // Armor stand 4, right leg
        );
        SOUTH_BOTTOM_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.00, 0.00, 4.00, 16.00, 1.00, 16.00),     // bottom
            Block.createCuboidShape(1.00, 4.50, 5.00, 15.00, 5.50, 15.00),     // shelf
            Block.createCuboidShape(0.00, 1.00, 4.00, 1.00, 16.00, 16.00),     // right
            Block.createCuboidShape(15.00, 1.00, 4.00, 16.00, 16.00, 16.00),   // left
            Block.createCuboidShape(1.00, 1.00, 15.00, 15.00, 16.00, 16.00)    // back
        );

        EAST_TOP_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(4.00, 0.00, 15.00, 16.00, 16.00, 16.00),   // left
            Block.createCuboidShape(4.00, 0.00, 0.00, 16.00, 16.00, 1.00),     // right
            Block.createCuboidShape(4.00, 15.00, 1.00, 15.00, 16.00, 15.00),   // back
            Block.createCuboidShape(15.00, 0.00, 1.00, 16.00, 16.00, 15.00),   // top
            Block.createCuboidShape(9.00, 12.00, 1.00, 10.00, 13.00, 15.00),   // pole
            Block.createCuboidShape(8.60, 8.40, 12.75, 10.40, 12.00, 13.75),   // Armor stand 1, head
            Block.createCuboidShape(5.00, 5.70, 12.50, 14.00, 8.40, 14.00),    // Armor stand 1, shoulders
            Block.createCuboidShape(10.40, 1.20, 12.75, 11.90, 5.70, 13.75),   // Armor stand 1, left arm
            Block.createCuboidShape(7.10, 1.20, 12.75, 8.60, 5.70, 13.75),     // Armor stand 1, right arm
            Block.createCuboidShape(6.53, -0.60, 12.75, 12.48, 1.20, 13.75),   // Armor stand 1, waist
            Block.createCuboidShape(10.40, -6.90, 12.75, 11.90, -0.60, 13.75), // Armor stand 1, left leg
            Block.createCuboidShape(7.10, -6.90, 12.75, 8.60, -0.60, 13.75),   // Armor stand 1, right leg
            Block.createCuboidShape(8.60, 8.40, 9.25, 10.40, 12.00, 10.25),    // Armor stand 2, head
            Block.createCuboidShape(5.00, 5.70, 9.00, 14.00, 8.40, 10.50),     // Armor stand 2, shoulders
            Block.createCuboidShape(10.40, 1.20, 9.25, 11.90, 5.70, 10.25),    // Armor stand 2, left arm
            Block.createCuboidShape(7.10, 1.20, 9.25, 8.60, 5.70, 10.25),      // Armor stand 2, right arm
            Block.createCuboidShape(6.53, -0.60, 9.25, 12.48, 1.20, 10.25),    // Armor stand 2, waist
            Block.createCuboidShape(10.40, -6.90, 9.25, 11.90, -0.60, 10.25),  // Armor stand 2, left leg
            Block.createCuboidShape(7.10, -6.90, 9.25, 8.60, -0.60, 10.25),    // Armor stand 2, right leg
            Block.createCuboidShape(8.60, 8.40, 5.75, 10.40, 12.00, 6.75),     // Armor stand 3, head
            Block.createCuboidShape(5.00, 5.70, 5.50, 14.00, 8.40, 7.00),      // Armor stand 3, shoulders
            Block.createCuboidShape(10.40, 1.20, 5.75, 11.90, 5.70, 6.75),     // Armor stand 3, left arm
            Block.createCuboidShape(7.10, 1.20, 5.75, 8.60, 5.70, 6.75),       // Armor stand 3, right arm
            Block.createCuboidShape(6.53, -0.60, 5.75, 12.48, 1.20, 6.75),     // Armor stand 3, waist
            Block.createCuboidShape(10.40, -6.90, 5.75, 11.90, -0.60, 6.75),   // Armor stand 3, left leg
            Block.createCuboidShape(7.10, -6.90, 5.75, 8.60, -0.60, 6.75),     // Armor stand 3, right leg
            Block.createCuboidShape(8.60, 8.40, 2.25, 10.40, 12.00, 3.25),     // Armor stand 4, head
            Block.createCuboidShape(5.00, 5.70, 2.00, 14.00, 8.40, 3.50),      // Armor stand 4, shoulders
            Block.createCuboidShape(10.40, 1.20, 2.25, 11.90, 5.70, 3.25),     // Armor stand 4, left arm
            Block.createCuboidShape(7.10, 1.20, 2.25, 8.60, 5.70, 3.25),       // Armor stand 4, right arm
            Block.createCuboidShape(6.53, -0.60, 2.25, 12.48, 1.20, 3.25),     // Armor stand 4, waist
            Block.createCuboidShape(10.40, -6.90, 2.25, 11.90, -0.60, 3.25),   // Armor stand 4, left leg
            Block.createCuboidShape(7.10, -6.90, 2.25, 8.60, -0.60, 3.25)      // Armor stand 4, right leg
        );
        EAST_BOTTOM_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(4.00, 0.00, 0.00, 16.00, 1.00, 16.00),     // bottom
            Block.createCuboidShape(4.00, 1.00, 15.00, 16.00, 16.00, 16.00),   // shelf
            Block.createCuboidShape(4.00, 1.00, 0.00, 16.00, 16.00, 1.00),     // right
            Block.createCuboidShape(15.00, 1.00, 1.00, 16.00, 16.00, 15.00),   // left
            Block.createCuboidShape(5.00, 4.50, 1.00, 15.00, 5.50, 15.00)      // back
        );

        WEST_TOP_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.00, 0.00, 0.00, 12.00, 16.00, 1.00),     // left
            Block.createCuboidShape(0.00, 0.00, 15.00, 12.00, 16.00, 16.00),   // right
            Block.createCuboidShape(1.00, 15.00, 1.00, 12.00, 16.00, 15.00),   // back
            Block.createCuboidShape(0.00, 0.00, 1.00, 1.00, 16.00, 15.00),     // top
            Block.createCuboidShape(6.00, 12.00, 1.00, 7.00, 13.00, 15.00),    // pole
            Block.createCuboidShape(5.60, 8.40, 2.25, 7.40, 12.00, 3.25),      // Armor stand 1, head
            Block.createCuboidShape(2.00, 5.70, 2.00, 11.00, 8.40, 3.50),      // Armor stand 1, shoulders
            Block.createCuboidShape(4.10, 1.20, 2.25, 5.60, 5.70, 3.25),       // Armor stand 1, left arm
            Block.createCuboidShape(7.40, 1.20, 2.25, 8.90, 5.70, 3.25),       // Armor stand 1, right arm
            Block.createCuboidShape(3.53, -0.60, 2.25, 9.48, 1.20, 3.25),      // Armor stand 1, waist
            Block.createCuboidShape(4.10, -6.90, 2.25, 5.60, -0.60, 3.25),     // Armor stand 1, left leg
            Block.createCuboidShape(7.40, -6.90, 2.25, 8.90, -0.60, 3.25),     // Armor stand 1, right leg
            Block.createCuboidShape(5.60, 8.40, 5.75, 7.40, 12.00, 6.75),      // Armor stand 2, head
            Block.createCuboidShape(2.00, 5.70, 5.50, 11.00, 8.40, 7.00),      // Armor stand 2, shoulders
            Block.createCuboidShape(4.10, 1.20, 5.75, 5.60, 5.70, 6.75),       // Armor stand 2, left arm
            Block.createCuboidShape(7.40, 1.20, 5.75, 8.90, 5.70, 6.75),       // Armor stand 2, right arm
            Block.createCuboidShape(3.53, -0.60, 5.75, 9.48, 1.20, 6.75),      // Armor stand 2, waist
            Block.createCuboidShape(4.10, -6.90, 5.75, 5.60, -0.60, 6.75),     // Armor stand 2, left leg
            Block.createCuboidShape(7.40, -6.90, 5.75, 8.90, -0.60, 6.75),     // Armor stand 2, right leg
            Block.createCuboidShape(5.60, 8.40, 9.25, 7.40, 12.00, 10.25),     // Armor stand 3, head
            Block.createCuboidShape(2.00, 5.70, 9.00, 11.00, 8.40, 10.50),     // Armor stand 3, shoulders
            Block.createCuboidShape(4.10, 1.20, 9.25, 5.60, 5.70, 10.25),      // Armor stand 3, left arm
            Block.createCuboidShape(7.40, 1.20, 9.25, 8.90, 5.70, 10.25),      // Armor stand 3, right arm
            Block.createCuboidShape(3.53, -0.60, 9.25, 9.48, 1.20, 10.25),     // Armor stand 3, waist
            Block.createCuboidShape(4.10, -6.90, 9.25, 5.60, -0.60, 10.25),    // Armor stand 3, left leg
            Block.createCuboidShape(7.40, -6.90, 9.25, 8.90, -0.60, 10.25),    // Armor stand 3, right leg
            Block.createCuboidShape(5.60, 8.40, 12.75, 7.40, 12.00, 13.75),    // Armor stand 4, head
            Block.createCuboidShape(2.00, 5.70, 12.50, 11.00, 8.40, 14.00),    // Armor stand 4, shoulders
            Block.createCuboidShape(4.10, 1.20, 12.75, 5.60, 5.70, 13.75),     // Armor stand 4, left arm
            Block.createCuboidShape(7.40, 1.20, 12.75, 8.90, 5.70, 13.75),     // Armor stand 4, right arm
            Block.createCuboidShape(3.53, -0.60, 12.75, 9.48, 1.20, 13.75),    // Armor stand 4, waist
            Block.createCuboidShape(4.10, -6.90, 12.75, 5.60, -0.60, 13.75),   // Armor stand 4, left leg
            Block.createCuboidShape(7.40, -6.90, 12.75, 8.90, -0.60, 13.75)    // Armor stand 4, right leg
        );
        WEST_BOTTOM_SHAPE = VoxelShapes.union(
            Block.createCuboidShape(0.00, 0.00, 0.00, 12.00, 1.00, 16.00),     // bottom
            Block.createCuboidShape(0.00, 1.00, 0.00, 12.00, 16.00, 1.00),     // shelf
            Block.createCuboidShape(0.00, 1.00, 15.00, 12.00, 16.00, 16.00),   // right
            Block.createCuboidShape(0.00, 1.00, 1.00, 1.00, 16.00, 15.00),     // left
            Block.createCuboidShape(1.00, 4.50, 1.00, 11.00, 5.50, 15.00)      // back
        );
    }

    public GenericArmoireBlock(ArmoireSettings settings) {
        super(settings);

        this.setDefaultState(
            this.stateManager
                .getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(HALF, DoubleBlockHalf.LOWER)
        );
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, HALF);
    }

    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient && player.isCreative()) {
            DoubleBlockHalf half = (DoubleBlockHalf) state.get(HALF);

            if (half == DoubleBlockHalf.UPPER) {
                BlockPos blockPos = pos.down();
                BlockState blockState = world.getBlockState(blockPos);

                if (blockState.isOf(state.getBlock()) && blockState.get(HALF) == DoubleBlockHalf.LOWER) {
                    BlockState blockState2 = blockState.contains(Properties.WATERLOGGED) && (Boolean) blockState.get(Properties.WATERLOGGED) ? Blocks.WATER.getDefaultState() : Blocks.AIR.getDefaultState();
                    world.setBlockState(blockPos, blockState2, 35);
                    world.syncWorldEvent(player, 2001, blockPos, Block.getRawIdFromState(blockState));
                }
            }
        }

        super.onBreak(world, pos, state, player);
    }

    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        world.setBlockState(pos.up(), (BlockState) state.with(HALF, DoubleBlockHalf.UPPER), 3);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction lookDirection = ctx.getPlayerLookDirection();

        if (lookDirection == Direction.DOWN || lookDirection == Direction.UP) {
            return (BlockState) this.getDefaultState().with(FACING, Direction.NORTH);
        }

        return (BlockState) this.getDefaultState().with(FACING, ctx.getPlayerLookDirection());
    }

    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf) state.get(HALF);

        if (direction.getAxis() == Direction.Axis.Y && doubleBlockHalf == DoubleBlockHalf.LOWER == (direction == Direction.UP)) {
            return neighborState.isOf(this) && neighborState.get(HALF) != doubleBlockHalf ? state.with(FACING, neighborState.get(FACING)) : Blocks.AIR.getDefaultState();
        } else {
            return doubleBlockHalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !state.canPlaceAt(world, pos)
                ? Blocks.AIR.getDefaultState()
                : super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
        }
    }

    public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.down();
        BlockState blockState = world.getBlockState(blockPos);
        return state.get(HALF) == DoubleBlockHalf.LOWER ? blockState.isSideSolidFullSquare(world, blockPos, Direction.UP) : blockState.isOf(this);
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction facing = state.get(FACING);
        DoubleBlockHalf half = state.get(HALF);

        return switch (facing) {
            case EAST -> half == DoubleBlockHalf.LOWER ? EAST_BOTTOM_SHAPE : EAST_TOP_SHAPE;
            case SOUTH -> half == DoubleBlockHalf.LOWER ? SOUTH_BOTTOM_SHAPE : SOUTH_TOP_SHAPE;
            case WEST -> half == DoubleBlockHalf.LOWER ? WEST_BOTTOM_SHAPE : WEST_TOP_SHAPE;
            default -> half == DoubleBlockHalf.LOWER ? NORTH_BOTTOM_SHAPE : NORTH_TOP_SHAPE;
        };
    }

    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.IGNORE;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ArmoireBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    /*
     * Slot arrangement:
     * 0  - left: chestplate
     * 1  - left: leggings
     * 2  - left: helmet
     * 3  - left: boots
     * 4  - middle-left: chestplate
     * 5  - middle-left: leggings
     * 6  - middle-left: helmet
     * 7  - middle-left: boots
     * 8  - middle-right: chestplate
     * 9  - middle-right: leggings
     * 10 - middle-right: helmet
     * 11 - middle-right: boots
     * 12 - right: chestplate
     * 13 - right: leggings
     * 14 - right: helmet
     * 15 - right: boots
     */
    private int getTargetSlot(BlockState state, BlockHitResult hit) {
        Direction facing = state.get(FACING);
        DoubleBlockHalf half = state.get(HALF);
        Vec3d localCoords = hit.getPos().subtract(Vec3d.of(hit.getBlockPos()));

        int targetStand = 0; // 0, 1, 2, 3 -> left, middle-left, middle-right, right
        int targetItem = -1; // -1, 0, 1, 2, 3 -> none, chestplate, leggings, helmet, boots

        double x = localCoords.getX();
        double y = localCoords.getY();
        double z = localCoords.getZ();

        /*
         * East
         * z 0.06250 -> 0.28125 (far left)
         * z 0.28126 -> 0.50000 (middle left)
         * z 0.50001 -> 0.71875 (middle right)
         * z 0.71876 -> 0.93750 (far right)
         *
         * West
         * z 0.06250 -> 0.28125 (far right)
         * z 0.28126 -> 0.50000 (middle right)
         * z 0.50001 -> 0.71875 (middle left)
         * z 0.71876 -> 0.93750 (far left)
         *
         * South
         * x 0.06250 -> 0.28125 (far right)
         * x 0.28126 -> 0.50000 (middle right)
         * x 0.50001 -> 0.71875 (middle left)
         * x 0.71876 -> 0.93750 (far left)
         *
         * North
         * x 0.06250 -> 0.28125 (far left)
         * x 0.28126 -> 0.50000 (middle left)
         * x 0.50001 -> 0.71875 (middle right)
         * x 0.71876 -> 0.93750 (far right)
         *
         *
         *
         * Top
         * y  0.07501 -> 0.75000 (chestplate)
         * y -0.43125 -> 0.07500 (leggings)
         *
         * Bottom
         * y 0.56876 -> 1.0 (leggings)
         * y 0.25001 -> 0.56875 (helmet)
         * y 0.00001 -> 0.25000 (boots)
         */
        switch (facing) {
            case NORTH:
                if (x > 0.71875) {
                    targetStand = 3;
                } else if (x > 0.5) {
                    targetStand = 2;
                } else if (x > 0.28125) {
                    targetStand = 1;
                }
                break;
            case EAST:
                if (z > 0.71875) {
                    targetStand = 3;
                } else if (z > 0.5) {
                    targetStand = 2;
                } else if (z > 0.28125) {
                    targetStand = 1;
                }
                break;
            case SOUTH:
                if (x <= 0.28125) {
                    targetStand = 3;
                } else if (x <= 0.5) {
                    targetStand = 2;
                } else if (x <= 0.71875) {
                    targetStand = 1;
                }
                break;
            case WEST:
                if (z <= 0.28125) {
                    targetStand = 3;
                } else if (z <= 0.5) {
                    targetStand = 2;
                } else if (z <= 0.71875) {
                    targetStand = 1;
                }
                break;
        }

        if (half == DoubleBlockHalf.UPPER) {
            if (y <= 0.075) {
                targetItem = 1;
            } else if (y <= 0.75) {
                targetItem = 0;
            }
        } else {
            if (y > 0.56875) {
                targetItem = 1;
            } else if (y > 0.25) {
                targetItem = 2;
            } else {
                targetItem = 3;
            }
        }

        if (targetItem == -1) {
            return -1;
        }

        /*
         * stand	item	slot
         * 0    	0   	0
         * 0    	1   	1
         * 0    	2   	2
         * 0    	3   	3
         * 1    	0   	4
         * 1    	1   	5
         * 1    	2   	6
         * 1    	3   	7
         * 2    	0   	8
         * 2    	1   	9
         * 2    	2   	10
         * 2    	3   	11
         * 3    	0   	12
         * 3    	1   	13
         * 3    	2   	14
         * 3    	3   	15
         */
        return (targetStand * 3) + targetStand + targetItem;
    }

    private void logTargetSlot(int slot) {
        switch (slot) {
            case 0 -> MinekeaMod.LOGGER.info("Target slot: left: chestplate");
            case 1 -> MinekeaMod.LOGGER.info("Target slot: left: leggings");
            case 2 -> MinekeaMod.LOGGER.info("Target slot: left: helmet");
            case 3 -> MinekeaMod.LOGGER.info("Target slot: left: boots");
            case 4 -> MinekeaMod.LOGGER.info("Target slot: middle-left: chestplate");
            case 5 -> MinekeaMod.LOGGER.info("Target slot: middle-left: leggings");
            case 6 -> MinekeaMod.LOGGER.info("Target slot: middle-left: helmet");
            case 7 -> MinekeaMod.LOGGER.info("Target slot: middle-left: boots");
            case 8 -> MinekeaMod.LOGGER.info("Target slot: middle-right: chestplate");
            case 9 -> MinekeaMod.LOGGER.info("Target slot: middle-right: leggings");
            case 10 -> MinekeaMod.LOGGER.info("Target slot: middle-right: helmet");
            case 11 -> MinekeaMod.LOGGER.info("Target slot: middle-right: boots");
            case 12 -> MinekeaMod.LOGGER.info("Target slot: right: chestplate");
            case 13 -> MinekeaMod.LOGGER.info("Target slot: right: leggings");
            case 14 -> MinekeaMod.LOGGER.info("Target slot: right: helmet");
            case 15 -> MinekeaMod.LOGGER.info("Target slot: right: boots");
            default -> MinekeaMod.LOGGER.info("Target slot: none");
        }
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }

        ArmoireBlockEntity entity;
        ArmoireBlockEntity lowerHalf;

        try {
            entity = (ArmoireBlockEntity) world.getBlockEntity(pos);
            if (state.get(HALF) == DoubleBlockHalf.UPPER) {
                lowerHalf = (ArmoireBlockEntity) world.getBlockEntity(pos.down());
            } else {
                lowerHalf = entity;
            }

            assert entity != null;
            assert lowerHalf != null;
        } catch (Exception e) {
            MinekeaMod.LOGGER.error(String.format("The armoire at %s had an invalid block entity.\nBlock Entity: %s", pos, world.getBlockEntity(pos)));

            return ActionResult.FAIL;
        }

        int slot = getTargetSlot(state, hit);

        if (slot == -1) {
            return ActionResult.PASS;
        }

        if (!player.getMainHandStack().isEmpty()) {
            // Try to insert the item in the player's hand into the targeted slot in the armoire
            player.setStackInHand(hand, lowerHalf.tryInsert(slot, player.getStackInHand(hand)));
        } else if (player.isSneaking() && player.getMainHandStack().isEmpty()) {
            if (!lowerHalf.getStack(slot).isEmpty()) {
                ItemScatterer.spawn(
                    world,
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    lowerHalf.removeStack(slot)
                );
            }
        }

        entity.markDirty();
        world.markDirty(pos);

        return ActionResult.SUCCESS;
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof ArmoireBlockEntity) {
                ItemScatterer.spawn(world, pos, (ArmoireBlockEntity) blockEntity);
                world.updateComparators(pos, this);
            }
            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    public Identifier getBlockID() {
        return ((MinekeaBlockSettings<?>) this.settings).getBlockId();
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroup.DECORATIONS)));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        setupResources();
    }

    @Override
    public void setupResources() {
        MinekeaResourcePack.EN_US.blockRespect(this, String.format("%s Armor-oire", ((MinekeaBlockSettings<?>) this.settings).getDefaultTranslation()));

        ArmoireSettings settings = (ArmoireSettings) this.settings;

        Map<String, Identifier> materials = settings.getMaterials();

        Identifier planks = materials.getOrDefault("planks", materials.get("main"));
        Identifier slab = materials.getOrDefault("slab", materials.get("main"));
        Identifier main = materials.getOrDefault("stripped_log", materials.get("main"));

        Identifier MAIN_MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier BOTTOM_MODEL_ID = new Identifier(MAIN_MODEL_ID + "_bottom");
        Identifier TOP_MODEL_ID = new Identifier(MAIN_MODEL_ID + "_top");

        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("BSB", "BCB", "###"),
                JKeys.keys()
                    .key("S", JIngredient.ingredient().item("minecraft:armor_stand"))
                    .key("C", JIngredient.ingredient().item("minecraft:chest"))
                    .key("B", JIngredient.ingredient().item(slab.toString()))
                    .key("#", JIngredient.ingredient().item(planks.toString())),
                JResult.result(getBlockID().toString())
            )
        );

        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.getLootTableID(getBlockID()), LootTable.doubleBlockLootTable(getBlockID()));

        JTextures textures = new JTextures()
            .var("main", Texture.getBlockTextureID(main).toString())
            .var("bar", Texture.getBlockTextureID("minecraft:netherite_block").toString())
            .var("oak_planks", Texture.getBlockTextureID("minecraft:oak_planks").toString());
        JModel bottomModel = JModel.model("minekea:block/furniture/armoires/bottom").textures(textures);
        JModel topModel = JModel.model("minekea:block/furniture/armoires/top").textures(textures);

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:item/furniture/armoire")
                .textures(new JTextures().var("main", String.format("minekea:item/furniture/armoires/%s", settings.getMainMaterial()))),
            ITEM_MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(bottomModel, BOTTOM_MODEL_ID);
        MinekeaResourcePack.RESOURCE_PACK.addModel(topModel, TOP_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(
                JState.variant()
                    .put("facing=north,half=lower", new JBlockModel(BOTTOM_MODEL_ID).y(180))
                    .put("facing=north,half=upper", new JBlockModel(TOP_MODEL_ID).y(180))
                    .put("facing=south,half=lower", new JBlockModel(BOTTOM_MODEL_ID))
                    .put("facing=south,half=upper", new JBlockModel(TOP_MODEL_ID))
                    .put("facing=east,half=lower", new JBlockModel(BOTTOM_MODEL_ID).y(270))
                    .put("facing=east,half=upper", new JBlockModel(TOP_MODEL_ID).y(270))
                    .put("facing=west,half=lower", new JBlockModel(BOTTOM_MODEL_ID).y(90))
                    .put("facing=west,half=upper", new JBlockModel(TOP_MODEL_ID).y(90))
            ),
            getBlockID()
        );
    }

    public static class ArmoireSettings extends MinekeaBlockSettings<ArmoireSettings> {
        public ArmoireSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sfurniture/armoires/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
