package net.irisfeanora.mods.bwstats.hud.session;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import net.irisfeanora.mods.bwstats.util.BWStatsUtil;
import net.irisfeanora.mods.bwstats.util.SessionStatsContainer;

public class SessionKdrHud extends SingleTextHud {
    public SessionKdrHud() {
        super("KDR", true);
    }

    private final String notSupportedText = "None";

    @Override
    protected String getText(boolean example) {
        return BWStatsUtil.shouldRender()
                ? String.format("%.2f", (float) SessionStatsContainer.sessionKills /
                (SessionStatsContainer.sessionDeaths == 0 ? 1 : SessionStatsContainer.sessionDeaths))
                : notSupportedText;
    }
}
