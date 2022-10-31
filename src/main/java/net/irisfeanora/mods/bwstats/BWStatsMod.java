package net.irisfeanora.mods.bwstats;

import cc.polyfrost.oneconfig.utils.commands.CommandManager;

import net.irisfeanora.mods.bwstats.command.ConfigCommand;
import net.irisfeanora.mods.bwstats.config.BWStatsConfig;
import net.irisfeanora.mods.bwstats.util.HypixelAPIClient;
import net.irisfeanora.mods.bwstats.util.SessionStatsContainer;
import net.irisfeanora.mods.bwstats.util.TablistFooterPeriodicParser;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiPlayerTabOverlay;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = BWStatsMod.MODID, name = BWStatsMod.NAME, version = BWStatsMod.VERSION)
public class BWStatsMod {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @Instance(MODID)
    public static BWStatsMod INSTANCE;
    public HypixelAPIClient client;
    public BWStatsConfig config;
    public SessionStatsContainer container;

    @EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) throws NoSuchFieldException {
        config = new BWStatsConfig();
        client = new HypixelAPIClient(BWStatsConfig.callDelay * 1000, BWStatsConfig.token, Minecraft.getMinecraft().getSession().getPlayerID());
        client.start();
        CommandManager.INSTANCE.registerCommand(ConfigCommand.class);

        GuiPlayerTabOverlay.class.getDeclaredField("field_175255_h").setAccessible(true);

        TablistFooterPeriodicParser parser = new TablistFooterPeriodicParser();
        parser.start();
    }
}
