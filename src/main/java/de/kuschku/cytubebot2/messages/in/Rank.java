package de.kuschku.cytubebot2.messages.in;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import de.kuschku.cytubebot2.messages.CytubeEvent;
import org.springframework.core.style.ToStringCreator;

@CytubeEvent(name = "rank", direction = CytubeEvent.Direction.IN)
public class Rank {
    private double rank;

    @JsonCreator
    public Rank(Number rank) {
        this.rank = rank.doubleValue();
    }

    @JsonValue
    public double getRank() {
        return rank;
    }

    public void setRank(Number rank) {
        this.rank = rank.doubleValue();
    }

    @Override
    public String toString() {
        return new ToStringCreator(this)
                .append("rank", rank)
                .toString();
    }
}
