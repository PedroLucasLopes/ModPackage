package net.pedrolucaslopes.modpackage.deathcoodinates;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.pedrolucaslopes.modpackage.ModEntities;
import org.jetbrains.annotations.NotNull;

public class PlayerDeathWaypoint extends Entity {
    public PlayerDeathWaypoint(EntityType<? extends PlayerDeathWaypoint> type, Level world) {
        super(type, world);
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.@NotNull Builder builder) {}

    @Override
    protected void readAdditionalSaveData(@NotNull CompoundTag compoundTag) {}

    @Override
    protected void addAdditionalSaveData(@NotNull CompoundTag compoundTag) {}

    @Override
    public void tick() {
        super.tick();
    }
}
