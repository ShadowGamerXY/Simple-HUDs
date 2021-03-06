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

    public static String HUD_POS_CATEGORY = "HUD Position";

    public static boolean fps_counter;

    /** HUD ELEMENTS **/
    public static float exp_x,exp_y;
    public static float health_x,health_y;
    public static float hunger_x,hunger_y;
    public static float water_x,water_y;


    public static void init(File file){
        if (configuration == null){
            configuration = new Configuration(file);
            loadConfigs();
        }
    }

    private static void loadConfigs(){

        exp_x = configuration.getFloat("ExpHUD_x",HUD_POS_CATEGORY,0.0f,0.0f,1000.0f,"");
        exp_y = configuration.getFloat("ExpHUD_y",HUD_POS_CATEGORY,0.1f,0.0f,1000.0f,"");

        health_x = configuration.getFloat("HealthHUD_x",HUD_POS_CATEGORY,0.0f,0.0f,1000.0f,"");
        health_y = configuration.getFloat("HealthHUD_y",HUD_POS_CATEGORY,0.3f,0.0f,1000.0f,"");

        hunger_x = configuration.getFloat("HungerHUD_x",HUD_POS_CATEGORY,0.0f,0.0f,1000.0f,"");
        hunger_y = configuration.getFloat("HungerHUD_y",HUD_POS_CATEGORY,0.5f,0.0f,1000.0f,"");

        water_x = configuration.getFloat("WaterHUD_x",HUD_POS_CATEGORY,0.0f,0.0f,1000.0f,"");
        water_y = configuration.getFloat("WaterHUD_y",HUD_POS_CATEGORY,0.7f,0.0f,1000.0f,"");

        fps_counter = configuration.getBoolean("fps_counter",Configuration.CATEGORY_CLIENT,false,"");

        if (configuration.hasChanged()){
            configuration.save();
        }
    }


    public static void setValueOfHUD(String hudName,float xValue,float yValue){
        configuration.get(HUD_POS_CATEGORY,hudName + "_x",xValue).setValue(xValue);
        configuration.get(HUD_POS_CATEGORY,hudName + "_y",yValue).setValue(yValue);
        configuration.save();
    }

    @SubscribeEvent
    public void onConfigsChanged(ConfigChangedEvent.OnConfigChangedEvent event){
        if (event.getModID().equals(ModLibrary.ModInfo.MOD_ID)){
            loadConfigs();
        }
    }
}
