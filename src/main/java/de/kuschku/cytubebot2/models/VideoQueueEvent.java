package de.kuschku.cytubebot2.models;

import javax.persistence.*;

@Entity
@Table
public class VideoQueueEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @ManyToOne
    @JoinColumn
    Video video;

    @ManyToOne
    @JoinColumn
    User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "VideoQueueEvent{" +
                "id=" + id +
                ", video=" + video +
                ", user=" + user +
                '}';
    }
}
