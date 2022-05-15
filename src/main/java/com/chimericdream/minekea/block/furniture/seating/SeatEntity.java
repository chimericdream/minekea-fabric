package com.chimericdream.minekea.block.furniture.seating;

import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class SeatEntity extends Entity {
    public SeatEntity(EntityType<? extends SeatEntity> entityType, World world) {
        super(entityType, world);
    }

    public SeatEntity(World world) {
        super(Seats.SEAT_ENTITY, world);
    }

    @Override
    protected void initDataTracker() {

    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    public Packet<?> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    public void tick() {
        if (this.age > 20 && this.getPassengerList().isEmpty()) {
            this.kill();
        }
    }

    public static class EmptyRenderer extends EntityRenderer<SeatEntity> {
        protected EmptyRenderer(EntityRendererFactory.Context ctx) {
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
