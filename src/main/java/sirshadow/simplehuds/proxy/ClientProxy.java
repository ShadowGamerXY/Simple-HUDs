package sirshadow.simplehuds.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import sirshadow.hudframework.client.hud.HUDRenderHelper;
import sirshadow.simplehuds.client.ClientEventHandler;
import sirshadow.simplehuds.client.hud.HUDHealth;

/**
 * Created by Shadow on 31.5.2017.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        HUDRenderHelper.hudElementsMap.put("HealthHUD",new HUDHealth(0,0.7f));
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
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return Minecraft.getMinecraft().player;
    }
}
