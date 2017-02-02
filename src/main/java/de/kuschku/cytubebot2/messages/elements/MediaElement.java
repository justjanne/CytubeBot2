package de.kuschku.cytubebot2.messages.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.style.ToStringCreator;

import java.util.Map;

public class MediaElement {
    @JsonProperty("currentTime")
    private double currentTime;

    @JsonProperty("paused")
    private boolean paused;

    @JsonProperty("duration")
    private String duration;

    @JsonProperty("seconds")
    private int seconds;

    @JsonProperty("meta")
    private Map<String, Object> meta;

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("type")
    private String type;

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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("currentTime", currentTime)
                .append("paused", paused)
                .append("duration", duration)
                .append("seconds", seconds)
                .append("meta", meta)
                .append("id", id)
                .append("title", title)
                .append("type", type)
                .toString();
    }
}
