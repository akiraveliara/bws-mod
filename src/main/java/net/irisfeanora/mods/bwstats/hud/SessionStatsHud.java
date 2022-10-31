package net.irisfeanora.mods.bwstats.hud;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import net.irisfeanora.mods.bwstats.util.BWStatsUtil;

public class SessionStatsHud extends SingleTextHud {
    public SessionStatsHud() {
        super("Session Stats", true);
    }

    private final String notSupportedText = "None";

    @Override
    protected String getText(boolean example) {
        return BWStatsUtil.shouldRender() ? BWStatsUtil.getSessionStats() : notSupportedText;
    }
}
