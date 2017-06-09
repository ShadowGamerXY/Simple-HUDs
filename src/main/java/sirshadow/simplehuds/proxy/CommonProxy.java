package sirshadow.simplehuds.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import sirshadow.simplehuds.ConfigurationHandler;

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
    }
}
