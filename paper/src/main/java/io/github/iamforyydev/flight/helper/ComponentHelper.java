package io.github.iamforyydev.flight.helper;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ComponentHelper {

    private static final MiniMessage miniMessage = MiniMessage.miniMessage();

    public static @NotNull Component asComponent(final @Nullable String message) {
        return message == null || message.isEmpty() ? Component.empty() : miniMessage.deserialize(message);
    }

}
