package net.irisfeanora.mods.bwstats.util;

import cc.polyfrost.oneconfig.utils.hypixel.HypixelUtils;
import cc.polyfrost.oneconfig.utils.hypixel.LocrawInfo;

public class BWStatsUtil {

    public static boolean shouldRender() {
        if(!HypixelUtils.INSTANCE.isHypixel()) {
            return false;
        }

        try {
            return HypixelUtils.INSTANCE.getLocrawInfo().getGameType().equals(LocrawInfo.GameType.BEDWARS);
        } catch (NullPointerException e) {
            return false;
        }
    }
}
