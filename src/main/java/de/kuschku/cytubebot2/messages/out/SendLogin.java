package de.kuschku.cytubebot2.messages.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "login", direction = CytubeEvent.Direction.OUT)
public class SendLogin {
    @JsonProperty("name")
    public final String username;

    @JsonProperty("pw")
    public final String password;

    public SendLogin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("username", username)
                .append("password", password)
                .toString();
    }
}
