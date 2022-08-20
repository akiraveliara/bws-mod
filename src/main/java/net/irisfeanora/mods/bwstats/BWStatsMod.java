package net.irisfeanora.mods.bwstats;

import net.irisfeanora.mods.bwstats.command.ConfigCommand;
import net.irisfeanora.mods.bwstats.config.TestConfig;

import cc.polyfrost.oneconfig.utils.commands.CommandManager;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;

@Mod(modid = BWStatsMod.MODID, name = BWStatsMod.NAME, version = BWStatsMod.VERSION)
public class BWStatsMod {
    public static final String MODID = "@ID@";
    public static final String NAME = "@NAME@";
    public static final String VERSION = "@VER@";
    @Instance(MODID)
    public static BWStatsMod INSTANCE;
    public HypixelAPIClient client;
    public TestConfig config;

    @EventHandler
    public void onFMLInitialization(FMLInitializationEvent event) {
        config = new TestConfig();
        client = new HypixelAPIClient();
        CommandManager.INSTANCE.registerCommand(ConfigCommand.class);
    }

    @EventHandler
    public void onHypixelJoined(ClientConnectedToServerEvent event) {
        if(event.isLocal) {
            return;
        }

        if(!Minecraft.getMinecraft().getCurrentServerData().serverIP.contains("hypixel")) {
            return;
        }

        client.refreshStats();
    }
}
