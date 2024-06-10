package net.pedrolucaslopes.modpackage.deathcoodinates;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class PlayerDeathCoordinates {
    public static void getDeathCoordinates(Player player) {
        if (player != null) {
            Vec3 playerCoordinates = player.position();
            String coordinatesMessage = String.format("X: %.2f, Y: %.2f, Z: %.2f",
                    playerCoordinates.x(), playerCoordinates.y(), playerCoordinates.z());

            MutableComponent baseMessage = Component.literal("You died at coordinates: ")
                    .withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xd1a128))
                            .withBold(true));

            MutableComponent coordinatesComponent = Component.literal(coordinatesMessage)
                    .withStyle(Style.EMPTY.withColor(TextColor.fromRgb(0xFF0000))
                            .withBold(true));

            MutableComponent deathMessage = baseMessage.append(coordinatesComponent);
            player.sendSystemMessage(deathMessage);
        }
    }
}