package sirshadow.simplehuds.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import sirshadow.hudframework.client.hud.HUDElement;
import sirshadow.hudframework.client.hud.HUDRenderHelper;
import sirshadow.hudframework.client.util.RenderUtil;
import sirshadow.simplehuds.ConfigurationHandler;
import sirshadow.simplehuds.client.hud.HUDData;
import sirshadow.simplehuds.client.hud.HUDExp;

import java.awt.*;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by sirshadow on 6/5/17.
 */
@SideOnly(Side.CLIENT)
public class ClientEventHandler {

    public ArrayList<RenderGameOverlayEvent.ElementType> elementTypes = new ArrayList<>();

    @SubscribeEvent
    public void onGameOverlay(RenderGameOverlayEvent event) {
        addDisabledElement("HealthHUD",ElementType.HEALTH);
        addDisabledElement("HungerHUD",ElementType.FOOD);
        addDisabledElement("ExpHUD",ElementType.EXPERIENCE);
        addDisabledElement("WaterHUD",ElementType.AIR);
        addDisabledElement("ArmorHUD",ElementType.ARMOR);


        if (event.getType().equals(ElementType.TEXT)) {
            if (ConfigurationHandler.fps_counter) {
                int fps = Minecraft.getDebugFPS();
                RenderUtil.addObject("FPS: " + fps, 0, 0, Color.WHITE);
            }
        }

        for (RenderGameOverlayEvent.ElementType type : elementTypes) {
            if (event.isCancelable()) {
                if (event.getType().equals(type)) {
                    event.setCanceled(true);
                }
            }
        }
    }


    public void addDisabledElement(String blackListName,ElementType type){
        for (Map.Entry<String,HUDElement>  entry : HUDRenderHelper.hudElementsMap.entrySet()) {
            HUDElement element = entry.getValue();
            if (element.getName().equalsIgnoreCase(blackListName)) {
                if (!element.onBlacklist()) {
                    if (!elementTypes.contains(type)) {
                        elementTypes.add(type);
                    }
                } else elementTypes.remove(type);
            }
        }
    }
}

