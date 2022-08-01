package net.irisfeanora.mods.bwstats.command;

import net.irisfeanora.mods.bwstats.BWStatsMod;
import cc.polyfrost.oneconfig.utils.commands.annotations.Command;
import cc.polyfrost.oneconfig.utils.commands.annotations.Main;

@Command(value = BWStatsMod.MODID, description = "Access the " + BWStatsMod.NAME + " GUI.")
public class ConfigCommand {

    @Main
    private static void main() {
        BWStatsMod.INSTANCE.config.openGui();
    }
}