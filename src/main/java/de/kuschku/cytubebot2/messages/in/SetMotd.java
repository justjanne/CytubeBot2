package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "setMotd", direction = CytubeEvent.Direction.IN)
public class SetMotd {
    private String motd;

    @JsonCreator
    public SetMotd(String motd) {
        this.motd = motd;
    }

    @JsonValue
    public String getMotd() {
        return motd;
    }

    public void setMotd(String motd) {
        this.motd = motd;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("motd", motd)
                .toString();
    }
}
