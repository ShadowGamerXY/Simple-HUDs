package sirshadow.simplehuds.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import sirshadow.hudframework.client.hud.HUDRenderHelper;
import sirshadow.simplehuds.ConfigurationHandler;
import sirshadow.simplehuds.client.ClientEventHandler;
import sirshadow.simplehuds.client.hud.HUDExp;
import sirshadow.simplehuds.client.hud.HUDHealth;
import sirshadow.simplehuds.client.hud.HUDHunger;
import sirshadow.simplehuds.client.hud.HUDWater;

/**
 * Created by Shadow on 31.5.2017.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        HUDRenderHelper.hudElementsMap.put("HealthHUD",new HUDHealth(ConfigurationHandler.health_x,ConfigurationHandler.health_y));
        HUDRenderHelper.hudElementsMap.put("hungerHUD",new HUDHunger(ConfigurationHandler.hunger_x,ConfigurationHandler.hunger_y));
        HUDRenderHelper.hudElementsMap.put("expHUD",new HUDExp());
        HUDRenderHelper.hudElementsMap.put("waterHUD",new HUDWater(ConfigurationHandler.water_x,ConfigurationHandler.water_y));
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
