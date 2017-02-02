package de.kuschku.cytubebot2;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import de.kuschku.cytubebot2.messages.in.ChannelOpts;
import de.kuschku.cytubebot2.messages.in.ChatMsg;
import de.kuschku.cytubebot2.messages.in.Connect;
import de.kuschku.cytubebot2.messages.in.Login;
import de.kuschku.cytubebot2.messages.out.SendChatMsg;
import de.kuschku.cytubebot2.messages.out.SendInitChannelCallbacks;
import de.kuschku.cytubebot2.messages.out.SendJoinChannel;
import de.kuschku.cytubebot2.messages.out.SendLogin;
import de.kuschku.cytubebot2.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.activation.DataSource;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static de.kuschku.cytubebot2.utils.PrintUtils.printMultiline;

@Component
public class BotHandler {
    @Autowired
    private EventBus eventBus;

    @Autowired
    private Database database;

    @PostConstruct
    public void register() {
        eventBus.register(this);
    }

    @PreDestroy
    public void unregister() {
        eventBus.unregister(this);
    }

    @Subscribe
    public void onEvent(Connect event) {
        eventBus.post(new SendInitChannelCallbacks());
        eventBus.post(new SendJoinChannel("yepityha"));
    }

    @Subscribe
    public void onEvent(ChannelOpts event) {
        eventBus.post(new SendLogin("TARS-test", null));
    }

    @Subscribe
    public void onEvent(Login event) {
        if (event.isSuccess()) {
            eventBus.post(new SendChatMsg("^^ Hi :) ^^"));
        }
    }

    @Subscribe
    public void onEvent(ChatMsg event) {
        Pattern pattern = Pattern.compile("(/[a-zA-Z0-9]*) TARScd");
        Matcher matcher = pattern.matcher(event.getMsg());
        if (matcher.matches()) {
            eventBus.post(new SendChatMsg(String.format("%s %s", matcher.group(1), event.getUsername())));
        }
    }

    @Subscribe
    public void onSocketEvent(SocketEvent event) {
        printMultiline(System.err, event.toString(), 120);
    }

    @Subscribe
    public void onEvent(Object event) {
        if (event.getClass().isAnnotationPresent(CytubeEvent.class)) {
            printMultiline(System.out, event.toString(), 120);
        }
    }
}
