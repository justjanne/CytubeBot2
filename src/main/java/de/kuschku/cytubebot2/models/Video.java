package de.kuschku.cytubebot2.models;

import javax.persistence.*;

@Table
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column
    String provider;

    @Column
    String identifier;

    @Column
    String title;

    @Column
    long duration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", provider='" + provider + '\'' +
                ", identifier='" + identifier + '\'' +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
