package net.irisfeanora.mods.bwstats.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiPlayerTabOverlay;

import java.lang.reflect.Field;

public class TablistFooterPeriodicParser extends Thread {

    public void run()  {

        Field footer = null;

        try {
            footer = GuiPlayerTabOverlay.class.getField("footer");
        } catch (NoSuchFieldException e) {
            return;
        }

        footer.setAccessible(true);

        while(true) {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(!BWStatsUtil.shouldRender()) {
                continue;
            }

            try {
                String tab = (String)footer.get(Minecraft.getMinecraft().ingameGUI.getTabList());


            } catch (IllegalAccessException e) {
                return;
            }
        }
    }
}
