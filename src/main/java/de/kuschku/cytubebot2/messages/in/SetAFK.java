package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "setAFK", direction = CytubeEvent.Direction.IN)
public class SetAFK {
    @JsonProperty("name")
    private String name;

    @JsonProperty("afk")
    private boolean afk;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAfk() {
        return afk;
    }

    public void setAfk(boolean afk) {
        this.afk = afk;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("name", name)
                .append("afk", afk)
                .toString();
    }
}
