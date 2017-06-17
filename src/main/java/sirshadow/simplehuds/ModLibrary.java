package sirshadow.simplehuds;

/**
 * Created by Shadow on 31.5.2017.
 */
public class ModLibrary {

    public static class ModInfo{
        public static final String MOD_ID = "sh",MOD_NAME = "Simple HUDs",MOD_VERSION = "0.2",GUI_FACTORY = "sirshadow.simplehuds.client.gui.ModGuiFactory" +
                "";

        public static final String CLIENT_PROXY = "sirshadow.simplehuds.proxy.ClientProxy",SERVER_PROXY = "sirshadow.simplehuds.proxy.ServerProxy";
    }

}
