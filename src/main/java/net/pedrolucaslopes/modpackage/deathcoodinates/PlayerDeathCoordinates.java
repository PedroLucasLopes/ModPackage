package net.pedrolucaslopes.modpackage.deathcoodinates;

import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.slf4j.Logger;

public class PlayerDeathCoordinates {
    public static void getCoordinates(Player player) {
        if (player != null) {
            Vec3 playerCoordinates = player.position();
            String deathMessage = String.format("You died at coordinates X: %.2f, Y: %.2f, Z: %.2f",
                    playerCoordinates.x(), playerCoordinates.y(), playerCoordinates.z());
            player.sendSystemMessage(Component.literal(deathMessage));
        }
    }
}