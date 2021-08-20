package de.nimble.listener;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class PlayerMoveListener implements Listener {

    private JavaPlugin plugin;
    public PlayerMoveListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Location loc = event.getPlayer().getLocation();
        ProtocolManager manager = ProtocolLibrary.getProtocolManager();

    }

}