package de.nimble.pets.nms.data;

import com.comphenix.protocol.events.PacketContainer;

public class DoubleData extends PacketData<Double> {

    public DoubleData(int index, double data) {
        super(index, data);
    }

    @Override
    public void write(PacketContainer container) {
        container.getDoubles().write(index, data);
    }
}
