package net.irisfeanora.mods.bwstats.util;

public class SessionStatsContainer {
    public static int gameKills, gameFinals, gameBeds;

    public static int sessionKills, sessionFinals, sessionBeds, sessionWins;
    public static int sessionDeaths, sessionFinalDeaths, sessionBedsLost, sessionLosses;
    // private int gameDeaths, gameFinalDeaths, gameBedsLost; // these are not currently supported by the mod.

    private static int startingKills, startingFinals, startingBeds, startingWins;
    private static int startingDeaths, startingFinalDeaths, startingBedsLost, startingLosses;

    private static boolean initialized = false;

    public static void startNewGame() {
        gameKills = 0;
        gameFinals = 0;
        gameBeds = 0;
    }

    public void setGameStats(int kills, int finals, int beds) {
        gameKills = kills;
        gameFinals = finals;
        gameBeds = beds;
    }

    public void setSessionStats(int kills, int finals, int beds, int wins, int deaths, int finalDeaths, int bedsLost, int losses) {
        if(!initialized) {
            startingKills = kills;
            startingFinals = finals;
            startingBeds = beds;
            startingWins = wins;
            startingDeaths = deaths;
            startingFinalDeaths = finalDeaths;
            startingBedsLost = bedsLost;
            startingLosses = losses;
        } else {
            sessionKills = kills - startingKills;
            sessionFinals = finals - startingFinals;
            sessionBeds = beds - startingBeds;
            sessionWins = wins - startingWins;
            sessionDeaths = deaths - startingDeaths;
            sessionFinalDeaths = finalDeaths - startingFinalDeaths;
            sessionBedsLost = bedsLost - startingBedsLost;
            sessionLosses = losses - startingLosses;
        }
    }
}
