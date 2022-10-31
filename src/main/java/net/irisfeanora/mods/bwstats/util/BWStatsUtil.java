package net.irisfeanora.mods.bwstats.util;

import cc.polyfrost.oneconfig.utils.hypixel.HypixelUtils;
import cc.polyfrost.oneconfig.utils.hypixel.LocrawInfo;
import net.irisfeanora.mods.bwstats.BWStatsMod;
import net.irisfeanora.mods.bwstats.config.BWStatsConfig;
import net.irisfeanora.mods.bwstats.config.TextFormatType;

public class BWStatsUtil {
    private static TextFormatType[] values;

    public static boolean shouldRender() {
        if(!HypixelUtils.INSTANCE.isHypixel()) {
            return false;
        }

        return HypixelUtils.INSTANCE.getLocrawInfo().getGameType().equals(LocrawInfo.GameType.BEDWARS);
    }

    public static String getGameStats() {
        return BWStatsMod.INSTANCE.container.formatGameStats(values[BWStatsConfig.textFormatType]);
    }

    public static String getSessionStats() {
        return BWStatsMod.INSTANCE.container.formatSessionStats(values[BWStatsConfig.textFormatType]);
    }

    static {
        values = TextFormatType.values();
    }
}
