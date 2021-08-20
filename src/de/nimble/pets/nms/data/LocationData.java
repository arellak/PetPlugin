package de.nimble.pets.nms.data;

import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.Location;

public class LocationData extends PacketData<Location> {

    public LocationData(Location data) {
        super(0, data);
    }

    @Override
    public void write(PacketContainer container) {
        container.getDoubles().write(0, data.getX());
        container.getDoubles().write(1, data.getY());
        container.getDoubles().write(2, data.getZ());
    }
}
