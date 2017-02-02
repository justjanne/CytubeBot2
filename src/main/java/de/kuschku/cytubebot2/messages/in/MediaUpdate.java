package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonProperty;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "mediaUpdate", direction = CytubeEvent.Direction.IN)
public class MediaUpdate {
    @JsonProperty("currentTime")
    private double currentTime;

    @JsonProperty("paused")
    private boolean paused;

    public double getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(double currentTime) {
        this.currentTime = currentTime;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("currentTime", currentTime)
                .append("paused", paused)
                .toString();
    }
}
