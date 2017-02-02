package de.kuschku.cytubebot2.models;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private int rank;

    @Column
    private int award;

    @Column
    private long coins;

    @OneToOne
    @Embedded
    private LegacyUser legacyUser;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public long getCoins() {
        return coins;
    }

    public void setCoins(long coins) {
        this.coins = coins;
    }

    public Optional<LegacyUser> getLegacyUser() {
        return Optional.ofNullable(legacyUser);
    }

    public void setLegacyUser(LegacyUser legacyUser) {
        this.legacyUser = legacyUser;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rank=" + rank +
                ", award=" + award +
                ", coins=" + coins +
                ", legacyUser=" + legacyUser +
                '}';
    }
}
