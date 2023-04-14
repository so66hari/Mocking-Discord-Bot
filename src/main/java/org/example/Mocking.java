package org.example;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Mocking extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {

        String prefix = "pls mock ";
        String input = event.getMessage().getContentRaw();

        if(input.startsWith(prefix)) {
            input = input.replace(prefix, "");
            String output = mocking(input);
            event.getChannel().sendMessage(output).queue();
        }
    }

    private String mocking(String input) {

        char[] toMock = input.toLowerCase().toCharArray();

        for(int i = 0; i < toMock.length; i +=2) {
            if(Character.isLetter(toMock[i])) {
                toMock[i] = Character.toUpperCase(toMock[i]);
            }
        }

        return new String(toMock);
    }
}
