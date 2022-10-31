package net.irisfeanora.mods.bwstats.hud.session;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import net.irisfeanora.mods.bwstats.util.BWStatsUtil;
import net.irisfeanora.mods.bwstats.util.SessionStatsContainer;

public class SessionFkdrHud extends SingleTextHud {
    public SessionFkdrHud() {
        super("FKDR", true);
    }

    private final String notSupportedText = "None";

    @Override
    protected String getText(boolean example) {
        return BWStatsUtil.shouldRender()
                ? String.format("%.2f", (float) SessionStatsContainer.sessionFinals /
                (SessionStatsContainer.sessionFinalDeaths == 0 ? 1 : SessionStatsContainer.sessionFinalDeaths))
                : notSupportedText;
    }
}
