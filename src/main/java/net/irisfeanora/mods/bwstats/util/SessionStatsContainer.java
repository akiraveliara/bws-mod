package net.irisfeanora.mods.bwstats.util;

import net.irisfeanora.mods.bwstats.config.TextFormatSettings;

public class SessionStatsContainer {
    private static int sessionKills, sessionFinals, sessionBeds, sessionWins;
    private static int gameKills, gameFinals, gameBeds;

    private static int sessionDeaths, sessionFinalDeaths, sessionBedsLost, sessionLosses;
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

    public String formatGameStats(TextFormatSettings settings) {
        StringBuilder builder = new StringBuilder();

        switch(settings.type) {
            case DASH:
                builder.append("Kills - ").append(gameKills);
                builder.append("Finals - ").append(gameFinals);
                builder.append("Beds - ").append(gameBeds);
                break;
            case COLON:
                builder.append("Kills: ").append(gameKills);
                builder.append("Finals: ").append(gameFinals);
                builder.append("Beds: ").append(gameBeds);
                break;
            case SQUARE_BRACKET:
                builder.append("[Kills] ").append(gameKills);
                builder.append("[Finals] ").append(gameFinals);
                builder.append("[Beds] ").append(gameBeds);
                break;
        }

        return builder.toString();
    }
}
