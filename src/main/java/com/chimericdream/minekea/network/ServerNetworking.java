package com.chimericdream.minekea.network;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.item.tools.PainterItem;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry;
import com.chimericdream.minekea.util.StreamUtils;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class ServerNetworking {
    public static Identifier CYCLE_PAINTER_COLOR = new Identifier(ModInfo.MOD_ID, "events/items/painter/cycle");

    public static void init() {
        registerCyclePainterColorPacketHandler();
    }

    private static void registerCyclePainterColorPacketHandler() {
        ServerPlayNetworking.registerGlobalReceiver(CYCLE_PAINTER_COLOR, ServerNetworking::receiveCyclePainterColorPacket);
    }

    private static void receiveCyclePainterColorPacket(MinecraftServer server, ServerPlayerEntity player, ServerPlayNetworkHandler handler, PacketByteBuf buf, PacketSender responseSender) {
        server.execute(() -> {
            ItemStack heldItem = StreamUtils.asStream(player.getHandItems().iterator())
                .filter((itemStack) -> itemStack.getItem() instanceof PainterItem)
                .findFirst()
                .orElse(ItemStack.EMPTY);

            if (heldItem.isEmpty()) {
                return;
            }

            ColoredBlocksRegistry.BlockColor nextColor = PainterItem.getNextColor(heldItem);
            NbtCompound nbt = heldItem.getOrCreateNbt();

            heldItem.setNbt(PainterItem.makeNbt(nbt, nextColor));
        });
    }
}
