package sirshadow.hudframework.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import sirshadow.hudframework.CommandHUD;
import sun.rmi.log.LogHandler;

/**
 * Created by Shadow on 31.5.2017.
 */
public class ServerProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }

    @Override
    public void init(FMLInitializationEvent e) {
        super.init(e);
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {
        super.postInit(e);
    }

    @Override
    public void serverStartEvent(FMLServerStartingEvent e) {
        super.serverStartEvent(e);
        System.out.println("SERVER");
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return null;
    }
}
