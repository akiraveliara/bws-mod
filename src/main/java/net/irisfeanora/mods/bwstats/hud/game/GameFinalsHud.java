package net.irisfeanora.mods.bwstats.hud.game;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import net.irisfeanora.mods.bwstats.util.BWStatsUtil;
import net.irisfeanora.mods.bwstats.util.SessionStatsContainer;

public class GameFinalsHud extends SingleTextHud {
    public GameFinalsHud() {
        super("Finals", true);
    }

    private final String notSupportedText = "None";

    @Override
    protected String getText(boolean example) {
        return BWStatsUtil.shouldRender() ? String.format("%d", SessionStatsContainer.gameFinals) : notSupportedText;
    }
}
