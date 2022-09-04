package net.irisfeanora.mods.bwstats;

import cc.polyfrost.oneconfig.utils.commands.CommandManager;

import net.irisfeanora.mods.bwstats.command.ConfigCommand;
import net.irisfeanora.mods.bwstats.config.TestConfig;
import net.irisfeanora.mods.bwstats.config.TextFormatSettings;
import net.irisfeanora.mods.bwstats.config.TextFormatType;
import net.irisfeanora.mods.bwstats.util.SessionStatsContainer;
import net.irisfeanora.mods.bwstats.util.TablistFooterPeriodicParser;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import java.lang.reflect.Field;

@Mod(modid = BWStatsMod.MODID, name = BWStatsMod.NAME, version = BWStatsMod.VERSION)
public class BWStatsMod {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @Instance(MODID)
    public static BWStatsMod INSTANCE;
    public HypixelAPIClient client;
    public TestConfig config;
    public SessionStatsContainer container;
    public TextFormatSettings formatSettings = new TextFormatSettings(TextFormatType.COLON);

    @EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) throws NoSuchFieldException {
        config = new TestConfig();
        client = new HypixelAPIClient();
        CommandManager.INSTANCE.registerCommand(ConfigCommand.class);

        GuiPlayerTabOverlay.class.getDeclaredField("footer").setAccessible(true);

        TablistFooterPeriodicParser parser = new TablistFooterPeriodicParser();
        parser.start();
    }
}
