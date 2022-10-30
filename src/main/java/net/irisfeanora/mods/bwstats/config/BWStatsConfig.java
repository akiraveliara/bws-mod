package net.irisfeanora.mods.bwstats.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import net.irisfeanora.mods.bwstats.BWStatsMod;
import net.irisfeanora.mods.bwstats.hud.GameStatsHud;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import net.irisfeanora.mods.bwstats.hud.SessionStatsHud;

public class BWStatsConfig extends Config {

    @HUD(
            name = "Game Stats HUD",
            subcategory = "HUDs"
    )
    public static GameStatsHud gameHud = new GameStatsHud();

    @HUD(
            name = "Session Stats HUD",
            subcategory = "HUDs"
    )
    public static SessionStatsHud sessionHud = new SessionStatsHud();

    @Dropdown(
            name = "Text Format Type",
            options = {
                    "Dashes",
                    "Colons",
                    "Square Brackets"
            }
    )
    public static int textFormatType = 0;

    @Slider(
            name = "Hypixel API call delay, in seconds",
            min = 5,
            max = 30,
            step = 5
    )
    public static int callDelay = 5;

    @Text(
            name = "Hypixel API Key",
            secure = true,
            multiline = false
    )
    public static String token = "";

    public BWStatsConfig() {
        super(new Mod(BWStatsMod.NAME, ModType.HYPIXEL), BWStatsMod.MODID + ".json");
        initialize();
    }
}

