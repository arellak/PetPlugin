package de.nimble.pets.nms.data;

import com.comphenix.protocol.events.PacketContainer;

public class BooleanData extends PacketData<Boolean> {

    public BooleanData(int index, Boolean data) {
        super(index, data);
    }

    @Override
    public void write(PacketContainer container) {
        container.getBooleans().write(index, data);
    }
}
