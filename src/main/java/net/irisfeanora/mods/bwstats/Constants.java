package net.irisfeanora.mods.bwstats;

import net.minecraft.client.Minecraft;

public class Constants {
    public static Minecraft client = Minecraft.getMinecraft();

    public static String[] gameNames = new String[] {
            "game_final_kills",
            "game_beds_broken",
            "game_kills",
            "game_time"
    };

    public static String[] sessionNames = new String[] {
            "session_wins",
            "session_losses",
            "session_final_kills",
            "session_final_deaths",
            "session_beds_broken",
            "session_beds_lost",
            "session_time"
    };

    public static String[] globalNames = new String[] {
            "global_wins",
            "global_losses",
            "global_kills",
            "global_deaths",
            "global_final_kills",
            "global_final_deaths",
            "global_beds_broken",
            "global_beds_lost"
    };
}
