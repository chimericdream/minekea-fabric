package com.chimericdream.minekea.network;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;

public record CyclePainterColorPayload(boolean cyclePressed) implements CustomPayload {
    public static final CustomPayload.Id<CyclePainterColorPayload> ID = new CustomPayload.Id<>(ServerNetworking.CYCLE_PAINTER_COLOR);
    public static final PacketCodec<RegistryByteBuf, CyclePainterColorPayload> CODEC = PacketCodec.tuple(PacketCodecs.BOOL, CyclePainterColorPayload::cyclePressed, CyclePainterColorPayload::new);

    @Override
    public Id<CyclePainterColorPayload> getId() {
        return ID;
    }
}
