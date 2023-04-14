package org.example;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

/***
 * main class to set up bot and running it
 */
public class Main {
    public static void main(String[] args) {
        String token = "MTA5NjE0NzQ1NzU2MzQyNjk3Ng.G20FXk.LPFNriZOwt9vVKNMAkfWQYLx4pVhd8Zo7MImsY";

        JDABuilder botPlanner = JDABuilder.createDefault(token);
        botPlanner.enableIntents(GatewayIntent.MESSAGE_CONTENT);
        botPlanner.setStatus(OnlineStatus.ONLINE);
        botPlanner.setActivity(Activity.playing("mocking ur mom"));
        botPlanner.addEventListeners(new Mocking());

        botPlanner.build();
    }
}