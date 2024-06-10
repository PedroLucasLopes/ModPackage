package net.pedrolucaslopes.modpackage;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pedrolucaslopes.modpackage.deathcoodinates.PlayerDeathWaypoint;

@Mod.EventBusSubscriber(modid = ModPackage.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ModPackage.MOD_ID);

    public static final RegistryObject<EntityType<PlayerDeathWaypoint>> DEATH_WAYPOINT = ENTITIES.register("death_waypoint",
            () -> EntityType.Builder.of(PlayerDeathWaypoint::new, MobCategory.MISC).sized(1.0f, 1.0f).build("death_waypoint"));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }
}