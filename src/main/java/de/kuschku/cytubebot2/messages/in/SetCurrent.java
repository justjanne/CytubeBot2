package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "setCurrent", direction = CytubeEvent.Direction.IN)
public class SetCurrent {
    private int current;

    @JsonCreator
    public SetCurrent(int current) {
        this.current = current;
    }

    @JsonValue
    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("current", current)
                .toString();
    }
}
