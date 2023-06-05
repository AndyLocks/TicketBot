package me.illia;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.SubscribeEvent;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException, InterruptedException {

        System.out.println("pidor");

        JDA bot = JDABuilder.createDefault("MTExNDk3NDYwNDc4NDU3ODU5MA.GlOfji.kKT1UO7gWdgBDSDZnRM5L2PTZwM-ek0mb8RZ3U")
                .setActivity(Activity.playing("aboba"))
                .build().awaitReady();

    }

    @SubscribeEvent
    public void ohHeyAMessage(MessageReceivedEvent event)
    {
        System.out.println(event.getMessage().getContentDisplay());
    }
}