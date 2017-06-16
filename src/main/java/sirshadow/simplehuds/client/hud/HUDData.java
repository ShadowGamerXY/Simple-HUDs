package sirshadow.simplehuds.client.hud;

import sirshadow.hudframework.client.hud.HUDElement;

import java.util.ArrayList;

/**
 * Created by sirshadow on 6/11/17.
 */
public interface HUDData {

    static ArrayList<HUDData> DATA = new ArrayList<>();

    HUDElement getElement();

}
