package com.chimericdream.minekea.entities.mounts;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.seating.Seats;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.server.network.EntityTrackerEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class SeatEntity extends Entity {
    public static final Identifier ENTITY_ID = Identifier.of(ModInfo.MOD_ID, "entities/mounts/seat");

    public SeatEntity(EntityType<? extends SeatEntity> entityType, World world) {
        super(entityType, world);
    }

    public SeatEntity(World world) {
        super(Seats.SEAT_ENTITY, world);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    public net.minecraft.network.packet.Packet<ClientPlayPacketListener> createSpawnPacket(EntityTrackerEntry entityTrackerEntry) {
        return new EntitySpawnS2CPacket(this, entityTrackerEntry);
    }

    @Override
    public void tick() {
        if (this.age > 20 && this.getPassengerList().isEmpty()) {
            this.kill();
        }
    }

    public static class EmptyRenderer extends EntityRenderer<SeatEntity> {
        public EmptyRenderer(EntityRendererFactory.Context ctx) {
            super(ctx);
        }

        @Override
        public boolean shouldRender(SeatEntity entity, Frustum frustum, double d, double e, double f) {
            return false;
        }

        @Override
        public Identifier getTexture(SeatEntity entity) {
            return null;
        }
    }
}
