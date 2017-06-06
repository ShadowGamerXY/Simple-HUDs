package sirshadow.simplehuds.client.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;
import sirshadow.hudframework.client.ClientEventManager;
import sirshadow.hudframework.client.hud.components.IComponentHoveringText;
import sirshadow.hudframework.client.hud.components.IComponentTitle;
import sirshadow.simplehuds.ModLibrary;
import sirshadow.hudframework.client.hud.HUDElement;
import sirshadow.hudframework.client.util.RenderUtil;
import sirshadow.simplehuds.SimpleHUDs;
import sirshadow.simplehuds.client.ClientEventHandler;

import java.util.List;

/**
 * Created by sirshadow on 6/5/17.
 */
public class HUDHealth extends HUDElement implements IComponentHoveringText,IComponentTitle{


    public HUDHealth(float x, float y) {
        super("HealthHUD", x, y, 256, 21);
    }

    @Override
    public void renderHUD(Minecraft mc) {
        ScaledResolution scaled = new ScaledResolution(mc);

        double scale = 1.5;

        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);

        int x = (int)((xPos * scaled.getScaledWidth()) * scale);
        int y = (int)((yPos * scaled.getScaledHeight()) * scale);

        float curHealth = SimpleHUDs.proxy.getClientPlayer().getHealth();
        float maxHealth = SimpleHUDs.proxy.getClientPlayer().getMaxHealth();

        //Calculate health amount
        int amount = Math.max((int) (128 *  (1 - (double)(curHealth) / maxHealth)), 0);


        GL11.glScalef((float)(1/scale), (float)(1/scale), (float)(1/scale));

        //Frame of the health bar
        ResourceLocation health = new ResourceLocation(ModLibrary.ModInfo.MOD_ID, "textures/hud/health_frame.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(health);
        RenderUtil.drawTexturedModalRect(x, y, 0, 0, 256, 256);

        //Red health park
        ResourceLocation blank = new ResourceLocation(ModLibrary.ModInfo.MOD_ID, "textures/hud/blank_health.png");
        GL11.glColor4f(1, 0, 0, 0.5F);
        mc.getTextureManager().bindTexture(blank);

        RenderUtil.drawTexturedModalRect(x + amount, y, amount, 0, 256 - amount, 256);

        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();

    }

    @Override
    public boolean shouldRenderHUD(Minecraft mc) {
        //TODO:Add a way to disable
        return true;
    }


    @Override
    public void onPositionChange() {
    }

    @Override
    public String getTitle() {
        return this.getUnlocalizedName();
    }

    @Override
    public void getHoveringText(List<String> hovText) {
        hovText.add(I18n.format("hudText.hudHealth.name"));
    }
}
