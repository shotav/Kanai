package net.pryoscode.kanai;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.pryoscode.kanai.config.Config;

public class Discord {

    private static final String APPLICATION_ID = "920404566867058769";

    private Discord() {}

    public static void init() {
        if (Config.getSetting(net.pryoscode.kanai.config.settings.Discord.class) == Boolean.FALSE) return;
        DiscordRPC.discordInitialize(APPLICATION_ID, new DiscordEventHandlers.Builder().build(), true);
        Runtime.getRuntime().addShutdownHook(new Thread(DiscordRPC::discordShutdown));
        DiscordRPC.discordUpdatePresence(new DiscordRichPresence.Builder(null).build());
    }

}