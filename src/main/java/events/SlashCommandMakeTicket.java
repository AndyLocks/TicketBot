package events;

import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.EnumSet;

public class SlashCommandMakeTicket extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {

        String command = event.getName();
        if (command.equals("make_ticket")) {

            String channelName = String.format("ticket room %d", (int) (Math.random() * 11000) - 100);

            event.getGuild()
                    .createTextChannel(channelName)
                    .addPermissionOverride(event.getMember(), EnumSet.of(Permission.MANAGE_CHANNEL), null)
                    .queue();

            event.reply(":white_check_mark:").setEphemeral(true).queue();
        }
    }
}
