package net.irisfeanora.mods.bwstats.config;

import net.irisfeanora.mods.bwstats.BWStatsMod;
import net.irisfeanora.mods.bwstats.hud.TestHud;
import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.annotations.HUD;
import cc.polyfrost.oneconfig.config.annotations.Switch;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;

public class TestConfig extends Config {

    @HUD(
            name = "Very cool HUD",
            subcategory = "Test"
    )
    public static TestHud testHud = new TestHud();

    @Switch(
            name = "Test",
            subcategory = "Test",
            size = 2
    )
    public static boolean test = true;

    public TestConfig() {
        super(new Mod(BWStatsMod.NAME, ModType.HYPIXEL), BWStatsMod.MODID + ".json");
        initialize();
    }
}

