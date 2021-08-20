package de.nimble.pets.nms.data;

import com.comphenix.protocol.events.PacketContainer;

import java.util.UUID;

public class UUIDData extends PacketData<UUID> {

    public UUIDData(int index, UUID data) {
        super(index, data);
    }

    @Override
    public void write(PacketContainer container) {
        container.getUUIDs().write(index, data);
    }
}
