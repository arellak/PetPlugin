package de.nimble.pets.nms.data;

import com.comphenix.protocol.events.PacketContainer;

public class ByteData extends PacketData<Byte> {

    public ByteData(int index, Byte data) {
        super(index, data);
    }

    @Override
    public void write(PacketContainer container) {
        container.getBytes().write(index, data);
    }
}
