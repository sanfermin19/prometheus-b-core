package com.fermine.prometheusb;

import com.fermine.prometheusb.block.PrometheusBBlockRegistry;
import com.fermine.prometheusb.item.PrometheusBItemRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
@Mod(PrometheusB.MOD_ID)
public class PrometheusB
{
    public static final String MOD_ID = "prometheusb";
    public PrometheusB(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        PrometheusBItemRegistry.register(modEventBus);
        PrometheusBBlockRegistry.register(modEventBus);
    }
}
