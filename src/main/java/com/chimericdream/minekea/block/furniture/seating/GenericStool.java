package com.chimericdream.minekea.block.furniture.seating;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.entities.mounts.SeatEntity;
import com.chimericdream.minekea.item.ItemGroups;
import com.chimericdream.minekea.resource.LootTable;
import com.chimericdream.minekea.resource.MinekeaResourcePack;
import com.chimericdream.minekea.resource.Model;
import com.chimericdream.minekea.settings.MinekeaBlockSettings;
import com.chimericdream.minekea.util.MinekeaBlock;
import net.devtech.arrp.json.blockstate.JBlockModel;
import net.devtech.arrp.json.blockstate.JState;
import net.devtech.arrp.json.models.JModel;
import net.devtech.arrp.json.models.JTextures;
import net.devtech.arrp.json.recipe.*;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;
import java.util.Objects;

public class GenericStool extends Block implements MinekeaBlock {
    private static final VoxelShape SEAT_SHAPE;
    private static final VoxelShape[] LEG_SHAPES;

    static {
        SEAT_SHAPE = Block.createCuboidShape(3.0, 6.0, 3.0, 13.0, 8.0, 13.0);
        LEG_SHAPES = new VoxelShape[]{
            Block.createCuboidShape(4.0, 0.0, 4.0, 6.0, 6.0, 6.0), // north-west
            Block.createCuboidShape(10.0, 0.0, 4.0, 12.0, 6.0, 6.0), // north-east
            Block.createCuboidShape(10.0, 0.0, 10.0, 12.0, 6.0, 12.0), // south-east
            Block.createCuboidShape(4.0, 0.0, 10.0, 6.0, 6.0, 12.0) // south-west
        };
    }

    public GenericStool(StoolSettings settings) {
        super(settings);
    }

    @Override
    public Identifier getBlockID() {
        return ((StoolSettings) this.settings).getBlockId();
    }

    @Override
    public void register() {
        register(false);
    }

    public void register(boolean isFlammable) {
        Registry.register(Registry.BLOCK, getBlockID(), this);
        Registry.register(Registry.ITEM, getBlockID(), new BlockItem(this, new Item.Settings().group(ItemGroups.FURNITURE)));

        if (isFlammable) {
            FuelRegistry.INSTANCE.add(this, 300);
            FlammableBlockRegistry.getDefaultInstance().add(this, 30, 20);
        }

        setupResources();
    }

    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return super.getCollisionShape(state, world, pos, context);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient()) {
            return ActionResult.SUCCESS;
        }

        List<SeatEntity> seats = world.getEntitiesByClass(SeatEntity.class, new Box(pos), (Object) -> true);

        if (seats.size() == 0) {
            SeatEntity seat = Seats.SEAT_ENTITY.create(world);
            Vec3d seatPos = new Vec3d(hit.getBlockPos().getX() + 0.5d, hit.getBlockPos().getY() + 1.05d, hit.getBlockPos().getZ() + 0.5d);

            seat.updatePosition(seatPos.getX(), seatPos.getY(), seatPos.getZ());
            world.spawnEntity(seat);
            player.startRiding(seat);

            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(SEAT_SHAPE, LEG_SHAPES);
    }

    @Override
    public void setupResources() {
        MinekeaBlockSettings<?> settings = (MinekeaBlockSettings<?>) this.settings;
        MinekeaResourcePack.EN_US.blockRespect(this, String.format(settings.getNamePattern(), settings.getIngredientName()));

        Identifier PLANK_MATERIAL = settings.getMaterial("planks");
        Identifier LOG_MATERIAL = settings.getMaterial("log");

        Identifier plankTexture = settings.getBlockTexture("planks");
        Identifier logTexture = settings.getBlockTexture("log");

        Identifier MODEL_ID = Model.getBlockModelID(getBlockID());
        Identifier ITEM_MODEL_ID = Model.getItemModelID(getBlockID());

        MinekeaResourcePack.RESOURCE_PACK.addRecipe(
            getBlockID(),
            JRecipe.shaped(
                JPattern.pattern("PP", "LL"),
                JKeys.keys()
                    .key("P", JIngredient.ingredient().item(PLANK_MATERIAL.toString()))
                    .key("L", JIngredient.ingredient().item(LOG_MATERIAL.toString())),
                JResult.stackedResult(getBlockID().toString(), 2)
            )
        );
        MinekeaResourcePack.RESOURCE_PACK.addLootTable(LootTable.blockID(getBlockID()), LootTable.dropSelf(getBlockID()));

        JTextures textures = new JTextures()
            .var("log", logTexture.toString())
            .var("planks", plankTexture.toString());

        MinekeaResourcePack.RESOURCE_PACK.addModel(
            JModel.model("minekea:block/furniture/seating/stool").textures(textures),
            MODEL_ID
        );

        MinekeaResourcePack.RESOURCE_PACK.addModel(JModel.model(MODEL_ID), ITEM_MODEL_ID);

        MinekeaResourcePack.RESOURCE_PACK.addBlockState(
            JState.state(JState.variant().put("", new JBlockModel(MODEL_ID))),
            getBlockID()
        );
    }

    public static class StoolSettings extends MinekeaBlockSettings<StoolSettings> {
        public StoolSettings(DefaultSettings settings) {
            super((DefaultSettings) settings.nonOpaque());
        }

        public String getNamePattern() {
            return Objects.requireNonNullElse(namePatternOverride, "%s Stool");
        }

        @Override
        public Identifier getBlockId() {
            if (blockId == null) {
                blockId = new Identifier(ModInfo.MOD_ID, String.format("%sfurniture/seating/stools/%s", ModInfo.getModPrefix(modId), mainMaterial));
            }

            return blockId;
        }
    }
}
