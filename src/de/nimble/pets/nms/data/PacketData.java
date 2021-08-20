package de.nimble.pets.nms.data;

import com.comphenix.protocol.events.PacketContainer;

public abstract class PacketData<T> {

    public int index;
    public T data;

    public PacketData(int index, T data) {
        this.index = index;
        this.data = data;
    }

    public abstract void write(PacketContainer container);

}
