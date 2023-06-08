package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.channel.ChannelCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class TextChannelNamer extends ListenerAdapter {

    @Override
    public void onChannelCreate(ChannelCreateEvent event) {

        if(event.getChannel() instanceof TextChannel) {


            TextChannel channel = (TextChannel) event.getChannel();
            if (channel.getName().startsWith("ticket-room")) {

                EmbedBuilder emb = new EmbedBuilder();
                emb.setTitle("Ticket Room");
                emb.setDescription("Here you can communicate with the administration. You can also delete this channel or change its name.");
                emb.setColor(Color.GREEN);
                channel.sendMessageEmbeds(emb.build()).queue();
            }
        }

    }


}
