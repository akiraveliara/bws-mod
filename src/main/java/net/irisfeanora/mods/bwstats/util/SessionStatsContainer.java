package net.irisfeanora.mods.bwstats.util;

public class SessionStatsContainer {
    private static int sessionKills, sessionFinals, sessionBeds, sessionWins;
    private static int gameKills, gameFinals, gameBeds;

    private static int sessionDeaths, sessionFinalDeaths, sessionBedsLost, sessionLosses;
    // private int gameDeaths, gameFinalDeaths, gameBedsLost; // these are not currently supported by the mod.

    public static void startNewGame() {
        sessionKills += gameKills;
        sessionFinals += gameFinals;
        sessionBeds += gameBeds;

        gameKills = 0;
        gameFinals = 0;
        gameBeds = 0;
    }

    public static void setGameStats(int kills, int finals, int beds) {
        gameKills = kills;
        gameFinals = finals;
        gameBeds = beds;
    }
}
