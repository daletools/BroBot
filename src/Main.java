import Listeners.EchoListener;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        final String BOT_TOKEN = System.getenv("BOT_TOKEN");
        JDA api = JDABuilder.createDefault(BOT_TOKEN).build();
        Guild guild = api.awaitReady().getGuildsByName("VIP Brogrammers", true).get(0);
        System.out.println(guild.getName());
        api.addEventListener(new EchoListener());
        guild.updateCommands().addCommands(
                Commands.slash("echo", "Echoes the provided input.")
                        .addOption(OptionType.STRING,
                                "message",
                                "The message to repeat.",
                                true),
                Commands.slash("foo", "Track professor foo usage.")
                        .addOption(OptionType.STRING,
                                "profName",
                                "Name of Prof who foo'd",
                                true)
                        .addOption(OptionType.STRING,
                                "context",
                                "Quote accompanying the foo")
        ).queue();
    }
}