package events;

import me.illia.Main;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent;
import net.dv8tion.jda.api.events.session.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class guildsLengthActivity extends ListenerAdapter {

    private void updateGuildsLengthActivity() {

        Main.shard.setActivity(Activity.watching(String.format("%d Guilds", Main.shard.getGuilds().size())));
    }

    @Override
    public void onGuildJoin(GuildJoinEvent event) {

        this.updateGuildsLengthActivity();
    }

    @Override
    public void onGuildLeave(GuildLeaveEvent event) {

        this.updateGuildsLengthActivity();
    }

    @Override
    public void onReady(ReadyEvent event) {

        this.updateGuildsLengthActivity();
    }
}
