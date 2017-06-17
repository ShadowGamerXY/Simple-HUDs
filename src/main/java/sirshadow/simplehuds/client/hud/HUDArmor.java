package sirshadow.simplehuds.client.hud;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemSaddle;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import sirshadow.hudframework.client.hud.GuiHUD;
import sirshadow.hudframework.client.hud.HUDElement;
import sirshadow.hudframework.client.hud.components.IComponentHoveringText;
import sirshadow.hudframework.client.hud.components.IComponentTitle;
import sirshadow.hudframework.client.util.RenderUtil;
import sirshadow.simplehuds.ConfigurationHandler;
import sirshadow.simplehuds.ModLibrary;

import java.util.List;

/**
 * Created by sirshadow on 6/5/17.
 */
public class HUDArmor extends HUDElement implements IComponentHoveringText,IComponentTitle{

    public float fadeEffect = 1F;

    public HUDArmor() {
        super("ArmorHUD", ConfigurationHandler.getXofHUD("ArmorHUD"), ConfigurationHandler.getYofHUD("ArmorHUD"), 256, 32);
    }

    @Override
    public void renderHUD(Minecraft mc) {
        ScaledResolution scaled = new ScaledResolution(mc);

        float healthAmount = mc.player.getTotalArmorValue();
        //float maxAmount = 30;

        if (mc.currentScreen instanceof GuiHUD) setShouldFade(false);

        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);

        //int amount = Math.max((int) (256 *  (1 - (double)(healthAmount) / maxAmount)), 0);

        if (healthAmount <= 0)fadeEffect = 0f;
        else fadeEffect = 1f;

        int x = (int)(xPos * scaled.getScaledWidth()) * 4;
        int y = (int)(yPos * scaled.getScaledHeight()) * 4;

        GL11.glScalef(1f/4f, 1f/4f, 1f/4f);


        ResourceLocation test = new ResourceLocation(ModLibrary.ModInfo.MOD_ID, "textures/hud/health_frame.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F * fadeEffect);
        mc.getTextureManager().bindTexture(test);


        RenderUtil.drawTexturedModalRect(x, y, 0, 0, 256, 256);

        ResourceLocation test2 = new ResourceLocation(ModLibrary.ModInfo.MOD_ID, "textures/hud/blank_health.png");
        GL11.glColor4f(255, 255, 255, 0.79F * fadeEffect);
        mc.getTextureManager().bindTexture(test2);

        RenderUtil.drawTexturedModalRect(x, y, 0, 0, 256, 256);
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
        ConfigurationHandler.setValueOfHUD(this.getName(),xPos,yPos);
    }

    @Override
    public String getTitle() {
        return this.getUnlocalizedName();
    }

    @Override
    public void getHoveringText(List<String> hovText) {
        hovText.add(I18n.format("hudText.hudArmor.name"));
    }
}
