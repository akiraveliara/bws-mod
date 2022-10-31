package net.irisfeanora.mods.bwstats.hud.session;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import net.irisfeanora.mods.bwstats.util.BWStatsUtil;
import net.irisfeanora.mods.bwstats.util.SessionStatsContainer;

public class SessionBedsHud extends SingleTextHud {
    public SessionBedsHud() {
        super("Session Beds", true);
    }

    private final String notSupportedText = "None";

    @Override
    protected String getText(boolean example) {
        return BWStatsUtil.shouldRender() ? String.format("%d", SessionStatsContainer.sessionBeds) : notSupportedText;
    }
}
