package de.kuschku.cytubebot2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import de.kuschku.cytubebot2.api.CytubeApi;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.util.StringJoiner;

@SpringBootApplication
@EnableJpaRepositories
public class MyApp {
    @Autowired
    private EventBus eventBus;

    @Autowired
    private SocketIOHandler socketIOHandler;

    @Autowired
    private BotHandler botHandler;

    public static void main(String... args) {
        SpringApplication.run(MyApp.class, args);
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public Retrofit retrofit(ObjectMapper objectMapper) {
        return new Retrofit.Builder()
                .baseUrl("https://cytu.be/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();
    }

    @Bean
    public CytubeApi cytubeApi(Retrofit retrofit) {
        return retrofit.create(CytubeApi.class);
    }

    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }

    @PostConstruct
    public void runBot() {
        eventBus.register(this);
        try {
            socketIOHandler.connect();
        } catch (URISyntaxException | JSONException | IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void unregister() {
        eventBus.unregister(this);
    }
}
