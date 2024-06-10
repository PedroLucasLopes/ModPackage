package net.pedrolucaslopes.modpackage.deathcoodinates;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.pedrolucaslopes.modpackage.ModPackage;
import org.jetbrains.annotations.NotNull;

public class PlayerDeathWaypointRenderer extends EntityRenderer<PlayerDeathWaypoint> {
    public PlayerDeathWaypointRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(@NotNull PlayerDeathWaypoint entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull PlayerDeathWaypoint entity) {
        return new ResourceLocation(ModPackage.MOD_ID, "");
    }
}
