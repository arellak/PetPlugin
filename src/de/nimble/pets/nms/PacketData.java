package de.nimble.pets.nms;

public class PacketData<T> {

    public int index;
    public T data;

    public PacketData(int index, T data) {
        this.index = index;
        this.data = data;
    }

}
