package de.nimble.pets.nms;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.entity.Player;

public class NMSHelper {

    private static NMSHelper instance;

    public static NMSHelper getInstance() {
        if(instance == null) {
            instance = new NMSHelper();
        }
        return instance;
    }

    private NMSHelper() {
    }

    public void sendPacket(Player player, PacketType type) {
        if(player == null) return;
        PacketContainer newPacket = new PacketContainer(type);


        // newPacket.getIntegers().write()
    }
}
