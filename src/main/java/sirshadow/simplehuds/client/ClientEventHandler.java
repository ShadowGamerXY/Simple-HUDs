package sirshadow.simplehuds.client;

import com.sun.org.apache.regexp.internal.RE;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
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
        elementTypes.add(RenderGameOverlayEvent.ElementType.HEALTH);
        elementTypes.add(RenderGameOverlayEvent.ElementType.FOOD);
        elementTypes.add(RenderGameOverlayEvent.ElementType.EXPERIENCE);
        elementTypes.add(RenderGameOverlayEvent.ElementType.AIR);


        if (event.getType().equals(RenderGameOverlayEvent.ElementType.TEXT)) {
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


    public void hudDataRender(){
        for (int i = 0; i < HUDData.DATA.size();i++){

        }
    }
}

