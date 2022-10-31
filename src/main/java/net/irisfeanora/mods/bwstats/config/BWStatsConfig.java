package net.irisfeanora.mods.bwstats.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import net.irisfeanora.mods.bwstats.BWStatsMod;
import net.irisfeanora.mods.bwstats.hud.game.GameBedsHud;
import net.irisfeanora.mods.bwstats.hud.game.GameFinalsHud;
import net.irisfeanora.mods.bwstats.hud.game.GameKillsHud;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import net.irisfeanora.mods.bwstats.hud.session.*;
import net.minecraft.util.Session;

public class BWStatsConfig extends Config {

    @HUD(
            name = "Game Kills",
            subcategory = "Game"
    )
    public static GameKillsHud gameKillsHud = new GameKillsHud();

    @HUD(
            name = "Game Finals",
            subcategory = "Game"
    )
    public static GameFinalsHud gameFinalsHud = new GameFinalsHud();

    @HUD(
            name = "Game Beds",
            subcategory = "Game"
    )
    public static GameBedsHud gameBedsHud = new GameBedsHud();

    @HUD(
            name = "Session Kills",
            subcategory = "Session"
    )
    public static SessionKillsHud sessionKillsHud = new SessionKillsHud();

    @HUD(
            name = "Session Finals",
            subcategory = "Session"
    )
    public static SessionFinalsHud sessionFinalsHud = new SessionFinalsHud();

    @HUD(
            name = "Session Beds",
            subcategory = "Session"
    )
    public static SessionBedsHud sessionBedsHud = new SessionBedsHud();

    @HUD(
            name = "Session Wins",
            subcategory = "Session"
    )
    public static SessionWinsHud sessionWinsHud = new SessionWinsHud();

    @HUD(
            name = "Session KDR",
            subcategory = "Session"
    )
    public static SessionKdrHud sessionKdrHud = new SessionKdrHud();

    @HUD(
            name = "Session FKDR",
            subcategory = "Session"
    )
    public static SessionFkdrHud sessionFkdrHud = new SessionFkdrHud();

    @HUD(
            name = "Session BBLR",
            subcategory = "Session"
    )
    public static SessionBblrHud sessionBblrHud = new SessionBblrHud();

    @HUD(
            name = "Session WLR",
            subcategory = "Session"
    )
    public static SessionWlrHud sessionWlrHud = new SessionWlrHud();

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

