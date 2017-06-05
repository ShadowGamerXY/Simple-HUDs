package sirshadow.hudframework.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import sirshadow.hudframework.ConfigurationHandler;
import sirshadow.hudframework.EventHandler;
import sirshadow.hudframework.HudFramework;
import sirshadow.hudframework.client.GuiHandler;

/**
 * Created by Shadow on 31.5.2017.
 */
public class CommonProxy implements IProxy {


    @Override
    public void serverStartEvent(FMLServerStartingEvent e) {
    }

    @Override
    public void preInit(FMLPreInitializationEvent e) {
        registerEvents();
        ConfigurationHandler.init(e.getSuggestedConfigurationFile());
    }

    @Override
    public void init(FMLInitializationEvent e) {
        NetworkRegistry.INSTANCE.registerGuiHandler(HudFramework.instance,new GuiHandler());
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }

    @Override
    public EntityPlayer getClientPlayer() {
        return null;
    }


    public void registerEvents(){
        MinecraftForge.EVENT_BUS.register(new ConfigurationHandler());
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
