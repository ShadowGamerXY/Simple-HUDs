package sirshadow.simplehuds;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by sirshadow on 6/5/17.
 */
public class ConfigurationHandler {
    public static Configuration configuration;

    public static String HUD_CATEGORY;

    public static void init(File file){
        if (configuration == null){
            configuration = new Configuration(file);
            loadConfigs();
        }
    }

    private static void loadConfigs(){

        if (configuration.hasChanged()){
            configuration.save();
        }
    }

    @SubscribeEvent
    public void onConfigsChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.getModID().equals(ModLibrary.ModInfo.MOD_ID)){
            loadConfigs();
        }
    }
}
