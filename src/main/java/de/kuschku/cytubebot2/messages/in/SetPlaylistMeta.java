package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "setPlaylistMeta", direction = CytubeEvent.Direction.IN)
public class SetPlaylistMeta {
    @JsonProperty("rawTime")
    private int rawTime;

    @JsonProperty("count")
    private int count;

    @JsonProperty("time")
    private String time;

    public void setRawTime(int rawTime) {
        this.rawTime = rawTime;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("rawTime", rawTime)
                .append("count", count)
                .append("time", time)
                .toString();
    }
}
