package net.irisfeanora.mods.bwstats.util;

import net.irisfeanora.mods.bwstats.config.TextFormatType;

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

    public String formatGameStats(TextFormatType type) {
        StringBuilder builder = new StringBuilder();

        switch(type) {
            case DASH:
                builder.append("Kills - ").append(gameKills).append('\n');
                builder.append("Finals - ").append(gameFinals).append('\n');
                builder.append("Beds - ").append(gameBeds).append('\n');
                break;
            case COLON:
                builder.append("Kills: ").append(gameKills).append('\n');
                builder.append("Finals: ").append(gameFinals).append('\n');
                builder.append("Beds: ").append(gameBeds).append('\n');
                break;
            case SQUARE_BRACKET:
                builder.append("[Kills] ").append(gameKills).append('\n');
                builder.append("[Finals] ").append(gameFinals).append('\n');
                builder.append("[Beds] ").append(gameBeds).append('\n');
                break;
        }

        return builder.toString();
    }

    public String formatSessionStats(TextFormatType type) {
        StringBuilder builder = new StringBuilder();

        switch(type) {
            case DASH:
                builder.append("Session Kills - ").append(sessionKills).append(" | KDR - ").append(String.format("%.2f", (float)sessionKills / sessionDeaths)).append('\n');
                builder.append("Session Final Kills - ").append(sessionFinals).append(" | FKDR - ").append(String.format("%.2f", (float)sessionFinals / sessionFinalDeaths)).append('\n');
                builder.append("Session Beds - ").append(sessionBeds).append(" | BBLR - ").append(String.format("%.2f", (float)sessionBeds / sessionBedsLost)).append('\n');
                builder.append("Session Wins - ").append(sessionWins).append(" | WLR - ").append(String.format("%.2f", (float)sessionWins / sessionLosses)).append('\n');
            case COLON:
                builder.append("Session Kills: ").append(sessionKills).append(" | KDR: ").append(String.format("%.2f", (float)sessionKills / sessionDeaths)).append('\n');
                builder.append("Session Final Kills: ").append(sessionFinals).append(" | FKDR: ").append(String.format("%.2f", (float)sessionFinals / sessionFinalDeaths)).append('\n');
                builder.append("Session Beds: ").append(sessionBeds).append(" | BBLR: ").append(String.format("%.2f", (float)sessionBeds / sessionBedsLost)).append('\n');
                builder.append("Session Wins: ").append(sessionWins).append(" | WLR: ").append(String.format("%.2f", (float)sessionWins / sessionLosses)).append('\n');
            case SQUARE_BRACKET:
                builder.append("[Session Kills] ").append(sessionKills).append(" | [KDR] - ").append(String.format("%.2f", (float)sessionKills / sessionDeaths)).append('\n');
                builder.append("[Session Final Kills] - ").append(sessionFinals).append(" | FKDR] - ").append(String.format("%.2f", (float)sessionFinals / sessionFinalDeaths)).append('\n');
                builder.append("[Session Beds] - ").append(sessionBeds).append(" | [BBLR] - ").append(String.format("%.2f", (float)sessionBeds / sessionBedsLost)).append('\n');
                builder.append("[Session Wins] - ").append(sessionWins).append(" | [WLR] - ").append(String.format("%.2f", (float)sessionWins / sessionLosses)).append('\n');
        }

        return builder.toString();
    }
}
