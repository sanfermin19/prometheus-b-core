package com.fermine.prometheusb;

import com.fermine.prometheusb.block.PrometheusBBlockRegistry;
import com.fermine.prometheusb.item.PrometheusBItemRegistry;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(PrometheusB.MOD_ID)
public class PrometheusB
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "prometheusb";


    public PrometheusB(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();
        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        PrometheusBItemRegistry.register(modEventBus);
        PrometheusBBlockRegistry.register(modEventBus);
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    { }

    // Add the example block item to the building blocks tab

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(PrometheusBItemRegistry.TESTY);
        }
    }
}
