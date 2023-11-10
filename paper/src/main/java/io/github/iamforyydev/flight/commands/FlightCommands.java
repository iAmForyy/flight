package io.github.iamforyydev.flight.commands;

import io.github.iamforyydev.flight.message.MessageKey;
import io.github.iamforyydev.flight.message.MessageManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FlightCommands implements CommandExecutor {

    private final MessageManager messageManager;
    public FlightCommands(final MessageManager messageManager) {
        this.messageManager = messageManager;
    }

    @Override
    public boolean onCommand(
            final @NotNull CommandSender sender,
            final @NotNull Command command,
            final @NotNull String label,
            final @NotNull String[] args
    ) {

        if (sender instanceof ConsoleCommandSender) {
            return false;
        }

        final Player player = (Player) sender;
        if (player.hasPermission("flight.use")) {
            if (player.getAllowFlight()) {
                player.setFlying(false);
                player.setAllowFlight(false);
                this.messageManager.send(player, MessageKey.FLIGHT_DISABLED);
                return true;
            }

            player.setFlying(true);
            player.setAllowFlight(true);
            this.messageManager.send(player, MessageKey.FLIGHT_ENABLED);
            return true;
        }

        this.messageManager.send(player, MessageKey.NO_PERMISSION);
        return true;
    }
}
