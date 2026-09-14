// Copyright (C) 2026 Dasik (Rifaditya) | GNU GPLv3
package net.instantgratification.stewstacker.network;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record StewLimitSyncPayload(int stewLimit) implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<StewLimitSyncPayload> TYPE = new CustomPacketPayload.Type<>(
        Identifier.fromNamespaceAndPath("stew-stacker", "sync_limit")
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, StewLimitSyncPayload> CODEC = StreamCodec.composite(
        ByteBufCodecs.VAR_INT,
        StewLimitSyncPayload::stewLimit,
        StewLimitSyncPayload::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
