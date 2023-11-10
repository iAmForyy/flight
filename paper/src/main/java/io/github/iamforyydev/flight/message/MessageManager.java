package io.github.iamforyydev.flight.message;

import io.github.iamforyydev.flight.helper.ComponentHelper;
import net.kyori.adventure.text.Component;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MessageManager {

    private final FileConfiguration configuration;
    public MessageManager(final @NotNull FileConfiguration configuration) {
        this.configuration = configuration;
    }

    public void send(final @NotNull Player player, final @NotNull String messageKey) {
        final String message = this.content(messageKey);
        final Component component = ComponentHelper.asComponent(message);

        player.sendMessage(component);
    }

    private @Nullable String content(final @NotNull String messageKey) {
        return this.configuration.getString(messageKey);
    }

}
