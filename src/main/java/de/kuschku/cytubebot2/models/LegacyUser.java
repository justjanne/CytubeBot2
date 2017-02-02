package de.kuschku.cytubebot2.models;

import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.time.Instant;
import java.util.Optional;

@Entity
@Table
public class LegacyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @Nullable
    private Instant firstActivity;

    @Column
    private long messageTotal;

    @Column
    private long messageCount;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Optional<Instant> getFirstActivity() {
        return Optional.ofNullable(firstActivity);
    }

    public void setFirstActivity(@Nullable Instant firstActivity) {
        this.firstActivity = firstActivity;
    }

    public long getMessageTotal() {
        return messageTotal;
    }

    public void setMessageTotal(long messageTotal) {
        this.messageTotal = messageTotal;
    }

    public long getMessageCount() {
        return messageCount;
    }

    public void setMessageCount(long messageCount) {
        this.messageCount = messageCount;
    }

    @Override
    public String toString() {
        return "LegacyUser{" +
                "id=" + id +
                ", firstActivity=" + firstActivity +
                ", messageTotal=" + messageTotal +
                ", messageCount=" + messageCount +
                '}';
    }
}
