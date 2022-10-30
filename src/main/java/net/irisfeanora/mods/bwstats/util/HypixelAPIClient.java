package net.irisfeanora.mods.bwstats.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class HypixelAPIClient extends Thread {
    // API call delay in milliseconds
    public int delay = 0;
    public String token = "";
    public String uuid = "";
    public static Boolean validToken = true;

    private JsonParser parser;

    public HypixelAPIClient(int delay, String token, String uuid) {
        this.delay = delay;
        this.token = token;
        this.uuid = uuid;
        this.parser = new JsonParser();
    }

    public void run() {
        while(true) {
            try {
                if(!BWStatsUtil.shouldRender()) {
                    sleep(delay);
                    continue;
                }

                JsonObject response = this.getStats();

                JsonObject stats = response.getAsJsonObject("player").getAsJsonObject("stats").getAsJsonObject("Bedwars");

                int finalKills = stats.getAsJsonPrimitive("final_kills_bedwars").getAsInt();
                int finalDeaths = stats.getAsJsonPrimitive("final_deaths_bedwars").getAsInt();

                int wins = stats.getAsJsonPrimitive("wins_bedwars").getAsInt();
                int losses = stats.getAsJsonPrimitive("losses_bedwars").getAsInt();

                int bedsBroken = stats.getAsJsonPrimitive("beds_broken_bedwars").getAsInt();
                int bedsLost = stats.getAsJsonPrimitive("beds_lost_bedwars").getAsInt();

                int kills = stats.getAsJsonPrimitive("kills_bedwars").getAsInt();
                int deaths = stats.getAsJsonPrimitive("deaths_bedwars").getAsInt();
            }
            catch(InterruptedException e) {}
            catch(IOException e) {
                e.printStackTrace();
                validToken = false;
            }

            try {
                sleep(delay);
            } catch (InterruptedException e) { }
        }
    }

    public JsonObject getStats() throws IOException {
        URL url = new URL("https://api.hypixel.net/player?key=" + token + "&uuid=" + uuid);
        URLConnection connection = url.openConnection();
        connection.connect();
        JsonElement element = parser.parse(new InputStreamReader((InputStream)connection.getContent()));
        return element.getAsJsonObject();
    }
}
