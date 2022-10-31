package net.irisfeanora.mods.bwstats.util;

import net.irisfeanora.mods.bwstats.BWStatsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraft.util.IChatComponent;

import java.lang.reflect.Field;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TablistFooterPeriodicParser extends Thread {

    private static final Pattern numberPattern = Pattern.compile("§e([0-9]+)§r");

    public void run()  {

        Field footer;

        try {
            footer = GuiPlayerTabOverlay.class.getField("field_175255_h");
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
                IChatComponent tab = (IChatComponent) footer.get(Minecraft.getMinecraft().ingameGUI.getTabList());

                if(tab == null) {
                    continue;
                }

                Matcher matcher = numberPattern.matcher(tab.getUnformattedText());

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

                BWStatsMod.INSTANCE.container.setGameStats(kills, finals, beds);

            } catch (IllegalAccessException e) {
                return;
            }
        }
    }
}
