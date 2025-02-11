package com.c2h6s.anvil_tinkering;

import com.c2h6s.anvil_tinkering.register.AnTFluids;
import com.c2h6s.anvil_tinkering.register.AnTItems;
import com.c2h6s.anvil_tinkering.register.AnTModifiers;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import slimeknights.tconstruct.smeltery.TinkerSmeltery;

import java.util.Random;

@Mod(AnvilTinkering.MODID)
public class AnvilTinkering
{
    public static final String MODID = "anvil_tinkering";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static ResourceLocation getNamespacedLocation(String name){
        return new ResourceLocation(MODID,name);
    }
    public static Random RANDOM = new Random();

    public AnvilTinkering(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::addCreative);
        MinecraftForge.EVENT_BUS.register(this);
        AnTFluids.FLUIDS.register(modEventBus);
        AnTItems.ITEMS.register(modEventBus);
        AnTModifiers.MODIFIER.register(modEventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey()== TinkerSmeltery.tabSmeltery.getKey()){
            event.accept(AnTItems.PRESSURE_PLATE_CAST.get());
            event.accept(AnTItems.PRESSURE_PLATE_CAST.getSand());
            event.accept(AnTItems.PRESSURE_PLATE_CAST.getRedSand());
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
