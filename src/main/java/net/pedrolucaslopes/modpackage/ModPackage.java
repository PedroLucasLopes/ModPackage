package net.pedrolucaslopes.modpackage;

import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.pedrolucaslopes.modpackage.deathcoodinates.PlayerDeathCoordinates;
import net.pedrolucaslopes.modpackage.deathcoodinates.PlayerDeathWaypoint;
import net.pedrolucaslopes.modpackage.deathcoodinates.PlayerDeathWaypointRenderer;
import org.slf4j.Logger;

@Mod(ModPackage.MOD_ID)
public class ModPackage
{
    public static final String MOD_ID = "modpackage";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ModPackage()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    public void setDeathWaypoint(Player player) {
        if (player != null) {
            Vec3 playerCoordinates = player.position();
            Level world = player.level();

            if(!world.isClientSide){
                PlayerDeathWaypoint waypoint = new PlayerDeathWaypoint(ModEntities.DEATH_WAYPOINT.get(), world);
                waypoint.setPos(playerCoordinates.x, playerCoordinates.y, playerCoordinates.z);
                world.addFreshEntity(waypoint);
            }
        }
    }

    @SubscribeEvent
    public void onPlayerDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            PlayerDeathCoordinates.getDeathCoordinates(player);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }

        @SubscribeEvent
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
            event.registerEntityRenderer(ModEntities.DEATH_WAYPOINT.get(), PlayerDeathWaypointRenderer::new);
        }
    }
}