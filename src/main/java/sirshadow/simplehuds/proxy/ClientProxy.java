package sirshadow.hudframework.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import sirshadow.hudframework.ConfigurationHandler;
import sirshadow.hudframework.client.ClientEventManager;
import sirshadow.hudframework.client.hud.hud.ExampleHUD;
import sirshadow.hudframework.client.hud.HUDRenderHelper;
import sirshadow.hudframework.client.keybindings.KeyBindings;
import sirshadow.hudframework.client.keybindings.KeyInputHandler;

/**
 * Created by Shadow on 31.5.2017.
 */
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
        MinecraftForge.EVENT_BUS.register(new ClientEventManager());
        registerKeyBindings();

        HUDRenderHelper.hudElementsMap.put("exampleHUD", new ExampleHUD("exampleHUD", ConfigurationHandler.example_xPos,ConfigurationHandler.example_yPos,256,32));
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
        //no-op
    }

    @Override
    public EntityPlayer getClientPlayer() {
        return Minecraft.getMinecraft().player;
    }

    public void registerKeyBindings(){
        MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
        for (KeyBindings key : KeyBindings.values()){
            ClientRegistry.registerKeyBinding(key.getKeyBid());
        }
    }
}
