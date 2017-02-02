package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "setPlaylistLocked", direction = CytubeEvent.Direction.IN)
public class SetPlaylistLocked {
    private boolean locked;

    @JsonCreator
    public SetPlaylistLocked(boolean locked) {
        this.locked = locked;
    }

    @JsonValue
    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("locked", locked)
                .toString();
    }
}
