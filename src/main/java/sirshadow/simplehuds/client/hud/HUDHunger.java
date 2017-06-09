package sirshadow.simplehuds.client.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import sirshadow.hudframework.client.hud.GuiHUD;
import sirshadow.hudframework.client.hud.HUDElement;
import sirshadow.hudframework.client.hud.components.IComponentHoveringText;
import sirshadow.hudframework.client.hud.components.IComponentTitle;
import sirshadow.hudframework.client.util.RenderUtil;
import sirshadow.simplehuds.ConfigurationHandler;
import sirshadow.simplehuds.ModLibrary;
import sirshadow.simplehuds.SimpleHUDs;
import sun.java2d.pipe.SpanShapeRenderer;

import java.util.List;
import java.util.Random;

/**
 * Created by sirshadow on 6/5/17.
 */
public class HUDHunger extends HUDElement implements IComponentHoveringText,IComponentTitle{

    public float fadeEffect = 1F;

    Random random = new Random();

    public HUDHunger(float x, float y) {
        super("HungerHUD", x, y, 256, 32);
    }

    @Override
    public void renderHUD(Minecraft mc) {
        ScaledResolution scaled = new ScaledResolution(mc);

        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);

        if (mc.currentScreen instanceof GuiHUD)setShouldFade(false);

        float hunger = mc.player.getFoodStats().getFoodLevel();

        int foodAmount = Math.max((int) (256 *  (1 - (double)(hunger / 20F))), 0);

        if (shouldFade()){
            if (!mc.player.getFoodStats().needFood()){
                if (fadeEffect > 0)fadeEffect -= 0.01;
            }else {
                if(fadeEffect < 1) {
                    fadeEffect += 0.05;
                }
                if (fadeEffect >= 1){
                    fadeEffect = 1;
                }
            }
        }else {
            fadeEffect = 1;
        }



        int x = (int)(xPos * scaled.getScaledWidth()) * 4;
        int y = (int)(yPos * scaled.getScaledHeight()) * 4;

        GL11.glScalef(1f/4f, 1f/4f, 1f/4f);


        ResourceLocation test = new ResourceLocation(ModLibrary.ModInfo.MOD_ID, "textures/hud/health_frame.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F * fadeEffect);
        mc.getTextureManager().bindTexture(test);


        RenderUtil.drawTexturedModalRect(x, y, 0, 0, 256, 256);

        ResourceLocation test2 = new ResourceLocation(ModLibrary.ModInfo.MOD_ID, "textures/hud/blank_health.png");
        GL11.glColor4f(255, 165, 0, 0.5F * fadeEffect);
        mc.getTextureManager().bindTexture(test2);

        RenderUtil.drawTexturedModalRect(x, y, 0, 0, 256 - foodAmount, 256);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    @Override
    public boolean shouldRenderHUD(Minecraft mc) {
        //TODO:Add a way to disable
        return true;
    }

    @Override
    public boolean shouldUpdate() {
        return true;
    }

    @Override
    public void update() {
    }
    @Override
    public void onPositionChange() {
        ConfigurationHandler.setValueOfHUD(this.getName(),xPos,yPos);
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
