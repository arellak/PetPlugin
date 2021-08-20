package de.nimble.pets.nms.data;

import com.comphenix.protocol.events.PacketContainer;

public class IntegerData extends PacketData<Integer> {

    public IntegerData(int index, int data) {
        super(index, data);
    }

    @Override
    public void write(PacketContainer container) {
        container.getIntegers().write(index, data);
    }
}
