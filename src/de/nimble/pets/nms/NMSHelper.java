package de.nimble.pets.nms;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import org.bukkit.entity.Player;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.UUID;

public class NMSHelper {

    public void sendPacket(PacketType type, Player player, PacketData... data) {
        ProtocolManager protocolManager = ProtocolLibrary.getProtocolManager();

        PacketContainer container = new PacketContainer(type);

        Arrays.stream(data).forEach(packetData -> {
            if(packetData.data instanceof Integer) {

            } else if(packetData.data instanceof Double) {

            } else if(packetData.data instanceof Byte) {

            } else if(packetData.data instanceof UUID) {

            } else if(packetData.data instanceof Short) {

            }
        });

        Arrays.stream(data).filter(pd -> pd.data instanceof Integer).forEach(pd -> container.getIntegers().write(pd.index, (int) pd.data));

        try {
            protocolManager.sendServerPacket(player, container);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}