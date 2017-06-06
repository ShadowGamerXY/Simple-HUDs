package sirshadow.simplehuds.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

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
    }
}
