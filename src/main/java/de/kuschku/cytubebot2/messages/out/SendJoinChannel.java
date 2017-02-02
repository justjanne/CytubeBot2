package de.kuschku.cytubebot2.messages.out;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "joinChannel", direction = CytubeEvent.Direction.OUT)
public class SendJoinChannel {
    @JsonProperty("name")
    public final String name;

    public SendJoinChannel(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("name", name)
                .toString();
    }
}
