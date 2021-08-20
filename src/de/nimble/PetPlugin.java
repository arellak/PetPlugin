package de.nimble;

import de.nimble.commands.PetCommand;
import de.nimble.listener.PlayerMoveListener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class PetPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        loadConfig();
        loadCommands();
        registerEvents(getServer().getPluginManager());
    }

    @Override
    public void onDisable() {

    }

    public void registerEvents(PluginManager pluginManager) {
        pluginManager.registerEvents(new PlayerMoveListener(this), this);
    }

    public void loadCommands() {
        getCommand("pet").setExecutor(new PetCommand(this));
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

}
