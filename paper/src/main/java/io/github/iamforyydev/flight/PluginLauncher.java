package io.github.iamforyydev.flight;

import io.github.iamforyydev.flight.commands.FlightCommands;
import io.github.iamforyydev.flight.message.MessageManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginLauncher extends JavaPlugin {

    private MessageManager messageManager;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.messageManager = new MessageManager(this.getConfig());
        this.getCommand("flight").setExecutor(new FlightCommands(this.messageManager));
    }

    public MessageManager messageManager() {
        return this.messageManager;
    }
}
