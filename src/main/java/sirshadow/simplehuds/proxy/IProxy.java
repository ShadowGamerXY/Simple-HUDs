package sirshadow.hudframework.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

/**
 * Created by Shadow on 31.5.2017.
 */
public interface IProxy {
    void serverStartEvent(FMLServerStartingEvent e);
    void preInit(FMLPreInitializationEvent e);
    void init(FMLInitializationEvent e);

    void postInit(FMLPostInitializationEvent e);

    EntityPlayer getClientPlayer();
}
