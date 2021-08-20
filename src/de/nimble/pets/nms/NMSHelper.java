package de.nimble.pets.nms;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import de.nimble.pets.nms.data.PacketData;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;

public class NMSHelper {

    public void sendPacket(PacketType type, Player player, PacketData... data) {
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();

        PacketContainer container = new PacketContainer(type);



        try {
            protocolManager.sendServerPacket(player, container);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}