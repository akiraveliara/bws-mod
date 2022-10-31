package net.irisfeanora.mods.bwstats.hud.game;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import net.irisfeanora.mods.bwstats.util.BWStatsUtil;
import net.irisfeanora.mods.bwstats.util.SessionStatsContainer;

public class GameKillsHud extends SingleTextHud {
    public GameKillsHud() {
        super("Kills", true);
    }

    private final String notSupportedText = "None";

    @Override
    protected String getText(boolean example) {
        return BWStatsUtil.shouldRender() ? String.format("%d", SessionStatsContainer.gameKills) : notSupportedText;
    }
}
