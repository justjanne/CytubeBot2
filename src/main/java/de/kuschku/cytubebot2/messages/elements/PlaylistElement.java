package de.kuschku.cytubebot2.messages.elements;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.core.style.ToStringCreator;

public class PlaylistElement {
    @JsonProperty("uid")
    private int uid;

    @JsonProperty("temp")
    private boolean temp;

    @JsonProperty("queueby")
    private String queueby;

    @JsonProperty("media")
    private MediaElement media;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public boolean isTemp() {
        return temp;
    }

    public void setTemp(boolean temp) {
        this.temp = temp;
    }

    public String getQueueby() {
        return queueby;
    }

    public void setQueueby(String queueby) {
        this.queueby = queueby;
    }

    public MediaElement getMedia() {
        return media;
    }

    public void setMedia(MediaElement media) {
        this.media = media;
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("uid", uid)
                .append("temp", temp)
                .append("queueby", queueby)
                .append("media", media)
                .toString();
    }
}
