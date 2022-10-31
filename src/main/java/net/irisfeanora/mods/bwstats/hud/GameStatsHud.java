package net.irisfeanora.mods.bwstats.hud;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import net.irisfeanora.mods.bwstats.util.BWStatsUtil;

public class GameStatsHud extends SingleTextHud {

    public GameStatsHud() {
        super("Game Stats", true);
    }

    private final String notSupportedText = "None";

    @Override
    protected String getText(boolean example) {
        return BWStatsUtil.shouldRender() ? BWStatsUtil.getGameStats() : notSupportedText;
    }
}
