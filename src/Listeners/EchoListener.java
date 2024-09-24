package Listeners;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EchoListener extends ListenerAdapter {
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getName().equals("echo") && event.getChannel().getName().contains("bot")) {
            event.reply(event.getOption("message").getAsString()).queue(); // reply immediately
        }
    }
}
