package sirshadow.simplehuds.client.gui;

import jline.internal.Nullable;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.DummyConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import net.minecraftforge.fml.client.config.IConfigElement;

import sirshadow.simplehuds.ConfigurationHandler;
import sirshadow.simplehuds.ModLibrary;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by sirshadow on 6/8/17.
 */
public class ModGuiFactory implements IModGuiFactory{

    @Override
    public void initialize(Minecraft minecraftInstance) {

    }

    @Override
    public boolean hasConfigGui() {
        return true;
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parentScreen) {
        return new ModGuiFactory.SimpleHUDsFactory(parentScreen);
    }

    @Override
    public Class<? extends GuiScreen> mainConfigGuiClass() {
        return SimpleHUDsFactory.class;
    }

    @Override
    public Set<IModGuiFactory.RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }

    @Nullable
    @Override
    public IModGuiFactory.RuntimeOptionGuiHandler getHandlerFor(IModGuiFactory.RuntimeOptionCategoryElement element) {
        return null;
    }

    public static class SimpleHUDsFactory extends GuiConfig {
        public SimpleHUDsFactory(GuiScreen parent) {
            super(parent, getConfigElements(), ModLibrary.ModInfo.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigurationHandler.configuration.toString()));
        }

        /**
         * Compiles a list of config elements
         */
        private static List<IConfigElement> getConfigElements() {
            List<IConfigElement> list = new ArrayList<IConfigElement>();

            //Add categories to config GUI
            list.add(categoryElement(Configuration.CATEGORY_GENERAL, "General", "Geneeral"));
            list.add(categoryElement(Configuration.CATEGORY_CLIENT, "Client", "Clieent"));
            list.add(categoryElement(ConfigurationHandler.HUD_CATEGORY,"HUDs","huds"));
            return list;
        }

        /**
         * Creates a button linking to another screen where all options of the category are available
         */
        private static IConfigElement categoryElement(String category, String name, String tooltip_key) {
            return new DummyConfigElement.DummyCategoryElement(name, tooltip_key, new ConfigElement(ConfigurationHandler.configuration.getCategory(category)).getChildElements());
        }
    }
}
