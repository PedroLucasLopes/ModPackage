package net.pedrolucaslopes.modpackage.deathcoodinates;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.resources.ResourceLocation;

public interface renderInterface {
    void render(PlayerDeathWaypoint entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight);

    ResourceLocation getTextureLocation(PlayerDeathWaypoint entity);
}
