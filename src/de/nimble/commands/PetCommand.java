package de.nimble.commands;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketContainer;
import de.nimble.pets.nms.data.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

public class PetCommand implements CommandExecutor {

    private JavaPlugin plugin;
    public PetCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String args, String[] label) {
        if(!(commandSender instanceof Player)) return false;

        Player player = (Player) commandSender;
        ProtocolManager manager = ProtocolLibrary.getProtocolManager();

        PacketContainer container = new PacketContainer(PacketType.Play.Server.SPAWN_ENTITY_LIVING);

        Location original = player.getLocation();

        IntegerData entityId = new IntegerData(0, 500);
        entityId.write(container);
        IntegerData entityType = new IntegerData(1, 11);
        entityType.write(container);

        UUIDData uuid = new UUIDData(0, UUID.randomUUID());
        uuid.write(container);

        LocationData petLocation = new LocationData(original);
        petLocation.write(container);


        // container.getIntegers().write(0, 500);
        // container.getIntegers().write(1, 11);
        // container.getUUIDs().write(0, UUID.randomUUID());

        /*container.getDoubles()
                .write(0, original.getX())
                .write(1, original.getY())
                .write(2, original.getZ());
         */

        Bukkit.getServer().getScheduler().runTaskTimer(plugin, task -> {
            Location location = original.clone().setDirection(player.getLocation().subtract(original.clone()).toVector());
            byte yaw = (byte) (location.getYaw() * 256 / 360);
            byte pitch = (byte) (location.getPitch() * 256 / 360);

            PacketContainer headRotation = new PacketContainer(PacketType.Play.Server.ENTITY_HEAD_ROTATION);

            entityId.write(headRotation);

            /* headRotation.getIntegers()
                            .write(0, 500);
             */

            ByteData yawData = new ByteData(0, yaw);
            yawData.write(headRotation);

            /*
                headRotation.getBytes()
                    .write(0, yaw);
             */

            try {
                 manager.sendServerPacket(player, headRotation);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            PacketContainer entityLook = new PacketContainer(PacketType.Play.Server.ENTITY_LOOK);
            entityId.write(entityLook);

            // entityLook.getIntegers().write(0, 500);
            yawData.write(entityLook);
            ByteData pitchData = new ByteData(1, pitch);
            pitchData.write(entityLook);

            BooleanData bData = new BooleanData(0, false);
            bData.write(entityLook);

            /*entityLook.getBytes()
                    .write(0, yaw)
                    .write(1, pitch);

            entityLook.getBooleans()
                    .write(0, false);
             */
            try {
                manager.sendServerPacket(player, entityLook);
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }, 0, 2);

        try {
            manager.sendServerPacket(player, container);
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return true;
    }

}