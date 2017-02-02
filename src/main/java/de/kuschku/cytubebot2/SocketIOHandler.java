package de.kuschku.cytubebot2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import de.kuschku.cytubebot2.api.CytubeApi;
import de.kuschku.cytubebot2.api.Server;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import de.kuschku.cytubebot2.utils.ClassPathScanner;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static de.kuschku.cytubebot2.messages.CytubeEvent.Direction.OUT;

@Component
public class SocketIOHandler {
    @Autowired
    private EventBus eventBus;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private CytubeApi cytubeApi;

    @Autowired
    private Socket socket;

    @PostConstruct
    public void register() {
        eventBus.register(this);
    }

    @Bean
    public Socket socket(SocketConfiguration configuration) throws URISyntaxException {
        return IO.socket(configuration.url, configuration.options);
    }

    @Bean
    public SocketConfiguration socketConfiguration(IO.Options options) throws IOException {
        List<Server> serverList = cytubeApi.serverList("yepityha").execute().body().getServers();
        Optional<Server> first = serverList.stream().findFirst();
        return new SocketConfiguration(first.orElseThrow(RuntimeException::new).getUrl(), options);
    }

    @Bean
    public IO.Options options() {
        IO.Options opts = new IO.Options();
        opts.forceNew = true;
        return opts;
    }

    public void connect() throws URISyntaxException, JSONException, InterruptedException, IOException {
        for (Class<?> clazz : ClassPathScanner
                .findAnnotatedClasses("de.kuschku.cytubebot2.messages.in", CytubeEvent.class)) {
            registerMessageClass(clazz);
        }

        registerListeners(socket, Arrays.asList(
                Socket.EVENT_CONNECT, Socket.EVENT_CONNECT_ERROR, Socket.EVENT_CONNECT_TIMEOUT,
                Socket.EVENT_DISCONNECT, Socket.EVENT_ERROR, Socket.EVENT_MESSAGE, Socket.EVENT_RECONNECT,
                Socket.EVENT_RECONNECT_ATTEMPT, Socket.EVENT_RECONNECT_ERROR, Socket.EVENT_RECONNECT_FAILED,
                Socket.EVENT_RECONNECTING, "error", "connect", "disconnect", "errorMsg", "costanza", "announcement",
                "kick", "noflood", "spamFiltered", "needPassword", "cancelNeedPassword", "cooldown",
                "channelNotRegistered", "setMotd", "chatFilters", "updateChatFilter", "deleteChatFilter",
                "channelOpts", "setPermissions", "channelCSSJS", "banlist", "banlistRemove", "channelRanks",
                "channelRankFail", "readChanLog", "voteskip", "rank", "login", "usercount", "chatMsg", "pm",
                "clearchat", "userlist", "addUser", "setUserMeta", "setUserProfile", "setLeader", "setUserRank",
                "setUserIcon", "setAFK", "userLeave", "drinkCount", "playlist", "setPlaylistMeta", "queue",
                "queueWarn", "queueFail", "setTemp", "delete ", "moveVideo", "setCurrent", "changeMedia",
                "mediaUpdate", "setPlaylistLocked", "searchResults", "newPoll", "updatePoll", "closePoll",
                "listPlaylists", "emoteList", "updateEmote", "removeEmote", "warnLargeChandump", "partitionChange",
                "validationError", "validationPassed", "modalAlert", "connect_error"
        ));

        // TODO: Remove
        //socket.emit("login", login);

        socket.connect();
    }

    private <T> void registerMessageClass(Class<T> clazz) {
        registerMessageClass(clazz.getAnnotation(CytubeEvent.class).name(), clazz);
    }

    private <T> void registerMessageClass(String event, Class<T> clazz) {
        socket.on(event, (args) -> {
            try {
                if (args.length > 0) {
                    Object arg = args[0];

                    if (arg instanceof JSONObject || arg instanceof JSONArray)
                        eventBus.post(objectMapper.readValue(args[0].toString(), clazz));
                    else
                        eventBus.post(objectMapper.readValue(objectMapper.writeValueAsString(args[0]), clazz));
                } else {
                    eventBus.post(clazz.newInstance());
                }
            } catch (IOException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
                for (int i = 0; i < args.length; i++) {
                    System.err.println("#" + i + " (" + args[i].getClass().getName() + "): " + args[i].toString());
                }
            }
        });
    }

    private void registerListeners(Socket socket, List<String> events) {
        for (String event : events) {
            if (!socket.hasListeners(event))
                socket.on(event, (args) -> eventBus.post(new SocketEvent(event, args)));
        }
    }

    @Subscribe
    public void onDispatch(Object event) {
        if (event.getClass().isAnnotationPresent(CytubeEvent.class)) {
            CytubeEvent annotation = event.getClass().getAnnotation(CytubeEvent.class);
            if (annotation.direction() == OUT) {
                try {
                    socket.emit(annotation.name(), new JSONObject(objectMapper.writeValueAsString(event)));
                } catch (JSONException | JsonProcessingException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @PreDestroy
    public void unregister() {
        eventBus.unregister(this);
    }
}
