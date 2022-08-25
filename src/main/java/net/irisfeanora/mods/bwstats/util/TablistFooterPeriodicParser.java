package net.irisfeanora.mods.bwstats.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiPlayerTabOverlay;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TablistFooterPeriodicParser extends Thread {

    private static final Pattern numberPattern = Pattern.compile("§e([0-9]+)§r");

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

                Matcher matcher = numberPattern.matcher(tab);

                int kills, finals, beds;

                if(matcher.find()) {
                    kills = Integer.parseInt(matcher.group());
                } else {
                    continue;
                }

                if(matcher.find()) {
                    finals = Integer.parseInt(matcher.group());
                } else {
                    continue;
                }

                if(matcher.find()) {
                    beds = Integer.parseInt(matcher.group());
                } else {
                    continue;
                }

                SessionStatsContainer.setGameStats(kills, finals, beds);

            } catch (IllegalAccessException e) {
                return;
            }
        }
    }
}
