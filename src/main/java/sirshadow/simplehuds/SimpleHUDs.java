package sirshadow.simplehuds;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import sirshadow.simplehuds.proxy.IProxy;

/**
 * Created by sirshadow on 6/5/17.
 */

@Mod(modid = ModLibrary.ModInfo.MOD_ID,name = ModLibrary.ModInfo.MOD_NAME,version = ModLibrary.ModInfo.MOD_VERSION,dependencies = "required-after:hf",guiFactory = ModLibrary.ModInfo.GUI_FACTORY)
public class SimpleHUDs {

    @Mod.Instance
    public static SimpleHUDs instance;

    @SidedProxy(serverSide = ModLibrary.ModInfo.SERVER_PROXY,clientSide = ModLibrary.ModInfo.CLIENT_PROXY)
    public static IProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){
        proxy.postInit(e);
    }
}
