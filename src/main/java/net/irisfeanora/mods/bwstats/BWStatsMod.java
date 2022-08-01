package net.irisfeanora.mods.bwstats;

import net.irisfeanora.mods.bwstats.command.ConfigCommand;
import net.irisfeanora.mods.bwstats.config.TestConfig;
import cc.polyfrost.oneconfig.utils.commands.CommandManager;

@net.minecraftforge.fml.common.Mod(modid = BWStatsMod.MODID, name = BWStatsMod.NAME, version = BWStatsMod.VERSION)
public class BWStatsMod {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @net.minecraftforge.fml.common.Mod.Instance(MODID)
    public static BWStatsMod INSTANCE;
    public TestConfig config;

    @net.minecraftforge.fml.common.Mod.EventHandler
    public void onFMLInitialization(net.minecraftforge.fml.common.event.FMLInitializationEvent event) {
        config = new TestConfig();
        CommandManager.INSTANCE.registerCommand(ConfigCommand.class);
    }
}
