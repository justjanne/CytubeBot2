package de.kuschku.cytubebot2.models;

import javax.persistence.*;
import java.time.Instant;

@Table
@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private Instant timestamp;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User sender;

    @Column
    private String content;

    public Message() {
    }

    public Message(Instant timestamp, User sender, String content) {
        this.timestamp = timestamp;
        this.sender = sender;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", timestamp=" + timestamp +
                ", sender=" + sender +
                ", content='" + content + '\'' +
                '}';
    }
}
