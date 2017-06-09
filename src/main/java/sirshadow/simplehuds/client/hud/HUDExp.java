package sirshadow.simplehuds.client.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import sirshadow.hudframework.client.hud.HUDElement;
import sirshadow.hudframework.client.hud.components.IComponentHoveringText;
import sirshadow.hudframework.client.hud.components.IComponentTitle;
import sirshadow.hudframework.client.util.RenderUtil;
import sirshadow.simplehuds.ModLibrary;

import java.awt.*;
import java.util.List;

/**
 * Created by sirshadow on 6/9/17.
 */
public class HUDExp extends HUDElement implements IComponentTitle,IComponentHoveringText {

    public HUDExp(float x, float y) {
        super("ExpHUD", x, y, 256, 32);
    }

    @Override
    public void renderHUD(Minecraft mc) {
        ScaledResolution scaled = new ScaledResolution(mc);

        float bloodAmount = mc.player.experience * mc.player.xpBarCap();
        float maxAmount = mc.player.xpBarCap();

        GL11.glPushMatrix();

        int x1 = (int)(xPos * scaled.getScaledWidth() * 1.5) - 20;
        int y1 = (int)(yPos * scaled.getScaledHeight() * 1.5) - 8;


        GL11.glScalef(1f/1.5f,1f/1.5f,1f/1.5f);

        Color c = new Color(223, 249, 46);

        RenderUtil.addObject(mc.player.experienceLevel,x1 + xSize / 4,y1, c);

        GL11.glPopMatrix();


        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);

        int amount = Math.max((int) (256 *  (1 - (double)(bloodAmount) / maxAmount)), 0);

        int x = (int)(xPos * scaled.getScaledWidth()) * 4;
        int y = (int)(yPos * scaled.getScaledHeight()) * 4;
        GL11.glScalef(1f/4f, 1f/4f, 1f/4f);


        ResourceLocation test = new ResourceLocation(ModLibrary.ModInfo.MOD_ID, "textures/hud/health_frame.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.getTextureManager().bindTexture(test);

        RenderUtil.drawTexturedModalRect(x, y, 0, 0, 256, 256);

        ResourceLocation test2 = new ResourceLocation(ModLibrary.ModInfo.MOD_ID, "textures/hud/blank_health.png");
        GL11.glColor4f(0, 2, 0, 0.5F);
        mc.getTextureManager().bindTexture(test2);

        RenderUtil.drawTexturedModalRect(x - amount, y, amount, 0, 256 - amount, 256);


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
        hovText.add(I18n.format("hudText.hudExp.name"));
    }
}
