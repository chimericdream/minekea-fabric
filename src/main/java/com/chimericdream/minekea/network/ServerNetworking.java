package com.chimericdream.minekea.network;

import com.chimericdream.minekea.ModInfo;
import com.chimericdream.minekea.block.furniture.armoires.Armoires;
import com.chimericdream.minekea.entities.blocks.furniture.ArmoireBlockEntity;
import com.chimericdream.minekea.item.tools.PainterItem;
import com.chimericdream.minekea.registry.ColoredBlocksRegistry;
import com.chimericdream.minekea.util.NbtHelpers;
import com.chimericdream.minekea.util.StreamUtils;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerBlockEntityEvents;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.CustomModelDataComponent;
import net.minecraft.component.type.NbtComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class ServerNetworking {
    public static Identifier CYCLE_PAINTER_COLOR = Identifier.of(ModInfo.MOD_ID, "events/items/painter/cycle");

    public static void init() {
        PayloadTypeRegistry.playC2S().register(CyclePainterColorPayload.ID, CyclePainterColorPayload.CODEC);
        registerCyclePainterColorPacketHandler();
        registerArmoireEventListeners();
    }

    private static void registerArmoireEventListeners() {
        ServerBlockEntityEvents.BLOCK_ENTITY_LOAD.register((entity, world) -> {
            if (entity.getType() == Armoires.ARMOIRE_BLOCK_ENTITY) {
                ArmoireBlockEntity armoire = (ArmoireBlockEntity) entity;
                armoire.initializeArmorStands(entity.getCachedState());
            }
        });

        ServerBlockEntityEvents.BLOCK_ENTITY_UNLOAD.register((entity, world) -> {
            if (entity.getType() == Armoires.ARMOIRE_BLOCK_ENTITY) {
                ArmoireBlockEntity armoire = (ArmoireBlockEntity) entity;
                armoire.destroyArmorStands();
            }
        });
    }

    private static void registerCyclePainterColorPacketHandler() {
        ServerPlayNetworking.registerGlobalReceiver(CyclePainterColorPayload.ID, ServerNetworking::receiveCyclePainterColorPacket);
    }

    private static void receiveCyclePainterColorPacket(CyclePainterColorPayload payload, ServerPlayNetworking.Context context) {
        MinecraftServer server = context.server();
        ServerPlayerEntity player = context.player();

        if (server != null && player != null) {
            server.execute(() -> {
                ItemStack heldItem = StreamUtils.asStream(player.getHandItems().iterator())
                    .filter((itemStack) -> itemStack.getItem() instanceof PainterItem)
                    .findFirst()
                    .orElse(ItemStack.EMPTY);

                if (heldItem.isEmpty()) {
                    return;
                }

                ColoredBlocksRegistry.BlockColor nextColor = PainterItem.getNextColor(heldItem);

                NbtCompound nbt = new NbtCompound();
                nbt.putString("current_color", nextColor.toString());
                heldItem.set(DataComponentTypes.CUSTOM_DATA, NbtComponent.of(nbt));
                heldItem.set(DataComponentTypes.CUSTOM_MODEL_DATA, new CustomModelDataComponent(nextColor.getModelNumber()));

                NbtHelpers.setCustomDataFromNbt(heldItem, PainterItem.makeNbt(nbt, nextColor));
            });
        }
    }
}
