package me.illia;

import events.GuildsLengthActivity;
import events.SlashCommandMakeTicket;
import events.TextChannelNamer;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

public class Main {

    public static ShardManager shard;
    public static void main(String[] args) {

        Dotenv config = Dotenv.configure().load();
        String token = config.get("TOKEN");

        DefaultShardManagerBuilder bot = DefaultShardManagerBuilder.create(
                token,
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.AUTO_MODERATION_CONFIGURATION,
                GatewayIntent.AUTO_MODERATION_EXECUTION,
                GatewayIntent.DIRECT_MESSAGE_REACTIONS,
                GatewayIntent.DIRECT_MESSAGE_TYPING,
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.GUILD_EMOJIS_AND_STICKERS,
                GatewayIntent.GUILD_INVITES,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_MESSAGE_REACTIONS,
                GatewayIntent.GUILD_MESSAGE_TYPING,
                GatewayIntent.GUILD_MODERATION,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.GUILD_VOICE_STATES,
                GatewayIntent.MESSAGE_CONTENT,
                GatewayIntent.SCHEDULED_EVENTS
        );

        shard = bot.build();
        shard.addEventListener(new SlashCommandMakeTicket());
        shard.addEventListener(new GuildsLengthActivity());
        shard.addEventListener(new TextChannelNamer());
    }
}