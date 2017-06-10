package sirshadow.simplehuds.client;

import net.minecraft.client.renderer.entity.Render;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.ArrayList;

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


        for (RenderGameOverlayEvent.ElementType type : elementTypes) {
            if (event.isCancelable()) {
                if (event.getType().equals(type)) {
                    event.setCanceled(true);
                }
            }
        }
    }
}

