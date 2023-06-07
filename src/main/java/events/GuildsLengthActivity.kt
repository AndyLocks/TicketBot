package events

import me.illia.Main
import net.dv8tion.jda.api.entities.Activity
import net.dv8tion.jda.api.events.guild.GuildJoinEvent
import net.dv8tion.jda.api.events.guild.GuildLeaveEvent
import net.dv8tion.jda.api.events.session.ReadyEvent
import net.dv8tion.jda.api.hooks.ListenerAdapter

class GuildsLengthActivity : ListenerAdapter() {

    private fun updateGuildsLengthActivity() {

        Main.shard.setActivity(Activity.watching("${Main.shard.guilds.size} Guilds"));
    }

    override fun onReady(event: ReadyEvent) {

        this.updateGuildsLengthActivity();
    }

    override fun onGuildJoin(event: GuildJoinEvent) {

        this.updateGuildsLengthActivity();
    }

    override fun onGuildLeave(event: GuildLeaveEvent) {

        this.updateGuildsLengthActivity();
    }
}