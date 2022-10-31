package net.irisfeanora.mods.bwstats.hud.game;

import cc.polyfrost.oneconfig.hud.SingleTextHud;
import net.irisfeanora.mods.bwstats.util.BWStatsUtil;
import net.irisfeanora.mods.bwstats.util.SessionStatsContainer;

public class GameBedsHud extends SingleTextHud {
    public GameBedsHud() {
        super("Beds", true);
    }

    private final String notSupportedText = "None";

    @Override
    protected String getText(boolean example) {
        return BWStatsUtil.shouldRender() ? String.format("%d", SessionStatsContainer.gameBeds) : notSupportedText;
    }
}
